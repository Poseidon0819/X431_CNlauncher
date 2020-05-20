package com.cnlaunch.x431pro.activity.golo.p224a;

import android.view.View;
import com.cnlaunch.x431pro.activity.golo.p225b.OnFaceTouchListener;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.utils.C2744aa;
import java.util.List;

/* compiled from: FriendsListAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.golo.a.c */
/* loaded from: classes.dex */
final class View$OnClickListenerC2226c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f12528a;

    /* renamed from: b */
    final /* synthetic */ FriendsListAdapter f12529b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2226c(FriendsListAdapter friendsListAdapter, int i) {
        this.f12529b = friendsListAdapter;
        this.f12528a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        OnFaceTouchListener onFaceTouchListener;
        List list;
        List list2;
        String user_name;
        OnFaceTouchListener onFaceTouchListener2;
        List list3;
        List list4;
        onFaceTouchListener = this.f12529b.f12508c;
        if (onFaceTouchListener != null) {
            list = this.f12529b.f12510e;
            if (C2744aa.m5178a(((FriendInfo) list.get(this.f12528a)).getNick_name())) {
                list4 = this.f12529b.f12510e;
                user_name = ((FriendInfo) list4.get(this.f12528a)).getNick_name();
            } else {
                list2 = this.f12529b.f12510e;
                user_name = ((FriendInfo) list2.get(this.f12528a)).getUser_name();
            }
            onFaceTouchListener2 = this.f12529b.f12508c;
            list3 = this.f12529b.f12510e;
            onFaceTouchListener2.mo7021a(user_name, ((FriendInfo) list3.get(this.f12528a)).getUser_id(), true);
        }
    }
}
