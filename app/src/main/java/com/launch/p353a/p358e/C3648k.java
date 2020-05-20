package com.launch.p353a.p358e;

import com.launch.p353a.p362i.IHttpFinishedListener;
import com.launch.p353a.p364k.C3669j;
import com.unionpay.tsmservice.data.AppStatus;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InterstitialAD.java */
/* renamed from: com.launch.a.e.k */
/* loaded from: classes.dex */
public final class C3648k implements IHttpFinishedListener {

    /* renamed from: a */
    final /* synthetic */ InterstitialAD f19903a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3648k(InterstitialAD interstitialAD) {
        this.f19903a = interstitialAD;
    }

    @Override // com.launch.p353a.p362i.IHttpFinishedListener
    /* renamed from: a */
    public final void mo2650a(Object obj) {
        try {
            new StringBuilder("onSuccess===").append(obj);
            JSONObject jSONObject = new JSONObject(obj.toString());
            String string = jSONObject.getString("code");
            if ("0000".equals(string)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(DataPacketExtension.ELEMENT_NAME);
                this.f19903a.f19889c = jSONObject2.getJSONArray("adinfos");
                if (this.f19903a.f19889c.length() > 0) {
                    String m2694a = this.f19903a.m2694a("updateTime");
                    String m2694a2 = this.f19903a.m2694a("exposureTime");
                    String string2 = jSONObject2.getString("showRuleUpdateTime");
                    String string3 = jSONObject2.getString("showFrequencyType");
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis() / 1000);
                    String sb2 = sb.toString();
                    if (m2694a2.equals("")) {
                        this.f19903a.m2693a("updateTime", jSONObject2.getString("showRuleUpdateTime"));
                        this.f19903a.f19891e.sendEmptyMessage(0);
                        return;
                    } else if (m2694a.equals("")) {
                        return;
                    } else {
                        if (!m2694a.equals(string2)) {
                            this.f19903a.m2693a("updateTime", jSONObject2.getString("showRuleUpdateTime"));
                            this.f19903a.f19891e.sendEmptyMessage(0);
                            return;
                        }
                        String m2694a3 = this.f19903a.m2694a("exposureTime");
                        char c = 65535;
                        boolean z = true;
                        switch (string3.hashCode()) {
                            case 1537:
                                if (string3.equals("01")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 1538:
                                if (string3.equals("02")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 1539:
                                if (string3.equals("03")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 1540:
                                if (string3.equals("04")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 1541:
                                if (string3.equals(AppStatus.OPEN)) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case 1542:
                                if (string3.equals(AppStatus.APPLY)) {
                                    c = 5;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                z = false;
                                break;
                            case 1:
                                if (m2694a3.equals("")) {
                                    z = false;
                                    break;
                                }
                                break;
                            case 2:
                                if (C3669j.m2619b(m2694a3) != C3669j.m2619b(sb2)) {
                                    z = false;
                                    break;
                                }
                                break;
                            case 3:
                                if (C3669j.m2618c(m2694a3) != C3669j.m2618c(sb2)) {
                                    z = false;
                                    break;
                                }
                                break;
                            case 4:
                                if (C3669j.m2617d(m2694a3) != C3669j.m2617d(sb2)) {
                                    z = false;
                                    break;
                                }
                                break;
                            case 5:
                                if (C3669j.m2616e(m2694a3) != C3669j.m2616e(sb2)) {
                                    z = false;
                                    break;
                                }
                                break;
                        }
                        if (z) {
                            return;
                        }
                        this.f19903a.f19891e.sendEmptyMessage(0);
                        return;
                    }
                }
                AbstractInterstitialADListener abstractInterstitialADListener = this.f19903a.f19887a;
                Integer.parseInt(string);
                InterstitialAD.m2695a(abstractInterstitialADListener);
                return;
            }
            AbstractInterstitialADListener abstractInterstitialADListener2 = this.f19903a.f19887a;
            Integer.parseInt(string);
            InterstitialAD.m2695a(abstractInterstitialADListener2);
        } catch (Exception e) {
            InterstitialAD.m2695a(this.f19903a.f19887a);
            e.printStackTrace();
        }
    }

    @Override // com.launch.p353a.p362i.IHttpFinishedListener
    /* renamed from: a */
    public final void mo2649a(String str, int i) {
        InterstitialAD.m2695a(this.f19903a.f19887a);
        StringBuilder sb = new StringBuilder("onError===");
        sb.append(str);
        sb.append(i);
    }
}
