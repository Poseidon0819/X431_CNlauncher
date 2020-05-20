package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.support.p012v4.view.ViewPager;
import android.view.View;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.mine.p229a.MyReportAdapter;
import com.cnlaunch.x431pro.activity.mine.p229a.NewLocalReportAdapter;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* compiled from: ReportPagersFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ct */
/* loaded from: classes.dex */
final class View$OnClickListenerC2469ct implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ReportPagersFragment f14112a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2469ct(ReportPagersFragment reportPagersFragment) {
        this.f14112a = reportPagersFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int m6229a;
        List list;
        int size;
        IconRadioButton iconRadioButton;
        List list2;
        int i;
        ViewPager viewPager;
        MyReportAdapter myReportAdapter;
        NewLocalReportAdapter newLocalReportAdapter;
        int i2;
        ViewPager viewPager2;
        MyReportAdapter myReportAdapter2;
        int i3;
        Context context;
        int i4;
        NewLocalReportAdapter newLocalReportAdapter2;
        int i5;
        ViewPager viewPager3;
        MyReportAdapter myReportAdapter3;
        NewLocalReportAdapter newLocalReportAdapter3;
        IconRadioButton iconRadioButton2;
        List list3;
        m6229a = this.f14112a.m6229a();
        if (m6229a == 0) {
            list3 = this.f14112a.f14077a;
            size = list3.size();
        } else {
            list = this.f14112a.f14079c;
            size = list.size();
        }
        int i6 = 0;
        if (size == 0) {
            iconRadioButton2 = this.f14112a.f14084h;
            iconRadioButton2.setChecked(false);
            NToast.m9447b(this.f14112a.getActivity(), (int) R.string.toast_need_one_report);
            return;
        }
        iconRadioButton = this.f14112a.f14084h;
        if (!iconRadioButton.isChecked()) {
            this.f14112a.f14089m = 0;
            viewPager3 = this.f14112a.f14092p;
            if (viewPager3.getCurrentItem() == 0) {
                newLocalReportAdapter3 = this.f14112a.f14096t;
                if (newLocalReportAdapter3.f13573a == null || newLocalReportAdapter3.f13573a.size() <= 0) {
                    return;
                }
                for (int i7 = 0; i7 < newLocalReportAdapter3.f13573a.size(); i7++) {
                    newLocalReportAdapter3.f13573a.get(i7).setCheck(false);
                }
                newLocalReportAdapter3.notifyDataSetChanged();
                return;
            }
            myReportAdapter3 = this.f14112a.f14097u;
            if (myReportAdapter3.f13556a == null || myReportAdapter3.f13556a.size() <= 0) {
                return;
            }
            for (int i8 = 0; i8 < myReportAdapter3.f13556a.size(); i8++) {
                myReportAdapter3.f13556a.get(i8).setCheck(false);
            }
            myReportAdapter3.notifyDataSetChanged();
            return;
        }
        list2 = this.f14112a.f14079c;
        int size2 = list2.size();
        i = this.f14112a.f14090n;
        if (size2 <= i) {
            viewPager = this.f14112a.f14092p;
            if (viewPager.getCurrentItem() == 0) {
                newLocalReportAdapter = this.f14112a.f14096t;
                if (newLocalReportAdapter.f13573a == null || newLocalReportAdapter.f13573a.size() <= 0) {
                    return;
                }
                while (i6 < newLocalReportAdapter.f13573a.size()) {
                    newLocalReportAdapter.f13573a.get(i6).setCheck(true);
                    i6++;
                }
                newLocalReportAdapter.notifyDataSetChanged();
                return;
            }
            myReportAdapter = this.f14112a.f14097u;
            if (myReportAdapter.f13556a == null || myReportAdapter.f13556a.size() <= 0) {
                return;
            }
            while (i6 < myReportAdapter.f13556a.size()) {
                myReportAdapter.f13556a.get(i6).setCheck(true);
                i6++;
            }
            myReportAdapter.notifyDataSetChanged();
            return;
        }
        ReportPagersFragment reportPagersFragment = this.f14112a;
        i2 = reportPagersFragment.f14090n;
        reportPagersFragment.f14089m = i2;
        viewPager2 = this.f14112a.f14092p;
        if (viewPager2.getCurrentItem() == 0) {
            newLocalReportAdapter2 = this.f14112a.f14096t;
            i5 = this.f14112a.f14090n;
            if (newLocalReportAdapter2.f13573a != null && newLocalReportAdapter2.f13573a.size() > 0) {
                for (int i9 = 0; i9 < i5; i9++) {
                    newLocalReportAdapter2.f13573a.get(i9).setCheck(true);
                }
                newLocalReportAdapter2.notifyDataSetChanged();
            }
        } else {
            myReportAdapter2 = this.f14112a.f14097u;
            i3 = this.f14112a.f14090n;
            if (myReportAdapter2.f13556a != null && myReportAdapter2.f13556a.size() > 0) {
                for (int i10 = 0; i10 < i3; i10++) {
                    myReportAdapter2.f13556a.get(i10).setCheck(true);
                }
                myReportAdapter2.notifyDataSetChanged();
            }
        }
        context = this.f14112a.mContext;
        String string = this.f14112a.getString(R.string.toast_replay_datastream_check);
        i4 = this.f14112a.f14090n;
        NToast.m9449a(context, String.format(string, Integer.valueOf(i4)));
    }
}
