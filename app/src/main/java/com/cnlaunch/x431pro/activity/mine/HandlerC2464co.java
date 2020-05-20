package com.cnlaunch.x431pro.activity.mine;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import java.util.List;

/* compiled from: ReportPagersFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.co */
/* loaded from: classes.dex */
final class HandlerC2464co extends Handler {

    /* renamed from: a */
    final /* synthetic */ ReportPagersFragment f14107a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2464co(ReportPagersFragment reportPagersFragment) {
        this.f14107a = reportPagersFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        IconRadioButton iconRadioButton;
        IconRadioButton iconRadioButton2;
        View view;
        IconButton iconButton;
        int m6229a;
        int m6229a2;
        int i;
        int i2;
        List list;
        List m6224a;
        List list2;
        IconRadioButton iconRadioButton3;
        List list3;
        List m6221b;
        List list4;
        View view2;
        IconButton iconButton2;
        switch (message2.what) {
            case 0:
                Log.i("Sanda", "msg.what=" + message2.what);
                if (message2.arg1 != 0) {
                    iconRadioButton = this.f14107a.f14084h;
                    iconRadioButton.setChecked(true);
                    return;
                }
                break;
            case 1:
                if (((Integer) message2.obj).intValue() == 1) {
                    view2 = this.f14107a.f14102z;
                    view2.setVisibility(8);
                    iconButton2 = this.f14107a.f14087k;
                    iconButton2.setVisibility(0);
                } else {
                    view = this.f14107a.f14102z;
                    view.setVisibility(0);
                    iconButton = this.f14107a.f14087k;
                    iconButton.setVisibility(8);
                }
                m6229a = this.f14107a.m6229a();
                if (m6229a != 0) {
                    m6229a2 = this.f14107a.m6229a();
                    if (m6229a2 == 2) {
                        ReportPagersFragment reportPagersFragment = this.f14107a;
                        list = reportPagersFragment.f14079c;
                        m6224a = reportPagersFragment.m6224a(list);
                        i = m6224a.size();
                        list2 = this.f14107a.f14079c;
                        i2 = list2.size();
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                } else {
                    ReportPagersFragment reportPagersFragment2 = this.f14107a;
                    list3 = reportPagersFragment2.f14077a;
                    m6221b = reportPagersFragment2.m6221b(list3);
                    i = m6221b.size();
                    list4 = this.f14107a.f14077a;
                    i2 = list4.size();
                }
                if (i == i2 && i2 != 0) {
                    iconRadioButton3 = this.f14107a.f14084h;
                    iconRadioButton3.setChecked(true);
                    return;
                }
                break;
            default:
                return;
        }
        iconRadioButton2 = this.f14107a.f14084h;
        iconRadioButton2.setChecked(false);
    }
}
