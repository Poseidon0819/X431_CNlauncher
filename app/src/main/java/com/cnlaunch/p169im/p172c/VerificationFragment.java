package com.cnlaunch.p169im.p172c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.p173d.NoticeMessageHandler;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p174db.VerificationInfoDao;
import com.cnlaunch.p169im.p177g.MessageInfo;
import com.cnlaunch.p169im.p180j.SendMessageTask;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.others.GoloTools;
import com.cnlaunch.x431pro.activity.golo.p224a.VerificationListAdapter;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.module.golo.model.VerificationInfo;
import com.cnlaunch.x431pro.module.golo.p262a.FriendAction;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.User;
import com.ifoer.expedition.pro.R;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import message.model.ChatMessage;
import message.model.ChatRoom;
import message.p378a.MessageParameters;

/* renamed from: com.cnlaunch.im.c.ad */
/* loaded from: classes.dex */
public class VerificationFragment extends BaseFragment {

    /* renamed from: b */
    private ListView f9072b;

    /* renamed from: c */
    private VerificationListAdapter f9073c;

    /* renamed from: e */
    private TextView f9075e;

    /* renamed from: d */
    private String f9074d = "";

    /* renamed from: a */
    FriendAction f9071a = null;

    /* renamed from: f */
    private VerificationInfo f9076f = null;

    /* renamed from: g */
    private VerificationListAdapter.InterfaceC2232a f9077g = new C1704af(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.golo_verication_fragment, viewGroup, false);
        this.f9072b = (ListView) inflate.findViewById(R.id.search_listview);
        this.f9075e = (TextView) inflate.findViewById(R.id.im_clear);
        this.f9075e.setOnClickListener(new View$OnClickListenerC1703ae(this));
        return inflate;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        GoloLightManager.m8495c();
        if (bundle == null) {
            setTitle(R.string.friend_verification);
            this.f9073c = new VerificationListAdapter(getActivity(), this.f9077g);
            this.f9072b.setAdapter((ListAdapter) this.f9073c);
            this.f9072b.setOnItemClickListener(new C1702a());
        }
        this.f9071a = new FriendAction(getActivity());
        User user = (User) PreferencesManager.m9595a((Context) getActivity()).m9593a(User.class);
        if (user != null) {
            this.f9074d = user.getNick_name();
        }
        request(40026);
        NoticeMessageHandler.m8784a(this.mContext).m8779a("-999");
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 40026:
                String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("user_id");
                GoloDBManager m8756a = GoloDBManager.m8756a(getActivity());
                QueryBuilder<VerificationInfo> queryBuilder = m8756a.f9220b.f9227d.queryBuilder();
                queryBuilder.where(VerificationInfoDao.Properties.IsRead.m321eq(Boolean.FALSE), new WhereCondition[0]);
                queryBuilder.where(VerificationInfoDao.Properties.Bind_ID.m321eq(m9591a), new WhereCondition[0]);
                List<VerificationInfo> list = queryBuilder.list();
                if (list != null && list.size() > 0) {
                    for (VerificationInfo verificationInfo : list) {
                        verificationInfo.f15551h = true;
                    }
                    m8756a.f9220b.f9227d.updateInTx(list);
                    list.size();
                }
                QueryBuilder<VerificationInfo> queryBuilder2 = GoloDBManager.m8756a(getActivity()).f9220b.f9227d.queryBuilder();
                queryBuilder2.where(VerificationInfoDao.Properties.Bind_ID.m321eq(m9591a), new WhereCondition[0]);
                List<VerificationInfo> list2 = queryBuilder2.list();
                for (MessageInfo messageInfo : IMPresenter.m8804a(getActivity()).m8797b()) {
                    if (messageInfo.f9270b.equalsIgnoreCase("friend_verification")) {
                        IMPresenter.m8804a(this.mContext).m8802a(messageInfo);
                    }
                }
                return list2;
            case 40027:
                VerificationInfo verificationInfo2 = this.f9076f;
                if (verificationInfo2 != null) {
                    return this.f9071a.m5319j(verificationInfo2.f15545b);
                }
                return null;
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        switch (i) {
            case 40026:
                List<VerificationInfo> list = (List) obj;
                VerificationListAdapter verificationListAdapter = this.f9073c;
                if (verificationListAdapter != null) {
                    verificationListAdapter.f12556a = list;
                    if (list != null) {
                        Collections.sort(list, new VerificationListAdapter.C2233b());
                    }
                    verificationListAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            case 40027:
                if (obj != null && ((BaseResponse) obj).getCode() == 0) {
                    this.f9076f.f15549f = 3;
                    GoloDBManager m8756a = GoloDBManager.m8756a(getActivity());
                    VerificationInfo verificationInfo = this.f9076f;
                    QueryBuilder<VerificationInfo> queryBuilder = m8756a.f9220b.f9227d.queryBuilder();
                    queryBuilder.where(VerificationInfoDao.Properties.User_id.m321eq(verificationInfo.f15545b), new WhereCondition[0]);
                    List<VerificationInfo> list2 = queryBuilder.list();
                    if (list2 != null && list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            list2.get(i2).f15549f = 3;
                            m8756a.f9220b.f9227d.update(list2.get(i2));
                        }
                    }
                    if (GoloDBManager.m8756a(ApplicationConfig.f7802a).m8755a(this.f9076f.f15545b) == null) {
                        FriendInfo friendInfo = new FriendInfo();
                        friendInfo.setUser_id(this.f9076f.f15545b);
                        friendInfo.setNick_name(this.f9076f.f15546c);
                        friendInfo.setFace_thumb(this.f9076f.f15550g);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(friendInfo);
                        GoloTools.m6961a(arrayList);
                        GoloDBManager.m8756a(ApplicationConfig.f7802a).f9220b.f9226c.insert(friendInfo);
                        IMPresenter.m8804a(ApplicationConfig.f7802a).f9184f = GoloDBManager.m8756a(ApplicationConfig.f7802a).m8757a();
                        IMPresenter.m8804a(ApplicationConfig.f7802a).m8792d(40021);
                    }
                    m8865a(this.f9076f.f15545b, this.f9076f.f15546c, this.mContext.getResources().getString(R.string.accpet_you_friend_request, this.f9074d), true);
                    request(40026);
                    return;
                }
                break;
        }
        super.onSuccess(i, obj);
    }

    /* compiled from: VerificationFragment.java */
    /* renamed from: com.cnlaunch.im.c.ad$a */
    /* loaded from: classes.dex */
    class C1702a implements AdapterView.OnItemClickListener {
        C1702a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            VerificationInfo verificationInfo = (VerificationInfo) VerificationFragment.this.f9073c.getItem(i);
            Bundle bundle = new Bundle();
            bundle.putString("target_id", verificationInfo.f15545b);
            bundle.putString("target_name", verificationInfo.f15546c);
            if (verificationInfo.f15549f.intValue() == 3 || verificationInfo.f15549f.intValue() == 1) {
                bundle.putBoolean("isFriend", true);
            } else {
                bundle.putBoolean("isFriend", false);
            }
            IMPresenter.m8804a(VerificationFragment.this.getActivity()).m8800a(UserDetailFragment.class.getName(), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8865a(String str, String str2, String str3, boolean z) {
        ChatMessage m190a = new ChatRoom(str, str2, MessageParameters.EnumC4721a.single).m190a(9);
        m190a.m210b(z ? 1 : 2);
        m190a.m214a("text", (Object) str3);
        m190a.m214a("subcontent", (Object) this.f9074d);
        new SendMessageTask().m256e(m190a);
    }
}
