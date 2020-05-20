package com.cnlaunch.p169im.p172c;

import android.view.MotionEvent;
import android.view.View;
import com.cnlaunch.p169im.widget.ChatListView;
import com.cnlaunch.p169im.widget.InputText;

/* compiled from: ProMessageFragment.java */
/* renamed from: com.cnlaunch.im.c.k */
/* loaded from: classes.dex */
final class View$OnTouchListenerC1715k implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ProMessageFragment f9146a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC1715k(ProMessageFragment proMessageFragment) {
        this.f9146a = proMessageFragment;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View view2;
        View view3;
        View view4;
        if (motionEvent.getAction() == 1) {
            ProMessageFragment proMessageFragment = this.f9146a;
            ChatListView chatListView = proMessageFragment.f9123f;
            InputText inputText = this.f9146a.f9128k;
            view2 = this.f9146a.f9132o;
            view3 = this.f9146a.f9131n;
            view4 = this.f9146a.f9133p;
            proMessageFragment.m8847a(chatListView, inputText, view2, view3, view4, true);
            return false;
        }
        return false;
    }
}
