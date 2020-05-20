package com.cnlaunch.p169im.p170a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.golo3.p165g.UserFaceUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.p177g.MessageInfo;
import com.cnlaunch.x431pro.activity.golo.p225b.OnFaceTouchListener;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;
import com.p297e.p298a.p306b.p310c.RoundedBitmapDisplayer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.cnlaunch.im.a.t */
/* loaded from: classes.dex */
public final class MessageInfoAdapter extends BaseAdapter {

    /* renamed from: b */
    LayoutInflater f9020b;

    /* renamed from: d */
    DisplayImageOptions f9022d;

    /* renamed from: e */
    String f9023e;

    /* renamed from: g */
    private Context f9025g;

    /* renamed from: a */
    public List<MessageInfo> f9019a = null;

    /* renamed from: c */
    C1694b f9021c = null;

    /* renamed from: f */
    public OnFaceTouchListener f9024f = null;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public MessageInfoAdapter(Context context) {
        this.f9020b = null;
        this.f9022d = null;
        this.f9023e = "1";
        this.f9025g = context;
        this.f9020b = LayoutInflater.from(context);
        DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
        c3010a.f17117a = R.drawable.login_default;
        c3010a.f17118b = R.drawable.login_default;
        c3010a.f17119c = R.drawable.login_default;
        c3010a.f17124h = true;
        c3010a.f17125i = true;
        c3010a.f17129m = true;
        c3010a.f17133q = new RoundedBitmapDisplayer(5);
        this.f9022d = c3010a.m4193a();
        this.f9023e = PreferencesManager.m9595a(context).m9584b("current_country", "CN").equalsIgnoreCase("CN") ? "1" : "2";
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<MessageInfo> list = this.f9019a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f9019a.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f9020b.inflate(R.layout.item_messageinfo_list, (ViewGroup) null);
            this.f9021c = new C1694b();
            this.f9021c.f9027a = (TextView) view.findViewById(R.id.tv_content);
            this.f9021c.f9029c = (TextView) view.findViewById(R.id.tv_name);
            this.f9021c.f9028b = (TextView) view.findViewById(R.id.tv_time);
            this.f9021c.f9031e = (ImageView) view.findViewById(R.id.img_face);
            this.f9021c.f9030d = (TextView) view.findViewById(R.id.no_read);
            this.f9021c.f9032f = (ImageView) view.findViewById(R.id.img_diagtip);
            view.setTag(this.f9021c);
        } else {
            this.f9021c = (C1694b) view.getTag();
        }
        this.f9021c.f9028b.setText(this.f9019a.get(i).f9276h.longValue() <= 0 ? "" : C2744aa.m5190a(this.f9019a.get(i).f9276h.longValue(), "MM-dd HH:mm"));
        if (this.f9019a.get(i).f9273e.intValue() == 1) {
            this.f9021c.f9032f.setVisibility(0);
            TextView textView = this.f9021c.f9027a;
            textView.setText("[" + this.f9025g.getString(R.string.remote_title) + "]" + this.f9019a.get(i).f9275g);
        } else {
            this.f9021c.f9032f.setVisibility(8);
            this.f9021c.f9027a.setText(this.f9019a.get(i).f9275g);
        }
        if (this.f9019a.get(i).f9270b.equalsIgnoreCase("666666")) {
            this.f9021c.f9029c.setText(R.string.cheyunteam_name);
            this.f9021c.f9031e.setImageResource(R.drawable.head_cheyunteam);
        } else if (this.f9019a.get(i).f9270b.equalsIgnoreCase("friend_verification")) {
            this.f9021c.f9029c.setText(R.string.friend_verification);
            this.f9021c.f9031e.setImageResource(R.drawable.verification_info);
        } else {
            String str = this.f9019a.get(i).f9271c;
            TextView textView2 = this.f9021c.f9029c;
            if (TextUtils.isEmpty(str)) {
                str = this.f9019a.get(i).f9270b;
            }
            textView2.setText(str);
            ImageLoader.m4191a().m4185b(UserFaceUtils.m9114a(this.f9019a.get(i).f9270b, null, this.f9023e), this.f9021c.f9031e, this.f9022d);
        }
        this.f9021c.f9031e.setOnClickListener(new View$OnClickListenerC1695u(this, i));
        if (this.f9019a.get(i).f9272d.intValue() > 0) {
            this.f9021c.f9030d.setVisibility(0);
            this.f9021c.f9030d.setText("");
        } else {
            this.f9021c.f9030d.setVisibility(8);
        }
        return view;
    }

    /* compiled from: MessageInfoAdapter.java */
    /* renamed from: com.cnlaunch.im.a.t$b */
    /* loaded from: classes.dex */
    class C1694b {

        /* renamed from: a */
        TextView f9027a;

        /* renamed from: b */
        TextView f9028b;

        /* renamed from: c */
        TextView f9029c;

        /* renamed from: d */
        TextView f9030d;

        /* renamed from: e */
        ImageView f9031e;

        /* renamed from: f */
        ImageView f9032f;

        C1694b() {
        }
    }

    /* renamed from: a */
    public final void m8884a(List<MessageInfo> list) {
        this.f9019a = list;
        if (list != null) {
            Collections.sort(list, new C1693a());
        }
        notifyDataSetChanged();
    }

    /* compiled from: MessageInfoAdapter.java */
    /* renamed from: com.cnlaunch.im.a.t$a */
    /* loaded from: classes.dex */
    class C1693a implements Comparator<MessageInfo> {
        C1693a() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(MessageInfo messageInfo, MessageInfo messageInfo2) {
            MessageInfo messageInfo3 = messageInfo;
            MessageInfo messageInfo4 = messageInfo2;
            int i = messageInfo3.f9276h.longValue() > messageInfo4.f9276h.longValue() ? 1 : 0;
            return (m8882a(messageInfo3) | i) > (m8882a(messageInfo4) | (i ^ 1)) ? -1 : 1;
        }

        /* renamed from: a */
        private static int m8882a(MessageInfo messageInfo) {
            return messageInfo.f9270b.equalsIgnoreCase("666666") ? 8 : 0;
        }
    }
}
