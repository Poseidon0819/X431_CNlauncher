package com.cnlaunch.x431pro.activity.golo.p224a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.golo3.p165g.DateUtil;
import com.cnlaunch.golo3.p165g.UserFaceUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.golo.p225b.OnFaceTouchListener;
import com.cnlaunch.x431pro.module.golo.model.CustomerInfo;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import com.p297e.p298a.p299a.p304b.p305a.C2996b;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;
import com.p297e.p298a.p306b.ImageLoaderConfiguration;
import com.p297e.p298a.p306b.p310c.RoundedBitmapDisplayer;
import com.p297e.p298a.p315c.L;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.cnlaunch.x431pro.activity.golo.a.b */
/* loaded from: classes.dex */
public final class FriendsListAdapter extends BaseAdapter {

    /* renamed from: a */
    DisplayImageOptions f12506a;

    /* renamed from: d */
    private Context f12509d;

    /* renamed from: e */
    private List<FriendInfo> f12510e;

    /* renamed from: g */
    private String f12512g;

    /* renamed from: b */
    ImageLoader f12507b = ImageLoader.m4191a();

    /* renamed from: c */
    public OnFaceTouchListener f12508c = null;

    /* renamed from: f */
    private Handler f12511f = null;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public FriendsListAdapter(Context context) {
        this.f12510e = new ArrayList();
        this.f12512g = "CN";
        this.f12509d = context;
        this.f12510e = null;
        ImageLoaderConfiguration.C3015a c3015a = new ImageLoaderConfiguration.C3015a(context);
        if (c3015a.f17176b != null || c3015a.f17177c != null) {
            L.m4103c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        c3015a.f17178d = 2;
        c3015a.m4177a(4);
        c3015a.m4176a(new C2996b(2097152));
        this.f12507b.m4189a(c3015a.m4178a());
        DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
        c3010a.f17117a = R.drawable.login_default;
        c3010a.f17118b = R.drawable.login_default;
        c3010a.f17119c = R.drawable.login_default;
        c3010a.f17124h = true;
        c3010a.f17125i = true;
        c3010a.f17129m = true;
        c3010a.f17133q = new RoundedBitmapDisplayer(5);
        this.f12506a = c3010a.m4193a();
        this.f12512g = PreferencesManager.m9595a(context).m9591a("current_country");
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<FriendInfo> list = this.f12510e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f12510e.get(i);
    }

    /* renamed from: a */
    public final void m7033a(List<FriendInfo> list) {
        this.f12510e = list;
        List<FriendInfo> list2 = this.f12510e;
        if (list2 != null) {
            Collections.sort(list2, new C2224a());
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C2225b c2225b;
        if (view == null) {
            view = LayoutInflater.from(this.f12509d).inflate(R.layout.item_friends_list, (ViewGroup) null);
            c2225b = new C2225b();
            c2225b.f12515b = (TextView) view.findViewById(R.id.client_username);
            c2225b.f12516c = (TextView) view.findViewById(R.id.tv_signature);
            c2225b.f12514a = (ImageView) view.findViewById(R.id.client_userimage);
            c2225b.f12517d = (TextView) view.findViewById(R.id.last_msg_time);
            c2225b.f12518e = (TextView) view.findViewById(R.id.last_msg_text);
            c2225b.f12519f = (TextView) view.findViewById(R.id.new_msg);
            c2225b.f12520g = (ImageView) view.findViewById(R.id.online_status);
            c2225b.f12521h = (TextView) view.findViewById(R.id.car_name);
            c2225b.f12522i = (ImageView) view.findViewById(R.id.car_icon);
            c2225b.f12523j = (TextView) view.findViewById(R.id.catalog);
            c2225b.f12524k = (LinearLayout) view.findViewById(R.id.lin_newcustomer);
            c2225b.f12525l = (LinearLayout) view.findViewById(R.id.lin_customer);
            c2225b.f12526m = (TextView) view.findViewById(R.id.no_read);
            view.setTag(c2225b);
        } else {
            c2225b = (C2225b) view.getTag();
        }
        c2225b.f12522i.setVisibility(8);
        c2225b.f12520g.setVisibility(8);
        int noRead = this.f12510e.get(i).getNoRead();
        Long lastTime = this.f12510e.get(i).getLastTime();
        if (lastTime != null) {
            c2225b.f12517d.setText(DateUtil.m9145a(lastTime.longValue()));
        } else {
            c2225b.f12517d.setText("");
        }
        c2225b.f12519f.setVisibility(noRead > 0 ? 0 : 8);
        c2225b.f12518e.setText(this.f12510e.get(i).getLastText());
        if (i == m7035a(m7032b(i))) {
            if (noRead > 0 || this.f12510e.get(i).isCarTeam() || this.f12510e.get(i).getUser_id().equalsIgnoreCase("friend_verification")) {
                c2225b.f12523j.setVisibility(8);
            } else {
                c2225b.f12523j.setVisibility(0);
                c2225b.f12523j.setText(this.f12510e.get(i).getSortKey());
            }
        } else {
            c2225b.f12523j.setVisibility(8);
        }
        String nick_name = C2744aa.m5178a(this.f12510e.get(i).getNick_name()) ? this.f12510e.get(i).getNick_name() : this.f12510e.get(i).getUser_name();
        if (CustomerInfo.isNotNull(nick_name)) {
            c2225b.f12515b.setText(nick_name);
        } else {
            c2225b.f12515b.setText(this.f12510e.get(i).getUser_id());
        }
        String signature = this.f12510e.get(i).getSignature();
        if (CustomerInfo.isNotNull(signature)) {
            c2225b.f12516c.setText(signature);
            c2225b.f12516c.setVisibility(0);
        } else {
            c2225b.f12516c.setText("");
            c2225b.f12516c.setVisibility(4);
        }
        if (this.f12510e.get(i).isCarTeam()) {
            c2225b.f12514a.setImageResource(R.drawable.head_cheyunteam);
            c2225b.f12515b.setText(R.string.cheyunteam_name);
        } else if (this.f12510e.get(i).getUser_id().equals("friend_verification")) {
            c2225b.f12514a.setImageResource(R.drawable.verification_info);
            c2225b.f12515b.setText(R.string.friend_verification);
        } else {
            this.f12507b.m4185b(UserFaceUtils.m9114a(this.f12510e.get(i).getUser_id(), null, this.f12512g.equalsIgnoreCase("CN") ? "1" : "2"), c2225b.f12514a, this.f12506a);
        }
        c2225b.f12514a.setOnClickListener(new View$OnClickListenerC2226c(this, i));
        return view;
    }

    /* compiled from: FriendsListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.golo.a.b$b */
    /* loaded from: classes.dex */
    class C2225b {

        /* renamed from: a */
        ImageView f12514a;

        /* renamed from: b */
        TextView f12515b;

        /* renamed from: c */
        TextView f12516c;

        /* renamed from: d */
        TextView f12517d;

        /* renamed from: e */
        TextView f12518e;

        /* renamed from: f */
        TextView f12519f;

        /* renamed from: g */
        ImageView f12520g;

        /* renamed from: h */
        TextView f12521h;

        /* renamed from: i */
        ImageView f12522i;

        /* renamed from: j */
        TextView f12523j;

        /* renamed from: k */
        LinearLayout f12524k;

        /* renamed from: l */
        LinearLayout f12525l;

        /* renamed from: m */
        TextView f12526m;

        C2225b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FriendsListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.golo.a.b$a */
    /* loaded from: classes.dex */
    public class C2224a implements Comparator<FriendInfo> {
        C2224a() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(FriendInfo friendInfo, FriendInfo friendInfo2) {
            FriendInfo friendInfo3 = friendInfo;
            FriendInfo friendInfo4 = friendInfo2;
            int i = 0;
            if (friendInfo3.getSortKey().equals("@") || friendInfo4.getSortKey().equals("#")) {
                i = 1;
            } else if (!friendInfo3.getSortKey().equals("#") && !friendInfo4.getSortKey().equals("@") && friendInfo3.getSortKey().compareTo(friendInfo4.getSortKey()) < 0) {
                i = 1;
            }
            return ((m7029b(friendInfo3) | (m7028c(friendInfo3) | m7030a(friendInfo3))) | i) > ((m7029b(friendInfo4) | (m7028c(friendInfo4) | m7030a(friendInfo4))) | (i ^ 1)) ? -1 : 1;
        }

        /* renamed from: a */
        private static int m7030a(FriendInfo friendInfo) {
            return friendInfo.getNoRead() > 0 ? 4 : 0;
        }

        /* renamed from: b */
        private static int m7029b(FriendInfo friendInfo) {
            return friendInfo.isCarTeam() || friendInfo.getUser_id().equalsIgnoreCase("friend_verification") ? 8 : 0;
        }

        /* renamed from: c */
        private static int m7028c(FriendInfo friendInfo) {
            return TextUtils.isEmpty(friendInfo.getLastText()) ? 0 : 2;
        }
    }

    /* renamed from: a */
    public final int m7035a(int i) {
        for (int i2 = 0; i2 < getCount(); i2++) {
            if (this.f12510e.get(i2).getNoRead() <= 0 && TextUtils.isEmpty(this.f12510e.get(i2).getLastText()) && this.f12510e.get(i2).getSortKey().toUpperCase().charAt(0) == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: b */
    private int m7032b(int i) {
        try {
            return this.f12510e.get(i).getSortKey().toUpperCase().charAt(0);
        } catch (Exception unused) {
            return -1;
        }
    }
}
