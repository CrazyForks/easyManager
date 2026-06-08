package com.easymanager.utils.ext;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.easymanager.core.entity.TransmissionEntity;
import com.easymanager.entitys.PKGINFO;

import java.util.ArrayList;
import java.util.List;

public class ProcessUtils {

    private PackageUtils packageUtils = PackageUtils.Instance();

    private easyManagerUtils ee = easyManagerUtils.Instance();

    private static ProcessUtils instance = null;

    public static ProcessUtils Instance(){
        if(instance == null){
            instance = new ProcessUtils();
        }
        return instance;
    }


    public ProcessUtils(){}

    public void queryRunningPKGSCore(List<PackageInfo> installedPackages, ArrayList<PKGINFO> pkginfos , ArrayList<Boolean> checkboxs, PackageManager packageManager, boolean isAll){
        packageUtils.clearList(pkginfos,checkboxs);
        for (PackageInfo packageInfo : installedPackages) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (isAll) {
                if (((ApplicationInfo.FLAG_STOPPED & applicationInfo.flags) == 0)) {
                    packageUtils.checkBoxs(pkginfos,checkboxs,packageInfo,packageManager);
                }
            } else {
                if (((ApplicationInfo.FLAG_SYSTEM & applicationInfo.flags) == 0)
                        && ((ApplicationInfo.FLAG_UPDATED_SYSTEM_APP & applicationInfo.flags) == 0)
                        && ((ApplicationInfo.FLAG_STOPPED & applicationInfo.flags) == 0)) {
                    packageUtils.checkBoxs(pkginfos,checkboxs,packageInfo,packageManager);
                }

            }
        }
        packageUtils.sortPKGINFOS(pkginfos);
    }

    public void queryRunningPKGSByUIDCore(List<PackageInfo> installedPackages, ArrayList<PKGINFO> pkginfos , ArrayList<Boolean> checkboxs, PackageManager packageManager, boolean isAll,int uid){
        packageUtils.clearList(pkginfos,checkboxs);
        for (PackageInfo packageInfo : installedPackages) {
            ApplicationInfo info = packageInfo.applicationInfo;
            if (isAll) {
                if (((ApplicationInfo.FLAG_STOPPED & info.flags) == 0)) {
                    packageUtils.appInfoAdd(packageManager,packageInfo,pkginfos,checkboxs,uid);
                }
            } else {
                if (((ApplicationInfo.FLAG_SYSTEM & info.flags) == 0)
                        && ((ApplicationInfo.FLAG_UPDATED_SYSTEM_APP & info.flags) == 0)
                        && ((ApplicationInfo.FLAG_STOPPED & info.flags) == 0)) {
                    packageUtils.appInfoAdd(packageManager,packageInfo,pkginfos,checkboxs,uid);
                }
            }
        }
        packageUtils.sortPKGINFOS(pkginfos);
    }


    //查询当前运行在后台的应用，用户安装部分
    public void queryRunningPKGS(Activity activity, ArrayList<PKGINFO> pkginfos , ArrayList<Boolean> checkboxs, Integer types){
        PackageManager packageManager = activity.getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(types);
        queryRunningPKGSCore(installedPackages,pkginfos,checkboxs,packageManager,false);
    }

    public void queryRunningPKGSByUID(Activity activity, ArrayList<PKGINFO> pkginfos , ArrayList<Boolean> checkboxs,Integer uid){
        List<PackageInfo> installedPackages = ee.getInstalledPackages(new TransmissionEntity(null,null,activity.getPackageName(),0,uid));
        queryRunningPKGSByUIDCore(installedPackages,pkginfos,checkboxs,activity.getPackageManager(),false,uid);
    }

    //查询当前运行在后台的应用，所有
    public void queryAllRunningPKGS(Activity activity, ArrayList<PKGINFO> pkginfos , ArrayList<Boolean> checkboxs,Integer types){
        PackageManager packageManager = activity.getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(types);
        queryRunningPKGSCore(installedPackages,pkginfos,checkboxs,packageManager,true);
    }
    public void queryAllRunningPKGSByUID(Activity activity, ArrayList<PKGINFO> pkginfos , ArrayList<Boolean> checkboxs,Integer uid){
        List<PackageInfo> installedPackages = ee.getInstalledPackages(new TransmissionEntity(null,null,activity.getPackageName(),0,uid));
        queryRunningPKGSByUIDCore(installedPackages,pkginfos,checkboxs,activity.getPackageManager(),true,uid);
    }

}
