package com.cnlaunch.x431pro.activity.pdf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.pdf.d */
/* loaded from: classes.dex */
public final class PDFReportsUtils {

    /* renamed from: a */
    private PdfPCell f14427a;

    /* renamed from: b */
    private PdfPTable f14428b;

    /* renamed from: g */
    private Rectangle f14433g;

    /* renamed from: h */
    private Document f14434h;

    /* renamed from: i */
    private Font f14435i;

    /* renamed from: j */
    private Font f14436j;

    /* renamed from: k */
    private Font f14437k;

    /* renamed from: l */
    private Font f14438l;

    /* renamed from: m */
    private Font f14439m;

    /* renamed from: n */
    private Font f14440n;

    /* renamed from: v */
    private Font f14448v;

    /* renamed from: c */
    private boolean f14429c = false;

    /* renamed from: d */
    private boolean f14430d = false;

    /* renamed from: e */
    private BaseFont f14431e = null;

    /* renamed from: f */
    private String f14432f = "";

    /* renamed from: o */
    private int f14441o = 12;

    /* renamed from: p */
    private int f14442p = 14;

    /* renamed from: q */
    private float f14443q = 0.92f;

    /* renamed from: r */
    private float f14444r = 0.96f;

    /* renamed from: s */
    private Bitmap f14445s = null;

    /* renamed from: t */
    private boolean f14446t = false;

    /* renamed from: u */
    private int f14447u = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;

    /* renamed from: w */
    private int f14449w = 0;

    /* renamed from: x */
    private int f14450x = 0;

