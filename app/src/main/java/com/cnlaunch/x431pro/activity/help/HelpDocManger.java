package com.cnlaunch.x431pro.activity.help;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.cnlaunch.x431pro.activity.help.f */
/* loaded from: classes.dex */
public final class HelpDocManger {

    /* renamed from: h */
    private static Object f12759h = new Object();

    /* renamed from: i */
    private static Object f12760i = new Object();

    /* renamed from: j */
    private static HashMap<String, ArrayList<String>> f12761j = new HashMap<>();

    /* renamed from: k */
    private static HashMap<String, ArrayList<String>> f12762k = new HashMap<>();

    /* renamed from: l */
    private static HashMap<String, ArrayList<String>> f12763l = new HashMap<>();

    /* renamed from: a */
    protected HandlerC2255a f12764a;

    /* renamed from: b */
    protected Handler f12765b;

    /* renamed from: c */
    RunnableC2256b f12766c;

    /* renamed from: d */
    RunnableC2256b f12767d;

    /* renamed from: e */
    ArrayList<String> f12768e;

    /* renamed from: f */
    String f12769f;

    /* renamed from: g */
    AssetManager f12770g;

    /* renamed from: m */
    private stHelpDoc f12771m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HelpDocManger(AssetManager assetManager, String str, String str2) {
        this(assetManager, str, str2, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HelpDocManger(AssetManager assetManager, String str, String str2, ArrayList<String> arrayList) {
        this.f12770g = assetManager;
        this.f12769f = str2;
        this.f12768e = arrayList;
        this.f12764a = new HandlerC2255a(this, (byte) 0);
        this.f12771m = stHelpDoc.m6884a();
        m6922a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m6924a(Handler handler) {
        this.f12765b = handler;
    }

    /* renamed from: a */
    public final void m6922a(String str) {
        new Thread(new RunnableC2257g(this, str)).start();
    }

    /* compiled from: HelpDocManger.java */
    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.cnlaunch.x431pro.activity.help.f$a */
    /* loaded from: classes.dex */
    class HandlerC2255a extends Handler {
        private HandlerC2255a() {
        }

        /* synthetic */ HandlerC2255a(HelpDocManger helpDocManger, byte b) {
            this();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            super.handleMessage(message2);
            if (message2.what == 0) {
                Bundle data = message2.getData();
                Message obtainMessage = HelpDocManger.this.f12765b.obtainMessage(0);
                obtainMessage.setData(data);
                obtainMessage.sendToTarget();
            } else if (message2.what == 1) {
                HelpDocManger helpDocManger = HelpDocManger.this;
                if (helpDocManger.f12766c != null) {
                    helpDocManger.f12766c.m6917a();
                }
                helpDocManger.f12766c = new RunnableC2256b(helpDocManger.f12769f, HelpStringConstant.f12806g);
                new Thread(helpDocManger.f12766c).start();
            } else if (message2.what == 2) {
                Bundle data2 = message2.getData();
                Message obtainMessage2 = HelpDocManger.this.f12765b.obtainMessage(2);
                obtainMessage2.setData(data2);
                obtainMessage2.sendToTarget();
            } else if (message2.what == 3) {
                HelpDocManger helpDocManger2 = HelpDocManger.this;
                if (helpDocManger2.f12767d != null) {
                    helpDocManger2.f12767d.m6917a();
                }
                helpDocManger2.f12767d = new RunnableC2256b(helpDocManger2.f12769f, HelpStringConstant.f12807h);
                new Thread(helpDocManger2.f12767d).start();
            }
        }
    }

    /* compiled from: HelpDocManger.java */
    /* renamed from: com.cnlaunch.x431pro.activity.help.f$b */
    /* loaded from: classes.dex */
    class RunnableC2256b implements Runnable {

        /* renamed from: b */
        private String f12774b;

        /* renamed from: c */
        private String f12775c;

        /* renamed from: d */
        private boolean f12776d = false;

        /* renamed from: e */
        private Object f12777e = new Object();

        public RunnableC2256b(String str, String str2) {
            this.f12774b = str;
            this.f12775c = str2;
        }

        /* renamed from: a */
        public final void m6917a() {
            synchronized (this.f12777e) {
                this.f12776d = true;
            }
        }

        /* renamed from: b */
        private boolean m6916b() {
            boolean z;
            synchronized (this.f12777e) {
                z = this.f12776d;
            }
            return z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this.f12777e) {
                if (this.f12775c.equalsIgnoreCase(HelpStringConstant.f12806g)) {
                    ArrayList<HelpFileInfo> arrayList = new ArrayList<>();
                    ArrayList<HelpFileInfo> arrayList2 = new ArrayList<>();
                    synchronized (HelpDocManger.f12759h) {
                        ArrayList arrayList3 = (ArrayList) HelpDocManger.f12761j.get(this.f12774b);
                        if (!HelpDocManger.f12761j.containsKey(this.f12774b)) {
                            arrayList3 = (ArrayList) HelpDocManger.f12761j.get("en");
                        }
                        if (arrayList3 != null) {
                            Iterator it = arrayList3.iterator();
                            while (it.hasNext()) {
                                HelpDocManger.this.f12771m.m6882a(HelpDocManger.this.f12770g, (String) it.next(), arrayList, arrayList2);
                            }
                        }
                    }
                    if (!m6916b()) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList(HelpStringConstant.f12803d, arrayList2);
                        bundle.putParcelableArrayList(HelpStringConstant.f12804e, arrayList);
                        Message obtainMessage = HelpDocManger.this.f12764a.obtainMessage(0);
                        obtainMessage.setData(bundle);
                        obtainMessage.sendToTarget();
                    }
                } else {
                    ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>();
                    synchronized (HelpDocManger.f12760i) {
                        ArrayList arrayList5 = (ArrayList) HelpDocManger.f12763l.get(this.f12774b);
                        if (!HelpDocManger.f12763l.containsKey(this.f12774b)) {
                            arrayList5 = (ArrayList) HelpDocManger.f12763l.get("en");
                        }
                        if (arrayList5 != null) {
                            Iterator it2 = arrayList5.iterator();
                            while (it2.hasNext()) {
                                stHelpDoc unused = HelpDocManger.this.f12771m;
                                stHelpDoc.m6883a(HelpDocManger.this.f12770g, (String) it2.next(), (ArrayList<HelpFileInfo>) arrayList4);
                            }
                        }
                    }
                    if (!m6916b()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelableArrayList(HelpStringConstant.f12805f, arrayList4);
                        Message obtainMessage2 = HelpDocManger.this.f12764a.obtainMessage(2);
                        obtainMessage2.setData(bundle2);
                        obtainMessage2.sendToTarget();
                    }
                }
            }
        }
    }
}
