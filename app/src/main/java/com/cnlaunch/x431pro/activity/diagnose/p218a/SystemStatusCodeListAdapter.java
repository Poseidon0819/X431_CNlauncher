package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.x431pro.activity.diagnose.p221d.SystemStatusCodeFragment;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.x */
/* loaded from: classes.dex */
public final class SystemStatusCodeListAdapter extends BaseExpandableListAdapter {

    /* renamed from: b */
    public static int f11449b = 1;

    /* renamed from: c */
    public static int f11450c = 2;

    /* renamed from: a */
    public SystemStatusCodeFragment f11451a;

    /* renamed from: f */
    public SerializableMap f11454f;

    /* renamed from: g */
    private LayoutInflater f11455g;

    /* renamed from: h */
    private List<BasicSystemStatusBean> f11456h;

    /* renamed from: i */
    private List<BasicFaultCodeBean> f11457i;

    /* renamed from: j */
    private Context f11458j;

    /* renamed from: k */
    private int f11459k;

    /* renamed from: l */
    private boolean f11460l = false;

    /* renamed from: m */
    private int f11461m = -1;

    /* renamed from: n */
    private int f11462n = -1;

    /* renamed from: d */
    public boolean f11452d = false;

    /* renamed from: e */
    public boolean f11453e = true;

    /* renamed from: o */
    private int[] f11463o = {-1, -1};

    /* renamed from: p */
    private C2037b f11464p = null;

    /* renamed from: q */
    private C2036a f11465q = null;

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    /* compiled from: SystemStatusCodeListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.x$b */
    /* loaded from: classes.dex */
    class C2037b {

        /* renamed from: a */
        TextView f11472a;

        /* renamed from: b */
        TextView f11473b;

        /* renamed from: c */
        TextView f11474c;

        /* renamed from: d */
        LinearLayout f11475d;

        /* renamed from: e */
        TextView f11476e;

        /* renamed from: f */
        LinearLayout f11477f;

        /* renamed from: g */
        TextView f11478g;

        C2037b() {
        }
    }

    /* compiled from: SystemStatusCodeListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.x$a */
    /* loaded from: classes.dex */
    class C2036a {

        /* renamed from: a */
        LinearLayout f11466a;

        /* renamed from: b */
        LinearLayout f11467b;

        /* renamed from: c */
        TextView f11468c;

        /* renamed from: d */
        TextView f11469d;

        /* renamed from: e */
        TextView f11470e;

        C2036a() {
        }
    }

    public SystemStatusCodeListAdapter(Context context, ArrayList<BasicSystemStatusBean> arrayList, int i) {
        this.f11459k = 0;
        this.f11458j = context;
        this.f11456h = arrayList;
        this.f11455g = LayoutInflater.from(context);
        this.f11459k = i;
    }

    /* renamed from: a */
    public static ArrayList<BasicSystemStatusBean> m7476a(ArrayList<BasicSystemStatusBean> arrayList, int i) {
        int i2 = 0;
        if (1 == i) {
            ArrayList<BasicSystemStatusBean> arrayList2 = new ArrayList<>();
            while (i2 < arrayList.size()) {
                if (arrayList.get(i2).getSystemFaultCodeBean() != null && (arrayList.get(i2).getSystemFaultCodeBean() == null || arrayList.get(i2).getSystemFaultCodeBean().size() != 0)) {
                    arrayList2.add(arrayList.get(i2));
                }
                i2++;
            }
            return arrayList2;
        } else if (2 == i) {
            ArrayList<BasicSystemStatusBean> arrayList3 = new ArrayList<>();
            while (i2 < arrayList.size()) {
                if (arrayList.get(i2).getSystemFaultCodeBean() == null || arrayList.get(i2).getSystemFaultCodeBean().size() <= 0) {
                    arrayList3.add(arrayList.get(i2));
                }
                i2++;
            }
            return arrayList3;
        } else {
            return arrayList;
        }
    }

