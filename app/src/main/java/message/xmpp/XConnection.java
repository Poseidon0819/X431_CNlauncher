package message.xmpp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p164f.MessageEventCodeManager;
import com.cnlaunch.golo3.p165g.Singlton;
import com.cnlaunch.p167h.C1673a;
import message.XConnectionHelper;
import message.p378a.MessageParameters;
import message.p379b.XmppEvent;
import message.p384g.DateTool;
import message.p384g.LogTracker;
import message.p384g.LogUtilMsg;
import message.p384g.MsgUtils;
import message.p384g.TimeRender;
import message.xmpp.iqProvider.CustomIQProvider;
import message.xmpp.iqProvider.UpgradeIQProvider;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.AbstractC4971IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.StreamError;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smackx.packet.StatusPresence;

/* loaded from: classes2.dex */
public class XConnection {
    public static AlarmManager alarmManager = null;
    private static XConnection instance = null;
    public static PendingIntent pIntTimeout = null;
    public static PendingIntent pIntent = null;
    private static long pingStamp = 0;
    public static String userId = "";
    private XMPPConnection connection;
    private ConnectionListener connectionListener;
    private PacketFilter packetCustomFilter;
    private PacketFilter packetFilter;
    private PacketListener packetListener;
    private PacketListener packetShareListener;
    private int timeoutCount;
    public static BroadcastReceiver AlarmReceiver = new BroadcastReceiver() { // from class: message.xmpp.XConnection.2
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (!MsgUtils.m222a(ApplicationConfig.f7802a, MessageParameters.f23953r)) {
                new XmppEvent(XmppEvent.EnumC4723a.service_stop).m9144a();
                C1673a.m8965a().m8964a("GoloService is Stop!");
            }
            XConnection.pIntTimeout = PendingIntent.getBroadcast(ApplicationConfig.f7802a, 1, new Intent(MessageParameters.f23946k), NTLMConstants.FLAG_UNIDENTIFIED_10);
            if (XConnection.alarmManager == null) {
                XConnection.alarmManager = (AlarmManager) ApplicationConfig.f7802a.getSystemService("alarm");
            }
            XConnection.alarmManager.setRepeating(2, SystemClock.elapsedRealtime(), 10000L, XConnection.pIntTimeout);
        }
    };
    private static boolean isStartTimeout = true;
    private static String timeRepeat_cu = "";
    private static String timeRepeat_la = "";
    public static BroadcastReceiver AlarmTimeoutReceiver = new BroadcastReceiver() { // from class: message.xmpp.XConnection.3
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String unused = XConnection.timeRepeat_cu = TimeRender.m219a();
            if (XConnection.timeRepeat_la.equals(XConnection.timeRepeat_cu)) {
                return;
            }
            String unused2 = XConnection.timeRepeat_la = XConnection.timeRepeat_cu;
            if (XConnection.isStartTimeout) {
                long unused3 = XConnection.pingStamp = System.currentTimeMillis();
                boolean unused4 = XConnection.isStartTimeout = false;
            }
            Ping ping = new Ping();
            if (XConnection.instance == null) {
                XConnection unused5 = XConnection.instance = new XConnection();
            }
            XConnection.instance.sendPacket(ping);
            if (XConnection.instance.timeoutCount >= 3) {
                XConnection.instance.notifyConnectionChange(XmppEvent.EnumC4723a.ping_failed);
            }
            if (System.currentTimeMillis() - XConnection.pingStamp > 30000) {
                XConnection.instance.notifyConnectionChange(XmppEvent.EnumC4723a.ping_failed);
            }
        }
    };

    private XConnection() {
        this.timeoutCount = 0;
        this.connectionListener = new ConnectionListener() { // from class: message.xmpp.XConnection.1
            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosed() {
                C1673a.m8965a().m8964a("connectionClosed");
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosedOnError(Exception exc) {
                StreamError streamError;
                if ((exc instanceof XMPPException) && (streamError = ((XMPPException) exc).getStreamError()) != null && streamError.getCode().equals("conflict")) {
                    XConnection.this.notifyConnectionChange(XmppEvent.EnumC4723a.conflict);
                    LogTracker.m231a("connectionClosedOnError_send", ApplicationConfig.m9181a() + "--" + DateTool.m241a().m237b(System.currentTimeMillis()));
                    C1673a m8965a = C1673a.m8965a();
                    StringBuilder sb = new StringBuilder("ConnectionClosedOnError_Conflict:");
                    sb.append(ApplicationConfig.m9181a());
                    m8965a.m8964a(sb.toString());
                    return;
                }
                XConnection.this.notifyConnectionChange(XmppEvent.EnumC4723a.connect_failed);
                C1673a m8965a2 = C1673a.m8965a();
                m8965a2.m8963a("ConnectionClosedOnError_Conflict:" + ApplicationConfig.m9181a(), exc);
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void reconnectingIn(int i) {
                C1673a.m8965a().m8964a("reconnectingIn".concat(String.valueOf(i)));
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void reconnectionSuccessful() {
                C1673a.m8965a().m8964a("reconnectionSuccessful");
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void reconnectionFailed(Exception exc) {
                C1673a.m8965a().m8963a("reconnectionFailed:", exc);
            }
        };
        this.packetFilter = new PacketFilter() { // from class: message.xmpp.XConnection.4
            @Override // org.jivesoftware.smack.filter.PacketFilter
            public boolean accept(Packet packet) {
                if (packet instanceof Message) {
                    return true;
                }
                if (((AbstractC4971IQ) packet).getType() == AbstractC4971IQ.Type.PONG) {
                    boolean unused = XConnection.isStartTimeout = true;
                    XConnection.this.timeoutCount = 0;
                    if (XConnection.alarmManager != null && XConnection.pIntTimeout != null) {
                        XConnection.alarmManager.cancel(XConnection.pIntTimeout);
                    }
                    long unused2 = XConnection.pingStamp = System.currentTimeMillis();
                }
                return false;
            }
        };
        this.packetListener = new PacketListener() { // from class: message.xmpp.XConnection.5
            @Override // org.jivesoftware.smack.PacketListener
            public void processPacket(Packet packet) {
                XmppEvent xmppEvent = new XmppEvent(XmppEvent.EnumC4723a.receive_msg);
                xmppEvent.f23967b = packet;
                xmppEvent.m9144a();
            }
        };
        this.packetShareListener = new PacketListener() { // from class: message.xmpp.XConnection.6
            @Override // org.jivesoftware.smack.PacketListener
            public void processPacket(Packet packet) {
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MessageParameters.f23946k);
        try {
            ApplicationConfig.f7802a.registerReceiver(AlarmTimeoutReceiver, intentFilter);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(MessageParameters.f23947l);
        ApplicationConfig.f7802a.registerReceiver(AlarmReceiver, intentFilter2);
    }

    public void UnregisterReceiver() {
        try {
            ApplicationConfig.f7802a.unregisterReceiver(AlarmTimeoutReceiver);
            ApplicationConfig.f7802a.unregisterReceiver(AlarmReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void setPacketFilter(PacketFilter packetFilter) {
        this.packetCustomFilter = packetFilter;
    }

    public static XConnection getInstance() {
        if (instance == null) {
            synchronized (XConnection.class) {
                if (instance == null) {
                    instance = new XConnection();
                    alarmManager = (AlarmManager) ApplicationConfig.f7802a.getSystemService("alarm");
                }
            }
        }
        return instance;
    }

    public static synchronized void release() {
        synchronized (XConnection.class) {
            instance = null;
        }
    }

    public XMPPConnection getConnection() {
        return this.connection;
    }

    public synchronized void login(String str, int i, String str2, String str3, String str4, String str5) {
        try {
            C1673a m8965a = C1673a.m8965a();
            m8965a.m8964a("Linked:[" + str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + i + "]");
        } catch (Exception e) {
            String message2 = e.getMessage();
            if (message2 != null && message2.contains("SASL")) {
                notifyConnectionChange(XmppEvent.EnumC4723a.pwd_error);
                C1673a.m8965a().m8964a("PassWord Error:".concat(String.valueOf(message2)));
                return;
            }
            notifyConnectionChange(XmppEvent.EnumC4723a.connect_failed);
            C1673a.m8965a().m8964a("Connect Failed:".concat(String.valueOf(message2)));
            Log.e("Sanda", "Login Error:" + e.getMessage());
            C1673a.m8965a().m8963a("Connect Failed:", e);
            if (message2 != null && message2.contains("Not connected to server")) {
                notifyConnectionChange(XmppEvent.EnumC4723a.connect_error);
            }
        }
        if (this.connection != null && this.connection.isConnected() && this.connection.isAuthenticated() && str2.equals(this.connection.getUser().split("@")[0])) {
            ((MessageEventCodeManager) Singlton.m9123a(MessageEventCodeManager.class)).m9126a(2455, new Object[0]);
            C1673a.m8965a().m8964a("Already Login:".concat(String.valueOf(str2)));
            return;
        }
        disConnect();
        ProviderManager.getInstance().addIQProvider("share", "jabber:client", new CustomIQProvider());
        ProviderManager.getInstance().addIQProvider("upgrade", "jabber:client", new UpgradeIQProvider());
        ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration(str, i);
        connectionConfiguration.setServiceName(str4);
        connectionConfiguration.setSendPresence(false);
        connectionConfiguration.setRosterLoadedAtLogin(false);
        connectionConfiguration.setDebuggerEnabled(true);
        this.connection = new XMPPConnection(connectionConfiguration);
        this.connection.connect();
        this.connection.addPacketListener(this.packetListener, this.packetFilter);
        this.connection.addPacketListener(this.packetShareListener, this.packetCustomFilter);
        this.connection.addConnectionListener(this.connectionListener);
        this.connection.login(str2, str3, str5);
        notifyConnectionChange(XmppEvent.EnumC4723a.connect_successfully);
        C1673a m8965a2 = C1673a.m8965a();
        m8965a2.m8964a("Connect Successfully:" + str2 + "[" + str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + i + "]");
        userId = str2;
    }

    public boolean sendPacket(Packet packet) {
        XMPPConnection xMPPConnection = this.connection;
        if (xMPPConnection != null && xMPPConnection.isConnected() && this.connection.isAuthenticated()) {
            this.connection.sendPacket(packet);
            return true;
        }
        this.timeoutCount++;
        if (this.timeoutCount >= 3) {
            notifyConnectionChange(XmppEvent.EnumC4723a.send_failed);
            return false;
        }
        return false;
    }

    public synchronized void disConnect() {
        stopPing();
        C1673a.m8965a().m8964a("XConnection is Disconnect!");
        if (this.connection != null) {
            this.connection.disconnect();
            this.connection.removeConnectionListener(this.connectionListener);
            this.connection.removePacketListener(this.packetListener);
        }
    }

    public void notifyConnectionChange(XmppEvent.EnumC4723a enumC4723a) {
        switch (enumC4723a) {
            case connect_successfully:
                startPing();
                C1673a m8965a = C1673a.m8965a();
                m8965a.m8964a("XConnection:Connect_Successfully:" + ApplicationConfig.m9181a());
                break;
            case connect_failed:
                XConnectionHelper.m313a().m312b();
                C1673a m8965a2 = C1673a.m8965a();
                m8965a2.m8964a("XConnection:Connect_Failed:" + ApplicationConfig.m9181a());
                break;
            case pwd_error:
                XConnectionHelper.m313a().m312b();
                C1673a m8965a3 = C1673a.m8965a();
                m8965a3.m8964a("XConnection:PassWord_Error:" + ApplicationConfig.m9181a());
                break;
            case conflict:
                XConnectionHelper.m313a().m312b();
                C1673a m8965a4 = C1673a.m8965a();
                m8965a4.m8964a("XConnection:Conflict:" + ApplicationConfig.m9181a());
                break;
            case send_failed:
                XConnectionHelper.m313a().m312b();
                C1673a m8965a5 = C1673a.m8965a();
                m8965a5.m8964a("XConnection:Send_Failed:" + ApplicationConfig.m9181a());
                break;
            case ping_failed:
                XConnectionHelper.m313a().m312b();
                C1673a m8965a6 = C1673a.m8965a();
                m8965a6.m8964a("XConnection:Ping_Failed:" + ApplicationConfig.m9181a());
                break;
        }
        new XmppEvent(enumC4723a).m9144a();
    }

    private synchronized void startPing() {
        pIntent = PendingIntent.getBroadcast(ApplicationConfig.f7802a, 0, new Intent(MessageParameters.f23947l), NTLMConstants.FLAG_UNIDENTIFIED_10);
        pingStamp = System.currentTimeMillis();
        if (alarmManager == null) {
            alarmManager = (AlarmManager) ApplicationConfig.f7802a.getSystemService("alarm");
        }
        alarmManager.setRepeating(2, SystemClock.elapsedRealtime(), 60000L, pIntent);
        LogUtilMsg.m227a("mTag", "Alarm==start=>" + DateTool.m241a().m237b(System.currentTimeMillis()));
        C1673a.m8965a().m8964a("XConnect startPing");
    }

    private synchronized void stopPing() {
        try {
            C1673a.m8965a().m8964a("XConnect stopPing");
            this.timeoutCount = 0;
            isStartTimeout = true;
            if (alarmManager != null) {
                if (pIntent != null) {
                    alarmManager.cancel(pIntent);
                }
                if (pIntTimeout != null) {
                    alarmManager.cancel(pIntTimeout);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setStaute(int i) {
        XMPPConnection xMPPConnection = this.connection;
        if (xMPPConnection != null && xMPPConnection.isConnected() && this.connection.isAuthenticated()) {
            this.connection.sendPacket(new StatusPresence(StatusPresence.Type.available, String.valueOf(i)));
        }
    }
}
