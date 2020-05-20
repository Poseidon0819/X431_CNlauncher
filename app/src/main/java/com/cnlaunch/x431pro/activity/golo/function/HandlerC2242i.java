package com.cnlaunch.x431pro.activity.golo.function;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import message.model.MessageObj;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoPlayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.golo.function.i */
/* loaded from: classes.dex */
public final class HandlerC2242i extends Handler {

    /* renamed from: a */
    final /* synthetic */ VideoPlayFragment f12675a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2242i(VideoPlayFragment videoPlayFragment) {
        this.f12675a = videoPlayFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        View view;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        TextView textView;
        ProgressBar progressBar3;
        TextView textView2;
        View view2;
        SharedPreferences sharedPreferences;
        MessageObj messageObj;
        String str;
        switch (message2.what) {
            case 1:
                view = this.f12675a.f12667g;
                view.setVisibility(0);
                progressBar = this.f12675a.f12665e;
                progressBar.setMax(100);
                progressBar2 = this.f12675a.f12665e;
                progressBar2.setProgress(0);
                textView = this.f12675a.f12666f;
                textView.setText("0%");
                break;
            case 2:
                int i = (message2.arg2 * 100) / message2.arg1;
                progressBar3 = this.f12675a.f12665e;
                progressBar3.setProgress(i);
                textView2 = this.f12675a.f12666f;
                textView2.setText(i + "%");
                break;
            case 3:
                view2 = this.f12675a.f12667g;
                view2.setVisibility(8);
                this.f12675a.f12673m = message2.obj.toString();
                sharedPreferences = this.f12675a.f12663c;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                messageObj = this.f12675a.f12668h;
                String str2 = messageObj.f24084a;
                str = this.f12675a.f12673m;
                edit.putString(str2, str).commit();
                this.f12675a.m6978a();
                break;
        }
        super.handleMessage(message2);
    }
}
