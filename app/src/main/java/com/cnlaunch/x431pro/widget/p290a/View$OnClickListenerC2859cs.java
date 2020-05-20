package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import com.cnlaunch.x431pro.activity.diagnose.p221d.GraphGridFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SetMaxMinValue.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.cs */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2859cs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetMaxMinValue f16380a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2859cs(SetMaxMinValue setMaxMinValue) {
        this.f16380a = setMaxMinValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GraphGridFragment graphGridFragment;
        GraphGridFragment graphGridFragment2;
        double d;
        double d2;
        graphGridFragment = this.f16380a.f16364a;
        if (graphGridFragment != null) {
            graphGridFragment2 = this.f16380a.f16364a;
            d = this.f16380a.f16367g;
            d2 = this.f16380a.f16368h;
            if (graphGridFragment2.f12035e.m7332d()) {
                graphGridFragment2.f12035e.m7344a(d, d2);
            }
        }
        SetMaxMinValue.m4584k(this.f16380a);
    }
}
