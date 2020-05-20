package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import com.cnlaunch.x431pro.utils.C2744aa;
import java.util.ArrayList;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.am */
/* loaded from: classes.dex */
final class View$OnTouchListenerC2314am implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13421a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC2314am(RegistActivity registActivity) {
        this.f13421a = registActivity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Context context;
        ArrayList arrayList;
        if (C2744aa.m5166c()) {
            arrayList = this.f13421a.f13192bj;
            if (arrayList == null && motionEvent.getAction() == 1) {
                this.f13421a.m7739c(202);
                return true;
            }
            return false;
        } else if (motionEvent.getAction() == 0) {
            Intent intent = new Intent();
            context = this.f13421a.f10981q;
            intent.setClass(context, CountrySelectActivity.class);
            this.f13421a.startActivityForResult(intent, 1);
            return true;
        } else {
            return false;
        }
    }
}
