package com.cnlaunch.x431pro.activity.mine;

import android.os.Handler;
import com.cnlaunch.physics.p201g.OnDownloadBinListener;
import com.itextpdf.text.pdf.PdfContentParser;
import java.math.BigDecimal;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.xbill.DNS.Type;

/* compiled from: VehicleVoltageFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.dd */
/* loaded from: classes.dex */
final class C2478dd implements OnDownloadBinListener {

    /* renamed from: a */
    final /* synthetic */ VehicleVoltageFragment f14200a;

    @Override // com.cnlaunch.physics.p201g.OnDownloadBinListener
    /* renamed from: a */
    public final void mo6135a(int i, long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2478dd(VehicleVoltageFragment vehicleVoltageFragment) {
        this.f14200a = vehicleVoltageFragment;
    }

    @Override // com.cnlaunch.physics.p201g.OnDownloadBinListener
    /* renamed from: a */
    public final void mo6134a(int i, String str) {
        Handler handler;
        double d;
        if (i == 18) {
            int parseInt = Integer.parseInt(str, 16);
            if (parseInt < 6500) {
                double d2 = parseInt + 100;
                double d3 = parseInt;
                Double.isNaN(d3);
                Double.isNaN(d2);
                d = d2 + (((d3 - 6000.0d) * 6.0d) / 6000.0d);
            } else if (parseInt < 7000) {
                double d4 = parseInt + 100;
                double d5 = parseInt;
                Double.isNaN(d5);
                Double.isNaN(d4);
                d = d4 + (((d5 - 6500.0d) * (-41.0d)) / 6500.0d);
            } else if (parseInt < 7500) {
                double d6 = parseInt + 150;
                double d7 = parseInt;
                Double.isNaN(d7);
                Double.isNaN(d6);
                d = d6 + (((d7 - 7000.0d) * 27.0d) / 7000.0d);
            } else if (parseInt < 8000) {
                double d8 = parseInt + 50;
                double d9 = parseInt;
                Double.isNaN(d9);
                Double.isNaN(d8);
                d = d8 + (((d9 - 7500.0d) * (-15.0d)) / 7500.0d);
            } else if (parseInt < 8500) {
                double d10 = parseInt + 100;
                double d11 = parseInt;
                Double.isNaN(d11);
                Double.isNaN(d10);
                d = d10 + (((d11 - 8000.0d) * 1.0d) / 8000.0d);
            } else if (parseInt < 9000) {
                double d12 = parseInt + Opcodes.ISHL;
                double d13 = parseInt;
                Double.isNaN(d13);
                Double.isNaN(d12);
                d = d12 + (((d13 - 8500.0d) * 28.0d) / 8500.0d);
            } else if (parseInt < 9500) {
                double d14 = parseInt + 80;
                double d15 = parseInt;
                Double.isNaN(d15);
                Double.isNaN(d14);
                d = d14 + (((d15 - 9000.0d) * 37.0d) / 9000.0d);
            } else if (parseInt < 10000) {
                double d16 = parseInt + 80;
                double d17 = parseInt;
                Double.isNaN(d17);
                Double.isNaN(d16);
                d = d16 + (((d17 - 9500.0d) * (-30.0d)) / 9500.0d);
            } else if (parseInt < 10500) {
                double d18 = parseInt + 100;
                double d19 = parseInt;
                Double.isNaN(d19);
                Double.isNaN(d18);
                d = d18 + (((d19 - 10000.0d) * 28.0d) / 10000.0d);
            } else if (parseInt < 11000) {
                double d20 = parseInt + Opcodes.ISHL;
                double d21 = parseInt;
                Double.isNaN(d21);
                Double.isNaN(d20);
                d = d20 + (((d21 - 10500.0d) * 29.0d) / 10500.0d);
            } else if (parseInt < 11500) {
                double d22 = parseInt + 100;
                double d23 = parseInt;
                Double.isNaN(d23);
                Double.isNaN(d22);
                d = d22 + (((d23 - 11000.0d) * 3.0d) / 11000.0d);
            } else if (parseInt < 12000) {
                double d24 = parseInt + 130;
                double d25 = parseInt;
                Double.isNaN(d25);
                Double.isNaN(d24);
                d = d24 + (((d25 - 11500.0d) * 9.0d) / 11500.0d);
            } else if (parseInt < 12500) {
                double d26 = parseInt + 150;
                double d27 = parseInt;
                Double.isNaN(d27);
                Double.isNaN(d26);
                d = d26 + (((d27 - 12000.0d) * (-20.0d)) / 12000.0d);
            } else if (parseInt < 13000) {
                double d28 = parseInt + 150;
                double d29 = parseInt;
                Double.isNaN(d29);
                Double.isNaN(d28);
                d = d28 + (((d29 - 12500.0d) * 53.0d) / 12500.0d);
            } else if (parseInt < 13500) {
                double d30 = parseInt + Opcodes.GETFIELD;
                double d31 = parseInt;
                Double.isNaN(d31);
                Double.isNaN(d30);
                d = d30 + (((d31 - 13000.0d) * 14.0d) / 13000.0d);
            } else if (parseInt < 14000) {
                double d32 = parseInt + PdfContentParser.COMMAND_TYPE;
                double d33 = parseInt;
                Double.isNaN(d33);
                Double.isNaN(d32);
                d = d32 + (((d33 - 13500.0d) * 18.0d) / 13500.0d);
            } else if (parseInt < 14500) {
                double d34 = parseInt + Type.TSIG;
                double d35 = parseInt;
                Double.isNaN(d35);
                Double.isNaN(d34);
                d = d34 + (((d35 - 14000.0d) * 14.0d) / 14000.0d);
            } else if (parseInt < 15000) {
                double d36 = parseInt + 300;
                double d37 = parseInt;
                Double.isNaN(d37);
                Double.isNaN(d36);
                d = d36 + (((d37 - 14500.0d) * 52.0d) / 14500.0d);
            } else if (parseInt < 15300) {
                double d38 = parseInt + 350;
                double d39 = parseInt;
                Double.isNaN(d39);
                Double.isNaN(d38);
                d = d38 + (((d39 - 15000.0d) * 67.0d) / 15000.0d);
            } else {
                d = parseInt;
            }
            this.f14200a.f14182m = new BigDecimal(((int) d) / 1000.0f).setScale(3, 4).floatValue();
        }
        handler = this.f14200a.f14161B;
        handler.sendEmptyMessage(i);
    }
}
