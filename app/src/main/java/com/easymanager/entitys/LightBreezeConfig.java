package com.easymanager.entitys;

import java.io.Serializable;
import java.util.ArrayList;

public class LightBreezeConfig implements Serializable {
    public ArrayList<String> getDisablePkgs() {
        return disablePkgs;
    }

    public void setDisablePkgs(ArrayList<String> disablePkgs) {
        this.disablePkgs = disablePkgs;
    }

    public ArrayList<String> getUninstallPkgs() {
        return uninstallPkgs;
    }

    public void setUninstallPkgs(ArrayList<String> uninstallPkgs) {
        this.uninstallPkgs = uninstallPkgs;
    }

    public ArrayList<String> getDisableFirewallPkgs() {
        return disableFirewallPkgs;
    }

    public void setDisableFirewallPkgs(ArrayList<String> disableFirewallPkgs) {
        this.disableFirewallPkgs = disableFirewallPkgs;
    }

    public ArrayList<String> getDisableSensorsPkgs() {
        return disableSensorsPkgs;
    }

    public void setDisableSensorsPkgs(ArrayList<String> disableSensorsPkgs) {
        this.disableSensorsPkgs = disableSensorsPkgs;
    }

    private ArrayList<String> disablePkgs = new ArrayList<>();
    private ArrayList<String> uninstallPkgs = new ArrayList<>();
    private ArrayList<String> disableFirewallPkgs = new ArrayList<>();
    private ArrayList<String> disableSensorsPkgs = new ArrayList<>();

}
