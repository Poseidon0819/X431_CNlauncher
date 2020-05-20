package com.cnlaunch.p169im.p170a;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.p169im.p173d.GoloHandler;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.cnlaunch.im.a.v */
/* loaded from: classes.dex */
public final class SelectAdapter extends BaseAdapter {

    /* renamed from: a */
    public ArrayList<Map<String, Integer>> f9036a = SelectProvider.m8879a();

    /* renamed from: b */
    private GoloHandler f9037b;

    /* renamed from: c */
    private Context f9038c;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public SelectAdapter(Context context, GoloHandler goloHandler, boolean z, int i) {
        this.f9037b = goloHandler;
        this.f9038c = context;
        if (!z) {
            int size = this.f9036a.size();
            Log.d("Sanda", "A data=".concat(String.valueOf(size)));
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                Map<String, Integer> map = this.f9036a.get(i2);
                if (map.get("what").intValue() == 100010) {
                    this.f9036a.remove(map);
                    break;
                }
                i2++;
            }
            Log.d("Sanda", "B data=".concat(String.valueOf(this.f9036a.size())));
        }
        if (i == 0) {
            this.f9036a.remove(0);
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f9036a.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public final Map<String, Integer> getItem(int i) {
        return this.f9036a.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f9038c).inflate(R.layout.aamsg_grid_view_item_select, (ViewGroup) null);
        }
        ((ImageView) view.findViewById(R.id.mode_select_image)).setImageResource(getItem(i).get("image").intValue());
        ((TextView) view.findViewById(R.id.mode_select_name)).setText(getItem(i).get("name").intValue());
        view.setOnClickListener(new View$OnClickListenerC1696w(this, i));
        return view;
    }
}
