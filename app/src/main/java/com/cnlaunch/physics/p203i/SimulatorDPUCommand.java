package com.cnlaunch.physics.p203i;

import com.cnlaunch.physics.p205k.ByteHexHelper;
import java.util.List;
import org.codehaus.jackson.smile.SmileConstants;

/* renamed from: com.cnlaunch.physics.i.b */
/* loaded from: classes.dex */
public final class SimulatorDPUCommand {

    /* renamed from: a */
    public static final byte[] f9936a = {85, -86, -16, -8};

    /* renamed from: b */
    public static final byte[] f9937b = {85, -86, -8, -16};

    /* renamed from: c */
    public static final byte[] f9938c = {103, 1};

    /* renamed from: d */
    byte[] f9939d = null;

    /* renamed from: e */
    byte[] f9940e = null;

    /* renamed from: c */
    private void m8253c(String str) {
        this.f9940e = ByteHexHelper.m8183a(str);
    }

    /* renamed from: a */
    public static byte[] m8259a(byte[] bArr, int i, byte b) {
        return m8258a(bArr, i, f9938c, b);
    }

    /* renamed from: b */
    public static byte[] m8255b(byte[] bArr, int i, byte b) {
        return m8258a(bArr, i, null, b);
    }

    /* renamed from: a */
    private static byte[] m8258a(byte[] bArr, int i, byte[] bArr2, byte b) {
        byte[] bArr3;
        if (bArr2 == null) {
            bArr3 = new byte[f9937b.length + 2 + 1 + i + 1];
        } else {
            bArr3 = new byte[f9937b.length + 2 + 1 + bArr2.length + i + 1];
        }
        byte[] bArr4 = f9937b;
        System.arraycopy(bArr4, 0, bArr3, 0, bArr4.length);
        int length = f9937b.length + 0;
        int length2 = bArr2 == null ? i + 1 : i + 1 + bArr2.length;
        bArr3[length] = (byte) ((length2 >> 8) & 255);
        int i2 = length + 1;
        bArr3[i2] = (byte) (length2 & 255);
        int i3 = i2 + 1;
        bArr3[i3] = b;
        int i4 = i3 + 1;
        if (bArr2 == null) {
            System.arraycopy(bArr, 0, bArr3, i4, i);
        } else {
            System.arraycopy(bArr2, 0, bArr3, i4, bArr2.length);
            System.arraycopy(bArr, 0, bArr3, i4 + bArr2.length, i);
        }
        byte[] bArr5 = f9937b;
        byte b2 = bArr3[bArr5.length - 2];
        for (int length3 = bArr5.length - 1; length3 < bArr3.length - 1; length3++) {
            b2 = (byte) (b2 ^ bArr3[length3]);
        }
        bArr3[bArr3.length - 1] = b2;
        return bArr3;
    }

    /* renamed from: a */
    public static SimulatorDPUCommand m8261a(String str) {
        SimulatorDPUCommand simulatorDPUCommand = new SimulatorDPUCommand();
        simulatorDPUCommand.f9939d = new byte[]{39, 1, 96, 32};
        simulatorDPUCommand.m8253c(String.format("67010001000B4E%s010900060209", ByteHexHelper.m8165e(str)));
        return simulatorDPUCommand;
    }

