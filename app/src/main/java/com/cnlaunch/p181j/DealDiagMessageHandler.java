package com.cnlaunch.p181j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p179i.UserInfoCache;
import com.cnlaunch.p169im.p180j.SendMessageTask;
import com.cnlaunch.p169im.widget.SelectDialog;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.golo.function.GoloFunctionActivity;
import com.cnlaunch.x431pro.module.p272k.p274b.User;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.p210a.RemoteDiagObserve;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import message.model.ChatMessage;
import message.model.ChatRoom;
import message.p378a.MessageParameters;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.j.c */
/* loaded from: classes.dex */
public class DealDiagMessageHandler {

    /* renamed from: a */
    public static DealDiagMessageHandler f9425a;

    /* renamed from: e */
    public Context f9429e;

    /* renamed from: b */
    public ChatMessageExplain f9426b = new ChatMessageExplain();

    /* renamed from: i */
    private ChatRoom f9433i = null;

    /* renamed from: j */
    private HandlerC1765a f9434j = new HandlerC1765a(this, (byte) 0);

    /* renamed from: c */
    public Bundle f9427c = null;

    /* renamed from: d */
    public InterfaceC1766b f9428d = null;

    /* renamed from: f */
    public ResultQueue f9430f = new C1769f(this);

    /* renamed from: g */
    public SelectDialog f9431g = null;

    /* renamed from: h */
    public String f9432h = null;

