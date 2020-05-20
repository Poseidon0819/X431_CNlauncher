package com.cnlaunch.x431pro.module.rtu;

import android.content.Context;
import com.cnlaunch.diagnosemodule.utils.DiagnoseLogUtil;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;

/* renamed from: com.cnlaunch.x431pro.module.rtu.j */
/* loaded from: classes.dex */
public final class RegisterAndLoadInfomation {

    /* renamed from: a */
    public String f15704a;

    /* renamed from: b */
    public String f15705b;

    /* renamed from: c */
    public boolean f15706c;

    /* renamed from: d */
    private Context f15707d;

    /* renamed from: e */
    private String f15708e;

    public RegisterAndLoadInfomation(Context context, String str) {
        this.f15704a = "";
        this.f15705b = "";
        this.f15706c = false;
        this.f15704a = "";
        this.f15706c = false;
        this.f15707d = context;
        this.f15708e = str;
        File file = new File(PathUtils.m4851e(this.f15707d, str) + File.separator + this.f15708e + File.separator + "regiterload_information.txt");
        if (file.exists()) {
            try {
                int length = (int) file.length();
                if (length <= 0) {
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[length];
                byte[] bArr2 = new byte[length];
                if (fileInputStream.read(bArr, 0, length) > 0) {
                    DiagnoseLogUtil.SafeMatrix.decryptionContent(bArr, bArr2, length);
                    StringReader stringReader = new StringReader(new String(bArr2, "ISO-8859-1"));
                    Properties properties = new Properties();
                    properties.load(stringReader);
                    this.f15706c = Boolean.parseBoolean(properties.getProperty("isRegisted"));
                    this.f15704a = properties.getProperty("login_username");
                    this.f15705b = properties.getProperty("login_password");
                    NLog.m9452b("RegisterLoadInfo", new String(bArr2, "ISO-8859-1") + "IS_REGISTED=" + this.f15706c + "LOGIN_USERNAME=" + this.f15704a + "LOGIN_PASSWORD=" + this.f15705b);
                }
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m5196a() {
        File m4999d = FileUtils.m4999d(PathUtils.m4851e(this.f15707d, this.f15708e) + File.separator + this.f15708e, "regiterload_information.txt");
        if (m4999d == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(m4999d);
            Properties properties = new Properties();
            properties.setProperty("isRegisted", Boolean.toString(this.f15706c));
            properties.setProperty("login_username", this.f15704a);
            properties.setProperty("login_password", this.f15705b);
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
            if (C2744aa.m5166c()) {
                if (this.f15706c || !this.f15704a.isEmpty()) {
                    ProductInformation productInformation = new ProductInformation(this.f15707d, this.f15708e);
                    productInformation.f15697b = false;
                    productInformation.f15696a = false;
                    productInformation.m5198a(this.f15708e);
                    productInformation.m5197b(this.f15708e);
                    if (this.f15707d != null) {
                        PreferencesManager.m9595a(this.f15707d).m9587a("tryFlag", false);
                        PreferencesManager.m9595a(this.f15707d).m9587a("isFirstRun", false);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
