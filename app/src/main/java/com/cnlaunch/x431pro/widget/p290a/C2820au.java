package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* compiled from: InputReportInfoDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.au */
/* loaded from: classes.dex */
final class C2820au implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC2819at f16194a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2820au(View$OnClickListenerC2819at view$OnClickListenerC2819at) {
        this.f16194a = view$OnClickListenerC2819at;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        TextView textView;
        Context context;
        TextView textView2;
        if (i >= 0) {
            try {
                list = this.f16194a.f16193a.f16169F;
                this.f16194a.f16193a.f16192z = i;
                textView = this.f16194a.f16193a.f16184r;
                textView.setText((String) list.get(i));
                context = this.f16194a.f16193a.f16179m;
                Drawable drawable = context.getResources().getDrawable(R.drawable.arrow_bottom);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.f16194a.f16193a.f16184r;
                textView2.setCompoundDrawables(null, null, drawable, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
