package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p221d.DataStreamSelectFragment;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.ifoer.expedition.pro.R;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.f */
/* loaded from: classes.dex */
public final class DatastreamSelectListAdapter extends BaseAdapter {

    /* renamed from: b */
    public ArrayList<BasicSelectMenuBean> f11309b;

    /* renamed from: d */
    public DataStreamSelectFragment f11311d;

    /* renamed from: f */
    private LayoutInflater f11313f;

    /* renamed from: g */
    private boolean f11314g;

    /* renamed from: h */
    private Comparator<BasicSelectMenuBean> f11315h;

    /* renamed from: m */
    private boolean f11320m;

    /* renamed from: a */
    public boolean f11308a = true;

    /* renamed from: i */
    private ArrayList<BasicSelectMenuBean> f11316i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<String> f11317j = new ArrayList<>();

    /* renamed from: k */
    private StringBuilder f11318k = new StringBuilder();

    /* renamed from: l */
    private int f11319l = 0;

    /* renamed from: c */
    public boolean f11310c = false;

    /* renamed from: e */
    C2019c f11312e = null;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public DatastreamSelectListAdapter(ArrayList<BasicSelectMenuBean> arrayList, String str, Context context, boolean z, boolean z2, int i, String str2) {
        this.f11314g = false;
        this.f11315h = null;
        this.f11320m = false;
        this.f11309b = arrayList;
        this.f11317j.clear();
        m7501h();
        this.f11314g = z;
        if (z) {
            this.f11315h = new C2018b();
            Collections.sort(arrayList, this.f11315h);
        }
        this.f11313f = LayoutInflater.from(context);
        if (C1947h.f10559k != -1 && i != C1947h.f10559k && str2.equals("menu")) {
            this.f11320m = true;
        }
        if (str.equals("DataStream") && !z2) {
            if (C1947h.f10558j == null) {
                C1947h.f10558j = arrayList;
            } else {
                if (z) {
                    this.f11315h = new C2018b();
                    Collections.sort(C1947h.f10558j, this.f11315h);
                }
                if (!m7509a(arrayList, C1947h.f10558j)) {
                    C1947h.f10558j = arrayList;
                } else if (this.f11320m) {
                    C1947h.f10558j = arrayList;
                }
            }
            if (C1947h.f10558j != null) {
                if (z) {
                    this.f11315h = new C2018b();
                    Collections.sort(C1947h.f10558j, this.f11315h);
                }
                if (arrayList.size() == C1947h.f10558j.size() && arrayList.get(0).getTitle().equals(C1947h.f10558j.get(0).getTitle())) {
                    String title = arrayList.get(arrayList.size() - 1).getTitle();
                    ArrayList<BasicSelectMenuBean> arrayList2 = C1947h.f10558j;
                    if (title.equals(arrayList2.get(arrayList2.size() - 1).getTitle())) {
                        this.f11309b = C1947h.f10558j;
                    }
                }
            }
        }
        C1947h.f10559k = i;
    }

    /* renamed from: a */
    private static boolean m7509a(ArrayList<BasicSelectMenuBean> arrayList, ArrayList<BasicSelectMenuBean> arrayList2) {
        if (arrayList.size() == arrayList2.size() && arrayList.get(0).getTitle().equals(arrayList2.get(0).getTitle()) && arrayList.get(arrayList.size() - 1).getTitle().equals(arrayList2.get(arrayList2.size() - 1).getTitle()) && arrayList.get(arrayList.size() / 2).getTitle().equals(arrayList2.get(arrayList2.size() / 2).getTitle())) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (!arrayList.get(i).getTitle().equals(arrayList2.get(i).getTitle())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f11309b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f11309b.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f11312e = new C2019c();
            view = this.f11313f.inflate(R.layout.item_grid_select, (ViewGroup) null);
            this.f11312e.f11325b = (TextView) view.findViewById(R.id.tv_list_title);
            this.f11312e.f11326c = (CheckBox) view.findViewById(R.id.cb_list_select);
            view.setTag(this.f11312e);
        } else {
            this.f11312e = (C2019c) view.getTag();
        }
        this.f11312e.f11324a = this.f11309b.get(i).getId();
        this.f11312e.f11325b.setText(this.f11309b.get(i).getTitle());
        this.f11312e.f11326c.setVisibility(0);
        this.f11312e.f11326c.setChecked(m7507b(i));
        this.f11312e.f11326c.setEnabled(false);
        if (this.f11308a && !this.f11310c) {
            this.f11312e.f11326c.setEnabled(true);
            this.f11312e.f11326c.setOnClickListener(new View$OnClickListenerC2020g(this, i));
        }
        view.setId(i);
        return view;
    }

    /* renamed from: a */
    public final boolean m7512a(int i) {
        boolean z = !this.f11309b.get(i).isCheck();
        this.f11309b.get(i).setCheck(z);
        notifyDataSetChanged();
        return z;
    }

