package com.cnlaunch.p169im.p170a;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.cnlaunch.x431pro.activity.golo.function.GoloFunctionActivity;
import com.itextpdf.text.Annotation;
import message.model.ChatMessage;
import org.json.JSONArray;

/* compiled from: ChatMessageAdapter.java */
/* renamed from: com.cnlaunch.im.a.c */
/* loaded from: classes.dex */
final class View$OnClickListenerC1679c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatMessage f8964a;

    /* renamed from: b */
    final /* synthetic */ ChatMessageAdapter f8965b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1679c(ChatMessageAdapter chatMessageAdapter, ChatMessage chatMessage) {
        this.f8965b = chatMessageAdapter;
        this.f8964a = chatMessage;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        try {
            String string = new JSONArray(this.f8964a.m192p().getString("news")).getJSONObject(0).getString("content_url");
            Log.i("Sanda", "new :".concat(String.valueOf(string)));
            context = this.f8965b.f8939v;
            Intent intent = new Intent(context, GoloFunctionActivity.class);
            intent.setAction("ACTION_REPORT");
            intent.putExtra(Annotation.URL, string);
            context2 = this.f8965b.f8939v;
            context2.startActivity(intent);
        } catch (Exception e) {
            Log.e("Sanda", "new:" + e.getMessage());
        }
    }
}
