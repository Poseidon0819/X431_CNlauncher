package com.cnlaunch.golo3.view.selectimg.p166a;

import java.io.Serializable;

/* renamed from: com.cnlaunch.golo3.view.selectimg.a.h */
/* loaded from: classes.dex */
public final class PhotoInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean choose = false;
    private int image_id;
    private String path_absolute;
    private String path_file;

    public final int getImage_id() {
        return this.image_id;
    }

    public final void setImage_id(int i) {
        this.image_id = i;
    }

    public final String getPath_file() {
        return this.path_file;
    }

    public final void setPath_file(String str) {
        this.path_file = str;
    }

    public final String getPath_absolute() {
        return this.path_absolute;
    }

    public final void setPath_absolute(String str) {
        this.path_absolute = str;
    }

    public final boolean isChoose() {
        return this.choose;
    }

    public final void setChoose(boolean z) {
        this.choose = z;
    }
}
