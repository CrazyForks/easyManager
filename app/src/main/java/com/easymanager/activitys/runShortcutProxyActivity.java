package com.easymanager.activitys;

import android.app.Activity;
import android.os.Bundle;

import com.easymanager.utils.ext.MyLauncherUtils;

public class runShortcutProxyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            String pkg = getIntent().getStringExtra("pkg");
            int uid = getIntent().getIntExtra("uid",0);

            if (pkg == null) {
                finish();
                return;
            }

            MyLauncherUtils.Instance().launchCloneVia(this,pkg, uid);
        }catch (Exception e){
            e.printStackTrace();
        }

        finish();
    }

}
