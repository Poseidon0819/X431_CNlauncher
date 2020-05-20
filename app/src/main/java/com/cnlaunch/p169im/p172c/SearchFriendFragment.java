package com.cnlaunch.p169im.p172c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p180j.SendMessageTask;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo;
import com.cnlaunch.x431pro.activity.golo.p224a.SearchFriendAdapter;
import com.cnlaunch.x431pro.module.golo.model.AddFriendInfo;
import com.cnlaunch.x431pro.module.golo.model.AddFriendResponse;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.module.golo.model.SearchFriednInfo;
import com.cnlaunch.x431pro.module.golo.model.SearchFriendResponse;
import com.cnlaunch.x431pro.module.golo.p262a.FriendAction;
import com.cnlaunch.x431pro.module.p255e.p257b.UserInfoResultResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.User;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.cnlaunch.x431pro.widget.sortlistview.CharacterParser;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import message.model.ChatMessage;
import message.model.ChatRoom;
import message.p378a.MessageParameters;

/* renamed from: com.cnlaunch.im.c.t */
/* loaded from: classes.dex */
public class SearchFriendFragment extends BaseFragment {

    /* renamed from: b */
    private ListView f9158b;

    /* renamed from: c */
    private SearchFriendAdapter f9159c;

    /* renamed from: i */
    private Button f9165i;

    /* renamed from: j */
    private ClearEditText f9166j;

    /* renamed from: k */
    private ProgressBar f9167k;

    /* renamed from: d */
    private String f9160d = "";

    /* renamed from: e */
    private String f9161e = "";

    /* renamed from: f */
    private String f9162f = "";

    /* renamed from: g */
    private String f9163g = "";

    /* renamed from: h */
    private List<InfaceItemInfo> f9164h = new ArrayList();

    /* renamed from: a */
    FriendAction f9157a = null;

    /* renamed from: l */
    private String f9168l = "";

    /* renamed from: m */
    private String f9169m = "";
    @SuppressLint({"HandlerLeak"})

