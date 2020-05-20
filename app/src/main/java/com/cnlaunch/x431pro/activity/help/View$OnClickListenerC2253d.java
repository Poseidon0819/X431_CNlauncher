package com.cnlaunch.x431pro.activity.help;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* compiled from: FunctionListAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.help.d */
/* loaded from: classes.dex */
final class View$OnClickListenerC2253d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ArrayList f12753a;

    /* renamed from: b */
    final /* synthetic */ FunctionListAdapter f12754b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2253d(FunctionListAdapter functionListAdapter, ArrayList arrayList) {
        this.f12754b = functionListAdapter;
        this.f12753a = arrayList;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = ((HelpFileInfo) this.f12753a.get(Integer.parseInt((String) ((TextView) view.findViewById(R.id.module_item_header)).getText()) - 1)).f12721d;
        Bundle bundle = new Bundle();
        Message obtainMessage = this.f12754b.f12751h.obtainMessage(3);
        bundle.putString(HelpStringConstant.f12802c, str);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }
}
