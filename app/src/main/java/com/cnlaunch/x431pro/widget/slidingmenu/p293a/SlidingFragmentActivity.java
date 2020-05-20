package com.cnlaunch.x431pro.widget.slidingmenu.p293a;

import android.app.ActivityGroup;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cnlaunch.x431pro.widget.slidingmenu.SlidingMenu;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.a.b */
/* loaded from: classes.dex */
public class SlidingFragmentActivity extends ActivityGroup {

    /* renamed from: c */
    protected SlidingActivityHelper f16779c;

    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16779c = new SlidingActivityHelper(this);
        SlidingActivityHelper slidingActivityHelper = this.f16779c;
        slidingActivityHelper.f16773b = (SlidingMenu) LayoutInflater.from(slidingActivityHelper.f16772a).inflate(R.layout.slidingmenu_main, (ViewGroup) null);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        SlidingActivityHelper slidingActivityHelper = this.f16779c;
        if (slidingActivityHelper.f16775d == null || slidingActivityHelper.f16774c == null) {
            throw new IllegalStateException("Both setBehindContentView must be called in onCreate in addition to setContentView.");
        }
        slidingActivityHelper.f16777f = true;
        TypedArray obtainStyledAttributes = slidingActivityHelper.f16772a.getTheme().obtainStyledAttributes(new int[]{16842836});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        if (slidingActivityHelper.f16778g) {
            ViewGroup viewGroup = (ViewGroup) slidingActivityHelper.f16772a.getWindow().getDecorView();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
            viewGroup2.setBackgroundResource(resourceId);
            viewGroup.removeView(viewGroup2);
            slidingActivityHelper.f16773b.setContent(viewGroup2);
            viewGroup.addView(slidingActivityHelper.f16773b);
        } else {
            ViewGroup viewGroup3 = (ViewGroup) slidingActivityHelper.f16774c.getParent();
            if (viewGroup3 != null) {
                viewGroup3.removeView(slidingActivityHelper.f16774c);
            }
            if (slidingActivityHelper.f16774c.getBackground() == null) {
                slidingActivityHelper.f16774c.setBackgroundResource(resourceId);
            }
            slidingActivityHelper.f16773b.setContent(slidingActivityHelper.f16774c);
            viewGroup3.addView(slidingActivityHelper.f16773b, new ViewGroup.LayoutParams(-1, -1));
        }
        slidingActivityHelper.f16773b.m4420a();
    }

    @Override // android.app.Activity
    public View findViewById(int i) {
        View findViewById;
        View findViewById2 = super.findViewById(i);
        if (findViewById2 != null) {
            return findViewById2;
        }
        SlidingActivityHelper slidingActivityHelper = this.f16779c;
        if (slidingActivityHelper.f16773b == null || (findViewById = slidingActivityHelper.f16773b.findViewById(i)) == null) {
            return null;
        }
        return findViewById;
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("menuOpen", this.f16779c.f16773b.m4416c());
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        setContentView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        SlidingActivityHelper slidingActivityHelper = this.f16779c;
        if (slidingActivityHelper.f16776e) {
            return;
        }
        slidingActivityHelper.f16774c = view;
    }

    /* renamed from: d */
    public final void m4397d(int i) {
        setBehindContentView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    public void setBehindContentView(View view) {
        new ViewGroup.LayoutParams(-1, -1);
        SlidingActivityHelper slidingActivityHelper = this.f16779c;
        slidingActivityHelper.f16775d = view;
        slidingActivityHelper.f16773b.setMenu(slidingActivityHelper.f16775d);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z;
        SlidingActivityHelper slidingActivityHelper = this.f16779c;
        if (i == 4 && slidingActivityHelper.f16773b.m4416c()) {
            slidingActivityHelper.f16773b.m4420a();
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.ActivityGroup, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