    /* compiled from: DatastreamSelectListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.f$c */
    /* loaded from: classes.dex */
    class C2019c {

        /* renamed from: a */
        String f11324a;

        /* renamed from: b */
        TextView f11325b;

        /* renamed from: c */
        CheckBox f11326c;

        C2019c() {
        }
    }

    /* renamed from: b */
    private boolean m7507b(int i) {
        ArrayList<BasicSelectMenuBean> arrayList = this.f11309b;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.f11309b.get(i).isCheck();
    }

    /* renamed from: a */
    public final void m7513a() {
        ArrayList<BasicSelectMenuBean> arrayList = this.f11309b;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.f11309b.size(); i++) {
            this.f11309b.get(i).setCheck(true);
        }
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public final void m7511a(int i, int i2) {
        ArrayList<BasicSelectMenuBean> arrayList = this.f11309b;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        while (i < this.f11309b.size() && i <= i2) {
            this.f11309b.get(i).setCheck(true);
            i++;
        }
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public final void m7508b() {
        ArrayList<BasicSelectMenuBean> arrayList = this.f11309b;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.f11309b.size(); i++) {
            this.f11309b.get(i).setCheck(false);
        }
        notifyDataSetChanged();
    }

    /* renamed from: c */
    public final void m7506c() {
        ArrayList<BasicSelectMenuBean> arrayList = this.f11309b;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.f11309b.size(); i++) {
            this.f11309b.get(i).setCheck(false);
        }
        notifyDataSetChanged();
    }

    /* renamed from: d */
    public final String m7505d() {
        StringBuilder sb = new StringBuilder();
        if (this.f11314g) {
            this.f11315h = new C2017a();
            Collections.sort(this.f11309b, this.f11315h);
        }
        for (int i = 0; i < this.f11309b.size(); i++) {
            sb.append(m7507b(i) ? "1" : "0");
        }
        return sb.toString();
    }

    /* renamed from: e */
    public final int m7504e() {
        int i = 0;
        for (int i2 = 0; i2 < this.f11309b.size(); i2++) {
            i += m7507b(i2) ? 1 : 0;
        }
        return i;
    }

    /* renamed from: f */
    public final ArrayList<String> m7503f() {
        this.f11317j = new ArrayList<>();
        this.f11319l = 0;
        int i = 0;
        while (i < this.f11309b.size()) {
            int num = this.f11309b.get(i).getNum();
            int i2 = i + 1;
            if (this.f11309b.get(i).isCheck()) {
                this.f11319l++;
                this.f11318k.setCharAt(num, '1');
            }
            if (i2 < this.f11309b.size() && this.f11319l == DiagnoseConstants.DATASTREAM_PAGE) {
                this.f11317j.add(this.f11318k.toString());
                this.f11319l = 0;
            } else if (i2 < this.f11309b.size()) {
                i = i2;
            } else if (this.f11318k.toString().contains("1")) {
                this.f11317j.add(this.f11318k.toString());
            }
            m7501h();
            i = i2;
        }
        return this.f11317j;
    }

    /* renamed from: g */
    public final int m7502g() {
        int i = 0;
        for (int i2 = 0; i2 < this.f11309b.size(); i2++) {
            if (this.f11309b.get(i2).isCheck()) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: h */
    private void m7501h() {
        StringBuilder sb = this.f11318k;
        sb.delete(0, sb.length());
        for (int i = 0; i < this.f11309b.size(); i++) {
            this.f11318k.append("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DatastreamSelectListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.f$a */
    /* loaded from: classes.dex */
    public class C2017a implements Comparator<BasicSelectMenuBean> {
        C2017a() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(BasicSelectMenuBean basicSelectMenuBean, BasicSelectMenuBean basicSelectMenuBean2) {
            return basicSelectMenuBean.getNum() - basicSelectMenuBean2.getNum();
        }
    }

    /* compiled from: DatastreamSelectListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.f$b */
    /* loaded from: classes.dex */
    class C2018b implements Comparator<BasicSelectMenuBean> {

        /* renamed from: a */
        RuleBasedCollator f11322a;

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(BasicSelectMenuBean basicSelectMenuBean, BasicSelectMenuBean basicSelectMenuBean2) {
            String title = basicSelectMenuBean.getTitle();
            String title2 = basicSelectMenuBean2.getTitle();
            if (title == null || title2 == null) {
                return 0;
            }
            return this.f11322a.compare(title, title2);
        }

        public C2018b() {
            this.f11322a = null;
            Locale locale = Locale.getDefault();
            if (locale.getCountry().equalsIgnoreCase("CN")) {
                this.f11322a = (RuleBasedCollator) Collator.getInstance(Locale.CHINA);
            } else {
                this.f11322a = (RuleBasedCollator) Collator.getInstance(locale);
            }
        }
    }
}
