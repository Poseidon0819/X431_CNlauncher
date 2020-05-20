package com.unionpay.mobile.android.pboctransaction;

import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.ResultCode;
import java.util.HashMap;

/* renamed from: com.unionpay.mobile.android.pboctransaction.f */
/* loaded from: classes2.dex */
final class C4265f extends HashMap<String, String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C4265f() {
        put("0156", Constant.KEY_CURRENCYTYPE_CNY);
        put(ResultCode.ERROR_DETAIL_TRANS_MESSAGE_NOT_MODIFIED, Constant.KEY_CURRENCYTYPE_AUD);
        put("0978", Constant.KEY_CURRENCYTYPE_EUR);
        put("0826", Constant.KEY_CURRENCYTYPE_GBP);
        put("0356", Constant.KEY_CURRENCYTYPE_INR);
        put("0392", Constant.KEY_CURRENCYTYPE_JPY);
        put("0410", Constant.KEY_CURRENCYTYPE_KRW);
        put("0840", Constant.KEY_CURRENCYTYPE_USD);
    }
}
