package com.cnlaunch.x431pro.activity.diagnose.p222e;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.e.f */
/* loaded from: classes.dex */
public final class TabListener<T extends Fragment> implements BottomActionBar.InterfaceC2091b {

    /* renamed from: a */
    public ICallKeyDownFragment f12429a = null;

    /* renamed from: b */
    private final Activity f12430b;

    /* renamed from: c */
    private final Class<T> f12431c;

    /* renamed from: d */
    private final Bundle f12432d;

    /* renamed from: e */
    private Fragment f12433e;

    /* renamed from: f */
    private Runnable f12434f;

    /* renamed from: g */
    private IDataStreamSelectionRecorder f12435g;

    public TabListener(Activity activity, Class<T> cls, Bundle bundle, Runnable runnable, IDataStreamSelectionRecorder iDataStreamSelectionRecorder) {
        this.f12435g = null;
        this.f12430b = activity;
        this.f12431c = cls;
        this.f12432d = bundle;
        this.f12434f = runnable;
        this.f12435g = iDataStreamSelectionRecorder;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar.InterfaceC2091b
    /* renamed from: a */
    public final void mo7071a() {
        this.f12429a = null;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar.InterfaceC2091b
    /* renamed from: a */
    public final void mo7070a(FragmentTransaction fragmentTransaction) {
        ICallKeyDownFragment iCallKeyDownFragment;
        Runnable runnable = this.f12434f;
        if (runnable != null) {
            runnable.run();
        }
        Fragment fragment = this.f12433e;
        if (fragment != null && fragment.isDetached()) {
            this.f12433e.getArguments().putAll(this.f12432d);
            fragmentTransaction.attach(this.f12433e);
        } else {
            this.f12433e = Fragment.instantiate(this.f12430b, this.f12431c.getName(), this.f12432d);
            fragmentTransaction.replace(R.id.datastream_container, this.f12433e);
        }
        Fragment fragment2 = this.f12433e;
        if (fragment2 instanceof IDataStreamSelector) {
            ((IDataStreamSelector) fragment2).mo6310a(this.f12435g);
        }
        Fragment fragment3 = this.f12433e;
        if (!(fragment3 instanceof ICallKeyDownFragment) || (iCallKeyDownFragment = this.f12429a) == null) {
            return;
        }
        iCallKeyDownFragment.mo6302a((ICallKeyDownFragment) fragment3);
        ((ICallKeyDownFragment) this.f12433e).mo6302a(this.f12429a);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar.InterfaceC2091b
    /* renamed from: b */
    public final void mo7069b(FragmentTransaction fragmentTransaction) {
        Fragment fragment = this.f12433e;
        if (fragment != null) {
            fragmentTransaction.detach(fragment);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar.InterfaceC2091b
    /* renamed from: c */
    public final void mo7068c(FragmentTransaction fragmentTransaction) {
        mo7069b(fragmentTransaction);
        mo7070a(fragmentTransaction);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar.InterfaceC2091b
    /* renamed from: d */
    public final void mo7067d(FragmentTransaction fragmentTransaction) {
        Fragment fragment = this.f12433e;
        if (fragment != null) {
            if (fragment instanceof IDataStreamSelector) {
                ((IDataStreamSelector) fragment).mo6310a((IDataStreamSelectionRecorder) null);
            }
            Fragment fragment2 = this.f12433e;
            if (fragment2 instanceof ICallKeyDownFragment) {
                ((ICallKeyDownFragment) fragment2).mo6302a(null);
            }
            fragmentTransaction.remove(this.f12433e).commitAllowingStateLoss();
            this.f12433e = null;
        }
    }
}
