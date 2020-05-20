package com.cnlaunch.x431pro.activity.help;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.activity.help.c */
/* loaded from: classes.dex */
public final class FunctionListAdapter extends BaseAdapter {

    /* renamed from: d */
    Context f12747d;

    /* renamed from: e */
    AssetManager f12748e;

    /* renamed from: f */
    LayoutInflater f12749f;

    /* renamed from: h */
    Handler f12751h;

    /* renamed from: a */
    int f12744a = 0;

    /* renamed from: b */
    LinearLayout f12745b = null;

    /* renamed from: c */
    TextView f12746c = null;

    /* renamed from: g */
    String f12750g = "";

    /* renamed from: i */
    Map<String, ArrayList<HelpFileInfo>> f12752i = new HashMap();

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public FunctionListAdapter(Context context, AssetManager assetManager, LayoutInflater layoutInflater) {
        this.f12748e = assetManager;
        this.f12749f = layoutInflater;
        this.f12747d = context;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f12744a;
    }

    /* renamed from: a */
    private Bitmap m6926a(String str) {
        Bitmap bitmap = null;
        try {
            InputStream open = this.f12748e.open(str);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LinearLayout linearLayout = new LinearLayout(this.f12747d);
            linearLayout.setOrientation(1);
            View inflate = this.f12749f.inflate(R.layout.help_module_menu_item, (ViewGroup) null);
            LinearLayout linearLayout2 = new LinearLayout(this.f12747d);
            linearLayout2.setOrientation(1);
            String str = (String) this.f12752i.keySet().toArray()[i];
            ArrayList<HelpFileInfo> arrayList = this.f12752i.get(str);
            String str2 = arrayList.get(0).f12719b;
            int i2 = 0;
            while (i2 < arrayList.size()) {
                View inflate2 = this.f12749f.inflate(R.layout.help_menu_item, (ViewGroup) null);
                LinearLayout linearLayout3 = (LinearLayout) inflate2.findViewById(R.id.module_item);
                linearLayout3.setPadding(100, 0, 0, 0);
                StringBuilder sb = new StringBuilder();
                int i3 = i2 + 1;
                sb.append(i3);
                ((TextView) inflate2.findViewById(R.id.module_item_header)).setText(sb.toString());
                ((TextView) inflate2.findViewById(R.id.module_item_title)).setText(arrayList.get(i2).f12720c);
                linearLayout3.setOnClickListener(new View$OnClickListenerC2253d(this, arrayList));
                linearLayout2.addView(inflate2);
                i2 = i3;
            }
            ((ImageView) inflate.findViewById(R.id.module_header)).setImageDrawable(new BitmapDrawable(m6926a(str2)));
            TextView textView = (TextView) inflate.findViewById(R.id.module_title);
            textView.setText(str);
            if (str.equals(this.f12750g)) {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.open_item, 0);
                this.f12745b = linearLayout2;
                this.f12746c = textView;
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.close_item, 0);
            }
            inflate.setOnClickListener(new View$OnClickListenerC2254e(this, linearLayout2, textView, str));
            linearLayout.addView(inflate);
            linearLayout.addView(linearLayout2);
            if (!str.equals(this.f12750g)) {
                linearLayout2.setVisibility(8);
            }
            return linearLayout;
        }
        return view;
    }
}
