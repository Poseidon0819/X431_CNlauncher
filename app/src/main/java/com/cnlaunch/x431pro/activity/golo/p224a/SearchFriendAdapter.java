package com.cnlaunch.x431pro.activity.golo.p224a;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.golo3.p165g.UserFaceUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.p172c.SearchFriendFragment;
import com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo;
import com.cnlaunch.x431pro.activity.golo.p225b.OnFaceTouchListener;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;
import com.p297e.p298a.p306b.p310c.RoundedBitmapDisplayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.golo.a.d */
/* loaded from: classes.dex */
public final class SearchFriendAdapter extends BaseAdapter {

    /* renamed from: a */
    DisplayImageOptions f12530a;

    /* renamed from: e */
    Handler f12534e;

    /* renamed from: h */
    private Context f12537h;

    /* renamed from: i */
    private String f12538i;

    /* renamed from: b */
    public List<InfaceItemInfo> f12531b = new ArrayList();

    /* renamed from: c */
    public List<InfaceItemInfo> f12532c = new ArrayList();

    /* renamed from: d */
    public List<InfaceItemInfo> f12533d = new ArrayList();

    /* renamed from: f */
    public SearchFriendFragment f12535f = null;

    /* renamed from: g */
    public OnFaceTouchListener f12536g = null;

    /* renamed from: a */
    private static int m7027a(int i) {
        return i != 2 ? R.string.search_from_local : R.string.search_from_network;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public SearchFriendAdapter(Context context, Handler handler) {
        this.f12534e = null;
        this.f12538i = "CN";
        this.f12537h = context;
        DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
        c3010a.f17117a = R.drawable.login_default;
        c3010a.f17118b = R.drawable.login_default;
        c3010a.f17119c = R.drawable.login_default;
        c3010a.f17124h = true;
        c3010a.f17125i = true;
        c3010a.f17129m = true;
        c3010a.f17133q = new RoundedBitmapDisplayer(5);
        this.f12530a = c3010a.m4193a();
        List<InfaceItemInfo> list = this.f12531b;
        if (list != null) {
            Collections.sort(list, new C2227a());
        }
        this.f12534e = handler;
        this.f12538i = PreferencesManager.m9595a(context).m9591a("current_country");
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<InfaceItemInfo> list = this.f12531b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f12531b.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C2228b c2228b;
        if (view == null) {
            view = LayoutInflater.from(this.f12537h).inflate(R.layout.item_golo_searchfriend, (ViewGroup) null);
            c2228b = new C2228b();
            c2228b.f12540a = (ImageView) view.findViewById(R.id.img_face);
            c2228b.f12542c = (TextView) view.findViewById(R.id.tv_name);
            c2228b.f12543d = (TextView) view.findViewById(R.id.tv_signature);
            c2228b.f12544e = view.findViewById(R.id.linear_letter);
            c2228b.f12545f = (TextView) view.findViewById(R.id.title_letter);
            c2228b.f12546g = view.findViewById(R.id.title_letter_padding);
            c2228b.f12547h = (TextView) view.findViewById(R.id.tip_readly);
            c2228b.f12548i = (TextView) view.findViewById(R.id.btn_remote_diag);
            c2228b.f12541b = (ImageView) view.findViewById(R.id.img_sex);
            view.setTag(c2228b);
        } else {
            c2228b = (C2228b) view.getTag();
        }
        if (i == 0) {
            c2228b.f12544e.setVisibility(0);
            c2228b.f12546g.setVisibility(8);
            c2228b.f12545f.setText(m7027a(this.f12531b.get(i).getSrcType()));
        } else if (i > 0 && this.f12531b.get(i).getSrcType() != this.f12531b.get(i - 1).getSrcType() && this.f12531b.get(i).getSrcType() == 2) {
            c2228b.f12544e.setVisibility(0);
            c2228b.f12546g.setVisibility(0);
            c2228b.f12545f.setText(m7027a(this.f12531b.get(i).getSrcType()));
        } else {
            c2228b.f12544e.setVisibility(8);
        }
        ImageLoader.m4191a().m4185b(UserFaceUtils.m9114a(this.f12531b.get(i).getUserID(), null, this.f12538i.equalsIgnoreCase("CN") ? "1" : "2"), c2228b.f12540a, this.f12530a);
        c2228b.f12542c.setText(this.f12531b.get(i).getName());
        c2228b.f12543d.setText(this.f12531b.get(i).getSignature());
        if (this.f12531b.get(i).getSex() != null) {
            c2228b.f12541b.setVisibility(0);
            c2228b.f12541b.setImageResource(this.f12531b.get(i).getSex().intValue() == 1 ? R.drawable.sex_boy : R.drawable.sex_gril);
        } else {
            c2228b.f12541b.setVisibility(8);
        }
        if (C2744aa.m5166c()) {
            c2228b.f12548i.setVisibility(0);
            c2228b.f12547h.setVisibility(8);
            c2228b.f12548i.setOnClickListener(new View$OnClickListenerC2229e(this, i));
        } else if (this.f12531b.get(i).isFriend()) {
            c2228b.f12547h.setClickable(false);
            c2228b.f12547h.setTextColor(this.f12537h.getResources().getColor(R.color.grey_800));
            c2228b.f12547h.setBackgroundResource(R.color.transparent);
            c2228b.f12547h.setText(R.string.add_readly);
        } else if (this.f12531b.get(i).getSrcType() == 0) {
            c2228b.f12547h.setClickable(false);
            c2228b.f12547h.setTextColor(this.f12537h.getResources().getColor(R.color.grey_800));
            c2228b.f12547h.setBackgroundResource(R.color.transparent);
            c2228b.f12547h.setText(R.string.mine_already_bind);
        } else {
            c2228b.f12547h.setText(R.string.add);
            c2228b.f12547h.setTextColor(this.f12537h.getResources().getColor(R.color.white));
            c2228b.f12547h.setBackgroundResource(R.drawable.bg_tip_red);
            c2228b.f12547h.setClickable(true);
            c2228b.f12547h.setOnClickListener(new View$OnClickListenerC2230f(this, i));
        }
        c2228b.f12540a.setOnClickListener(new View$OnClickListenerC2231g(this, i));
        return view;
    }

    /* compiled from: SearchFriendAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.golo.a.d$b */
    /* loaded from: classes.dex */
    class C2228b {

        /* renamed from: a */
        ImageView f12540a;

        /* renamed from: b */
        ImageView f12541b;

        /* renamed from: c */
        TextView f12542c;

        /* renamed from: d */
        TextView f12543d;

        /* renamed from: e */
        View f12544e;

        /* renamed from: f */
        TextView f12545f;

        /* renamed from: g */
        View f12546g;

        /* renamed from: h */
        TextView f12547h;

        /* renamed from: i */
        TextView f12548i;

        C2228b() {
        }
    }

    /* compiled from: SearchFriendAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.golo.a.d$a */
    /* loaded from: classes.dex */
    public class C2227a implements Comparator<InfaceItemInfo> {
        public C2227a() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(InfaceItemInfo infaceItemInfo, InfaceItemInfo infaceItemInfo2) {
            return infaceItemInfo.getSrcType() < infaceItemInfo2.getSrcType() ? -1 : 1;
        }
    }
}