    /* renamed from: b */
    public static SimulatorDPUCommand m8256b(String str) {
        SimulatorDPUCommand simulatorDPUCommand = new SimulatorDPUCommand();
        simulatorDPUCommand.f9939d = new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 3};
        simulatorDPUCommand.m8253c(String.format("6103001934393030323930303034353133343333333733393337333900000D%s00000A56312E30302E3030300000093230313630353037000003313000", ByteHexHelper.m8165e(str)));
        return simulatorDPUCommand;
    }

    /* renamed from: a */
    public static SimulatorDPUCommand m8262a() {
        SimulatorDPUCommand simulatorDPUCommand = new SimulatorDPUCommand();
        simulatorDPUCommand.f9939d = new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 5};
        simulatorDPUCommand.m8253c("6105000A56312E32302E3030370000075639392E39390000075639392E393900000100");
        return simulatorDPUCommand;
    }

    /* renamed from: b */
    public static SimulatorDPUCommand m8257b() {
        SimulatorDPUCommand simulatorDPUCommand = new SimulatorDPUCommand();
        simulatorDPUCommand.f9939d = new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 49};
        simulatorDPUCommand.m8253c("613100");
        return simulatorDPUCommand;
    }

    /* renamed from: c */
    public static SimulatorDPUCommand m8254c() {
        SimulatorDPUCommand simulatorDPUCommand = new SimulatorDPUCommand();
        simulatorDPUCommand.f9939d = new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 20};
        simulatorDPUCommand.m8253c("611400");
        return simulatorDPUCommand;
    }

    /* renamed from: a */
    public static void m8260a(List<SimulatorDPUCommand> list) {
        SimulatorDPUCommand simulatorDPUCommand = new SimulatorDPUCommand();
        simulatorDPUCommand.f9939d = new byte[]{37, 5};
        simulatorDPUCommand.f9940e = new byte[]{101, 5, 0};
        list.add(simulatorDPUCommand);
        SimulatorDPUCommand simulatorDPUCommand2 = new SimulatorDPUCommand();
        simulatorDPUCommand2.f9939d = new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 23};
        simulatorDPUCommand2.f9940e = new byte[]{97, 23, 0};
        list.add(simulatorDPUCommand2);
        SimulatorDPUCommand simulatorDPUCommand3 = new SimulatorDPUCommand();
        simulatorDPUCommand3.f9939d = new byte[]{39, 1, 96, SmileConstants.TOKEN_LITERAL_NULL};
        simulatorDPUCommand3.f9940e = new byte[]{103, 1, 0, 7};
        list.add(simulatorDPUCommand3);
        SimulatorDPUCommand simulatorDPUCommand4 = new SimulatorDPUCommand();
        simulatorDPUCommand4.f9939d = new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 24, 1, 1};
        simulatorDPUCommand4.f9940e = new byte[]{97, 24, 1, 1, 0};
        list.add(simulatorDPUCommand4);
        SimulatorDPUCommand simulatorDPUCommand5 = new SimulatorDPUCommand();
        simulatorDPUCommand5.f9939d = new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 24, 1, 2, 0, 6, 76, 97, 117, 110, 99, 104, 1, 0, 11, 76, 97, 117, 110, 99, 104, 64, 103, 111, 108, 111};
        simulatorDPUCommand5.f9940e = new byte[]{97, 24, 1, 2, 0};
        list.add(simulatorDPUCommand5);
        SimulatorDPUCommand simulatorDPUCommand6 = new SimulatorDPUCommand();
        simulatorDPUCommand6.f9939d = new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 24, 1, 2, 0, 6, 76, 97, 117, 110, 99, 104, 0, 0, 0};
        simulatorDPUCommand6.f9940e = new byte[]{97, 24, 1, 2, 0};
        list.add(simulatorDPUCommand6);
        SimulatorDPUCommand simulatorDPUCommand7 = new SimulatorDPUCommand();
        simulatorDPUCommand7.f9939d = new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 25, 1};
        simulatorDPUCommand7.f9940e = new byte[]{97, 25, 1, 0, 1};
        list.add(simulatorDPUCommand7);
        SimulatorDPUCommand simulatorDPUCommand8 = new SimulatorDPUCommand();
        simulatorDPUCommand8.f9939d = new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 25, 2};
        simulatorDPUCommand8.f9940e = new byte[]{97, 25, 2, 0};
        list.add(simulatorDPUCommand8);
        SimulatorDPUCommand simulatorDPUCommand9 = new SimulatorDPUCommand();
        simulatorDPUCommand9.f9939d = new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 20};
        simulatorDPUCommand9.f9940e = new byte[]{97, 20, 0};
        list.add(simulatorDPUCommand9);
    }
}
