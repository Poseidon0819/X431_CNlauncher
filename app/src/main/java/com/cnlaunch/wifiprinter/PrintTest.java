package com.cnlaunch.wifiprinter;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.wifiprinter.C1900at;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import okhttp3.internal.http.StatusLine;
import org.codehaus.jackson.smile.SmileConstants;

/* renamed from: com.cnlaunch.wifiprinter.o */
/* loaded from: classes.dex */
public final class PrintTest extends Fragment {

    /* renamed from: A */
    private String f10462A;

    /* renamed from: B */
    private String f10463B;

    /* renamed from: C */
    private MulticastSocket f10464C;

    /* renamed from: a */
    Bitmap f10465a;

    /* renamed from: d */
    LinearLayout f10468d;

    /* renamed from: e */
    Button f10469e;

    /* renamed from: f */
    Button f10470f;

    /* renamed from: g */
    Button f10471g;

    /* renamed from: h */
    Button f10472h;

    /* renamed from: k */
    String f10475k;

    /* renamed from: l */
    String f10476l;

    /* renamed from: m */
    String f10477m;

    /* renamed from: q */
    Context f10481q;

    /* renamed from: r */
    LinearLayout f10482r;

    /* renamed from: s */
    Button f10483s;

    /* renamed from: t */
    Button f10484t;

    /* renamed from: z */
    private WifiManager f10490z;

    /* renamed from: b */
    DataOutputStream f10466b = null;

    /* renamed from: c */
    DataInputStream f10467c = null;

    /* renamed from: i */
    TextView f10473i = null;

    /* renamed from: j */
    TextView f10474j = null;

    /* renamed from: n */
    Thread f10478n = null;

    /* renamed from: o */
    Thread f10479o = null;

    /* renamed from: p */
    Thread f10480p = null;

    /* renamed from: u */
    boolean f10485u = false;

    /* renamed from: v */
    boolean f10486v = true;

    /* renamed from: w */
    boolean f10487w = true;

    /* renamed from: x */
    boolean f10488x = true;

