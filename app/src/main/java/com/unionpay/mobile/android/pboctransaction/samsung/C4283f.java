package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.pboctransaction.C4263d;
import com.unionpay.mobile.android.pboctransaction.C4264e;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4262c;
import com.unionpay.mobile.android.utils.C4385f;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.data.Amount;
import com.unionpay.tsmservice.request.CloseChannelRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoBySpayRequestParams;
import com.unionpay.tsmservice.request.GetSeAppListRequestParams;
import com.unionpay.tsmservice.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.pboctransaction.samsung.f */
/* loaded from: classes2.dex */
public final class C4283f implements InterfaceC4262c {

    /* renamed from: C */
    private GetVendorPayStatusRequestParams f22784C;

    /* renamed from: H */
    private InitRequestParams f22789H;

    /* renamed from: I */
    private SendApduRequestParams f22790I;

    /* renamed from: k */
    private Context f22802k;

    /* renamed from: l */
    private InterfaceC4261b f22803l;

    /* renamed from: m */
    private InterfaceC4284a f22804m;

    /* renamed from: n */
    private UPTsmAddon f22805n;

    /* renamed from: a */
    String f22792a = "19999741583305435775450371903957622252895007857586703985696530069777024392884287211670048223494223356836139331264745305488035196420545843046674853984852305228918004888414759300445308845681087472809487791392726663269247999482633231304479943902981311338709709401000108625221857486530967716878328228310703650408575058288784573884262229674701501842066793928002725038356122707147929560460157457327696696471785787505023643000687928051333648369477362945785046976181683285277919023274376124429148429078602516462345014971452220809120399264066736558357572250447243744965533695780751271768398207631002867947152625578881506566297";

    /* renamed from: b */
    String f22793b = "65537";

    /* renamed from: c */
    String f22794c = "5929703506495688276130676968213384164609348882017291684789802337394713840702726472221198819456433069055388915357817202968369194525956730949539025096963015440180443916974948318765778051794088998339276397676916425744003507605582286608745438301704836361482343765671805403004194772735755889141443700570750608527755694790475628670051863813384800013641474007746161600969180035295709344887092512089121125289090881005234379649440422346798246278284328310221953743757037875834557694749810951089453346522229122216198442376081589767583019062954875861469699069474707285206935898628020341168773624455554331118138151051364372906861";

    /* renamed from: d */
    String f22795d = "UnionPay";

    /* renamed from: i */
    private final String f22800i = "A0000003334355502D4D4F42494C45";

    /* renamed from: j */
    private final int f22801j = 10000;

    /* renamed from: o */
    private Handler f22806o = null;

    /* renamed from: p */
    private int f22807p = 0;

    /* renamed from: q */
    private final int f22808q = 8;

    /* renamed from: r */
    private boolean f22809r = false;

    /* renamed from: s */
    private String f22810s = "-1";

    /* renamed from: t */
    private String f22811t = "";

    /* renamed from: u */
    private boolean f22812u = false;

    /* renamed from: v */
    private String f22813v = null;

    /* renamed from: w */
    private boolean f22814w = false;

    /* renamed from: x */
    private String f22815x = "";

    /* renamed from: y */
    private String f22816y = "-1";

    /* renamed from: z */
    private String f22817z = "-1";

    /* renamed from: A */
    private String f22782A = "";

    /* renamed from: B */
    private String f22783B = "";

    /* renamed from: e */
    String f22796e = "";

    /* renamed from: f */
    boolean f22797f = false;

    /* renamed from: g */
    boolean f22798g = false;

    /* renamed from: h */
    boolean f22799h = false;

    /* renamed from: D */
    private long f22785D = 8000;

    /* renamed from: E */
    private boolean f22786E = false;

    /* renamed from: F */
    private final Handler.Callback f22787F = new C4285g(this);

    /* renamed from: G */
    private final Handler f22788G = new Handler(this.f22787F);

    /* renamed from: J */
    private final UPTsmAddon.UPTsmConnectionListener f22791J = new C4286h(this);

