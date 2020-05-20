package com.cnlaunch.p169im.p172c;

import android.os.Bundle;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.x431pro.activity.golo.p225b.OnFaceTouchListener;

/* compiled from: SearchFriendFragment.java */
/* renamed from: com.cnlaunch.im.c.x */
/* loaded from: classes.dex */
final class C1728x implements OnFaceTouchListener {

    /* renamed from: a */
    final /* synthetic */ SearchFriendFragment f9175a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1728x(SearchFriendFragment searchFriendFragment) {
        this.f9175a = searchFriendFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnFaceTouchListener
    /* renamed from: a */
    public final void mo7021a(String str, String str2, boolean z) {
        String str3;
        if (str2.equalsIgnoreCase("friend_verification") || str2.equalsIgnoreCase("666666")) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("target_id", str2);
        str3 = this.f9175a.f9160d;
        bundle.putString("target_name", str3);
        bundle.putBoolean("isFriend", z);
        IMPresenter.m8804a(this.f9175a.getActivity()).m8800a(UserDetailFragment.class.getName(), bundle);
    }
}
