package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p181j.RemotePerformClick;
import com.cnlaunch.p188n.RemoteSocketControler;
import com.cnlaunch.p188n.p191c.DiagCarInfo;
import com.cnlaunch.p188n.p191c.RemoteConstants;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p192a.BluetoothManager;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IRemoteDownloadListener;
import com.cnlaunch.x431pro.activity.diagnose.p223f.DiagnoseWaitDialog;
import com.cnlaunch.x431pro.activity.diagnose.p223f.RemoteDiagHandler;
import com.cnlaunch.x431pro.module.p252d.p254b.RemoteDiagRunningInfo;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseLogInfoSearchUtil;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseUtils;
import com.ifoer.expedition.pro.R;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.File;
import java.util.Vector;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.t */
/* loaded from: classes.dex */
public final class HandlerC2212t extends Handler {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f12486a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2212t(DiagnoseActivity diagnoseActivity) {
        this.f12486a = diagnoseActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        IRemoteDownloadListener iRemoteDownloadListener;
        IRemoteDownloadListener iRemoteDownloadListener2;
        IRemoteDownloadListener iRemoteDownloadListener3;
        IRemoteDownloadListener iRemoteDownloadListener4;
        IRemoteDownloadListener iRemoteDownloadListener5;
        IRemoteDownloadListener iRemoteDownloadListener6;
        IRemoteDownloadListener iRemoteDownloadListener7;
        IRemoteDownloadListener iRemoteDownloadListener8;
        IRemoteDownloadListener iRemoteDownloadListener9;
        IRemoteDownloadListener iRemoteDownloadListener10;
        IRemoteDownloadListener iRemoteDownloadListener11;
        IRemoteDownloadListener iRemoteDownloadListener12;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness2;
        RemoteDiagHandler remoteDiagHandler;
        String str;
        RemoteDiagHandler remoteDiagHandler2;
        RemoteDiagHandler remoteDiagHandler3;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness3;
        RemoteDiagRunningInfo remoteDiagRunningInfo;
        RemoteDiagHandler remoteDiagHandler4;
        RemoteDiagHandler remoteDiagHandler5;
        RemoteDiagRunningInfo remoteDiagRunningInfo2;
        Context context;
        Context context2;
        String str2;
        Context context3;
        DiagnoseLogInfoSearchUtil.C2749a m5087a;
        RemoteDiagHandler remoteDiagHandler6;
        RemoteDiagHandler remoteDiagHandler7;
        RemoteDiagHandler remoteDiagHandler8;
        RemoteDiagHandler remoteDiagHandler9;
        RemoteDiagHandler remoteDiagHandler10;
        RemoteDiagHandler remoteDiagHandler11;
        Context context4;
        DiagnoseWaitDialog diagnoseWaitDialog;
        DiagnoseWaitDialog diagnoseWaitDialog2;
        int i = message2.what;
        if (i == 102) {
            String string = message2.getData().getString("vehicle_info");
            C1856n.m8125d("XEE", "收到服务器端发过来的车辆信息:".concat(String.valueOf(string)));
            DiagnoseUtils m5086a = DiagnoseUtils.m5086a();
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (m5086a.f15757c == null) {
                    m5086a.f15757c = new DiagCarInfo();
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject(DataPacketExtension.ELEMENT_NAME);
                m5086a.f15757c.setVin(jSONObject2.getString("vin"));
                m5086a.f15757c.setPackageId(jSONObject2.getString("packageid"));
                m5086a.f15757c.setCar_series(jSONObject2.getString("car_series"));
                m5086a.f15757c.setYear(jSONObject2.getString("year"));
                m5086a.f15757c.setModel(jSONObject2.getString("model"));
                m5086a.f15757c.setSoftVersion(jSONObject2.getString("soft_version"));
                m5086a.f15757c.setSerialNo(jSONObject2.getString("serialNo"));
                C1856n.m8125d("XEE", "远程车辆信息:" + m5086a.f15757c.toString());
                return;
            } catch (JSONException e) {
                Log.e("XEE", "远程车辆信息 err:" + e.toString());
                e.printStackTrace();
                return;
            }
        }
        if (i != 104) {
            switch (i) {
                case 50:
                    if (MainActivity.m7907a()) {
                        String string2 = message2.getData().getString(DataPacketExtension.ELEMENT_NAME);
                        if (RemoteConstants.f9649a == 1) {
                            RemoteSocketControler.m8607a().m8601a(string2);
                        }
                        diagnoseUIDataBusiness = this.f12486a.f11070ah;
                        diagnoseUIDataBusiness.stdJsonToUI(string2);
                        DiagnoseActivity diagnoseActivity = this.f12486a;
                        diagnoseUIDataBusiness2 = diagnoseActivity.f11070ah;
                        diagnoseActivity.m7645c(diagnoseUIDataBusiness2.getIsDiagnoseFlagAfterMenuIsDisplay());
                        remoteDiagHandler = this.f12486a.f11015D;
                        if (remoteDiagHandler != null) {
                            remoteDiagHandler2 = this.f12486a.f11015D;
                            remoteDiagHandler2.obtainMessage(105).sendToTarget();
                            if (this.f12486a.mo7083i().getDiagnoseStatue() < 2) {
                                remoteDiagHandler3 = this.f12486a.f11015D;
                                remoteDiagHandler3.obtainMessage(108).sendToTarget();
                            }
                        }
                        if (this.f12486a.mo7083i().getDiagnoseStatue() >= 2) {
                            if (C2787z.m4821a(DiagnoseConstants.DIAGNOSE_CURRENT_PATH)) {
                                str = "";
                            } else {
                                str = DiagnoseConstants.DIAGNOSE_CURRENT_PATH + " > ";
                            }
                            ReportProduceTool m5233a = ReportProduceTool.m5233a();
                            try {
                                if (TextUtils.isEmpty(string2)) {
                                    return;
                                }
                                JSONObject jSONObject3 = new JSONObject(new JSONObject(string2).getString(DataPacketExtension.ELEMENT_NAME));
                                String string3 = jSONObject3.getString("ui_type");
                                if (!string3.equals(DiagnoseConstants.UI_TYPE_DIALOG) && !string3.equals("90") && !string3.equals(DiagnoseConstants.UI_TYPE_GGP_NAME)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append(jSONObject3.has("content") ? jSONObject3.getString("content") : "");
                                    String sb2 = sb.toString();
                                    if (!TextUtils.isEmpty(sb2) && !sb2.equalsIgnoreCase(m5233a.f15654q)) {
                                        m5233a.f15654q = sb2;
                                        JSONObject jSONObject4 = new JSONObject();
                                        jSONObject4.put("item", sb2);
                                        m5233a.f15641d.put(jSONObject4);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    return;
                case 51:
                    int i2 = message2.arg1;
                    diagnoseUIDataBusiness3 = this.f12486a.f11070ah;
                    diagnoseUIDataBusiness3.setCurrentVer(message2.arg2);
                    remoteDiagRunningInfo = this.f12486a.f11130n;
                    if (remoteDiagRunningInfo != null) {
                        remoteDiagRunningInfo2 = this.f12486a.f11130n;
                        remoteDiagRunningInfo2.setOtherVer(message2.arg2);
                    }
                    remoteDiagHandler4 = this.f12486a.f11015D;
                    remoteDiagHandler4.f12460b = i2;
                    remoteDiagHandler5 = this.f12486a.f11015D;
                    remoteDiagHandler5.obtainMessage(i2).sendToTarget();
                    return;
                default:
                    switch (i) {
                        case 53:
                            Bundle data = message2.getData();
                            if (data != null) {
                                switch (data.getInt(VastExtensionXmlManager.TYPE, 0)) {
                                    case 0:
                                        String string4 = data.getString(DataPacketExtension.ELEMENT_NAME, "");
                                        context = this.f12486a.f11019H;
                                        NToast.m9441d(context, string4);
                                        return;
                                    case 1:
                                        context2 = this.f12486a.f11019H;
                                        if (!C2778n.m4917a(context2)) {
                                            NToast.m9450a(this.f12486a, (int) R.string.common_network_unavailable);
                                            DiagnoseActivity.m7672a(this.f12486a, false);
                                            return;
                                        }
                                        String string5 = data.getString(DataPacketExtension.ELEMENT_NAME, "");
                                        NLog.m9452b("DiagnoseActivity", "快速反馈诊断日志路径".concat(String.valueOf(string5)));
                                        DiagnoseActivity.m7672a(this.f12486a, false);
                                        Vector vector = new Vector();
                                        if (string5 != null) {
                                            File file = new File(string5);
                                            if (!file.isDirectory() && file.getName().contains(".dat") && (m5087a = DiagnoseLogInfoSearchUtil.m5087a(file)) != null) {
                                                vector.add(m5087a);
                                            }
                                        }
                                        if (vector.size() > 0) {
                                            context3 = this.f12486a.f11019H;
                                            DiagnoseLogInfoSearchUtil.m5088a(context3, vector, true);
                                            return;
                                        }
                                        DiagnoseActivity diagnoseActivity2 = this.f12486a;
                                        String string6 = diagnoseActivity2.getString(R.string.failed_get_diagnose_log);
                                        str2 = this.f12486a.f11038aB;
                                        NToast.m9449a(diagnoseActivity2, String.format(string6, str2));
                                        return;
                                    case 2:
                                        NLog.m9452b("DiagnoseActivity", "特殊功能诊断日志路径" + data.getString(DataPacketExtension.ELEMENT_NAME, ""));
                                        MainActivity mainActivity = (MainActivity) this.f12486a.getParent();
                                        if (mainActivity != null) {
                                            mainActivity.m7869i();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                            return;
                        case 54:
                            String string7 = message2.getData().getString("cmd");
                            remoteDiagHandler6 = this.f12486a.f11015D;
                            if (remoteDiagHandler6 != null) {
                                remoteDiagHandler7 = this.f12486a.f11015D;
                                remoteDiagHandler7.obtainMessage(105).sendToTarget();
                                if (this.f12486a.mo7083i().getDiagnoseStatue() < 2) {
                                    remoteDiagHandler8 = this.f12486a.f11015D;
                                    remoteDiagHandler8.obtainMessage(108).sendToTarget();
                                }
                            }
                            RemotePerformClick mo7080l = this.f12486a.mo7080l();
                            if (string7.equalsIgnoreCase("graph_vaule") && mo7080l.f9482a != null) {
                                mo7080l.f9482a.mo7256a();
                                return;
                            } else if (string7.equalsIgnoreCase("graph_combine") && mo7080l.f9482a != null) {
                                mo7080l.f9482a.mo7255b();
                                return;
                            } else if (string7.equalsIgnoreCase("graph_multiple") && mo7080l.f9482a != null) {
                                mo7080l.f9482a.mo7254c();
                                return;
                            } else if (!string7.equalsIgnoreCase("graph_free_combine") || mo7080l.f9482a == null) {
                                if (string7.contains("graph_item_click") && mo7080l.f9484c != null) {
                                    Integer.valueOf(string7.replace("graph_item_click", "")).intValue();
                                    return;
                                } else if ((!string7.contains("key_down_click") || mo7080l.f9484c == null) && string7.contains("onGridGraphItemClick") && mo7080l.f9485d != null) {
                                    Integer.valueOf(string7.replace("onGridGraphItemClick", "")).intValue();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        case 55:
                            String string8 = message2.getData().getString("config");
                            if (this.f12486a.mo7083i().getDiagnoseStatue() != 0) {
                                DataStreamConfiguration.m7958a(string8);
                                return;
                            }
                            return;
                        case 56:
                            int i3 = message2.getData().getInt("position");
                            remoteDiagHandler9 = this.f12486a.f11015D;
                            if (remoteDiagHandler9 != null) {
                                remoteDiagHandler10 = this.f12486a.f11015D;
                                remoteDiagHandler10.obtainMessage(105).sendToTarget();
                                if (this.f12486a.mo7083i().getDiagnoseStatue() < 2) {
                                    remoteDiagHandler11 = this.f12486a.f11015D;
                                    remoteDiagHandler11.obtainMessage(108).sendToTarget();
                                }
                            }
                            RemotePerformClick mo7080l2 = this.f12486a.mo7080l();
                            if (mo7080l2.f9483b != null) {
                                mo7080l2.f9483b.mo7104a(i3);
                                return;
                            }
                            return;
                        case 57:
                            Bundle data2 = message2.getData();
                            String string9 = data2 != null ? data2.getString("device_information_key", "") : "";
                            if (string9.equals("device_information_status")) {
                                C1856n.m8130a("DiagnoseActivity", "GET SERVICE WANT STATUS INFORMATION");
                                return;
                            } else if (string9.equals("device_information_reset")) {
                                C1856n.m8130a("DiagnoseActivity", "GET SERVICE RESET INFORMATION");
                                DeviceFactoryManager.m8305a().f9902b = true;
                                return;
                            } else if (string9.equals("device_information_change_device")) {
                                C1856n.m8130a("DiagnoseActivity", "GET SERVICE CHANGE DEVICE INFORMATION");
                                DiagnoseActivity.m7630g(this.f12486a);
                                return;
                            } else if (string9.equals("device_information_reconnect")) {
                                C1856n.m8130a("DiagnoseActivity", "DEVICE INFORMATION RECONNECT");
                                DeviceFactoryManager m8305a = DeviceFactoryManager.m8305a();
                                context4 = this.f12486a.f11019H;
                                IPhysics m8301a = m8305a.m8301a(context4, false, (String) null);
                                if (DeviceFactoryManager.m8305a().f9903c == 0) {
                                    String format = String.format("%1$s: %2$s......", this.f12486a.getResources().getString(R.string.connect_bluetooth_tip_message), PreferencesManager.m9595a((Context) this.f12486a).m9591a("serialNo"));
                                    diagnoseWaitDialog = this.f12486a.f11078ap;
                                    diagnoseWaitDialog.m7059a(format);
                                    diagnoseWaitDialog2 = this.f12486a.f11078ap;
                                    diagnoseWaitDialog2.show();
                                    BluetoothManager bluetoothManager = m8301a instanceof BluetoothManager ? (BluetoothManager) m8301a : null;
                                    if (bluetoothManager != null) {
                                        new C2213u(this, bluetoothManager).start();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        case 58:
                            Bundle data3 = message2.getData();
                            boolean z = data3 != null ? data3.getBoolean("device_not_quit_car_key", false) : false;
                            C1856n.m8130a("DiagnoseActivity", "SERVICE_DEVICE_INFORMATION_NOT_QUIT_CAR".concat(String.valueOf(z)));
                            DeviceFactoryManager.m8305a().f9906f = z;
                            return;
                        case 59:
                            String string10 = message2.getData().getString(VastExtensionXmlManager.TYPE);
                            if (!TextUtils.isEmpty(string10) && string10.equalsIgnoreCase("dataStreamCount")) {
                                this.f12486a.mo7083i().setDataStreamCount(message2.getData().getInt("count"));
                                return;
                            }
                            return;
                        default:
                            super.handleMessage(message2);
                            return;
                    }
            }
        }
        String string11 = message2.getData().getString("remote_other_message");
        NLog.m9452b("XEE", "收到服务器端发过来的其他信息:".concat(String.valueOf(string11)));
        if ("remote_start_downloading".equals(string11)) {
            NLog.m9452b("XEE", "技师端开始下载:".concat(String.valueOf(string11)));
            iRemoteDownloadListener11 = this.f12486a.f11023M;
            if (iRemoteDownloadListener11 != null) {
                iRemoteDownloadListener12 = this.f12486a.f11023M;
                iRemoteDownloadListener12.mo4640j_();
            }
        } else if ("remote_download_finished".equals(string11)) {
            NLog.m9452b("XEE", "用户端下载完成:".concat(String.valueOf(string11)));
            iRemoteDownloadListener9 = this.f12486a.f11023M;
            if (iRemoteDownloadListener9 != null) {
                iRemoteDownloadListener10 = this.f12486a.f11023M;
                iRemoteDownloadListener10.mo4654b();
            }
        } else if ("remote_download_failed".equals(string11)) {
            NLog.m9452b("XEE", "用户端下载失败:".concat(String.valueOf(string11)));
            iRemoteDownloadListener7 = this.f12486a.f11023M;
            if (iRemoteDownloadListener7 != null) {
                iRemoteDownloadListener8 = this.f12486a.f11023M;
                iRemoteDownloadListener8.mo4652c();
            }
        } else if ("remote_start_downloading".equals(string11)) {
            NLog.m9452b("XEE", "用户端正在下载:".concat(String.valueOf(string11)));
            iRemoteDownloadListener5 = this.f12486a.f11023M;
            if (iRemoteDownloadListener5 != null) {
                iRemoteDownloadListener6 = this.f12486a.f11023M;
                iRemoteDownloadListener6.mo4650d();
            }
        } else if ("remote_download_finished_confirm".equals(string11)) {
            NLog.m9452b("XEE", "技师点击下载完成后点击确定:".concat(String.valueOf(string11)));
            iRemoteDownloadListener3 = this.f12486a.f11023M;
            if (iRemoteDownloadListener3 != null) {
                iRemoteDownloadListener4 = this.f12486a.f11023M;
                iRemoteDownloadListener4.mo4648e();
            }
        } else if ("remote_download_cancel".equals(string11)) {
            NLog.m9452b("XEE", "技师点击取消下载:".concat(String.valueOf(string11)));
            iRemoteDownloadListener = this.f12486a.f11023M;
            if (iRemoteDownloadListener != null) {
                iRemoteDownloadListener2 = this.f12486a.f11023M;
                iRemoteDownloadListener2.mo4646f();
            }
        }
    }
}
