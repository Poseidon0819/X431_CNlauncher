package com.cnlaunch.diagnosemodule.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.diagnosemodule.BluetoothStateStd;
import com.cnlaunch.diagnosemodule.C1444R;
import com.cnlaunch.diagnosemodule.DiagnoseBusiness;
import com.cnlaunch.diagnosemodule.listener.OnDiagnoseJsonListener;
import com.cnlaunch.diagnosemodule.listener.OnRemoteDiagStatusListener;
import com.cnlaunch.diagnosemodule.model.DiagnoseActionInfo;
import com.cnlaunch.diagnosemodule.newinterface.NewFrameUtil;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.diagnosemodule.utils.DiagnoseLogUtil;
import com.cnlaunch.diagnosemodule.utils.JsonUtils;
import com.cnlaunch.diagnosemodule.utils.LocalSocketClient;
import com.cnlaunch.diagnosemodule.utils.MessagerInfo;
import com.cnlaunch.diagnosemodule.utils.VersionCompatibileTool;
import com.cnlaunch.mycar.jni.FileUtils;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.p181j.CarerDataAdapter;
import com.cnlaunch.p181j.DiagSocketController;
import com.cnlaunch.p181j.RemoteClickListener;
import com.cnlaunch.p181j.RemoteSetValueListener;
import com.cnlaunch.p181j.SocketDataFilter;
import com.cnlaunch.p181j.TechDataAdapter;
import com.cnlaunch.physics.p205k.AppMlogConfig;
import com.cnlaunch.physics.p205k.C1856n;
import com.ifoer.expedition.cto.CToJava;
import com.ifoer.expedition.cto.CToJava2;
import com.ifoer.expedition.cto.CToJavaImplements;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.pdf.PdfBoolean;
import com.launch.rcu.socket.SocketCall;
import com.mopub.common.AdType;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.UnsupportedEncodingException;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DiagnoseService extends Service {
    public static final String CHANNEL_ID_STRING = "diag_01";
    public static final String DIAGNOSE_SERVICE = "com.cnlaunch.diagnose.service";
    private static final String TAG = "DiagnoseService";
    public static int diagnoseStatue = 3;
    public static boolean isDataCollectPause = false;
    public static boolean isRemoteUiPageMask = false;
    private static int mDeviceLinkMode;
    private boolean isADAS;
    private int mDeviceStatus;
    private String mDiagnoseLogPath;
    private boolean mIsCollect;
    private boolean mIsOnlyUiDataCollect;
    private boolean mIsReconnect;
    private LocalSocketClient mLocalSocketClient;
    private String mSpecificLogsPath;
    private SocketDataFilter socketDataFilter;
    public Messenger mClient = null;
    private DiagnoseBusiness mDiagBusiness = null;
    private String tempLibPath = "";
    private String tempLanguage = "";
    private DiagnoseLogUtil.LogRecordHead mLogRecordHead = null;
    private boolean mDiagnoseLogSwitch = false;
    private boolean mDiagnoseLogWithAutosearchSwitch = false;
    private boolean mIsNoScreenDiagnoseLog = false;
    private PowerManager.WakeLock mWakeLock = null;
    private String tempFilePath = "";
    private OnDiagnoseJsonListener mOnDiagnoseJsonListener = new OnDiagnoseJsonListener() { // from class: com.cnlaunch.diagnosemodule.service.DiagnoseService.1
        @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseJsonListener
        public void onDiagnoseJsonCallback(String str, String str2) {
            Message obtain = Message.obtain((Handler) null, 50);
            Bundle bundle = new Bundle();
            bundle.putString(VastExtensionXmlManager.TYPE, str);
            if (str2.length() > 256000) {
                bundle.putBoolean("isFromFile", true);
                String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                if (FileUtils.saveFile(str2, DiagnoseService.this.tempFilePath + format)) {
                    bundle.putString("filePath", DiagnoseService.this.tempFilePath + format);
                }
            } else {
                bundle.putString(DataPacketExtension.ELEMENT_NAME, str2);
            }
            obtain.setData(bundle);
            DiagnoseService.this.sendClientMessage(obtain);
            if (DiagnoseService.diagnoseStatue <= 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (DiagnoseService.this.socketDataFilter == null) {
                        DiagnoseService.this.socketDataFilter = new SocketDataFilter();
                    }
                    SocketDataFilter unused = DiagnoseService.this.socketDataFilter;
                    if (SocketDataFilter.m8679a(str, jSONObject.toString()) || !DiagnoseService.this.socketDataFilter.m8678a(str, jSONObject)) {
                        return;
                    }
                    DiagSocketController.m8651a().m8649a(jSONObject.toString());
                } catch (JSONException e) {
                    Log.e("XEE", "get send json err:" + e.toString());
                    e.printStackTrace();
                }
            }
        }
    };
    private OnRemoteDiagStatusListener onRemoteStatusListener = new OnRemoteDiagStatusListener() { // from class: com.cnlaunch.diagnosemodule.service.DiagnoseService.2
        @Override // com.cnlaunch.diagnosemodule.listener.OnRemoteDiagStatusListener
        public void OnRemoteDiagStatusCallback(int i) {
            Message obtain;
            Log.i("Sanda", "OnRemoteDiagStatusListener statues:".concat(String.valueOf(i)));
            if (i == 6) {
                obtain = Message.obtain(null, 51, i, DiagSocketController.m8651a().f9470c);
                DiagnoseConstants.DIAGNOSE_LANGUAGE = DiagnoseBusiness.getMatchedLanguage();
                DiagnoseService.this.mDiagBusiness.LoadLocalSO();
            } else {
                obtain = Message.obtain(null, 51, i, 3);
            }
            DiagnoseService.this.sendClientMessage(obtain);
        }
    };
    private final Messenger mEthNetMessenger = new Messenger(new Handler() { // from class: com.cnlaunch.diagnosemodule.service.DiagnoseService.3
        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            switch (message2.what) {
                case 0:
                    CToJavaImplements.setEthNetWaitLock.lock();
                    try {
                        CToJavaImplements.setEthNetCondition.signal();
                        return;
                    } finally {
                    }
                case 1:
                    CToJavaImplements.returnValue = message2.getData().getInt(DataPacketExtension.ELEMENT_NAME);
                    CToJavaImplements.setEthNetWaitLock.lock();
                    try {
                        CToJavaImplements.setEthNetCondition.signal();
                        return;
                    } finally {
                    }
                case 2:
                case 3:
                case 4:
                default:
                    super.handleMessage(message2);
                    return;
                case 5:
                    CToJavaImplements.returnValue = message2.getData().getInt(DataPacketExtension.ELEMENT_NAME);
                    CToJavaImplements.setEthNetWaitLock.lock();
                    try {
                        CToJavaImplements.setEthNetCondition.signal();
                        return;
                    } finally {
                    }
                case 6:
                    CToJavaImplements.returnValue = message2.getData().getInt(DataPacketExtension.ELEMENT_NAME);
                    CToJavaImplements.setEthNetWaitLock.lock();
                    try {
                        CToJavaImplements.setEthNetCondition.signal();
                        return;
                    } finally {
                    }
            }
        }
    });
    private final Messenger mMessenger = new Messenger(new Handler() { // from class: com.cnlaunch.diagnosemodule.service.DiagnoseService.4
        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            try {
                if (DiagnoseService.diagnoseStatue >= 2 || !DiagSocketController.m8651a().m8650a(message2)) {
                    switch (message2.what) {
                        case 0:
                            DiagnoseService.this.mClient = message2.replyTo;
                            return;
                        case 1:
                            DiagnoseService.this.mClient = message2.replyTo;
                            DiagnoseService.this.demoConnectedAction(message2.getData());
                            return;
                        case 3:
                            Bundle data = message2.getData();
                            String string = data.getString(VastExtensionXmlManager.TYPE);
                            String string2 = data.getString("cmd");
                            if (!DiagnoseService.this.mDiagBusiness.isNewFrame()) {
                                DiagnoseService.this.feedbackCMD(JsonUtils.cmdToJson(string, string2));
                                return;
                            }
                            if (!DiagnoseConstants.FEEDBACK_HIS_RECORD_SET_DATA_ID.equals(string) && !DiagnoseConstants.FEEDBACK_HIS_RECORD_SET_DATA_ID.equals(string)) {
                                NewFrameUtil.getInstance().returnDiagData(string, string2);
                                return;
                            }
                            DiagnoseService.this.feedbackCMD(JsonUtils.cmdToJson(string, string2));
                            return;
                        case 4:
                            Bundle data2 = message2.getData();
                            DiagnoseService.this.mDiagBusiness.switchPage(data2.getString(VastExtensionXmlManager.TYPE), data2.getString("cmd"), data2.getInt(Annotation.PAGE));
                            return;
                        case 5:
                            DiagnoseService.this.mDiagBusiness.backToPreviousLevel();
                            return;
                        case 6:
                            DiagnoseService.this.deviceConnectedAction(message2.getData());
                            return;
                        case 7:
                            return;
                        case 8:
                            DiagnoseService.this.mDiagBusiness.setRemoteDiagnoseStatueCallback(DiagnoseService.this.onRemoteStatusListener);
                            Bundle data3 = message2.getData();
                            int i = data3.getInt("identify");
                            DiagnoseService.diagnoseStatue = i;
                            DiagnoseConstants.setDiagIdentity(i);
                            DiagSocketController.m8651a().f9468a = DiagnoseService.this;
                            DiagSocketController.m8651a().f9475i = DiagnoseService.this.remoteClickListener;
                            DiagSocketController.m8651a().f9476j = DiagnoseService.this.remoteSetValueListener;
                            DiagSocketController.m8651a().f9473f = DiagnoseService.diagnoseStatue == 0 ? new CarerDataAdapter(DiagnoseService.this) : new TechDataAdapter(DiagnoseService.this);
                            if (data3.containsKey("isWebTech")) {
                                DiagSocketController.m8651a().f9469b = DiagnoseService.diagnoseStatue;
                                DiagSocketController.m8651a().f9471d = true;
                                DiagSocketController.m8651a().f9472e = DiagnoseService.this.mClient;
                            } else {
                                DiagSocketController.m8651a().f9471d = false;
                                DiagSocketController.m8651a().f9472e = null;
                                String string3 = data3.getString("ip");
                                int i2 = data3.getInt("port");
                                String string4 = data3.getString("info");
                                DiagSocketController m8651a = DiagSocketController.m8651a();
                                int i3 = DiagnoseService.diagnoseStatue;
                                m8651a.f9469b = i3;
                                SocketCall.getInstance().StartRemoteDiag(string3, i2, i3, string4, 0);
                            }
                            if (data3.containsKey("package_name") && "com.cnlaunch.MaxGo".equals(data3.getString("package_name"))) {
                                return;
                            }
                            DiagnoseConstants.setDataStreamPageNum(15);
                            return;
                        case 12:
                            Bundle data4 = message2.getData();
                            DiagnoseBusiness.sendCustomDialog(data4.getString(VastExtensionXmlManager.TYPE), data4.getString("ui_type"), data4.getString("title"), data4.getString(MessageDao.TABLENAME));
                            return;
                        case 13:
                            DiagnoseConstants.datastreamRecord = message2.getData().getBoolean("datastream_record");
                            DiagnoseConstants.IS_START_RECORD_DATASTREAM = true;
                            return;
                        case 15:
                            Bundle data5 = message2.getData();
                            data5.getString(VastExtensionXmlManager.TYPE);
                            DiagnoseService.this.mDiagBusiness.setDataStreamPageMask(data5.getStringArrayList("cmd"));
                            return;
                        case 16:
                            Bundle data6 = message2.getData();
                            if (data6.getInt(VastExtensionXmlManager.TYPE, 0) == 1) {
                                DiagnoseLogUtil.getInstance().realFeedBackProcess();
                                return;
                            } else if (data6.getInt(VastExtensionXmlManager.TYPE, 0) == 2) {
                                DiagnoseLogUtil.getInstance().realFeedbackForIm();
                                return;
                            } else {
                                return;
                            }
                        case 20:
                            DiagSocketController.m8651a().m8649a(message2.getData().getString("config"));
                            return;
                        case 24:
                            Bundle data7 = message2.getData();
                            data7.getString(VastExtensionXmlManager.TYPE);
                            byte[] byteArray = data7.getByteArray("cmd");
                            if (DiagnoseService.this.mDiagBusiness.isNewFrame()) {
                                return;
                            }
                            DiagnoseService.this.mDiagBusiness.feedbackBytesCommand(byteArray);
                            return;
                        case 25:
                            Bundle data8 = message2.getData();
                            C1856n.m8130a(DiagnoseService.TAG, "GET CLIENT  INFORMATION");
                            String string5 = data8.getString("device_information_key");
                            if (string5.equals("device_information_linkmode")) {
                                C1856n.m8130a(DiagnoseService.TAG, "GET CLIENT LINK MODE INFORMATION value ");
                                DiagnoseService.setDeviceLinkMode(data8.getInt("device_information_value", 0));
                                return;
                            } else if (string5.equals("device_information_status")) {
                                C1856n.m8130a(DiagnoseService.TAG, "GET CLIENT CURRENT STATUS INFORMATION");
                                DiagnoseService.this.setDeviceStatus(data8.getInt("device_information_value", 0));
                                return;
                            } else if (string5.equals("device_information_disconnect")) {
                                C1856n.m8130a(DiagnoseService.TAG, "DEVICE INFORMATION DISCONNECT VALUE");
                                boolean z = data8.getBoolean("device_information_value", false);
                                if (z) {
                                    C1856n.m8130a(DiagnoseService.TAG, "DEVICE INFORMATION DISCONNECT VALUE = ".concat(String.valueOf(z)));
                                    DiagnoseConstants.driviceConnStatus = false;
                                } else {
                                    C1856n.m8130a(DiagnoseService.TAG, "DEVICE INFORMATION CONNECTED");
                                    DiagnoseConstants.driviceConnStatus = true;
                                }
                                if (DiagnoseConstants.isLoadStded) {
                                    new BluetoothStateStd().setBluetoochConnectState(DiagnoseConstants.driviceConnStatus ? 1 : 2);
                                }
                                if (!DiagnoseConstants.driviceConnStatus) {
                                    DiagnoseConstants.isVoltageShow = false;
                                }
                                C1856n.m8125d(DiagnoseService.TAG, " + DiagnoseConstants.isLoadStded =" + DiagnoseConstants.isLoadStded + ",DiagnoseConstants.isVoltageShow=" + DiagnoseConstants.isVoltageShow);
                                return;
                            } else {
                                return;
                            }
                        case 26:
                            String upperCase = DiagnoseService.this.open_readVinByObd().toUpperCase();
                            Message obtain = Message.obtain((Handler) null, 26);
                            Bundle bundle = new Bundle();
                            bundle.putString("VIN", upperCase);
                            obtain.setData(bundle);
                            DiagnoseService.this.sendClientMessage(obtain);
                            return;
                        case 27:
                            Bundle data9 = message2.getData();
                            NewFrameUtil.getInstance().returnDiagData(data9.getString(VastExtensionXmlManager.TYPE), data9.getIntArray("cmd"));
                            return;
                        case 28:
                            Bundle data10 = message2.getData();
                            DiagnoseService.this.mDiagBusiness.setDataFromUI2So(Integer.valueOf(data10.getString(VastExtensionXmlManager.TYPE)).intValue(), data10.getString("cmd"));
                            return;
                        case 29:
                            Bundle data11 = message2.getData();
                            int i4 = data11.getInt(VastExtensionXmlManager.TYPE, -1);
                            byte[] byteArray2 = data11.getByteArray("cmd");
                            if (!DiagnoseService.this.mDiagBusiness.isNewFrame()) {
                                DiagnoseService.this.mDiagBusiness.sendEventData(i4, byteArray2);
                                return;
                            } else {
                                NewFrameUtil.getInstance().returnDiagData(i4, byteArray2);
                                return;
                            }
                        case 30:
                            DiagnoseService.this.mDiagBusiness.sendTpmsgunEventData(message2.getData().getByteArray("cmd"));
                            return;
                        case 52:
                            DiagSocketController.m8651a().f9474h = true;
                            SocketCall.getInstance().StopRemoteDiag();
                            VersionCompatibileTool.setVersionCom(false);
                            DiagnoseService.diagnoseStatue = 3;
                            DiagnoseService.isRemoteUiPageMask = false;
                            DiagnoseConstants.setDiagIdentity(DiagnoseService.diagnoseStatue);
                            return;
                        case 99:
                            DiagnoseService.this.mDiagBusiness.feekbackDataRemote(message2.getData().getString(AdType.STATIC_NATIVE));
                            return;
                        case 101:
                            DiagSocketController.m8651a().m8649a(message2.getData().getString("vehicle_info"));
                            return;
                        case 103:
                            DiagSocketController.m8651a().f9468a = DiagnoseService.this;
                            DiagSocketController.m8651a().f9475i = DiagnoseService.this.remoteClickListener;
                            return;
                        case 104:
                            DiagSocketController.m8651a().m8649a(message2.getData().getString("remote_other_message"));
                            return;
                        case 109:
                            DiagnoseService.this.mDiagBusiness.setAutoCleanDCT(true);
                            return;
                        case 4105:
                            DiagnoseService.isDataCollectPause = message2.getData().getBoolean("isDataCollectPause");
                            return;
                        case MessagerInfo.REMOTE_FEEDBACK_TECH_JSON /* 10055 */:
                            DiagSocketController.m8651a().m8647b(message2.getData().getString(AdType.STATIC_NATIVE));
                            return;
                        default:
                            Log.e("Sanda", "------>未处理的信息：" + message2.what + "  indentify=" + DiagnoseService.diagnoseStatue);
                            super.handleMessage(message2);
                            return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    long MAX_RUNNING_READVINBYOBD_Time = 10000;
    public Thread.UncaughtExceptionHandler onForceCloseError = new Thread.UncaughtExceptionHandler() { // from class: com.cnlaunch.diagnosemodule.service.DiagnoseService.5
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            String str = DiagnoseService.TAG;
            C1856n.m8127b(str, "onForceCloseError捕获到异常: " + th.getMessage());
            DiagnoseService.this.sendCrashInfoBroadcast(th);
            Process.killProcess(Process.myPid());
        }
    };
    private RemoteClickListener remoteClickListener = new RemoteClickListener() { // from class: com.cnlaunch.diagnosemodule.service.DiagnoseService.6
        @Override // com.cnlaunch.p181j.RemoteClickListener
        public void switchPage(String str, String str2, int i) {
        }

        @Override // com.cnlaunch.p181j.RemoteClickListener
        public void onClick(String str) {
            Message obtain = Message.obtain((Handler) null, 54);
            Bundle bundle = new Bundle();
            bundle.putString("cmd", str);
            obtain.setData(bundle);
            DiagnoseService.this.sendClientMessage(obtain);
        }

        @Override // com.cnlaunch.p181j.RemoteClickListener
        public void initDataStreamConifg(String str, int i) {
            Message obtain = Message.obtain((Handler) null, 55);
            Bundle bundle = new Bundle();
            bundle.putString("config", str);
            obtain.setData(bundle);
            DiagnoseService.this.sendClientMessage(obtain);
        }

        @Override // com.cnlaunch.p181j.RemoteClickListener
        public void onScrollPage(int i) {
            Message obtain = Message.obtain((Handler) null, 56);
            Bundle bundle = new Bundle();
            bundle.putInt("position", i);
            obtain.setData(bundle);
            DiagnoseService.this.sendClientMessage(obtain);
        }

        @Override // com.cnlaunch.p181j.RemoteClickListener
        public void initVehicleInfo(JSONObject jSONObject) {
            Message obtain = Message.obtain((Handler) null, 102);
            Bundle bundle = new Bundle();
            bundle.putString("vehicle_info", jSONObject.toString());
            obtain.setData(bundle);
            DiagnoseService.this.sendClientMessage(obtain);
        }

        @Override // com.cnlaunch.p181j.RemoteClickListener
        public void remoteOtherMessage(String str, int i) {
            Message obtain = Message.obtain((Handler) null, 104);
            Bundle bundle = new Bundle();
            bundle.putString("remote_other_message", str);
            bundle.putInt("progress", i);
            obtain.setData(bundle);
            DiagnoseService.this.sendClientMessage(obtain);
        }
    };
    private RemoteSetValueListener remoteSetValueListener = new RemoteSetValueListener() { // from class: com.cnlaunch.diagnosemodule.service.DiagnoseService.7
        @Override // com.cnlaunch.p181j.RemoteSetValueListener
        public void setDataStreamCount(int i) {
            Message obtain = Message.obtain((Handler) null, 59);
            Bundle bundle = new Bundle();
            bundle.putString(VastExtensionXmlManager.TYPE, "dataStreamCount");
            bundle.putInt("count", i);
            obtain.setData(bundle);
            DiagnoseService.this.sendClientMessage(obtain);
        }

        @Override // com.cnlaunch.p181j.RemoteSetValueListener
        public void setRemoteMessage(String str) {
            Message obtain = Message.obtain((Handler) null, (int) MessagerInfo.REMOTE_CMD_MESSAGE);
            Bundle bundle = new Bundle();
            bundle.putString("remote_message", str);
            obtain.setData(bundle);
            DiagnoseService.this.sendClientMessage(obtain);
        }
    };
    private boolean mState = true;

    @Override // android.app.Service
    public void onCreate() {
        Notification.Builder builder;
        super.onCreate();
        acquireWakeLock();
        if (Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT >= 26) {
                ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel(CHANNEL_ID_STRING, "e4", 4));
                builder = new Notification.Builder(this, CHANNEL_ID_STRING);
            } else {
                builder = new Notification.Builder(this);
            }
            builder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, DiagnoseService.class), NTLMConstants.FLAG_UNIDENTIFIED_10)).setSmallIcon(C1444R.drawable.notic_diagservice_icon_tran).setWhen(System.currentTimeMillis()).setOngoing(false).setSmallIcon(C1444R.drawable.notic_diagservice_icon_tran).setColor(Color.rgb(0, 133, 117)).setContentTitle(TAG);
            startForeground(-1213, builder.build());
        } else {
            startForeground(-1213, new Notification());
        }
        this.mDiagBusiness = DiagnoseBusiness.getInstance(this);
        this.mDiagBusiness.setDiagnoseJsonCallback(this.mOnDiagnoseJsonListener);
        this.mLogRecordHead = new DiagnoseLogUtil.LogRecordHead();
        DiagnoseConstants.setDataStreamPageNum(getResources().getInteger(C1444R.integer.datastream_page_num));
        mDeviceLinkMode = 0;
        this.mDeviceStatus = 3;
        this.mIsReconnect = false;
        DiagnoseConstants.isVoltageShow = false;
        DiagnoseConstants.isLoadStded = false;
        C1856n.m8128a(AppMlogConfig.m8215a().f10029a);
    }

    private void initDiagnoseBusiness(boolean z) {
        this.mDiagBusiness = DiagnoseBusiness.getInstance(this);
        this.mDiagBusiness.setNewFrame(z);
        this.mDiagBusiness.setDiagnoseJsonCallback(this.mOnDiagnoseJsonListener);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
        LocalSocketClient localSocketClient = this.mLocalSocketClient;
        if (localSocketClient != null) {
            localSocketClient.stopThread();
            this.mLocalSocketClient = null;
        }
        DiagnoseLogUtil.getInstance().stopRecord();
        releaseWakeLock();
        Process.killProcess(Process.myPid());
    }

    public String getSysName(String str) {
        if (str.contains("{name=")) {
            str = str.substring(str.indexOf("{name=") + 6, str.indexOf("}"));
            if (TextUtils.isEmpty(str)) {
                return "";
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String open_readVinByObd() {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.service.DiagnoseService.open_readVinByObd():java.lang.String");
    }

    private void initLogRecordHead(Bundle bundle) {
        this.mLogRecordHead.setVehicleSoftname(bundle.getString("carName", ""));
        this.mLogRecordHead.setVehicleSoftVersion(bundle.getString("softVer", ""));
        this.mLogRecordHead.setVehicleSoftLanguage(bundle.getString("softLan", ""));
        this.mLogRecordHead.setDeviceSN(bundle.getString("serialNum", ""));
        this.mLogRecordHead.setSoftVersion(bundle.getString("appVer", ""));
        this.mLogRecordHead.setPadInformation("");
        this.mLogRecordHead.setDeviceVersion(bundle.getString("binVer", ""));
        this.mLogRecordHead.setCollecterUsername(bundle.getString("collecter_username", ""));
        this.mLogRecordHead.setCollecterPhone(bundle.getString("collecter_phone", ""));
        this.mLogRecordHead.setCollectPlacesLongitude(bundle.getString("collect_places_longitude", ""));
        this.mLogRecordHead.setCollectPlacesLatitude(bundle.getString("collect_places_latitude", ""));
        this.mLogRecordHead.setCollectPlacesLatitudeType(bundle.getString("collect_places_latitude_type", ""));
        this.mLogRecordHead.setVehicleVin(bundle.getString("vehicle_vin", ""));
        this.mLogRecordHead.setVehicleMake(bundle.getString("vehicle_make", ""));
        this.mLogRecordHead.setVehicleModel(bundle.getString("vehicle_model", ""));
        this.mLogRecordHead.setVehicleYear(bundle.getString("vehicle_year", ""));
        this.mDiagnoseLogSwitch = bundle.getBoolean("diagnoseLogSwitch", false);
        this.mDiagnoseLogWithAutosearchSwitch = bundle.getBoolean("diagnoseLogWithAutosearchSwitch", false);
        this.mIsNoScreenDiagnoseLog = bundle.getBoolean("isNoScreenDiagnoseLog", false);
        this.mDiagnoseLogPath = bundle.getString("diagnoseLogPath", "");
        this.mSpecificLogsPath = bundle.getString("specificLogsPath", "");
        this.mIsCollect = bundle.getBoolean("is_collect", false);
        this.mIsOnlyUiDataCollect = bundle.getBoolean("is_ui_data_collect", false);
        this.isADAS = bundle.getBoolean("is_adas", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void demoConnectedAction(Bundle bundle) {
        String replaceAll = bundle.getString("Lib_path").replaceAll("//", "/");
        String string = bundle.getString("Lib_language");
        initDiagnoseBusiness(bundle.getBoolean("IsNewFrame", false));
        if (bundle.getBoolean("IsDiagGetSwitch", false)) {
            DiagnoseBusiness.setIsDiagGetSwitch(true);
            this.mDiagBusiness.setDiagSwitchData(bundle.getByteArray("DiagSwitchData"));
        }
        DiagnoseConstants.diagDataGather = bundle.getBoolean("isDataGatherDiag", false);
        DiagnoseConstants.isStudyDiag = bundle.getBoolean("isStudyDiag", false);
        this.tempFilePath = bundle.getString("TempFilePath", "");
        String string2 = bundle.getString("Diagnostic_path");
        initLogRecordHead(bundle);
        DiagnoseConstants.driviceConnStatus = false;
        boolean z = bundle.getBoolean("IsWebRemote", false);
        DiagnoseConstants.isWebRemote = z;
        if (z) {
            DiagSocketController.m8651a().f9476j = this.remoteSetValueListener;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("APP_VER", this.mLogRecordHead.getSoftVersion());
            jSONObject.put("CAR_NAME", this.mLogRecordHead.getVehicleSoftname());
            jSONObject.put("CAR_VER", this.mLogRecordHead.getVehicleSoftVersion());
            jSONObject.put("LIB_PATH", replaceAll);
            jSONObject.put("HIS_FOLDER", string2);
            jSONObject.put("DEV_SN", this.mLogRecordHead.getDeviceSN());
            jSONObject.put("VehicleID", bundle.getString("VehicleID"));
            jSONObject.put("IN_TYPE", bundle.getString("DiagInType"));
            jSONObject.put("License_Plate", bundle.getString("LicensePlate"));
            if (bundle.getBoolean("isStudyDiag", false)) {
                jSONObject.put("isStudyDiag", PdfBoolean.TRUE);
            }
            jSONObject.put("EnableHistoryDiagnose", bundle.getBoolean("EnableHistoryDiagnose"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!bundle.getString("DiagInType").equals("2")) {
            DiagnoseInfo.getInstance().clear();
        }
        this.mDiagBusiness.getDiagInfo(jSONObject.toString());
        launchDiagnoseForDemo(replaceAll, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deviceConnectedAction(Bundle bundle) {
        if (bundle == null || bundle.getString("Lib_language") == null) {
            return;
        }
        initDiagnoseBusiness(bundle.getBoolean("IsNewFrame", false));
        if (bundle.getBoolean("IsDiagGetSwitch", false)) {
            DiagnoseBusiness.setIsDiagGetSwitch(true);
            this.mDiagBusiness.setDiagSwitchData(bundle.getByteArray("DiagSwitchData"));
        }
        DiagnoseConstants.diagDataGather = bundle.getBoolean("isDataGatherDiag", false);
        DiagnoseConstants.isStudyDiag = bundle.getBoolean("isStudyDiag", false);
        this.tempFilePath = bundle.getString("TempFilePath", "");
        DiagnoseConstants.driviceConnStatus = true;
        initLogRecordHead(bundle);
        this.tempLibPath = bundle.getString("Lib_path").replaceAll("//", "/");
        String string = bundle.getString("Diagnostic_path");
        this.tempLanguage = bundle.getString("Lib_language");
        DiagnoseConstants.DATASTREAM_PAGE = bundle.getInt("DATASTREAM_PAGE_COUNT");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("APP_VER", this.mLogRecordHead.getSoftVersion());
            jSONObject.put("CAR_NAME", this.mLogRecordHead.getVehicleSoftname());
            jSONObject.put("CAR_VER", this.mLogRecordHead.getVehicleSoftVersion());
            jSONObject.put("LIB_PATH", this.tempLibPath);
            jSONObject.put("HIS_FOLDER", string);
            jSONObject.put("DEV_SN", this.mLogRecordHead.getDeviceSN());
            jSONObject.put("VehicleID", bundle.getString("VehicleID"));
            jSONObject.put("IN_TYPE", bundle.getString("DiagInType"));
            jSONObject.put("License_Plate", bundle.getString("LicensePlate"));
            if (bundle.getBoolean("isStudyDiag", false)) {
                jSONObject.put("isStudyDiag", PdfBoolean.TRUE);
            }
            jSONObject.put("EnableHistoryDiagnose", bundle.getBoolean("EnableHistoryDiagnose"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.mDiagBusiness.getDiagInfo(jSONObject.toString());
        if (!bundle.getString("DiagInType").equals("2")) {
            DiagnoseInfo.getInstance().clear();
        }
        DiagnoseConstants.CURRENT_DIAG_CAR = bundle.getString("carName");
        DiagnoseConstants.DIAG_INPUT_TYPE = bundle.getString("DiagInType");
        DiagnoseConstants.DIAG_AutoSearchSetArgs = bundle.getString("AutoSearchSetArgs", "");
        boolean z = bundle.getBoolean("IsWebRemote", false);
        DiagnoseConstants.isWebRemote = z;
        if (z) {
            DiagSocketController.m8651a().f9476j = this.remoteSetValueListener;
        }
        if (this.mLocalSocketClient == null) {
            this.mLocalSocketClient = new LocalSocketClient();
            this.mLocalSocketClient.setContext(this);
            this.mLocalSocketClient.start();
        }
        DiagnoseConstants.isVoltageShow = false;
        DiagnoseConstants.isLoadStded = false;
        DiagnoseConstants.DEVICE_SERIALNO = bundle.getString("serialNum");
        DiagnoseConstants.INPUT_VIN = bundle.getString("vin_scan");
        String str = this.tempLibPath;
        if (str == null || str.equals("")) {
            return;
        }
        launchDiagnose(this.tempLibPath, this.tempLanguage);
        this.tempLibPath = "";
    }

    private void devicedisconnectAction() {
        C1856n.m8125d(DIAGNOSE_SERVICE, "Device Connect Lost");
        try {
            DiagnoseLogUtil.getInstance().writeBytes(new String("蓝牙连接异常或断开").getBytes("UTF-8"), (byte) 5);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    public void sendClientMessage(Message message2) {
        Messenger messenger = this.mClient;
        if (messenger == null) {
            sendBroadcast(new Intent(DiagnoseActionInfo.DiagServiceInitMessager));
            return;
        }
        try {
            messenger.send(message2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void sendClientMessage(Context context, Message message2) {
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, "sendClientMessage context =".concat(String.valueOf(context)));
        }
        if (context != null) {
            DiagnoseService diagnoseService = context instanceof DiagnoseService ? (DiagnoseService) context : null;
            if (diagnoseService != null) {
                C1856n.m8130a(TAG, "get DiagnoseService object");
                diagnoseService.sendClientMessage(message2);
            }
        }
    }

    private void launchDiagnose(String str, String str2) {
        if (DiagnoseConstants.CURRENT_DIAG_CAR.equalsIgnoreCase("AUTOSEARCH")) {
            CToJava2.init(this, this.mEthNetMessenger);
        } else {
            CToJava.init(this, this.mEthNetMessenger);
        }
        if (!this.mDiagBusiness.isNewFrame()) {
            startDiagnoseLog();
        }
        launchDiagnoseLib(str, str2);
        this.mDiagBusiness.recordLog(this.mDiagnoseLogSwitch ? 0 : -1);
    }

    private void launchDiagnoseForDemo(String str, String str2) {
        CToJava.init(this, this.mEthNetMessenger);
        launchDiagnoseLib(str, str2);
    }

    private void launchDiagnoseLib(String str, String str2) {
        this.mDiagBusiness.LoadDynLib(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCrashInfoBroadcast(Throwable th) {
        sendBroadcast(new Intent(DiagnoseConstants.DIAG_ERROR_BROADCAST));
    }

    public void sendCrashInfoBroadcast() {
        sendCrashInfoBroadcast(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void feedbackCMD(String str) {
        this.mDiagBusiness.sendFeedbackCommand(str);
    }

    private void startDiagnoseLog() {
        if (this.mLogRecordHead.getVehicleSoftname() == null || !this.mLogRecordHead.getVehicleSoftname().toLowerCase().contains("demo")) {
            if (this.mLogRecordHead.getVehicleSoftname() == null || !this.mLogRecordHead.getVehicleSoftname().toLowerCase().contains("autosearch") || this.mDiagnoseLogWithAutosearchSwitch) {
                DiagnoseLogUtil.getInstance().setContext(this);
                DiagnoseLogUtil.getInstance().initRecord(this.mDiagnoseLogSwitch, this.mIsNoScreenDiagnoseLog, this.mIsCollect, this.mDiagnoseLogPath, this.mSpecificLogsPath, this.isADAS);
                DiagnoseLogUtil.getInstance().setIsOnlyUIDataCollect(this.mIsOnlyUiDataCollect);
                DiagnoseLogUtil.LogRecordHead logRecordHead = DiagnoseLogUtil.getInstance().getLogRecordHead();
                logRecordHead.copyLogRecordHead(this.mLogRecordHead);
                logRecordHead.setCreateDate(new Date());
                if (TextUtils.isEmpty(this.mLogRecordHead.getPadInformation())) {
                    logRecordHead.setPadInformation(String.format("PAD system version(%s)", Build.DISPLAY));
                } else {
                    logRecordHead.setPadInformation(this.mLogRecordHead.getPadInformation() + String.format("\nPAD system version(%s)", Build.DISPLAY));
                }
                DiagnoseLogUtil.getInstance().startRecord();
            }
        }
    }

    private void diagnoseLogExceptionProcess(Message message2) {
        String str = TAG;
        C1856n.m8130a(str, "诊断日志异常发送数据：" + message2.toString());
        sendClientMessage(message2);
    }

    public static void setDeviceLinkMode(int i) {
        if (mDeviceLinkMode != i) {
            mDeviceLinkMode = i;
        }
    }

    public static int getDeviceLinkMode() {
        return mDeviceLinkMode;
    }

    public void setDeviceStatus(int i) {
        if (this.mDeviceStatus != i) {
            this.mDeviceStatus = i;
        }
    }

    public int getDeviceStatus() {
        return this.mDeviceStatus;
    }

    public boolean isReconnect() {
        return this.mIsReconnect;
    }

    public void setIsReconnect(boolean z) {
        this.mIsReconnect = z;
    }

    private void acquireWakeLock() {
        if (this.mWakeLock == null) {
            this.mWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, "DiagnoseService WakeLock");
            if (this.mWakeLock != null) {
                if (C1856n.f10135a) {
                    C1856n.m8130a(TAG, "call DiagnoseService WakeLock");
                }
                this.mWakeLock.acquire();
            }
        }
    }

    private void releaseWakeLock() {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, "call release DiagnoseService WakeLock");
        }
        this.mWakeLock.release();
        this.mWakeLock = null;
    }
}
