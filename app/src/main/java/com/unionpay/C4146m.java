package com.unionpay;

/* renamed from: com.unionpay.m */
/* loaded from: classes2.dex */
final class C4146m implements InterfaceC4124ac {

    /* renamed from: a */
    final /* synthetic */ UPPayWapActivity f22095a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4146m(UPPayWapActivity uPPayWapActivity) {
        this.f22095a = uPPayWapActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005c A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #2 {Exception -> 0x0068, blocks: (B:3:0x0001, B:14:0x0030, B:16:0x005c, B:12:0x0022), top: B:26:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // com.unionpay.InterfaceC4124ac
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo430a(java.lang.String r6, com.unionpay.InterfaceC4125ad r7) {
        /*
            r5 = this;
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L68
            r1.<init>(r6)     // Catch: java.lang.Exception -> L68
            java.lang.String r6 = ""
            java.lang.String r2 = ""
            java.lang.String r3 = "url"
            java.lang.Object r3 = r1.get(r3)     // Catch: java.lang.Exception -> L1d
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> L1d
            java.lang.String r6 = "title"
            java.lang.Object r6 = r1.get(r6)     // Catch: java.lang.Exception -> L1b
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> L1b
            goto L30
        L1b:
            r6 = move-exception
            goto L20
        L1d:
            r1 = move-exception
            r3 = r6
            r6 = r1
        L20:
            if (r7 == 0) goto L2f
            java.lang.String r1 = "1"
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Exception -> L68
            java.lang.String r6 = com.unionpay.UPPayWapActivity.m1647a(r1, r6, r0)     // Catch: java.lang.Exception -> L68
            r7.mo429a(r6)     // Catch: java.lang.Exception -> L68
        L2f:
            r6 = r2
        L30:
            android.os.Bundle r1 = new android.os.Bundle     // Catch: java.lang.Exception -> L68
            r1.<init>()     // Catch: java.lang.Exception -> L68
            java.lang.String r2 = "waptype"
            java.lang.String r4 = "new_page"
            r1.putString(r2, r4)     // Catch: java.lang.Exception -> L68
            java.lang.String r2 = "wapurl"
            r1.putString(r2, r3)     // Catch: java.lang.Exception -> L68
            java.lang.String r2 = "waptitle"
            r1.putString(r2, r6)     // Catch: java.lang.Exception -> L68
            android.content.Intent r6 = new android.content.Intent     // Catch: java.lang.Exception -> L68
            r6.<init>()     // Catch: java.lang.Exception -> L68
            r6.putExtras(r1)     // Catch: java.lang.Exception -> L68
            com.unionpay.UPPayWapActivity r1 = r5.f22095a     // Catch: java.lang.Exception -> L68
            java.lang.Class<com.unionpay.UPPayWapActivity> r2 = com.unionpay.UPPayWapActivity.class
            r6.setClass(r1, r2)     // Catch: java.lang.Exception -> L68
            com.unionpay.UPPayWapActivity r1 = r5.f22095a     // Catch: java.lang.Exception -> L68
            r1.startActivity(r6)     // Catch: java.lang.Exception -> L68
            if (r7 == 0) goto L67
            java.lang.String r6 = "0"
            java.lang.String r1 = "success"
            java.lang.String r6 = com.unionpay.UPPayWapActivity.m1647a(r6, r1, r0)     // Catch: java.lang.Exception -> L68
            r7.mo429a(r6)     // Catch: java.lang.Exception -> L68
        L67:
            return
        L68:
            r6 = move-exception
            if (r7 == 0) goto L78
            java.lang.String r1 = "1"
            java.lang.String r6 = r6.getMessage()
            java.lang.String r6 = com.unionpay.UPPayWapActivity.m1647a(r1, r6, r0)
            r7.mo429a(r6)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.C4146m.mo430a(java.lang.String, com.unionpay.ad):void");
    }
}
