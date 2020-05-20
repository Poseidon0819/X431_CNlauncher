package com.cnlaunch.p169im.p172c;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.p175e.OnIMDataListener;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.p224a.FriendsListAdapter;
import com.cnlaunch.x431pro.activity.golo.p225b.OnFaceTouchListener;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.p210a.LoginTools;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshListView;
import com.cnlaunch.x431pro.widget.sortlistview.SideBar;
import com.ifoer.expedition.pro.R;
import java.util.List;
import message.model.ChatRoom;
import message.p378a.MessageParameters;

/* renamed from: com.cnlaunch.im.c.a */
/* loaded from: classes.dex */
public class FriendListFragment extends BaseFragment implements OnIMDataListener {

    /* renamed from: a */
    PullToRefreshListView f9043a;

    /* renamed from: b */
    FriendsListAdapter f9044b = null;

    /* renamed from: c */
    SideBar f9045c = null;

    /* renamed from: d */
    TextView f9046d;

    /* renamed from: e */
    ImageView f9047e;

    /* renamed from: f */
    View f9048f;

    /* renamed from: g */
    private RelativeLayout f9049g;

    /* renamed from: h */
    private LinearLayout f9050h;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.i("Sanda", "------>FriendListFragment onCreateFragmentView");
        View inflate = layoutInflater.inflate(R.layout.im_friends_fragment, viewGroup, false);
        this.f9043a = (PullToRefreshListView) inflate.findViewById(R.id.lv_friend);
        this.f9045c = (SideBar) inflate.findViewById(R.id.sidebar_list);
        this.f9046d = (TextView) inflate.findViewById(R.id.sidebar_show);
        this.f9050h = (LinearLayout) inflate.findViewById(R.id.message_no_read);
        this.f9049g = (RelativeLayout) inflate.findViewById(R.id.btn_message);
        this.f9049g.setOnClickListener(new View$OnClickListenerC1705b(this));
        return inflate;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        FriendsListAdapter friendsListAdapter;
        super.onActivityCreated(bundle);
        StringBuilder sb = new StringBuilder("****onActivityCreated ");
        sb.append(bundle == null);
        Log.i("Sanda", sb.toString());
        this.f9044b = new FriendsListAdapter(this.mContext);
        this.f9043a.setAdapter(this.f9044b);
        C1699a c1699a = new C1699a(this, (byte) 0);
        this.f9043a.setOnItemClickListener(c1699a);
        this.f9043a.setOnRefreshListener(c1699a);
        this.f9044b.f12508c = c1699a;
        ListView listView = (ListView) this.f9043a.getRefreshableView();
        if (listView != null) {
            listView.setOnItemLongClickListener(c1699a);
        }
        this.f9045c.setTextView(this.f9046d);
        this.f9045c.setOnTouchingLetterChangedListener(new C1706c(this));
        boolean z = this.mContext.getResources().getBoolean(R.bool.isTop_search);
        this.f9048f = getActivity().findViewById(R.id.btn_friend_search);
        this.f9048f.setVisibility(z ? 8 : 0);
        this.f9048f.setOnClickListener(new View$OnClickListenerC1707d(this));
        setTitle(R.string.friends);
        IMPresenter.m8804a(getActivity()).m8803a(this);
        List<FriendInfo> m8798a = IMPresenter.m8804a(getActivity()).m8798a(true);
        if (m8798a.size() > 0 && (friendsListAdapter = this.f9044b) != null) {
            friendsListAdapter.m7033a(m8798a);
        }
        if ((!TextUtils.isEmpty(PreferencesManager.m9595a(this.mContext).m9584b("user_id", "")) ? IMPresenter.m8804a(getActivity()).m8794c() : 0) > 0) {
            this.f9050h.setVisibility(0);
        } else {
            this.f9050h.setVisibility(8);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        PullToRefreshListView pullToRefreshListView = this.f9043a;
        if (pullToRefreshListView != null) {
            pullToRefreshListView.requestFocus();
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ImageView imageView = this.f9047e;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        IMPresenter.m8804a(getActivity()).m8796b(this);
    }

    @Override // com.cnlaunch.p169im.p175e.OnIMDataListener
    /* renamed from: a */
    public final void mo6461a(int i) {
        if (isAdded()) {
            if (i == 40021) {
                this.f9043a.m4428i();
                this.f9044b.m7033a(IMPresenter.m8804a(getActivity()).m8798a(false));
            }
            if (IMPresenter.m8804a(getActivity()).m8794c() > 0) {
                this.f9050h.setVisibility(0);
            } else {
                this.f9050h.setVisibility(8);
            }
        }
    }

    /* compiled from: FriendListFragment.java */
    /* renamed from: com.cnlaunch.im.c.a$a */
    /* loaded from: classes.dex */
    class C1699a implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, OnFaceTouchListener, PullToRefreshBase.InterfaceC2936e<ListView> {
        private C1699a() {
        }

        /* synthetic */ C1699a(FriendListFragment friendListFragment, byte b) {
            this();
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i > 0) {
                i--;
            }
            FriendInfo friendInfo = (FriendInfo) FriendListFragment.this.f9044b.getItem(i);
            if (friendInfo.getUserID().equalsIgnoreCase("friend_verification") || friendInfo.getUserID().equalsIgnoreCase("666666")) {
                return false;
            }
            new C1708e(this, friendInfo).m4609a(FriendListFragment.this.mContext, FriendListFragment.this.mContext.getString(R.string.dialog_title_default), FriendListFragment.this.mContext.getString(R.string.make_sure_del_friend, friendInfo.getName()));
            return true;
        }

        @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase.InterfaceC2936e
        /* renamed from: f_ */
        public final void mo4423f_() {
            IMPresenter.m8804a(FriendListFragment.this.getActivity()).m8805a(40021);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (LoginTools.m7945a(FriendListFragment.this.mContext, 0)) {
                if (i > 0) {
                    i--;
                }
                FriendInfo friendInfo = (FriendInfo) FriendListFragment.this.f9044b.getItem(i);
                ChatRoom chatRoom = new ChatRoom(friendInfo.getUser_id(), friendInfo.getNick_name(), MessageParameters.EnumC4721a.single);
                Bundle bundle = new Bundle();
                bundle.putString("otherFaceUrl", friendInfo.getFace_thumb());
                bundle.putParcelable("ChatRoom", chatRoom);
                bundle.putInt("roles", friendInfo.getIntRoles());
                bundle.putInt("launch_model", 0);
                bundle.putBoolean("isFriend", friendInfo.isFriend());
                IMPresenter.m8804a(FriendListFragment.this.getActivity()).m8800a(ProMessageFragment.class.getName(), bundle);
            }
        }

        @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnFaceTouchListener
        /* renamed from: a */
        public final void mo7021a(String str, String str2, boolean z) {
            if (str2.equalsIgnoreCase("friend_verification") || str2.equalsIgnoreCase("666666")) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("target_id", str2);
            bundle.putString("target_name", str);
            bundle.putBoolean("isFriend", z);
            IMPresenter.m8804a(FriendListFragment.this.getActivity()).m8800a(UserDetailFragment.class.getName(), bundle);
        }
    }
}