    /* renamed from: y */
    Handler f10489y = new HandlerC1929p(this);

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10481q = getActivity();
        View inflate = layoutInflater.cloneInContext(Constant.f10351f).inflate(C1900at.C1906f.activity_print_test, viewGroup, false);
        this.f10482r = (LinearLayout) inflate.findViewById(C1900at.C1905e.line2btn);
        this.f10482r.setVisibility(8);
        this.f10483s = (Button) inflate.findViewById(C1900at.C1905e.btnSettin);
        this.f10484t = (Button) inflate.findViewById(C1900at.C1905e.check);
        this.f10470f = (Button) inflate.findViewById(C1900at.C1905e.btnWord);
        this.f10471g = (Button) inflate.findViewById(C1900at.C1905e.btnBmp);
        this.f10472h = (Button) inflate.findViewById(C1900at.C1905e.btnHelp);
        this.f10469e = (Button) inflate.findViewById(C1900at.C1905e.btnFind);
        this.f10468d = (LinearLayout) inflate.findViewById(C1900at.C1905e.linefind);
        this.f10470f.setOnClickListener(new View$OnClickListenerC1925a());
        this.f10471g.setOnClickListener(new View$OnClickListenerC1925a());
        this.f10472h.setOnClickListener(new View$OnClickListenerC1925a());
        this.f10469e.setOnClickListener(new View$OnClickListenerC1925a());
        this.f10483s.setOnClickListener(new View$OnClickListenerC1925a());
        this.f10484t.setOnClickListener(new View$OnClickListenerC1925a());
        this.f10473i = (TextView) inflate.findViewById(C1900at.C1905e.show);
        this.f10474j = (TextView) inflate.findViewById(C1900at.C1905e.connectinfo);
        this.f10475k = MySharedPreferences.m8003a(this.f10481q, "SSID");
        this.f10476l = MySharedPreferences.m8003a(this.f10481q, "Style");
        this.f10477m = MySharedPreferences.m8003a(this.f10481q, "PassWord");
        this.f10468d.setVisibility(8);
        this.f10473i.setText(this.f10481q.getResources().getString(C1900at.C1907g.find_printer));
        if (this.f10475k != null) {
            this.f10486v = true;
        } else {
            new Timer().schedule(new C1931r(this), 4000L);
        }
        this.f10470f.setVisibility(8);
        try {
            this.f10464C = new MulticastSocket();
            this.f10464C.setSoTimeout(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f10490z = (WifiManager) this.f10481q.getSystemService("wifi");
        if (!this.f10490z.isWifiEnabled()) {
            this.f10490z.setWifiEnabled(true);
        }
        this.f10489y.sendEmptyMessage(StatusLine.HTTP_PERM_REDIRECT);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7992b() {
        this.f10473i.setTextColor(this.f10481q.getResources().getColor(C1900at.C1902b.black));
        this.f10480p = new C1926b(this.f10464C);
        this.f10480p.start();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new C1932s(this).start();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        this.f10486v = true;
        this.f10487w = true;
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrintTest.java */
    /* renamed from: com.cnlaunch.wifiprinter.o$b */
    /* loaded from: classes.dex */
    public class C1926b extends Thread {

        /* renamed from: a */
        MulticastSocket f10492a;

        C1926b(MulticastSocket multicastSocket) {
            this.f10492a = multicastSocket;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            byte[] bArr = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 1024);
            long currentTimeMillis = System.currentTimeMillis() + 12000;
            do {
                try {
                    this.f10492a.receive(datagramPacket);
                    InetAddress address = datagramPacket.getAddress();
                    PrintTest.this.f10462A = address.toString().substring(1);
                    PrintTest.this.f10463B = new String(bArr, 0, datagramPacket.getLength());
                    if (PrintTest.this.f10463B.indexOf("HLK-") != -1) {
                        int indexOf = PrintTest.this.f10463B.indexOf("(");
                        PrintTest printTest = PrintTest.this;
                        printTest.f10463B = "X-431Printer" + PrintTest.this.f10463B.substring(indexOf);
                        PrintTest.this.f10485u = true;
                        Message message2 = new Message();
                        message2.what = 304;
                        message2.obj = PrintTest.this.f10481q.getResources().getString(C1900at.C1907g.FindPrinterOK) + ":\r\n" + PrintTest.this.f10463B + "  IP:" + PrintTest.this.f10462A;
                        PrintTest.this.f10489y.sendMessage(message2);
                        Intent intent = new Intent();
                        intent.setAction("WifiprinterIP");
                        intent.putExtra("strIP", PrintTest.this.f10462A);
                        PrintTest.this.f10481q.sendBroadcast(intent);
                        return;
                    }
                } catch (Exception e) {
                    if (PrintTest.this.f10485u) {
                        return;
                    }
                    Message message3 = new Message();
                    message3.what = TIFFConstants.TIFFTAG_DATETIME;
                    message3.obj = PrintTest.this.f10481q.getResources().getString(C1900at.C1907g.FindPrinterFailed);
                    PrintTest.this.f10489y.sendMessage(message3);
                    e.printStackTrace();
                    return;
                }
            } while (System.currentTimeMillis() <= currentTimeMillis);
            Message message4 = new Message();
            message4.what = TIFFConstants.TIFFTAG_DATETIME;
            message4.obj = PrintTest.this.f10481q.getResources().getString(C1900at.C1907g.FindPrinterFailed);
            PrintTest.this.f10489y.sendMessage(message4);
        }
    }

    /* compiled from: PrintTest.java */
    /* renamed from: com.cnlaunch.wifiprinter.o$a */
    /* loaded from: classes.dex */
    class View$OnClickListenerC1925a implements View.OnClickListener {
        View$OnClickListenerC1925a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view == PrintTest.this.f10469e) {
                PrintTest printTest = PrintTest.this;
                printTest.f10488x = false;
                printTest.m8000a();
            }
            if (view == PrintTest.this.f10470f) {
                PrintTest printTest2 = PrintTest.this;
                printTest2.f10488x = true;
                printTest2.m8000a();
            } else if (view == PrintTest.this.f10471g) {
                PrintTest printTest3 = PrintTest.this;
                View decorView = printTest3.getActivity().getWindow().getDecorView();
                decorView.setDrawingCacheEnabled(true);
                printTest3.f10465a = decorView.getDrawingCache();
                PrintTest printTest4 = PrintTest.this;
                printTest4.f10465a = PrintTest.m7998a(printTest4.f10465a);
                PrintTest printTest5 = PrintTest.this;
                printTest5.f10465a = PrintTest.m7991b(printTest5.f10465a);
                PrintTest.this.f10471g.setClickable(false);
                PrintTest printTest6 = PrintTest.this;
                printTest6.f10479o = new C1927c(printTest6.f10462A);
                PrintTest.this.f10479o.start();
            } else if (view == PrintTest.this.f10472h) {
                Bundle bundle = new Bundle();
                bundle.putInt("PAGE", 3);
                HelpActivity helpActivity = new HelpActivity();
                helpActivity.setStyle(1, 0);
                helpActivity.setArguments(bundle);
                helpActivity.show(PrintTest.this.getFragmentManager(), HelpActivity.class.getName());
            } else if (view == PrintTest.this.f10483s) {
                PrintTest.this.f10474j.setText("");
                PrintTest.this.f10473i.setText("");
                PrintTest.this.f10482r.setVisibility(8);
                Intent intent = new Intent();
                intent.setAction("WifiprinterStep");
                intent.putExtra("step", 4);
                PrintTest.this.f10481q.sendBroadcast(intent);
            } else if (view == PrintTest.this.f10484t) {
                PrintTest.this.f10474j.setText("");
                PrintTest.this.f10473i.setText("");
                PrintTest.this.f10482r.setVisibility(8);
                Intent intent2 = new Intent();
                intent2.setAction("WifiprinterStep");
                intent2.putExtra("step", 1);
                PrintTest.this.f10481q.sendBroadcast(intent2);
            }
        }
    }

