package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.upgrade.AdapterClickListenter;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.g */
/* loaded from: classes.dex */
public final class ExpiredAdapter extends UpgradeAdapter {

    /* renamed from: f */
    private C2609a f15017f;

    public ExpiredAdapter(Context context, AdapterClickListenter adapterClickListenter) {
        super(context, adapterClickListenter);
    }

    /* compiled from: ExpiredAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.g$a */
    /* loaded from: classes.dex */
    static class C2609a {

        /* renamed from: a */
        CheckBox f15018a;

        /* renamed from: b */
        TextView f15019b;

        /* renamed from: c */
        TextView f15020c;

        /* renamed from: d */
        TextView f15021d;

        /* renamed from: e */
        TextView f15022e;

        /* renamed from: f */
        ImageView f15023f;

        /* renamed from: g */
        RelativeLayout f15024g;

        C2609a() {
        }
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter, android.widget.ExpandableListAdapter
    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        X431PadDtoSoft x431PadDtoSoft = this.f15035c.get(i);
        if (view == null) {
            this.f15017f = new C2609a();
            view = this.f15034b.inflate(R.layout.expired_list_item, (ViewGroup) null);
            this.f15017f.f15018a = (CheckBox) view.findViewById(R.id.cbox_item);
            this.f15017f.f15019b = (TextView) view.findViewById(R.id.tv_carname_item);
            this.f15017f.f15020c = (TextView) view.findViewById(R.id.tv_curversion_item);
            this.f15017f.f15021d = (TextView) view.findViewById(R.id.tv_upgradeversion_item);
            this.f15017f.f15022e = (TextView) view.findViewById(R.id.tv_expired_item);
            this.f15017f.f15023f = (ImageView) view.findViewById(R.id.division_expand);
            this.f15017f.f15024g = (RelativeLayout) view.findViewById(R.id.lin_expand);
            view.setTag(this.f15017f);
        } else {
            this.f15017f = (C2609a) view.getTag();
        }
        if (x431PadDtoSoft != null && !x431PadDtoSoft.isMust() && 3 == x431PadDtoSoft.getType()) {
            Drawable drawable = this.f15033a.getResources().getDrawable(R.drawable.down_red_arrow);
            drawable.setBounds(0, 0, 19, 11);
            this.f15017f.f15021d.setCompoundDrawables(null, null, drawable, null);
            this.f15017f.f15021d.setOnClickListener(new View$OnClickListenerC2610h(this, x431PadDtoSoft, i));
        } else {
            this.f15017f.f15021d.setCompoundDrawables(null, null, null, null);
            this.f15017f.f15021d.setOnClickListener(null);
        }
        if (x431PadDtoSoft != null) {
            this.f15017f.f15019b.setText(x431PadDtoSoft.getSoftName());
            this.f15017f.f15020c.setText(x431PadDtoSoft.getMaxOldVersion());
            this.f15017f.f15021d.setText(x431PadDtoSoft.getVersionNo());
            this.f15017f.f15018a.setEnabled(!x431PadDtoSoft.isMust());
            this.f15017f.f15018a.setOnCheckedChangeListener(null);
            this.f15017f.f15018a.setChecked(x431PadDtoSoft.isChecked());
            this.f15017f.f15018a.setOnCheckedChangeListener(new C2611i(this, x431PadDtoSoft));
            if (x431PadDtoSoft.getExpired()) {
                Drawable drawable2 = view.getResources().getDrawable(R.drawable.expired_normal);
                drawable2.setBounds(0, 0, 50, 50);
                this.f15017f.f15022e.setCompoundDrawables(drawable2, null, null, null);
            } else {
                this.f15017f.f15022e.setCompoundDrawables(null, null, null, null);
            }
            this.f15017f.f15024g.setOnClickListener(new View$OnClickListenerC2612j(this, z, i));
            if (x431PadDtoSoft.isHaveDivisions() && !x431PadDtoSoft.getSoftPackageID().startsWith("RESET")) {
                this.f15017f.f15024g.setVisibility(0);
                this.f15017f.f15023f.setImageResource(R.drawable.selector_expand_division);
            } else {
                this.f15017f.f15024g.setVisibility(8);
            }
        }
        this.f15017f.f15023f.setActivated(z);
        return view;
    }
}
