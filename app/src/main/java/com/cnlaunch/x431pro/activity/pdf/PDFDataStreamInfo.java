package com.cnlaunch.x431pro.activity.pdf;

import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.cnlaunch.x431pro.activity.pdf.b */
/* loaded from: classes.dex */
public final class PDFDataStreamInfo extends PDFBaseInfo implements Serializable {
    public ArrayList<BasicDataStreamBean> dataStreamList = null;
    public HashMap<HashMap<String, Integer>, Integer> mapDataStreamID2ChoiceUnit;
}
