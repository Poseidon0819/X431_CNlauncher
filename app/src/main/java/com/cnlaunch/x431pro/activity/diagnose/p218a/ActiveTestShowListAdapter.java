package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p280b.MeasureConversion;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.a */
/* loaded from: classes.dex */
public final class ActiveTestShowListAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<BasicDataStreamBean> f11239a;

    /* renamed from: b */
    public Context f11240b;

    /* renamed from: c */
    public int f11241c = -1;

    /* renamed from: d */
    public SerializableMap f11242d = null;

    /* renamed from: e */
    C2012a f11243e = null;

    /* renamed from: f */
    public List<Boolean> f11244f = new ArrayList();

    /* renamed from: g */
    private LayoutInflater f11245g;

    /* renamed from: h */
    private String f11246h;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public ActiveTestShowListAdapter(String str, ArrayList<BasicDataStreamBean> arrayList, Context context) {
        this.f11246h = "";
        this.f11245g = LayoutInflater.from(context);
        this.f11246h = str;
        this.f11240b = context;
        this.f11239a = MeasureConversion.m5099a(C2744aa.m5158d(this.f11240b), arrayList);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<BasicDataStreamBean> list = this.f11239a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f11243e = new C2012a();
            view = this.f11245g.inflate(R.layout.item_list_activetest, (ViewGroup) null);
            this.f11243e.f11251e = (CheckBox) view.findViewById(R.id.cb_list_select);
            this.f11243e.f11248b = (TextView) view.findViewById(R.id.title);
            this.f11243e.f11249c = (TextView) view.findViewById(R.id.value);
            this.f11243e.f11250d = (TextView) view.findViewById(R.id.unit);
            view.setTag(this.f11243e);
        } else {
            this.f11243e = (C2012a) view.getTag();
        }
        String title = this.f11239a.get(i).getTitle();
        SerializableMap serializableMap = this.f11242d;
        if (serializableMap != null && serializableMap.getMap() != null) {
            String str = this.f11242d.getMap().get(title);
            if (!TextUtils.isEmpty(str)) {
                this.f11243e.f11248b.setText(str);
            } else {
                this.f11243e.f11248b.setText(title);
            }
        } else {
            this.f11243e.f11248b.setText(title);
        }
        this.f11243e.f11247a = this.f11239a.get(i).getId();
        this.f11243e.f11249c.setText(this.f11239a.get(i).getValue());
        this.f11243e.f11250d.setText(this.f11239a.get(i).getUnit());
        if (!this.f11239a.get(i).getUnit().equals("")) {
            this.f11246h.equals(DiagnoseConstants.UI_TYPE_FIXED_ITEM_ACTIVE_TEST);
        }
        if (this.f11241c == i) {
            view.setActivated(true);
        } else {
            view.setActivated(false);
        }
        return view;
    }

    /* compiled from: ActiveTestShowListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.a$a */
    /* loaded from: classes.dex */
    class C2012a {

        /* renamed from: a */
        String f11247a;

        /* renamed from: b */
        TextView f11248b;

        /* renamed from: c */
        TextView f11249c;

        /* renamed from: d */
        TextView f11250d;

        /* renamed from: e */
        CheckBox f11251e;

        C2012a() {
        }
    }

    /* renamed from: a */
    public final String m7525a() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f11244f.size(); i++) {
            List<Boolean> list = this.f11244f;
            sb.append((list == null || list.size() <= 0) ? false : this.f11244f.get(i).booleanValue() ? "1" : "0");
        }
        return sb.toString();
    }
}
