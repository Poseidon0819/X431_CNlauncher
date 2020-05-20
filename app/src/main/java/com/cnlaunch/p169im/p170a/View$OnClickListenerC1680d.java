package com.cnlaunch.p169im.p170a;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.cnlaunch.x431pro.activity.golo.function.GoloFunctionActivity;
import com.itextpdf.text.Annotation;
import org.json.JSONObject;

/* compiled from: ChatMessageAdapter.java */
/* renamed from: com.cnlaunch.im.a.d */
/* loaded from: classes.dex */
final class View$OnClickListenerC1680d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JSONObject f8966a;

    /* renamed from: b */
    final /* synthetic */ ChatMessageAdapter f8967b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1680d(ChatMessageAdapter chatMessageAdapter, JSONObject jSONObject) {
        this.f8967b = chatMessageAdapter;
        this.f8966a = jSONObject;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        try {
            String string = this.f8966a.getString("content_url");
            Log.i("Sanda", "new :".concat(String.valueOf(string)));
            context = this.f8967b.f8939v;
            Intent intent = new Intent(context, GoloFunctionActivity.class);
            intent.setAction("ACTION_REPORT");
            intent.putExtra(Annotation.URL, string);
            context2 = this.f8967b.f8939v;
            context2.startActivity(intent);
        } catch (Exception e) {
            Log.e("Sanda", "new:" + e.getMessage());
        }
    }
}
