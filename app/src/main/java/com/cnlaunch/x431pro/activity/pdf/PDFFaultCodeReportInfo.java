package com.cnlaunch.x431pro.activity.pdf;

import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import java.io.Serializable;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.pdf.c */
/* loaded from: classes.dex */
public final class PDFFaultCodeReportInfo extends PDFBaseInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public boolean bNeedSumSys;
    public boolean mIsSystemStatusCode;
    public String strCarLeft;
    public String strCarRight;
    public String strErrorCode;
    public String strErrorCodeNum;
    public String strErrorStatus;
    public String strNormalCode;
    public String strNormalCodeNum;
    public String strNormalStatus;
    public ArrayList<BasicFaultCodeBean> faultCodeList = null;
    public ArrayList<BasicSystemStatusBean> systemStatusList = null;
    public ArrayList<BasicSystemStatusBean> systemStatusList_err = null;
    public ArrayList<BasicSystemStatusBean> systemStatusList_normal = null;
}
