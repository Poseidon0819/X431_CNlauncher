package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.upgrade.AdapterClickListenter;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.a */
/* loaded from: classes.dex */
public final class DivisionSoftAdapter extends BaseAdapter {

    /* renamed from: a */
    private Context f14990a;

    /* renamed from: b */
    private LayoutInflater f14991b;

    /* renamed from: c */
    private List<DivisionSoftDto> f14992c;

    /* renamed from: d */
    private AdapterClickListenter f14993d;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public DivisionSoftAdapter(Context context, AdapterClickListenter adapterClickListenter) {
        this.f14990a = context;
        this.f14991b = LayoutInflater.from(this.f14990a);
        this.f14993d = adapterClickListenter;
    }

    /* compiled from: DivisionSoftAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.a$a */
    /* loaded from: classes.dex */
    static class C2603a {

        /* renamed from: a */
        CheckBox f14994a;

        /* renamed from: b */
        TextView f14995b;

        /* renamed from: c */
        TextView f14996c;

        /* renamed from: d */
        TextView f14997d;

        /* renamed from: e */
        Button f14998e;

        C2603a() {
        }
    }

    /* renamed from: a */
    public final void m5813a(List<DivisionSoftDto> list) {
        this.f14992c = list;
        this.f14993d.mo4708a();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<DivisionSoftDto> list = this.f14992c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f14992c.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C2603a c2603a;
        DivisionSoftDto divisionSoftDto = (DivisionSoftDto) getItem(i);
        if (view == null) {
            c2603a = new C2603a();
            view2 = this.f14991b.inflate(R.layout.thesoft_division_list_item, (ViewGroup) null);
            c2603a.f14994a = (CheckBox) view2.findViewById(R.id.cbox_item);
            c2603a.f14995b = (TextView) view2.findViewById(R.id.tv_carname_item);
            c2603a.f14996c = (TextView) view2.findViewById(R.id.tv_curversion_item);
            c2603a.f14997d = (TextView) view2.findViewById(R.id.tv_upgradeversion_item);
            c2603a.f14998e = (Button) view2.findViewById(R.id.division_softDes);
            view2.setTag(c2603a);
        } else {
            view2 = view;
            c2603a = (C2603a) view.getTag();
        }
        if (divisionSoftDto != null) {
            c2603a.f14995b.setText(divisionSoftDto.getSpfNameDesc());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f14990a.getString(R.string.cur_version_txt));
            stringBuffer.append(": ");
            if (divisionSoftDto.getMaxOldVersion() == null || divisionSoftDto.getMaxOldVersion().isEmpty()) {
                stringBuffer.append(this.f14990a.getString(R.string.personal_infomation_none));
            } else {
                stringBuffer.append(divisionSoftDto.getMaxOldVersion());
            }
            c2603a.f14996c.setText(stringBuffer.toString());
            TextView textView = c2603a.f14997d;
            textView.setText(this.f14990a.getString(R.string.division_latest_version_tip) + "V" + divisionSoftDto.getvNum());
            c2603a.f14994a.setEnabled(divisionSoftDto.isMust() ^ true);
            c2603a.f14994a.setOnCheckedChangeListener(null);
            c2603a.f14994a.setChecked(divisionSoftDto.isChecked());
            c2603a.f14994a.setOnCheckedChangeListener(new C2604b(this, divisionSoftDto));
            c2603a.f14998e.setOnClickListener(new View$OnClickListenerC2605c(this, divisionSoftDto));
        }
        return view2;
    }
}
