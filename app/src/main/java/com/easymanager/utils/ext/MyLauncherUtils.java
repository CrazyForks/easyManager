package com.easymanager.utils.ext;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.LauncherActivityInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.UserHandle;

import com.easymanager.activitys.runShortcutProxyActivity;

import java.util.List;

public class MyLauncherUtils {

    private static MyLauncherUtils instance = null;
    public MyLauncherUtils(){

    }

    public static MyLauncherUtils Instance(){
        if(instance == null){
            instance = new MyLauncherUtils();
        }
        return instance;
    }



    /**
     * 创建桌面快捷方式
     *
     * @param activity    当前Activity
     * @param packageName 目标应用包名
     */
    public void createAppShortcut(Context context,Activity activity, String packageName, int uid  , IntentSender intentSender) {
        int sdk = android.os.Build.VERSION.SDK_INT;

        PackageManager pm = activity.getPackageManager();

        try {

            // =========================
            // 1️⃣ 获取启动 Intent
            // =========================
            Intent launchIntent = pm.getLaunchIntentForPackage(packageName);
            if (launchIntent == null) return;

            ComponentName component = launchIntent.getComponent();

            // =========================
            // 2️⃣ 获取图标
            // =========================
            Drawable iconDrawable = pm.getApplicationIcon(packageName);
            Bitmap iconBitmap = drawableToBitmap(iconDrawable);

            // =========================
            // 3️⃣ 构造点击 Intent（代理启动）
            // =========================
            Intent shortcutIntent = new Intent(activity, runShortcutProxyActivity.class);
            shortcutIntent.setAction(Intent.ACTION_VIEW);
            shortcutIntent.putExtra("pkg", packageName);
            shortcutIntent.putExtra("component", component.flattenToString());
            shortcutIntent.putExtra("uid", uid);
            String appname = PackageUtils.Instance().getPKGINFO(context,packageName).getAppname();
            String label = String.format("%s%d",appname,uid);
            String shortcutId = label+uid;
            // =====================================================
            // 📱 Android 8+ 推荐方式（ShortcutManager API）
            // =====================================================
            if (sdk >= Build.VERSION_CODES.O) {

                ShortcutManager shortcutManager =
                        activity.getSystemService(ShortcutManager.class);

                ShortcutInfo shortcut = new ShortcutInfo.Builder(activity, shortcutId)
                        .setShortLabel(label)
                        .setLongLabel(label)
                        .setIcon(Icon.createWithBitmap(iconBitmap))
                        .setIntent(shortcutIntent)
                        .build();

                shortcutManager.requestPinShortcut(shortcut, intentSender);
                return;
            }

            // =====================================================
            // 📱 Android 4.2 - 7.1 兼容方式（Broadcast）
            // =====================================================
            Intent installShortcut = new Intent(
                    "com.android.launcher.action.INSTALL_SHORTCUT"
            );

            installShortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, label);
            installShortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON, iconBitmap);
            installShortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
            installShortcut.putExtra("duplicate", false);

            activity.sendBroadcast(installShortcut);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAppShortcut(Context context,Activity activity, String packageName, int uid){
        createAppShortcut(context,activity,packageName,uid,null);
    }

    public Bitmap drawableToBitmap(Drawable drawable) {

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        Bitmap bitmap;

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(
                    drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight(),
                    Bitmap.Config.ARGB_8888
            );
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public void launchCloneVia(Context context, String pkgname, int userId) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            try {
                LauncherApps launcherApps =
                        (LauncherApps) context.getSystemService(Context.LAUNCHER_APPS_SERVICE);

                UserHandle user = createUserHandle(userId);

                List<LauncherActivityInfo> list =
                        launcherApps.getActivityList(pkgname, user);

                if (list == null || list.isEmpty()) return;

                ComponentName cn = list.get(0).getComponentName();

                launcherApps.startMainActivity(cn, user,null,null);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private UserHandle createUserHandle(int userId) {
        try {
            Class<?> clazz = Class.forName("android.os.UserHandle");
            java.lang.reflect.Method m =
                    clazz.getMethod("of", int.class);
            return (UserHandle) m.invoke(null, userId);
        } catch (Exception e) {
            return null;
        }
    }

}
