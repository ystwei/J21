package com.weikun.model;

public class Category {
    private String catid;
    private Object plist;//product list

    public Object getPlist() {
        return plist;
    }

    public void setPlist(Object plist) {
        this.plist = plist;
    }

    private String name;

    private String descn;

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid == null ? null : catid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn == null ? null : descn.trim();
    }
}