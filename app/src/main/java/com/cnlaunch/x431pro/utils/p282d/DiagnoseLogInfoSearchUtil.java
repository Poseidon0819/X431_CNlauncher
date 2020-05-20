package com.cnlaunch.x431pro.utils.p282d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.diagnosemodule.utils.DiagnoseLogUtil;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.x431pro.activity.setting.SendDiagnosticLogActivity1;
import com.cnlaunch.x431pro.utils.PathUtils;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.utils.d.a */
/* loaded from: classes.dex */
public final class DiagnoseLogInfoSearchUtil {

    /* compiled from: DiagnoseLogInfoSearchUtil.java */
    /* renamed from: com.cnlaunch.x431pro.utils.d.a$a */
    /* loaded from: classes.dex */
    public static class C2749a implements Serializable {
        private static final long serialVersionUID = 2226493882202622016L;
        private boolean isChecked;
        private long mCreateDate;
        private String mDeviceSN;
        private String mFilename;
        private String mFullFilePath;
        private String mMake;
        private String mModel;
        private String mVIN;
        private String mVehicleSoftname;
        private String mYear;
        private String vehicleName;
        private String zipFilePath;

        public final void setFilename(String str) {
            this.mFilename = str;
        }

        public final void setDeviceSN(String str) {
            this.mDeviceSN = str;
        }

        public final void setVehicleSoftname(String str) {
            this.mVehicleSoftname = str;
        }

        public final void setCreateDate(long j) {
            this.mCreateDate = j;
        }

        public final void setFullFilePath(String str) {
            this.mFullFilePath = str;
        }

        public final String getFilename() {
            return this.mFilename;
        }

        public final String getDeviceSN() {
            return this.mDeviceSN;
        }

        public final String getVehicleSoftname() {
            return this.mVehicleSoftname;
        }

        public final long getCreateDate() {
            return this.mCreateDate;
        }

        public final String getFullFilePath() {
            return this.mFullFilePath;
        }

        public final String getZipFilePath() {
            return this.zipFilePath;
        }

        public final void setZipFilePath(String str) {
            this.zipFilePath = str;
        }

        public final boolean isChecked() {
            return this.isChecked;
        }

        public final void setChecked(boolean z) {
            this.isChecked = z;
        }

        public final String getVehicleName() {
            return this.vehicleName;
        }

        public final void setVehicleName(String str) {
            this.vehicleName = str;
        }

        public final synchronized String getMake() {
            return this.mMake;
        }

        public final synchronized void setMake(String str) {
            this.mMake = str;
        }

        public final synchronized String getModel() {
            return this.mModel;
        }

        public final synchronized void setModel(String str) {
            this.mModel = str;
        }

        public final synchronized String getYear() {
            return this.mYear;
        }

        public final synchronized void setYear(String str) {
            this.mYear = str;
        }

        public final synchronized String getVIN() {
            return this.mVIN;
        }

        public final synchronized void setVIN(String str) {
            this.mVIN = str;
        }
    }

