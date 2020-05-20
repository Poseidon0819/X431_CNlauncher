package com.cnlaunch.p169im;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.cnlaunch.p169im.p172c.MessageListFragment;
import com.cnlaunch.p169im.p172c.ProMessageFragment;
import com.cnlaunch.p169im.p172c.VerificationFragment;
import com.cnlaunch.p169im.p173d.NoticeMessageHandler;
import message.model.ChatRoom;

/* compiled from: IMActivity.java */
/* renamed from: com.cnlaunch.im.b */
/* loaded from: classes.dex */
final class C1697b extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ IMActivity f9041a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1697b(IMActivity iMActivity) {
        this.f9041a = iMActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Context context2;
        Context context3;
        String action = intent.getAction();
        Log.i("Sanda", "mReceiver ".concat(String.valueOf(action)));
        if (action.equalsIgnoreCase("ShowMessageFragment")) {
            Bundle bundle = new Bundle();
            ChatRoom chatRoom = (ChatRoom) intent.getExtras().get("ChatRoom");
            context3 = this.f9041a.f10981q;
            if (NoticeMessageHandler.m8784a(context3).m8773b(chatRoom.f24076a)) {
                return;
            }
            bundle.putParcelable("ChatRoom", chatRoom);
            bundle.putInt("launch_model", 0);
            this.f9041a.mo8745a(ProMessageFragment.class.getName(), bundle);
        } else if (action.equalsIgnoreCase("showSubFragment")) {
            if (intent.getExtras().getInt("subtype") == 0) {
                if (!intent.getExtras().getBoolean("isGolo")) {
                    context2 = this.f9041a.f10981q;
                    IMPresenter.m8804a(context2).m8800a(MessageListFragment.class.getName(), (Bundle) null);
                    return;
                }
                Log.i("XEE", "goto GOLO商家");
            }
        } else if (action.equalsIgnoreCase("logout") || !action.equalsIgnoreCase("friend_verication")) {
        } else {
            this.f9041a.mo8745a(VerificationFragment.class.getName(), null);
        }
    }
}
