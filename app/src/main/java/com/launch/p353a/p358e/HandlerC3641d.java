package com.launch.p353a.p358e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.launch.p353a.p359f.ImageManager;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InterstitialAD.java */
/* renamed from: com.launch.a.e.d */
/* loaded from: classes.dex */
public final class HandlerC3641d extends Handler {

    /* renamed from: a */
    final /* synthetic */ InterstitialAD f19894a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3641d(InterstitialAD interstitialAD, Looper looper) {
        super(looper);
        this.f19894a = interstitialAD;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        String string;
        if (message2.what != 0) {
            return;
        }
        InterstitialAD interstitialAD = this.f19894a;
        boolean z = interstitialAD.f19888b.getResources().getConfiguration().orientation == 2;
        ImageView imageView = new ImageView(interstitialAD.f19888b);
        if (interstitialAD.f19889c != null) {
            for (int i = 0; i < interstitialAD.f19889c.length(); i++) {
                if (z) {
                    try {
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (!interstitialAD.f19889c.getJSONObject(i).getString("horImageUrl").isEmpty()) {
                        string = interstitialAD.f19889c.getJSONObject(i).getString("horImageUrl");
                        ImageManager imageManager = new ImageManager(interstitialAD.f19888b);
                        imageManager.f19949a = new C3642e(interstitialAD);
                        imageManager.m2659a(string, imageView);
                    }
                }
                string = interstitialAD.f19889c.getJSONObject(i).getString("imageUrl");
                ImageManager imageManager2 = new ImageManager(interstitialAD.f19888b);
                imageManager2.f19949a = new C3642e(interstitialAD);
                imageManager2.m2659a(string, imageView);
            }
        }
    }
}
