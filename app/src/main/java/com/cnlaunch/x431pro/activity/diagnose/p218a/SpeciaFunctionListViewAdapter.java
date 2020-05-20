package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.t */
/* loaded from: classes.dex */
public final class SpeciaFunctionListViewAdapter extends BaseAdapter {

    /* renamed from: a */
    public ArrayList<ArrayList<BasicSpeciaFunctionBean>> f11427a;

    /* renamed from: c */
    public SerializableMap f11429c;

    /* renamed from: d */
    public int[] f11430d;

    /* renamed from: g */
    private Context f11433g;

    /* renamed from: h */
    private LayoutInflater f11434h;

    /* renamed from: b */
    public int f11428b = -1;

    /* renamed from: e */
    public String f11431e = "";

    /* renamed from: f */
    C2032a f11432f = null;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public SpeciaFunctionListViewAdapter(ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList, Context context, int[] iArr) {
        this.f11434h = LayoutInflater.from(context);
        this.f11427a = arrayList;
        this.f11433g = context;
        this.f11430d = iArr;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList = this.f11427a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        String title;
        if (view == null) {
            this.f11432f = new C2032a();
            view = this.f11434h.inflate(R.layout.item_listview_speciafunction, (ViewGroup) null);
            this.f11432f.f11435a = (LinearLayout) view.findViewById(R.id.item_specia_layout);
            view.setTag(this.f11432f);
        } else {
            this.f11432f = (C2032a) view.getTag();
        }
        this.f11432f.f11435a.removeAllViews();
        ArrayList<BasicSpeciaFunctionBean> arrayList = this.f11427a.get(i);
        boolean z = arrayList.size() > 1 && arrayList.get(1) != null && (title = arrayList.get(1).getTitle()) != null && title.contains("|");
        int dimension = (int) this.f11433g.getResources().getDimension(R.dimen.item_text_padding);
        if (this.f11431e.equals(DiagnoseConstants.UI_TYPE_SPECIAL_MultiSelect)) {
            CheckBox checkBox = new CheckBox(this.f11433g);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((dimension * 2) + 50, -1);
            layoutParams.setMargins(dimension, 0, dimension, 0);
            checkBox.setLayoutParams(layoutParams);
            checkBox.setGravity(16);
            checkBox.setButtonDrawable(this.f11433g.getResources().getDrawable(17170445));
            this.f11432f.f11435a.addView(checkBox);
            checkBox.setBackgroundResource(R.drawable.select_checkbox_red);
            checkBox.setChecked(arrayList.get(0).isCheck());
            checkBox.setOnClickListener(new View$OnClickListenerC2033u(this, i));
            this.f11432f.f11435a.setOnClickListener(new View$OnClickListenerC2034v(this, i));
            z = false;
        }
        int dimensionPixelSize = (this.f11433g.getResources().getDisplayMetrics().widthPixels - (this.f11433g.getResources().getDimensionPixelSize(R.dimen.horizontal_margin) * 2)) - (arrayList.size() * dimension);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TextView textView = new TextView(this.f11433g);
            SerializableMap serializableMap = this.f11429c;
            if (serializableMap != null && serializableMap.getMap() != null) {
                String str = this.f11429c.getMap().get(arrayList.get(i2).getTitle());
                if (!TextUtils.isEmpty(str)) {
                    textView.setText(str);
                } else {
                    textView.setText(arrayList.get(i2).getTitle());
                }
            } else {
                textView.setText(arrayList.get(i2).getTitle());
            }
            int i3 = (int) (dimensionPixelSize * (this.f11430d[i2] / 100.0f));
            if (this.f11431e.equals(DiagnoseConstants.UI_TYPE_SPECIAL_MultiSelect) && i2 == 0) {
                i3 = (i3 - 50) - (dimension * 4);
            }
            textView.setTextAppearance(this.f11433g, 2131755308);
            if (z) {
                textView.setTextColor(-65536);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, -1);
            layoutParams2.setMargins(dimension, 15, 0, 15);
            textView.setGravity(16);
            textView.setLayoutParams(layoutParams2);
            this.f11432f.f11435a.addView(textView);
            if (i2 < arrayList.size() - 1) {
                View view2 = new View(this.f11433g);
                view2.setBackgroundColor(-1644826);
                view2.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
                this.f11432f.f11435a.addView(view2);
            }
        }
        if (this.f11428b == i) {
            view.setActivated(true);
        } else {
            view.setActivated(false);
        }
        return view;
    }

    /* renamed from: a */
    public final boolean m7482a(int i) {
        boolean z = !this.f11427a.get(i).get(0).isCheck();
        this.f11427a.get(i).get(0).setCheck(z);
        notifyDataSetChanged();
        return z;
    }

    /* compiled from: SpeciaFunctionListViewAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.t$a */
    /* loaded from: classes.dex */
    class C2032a {

        /* renamed from: a */
        LinearLayout f11435a;

        C2032a() {
        }
    }

    /* renamed from: b */
    public final void m7480b(int i) {
        this.f11428b = i;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public final void m7481a(boolean z) {
        ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList = this.f11427a;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.f11427a.size(); i++) {
            this.f11427a.get(i).get(0).setCheck(z);
        }
        notifyDataSetChanged();
    }
}
