package com.cnlaunch.x431pro.module.p255e.p257b;

import android.content.Context;
import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import com.cnlaunch.x431pro.utils.C2744aa;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.cnlaunch.x431pro.module.e.b.i */
/* loaded from: classes.dex */
public final class ReportFileInfo extends AbstractC2709c {
    private static final long serialVersionUID = -1604584234577915297L;
    private boolean check = false;
    private String reportName;
    private String reportSerialnumber;
    private Date reportTime;

    public final String getReportName() {
        return this.reportName;
    }

    public final String getStrcarType() {
        int indexOf = this.reportName.indexOf("_");
        return indexOf != -1 ? this.reportName.substring(0, indexOf) : "";
    }

    public final void setReportName(String str) {
        this.reportName = str;
    }

    public final String getReportSerialnumber() {
        return this.reportSerialnumber;
    }

    public final void setReportSerialnumber(String str) {
        this.reportSerialnumber = str;
    }

    public final Date getReportTime() {
        return this.reportTime;
    }

    public final String getReportTimeToString(Context context) {
        Locale locale;
        if (C2744aa.m5166c()) {
            locale = Locale.ENGLISH;
        } else {
            locale = Locale.getDefault();
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).format(this.reportTime);
    }

    public final void setReportTime(Date date) {
        this.reportTime = date;
    }

    public final boolean isCheck() {
        return this.check;
    }

    public final void setCheck(boolean z) {
        this.check = z;
    }

    public final String toString() {
        return "ReportFileInfo [reportName=" + this.reportName + ", reportSerialnumber=" + this.reportSerialnumber + ", reportTime=" + this.reportTime + "]";
    }
}
