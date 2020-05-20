package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.upgrade.AdapterClickListenter;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.k */
/* loaded from: classes.dex */
public class UpgradeAdapter extends BaseExpandableListAdapter {

    /* renamed from: a */
    protected Context f15033a;

    /* renamed from: b */
    protected LayoutInflater f15034b;

    /* renamed from: c */
    protected List<X431PadDtoSoft> f15035c;

    /* renamed from: d */
    protected AdapterClickListenter f15036d;

    /* renamed from: e */
    protected ExpandableListView f15037e;

    /* renamed from: f */
    private C2614b f15038f;

    /* renamed from: g */
    private C2613a f15039g;

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public UpgradeAdapter(Context context, AdapterClickListenter adapterClickListenter) {
        this.f15033a = context;
        this.f15036d = adapterClickListenter;
        this.f15034b = LayoutInflater.from(this.f15033a);
    }

    /* renamed from: a */
    public final void m5808a(ExpandableListView expandableListView) {
        this.f15037e = expandableListView;
    }

    /* compiled from: UpgradeAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.k$b */
    /* loaded from: classes.dex */
    static class C2614b {

        /* renamed from: a */
        CheckBox f15045a;

        /* renamed from: b */
        TextView f15046b;

        /* renamed from: c */
        TextView f15047c;

        /* renamed from: d */
        TextView f15048d;

        /* renamed from: e */
        ImageView f15049e;

        /* renamed from: f */
        RelativeLayout f15050f;

        C2614b() {
        }
    }

    /* renamed from: a */
    public final List<X431PadDtoSoft> m5809a() {
        return this.f15035c;
    }