    /* renamed from: a */
    public static Vector<C2749a> m5090a() {
        File[] listFiles;
        C2749a m5087a;
        Vector<C2749a> vector = new Vector<>();
        File file = new File(PathUtils.m4850f());
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (!file2.isDirectory() && file2.getName().contains(".dat") && (m5087a = m5087a(file2)) != null) {
                    vector.add(m5087a);
                }
            }
            Collections.sort(vector, new C2750b());
            return vector;
        }
        return vector;
    }

    /* renamed from: a */
    public static C2749a m5087a(File file) {
        byte[] bArr = {76, 65, 85, 78, 67, 72};
        byte[] bArr2 = new byte[6];
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            dataInputStream.read(bArr2);
            if (Arrays.equals(bArr2, bArr)) {
                byte[] bArr3 = new byte[4096];
                byte[] bArr4 = new byte[4096];
                byte[] bArr5 = new byte[4];
                dataInputStream.read(bArr5);
                int byteToInt = DiagnoseLogUtil.byteToInt(bArr5);
                if (byteToInt <= 4096) {
                    dataInputStream.read(bArr3, 0, byteToInt);
                    DiagnoseLogUtil.SafeMatrix.decryptionContent(bArr3, bArr4, byteToInt);
                } else {
                    byte[] bArr6 = new byte[byteToInt];
                    int read = dataInputStream.read(bArr3);
                    int i = 0;
                    while (read == 4096) {
                        DiagnoseLogUtil.SafeMatrix.decryptionContent(bArr3, bArr4, 4096);
                        for (int i2 = 0; i2 < 4096; i2++) {
                            bArr6[(i * 4096) + i2] = bArr4[i2];
                        }
                        i++;
                        read = dataInputStream.read(bArr3, 0, byteToInt + UIMsg.m_AppUI.MSG_SENSOR);
                    }
                    if (read > 0 && read < 4096) {
                        int decryptionContent = DiagnoseLogUtil.SafeMatrix.decryptionContent(bArr3, bArr4, read);
                        for (int i3 = 0; i3 < decryptionContent; i3++) {
                            bArr6[(i * 4096) + i3] = bArr4[i3];
                        }
                    }
                    bArr4 = bArr6;
                }
                C2749a c2749a = new C2749a();
                c2749a.setFilename(file.getName());
                c2749a.setFullFilePath(file.getAbsolutePath());
                byte b = bArr4[0];
                byte b2 = bArr4[1];
                long byteToLong = DiagnoseLogUtil.byteToLong(Arrays.copyOfRange(bArr4, 2, 10));
                c2749a.setCreateDate(byteToLong);
                int i4 = ((bArr4[10] & 255) * 256) + (bArr4[11] & 255) + 12;
                String str = new String(Arrays.copyOfRange(bArr4, 12, i4), "utf-8");
                c2749a.setVehicleSoftname(str.toUpperCase());
                int i5 = i4 + 1;
                int i6 = i5 + 1 + ((bArr4[i4] & 255) * 256) + (bArr4[i5] & 255);
                int i7 = i6 + 1;
                int i8 = i7 + 1 + ((bArr4[i6] & 255) * 256) + (bArr4[i7] & 255);
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                String str2 = new String(Arrays.copyOfRange(bArr4, i10, ((bArr4[i8] & 255) * 256) + (bArr4[i9] & 255) + i10), "utf-8");
                c2749a.setDeviceSN(str2.toUpperCase());
                if (C1856n.f10135a) {
                    C1856n.m8130a("DiagnoseLogInfoSearchUtil", str2 + "  " + str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + new Date(byteToLong).toString() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + c2749a.getFilename() + "  " + c2749a.getFullFilePath());
                }
                dataInputStream.close();
                if (!m5089a(b, b2, file, c2749a)) {
                    if (C1856n.f10135a) {
                        C1856n.m8130a("DiagnoseLogInfoSearchUtil", "readDiagnoseLogTailInfo(versionMajor,versionMinor,file,diagnoseLogFileInfo)==false");
                    }
                    c2749a.setMake("");
                    c2749a.setModel("");
                    c2749a.setYear("");
                    c2749a.setVIN("");
                }
                return c2749a;
            }
            dataInputStream.close();
            return null;
        } catch (FileNotFoundException | IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0211 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m5089a(byte r11, byte r12, java.io.File r13, com.cnlaunch.x431pro.utils.p282d.DiagnoseLogInfoSearchUtil.C2749a r14) {
        /*
            Method dump skipped, instructions count: 539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.utils.p282d.DiagnoseLogInfoSearchUtil.m5089a(byte, byte, java.io.File, com.cnlaunch.x431pro.utils.d.a$a):boolean");
    }

    /* renamed from: a */
    public static void m5088a(Context context, Vector<C2749a> vector, boolean z) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ListFile", vector);
        bundle.putBoolean("isDiagnosing", z);
        intent.putExtras(bundle);
        intent.setFlags(67108864);
        intent.setClass(context, SendDiagnosticLogActivity1.class);
        context.startActivity(intent);
    }
}
