package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDelectDataListenter;
import com.cnlaunch.x431pro.module.p252d.p254b.CarVersionInfo;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.r */
/* loaded from: classes.dex */
public final class SelectCarVerAdapter extends BaseAdapter {

    /* renamed from: a */
    public int f11414a;

    /* renamed from: b */
    OnDelectDataListenter f11415b;

    /* renamed from: c */
    private LayoutInflater f11416c;

    /* renamed from: d */
    private ArrayList<CarVersionInfo> f11417d;

    /* renamed from: e */
    private String f11418e;

    /* renamed from: f */
    private C2030b f11419f = null;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r2.f11417d.size() == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SelectCarVerAdapter(android.content.Context r3, java.util.ArrayList<com.cnlaunch.x431pro.module.p252d.p254b.CarVersionInfo> r4, java.lang.String r5, com.cnlaunch.x431pro.activity.diagnose.p222e.OnDelectDataListenter r6) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.f11417d = r0
            r1 = 0
            r2.f11414a = r1
            java.lang.String r1 = ""
            r2.f11418e = r1
            r2.f11415b = r0
            r2.f11419f = r0
            r2.f11417d = r4
            if (r4 == 0) goto L25
            com.cnlaunch.x431pro.activity.diagnose.a.r$a r0 = new com.cnlaunch.x431pro.activity.diagnose.a.r$a
            r0.<init>()
            java.util.Collections.sort(r4, r0)
            java.util.ArrayList<com.cnlaunch.x431pro.module.d.b.b> r4 = r2.f11417d
            int r4 = r4.size()
            if (r4 != 0) goto L28
        L25:
            r4 = -1
            r2.f11414a = r4
        L28:
            r2.f11418e = r5
            r2.f11415b = r6
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r2.f11416c = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.p218a.SelectCarVerAdapter.<init>(android.content.Context, java.util.ArrayList, java.lang.String, com.cnlaunch.x431pro.activity.diagnose.e.c):void");
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList<CarVersionInfo> arrayList = this.f11417d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f11416c.inflate(R.layout.item_list_carver, (ViewGroup) null);
            this.f11419f = new C2030b();
            this.f11419f.f11421a = (TextView) view.findViewById(R.id.tv_carname);
            this.f11419f.f11422b = (TextView) view.findViewById(R.id.tv_carver);
            this.f11419f.f11423c = (ImageView) view.findViewById(R.id.btn_del);
            view.setTag(this.f11419f);
        } else {
            this.f11419f = (C2030b) view.getTag();
        }
        this.f11419f.f11421a.setText(this.f11418e.toUpperCase(Locale.getDefault()));
        this.f11419f.f11422b.setText(this.f11417d.get(i).getVersion());
        this.f11419f.f11423c.setOnClickListener(new View$OnClickListenerC2031s(this, i));
        this.f11419f.f11423c.setVisibility(i == 0 ? 4 : 0);
        if (this.f11414a == i) {
            view.setActivated(true);
        } else {
            view.setActivated(false);
        }
        return view;
    }

    /* compiled from: SelectCarVerAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.r$b */
    /* loaded from: classes.dex */
    class C2030b {

        /* renamed from: a */
        TextView f11421a;

        /* renamed from: b */
        TextView f11422b;

        /* renamed from: c */
        ImageView f11423c;

        C2030b() {
        }
    }

    /* renamed from: a */
    public final void m7484a(int i) {
        this.f11414a = i;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public final void m7483a(ArrayList<CarVersionInfo> arrayList) {
        this.f11417d = arrayList;
        if (arrayList == null || this.f11417d.size() == 0) {
            this.f11414a = -1;
        } else if (this.f11414a == -1) {
            this.f11414a = 0;
        }
        notifyDataSetChanged();
    }

    /* compiled from: SelectCarVerAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.r$a */
    /* loaded from: classes.dex */
    class C2029a implements Comparator<CarVersionInfo> {
        C2029a() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(CarVersionInfo carVersionInfo, CarVersionInfo carVersionInfo2) {
            return Double.parseDouble(carVersionInfo2.getVersion().replace("V", "")) > Double.parseDouble(carVersionInfo.getVersion().replace("V", "")) ? 1 : -1;
        }
    }
}
