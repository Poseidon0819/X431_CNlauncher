package com.cnlaunch.physics.p205k.p207b;

import android.os.Environment;
import com.cnlaunch.physics.RomoteLocalSwitch;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p205k.ByteHexHelper;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.Tools;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.cnlaunch.physics.k.b.a */
/* loaded from: classes.dex */
public class CommonDiagnoseDataStreamProcessor {

    /* renamed from: r */
    private static final String f10055r = "a";

    /* renamed from: a */
    protected IPhysics f10056a;

    /* renamed from: b */
    protected InputStream f10057b;

    /* renamed from: c */
    protected OutputStream f10058c;

    /* renamed from: d */
    protected final int f10059d = 7;

    /* renamed from: e */
    protected final int f10060e = 2;

    /* renamed from: f */
    protected final byte[] f10061f = {85, -86, -8, -16};

    /* renamed from: g */
    protected final byte[] f10062g = {85, -86, -8, -15};

    /* renamed from: h */
    protected final byte[] f10063h = {85, -86};

    /* renamed from: i */
    protected boolean f10064i;

    /* renamed from: j */
    protected boolean f10065j;

    /* renamed from: k */
    protected BufferedWriter f10066k;

    /* renamed from: l */
    protected SimpleDateFormat f10067l;

    /* renamed from: m */
    protected boolean f10068m;

    /* renamed from: n */
    protected boolean f10069n;

    /* renamed from: o */
    protected boolean f10070o;

    /* renamed from: p */
    protected ReadByteDataStream f10071p;

    /* renamed from: q */
    protected int f10072q;

