package com.cnlaunch.x431pro.activity.login;

import android.util.Base64;
import android.util.Log;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.diagnosemodule.utils.DiagnoseLogUtil;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.utils.PathUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: com.cnlaunch.x431pro.activity.login.cc */
/* loaded from: classes.dex */
public class RegisterInfoRecord {

    /* renamed from: b */
    private final String f13468b = RegisterInfoRecord.class.getSimpleName();

    /* renamed from: a */
    HashMap<String, String> f13467a = new HashMap<>();

    /* renamed from: c */
    private String f13469c = PathUtils.m4846j() + "loginInfo.dat";

    /* renamed from: a */
    public static String m6543a(HashMap<String, String> hashMap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(hashMap);
        String str = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
        objectOutputStream.close();
        return str;
    }

    /* renamed from: a */
    public final void m6544a(String str) {
        File file = new File(this.f13469c);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byte[] bArr = null;
        try {
            bArr = str.getBytes("utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int length = bArr.length;
        byte[] intToByte = DiagnoseLogUtil.intToByte(length);
        NLog.m9451c("weiwell setUsernamePassword_fileLength", Integer.valueOf(length));
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            byte[] bArr2 = new byte[4096];
            byte[] bArr3 = new byte[4096];
            dataOutputStream.write(intToByte);
            int m6545a = m6545a(length);
            if (length <= 4096) {
                for (int i = 0; i < 4096; i++) {
                    bArr2[i] = 0;
                }
                for (int i2 = 0; i2 < length; i2++) {
                    bArr2[i2] = bArr[i2];
                }
                DiagnoseLogUtil.SafeMatrix.encryptionContent(bArr2, bArr3, 4096);
                dataOutputStream.write(bArr3, 0, m6545a);
            } else {
                byte[] bArr4 = new byte[m6545a];
                int i3 = length;
                int i4 = 0;
                while (4096 < i3) {
                    for (int i5 = 0; i5 < 4096; i5++) {
                        bArr2[i5] = bArr[(i4 * 4096) + i5];
                    }
                    DiagnoseLogUtil.SafeMatrix.encryptionContent(bArr2, bArr3, 4096);
                    for (int i6 = 0; i6 < 4096; i6++) {
                        bArr4[(i4 * 4096) + i6] = bArr3[i6];
                    }
                    i4++;
                    i3 = length + UIMsg.m_AppUI.MSG_SENSOR;
                }
                if (i3 > 0 && i3 < 4096) {
                    for (int i7 = 0; i7 < 4096; i7++) {
                        bArr2[i7] = 0;
                    }
                    for (int i8 = 0; i8 < i3; i8++) {
                        bArr2[i8] = bArr[(i4 * 4096) + i8];
                    }
                    DiagnoseLogUtil.SafeMatrix.encryptionContent(bArr2, bArr3, 4096);
                    int i9 = i4 * 4096;
                    int i10 = m6545a - i9;
                    for (int i11 = 0; i11 < i10; i11++) {
                        bArr4[i9 + i11] = bArr3[i11];
                    }
                }
                dataOutputStream.write(bArr4, 0, length);
            }
            dataOutputStream.close();
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: a */
    public final HashMap<String, String> m6546a() {
        File file = new File(this.f13469c);
        if (file.exists()) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                byte[] bArr = new byte[4096];
                byte[] bArr2 = new byte[4096];
                byte[] bArr3 = new byte[4];
                dataInputStream.read(bArr3);
                int byteToInt = DiagnoseLogUtil.byteToInt(bArr3);
                NLog.m9451c("weiwell getUsernamePassword_filelength", Integer.valueOf(byteToInt));
                byte[] bArr4 = new byte[byteToInt];
                int m6545a = m6545a(byteToInt);
                if (byteToInt <= 4096) {
                    dataInputStream.read(bArr, 0, m6545a);
                    DiagnoseLogUtil.SafeMatrix.decryptionContent(bArr, bArr2, 4096);
                    for (int i = 0; i < byteToInt; i++) {
                        bArr4[i] = bArr2[i];
                    }
                } else {
                    int read = dataInputStream.read(bArr);
                    int i2 = 0;
                    while (read == 4096) {
                        DiagnoseLogUtil.SafeMatrix.decryptionContent(bArr, bArr2, 4096);
                        for (int i3 = 0; i3 < 4096; i3++) {
                            bArr4[(i2 * 4096) + i3] = bArr2[i3];
                        }
                        i2++;
                        read = dataInputStream.read(bArr, 0, m6545a + UIMsg.m_AppUI.MSG_SENSOR);
                    }
                    if (read > 0 && read < 4096) {
                        DiagnoseLogUtil.SafeMatrix.decryptionContent(bArr, bArr2, read);
                        for (int i4 = 0; i4 < read; i4++) {
                            bArr4[(i2 * 4096) + i4] = bArr2[i4];
                        }
                    }
                }
                String str = new String(Arrays.copyOfRange(bArr4, 0, byteToInt), "utf-8");
                try {
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str.getBytes(), 0)));
                        objectInputStream.close();
                        this.f13467a = (HashMap) objectInputStream.readObject();
                        Log.i("weiwell", "getUsernamePassword =".concat(String.valueOf(str)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e2) {
                        e2.printStackTrace();
                    }
                } catch (StreamCorruptedException e3) {
                    e3.printStackTrace();
                }
                dataInputStream.close();
            } catch (FileNotFoundException | IOException unused) {
            }
        }
        return this.f13467a;
    }

    /* renamed from: a */
    private static int m6545a(int i) {
        int i2 = i % 8;
        return i2 != 0 ? i + (8 - i2) : i;
    }
}
