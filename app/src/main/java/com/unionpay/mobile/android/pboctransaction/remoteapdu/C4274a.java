package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.unionpay.mobile.android.model.C4172a;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.C4263d;
import com.unionpay.mobile.android.pboctransaction.C4264e;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4262c;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.tsm.connect.IInitCallback;
import com.unionpay.mobile.tsm.connect.IRemoteApdu;
import com.unionpay.tsmservice.data.AppStatus;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.unionpay.mobile.android.pboctransaction.remoteapdu.a */
/* loaded from: classes2.dex */
public final class C4274a implements InterfaceC4262c {

    /* renamed from: a */
    InterfaceC4261b f22760a;

    /* renamed from: b */
    private IRemoteApdu f22761b = null;

    /* renamed from: c */
    private boolean f22762c = false;

    /* renamed from: d */
    private Context f22763d = null;

    /* renamed from: e */
    private Handler f22764e = null;

    /* renamed from: f */
    private boolean f22765f = false;

    /* renamed from: g */
    private final Handler.Callback f22766g = new C4275b(this);

    /* renamed from: h */
    private final ServiceConnection f22767h = new ServiceConnectionC4276c(this);

    /* renamed from: i */
    private final IInitCallback.Stub f22768i = new BinderC4277d(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ boolean m1276b(C4274a c4274a) {
        c4274a.f22765f = true;
        return true;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final String mo1236a(String str) {
        return "";
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final ArrayList<InterfaceC4174c> mo1238a(C4263d c4263d) {
        ArrayList<AppIdentification> arrayList;
        String m1299c;
        C4390k.m838a("plugin-tsm", "RemoteApduEngine.readList() +++");
        ArrayList<InterfaceC4174c> arrayList2 = null;
        try {
            String str = this.f22762c ? "D15600010100016111000000B0004101" : "D15600010100016111000000B0004001";
            C4390k.m838a("plugin-tsm", "sid=".concat(String.valueOf(str)));
            String writeApdu = this.f22761b.writeApdu("00a4040010".concat(String.valueOf(str)), 0);
            if (writeApdu != null && writeApdu.equalsIgnoreCase("9000")) {
                writeApdu = this.f22761b.writeApdu("80CA2F0000", 0);
            }
            arrayList = C4264e.m1300b(writeApdu);
        } catch (Exception e) {
            e.printStackTrace();
            C4390k.m836c("plugin-tsm", e.getMessage());
            arrayList = null;
        }
        if (arrayList != null && arrayList.size() > 0) {
            arrayList2 = new ArrayList<>();
            Iterator<AppIdentification> it = arrayList.iterator();
            while (it.hasNext()) {
                AppIdentification next = it.next();
                if (next.m1332c() && !AppStatus.APPLY.equalsIgnoreCase(next.m1334b()) && (m1299c = C4264e.m1299c(c4263d.m1328a(next))) != null && m1299c.length() > 0) {
                    arrayList2.add(new C4172a(4, next.m1336a(), "", m1299c, 1));
                }
            }
        }
        C4390k.m838a("plugin-tsm", "RemoteApduEngine.readList() ---");
        return arrayList2;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final void mo1241a() {
        mo1229d();
        Context context = this.f22763d;
        if (context != null) {
            C4390k.m838a("plugin-tsm", "unbindTSMService() ++");
            if (this.f22765f) {
                try {
                    context.unbindService(this.f22767h);
                } catch (Exception unused) {
                }
                this.f22765f = false;
            }
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final void mo1239a(InterfaceC4261b interfaceC4261b, Context context) {
        this.f22760a = interfaceC4261b;
        this.f22763d = context;
        this.f22764e = new Handler(this.f22766g);
        try {
            Intent intent = new Intent("com.unionpay.mobile.tsm.PBOCService");
            intent.setPackage("com.unionpay.mobile.tsm");
            context.startService(intent);
            if (this.f22764e != null) {
                this.f22764e.sendMessageDelayed(Message.obtain(this.f22764e, (int) SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY), 8000L);
            }
            if (context.bindService(intent, this.f22767h, 1) || this.f22760a == null) {
                return;
            }
            C4390k.m838a("plugin-tsm", "startTSMService.initFailed()");
            this.f22760a.mo1205b();
        } catch (Exception unused) {
            if (this.f22760a != null) {
                C4390k.m838a("plugin-tsm", "startTSMService exception");
                this.f22760a.mo1205b();
            }
        }
    }

    /* renamed from: a */
    public final void m1277a(boolean z) {
        this.f22762c = z;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final byte[] mo1234a(byte[] bArr, int i) {
        String str = null;
        if (bArr == null) {
            return null;
        }
        String m1302a = C4264e.m1302a(bArr);
        C4390k.m838a("plugin-tsm", "[---->]".concat(String.valueOf(m1302a)));
        try {
            str = this.f22761b.writeApdu(m1302a, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4390k.m838a("plugin-tsm", "[<----]".concat(String.valueOf(str)));
        return C4264e.m1305a(str);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: b */
    public final void mo1233b() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: c */
    public final void mo1230c() {
        mo1229d();
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: d */
    public final void mo1229d() {
        IRemoteApdu iRemoteApdu = this.f22761b;
        if (iRemoteApdu != null) {
            try {
                iRemoteApdu.closeChannel(0);
                this.f22761b.closeChannel(1);
                this.f22761b.closeChannel(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