    /* renamed from: a */
    public final void m8000a() {
        this.f10474j.setText("");
        this.f10468d.setVisibility(8);
        this.f10482r.setVisibility(8);
        this.f10470f.setVisibility(8);
        this.f10473i.setText(this.f10481q.getResources().getString(C1900at.C1907g.find_printer));
        this.f10469e.setEnabled(false);
        m7992b();
    }

    /* compiled from: PrintTest.java */
    /* renamed from: com.cnlaunch.wifiprinter.o$d */
    /* loaded from: classes.dex */
    class C1928d extends Thread {

        /* renamed from: a */
        String f10496a;

        /* renamed from: b */
        String f10497b;

        public C1928d(String str, String str2) {
            this.f10496a = str;
            this.f10497b = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int m7993a = PrintTest.m7993a(this.f10496a, this.f10497b);
            PrintTest.this.m7999a(m7993a);
            PrintTest.this.f10489y.obtainMessage(TIFFConstants.TIFFTAG_SOFTWARE, Integer.valueOf(m7993a)).sendToTarget();
        }
    }

    /* renamed from: a */
    public static int m7993a(String str, String str2) {
        try {
            Socket socket = new Socket(str, 7001);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.write(str2);
            printWriter.flush();
            printWriter.close();
            socket.close();
            return 0;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return 4094;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 4094;
        }
    }

    /* compiled from: PrintTest.java */
    /* renamed from: com.cnlaunch.wifiprinter.o$c */
    /* loaded from: classes.dex */
    class C1927c extends Thread {

        /* renamed from: a */
        String f10494a;

