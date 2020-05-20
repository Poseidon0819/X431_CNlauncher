package com.ifoer.expedition.cto;

import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public class CToJavaImplementsExtendsForEasyDiag30Logic implements CToJavaImplementsExtends {
    private static final String TAG = "CToJavaImplementsExtendsForEasyDiag30Logic";

    @Override // com.ifoer.expedition.cto.CToJavaImplementsExtends
    public boolean isNeedInterceptFor2505(byte[] bArr) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x014b -> B:61:0x014e). Please submit an issue!!! */
    @Override // com.ifoer.expedition.cto.CToJavaImplementsExtends
    public byte[] writeAndReadSendBufferWrapper(byte[] bArr) {
        FileInputStream fileInputStream;
        if (C1856n.f10135a) {
            String str = TAG;
            C1856n.m8130a(str, "sendBuffer=" + ByteHexHelper.bytesToHexString(bArr));
            String str2 = TAG;
            C1856n.m8130a(str2, "CToJavaImplements.getVehicleSdPath()=" + CToJavaImplements.getVehicleSdPath());
        }
        if (bArr[0] != 33 || bArr[1] != 23) {
            return bArr;
        }
        FileInputStream fileInputStream2 = 0;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(CToJavaImplements.getVehicleSdPath() + File.separator + "LICENSE.DAT");
                    try {
                        byte[] bArr2 = new byte[3];
                        int read = fileInputStream.read(bArr2);
                        if (C1856n.f10135a) {
                            C1856n.m8130a(TAG, String.format("n3LengthBuffer read count=%d", Integer.valueOf(read)));
                        }
                        if (read == 3) {
                            int i = ((bArr2[1] & 255) * 256) + (bArr2[2] & 255);
                            byte[] bArr3 = new byte[i];
                            int read2 = fileInputStream.read(bArr3);
                            if (C1856n.f10135a) {
                                C1856n.m8130a(TAG, String.format("n3LengthBuffer[0]=%d,n3LengthBuffer[1]=%d,n3LengthBuffer[2]=%d,n3Length=%d n3ContentBuffer readCount=%d", Byte.valueOf(bArr2[0]), Byte.valueOf(bArr2[1]), Byte.valueOf(bArr2[2]), Integer.valueOf(i), Integer.valueOf(read2)));
                            }
                            if (read2 == i) {
                                int i2 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
                                if (C1856n.f10135a) {
                                    C1856n.m8130a(TAG, String.format("n1Length=%d n3Length=%d", Integer.valueOf(i2), Integer.valueOf(i)));
                                }
                                int i3 = i2 + 4;
                                int i4 = i3 + 2;
                                byte[] bArr4 = new byte[i4 + i];
                                System.arraycopy(bArr, 0, bArr4, 0, i3);
                                System.arraycopy(bArr2, 1, bArr4, i3, 2);
                                System.arraycopy(bArr3, 0, bArr4, i4, i);
                                if (C1856n.f10135a) {
                                    String str3 = TAG;
                                    C1856n.m8130a(str3, "newSendBuffer=" + ByteHexHelper.bytesToHexString(bArr4));
                                }
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return bArr4;
                            }
                        }
                        fileInputStream.close();
                        fileInputStream2 = bArr2;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileInputStream2 = fileInputStream;
                        e.printStackTrace();
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                            fileInputStream2 = fileInputStream2;
                        }
                        return bArr;
                    } catch (IOException e3) {
                        e = e3;
                        fileInputStream2 = fileInputStream;
                        e.printStackTrace();
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                            fileInputStream2 = fileInputStream2;
                        }
                        return bArr;
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (IOException e7) {
                e7.printStackTrace();
                fileInputStream2 = fileInputStream2;
            }
            return bArr;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = fileInputStream2;
        }
    }
}
