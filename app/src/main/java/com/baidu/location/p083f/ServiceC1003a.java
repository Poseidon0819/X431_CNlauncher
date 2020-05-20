package com.baidu.location.p083f;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.location.LLSInterface;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.indoor.C1026d;
import com.baidu.location.p078a.C0892a;
import com.baidu.location.p078a.C0895b;
import com.baidu.location.p078a.C0900d;
import com.baidu.location.p078a.C0905f;
import com.baidu.location.p078a.C0910h;
import com.baidu.location.p078a.C0919j;
import com.baidu.location.p078a.C0923k;
import com.baidu.location.p078a.C0925m;
import com.baidu.location.p078a.C0931o;
import com.baidu.location.p078a.C0932p;
import com.baidu.location.p079b.C0934a;
import com.baidu.location.p079b.C0936b;
import com.baidu.location.p079b.C0939c;
import com.baidu.location.p079b.C0941d;
import com.baidu.location.p079b.C0943e;
import com.baidu.location.p079b.C0944f;
import com.baidu.location.p079b.C0948g;
import com.baidu.location.p081d.C0955a;
import com.baidu.location.p081d.C0969d;
import com.baidu.location.p082e.C0987b;
import com.baidu.location.p082e.C0991d;
import com.baidu.location.p082e.C0998f;
import com.baidu.location.p084g.C1006b;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.lang.ref.WeakReference;

/* renamed from: com.baidu.location.f.a */
/* loaded from: classes.dex */
public class ServiceC1003a extends Service implements LLSInterface {

    /* renamed from: a */
    static HandlerC1004a f4474a;

    /* renamed from: f */
    private static long f4475f;

    /* renamed from: c */
    private Looper f4477c;

    /* renamed from: d */
    private HandlerThread f4478d;

    /* renamed from: b */
    Messenger f4476b = null;

    /* renamed from: e */
    private boolean f4479e = false;

    /* renamed from: com.baidu.location.f.a$a */
    /* loaded from: classes.dex */
    public static class HandlerC1004a extends Handler {

        /* renamed from: a */
        private final WeakReference<ServiceC1003a> f4480a;

        public HandlerC1004a(Looper looper, ServiceC1003a serviceC1003a) {
            super(looper);
            this.f4480a = new WeakReference<>(serviceC1003a);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            ServiceC1003a serviceC1003a = this.f4480a.get();
            if (serviceC1003a == null) {
                return;
            }
            if (ServiceC1002f.isServing) {
                switch (message2.what) {
                    case 11:
                        serviceC1003a.m11613a(message2);
                        break;
                    case 12:
                        serviceC1003a.m11609b(message2);
                        break;
                    case 15:
                        serviceC1003a.m11605c(message2);
                        break;
                    case 22:
                        C0919j.m12105c().m12110b(message2);
                        break;
                    case 28:
                        C0919j.m12105c().m12111a(true, true);
                        break;
                    case 41:
                        C0919j.m12105c().m12088i();
                        break;
                    case 110:
                        C1026d.m11499a().m11470c();
                        break;
                    case 111:
                        C1026d.m11499a().m11465d();
                        break;
                    case 112:
                        C1026d.m11499a().m11479b();
                        break;
                    case MetaDo.META_SETTEXTALIGN /* 302 */:
                        C1026d.m11499a().m11460e();
                        break;
                    case 401:
                        try {
                            message2.getData();
                            break;
                        } catch (Exception unused) {
                            break;
                        }
                    case 405:
                        byte[] byteArray = message2.getData().getByteArray("errorid");
                        if (byteArray != null && byteArray.length > 0) {
                            new String(byteArray);
                            break;
                        }
                        break;
                    case 406:
                        C0905f.m12169a().m12157e();
                        break;
                }
            }
            if (message2.what == 1) {
                serviceC1003a.m11606c();
            }
            if (message2.what == 0) {
                serviceC1003a.m11610b();
            }
            super.handleMessage(message2);
        }
    }

    /* renamed from: a */
    public static long m11614a() {
        return f4475f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11613a(Message message2) {
        Log.d("baidu_location_service", "baidu location service register ...");
        C0892a.m12261a().m12259a(message2);
        C0969d.m11810a();
        C0941d.m11996a().m11984d();
        C0925m.m12066b().m12064c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11610b() {
        C0910h.m12149a().m12148a(ServiceC1002f.getServiceContext());
        C0923k.m12082a().m12081b();
        C0905f.m12169a().m12162b();
        C0991d.m11704a().m11689b();
        C0987b.m11732a().m11724b();
        C1006b.m11603a();
        C0919j.m12105c().m12100d();
        C0955a.m11938a().m11924b();
        C0939c.m12005a().m12001b();
        C0941d.m11996a().m11989b();
        C0943e.m11976a().m11972b();
        C0934a.m12027a().m12021b();
        C0944f.m11971a().m11966b();
        C0998f.m11640a().m11633c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11609b(Message message2) {
        C0892a.m12261a().m12252b(message2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11606c() {
        C0998f.m11640a().m11631e();
        C0969d.m11810a().m11789n();
        C0991d.m11704a().m11674e();
        C0948g.m11961a().m11956c();
        C0941d.m11996a().m11986c();
        C0939c.m12005a().m12000c();
        C0936b.m12017a().m12012c();
        C0934a.m12027a().m12019c();
        C0895b.m12229a().m12227b();
        C0987b.m11732a().m11721c();
        C0919j.m12105c().m12096e();
        C1026d.m11499a().m11465d();
        C0905f.m12169a().m12160c();
        C0932p.m12031e();
        C0892a.m12261a().m12253b();
        C0900d.m12208a().m12199b();
        C0923k.m12082a().m12080c();
        Log.d("baidu_location_service", "baidu location service has stoped ...");
        if (this.f4479e) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11605c(Message message2) {
        C0892a.m12261a().m12248c(message2);
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 7.510000228881836d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        boolean z;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            C1006b.f4493g = extras.getString("key");
            C1006b.f4492f = extras.getString("sign");
            this.f4479e = extras.getBoolean("kill_process");
            z = extras.getBoolean("cache_exception");
        } else {
            z = false;
        }
        if (!z) {
            Thread.setDefaultUncaughtExceptionHandler(C0943e.m11976a());
        }
        return this.f4476b.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        f4475f = System.currentTimeMillis();
        this.f4478d = C0931o.m12049a();
        this.f4477c = this.f4478d.getLooper();
        Looper looper = this.f4477c;
        if (looper == null) {
            f4474a = new HandlerC1004a(Looper.getMainLooper(), this);
        } else {
            f4474a = new HandlerC1004a(looper, this);
        }
        this.f4476b = new Messenger(f4474a);
        f4474a.sendEmptyMessage(0);
        Log.d("baidu_location_service", "baidu location service start1 ...20171027..." + Process.myPid());
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        try {
            f4474a.sendEmptyMessage(1);
        } catch (Exception unused) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            m11606c();
            Process.killProcess(Process.myPid());
        }
        Log.d("baidu_location_service", "baidu location service stop ...");
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onTaskRemoved(Intent intent) {
        Log.d("baidu_location_service", "baidu location service remove task...");
    }

    @Override // com.baidu.location.LLSInterface
    public boolean onUnBind(Intent intent) {
        return false;
    }
}
