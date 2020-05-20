package com.cnlaunch.p188n.p190b;

import android.os.Handler;
import android.os.Message;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.n.b.f */
/* loaded from: classes.dex */
public class FeedbackDiagControler {

    /* renamed from: b */
    private static FeedbackDiagControler f9581b;

    /* renamed from: a */
    public Handler f9582a;

    /* renamed from: a */
    public static FeedbackDiagControler m8576a() {
        if (f9581b == null) {
            synchronized (FeedbackDiagControler.class) {
                if (f9581b == null) {
                    f9581b = new FeedbackDiagControler();
                }
            }
        }
        return f9581b;
    }

    /* renamed from: a */
    public final void m8575a(JSONObject jSONObject) {
        Message obtain = Message.obtain();
        try {
            if (jSONObject.has("remote_data_type") && "dynamic_event".equals(jSONObject.getString("remote_data_type"))) {
                obtain.what = 12310;
                obtain.obj = jSONObject;
            } else {
                obtain.what = 12309;
                obtain.obj = jSONObject.toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Handler handler = this.f9582a;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }
}