    public CommonDiagnoseDataStreamProcessor(ReadByteDataStream readByteDataStream, IPhysics iPhysics, InputStream inputStream, OutputStream outputStream) {
        boolean m8114a;
        boolean m8101b;
        this.f10064i = false;
        this.f10065j = false;
        this.f10057b = inputStream;
        this.f10058c = outputStream;
        this.f10056a = iPhysics;
        RomoteLocalSwitch m8086a = RomoteLocalSwitch.m8086a();
        String serialNo = this.f10056a.getSerialNo();
        if (m8086a.f10149a) {
            RomoteLocalSwitch.C1859a c1859a = m8086a.f10150b.get(serialNo);
            m8114a = c1859a == null ? false : c1859a.f10152b;
        } else {
            m8114a = Tools.m8114a();
        }
        this.f10064i = m8114a;
        RomoteLocalSwitch m8086a2 = RomoteLocalSwitch.m8086a();
        String serialNo2 = this.f10056a.getSerialNo();
        if (m8086a2.f10149a) {
            RomoteLocalSwitch.C1859a c1859a2 = m8086a2.f10150b.get(serialNo2);
            m8101b = c1859a2 == null ? false : c1859a2.f10153c;
        } else {
            m8101b = Tools.m8101b();
        }
        this.f10065j = m8101b;
        this.f10071p = readByteDataStream;
        this.f10072q = 0;
        this.f10068m = false;
        if (this.f10068m) {
            this.f10067l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS", Locale.ENGLISH);
            String str = Environment.getExternalStorageDirectory().getPath() + "/cnlaunch/dpu_data_store.txt";
            try {
                new FileInputStream(new File(str));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                this.f10066k = new BufferedWriter(new FileWriter(str, true));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m8200a() {
        this.f10072q = 0;
    }

    /* renamed from: b */
    public final void m8199b() {
        int i;
        if (C1856n.f10135a) {
            C1856n.m8130a(f10055r, "CommonDiagnoseDataStreamProcessor  dataItemProcess() ");
        }
        if (this.f10068m) {
            try {
                this.f10066k.write("\nAnswer(" + this.f10067l.format(new Date()) + "):" + ByteHexHelper.m8179a(this.f10071p.f10077c, this.f10071p.f10075a));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mo8197c();
        this.f10072q += this.f10071p.f10075a;
        if (!this.f10064i || this.f10065j) {
            mo8196e();
            return;
        }
        String m8179a = ByteHexHelper.m8179a(this.f10071p.f10078d, this.f10072q);
        if (this.f10056a.isTruckReset() && ("3f".equalsIgnoreCase(m8179a) || "3f3f".equalsIgnoreCase(m8179a) || "3f3f3f".equalsIgnoreCase(m8179a) || "ff3f".equalsIgnoreCase(m8179a) || "ff3f3f".equalsIgnoreCase(m8179a) || "ff3f3f3f".equalsIgnoreCase(m8179a) || "3f3f3f3f".equalsIgnoreCase(m8179a) || "3f3f3f3f3f".equalsIgnoreCase(m8179a) || "3f3f3f3f3f3f".equalsIgnoreCase(m8179a) || "3f3f3f3f3f3f3f".equalsIgnoreCase(m8179a))) {
            IPhysics iPhysics = this.f10056a;
            if (iPhysics != null) {
                iPhysics.setCommand("3f");
                this.f10056a.setCommand_wait(false);
                this.f10056a.setIsTruckReset(false);
            }
            this.f10069n = true;
        } else if (m8179a.indexOf("4f4b21") >= 0 && this.f10069n) {
            IPhysics iPhysics2 = this.f10056a;
            if (iPhysics2 != null) {
                iPhysics2.setCommand("4f4b21");
                this.f10056a.setCommand_wait(false);
            }
            this.f10069n = false;
        } else {
            int m8177a = ByteHexHelper.m8177a(this.f10071p.f10078d, this.f10063h, 0, this.f10072q);
            if (m8177a >= 0) {
                if (m8177a > 0) {
                    int i2 = this.f10072q - m8177a;
                    System.arraycopy(this.f10071p.f10078d, m8177a, this.f10071p.f10078d, 0, i2);
                    this.f10072q = i2;
                }
                if (this.f10072q < 4 || this.f10072q < (i = ((this.f10071p.f10078d[2] & 255) * 256) + (this.f10071p.f10078d[3] & 255) + 2)) {
                    return;
                }
                this.f10056a.setCommand(ByteHexHelper.m8179a(this.f10071p.f10078d, i));
                this.f10056a.setCommand_wait(false);
                this.f10072q -= i;
                if (this.f10072q > 0) {
                    System.arraycopy(this.f10071p.f10078d, i, this.f10071p.f10078d, 0, this.f10072q);
                }
            }
        }
    }

    /* renamed from: c */
    protected void mo8197c() {
        if (this.f10072q + this.f10071p.f10075a <= this.f10071p.f10079e) {
            System.arraycopy(this.f10071p.f10077c, 0, this.f10071p.f10078d, this.f10072q, this.f10071p.f10075a);
            return;
        }
        this.f10072q = 0;
        System.arraycopy(this.f10071p.f10077c, 0, this.f10071p.f10078d, this.f10072q, this.f10071p.f10075a);
    }

    /* renamed from: d */
    public final void m8198d() {
        try {
            if (this.f10068m) {
                this.f10066k.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    protected void mo8196e() {
        int i;
        int i2;
        this.f10070o = false;
        int m8177a = ByteHexHelper.m8177a(this.f10071p.f10078d, this.f10061f, 0, this.f10072q);
        if (m8177a >= 0) {
            this.f10070o = true;
        } else {
            m8177a = ByteHexHelper.m8177a(this.f10071p.f10078d, this.f10062g, 0, this.f10072q);
            if (m8177a >= 0) {
                this.f10070o = true;
            }
        }
        if (this.f10070o) {
            if (m8177a > 0) {
                int i3 = this.f10072q - m8177a;
                System.arraycopy(this.f10071p.f10078d, m8177a, this.f10071p.f10078d, 0, i3);
                this.f10072q = i3;
            }
            if (this.f10072q < 6 || this.f10072q < (i = ((this.f10071p.f10078d[4] & 255) * 256) + (this.f10071p.f10078d[5] & 255) + 7)) {
                return;
            }
            byte b = this.f10071p.f10078d[2];
            int i4 = 3;
            while (true) {
                i2 = i - 1;
                if (i4 >= i2) {
                    break;
                }
                b = (byte) (b ^ this.f10071p.f10078d[i4]);
                i4++;
            }
            if (b == this.f10071p.f10078d[i2]) {
                this.f10056a.setCommand(ByteHexHelper.m8179a(this.f10071p.f10078d, i));
                this.f10056a.setCommand_wait(false);
            }
            this.f10072q -= i;
            if (this.f10072q > 0) {
                System.arraycopy(this.f10071p.f10078d, i, this.f10071p.f10078d, 0, this.f10072q);
            }
        }
    }
}
