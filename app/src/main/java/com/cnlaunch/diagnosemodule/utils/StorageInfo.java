package com.cnlaunch.diagnosemodule.utils;

/* loaded from: classes.dex */
public class StorageInfo {
    private boolean mIsRemoveable;
    private String mPath;
    private String mState;

    public StorageInfo(String str) {
        this.mPath = str;
    }

    public boolean isMounted() {
        return "mounted".equals(this.mState);
    }

    public String getPath() {
        return this.mPath;
    }

    public boolean isRemovable() {
        return this.mIsRemoveable;
    }

    public void setState(String str) {
        this.mState = str;
    }

    public void setRemovable(boolean z) {
        this.mIsRemoveable = z;
    }
}
