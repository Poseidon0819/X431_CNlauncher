package com.mopub.mobileads;

import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.mopub.common.Preconditions;

/* loaded from: classes.dex */
public enum VastErrorCode {
    XML_PARSING_ERROR(DiagnoseConstants.UI_TYPE_DIALOG),
    WRAPPER_TIMEOUT("301"),
    NO_ADS_VAST_RESPONSE("303"),
    GENERAL_LINEAR_AD_ERROR(DiagnoseConstants.UI_TYPE_BUTTON),
    GENERAL_COMPANION_AD_ERROR(DiagnoseConstants.UI_TYPE_ACTIVE_TEST),
    UNDEFINED_ERROR(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM);
    
    private final String mErrorCode;

    VastErrorCode(String str) {
        Preconditions.checkNotNull(str, "errorCode cannot be null");
        this.mErrorCode = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getErrorCode() {
        return this.mErrorCode;
    }
}
