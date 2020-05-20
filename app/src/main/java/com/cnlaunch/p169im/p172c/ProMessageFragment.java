package com.cnlaunch.p169im.p172c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.golo3.p154a.p159e.PauseOnScrollListener;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p165g.InterfaceC1618p;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.GoloApplication;
import com.cnlaunch.p169im.IMActivity;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.ShowImageDetailActivity;
import com.cnlaunch.p169im.p170a.C1692s;
import com.cnlaunch.p169im.p170a.ChatMessageAdapter;
import com.cnlaunch.p169im.p170a.ChatPagerAdapter;
import com.cnlaunch.p169im.p170a.LayoutAdapter;
import com.cnlaunch.p169im.p170a.SelectAdapter;
import com.cnlaunch.p169im.p173d.AutoVoiceHandler;
import com.cnlaunch.p169im.p173d.GoloHandler;
import com.cnlaunch.p169im.p173d.MessageDealHandlerCustom;
import com.cnlaunch.p169im.p173d.NoticeMessageHandler;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p174db.MessageInfoDao;
import com.cnlaunch.p169im.p176f.ChatManager;
import com.cnlaunch.p169im.p177g.MessageInfo;
import com.cnlaunch.p169im.p178h.ConnectStatusObserver;
import com.cnlaunch.p169im.p178h.GoloOBManager;
import com.cnlaunch.p169im.p179i.MessageListenerProvider;
import com.cnlaunch.p169im.p180j.SendMessageTask;
import com.cnlaunch.p169im.widget.ChatListView;
import com.cnlaunch.p169im.widget.ChatViewPager;
import com.cnlaunch.p169im.widget.InputText;
import com.cnlaunch.p169im.widget.SelectDialog;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.p181j.View$OnClickListenerC1770g;
import com.cnlaunch.p181j.View$OnClickListenerC1771h;
import com.cnlaunch.p181j.View$OnClickListenerC1772i;
import com.cnlaunch.p181j.View$OnClickListenerC1773j;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.golo.BaseGoloFragment;
import com.cnlaunch.x431pro.activity.golo.function.GoloFunctionActivity;
import com.cnlaunch.x431pro.activity.golo.others.CarTeamObject;
import com.cnlaunch.x431pro.activity.golo.others.ChatKey;
import com.cnlaunch.x431pro.activity.golo.others.GoloTools;
import com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent;
import com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter;
import com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener;
import com.cnlaunch.x431pro.activity.golo.p225b.onGoloDataListenter;
import com.cnlaunch.x431pro.activity.mine.PDFReportActivity;
import com.cnlaunch.x431pro.activity.mine.PDFReportFragment;
import com.cnlaunch.x431pro.activity.mine.p230b.DiagnosisPlaybackFragment;
import com.cnlaunch.x431pro.module.golo.model.AddFriendInfo;
import com.cnlaunch.x431pro.module.golo.model.AddFriendResponse;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.module.golo.p262a.GoloAction;
import com.cnlaunch.x431pro.module.p272k.p274b.User;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.InputDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import message.model.ChatMessage;
import message.model.ChatRoom;
import message.model.MessageObj;
import message.p380c.MessageDealHandler;
import message.p381d.FaceProvider;
import message.p381d.MediaProvider;
import message.p383f.RunnableC4743k;
import message.p383f.SendTask;
import message.p384g.MessageThreadPoolManager;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.im.c.j */
/* loaded from: classes.dex */
public class ProMessageFragment extends BaseGoloFragment implements View.OnClickListener, View.OnTouchListener, InterfaceC1618p, OnActivityResultListenter, OnGoloKeyDownListener {

    /* renamed from: A */
    private TextView f9094A;

    /* renamed from: D */
    private RelativeLayout f9097D;

    /* renamed from: E */
    private String f9098E;

    /* renamed from: G */
    private String f9100G;

    /* renamed from: H */
    private InputDialog f9101H;

    /* renamed from: O */
    private ChatViewPager f9108O;

    /* renamed from: P */
    private Button f9109P;

    /* renamed from: Q */
    private InputMethodManager f9110Q;

    /* renamed from: R */
    private AnimationDrawable f9111R;

    /* renamed from: b */
    Dialog f9119b;

    /* renamed from: c */
    protected DisplayMetrics f9120c;

    /* renamed from: d */
    SelectDialog f9121d;

    /* renamed from: f */
    private ChatListView f9123f;

    /* renamed from: g */
    private ChatMessageAdapter f9124g;

    /* renamed from: h */
    private ArrayList<ChatMessage> f9125h;

    /* renamed from: k */
    private InputText f9128k;

    /* renamed from: l */
    private Button f9129l;

    /* renamed from: m */
    private Button f9130m;

    /* renamed from: n */
    private View f9131n;

    /* renamed from: o */
    private View f9132o;

    /* renamed from: p */
    private View f9133p;

    /* renamed from: q */
    private View f9134q;

    /* renamed from: r */
    private View f9135r;

    /* renamed from: s */
    private View f9136s;

    /* renamed from: t */
    private View f9137t;

    /* renamed from: u */
    private View f9138u;

    /* renamed from: v */
    private WindowManager f9139v;

    /* renamed from: y */
    private File f9142y;

    /* renamed from: z */
    private TextView f9143z;

    /* renamed from: e */
    private ChatRoom f9122e = null;

    /* renamed from: i */
    private HandlerC1713a f9126i = null;

    /* renamed from: j */
    private LayoutAdapter f9127j = null;

    /* renamed from: w */
    private boolean f9140w = false;

    /* renamed from: x */
    private boolean f9141x = false;

    /* renamed from: B */
    private long f9095B = 0;

    /* renamed from: C */
    private ChatKey f9096C = new ChatKey();

    /* renamed from: F */
    private boolean f9099F = false;

    /* renamed from: I */
    private onGoloDataListenter f9102I = null;

    /* renamed from: J */
    private int f9103J = 0;

    /* renamed from: K */
    private boolean f9104K = false;

    /* renamed from: L */
    private MessageDealHandlerCustom f9105L = new C1717m(this, Looper.myLooper());

    /* renamed from: M */
    private BroadcastReceiver f9106M = new C1719o(this);

    /* renamed from: N */
    private String f9107N = "";

    /* renamed from: a */
    int f9118a = 0;

    /* renamed from: S */
    private InfaceFragmentParent f9112S = null;

    /* renamed from: T */
    private GoloAction f9113T = null;

    /* renamed from: U */
    private String f9114U = "";

    /* renamed from: V */
    private HandlerC1714b f9115V = new HandlerC1714b();

    /* renamed from: W */
    private PopupWindow f9116W = null;

