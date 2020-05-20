package com.unionpay.mobile.android.widgets;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.l */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4470l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4469k f23462a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4470l(C4469k c4469k) {
        this.f23462a = c4469k;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0085 A[LOOP:0: B:17:0x007f->B:19:0x0085, LOOP_END] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onClick(android.view.View r6) {
        /*
            r5 = this;
            com.unionpay.mobile.android.widgets.k r0 = r5.f23462a
            boolean r0 = com.unionpay.mobile.android.widgets.C4469k.m644a(r0)
            r1 = 0
            if (r0 == 0) goto L90
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.unionpay.mobile.android.widgets.k r2 = r5.f23462a     // Catch: org.json.JSONException -> L6e
            java.lang.String r2 = r2.mo585a()     // Catch: org.json.JSONException -> L6e
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: org.json.JSONException -> L6e
            r3 = 1
            if (r2 != 0) goto L5b
            com.unionpay.mobile.android.widgets.k r2 = r5.f23462a     // Catch: org.json.JSONException -> L6e
            java.lang.String r2 = r2.mo585a()     // Catch: org.json.JSONException -> L6e
            java.lang.String r4 = "[A-Za-z0-9]{8,32}"
            boolean r2 = r2.matches(r4)     // Catch: org.json.JSONException -> L6e
            if (r2 == 0) goto L45
            com.unionpay.mobile.android.widgets.k r1 = r5.f23462a     // Catch: org.json.JSONException -> L6e
            r1.m643a(r3)     // Catch: org.json.JSONException -> L6e
            java.lang.String r1 = "value"
            com.unionpay.mobile.android.widgets.k r2 = r5.f23462a     // Catch: org.json.JSONException -> L6e
            java.lang.String r2 = r2.mo580h()     // Catch: org.json.JSONException -> L6e
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L6e
            java.lang.String r1 = "action"
            com.unionpay.mobile.android.widgets.k r2 = r5.f23462a     // Catch: org.json.JSONException -> L6e
            java.lang.String r2 = com.unionpay.mobile.android.widgets.C4469k.m641b(r2)     // Catch: org.json.JSONException -> L6e
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L6e
            goto L72
        L45:
            com.unionpay.mobile.android.languages.c r2 = com.unionpay.mobile.android.languages.C4171c.f22227bD     // Catch: org.json.JSONException -> L6e
            java.lang.String r2 = r2.f22258aD     // Catch: org.json.JSONException -> L6e
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: org.json.JSONException -> L6e
            com.unionpay.mobile.android.languages.c r4 = com.unionpay.mobile.android.languages.C4171c.f22227bD     // Catch: org.json.JSONException -> L6e
            java.lang.String r4 = r4.f22230C     // Catch: org.json.JSONException -> L6e
            r3[r1] = r4     // Catch: org.json.JSONException -> L6e
            java.lang.String r1 = java.lang.String.format(r2, r3)     // Catch: org.json.JSONException -> L6e
            java.lang.String r2 = "errMsg"
        L57:
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L6e
            goto L72
        L5b:
            com.unionpay.mobile.android.languages.c r2 = com.unionpay.mobile.android.languages.C4171c.f22227bD     // Catch: org.json.JSONException -> L6e
            java.lang.String r2 = r2.f22257aC     // Catch: org.json.JSONException -> L6e
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: org.json.JSONException -> L6e
            com.unionpay.mobile.android.languages.c r4 = com.unionpay.mobile.android.languages.C4171c.f22227bD     // Catch: org.json.JSONException -> L6e
            java.lang.String r4 = r4.f22230C     // Catch: org.json.JSONException -> L6e
            r3[r1] = r4     // Catch: org.json.JSONException -> L6e
            java.lang.String r1 = java.lang.String.format(r2, r3)     // Catch: org.json.JSONException -> L6e
            java.lang.String r2 = "errMsg"
            goto L57
        L6e:
            r1 = move-exception
            r1.printStackTrace()
        L72:
            r6.setTag(r0)
            com.unionpay.mobile.android.widgets.k r0 = r5.f23462a
            java.util.ArrayList r0 = com.unionpay.mobile.android.widgets.C4469k.m640c(r0)
            java.util.Iterator r0 = r0.iterator()
        L7f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L8f
            java.lang.Object r1 = r0.next()
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r1.onClick(r6)
            goto L7f
        L8f:
            return
        L90:
            com.unionpay.mobile.android.widgets.k r0 = r5.f23462a
            com.unionpay.mobile.android.widgets.u r0 = r0.f23323b
            r0.m591e()
            com.unionpay.mobile.android.widgets.k r0 = r5.f23462a
            r0.m643a(r1)
            com.unionpay.mobile.android.widgets.k r0 = r5.f23462a
            java.util.ArrayList r0 = com.unionpay.mobile.android.widgets.C4469k.m639d(r0)
            java.util.Iterator r0 = r0.iterator()
        La6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lb6
            java.lang.Object r1 = r0.next()
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r1.onClick(r6)
            goto La6
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.widgets.View$OnClickListenerC4470l.onClick(android.view.View):void");
    }
}