        public C1927c(String str) {
            this.f10494a = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int m7994a = PrintTest.this.m7994a(this.f10494a);
            PrintTest.this.m7999a(m7994a);
            PrintTest.this.f10489y.obtainMessage(TIFFConstants.TIFFTAG_SOFTWARE, Integer.valueOf(m7994a)).sendToTarget();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0128 -> B:52:0x012c). Please submit an issue!!! */
    /* renamed from: a */
    public final int m7994a(String str) {
        try {
            Socket socket = new Socket(str, 7001);
            this.f10466b = new DataOutputStream(socket.getOutputStream());
            this.f10467c = new DataInputStream(socket.getInputStream());
            byte[] bArr = {27, 51, 0};
            try {
                this.f10466b.write(bArr, 0, 3);
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                byte[] bArr2 = {27, 74, 0};
                byte[] bArr3 = {29, 114, 73};
                int i = 5;
                byte[] bArr4 = {27, 42, 0, 0, 0};
                bArr4[2] = SmileConstants.TOKEN_LITERAL_NULL;
                bArr4[3] = (byte) (this.f10465a.getWidth() % 256);
                bArr4[4] = (byte) (this.f10465a.getWidth() / 256);
                int i2 = 0;
                while (true) {
                    int i3 = 24;
                    if (i2 >= (this.f10465a.getHeight() / 24) + 1) {
                        break;
                    }
                    try {
                        this.f10466b.write(bArr4, 0, i);
                        int i4 = 0;
                        while (i4 < this.f10465a.getWidth()) {
                            int i5 = 0;
                            while (i5 < i3) {
                                int i6 = (i2 * 24) + i5;
                                if (i6 < this.f10465a.getHeight() && Color.red(this.f10465a.getPixel(i4, i6)) == 0) {
                                    int i7 = i5 / 8;
                                    bArr[i7] = (byte) (bArr[i7] + ((byte) (128 >> (i5 % 8))));
                                }
                                i5++;
                                i3 = 24;
                            }
                            try {
                                this.f10466b.write(bArr, 0, 3);
                                bArr[0] = 0;
                                bArr[1] = 0;
                                bArr[2] = 0;
                                i4++;
                                i3 = 24;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return 4095;
                            }
                        }
                        try {
                            if (i2 % 10 == 0) {
                                this.f10466b.write(bArr3);
                                if (this.f10467c.readByte() == 0) {
                                    this.f10466b.write(bArr2, 0, 3);
                                }
                            } else {
                                this.f10466b.write(bArr2, 0, 3);
                            }
                            i2++;
                            i = 5;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return 4095;
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return 4095;
                    }
                }
                byte[] bArr5 = {27, 74, 64};
                try {
                    this.f10466b.write(new byte[]{29, 122, 49});
                    this.f10466b.write(bArr5);
                    byte readByte = this.f10467c.readByte();
                    try {
                        try {
                            try {
                                this.f10466b.close();
                                this.f10467c.close();
                                socket.close();
                            } catch (Throwable th) {
                                try {
                                    socket.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                                throw th;
                            }
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            socket.close();
                        }
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    return readByte;
                } catch (IOException unused) {
                    return 4095;
                }
            } catch (IOException e7) {
                e7.printStackTrace();
                return 4095;
            }
        } catch (UnknownHostException e8) {
            e8.printStackTrace();
            return 4094;
        } catch (IOException e9) {
            e9.printStackTrace();
            return 4094;
        }
    }

    /* renamed from: a */
    public static Bitmap m7998a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(384.0f / width, ((height * 384) / width) / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* renamed from: b */
    public static Bitmap m7991b(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        bitmap.getPixels(new int[width * height], 0, width, 0, 0, width, height);
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                int pixel = bitmap.getPixel(i2, i);
                if (((((16711680 & pixel) >> 16) + ((65280 & pixel) >> 8)) + (pixel & 255)) / 3 < 100) {
                    bitmap.setPixel(i2, i, -16777216);
                } else {
                    bitmap.setPixel(i2, i, -1);
                }
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    public final void m7999a(int i) {
        new Handler(Looper.getMainLooper()).post(new RunnableC1933t(this, i));
    }
}
