package com.easymanager.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.content.res.Configuration;

import com.easymanager.utils.view.ThemeUtils;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtils.applyTheme(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // 重启 Activity 以应用资源更改（如黑暗模式切换）
        recreate();
    }
}
