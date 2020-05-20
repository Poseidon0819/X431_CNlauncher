package com.cnlaunch.x431pro.activity.golo.others;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrderDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.golo.others.i */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2243i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f12684a;

    /* renamed from: b */
    final /* synthetic */ String f12685b;

    /* renamed from: c */
    final /* synthetic */ OrderDialog f12686c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2243i(OrderDialog orderDialog, Context context, String str) {
        this.f12686c = orderDialog;
        this.f12684a = context;
        this.f12685b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        LoadDialog.m4686a(this.f12684a);
        OrderAsyncTask orderAsyncTask = new OrderAsyncTask(this.f12684a);
        StringBuilder sb = new StringBuilder();
        editText = this.f12686c.f12682a;
        sb.append(editText.getText().toString());
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        orderAsyncTask.execute(this.f12685b, sb.toString());
    }
}
