package com.cnlaunch.p169im;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import com.cnlaunch.p169im.p172c.FriendListFragment;
import com.cnlaunch.p169im.p172c.MessageListFragment;
import com.cnlaunch.p169im.p172c.ProMessageFragment;
import com.cnlaunch.p169im.p172c.SearchFriendFragment;
import com.cnlaunch.p169im.p172c.UserDetailFragment;
import com.cnlaunch.p169im.p172c.VerificationFragment;
import com.cnlaunch.p169im.p175e.OnIMViewListener;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.golo.others.GoloIntentFilter;
import com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent;
import com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter;
import com.cnlaunch.x431pro.activity.golousa.GoloUSAActivity;
import com.cnlaunch.x431pro.activity.mine.MineActivity;
import com.cnlaunch.x431pro.activity.mine.PDFReportFragment;
import com.cnlaunch.x431pro.activity.mine.p230b.DiagnosisPlaybackFragment;
import com.cnlaunch.x431pro.p210a.FragmentKeyDownListener;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.im.IMActivity */
/* loaded from: classes.dex */
public class IMActivity extends ActivityC2004c implements OnIMViewListener, FragmentKeyDownListener, InfaceFragmentParent {

    /* renamed from: n */
    public String f8866n = null;

    /* renamed from: C */
    private OnActivityResultListenter f8862C = null;

    /* renamed from: D */
    private BroadcastReceiver f8863D = new C1697b(this);

    /* renamed from: E */
    private FragmentKeyDownListener.InterfaceC1949a f8864E = null;

    /* renamed from: F */
    private BroadcastReceiver f8865F = new C1698c(this);

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_common_fragment);
        if (bundle == null) {
            mo5888b(FriendListFragment.class.getName(), null);
            this.f8866n = FriendListFragment.class.getName();
        }
        IMPresenter.m8804a(this).f9182c = this;
        registerReceiver(this.f8863D, new GoloIntentFilter());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("finishIMActivity");
        registerReceiver(this.f8865F, intentFilter);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        IMPresenter.m8804a(this).f9182c = null;
        unregisterReceiver(this.f8863D);
        BroadcastReceiver broadcastReceiver = this.f8865F;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        FragmentKeyDownListener.InterfaceC1949a interfaceC1949a = this.f8864E;
        if (interfaceC1949a == null || !interfaceC1949a.onKeyDown(i, keyEvent)) {
            if (i == 4 && keyEvent.getAction() == 0) {
                if (getFragmentManager().getBackStackEntryCount() > 0 && (this.f8866n == PDFReportFragment.class.getName() || this.f8866n == DiagnosisPlaybackFragment.class.getName() || this.f8866n == ProMessageFragment.class.getName() || this.f8866n == UserDetailFragment.class.getName() || this.f8866n == VerificationFragment.class.getName() || this.f8866n == SearchFriendFragment.class.getName())) {
                    getFragmentManager().popBackStack();
                    return true;
                }
                if (IMPresenter.m8804a(this.f10981q).m8791d((C2744aa.m5139k() ? GoloUSAActivity.class : MineActivity.class).getName())) {
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.cnlaunch.p169im.p175e.OnIMViewListener
    /* renamed from: a */
    public final void mo8745a(String str, Bundle bundle) {
        Fragment instantiate;
        Fragment findFragmentByTag = getFragmentManager().findFragmentByTag(str);
        if (findFragmentByTag == null) {
            instantiate = Fragment.instantiate(this.f10981q, str);
        } else if (this.f8866n == str) {
            if (str == ProMessageFragment.class.getName()) {
                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStack();
                } else {
                    getFragmentManager().beginTransaction().detach(findFragmentByTag).commitAllowingStateLoss();
                }
                instantiate = Fragment.instantiate(this.f10981q, str);
            } else if (str != UserDetailFragment.class.getName()) {
                return;
            } else {
                instantiate = Fragment.instantiate(this.f10981q, str);
            }
        } else if (str == ProMessageFragment.class.getName()) {
            if (getFragmentManager().getBackStackEntryCount() > 0) {
                getFragmentManager().popBackStack();
            } else {
                getFragmentManager().beginTransaction().detach(findFragmentByTag).commitAllowingStateLoss();
            }
            instantiate = Fragment.instantiate(this.f10981q, str);
        } else if (str == MessageListFragment.class.getName() || str != UserDetailFragment.class.getName()) {
            return;
        } else {
            instantiate = Fragment.instantiate(this.f10981q, str);
        }
        this.f8866n = str;
        instantiate.setArguments(bundle);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.layout_fragment_contanier, instantiate, str);
        beginTransaction.addToBackStack(str);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent
    /* renamed from: a */
    public final void mo6035a(OnActivityResultListenter onActivityResultListenter) {
        this.f8862C = onActivityResultListenter;
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        OnActivityResultListenter onActivityResultListenter = this.f8862C;
        if (onActivityResultListenter != null) {
            onActivityResultListenter.mo5996a(i, i2, intent);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent
    /* renamed from: a */
    public final void mo6036a(long j) {
        OnActivityResultListenter onActivityResultListenter = this.f8862C;
        if (onActivityResultListenter == null || onActivityResultListenter.mo5997a() != j) {
            return;
        }
        this.f8862C = null;
    }

    @Override // com.cnlaunch.x431pro.p210a.FragmentKeyDownListener
    /* renamed from: a */
    public final void mo6039a(FragmentKeyDownListener.InterfaceC1949a interfaceC1949a) {
        this.f8864E = interfaceC1949a;
    }
}
