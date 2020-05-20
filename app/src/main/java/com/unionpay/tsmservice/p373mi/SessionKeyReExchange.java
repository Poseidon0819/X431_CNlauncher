package com.unionpay.tsmservice.p373mi;

import android.content.Context;
import com.unionpay.tsmservice.p373mi.request.AcquireSEAppListRequestParams;
import com.unionpay.tsmservice.p373mi.request.AddCardToVendorPayRequestParams;
import com.unionpay.tsmservice.p373mi.request.CardListStatusChangedRequestParams;
import com.unionpay.tsmservice.p373mi.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.p373mi.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.p373mi.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.p373mi.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.p373mi.request.InitRequestParams;
import com.unionpay.tsmservice.p373mi.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.p373mi.request.PayResultNotifyRequestParams;
import com.unionpay.tsmservice.p373mi.request.PinRequestRequestParams;
import com.unionpay.tsmservice.p373mi.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.p373mi.request.RequestParams;
import com.unionpay.tsmservice.p373mi.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.p373mi.utils.IUPJniInterface;

/* renamed from: com.unionpay.tsmservice.mi.SessionKeyReExchange */
/* loaded from: classes2.dex */
public class SessionKeyReExchange {

    /* renamed from: a */
    private UPTsmAddon f23606a;

    /* renamed from: b */
    private int f23607b;

    /* renamed from: c */
    private RequestParams f23608c;

    /* renamed from: d */
    private ITsmCallback f23609d;

    /* renamed from: e */
    private ITsmProgressCallback f23610e;

    /* renamed from: f */
    private int f23611f;

    /* renamed from: g */
    private OnSafetyKeyboardCallback f23612g;

    /* renamed from: h */
    private Context f23613h;

    /* renamed from: i */
    private int f23614i;

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, ITsmCallback iTsmCallback) {
        this(uPTsmAddon, i, null, iTsmCallback);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback) {
        this(uPTsmAddon, i, requestParams, iTsmCallback, 1000);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback, int i2) {
        this.f23607b = -1;
        this.f23611f = 1000;
        this.f23606a = uPTsmAddon;
        this.f23607b = i;
        this.f23608c = requestParams;
        this.f23609d = iTsmCallback;
        this.f23611f = i2;
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        this(uPTsmAddon, i, requestParams, iTsmCallback, iTsmProgressCallback, 1000);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback, int i2) {
        this.f23607b = -1;
        this.f23611f = 1000;
        this.f23606a = uPTsmAddon;
        this.f23607b = i;
        this.f23608c = requestParams;
        this.f23609d = iTsmCallback;
        this.f23610e = iTsmProgressCallback;
        this.f23611f = i2;
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i2, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) {
        this.f23607b = -1;
        this.f23611f = 1000;
        this.f23606a = uPTsmAddon;
        this.f23607b = i;
        this.f23614i = i2;
        this.f23608c = safetyKeyboardRequestParams;
        this.f23612g = onSafetyKeyboardCallback;
        this.f23613h = context;
    }

    public int reExchangeKey() {
        String[] strArr = new String[1];
        int pubKey = this.f23606a.getPubKey(1000, strArr);
        if (pubKey != 0) {
            return pubKey;
        }
        int exchangeKey = this.f23606a.exchangeKey(IUPJniInterface.rER(strArr[0], IUPJniInterface.mSK()), strArr);
        if (exchangeKey != 0) {
            return exchangeKey;
        }
        String dMG = IUPJniInterface.dMG(strArr[0]);
        IUPJniInterface.sSK(dMG);
        Context context = this.f23606a.getContext();
        if (context != null) {
            IUPJniInterface.uSKT(context.getPackageName(), dMG);
        }
        int i = this.f23607b;
        if (i == 1000) {
            return this.f23606a.showSafetyKeyboard((SafetyKeyboardRequestParams) this.f23608c, this.f23614i, this.f23612g, this.f23613h);
        }
        switch (i) {
            case 0:
                return this.f23606a.init((InitRequestParams) this.f23608c, this.f23609d);
            case 1:
                return this.f23606a.encryptData((EncryptDataRequestParams) this.f23608c, this.f23609d);
            case 2:
                return this.f23606a.getEncryptData((GetEncryptDataRequestParams) this.f23608c, this.f23609d);
            case 3:
                return this.f23606a.setSafetyKeyboardBitmap((SafetyKeyboardRequestParams) this.f23608c);
            case 4:
                return this.f23606a.clearEncryptData(this.f23614i);
            case 5:
                return this.f23606a.hideKeyboard();
            case 6:
                return this.f23606a.acquireSEAppList((AcquireSEAppListRequestParams) this.f23608c, this.f23609d);
            case 7:
                return this.f23606a.cardListStatusChanged((CardListStatusChangedRequestParams) this.f23608c, this.f23609d);
            case 8:
                return this.f23606a.queryVendorPayStatus((QueryVendorPayStatusRequestParams) this.f23608c, this.f23609d);
            case 9:
                return this.f23606a.getVendorPayStatus((GetVendorPayStatusRequestParams) this.f23608c, this.f23609d);
            case 10:
                return this.f23606a.onlinePaymentVerify((OnlinePaymentVerifyRequestParams) this.f23608c, this.f23609d);
            case 11:
                return this.f23606a.pinRequest((PinRequestRequestParams) this.f23608c, this.f23609d);
            case 12:
                return this.f23606a.payResultNotify((PayResultNotifyRequestParams) this.f23608c, this.f23609d);
            case 13:
                return this.f23606a.cancelPay();
            case 14:
                return this.f23606a.getVendorPayStatusForBankApp((GetVendorPayStatusRequestParams) this.f23608c, this.f23609d);
            case 15:
                return this.f23606a.getSeId((GetSeIdRequestParams) this.f23608c, this.f23609d);
            case 16:
                return this.f23606a.addCardToVendorPay((AddCardToVendorPayRequestParams) this.f23608c, this.f23609d, this.f23610e);
            default:
                return 0;
        }
    }
}
