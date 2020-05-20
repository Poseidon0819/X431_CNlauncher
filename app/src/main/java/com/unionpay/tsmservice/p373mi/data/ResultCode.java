package com.unionpay.tsmservice.p373mi.data;

import android.text.TextUtils;

/* renamed from: com.unionpay.tsmservice.mi.data.ResultCode */
/* loaded from: classes2.dex */
public class ResultCode {
    public static final String ERROR_DETAIL_DEFAULT = "0000";
    public static final String ERROR_DETAIL_FORCE_UPDATE = "0019";
    public static final String ERROR_DETAIL_NETWORK = "0001";
    public static final String ERROR_DETAIL_NFC_NOT_ENABLE = "0009";
    public static final String ERROR_DETAIL_NOT_SUPPORT = "0004";
    public static final String ERROR_DETAIL_NO_PERMISSION = "0003";
    public static final String ERROR_DETAIL_ONLINE_PAYMENT_CANCEL = "0029";
    public static final String ERROR_DETAIL_ONLINE_PAYMENT_OTHER_FAIL = "0032";
    public static final String ERROR_DETAIL_ONLINE_PAYMENT_TIMEOUT = "0030";
    public static final String ERROR_DETAIL_PIN_REQUEST_CANCEL = "0039";
    public static final String ERROR_DETAIL_PIN_REQUEST_MI_ERROR = "0037";
    public static final String ERROR_DETAIL_PIN_REQUEST_TSM_ERROR = "0038";
    public static final String ERROR_DETAIL_SE_SERVICE_CONNTECT = "0010";
    public static final String ERROR_DETAIL_SIGNATURE_INVALID = "0015";
    public static final String ERROR_DETAIL_UNKNOWN_HOST = "0002";
    public static final String ERROR_DETAIL_VENDOR_STATUS_NOT_INSTALL = "0035";
    public static final String ERROR_DETAIL_VENDOR_STATUS_NOT_READY = "0023";
    public static final String ERROR_DETAIL_VENDOR_STATUS_NOT_SUPPORTED = "0024";
    public static final String ERROR_DETAIL_VENDOR_STATUS_OTHER_FAIL = "0025";
    public static final String ERROR_DOWNLOAD_FILE = "10004";
    public static final String ERROR_INTERFACE_ACQUIRE_SE_APP_LIST = "10007";
    public static final String ERROR_INTERFACE_ADD_CARD_TO_VENDOR_PAY = "10008";
    public static final String ERROR_INTERFACE_ENCRYPT_DATA = "10004";
    public static final String ERROR_INTERFACE_EXCHANGE_KEY = "10003";
    public static final String ERROR_INTERFACE_GET_ENCRYPT_DATA = "10036";
    public static final String ERROR_INTERFACE_GET_PUBLIC_KEY = "10002";
    public static final String ERROR_INTERFACE_GET_SE_ID = "10005";
    public static final String ERROR_INTERFACE_GET_VENDOR_PAY_STATUS = "10037";
    public static final String ERROR_INTERFACE_INIT = "10001";
    public static final String ERROR_INTERFACE_ONLINE_PAYMENT_VERIFY = "10039";
    public static final String ERROR_INTERFACE_PAY_RESULT = "10046";
    public static final String ERROR_INTERFACE_PIN_REQUEST = "10045";
    public static final String ERROR_INTERFACE_RESULT_DECRYPT_FAIL = "10035";
    public static final String ERROR_INTERFACE_RESULT_ENCRYPT_FAIL = "10034";
    public static final String ERROR_LOCAL_BEGIN = "10000";
    public static final String ERROR_NETWORK = "10001";
    public static final String ERROR_RESPONSE_FORMAT = "10002";
    public static final String ERROR_SOURCE_ADDON = "0";
    public static final String ERROR_SOURCE_TSM = "1";
    public static final String ERROR_STORAGE_NOT_ENOUGHT = "10003";
    public static final String SUCCESS = "10000";

    public static String getResultCode(String str) {
        return !TextUtils.isEmpty(str) ? "0000".equals(str) ? "" : "10001".equals(str) ? "00001" : com.unionpay.tsmservice.data.ResultCode.ERROR_INTERFACE_APP_UNLOCK.equals(str) ? "00004" : com.unionpay.tsmservice.data.ResultCode.ERROR_INTERFACE_GET_CARD_INFO.equals(str) ? "00009" : com.unionpay.tsmservice.data.ResultCode.ERROR_INTERFACE_GET_TRANS_RECORD.equals(str) ? "00010" : ("10004".equals(str) || com.unionpay.tsmservice.data.ResultCode.ERROR_INTERFACE_GET_APP_DETAIL.equals(str) || com.unionpay.tsmservice.data.ResultCode.ERROR_INTERFACE_APP_LOCK.equals(str)) ? "00001" : com.unionpay.tsmservice.data.ResultCode.ERROR_INTERFACE_CLOSE_CHANNEL.equals(str) ? "00023" : com.unionpay.tsmservice.data.ResultCode.ERROR_INTERFACE_EXECUTE_CMD.equals(str) ? "00024" : com.unionpay.tsmservice.data.ResultCode.ERROR_INTERFACE_GET_CARDINFO_BY_SAMSUNGPAY.equals(str) ? "00035" : com.unionpay.tsmservice.data.ResultCode.ERROR_INTERFACE_CHECK_SSAMSUNGPAY.equals(str) ? "00025" : "10034".equals(str) ? "00029" : "10035".equals(str) ? "00030" : "10036".equals(str) ? "00032" : com.unionpay.tsmservice.data.ResultCode.ERROR_INTERFACE_ACTIVATE_VENDOR_PAY.equals(str) ? "00037" : str.startsWith("Mi") ? str : "1".concat(String.valueOf(str)) : "00000";
    }
}
