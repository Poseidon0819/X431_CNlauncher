package com.unionpay.tsmservice;

import android.content.Context;
import android.os.RemoteException;
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

/* loaded from: classes2.dex */
public class SessionKeyReExchange {

    /* renamed from: a */
    private UPTsmAddon f23528a;

    /* renamed from: b */
    private int f23529b;

    /* renamed from: c */
    private RequestParams f23530c;

    /* renamed from: d */
    private ITsmCallback f23531d;

    /* renamed from: e */
    private ITsmProgressCallback f23532e;

    /* renamed from: f */
    private int f23533f;

    /* renamed from: g */
    private OnSafetyKeyboardCallback f23534g;

    /* renamed from: h */
    private Context f23535h;

    /* renamed from: i */
    private int f23536i;

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, ITsmCallback iTsmCallback) {
        this(uPTsmAddon, i, null, iTsmCallback);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback) {
        this(uPTsmAddon, i, requestParams, iTsmCallback, null);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        this(uPTsmAddon, i, requestParams, iTsmCallback, iTsmProgressCallback, 1000);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback, int i2) {
        this.f23529b = -1;
        this.f23533f = 1000;
        this.f23528a = uPTsmAddon;
        this.f23529b = i;
        this.f23530c = requestParams;
        this.f23531d = iTsmCallback;
        this.f23532e = iTsmProgressCallback;
        this.f23533f = i2;
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i2, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) {
        this.f23529b = -1;
        this.f23533f = 1000;
        this.f23528a = uPTsmAddon;
        this.f23529b = i;
        this.f23536i = i2;
        this.f23530c = safetyKeyboardRequestParams;
        this.f23534g = onSafetyKeyboardCallback;
        this.f23535h = context;
    }

    public int reExchangeKey() throws RemoteException {
        String[] strArr = new String[1];
        int pubKey = this.f23528a.getPubKey(1000, strArr);
        if (pubKey != 0) {
            return pubKey;
        }
        int exchangeKey = this.f23528a.exchangeKey(IUPJniInterface.rER(strArr[0], IUPJniInterface.mSK()), strArr);
        if (exchangeKey != 0) {
            return exchangeKey;
        }
        String dMG = IUPJniInterface.dMG(strArr[0], this.f23528a.getCryptType());
        IUPJniInterface.sSK(dMG);
        Context context = this.f23528a.getContext();
        if (context != null) {
            IUPJniInterface.uSKT(context.getPackageName(), dMG);
        }
        int i = this.f23529b;
        if (i == 1000) {
            return this.f23528a.showSafetyKeyboard((SafetyKeyboardRequestParams) this.f23530c, this.f23536i, this.f23534g, this.f23535h);
        }
        switch (i) {
            case 0:
                return this.f23528a.init((InitRequestParams) this.f23530c, this.f23531d);
            case 1:
                return this.f23528a.getAssociatedApp((GetAssociatedAppRequestParams) this.f23530c, this.f23531d);
            case 2:
                return this.f23528a.getAppList((GetAppListRequestParams) this.f23530c, this.f23531d);
            case 3:
                return this.f23528a.getSEAppList((GetSeAppListRequestParams) this.f23530c, this.f23531d);
            case 4:
                return this.f23528a.getAppDetail((GetAppDetailRequestParams) this.f23530c, this.f23531d);
            case 5:
                return this.f23528a.getAppStatus((GetAppStatusRequestParams) this.f23530c, this.f23531d);
            case 6:
                return this.f23528a.getCardInfo((GetCardInfoRequestParams) this.f23530c, this.f23531d);
            case 7:
                return this.f23528a.getAccountInfo((GetAccountInfoRequestParams) this.f23530c, this.f23531d);
            case 8:
                return this.f23528a.getAccountBalance((GetAccountBalanceRequestParams) this.f23530c, this.f23531d);
            case 9:
                return this.f23528a.getTransElements((GetTransElementsRequestParams) this.f23530c, this.f23531d);
            case 10:
                return this.f23528a.getTransRecord((GetTransRecordRequestParams) this.f23530c, this.f23531d);
            case 11:
                return this.f23528a.getSMSAuthCode((GetSMSAuthCodeRequestParams) this.f23530c, this.f23531d);
            case 12:
                return this.f23528a.getSeId((GetSeIdRequestParams) this.f23530c, this.f23531d);
            case 13:
                return this.f23528a.getDefaultCard((GetDefaultCardRequestParams) this.f23530c, this.f23531d);
            case 14:
                return this.f23528a.setDefaultCard((SetDefaultCardRequestParams) this.f23530c, this.f23531d);
            case 15:
                return this.f23528a.appDownloadApply((AppDownloadApplyRequestParams) this.f23530c, this.f23531d);
            case 16:
                return this.f23528a.appDownload((AppDownloadRequestParams) this.f23530c, this.f23531d, this.f23532e);
            case 17:
                return this.f23528a.appDelete((AppDeleteRequestParams) this.f23530c, this.f23531d, this.f23532e);
            case 18:
                return this.f23528a.appDataUpdate((AppDataUpdateRequestParams) this.f23530c, this.f23531d, this.f23532e);
            case 19:
                return this.f23528a.eCashTopUp((ECashTopUpRequestParams) this.f23530c, this.f23531d);
            case 20:
                return this.f23528a.openChannel((OpenChannelRequestParams) this.f23530c, this.f23531d);
            case 21:
                return this.f23528a.closeChannel((CloseChannelRequestParams) this.f23530c, this.f23531d);
            case 22:
                return this.f23528a.sendApdu((SendApduRequestParams) this.f23530c, this.f23531d);
            case 23:
                return this.f23528a.encryptData((EncryptDataRequestParams) this.f23530c, this.f23531d);
            case 24:
                return this.f23528a.hideAppApply((HideAppApplyRequestParams) this.f23530c, this.f23531d);
            case 25:
                return this.f23528a.executeCmd((ExecuteCmdRequestParams) this.f23530c, this.f23531d, this.f23532e);
            case 26:
                return this.f23528a.appLock((AppLockRequestParams) this.f23530c, this.f23531d);
            case 27:
                return this.f23528a.appUnlock((AppUnlockRequestParams) this.f23530c, this.f23531d);
            case 28:
                return this.f23528a.getCardInfoBySamsungPay((GetCardInfoBySpayRequestParams) this.f23530c, this.f23531d);
            case 29:
                return this.f23528a.checkSSamsungPay((CheckSSamsungPayRequestParams) this.f23530c, this.f23531d);
            case 30:
                return this.f23528a.setSamsungDefaultWallet((SetSamsungDefWalletRequestParams) this.f23530c, this.f23531d);
            case 31:
                return this.f23528a.getEncryptData((GetEncryptDataRequestParams) this.f23530c, this.f23531d);
            case 32:
                return this.f23528a.setSafetyKeyboardBitmap((SafetyKeyboardRequestParams) this.f23530c);
            case 33:
                return this.f23528a.clearEncryptData(this.f23536i);
            case 34:
                return this.f23528a.hideKeyboard();
            case 35:
                return this.f23528a.cardListStatusChanged((CardListStatusChangedRequestParams) this.f23530c, this.f23531d);
            case 36:
                return this.f23528a.getVendorPayStatus((GetVendorPayStatusRequestParams) this.f23530c, this.f23531d);
            case 37:
                return this.f23528a.activateVendorPay((ActivateVendorPayRequestParams) this.f23530c, this.f23531d);
            case 38:
                return this.f23528a.addCardToVendorPay((AddCardToVendorPayRequestParams) this.f23530c, this.f23531d, this.f23532e);
            case 39:
                return this.f23528a.onlinePaymentVerify((OnlinePaymentVerifyRequestParams) this.f23530c, this.f23531d);
            case 40:
                return this.f23528a.preDownload((PreDownloadRequestParams) this.f23530c, this.f23531d, this.f23532e);
            case 41:
                return this.f23528a.queryVendorPayStatus((QueryVendorPayStatusRequestParams) this.f23530c, this.f23531d);
            case 42:
                return this.f23528a.acquireSEAppList((AcquireSEAppListRequestParams) this.f23530c, this.f23531d);
            case 43:
                return this.f23528a.getTransactionDetails((GetTransactionDetailsRequestParams) this.f23530c, this.f23531d);
            case 44:
                return this.f23528a.getMessageDetails((GetMessageDetailsRequestParams) this.f23530c, this.f23531d);
            case 45:
                return this.f23528a.sendCustomData((SendCustomDataRequestParams) this.f23530c, this.f23531d);
            case 46:
                return this.f23528a.createSSD((UniteRequestParams) this.f23530c, this.f23531d);
            default:
                return 0;
        }
    }
}