    /* renamed from: X */
    private ConnectStatusObserver f9117X = new C1722r(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y */
    public static /* synthetic */ boolean m8819y(ProMessageFragment proMessageFragment) {
        proMessageFragment.f9099F = true;
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.BaseGoloFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ChatRoom chatRoom;
        super.onActivityCreated(bundle);
        this.f9095B = System.currentTimeMillis();
        this.f9113T = new GoloAction(this.mContext);
        request(40015, false);
        if (this.f9140w) {
            DealDiagMessageHandler.m8673a().m8668a(this.f9122e.f24076a, this.f9107N);
        } else if (this.f9141x) {
            DealDiagMessageHandler m8673a = DealDiagMessageHandler.m8673a();
            if (MainActivity.m7907a()) {
                NToast.longToast(m8673a.f9429e, (int) R.string.tip_must_stop_diag_before, 17);
                m8673a.f9430f.m8681c();
            } else {
                DealDiagMessageHandler.m8673a().m8664b(m8673a.f9432h);
            }
        }
        try {
            this.f9112S = (InfaceFragmentParent) getActivity();
            if (this.f9112S != null) {
                this.f9112S.mo6035a(this);
            }
        } catch (Exception e) {
            Log.e("Sanda", "infaceFragmentParent Error:" + e.toString());
        }
        if (this.f9096C.f12677a != 2 && (chatRoom = this.f9122e) != null) {
            if (CarTeamObject.m6965a(chatRoom.f24076a)) {
                setTitle(R.string.cheyunteam_name);
            } else {
                setTitle(TextUtils.isEmpty(this.f9122e.f24077b) ? this.f9122e.f24076a : this.f9122e.f24077b);
            }
        }
        GoloOBManager m8721a = GoloOBManager.m8721a();
        ConnectStatusObserver connectStatusObserver = this.f9117X;
        if (m8721a.f9280b == null) {
            Log.e("Sanda", "ConnectStatusObserver is NullPointerException!");
        } else if (!m8721a.f9280b.contains(connectStatusObserver)) {
            m8721a.f9280b.add(connectStatusObserver);
        }
        if (TextUtils.isEmpty(ApplicationConfig.m9181a())) {
            this.f9129l.setEnabled(false);
            NToast.longToast(getActivity(), (int) R.string.failed_to_get_user_info);
        }
        if (this.f9104K) {
            return;
        }
        NoticeMessageHandler m8784a = NoticeMessageHandler.m8784a(getActivity());
        String str = this.f9122e.f24076a;
        Log.i("Sanda", "putObject=".concat(String.valueOf(str)));
        m8784a.f9201d.add(str);
        m8784a.f9200c.m8734a(str);
    }

    @Override // com.cnlaunch.x431pro.activity.golo.BaseGoloFragment, android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f9102I = (onGoloDataListenter) activity;
        } catch (Exception unused) {
            this.f9102I = null;
        }
        this.bundle = getArguments();
        if (this.bundle != null) {
            this.f9122e = (ChatRoom) this.bundle.getParcelable("ChatRoom");
            this.f9098E = this.f9122e.f24076a;
            if (this.bundle.containsKey("LaunchRemote")) {
                this.f9140w = this.bundle.getBoolean("LaunchRemote");
            }
            if (this.bundle.containsKey("LaunchRemoteHelp")) {
                this.f9141x = this.bundle.getBoolean("LaunchRemoteHelp");
            }
            if (this.bundle.containsKey("isFriend")) {
                this.f9099F = this.bundle.getBoolean("isFriend");
                this.f9122e.f24078c = this.f9099F;
            }
            if (this.bundle.containsKey("launch_model")) {
                this.f9096C.f12677a = this.bundle.getInt("launch_model", 0);
            }
            if (this.bundle.containsKey("otherFaceUrl")) {
                this.f9096C.f12678b = this.bundle.getString("otherFaceUrl");
            }
            this.f9096C.f12678b = GoloTools.m6963a(getActivity(), this.f9122e.f24076a);
            if (this.bundle.containsKey("seriNo")) {
                this.f9107N = this.bundle.getString("seriNo");
            }
            if (this.bundle.containsKey("roles")) {
                this.f9096C.f12679c = this.bundle.getInt("roles");
            }
            if (this.bundle.containsKey("IsRemoteDiagFlag")) {
                this.f9104K = this.bundle.getBoolean("IsRemoteDiagFlag");
            }
            GoloDBManager m8756a = GoloDBManager.m8756a(getActivity());
            String str = this.f9122e.f24076a;
            QueryBuilder<MessageInfo> queryBuilder = m8756a.f9220b.f9228e.queryBuilder();
            queryBuilder.where(MessageInfoDao.Properties.User_id.m321eq(str), new WhereCondition[0]);
            queryBuilder.where(MessageInfoDao.Properties.Type.m321eq(3), new WhereCondition[0]);
            List<MessageInfo> list = queryBuilder.list();
            this.f9103J = list != null && list.size() > 0 ? 3 : 0;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_chat_message, viewGroup, false);
        MessageListenerProvider.m8714a(this.f9105L);
        this.f9126i = new HandlerC1713a();
        if (this.f9096C.f12677a == 2) {
            AutoVoiceHandler.m8789a(getActivity()).f9192d = this.f9126i;
        }
        this.f9127j = new LayoutAdapter(getActivity(), this.f9122e, this.f9126i);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("add_friend");
        getActivity().registerReceiver(this.f9106M, intentFilter);
        this.f9139v = (WindowManager) getActivity().getSystemService("window");
        this.f9120c = new DisplayMetrics();
        this.f9139v.getDefaultDisplay().getMetrics(this.f9120c);
        this.f9094A = (TextView) inflate.findViewById(R.id.im_clear);
        this.f9094A.setOnClickListener(this);
        this.f9097D = (RelativeLayout) inflate.findViewById(R.id.lr_chat_tips);
        this.f9128k = (InputText) inflate.findViewById(R.id.chat_edit_input);
        this.f9128k.setOnTouchListener(new View$OnTouchListenerC1715k(this));
        this.f9129l = (Button) inflate.findViewById(R.id.chat_btn_send_text);
        this.f9129l.setOnClickListener(this);
        this.f9130m = (Button) inflate.findViewById(R.id.chat_btn_select);
        this.f9130m.setOnClickListener(this);
        this.f9131n = inflate.findViewById(R.id.chat_text_layout);
        this.f9132o = inflate.findViewById(R.id.chat_voice_layout);
        this.f9133p = inflate.findViewById(R.id.chat_select_layout);
        this.f9108O = (ChatViewPager) inflate.findViewById(R.id.select_grid);
        this.f9134q = inflate.findViewById(R.id.face_bar);
        this.f9135r = inflate.findViewById(R.id.yellow_face);
        this.f9136s = inflate.findViewById(R.id.goose_face);
        this.f9137t = inflate.findViewById(R.id.gay_face);
        this.f9138u = inflate.findViewById(R.id.car_face);
        this.f9135r.setOnClickListener(this);
        this.f9136s.setOnClickListener(this);
        this.f9137t.setOnClickListener(this);
        this.f9138u.setOnClickListener(this);
        this.f9109P = (Button) inflate.findViewById(R.id.chat_btn_send_voice);
        ((Button) inflate.findViewById(R.id.chat_btn_voice)).setOnClickListener(this);
        ((Button) inflate.findViewById(R.id.chat_btn_text)).setOnClickListener(this);
        this.f9109P.setOnTouchListener(this);
        this.f9123f = (ChatListView) inflate.findViewById(R.id.chat_list_view);
        ChatKey chatKey = this.f9096C;
        if (TextUtils.isEmpty(chatKey.f12678b) || chatKey.f12678b.equalsIgnoreCase("null")) {
            this.f9124g = new ChatMessageAdapter(getActivity(), this.f9125h, this.f9126i, GoloApplication.m8925a());
        } else {
            this.f9124g = new ChatMessageAdapter(getActivity(), this.f9125h, this.f9126i, GoloApplication.m8925a(), this.f9096C.f12678b);
        }
        this.f9123f.setHandler(this.f9126i);
        this.f9123f.setAdapter((ListAdapter) this.f9124g);
        this.f9123f.setOnScrollListener(new PauseOnScrollListener(GoloApplication.m8925a()));
        this.f9123f.setOnTouchListener(new View$OnTouchListenerC1716l(this));
        this.f9143z = (TextView) inflate.findViewById(R.id.connect_hit);
        this.f9143z.setVisibility(GoloTools.m6964a(this.mContext) ? 8 : 0);
        User user = (User) PreferencesManager.m9595a((Context) getActivity()).m9593a(User.class);
        if (user != null) {
            this.f9100G = !TextUtils.isEmpty(user.getNick_name()) ? user.getNick_name() : user.getUser_name();
        }
        return inflate;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GoloLightManager.m8495c();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f9106M != null) {
            getActivity().unregisterReceiver(this.f9106M);
        }
        PreferencesManager.m9595a(this.mContext).m9588a("current_visible_promessagefragment_room_id", "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r5 != 40023) goto L10;
     */
    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doInBackground(int r5) throws com.cnlaunch.p120d.p125c.p128c.C1425f {
        /*
            r4 = this;
            r0 = 40015(0x9c4f, float:5.6073E-41)
            if (r5 == r0) goto Lb
            r0 = 40023(0x9c57, float:5.6084E-41)
            if (r5 == r0) goto L56
            goto L68
        Lb:
            android.content.Context r0 = r4.mContext
            if (r0 == 0) goto L56
            android.content.Context r5 = r4.mContext
            com.cnlaunch.im.db.b r5 = com.cnlaunch.p169im.p174db.GoloDBManager.m8756a(r5)
            message.model.ChatRoom r0 = r4.f9122e
            java.lang.String r0 = r0.f24076a
            com.cnlaunch.im.db.d r5 = r5.f9220b
            com.cnlaunch.im.db.MessageDao r5 = r5.f9224a
            de.greenrobot.dao.query.QueryBuilder r5 = r5.queryBuilder()
            de.greenrobot.dao.query.WhereCondition$StringCondition r1 = new de.greenrobot.dao.query.WhereCondition$StringCondition
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            de.greenrobot.dao.Property r3 = com.cnlaunch.p169im.p174db.MessageDao.Properties.roomId
            java.lang.String r3 = r3.columnName
            r2.append(r3)
            java.lang.String r3 = "= ? ORDER BY "
            r2.append(r3)
            de.greenrobot.dao.Property r3 = com.cnlaunch.p169im.p174db.MessageDao.Properties.time
            java.lang.String r3 = r3.columnName
            r2.append(r3)
            java.lang.String r3 = " DESC LIMIT 30"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            r0 = 0
            de.greenrobot.dao.query.WhereCondition[] r0 = new de.greenrobot.dao.query.WhereCondition[r0]
            de.greenrobot.dao.query.QueryBuilder r0 = r5.where(r1, r0)
            r0.build()
            java.util.List r5 = r5.list()
            return r5
        L56:
            android.content.Context r0 = r4.mContext
            if (r0 == 0) goto L68
            com.cnlaunch.x431pro.module.golo.a.a r5 = new com.cnlaunch.x431pro.module.golo.a.a
            android.content.Context r0 = r4.mContext
            r5.<init>(r0)
            java.lang.String r0 = r4.f9098E
            com.cnlaunch.x431pro.module.golo.model.b r5 = r5.m5321h(r0)
            return r5
        L68:
            java.lang.Object r5 = super.doInBackground(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p169im.p172c.ProMessageFragment.doInBackground(int):java.lang.Object");
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 40015) {
            ChatListView chatListView = this.f9123f;
            if (chatListView != null) {
                chatListView.computeScroll();
            }
            this.f9124g.m8911a((ArrayList) obj, true);
        } else if (i == 40023) {
            try {
                AddFriendResponse addFriendResponse = (AddFriendResponse) obj;
                if (addFriendResponse.getCode() == 0) {
                    AddFriendInfo data = addFriendResponse.getData();
                    if (data.getEcode() == 100101) {
                        if ((this.f9101H == null || !this.f9101H.isShowing()) && this.mContext != null) {
                            this.f9101H = new DialogC1718n(this, this.mContext, getString(R.string.input_your_verification), getString(R.string.input_your_verification_default, new Object[]{this.f9100G}), data);
                            this.f9101H.m4704b();
                        }
                    } else if (data.getEcode() == 1) {
                        IMPresenter.m8804a(this.mContext).m8805a(40021);
                        if (this.mContext != null) {
                            NToast.shortToast(this.mContext, (int) R.string.add_readly);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mContext != null) {
                    NToast.shortToast(this.mContext, (int) R.string.check_server_failure_txt);
                }
            }
        } else {
            super.onSuccess(i, obj);
        }
    }

    @Override // com.cnlaunch.golo3.p165g.InterfaceC1618p
    /* renamed from: a */
    public final void mo8851a(int i) {
        ChatPagerAdapter chatPagerAdapter;
        GridView gridView;
        SelectAdapter selectAdapter;
        ArrayList<Map<String, Integer>> arrayList;
        if (i != 145) {
            return;
        }
        if (GoloDBManager.m8756a(this.mContext).m8755a(this.f9122e.f24076a) == null) {
            FriendInfo friendInfo = new FriendInfo();
            friendInfo.setUser_id(this.f9122e.f24076a);
            friendInfo.setFace_url(this.f9096C.f12678b);
            friendInfo.setNick_name(this.f9122e.f24077b);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(friendInfo);
            GoloTools.m6961a(arrayList2);
            GoloDBManager.m8756a(this.mContext).f9220b.f9226c.insert(friendInfo);
            IMPresenter.m8804a(ApplicationConfig.f7802a).f9184f = GoloDBManager.m8756a(ApplicationConfig.f7802a).m8757a();
            IMPresenter.m8804a(ApplicationConfig.f7802a).m8792d(40021);
        }
        if (this.f9118a != 1 || (chatPagerAdapter = (ChatPagerAdapter) this.f9108O.getAdapter()) == null || (gridView = (GridView) chatPagerAdapter.f8978a.get(0)) == null || !(gridView.getAdapter() instanceof SelectAdapter) || (arrayList = (selectAdapter = (SelectAdapter) gridView.getAdapter()).f9036a) == null || arrayList.size() != 5) {
            return;
        }
        arrayList.remove(0);
        selectAdapter.notifyDataSetChanged();
        gridView.setNumColumns(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProMessageFragment.java */
    /* renamed from: com.cnlaunch.im.c.j$a */
    /* loaded from: classes.dex */
    public class HandlerC1713a extends GoloHandler {
        HandlerC1713a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            switch (message2.what) {
                case 6:
                    int i = message2.arg1;
                    if (ProMessageFragment.this.f9124g.m8908c(i)) {
                        new C1723s(this, i).m4610a(ProMessageFragment.this.getActivity(), R.string.dialog_title_default, R.string.resend_message, false);
                        return;
                    }
                    return;
                case 10000:
                    if (ProMessageFragment.this.f9124g.getCount() - ProMessageFragment.this.f9123f.getLastVisiblePosition() > 0) {
                        ProMessageFragment.this.f9123f.setTranscriptMode(0);
                    } else {
                        ProMessageFragment.this.f9123f.setTranscriptMode(2);
                    }
                    ProMessageFragment.this.f9124g.notifyDataSetChanged();
                    return;
                case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_OPTIONS_NULL /* 10001 */:
                    ProMessageFragment.m8848a(ProMessageFragment.this, ((Integer) message2.obj).intValue());
                    return;
                case 10011:
                    if (message2.arg1 != 1) {
                        ProMessageFragment.this.f9123f.setSelection(message2.arg2);
                    } else {
                        NToast.shortToast(ProMessageFragment.this.getActivity(), (int) R.string.upload_hint);
                    }
                    ChatListView chatListView = ProMessageFragment.this.f9123f;
                    chatListView.f9319c = 1;
                    chatListView.f9317a.setPadding(0, -chatListView.f9318b, 0, 0);
                    return;
                case 10013:
                    LayoutAdapter layoutAdapter = ProMessageFragment.this.f9127j;
                    ChatListView chatListView2 = ProMessageFragment.this.f9123f;
                    Button button = ProMessageFragment.this.f9109P;
                    if (layoutAdapter.f8993e) {
                        return;
                    }
                    try {
                        File m8727a = layoutAdapter.f8994f.m8727a();
                        NToast.longToast(layoutAdapter.f8989a, (int) R.string.recording_time_toolong);
                        layoutAdapter.f8993e = true;
                        layoutAdapter.f8992d.cancel();
                        LayoutAdapter.f8988g = false;
                        layoutAdapter.m8894a(false, chatListView2, (View) button);
                        ChatMessage m190a = layoutAdapter.f8990b.m190a(2);
                        m190a.m209b("path", (Object) m8727a.getPath());
                        m190a.m193o();
                        chatListView2.setTranscriptMode(2);
                        new SendMessageTask().m256e(m190a);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case 10015:
                    if (ProMessageFragment.this.f9097D != null) {
                        ProMessageFragment.this.f9097D.setVisibility(0);
                        return;
                    }
                    return;
                case 10016:
                    if (ProMessageFragment.this.f9097D != null) {
                        ProMessageFragment.this.f9097D.setVisibility(8);
                        return;
                    }
                    return;
                case 100000:
                    LayoutAdapter layoutAdapter2 = ProMessageFragment.this.f9127j;
                    InputText inputText = ProMessageFragment.this.f9128k;
                    Editable editableText = inputText.getEditableText();
                    if (editableText != null) {
                        try {
                            editableText.insert(inputText.getSelectionStart(), FaceProvider.m296a(layoutAdapter2.f8989a, (String) message2.obj, inputText.getTextSize()));
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 100001:
                    LayoutAdapter unused = ProMessageFragment.this.f9127j;
                    LayoutAdapter.m8896a(ProMessageFragment.this.f9128k);
                    return;
                case 100002:
                    LayoutAdapter unused2 = ProMessageFragment.this.f9127j;
                    LayoutAdapter.m8900a(ProMessageFragment.this.f9134q, ProMessageFragment.this.f9126i, ProMessageFragment.this.f9108O);
                    return;
                case 100003:
                    ProMessageFragment proMessageFragment = ProMessageFragment.this;
                    if (proMessageFragment.f9119b == null) {
                        View inflate = proMessageFragment.getActivity().getLayoutInflater().inflate(R.layout.chat_menu_picture, (ViewGroup) null);
                        ((Button) inflate.findViewById(R.id.menu_picture_camera)).setOnClickListener(proMessageFragment);
                        ((Button) inflate.findViewById(R.id.menu_picture_gallery)).setOnClickListener(proMessageFragment);
                        ((Button) inflate.findViewById(R.id.menu_picture_cancel)).setOnClickListener(proMessageFragment);
                        proMessageFragment.f9119b = new SelectDialog(proMessageFragment.getActivity());
                        proMessageFragment.f9119b.setContentView(inflate);
                        proMessageFragment.f9119b.getWindow().setWindowAnimations(R.style.dialog_anim);
                    }
                    proMessageFragment.f9119b.show();
                    return;
                case 100004:
                    ProMessageFragment proMessageFragment2 = ProMessageFragment.this;
                    if (proMessageFragment2.f9121d == null) {
                        View inflate2 = LayoutInflater.from(proMessageFragment2.mContext).inflate(R.layout.chat_menu_file, (ViewGroup) null);
                        ((Button) inflate2.findViewById(R.id.menu_file_report)).setOnClickListener(proMessageFragment2);
                        ((Button) inflate2.findViewById(R.id.menu_file_gallery)).setOnClickListener(proMessageFragment2);
                        ((Button) inflate2.findViewById(R.id.menu_file_cancel)).setOnClickListener(proMessageFragment2);
                        proMessageFragment2.f9121d = new SelectDialog(proMessageFragment2.mContext);
                        proMessageFragment2.f9121d.setContentView(inflate2);
                    }
                    proMessageFragment2.f9121d.show();
                    return;
                case 100006:
                    List<ChatMessage> m8738a = ChatManager.m8741a(ProMessageFragment.this.getActivity()).m8738a(ProMessageFragment.this.f9122e, Long.valueOf(ProMessageFragment.this.f9124g.getCount() != 0 ? ProMessageFragment.this.f9124g.getItem(0).f24056a.longValue() : 0L));
                    if (m8738a.size() == 0) {
                        ProMessageFragment.this.f9126i.obtainMessage(10011, 1, 0).sendToTarget();
                        return;
                    }
                    ProMessageFragment.this.f9124g.m8911a((ArrayList) m8738a, false);
                    ProMessageFragment.this.f9126i.obtainMessage(10011, 0, m8738a.size()).sendToTarget();
                    return;
                case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_NETWORK_ERROR /* 100010 */:
                    ReportProduceTool.m5233a().m5224c();
                    ProMessageFragment.this.f9123f.setTranscriptMode(0);
                    if (ProMessageFragment.this.f9122e.f24076a.equalsIgnoreCase("666666")) {
                        NToast.shortToast(ProMessageFragment.this.mContext, (int) R.string.error_roles, 17);
                        return;
                    } else if (ProMessageFragment.this.f9096C.f12677a == 2) {
                        NToast.shortToast(ProMessageFragment.this.mContext, (int) R.string.remotediagnoseconnected, 17);
                        return;
                    } else if (ProMessageFragment.this.f9096C.f12677a == 1) {
                        DealDiagMessageHandler.m8673a().m8668a(ProMessageFragment.this.f9122e.f24076a, ProMessageFragment.this.f9107N);
                        return;
                    } else {
                        if ((ProMessageFragment.this.f9096C.f12679c & 32) == 32) {
                            DealDiagMessageHandler.m8673a().m8668a(ProMessageFragment.this.f9122e.f24076a, ProMessageFragment.this.f9107N);
                            return;
                        } else if (ProMessageFragment.this.f9122e != null) {
                            DealDiagMessageHandler m8673a = DealDiagMessageHandler.m8673a();
                            String str = ProMessageFragment.this.f9122e.f24076a;
                            String str2 = ProMessageFragment.this.f9107N;
                            m8673a.f9432h = str;
                            if (m8673a.f9431g == null) {
                                View inflate3 = ((Activity) m8673a.f9429e).getLayoutInflater().inflate(R.layout.menu_remotediag_model, (ViewGroup) null);
                                ((Button) inflate3.findViewById(R.id.menu_order)).setOnClickListener(new View$OnClickListenerC1770g(m8673a));
                                ((Button) inflate3.findViewById(R.id.menu_request)).setOnClickListener(new View$OnClickListenerC1771h(m8673a, str2));
                                ((Button) inflate3.findViewById(R.id.menu_invite)).setOnClickListener(new View$OnClickListenerC1772i(m8673a));
                                ((Button) inflate3.findViewById(R.id.menu_cancel)).setOnClickListener(new View$OnClickListenerC1773j(m8673a));
                                m8673a.f9431g = new SelectDialog(m8673a.f9429e);
                                m8673a.f9431g.setContentView(inflate3);
                                m8673a.f9431g.getWindow().setWindowAnimations(R.style.dialog_anim);
                            }
                            m8673a.f9431g.show();
                            return;
                        } else {
                            return;
                        }
                    }
                case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR /* 100012 */:
                    LayoutAdapter layoutAdapter3 = ProMessageFragment.this.f9127j;
                    String str3 = (String) message2.obj;
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(layoutAdapter3.f8990b.f24076a);
                        MessageThreadPoolManager.m225a(SendTask.class.getName()).m226a(new RunnableC4743k(new SendMessageTask(), arrayList, layoutAdapter3.f8990b.f24079d, str3, new C1692s(layoutAdapter3)));
                        return;
                    } catch (Exception unused3) {
                        return;
                    }
                case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_ICON_NULL /* 100021 */:
                    if (ProMessageFragment.this.f9099F) {
                        NToast.longToast(ProMessageFragment.this.mContext, (int) R.string.his_is_friend);
                        return;
                    } else if (MainActivity.m7895b()) {
                        Toast.makeText(ProMessageFragment.this.mContext, (int) R.string.remoteing_no_add_friend, 0).show();
                        return;
                    } else {
                        ProMessageFragment.this.request(40023);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public final void m8846a(ChatMessage chatMessage) {
        this.f9123f.setTranscriptMode(2);
        new SendMessageTask().m256e(chatMessage);
    }

    /* renamed from: b */
    private boolean m8845b() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager == null || getActivity().getCurrentFocus() == null || !inputMethodManager.isActive(this.f9128k)) {
                return false;
            }
            if (getView() != null) {
                getView().requestFocus();
            }
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 2);
            inputMethodManager.restartInput(this.f9128k);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        switch (view.getId()) {
            case R.id.car_face /* 2131296636 */:
                LayoutAdapter.m8893b(this.f9134q, this.f9126i, this.f9108O);
                return;
            case R.id.chat_btn_select /* 2131296691 */:
                if (m8845b()) {
                    return;
                }
                if (this.f9118a == 1 && this.f9133p.getVisibility() != 8) {
                    this.f9118a = 2;
                    this.f9134q.setVisibility(8);
                    this.f9133p.setVisibility(8);
                    return;
                }
                ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
                this.f9118a = 1;
                this.f9134q.setVisibility(8);
                this.f9131n.setVisibility(0);
                this.f9132o.setVisibility(8);
                this.f9133p.setVisibility(0);
                LayoutAdapter layoutAdapter = this.f9127j;
                ChatViewPager chatViewPager = this.f9108O;
                HandlerC1713a handlerC1713a = this.f9126i;
                boolean z = this.f9103J != 3;
                Context context = layoutAdapter.f8989a;
                String str = layoutAdapter.f8990b.f24076a;
                ArrayList arrayList = new ArrayList();
                GridView gridView = new GridView(context);
                gridView.setNumColumns(5);
                gridView.setGravity(17);
                if (GoloDBManager.m8756a(context).m8755a(str) != null || CarTeamObject.m6965a(str)) {
                    gridView.setNumColumns(4);
                    i = 0;
                } else {
                    i = -1;
                    gridView.setNumColumns(5);
                }
                gridView.setAdapter((ListAdapter) new SelectAdapter(context, handlerC1713a, z, i));
                arrayList.add(gridView);
                chatViewPager.setAdapter(new ChatPagerAdapter(arrayList));
                LayoutAdapter.m8899a(m8843c(), this.f9128k);
                FriendInfo m8755a = GoloDBManager.m8756a(this.mContext).m8755a(this.f9122e.f24076a);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                GridView gridView2 = (GridView) ((ChatPagerAdapter) this.f9108O.getAdapter()).f8978a.get(0);
                if (getResources().getConfiguration().orientation == 1) {
                    if (m8755a != null) {
                        this.f9108O.setHeight(getResources().getDimension(R.dimen.chat_selectview_height_friend_port));
                    } else {
                        this.f9108O.setHeight(getResources().getDimension(R.dimen.chat_selectview_height_strange));
                    }
                    layoutParams.setMargins(0, 0, 0, 0);
                    gridView2.setNumColumns(4);
                } else {
                    if (m8755a != null) {
                        gridView2.setNumColumns(4);
                    } else {
                        gridView2.setNumColumns(5);
                    }
                    this.f9108O.setHeight(getResources().getDimension(R.dimen.chat_selectview_height_strange));
                    layoutParams.setMargins(0, 0, 0, 0);
                }
                this.f9108O.setLayoutParams(layoutParams);
                this.f9123f.setTranscriptMode(2);
                return;
            case R.id.chat_btn_send_text /* 2131296692 */:
                Editable editableText = this.f9128k.getEditableText();
                if (editableText == null || editableText.toString().trim().length() == 0) {
                    return;
                }
                ChatMessage m190a = this.f9122e.m190a(1);
                m190a.m214a("text", (Object) editableText.toString());
                this.f9128k.setText("");
                m8846a(m190a);
                return;
            case R.id.chat_btn_text /* 2131296694 */:
                m8847a(this.f9123f, this.f9128k, this.f9132o, this.f9131n, this.f9133p, true);
                return;
            case R.id.chat_btn_voice /* 2131296695 */:
                if (FileUtils.m5027a() > 2) {
                    InputText inputText = this.f9128k;
                    View view2 = this.f9132o;
                    View view3 = this.f9131n;
                    View view4 = this.f9133p;
                    if (!MainActivity.m7895b()) {
                        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(1);
                    } else {
                        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
                    }
                    this.f9118a = 3;
                    view3.setVisibility(8);
                    view2.setVisibility(0);
                    view4.setVisibility(8);
                    LayoutAdapter.m8899a(m8843c(), inputText);
                    return;
                }
                NToast.shortToast(this.mContext, (int) R.string.sd_no_storage_space);
                return;
            case R.id.gay_face /* 2131297041 */:
                LayoutAdapter.m8889d(this.f9134q, this.f9126i, this.f9108O);
                return;
            case R.id.goose_face /* 2131297062 */:
                LayoutAdapter.m8891c(this.f9134q, this.f9126i, this.f9108O);
                return;
            case R.id.im_clear /* 2131297125 */:
                ArrayList<ChatMessage> arrayList2 = this.f9124g.f8918a;
                if (arrayList2 == null || arrayList2.size() <= 0) {
                    return;
                }
                ChatManager.m8741a(getActivity()).m8740a(this.f9122e.f24076a, this.f9122e.f24079d.name());
                arrayList2.clear();
                GoloDBManager m8756a = GoloDBManager.m8756a(this.mContext);
                String str2 = this.f9122e.f24076a;
                QueryBuilder<MessageInfo> queryBuilder = m8756a.f9220b.f9228e.queryBuilder();
                queryBuilder.where(MessageInfoDao.Properties.User_id.m321eq(str2), new WhereCondition[0]);
                queryBuilder.where(MessageInfoDao.Properties.Type.m321eq(0), new WhereCondition[0]);
                queryBuilder.limit(1);
                List<MessageInfo> list = queryBuilder.list();
                if (list != null && list.size() > 0) {
                    list.get(0).f9275g = "";
                    m8756a.f9220b.f9228e.update(list.get(0));
                }
                MessageListFragment messageListFragment = (MessageListFragment) getActivity().getFragmentManager().findFragmentByTag(MessageListFragment.class.getName());
                if (messageListFragment != null) {
                    messageListFragment.m8859a(this.f9122e.f24076a);
                }
                this.f9124g.notifyDataSetChanged();
                return;
            case R.id.menu_file_cancel /* 2131297487 */:
                SelectDialog selectDialog = this.f9121d;
                if (selectDialog != null) {
                    selectDialog.dismiss();
                    return;
                }
                return;
            case R.id.menu_file_gallery /* 2131297488 */:
                SelectDialog selectDialog2 = this.f9121d;
                if (selectDialog2 != null) {
                    selectDialog2.dismiss();
                }
                Intent intent = new Intent(this.mContext, GoloFunctionActivity.class);
                intent.setAction("ACTION_LOCALFILE");
                m8850a(getActivity(), intent, 4);
                getActivity().getParent().overridePendingTransition(R.anim.activity_right_to_left_in, R.anim.activity_right_to_left_out);
                return;
            case R.id.menu_file_report /* 2131297489 */:
                SelectDialog selectDialog3 = this.f9121d;
                if (selectDialog3 != null) {
                    selectDialog3.dismiss();
                }
                Intent intent2 = new Intent(this.mContext, GoloFunctionActivity.class);
                intent2.setAction("ACTION_REPORTFILE");
                m8850a(getActivity(), intent2, 4);
                getActivity().getParent().overridePendingTransition(R.anim.activity_right_to_left_in, R.anim.activity_right_to_left_out);
                return;
            case R.id.menu_picture_camera /* 2131297492 */:
                this.f9119b.dismiss();
                try {
                    this.f9142y = MediaProvider.m290a("/picture", String.valueOf(System.currentTimeMillis()));
                    Intent intent3 = new Intent();
                    if (getActivity().getPackageManager().getLaunchIntentForPackage("com.android.camera") != null) {
                        intent3.setPackage("com.android.camera");
                    }
                    intent3.setAction("android.media.action.IMAGE_CAPTURE");
                    intent3.putExtra("output", Uri.fromFile(this.f9142y));
                    m8850a(getActivity(), intent3, 1);
                    SharedPreferences.Editor edit = getActivity().getSharedPreferences("picture", 2).edit();
                    edit.putString("picture_path", this.f9142y.getPath());
                    edit.commit();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.menu_picture_cancel /* 2131297493 */:
                this.f9119b.dismiss();
                return;
            case R.id.menu_picture_gallery /* 2131297494 */:
                Dialog dialog = this.f9119b;
                if (dialog != null) {
                    dialog.dismiss();
                }
                Intent intent4 = new Intent("android.intent.action.GET_CONTENT");
                intent4.setType("image/*");
                m8850a(getActivity(), intent4, 0);
                return;
            case R.id.yellow_face /* 2131298465 */:
                LayoutAdapter.m8900a(this.f9134q, this.f9126i, this.f9108O);
                return;
            default:
                return;
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f9118a = 2;
        this.f9133p.setVisibility(8);
    }

    /* renamed from: c */
    private InputMethodManager m8843c() {
        if (this.f9110Q == null) {
            this.f9110Q = (InputMethodManager) getActivity().getSystemService("input_method");
        }
        return this.f9110Q;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() != R.id.chat_btn_send_voice) {
            return false;
        }
        if (FileUtils.m5027a() > 20) {
            this.f9127j.m8901a(motionEvent, this.f9123f, this.f9109P);
            return true;
        }
        NToast.shortToast(this.mContext, (int) R.string.sd_no_storage_space);
        return true;
    }

    /* renamed from: a */
    public final void m8847a(ChatListView chatListView, InputText inputText, View view, View view2, View view3, boolean z) {
        if (!MainActivity.m7895b()) {
            ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
        }
        this.f9118a = 2;
        view2.setVisibility(0);
        view.setVisibility(8);
        view3.setVisibility(8);
        if (z) {
            LayoutAdapter.m8898a(m8843c(), inputText, chatListView);
        } else {
            LayoutAdapter.m8899a(m8843c(), this.f9128k);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    @Override // android.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r9, int r10, android.content.Intent r11) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p169im.p172c.ProMessageFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // com.cnlaunch.x431pro.activity.golo.BaseGoloFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f9096C.f12677a != 2) {
            NoticeMessageHandler m8784a = NoticeMessageHandler.m8784a(getActivity());
            m8784a.f9201d.remove(this.f9122e.f24076a);
        }
        try {
            if (this.f9112S != null && !getActivity().isFinishing()) {
                this.f9112S.mo6036a(this.f9095B);
            }
            MessageListenerProvider.m8713a((MessageDealHandler) this.f9105L);
        } catch (Exception e) {
            Log.e("Sanda", "ProMessage onDestroyView() error:" + e.toString());
        }
        GoloOBManager.m8721a().m8719a(this.f9117X);
        IMPresenter.m8804a(getActivity()).m8793c(this.f9122e.f24076a);
        m8841d();
    }

    /* renamed from: d */
    private void m8841d() {
        SelectDialog selectDialog = this.f9121d;
        if (selectDialog != null) {
            selectDialog.dismiss();
        }
        Dialog dialog = this.f9119b;
        if (dialog != null) {
            dialog.dismiss();
        }
        DealDiagMessageHandler.m8673a().m8655g();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        m8841d();
        LayoutAdapter layoutAdapter = this.f9127j;
        if (layoutAdapter != null && layoutAdapter.f8996i != null && layoutAdapter.f8996i.isPlaying()) {
            layoutAdapter.f8996i.stop();
            layoutAdapter.f8995h.f24068m = false;
            layoutAdapter.f8991c.sendEmptyMessage(10000);
        }
        PreferencesManager.m9595a(this.mContext).m9588a("current_visible_promessagefragment_room_id", "");
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final void mo5996a(int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent);
    }

    /* renamed from: a */
    private void m8850a(Activity activity, Intent intent, int i) {
        if (activity != null) {
            activity.startActivityForResult(intent, i);
        } else {
            startActivityForResult(intent, i);
        }
    }

    /* compiled from: ProMessageFragment.java */
    /* renamed from: com.cnlaunch.im.c.j$b */
    /* loaded from: classes.dex */
    public class HandlerC1714b extends Handler {
        public HandlerC1714b() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            if (message2.what == 8) {
                ProMessageFragment.this.f9143z.setVisibility(GoloTools.m6964a(ProMessageFragment.this.mContext) ? 8 : 0);
            } else {
                super.handleMessage(message2);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final boolean mo5995a(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 67 && keyEvent.getAction() == 0) {
            LayoutAdapter.m8896a(this.f9128k);
            return true;
        }
        return false;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        InputText inputText = this.f9128k;
        if (inputText != null) {
            inputText.clearFocus();
        }
        PreferencesManager.m9595a(this.mContext).m9588a("current_visible_promessagefragment_room_id", this.f9122e.f24076a);
        IMPresenter.m8804a(this.mContext).m8793c(this.f9122e.f24076a);
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final long mo5997a() {
        return this.f9095B;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f9118a == 1) {
            m8847a(this.f9123f, this.f9128k, this.f9132o, this.f9131n, this.f9133p, false);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m8848a(ProMessageFragment proMessageFragment, int i) {
        ChatMessage item = proMessageFragment.f9124g.getItem(i);
        switch (item.m218a()) {
            case 1:
                try {
                    if (item.m192p().has("check_report")) {
                        String string = new JSONObject(ChatMessage.m213a(item.f24063h, "check_report")).getString(Annotation.URL);
                        Intent intent = new Intent(proMessageFragment.getActivity(), GoloFunctionActivity.class);
                        intent.setAction("ACTION_REPORT");
                        intent.putExtra(Annotation.URL, string);
                        proMessageFragment.getActivity().startActivity(intent);
                        proMessageFragment.getActivity().getParent().overridePendingTransition(R.anim.activity_right_to_left_in, R.anim.activity_right_to_left_out);
                        return;
                    } else if (item.m192p().has("check_appraisal")) {
                        String string2 = new JSONObject(ChatMessage.m213a(item.f24063h, "check_appraisal")).getString("id");
                        if (TextUtils.isEmpty(string2)) {
                            NToast.shortToast(proMessageFragment.getActivity(), (int) R.string.tip_fail_to_open);
                            return;
                        }
                        Intent intent2 = new Intent(proMessageFragment.getActivity(), GoloFunctionActivity.class);
                        intent2.setAction("ACTION_APPRAISE");
                        intent2.putExtra("id", string2);
                        proMessageFragment.getActivity().startActivity(intent2);
                        proMessageFragment.getActivity().getParent().overridePendingTransition(R.anim.activity_right_to_left_in, R.anim.activity_right_to_left_out);
                        return;
                    } else if (item.m192p().has("news")) {
                        JSONArray jSONArray = new JSONArray(item.m192p().getString("news"));
                        if (jSONArray.length() > 1) {
                            String string3 = jSONArray.getJSONObject(0).getString("content_url");
                            Intent intent3 = new Intent(proMessageFragment.getActivity(), GoloFunctionActivity.class);
                            intent3.setAction("ACTION_REPORT");
                            intent3.putExtra(Annotation.URL, string3);
                            proMessageFragment.getActivity().startActivity(intent3);
                            proMessageFragment.getActivity().getParent().overridePendingTransition(R.anim.activity_right_to_left_in, R.anim.activity_right_to_left_out);
                            return;
                        }
                        return;
                    } else if (item.m192p().has("report")) {
                        String string4 = item.m192p().getString("report");
                        Intent intent4 = new Intent(proMessageFragment.getActivity(), GoloFunctionActivity.class);
                        intent4.setAction("ACTION_REPORT");
                        intent4.putExtra(Annotation.URL, string4);
                        proMessageFragment.getActivity().startActivity(intent4);
                        proMessageFragment.getActivity().getParent().overridePendingTransition(R.anim.activity_right_to_left_in, R.anim.activity_right_to_left_out);
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    NToast.shortToast(proMessageFragment.getActivity(), (int) R.string.tip_fail_to_open);
                    return;
                }
            case 2:
                LayoutAdapter layoutAdapter = proMessageFragment.f9127j;
                if (item.f24061f.equalsIgnoreCase(ChatMessage.EnumC4748b.failed.name()) && item.f24060e.equalsIgnoreCase(item.f24057b)) {
                    NToast.longToast(layoutAdapter.f8989a, (int) R.string.play_voice_failed);
                    return;
                }
                try {
                    if (layoutAdapter.f8995h != null && layoutAdapter.f8995h.f24068m) {
                        layoutAdapter.f8995h.f24068m = false;
                        layoutAdapter.f8996i.stop();
                        if (layoutAdapter.f8995h.f24056a == item.f24056a) {
                            ChatManager.m8741a(layoutAdapter.f8989a).m8736b(layoutAdapter.f8995h);
                            layoutAdapter.f8991c.sendEmptyMessage(10000);
                            return;
                        }
                    }
                    layoutAdapter.f8995h = item;
                    if (layoutAdapter.f8995h.m197k() != null) {
                        if (!layoutAdapter.f8995h.m194n()) {
                            layoutAdapter.f8995h.m193o();
                            ChatManager.m8741a(layoutAdapter.f8989a).m8736b(layoutAdapter.f8995h);
                        }
                        layoutAdapter.f8995h.f24068m = true;
                        if (layoutAdapter.f8996i == null) {
                            layoutAdapter.f8996i = new MediaPlayer();
                        } else if (layoutAdapter.f8996i.isPlaying()) {
                            layoutAdapter.f8996i.stop();
                        }
                        layoutAdapter.f8996i.reset();
                        layoutAdapter.f8996i.setDataSource(layoutAdapter.f8995h.m197k());
                        if (layoutAdapter.f8997j) {
                            layoutAdapter.f8996i.setAudioStreamType(0);
                        }
                        layoutAdapter.f8996i.setOnCompletionListener(layoutAdapter.f8998k);
                        layoutAdapter.f8996i.prepare();
                        layoutAdapter.f8996i.start();
                        layoutAdapter.f8991c.sendEmptyMessage(10000);
                        return;
                    }
                    return;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return;
                } catch (IllegalStateException e3) {
                    e3.printStackTrace();
                    return;
                }
            case 3:
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                for (int i3 = 0; i3 < proMessageFragment.f9124g.getCount(); i3++) {
                    ChatMessage item2 = proMessageFragment.f9124g.getItem(i3);
                    if (item2.m218a() == 3) {
                        MessageObj messageObj = new MessageObj();
                        messageObj.f24084a = item2.m207c();
                        messageObj.f24086c = item2.m197k();
                        messageObj.f24087d = item2.m204d();
                        arrayList.add(messageObj);
                        i2++;
                        if (i3 == i) {
                            i = i2 - 1;
                        }
                    }
                }
                Intent intent5 = new Intent("android.intent.action.VIEW");
                intent5.putExtra("BUNDLE", arrayList);
                intent5.putExtra("IMAGEPOSITION", i);
                intent5.setClass(proMessageFragment.getActivity(), ShowImageDetailActivity.class);
                proMessageFragment.getActivity().startActivity(intent5);
                return;
            case 4:
            default:
                return;
            case 5:
                C2778n.m4918a(proMessageFragment.getActivity());
                proMessageFragment.f9114U = item.m211b();
                Bundle bundle = new Bundle();
                bundle.putString("target_id", proMessageFragment.f9114U);
                bundle.putBoolean("isFriend", false);
                if (MainActivity.m7895b()) {
                    if (C2778n.m4905b()) {
                        return;
                    }
                    NToast.shortToast(proMessageFragment.mContext, (int) R.string.remotediagnoseconnected);
                    return;
                }
                IMPresenter.m8804a(proMessageFragment.getActivity()).m8800a(UserDetailFragment.class.getName(), bundle);
                return;
            case 6:
                C2778n.m4918a(proMessageFragment.getActivity());
                if (!new File(item.m197k()).exists()) {
                    NToast.shortToast(proMessageFragment.mContext, (int) R.string.report_file_unexists);
                    return;
                }
                try {
                    if (item.m197k().endsWith("x431")) {
                        if (!MainActivity.m7895b()) {
                            proMessageFragment.bundle.putString("report_name", item.m197k());
                            ((IMActivity) proMessageFragment.getActivity()).f8866n = DiagnosisPlaybackFragment.class.getName();
                            proMessageFragment.replaceFragment(DiagnosisPlaybackFragment.class.getName(), proMessageFragment.bundle);
                            return;
                        }
                        NToast.shortToast(proMessageFragment.mContext, (int) R.string.remoteing_no_playback);
                        return;
                    } else if (item.m197k().endsWith(".pdf")) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("report_name", item.m197k());
                        if (MainActivity.m7895b()) {
                            Intent intent6 = new Intent(proMessageFragment.mContext, PDFReportActivity.class);
                            intent6.putExtras(bundle2);
                            proMessageFragment.startActivity(intent6);
                            return;
                        }
                        ((IMActivity) proMessageFragment.getActivity()).f8866n = PDFReportFragment.class.getName();
                        proMessageFragment.replaceFragment(PDFReportFragment.class.getName(), bundle2);
                        return;
                    } else {
                        Uri fromFile = Uri.fromFile(new File(item.m197k()));
                        Intent intent7 = new Intent("android.intent.action.VIEW");
                        intent7.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
                        intent7.setDataAndType(fromFile, ChatMessage.m213a(item.f24063h, Annotation.MIMETYPE));
                        proMessageFragment.getActivity().startActivity(intent7);
                        return;
                    }
                } catch (Exception unused) {
                    NToast.shortToast(proMessageFragment.mContext, (int) R.string.can_not_open);
                    return;
                }
            case 7:
                LayoutAdapter layoutAdapter2 = proMessageFragment.f9127j;
                Log.e("Sanda", "ShowVodeo");
                MessageObj messageObj2 = new MessageObj();
                messageObj2.f24085b = item.m197k();
                messageObj2.f24088e = ChatMessage.m213a(item.f24063h, "item_id");
                messageObj2.f24084a = item.m207c();
                messageObj2.f24087d = item.m204d();
                messageObj2.f24086c = item.m196l();
                if (item.m198j() != null && !item.m198j().equals("null")) {
                    messageObj2.f24089f = Integer.parseInt(item.m198j());
                }
                if (layoutAdapter2.m8895a(messageObj2)) {
                    Intent intent8 = new Intent(layoutAdapter2.f8989a, GoloFunctionActivity.class);
                    intent8.setAction("ACTION_VIDEO_PLAY");
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelable("MEDIA", messageObj2);
                    intent8.putExtra("BUNDLE", bundle3);
                    layoutAdapter2.f8989a.startActivity(intent8);
                    return;
                }
                return;
        }
    }
}