    /* renamed from: a */
    private static String m6049a(Context context, String str) {
        try {
            Properties properties = new Properties();
            InputStream open = context.getAssets().open("config.properties");
            if (open != null) {
                properties.load(open);
                return properties.getProperty(str);
            }
            return "";
        } catch (IOException e) {
            Log.e("XEE", "err2:" + e.toString());
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private boolean m6053a(Context context) {
        this.f14447u = C2744aa.m5158d(context);
        this.f14446t = Boolean.valueOf(m6049a(context, "is_show_odo")).booleanValue();
        String m5131o = C2744aa.m5131o();
        if (m5131o.equalsIgnoreCase("ES")) {
            this.f14430d = true;
        }
        if (m5131o.equalsIgnoreCase("AR") || m5131o.equalsIgnoreCase("FA")) {
            this.f14430d = true;
            this.f14429c = true;
        }
        if (m5131o.equalsIgnoreCase("CS")) {
            this.f14430d = true;
        }
        if (this.f14430d) {
            this.f14432f = context.getResources().getString(R.raw.cour);
        } else {
            this.f14432f = context.getResources().getString(R.raw.droidsansfallback);
        }
        try {
            this.f14431e = BaseFont.createFont(this.f14432f, BaseFont.IDENTITY_H, false);
            this.f14433g = new Rectangle(PageSize.f19601A4);
            this.f14434h = new Document(this.f14433g, 20.0f, 20.0f, 20.0f, 20.0f);
            this.f14435i = new Font(this.f14431e, this.f14441o, 0);
            this.f14435i.setColor(BaseColor.BLACK);
            this.f14436j = new Font(this.f14431e, this.f14441o, 1);
            this.f14436j.setColor(BaseColor.BLACK);
            this.f14437k = new Font(this.f14431e, this.f14441o, 0);
            this.f14437k.setColor(BaseColor.RED);
            this.f14438l = new Font(this.f14431e, this.f14441o, 0);
            this.f14438l.setColor(BaseColor.GREEN);
            this.f14439m = new Font(this.f14431e, this.f14441o, 1);
            this.f14439m.setColor(BaseColor.BLACK);
            this.f14440n = new Font(this.f14431e, this.f14442p, 1);
            this.f14440n.setColor(BaseColor.BLACK);
            this.f14448v = new Font(this.f14431e, this.f14441o, 0);
            this.f14448v.setColor(BaseColor.GRAY);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("XEE", "err1:" + e.toString());
            return false;
        }
    }

    /* renamed from: a */
    private PdfPCell m6046a(String str, Font font) {
        this.f14427a = new PdfPCell(new Paragraph(str, font));
        this.f14427a.setBorder(0);
        if (this.f14429c) {
            this.f14427a.setRunDirection(3);
        }
        return this.f14427a;
    }

    /* renamed from: b */
    private PdfPCell m6043b(String str, Font font) {
        this.f14427a = new PdfPCell(new Paragraph(str, font));
        this.f14427a.setBorder(0);
        this.f14427a.setVerticalAlignment(5);
        if (this.f14429c) {
            this.f14427a.setRunDirection(3);
        }
        return this.f14427a;
    }

    /* renamed from: c */
    private PdfPCell m6040c(String str, Font font) {
        this.f14427a = new PdfPCell(new Paragraph(str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, font));
        this.f14427a.setBorder(0);
        this.f14427a.setHorizontalAlignment(0);
        this.f14427a.setVerticalAlignment(5);
        this.f14427a.setBackgroundColor(BaseColor.LIGHT_GRAY);
        this.f14427a.setGrayFill(this.f14443q);
        this.f14427a.setFixedHeight(30.0f);
        if (this.f14429c) {
            this.f14427a.setRunDirection(3);
        }
        return this.f14427a;
    }

    /* renamed from: a */
    private PdfPTable m6047a(Bitmap bitmap, int i) {
        Image image;
        float width = bitmap.getWidth();
        float f = width / i;
        int i2 = (int) (width / f);
        int height = (int) (bitmap.getHeight() / f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        try {
            image = Image.getInstance(byteArrayOutputStream.toByteArray());
        } catch (BadElementException e) {
            e.printStackTrace();
            image = null;
            image.setAlignment(1);
            image.scaleAbsolute(i2, height);
            PdfPTable pdfPTable = new PdfPTable(1);
            this.f14427a = new PdfPCell(image);
            this.f14427a.setHorizontalAlignment(1);
            this.f14427a.setVerticalAlignment(5);
            this.f14427a.setBorder(0);
            pdfPTable.addCell(this.f14427a);
            return pdfPTable;
        } catch (IOException e2) {
            e2.printStackTrace();
            image = null;
            image.setAlignment(1);
            image.scaleAbsolute(i2, height);
            PdfPTable pdfPTable2 = new PdfPTable(1);
            this.f14427a = new PdfPCell(image);
            this.f14427a.setHorizontalAlignment(1);
            this.f14427a.setVerticalAlignment(5);
            this.f14427a.setBorder(0);
            pdfPTable2.addCell(this.f14427a);
            return pdfPTable2;
        }
        image.setAlignment(1);
        image.scaleAbsolute(i2, height);
        PdfPTable pdfPTable22 = new PdfPTable(1);
        this.f14427a = new PdfPCell(image);
        this.f14427a.setHorizontalAlignment(1);
        this.f14427a.setVerticalAlignment(5);
        this.f14427a.setBorder(0);
        pdfPTable22.addCell(this.f14427a);
        return pdfPTable22;
    }

    /* renamed from: a */
    private boolean m6052a(Context context, PDFBaseInfo pDFBaseInfo) {
        try {
            PdfWriter.getInstance(this.f14434h, new FileOutputStream(pDFBaseInfo.pdfFileName));
            this.f14434h.open();
            if (!C2744aa.m5128p(context)) {
                Boolean bool = Boolean.TRUE;
                if (this.f14429c) {
                    this.f14434h.addSubject("Arabic");
                } else {
                    this.f14434h.addSubject("Launch");
                }
                this.f14428b = new PdfPTable(1);
                this.f14428b.setWidthPercentage(100.0f);
                this.f14427a = m6046a(pDFBaseInfo.strRepairType, this.f14448v);
                this.f14427a.setHorizontalAlignment(0);
                this.f14427a.setBackgroundColor(BaseColor.LIGHT_GRAY);
                this.f14427a.setGrayFill(this.f14443q);
                this.f14428b.addCell(this.f14427a);
                this.f14434h.add(this.f14428b);
                PdfPTable pdfPTable = new PdfPTable(1);
                pdfPTable.setWidthPercentage(100.0f);
                PdfPCell pdfPCell = new PdfPCell(new Paragraph(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + pDFBaseInfo.title + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, this.f14436j));
                pdfPCell.setBorder(0);
                pdfPCell.setHorizontalAlignment(1);
                pdfPCell.setVerticalAlignment(5);
                pdfPCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                pdfPCell.setGrayFill(this.f14443q);
                pdfPCell.setFixedHeight(30.0f);
                if (this.f14429c) {
                    pdfPCell.setRunDirection(3);
                }
                pdfPTable.addCell(pdfPCell);
                this.f14434h.add(pdfPTable);
                this.f14428b = new PdfPTable(2);
                this.f14428b.setWidthPercentage(100.0f);
                this.f14428b.setWidths(new float[]{0.25f, 0.75f});
                this.f14445s = m6048a(context, pDFBaseInfo.report_logo_path, 70);
                PdfPCell pdfPCell2 = new PdfPCell(m6047a(this.f14445s, 70));
                pdfPCell2.setBorder(0);
                pdfPCell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                pdfPCell2.setHorizontalAlignment(0);
                pdfPCell2.setVerticalAlignment(5);
                pdfPCell2.setGrayFill(this.f14443q);
                this.f14428b.addCell(pdfPCell2);
                PdfPTable pdfPTable2 = new PdfPTable(1);
                pdfPTable2.addCell(m6046a(pDFBaseInfo.strShopName, this.f14435i));
                pdfPTable2.addCell(m6046a(pDFBaseInfo.strAddr, this.f14435i));
                pdfPTable2.addCell(m6046a(pDFBaseInfo.strPhone, this.f14435i));
                pdfPTable2.addCell(m6046a(pDFBaseInfo.strEmail, this.f14435i));
                PdfPCell pdfPCell3 = new PdfPCell(pdfPTable2);
                pdfPCell3.setBorder(0);
                pdfPCell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                pdfPCell3.setGrayFill(this.f14443q);
                this.f14428b.addCell(pdfPCell3);
                this.f14434h.add(this.f14428b);
                this.f14428b = new PdfPTable(1);
                this.f14428b.setWidthPercentage(100.0f);
                if (this.f14429c) {
                    this.f14428b.setRunDirection(3);
                }
                if (!TextUtils.isEmpty(pDFBaseInfo.strCarUserName)) {
                    this.f14428b.addCell(m6046a(pDFBaseInfo.strCarUserName, this.f14435i));
                }
                if (!TextUtils.isEmpty(pDFBaseInfo.diagnose_report_platenumber)) {
                    this.f14428b.addCell(m6046a(pDFBaseInfo.diagnose_report_platenumber, this.f14435i));
                }
                this.f14428b.addCell(m6046a(pDFBaseInfo.strCarVin, this.f14435i));
                this.f14428b.addCell(m6046a(pDFBaseInfo.strCarYear, this.f14435i));
                this.f14428b.addCell(m6046a(pDFBaseInfo.strcarType, this.f14435i));
                this.f14428b.addCell(m6046a(pDFBaseInfo.strCarMode, this.f14435i));
                if (this.f14446t) {
                    this.f14428b.addCell(m6046a(pDFBaseInfo.strODO, this.f14435i));
                }
                if (!C2744aa.m5166c()) {
                    this.f14428b.addCell(m6046a(pDFBaseInfo.strCarVer, this.f14435i));
                    this.f14428b.addCell(m6046a(pDFBaseInfo.strApkVer, this.f14435i));
                }
                this.f14428b.addCell(m6046a(pDFBaseInfo.strTime, this.f14435i));
                if (!TextUtils.isEmpty(pDFBaseInfo.strTester)) {
                    this.f14428b.addCell(m6046a(pDFBaseInfo.strTester, this.f14435i));
                }
                this.f14428b.addCell(m6046a(pDFBaseInfo.strPath, this.f14435i));
                this.f14434h.add(this.f14428b);
                return true;
            }
            this.f14428b = new PdfPTable(2);
            this.f14428b.setWidths(new float[]{4.0f, 8.0f});
            this.f14428b.setWidthPercentage(100.0f);
            this.f14445s = m6048a(context, pDFBaseInfo.report_logo_path, 80);
            this.f14427a = new PdfPCell(m6047a(this.f14445s, 80));
            this.f14427a.setBorder(0);
            this.f14427a.setHorizontalAlignment(0);
            this.f14427a.setVerticalAlignment(5);
            if (this.f14429c) {
                this.f14427a.setRunDirection(3);
            }
            this.f14427a.setPadding(context.getResources().getDimension(R.dimen.dp_5));
            this.f14428b.addCell(this.f14427a);
            PdfPTable pdfPTable3 = new PdfPTable(1);
            pdfPTable3.addCell(m6046a(Html.fromHtml(pDFBaseInfo.strShopName).toString(), this.f14435i));
            pdfPTable3.addCell(m6046a(pDFBaseInfo.strAddr, this.f14435i));
            pdfPTable3.addCell(m6046a(pDFBaseInfo.strPhone, this.f14435i));
            pdfPTable3.addCell(m6046a(pDFBaseInfo.strEmail, this.f14435i));
            this.f14427a = new PdfPCell(pdfPTable3);
            this.f14427a.setBorder(0);
            this.f14427a.setPadding(context.getResources().getDimension(R.dimen.dp_5));
            this.f14428b.addCell(this.f14427a);
            this.f14434h.add(this.f14428b);
            Boolean bool2 = Boolean.FALSE;
            if (this.f14429c) {
                this.f14434h.addSubject("Arabic");
            } else {
                this.f14434h.addSubject("Launch");
            }
            if (!TextUtils.isEmpty(pDFBaseInfo.title)) {
                Paragraph paragraph = new Paragraph();
                paragraph.setAlignment(1);
                paragraph.add((Element) new Chunk(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + pDFBaseInfo.title + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, this.f14440n));
                paragraph.setSpacingBefore(5.0f);
                paragraph.setSpacingAfter(10.0f);
                this.f14434h.add(paragraph);
            }
            m6045b(context);
            this.f14428b = new PdfPTable(3);
            this.f14428b.setWidths(new float[]{20.0f, 20.0f, 10.0f});
            this.f14428b.setWidthPercentage(100.0f);
            PdfPTable pdfPTable4 = new PdfPTable(1);
            pdfPTable4.addCell(m6046a(pDFBaseInfo.strCarYear + pDFBaseInfo.strCarMode + pDFBaseInfo.strcarType, this.f14435i));
            pdfPTable4.addCell(m6046a(pDFBaseInfo.strCarVin, this.f14435i));
            pdfPTable4.addCell(m6046a(pDFBaseInfo.strEngineSize, this.f14435i));
            if (this.f14446t) {
                pdfPTable4.addCell(m6046a(pDFBaseInfo.strODO, this.f14435i));
            }
            pdfPTable4.addCell(m6046a(pDFBaseInfo.diagnose_report_platenumber, this.f14435i));
            this.f14427a = new PdfPCell(pdfPTable4);
            this.f14427a.setPadding(context.getResources().getDimension(R.dimen.dp_5));
            this.f14427a.setBorder(0);
            this.f14428b.addCell(this.f14427a);
            PdfPTable pdfPTable5 = new PdfPTable(1);
            pdfPTable5.addCell(m6046a(pDFBaseInfo.strRepairType, this.f14435i));
            if (this.f14450x != 0) {
                pdfPTable5.addCell(m6046a("Found Codes in " + this.f14449w + " of " + this.f14450x + " systems", this.f14435i));
            }
            pdfPTable5.addCell(m6046a(pDFBaseInfo.strTime, this.f14435i));
            pdfPTable5.addCell(m6046a(pDFBaseInfo.strTester, this.f14435i));
            this.f14427a = new PdfPCell(pdfPTable5);
            this.f14427a.setBorder(0);
            this.f14427a.setPadding(context.getResources().getDimension(R.dimen.dp_10));
            this.f14428b.addCell(this.f14427a);
            this.f14445s = m6048a(context, pDFBaseInfo.strSelectImagePath, 80);
            this.f14427a = new PdfPCell(m6047a(this.f14445s, 80));
            this.f14427a.setBorder(0);
            this.f14427a.setHorizontalAlignment(0);
            this.f14427a.setVerticalAlignment(5);
            if (this.f14429c) {
                this.f14427a.setRunDirection(3);
            }
            this.f14427a.setPadding(context.getResources().getDimension(R.dimen.dp_10));
            this.f14428b.addCell(this.f14427a);
            this.f14434h.add(this.f14428b);
            return true;
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private void m6045b(Context context) throws DocumentException {
        this.f14428b = new PdfPTable(1);
        this.f14428b.setWidthPercentage(100.0f);
        this.f14445s = m6042c(context);
        this.f14427a = new PdfPCell(m6047a(this.f14445s, 1000));
        this.f14427a.setBorder(0);
        this.f14427a.setFixedHeight(20.0f);
        this.f14427a.setVerticalAlignment(5);
        this.f14428b.addCell(this.f14427a);
        this.f14434h.add(this.f14428b);
    }

    /* renamed from: b */
    private void m6044b(Context context, PDFBaseInfo pDFBaseInfo) throws DocumentException {
        this.f14428b = new PdfPTable(1);
        this.f14428b.setWidthPercentage(100.0f);
        this.f14428b.setSpacingBefore(20.0f);
        PdfPCell m6046a = m6046a(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + context.getString(R.string.report_symptoms_title), this.f14439m);
        m6046a.setBorder(15);
        m6046a.setBorderColor(new BaseColor(221, 229, 240));
        m6046a.setHorizontalAlignment(0);
        m6046a.setPadding(context.getResources().getDimension(R.dimen.dp_5));
        this.f14428b.addCell(m6046a);
        this.f14434h.add(this.f14428b);
        String[] split = pDFBaseInfo.strSymptoms.split(Html.fromHtml("<br>").toString());
        this.f14428b = new PdfPTable(split.length);
        this.f14428b.setWidthPercentage(100.0f);
        for (String str : split) {
            this.f14427a = m6046a(str, this.f14435i);
            this.f14427a.setBorder(15);
            this.f14427a.setBorderColor(new BaseColor(221, 229, 240));
            this.f14427a.setUseAscender(true);
            this.f14427a.setVerticalAlignment(5);
            this.f14427a.setPadding(context.getResources().getDimension(R.dimen.dp_10));
            this.f14428b.addCell(this.f14427a);
        }
        this.f14434h.add(this.f14428b);
    }

    /* renamed from: c */
    private void m6041c(Context context, PDFBaseInfo pDFBaseInfo) throws DocumentException {
        this.f14428b = new PdfPTable(1);
        this.f14428b.setWidthPercentage(100.0f);
        PdfPTable pdfPTable = new PdfPTable(1);
        pdfPTable.addCell(m6046a(pDFBaseInfo.strRemark, this.f14435i));
        this.f14427a = new PdfPCell(pdfPTable);
        this.f14427a.setBorder(0);
        this.f14427a.setPaddingTop(context.getResources().getDimension(R.dimen.dp_10));
        this.f14427a.setPaddingBottom(context.getResources().getDimension(R.dimen.dp_10));
        this.f14428b.addCell(this.f14427a);
        this.f14434h.add(this.f14428b);
    }

    /* JADX WARN: Removed duplicated region for block: B:192:0x08db  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x08e0  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x08f0  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x08f5  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x08fb  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m6050a(android.content.Context r18, com.cnlaunch.x431pro.activity.pdf.PDFFaultCodeReportInfo r19) {
        /*
            Method dump skipped, instructions count: 2305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.pdf.PDFReportsUtils.m6050a(android.content.Context, com.cnlaunch.x431pro.activity.pdf.c):boolean");
    }

    /* renamed from: a */
    public final boolean m6051a(Context context, PDFDataStreamInfo pDFDataStreamInfo, int i) {
        boolean z = false;
        if (pDFDataStreamInfo != null && m6053a(context)) {
            new Font(this.f14431e, this.f14441o, 0).setColor(BaseColor.WHITE);
            try {
            } catch (Exception unused) {
                this.f14434h.close();
                Bitmap bitmap = this.f14445s;
                if (bitmap != null) {
                    bitmap.recycle();
                }
            } catch (Throwable th) {
                this.f14434h.close();
                Bitmap bitmap2 = this.f14445s;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                throw th;
            }
            if (!m6052a(context, pDFDataStreamInfo)) {
                this.f14434h.close();
                Bitmap bitmap3 = this.f14445s;
                if (bitmap3 != null) {
                    bitmap3.recycle();
                }
                return false;
            }
            this.f14428b = new PdfPTable(1);
            this.f14428b.setWidthPercentage(100.0f);
            PdfPTable pdfPTable = this.f14428b;
            pdfPTable.addCell(m6046a(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + context.getString(R.string.read_data_stream), this.f14435i));
            this.f14434h.add(this.f14428b);
            this.f14428b = new PdfPTable(1);
            this.f14428b.setWidthPercentage(100.0f);
            this.f14427a = new PdfPCell(new Paragraph("", this.f14435i));
            this.f14427a.setBorder(0);
            this.f14427a.setFixedHeight(15.0f);
            this.f14428b.addCell(this.f14427a);
            this.f14434h.add(this.f14428b);
            this.f14428b = new PdfPTable(i == 1 ? 4 : 3);
            this.f14428b.setWidthPercentage(100.0f);
            this.f14428b.setWidths(i == 1 ? new float[]{0.3f, 0.23f, 0.24f, 0.23f} : new float[]{0.4f, 0.4f, 0.2f});
            PdfPTable pdfPTable2 = this.f14428b;
            pdfPTable2.addCell(m6040c(context.getString(R.string.tv_datastream_title), this.f14436j));
            PdfPTable pdfPTable3 = this.f14428b;
            pdfPTable3.addCell(m6040c(context.getString(R.string.tv_datastream_value), this.f14436j));
            if (i == 1) {
                PdfPTable pdfPTable4 = this.f14428b;
                pdfPTable4.addCell(m6040c(context.getString(R.string.tv_datastream_stand_value), this.f14436j));
            }
            PdfPTable pdfPTable5 = this.f14428b;
            pdfPTable5.addCell(m6040c(context.getString(R.string.tv_datastream_unit), this.f14436j));
            Font font = this.f14435i;
            BasicDataStreamBean.currconversionType = C2744aa.m5158d(context);
            if (pDFDataStreamInfo.mapDataStreamID2ChoiceUnit != null) {
                BasicDataStreamBean.mapDataStreamID2ChoiceUnit = pDFDataStreamInfo.mapDataStreamID2ChoiceUnit;
            }
            if (pDFDataStreamInfo.dataStreamList != null && pDFDataStreamInfo.dataStreamList.size() > 0) {
                Iterator<BasicDataStreamBean> it = pDFDataStreamInfo.dataStreamList.iterator();
                while (it.hasNext()) {
                    BasicDataStreamBean next = it.next();
                    BasicDataStreamBean.currconversionType = this.f14447u;
                    if (!TextUtils.isEmpty(next.getValuestatus())) {
                        font = "0".equalsIgnoreCase(next.getValuestatus()) ? this.f14435i : this.f14437k;
                    }
                    PdfPTable pdfPTable6 = this.f14428b;
                    pdfPTable6.addCell(m6043b(next.getTranslation_title(), font));
                    PdfPTable pdfPTable7 = this.f14428b;
                    pdfPTable7.addCell(m6043b(next.getValue(), font));
                    if (i == 1) {
                        PdfPTable pdfPTable8 = this.f14428b;
                        pdfPTable8.addCell(m6043b(next.getStandardvalue(), font));
                    }
                    PdfPTable pdfPTable9 = this.f14428b;
                    pdfPTable9.addCell(m6043b(next.getUnit(), font));
                }
            }
            this.f14427a = new PdfPCell(this.f14428b);
            this.f14427a.setBorderColor(BaseColor.LIGHT_GRAY);
            this.f14427a.setPaddingBottom(20.0f);
            PdfPTable pdfPTable10 = new PdfPTable(1);
            pdfPTable10.setWidthPercentage(100.0f);
            pdfPTable10.addCell(this.f14427a);
            this.f14434h.add(pdfPTable10);
            if (C2744aa.m5128p(context)) {
                m6044b(context, pDFDataStreamInfo);
                m6041c(context, pDFDataStreamInfo);
            } else if (!TextUtils.isEmpty(pDFDataStreamInfo.strRemark)) {
                this.f14428b = new PdfPTable(1);
                this.f14428b.setWidthPercentage(100.0f);
                this.f14428b.addCell(m6046a(pDFDataStreamInfo.strRemark, this.f14435i));
                this.f14434h.add(this.f14428b);
            }
            this.f14434h.close();
            Bitmap bitmap4 = this.f14445s;
            if (bitmap4 != null) {
                bitmap4.recycle();
            }
            z = true;
            if (!z) {
                FileUtils.m5000d(pDFDataStreamInfo.pdfFileName);
            }
            return z;
        }
        return false;
    }

    /* renamed from: a */
    private static Bitmap m6048a(Context context, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (new File(str).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inJustDecodeBounds = false;
                int i2 = options.outWidth / i;
                if (i2 <= 0) {
                    i2 = 1;
                }
                options.inSampleSize = i2;
                return BitmapFactory.decodeFile(str, options);
            }
            return ((BitmapDrawable) context.getResources().getDrawable(R.drawable.u2_normal)).getBitmap();
        }
        return ((BitmapDrawable) context.getResources().getDrawable(R.drawable.u2_normal)).getBitmap();
    }

    /* renamed from: c */
    private static Bitmap m6042c(Context context) {
        return ((BitmapDrawable) context.getResources().getDrawable(R.drawable.report_line)).getBitmap();
    }
}
