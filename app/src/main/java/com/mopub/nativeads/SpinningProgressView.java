package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Views;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* renamed from: com.mopub.nativeads.bb */
/* loaded from: classes2.dex */
final class SpinningProgressView extends ViewGroup {

    /* renamed from: a */
    private final ProgressBar f21109a;

    /* renamed from: b */
    private int f21110b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpinningProgressView(Context context) {
        super(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setVisibility(8);
        setBackgroundColor(-16777216);
        getBackground().setAlpha(Opcodes.GETFIELD);
        this.f21109a = new ProgressBar(context);
        this.f21110b = Dips.asIntPixels(25.0f, getContext());
        this.f21109a.setIndeterminate(true);
        addView(this.f21109a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            int i5 = (i + i3) / 2;
            int i6 = (i2 + i4) / 2;
            ProgressBar progressBar = this.f21109a;
            int i7 = this.f21110b;
            progressBar.layout(i5 - i7, i6 - i7, i5 + i7, i6 + i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m2066a(View view) {
        Preconditions.checkNotNull(view);
        View rootView = view.getRootView();
        if (rootView == null || !(rootView instanceof ViewGroup)) {
            return false;
        }
        setVisibility(0);
        setMeasuredDimension(rootView.getWidth(), rootView.getHeight());
        ((ViewGroup) rootView).addView(this);
        forceLayout();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m2067a() {
        Views.removeFromParent(this);
        setVisibility(8);
        return true;
    }
}
