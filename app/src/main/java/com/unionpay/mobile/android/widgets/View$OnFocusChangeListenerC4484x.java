package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.ImageView;
import com.unionpay.mobile.android.widgets.View$OnClickListenerC4479u;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.x */
/* loaded from: classes2.dex */
public final class View$OnFocusChangeListenerC4484x implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC4479u f23513a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnFocusChangeListenerC4484x(View$OnClickListenerC4479u view$OnClickListenerC4479u) {
        this.f23513a = view$OnClickListenerC4479u;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        int i;
        View$OnClickListenerC4479u.InterfaceC4481b interfaceC4481b;
        View$OnClickListenerC4479u.InterfaceC4480a interfaceC4480a;
        View$OnClickListenerC4479u.InterfaceC4480a interfaceC4480a2;
        View$OnClickListenerC4479u.InterfaceC4481b interfaceC4481b2;
        ImageView imageView3;
        if (z) {
            if (View$OnClickListenerC4479u.m598b(this.f23513a)) {
                imageView3 = this.f23513a.f23500c;
                if (imageView3 != null) {
                    imageView2 = this.f23513a.f23500c;
                    i = 0;
                    imageView2.setVisibility(i);
                }
            }
        } else if (View$OnClickListenerC4479u.m598b(this.f23513a)) {
            imageView = this.f23513a.f23500c;
            if (imageView != null) {
                imageView2 = this.f23513a.f23500c;
                i = 8;
                imageView2.setVisibility(i);
            }
        }
        interfaceC4481b = this.f23513a.f23502e;
        if (interfaceC4481b != null) {
            interfaceC4481b2 = this.f23513a.f23502e;
            interfaceC4481b2.mo588a(z);
        }
        interfaceC4480a = this.f23513a.f23503f;
        if (interfaceC4480a != null) {
            interfaceC4480a2 = this.f23513a.f23503f;
            interfaceC4480a2.mo588a(z);
        }
        this.f23513a.invalidate();
    }
}
