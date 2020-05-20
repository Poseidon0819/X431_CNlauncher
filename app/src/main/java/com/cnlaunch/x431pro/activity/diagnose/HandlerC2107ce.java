package com.cnlaunch.x431pro.activity.diagnose;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.diagnose.p218a.SelectCarVerAdapter;
import com.cnlaunch.x431pro.module.p252d.p254b.CarVersionInfo;
import com.cnlaunch.x431pro.widget.button.IconButton;
import java.util.ArrayList;
import java.util.Timer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelectSoftVersionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ce */
/* loaded from: classes.dex */
public final class HandlerC2107ce extends Handler {

    /* renamed from: a */
    final /* synthetic */ SelectSoftVersionFragment f11834a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2107ce(SelectSoftVersionFragment selectSoftVersionFragment) {
        this.f11834a = selectSoftVersionFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        IconButton iconButton;
        IconButton iconButton2;
        SelectCarVerAdapter selectCarVerAdapter;
        ArrayList arrayList;
        ArrayList arrayList2;
        SelectCarVerAdapter selectCarVerAdapter2;
        ArrayList<CarVersionInfo> arrayList3;
        TextView textView;
        ArrayList arrayList4;
        TextView textView2;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        IconButton iconButton3;
        IconButton iconButton4;
        if (message2.what == 274 || message2.what == 275) {
            iconButton = this.f11834a.f11687l;
            iconButton.setEnabled(message2.what == 274);
            iconButton2 = this.f11834a.f11686k;
            iconButton2.setEnabled(message2.what == 274);
        } else if (message2.what == 291) {
            iconButton3 = this.f11834a.f11687l;
            iconButton3.setEnabled(true);
            iconButton4 = this.f11834a.f11686k;
            iconButton4.setEnabled(true);
        } else if (message2.what != 273) {
            selectCarVerAdapter = this.f11834a.f11685j;
            int i = selectCarVerAdapter.f11414a;
            arrayList = this.f11834a.f11693r;
            if (arrayList != null) {
                arrayList2 = this.f11834a.f11693r;
                if (arrayList2.size() >= i) {
                    selectCarVerAdapter2 = this.f11834a.f11685j;
                    arrayList3 = this.f11834a.f11693r;
                    selectCarVerAdapter2.m7483a(arrayList3);
                    textView = this.f11834a.f11673A;
                    arrayList4 = this.f11834a.f11693r;
                    textView.setText(((CarVersionInfo) arrayList4.get(i)).getIniTitle());
                    textView2 = this.f11834a.f11701z;
                    arrayList5 = this.f11834a.f11693r;
                    textView2.setText(((CarVersionInfo) arrayList5.get(i)).getIniText());
                    SelectSoftVersionFragment selectSoftVersionFragment = this.f11834a;
                    StringBuilder sb = new StringBuilder();
                    arrayList6 = this.f11834a.f11693r;
                    sb.append(((CarVersionInfo) arrayList6.get(i)).getIniTitle());
                    sb.append("\n");
                    arrayList7 = this.f11834a.f11693r;
                    sb.append(((CarVersionInfo) arrayList7.get(i)).getIniText());
                    selectSoftVersionFragment.f11696u = sb.toString();
                }
            }
        } else {
            new Timer().schedule(new C2108cf(this), 6000L);
        }
    }
}
