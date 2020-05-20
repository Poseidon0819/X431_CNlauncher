package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.c */
/* loaded from: classes.dex */
public class AppraiseImageInfo extends AbstractC2709c {
    private static final long serialVersionUID = 5587144385832340965L;
    private List<String> name;
    private String url_prefix;

    public List<String> getName() {
        return this.name;
    }

    public void setName(List<String> list) {
        this.name = list;
    }

    public String getUrl_prefix() {
        return this.url_prefix;
    }

    public void setUrl_prefix(String str) {
        this.url_prefix = str;
    }
}
