package com.cnlaunch.p169im.p172c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.p170a.MessageInfoAdapter;
import com.cnlaunch.p169im.p175e.OnIMDataListener;
import com.cnlaunch.p169im.p177g.MessageInfo;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.p225b.OnFaceTouchListener;
import com.cnlaunch.x431pro.p210a.LoginTools;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshListView;
import com.ifoer.expedition.pro.R;
import java.util.List;
import message.model.ChatRoom;
import message.p378a.MessageParameters;

/* renamed from: com.cnlaunch.im.c.f */
/* loaded from: classes.dex */
public class MessageListFragment extends BaseFragment implements OnIMDataListener {

    /* renamed from: a */
    PullToRefreshListView f9086a;

    /* renamed from: b */
    MessageInfoAdapter f9087b = null;

    /* renamed from: c */
    LinearLayout f9088c;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.im_message_fragment, viewGroup, false);
        this.f9086a = (PullToRefreshListView) inflate.findViewById(R.id.lv_message);
        this.f9088c = (LinearLayout) inflate.findViewById(R.id.btn_friend);
        this.f9088c.setOnClickListener(new View$OnClickListenerC1710g(this));
        return inflate;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        PullToRefreshListView pullToRefreshListView = this.f9086a;
        if (pullToRefreshListView != null) {
            pullToRefreshListView.requestFocus();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f9087b = new MessageInfoAdapter(getActivity());
        this.f9086a.setAdapter(this.f9087b);
        C1709a c1709a = new C1709a(this, (byte) 0);
        this.f9086a.setOnItemClickListener(c1709a);
        this.f9086a.setOnRefreshListener(c1709a);
        this.f9087b.f9024f = c1709a;
        ListView listView = (ListView) this.f9086a.getRefreshableView();
        if (listView != null) {
            listView.setOnItemLongClickListener(c1709a);
        }
        setTitle(R.string.title_message);
        IMPresenter.m8804a(getActivity()).m8803a(this);
        List<MessageInfo> m8797b = IMPresenter.m8804a(getActivity()).m8797b();
        if (this.f9087b == null || m8797b.size() <= 0) {
            return;
        }
        this.f9087b.m8884a(m8797b);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        IMPresenter.m8804a(getActivity()).m8796b(this);
    }

    @Override // com.cnlaunch.p169im.p175e.OnIMDataListener
    /* renamed from: a */
    public final void mo6461a(int i) {
        MessageInfoAdapter messageInfoAdapter;
        PullToRefreshListView pullToRefreshListView;
        if (isAdded()) {
            if (i == 40029 || i == 40030 || i == 40028) {
                this.f9086a.m4428i();
                this.f9087b.m8884a(IMPresenter.m8804a(getActivity()).m8797b());
                return;
            }
            if (i == 40032 && (messageInfoAdapter = this.f9087b) != null && (pullToRefreshListView = this.f9086a) != null) {
                pullToRefreshListView.setAdapter(messageInfoAdapter);
            }
            if (i == 40025) {
                this.f9086a.m4428i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageListFragment.java */
    /* renamed from: com.cnlaunch.im.c.f$a */
    /* loaded from: classes.dex */
    public class C1709a implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, OnFaceTouchListener, PullToRefreshBase.InterfaceC2936e<ListView> {
        private C1709a() {
        }

        /* synthetic */ C1709a(MessageListFragment messageListFragment, byte b) {
            this();
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i > 0) {
                i--;
            }
            MessageInfo messageInfo = (MessageInfo) MessageListFragment.this.f9087b.getItem(i);
            if (messageInfo.f9270b.equalsIgnoreCase("666666")) {
                return false;
            }
            MessageDialog messageDialog = new MessageDialog(MessageListFragment.this.mContext, (int) R.string.dialog_title_default, (int) R.string.is_del_message, false, (byte) 0);
            messageDialog.m4719a(R.string.remote_dialog_y, true, new View$OnClickListenerC1711h(this, messageInfo));
            messageDialog.m4717b(R.string.remote_dialog_n, true, new View$OnClickListenerC1712i(this));
            messageDialog.show();
            return true;
        }

        @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase.InterfaceC2936e
        /* renamed from: f_ */
        public final void mo4423f_() {
            IMPresenter.m8804a(MessageListFragment.this.getActivity()).m8805a(40025);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (LoginTools.m7945a(MessageListFragment.this.mContext, 0)) {
                if (i > 0) {
                    i--;
                }
                MessageInfo messageInfo = (MessageInfo) MessageListFragment.this.f9087b.getItem(i);
                IMPresenter.m8804a(MessageListFragment.this.mContext).m8802a(messageInfo);
                if (messageInfo.f9270b.equalsIgnoreCase("friend_verification")) {
                    IMPresenter.m8804a(MessageListFragment.this.getActivity()).m8800a(VerificationFragment.class.getName(), (Bundle) null);
                    return;
                }
                ChatRoom chatRoom = new ChatRoom(messageInfo.f9270b, messageInfo.f9271c, MessageParameters.EnumC4721a.single);
                Bundle bundle = new Bundle();
                bundle.putParcelable("ChatRoom", chatRoom);
                bundle.putInt("launch_model", 0);
                IMPresenter.m8804a(MessageListFragment.this.mContext).m8800a(ProMessageFragment.class.getName(), bundle);
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
            IMPresenter.m8804a(MessageListFragment.this.getActivity()).m8800a(UserDetailFragment.class.getName(), bundle);
        }
    }

    /* renamed from: a */
    public final void m8859a(String str) {
        List<MessageInfo> list;
        MessageInfoAdapter messageInfoAdapter = this.f9087b;
        if (messageInfoAdapter == null || (list = messageInfoAdapter.f9019a) == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i).f9270b)) {
                list.get(i).f9275g = "";
                this.f9087b.notifyDataSetChanged();
            }
        }
    }
}
