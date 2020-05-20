package com.cnlaunch.x431pro.activity.share.p236a;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.share.a.a */
/* loaded from: classes.dex */
public final class ShareAdapter extends BaseAdapter {

    /* renamed from: a */
    ArrayList<ResolveInfo> f14951a;

    /* renamed from: b */
    private LayoutInflater f14952b;

    /* renamed from: c */
    private Context f14953c;

    /* renamed from: d */
    private C2595a f14954d = null;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public ShareAdapter(ArrayList<ResolveInfo> arrayList, Context context) {
        this.f14951a = null;
        this.f14951a = arrayList;
        this.f14953c = context;
        this.f14952b = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList<ResolveInfo> arrayList = this.f14951a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f14951a.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f14954d = new C2595a();
            view = this.f14952b.inflate(R.layout.item_share, (ViewGroup) null);
            this.f14954d.f14955a = (TextView) view.findViewById(R.id.tv_share);
            this.f14954d.f14957c = (ImageView) view.findViewById(R.id.im_icon);
            view.setTag(this.f14954d);
        } else {
            this.f14954d = (C2595a) view.getTag();
        }
        this.f14954d.f14955a.setText(this.f14951a.get(i).loadLabel(this.f14953c.getPackageManager()));
        this.f14954d.f14956b = this.f14951a.get(i).loadIcon(this.f14953c.getPackageManager());
        this.f14954d.f14957c.setImageDrawable(this.f14954d.f14956b);
        return view;
    }

    /* compiled from: ShareAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.share.a.a$a */
    /* loaded from: classes.dex */
    class C2595a {

        /* renamed from: a */
        TextView f14955a;

        /* renamed from: b */
        Drawable f14956b;

        /* renamed from: c */
        ImageView f14957c;

        C2595a() {
        }
    }
}
