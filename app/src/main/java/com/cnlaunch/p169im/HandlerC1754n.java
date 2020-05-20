package com.cnlaunch.p169im;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import com.cnlaunch.golo3.p154a.C1551a;
import com.cnlaunch.golo3.p154a.p156b.C1580e;
import com.cnlaunch.p169im.widget.ImageTouchView;
import com.cnlaunch.p169im.widget.RoundProgressView;
import com.ifoer.expedition.pro.R;
import java.util.List;
import message.p384g.LogUtilMsg;

/* compiled from: ShowImageDetailActivity.java */
/* renamed from: com.cnlaunch.im.n */
/* loaded from: classes.dex */
final class HandlerC1754n extends Handler {

    /* renamed from: a */
    final /* synthetic */ ShowImageDetailActivity f9311a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1754n(ShowImageDetailActivity showImageDetailActivity) {
        this.f9311a = showImageDetailActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ProgressBar progressBar;
        RoundProgressView roundProgressView;
        List list;
        C1551a c1551a;
        C1580e c1580e;
        ProgressBar progressBar2;
        RoundProgressView roundProgressView2;
        RoundProgressView roundProgressView3;
        int i;
        RoundProgressView roundProgressView4;
        switch (message2.what) {
            case 0:
                int i2 = message2.arg1;
                String str = (String) message2.obj;
                LogUtilMsg.m227a("SHOW_ORIGIN", str);
                if (str != null) {
                    list = this.f9311a.f8876j;
                    View view = (View) list.get(i2);
                    ImageTouchView imageTouchView = (ImageTouchView) view.findViewById(R.id.large_image);
                    ImageTouchView imageTouchView2 = (ImageTouchView) view.findViewById(R.id.origin_image);
                    if (imageTouchView != null) {
                        imageTouchView.setVisibility(8);
                    }
                    if (imageTouchView2 != null) {
                        imageTouchView2.setVisibility(0);
                    }
                    c1551a = this.f9311a.f8882p;
                    c1580e = this.f9311a.f8883q;
                    c1551a.m9255a(imageTouchView2, str, c1580e);
                }
                progressBar = this.f9311a.f8879m;
                progressBar.setVisibility(8);
                roundProgressView = this.f9311a.f8877k;
                roundProgressView.setVisibility(4);
                return;
            case 1:
                progressBar2 = this.f9311a.f8879m;
                progressBar2.setVisibility(8);
                roundProgressView2 = this.f9311a.f8877k;
                roundProgressView2.setVisibility(4);
                return;
            case 11:
                roundProgressView3 = this.f9311a.f8877k;
                i = this.f9311a.f8878l;
                roundProgressView3.setProgress(i);
                return;
            case 12:
                roundProgressView4 = this.f9311a.f8877k;
                roundProgressView4.setProgress(100);
                return;
            default:
                return;
        }
    }
}
