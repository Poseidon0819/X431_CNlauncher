package com.cnlaunch.x431pro.activity.setting.p234a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.setting.DiagsoftRewardFragment;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.setting.a.a */
/* loaded from: classes.dex */
public final class DiagsoftRewardAdapter extends BaseAdapter {

    /* renamed from: d */
    private Context f14517d;

    /* renamed from: e */
    private LayoutInflater f14518e;

    /* renamed from: f */
    private C2515a f14519f;

    /* renamed from: g */
    private DiagsoftRewardFragment f14520g;

    /* renamed from: b */
    public boolean f14515b = false;

    /* renamed from: c */
    public int f14516c = 0;

    /* renamed from: a */
    public List<X431PadDtoSoft> f14514a = new ArrayList();

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @SuppressLint({"UseSparseArrays"})
    public DiagsoftRewardAdapter(Context context, DiagsoftRewardFragment diagsoftRewardFragment) {
        this.f14517d = context;
        this.f14520g = diagsoftRewardFragment;
        this.f14518e = LayoutInflater.from(this.f14517d);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<X431PadDtoSoft> list = this.f14514a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List<X431PadDtoSoft> list = this.f14514a;
        if (list == null || list.size() <= i) {
            return null;
        }
        return this.f14514a.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        X431PadDtoSoft x431PadDtoSoft = this.f14514a.get(i);
        if (view == null) {
            this.f14519f = new C2515a();
            view = this.f14518e.inflate(R.layout.diagsoftreward_list_item, (ViewGroup) null);
            this.f14519f.f14521a = (TextView) view.findViewById(R.id.tv_serialNo);
            this.f14519f.f14522b = (TextView) view.findViewById(R.id.tv_vehicle_name);
            this.f14519f.f14523c = (TextView) view.findViewById(R.id.tv_warranty_date);
            this.f14519f.f14524d = (TextView) view.findViewById(R.id.tv_feed_end_date);
            view.setTag(this.f14519f);
        } else {
            this.f14519f = (C2515a) view.getTag();
        }
        if (x431PadDtoSoft != null) {
            this.f14519f.f14521a.setText(PreferencesManager.m9595a(this.f14517d).m9584b("serialNo", ""));
            this.f14519f.f14522b.setText(x431PadDtoSoft.getSoftName());
            if (this.f14515b) {
                this.f14519f.f14523c.setText(DateUtils.m5093a(x431PadDtoSoft.getFreeUseEndTime(), 0 - this.f14516c));
                this.f14519f.f14524d.setText(x431PadDtoSoft.getFreeUseEndTime());
            } else {
                this.f14519f.f14524d.setVisibility(8);
                this.f14519f.f14523c.setText(x431PadDtoSoft.getFreeUseEndTime());
            }
        }
        return view;
    }

    /* compiled from: DiagsoftRewardAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.setting.a.a$a */
    /* loaded from: classes.dex */
    public class C2515a {

        /* renamed from: a */
        public TextView f14521a;

        /* renamed from: b */
        public TextView f14522b;

        /* renamed from: c */
        public TextView f14523c;

        /* renamed from: d */
        public TextView f14524d;

        public C2515a() {
        }
    }
}
