package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.x431pro.activity.diagnose.p221d.FaultCodeFragment;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.i */
/* loaded from: classes.dex */
public final class FaultCodeShowListAdapter extends BaseAdapter {

    /* renamed from: a */
    public ArrayList<BasicFaultCodeBean> f11330a;

    /* renamed from: b */
    public int f11331b;

    /* renamed from: c */
    public boolean f11332c;

    /* renamed from: d */
    public boolean f11333d;

    /* renamed from: e */
    public SerializableMap f11334e;

    /* renamed from: f */
    public FaultCodeFragment f11335f;

    /* renamed from: g */
    C2021a f11336g;

    /* renamed from: h */
    private Context f11337h;

    /* renamed from: i */
    private LayoutInflater f11338i;

    /* renamed from: j */
    private boolean f11339j;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public FaultCodeShowListAdapter(ArrayList<BasicFaultCodeBean> arrayList, Context context) {
        this.f11331b = -1;
        this.f11339j = false;
        this.f11332c = false;
        this.f11333d = false;
        this.f11336g = null;
        this.f11338i = LayoutInflater.from(context);
        this.f11330a = arrayList;
        this.f11337h = context;
    }

    public FaultCodeShowListAdapter(ArrayList<BasicFaultCodeBean> arrayList, Context context, byte b) {
        this.f11331b = -1;
        this.f11339j = false;
        this.f11332c = false;
        this.f11333d = false;
        this.f11336g = null;
        this.f11338i = LayoutInflater.from(context);
        this.f11330a = arrayList;
        this.f11337h = context;
        this.f11339j = true;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList<BasicFaultCodeBean> arrayList = this.f11330a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01f5  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View getView(int r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.p218a.FaultCodeShowListAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* compiled from: FaultCodeShowListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.i$a */
    /* loaded from: classes.dex */
    class C2021a {

        /* renamed from: a */
        String f11340a;

        /* renamed from: b */
        TextView f11341b;

        /* renamed from: c */
        TextView f11342c;

        /* renamed from: d */
        TextView f11343d;

        /* renamed from: e */
        TextView f11344e;

        /* renamed from: f */
        TextView f11345f;

        /* renamed from: g */
        LinearLayout f11346g;

        /* renamed from: h */
        LinearLayout f11347h;

        C2021a() {
        }
    }
}
