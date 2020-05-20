package com.cnlaunch.x431pro.activity.help;

import android.content.res.AssetManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HelpDocManger.java */
/* renamed from: com.cnlaunch.x431pro.activity.help.g */
/* loaded from: classes.dex */
public final class RunnableC2257g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f12778a;

    /* renamed from: b */
    final /* synthetic */ HelpDocManger f12779b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2257g(HelpDocManger helpDocManger, String str) {
        this.f12779b = helpDocManger;
        this.f12778a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        HashMap hashMap2;
        String[] list;
        HashMap hashMap3;
        String[] list2;
        HashMap hashMap4;
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!this.f12778a.equals(HelpStringConstant.f12806g)) {
            m6915a();
            return;
        }
        AssetManager assetManager = this.f12779b.f12770g;
        try {
            synchronized (HelpDocManger.f12759h) {
                hashMap2 = HelpDocManger.f12762k;
                hashMap2.clear();
                HelpDocManger.f12761j.clear();
                list = assetManager.list("HelpDocSource/module");
            }
            for (String str : list) {
                if (!this.f12779b.f12768e.contains(str)) {
                    synchronized (HelpDocManger.f12759h) {
                        hashMap3 = HelpDocManger.f12762k;
                        if (hashMap3.get(str) == null) {
                            ArrayList arrayList = new ArrayList();
                            for (String str2 : assetManager.list("HelpDocSource/module/" + str)) {
                                arrayList.add("HelpDocSource/module/" + str + "/" + str2);
                                if (HelpDocManger.f12761j.get(str2) != null) {
                                    ((ArrayList) HelpDocManger.f12761j.get(str2)).add("HelpDocSource/module/" + str + "/" + str2);
                                } else {
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add("HelpDocSource/module/" + str + "/" + str2);
                                    HelpDocManger.f12761j.put(str2, arrayList2);
                                }
                            }
                            hashMap4 = HelpDocManger.f12762k;
                            hashMap4.put(str, arrayList);
                        }
                    }
                }
            }
            this.f12779b.f12764a.obtainMessage(1).sendToTarget();
        } catch (IOException unused) {
            hashMap = HelpDocManger.f12762k;
            hashMap.clear();
            HelpDocManger.f12761j.clear();
        }
    }

    /* renamed from: a */
    private void m6915a() {
        String[] list;
        AssetManager assetManager = this.f12779b.f12770g;
        try {
            synchronized (HelpDocManger.f12760i) {
                list = assetManager.list("HelpDocSource/QuestionAnswer");
            }
            synchronized (HelpDocManger.f12760i) {
                HelpDocManger.f12763l.clear();
                for (String str : list) {
                    if (HelpDocManger.f12763l.get(str) != null) {
                        ((ArrayList) HelpDocManger.f12763l.get(str)).add("HelpDocSource/QuestionAnswer/" + str);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("HelpDocSource/QuestionAnswer/" + str);
                        HelpDocManger.f12763l.put(str, arrayList);
                    }
                }
            }
            this.f12779b.f12764a.obtainMessage(3).sendToTarget();
        } catch (IOException unused) {
            synchronized (HelpDocManger.f12760i) {
                HelpDocManger.f12763l.clear();
            }
        }
    }
}