    /* renamed from: a */
    public final void m5807a(List<X431PadDtoSoft> list) {
        this.f15035c = list;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        List<X431PadDtoSoft> list = this.f15035c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        List<DivisionSoftDto> carDivisionSoftDtoList;
        List<X431PadDtoSoft> list = this.f15035c;
        if (list == null || list.isEmpty() || (carDivisionSoftDtoList = this.f15035c.get(i).getCarDivisionSoftDtoList()) == null) {
            return 0;
        }
        return carDivisionSoftDtoList.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        List<X431PadDtoSoft> list = this.f15035c;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        List<DivisionSoftDto> carDivisionSoftDtoList;
        List<X431PadDtoSoft> list = this.f15035c;
        if (list == null || (carDivisionSoftDtoList = list.get(i).getCarDivisionSoftDtoList()) == null) {
            return null;
        }
        return carDivisionSoftDtoList.get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        X431PadDtoSoft x431PadDtoSoft = this.f15035c.get(i);
        if (view == null) {
            this.f15038f = new C2614b();
            view = this.f15034b.inflate(R.layout.upgrade_list_item, (ViewGroup) null);
            this.f15038f.f15045a = (CheckBox) view.findViewById(R.id.cbox_item);
            this.f15038f.f15046b = (TextView) view.findViewById(R.id.tv_carname_item);
            this.f15038f.f15047c = (TextView) view.findViewById(R.id.tv_curversion_item);
            this.f15038f.f15048d = (TextView) view.findViewById(R.id.tv_upgradeversion_item);
            this.f15038f.f15049e = (ImageView) view.findViewById(R.id.division_expand);
            this.f15038f.f15050f = (RelativeLayout) view.findViewById(R.id.lin_expand);
            view.setTag(this.f15038f);
        } else {
            this.f15038f = (C2614b) view.getTag();
        }
        if (x431PadDtoSoft != null && !x431PadDtoSoft.isMust() && 3 == x431PadDtoSoft.getType()) {
            Drawable drawable = this.f15033a.getResources().getDrawable(R.drawable.down_red_arrow);
            drawable.setBounds(0, 0, 19, 11);
            this.f15038f.f15048d.setCompoundDrawables(null, null, drawable, null);
            this.f15038f.f15048d.setOnClickListener(new View$OnClickListenerC2615l(this, x431PadDtoSoft, i));
        } else {
            this.f15038f.f15048d.setCompoundDrawables(null, null, null, null);
            this.f15038f.f15048d.setOnClickListener(null);
        }
        if (x431PadDtoSoft != null) {
            if (C2744aa.m5166c()) {
                this.f15038f.f15046b.setText(C2744aa.m5170b(this.f15033a, x431PadDtoSoft.getSoftName()));
            } else {
                this.f15038f.f15046b.setText(x431PadDtoSoft.getSoftName());
            }
            this.f15038f.f15047c.setText(x431PadDtoSoft.getMaxOldVersion());
            this.f15038f.f15048d.setText(x431PadDtoSoft.getVersionNo());
            this.f15038f.f15045a.setEnabled(!x431PadDtoSoft.isMust());
            this.f15038f.f15045a.setOnCheckedChangeListener(null);
            this.f15038f.f15045a.setChecked(x431PadDtoSoft.isChecked());
            this.f15038f.f15045a.setOnCheckedChangeListener(new C2616m(this, x431PadDtoSoft));
            this.f15038f.f15050f.setOnClickListener(new View$OnClickListenerC2617n(this, z, i));
            if (x431PadDtoSoft.isHaveDivisions() && !x431PadDtoSoft.getSoftPackageID().startsWith("RESET")) {
                this.f15038f.f15050f.setVisibility(0);
                this.f15038f.f15049e.setImageResource(R.drawable.selector_expand_division);
            } else {
                this.f15038f.f15050f.setVisibility(8);
            }
        }
        this.f15038f.f15049e.setActivated(z);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        DivisionSoftDto divisionSoftDto;
        if (view == null) {
            this.f15039g = new C2613a();
            view = this.f15034b.inflate(R.layout.division_list_item, (ViewGroup) null);
            this.f15039g.f15040a = (CheckBox) view.findViewById(R.id.cbox_item);
            this.f15039g.f15041b = (TextView) view.findViewById(R.id.tv_carname_item);
            this.f15039g.f15042c = (TextView) view.findViewById(R.id.tv_curversion_item);
            this.f15039g.f15043d = (TextView) view.findViewById(R.id.tv_upgradeversion_item);
            this.f15039g.f15044e = (Button) view.findViewById(R.id.division_softDes);
            view.setTag(this.f15039g);
        } else {
            this.f15039g = (C2613a) view.getTag();
        }
        List<DivisionSoftDto> carDivisionSoftDtoList = this.f15035c.get(i).getCarDivisionSoftDtoList();
        if (carDivisionSoftDtoList != null && !carDivisionSoftDtoList.isEmpty() && (divisionSoftDto = carDivisionSoftDtoList.get(i2)) != null) {
            this.f15039g.f15041b.setText(divisionSoftDto.getSpfNameDesc());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f15033a.getString(R.string.cur_version_txt));
            stringBuffer.append(": ");
            if (divisionSoftDto.getMaxOldVersion() == null || divisionSoftDto.getMaxOldVersion().isEmpty()) {
                stringBuffer.append(this.f15033a.getString(R.string.personal_infomation_none));
            } else {
                stringBuffer.append(divisionSoftDto.getMaxOldVersion());
            }
            this.f15039g.f15042c.setText(stringBuffer.toString());
            TextView textView = this.f15039g.f15043d;
            textView.setText(this.f15033a.getString(R.string.division_latest_version_tip) + "V" + divisionSoftDto.getvNum());
            this.f15039g.f15040a.setEnabled(divisionSoftDto.isMust() ^ true);
            this.f15039g.f15040a.setOnCheckedChangeListener(null);
            this.f15039g.f15040a.setChecked(divisionSoftDto.isChecked());
            this.f15039g.f15040a.setOnCheckedChangeListener(new C2618o(this, divisionSoftDto));
            this.f15039g.f15044e.setOnClickListener(new View$OnClickListenerC2619p(this, divisionSoftDto));
        }
        return view;
    }

    /* compiled from: UpgradeAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.k$a */
    /* loaded from: classes.dex */
    static class C2613a {

        /* renamed from: a */
        CheckBox f15040a;

        /* renamed from: b */
        TextView f15041b;

        /* renamed from: c */
        TextView f15042c;

        /* renamed from: d */
        TextView f15043d;

        /* renamed from: e */
        Button f15044e;

        C2613a() {
        }
    }
}
