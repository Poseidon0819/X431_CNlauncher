package com.cnlaunch.x431pro.activity.golo.p224a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.golo.others.GoloTools;
import com.cnlaunch.x431pro.module.golo.model.VerificationInfo;
import com.ifoer.expedition.pro.R;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;
import com.p297e.p298a.p306b.p310c.RoundedBitmapDisplayer;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.golo.a.h */
/* loaded from: classes.dex */
public final class VerificationListAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<VerificationInfo> f12556a;

    /* renamed from: b */
    DisplayImageOptions f12557b;

    /* renamed from: c */
    private LayoutInflater f12558c;

    /* renamed from: d */
    private Context f12559d;

    /* renamed from: e */
    private InterfaceC2232a f12560e;

    /* compiled from: VerificationListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.golo.a.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2232a {
        /* renamed from: a */
        void mo7023a(VerificationInfo verificationInfo);

        /* renamed from: b */
        void mo7022b(VerificationInfo verificationInfo);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public VerificationListAdapter(Context context, InterfaceC2232a interfaceC2232a) {
        this.f12556a = null;
        this.f12560e = null;
        this.f12556a = null;
        List<VerificationInfo> list = this.f12556a;
        if (list != null) {
            Collections.sort(list, new C2233b());
        }
        this.f12559d = context;
        this.f12558c = LayoutInflater.from(context);
        this.f12560e = interfaceC2232a;
        DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
        c3010a.f17117a = R.drawable.ic_golo_logo_default;
        c3010a.f17118b = R.drawable.ic_golo_logo_default;
        c3010a.f17119c = R.drawable.ic_golo_logo_default;
        c3010a.f17124h = true;
        c3010a.f17125i = true;
        c3010a.f17129m = true;
        c3010a.f17133q = new RoundedBitmapDisplayer(5);
        this.f12557b = c3010a.m4193a();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<VerificationInfo> list = this.f12556a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List<VerificationInfo> list = this.f12556a;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C2234c c2234c;
        if (view == null) {
            view = this.f12558c.inflate(R.layout.item_list_verification, (ViewGroup) null);
            c2234c = new C2234c();
            c2234c.f12562a = (TextView) view.findViewById(R.id.tv_name);
            c2234c.f12566e = (ImageView) view.findViewById(R.id.icon);
            c2234c.f12563b = (TextView) view.findViewById(R.id.tv_content);
            c2234c.f12564c = (TextView) view.findViewById(R.id.tv_agree);
            c2234c.f12565d = (TextView) view.findViewById(R.id.tv_refuse);
            view.setTag(c2234c);
        } else {
            c2234c = (C2234c) view.getTag();
        }
        VerificationInfo verificationInfo = this.f12556a.get(i);
        c2234c.f12563b.setText(verificationInfo.f15547d);
        String str = verificationInfo.f15546c;
        TextView textView = c2234c.f12562a;
        if (TextUtils.isEmpty(str)) {
            str = verificationInfo.f15545b;
        }
        textView.setText(str);
        ImageLoader.m4191a().m4185b(GoloTools.m6963a(this.f12559d, verificationInfo.f15545b), c2234c.f12566e, this.f12557b);
        if (this.f12560e != null) {
            c2234c.f12564c.setOnClickListener(new View$OnClickListenerC2235i(this, verificationInfo));
            c2234c.f12565d.setOnClickListener(new View$OnClickListenerC2236j(this, verificationInfo));
        }
        if (verificationInfo.f15549f.intValue() == 0) {
            c2234c.f12565d.setVisibility(0);
            c2234c.f12564c.setVisibility(0);
            c2234c.f12564c.setClickable(true);
            c2234c.f12564c.setTextColor(this.f12559d.getResources().getColor(R.color.white));
            c2234c.f12564c.setBackgroundResource(R.drawable.bg_tip_red);
            c2234c.f12564c.setText(R.string.text_agree);
        } else if (verificationInfo.f15549f.intValue() == 1 || verificationInfo.f15549f.intValue() == 2) {
            c2234c.f12565d.setVisibility(4);
            c2234c.f12564c.setVisibility(4);
        } else {
            c2234c.f12565d.setVisibility(4);
            c2234c.f12564c.setVisibility(0);
            c2234c.f12564c.setClickable(false);
            c2234c.f12564c.setTextColor(this.f12559d.getResources().getColor(R.color.grey_800));
            c2234c.f12564c.setBackgroundResource(R.color.transparent);
            if (verificationInfo.f15549f.intValue() == 3) {
                c2234c.f12564c.setText(R.string.text_agree_already);
            } else {
                c2234c.f12564c.setText(R.string.text_refuse_already);
            }
        }
        return view;
    }

    /* compiled from: VerificationListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.golo.a.h$c */
    /* loaded from: classes.dex */
    class C2234c {

        /* renamed from: a */
        TextView f12562a;

        /* renamed from: b */
        TextView f12563b;

        /* renamed from: c */
        TextView f12564c;

        /* renamed from: d */
        TextView f12565d;

        /* renamed from: e */
        ImageView f12566e;

        C2234c() {
        }
    }

    /* compiled from: VerificationListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.golo.a.h$b */
    /* loaded from: classes.dex */
    public class C2233b implements Comparator<VerificationInfo> {
        public C2233b() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(VerificationInfo verificationInfo, VerificationInfo verificationInfo2) {
            return new Date(verificationInfo.f15548e).before(new Date(verificationInfo2.f15548e)) ? 1 : -1;
        }
    }
}
