package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.d.b.l */
/* loaded from: classes.dex */
public class OnlineFaultCodeHelpInfo extends BaseResponse {
    public static String PDF = "pdf";
    public static String TXT = "txt";
    public static String VEDIO = "vedio";
    String dtcHelpData = "";
    String dtcHelpType = "";

    public String getDtcHelpData() {
        return this.dtcHelpData;
    }

    public void setDtcHelpData(String str) {
        this.dtcHelpData = str;
    }

    public String getDtcHelpType() {
        return this.dtcHelpType;
    }

    public void setDtcHelpType(String str) {
        this.dtcHelpType = str;
    }
}
