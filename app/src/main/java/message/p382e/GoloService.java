package message.p382e;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p160b.GoloCacheManager;
import com.cnlaunch.golo3.p164f.MessageEventCodeManager;
import com.cnlaunch.golo3.p165g.AbstractC1614h;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.golo3.p165g.Singlton;
import com.cnlaunch.p167h.C1673a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import message.XConnectionHelper;
import message.model.ChatMessage;
import message.p378a.MessageLoginManager;
import message.p378a.MessageParameters;
import message.p378a.ReportPushMsg;
import message.p378a.UnReadMsg;
import message.p379b.XmppEvent;
import message.p383f.SharePreferenceMsgUtils;
import message.p384g.DateTool;
import message.p384g.LogUtilMsg;
import message.xmpp.XConnection;
import message.xmpp.p385iq.ActivityIQ;
import message.xmpp.p385iq.ReceiptIQ;
import message.xmpp.p385iq.UpgradeIQ;
import org.apache.http.HttpHeaders;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.AbstractC4971IQ;
import org.jivesoftware.smack.packet.CustomIQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: message.e.a */
/* loaded from: classes2.dex */
public abstract class GoloService extends Service {

    /* renamed from: b */
    public static boolean f23972b = false;

    /* renamed from: c */
    public static int f23973c;

    /* renamed from: d */
    public static int f23974d;

    /* renamed from: g */
    private static Handler f23975g;

    /* renamed from: h */
    private static List<String> f23976h = new ArrayList();

    /* renamed from: a */
    private HandlerThreadC4725a f23977a;

    /* renamed from: i */
    private final int f23980i = 100001;

    /* renamed from: j */
    private Handler.Callback f23981j = new C4726b(this);

    /* renamed from: k */
    private int f23982k = 0;

    /* renamed from: l */
    private ScheduledExecutorService f23983l = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: e */
    List<ChatMessage> f23978e = new ArrayList();

    /* renamed from: f */
    List<String> f23979f = new ArrayList();

    /* renamed from: m */
    private AbstractC1614h f23984m = new C4728d(this, Looper.myLooper());

    /* renamed from: n */
    private PacketFilter f23985n = new C4730f(this);

    /* renamed from: o */
    private BroadcastReceiver f23986o = new C4731g(this);

    /* renamed from: a */
    public abstract void mo289a();

    /* renamed from: a */
    public abstract void mo283a(ChatMessage chatMessage, boolean z);

    /* renamed from: b */
    public abstract void mo281b();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ int m286a(GoloService goloService) {
        goloService.f23982k = 0;
        return 0;
    }

    /* renamed from: a */
    private static void m287a(String str) {
        f23976h.add(str);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f23978e.clear();
        m287a("golo_sys");
        m287a("600000");
        m287a("200000");
        m287a("608833");
        m287a("608834");
        m287a("1242746");
        m287a("500092519");
        LogUtilMsg.m227a("GoloService", "onCreate");
        XConnection.getInstance().setPacketFilter(this.f23985n);
        this.f23977a = new HandlerThreadC4725a("XMPP Connection");
        this.f23977a.start();
        f23975g = new Handler(this.f23977a.getLooper(), this.f23981j);
        if (f23973c == 0) {
            GoloCacheManager.m9176a(this.f23984m);
            f23973c = 1;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f23986o, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f23977a.quit();
        unregisterReceiver(this.f23986o);
        XConnectionHelper.m311c();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            m271g();
        }
        String action = intent == null ? null : intent.getAction();
        if (action != null && "action_login".equals(action)) {
            m271g();
        }
        return super.onStartCommand(intent, 1, i2);
    }