    /* compiled from: DealDiagMessageHandler.java */
    /* renamed from: com.cnlaunch.j.c$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1766b {
        /* renamed from: a */
        void mo7468a();
    }

    /* renamed from: a */
    public static DealDiagMessageHandler m8673a() {
        if (f9425a == null) {
            synchronized (DealDiagMessageHandler.class) {
                if (f9425a == null) {
                    f9425a = new DealDiagMessageHandler();
                }
            }
        }
        return f9425a;
    }

    /* renamed from: a */
    public final void m8667a(String str, String str2, Object obj) {
        this.f9433i = new ChatRoom(str, m8670a(str), MessageParameters.EnumC4721a.single);
        ChatMessage m190a = this.f9433i.m190a(10);
        m190a.m214a("text", (Object) str2);
        m190a.m214a("content", obj);
        new SendMessageTask().m256e(m190a);
    }

    /* renamed from: a */
    public final void m8669a(String str, int i, Object obj) {
        m8667a(str, this.f9429e.getString(i), obj);
    }

    /* renamed from: b */
    public final void m8666b() {
        try {
            ExplainResult explainResult = new ExplainResult(this.f9430f.m8685a(), 0);
            explainResult.f9478id = this.f9430f.f9419c;
            m8669a(explainResult.f9478id, R.string.remote_diag_fail, explainResult.toJsonString(ExplainResult.STOP));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final String m8670a(String str) {
        String m8710a = UserInfoCache.m8711a(this.f9429e, true).m8710a(str);
        return TextUtils.isEmpty(m8710a) ? str : m8710a;
    }

    /* renamed from: c */
    public final void m8663c() {
        Intent intent = new Intent(this.f9429e, GoloFunctionActivity.class);
        intent.setAction("ACTION_SELECT_SOFT");
        this.f9429e.startActivity(intent);
    }

    /* renamed from: d */
    public final void m8661d() {
        String str = this.f9430f.f9419c;
        if (TextUtils.isEmpty(str)) {
            NToast.shortToast(this.f9429e, "Error Retry agrin");
            return;
        }
        ExplainResult explainResult = new ExplainResult(2, 0);
        if (LangManager.m9469a().equals("zh_CN") || LangManager.m9469a().equals("zh")) {
            explainResult.carName = this.f9427c.getString("carname_zh") + this.f9427c.getString("versionlist");
        } else {
            explainResult.carName = this.f9427c.getString("carname") + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f9427c.getString("versionlist");
        }
        explainResult.f9478id = str;
        explainResult.serialNum = this.f9427c.getString("serialNum");
        if (this.f9430f.m8683b()) {
            this.f9430f.m8684a(str);
            ResultQueue resultQueue = this.f9430f;
            resultQueue.f9420d = 2;
            resultQueue.m8682b(explainResult);
        }
        m8669a(str, R.string.tip_remote_askfor_request, explainResult.toJsonString(ExplainResult.ASKFOR));
        Context context = this.f9429e;
        LoadDialog.m4683a(context, context.getString(R.string.custom_diaglog_message), new DialogInterface$OnCancelListenerC1767d(this, str, explainResult));
        Message message2 = new Message();
        message2.what = 11;
        message2.obj = explainResult;
        this.f9434j.sendMessageDelayed(message2, 120000L);
    }

    /* renamed from: b */
    public final void m8664b(String str) {
        this.f9430f.m8684a(str);
        if (this.f9427c == null) {
            m8663c();
        } else {
            this.f9434j.obtainMessage(9).sendToTarget();
        }
    }

    /* renamed from: a */
    public final void m8668a(String str, String str2) {
        if (MainActivity.m7907a()) {
            NToast.longToast(this.f9429e, (int) R.string.tip_must_stop_diag_before, 17);
            this.f9430f.m8681c();
            return;
        }
        ExplainResult explainResult = new ExplainResult(1, 0);
        explainResult.f9478id = str;
        explainResult.cmd = "invite";
        this.f9433i = new ChatRoom(str, m8670a(str), MessageParameters.EnumC4721a.single);
        ChatMessage m190a = this.f9433i.m190a(10);
        m190a.m214a("text", (Object) this.f9429e.getString(R.string.request_diagnose, m8657f()));
        m190a.m214a("content", explainResult.toJsonString("invite"));
        if (str2 == null) {
            str2 = "";
        }
        m190a.m215a(str2);
        new SendMessageTask().m256e(m190a);
        this.f9430f.m8684a(str);
        this.f9430f.m8682b(explainResult);
        LoadDialog.m4681b(this.f9429e);
        Context context = this.f9429e;
        LoadDialog.m4683a(context, context.getString(R.string.custom_diaglog_message), new DialogInterface$OnCancelListenerC1768e(this, explainResult));
        Message message2 = new Message();
        message2.what = 11;
        message2.obj = explainResult;
        this.f9434j.sendMessageDelayed(message2, 120000L);
    }

    /* renamed from: a */
    public final void m8672a(int i, ExplainResult explainResult) {
        SelectDialog selectDialog = this.f9431g;
        if (selectDialog != null && selectDialog.isShowing()) {
            this.f9431g.dismiss();
        }
        ReportProduceTool.m5233a().m5224c();
        GoloLightManager.m8495c();
        if (MainActivity.m7907a() || MainActivity.m7895b()) {
            m8667a(explainResult.f9478id, this.f9429e.getString(R.string.diag_in_bussnise, m8659e()), explainResult.toJsonString(ExplainResult.REFUSE));
            NToast.longToast(this.f9429e, (int) R.string.tip_must_stop_diag_before, 17);
            this.f9430f.m8681c();
            return;
        }
        RemoteDiagObserve.m7938a(this.f9429e, GoloDBManager.m8756a(this.f9429e).m8749b(explainResult.f9478id));
        if (i == 1) {
            m8669a(explainResult.f9478id, R.string.remote_diag_accept, explainResult.toJsonString(ExplainResult.ACCEPT));
        }
        if (RemoteDiagObserve.m7937b()) {
            NToast.shortToast(this.f9429e, (int) R.string.dialog_remotediag_handler_0B);
            this.f9430f.m8681c();
            return;
        }
        RemoteDiagObserve.m7939a(1);
        Intent intent = new Intent("show_remotediag");
        Bundle bundle = new Bundle();
        bundle.putInt("identify", i);
        bundle.putString("userId", explainResult.f9478id);
        bundle.putString("userName", m8670a(explainResult.f9478id));
        bundle.putString("serialNum", explainResult.serialNum);
        bundle.putString("carName", explainResult.carName);
        bundle.putString("lat", explainResult.location.f9480a);
        bundle.putString("lon", explainResult.location.f9481b);
        if (i == 0) {
            bundle.putString("ip", explainResult.f9479ip);
            bundle.putInt("port", Integer.parseInt(explainResult.port));
            bundle.putString("domain", explainResult.domain);
            Bundle bundle2 = this.f9427c;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
        }
        intent.putExtras(bundle);
        this.f9429e.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DealDiagMessageHandler.java */
    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.cnlaunch.j.c$a */
    /* loaded from: classes.dex */
    public class HandlerC1765a extends Handler {

        /* renamed from: a */
        MessageDialog f9435a;

        private HandlerC1765a() {
            this.f9435a = null;
        }

        /* synthetic */ HandlerC1765a(DealDiagMessageHandler dealDiagMessageHandler, byte b) {
            this();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            String str;
            if (DealDiagMessageHandler.this.f9431g != null && DealDiagMessageHandler.this.f9431g.isShowing()) {
                DealDiagMessageHandler.this.f9431g.dismiss();
            }
            int i = message2.what;
            if (i == 1) {
                m8654a(R.string.remote_diag_fail);
            } else if (i == 3) {
                String str2 = (String) message2.obj;
                if (!TextUtils.isEmpty(str2)) {
                    LoadDialog.m4681b(DealDiagMessageHandler.this.f9429e);
                    MessageDialog messageDialog = this.f9435a;
                    if (messageDialog != null && messageDialog.isShowing()) {
                        this.f9435a.dismiss();
                        this.f9435a = null;
                    }
                    this.f9435a = new MessageDialog(DealDiagMessageHandler.this.f9429e);
                    MessageDialog messageDialog2 = this.f9435a;
                    String string = DealDiagMessageHandler.this.f9429e.getString(R.string.remote_dialog_title);
                    String string2 = DealDiagMessageHandler.this.f9429e.getString(R.string.btn_confirm);
                    messageDialog2.m4716b(string);
                    messageDialog2.m4715c(str2);
                    messageDialog2.setCancelable(true);
                    messageDialog2.m4718a(string2, (View.OnClickListener) null);
                    messageDialog2.show();
                    return;
                }
                m8654a(R.string.tip_other_deny_your_request);
            } else if (i == 7) {
                ExplainResult explainResult = (ExplainResult) message2.obj;
                LoadDialog.m4681b(DealDiagMessageHandler.this.f9429e);
                MessageDialog messageDialog3 = this.f9435a;
                if (messageDialog3 != null && messageDialog3.isShowing()) {
                    this.f9435a.dismiss();
                    this.f9435a = null;
                }
                this.f9435a = new MessageDialog(DealDiagMessageHandler.this.f9429e, DealDiagMessageHandler.this.f9429e.getString(R.string.askfor_remotediag, DealDiagMessageHandler.this.m8670a(explainResult.f9478id)));
                this.f9435a.m4719a(R.string.yes, true, new View$OnClickListenerC1780q(this, explainResult));
                this.f9435a.m4717b(R.string.no, true, new View$OnClickListenerC1781r(this, explainResult));
                this.f9435a.show();
            } else {
                switch (i) {
                    case 9:
                        MessageDialog messageDialog4 = this.f9435a;
                        if (messageDialog4 != null && messageDialog4.isShowing()) {
                            this.f9435a.dismiss();
                            this.f9435a = null;
                        }
                        Context context = DealDiagMessageHandler.this.f9429e;
                        Context context2 = DealDiagMessageHandler.this.f9429e;
                        Object[] objArr = new Object[1];
                        DealDiagMessageHandler dealDiagMessageHandler = DealDiagMessageHandler.this;
                        if (dealDiagMessageHandler.f9427c != null) {
                            str = dealDiagMessageHandler.f9427c.getString("carname") + "/" + dealDiagMessageHandler.f9427c.getString("carname_zh");
                        } else {
                            str = "NA";
                        }
                        objArr[0] = str;
                        this.f9435a = new MessageDialog(context, context2.getString(R.string.is_use_rightnow_soft, objArr), (byte) 0);
                        this.f9435a.setCanceledOnTouchOutside(false);
                        this.f9435a.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC1782s(this));
                        this.f9435a.m4717b(R.string.reselect_soft, true, new View$OnClickListenerC1783t(this));
                        this.f9435a.show();
                        return;
                    case 10:
                        ExplainResult explainResult2 = (ExplainResult) message2.obj;
                        MessageDialog messageDialog5 = this.f9435a;
                        if (messageDialog5 != null && messageDialog5.isShowing()) {
                            this.f9435a.dismiss();
                            this.f9435a = null;
                        }
                        if (MainActivity.m7907a() || MainActivity.m7895b()) {
                            DealDiagMessageHandler.this.m8667a(explainResult2.f9478id, DealDiagMessageHandler.this.f9429e.getString(R.string.diag_in_bussnise, DealDiagMessageHandler.this.m8659e()), explainResult2.toJsonString(ExplainResult.REFUSE));
                            DealDiagMessageHandler.this.f9430f.m8681c();
                            return;
                        }
                        this.f9435a = new MessageDialog(DealDiagMessageHandler.this.f9429e, String.format(DealDiagMessageHandler.this.f9429e.getString(R.string.is_agree_to_control_remote), DealDiagMessageHandler.this.m8670a(explainResult2.f9478id)));
                        this.f9435a.m4719a(R.string.yes, true, new View$OnClickListenerC1778o(this));
                        this.f9435a.m4717b(R.string.no, true, new View$OnClickListenerC1779p(this, explainResult2));
                        this.f9435a.show();
                        return;
                    case 11:
                        ExplainResult explainResult3 = (ExplainResult) message2.obj;
                        MessageDialog messageDialog6 = this.f9435a;
                        if (messageDialog6 != null && messageDialog6.isShowing()) {
                            this.f9435a.dismiss();
                            this.f9435a = null;
                        }
                        this.f9435a = new MessageDialog(DealDiagMessageHandler.this.f9429e, (int) R.string.remote_dialog_title, (int) R.string.tip_longtime_no_accept, false, (byte) 0);
                        this.f9435a.m4719a(R.string.btn_exit, true, new View$OnClickListenerC1774k(this, explainResult3));
                        this.f9435a.m4717b(R.string.btn_wait_argin, true, new View$OnClickListenerC1777n(this, explainResult3));
                        this.f9435a.show();
                        return;
                    case 12:
                        MessageDialog messageDialog7 = this.f9435a;
                        if (messageDialog7 == null || !messageDialog7.isShowing()) {
                            return;
                        }
                        this.f9435a.dismiss();
                        this.f9435a = null;
                        return;
                    case 13:
                        ExplainResult explainResult4 = (ExplainResult) message2.obj;
                        MessageDialog messageDialog8 = this.f9435a;
                        if (messageDialog8 != null && messageDialog8.isShowing()) {
                            this.f9435a.dismiss();
                            this.f9435a = null;
                        }
                        LoadDialog.m4681b(DealDiagMessageHandler.this.f9429e);
                        this.f9435a = new MessageDialog(DealDiagMessageHandler.this.f9429e, (int) R.string.remote_dialog_title, (int) R.string.dialog_long_time_wait_error, false, (byte) 0);
                        this.f9435a.m4719a(R.string.btn_exit, true, new View$OnClickListenerC1784u(this, explainResult4));
                        this.f9435a.m4717b(R.string.btn_wait_argin, true, new View$OnClickListenerC1775l(this, explainResult4));
                        this.f9435a.show();
                        return;
                    case 14:
                        ExplainResult explainResult5 = (ExplainResult) message2.obj;
                        LoadDialog.m4681b(DealDiagMessageHandler.this.f9429e);
                        LoadDialog.m4683a(DealDiagMessageHandler.this.f9429e, DealDiagMessageHandler.this.f9429e.getString(R.string.custom_diaglog_message), new DialogInterface$OnCancelListenerC1776m(this, explainResult5));
                        Message obtain = Message.obtain();
                        obtain.what = 13;
                        obtain.obj = explainResult5;
                        DealDiagMessageHandler.this.f9434j.sendMessageDelayed(obtain, 120000L);
                        return;
                    default:
                        super.handleMessage(message2);
                        return;
                }
            }
        }

        /* renamed from: a */
        private void m8654a(int i) {
            LoadDialog.m4681b(DealDiagMessageHandler.this.f9429e);
            MessageDialog messageDialog = this.f9435a;
            if (messageDialog != null && messageDialog.isShowing()) {
                this.f9435a.dismiss();
                this.f9435a = null;
            }
            this.f9435a = new MessageDialog(DealDiagMessageHandler.this.f9429e);
            this.f9435a.m4671a(i);
        }
    }

    /* renamed from: e */
    public final String m8659e() {
        String m9591a = PreferencesManager.m9595a(this.f9429e).m9591a("user_id");
        User user = (User) PreferencesManager.m9595a(this.f9429e).m9593a(User.class);
        if (user != null) {
            String nick_name = user.getNick_name();
            if (TextUtils.isEmpty(nick_name) || nick_name.equalsIgnoreCase("null")) {
                return user.getUser_id();
            }
            return nick_name;
        }
        return m9591a;
    }

    /* renamed from: f */
    public final String m8657f() {
        String m8659e = m8659e();
        String m9591a = PreferencesManager.m9595a(this.f9429e).m9591a("USER_PUBLIC_NAME");
        if (TextUtils.isEmpty(m9591a)) {
            return m8659e;
        }
        return m9591a + "(" + m8659e + ")";
    }

    /* renamed from: g */
    public final void m8655g() {
        SelectDialog selectDialog = this.f9431g;
        if (selectDialog != null) {
            selectDialog.dismiss();
        }
    }
}
