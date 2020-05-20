package com.cnlaunch.x431pro.module.rtu;

import android.content.Context;
import android.util.Log;
import com.cnlaunch.diagnosemodule.utils.DiagnoseLogUtil;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;

/* renamed from: com.cnlaunch.x431pro.module.rtu.i */
/* loaded from: classes.dex */
public final class ProductInformation {

    /* renamed from: a */
    public boolean f15696a;

    /* renamed from: b */
    public boolean f15697b;

    /* renamed from: c */
    public long f15698c;

    /* renamed from: d */
    public long f15699d;

    /* renamed from: e */
    public long f15700e;

    /* renamed from: f */
    public String f15701f;

    /* renamed from: g */
    public String f15702g;

    /* renamed from: h */
    private Context f15703h;

    public ProductInformation(Context context, String str) {
        this.f15696a = false;
        this.f15697b = true;
        this.f15698c = 0L;
        this.f15699d = 0L;
        this.f15700e = 0L;
        this.f15701f = "";
        this.f15703h = context;
        this.f15702g = "";
        File file = new File(PathUtils.m4858c() + File.separator + str + File.separator + "product_information.txt");
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                int length = (int) file.length();
                if (length <= 0) {
                    return;
                }
                byte[] bArr = new byte[length];
                byte[] bArr2 = new byte[length];
                if (fileInputStream.read(bArr, 0, length) > 0) {
                    DiagnoseLogUtil.SafeMatrix.decryptionContent(bArr, bArr2, length);
                    StringReader stringReader = new StringReader(new String(bArr2, "ISO-8859-1"));
                    Properties properties = new Properties();
                    properties.load(stringReader);
                    this.f15696a = Boolean.parseBoolean(properties.getProperty("tryFlag"));
                    this.f15697b = Boolean.parseBoolean(properties.getProperty("isFirstRun"));
                    this.f15698c = Long.parseLong(properties.getProperty("tryFlagStartTime"));
                    this.f15699d = Long.parseLong(properties.getProperty("lastRemindTime"));
                    this.f15700e = Long.parseLong(properties.getProperty("totalDiagTime"));
                    this.f15701f = properties.getProperty("diagTime_date");
                    this.f15702g = properties.getProperty("serialNo");
                    NLog.m9452b("ProductInformation", new String(bArr2, "ISO-8859-1") + "IsTryFlag=" + this.f15696a + "IsFirstRun=" + this.f15697b + "TryFlagStartTime=" + this.f15698c + "mLastRemindTime=" + this.f15699d + "mTotalDiagTime=" + this.f15700e + "mDiagTimeDate=" + this.f15701f);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m5198a(String str) {
        if ("".equals(this.f15702g) || this.f15702g.equals(str)) {
            this.f15702g = str;
        } else {
            Log.e("ProductInformation", "非法操作======");
        }
    }

    /* renamed from: b */
    public final void m5197b(String str) {
        String str2 = this.f15702g;
        if (str2 == null || "".equals(str2) || this.f15702g.equals(str)) {
            File m4999d = FileUtils.m4999d(PathUtils.m4858c() + File.separator + this.f15702g, "product_information.txt");
            if (m4999d == null) {
                return;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(m4999d);
                Properties properties = new Properties();
                properties.setProperty("tryFlag", Boolean.toString(this.f15696a));
                properties.setProperty("isFirstRun", Boolean.toString(this.f15697b));
                properties.setProperty("tryFlagStartTime", Long.toString(this.f15698c));
                properties.setProperty("lastRemindTime", Long.toString(this.f15699d));
                properties.setProperty("totalDiagTime", Long.toString(this.f15700e));
                properties.setProperty("diagTime_date", this.f15701f);
                properties.setProperty("serialNo", this.f15702g);
                StringWriter stringWriter = new StringWriter();
                properties.store(stringWriter, (String) null);
                byte[] bytes = stringWriter.toString().getBytes("ISO-8859-1");
                int length = bytes.length;
                int i = length % 8;
                if (i != 0) {
                    int i2 = 8 - i;
                    int i3 = length + i2;
                    byte[] bArr = new byte[i3];
                    for (int i4 = 0; i4 < length; i4++) {
                        bArr[i4] = bytes[i4];
                    }
                    for (int i5 = 0; i5 < i2; i5++) {
                        bArr[length + i5] = 0;
                    }
                    length = i3;
                    bytes = bArr;
                }
                byte[] bArr2 = new byte[length];
                DiagnoseLogUtil.SafeMatrix.encryptionContent(bytes, bArr2, length);
                fileOutputStream.write(bArr2);
                fileOutputStream.close();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        Log.e("ProductInformation", "非法操作======!!!!");
    }
}
