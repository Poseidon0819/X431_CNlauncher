package com.cnlaunch.golo3.view.selectimg.p166a;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.cnlaunch.golo3.view.selectimg.a.a */
/* loaded from: classes.dex */
public final class AlbumInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private int image_id;
    private List<PhotoInfo> list;
    private String name_album;
    private String path_absolute;
    private String path_file;

    public final int getImage_id() {
        return this.image_id;
    }

    public final void setImage_id(int i) {
        this.image_id = i;
    }

    public final String getPath_absolute() {
        return this.path_absolute;
    }

    public final void setPath_absolute(String str) {
        this.path_absolute = str;
    }

    public final String getPath_file() {
        return this.path_file;
    }

    public final void setPath_file(String str) {
        this.path_file = str;
    }

    public final String getName_album() {
        return this.name_album;
    }

    public final void setName_album(String str) {
        this.name_album = str;
    }

    public final List<PhotoInfo> getList() {
        return this.list;
    }

    public final void setList(List<PhotoInfo> list) {
        this.list = list;
    }
}
