package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.utils.C4394o;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.am */
/* loaded from: classes2.dex */
public final class C4436am implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C4432aj f23366a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4436am(C4432aj c4432aj) {
        this.f23366a = c4432aj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String m706a;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        int intValue = ((Integer) view.getTag()).intValue();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23366a.m669s());
        sb.append("_select_reduce_activity");
        String[] strArr = C4394o.f23205h;
        m706a = this.f23366a.m706a(intValue, i, "label");
        Object[] objArr = {C4432aj.m700a(this.f23366a, intValue, VastExtensionXmlManager.TYPE), Integer.valueOf(i), m706a};
        this.f23366a.m707a(intValue, i);
        popupWindow = this.f23366a.f23353p;
        if (popupWindow != null) {
            popupWindow2 = this.f23366a.f23353p;
            popupWindow2.dismiss();
        }
    }
}
