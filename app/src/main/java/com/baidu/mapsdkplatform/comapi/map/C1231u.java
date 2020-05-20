package com.baidu.mapsdkplatform.comapi.map;

import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mapsdkplatform.comapi.map.u */
/* loaded from: classes.dex */
public class C1231u {

    /* renamed from: a */
    private static final String f6095a = "u";

    /* renamed from: b */
    private InterfaceC1230t f6096b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10568a(Message message2) {
        if (message2.what != 65289) {
            return;
        }
        int i = message2.arg1;
        if (i != 12) {
            switch (i) {
                case -1:
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    break;
                default:
                    switch (i) {
                        case 101:
                        case 102:
                            break;
                        default:
                            return;
                    }
            }
        }
        InterfaceC1230t interfaceC1230t = this.f6096b;
        if (interfaceC1230t != null) {
            interfaceC1230t.mo10569a(message2.arg1, message2.arg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10567a(InterfaceC1230t interfaceC1230t) {
        this.f6096b = interfaceC1230t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m10566b(InterfaceC1230t interfaceC1230t) {
        this.f6096b = null;
    }
}
