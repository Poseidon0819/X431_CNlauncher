package com.cnlaunch.physics.p195b.p196a;

import com.cnlaunch.physics.p197c.AnalysisData;
import com.cnlaunch.physics.p201g.OnDownloadBinListener;
import com.cnlaunch.physics.p205k.ByteHexHelper;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.physics.b.a.c */
/* loaded from: classes.dex */
public final class AnalysisForHD extends Analysis {

    /* renamed from: a */
    static int f9821a;

    /* renamed from: b */
    private static AnalysisForHD f9822b;

    private AnalysisForHD() {
    }

    /* renamed from: a */
    public static AnalysisForHD m8360a() {
        if (f9822b == null) {
            f9822b = new AnalysisForHD();
        }
        return f9822b;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: a */
    public final AnalysisData mo8358a(byte[] bArr, byte[] bArr2) {
        return mo8357a(bArr, bArr2, null);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: a */
    public final AnalysisData mo8357a(byte[] bArr, byte[] bArr2, OnDownloadBinListener onDownloadBinListener) {
        AnalysisData analysisData = new AnalysisData();
        System.out.println("开始校验相应字节数组...");
        if (bArr2 != null && bArr2.length > 0) {
            if (bArr2.length > 1) {
                if (ByteHexHelper.m8186a(bArr2[0]).equalsIgnoreCase("55")) {
                    System.out.println("首字节 0x55 OK!");
                    if (bArr2.length > 2 && ByteHexHelper.m8186a(bArr2[1]).equalsIgnoreCase("aa")) {
                        System.out.println("包头校验 OK!");
                        if (bArr2.length > 6) {
                            int i = (bArr2[2] * 256) + bArr2[3];
                            System.out.println("包长度为：".concat(String.valueOf(i)));
                            if (bArr2.length > 8) {
                                int i2 = (bArr2[4] * 256) + bArr2[5];
                                System.out.println("包长度为：".concat(String.valueOf(i2)));
                                if (i != (i2 ^ (-1))) {
                                    if (i > 0 && bArr2.length >= i + 2) {
                                        System.out.println("命令字校验 OK!");
                                        int i3 = i - 4;
                                        byte[] bArr3 = new byte[i3];
                                        int i4 = 0;
                                        for (int i5 = 0; i5 < i3; i5++) {
                                            bArr3[i4] = bArr2[i5 + 6];
                                            i4++;
                                        }
                                        System.out.println("收到命令数据成功!");
                                        analysisData.f9843d = Boolean.TRUE;
                                        analysisData.f9842c = bArr3;
                                        analysisData.f9841b = null;
                                        return analysisData;
                                    }
                                    analysisData.f9843d = Boolean.FALSE;
                                    System.out.println("命令获取不完整");
                                } else {
                                    analysisData.f9843d = Boolean.FALSE;
                                    System.out.println("bao chang du  xin xi cuowu！");
                                }
                            } else {
                                analysisData.f9843d = Boolean.FALSE;
                                System.out.println("命令获取不完整，没有获取到包长度！");
                            }
                        } else {
                            analysisData.f9843d = Boolean.FALSE;
                            System.out.println("命令获取不完整，没有获取到包长度！");
                        }
                    } else {
                        analysisData.f9843d = Boolean.FALSE;
                        System.out.println("包头校验fail!");
                    }
                }
            }
            analysisData.f9843d = Boolean.FALSE;
            System.out.println("首字节 0x55 fail!");
        } else {
            analysisData.f9843d = Boolean.FALSE;
            System.out.println("接收指令为空！");
            int i6 = f9821a + 1;
            f9821a = i6;
            if (i6 > 4) {
                onDownloadBinListener.mo6135a(-99, 0L, 0L);
            }
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
                String m8180a = ByteHexHelper.m8180a(m8344a);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(m8180a);
                return arrayList;
            }
        }
        return null;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: e */
    public final Boolean mo8352e(AnalysisData analysisData) {
        boolean booleanValue = analysisData.f9843d.booleanValue();
        byte[] bArr = analysisData.f9842c;
        boolean z = false;
        if (booleanValue) {
            if (ByteHexHelper.m8186a(bArr[0]).equalsIgnoreCase("00")) {
                z = true;
            }
        } else {
            System.out.println("2407返回失败");
        }
        System.out.println("2407返回的数据==".concat(String.valueOf(z)));
        return Boolean.valueOf(z);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: f */
    public final Boolean mo8351f(AnalysisData analysisData) {
        boolean booleanValue = analysisData.f9843d.booleanValue();
        byte[] bArr = analysisData.f9842c;
        boolean z = false;
        if (booleanValue) {
            if (ByteHexHelper.m8186a(bArr[0]).equalsIgnoreCase("00")) {
                z = true;
            }
        } else {
            System.out.println("2402返回失败");
        }
        System.out.println("2402返回的数据==".concat(String.valueOf(z)));
        return Boolean.valueOf(z);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: g */
    public final Boolean mo8350g(AnalysisData analysisData) {
        boolean booleanValue = analysisData.f9843d.booleanValue();
        byte[] bArr = analysisData.f9842c;
        boolean z = false;
        if (booleanValue) {
            if (ByteHexHelper.m8186a(bArr[0]).equalsIgnoreCase("00")) {
                z = true;
            }
        } else {
            System.out.println("2404返回失败");
        }
        System.out.println("2404返回的数据==".concat(String.valueOf(z)));
        return Boolean.valueOf(z);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: h */
    public final Boolean mo8349h(AnalysisData analysisData) {
        boolean booleanValue = analysisData.f9843d.booleanValue();
        byte[] bArr = analysisData.f9842c;
        boolean z = false;
        if (booleanValue) {
            if (ByteHexHelper.m8186a(bArr[0]).equalsIgnoreCase("00")) {
                z = true;
            }
        } else {
            System.out.println("2403返回失败");
        }
        System.out.println("2403返回的数据==".concat(String.valueOf(z)));
        return Boolean.valueOf(z);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.Analysis
    /* renamed from: i */
    public final String[] mo8348i(AnalysisData analysisData) {
        boolean booleanValue = analysisData.f9843d.booleanValue();
        ArrayList arrayList = new ArrayList();
        if (!booleanValue) {
            System.out.println("2103返回数据长度小于0");
        } else {
            byte[] bArr = analysisData.f9842c;
            int length = bArr.length;
            if (length <= 0) {
                System.out.println("2103===接收数据不正确");
            } else if (length <= 1) {
                System.out.println("2103返回数据长度==".concat(String.valueOf(length)));
            } else if (length > 5) {
                byte[] bArr2 = new byte[4];
                int i = 0;
                for (int i2 = 1; i2 < 5; i2++) {
                    bArr2[i] = bArr[i2];
                    i++;
                }
                String m8180a = ByteHexHelper.m8180a(bArr2);
                arrayList.add(m8180a);
                System.out.println("pcbVerNum = ".concat(String.valueOf(m8180a)));
            }
        }
        if (arrayList.size() > 0) {
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
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