    /* renamed from: b */
    public final void m7475b(ArrayList<BasicSystemStatusBean> arrayList, int i) {
        this.f11456h = m7476a(arrayList, i);
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i, int i2) {
        return this.f11456h.get(i).getSystemFaultCodeBean().get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f11465q = new C2036a();
            view = this.f11455g.inflate(R.layout.item_system_status_sub, (ViewGroup) null);
            this.f11465q.f11468c = (TextView) view.findViewById(R.id.tv_syscontent);
            this.f11465q.f11469d = (TextView) view.findViewById(R.id.tv_system_status);
            this.f11465q.f11467b = (LinearLayout) view.findViewById(R.id.ly_system_help);
            this.f11465q.f11470e = (TextView) view.findViewById(R.id.tv_system_help);
            this.f11465q.f11466a = (LinearLayout) view.findViewById(R.id.layout_fault);
            view.setTag(this.f11465q);
        } else {
            this.f11465q = (C2036a) view.getTag();
        }
        this.f11457i = this.f11456h.get(i).getSystemFaultCodeBean();
        if (this.f11457i != null && this.f11456h.get(i).getSystemFaultCodeBean().size() > 0) {
            String title = this.f11457i.get(i2).getTitle();
            String context = this.f11457i.get(i2).getContext();
            if ("CONSULT HANDBOOK".equals(context)) {
                String string = this.f11458j.getString(R.string.diagnose_consult_handbook);
                TextView textView = this.f11465q.f11468c;
                textView.setText(title + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + string);
            } else {
                SerializableMap serializableMap = this.f11454f;
                if (serializableMap != null && serializableMap.getMap() != null) {
                    String str = this.f11454f.getMap().get(context);
                    if (!TextUtils.isEmpty(str)) {
                        TextView textView2 = this.f11465q.f11468c;
                        textView2.setText(title + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str);
                    } else {
                        TextView textView3 = this.f11465q.f11468c;
                        textView3.setText(title + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + context);
                    }
                } else {
                    TextView textView4 = this.f11465q.f11468c;
                    textView4.setText(title + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + context);
                }
            }
            this.f11465q.f11469d.setText(this.f11457i.get(i2).getStatus());
        }
        int i3 = f11449b;
        int i4 = this.f11459k;
        if (i3 == i4) {
            this.f11465q.f11469d.setTextColor(this.f11458j.getResources().getColor(R.color.red));
            if (this.f11460l) {
                this.f11465q.f11467b.setVisibility(0);
                if (this.f11451a.f12356c) {
                    this.f11465q.f11467b.setEnabled(true);
                    this.f11465q.f11470e.setBackgroundResource(R.drawable.btn_help_normal);
                } else {
                    this.f11465q.f11467b.setEnabled(false);
                    this.f11465q.f11470e.setBackgroundResource(R.drawable.btn_help_disable);
                }
            } else {
                this.f11465q.f11467b.setVisibility(8);
            }
            this.f11465q.f11467b.setOnClickListener(new View$OnClickListenerC2038y(this, i, i2));
        } else if (f11450c == i4) {
            this.f11465q.f11469d.setTextColor(this.f11458j.getResources().getColor(R.color.black));
            this.f11465q.f11467b.setVisibility(8);
        }
        if (this.f11461m == i && this.f11462n == i2) {
            view.setActivated(true);
            this.f11465q.f11466a.setBackgroundColor(this.f11458j.getResources().getColor(R.color.khaki));
        } else {
            view.setActivated(false);
            this.f11465q.f11466a.setBackgroundColor(this.f11458j.getResources().getColor(R.color.grey_100));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i) {
        if (this.f11456h.get(i).getSystemFaultCodeBean() == null || this.f11456h.get(i).getSystemFaultCodeBean().size() <= 0) {
            return 0;
        }
        return this.f11456h.get(i).getSystemFaultCodeBean().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i) {
        return this.f11456h.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        return this.f11456h.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        SystemStatusCodeFragment systemStatusCodeFragment;
        int indexOf;
        if (view == null) {
            this.f11464p = new C2037b();
            view = this.f11455g.inflate(R.layout.item_system_status, (ViewGroup) null);
            this.f11464p.f11472a = (TextView) view.findViewById(R.id.tv_systemname);
            this.f11464p.f11473b = (TextView) view.findViewById(R.id.tv_codenumber);
            this.f11464p.f11474c = (TextView) view.findViewById(R.id.tv_systemstatus);
            this.f11464p.f11477f = (LinearLayout) view.findViewById(R.id.ly_codehelp);
            this.f11464p.f11478g = (TextView) view.findViewById(R.id.tv_codehelp);
            this.f11464p.f11475d = (LinearLayout) view.findViewById(R.id.rightend);
            this.f11464p.f11476e = (TextView) view.findViewById(R.id.btn_diagnose);
            this.f11464p.f11476e.setTypeface(null, 3);
            view.setTag(this.f11464p);
        } else {
            this.f11464p = (C2037b) view.getTag();
        }
        if (this.f11452d) {
            this.f11464p.f11474c.setVisibility(8);
            this.f11464p.f11475d.setVisibility(0);
            this.f11464p.f11475d.setEnabled(this.f11453e);
            this.f11464p.f11476e.setEnabled(this.f11453e);
            this.f11464p.f11475d.setOnClickListener(new View$OnClickListenerC2039z(this, this.f11456h.get(i).getCurrentNum()));
        }
        this.f11464p.f11472a.setText(this.f11456h.get(i).getSystemName());
        int childrenCount = getChildrenCount(i);
        TextView textView = this.f11464p.f11473b;
        textView.setText("( " + childrenCount + " )");
        if (childrenCount == 0 && this.f11452d) {
            this.f11464p.f11473b.setVisibility(8);
        } else {
            this.f11464p.f11473b.setVisibility(0);
        }
        int i2 = f11450c;
        int i3 = this.f11459k;
        if (i2 == i3 || childrenCount == 0) {
            this.f11464p.f11472a.setTextColor(this.f11458j.getResources().getColor(R.color.black));
            this.f11464p.f11473b.setTextColor(this.f11458j.getResources().getColor(R.color.black));
            this.f11464p.f11473b.setVisibility(8);
            this.f11464p.f11474c.setText(this.f11458j.getResources().getString(R.string.tv_status_normal));
            this.f11464p.f11474c.setTextColor(this.f11458j.getResources().getColor(R.color.black));
            if (this.f11460l) {
                this.f11464p.f11477f.setVisibility(0);
            } else {
                this.f11464p.f11477f.setVisibility(8);
            }
        } else if (f11449b == i3) {
            this.f11464p.f11472a.setTextColor(this.f11458j.getResources().getColor(R.color.red));
            this.f11464p.f11473b.setTextColor(this.f11458j.getResources().getColor(R.color.red));
            this.f11464p.f11474c.setTextColor(this.f11458j.getResources().getColor(R.color.red));
            this.f11464p.f11474c.setText(this.f11458j.getResources().getString(R.string.tv_status_abnormal));
            if (this.f11460l) {
                this.f11464p.f11477f.setVisibility(0);
                this.f11464p.f11478g.setText(this.f11458j.getResources().getString(R.string.btn_help));
            } else {
                this.f11464p.f11477f.setVisibility(8);
            }
        }
        if (z && f11449b == this.f11459k) {
            SystemStatusCodeFragment systemStatusCodeFragment2 = this.f11451a;
            if (systemStatusCodeFragment2 != null) {
                systemStatusCodeFragment2.f12267b.add(Integer.valueOf(i));
            }
        } else if (f11449b == this.f11459k && (systemStatusCodeFragment = this.f11451a) != null && (indexOf = systemStatusCodeFragment.f12267b.indexOf(Integer.valueOf(i))) != -1) {
            this.f11451a.f12267b.remove(indexOf);
        }
        return view;
    }

    /* renamed from: a */
    public final void m7478a(int i, int i2) {
        this.f11461m = i;
        this.f11462n = i2;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public final int[] m7479a() {
        int[] iArr = this.f11463o;
        iArr[0] = this.f11461m;
        iArr[1] = this.f11462n;
        return iArr;
    }
}
