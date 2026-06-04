package com.easymanager.entitys;

import java.io.Serializable;

public class MyApplicationInfo implements Serializable {

    private static final long serialVersionUID = 1L;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    public MyApplicationInfo(int flags, int uid, boolean enabled, String sourceDir) {
        this.flags = flags;
        this.uid = uid;
        this.enabled = enabled;
        this.sourceDir = sourceDir;
    }

    @Override
    public String toString() {
        return "MyApplicationInfo{" +
                "flags=" + flags +
                ", uid=" + uid +
                ", enabled=" + enabled +
                ", sourceDir='" + sourceDir + '\'' +
                '}';
    }

    public int flags = 0;
    public int uid = 0;
    public boolean enabled;
    public String sourceDir;




}
