package com.alipay.sdk.app;

import com.baidu.mapapi.UIMsg;

/* renamed from: com.alipay.sdk.app.h */
/* loaded from: classes.dex */
public enum EnumC0735h {
    SUCCEEDED(9000, "处理成功"),
    FAILED(UIMsg.m_AppUI.MSG_APP_SAVESCREEN, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    PARAMS_ERROR(4001, "参数错误"),
    DOUBLE_REQUEST(UIMsg.m_AppUI.MSG_APP_GPS, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");
    

    /* renamed from: h */
    private int f3519h;

    /* renamed from: i */
    private String f3520i;

    EnumC0735h(int i, String str) {
        this.f3519h = i;
        this.f3520i = str;
    }

    /* renamed from: a */
    public final int m12547a() {
        return this.f3519h;
    }

    /* renamed from: b */
    public final String m12545b() {
        return this.f3520i;
    }

    /* renamed from: a */
    public static EnumC0735h m12546a(int i) {
        if (i != 4001) {
            if (i != 5000) {
                if (i != 8000) {
                    if (i == 9000) {
                        return SUCCEEDED;
                    }
                    switch (i) {
                        case 6001:
                            return CANCELED;
                        case 6002:
                            return NETWORK_ERROR;
                        default:
                            return FAILED;
                    }
                }
                return PAY_WAITTING;
            }
            return DOUBLE_REQUEST;
        }
        return PARAMS_ERROR;
    }
}
