package com.cnlaunch.x431pro.activity.help;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.help.a */
/* loaded from: classes.dex */
public final class FAQlistAdapter extends BaseAdapter {

    /* renamed from: d */
    Context f12732d;

    /* renamed from: e */
    AssetManager f12733e;

    /* renamed from: f */
    LayoutInflater f12734f;

    /* renamed from: h */
    Handler f12736h;

    /* renamed from: a */
    int f12729a = 0;

    /* renamed from: b */
    LinearLayout f12730b = null;

    /* renamed from: c */
    TextView f12731c = null;

    /* renamed from: g */
    String f12735g = "";

    /* renamed from: i */
    TextView f12737i = null;

    /* renamed from: j */
    TextView f12738j = null;

    /* renamed from: k */
    ArrayList<? extends Parcelable> f12739k = null;

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    public FAQlistAdapter(Context context, AssetManager assetManager, LayoutInflater layoutInflater) {
        this.f12733e = assetManager;
        this.f12734f = layoutInflater;
        this.f12732d = context;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f12729a;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.f12732d);
        linearLayout.setOrientation(1);
        int i2 = 0;
        while (i2 < this.f12739k.size()) {
            TextView textView = (TextView) this.f12734f.inflate(R.layout.help_q2a_answer_item, (ViewGroup) null);
            View inflate = this.f12734f.inflate(R.layout.help_q2a_menu_item, (ViewGroup) null);
            textView.setText(((HelpFileInfo) this.f12739k.get(i2)).f12721d);
            textView.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.module_q2_a_item);
            StringBuilder sb = new StringBuilder();
            int i3 = i2 + 1;
            sb.append(i3);
            String sb2 = sb.toString();
            ((TextView) inflate.findViewById(R.id.module_q2_a_item_header)).setText(sb2);
            TextView textView2 = (TextView) inflate.findViewById(R.id.module_q2_a_item_title);
            textView2.setText(((HelpFileInfo) this.f12739k.get(i2)).f12720c);
            if (sb2.equals(this.f12735g)) {
                this.f12737i = textView2;
                this.f12738j = textView;
                textView.setVisibility(0);
                textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.open_item, 0);
            } else {
                textView.setVisibility(8);
                textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.close_item, 0);
            }
            linearLayout2.setOnClickListener(new View$OnClickListenerC2252b(this, textView, textView2, sb2));
            linearLayout.addView(inflate);
            linearLayout.addView(textView);
            i2 = i3;
        }
        return linearLayout;
    }
}