    /* compiled from: GoloService.java */
    /* renamed from: message.e.a$a */
    /* loaded from: classes2.dex */
    class HandlerThreadC4725a extends HandlerThread {
        public HandlerThreadC4725a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    private void m288a(int i) {
        this.f23983l.schedule(new RunnableC4727c(this), i, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m278b(ChatMessage chatMessage, boolean z) {
        int i = 0;
        for (String str : f23976h) {
            if (chatMessage.f24057b.equals(str)) {
                i++;
            }
        }
        if (i == 0) {
            mo283a(chatMessage, z);
        }
    }

    /* renamed from: c */
    public void mo276c() {
        ((MessageEventCodeManager) Singlton.m9123a(MessageEventCodeManager.class)).m9126a(2455, new Object[0]);
    }

    /* renamed from: d */
    public static String m274d() {
        return ApplicationConfig.m9181a();
    }

    /* renamed from: a */
    public static void m282a(Packet packet) {
        ActivityIQ activityIQ;
        if (packet instanceof CustomIQ) {
            try {
                if (((CustomIQ) packet).customType == CustomIQ.Type.SHARE) {
                    XmppEvent xmppEvent = new XmppEvent(XmppEvent.EnumC4723a.receive_share);
                    xmppEvent.f23967b = packet;
                    xmppEvent.m9144a();
                } else if (((CustomIQ) packet).getType() == AbstractC4971IQ.Type.SET) {
                    if (!MessageParameters.f23954s) {
                        if (!f23972b) {
                            Log.e("send_receive_offline_msg_end", "send_receive_offline_msg_end");
                            new XmppEvent(XmppEvent.EnumC4723a.receive_offline_msg_end).m9144a();
                        }
                    } else {
                        ((MessageEventCodeManager) Singlton.m9123a(MessageEventCodeManager.class)).m9126a(2455, new Object[0]);
                    }
                    ((MessageEventCodeManager) Singlton.m9123a(MessageEventCodeManager.class)).m9126a(2449, new Object[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (packet instanceof UpgradeIQ) {
            XmppEvent xmppEvent2 = new XmppEvent(XmppEvent.EnumC4723a.receive_upgrade_bin);
            xmppEvent2.f23967b = packet;
            xmppEvent2.m9144a();
        } else if ((packet instanceof ActivityIQ) && (activityIQ = (ActivityIQ) packet) != null && Integer.parseInt(activityIQ.getActivityType()) == 3 && activityIQ.getRing().equals(DiagnoseConstants.UI_Type_EXT1_SPECIAL_FUNCTION_DYNAMICEVENT_ID)) {
            ((ReportPushMsg) Singlton.m9123a(ReportPushMsg.class)).m305a("nullpostid");
            Log.i("anqi", "iq = " + activityIQ.getPost_id());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static void m271g() {
        if (MessageLoginManager.m306b(ApplicationConfig.m9181a()) != null) {
            f23975g.obtainMessage(100001, null).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m277b(Packet packet) {
        ActivityIQ activityIQ = (ActivityIQ) packet;
        String event_id = activityIQ.getEvent_id();
        if (TextUtils.isEmpty(event_id)) {
            return;
        }
        UnReadMsg unReadMsg = (UnReadMsg) Singlton.m9123a(UnReadMsg.class);
        String gid = activityIQ.getGid();
        String activityType = activityIQ.getActivityType();
        if (C1621v.m9121a(gid) || gid.equals("0")) {
            gid = String.format("%s%s", "shop_", event_id);
        }
        if (!unReadMsg.f23959c.containsKey(gid)) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            JSONArray jSONArray = new JSONArray();
            if (activityType.equals("1")) {
                jSONArray.put(0);
                jSONArray.put(1);
            } else if (activityType.equals("2")) {
                jSONArray.put(1);
                jSONArray.put(0);
            }
            concurrentHashMap.put(event_id, jSONArray);
            unReadMsg.f23959c.put(gid, new JSONObject(concurrentHashMap));
        } else {
            JSONObject jSONObject = unReadMsg.f23959c.get(gid);
            if (!jSONObject.has(event_id)) {
                JSONArray jSONArray2 = new JSONArray();
                if (activityType.equals("1")) {
                    jSONArray2.put(0);
                    jSONArray2.put(1);
                } else if (activityType.equals("2")) {
                    jSONArray2.put(1);
                    jSONArray2.put(0);
                }
                try {
                    jSONObject.put(event_id, jSONArray2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    JSONArray jSONArray3 = jSONObject.getJSONArray(event_id);
                    if (activityType.equals("1")) {
                        jSONArray3.put(1, jSONArray3.getInt(1) + 1);
                    } else if (activityType.equals("2")) {
                        jSONArray3.put(0, jSONArray3.getInt(0) + 1);
                    }
                    jSONObject.put(event_id, jSONArray3);
                } catch (Exception unused) {
                }
            }
            unReadMsg.f23959c.put(gid, jSONObject);
        }
        String str = unReadMsg.f23961e;
        Map<String, JSONObject> map = unReadMsg.f23959c;
        if (map != null) {
            JSONObject jSONObject2 = new JSONObject(map);
            SharedPreferences.Editor edit = unReadMsg.f23962f.edit();
            edit.putString(UnReadMsg.m304a(str), jSONObject2.toString());
            edit.commit();
        }
        SharedPreferences.Editor edit2 = unReadMsg.f23962f.edit();
        edit2.putBoolean(UnReadMsg.m304a("event_msg_status"), true);
        edit2.commit();
        unReadMsg.m9126a(Opcodes.D2F, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m280b(GoloService goloService) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) goloService.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
            int i = goloService.f23982k;
            if (i < 20) {
                goloService.m288a(1);
            } else if (i < 60) {
                goloService.m288a(5);
            } else {
                goloService.m288a(30);
            }
            goloService.f23982k++;
            StringBuilder sb = new StringBuilder();
            sb.append(goloService.f23982k);
            LogUtilMsg.m227a("login_count", sb.toString());
            C1673a.m8965a().m8964a("ReLogin Count:" + goloService.f23982k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m284a(GoloService goloService, Packet packet) {
        if (!MessageParameters.f23954s && MessageParameters.f23949n) {
            MessageParameters.f23949n = false;
        }
        ChatMessage chatMessage = new ChatMessage();
        Message message2 = (Message) packet;
        if (message2.getType() == Message.Type.chat) {
            chatMessage.f24057b = message2.getFrom().split("@")[0];
            chatMessage.f24058c = MessageParameters.EnumC4721a.single.name();
            chatMessage.f24060e = message2.getFrom().split("@")[0];
            chatMessage.f24067l = packet.getPacketID();
        } else {
            chatMessage.f24057b = message2.getTo().split("@")[0];
            chatMessage.f24058c = MessageParameters.EnumC4721a.group.name();
            chatMessage.f24060e = message2.getFrom().split("@")[0];
            chatMessage.f24067l = packet.getPacketID();
        }
        if (chatMessage.f24060e.equals(ApplicationConfig.m9181a())) {
            return;
        }
        chatMessage.f24061f = ChatMessage.EnumC4748b.done.name();
        chatMessage.f24062g = Long.valueOf(message2.getStamp());
        if (MessageParameters.f23954s) {
            if (chatMessage.f24057b.equals(MessageParameters.f23936a)) {
                Log.i("yzp", "messageId-" + chatMessage.f24067l + "-" + DateTool.m241a().m239a(message2.getStamp()));
                boolean sendPacket = XConnection.getInstance().sendPacket(new ReceiptIQ(packet.getPacketID(), message2.getStamp()));
                Log.i("yzp", "sendPacket-" + sendPacket + "-" + DateTool.m241a().m239a(message2.getStamp()));
            }
            if (message2.getStamp() > SharePreferenceMsgUtils.m248a().m243b().longValue()) {
                LogUtilMsg.m227a("saveLastMessageTime", "saveLastMessageTime");
                SharePreferenceMsgUtils.m248a().m247a(Long.valueOf(message2.getStamp()));
            }
        }
        chatMessage.f24059d = ChatMessage.EnumC4747a.unread.name();
        chatMessage.f24063h = message2.getBody();
        if (MessageParameters.f23954s) {
            goloService.m278b(chatMessage, false);
            return;
        }
        if (chatMessage.f24057b.equals(MessageParameters.f23936a)) {
            LogUtilMsg.m227a("RECEIVE_LITTLE_HELP_MSG", packet.getPacketID());
            goloService.f23979f.add(packet.getPacketID());
        }
        goloService.f23978e.add(chatMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ void m275c(Packet packet) {
        String shareType = ((CustomIQ) packet).getShareType();
        if (TextUtils.isEmpty(shareType)) {
            return;
        }
        if (shareType.equals("41") || shareType.equals("42") || shareType.equals(DiagnoseConstants.FEEDBACK_MESSAGEBOX)) {
            UnReadMsg unReadMsg = (UnReadMsg) Singlton.m9123a(UnReadMsg.class);
            if (TextUtils.isEmpty(shareType)) {
                return;
            }
            if (!unReadMsg.f23958b.containsKey(shareType)) {
                unReadMsg.f23958b.put(shareType, 1);
            } else {
                unReadMsg.f23958b.put(shareType, Integer.valueOf(unReadMsg.f23958b.get(shareType).intValue() + 1));
            }
            unReadMsg.f23958b.get(shareType).intValue();
            unReadMsg.m303a(unReadMsg.f23960d, unReadMsg.f23958b);
            unReadMsg.m9126a(Opcodes.DCMPG, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m279b(GoloService goloService, Packet packet) {
        UpgradeIQ upgradeIQ = (UpgradeIQ) packet;
        Intent intent = new Intent(HttpHeaders.UPGRADE);
        intent.putExtra("TYPE", upgradeIQ.getUpgradeType());
        intent.putExtra("VERSION", upgradeIQ.getVersion());
        intent.putExtra("SERIALNO", upgradeIQ.getSerialNo());
        intent.putExtra("UPDATETIME", upgradeIQ.getUpdateTime());
        goloService.sendBroadcast(intent);
    }
}
