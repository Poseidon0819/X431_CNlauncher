package com.cnlaunch.x431pro.activity.mine.p230b;

import android.content.Context;
import android.widget.CompoundButton;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.diagnose.p218a.DatastreamSelectListAdapter;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* compiled from: DiagnosisPlaybackFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.m */
/* loaded from: classes.dex */
final class C2425m implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2424l f13821a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2425m(HandlerC2424l handlerC2424l) {
        this.f13821a = handlerC2424l;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ArrayList arrayList;
        int i;
        DatastreamSelectListAdapter datastreamSelectListAdapter;
        int i2;
        DatastreamSelectListAdapter datastreamSelectListAdapter2;
        int i3;
        Context context;
        int i4;
        DatastreamSelectListAdapter datastreamSelectListAdapter3;
        if (!z) {
            this.f13821a.f13820a.f13818y = 0;
            datastreamSelectListAdapter3 = this.f13821a.f13820a.f13815v;
            datastreamSelectListAdapter3.m7506c();
            return;
        }
        arrayList = this.f13821a.f13820a.f13813t;
        int size = arrayList.size();
        i = this.f13821a.f13820a.f13819z;
        if (size <= i) {
            datastreamSelectListAdapter = this.f13821a.f13820a.f13815v;
            datastreamSelectListAdapter.m7513a();
            return;
        }
        DiagnosisPlaybackFragment diagnosisPlaybackFragment = this.f13821a.f13820a;
        i2 = this.f13821a.f13820a.f13819z;
        diagnosisPlaybackFragment.f13818y = i2;
        datastreamSelectListAdapter2 = this.f13821a.f13820a.f13815v;
        i3 = this.f13821a.f13820a.f13819z;
        if (datastreamSelectListAdapter2.f11309b != null && datastreamSelectListAdapter2.f11309b.size() > 0) {
            for (int i5 = 0; i5 < i3; i5++) {
                datastreamSelectListAdapter2.f11309b.get(i5).setCheck(true);
            }
            datastreamSelectListAdapter2.notifyDataSetChanged();
        }
        context = this.f13821a.f13820a.mContext;
        String string = this.f13821a.f13820a.getString(R.string.toast_replay_datastream_check);
        i4 = this.f13821a.f13820a.f13819z;
        NToast.m9449a(context, String.format(string, Integer.valueOf(i4)));
    }
}