    /* renamed from: com.unionpay.mobile.android.pboctransaction.samsung.f$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4284a {
        /* renamed from: a */
        void mo1214a(boolean z);
    }

    public C4283f(InterfaceC4284a interfaceC4284a) {
        this.f22804m = interfaceC4284a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1266a(C4283f c4283f, int i, String str) {
        if (i == 1000) {
            c4283f.m1262a(false);
            return;
        }
        if (i != 1018) {
            switch (i) {
                case 1011:
                    C4390k.m836c("uppay", "open channel fail");
                    c4283f.f22810s = null;
                    c4283f.f22811t = "";
                    c4283f.f22809r = true;
                    return;
                case 1012:
                    C4390k.m836c("uppay", "apdu fail");
                    c4283f.f22788G.removeMessages(3);
                    c4283f.f22812u = true;
                    return;
                case 1013:
                    C4390k.m836c("uppay", "close channel fail");
                    c4283f.f22814w = true;
                    return;
                case 1014:
                    c4283f.f22806o.sendMessage(c4283f.f22788G.obtainMessage(8, null));
                    return;
                case 1015:
                    C4390k.m836c("uppay-spay", "get spay list call back");
                    c4283f.f22806o.sendMessage(c4283f.f22806o.obtainMessage(2001, str));
                    return;
                case 1016:
                    break;
                default:
                    return;
            }
        }
        C4390k.m836c("uppay-spay", "check spay support fail");
        c4283f.f22804m.mo1214a(false);
    }

    /* renamed from: a */
    private void m1263a(String str, String str2) {
        this.f22790I = new SendApduRequestParams();
        this.f22790I.setChannel(str2);
        this.f22790I.setHexApdu(str);
        if (this.f22797f) {
            this.f22790I.setReserve(m1248g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1262a(boolean z) {
        InterfaceC4261b interfaceC4261b = this.f22803l;
        if (interfaceC4261b != null) {
            if (z) {
                interfaceC4261b.mo1206a();
            } else {
                interfaceC4261b.mo1205b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ boolean m1257c(C4283f c4283f) {
        c4283f.f22812u = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m1250f() {
        if (this.f22789H == null) {
            this.f22789H = new InitRequestParams();
            if (this.f22797f) {
                this.f22789H.setSignature(m1248g());
                this.f22789H.setReserve(m1248g());
            }
        }
        try {
            int init = this.f22805n.init(this.f22789H, new BinderC4282e(1000, this.f22788G));
            if (init != 0) {
                this.f22788G.sendMessage(Message.obtain(this.f22788G, 1, 1000, 0, ""));
            } else {
                this.f22788G.sendMessageDelayed(Message.obtain(this.f22788G, 4, 1000, 0, ""), this.f22785D);
            }
            C4390k.m836c("uppay", "ret = ".concat(String.valueOf(init)));
        } catch (RemoteException e) {
            m1262a(false);
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private String m1248g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("signature", this.f22796e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final String mo1236a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        this.f22811t = "";
        this.f22809r = false;
        try {
            OpenChannelRequestParams openChannelRequestParams = new OpenChannelRequestParams();
            openChannelRequestParams.setAppAID(str);
            if (this.f22797f) {
                openChannelRequestParams.setReserve(m1248g());
            }
            if (this.f22805n.openChannel(openChannelRequestParams, new BinderC4282e(1011, this.f22788G)) != 0) {
                this.f22788G.sendMessage(Message.obtain(this.f22788G, 1, 1011, 0, ""));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        while (TextUtils.isEmpty(this.f22811t) && !this.f22809r) {
        }
        if ("A0000003334355502D4D4F42494C45".equals(str)) {
            this.f22816y = this.f22810s;
        } else {
            this.f22817z = this.f22810s;
        }
        this.f22809r = false;
        return this.f22811t;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final ArrayList<InterfaceC4174c> mo1238a(C4263d c4263d) {
        if (this.f22805n != null) {
            try {
                if (C4173b.f22368aB && C4173b.f22367aA && C4173b.f22374bo) {
                    GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams = new GetCardInfoBySpayRequestParams();
                    Amount amount = new Amount();
                    amount.setProductPrice(this.f22782A);
                    String m1297e = C4264e.m1297e(this.f22783B);
                    if (!TextUtils.isEmpty(m1297e)) {
                        amount.setCurrencyType(m1297e);
                    }
                    getCardInfoBySpayRequestParams.setAmount(amount);
                    if (this.f22797f) {
                        getCardInfoBySpayRequestParams.setReserve(m1248g());
                    }
                    int cardInfoBySamsungPay = this.f22805n.getCardInfoBySamsungPay(getCardInfoBySpayRequestParams, new BinderC4282e(1015, this.f22788G));
                    if (cardInfoBySamsungPay != 0) {
                        this.f22788G.sendMessage(Message.obtain(this.f22788G, 1, 1015, 0, ""));
                    } else {
                        this.f22788G.sendMessageDelayed(Message.obtain(this.f22788G, 4, 1015, 0, ""), 8000L);
                    }
                    C4390k.m836c("uppay", "readList: ".concat(String.valueOf(cardInfoBySamsungPay)));
                } else {
                    GetSeAppListRequestParams getSeAppListRequestParams = new GetSeAppListRequestParams();
                    if (this.f22797f) {
                        getSeAppListRequestParams.setReserve(m1248g());
                    }
                    if (this.f22805n.getSEAppList(getSeAppListRequestParams, new BinderC4282e(1014, this.f22788G)) != 0) {
                        this.f22788G.sendMessage(Message.obtain(this.f22788G, 1, 1014, 0, ""));
                    } else {
                        this.f22788G.sendMessageDelayed(Message.obtain(this.f22788G, 4, 1014, 0, ""), this.f22785D);
                    }
                }
            } catch (RemoteException e) {
                m1262a(false);
                e.printStackTrace();
            } catch (Exception e2) {
                m1262a(false);
                e2.printStackTrace();
            }
            C4390k.m836c("uppay", "readList");
            return null;
        }
        return null;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final void mo1241a() {
        UPTsmAddon uPTsmAddon = this.f22805n;
        if (uPTsmAddon != null) {
            uPTsmAddon.removeConnectionListener(this.f22791J);
            this.f22805n.unbind();
        }
    }

    /* renamed from: a */
    public final void m1268a(Handler handler) {
        this.f22806o = handler;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    public final void mo1239a(InterfaceC4261b interfaceC4261b, Context context) {
        this.f22803l = interfaceC4261b;
        this.f22802k = context;
        try {
            this.f22796e = C4278a.m1273a(KeyFactory.getInstance("RSA").generatePrivate(new RSAPrivateKeySpec(new BigInteger(this.f22792a), new BigInteger(this.f22794c))), this.f22795d);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e2) {
            e2.printStackTrace();
        }
        if (C4173b.f22372bm) {
            this.f22785D = 60000L;
        }
        this.f22797f = !"com.unionpay.uppay".equals(C4385f.m869b(this.f22802k));
        this.f22805n = UPTsmAddon.getInstance(context);
        if (!this.f22798g) {
            this.f22805n.addConnectionListener(this.f22791J);
            this.f22798g = true;
        }
        C4390k.m836c("uppay-spay", "type se  bind service");
        UPTsmAddon uPTsmAddon = this.f22805n;
        if (uPTsmAddon != null && !uPTsmAddon.isConnected()) {
            C4390k.m836c("uppay", "bind service");
            if (this.f22805n.bind()) {
                return;
            }
            m1262a(false);
            return;
        }
        UPTsmAddon uPTsmAddon2 = this.f22805n;
        if (uPTsmAddon2 == null || !uPTsmAddon2.isConnected()) {
            return;
        }
        C4390k.m836c("uppay", "tem service already connected");
        if (this.f22799h) {
            m1262a(true);
        } else {
            m1250f();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(1:3)(10:(1:26)|5|6|(1:8)|10|(1:11)|16|(1:18)|19|20)|4|5|6|(0)|10|(2:13|(1:11))|22|16|(0)|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0054, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
        r7.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0046 A[Catch: RemoteException -> 0x0054, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x0054, blocks: (B:8:0x0033, B:10:0x0046), top: B:24:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] mo1234a(byte[] r7, int r8) {
        /*
            r6 = this;
            r0 = 0
            r6.f22813v = r0
            r1 = 0
            r6.f22812u = r1
            java.lang.String r2 = "uppay"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "--->"
            r3.<init>(r4)
            java.lang.String r4 = com.unionpay.mobile.android.pboctransaction.C4264e.m1302a(r7)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.unionpay.mobile.android.utils.C4390k.m838a(r2, r3)
            r2 = 1
            if (r8 != 0) goto L2a
            java.lang.String r7 = com.unionpay.mobile.android.pboctransaction.C4264e.m1302a(r7)
            java.lang.String r8 = r6.f22817z
        L26:
            r6.m1263a(r7, r8)
            goto L33
        L2a:
            if (r8 != r2) goto L33
            java.lang.String r7 = com.unionpay.mobile.android.pboctransaction.C4264e.m1302a(r7)
            java.lang.String r8 = r6.f22816y
            goto L26
        L33:
            com.unionpay.tsmservice.UPTsmAddon r7 = r6.f22805n     // Catch: android.os.RemoteException -> L54
            com.unionpay.tsmservice.request.SendApduRequestParams r8 = r6.f22790I     // Catch: android.os.RemoteException -> L54
            com.unionpay.mobile.android.pboctransaction.samsung.e r3 = new com.unionpay.mobile.android.pboctransaction.samsung.e     // Catch: android.os.RemoteException -> L54
            android.os.Handler r4 = r6.f22788G     // Catch: android.os.RemoteException -> L54
            r5 = 1012(0x3f4, float:1.418E-42)
            r3.<init>(r5, r4)     // Catch: android.os.RemoteException -> L54
            int r7 = r7.sendApdu(r8, r3)     // Catch: android.os.RemoteException -> L54
            if (r7 == 0) goto L58
            android.os.Handler r7 = r6.f22788G     // Catch: android.os.RemoteException -> L54
            android.os.Handler r8 = r6.f22788G     // Catch: android.os.RemoteException -> L54
            java.lang.String r3 = ""
            android.os.Message r8 = android.os.Message.obtain(r8, r2, r5, r1, r3)     // Catch: android.os.RemoteException -> L54
            r7.sendMessage(r8)     // Catch: android.os.RemoteException -> L54
            goto L58
        L54:
            r7 = move-exception
            r7.printStackTrace()
        L58:
            android.os.Handler r7 = r6.f22788G
            r8 = 3
            android.os.Message r8 = android.os.Message.obtain(r7, r8)
            r2 = 10000(0x2710, double:4.9407E-320)
            r7.sendMessageDelayed(r8, r2)
        L64:
            java.lang.String r7 = r6.f22813v
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L70
            boolean r7 = r6.f22812u
            if (r7 == 0) goto L64
        L70:
            java.lang.String r7 = "uppay"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r2 = "mApduResult: "
            r8.<init>(r2)
            java.lang.String r2 = r6.f22813v
            r8.append(r2)
            java.lang.String r2 = ",mApduReturn:"
            r8.append(r2)
            boolean r2 = r6.f22812u
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            com.unionpay.mobile.android.utils.C4390k.m838a(r7, r8)
            java.lang.String r7 = r6.f22813v
            if (r7 == 0) goto La6
            byte[] r0 = com.unionpay.mobile.android.pboctransaction.C4264e.m1305a(r7)
            java.lang.String r7 = "uppay"
            java.lang.String r8 = "ret1 <---"
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r8 = r8.concat(r2)
            com.unionpay.mobile.android.utils.C4390k.m838a(r7, r8)
        La6:
            java.lang.String r7 = "uppay"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r2 = "<---"
            r8.<init>(r2)
            java.lang.String r2 = r6.f22813v
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            com.unionpay.mobile.android.utils.C4390k.m838a(r7, r8)
            r6.f22812u = r1
            java.lang.String r7 = "uppay"
            java.lang.String r8 = "ret2 <---"
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r8 = r8.concat(r1)
            com.unionpay.mobile.android.utils.C4390k.m838a(r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.pboctransaction.samsung.C4283f.mo1234a(byte[], int):byte[]");
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: b */
    public final void mo1233b() {
    }

    /* renamed from: b */
    public final void m1258b(String str) {
        this.f22782A = str;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: c */
    public final void mo1230c() {
        String str = this.f22816y;
        if (str != null && !"-1".equals(str)) {
            this.f22815x = "";
            this.f22814w = false;
            try {
                CloseChannelRequestParams closeChannelRequestParams = new CloseChannelRequestParams();
                closeChannelRequestParams.setChannel(this.f22816y);
                if (this.f22797f) {
                    closeChannelRequestParams.setReserve(m1248g());
                }
                if (this.f22805n.closeChannel(closeChannelRequestParams, new BinderC4282e(1013, this.f22788G)) != 0) {
                    this.f22788G.sendMessage(Message.obtain(this.f22788G, 1, 1013, 0, ""));
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            while (TextUtils.isEmpty(this.f22815x) && !this.f22814w) {
            }
            this.f22816y = "-1";
            this.f22814w = false;
        }
        String str2 = this.f22817z;
        if (str2 == null || "-1".equals(str2)) {
            return;
        }
        this.f22815x = "";
        this.f22814w = false;
        try {
            CloseChannelRequestParams closeChannelRequestParams2 = new CloseChannelRequestParams();
            closeChannelRequestParams2.setChannel(this.f22817z);
            if (this.f22797f) {
                closeChannelRequestParams2.setReserve(m1248g());
            }
            if (this.f22805n.closeChannel(closeChannelRequestParams2, new BinderC4282e(1013, this.f22788G)) != 0) {
                this.f22788G.sendMessage(Message.obtain(this.f22788G, 1, 1013, 0, ""));
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        while (TextUtils.isEmpty(this.f22815x) && !this.f22814w) {
        }
        this.f22817z = "-1";
        this.f22814w = false;
    }

    /* renamed from: c */
    public final void m1255c(String str) {
        this.f22783B = str;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4262c
    /* renamed from: d */
    public final void mo1229d() {
    }

    /* renamed from: e */
    public final boolean m1252e() {
        try {
            C4390k.m836c("uppay", "getVendorPayStatus()");
            if (this.f22784C == null) {
                this.f22784C = new GetVendorPayStatusRequestParams();
                if (this.f22797f) {
                    this.f22784C.setReserve(m1248g());
                }
            }
            if (this.f22805n.getVendorPayStatus(this.f22784C, new BinderC4282e(1018, this.f22788G)) != 0) {
                this.f22788G.sendMessage(Message.obtain(this.f22788G, 1, 1018, 0, ""));
                return false;
            }
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
