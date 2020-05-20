package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.PopupWindow;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.utils.C4394o;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.al */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4435al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4432aj f23365a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4435al(C4432aj c4432aj) {
        this.f23365a = c4432aj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String m706a;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        int intValue = ((Integer) view.getTag()).intValue();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23365a.m669s());
        sb.append("_select_reduce_activity");
        String[] strArr = C4394o.f23205h;
        m706a = this.f23365a.m706a(intValue, 0, "label");
        Object[] objArr = {C4432aj.m700a(this.f23365a, intValue, VastExtensionXmlManager.TYPE), 0, m706a};
        this.f23365a.m707a(intValue, 0);
        popupWindow = this.f23365a.f23353p;
        if (popupWindow != null) {
            popupWindow2 = this.f23365a.f23353p;
            popupWindow2.dismiss();
        }
    }
}
