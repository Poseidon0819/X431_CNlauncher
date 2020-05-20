package com.cnlaunch.x431pro.activity.diagnose;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness;
import com.cnlaunch.diagnosemodule.model.DiagnoseActionInfo;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p118c.p119a.MyTools;
import com.cnlaunch.p120d.p121a.ActivityPageManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p169im.p172c.ProMessageFragment;
import com.cnlaunch.p169im.p172c.View$OnTouchListenerC1721q;
import com.cnlaunch.p169im.p173d.AutoVoiceHandler;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.p169im.p180j.SendMessageTask;
import com.cnlaunch.p181j.ExplainResult;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p192a.BluetoothManager;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.bluetooth.BluetoothActivity;
import com.cnlaunch.x431pro.activity.diagnose.p223f.DiagnoseWaitDialog;
import com.cnlaunch.x431pro.activity.diagnose.p223f.RemoteDiagHandler;
import com.cnlaunch.x431pro.activity.p217c.InputVinFragment;
import com.cnlaunch.x431pro.module.cloud.p248b.WebRemoteHandler;
import com.cnlaunch.x431pro.module.p252d.p254b.CarVersionInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagnoseRunningInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.RemoteDiagRunningInfo;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.p210a.RemoteDiagObserve;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseUtils;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Locale;
import message.model.ChatMessage;
import message.model.ChatRoom;
import message.p378a.MessageParameters;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ad */
/* loaded from: classes.dex */
final class C2043ad extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11488a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2043ad(DiagnoseActivity diagnoseActivity) {
        this.f11488a = diagnoseActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean z;
        Handler handler;
        Context context2;
        Context context3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        boolean z2;
        String str;
        Context context4;
        Context context5;
        Context context6;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness;
        String[] strArr;
        Context context7;
        Context context8;
        Handler handler2;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness2;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness3;
        RemoteDiagHandler remoteDiagHandler;
        Context context9;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness4;
        DiagnoseWaitDialog diagnoseWaitDialog;
        BluetoothManager bluetoothManager;
        Context context10;
        Context context11;
        Context context12;
        Context context13;
        Context context14;
        Context context15;
        Context context16;
        Bundle bundleExtra;
        int m7720C;
        DiagnoseWaitDialog diagnoseWaitDialog2;
        int m7720C2;
        DiagnoseWaitDialog diagnoseWaitDialog3;
        DiagnoseWaitDialog diagnoseWaitDialog4;
        DiagnoseWaitDialog diagnoseWaitDialog5;
        DiagnoseWaitDialog diagnoseWaitDialog6;
        DiagnoseWaitDialog diagnoseWaitDialog7;
        DiagnoseWaitDialog diagnoseWaitDialog8;
        DiagnoseWaitDialog diagnoseWaitDialog9;
        Context context17;
        int m7720C3;
        int m7720C4;
        DiagnoseWaitDialog diagnoseWaitDialog10;
        int m7720C5;
        int m7720C6;
        RemoteDiagHandler remoteDiagHandler2;
        RemoteDiagHandler remoteDiagHandler3;
        RemoteDiagRunningInfo remoteDiagRunningInfo;
        RemoteDiagRunningInfo remoteDiagRunningInfo2;
        RemoteDiagRunningInfo remoteDiagRunningInfo3;
        Context context18;
        RemoteDiagRunningInfo remoteDiagRunningInfo4;
        Context context19;
        Context context20;
        DiagnoseWaitDialog diagnoseWaitDialog11;
        DiagnoseWaitDialog diagnoseWaitDialog12;
        DiagnoseWaitDialog diagnoseWaitDialog13;
        DiagnoseWaitDialog diagnoseWaitDialog14;
        DiagnoseWaitDialog diagnoseWaitDialog15;
        DiagnoseWaitDialog diagnoseWaitDialog16;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness5;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness6;
        Context context21;
        Context context22;
        DiagnoseWaitDialog diagnoseWaitDialog17;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness7;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness8;
        Context context23;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness9;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness10;
        RemoteDiagHandler remoteDiagHandler4;
        Messenger messenger;
        Activity lastElement;
        String action = intent.getAction();
        NLog.m9456a("DiagnoseActivity", "mReceiver action=".concat(String.valueOf(action)));
        if (action.equals("pause_soundpool")) {
            DiagnoseActivity.m7723A(this.f11488a);
        } else if (action.equals("android.intent.action.LOCALE_CHANGED")) {
            this.f11488a.m7606u();
            ActivityPageManager.m9634a();
            if (ActivityPageManager.f6742a != null && ActivityPageManager.f6742a.size() > 0 && (lastElement = ActivityPageManager.f6742a.lastElement()) != null) {
                ActivityPageManager.f6742a.remove(lastElement);
                lastElement.finish();
            }
            Process.killProcess(Process.myPid());
            System.exit(0);
        } else {
            if (action.equals(DiagnoseActionInfo.DiagServiceInitMessager)) {
                Message obtain = Message.obtain((Handler) null, 0);
                messenger = this.f11488a.f11026P;
                obtain.replyTo = messenger;
                this.f11488a.m7692a(obtain);
            } else if (action.equals(DiagnoseConstants.DIAG_EXIT_BROADCAST)) {
                if (this.f11488a.mo7083i().getDiagnoseStatue() < 2) {
                    remoteDiagHandler4 = this.f11488a.f11015D;
                    remoteDiagHandler4.mo7050a(109);
                } else {
                    if (C2744aa.m5166c() && !C1947h.f10551c) {
                        this.f11488a.m7602w();
                        C1947h.f10552d = false;
                    }
                    context23 = this.f11488a.f11019H;
                    LoadDialog.m4681b(context23);
                    this.f11488a.m7600x();
                    this.f11488a.m7598y();
                    this.f11488a.m7620n();
                    this.f11488a.m7632f(true);
                }
                diagnoseUIDataBusiness9 = this.f11488a.f11070ah;
                if (diagnoseUIDataBusiness9 != null) {
                    diagnoseUIDataBusiness10 = this.f11488a.f11070ah;
                    diagnoseUIDataBusiness10.closeAlertDialog(DiagnoseConstants.UI_TYPE_DIALOG, true);
                }
            } else if (action.equals(DiagnoseConstants.DIAG_ERROR_BROADCAST)) {
                diagnoseUIDataBusiness7 = this.f11488a.f11070ah;
                if (diagnoseUIDataBusiness7 != null) {
                    diagnoseUIDataBusiness8 = this.f11488a.f11070ah;
                    diagnoseUIDataBusiness8.closeAlertDialog(DiagnoseConstants.UI_TYPE_DIALOG, true);
                }
                if (this.f11488a.mo7083i().isBinding()) {
                    if (intent.hasExtra("errFromDiagnoseService")) {
                        DiagnoseActivity.m7716F(this.f11488a);
                    }
                    this.f11488a.m7604v();
                    this.f11488a.m7606u();
                }
                this.f11488a.m7600x();
                this.f11488a.m7620n();
            } else {
                if (action.equals("android.hardware.usb.action.USB_DEVICE_ATTACHED")) {
                    DeviceFactoryManager.m8305a();
                    context21 = this.f11488a.f11019H;
                    if (DeviceFactoryManager.m8303a(context21, intent)) {
                        C1856n.m8130a("DiagnoseActivity", "ACTION_USB_DEVICE_ATTACHED");
                        if (MainActivity.m7907a()) {
                            if (this.f11488a.f11024N) {
                                if (DeviceFactoryManager.m8305a().f9902b) {
                                    return;
                                }
                                int i = DeviceFactoryManager.m8305a().f9903c;
                                if (i != 3) {
                                    DeviceFactoryManager.m8305a().m8284d();
                                    DeviceFactoryManager m8305a = DeviceFactoryManager.m8305a();
                                    context22 = this.f11488a.f11019H;
                                    m8305a.m8301a(context22, false, (String) null);
                                    String str2 = "";
                                    if (i == 1) {
                                        str2 = this.f11488a.getResources().getString(R.string.connect_auto_change_wifi_to_usb_tip_message);
                                    } else if (i == 0) {
                                        str2 = this.f11488a.getResources().getString(R.string.connect_auto_change_bluetooth_to_usb_tip_message);
                                    } else if (i == 2) {
                                        str2 = this.f11488a.getResources().getString(R.string.connect_auto_change_serialport_to_usb_tip_message);
                                    }
                                    diagnoseWaitDialog17 = this.f11488a.f11078ap;
                                    diagnoseWaitDialog17.m7059a(str2);
                                    return;
                                } else if (DeviceFactoryManager.m8305a().f9906f) {
                                    return;
                                } else {
                                    DiagnoseActivity.m7714H(this.f11488a);
                                    return;
                                }
                            }
                            int i2 = DeviceFactoryManager.m8305a().f9903c;
                            if (i2 == -1 || i2 == 3) {
                                return;
                            }
                            DiagnoseActivity.m7714H(this.f11488a);
                            DiagnoseActivity.m7722B();
                            return;
                        }
                        IPhysics iPhysics = DeviceFactoryManager.m8305a().f9901a;
                        if (iPhysics != null && iPhysics.getState() == 2) {
                            DiagnoseActivity.m7714H(this.f11488a);
                        }
                        DiagnoseActivity.m7722B();
                        return;
                    }
                }
                if (action.equals("android.bluetooth.device.action.ACL_DISCONNECTED") || (Build.VERSION.SDK_INT >= 23 && action.equals("android.bluetooth.adapter.action.STATE_CHANGED") && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10) == 10)) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    String m9591a = PreferencesManager.m9595a((Context) this.f11488a).m9591a("serialNo");
                    if ((action.equals("android.bluetooth.adapter.action.STATE_CHANGED") || !(bluetoothDevice == null || bluetoothDevice.getName() == null || !bluetoothDevice.getName().equals(m9591a))) && DeviceFactoryManager.m8305a().f9903c != 1) {
                        if (!MainActivity.m7907a()) {
                            if (!DiagnoseConstants.driviceConnStatus || DeviceFactoryManager.m8305a().f9903c == 3) {
                                return;
                            }
                            DiagnoseActivity.m7724A();
                        } else if (!this.f11488a.f11024N || this.f11488a.mo7083i().getDiagnoseStatue() == 1 || DeviceFactoryManager.m8305a().f9902b || DeviceFactoryManager.m8305a().f9903c == 3 || DeviceFactoryManager.m8305a().f9906f) {
                        } else {
                            C1856n.m8130a("DiagnoseActivity", "current link mode is LINK_MODE_Bluetooth");
                            IPhysics iPhysics2 = DeviceFactoryManager.m8305a().f9901a;
                            if (iPhysics2 == null || iPhysics2.getState() == 2) {
                                return;
                            }
                            z = this.f11488a.f11110bg;
                            if (z) {
                                return;
                            }
                            DiagnoseActivity.m7714H(this.f11488a);
                            DiagnoseActivity.m7724A();
                        }
                    }
                } else if (action.equals("DPUDeviceConnectDisconnected")) {
                    if (intent.getBooleanExtra("isFix", false)) {
                        return;
                    }
                    if (!MainActivity.m7907a()) {
                        if (DiagnoseConstants.driviceConnStatus) {
                            DiagnoseActivity.m7724A();
                        }
                    } else if (!this.f11488a.f11024N) {
                        diagnoseUIDataBusiness5 = this.f11488a.f11070ah;
                        if (diagnoseUIDataBusiness5 != null) {
                            diagnoseUIDataBusiness6 = this.f11488a.f11070ah;
                            diagnoseUIDataBusiness6.closeAlertDialog(DiagnoseConstants.UI_TYPE_DIALOG, true);
                        }
                        if (DeviceFactoryManager.m8305a().f9904d || DeviceFactoryManager.m8305a().f9902b) {
                            C1856n.m8130a("DiagnoseActivity", "RESET STATE OR NeedChangeLinkMode");
                        } else {
                            DiagnoseActivity.m7714H(this.f11488a);
                        }
                    } else if (this.f11488a.mo7083i().getDiagnoseStatue() == 1 || DeviceFactoryManager.m8305a().f9902b) {
                    } else {
                        int i3 = DeviceFactoryManager.m8305a().f9903c;
                        if (i3 == 1) {
                            DiagnoseActivity.m7714H(this.f11488a);
                            DiagnoseActivity.m7724A();
                        } else if (i3 == 2) {
                            DiagnoseActivity.m7714H(this.f11488a);
                            DiagnoseActivity.m7724A();
                        } else {
                            DeviceFactoryManager m8305a2 = DeviceFactoryManager.m8305a();
                            context20 = this.f11488a.f11019H;
                            IPhysics m8301a = m8305a2.m8301a(context20, false, (String) null);
                            int i4 = DeviceFactoryManager.m8305a().f9903c;
                            if (i4 == 0) {
                                String string = this.f11488a.getResources().getString(R.string.connect_auto_change_usb_to_bluetooth_tip_message);
                                diagnoseWaitDialog15 = this.f11488a.f11078ap;
                                diagnoseWaitDialog15.m7059a(string);
                                diagnoseWaitDialog16 = this.f11488a.f11078ap;
                                diagnoseWaitDialog16.show();
                                bluetoothManager = m8301a instanceof BluetoothManager ? (BluetoothManager) m8301a : null;
                                if (bluetoothManager != null) {
                                    new C2044ae(this, bluetoothManager).start();
                                }
                            } else if (i4 == 1) {
                                String string2 = this.f11488a.getResources().getString(R.string.connect_auto_change_usb_to_wifi_tip_message);
                                diagnoseWaitDialog13 = this.f11488a.f11078ap;
                                diagnoseWaitDialog13.m7059a(string2);
                                diagnoseWaitDialog14 = this.f11488a.f11078ap;
                                diagnoseWaitDialog14.show();
                            } else if (i4 == 2) {
                                String string3 = this.f11488a.getResources().getString(R.string.connect_auto_change_usb_to_serialport_tip_message);
                                diagnoseWaitDialog11 = this.f11488a.f11078ap;
                                diagnoseWaitDialog11.m7059a(string3);
                                diagnoseWaitDialog12 = this.f11488a.f11078ap;
                                diagnoseWaitDialog12.show();
                            }
                        }
                    }
                } else if (action.equals("LaunchRemoteDiag")) {
                    if (DiagnoseActivity.f11013J) {
                        context19 = this.f11488a.f11019H;
                        NToast.m9444c(context19, (int) R.string.remotediagnoseconnected);
                        return;
                    }
                    DiagnoseActivity.f11013J = true;
                    this.f11488a.f11130n = (RemoteDiagRunningInfo) intent.getSerializableExtra("RemoteDiagInfo");
                    remoteDiagRunningInfo2 = this.f11488a.f11130n;
                    remoteDiagRunningInfo2.setLan(Locale.getDefault().getCountry());
                    remoteDiagRunningInfo3 = this.f11488a.f11130n;
                    context18 = this.f11488a.f11019H;
                    remoteDiagRunningInfo3.setUserID(PreferencesManager.m9595a(context18).m9591a("user_id"));
                    DiagnoseActivity diagnoseActivity = this.f11488a;
                    remoteDiagRunningInfo4 = diagnoseActivity.f11130n;
                    int indetify = remoteDiagRunningInfo4.getIndetify();
                    MainActivity.m7887b(true);
                    DiagnoseUtils.m5086a().m5079c();
                    diagnoseActivity.mo7083i().setDiagnoseStatue(indetify);
                    diagnoseActivity.f11130n.setRomote_diag_start_time(String.valueOf(System.currentTimeMillis() / 1000));
                    DiagnoseConstants.setDiagIdentity(indetify);
                    if (diagnoseActivity.f11015D != null) {
                        diagnoseActivity.f11015D.m7047b();
                    }
                    diagnoseActivity.f11015D = new HandlerC2057ar(diagnoseActivity, diagnoseActivity);
                    diagnoseActivity.f11015D.f12460b = 0;
                    diagnoseActivity.mo7082j();
                    if (diagnoseActivity.f11017F != null) {
                        diagnoseActivity.f11017F.setPanelSlideListener(diagnoseActivity.f11036Z);
                    }
                    if (diagnoseActivity.f11016E != null) {
                        diagnoseActivity.f11016E.setVisibility(0);
                    }
                    diagnoseActivity.f11020I = new ProMessageFragment();
                    diagnoseActivity.f11021K = (Button) diagnoseActivity.findViewById(R.id.btn_recordvoice);
                    diagnoseActivity.f11021K.setOnTouchListener(new View$OnTouchListenerC1721q(diagnoseActivity.f11020I));
                    diagnoseActivity.f11018G.setText(TextUtils.isEmpty(diagnoseActivity.f11130n.getOtherUseName()) ? diagnoseActivity.f11130n.getOtherUseID() : diagnoseActivity.f11130n.getOtherUseName());
                    ChatRoom chatRoom = new ChatRoom(diagnoseActivity.f11130n.getOtherUseID(), diagnoseActivity.f11130n.getOtherUseName(), MessageParameters.EnumC4721a.single);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("ChatRoom", chatRoom);
                    bundle.putInt("launch_model", 2);
                    bundle.putBoolean("IsRemoteDiagFlag", true);
                    diagnoseActivity.f11020I.setArguments(bundle);
                    diagnoseActivity.getFragmentManager().beginTransaction().add(R.id.fragment_chat, diagnoseActivity.f11020I, ProMessageFragment.class.getName()).commitAllowingStateLoss();
                    AutoVoiceHandler.f9188c = true;
                    if (indetify == 1) {
                        diagnoseActivity.m7739c(20014);
                    } else {
                        diagnoseActivity.m7660b(diagnoseActivity.f11130n.getDiagSoft().getSoftBundle());
                    }
                } else {
                    if (action.equalsIgnoreCase("SPT_SET_VIN")) {
                        DiagnoseUtils m5086a = DiagnoseUtils.m5086a();
                        if (!MyTools.m9636a(DiagnoseConstants.VIN_CODE) && m5086a.f15757c != null && MyTools.m9636a(m5086a.f15757c.getVin())) {
                            NLog.m9452b("XEE", "获取到VIN码的广播 VIN:" + DiagnoseConstants.VIN_CODE);
                            m5086a.f15757c.setVin(DiagnoseConstants.VIN_CODE);
                            C2744aa.m5183a(m5086a.f15755a, DiagnoseConstants.VIN_CODE, "");
                            if (m5086a.f15755a.mo7083i().getDiagnoseStatue() == 0) {
                                m5086a.f15755a.m7690a(m5086a.f15757c);
                            }
                        }
                    }
                    if (action.equalsIgnoreCase("GET_OTO")) {
                        DiagnoseUtils m5086a2 = DiagnoseUtils.m5086a();
                        String stringExtra = intent.getStringExtra("OTO");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            NLog.m9452b("XEE", "获取到里程广播:".concat(String.valueOf(stringExtra)));
                            if (!"0".equals(stringExtra) && !TextUtils.isEmpty(stringExtra) && !MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR.equals(stringExtra) && m5086a2.f15757c != null && m5086a2.f15755a.mo7083i().getDiagnoseStatue() != 1) {
                                m5086a2.f15757c.setMileage(stringExtra);
                                m5086a2.m5085a(m5086a2.f15755a);
                            }
                        }
                    }
                    if (action.equalsIgnoreCase("LaunchCloudDiag")) {
                        if (MainActivity.m7907a()) {
                            return;
                        }
                        String stringExtra2 = intent.getStringExtra("VIN");
                        String stringExtra3 = intent.getStringExtra("package_id");
                        if (TextUtils.isEmpty(stringExtra3)) {
                            C2744aa.m5172b((Activity) this.f11488a, stringExtra2);
                        } else {
                            Log.i("XEE", "通过packageID启动2:".concat(String.valueOf(stringExtra3)));
                            C2744aa.m5187a((Activity) this.f11488a, stringExtra3);
                        }
                    }
                    if (action.equalsIgnoreCase("LaunchWebRemoteDiag")) {
                        WebRemoteHandler.m5419a().f15483c.obtainMessage(12).sendToTarget();
                        String stringExtra4 = intent.getStringExtra("package_id");
                        DiagnoseConstants.setDiagIdentity(0);
                        if (!TextUtils.isEmpty(stringExtra4)) {
                            C2744aa.m5187a((Activity) this.f11488a, stringExtra4);
                        }
                    }
                    if (action.equals("StopRemotoDiagnoseFromBuletooth")) {
                        remoteDiagRunningInfo = this.f11488a.f11130n;
                        ChatMessage m190a = new ChatRoom(remoteDiagRunningInfo.getOtherUseID(), "", MessageParameters.EnumC4721a.single).m190a(10);
                        m190a.m214a("text", (Object) this.f11488a.getString(R.string.canlce_remotediag));
                        m190a.m214a("content", (Object) ExplainResult.STOP);
                        new SendMessageTask().m256e(m190a);
                        this.f11488a.mo7085f(1);
                    }
                    if (action.equals("StopRemotoDiagnose")) {
                        if (this.f11488a.mo7083i().getDiagnoseStatue() < 2) {
                            if (MainActivity.m7875f()) {
                                RemoteDiagObserve.m7936c();
                            }
                            remoteDiagHandler2 = this.f11488a.f11015D;
                            if (remoteDiagHandler2.f12460b < 6) {
                                remoteDiagHandler3 = this.f11488a.f11015D;
                                remoteDiagHandler3.m7051a();
                                this.f11488a.m7692a(Message.obtain((Handler) null, 52));
                                this.f11488a.mo7085f(1);
                            }
                        }
                    } else if (action.equals("DPUDeviceConnectSuccess")) {
                        if (true == intent.getBooleanExtra("isFix", false) || DiagnoseConstants.DIAGNOSE_LIB_PATH == null || DiagnoseConstants.DIAGNOSE_LIB_PATH.length() <= 0) {
                            return;
                        }
                        DiagnoseConstants.driviceConnStatus = true;
                        if (DeviceFactoryManager.m8305a().f9906f) {
                            if (DeviceFactoryManager.m8305a().f9902b) {
                                DiagnoseActivity diagnoseActivity2 = this.f11488a;
                                diagnoseActivity2.mo7091a(DiagnoseConstants.UI_TYPE_DIALOG, "90", diagnoseActivity2.getString(R.string.custom_diaglog_title), this.f11488a.getString(R.string.common_loading_tips));
                                if (DeviceFactoryManager.m8305a().f9904d) {
                                    Message obtain2 = Message.obtain((Handler) null, 25);
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("device_information_key", "device_information_linkmode");
                                    m7720C6 = this.f11488a.m7720C();
                                    bundle2.putInt("device_information_value", m7720C6);
                                    obtain2.setData(bundle2);
                                    this.f11488a.m7692a(obtain2);
                                    DeviceFactoryManager.m8305a().m8297a(false);
                                    Dialog dialog = DeviceFactoryManager.m8305a().f9905e;
                                    if (dialog != null) {
                                        dialog.dismiss();
                                        DeviceFactoryManager.m8305a().f9905e = null;
                                    }
                                } else {
                                    Message obtain3 = Message.obtain((Handler) null, 25);
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putString("device_information_key", "device_information_linkmode");
                                    m7720C5 = this.f11488a.m7720C();
                                    bundle3.putInt("device_information_value", m7720C5);
                                    obtain3.setData(bundle3);
                                    this.f11488a.m7692a(obtain3);
                                    bundle3.putString("device_information_key", "device_information_status");
                                    bundle3.putInt("device_information_value", DeviceFactoryManager.m8305a().f9901a.getState());
                                    obtain3.setData(bundle3);
                                    this.f11488a.m7692a(obtain3);
                                    if (DeviceFactoryManager.m8305a().f9902b) {
                                        DeviceFactoryManager.m8305a().f9902b = false;
                                    }
                                }
                            }
                            Message obtain4 = Message.obtain((Handler) null, 25);
                            Bundle bundle4 = new Bundle();
                            bundle4.putString("device_information_key", "device_information_linkmode");
                            m7720C4 = this.f11488a.m7720C();
                            bundle4.putInt("device_information_value", m7720C4);
                            obtain4.setData(bundle4);
                            this.f11488a.m7692a(obtain4);
                            bundle4.putString("device_information_key", "device_information_status");
                            bundle4.putInt("device_information_value", DeviceFactoryManager.m8305a().f9901a.getState());
                            obtain4.setData(bundle4);
                            this.f11488a.m7692a(obtain4);
                            if (DeviceFactoryManager.m8305a().f9902b) {
                                DeviceFactoryManager.m8305a().f9902b = false;
                            }
                            diagnoseWaitDialog10 = this.f11488a.f11078ap;
                            diagnoseWaitDialog10.dismiss();
                        } else if (DeviceFactoryManager.m8305a().f9904d || DeviceFactoryManager.m8305a().f9902b) {
                            DiagnoseActivity diagnoseActivity3 = this.f11488a;
                            diagnoseActivity3.mo7091a(DiagnoseConstants.UI_TYPE_DIALOG, "90", diagnoseActivity3.getString(R.string.custom_diaglog_title), this.f11488a.getString(R.string.common_loading_tips));
                            if (DeviceFactoryManager.m8305a().f9904d) {
                                Message obtain5 = Message.obtain((Handler) null, 25);
                                Bundle bundle5 = new Bundle();
                                bundle5.putString("device_information_key", "device_information_linkmode");
                                m7720C2 = this.f11488a.m7720C();
                                bundle5.putInt("device_information_value", m7720C2);
                                obtain5.setData(bundle5);
                                this.f11488a.m7692a(obtain5);
                                DeviceFactoryManager.m8305a().m8297a(false);
                                Dialog dialog2 = DeviceFactoryManager.m8305a().f9905e;
                                if (dialog2 != null) {
                                    dialog2.dismiss();
                                    DeviceFactoryManager.m8305a().f9905e = null;
                                }
                            }
                            Message obtain6 = Message.obtain((Handler) null, 25);
                            Bundle bundle6 = new Bundle();
                            bundle6.putString("device_information_key", "device_information_linkmode");
                            m7720C = this.f11488a.m7720C();
                            bundle6.putInt("device_information_value", m7720C);
                            obtain6.setData(bundle6);
                            this.f11488a.m7692a(obtain6);
                            bundle6.putString("device_information_key", "device_information_status");
                            bundle6.putInt("device_information_value", DeviceFactoryManager.m8305a().f9901a.getState());
                            obtain6.setData(bundle6);
                            this.f11488a.m7692a(obtain6);
                            if (DeviceFactoryManager.m8305a().f9902b) {
                                DeviceFactoryManager.m8305a().f9902b = false;
                            }
                            diagnoseWaitDialog2 = this.f11488a.f11078ap;
                            diagnoseWaitDialog2.dismiss();
                        } else if (MainActivity.m7907a()) {
                            if (this.f11488a.f11024N) {
                                Message obtain7 = Message.obtain((Handler) null, 25);
                                Bundle bundle7 = new Bundle();
                                bundle7.putString("device_information_key", "device_information_linkmode");
                                m7720C3 = this.f11488a.m7720C();
                                bundle7.putInt("device_information_value", m7720C3);
                                obtain7.setData(bundle7);
                                this.f11488a.m7692a(obtain7);
                            }
                            diagnoseWaitDialog9 = this.f11488a.f11078ap;
                            diagnoseWaitDialog9.dismiss();
                            context17 = this.f11488a.f11019H;
                            NToast.m9449a(context17, intent.getStringExtra(MessageDao.TABLENAME));
                        } else {
                            if (DeviceFactoryManager.m8305a().f9903c == 3) {
                                diagnoseWaitDialog8 = this.f11488a.f11078ap;
                                diagnoseWaitDialog8.show();
                            } else {
                                StringBuilder sb = new StringBuilder("mConnectWaitDialog.isShowing() STATE = ");
                                diagnoseWaitDialog3 = this.f11488a.f11078ap;
                                sb.append(diagnoseWaitDialog3.isShowing());
                                C1856n.m8130a("DiagnoseActivity", sb.toString());
                                diagnoseWaitDialog4 = this.f11488a.f11078ap;
                                if (!diagnoseWaitDialog4.isShowing()) {
                                    diagnoseWaitDialog5 = this.f11488a.f11078ap;
                                    diagnoseWaitDialog5.m7059a(this.f11488a.getString(R.string.connector_reset_processing_tips));
                                    diagnoseWaitDialog6 = this.f11488a.f11078ap;
                                    diagnoseWaitDialog6.show();
                                }
                            }
                            diagnoseWaitDialog7 = this.f11488a.f11078ap;
                            diagnoseWaitDialog7.m7064a();
                        }
                    } else if (action.equals("action.bt.device.con.coning")) {
                        if (intent.getBooleanExtra("isFix", false)) {
                            return;
                        }
                        IPhysics iPhysics3 = DeviceFactoryManager.m8305a().f9901a;
                        bluetoothManager = iPhysics3 instanceof BluetoothManager ? (BluetoothManager) iPhysics3 : null;
                        if (bluetoothManager == null || !bluetoothManager.m8452a() || (bundleExtra = intent.getBundleExtra("customBluetoothBroadcastIntentExtraBundle")) == null) {
                            return;
                        }
                        bundleExtra.getInt("auto_reconnect_count");
                    } else if (action.equals("DPUDeviceConnectFail")) {
                        if (intent.getBooleanExtra("isFix", false)) {
                            return;
                        }
                        diagnoseWaitDialog = this.f11488a.f11078ap;
                        diagnoseWaitDialog.dismiss();
                        if (MainActivity.m7907a()) {
                            if (this.f11488a.f11024N && !DeviceFactoryManager.m8305a().f9906f) {
                                context16 = this.f11488a.f11019H;
                                NToast.m9449a(context16, intent.getStringExtra(MessageDao.TABLENAME));
                                DiagnoseActivity.m7714H(this.f11488a);
                            }
                            if (DeviceFactoryManager.m8305a().f9904d || DeviceFactoryManager.m8305a().f9902b) {
                                context15 = this.f11488a.f11019H;
                                NToast.m9449a(context15, intent.getStringExtra(MessageDao.TABLENAME));
                                DiagnoseActivity.m7714H(this.f11488a);
                                return;
                            }
                            return;
                        }
                        switch (DeviceFactoryManager.m8305a().f9903c) {
                            case 0:
                                IPhysics iPhysics4 = DeviceFactoryManager.m8305a().f9901a;
                                bluetoothManager = iPhysics4 instanceof BluetoothManager ? (BluetoothManager) iPhysics4 : null;
                                if (bluetoothManager == null || !bluetoothManager.m8452a()) {
                                    return;
                                }
                                Intent intent2 = new Intent();
                                context10 = this.f11488a.f11019H;
                                intent2.setClass(context10, BluetoothActivity.class);
                                intent2.putExtra("isDiagModel", true);
                                intent2.putExtra("Lib_path", DiagnoseConstants.DIAGNOSE_LIB_PATH);
                                intent2.putExtra("Lib_language", DiagnoseConstants.DIAGNOSE_LANGUAGE);
                                intent2.putExtra("is_connect_fail", intent.getBooleanExtra("is_connect_fail", true));
                                context11 = this.f11488a.f11019H;
                                context11.startActivity(intent2);
                                return;
                            case 1:
                                context12 = this.f11488a.f11019H;
                                MessageDialog messageDialog = new MessageDialog(context12, this.f11488a.getResources().getString(R.string.dialog_title_default), intent.getStringExtra(MessageDao.TABLENAME), false, (byte) 0);
                                messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2045af(this));
                                messageDialog.show();
                                return;
                            case 2:
                                context13 = this.f11488a.f11019H;
                                MessageDialog messageDialog2 = new MessageDialog(context13, this.f11488a.getResources().getString(R.string.dialog_title_default), intent.getStringExtra(MessageDao.TABLENAME), false, (byte) 0);
                                messageDialog2.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2046ag(this));
                                messageDialog2.show();
                                return;
                            case 3:
                                context14 = this.f11488a.f11019H;
                                NToast.m9449a(context14, intent.getStringExtra(MessageDao.TABLENAME));
                                return;
                            default:
                                return;
                        }
                    } else if (action.equals(DiagnoseConstants.SCREEN_CHANGE)) {
                        DiagnoseActivity.m7612r();
                    } else if (action.equals("JumpDownloadBin")) {
                        this.f11488a.mo7094a(DiagnoseConstants.DIAGNOSE_LIB_PATH, DiagnoseConstants.DIAGNOSE_LANGUAGE);
                    } else if (action.equals("DownloadBin_DisConnBluetooth")) {
                        this.f11488a.mo7085f(3);
                        DiagnoseActivity.m7724A();
                    } else if (action.equals("NativeMethodNoFind")) {
                        diagnoseUIDataBusiness3 = this.f11488a.f11070ah;
                        if (diagnoseUIDataBusiness3 != null) {
                            diagnoseUIDataBusiness4 = this.f11488a.f11070ah;
                            diagnoseUIDataBusiness4.closeAlertDialog(DiagnoseConstants.UI_TYPE_DIALOG, true);
                        }
                        String type = intent.getType();
                        if (type != null && type.equals("HadSoFileNotCopy")) {
                            context9 = this.f11488a.f11019H;
                            NToast.m9446b(context9, "Had .so File Not Copy");
                        }
                        if (this.f11488a.mo7083i().getDiagnoseStatue() < 2) {
                            remoteDiagHandler = this.f11488a.f11015D;
                            remoteDiagHandler.m7051a();
                            this.f11488a.m7692a(Message.obtain((Handler) null, 52));
                            this.f11488a.mo7085f(1);
                            return;
                        }
                        if (C2744aa.m5166c() && !C1947h.f10551c) {
                            this.f11488a.m7602w();
                            C1947h.f10552d = false;
                        }
                        this.f11488a.m7620n();
                        this.f11488a.m7598y();
                    } else if (action.equals("ExitDiagnoseWithHomeBtn")) {
                        this.f11488a.mo7085f(0);
                    } else if (!action.equals("startDiagnoseWithoutSelectVersion")) {
                        if (action.equals("VIN_CAR_ARRAY")) {
                            context6 = this.f11488a.f11019H;
                            LoadDialog.m4686a(context6);
                            DiagnoseActivity.m7710L(this.f11488a);
                            diagnoseUIDataBusiness = this.f11488a.f11070ah;
                            if (diagnoseUIDataBusiness != null) {
                                diagnoseUIDataBusiness2 = this.f11488a.f11070ah;
                                diagnoseUIDataBusiness2.closeAlertDialog(DiagnoseConstants.UI_TYPE_DIALOG, true);
                            }
                            this.f11488a.m7606u();
                            DiagnoseUtils.m5081b(this.f11488a);
                            DiagnoseConstants.VIN_CODE = intent.getStringExtra("cur_vin_code");
                            this.f11488a.f11043aG = intent.getStringArrayExtra("VinArray");
                            strArr = this.f11488a.f11043aG;
                            if (strArr != null) {
                                handler2 = this.f11488a.f11103bO;
                                handler2.sendEmptyMessageDelayed(20501, 500L);
                                return;
                            }
                            DiagnoseConstants.VIN_CODE = "";
                            context7 = this.f11488a.f11019H;
                            NToast.m9450a(context7, (int) R.string.vin_cararray_fail);
                            context8 = this.f11488a.f11019H;
                            LoadDialog.m4681b(context8);
                            this.f11488a.m7620n();
                        } else if (action.equals("CT_HEAD_RET_READVINCVN")) {
                            String stringExtra5 = intent.getStringExtra("VINCVN");
                            String str3 = "";
                            if (stringExtra5.contains("VIN:")) {
                                DiagnoseConstants.VIN_CODE = stringExtra5.substring(stringExtra5.indexOf("VIN:") + 4, stringExtra5.indexOf("}"));
                            }
                            if (stringExtra5.contains("CVN:")) {
                                int indexOf = stringExtra5.indexOf("CVN:") + 4;
                                DiagnoseConstants.RECORD_CVN = stringExtra5.substring(indexOf, stringExtra5.indexOf("}", indexOf));
                            }
                            if (stringExtra5.contains("SoftID:")) {
                                int indexOf2 = stringExtra5.indexOf("SoftID:") + 7;
                                str3 = stringExtra5.substring(indexOf2, stringExtra5.indexOf("}", indexOf2));
                            }
                            if (stringExtra5.contains("EngSpd:")) {
                                int indexOf3 = stringExtra5.indexOf("EngSpd:") + 7;
                                DiagnoseConstants.RECORD_ENGINESPEED = stringExtra5.substring(indexOf3, stringExtra5.indexOf("}", indexOf3));
                            }
                            Intent intent3 = new Intent("VIN_CAR_ARRAY");
                            intent3.putExtra("VinArray", str3.split(","));
                            intent3.putExtra("cur_vin_code", DiagnoseConstants.VIN_CODE);
                            context4 = this.f11488a.f11019H;
                            context4.sendBroadcast(intent3);
                            context5 = this.f11488a.f11019H;
                            NToast.m9449a(context5, "CT_HEAD_RET_READVINCVN ret = " + intent.getStringExtra("VINCVN"));
                        } else if (!action.equals("VIN_START_DIAG")) {
                            if (action.equals("InputVinFragment")) {
                                InputVinFragment inputVinFragment = new InputVinFragment();
                                this.f11488a.mo7098a((Fragment) inputVinFragment, inputVinFragment.getClass().getName(), false);
                            } else if (action.equals("DownloadBin_DisConnBluetooth")) {
                                this.f11488a.m7620n();
                            } else {
                                if (action.equals("HISTORY_DIAG")) {
                                    this.f11488a.mo7083i().setCarSoftName(intent.getStringExtra("carName"));
                                    this.f11488a.mo7083i().setSerialNum(intent.getStringExtra("serialNo"));
                                    this.f11488a.mo7083i().setSoftPackageid(intent.getStringExtra("softPackageid"));
                                    this.f11488a.mo7083i().setSoftVersion(intent.getStringExtra("softVersion"));
                                    this.f11488a.mo7083i().setSoftLan(intent.getStringExtra("softLan"));
                                    this.f11488a.mo7083i().setVID(intent.getIntExtra("VID", -1));
                                    if (intent.hasExtra("vin")) {
                                        this.f11488a.mo7083i().setVin(intent.getStringExtra("vin"));
                                    }
                                    DiagnoseConstants.DIAG_INPUT_TYPE = "2";
                                    arrayList = this.f11488a.f11056aT;
                                    if (arrayList == null) {
                                        this.f11488a.f11056aT = new ArrayList();
                                    }
                                    arrayList2 = this.f11488a.f11056aT;
                                    arrayList2.clear();
                                    CarVersionInfo carVersionInfo = new CarVersionInfo();
                                    carVersionInfo.setVersion(intent.getStringExtra("softVersion"));
                                    carVersionInfo.setLanguage(intent.getStringExtra("softLan"));
                                    arrayList3 = this.f11488a.f11056aT;
                                    arrayList3.add(carVersionInfo);
                                    DiagnoseActivity.m7704R(this.f11488a);
                                    this.f11488a.m7668a(intent.getStringExtra("carName"), intent.getStringExtra("path"), intent.getStringExtra("language"), true);
                                }
                                if (action.equals("NativeSoNotFind")) {
                                    String serialNum = DiagnoseActivity.f11012C.getSerialNum();
                                    String softPackageid = DiagnoseActivity.f11012C.getSoftPackageid();
                                    String softVersion = DiagnoseActivity.f11012C.getSoftVersion();
                                    String stringExtra6 = intent.getStringExtra("softPath");
                                    context2 = this.f11488a.f11019H;
                                    new CarIconUtils(context2).m4970a(serialNum, softPackageid, stringExtra6, softVersion);
                                    context3 = this.f11488a.f11019H;
                                    NToast.m9446b(context3, this.f11488a.getResources().getString(R.string.no_this_carversion));
                                    C2744aa.m5165c((Activity) this.f11488a, softPackageid);
                                }
                                if (action.equals("UpdateDatastreamCount")) {
                                    this.f11488a.mo7083i().setDataStreamCount(intent.getIntExtra("count", 0));
                                }
                                if (action.equals("NEED_DOWN_LOAD_VEHICLES")) {
                                    C2744aa.m5165c((Activity) this.f11488a, intent.getStringExtra("vehicles"));
                                }
                                if (action.equals("com.cnlaunch.intent.action.DIAG_UNCONNECTED")) {
                                    handler = this.f11488a.f11103bO;
                                    handler.sendEmptyMessage(20504);
                                }
                            }
                        } else {
                            DiagnoseUtils.m5081b(this.f11488a.f11019H);
                            DiagnoseConstants.DIAG_INPUT_TYPE = "1";
                            this.f11488a.mo7083i().setCarSoftName(intent.getStringExtra("carName"));
                            this.f11488a.mo7083i().setSerialNum(intent.getStringExtra("serialNo"));
                            this.f11488a.mo7083i().setSoftPackageid(intent.getStringExtra("softPackageid"));
                            this.f11488a.mo7083i().setSoftVersion(intent.getStringExtra("softVersion"));
                            this.f11488a.mo7083i().setSoftLan(intent.getStringExtra("softLan"));
                            z2 = this.f11488a.f11044aH;
                            if (z2) {
                                DiagnoseRunningInfo mo7083i = this.f11488a.mo7083i();
                                str = this.f11488a.f11045aI;
                                mo7083i.setVin(str);
                            }
                            this.f11488a.m7668a(intent.getStringExtra("carName"), intent.getStringExtra("path"), intent.getStringExtra("language"), !DiagnoseConstants.driviceConnStatus);
                        }
                    } else {
                        DiagnoseUtils.m5081b(this.f11488a.f11019H);
                        try {
                            this.f11488a.m7660b(intent.getExtras());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
