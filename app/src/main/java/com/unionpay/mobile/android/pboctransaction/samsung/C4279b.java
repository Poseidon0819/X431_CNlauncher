package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.RemoteException;
import com.unionpay.client3.tsm.ITsmConnection;
import com.unionpay.client3.tsm.SeAppInfo;
import com.unionpay.mobile.android.model.C4172a;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.pboctransaction.C4263d;
import com.unionpay.mobile.android.pboctransaction.C4264e;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4262c;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.tsmservice.data.AppStatus;
import java.util.ArrayList;

/* renamed from: com.unionpay.mobile.android.pboctransaction.samsung.b */
/* loaded from: classes2.dex */
public final class C4279b implements InterfaceC4262c {

    /* renamed from: a */
    private Context f22772a;

    /* renamed from: b */
    private InterfaceC4261b f22773b;

    /* renamed from: c */
    private ITsmConnection f22774c;

    /* renamed from: d */
    private int f22775d = 0;

    /* renamed from: e */
    private Handler.Callback f22776e = new C4280c(this);

    /* renamed from: f */
    private Handler f22777f = new Handler(this.f22776e);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1269a(boolean z) {
        InterfaceC4261b interfaceC4261b = this.f22773b;
        if (interfaceC4261b != null) {
            if (z) {
                interfaceC4261b.mo1206a();
            } else {
                interfaceC4261b.mo1205b();
            }
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final String mo1236a(String str) {
        return "";
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final ArrayList<InterfaceC4174c> mo1238a(C4263d c4263d) {
        ITsmConnection iTsmConnection = this.f22774c;
        ArrayList<InterfaceC4174c> arrayList = null;
        if (iTsmConnection == null) {
            return null;
        }
        try {
            SeAppInfo[] seApps = iTsmConnection.getSeApps(this.f22775d);
            if (seApps == null || seApps.length <= 0) {
                return null;
            }
            ArrayList<InterfaceC4174c> arrayList2 = new ArrayList<>();
            for (int i = 0; i < seApps.length; i++) {
                try {
                    String appAid = seApps[i].getAppAid();
                    if (appAid != null && appAid.startsWith("A000000333")) {
                        String appAid2 = seApps[i].getAppAid();
                        if (!(appAid2 == null || appAid2.length() <= 16 || AppStatus.APPLY.equalsIgnoreCase(appAid2.substring(14, 16)))) {
                            arrayList2.add(new C4172a(1, seApps[i].getAppAid(), "", seApps[i].getPan(), 1));
                        }
                    }
                } catch (RemoteException e) {
                    e = e;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    return arrayList;
                } catch (Exception e2) {
                    e = e2;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (RemoteException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final void mo1241a() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final void mo1239a(InterfaceC4261b interfaceC4261b, Context context) {
        this.f22773b = interfaceC4261b;
        this.f22772a = context;
        try {
            Intent intent = new Intent();
            intent.setAction("com.unionpay.client3.action.TSM_MODEL");
            intent.setPackage("com.unionpay");
            context.startService(intent);
            if (context.bindService(intent, new ServiceConnectionC4281d(this), 1)) {
                this.f22777f.sendMessageDelayed(this.f22777f.obtainMessage(1), 3000L);
                return;
            }
            C4390k.m838a("plugin-clientV3", "startSamsungService() failed!!!");
            m1269a(false);
        } catch (Exception unused) {
            m1269a(false);
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final byte[] mo1234a(byte[] bArr, int i) {
        if (this.f22774c != null) {
            try {
                C4390k.m838a("plugin-clientV3", "--->" + C4264e.m1302a(bArr));
                String sendApdu = this.f22774c.sendApdu(this.f22775d, C4264e.m1302a(bArr), i);
                C4390k.m838a("plugin-clientV3", "<---".concat(String.valueOf(sendApdu)));
                return C4264e.m1305a(sendApdu);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: b */
    public final void mo1233b() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: c */
    public final void mo1230c() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: d */
    public final void mo1229d() {
    }
}
