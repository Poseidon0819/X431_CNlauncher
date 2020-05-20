package com.cnlaunch.x431pro.utils.p282d;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.cnlaunch.x431pro.utils.p283db.DiagReportOrHistoryDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.SDCardDBManager;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* compiled from: ReportDBUtils.java */
/* renamed from: com.cnlaunch.x431pro.utils.d.f */
/* loaded from: classes.dex */
public final class C2752f {
    /* renamed from: a */
    public static long m5070a(Context context, DiagReportOrHistoryInfo diagReportOrHistoryInfo) {
        if (diagReportOrHistoryInfo == null) {
            return -1L;
        }
        return SDCardDBManager.m5030a(context.getApplicationContext()).f15817a.f15821a.insertOrReplace(diagReportOrHistoryInfo);
    }

    /* renamed from: a */
    public static void m5071a(Context context, long j) {
        SDCardDBManager.m5030a(context.getApplicationContext()).f15817a.f15821a.deleteByKey(Long.valueOf(j));
    }

    /* renamed from: a */
    public static List<DiagReportOrHistoryInfo> m5072a(Context context, int i, String str, String str2, String str3, String str4) {
        boolean z;
        int i2;
        List<DiagReportOrHistoryInfo> m5069b = m5069b(context, i, str, str2, str3, str4);
        if (i == -1 && C2787z.m4821a(str) && C2787z.m4821a(str2) && C2787z.m4821a(str3) && C2787z.m4821a(str4)) {
            List<DiagReportOrHistoryInfo> m5073a = m5073a();
            if (!m5073a.isEmpty()) {
                z = false;
                for (int i3 = 0; i3 < m5073a.size(); i3++) {
                    while (true) {
                        if (i2 < m5069b.size()) {
                            i2 = new File(m5069b.get(i2).getPdfFileName()).getName().equals(new File(m5073a.get(i3).getPdfFileName()).getName()) ? 0 : i2 + 1;
                        } else {
                            m5069b.add(m5073a.get(i3));
                            z = true;
                            break;
                        }
                    }
                }
                if (z && m5069b != null && m5069b.size() > 0) {
                    Collections.sort(m5069b, new C2753g());
                }
                return m5069b;
            }
        }
        z = false;
        if (z) {
            Collections.sort(m5069b, new C2753g());
        }
        return m5069b;
    }

    /* renamed from: b */
    private static List<DiagReportOrHistoryInfo> m5069b(Context context, int i, String str, String str2, String str3, String str4) {
        Property property;
        String str5;
        Property property2;
        String str6;
        Property property3;
        String str7;
        Property property4;
        String str8;
        QueryBuilder<DiagReportOrHistoryInfo> queryBuilder = SDCardDBManager.m5030a(context.getApplicationContext()).f15817a.f15821a.queryBuilder();
        WhereCondition m317in = DiagReportOrHistoryDao.Properties.Type.m317in(2, 0, 3, 1);
        WhereCondition[] whereConditionArr = new WhereCondition[5];
        whereConditionArr[0] = i == -1 ? DiagReportOrHistoryDao.Properties.RepairType.m317in(0, 1, 2) : DiagReportOrHistoryDao.Properties.RepairType.m321eq(Integer.valueOf(i));
        if (C2787z.m4821a(str)) {
            property = DiagReportOrHistoryDao.Properties.StrCarVin;
            str5 = "%";
        } else {
            property = DiagReportOrHistoryDao.Properties.StrCarVin;
            str5 = "%" + str + "%";
        }
        whereConditionArr[1] = property.like(str5);
        if (C2787z.m4821a(str2)) {
            property2 = DiagReportOrHistoryDao.Properties.StrcarType;
            str6 = "%";
        } else {
            property2 = DiagReportOrHistoryDao.Properties.StrcarType;
            str6 = "%" + str2 + "%";
        }
        whereConditionArr[2] = property2.like(str6);
        if (C2787z.m4821a(str3)) {
            property3 = DiagReportOrHistoryDao.Properties.StrCarMode;
            str7 = "%";
        } else {
            property3 = DiagReportOrHistoryDao.Properties.StrCarMode;
            str7 = "%" + str3 + "%";
        }
        whereConditionArr[3] = property3.like(str7);
        if (C2787z.m4821a(str4)) {
            property4 = DiagReportOrHistoryDao.Properties.StrCustomer;
            str8 = "%";
        } else {
            property4 = DiagReportOrHistoryDao.Properties.StrCustomer;
            str8 = "%" + str4 + "%";
        }
        whereConditionArr[4] = property4.like(str8);
        List<DiagReportOrHistoryInfo> list = queryBuilder.where(m317in, whereConditionArr).orderDesc(DiagReportOrHistoryDao.Properties.StrTime).list();
        for (int size = list.size() - 1; size >= 0; size--) {
            DiagReportOrHistoryInfo diagReportOrHistoryInfo = list.get(size);
            String pdfFileName = diagReportOrHistoryInfo.getPdfFileName();
            if (C2787z.m4821a(pdfFileName) || !new File(pdfFileName).exists()) {
                list.remove(size);
                if (diagReportOrHistoryInfo.getId() != null) {
                    m5071a(context, diagReportOrHistoryInfo.getId().longValue());
                }
            }
        }
        for (int i2 = 0; i2 < list.size() - 1; i2++) {
            for (int size2 = list.size() - 1; size2 > i2; size2--) {
                if (list.get(size2).equals(list.get(i2))) {
                    list.remove(size2);
                }
            }
        }
        return list;
    }

    /* renamed from: a */
    private static List<DiagReportOrHistoryInfo> m5073a() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(PathUtils.m4855d()).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                if (name.endsWith(".pdf") && file.length() != 0) {
                    DiagReportOrHistoryInfo diagReportOrHistoryInfo = new DiagReportOrHistoryInfo();
                    diagReportOrHistoryInfo.setPdfFileName(file.getAbsolutePath());
                    diagReportOrHistoryInfo.setType(5);
                    String[] split = name.replace(".pdf", "").split("_");
                    if (split.length > 0) {
                        String str = split[split.length - 1];
                        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str) && str.length() == 14) {
                            diagReportOrHistoryInfo.setStrTime(split[split.length - 1].substring(0, 4) + "-" + split[split.length - 1].substring(4, 6) + "-" + split[split.length - 1].substring(6, 8) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + split[split.length - 1].substring(8, 10) + ":" + split[split.length - 1].substring(10, 12) + ":" + split[split.length - 1].substring(12, 14));
                            arrayList.add(diagReportOrHistoryInfo);
                        }
                    }
                    diagReportOrHistoryInfo.setStrTime(DateUtils.m5095a(file.lastModified()));
                    arrayList.add(diagReportOrHistoryInfo);
                }
            }
        }
        return arrayList;
    }
}
