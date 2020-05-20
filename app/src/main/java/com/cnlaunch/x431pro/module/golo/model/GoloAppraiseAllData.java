package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.h */
/* loaded from: classes.dex */
public final class GoloAppraiseAllData extends AbstractC2709c {
    private static final long serialVersionUID = 2892687055959408917L;
    private GoloAppraiseResponse response = null;
    private AppraiseJsonInfo json = null;
    private AppraiseImageInfo img = null;

    public final AppraiseJsonInfo getJson() {
        return this.json;
    }

    public final void setJson(AppraiseJsonInfo appraiseJsonInfo) {
        this.json = appraiseJsonInfo;
    }

    public final AppraiseImageInfo getImg() {
        return this.img;
    }

    public final void setImg(AppraiseImageInfo appraiseImageInfo) {
        this.img = appraiseImageInfo;
    }

    public final GoloAppraiseResponse getResponse() {
        return this.response;
    }

    public final void setResponse(GoloAppraiseResponse goloAppraiseResponse) {
        this.response = goloAppraiseResponse;
    }
}
