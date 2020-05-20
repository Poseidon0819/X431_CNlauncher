package com.cnlaunch.x431pro.activity.mine.p230b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.diagnose.p218a.DatastreamSelectListAdapter;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.staggeredgridview.StaggeredGridView;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnosisPlaybackFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.l */
/* loaded from: classes.dex */
public final class HandlerC2424l extends Handler {

    /* renamed from: a */
    final /* synthetic */ DiagnosisPlaybackFragment f13820a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2424l(DiagnosisPlaybackFragment diagnosisPlaybackFragment) {
        this.f13820a = diagnosisPlaybackFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ProgressBar progressBar;
        IconRadioButton iconRadioButton;
        IconButton iconButton;
        TextView textView;
        ProgressBar progressBar2;
        ArrayList arrayList;
        IconRadioButton iconRadioButton2;
        ArrayList arrayList2;
        DatastreamSelectListAdapter datastreamSelectListAdapter;
        DatastreamSelectListAdapter datastreamSelectListAdapter2;
        StaggeredGridView staggeredGridView;
        DatastreamSelectListAdapter datastreamSelectListAdapter3;
        StaggeredGridView staggeredGridView2;
        Context context;
        IconRadioButton iconRadioButton3;
        IconRadioButton iconRadioButton4;
        switch (message2.what) {
            case 0:
                progressBar = this.f13820a.f13801h;
                progressBar.setProgress(message2.arg1);
                return;
            case 1:
                iconRadioButton = this.f13820a.f13797d;
                iconRadioButton.setEnabled(true);
                iconButton = this.f13820a.f13798e;
                iconButton.setEnabled(true);
                textView = this.f13820a.f13800g;
                textView.setVisibility(8);
                progressBar2 = this.f13820a.f13801h;
                progressBar2.setVisibility(8);
                arrayList = this.f13820a.f13813t;
                if (arrayList != null && this.f13820a.getActivity() != null) {
                    DiagnosisPlaybackFragment diagnosisPlaybackFragment = this.f13820a;
                    arrayList2 = diagnosisPlaybackFragment.f13813t;
                    diagnosisPlaybackFragment.f13815v = new DatastreamSelectListAdapter(arrayList2, "RePlayDataStream", this.f13820a.getActivity(), true, false, 0, "replaydatastream");
                    datastreamSelectListAdapter = this.f13820a.f13815v;
                    datastreamSelectListAdapter.f11310c = true;
                    datastreamSelectListAdapter2 = this.f13820a.f13815v;
                    datastreamSelectListAdapter2.f11308a = true;
                    staggeredGridView = this.f13820a.f13814u;
                    datastreamSelectListAdapter3 = this.f13820a.f13815v;
                    staggeredGridView.setAdapter((ListAdapter) datastreamSelectListAdapter3);
                    if (1 == this.f13820a.f13794a.mValue) {
                        staggeredGridView2 = this.f13820a.f13814u;
                        staggeredGridView2.setVisibility(8);
                        DiagnosisPlaybackFragment.m6339h(this.f13820a);
                        return;
                    }
                }
                iconRadioButton2 = this.f13820a.f13797d;
                iconRadioButton2.setOnCheckedChangeListener(new C2425m(this));
                return;
            case 2:
                new C2426n(this).m4610a(this.f13820a.getActivity(), R.string.dialog_title_default, R.string.mine_reportfile_error, true);
                return;
            case 3:
                context = this.f13820a.mContext;
                NToast.m9447b(context, (int) R.string.mine_file_not_exist);
                return;
            case 4:
                if (message2.arg1 == 0) {
                    iconRadioButton4 = this.f13820a.f13797d;
                    iconRadioButton4.setCheckedInvalidate(false);
                    return;
                }
                iconRadioButton3 = this.f13820a.f13797d;
                iconRadioButton3.setChecked(true);
                return;
            case 5:
                new C2427o(this).m4610a(this.f13820a.getActivity(), R.string.dialog_title_default, R.string.mine_reportfile_large, false);
                return;
            default:
                return;
        }
    }
}
