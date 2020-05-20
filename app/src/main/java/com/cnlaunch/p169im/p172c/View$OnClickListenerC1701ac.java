package com.cnlaunch.p169im.p172c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.p179i.UserInfoCache;
import message.model.ChatRoom;
import message.p378a.MessageParameters;

/* compiled from: UserDetailFragment.java */
/* renamed from: com.cnlaunch.im.c.ac */
/* loaded from: classes.dex */
final class View$OnClickListenerC1701ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserDetailFragment f9070a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1701ac(UserDetailFragment userDetailFragment) {
        this.f9070a = userDetailFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Context context;
        String str2;
        boolean z;
        str = this.f9070a.f9057f;
        context = this.f9070a.mContext;
        UserInfoCache m8711a = UserInfoCache.m8711a(context, false);
        str2 = this.f9070a.f9057f;
        ChatRoom chatRoom = new ChatRoom(str, m8711a.m8710a(str2), MessageParameters.EnumC4721a.single);
        Bundle bundle = new Bundle();
        bundle.putParcelable("ChatRoom", chatRoom);
        bundle.putInt("launch_model", 0);
        bundle.putBoolean("isRemote", false);
        z = this.f9070a.f9054c;
        bundle.putBoolean("isFriend", z);
        IMPresenter.m8804a(this.f9070a.getActivity()).m8800a(ProMessageFragment.class.getName(), bundle);
    }
}
