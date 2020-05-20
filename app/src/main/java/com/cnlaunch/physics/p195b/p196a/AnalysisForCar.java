package com.cnlaunch.physics.p195b.p196a;

import com.cnlaunch.physics.p197c.AnalysisData;
import com.cnlaunch.physics.p201g.OnDownloadBinListener;
import com.cnlaunch.physics.p205k.ByteHexHelper;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.physics.b.a.b */
/* loaded from: classes.dex */
public final class AnalysisForCar extends Analysis {

    /* renamed from: a */
    static int f9819a;

    /* renamed from: b */
    private static AnalysisForCar f9820b;

    private AnalysisForCar() {
    }

    /* renamed from: a */
    public static AnalysisForCar m8361a() {
        if (f9820b == null) {
            f9820b = new AnalysisForCar();
        }
        return f9820b;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: a */
    public final AnalysisData mo8358a(byte[] bArr, byte[] bArr2) {
        return mo8357a(bArr, bArr2, null);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: a */
    public final AnalysisData mo8357a(byte[] bArr, byte[] bArr2, OnDownloadBinListener onDownloadBinListener) {
        byte[] bArr3;
        int m8170c;
        AnalysisData analysisData = new AnalysisData();
        int i = 0;
        String m8180a = ByteHexHelper.m8180a(new byte[]{bArr[7], bArr[8]});
        System.out.println("发送的命令字：".concat(String.valueOf(m8180a)));
        int m8176b = ByteHexHelper.m8176b(bArr[6]);
        if (bArr.length <= 6 || (m8170c = ByteHexHelper.m8170c(new byte[]{bArr[4], bArr[5]})) <= 0 || bArr.length < m8170c + 7) {
            bArr3 = null;
        } else {
            bArr3 = new byte[m8170c - 3];
            int i2 = 0;
            for (int i3 = 9; i3 < (m8170c + 9) - 3; i3++) {
                bArr3[i2] = bArr[i3];
                i2++;
            }
        }
        System.out.println("发送指令计数器值 = ".concat(String.valueOf(m8176b)));
        System.out.println("开始校验相应字节数组...");
        if (bArr2 != null && bArr2.length > 0) {
            f9819a = 0;
            if (bArr2.length > 1 && ByteHexHelper.m8186a(bArr2[0]).equalsIgnoreCase("55")) {
                System.out.println("首字节 0x55 OK!");
                if (bArr2.length > 2 && ByteHexHelper.m8186a(bArr2[1]).equalsIgnoreCase("aa")) {
                    System.out.println("包头校验 OK!");
                    if (bArr2.length > 6) {
                        int m8170c2 = ByteHexHelper.m8170c(new byte[]{bArr2[4], bArr2[5]});
                        System.out.println("包长度为：".concat(String.valueOf(m8170c2)));
                        if (m8170c2 > 0 && bArr2.length >= m8170c2 + 7) {
                            if (ByteHexHelper.m8176b(bArr2[6]) == m8176b) {
                                System.out.println("计数器校验 OK!");
                                String m8180a2 = ByteHexHelper.m8180a(new byte[]{bArr2[7], bArr2[8]});
                                if (m8180a2.substring(0, 1).equalsIgnoreCase("6") && m8180a2.substring(1).equalsIgnoreCase(m8180a.substring(1))) {
                                    System.out.println("命令字校验 OK!");
                                    byte[] bArr4 = new byte[m8170c2 - 3];
                                    for (int i4 = 9; i4 < (m8170c2 + 9) - 3; i4++) {
                                        bArr4[i] = bArr2[i4];
                                        i++;
                                    }
                                    System.out.println("收到命令数据成功!");
                                    analysisData.f9843d = Boolean.TRUE;
                                    analysisData.f9842c = bArr4;
                                    analysisData.f9841b = bArr3;
                                    analysisData.f9840a = m8180a;
                                    return analysisData;
                                }
                                analysisData.f9843d = Boolean.FALSE;
                                System.out.println("命令字校验 fail!");
                            } else {
                                analysisData.f9843d = Boolean.FALSE;
                                System.out.println("计数器校验 fail!");
                            }
                        } else {
                            analysisData.f9843d = Boolean.FALSE;
                            System.out.println("命令获取不完整");
                        }
                    } else {
                        analysisData.f9843d = Boolean.FALSE;
                        System.out.println("命令获取不完整，没有获取到包长度！");
                    }
                } else {
                    analysisData.f9843d = Boolean.FALSE;
                    System.out.println("包头校验fail!");
                }
            } else {
                analysisData.f9843d = Boolean.FALSE;
                System.out.println("首字节 0x55 fail!");
            }
        } else {
            analysisData.f9843d = Boolean.FALSE;
            System.out.println("接收指令为空！");
            f9819a++;
        }
        return analysisData;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: b */
    public final AnalysisData mo8355b(byte[] bArr, byte[] bArr2) {
        return mo8357a(bArr, bArr2, null);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: a */
    public final String mo8359a(AnalysisData analysisData) {
        String str = "";
        if (!analysisData.f9843d.booleanValue()) {
            System.out.println("2502命令校验未通过");
        } else {
            byte[] bArr = analysisData.f9842c;
            byte[] bArr2 = analysisData.f9841b;
            if (bArr2.length > 0) {
                int i = 0;
                String m8186a = ByteHexHelper.m8186a(bArr2[0]);
                String m8186a2 = ByteHexHelper.m8186a(bArr[0]);
                if (m8186a.equals(m8186a2)) {
                    if (m8186a2.equalsIgnoreCase("01")) {
                        byte[] bArr3 = new byte[3];
                        while (i < 3) {
                            bArr3[i] = bArr[i];
                            i++;
                        }
                        str = ByteHexHelper.m8180a(bArr3);
                    } else if (m8186a2.equalsIgnoreCase("02")) {
                        byte[] bArr4 = new byte[5];
                        while (i < 5) {
                            bArr4[i] = bArr[i];
                            i++;
                        }
                        str = ByteHexHelper.m8180a(bArr4);
                    }
                    System.out.println("2502 校验码==".concat(String.valueOf(str)));
                } else {
                    System.out.println("2502 请求参数与响应参数不同");
                }
            } else {
                System.out.println("2502发送命令长度不大于0");
            }
        }
        return str;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: b */
    public final Boolean mo8356b(AnalysisData analysisData) {
        boolean z = false;
        if (!analysisData.f9843d.booleanValue()) {
            System.out.println("2503命令校验未通过");
        } else {
            byte[] bArr = analysisData.f9841b;
            byte[] bArr2 = analysisData.f9842c;
            if (bArr.length > 0 && bArr2.length > 0) {
                if (ByteHexHelper.m8186a(bArr[0]).equalsIgnoreCase(ByteHexHelper.m8186a(bArr2[0]))) {
                    if (bArr2.length > 1) {
                        String m8186a = ByteHexHelper.m8186a(bArr2[1]);
                        if (m8186a.equalsIgnoreCase("00")) {
                            System.out.println("解析2503返回的数据===成功获得授权");
                            z = true;
                        } else if (m8186a.equalsIgnoreCase("01")) {
                            System.out.println("解析2503返回的数据===拒绝，校验字节错误");
                        } else if (m8186a.equalsIgnoreCase("02")) {
                            System.out.println("解析2503返回的数据===其他错误");
                        }
                        System.out.println("解析2503返回的数据===".concat(String.valueOf(m8186a)));
                    } else {
                        System.out.println("2503请求参数长度小于1");
                    }
                } else {
                    System.out.println("2503请求校验等级与响应校验等级不同");
                }
            } else {
                System.out.println("2503请求参数长度小于0");
            }
        }
        return Boolean.valueOf(z);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: c */
    public final String mo8354c(AnalysisData analysisData) {
        String m8186a = ByteHexHelper.m8186a(analysisData.f9842c[0]);
        System.out.println("2114 返回的数据==".concat(String.valueOf(m8186a)));
        return m8186a;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: d */
    public final ArrayList<String> mo8353d(AnalysisData analysisData) {
        if (analysisData.f9843d.booleanValue()) {
            byte[] m8344a = DpuOrderUtils.m8344a(analysisData.f9842c);
            if (m8344a.length >= 3) {
                return ByteHexHelper.m8167d(m8344a);
            }
            return null;
        }
        return null;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: e */
    public final Boolean mo8352e(AnalysisData analysisData) {
        boolean booleanValue = analysisData.f9843d.booleanValue();
        byte[] bArr = analysisData.f9842c;
        boolean z = false;
        if (booleanValue && ByteHexHelper.m8186a(bArr[0]).equalsIgnoreCase("00")) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: f */
    public final Boolean mo8351f(AnalysisData analysisData) {
        boolean booleanValue = analysisData.f9843d.booleanValue();
        byte[] bArr = analysisData.f9842c;
        boolean z = false;
        if (booleanValue && ByteHexHelper.m8186a(bArr[0]).equalsIgnoreCase("00")) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: g */
    public final Boolean mo8350g(AnalysisData analysisData) {
        boolean booleanValue = analysisData.f9843d.booleanValue();
        byte[] bArr = analysisData.f9842c;
        boolean z = false;
        if (booleanValue && ByteHexHelper.m8186a(bArr[0]).equalsIgnoreCase("00")) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: h */
    public final Boolean mo8349h(AnalysisData analysisData) {
        boolean booleanValue = analysisData.f9843d.booleanValue();
        byte[] bArr = analysisData.f9842c;
        boolean z = false;
        if (booleanValue && ByteHexHelper.m8186a(bArr[0]).equalsIgnoreCase("00")) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: i */
    public final String[] mo8348i(AnalysisData analysisData) {
        int i;
        int i2;
        int i3;
        boolean booleanValue = analysisData.f9843d.booleanValue();
        ArrayList arrayList = new ArrayList();
        if (!booleanValue) {
            System.out.println("2103返回数据长度小于0");
        } else {
            byte[] bArr = analysisData.f9842c;
            int length = bArr.length;
            if (length <= 0) {
                System.out.println("2103===接收数据不正确");
            } else if (length > 2) {
                int m8170c = ByteHexHelper.m8170c(new byte[]{bArr[0], bArr[1]});
                int i4 = m8170c + 2;
                if (length > i4) {
                    byte[] bArr2 = new byte[m8170c - 1];
                    int i5 = 0;
                    for (int i6 = 2; i6 < i4 - 1; i6++) {
                        bArr2[i5] = bArr[i6];
                        i5++;
                    }
                    String str = new String(bArr2);
                    arrayList.add(str);
                    System.out.println("====".concat(String.valueOf(str)));
                    int i7 = i4 + 2;
                    if (length > i7) {
                        int m8170c2 = ByteHexHelper.m8170c(new byte[]{bArr[i4], bArr[i4 + 1]});
                        byte[] bArr3 = new byte[m8170c2 - 1];
                        int i8 = i7;
                        int i9 = 0;
                        while (true) {
                            i = i7 + m8170c2;
                            if (i8 >= i - 1) {
                                break;
                            }
                            bArr3[i9] = bArr[i8];
                            i9++;
                            i8++;
                        }
                        arrayList.add(new String(bArr3));
                        int i10 = i + 2;
                        if (length > i10) {
                            int m8170c3 = ByteHexHelper.m8170c(new byte[]{bArr[i], bArr[i + 1]});
                            byte[] bArr4 = new byte[m8170c3 - 1];
                            int i11 = i10;
                            int i12 = 0;
                            while (true) {
                                i2 = i10 + m8170c3;
                                if (i11 >= i2 - 1) {
                                    break;
                                }
                                bArr4[i12] = bArr[i11];
                                i12++;
                                i11++;
                            }
                            arrayList.add(new String(bArr4));
                            int i13 = i2 + 2;
                            if (length > i13) {
                                int m8170c4 = ByteHexHelper.m8170c(new byte[]{bArr[i2], bArr[i2 + 1]});
                                byte[] bArr5 = new byte[m8170c4 - 1];
                                int i14 = i13;
                                int i15 = 0;
                                while (true) {
                                    i3 = i13 + m8170c4;
                                    if (i14 >= i3 - 1) {
                                        break;
                                    }
                                    bArr5[i15] = bArr[i14];
                                    i15++;
                                    i14++;
                                }
                                arrayList.add(new String(bArr5));
                                int i16 = i3 + 2;
                                if (length > i16) {
                                    int m8170c5 = ByteHexHelper.m8170c(new byte[]{bArr[i3], bArr[i3 + 1]});
                                    byte[] bArr6 = new byte[m8170c5 - 1];
                                    int i17 = 0;
                                    for (int i18 = i16; i18 < (i16 + m8170c5) - 1; i18++) {
                                        bArr6[i17] = bArr[i18];
                                        i17++;
                                    }
                                    arrayList.add(new String(bArr6));
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("2103返回数据长度==".concat(String.valueOf(length)));
            }
        }
        String[] strArr = arrayList.size() > 0 ? (String[]) arrayList.toArray(new String[arrayList.size()]) : null;
        for (String str2 : strArr) {
            System.out.println("2013 解析后的数据==" + str2 + "===");
        }
        return strArr;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: j */
    public final ArrayList<String> mo8347j(AnalysisData analysisData) {
        boolean booleanValue = analysisData.f9843d.booleanValue();
        ArrayList<String> arrayList = new ArrayList<>();
        if (booleanValue) {
            byte[] m8344a = DpuOrderUtils.m8344a(analysisData.f9842c);
            if (m8344a.length >= 2) {
                String m8180a = ByteHexHelper.m8180a(m8344a);
                if (m8180a.length() == 10) {
                    arrayList.add(m8180a.substring(0, 4));
                    arrayList.add(m8180a.substring(4, 8));
                    arrayList.add(m8180a.substring(8, 10));
                }
                return arrayList;
            }
        } else {
            System.out.println("2120返回数据长度小于0");
        }
        return arrayList;
    }
}