    /* renamed from: n */
    private Handler f9170n = new HandlerC1729y(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.golo_searchfriend_fragment, viewGroup, false);
        this.f9158b = (ListView) inflate.findViewById(R.id.search_listview);
        this.f9167k = (ProgressBar) inflate.findViewById(R.id.search_progressbar);
        this.f9167k.setVisibility(4);
        this.f9166j = (ClearEditText) inflate.findViewById(R.id.golo_search);
        this.f9166j.addTextChangedListener(new C1725u(this));
        this.f9166j.setOnFocusChangeListener(new View$OnFocusChangeListenerC1726v(this));
        this.f9165i = (Button) inflate.findViewById(R.id.btn_search);
        this.f9165i.setOnClickListener(new View$OnClickListenerC1727w(this));
        return inflate;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.friends);
        if (bundle == null) {
            this.f9159c = new SearchFriendAdapter(getActivity(), this.f9170n);
            SearchFriendAdapter searchFriendAdapter = this.f9159c;
            searchFriendAdapter.f12535f = this;
            this.f9158b.setAdapter((ListAdapter) searchFriendAdapter);
            this.f9158b.setOnItemClickListener(new C1724a());
            this.f9159c.f12536g = new C1728x(this);
            this.f9157a = new FriendAction(getActivity());
            User user = (User) PreferencesManager.m9595a((Context) getActivity()).m9593a(User.class);
            if (user != null) {
                this.f9160d = !TextUtils.isEmpty(user.getNick_name()) ? user.getNick_name() : user.getUser_name();
                this.f9169m = user.getUser_id();
            }
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f9161e = this.f9166j.getText().toString();
        if (TextUtils.isEmpty(this.f9161e)) {
            return;
        }
        this.f9167k.setVisibility(0);
        if (TextUtils.isDigitsOnly(this.f9161e) && this.f9161e.length() == 12) {
            this.f9162f = this.f9161e;
            request(40033);
            return;
        }
        this.f9162f = "";
        request(40022);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i != 40033) {
            switch (i) {
                case 40022:
                    return this.f9157a.m5327a(this.f9161e);
                case 40023:
                    return this.f9157a.m5321h(this.f9168l);
                default:
                    return super.doInBackground(i);
            }
        }
        return this.f9157a.m5322g(this.f9161e);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i != 40033) {
            switch (i) {
                case 40022:
                    this.f9167k.setVisibility(4);
                    SearchFriendResponse searchFriendResponse = (SearchFriendResponse) obj;
                    if (searchFriendResponse != null) {
                        List<SearchFriednInfo> data = searchFriendResponse.getData();
                        if (data == null || data.size() <= 0) {
                            NToast.longToast(this.mContext, (int) R.string.search_no_found, 17);
                        } else if (!TextUtils.isEmpty(this.f9162f)) {
                            int i2 = 0;
                            while (i2 < data.size()) {
                                if (!this.f9163g.equalsIgnoreCase(data.get(i2).getUser_id())) {
                                    data.remove(i2);
                                    i2--;
                                }
                                i2++;
                            }
                        }
                        if (data != null) {
                            for (SearchFriednInfo searchFriednInfo : data) {
                                String nick_name = searchFriednInfo.getNick_name();
                                if (nick_name != null) {
                                    String m4390a = CharacterParser.m4391a().m4390a(nick_name);
                                    if (m4390a == null || "".equals(m4390a)) {
                                        searchFriednInfo.setSortKey("#");
                                    } else {
                                        String upperCase = m4390a.substring(0, 1).toUpperCase();
                                        if (upperCase.matches("[A-Z]")) {
                                            searchFriednInfo.setSortKey(upperCase);
                                        } else {
                                            searchFriednInfo.setSortKey("#");
                                        }
                                    }
                                }
                            }
                        }
                        SearchFriendAdapter searchFriendAdapter = this.f9159c;
                        String str = this.f9169m;
                        if (data != null) {
                            synchronized (searchFriendAdapter.f12531b) {
                                try {
                                    Iterator<SearchFriednInfo> it = data.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            SearchFriednInfo next = it.next();
                                            if (next.getUserID().equalsIgnoreCase(str)) {
                                                data.remove(next);
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                searchFriendAdapter.f12532c.clear();
                                searchFriendAdapter.f12532c.addAll(data);
                                searchFriendAdapter.f12531b.clear();
                                searchFriendAdapter.f12531b.addAll(searchFriendAdapter.f12533d);
                                searchFriendAdapter.f12531b.addAll(searchFriendAdapter.f12532c);
                                Collections.sort(searchFriendAdapter.f12531b, new SearchFriendAdapter.C2227a());
                                searchFriendAdapter.notifyDataSetChanged();
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 40023:
                    try {
                        AddFriendResponse addFriendResponse = (AddFriendResponse) obj;
                        if (addFriendResponse.getCode() == 0) {
                            AddFriendInfo data2 = addFriendResponse.getData();
                            if (data2.getEcode() == 100101) {
                                DialogC1730z dialogC1730z = new DialogC1730z(this, getActivity(), getString(R.string.input_your_verification), getString(R.string.input_your_verification_default, new Object[]{this.f9160d}), data2);
                                getActivity();
                                dialogC1730z.m4704b();
                                return;
                            } else if (data2.getEcode() == 1) {
                                SearchFriendAdapter searchFriendAdapter2 = this.f9159c;
                                String user_id = data2.getUser_id();
                                if (searchFriendAdapter2.f12531b != null && searchFriendAdapter2.f12531b.size() > 0) {
                                    Iterator<InfaceItemInfo> it2 = searchFriendAdapter2.f12531b.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            InfaceItemInfo next2 = it2.next();
                                            if (next2.getUserID().equalsIgnoreCase(user_id)) {
                                                next2.setFriend(true);
                                            }
                                        }
                                    }
                                    searchFriendAdapter2.notifyDataSetChanged();
                                }
                                IMPresenter.m8804a(this.mContext).m8805a(40021);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        NToast.shortToast(this.mContext, (int) R.string.check_server_failure_txt);
                        return;
                    }
                default:
                    super.onSuccess(i, obj);
                    return;
            }
        }
        UserInfoResultResponse userInfoResultResponse = (UserInfoResultResponse) obj;
        if (userInfoResultResponse != null && !TextUtils.isEmpty(userInfoResultResponse.getUserName())) {
            this.f9161e = userInfoResultResponse.getUserName();
            this.f9163g = userInfoResultResponse.getCc();
        }
        request(40022);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        if (i == 40022) {
            this.f9167k.setVisibility(4);
        } else if (i != 40033) {
        } else {
            request(40022);
        }
    }

    /* renamed from: a */
    public final void m8814a(InfaceItemInfo infaceItemInfo, int i) {
        ChatRoom chatRoom = new ChatRoom(infaceItemInfo.getUserID(), infaceItemInfo.getName(), MessageParameters.EnumC4721a.single);
        Bundle bundle = new Bundle();
        bundle.putParcelable("ChatRoom", chatRoom);
        bundle.putInt("launch_model", infaceItemInfo.isFriend() ? 0 : 3);
        bundle.putBoolean("isRemote", false);
        bundle.putBoolean("isFriend", infaceItemInfo.isFriend());
        if (i == 2) {
            bundle.putBoolean("LaunchRemoteHelp", true);
        } else if (i == 3) {
            bundle.putBoolean("LaunchRemote", true);
        }
        IMPresenter.m8804a(getActivity()).m8800a(ProMessageFragment.class.getName(), bundle);
    }

    /* compiled from: SearchFriendFragment.java */
    /* renamed from: com.cnlaunch.im.c.t$a */
    /* loaded from: classes.dex */
    class C1724a implements AdapterView.OnItemClickListener {
        C1724a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchFriendFragment.this.m8814a((InfaceItemInfo) SearchFriendFragment.this.f9159c.getItem(i), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m8816a(SearchFriendFragment searchFriendFragment, String str) {
        searchFriendFragment.f9164h.clear();
        List<FriendInfo> m8757a = GoloDBManager.m8756a(searchFriendFragment.getActivity()).m8757a();
        List<InfaceItemInfo> list = searchFriendFragment.f9164h;
        if (m8757a != null && !TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            for (FriendInfo friendInfo : m8757a) {
                String lowerCase2 = TextUtils.isEmpty(friendInfo.getName()) ? "" : friendInfo.getName().toLowerCase();
                if (!TextUtils.isEmpty(lowerCase2) && lowerCase2.contains(lowerCase)) {
                    list.add(friendInfo);
                }
            }
        }
        SearchFriendAdapter searchFriendAdapter = searchFriendFragment.f9159c;
        List<InfaceItemInfo> list2 = searchFriendFragment.f9164h;
        if (list2 != null) {
            synchronized (searchFriendAdapter.f12531b) {
                searchFriendAdapter.f12533d.clear();
                searchFriendAdapter.f12533d.addAll(list2);
                searchFriendAdapter.f12531b.clear();
                searchFriendAdapter.f12531b.addAll(searchFriendAdapter.f12533d);
                searchFriendAdapter.f12531b.addAll(searchFriendAdapter.f12532c);
                Collections.sort(searchFriendAdapter.f12531b, new SearchFriendAdapter.C2227a());
                searchFriendAdapter.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m8815a(SearchFriendFragment searchFriendFragment, String str, String str2, String str3) {
        ChatMessage m190a = new ChatRoom(str, str2, MessageParameters.EnumC4721a.single).m190a(9);
        m190a.m210b(0);
        m190a.m214a("text", (Object) str3);
        m190a.m214a("subcontent", (Object) searchFriendFragment.f9160d);
        new SendMessageTask().m256e(m190a);
    }
}
