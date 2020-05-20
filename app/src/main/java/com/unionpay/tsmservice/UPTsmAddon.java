package com.unionpay.tsmservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.unionpay.tsmservice.ITsmActivityCallback;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.ITsmService;
import com.unionpay.tsmservice.data.Amount;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.request.AcquireSEAppListRequestParams;
import com.unionpay.tsmservice.request.ActivateVendorPayRequestParams;
import com.unionpay.tsmservice.request.AddCardToVendorPayRequestParams;
import com.unionpay.tsmservice.request.AppDataUpdateRequestParams;
import com.unionpay.tsmservice.request.AppDeleteRequestParams;
import com.unionpay.tsmservice.request.AppDownloadApplyRequestParams;
import com.unionpay.tsmservice.request.AppDownloadRequestParams;
import com.unionpay.tsmservice.request.AppLockRequestParams;
import com.unionpay.tsmservice.request.AppUnlockRequestParams;
import com.unionpay.tsmservice.request.CardListStatusChangedRequestParams;
import com.unionpay.tsmservice.request.CheckSSamsungPayRequestParams;
import com.unionpay.tsmservice.request.CloseChannelRequestParams;
import com.unionpay.tsmservice.request.ECashTopUpRequestParams;
import com.unionpay.tsmservice.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.request.ExecuteCmdRequestParams;
import com.unionpay.tsmservice.request.GetAccountBalanceRequestParams;
import com.unionpay.tsmservice.request.GetAccountInfoRequestParams;
import com.unionpay.tsmservice.request.GetAppDetailRequestParams;
import com.unionpay.tsmservice.request.GetAppListRequestParams;
import com.unionpay.tsmservice.request.GetAppStatusRequestParams;
import com.unionpay.tsmservice.request.GetAssociatedAppRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoBySpayRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoRequestParams;
import com.unionpay.tsmservice.request.GetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.request.GetMessageDetailsRequestParams;
import com.unionpay.tsmservice.request.GetSMSAuthCodeRequestParams;
import com.unionpay.tsmservice.request.GetSeAppListRequestParams;
import com.unionpay.tsmservice.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.request.GetTransElementsRequestParams;
import com.unionpay.tsmservice.request.GetTransRecordRequestParams;
import com.unionpay.tsmservice.request.GetTransactionDetailsRequestParams;
import com.unionpay.tsmservice.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.HideAppApplyRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.PreDownloadRequestParams;
import com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.RequestParams;
import com.unionpay.tsmservice.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import com.unionpay.tsmservice.request.SendCustomDataRequestParams;
import com.unionpay.tsmservice.request.SetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.SetSamsungDefWalletRequestParams;
import com.unionpay.tsmservice.request.UniteRequestParams;
import com.unionpay.tsmservice.utils.IUPJniInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UPTsmAddon {

    /* renamed from: a */
    private static UPTsmAddon f23537a;

    /* renamed from: b */
    private static CopyOnWriteArrayList<UPTsmConnectionListener> f23538b;

    /* renamed from: c */
    private Context f23567c;

    /* renamed from: d */
    private ServiceConnection f23568d = null;

    /* renamed from: e */
    private ITsmService f23569e = null;

    /* renamed from: f */
    private boolean f23570f = false;

    /* renamed from: g */
    private int f23571g = 1;

    /* renamed from: h */
    private boolean f23572h = false;

    /* renamed from: i */
    private HashMap<String, ITsmCallback> f23573i = new HashMap<>();

    /* renamed from: j */
    private HashMap<String, ITsmCallback> f23574j = new HashMap<>();

    /* renamed from: k */
    private HashMap<String, ITsmCallback> f23575k = new HashMap<>();

    /* renamed from: l */
    private HashMap<String, ITsmCallback> f23576l = new HashMap<>();

    /* renamed from: m */
    private HashMap<String, ITsmCallback> f23577m = new HashMap<>();

    /* renamed from: n */
    private HashMap<String, ITsmCallback> f23578n = new HashMap<>();

    /* renamed from: o */
    private HashMap<String, ITsmCallback> f23579o = new HashMap<>();

    /* renamed from: p */
    private HashMap<String, ITsmCallback> f23580p = new HashMap<>();

    /* renamed from: q */
    private HashMap<String, ITsmCallback> f23581q = new HashMap<>();

    /* renamed from: r */
    private HashMap<String, ITsmCallback> f23582r = new HashMap<>();

    /* renamed from: s */
    private HashMap<String, ITsmCallback> f23583s = new HashMap<>();

    /* renamed from: t */
    private HashMap<String, ITsmCallback> f23584t = new HashMap<>();

    /* renamed from: u */
    private HashMap<String, ITsmCallback> f23585u = new HashMap<>();

    /* renamed from: v */
    private HashMap<String, ITsmCallback> f23586v = new HashMap<>();

    /* renamed from: w */
    private HashMap<String, ITsmCallback> f23587w = new HashMap<>();

    /* renamed from: x */
    private HashMap<String, ITsmCallback> f23588x = new HashMap<>();

    /* renamed from: y */
    private HashMap<String, ITsmCallback> f23589y = new HashMap<>();

    /* renamed from: z */
    private HashMap<String, ITsmCallback> f23590z = new HashMap<>();

    /* renamed from: A */
    private HashMap<String, ITsmCallback> f23539A = new HashMap<>();

    /* renamed from: B */
    private HashMap<String, ITsmCallback> f23540B = new HashMap<>();

    /* renamed from: C */
    private HashMap<String, ITsmCallback> f23541C = new HashMap<>();

    /* renamed from: D */
    private HashMap<String, ITsmCallback> f23542D = new HashMap<>();

    /* renamed from: E */
    private HashMap<String, ITsmCallback> f23543E = new HashMap<>();

    /* renamed from: F */
    private HashMap<String, ITsmCallback> f23544F = new HashMap<>();

    /* renamed from: G */
    private HashMap<String, ITsmCallback> f23545G = new HashMap<>();

    /* renamed from: H */
    private HashMap<String, ITsmCallback> f23546H = new HashMap<>();

    /* renamed from: I */
    private HashMap<String, ITsmCallback> f23547I = new HashMap<>();

    /* renamed from: J */
    private HashMap<String, ITsmCallback> f23548J = new HashMap<>();

    /* renamed from: K */
    private HashMap<String, ITsmCallback> f23549K = new HashMap<>();

    /* renamed from: L */
    private HashMap<String, ITsmCallback> f23550L = new HashMap<>();

    /* renamed from: M */
    private HashMap<String, ITsmCallback> f23551M = new HashMap<>();

    /* renamed from: N */
    private HashMap<String, ITsmCallback> f23552N = new HashMap<>();

    /* renamed from: O */
    private HashMap<String, ITsmCallback> f23553O = new HashMap<>();

    /* renamed from: P */
    private HashMap<String, ITsmCallback> f23554P = new HashMap<>();

    /* renamed from: Q */
    private HashMap<String, ITsmCallback> f23555Q = new HashMap<>();

    /* renamed from: R */
    private HashMap<String, ITsmCallback> f23556R = new HashMap<>();

    /* renamed from: S */
    private HashMap<String, ITsmCallback> f23557S = new HashMap<>();

    /* renamed from: T */
    private HashMap<String, ITsmCallback> f23558T = new HashMap<>();

    /* renamed from: U */
    private HashMap<String, ITsmCallback> f23559U = new HashMap<>();

    /* renamed from: V */
    private HashMap<String, ITsmCallback> f23560V = new HashMap<>();

    /* renamed from: W */
    private HashMap<String, ITsmCallback> f23561W = new HashMap<>();

    /* renamed from: X */
    private HashMap<String, ITsmCallback> f23562X = new HashMap<>();

    /* renamed from: Y */
    private HashMap<String, ITsmActivityCallback> f23563Y = new HashMap<>();

    /* renamed from: aa */
    private final Handler.Callback f23565aa = new Handler.Callback() { // from class: com.unionpay.tsmservice.UPTsmAddon.1
        @Override // android.os.Handler.Callback
        public final synchronized boolean handleMessage(Message message2) {
            switch (message2.what) {
                case 0:
                    UPTsmAddon.this.m578a();
                    return true;
                case 1:
                    UPTsmAddon.this.m563b();
                    return true;
                default:
                    return false;
            }
        }
    };

    /* renamed from: ab */
    private final Handler f23566ab = new Handler(Looper.getMainLooper(), this.f23565aa);

    /* renamed from: Z */
    private int[] f23564Z = new int[47];

    /* loaded from: classes2.dex */
    public interface UPTsmConnectionListener {
        void onTsmConnected();

        void onTsmDisconnected();
    }

    /* renamed from: com.unionpay.tsmservice.UPTsmAddon$a */
    /* loaded from: classes2.dex */
    public class BinderC4502a extends ITsmActivityCallback.Stub {

        /* renamed from: b */
        private int f23594b = 1000;

        public BinderC4502a() {
        }

        @Override // com.unionpay.tsmservice.ITsmActivityCallback
        public final void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
            UPTsmAddon.m572a((ITsmActivityCallback) UPTsmAddon.m561b(UPTsmAddon.this, this.f23594b).get(UPTsmAddon.m554e(UPTsmAddon.this)), str, str2, i, bundle);
            UPTsmAddon.m561b(UPTsmAddon.this, this.f23594b).remove(UPTsmAddon.m554e(UPTsmAddon.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.unionpay.tsmservice.UPTsmAddon$b */
    /* loaded from: classes2.dex */
    public class BinderC4503b extends ITsmCallback.Stub {

        /* renamed from: b */
        private int f23596b;

        /* renamed from: c */
        private int f23597c;

        private BinderC4503b(int i, int i2) {
            this.f23596b = i;
            this.f23597c = i2;
        }

        /* synthetic */ BinderC4503b(UPTsmAddon uPTsmAddon, int i, int i2, byte b) {
            this(i, i2);
        }

        @Override // com.unionpay.tsmservice.ITsmCallback
        public final void onError(String str, String str2) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("errorCode", str);
            bundle.putString("errorDesc", str2);
            UPTsmAddon.m571a((ITsmCallback) UPTsmAddon.m569a(UPTsmAddon.this, this.f23596b).get(String.valueOf(this.f23597c)), bundle);
            UPTsmAddon.m569a(UPTsmAddon.this, this.f23596b).remove(String.valueOf(this.f23597c));
            if (UPTsmAddon.m569a(UPTsmAddon.this, this.f23596b).isEmpty()) {
                UPTsmAddon.this.f23564Z[this.f23596b] = 0;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x0193  */
        /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
        @Override // com.unionpay.tsmservice.ITsmCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onResult(android.os.Bundle r7) throws android.os.RemoteException {
            /*
                Method dump skipped, instructions count: 454
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unionpay.tsmservice.UPTsmAddon.BinderC4503b.onResult(android.os.Bundle):void");
        }
    }

    static {
        try {
            System.loadLibrary("uptsmaddon");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        f23537a = null;
        f23538b = null;
    }

    private UPTsmAddon(Context context) {
        this.f23567c = null;
        this.f23567c = context;
        if (!m574a(context)) {
            throw new RuntimeException();
        }
    }

    /* renamed from: a */
    private static int m577a(int i, RequestParams requestParams, ITsmCallback iTsmCallback) throws RemoteException {
        return new SessionKeyReExchange(f23537a, i, requestParams, iTsmCallback).reExchangeKey();
    }

    /* renamed from: a */
    private static int m576a(int i, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
        return new SessionKeyReExchange(f23537a, i, requestParams, iTsmCallback, iTsmProgressCallback).reExchangeKey();
    }

    /* renamed from: a */
    private static int m575a(int i, SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i2, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) throws RemoteException {
        return new SessionKeyReExchange(f23537a, i, safetyKeyboardRequestParams, i2, onSafetyKeyboardCallback, context).reExchangeKey();
    }

    /* renamed from: a */
    private String m573a(Bundle bundle) {
        String str = "";
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        if (marshall != null && marshall.length != 0) {
            str = m560b(Base64.encodeToString(marshall, 0));
        }
        obtain.recycle();
        return str;
    }

    /* renamed from: a */
    static /* synthetic */ HashMap m569a(UPTsmAddon uPTsmAddon, int i) {
        switch (i) {
            case 0:
                return uPTsmAddon.f23573i;
            case 1:
                return uPTsmAddon.f23574j;
            case 2:
                return uPTsmAddon.f23576l;
            case 3:
                return uPTsmAddon.f23575k;
            case 4:
                return uPTsmAddon.f23578n;
            case 5:
                return uPTsmAddon.f23577m;
            case 6:
                return uPTsmAddon.f23539A;
            case 7:
                return uPTsmAddon.f23585u;
            case 8:
                return uPTsmAddon.f23586v;
            case 9:
                return uPTsmAddon.f23579o;
            case 10:
                return uPTsmAddon.f23584t;
            case 11:
                return uPTsmAddon.f23582r;
            case 12:
                return uPTsmAddon.f23590z;
            case 13:
                return uPTsmAddon.f23589y;
            case 14:
                return uPTsmAddon.f23543E;
            case 15:
                return uPTsmAddon.f23580p;
            case 16:
                return uPTsmAddon.f23541C;
            case 17:
                return uPTsmAddon.f23542D;
            case 18:
                return uPTsmAddon.f23581q;
            case 19:
                return uPTsmAddon.f23583s;
            case 20:
                return uPTsmAddon.f23587w;
            case 21:
                return uPTsmAddon.f23544F;
            case 22:
                return uPTsmAddon.f23588x;
            case 23:
                return uPTsmAddon.f23540B;
            case 24:
                return uPTsmAddon.f23545G;
            case 25:
                return uPTsmAddon.f23546H;
            case 26:
            case 27:
            case 32:
            case 33:
            case 34:
            default:
                return null;
            case 28:
                return uPTsmAddon.f23547I;
            case 29:
                return uPTsmAddon.f23548J;
            case 30:
                return uPTsmAddon.f23549K;
            case 31:
                return uPTsmAddon.f23550L;
            case 35:
                return uPTsmAddon.f23551M;
            case 36:
                return uPTsmAddon.f23552N;
            case 37:
                return uPTsmAddon.f23553O;
            case 38:
                return uPTsmAddon.f23554P;
            case 39:
                return uPTsmAddon.f23555Q;
            case 40:
                return uPTsmAddon.f23556R;
            case 41:
                return uPTsmAddon.f23557S;
            case 42:
                return uPTsmAddon.f23558T;
            case 43:
                return uPTsmAddon.f23559U;
            case 44:
                return uPTsmAddon.f23560V;
            case 45:
                return uPTsmAddon.f23561W;
            case 46:
                return uPTsmAddon.f23562X;
        }
    }

    /* renamed from: a */
    private static HashMap<String, String> m564a(HashMap<String, String> hashMap) {
        String str;
        if (hashMap == null) {
            return new HashMap<>();
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        for (String str2 : hashMap.keySet()) {
            if (str2 != null && (str = hashMap.get(str2)) != null) {
                hashMap2.put(new String(str2), new String(str));
            }
        }
        return hashMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m578a() {
        if (f23538b != null && f23538b.size() > 0) {
            Iterator<UPTsmConnectionListener> it = f23538b.iterator();
            while (it.hasNext()) {
                UPTsmConnectionListener next = it.next();
                if (next != null) {
                    next.onTsmConnected();
                }
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m572a(ITsmActivityCallback iTsmActivityCallback, String str, String str2, int i, Bundle bundle) {
        if (iTsmActivityCallback != null) {
            try {
                iTsmActivityCallback.startActivity(str, str2, i, bundle);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m571a(ITsmCallback iTsmCallback, Bundle bundle) {
        if (iTsmCallback != null) {
            try {
                String string = bundle.getString("errorCode");
                if ("10000".equals(string)) {
                    iTsmCallback.onResult(bundle);
                } else {
                    iTsmCallback.onError(string, bundle.getString("errorDesc"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static boolean m574a(Context context) {
        try {
            return IUPJniInterface.iJE(context);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m565a(String str) {
        try {
            return IUPJniInterface.cSKV(str);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private String m560b(String str) {
        try {
            return IUPJniInterface.eMG(str, this.f23571g);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    static /* synthetic */ HashMap m561b(UPTsmAddon uPTsmAddon, int i) {
        if (i != 1000) {
            return null;
        }
        return uPTsmAddon.f23563Y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m563b() {
        if (f23538b != null && f23538b.size() > 0) {
            Iterator<UPTsmConnectionListener> it = f23538b.iterator();
            while (it.hasNext()) {
                UPTsmConnectionListener next = it.next();
                if (next != null) {
                    next.onTsmDisconnected();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public String m557c(String str) {
        try {
            return IUPJniInterface.dMG(str, this.f23571g);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: c */
    private boolean m559c() {
        String m553e = m553e("com.unionpay.tsmservice");
        if (m553e == null || m553e.compareTo(Constant.SUPPORTED_MIN_APK_VERSION) < 0) {
            return false;
        }
        if (m553e.compareTo(Constant.APK_VERSION_010018) >= 0) {
            this.f23571g = 1;
            this.f23572h = true;
            return true;
        } else if (m553e.compareTo(Constant.APK_VERSION_010012) >= 0 && m553e.compareTo(Constant.APK_VERSION_010016) <= 0) {
            this.f23571g = 2;
            this.f23572h = false;
            return true;
        } else if (m553e.compareTo(Constant.APK_VERSION_010017) == 0 || m553e.compareTo(Constant.SUPPORTED_MIN_APK_VERSION) == 0) {
            this.f23571g = 1;
            this.f23572h = false;
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: d */
    private boolean m555d(String str) {
        String m553e = m553e("com.unionpay.tsmservice");
        return m553e != null && m553e.compareTo(str) >= 0;
    }

    /* renamed from: e */
    static /* synthetic */ String m554e(UPTsmAddon uPTsmAddon) {
        return uPTsmAddon.f23567c.getPackageName();
    }

    /* renamed from: e */
    private String m553e(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = this.f23567c.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    /* renamed from: f */
    private static String m552f(String str) {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("jarVersionCode", 41);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: g */
    private String m551g(String str) {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("packageName", this.f23567c.getPackageName());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static synchronized UPTsmAddon getInstance(Context context) {
        synchronized (UPTsmAddon.class) {
            if (context == null) {
                return null;
            }
            if (f23537a == null) {
                f23537a = new UPTsmAddon(context.getApplicationContext());
            }
            if (f23538b == null) {
                f23538b = new CopyOnWriteArrayList<>();
            }
            return f23537a;
        }
    }

    public synchronized int acquireSEAppList(AcquireSEAppListRequestParams acquireSEAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m555d("01.00.28")) {
            return -8;
        } else {
            if (!m559c()) {
                return -8;
            }
            if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(42, acquireSEAppListRequestParams, iTsmCallback);
                }
                AcquireSEAppListRequestParams acquireSEAppListRequestParams2 = new AcquireSEAppListRequestParams();
                String str = "";
                if (acquireSEAppListRequestParams != null) {
                    str = acquireSEAppListRequestParams.getReserve();
                    Bundle params = acquireSEAppListRequestParams.getParams();
                    if (params != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("encryptData", m573a(params));
                        acquireSEAppListRequestParams2.setParams(bundle);
                    }
                }
                if (this.f23572h) {
                    str = m551g(m552f(str));
                }
                if (!TextUtils.isEmpty(str)) {
                    acquireSEAppListRequestParams2.setReserve(m560b(str));
                }
                this.f23558T.put(String.valueOf(this.f23564Z[42]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[42];
                    iArr[42] = i2 + 1;
                    int acquireSEAppList = iTsmService.acquireSEAppList(acquireSEAppListRequestParams2, new BinderC4503b(this, 42, i2, (byte) 0));
                    if (acquireSEAppList != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23558T;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[42] - 1;
                        iArr2[42] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == acquireSEAppList) {
                        return m577a(42, acquireSEAppListRequestParams, iTsmCallback);
                    }
                    return acquireSEAppList;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized int activateVendorPay(ActivateVendorPayRequestParams activateVendorPayRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m555d("01.00.20")) {
            return -8;
        } else {
            if (!m559c()) {
                return -8;
            }
            if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(37, activateVendorPayRequestParams, iTsmCallback);
                }
                ActivateVendorPayRequestParams activateVendorPayRequestParams2 = new ActivateVendorPayRequestParams();
                String reserve = activateVendorPayRequestParams != null ? activateVendorPayRequestParams.getReserve() : "";
                if (this.f23572h) {
                    reserve = m551g(m552f(reserve));
                }
                if (!TextUtils.isEmpty(reserve)) {
                    activateVendorPayRequestParams2.setReserve(m560b(reserve));
                }
                this.f23553O.put(String.valueOf(this.f23564Z[37]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[37];
                    iArr[37] = i2 + 1;
                    int activateVendorPay = iTsmService.activateVendorPay(activateVendorPayRequestParams2, new BinderC4503b(this, 37, i2, (byte) 0));
                    if (activateVendorPay != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23553O;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[37] - 1;
                        iArr2[37] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == activateVendorPay) {
                        return m577a(37, activateVendorPayRequestParams, iTsmCallback);
                    }
                    return activateVendorPay;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized int addCardToVendorPay(AddCardToVendorPayRequestParams addCardToVendorPayRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
        int i;
        if (addCardToVendorPayRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m555d("01.00.20")) {
            return -8;
        } else {
            if (!m559c()) {
                return -8;
            }
            if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(38, addCardToVendorPayRequestParams, iTsmCallback);
                }
                AddCardToVendorPayRequestParams addCardToVendorPayRequestParams2 = new AddCardToVendorPayRequestParams();
                Bundle params = addCardToVendorPayRequestParams.getParams();
                if (params != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("encryptData", m573a(params));
                    addCardToVendorPayRequestParams2.setParams(bundle);
                }
                String reserve = addCardToVendorPayRequestParams.getReserve();
                if (this.f23572h) {
                    reserve = m551g(m552f(reserve));
                }
                if (!TextUtils.isEmpty(reserve)) {
                    addCardToVendorPayRequestParams2.setReserve(m560b(reserve));
                }
                this.f23554P.put(String.valueOf(this.f23564Z[38]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[38];
                    iArr[38] = i2 + 1;
                    int addCardToVendorPay = iTsmService.addCardToVendorPay(addCardToVendorPayRequestParams2, new BinderC4503b(this, 38, i2, (byte) 0), iTsmProgressCallback);
                    if (addCardToVendorPay != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23554P;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[38] - 1;
                        iArr2[38] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == addCardToVendorPay) {
                        return m576a(38, addCardToVendorPayRequestParams, iTsmCallback, iTsmProgressCallback);
                    }
                    return addCardToVendorPay;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized void addConnectionListener(UPTsmConnectionListener uPTsmConnectionListener) {
        if (uPTsmConnectionListener != null) {
            f23538b.add(uPTsmConnectionListener);
        }
    }

    public synchronized int appDataUpdate(AppDataUpdateRequestParams appDataUpdateRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
        int i;
        if (appDataUpdateRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m576a(18, appDataUpdateRequestParams, iTsmCallback, iTsmProgressCallback);
            }
            AppDataUpdateRequestParams appDataUpdateRequestParams2 = new AppDataUpdateRequestParams();
            String reserve = appDataUpdateRequestParams.getReserve();
            AppID appID = appDataUpdateRequestParams.getAppID();
            if (!TextUtils.isEmpty(reserve)) {
                appDataUpdateRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    appDataUpdateRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            try {
                int appDataUpdate = this.f23569e.appDataUpdate(appDataUpdateRequestParams2, new BinderC4503b(this, 18, this.f23564Z[18], (byte) 0), iTsmProgressCallback);
                if (-2 == appDataUpdate) {
                    return m576a(18, appDataUpdateRequestParams, iTsmCallback, iTsmProgressCallback);
                }
                if (appDataUpdate == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23581q;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[18];
                    iArr[18] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return appDataUpdate;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int appDelete(AppDeleteRequestParams appDeleteRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
        int i;
        if (appDeleteRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m576a(17, appDeleteRequestParams, iTsmCallback, iTsmProgressCallback);
            }
            AppDeleteRequestParams appDeleteRequestParams2 = new AppDeleteRequestParams();
            String reserve = appDeleteRequestParams.getReserve();
            AppID appID = appDeleteRequestParams.getAppID();
            if (!TextUtils.isEmpty(reserve)) {
                appDeleteRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    appDeleteRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            HashMap hashMap = (HashMap) appDeleteRequestParams.getParams();
            if (hashMap == null) {
                try {
                    int appDelete = this.f23569e.appDelete(appDeleteRequestParams2, new BinderC4503b(this, 17, this.f23564Z[17], (byte) 0), iTsmProgressCallback);
                    if (-2 == appDelete) {
                        return m576a(17, appDeleteRequestParams, iTsmCallback, iTsmProgressCallback);
                    }
                    if (appDelete == 0) {
                        HashMap<String, ITsmCallback> hashMap2 = this.f23542D;
                        int[] iArr = this.f23564Z;
                        int i2 = iArr[17];
                        iArr[17] = i2 + 1;
                        hashMap2.put(String.valueOf(i2), iTsmCallback);
                    }
                    return appDelete;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            HashMap<String, String> m564a = m564a(hashMap);
            String str = m564a.get(Constant.KEY_CARD_HOLDER_NAME);
            String str2 = m564a.get(Constant.KEY_ID_TYPE);
            String str3 = m564a.get(Constant.KEY_ID_NO);
            String str4 = m564a.get(Constant.KEY_PAN);
            String str5 = m564a.get(Constant.KEY_PIN);
            String str6 = m564a.get(Constant.KEY_EXPIRY_DATE);
            String str7 = m564a.get(Constant.KEY_CVN2);
            String str8 = m564a.get(Constant.KEY_PHONE_NUMBER);
            String str9 = m564a.get(Constant.KEY_SMS_AUTH_CODE);
            String str10 = m564a.get(Constant.KEY_BALANCE);
            String str11 = m564a.get("cardType");
            if (!TextUtils.isEmpty(str)) {
                m564a.put(Constant.KEY_CARD_HOLDER_NAME, m560b(str));
            }
            if (!TextUtils.isEmpty(str2)) {
                m564a.put(Constant.KEY_ID_TYPE, m560b(str2));
            }
            if (!TextUtils.isEmpty(str3)) {
                m564a.put(Constant.KEY_ID_NO, m560b(str3));
            }
            if (!TextUtils.isEmpty(str4)) {
                m564a.put(Constant.KEY_PAN, m560b(str4));
            }
            if (!TextUtils.isEmpty(str5)) {
                m564a.put(Constant.KEY_PIN, str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                m564a.put(Constant.KEY_EXPIRY_DATE, m560b(str6));
            }
            if (!TextUtils.isEmpty(str7)) {
                m564a.put(Constant.KEY_CVN2, m560b(str7));
            }
            if (!TextUtils.isEmpty(str8)) {
                m564a.put(Constant.KEY_PHONE_NUMBER, m560b(str8));
            }
            if (!TextUtils.isEmpty(str9)) {
                m564a.put(Constant.KEY_SMS_AUTH_CODE, m560b(str9));
            }
            if (!TextUtils.isEmpty(str10)) {
                m564a.put(Constant.KEY_BALANCE, m560b(str10));
            }
            if (!TextUtils.isEmpty(str11)) {
                m564a.put("cardType", m560b(str11));
            }
            appDeleteRequestParams2.setParams(m564a);
            try {
                int appDelete2 = this.f23569e.appDelete(appDeleteRequestParams2, new BinderC4503b(this, 17, this.f23564Z[17], (byte) 0), iTsmProgressCallback);
                if (-2 == appDelete2) {
                    return m576a(17, appDeleteRequestParams, iTsmCallback, iTsmProgressCallback);
                }
                if (appDelete2 == 0) {
                    HashMap<String, ITsmCallback> hashMap3 = this.f23542D;
                    int[] iArr2 = this.f23564Z;
                    int i3 = iArr2[17];
                    iArr2[17] = i3 + 1;
                    hashMap3.put(String.valueOf(i3), iTsmCallback);
                }
                return appDelete2;
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int appDownload(AppDownloadRequestParams appDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
        int i;
        if (appDownloadRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m576a(16, appDownloadRequestParams, iTsmCallback, iTsmProgressCallback);
            }
            AppDownloadRequestParams appDownloadRequestParams2 = new AppDownloadRequestParams();
            String reserve = appDownloadRequestParams.getReserve();
            AppID appID = appDownloadRequestParams.getAppID();
            String appName = appDownloadRequestParams.getAppName();
            if (!TextUtils.isEmpty(reserve)) {
                appDownloadRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    appDownloadRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            if (!TextUtils.isEmpty(appName)) {
                appDownloadRequestParams2.setAppName(m560b(appName));
            }
            try {
                int appDownload = this.f23569e.appDownload(appDownloadRequestParams2, new BinderC4503b(this, 16, this.f23564Z[16], (byte) 0), iTsmProgressCallback);
                if (-2 == appDownload) {
                    return m576a(16, appDownloadRequestParams, iTsmCallback, iTsmProgressCallback);
                }
                if (appDownload == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23541C;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[16];
                    iArr[16] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return appDownload;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int appDownloadApply(AppDownloadApplyRequestParams appDownloadApplyRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (appDownloadApplyRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(15, appDownloadApplyRequestParams, iTsmCallback);
            }
            AppDownloadApplyRequestParams appDownloadApplyRequestParams2 = new AppDownloadApplyRequestParams();
            String reserve = appDownloadApplyRequestParams.getReserve();
            AppID appID = appDownloadApplyRequestParams.getAppID();
            if (!TextUtils.isEmpty(reserve)) {
                appDownloadApplyRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    appDownloadApplyRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            HashMap hashMap = (HashMap) appDownloadApplyRequestParams.getParams();
            if (hashMap == null) {
                try {
                    int appDownloadApply = this.f23569e.appDownloadApply(appDownloadApplyRequestParams2, new BinderC4503b(this, 15, this.f23564Z[15], (byte) 0));
                    if (-2 == appDownloadApply) {
                        return m577a(15, appDownloadApplyRequestParams, iTsmCallback);
                    }
                    if (appDownloadApply == 0) {
                        HashMap<String, ITsmCallback> hashMap2 = this.f23580p;
                        int[] iArr = this.f23564Z;
                        int i2 = iArr[15];
                        iArr[15] = i2 + 1;
                        hashMap2.put(String.valueOf(i2), iTsmCallback);
                    }
                    return appDownloadApply;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            HashMap<String, String> m564a = m564a(hashMap);
            String str = m564a.get(Constant.KEY_ACCOUNT_LIMIT);
            String str2 = m564a.get(Constant.KEY_ACCOUNT_TYPE);
            String str3 = m564a.get(Constant.KEY_CARD_HOLDER_NAME);
            String str4 = m564a.get(Constant.KEY_ID_TYPE);
            String str5 = m564a.get(Constant.KEY_ID_NO);
            String str6 = m564a.get(Constant.KEY_PAN);
            String str7 = m564a.get(Constant.KEY_PIN);
            String str8 = m564a.get(Constant.KEY_EXPIRY_DATE);
            String str9 = m564a.get(Constant.KEY_CVN2);
            String str10 = m564a.get(Constant.KEY_PHONE_NUMBER);
            String str11 = m564a.get(Constant.KEY_SMS_AUTH_CODE);
            String str12 = m564a.get("cardType");
            if (!TextUtils.isEmpty(str)) {
                m564a.put(Constant.KEY_ACCOUNT_LIMIT, m560b(str));
            }
            if (!TextUtils.isEmpty(str2)) {
                m564a.put(Constant.KEY_ACCOUNT_TYPE, m560b(str2));
            }
            if (!TextUtils.isEmpty(str3)) {
                m564a.put(Constant.KEY_CARD_HOLDER_NAME, m560b(str3));
            }
            if (!TextUtils.isEmpty(str4)) {
                m564a.put(Constant.KEY_ID_TYPE, m560b(str4));
            }
            if (!TextUtils.isEmpty(str5)) {
                m564a.put(Constant.KEY_ID_NO, m560b(str5));
            }
            if (!TextUtils.isEmpty(str6)) {
                m564a.put(Constant.KEY_PAN, m560b(str6));
            }
            if (!TextUtils.isEmpty(str7)) {
                m564a.put(Constant.KEY_PIN, str7);
            }
            if (!TextUtils.isEmpty(str8)) {
                m564a.put(Constant.KEY_EXPIRY_DATE, m560b(str8));
            }
            if (!TextUtils.isEmpty(str9)) {
                m564a.put(Constant.KEY_CVN2, m560b(str9));
            }
            if (!TextUtils.isEmpty(str10)) {
                m564a.put(Constant.KEY_PHONE_NUMBER, m560b(str10));
            }
            if (!TextUtils.isEmpty(str11)) {
                m564a.put(Constant.KEY_SMS_AUTH_CODE, m560b(str11));
            }
            if (!TextUtils.isEmpty(str12)) {
                m564a.put("cardType", m560b(str12));
            }
            appDownloadApplyRequestParams2.setParams(m564a);
            try {
                int appDownloadApply2 = this.f23569e.appDownloadApply(appDownloadApplyRequestParams2, new BinderC4503b(this, 15, this.f23564Z[15], (byte) 0));
                if (-2 == appDownloadApply2) {
                    return m577a(15, appDownloadApplyRequestParams, iTsmCallback);
                }
                if (appDownloadApply2 == 0) {
                    HashMap<String, ITsmCallback> hashMap3 = this.f23580p;
                    int[] iArr2 = this.f23564Z;
                    int i3 = iArr2[15];
                    iArr2[15] = i3 + 1;
                    hashMap3.put(String.valueOf(i3), iTsmCallback);
                }
                return appDownloadApply2;
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int appLock(AppLockRequestParams appLockRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (appLockRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(26, appLockRequestParams, iTsmCallback);
            }
            AppLockRequestParams appLockRequestParams2 = new AppLockRequestParams();
            String reserve = appLockRequestParams.getReserve();
            AppID appID = appLockRequestParams.getAppID();
            if (!TextUtils.isEmpty(reserve)) {
                appLockRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    appLockRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            try {
                int appLock = this.f23569e.appLock(appLockRequestParams2, iTsmCallback);
                if (-2 == appLock) {
                    return m577a(26, appLockRequestParams, iTsmCallback);
                }
                return appLock;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int appUnlock(AppUnlockRequestParams appUnlockRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (appUnlockRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(27, appUnlockRequestParams, iTsmCallback);
            }
            AppUnlockRequestParams appUnlockRequestParams2 = new AppUnlockRequestParams();
            String reserve = appUnlockRequestParams.getReserve();
            AppID appID = appUnlockRequestParams.getAppID();
            if (!TextUtils.isEmpty(reserve)) {
                appUnlockRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    appUnlockRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            try {
                int appUnlock = this.f23569e.appUnlock(appUnlockRequestParams2, iTsmCallback);
                if (-2 == appUnlock) {
                    return m577a(27, appUnlockRequestParams, iTsmCallback);
                }
                return appUnlock;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public boolean bind() {
        if (this.f23568d == null) {
            this.f23568d = new ServiceConnection() { // from class: com.unionpay.tsmservice.UPTsmAddon.2
                @Override // android.content.ServiceConnection
                public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    UPTsmAddon.this.f23570f = true;
                    UPTsmAddon.this.f23569e = ITsmService.Stub.asInterface(iBinder);
                    UPTsmAddon.this.f23566ab.sendEmptyMessage(0);
                }

                @Override // android.content.ServiceConnection
                public final synchronized void onServiceDisconnected(ComponentName componentName) {
                    UPTsmAddon.this.f23570f = false;
                    UPTsmAddon.this.f23569e = null;
                    UPTsmAddon.this.f23566ab.sendEmptyMessage(1);
                }
            };
        }
        if (this.f23570f) {
            return true;
        }
        Intent intent = new Intent("com.unionpay.tsmservice.UPTsmService");
        intent.setPackage("com.unionpay.tsmservice");
        this.f23567c.startService(intent);
        return this.f23567c.bindService(intent, this.f23568d, 1);
    }

    public synchronized int cardListStatusChanged(CardListStatusChangedRequestParams cardListStatusChangedRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m555d("01.00.14")) {
            return -8;
        } else {
            if (!m559c()) {
                return -8;
            }
            if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(35, cardListStatusChangedRequestParams, iTsmCallback);
                }
                CardListStatusChangedRequestParams cardListStatusChangedRequestParams2 = new CardListStatusChangedRequestParams();
                String reserve = cardListStatusChangedRequestParams != null ? cardListStatusChangedRequestParams.getReserve() : "";
                if (this.f23572h) {
                    reserve = m551g(m552f(reserve));
                }
                if (!TextUtils.isEmpty(reserve)) {
                    cardListStatusChangedRequestParams2.setReserve(m560b(reserve));
                }
                this.f23551M.put(String.valueOf(this.f23564Z[35]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[35];
                    iArr[35] = i2 + 1;
                    int cardListStatusChanged = iTsmService.cardListStatusChanged(cardListStatusChangedRequestParams2, new BinderC4503b(this, 35, i2, (byte) 0));
                    if (cardListStatusChanged != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23551M;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[35] - 1;
                        iArr2[35] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == cardListStatusChanged) {
                        return m577a(35, cardListStatusChangedRequestParams, iTsmCallback);
                    }
                    return cardListStatusChanged;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized int checkSSamsungPay(CheckSSamsungPayRequestParams checkSSamsungPayRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (checkSSamsungPayRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(29, checkSSamsungPayRequestParams, iTsmCallback);
            }
            CheckSSamsungPayRequestParams checkSSamsungPayRequestParams2 = new CheckSSamsungPayRequestParams();
            String reserve = checkSSamsungPayRequestParams.getReserve();
            if (this.f23572h) {
                reserve = m551g(m552f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                checkSSamsungPayRequestParams2.setReserve(m560b(reserve));
            }
            this.f23548J.put(String.valueOf(this.f23564Z[29]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f23569e;
                int[] iArr = this.f23564Z;
                int i2 = iArr[29];
                iArr[29] = i2 + 1;
                int checkSSamsungPay = iTsmService.checkSSamsungPay(checkSSamsungPayRequestParams2, new BinderC4503b(this, 29, i2, (byte) 0));
                if (checkSSamsungPay != 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23548J;
                    int[] iArr2 = this.f23564Z;
                    int i3 = iArr2[29] - 1;
                    iArr2[29] = i3;
                    hashMap.remove(String.valueOf(i3));
                }
                if (-2 == checkSSamsungPay) {
                    return m577a(29, checkSSamsungPayRequestParams, iTsmCallback);
                }
                return checkSSamsungPay;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0069 A[Catch: all -> 0x0083, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x000b, B:13:0x0014, B:15:0x0018, B:17:0x0027, B:19:0x002f, B:21:0x003a, B:22:0x0042, B:24:0x0048, B:25:0x004f, B:28:0x0057, B:29:0x005f, B:33:0x0069, B:30:0x0060, B:39:0x0072, B:40:0x007a, B:41:0x007b), top: B:49:0x000b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int clearEncryptData(int r6) throws android.os.RemoteException {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 2000(0x7d0, float:2.803E-42)
            if (r6 < r0) goto L86
            r0 = 2001(0x7d1, float:2.804E-42)
            if (r6 <= r0) goto Lb
            goto L86
        Lb:
            boolean r0 = r5.m559c()     // Catch: java.lang.Throwable -> L83
            if (r0 != 0) goto L14
            r6 = -8
        L12:
            monitor-exit(r5)
            return r6
        L14:
            com.unionpay.tsmservice.ITsmService r0 = r5.f23569e     // Catch: java.lang.Throwable -> L83
            if (r0 == 0) goto L81
            android.content.Context r0 = r5.f23567c     // Catch: java.lang.Throwable -> L83
            java.lang.String r0 = r0.getPackageName()     // Catch: java.lang.Throwable -> L83
            boolean r0 = m565a(r0)     // Catch: java.lang.Throwable -> L83
            r1 = 33
            r2 = 0
            if (r0 == 0) goto L7b
            java.lang.String r0 = "01.00.24"
            boolean r0 = r5.m555d(r0)     // Catch: java.lang.Throwable -> L83
            if (r0 == 0) goto L60
            com.unionpay.tsmservice.request.ClearEncryptDataRequestParams r0 = new com.unionpay.tsmservice.request.ClearEncryptDataRequestParams     // Catch: java.lang.Throwable -> L83
            r0.<init>()     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = ""
            boolean r4 = r5.f23572h     // Catch: java.lang.Throwable -> L83
            if (r4 == 0) goto L42
            java.lang.String r3 = m552f(r3)     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r5.m551g(r3)     // Catch: java.lang.Throwable -> L83
        L42:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L83
            if (r4 != 0) goto L4f
            java.lang.String r3 = r5.m560b(r3)     // Catch: java.lang.Throwable -> L83
            r0.setReserve(r3)     // Catch: java.lang.Throwable -> L83
        L4f:
            com.unionpay.tsmservice.ITsmService r3 = r5.f23569e     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L83
            int r0 = r3.clearKeyboardEncryptData(r0, r6)     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L83
            goto L66
        L56:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L83
            android.os.RemoteException r6 = new android.os.RemoteException     // Catch: java.lang.Throwable -> L83
            r6.<init>()     // Catch: java.lang.Throwable -> L83
            throw r6     // Catch: java.lang.Throwable -> L83
        L60:
            com.unionpay.tsmservice.ITsmService r0 = r5.f23569e     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L83
            int r0 = r0.clearEncryptData(r6)     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L83
        L66:
            r3 = -2
            if (r3 != r0) goto L6f
            int r6 = m575a(r1, r2, r6, r2, r2)     // Catch: java.lang.Throwable -> L83
            monitor-exit(r5)
            return r6
        L6f:
            monitor-exit(r5)
            return r0
        L71:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L83
            android.os.RemoteException r6 = new android.os.RemoteException     // Catch: java.lang.Throwable -> L83
            r6.<init>()     // Catch: java.lang.Throwable -> L83
            throw r6     // Catch: java.lang.Throwable -> L83
        L7b:
            int r6 = m575a(r1, r2, r6, r2, r2)     // Catch: java.lang.Throwable -> L83
            monitor-exit(r5)
            return r6
        L81:
            r6 = -1
            goto L12
        L83:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L86:
            r6 = -3
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.tsmservice.UPTsmAddon.clearEncryptData(int):int");
    }

    public synchronized int closeChannel(CloseChannelRequestParams closeChannelRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (closeChannelRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        String channel = closeChannelRequestParams.getChannel();
        if (TextUtils.isEmpty(channel)) {
            return -3;
        }
        if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(21, closeChannelRequestParams, iTsmCallback);
            }
            String m560b = m560b(channel);
            CloseChannelRequestParams closeChannelRequestParams2 = new CloseChannelRequestParams();
            closeChannelRequestParams2.setChannel(m560b);
            String reserve = closeChannelRequestParams.getReserve();
            if (this.f23572h) {
                reserve = m551g(m552f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                closeChannelRequestParams2.setReserve(m560b(reserve));
            }
            this.f23544F.put(String.valueOf(this.f23564Z[21]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f23569e;
                int[] iArr = this.f23564Z;
                int i2 = iArr[21];
                iArr[21] = i2 + 1;
                int closeChannel = iTsmService.closeChannel(closeChannelRequestParams2, new BinderC4503b(this, 21, i2, (byte) 0));
                if (closeChannel != 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23544F;
                    int[] iArr2 = this.f23564Z;
                    int i3 = iArr2[21] - 1;
                    iArr2[21] = i3;
                    hashMap.remove(String.valueOf(i3));
                }
                if (-2 == closeChannel) {
                    return m577a(21, closeChannelRequestParams, iTsmCallback);
                }
                return closeChannel;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int createSSD(UniteRequestParams uniteRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m555d("01.00.38")) {
            return -8;
        } else {
            if (!m559c()) {
                return -8;
            }
            if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(46, uniteRequestParams, iTsmCallback);
                }
                UniteRequestParams uniteRequestParams2 = new UniteRequestParams();
                if (uniteRequestParams == null) {
                    uniteRequestParams = new UniteRequestParams();
                }
                Bundle params = uniteRequestParams.getParams();
                if (params != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("encryptData", m573a(params));
                    uniteRequestParams2.setParams(bundle);
                }
                String reserve = uniteRequestParams.getReserve();
                if (this.f23572h) {
                    reserve = m551g(m552f(reserve));
                }
                if (!TextUtils.isEmpty(reserve)) {
                    uniteRequestParams2.setReserve(m560b(reserve));
                }
                this.f23562X.put(String.valueOf(this.f23564Z[46]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[46];
                    iArr[46] = i2 + 1;
                    int createSSD = iTsmService.createSSD(uniteRequestParams2, new BinderC4503b(this, 46, i2, (byte) 0));
                    if (createSSD != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23562X;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[46] - 1;
                        iArr2[46] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == createSSD) {
                        return m577a(46, uniteRequestParams, iTsmCallback);
                    }
                    return createSSD;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized int eCashTopUp(ECashTopUpRequestParams eCashTopUpRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (eCashTopUpRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(19, eCashTopUpRequestParams, iTsmCallback);
            }
            ECashTopUpRequestParams eCashTopUpRequestParams2 = new ECashTopUpRequestParams();
            String reserve = eCashTopUpRequestParams.getReserve();
            AppID appID = eCashTopUpRequestParams.getAppID();
            String type = eCashTopUpRequestParams.getType();
            String amount = eCashTopUpRequestParams.getAmount();
            if (!TextUtils.isEmpty(reserve)) {
                eCashTopUpRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    eCashTopUpRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            String encrpytPin = eCashTopUpRequestParams.getEncrpytPin();
            if (!TextUtils.isEmpty(encrpytPin)) {
                eCashTopUpRequestParams2.setEncrpytPin(encrpytPin);
            }
            if (!TextUtils.isEmpty(type)) {
                eCashTopUpRequestParams2.setType(m560b(type));
            }
            if (!TextUtils.isEmpty(amount)) {
                eCashTopUpRequestParams2.setAmount(m560b(amount));
            }
            try {
                int eCashTopUp = this.f23569e.eCashTopUp(eCashTopUpRequestParams2, new BinderC4503b(this, 19, this.f23564Z[19], (byte) 0));
                if (-2 == eCashTopUp) {
                    return m577a(19, eCashTopUpRequestParams, iTsmCallback);
                }
                if (eCashTopUp == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23583s;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[19];
                    iArr[19] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return eCashTopUp;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int encryptData(EncryptDataRequestParams encryptDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (encryptDataRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(23, encryptDataRequestParams, iTsmCallback);
            }
            EncryptDataRequestParams encryptDataRequestParams2 = new EncryptDataRequestParams();
            String reserve = encryptDataRequestParams.getReserve();
            if (this.f23572h) {
                reserve = m551g(m552f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                encryptDataRequestParams2.setReserve(m560b(reserve));
            }
            ArrayList arrayList = (ArrayList) encryptDataRequestParams.getData();
            if (arrayList != null) {
                int size = arrayList.size();
                if (size == 0) {
                    return -3;
                }
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = (String) arrayList.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        arrayList2.add(m560b(str));
                    }
                }
                encryptDataRequestParams2.setData(arrayList2);
            }
            this.f23540B.put(String.valueOf(this.f23564Z[23]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f23569e;
                int[] iArr = this.f23564Z;
                int i3 = iArr[23];
                iArr[23] = i3 + 1;
                int encryptData = iTsmService.encryptData(encryptDataRequestParams2, new BinderC4503b(this, 23, i3, (byte) 0));
                if (encryptData != 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23540B;
                    int[] iArr2 = this.f23564Z;
                    int i4 = iArr2[23] - 1;
                    iArr2[23] = i4;
                    hashMap.remove(String.valueOf(i4));
                }
                if (-2 == encryptData) {
                    return m577a(23, encryptDataRequestParams, iTsmCallback);
                }
                return encryptData;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public int exchangeKey(String str, String[] strArr) throws RemoteException {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            return -3;
        }
        if (m559c()) {
            ITsmService iTsmService = this.f23569e;
            if (iTsmService != null) {
                try {
                    return iTsmService.exchangeKey(str, strArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            return -1;
        }
        return -8;
    }

    public synchronized int executeCmd(ExecuteCmdRequestParams executeCmdRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
        int i;
        if (executeCmdRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m576a(25, executeCmdRequestParams, iTsmCallback, iTsmProgressCallback);
            }
            ExecuteCmdRequestParams executeCmdRequestParams2 = new ExecuteCmdRequestParams();
            String reserve = executeCmdRequestParams.getReserve();
            String ssid = executeCmdRequestParams.getSsid();
            String sign = executeCmdRequestParams.getSign();
            if (this.f23572h) {
                reserve = m551g(m552f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                executeCmdRequestParams2.setReserve(m560b(reserve));
            }
            if (!TextUtils.isEmpty(ssid)) {
                executeCmdRequestParams2.setSsid(m560b(ssid));
            }
            if (!TextUtils.isEmpty(sign)) {
                executeCmdRequestParams2.setSign(m560b(sign));
            }
            this.f23546H.put(String.valueOf(this.f23564Z[25]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f23569e;
                int[] iArr = this.f23564Z;
                int i2 = iArr[25];
                iArr[25] = i2 + 1;
                int executeCmd = iTsmService.executeCmd(executeCmdRequestParams2, new BinderC4503b(this, 25, i2, (byte) 0), iTsmProgressCallback);
                if (executeCmd != 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23546H;
                    int[] iArr2 = this.f23564Z;
                    int i3 = iArr2[25] - 1;
                    iArr2[25] = i3;
                    hashMap.remove(String.valueOf(i3));
                }
                if (-2 == executeCmd) {
                    return m576a(25, executeCmdRequestParams, iTsmCallback, iTsmProgressCallback);
                }
                return executeCmd;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getAccountBalance(GetAccountBalanceRequestParams getAccountBalanceRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (getAccountBalanceRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(8, getAccountBalanceRequestParams, iTsmCallback);
            }
            GetAccountBalanceRequestParams getAccountBalanceRequestParams2 = new GetAccountBalanceRequestParams();
            String reserve = getAccountBalanceRequestParams.getReserve();
            AppID appID = getAccountBalanceRequestParams.getAppID();
            if (!TextUtils.isEmpty(reserve)) {
                getAccountBalanceRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    getAccountBalanceRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            String encryptPin = getAccountBalanceRequestParams.getEncryptPin();
            if (!TextUtils.isEmpty(encryptPin)) {
                getAccountBalanceRequestParams2.setEncryptPin(encryptPin);
            }
            try {
                int accountBalance = this.f23569e.getAccountBalance(getAccountBalanceRequestParams2, new BinderC4503b(this, 8, this.f23564Z[8], (byte) 0));
                if (-2 == accountBalance) {
                    return m577a(8, getAccountBalanceRequestParams, iTsmCallback);
                }
                if (accountBalance == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23586v;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[8];
                    iArr[8] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return accountBalance;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getAccountInfo(GetAccountInfoRequestParams getAccountInfoRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (getAccountInfoRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(7, getAccountInfoRequestParams, iTsmCallback);
            }
            GetAccountInfoRequestParams getAccountInfoRequestParams2 = new GetAccountInfoRequestParams();
            String reserve = getAccountInfoRequestParams.getReserve();
            AppID appID = getAccountInfoRequestParams.getAppID();
            if (!TextUtils.isEmpty(reserve)) {
                getAccountInfoRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    getAccountInfoRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            try {
                int accountInfo = this.f23569e.getAccountInfo(getAccountInfoRequestParams2, new BinderC4503b(this, 7, this.f23564Z[7], (byte) 0));
                if (-2 == accountInfo) {
                    return m577a(7, getAccountInfoRequestParams, iTsmCallback);
                }
                if (accountInfo == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23585u;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[7];
                    iArr[7] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return accountInfo;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getAppDetail(GetAppDetailRequestParams getAppDetailRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (getAppDetailRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(4, getAppDetailRequestParams, iTsmCallback);
            }
            GetAppDetailRequestParams getAppDetailRequestParams2 = new GetAppDetailRequestParams();
            String reserve = getAppDetailRequestParams.getReserve();
            AppID appID = getAppDetailRequestParams.getAppID();
            String transType = getAppDetailRequestParams.getTransType();
            if (!TextUtils.isEmpty(reserve)) {
                getAppDetailRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    getAppDetailRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            if (!TextUtils.isEmpty(transType)) {
                getAppDetailRequestParams2.setTransType(m560b(transType));
            }
            try {
                int appDetail = this.f23569e.getAppDetail(getAppDetailRequestParams2, new BinderC4503b(this, 4, this.f23564Z[4], (byte) 0));
                if (-2 == appDetail) {
                    return m577a(4, getAppDetailRequestParams, iTsmCallback);
                }
                if (appDetail == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23578n;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[4];
                    iArr[4] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return appDetail;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getAppList(GetAppListRequestParams getAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (getAppListRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(2, getAppListRequestParams, iTsmCallback);
            }
            GetAppListRequestParams getAppListRequestParams2 = new GetAppListRequestParams();
            String reserve = getAppListRequestParams.getReserve();
            String keyword = getAppListRequestParams.getKeyword();
            String[] status = getAppListRequestParams.getStatus();
            if (!TextUtils.isEmpty(reserve)) {
                getAppListRequestParams2.setReserve(m560b(reserve));
            }
            if (!TextUtils.isEmpty(keyword)) {
                getAppListRequestParams2.setKeyword(m560b(keyword));
            }
            if (status != null) {
                int length = status.length;
                String[] strArr = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    if (!TextUtils.isEmpty(status[i2])) {
                        strArr[i2] = m560b(status[i2]);
                    }
                }
                getAppListRequestParams2.setStatus(strArr);
            }
            try {
                int appList = this.f23569e.getAppList(getAppListRequestParams2, new BinderC4503b(this, 2, this.f23564Z[2], (byte) 0));
                if (-2 == appList) {
                    return m577a(2, getAppListRequestParams, iTsmCallback);
                }
                if (appList == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23576l;
                    int[] iArr = this.f23564Z;
                    int i3 = iArr[2];
                    iArr[2] = i3 + 1;
                    hashMap.put(String.valueOf(i3), iTsmCallback);
                }
                return appList;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getAppStatus(GetAppStatusRequestParams getAppStatusRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (getAppStatusRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(5, getAppStatusRequestParams, iTsmCallback);
            }
            GetAppStatusRequestParams getAppStatusRequestParams2 = new GetAppStatusRequestParams();
            String reserve = getAppStatusRequestParams.getReserve();
            AppID appID = getAppStatusRequestParams.getAppID();
            if (!TextUtils.isEmpty(reserve)) {
                getAppStatusRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    getAppStatusRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            try {
                int appStatus = this.f23569e.getAppStatus(getAppStatusRequestParams2, new BinderC4503b(this, 5, this.f23564Z[5], (byte) 0));
                if (-2 == appStatus) {
                    return m577a(5, getAppStatusRequestParams, iTsmCallback);
                }
                if (appStatus == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23577m;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[5];
                    iArr[5] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return appStatus;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getAssociatedApp(GetAssociatedAppRequestParams getAssociatedAppRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (getAssociatedAppRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        String encryptPan = getAssociatedAppRequestParams.getEncryptPan();
        if (TextUtils.isEmpty(encryptPan)) {
            return -3;
        }
        if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(1, getAssociatedAppRequestParams, iTsmCallback);
            }
            GetAssociatedAppRequestParams getAssociatedAppRequestParams2 = new GetAssociatedAppRequestParams();
            String reserve = getAssociatedAppRequestParams.getReserve();
            if (this.f23572h) {
                reserve = m551g(m552f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                getAssociatedAppRequestParams2.setReserve(m560b(reserve));
            }
            getAssociatedAppRequestParams2.setEncryptPan(m560b(encryptPan));
            try {
                int associatedApp = this.f23569e.getAssociatedApp(getAssociatedAppRequestParams2, new BinderC4503b(this, 1, this.f23564Z[1], (byte) 0));
                if (-2 == associatedApp) {
                    return m577a(1, getAssociatedAppRequestParams, iTsmCallback);
                }
                if (associatedApp == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23574j;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[1];
                    iArr[1] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return associatedApp;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getCardInfo(GetCardInfoRequestParams getCardInfoRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (getCardInfoRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        String[] appAID = getCardInfoRequestParams.getAppAID();
        int length = appAID.length;
        if (appAID != null && length != 0) {
            int i2 = 0;
            while (i2 < length && appAID[i2] == null) {
                i2++;
            }
            if (i2 == length) {
                return -3;
            }
            if (!m559c()) {
                i = -8;
            } else if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(6, getCardInfoRequestParams, iTsmCallback);
                }
                String[] strArr = new String[length];
                for (int i3 = 0; i3 < length; i3++) {
                    if (appAID[i3] == null) {
                        strArr[i3] = appAID[i3];
                    } else {
                        strArr[i3] = m560b(appAID[i3]);
                    }
                }
                GetCardInfoRequestParams getCardInfoRequestParams2 = new GetCardInfoRequestParams();
                getCardInfoRequestParams2.setAppAID(strArr);
                String reserve = getCardInfoRequestParams.getReserve();
                if (this.f23572h) {
                    reserve = m551g(m552f(reserve));
                }
                if (!TextUtils.isEmpty(reserve)) {
                    getCardInfoRequestParams2.setReserve(m560b(reserve));
                }
                try {
                    int cardInfo = this.f23569e.getCardInfo(getCardInfoRequestParams2, new BinderC4503b(this, 6, this.f23564Z[6], (byte) 0));
                    if (-2 == cardInfo) {
                        return m577a(6, getCardInfoRequestParams, iTsmCallback);
                    }
                    if (cardInfo == 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23539A;
                        int[] iArr = this.f23564Z;
                        int i4 = iArr[6];
                        iArr[6] = i4 + 1;
                        hashMap.put(String.valueOf(i4), iTsmCallback);
                    }
                    return cardInfo;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            } else {
                i = -1;
            }
            return i;
        }
        return -3;
    }

    public synchronized int getCardInfoBySamsungPay(GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (getCardInfoBySpayRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(28, getCardInfoBySpayRequestParams, iTsmCallback);
            }
            GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams2 = new GetCardInfoBySpayRequestParams();
            String reserve = getCardInfoBySpayRequestParams.getReserve();
            if (this.f23572h) {
                reserve = m551g(m552f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                getCardInfoBySpayRequestParams2.setReserve(m560b(reserve));
            }
            Amount amount = getCardInfoBySpayRequestParams.getAmount();
            if (amount != null) {
                String currencyType = amount.getCurrencyType();
                String productPrice = amount.getProductPrice();
                Amount amount2 = new Amount();
                if (!TextUtils.isEmpty(currencyType)) {
                    amount2.setCurrencyType(m560b(currencyType));
                }
                if (!TextUtils.isEmpty(productPrice)) {
                    amount2.setProductPrice(m560b(productPrice));
                }
                getCardInfoBySpayRequestParams2.setAmount(amount2);
            }
            this.f23547I.put(String.valueOf(this.f23564Z[28]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f23569e;
                int[] iArr = this.f23564Z;
                int i2 = iArr[28];
                iArr[28] = i2 + 1;
                int cardInfoBySamsungPay = iTsmService.getCardInfoBySamsungPay(getCardInfoBySpayRequestParams2, new BinderC4503b(this, 28, i2, (byte) 0));
                if (cardInfoBySamsungPay != 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23547I;
                    int[] iArr2 = this.f23564Z;
                    int i3 = iArr2[28] - 1;
                    iArr2[28] = i3;
                    hashMap.remove(String.valueOf(i3));
                }
                if (-2 == cardInfoBySamsungPay) {
                    return m577a(28, getCardInfoBySpayRequestParams, iTsmCallback);
                }
                return cardInfoBySamsungPay;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public Context getContext() {
        return this.f23567c;
    }

    public int getCryptType() {
        return this.f23571g;
    }

    public synchronized int getDefaultCard(GetDefaultCardRequestParams getDefaultCardRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(13, getDefaultCardRequestParams, iTsmCallback);
            }
            GetDefaultCardRequestParams getDefaultCardRequestParams2 = new GetDefaultCardRequestParams();
            if (getDefaultCardRequestParams != null) {
                String reserve = getDefaultCardRequestParams.getReserve();
                if (!TextUtils.isEmpty(reserve)) {
                    getDefaultCardRequestParams2.setReserve(m560b(reserve));
                }
            }
            try {
                int defaultCard = this.f23569e.getDefaultCard(getDefaultCardRequestParams2, new BinderC4503b(this, 13, this.f23564Z[13], (byte) 0));
                if (-2 == defaultCard) {
                    return m577a(13, getDefaultCardRequestParams, iTsmCallback);
                }
                if (defaultCard == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23589y;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[13];
                    iArr[13] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return defaultCard;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getEncryptData(GetEncryptDataRequestParams getEncryptDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null || getEncryptDataRequestParams == null) {
            return -3;
        }
        int type = getEncryptDataRequestParams.getType();
        String pan = getEncryptDataRequestParams.getPan();
        if (type >= 2000 && type <= 2001) {
            if (type == 2000 && TextUtils.isEmpty(pan)) {
                return -3;
            }
            if (!m559c()) {
                i = -8;
            } else if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(31, getEncryptDataRequestParams, iTsmCallback);
                }
                GetEncryptDataRequestParams getEncryptDataRequestParams2 = new GetEncryptDataRequestParams();
                if (type == 2000) {
                    getEncryptDataRequestParams2.setPan(m560b(pan));
                }
                getEncryptDataRequestParams2.setType(type);
                String reserve = getEncryptDataRequestParams.getReserve();
                if (this.f23572h) {
                    reserve = m551g(m552f(reserve));
                }
                if (!TextUtils.isEmpty(reserve)) {
                    getEncryptDataRequestParams2.setReserve(m560b(reserve));
                }
                this.f23550L.put(String.valueOf(this.f23564Z[31]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[31];
                    iArr[31] = i2 + 1;
                    int encryptData = iTsmService.getEncryptData(getEncryptDataRequestParams2, new BinderC4503b(this, 31, i2, (byte) 0));
                    if (encryptData != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23550L;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[31] - 1;
                        iArr2[31] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == encryptData) {
                        return m577a(31, getEncryptDataRequestParams, iTsmCallback);
                    }
                    return encryptData;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            } else {
                i = -1;
            }
            return i;
        }
        return -3;
    }

    public synchronized int getListenerCount() {
        if (f23538b != null) {
            return f23538b.size();
        }
        return 0;
    }

    public synchronized int getMessageDetails(GetMessageDetailsRequestParams getMessageDetailsRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m555d("01.00.35")) {
            return -8;
        } else {
            if (!m559c()) {
                return -8;
            }
            if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(44, getMessageDetailsRequestParams, iTsmCallback);
                }
                GetMessageDetailsRequestParams getMessageDetailsRequestParams2 = new GetMessageDetailsRequestParams();
                String str = "";
                if (getMessageDetailsRequestParams != null) {
                    str = getMessageDetailsRequestParams.getReserve();
                    Bundle params = getMessageDetailsRequestParams.getParams();
                    if (params != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("encryptData", m573a(params));
                        getMessageDetailsRequestParams2.setParams(bundle);
                    }
                }
                if (this.f23572h) {
                    str = m551g(m552f(str));
                }
                if (!TextUtils.isEmpty(str)) {
                    getMessageDetailsRequestParams2.setReserve(m560b(str));
                }
                this.f23560V.put(String.valueOf(this.f23564Z[44]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[44];
                    iArr[44] = i2 + 1;
                    int messageDetails = iTsmService.getMessageDetails(getMessageDetailsRequestParams2, new BinderC4503b(this, 44, i2, (byte) 0));
                    if (messageDetails != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23560V;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[44] - 1;
                        iArr2[44] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == messageDetails) {
                        return m577a(44, getMessageDetailsRequestParams, iTsmCallback);
                    }
                    return messageDetails;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            i = -1;
        }
        return i;
    }

    public int getPubKey(int i, String[] strArr) throws RemoteException {
        if (strArr == null || strArr.length == 0) {
            return -3;
        }
        if (m559c()) {
            ITsmService iTsmService = this.f23569e;
            if (iTsmService != null) {
                try {
                    return iTsmService.getPubKey(i, strArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            return -1;
        }
        return -8;
    }

    public synchronized int getSEAppList(GetSeAppListRequestParams getSeAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(3, getSeAppListRequestParams, iTsmCallback);
            }
            GetSeAppListRequestParams getSeAppListRequestParams2 = new GetSeAppListRequestParams();
            String reserve = getSeAppListRequestParams != null ? getSeAppListRequestParams.getReserve() : "";
            if (this.f23572h) {
                reserve = m551g(m552f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                getSeAppListRequestParams2.setReserve(m560b(reserve));
            }
            this.f23575k.put(String.valueOf(this.f23564Z[3]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f23569e;
                int[] iArr = this.f23564Z;
                int i2 = iArr[3];
                iArr[3] = i2 + 1;
                int sEAppList = iTsmService.getSEAppList(getSeAppListRequestParams2, new BinderC4503b(this, 3, i2, (byte) 0));
                if (sEAppList != 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23575k;
                    int[] iArr2 = this.f23564Z;
                    int i3 = iArr2[3] - 1;
                    iArr2[3] = i3;
                    hashMap.remove(String.valueOf(i3));
                }
                if (-2 == sEAppList) {
                    return m577a(3, getSeAppListRequestParams, iTsmCallback);
                }
                return sEAppList;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getSMSAuthCode(GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (getSMSAuthCodeRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(11, getSMSAuthCodeRequestParams, iTsmCallback);
            }
            GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams2 = new GetSMSAuthCodeRequestParams();
            String reserve = getSMSAuthCodeRequestParams.getReserve();
            AppID appID = getSMSAuthCodeRequestParams.getAppID();
            if (!TextUtils.isEmpty(reserve)) {
                getSMSAuthCodeRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    getSMSAuthCodeRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            String pan = getSMSAuthCodeRequestParams.getPan();
            String msisdn = getSMSAuthCodeRequestParams.getMsisdn();
            if (!TextUtils.isEmpty(pan)) {
                getSMSAuthCodeRequestParams2.setPan(m560b(pan));
            }
            if (!TextUtils.isEmpty(msisdn)) {
                getSMSAuthCodeRequestParams2.setMsisdn(m560b(msisdn));
            }
            try {
                int sMSAuthCode = this.f23569e.getSMSAuthCode(getSMSAuthCodeRequestParams2, new BinderC4503b(this, 11, this.f23564Z[11], (byte) 0));
                if (-2 == sMSAuthCode) {
                    return m577a(11, getSMSAuthCodeRequestParams, iTsmCallback);
                }
                if (sMSAuthCode == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23582r;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[11];
                    iArr[11] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return sMSAuthCode;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getSeId(GetSeIdRequestParams getSeIdRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(12, getSeIdRequestParams, iTsmCallback);
            }
            GetSeIdRequestParams getSeIdRequestParams2 = new GetSeIdRequestParams();
            String reserve = getSeIdRequestParams != null ? getSeIdRequestParams.getReserve() : "";
            if (this.f23572h) {
                reserve = m551g(m552f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                getSeIdRequestParams2.setReserve(m560b(reserve));
            }
            this.f23590z.put(String.valueOf(this.f23564Z[12]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f23569e;
                int[] iArr = this.f23564Z;
                int i2 = iArr[12];
                iArr[12] = i2 + 1;
                int sEId = iTsmService.getSEId(getSeIdRequestParams2, new BinderC4503b(this, 12, i2, (byte) 0));
                if (sEId != 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23590z;
                    int[] iArr2 = this.f23564Z;
                    int i3 = iArr2[12] - 1;
                    iArr2[12] = i3;
                    hashMap.remove(String.valueOf(i3));
                }
                if (-2 == sEId) {
                    return m577a(12, getSeIdRequestParams, iTsmCallback);
                }
                return sEId;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getTransElements(GetTransElementsRequestParams getTransElementsRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (getTransElementsRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(9, getTransElementsRequestParams, iTsmCallback);
            }
            GetTransElementsRequestParams getTransElementsRequestParams2 = new GetTransElementsRequestParams();
            String reserve = getTransElementsRequestParams.getReserve();
            AppID appID = getTransElementsRequestParams.getAppID();
            String transType = getTransElementsRequestParams.getTransType();
            if (!TextUtils.isEmpty(reserve)) {
                getTransElementsRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    getTransElementsRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            if (!TextUtils.isEmpty(transType)) {
                getTransElementsRequestParams2.setTransType(m560b(transType));
            }
            try {
                int transElements = this.f23569e.getTransElements(getTransElementsRequestParams2, new BinderC4503b(this, 9, this.f23564Z[9], (byte) 0));
                if (-2 == transElements) {
                    return m577a(9, getTransElementsRequestParams, iTsmCallback);
                }
                if (transElements == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23579o;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[9];
                    iArr[9] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return transElements;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getTransRecord(GetTransRecordRequestParams getTransRecordRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (getTransRecordRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(10, getTransRecordRequestParams, iTsmCallback);
            }
            GetTransRecordRequestParams getTransRecordRequestParams2 = new GetTransRecordRequestParams();
            String reserve = getTransRecordRequestParams.getReserve();
            AppID appID = getTransRecordRequestParams.getAppID();
            if (!TextUtils.isEmpty(reserve)) {
                getTransRecordRequestParams2.setReserve(m560b(reserve));
            }
            if (appID != null) {
                String appAid = appID.getAppAid();
                String appVersion = appID.getAppVersion();
                if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                    getTransRecordRequestParams2.setAppID(new AppID(m560b(appAid), m560b(appVersion)));
                }
            }
            try {
                int transRecord = this.f23569e.getTransRecord(getTransRecordRequestParams2, new BinderC4503b(this, 10, this.f23564Z[10], (byte) 0));
                if (-2 == transRecord) {
                    return m577a(10, getTransRecordRequestParams, iTsmCallback);
                }
                if (transRecord == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23584t;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[10];
                    iArr[10] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return transRecord;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int getTransactionDetails(GetTransactionDetailsRequestParams getTransactionDetailsRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m555d("01.00.35")) {
            return -8;
        } else {
            if (!m559c()) {
                return -8;
            }
            if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(43, getTransactionDetailsRequestParams, iTsmCallback);
                }
                GetTransactionDetailsRequestParams getTransactionDetailsRequestParams2 = new GetTransactionDetailsRequestParams();
                String str = "";
                if (getTransactionDetailsRequestParams != null) {
                    str = getTransactionDetailsRequestParams.getReserve();
                    Bundle params = getTransactionDetailsRequestParams.getParams();
                    if (params != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("encryptData", m573a(params));
                        getTransactionDetailsRequestParams2.setParams(bundle);
                    }
                }
                if (this.f23572h) {
                    str = m551g(m552f(str));
                }
                if (!TextUtils.isEmpty(str)) {
                    getTransactionDetailsRequestParams2.setReserve(m560b(str));
                }
                this.f23559U.put(String.valueOf(this.f23564Z[43]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[43];
                    iArr[43] = i2 + 1;
                    int transactionDetails = iTsmService.getTransactionDetails(getTransactionDetailsRequestParams2, new BinderC4503b(this, 43, i2, (byte) 0));
                    if (transactionDetails != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23559U;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[43] - 1;
                        iArr2[43] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == transactionDetails) {
                        return m577a(43, getTransactionDetailsRequestParams, iTsmCallback);
                    }
                    return transactionDetails;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized int getVendorPayStatus(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m555d("01.00.20")) {
            return -8;
        } else {
            if (!m559c()) {
                return -8;
            }
            if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(36, getVendorPayStatusRequestParams, iTsmCallback);
                }
                GetVendorPayStatusRequestParams getVendorPayStatusRequestParams2 = new GetVendorPayStatusRequestParams();
                String reserve = getVendorPayStatusRequestParams != null ? getVendorPayStatusRequestParams.getReserve() : "";
                if (this.f23572h) {
                    reserve = m551g(m552f(reserve));
                }
                if (!TextUtils.isEmpty(reserve)) {
                    getVendorPayStatusRequestParams2.setReserve(m560b(reserve));
                }
                this.f23552N.put(String.valueOf(this.f23564Z[36]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[36];
                    iArr[36] = i2 + 1;
                    int vendorPayStatus = iTsmService.getVendorPayStatus(getVendorPayStatusRequestParams2, new BinderC4503b(this, 36, i2, (byte) 0));
                    if (vendorPayStatus != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23552N;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[36] - 1;
                        iArr2[36] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == vendorPayStatus) {
                        return m577a(36, getVendorPayStatusRequestParams, iTsmCallback);
                    }
                    return vendorPayStatus;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized int hideAppApply(HideAppApplyRequestParams hideAppApplyRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (hideAppApplyRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        String applyId = hideAppApplyRequestParams.getApplyId();
        if (TextUtils.isEmpty(applyId)) {
            return -3;
        }
        if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(24, hideAppApplyRequestParams, iTsmCallback);
            }
            String m560b = m560b(applyId);
            HideAppApplyRequestParams hideAppApplyRequestParams2 = new HideAppApplyRequestParams();
            hideAppApplyRequestParams2.setApplyId(m560b);
            String reserve = hideAppApplyRequestParams.getReserve();
            if (!TextUtils.isEmpty(reserve)) {
                hideAppApplyRequestParams2.setReserve(m560b(reserve));
            }
            try {
                int hideAppApply = this.f23569e.hideAppApply(hideAppApplyRequestParams2, new BinderC4503b(this, 24, this.f23564Z[24], (byte) 0));
                if (-2 == hideAppApply) {
                    return m577a(24, hideAppApplyRequestParams, iTsmCallback);
                }
                if (hideAppApply == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23545G;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[24];
                    iArr[24] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return hideAppApply;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0060 A[Catch: all -> 0x007a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:8:0x000a, B:10:0x000e, B:12:0x001e, B:14:0x0026, B:16:0x0031, B:17:0x0039, B:19:0x003f, B:20:0x0046, B:23:0x004e, B:24:0x0056, B:28:0x0060, B:25:0x0057, B:34:0x0069, B:35:0x0071, B:36:0x0072), top: B:48:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int hideKeyboard() throws android.os.RemoteException {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.m559c()     // Catch: java.lang.Throwable -> L7a
            if (r0 != 0) goto La
            r0 = -8
        L8:
            monitor-exit(r6)
            return r0
        La:
            com.unionpay.tsmservice.ITsmService r0 = r6.f23569e     // Catch: java.lang.Throwable -> L7a
            if (r0 == 0) goto L78
            android.content.Context r0 = r6.f23567c     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = r0.getPackageName()     // Catch: java.lang.Throwable -> L7a
            boolean r0 = m565a(r0)     // Catch: java.lang.Throwable -> L7a
            r1 = 0
            r2 = 34
            r3 = 0
            if (r0 == 0) goto L72
            java.lang.String r0 = "01.00.24"
            boolean r0 = r6.m555d(r0)     // Catch: java.lang.Throwable -> L7a
            if (r0 == 0) goto L57
            com.unionpay.tsmservice.request.HideSafetyKeyboardRequestParams r0 = new com.unionpay.tsmservice.request.HideSafetyKeyboardRequestParams     // Catch: java.lang.Throwable -> L7a
            r0.<init>()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r4 = ""
            boolean r5 = r6.f23572h     // Catch: java.lang.Throwable -> L7a
            if (r5 == 0) goto L39
            java.lang.String r4 = m552f(r4)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r4 = r6.m551g(r4)     // Catch: java.lang.Throwable -> L7a
        L39:
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L7a
            if (r5 != 0) goto L46
            java.lang.String r4 = r6.m560b(r4)     // Catch: java.lang.Throwable -> L7a
            r0.setReserve(r4)     // Catch: java.lang.Throwable -> L7a
        L46:
            com.unionpay.tsmservice.ITsmService r4 = r6.f23569e     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L7a
            int r0 = r4.hideSafetyKeyboard(r0)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L7a
            goto L5d
        L4d:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L7a
            android.os.RemoteException r0 = new android.os.RemoteException     // Catch: java.lang.Throwable -> L7a
            r0.<init>()     // Catch: java.lang.Throwable -> L7a
            throw r0     // Catch: java.lang.Throwable -> L7a
        L57:
            com.unionpay.tsmservice.ITsmService r0 = r6.f23569e     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L7a
            int r0 = r0.hideKeyboard()     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L7a
        L5d:
            r4 = -2
            if (r4 != r0) goto L66
            int r0 = m575a(r2, r3, r1, r3, r3)     // Catch: java.lang.Throwable -> L7a
            monitor-exit(r6)
            return r0
        L66:
            monitor-exit(r6)
            return r0
        L68:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L7a
            android.os.RemoteException r0 = new android.os.RemoteException     // Catch: java.lang.Throwable -> L7a
            r0.<init>()     // Catch: java.lang.Throwable -> L7a
            throw r0     // Catch: java.lang.Throwable -> L7a
        L72:
            int r0 = m575a(r2, r3, r1, r3, r3)     // Catch: java.lang.Throwable -> L7a
            monitor-exit(r6)
            return r0
        L78:
            r0 = -1
            goto L8
        L7a:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.tsmservice.UPTsmAddon.hideKeyboard():int");
    }

    public synchronized int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(0, initRequestParams, iTsmCallback);
            }
            InitRequestParams initRequestParams2 = new InitRequestParams();
            String str = "";
            if (initRequestParams != null) {
                str = initRequestParams.getReserve();
                String signature = initRequestParams.getSignature();
                if (!TextUtils.isEmpty(signature)) {
                    initRequestParams2.setSignature(m560b(signature));
                }
            }
            if (this.f23572h) {
                str = m551g(m552f(str));
            }
            if (!TextUtils.isEmpty(str)) {
                initRequestParams2.setReserve(m560b(str));
            }
            this.f23573i.put(String.valueOf(this.f23564Z[0]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f23569e;
                int[] iArr = this.f23564Z;
                int i2 = iArr[0];
                iArr[0] = i2 + 1;
                int init = iTsmService.init(initRequestParams2, new BinderC4503b(this, 0, i2, (byte) 0));
                if (init != 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23573i;
                    int[] iArr2 = this.f23564Z;
                    int i3 = iArr2[0] - 1;
                    iArr2[0] = i3;
                    hashMap.remove(String.valueOf(i3));
                }
                if (-2 == init) {
                    return m577a(0, initRequestParams, iTsmCallback);
                }
                return init;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public boolean isConnected() {
        return this.f23570f;
    }

    public synchronized int onlinePaymentVerify(OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (onlinePaymentVerifyRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m555d("01.00.21")) {
            return -8;
        } else {
            if (!m559c()) {
                return -8;
            }
            if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(39, onlinePaymentVerifyRequestParams, iTsmCallback);
                }
                OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams2 = new OnlinePaymentVerifyRequestParams();
                Bundle resource = onlinePaymentVerifyRequestParams.getResource();
                if (resource != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("encryptData", m573a(resource));
                    onlinePaymentVerifyRequestParams2.setResource(bundle);
                }
                String orderNumber = onlinePaymentVerifyRequestParams.getOrderNumber();
                String aId = onlinePaymentVerifyRequestParams.getAId();
                if (!TextUtils.isEmpty(orderNumber)) {
                    onlinePaymentVerifyRequestParams2.setOrderNumber(m560b(orderNumber));
                }
                if (!TextUtils.isEmpty(aId)) {
                    onlinePaymentVerifyRequestParams2.setAId(m560b(aId));
                }
                String reserve = onlinePaymentVerifyRequestParams.getReserve();
                if (this.f23572h) {
                    reserve = m551g(m552f(reserve));
                }
                if (!TextUtils.isEmpty(reserve)) {
                    onlinePaymentVerifyRequestParams2.setReserve(m560b(reserve));
                }
                this.f23555Q.put(String.valueOf(this.f23564Z[39]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[39];
                    iArr[39] = i2 + 1;
                    int onlinePaymentVerify = iTsmService.onlinePaymentVerify(onlinePaymentVerifyRequestParams2, new BinderC4503b(this, 39, i2, (byte) 0));
                    if (onlinePaymentVerify != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23555Q;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[39] - 1;
                        iArr2[39] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == onlinePaymentVerify) {
                        return m577a(39, onlinePaymentVerifyRequestParams, iTsmCallback);
                    }
                    return onlinePaymentVerify;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized int openChannel(OpenChannelRequestParams openChannelRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (openChannelRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        String appAID = openChannelRequestParams.getAppAID();
        if (TextUtils.isEmpty(appAID)) {
            return -3;
        }
        if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(20, openChannelRequestParams, iTsmCallback);
            }
            String m560b = m560b(appAID);
            OpenChannelRequestParams openChannelRequestParams2 = new OpenChannelRequestParams();
            openChannelRequestParams2.setAppAID(m560b);
            String reserve = openChannelRequestParams.getReserve();
            if (this.f23572h) {
                reserve = m551g(m552f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                openChannelRequestParams2.setReserve(m560b(reserve));
            }
            this.f23587w.put(String.valueOf(this.f23564Z[20]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f23569e;
                int[] iArr = this.f23564Z;
                int i2 = iArr[20];
                iArr[20] = i2 + 1;
                int openChannel = iTsmService.openChannel(openChannelRequestParams2, new BinderC4503b(this, 20, i2, (byte) 0));
                if (openChannel != 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23587w;
                    int[] iArr2 = this.f23564Z;
                    int i3 = iArr2[20] - 1;
                    iArr2[20] = i3;
                    hashMap.remove(String.valueOf(i3));
                }
                if (-2 == openChannel) {
                    return m577a(20, openChannelRequestParams, iTsmCallback);
                }
                return openChannel;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int preDownload(PreDownloadRequestParams preDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m555d("01.00.26")) {
            return -8;
        } else {
            if (!m559c()) {
                return -8;
            }
            if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m576a(40, preDownloadRequestParams, iTsmCallback, iTsmProgressCallback);
                }
                PreDownloadRequestParams preDownloadRequestParams2 = new PreDownloadRequestParams();
                String str = "";
                if (preDownloadRequestParams != null) {
                    str = preDownloadRequestParams.getReserve();
                    Bundle params = preDownloadRequestParams.getParams();
                    if (params != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("encryptData", m573a(params));
                        preDownloadRequestParams2.setParams(bundle);
                    }
                }
                if (this.f23572h) {
                    str = m551g(m552f(str));
                }
                if (!TextUtils.isEmpty(str)) {
                    preDownloadRequestParams2.setReserve(m560b(str));
                }
                this.f23556R.put(String.valueOf(this.f23564Z[40]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[40];
                    iArr[40] = i2 + 1;
                    int preDownload = iTsmService.preDownload(preDownloadRequestParams2, new BinderC4503b(this, 40, i2, (byte) 0), iTsmProgressCallback);
                    if (preDownload != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23556R;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[40] - 1;
                        iArr2[40] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == preDownload) {
                        return m576a(40, preDownloadRequestParams, iTsmCallback, iTsmProgressCallback);
                    }
                    return preDownload;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized int queryVendorPayStatus(QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m555d("01.00.27")) {
            return -8;
        } else {
            if (!m559c()) {
                return -8;
            }
            if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(41, queryVendorPayStatusRequestParams, iTsmCallback);
                }
                QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams2 = new QueryVendorPayStatusRequestParams();
                String reserve = queryVendorPayStatusRequestParams != null ? queryVendorPayStatusRequestParams.getReserve() : "";
                if (this.f23572h) {
                    reserve = m551g(m552f(reserve));
                }
                if (!TextUtils.isEmpty(reserve)) {
                    queryVendorPayStatusRequestParams2.setReserve(m560b(reserve));
                }
                this.f23557S.put(String.valueOf(this.f23564Z[41]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[41];
                    iArr[41] = i2 + 1;
                    int queryVendorPayStatus = iTsmService.queryVendorPayStatus(queryVendorPayStatusRequestParams2, new BinderC4503b(this, 41, i2, (byte) 0));
                    if (queryVendorPayStatus != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23557S;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[41] - 1;
                        iArr2[41] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == queryVendorPayStatus) {
                        return m577a(41, queryVendorPayStatusRequestParams, iTsmCallback);
                    }
                    return queryVendorPayStatus;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized void removeConnectionListener(UPTsmConnectionListener uPTsmConnectionListener) {
        if (uPTsmConnectionListener != null) {
            f23538b.remove(uPTsmConnectionListener);
        }
    }

    public synchronized int sendApdu(SendApduRequestParams sendApduRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (sendApduRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(22, sendApduRequestParams, iTsmCallback);
            }
            SendApduRequestParams sendApduRequestParams2 = new SendApduRequestParams();
            String reserve = sendApduRequestParams.getReserve();
            String channel = sendApduRequestParams.getChannel();
            String hexApdu = sendApduRequestParams.getHexApdu();
            if (this.f23572h) {
                reserve = m551g(m552f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                sendApduRequestParams2.setReserve(m560b(reserve));
            }
            if (!TextUtils.isEmpty(channel)) {
                sendApduRequestParams2.setChannel(m560b(channel));
            }
            if (!TextUtils.isEmpty(hexApdu)) {
                sendApduRequestParams2.setHexApdu(m560b(hexApdu));
            }
            this.f23588x.put(String.valueOf(this.f23564Z[22]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f23569e;
                int[] iArr = this.f23564Z;
                int i2 = iArr[22];
                iArr[22] = i2 + 1;
                int sendApdu = iTsmService.sendApdu(sendApduRequestParams2, new BinderC4503b(this, 22, i2, (byte) 0));
                if (sendApdu != 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23588x;
                    int[] iArr2 = this.f23564Z;
                    int i3 = iArr2[22] - 1;
                    iArr2[22] = i3;
                    hashMap.remove(String.valueOf(i3));
                }
                if (-2 == sendApdu) {
                    return m577a(22, sendApduRequestParams, iTsmCallback);
                }
                return sendApdu;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int sendCustomData(SendCustomDataRequestParams sendCustomDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (sendCustomDataRequestParams == null || iTsmCallback == null) {
            i = -3;
        } else if (!m555d("01.00.37")) {
            return -8;
        } else {
            if (!m559c()) {
                return -8;
            }
            if (this.f23569e != null) {
                if (!m565a(this.f23567c.getPackageName())) {
                    return m577a(45, sendCustomDataRequestParams, iTsmCallback);
                }
                SendCustomDataRequestParams sendCustomDataRequestParams2 = new SendCustomDataRequestParams();
                Bundle params = sendCustomDataRequestParams.getParams();
                if (params != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("encryptData", m573a(params));
                    sendCustomDataRequestParams2.setParams(bundle);
                }
                String reserve = sendCustomDataRequestParams.getReserve();
                if (this.f23572h) {
                    reserve = m551g(m552f(reserve));
                }
                if (!TextUtils.isEmpty(reserve)) {
                    sendCustomDataRequestParams2.setReserve(m560b(reserve));
                }
                this.f23561W.put(String.valueOf(this.f23564Z[45]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f23569e;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[45];
                    iArr[45] = i2 + 1;
                    int sendCustomData = iTsmService.sendCustomData(sendCustomDataRequestParams2, new BinderC4503b(this, 45, i2, (byte) 0));
                    if (sendCustomData != 0) {
                        HashMap<String, ITsmCallback> hashMap = this.f23561W;
                        int[] iArr2 = this.f23564Z;
                        int i3 = iArr2[45] - 1;
                        iArr2[45] = i3;
                        hashMap.remove(String.valueOf(i3));
                    }
                    if (-2 == sendCustomData) {
                        return m577a(45, sendCustomDataRequestParams, iTsmCallback);
                    }
                    return sendCustomData;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized int setDefaultCard(SetDefaultCardRequestParams setDefaultCardRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (setDefaultCardRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        String appAID = setDefaultCardRequestParams.getAppAID();
        if (TextUtils.isEmpty(appAID)) {
            return -3;
        }
        if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(14, setDefaultCardRequestParams, iTsmCallback);
            }
            String m560b = m560b(appAID);
            SetDefaultCardRequestParams setDefaultCardRequestParams2 = new SetDefaultCardRequestParams();
            setDefaultCardRequestParams2.setAppAID(m560b);
            String reserve = setDefaultCardRequestParams.getReserve();
            if (!TextUtils.isEmpty(reserve)) {
                setDefaultCardRequestParams2.setReserve(m560b(reserve));
            }
            try {
                int defaultCard = this.f23569e.setDefaultCard(setDefaultCardRequestParams2, new BinderC4503b(this, 14, this.f23564Z[14], (byte) 0));
                if (-2 == defaultCard) {
                    return m577a(14, setDefaultCardRequestParams, iTsmCallback);
                }
                if (defaultCard == 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23543E;
                    int[] iArr = this.f23564Z;
                    int i2 = iArr[14];
                    iArr[14] = i2 + 1;
                    hashMap.put(String.valueOf(i2), iTsmCallback);
                }
                return defaultCard;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams) throws RemoteException {
        int i;
        if (safetyKeyboardRequestParams == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(32, safetyKeyboardRequestParams, null);
            }
            String reserve = safetyKeyboardRequestParams.getReserve();
            if (this.f23572h) {
                reserve = m551g(m552f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                safetyKeyboardRequestParams.setReserve(m560b(reserve));
            }
            try {
                int safetyKeyboardBitmap = this.f23569e.setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
                if (-2 == safetyKeyboardBitmap) {
                    return m577a(32, safetyKeyboardRequestParams, null);
                }
                return safetyKeyboardBitmap;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int setSamsungDefaultWallet(SetSamsungDefWalletRequestParams setSamsungDefWalletRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i;
        if (iTsmCallback == null) {
            i = -3;
        } else if (!m559c()) {
            i = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m577a(30, setSamsungDefWalletRequestParams, iTsmCallback);
            }
            SetSamsungDefWalletRequestParams setSamsungDefWalletRequestParams2 = new SetSamsungDefWalletRequestParams();
            if (setSamsungDefWalletRequestParams != null) {
                String reserve = setSamsungDefWalletRequestParams.getReserve();
                if (!TextUtils.isEmpty(reserve)) {
                    setSamsungDefWalletRequestParams2.setReserve(m560b(reserve));
                }
            }
            this.f23549K.put(String.valueOf(this.f23564Z[30]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f23569e;
                int[] iArr = this.f23564Z;
                int i2 = iArr[30];
                iArr[30] = i2 + 1;
                int samsungDefaultWallet = iTsmService.setSamsungDefaultWallet(setSamsungDefWalletRequestParams2, new BinderC4503b(this, 30, i2, (byte) 0));
                if (samsungDefaultWallet != 0) {
                    HashMap<String, ITsmCallback> hashMap = this.f23549K;
                    int[] iArr2 = this.f23564Z;
                    int i3 = iArr2[30] - 1;
                    iArr2[30] = i3;
                    hashMap.remove(String.valueOf(i3));
                }
                if (-2 == samsungDefaultWallet) {
                    return m577a(30, setSamsungDefWalletRequestParams, iTsmCallback);
                }
                return samsungDefaultWallet;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) throws RemoteException {
        int i2;
        if (safetyKeyboardRequestParams == null || i < 2000 || i > 2001) {
            i2 = -3;
        } else if (!m559c()) {
            i2 = -8;
        } else if (this.f23569e != null) {
            if (!m565a(this.f23567c.getPackageName())) {
                return m575a(1000, safetyKeyboardRequestParams, i, onSafetyKeyboardCallback, context);
            }
            this.f23563Y.put(this.f23567c.getPackageName(), new BinderC4504a(context));
            String reserve = safetyKeyboardRequestParams.getReserve();
            if (this.f23572h) {
                reserve = m551g(m552f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                safetyKeyboardRequestParams.setReserve(m560b(reserve));
            }
            try {
                int showSafetyKeyboard = this.f23569e.showSafetyKeyboard(safetyKeyboardRequestParams, i, onSafetyKeyboardCallback, new BinderC4502a());
                if (showSafetyKeyboard != 0) {
                    this.f23563Y.remove(this.f23567c.getPackageName());
                }
                if (-2 == showSafetyKeyboard) {
                    return m575a(1000, safetyKeyboardRequestParams, i, onSafetyKeyboardCallback, context);
                }
                return showSafetyKeyboard;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            i2 = -1;
        }
        return i2;
    }

    public void unbind() {
        ServiceConnection serviceConnection = this.f23568d;
        if (serviceConnection == null || !this.f23570f) {
            return;
        }
        this.f23567c.unbindService(serviceConnection);
        this.f23570f = false;
    }
}
