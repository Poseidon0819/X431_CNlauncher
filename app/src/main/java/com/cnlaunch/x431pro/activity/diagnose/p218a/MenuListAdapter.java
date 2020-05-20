package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpecMenuBean;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.o */
/* loaded from: classes.dex */
public final class MenuListAdapter extends BaseAdapter {

    /* renamed from: a */
    public IFragmentCallback f11389a;

    /* renamed from: b */
    public int f11390b;

    /* renamed from: c */
    public int f11391c;

    /* renamed from: d */
    public String f11392d;

    /* renamed from: e */
    C2026a f11393e;

    /* renamed from: f */
    private LayoutInflater f11394f;

    /* renamed from: g */
    private ArrayList<BasicMenuBean> f11395g;

    /* renamed from: h */
    private Context f11396h;

    /* renamed from: i */
    private int f11397i;

    /* renamed from: j */
    private int f11398j;

    /* renamed from: k */
    private ArrayList<BasicSpecMenuBean> f11399k;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public MenuListAdapter(ArrayList<BasicMenuBean> arrayList, Context context) {
        this.f11397i = 0;
        this.f11398j = 0;
        this.f11393e = null;
        this.f11395g = arrayList;
        this.f11394f = LayoutInflater.from(context);
        this.f11396h = context;
    }

    public MenuListAdapter(ArrayList<BasicSpecMenuBean> arrayList, Context context, int i) {
        this.f11397i = 0;
        this.f11398j = 0;
        this.f11393e = null;
        this.f11399k = arrayList;
        this.f11398j = i;
        this.f11397i = 1;
        this.f11394f = LayoutInflater.from(context);
        this.f11396h = context;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.f11397i != 0) {
            return this.f11399k.size();
        }
        return this.f11395g.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.f11397i != 0) {
            return this.f11399k.get(i);
        }
        return this.f11395g.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f11393e = new C2026a();
            if (this.f11397i == 0) {
                view = this.f11394f.inflate(R.layout.item_list_menu, (ViewGroup) null);
                this.f11393e.f11400a = (ImageView) view.findViewById(R.id.car_icon);
                this.f11393e.f11401b = (TextView) view.findViewById(R.id.title);
                this.f11393e.f11403d = (ImageView) view.findViewById(R.id.helpbt);
                view.setTag(this.f11393e);
            } else {
                view = this.f11394f.inflate(R.layout.item_history_choice_list_menu, (ViewGroup) null);
                this.f11393e.f11401b = (TextView) view.findViewById(R.id.title);
                this.f11393e.f11402c = (TextView) view.findViewById(R.id.memu);
                this.f11393e.f11403d = (ImageView) view.findViewById(R.id.helpbt);
                view.setTag(this.f11393e);
            }
        } else {
            this.f11393e = (C2026a) view.getTag();
        }
        view.setActivated("1".equals(this.f11397i == 0 ? this.f11395g.get(i).getHadChoiced() : ""));
        if ("1".equals(this.f11397i == 0 ? this.f11395g.get(i).getHasHelp() : "")) {
            this.f11393e.f11403d.setVisibility(0);
            this.f11393e.f11403d.setOnClickListener(new View$OnClickListenerC2027p(this, i));
        } else if (this.f11393e.f11403d != null) {
            this.f11393e.f11403d.setVisibility(8);
        }
        String title = this.f11397i == 0 ? this.f11395g.get(i).getTitle() : this.f11399k.get(i).getTitle();
        if (title.equals("Quick Test")) {
            title = "Health Report";
        }
        this.f11393e.f11401b.setText(title);
        if (this.f11397i != 0) {
            if (i == this.f11399k.size() - 1) {
                view.setBackgroundColor(-65536);
                this.f11393e.f11401b.setTextColor(-1);
                this.f11393e.f11402c.setVisibility(8);
            } else {
                view.setBackgroundColor(-7829368);
                this.f11393e.f11401b.setTextColor(-16777216);
                this.f11393e.f11402c.setTextColor(-16711936);
                this.f11393e.f11402c.setVisibility(0);
                this.f11393e.f11402c.setText(this.f11399k.get(i).getSecondTitle());
            }
        }
        return view;
    }

    /* compiled from: MenuListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.o$a */
    /* loaded from: classes.dex */
    class C2026a {

        /* renamed from: a */
        ImageView f11400a;

        /* renamed from: b */
        TextView f11401b;

        /* renamed from: c */
        TextView f11402c;

        /* renamed from: d */
        ImageView f11403d;

        C2026a() {
        }
    }
}
