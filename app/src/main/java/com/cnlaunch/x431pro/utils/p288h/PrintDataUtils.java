package com.cnlaunch.x431pro.utils.p288h;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.diagnosemodule.bean.BasicCombineMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NetPOSPrinterUtil;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagnoseRunningInfo;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.utils.h.b */
/* loaded from: classes.dex */
public final class PrintDataUtils {
    /* renamed from: a */
    public static <T> String m4933a(Context context, ArrayList<T> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        if (arrayList.get(0) instanceof BasicSelectMenuBean) {
            while (i < arrayList.size()) {
                stringBuffer.append(((BasicSelectMenuBean) arrayList.get(i)).getTitle() + "\n");
                i++;
            }
        } else if (arrayList.get(0) instanceof BasicFaultCodeBean) {
            while (i < arrayList.size()) {
                BasicFaultCodeBean basicFaultCodeBean = (BasicFaultCodeBean) arrayList.get(i);
                if (basicFaultCodeBean.getContext().equals("CONSULT HANDBOOK")) {
                    basicFaultCodeBean.setContext(context.getString(R.string.diagnose_consult_handbook));
                }
                stringBuffer.append(basicFaultCodeBean.getTitle() + "  " + basicFaultCodeBean.getContext() + "  " + basicFaultCodeBean.getStatus() + "\n");
                i++;
            }
        } else if (arrayList.get(0) instanceof BasicSystemStatusBean) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                BasicSystemStatusBean basicSystemStatusBean = (BasicSystemStatusBean) arrayList.get(i2);
                stringBuffer.append(basicSystemStatusBean.getSystemName() + "\n");
                ArrayList<BasicFaultCodeBean> systemFaultCodeBean = basicSystemStatusBean.getSystemFaultCodeBean();
                for (int i3 = 0; i3 < systemFaultCodeBean.size(); i3++) {
                    BasicFaultCodeBean basicFaultCodeBean2 = systemFaultCodeBean.get(i3);
                    if (basicFaultCodeBean2.getContext().equals("CONSULT HANDBOOK")) {
                        basicFaultCodeBean2.setContext(context.getString(R.string.diagnose_consult_handbook));
                    }
                    stringBuffer.append(basicFaultCodeBean2.getTitle() + "  " + basicFaultCodeBean2.getContext() + "  " + basicFaultCodeBean2.getStatus() + "\n");
                }
            }
        } else if (arrayList.get(0) instanceof BasicDataStreamBean) {
            while (i < arrayList.size()) {
                BasicDataStreamBean basicDataStreamBean = (BasicDataStreamBean) arrayList.get(i);
                String title = TextUtils.isEmpty(basicDataStreamBean.getTranslation_title()) ? basicDataStreamBean.getTitle() : basicDataStreamBean.getTranslation_title();
                stringBuffer.append(title + "  " + basicDataStreamBean.getValue() + "  " + basicDataStreamBean.getStandardvalue() + "  " + basicDataStreamBean.getUnit() + "\n");
                i++;
            }
        } else if (arrayList.get(0) instanceof BasicCombineMenuBean) {
            while (i < arrayList.size()) {
                BasicCombineMenuBean basicCombineMenuBean = (BasicCombineMenuBean) arrayList.get(i);
                stringBuffer.append(basicCombineMenuBean.getTitle() + "  " + basicCombineMenuBean.getValue() + "\n");
                i++;
            }
        } else if (arrayList.get(0) instanceof BasicMenuBean) {
            while (i < arrayList.size()) {
                stringBuffer.append(((BasicMenuBean) arrayList.get(i)).getTitle() + "\n");
                i++;
            }
        } else if (arrayList.get(0) instanceof BasicSpeciaFunctionBean) {
            while (i < arrayList.size()) {
                stringBuffer.append(((BasicSpeciaFunctionBean) arrayList.get(i)).getTitle() + "\n");
                i++;
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static int m4935a(Context context, String str) {
        Log.d("weixingtai", String.valueOf(str));
        Bitmap a = NetPOSPrinterUtilPro.m9436a(NetPOSPrinterUtilPro.m9433b(context), NetPOSPrinterUtil.m9434a(str));
        if (PreferencesManager.m9595a(context).m9583b(C1947h.f10555g, false)) {
            return NetPOSPrinterUtilPro.m9435a(a, PreferencesManager.m9595a(context).m9591a(C1947h.f10554f));
        }
        return NetPOSPrinterUtilPro.m9438a(context, a);
    }

    /* renamed from: a */
    public static String m4932a(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            PdfReader pdfReader = new PdfReader(str);
            PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(pdfReader);
            int numberOfPages = pdfReader.getNumberOfPages();
            for (int i = 1; i <= numberOfPages; i++) {
                sb.append(((TextExtractionStrategy) pdfReaderContentParser.processContent(i, new SimpleTextExtractionStrategy())).getResultantText());
            }
            pdfReader.close();
        } catch (IOException e) {
            Log.e("EE", "readpdf error");
            e.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static int m4931b(Context context, String str) {
        String m4932a = m4932a(str);
        if (TextUtils.isEmpty(m4932a)) {
            return 3;
        }
        return m4935a(context, m4932a);
    }

    /* renamed from: a */
    public static int m4934a(Context context, String str, DiagnoseRunningInfo diagnoseRunningInfo) {
        Bitmap a = NetPOSPrinterUtilPro.m9436a(NetPOSPrinterUtilPro.m9440a(context), NetPOSPrinterUtilPro.m4936a(context, str, diagnoseRunningInfo));
        if (PreferencesManager.m9595a(context).m9583b(C1947h.f10555g, false)) {
            return NetPOSPrinterUtilPro.m9435a(a, PreferencesManager.m9595a(context).m9591a(C1947h.f10554f));
        }
        return NetPOSPrinterUtilPro.m9438a(context, a);
    }
}
