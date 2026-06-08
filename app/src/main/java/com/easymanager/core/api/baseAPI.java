package com.easymanager.core.api;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class baseAPI {

    private static baseAPI instance = null;

    public static baseAPI Instance(){
        if(instance == null){
            instance = new baseAPI();
        }
        return instance;
    }

    //获取应用本身的uid，如果是adb授权模式，uid理应2000
    public int getMyuid(){
        return android.os.Process.myUid();
    }

    public int getMyuidHascode(){
        return android.os.Process.myUserHandle().hashCode();
    }

    //判断当前应用权限是否为root
    public boolean isRoot(){
        return getMyuid() == 0;
    }

    //判断当前应用权限是否为adb
    public boolean isADB(){
        return getMyuid() == 2000;
    }

    public String getNowDateStr(){
        SimpleDateFormat sdf = new SimpleDateFormat(
                "yyyyMMddHHmmss",
                Locale.getDefault()
        );
        String nowDate = sdf.format(new Date(System.currentTimeMillis()));
        return nowDate;
    }

    public byte[] parcelableToBytes(Parcelable p) {
        Parcel parcel = Parcel.obtain();
        try {
            p.writeToParcel(parcel, 0);
            return parcel.marshall();
        } finally {
            parcel.recycle();
        }
    }

    public <T> T bytesToParcelable(
            byte[] data,
            Parcelable.Creator<T> creator) {

        Parcel parcel = Parcel.obtain();

        try {
            parcel.unmarshall(data, 0, data.length);
            parcel.setDataPosition(0);

            return creator.createFromParcel(parcel);
        } finally {
            parcel.recycle();
        }
    }

    // =========================
    // 1. List 序列化
    // =========================
    public <T extends Parcelable> byte[] listToBytes(List<T> list) {

        if (list == null) return null;

        Parcel parcel = Parcel.obtain();

        try {
            parcel.writeTypedList(list);
            return parcel.marshall();

        } finally {
            parcel.recycle();
        }
    }

    // =========================
    // 2. List 反序列化
    // =========================
    public <T extends Parcelable> List<T> bytesToList(
            byte[] data,
            Parcelable.Creator<T> creator) {

        if (data == null) return null;

        Parcel parcel = Parcel.obtain();

        try {
            parcel.unmarshall(data, 0, data.length);
            parcel.setDataPosition(0);

            return parcel.createTypedArrayList(creator);

        } finally {
            parcel.recycle();
        }
    }

}
