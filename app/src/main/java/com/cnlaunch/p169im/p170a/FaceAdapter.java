package com.cnlaunch.p169im.p170a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.golo3.p154a.C1551a;
import com.cnlaunch.p169im.p173d.GoloHandler;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Map;
import message.p381d.FaceProvider;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* renamed from: com.cnlaunch.im.a.l */
/* loaded from: classes.dex */
public final class FaceAdapter extends BaseAdapter {

    /* renamed from: a */
    C1551a f8979a;

    /* renamed from: b */
    private Context f8980b;

    /* renamed from: c */
    private GoloHandler f8981c;

    /* renamed from: d */
    private int f8982d;

    /* renamed from: e */
    private ArrayList<Map<String, Object>> f8983e;

    /* renamed from: f */
    private ArrayList<String> f8984f;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: FaceAdapter.java */
    /* renamed from: com.cnlaunch.im.a.l$a */
    /* loaded from: classes.dex */
    public static final class EnumC1686a {
        public static final int yellow$1d664d25 = 1;
        public static final int rabbit$1d664d25 = 2;
        public static final int goose$1d664d25 = 3;
        public static final int gay$1d664d25 = 4;
        public static final int custom$1d664d25 = 5;
        public static final int car$1d664d25 = 6;

        /* renamed from: a */
        private static final /* synthetic */ int[] f8985a = {yellow$1d664d25, rabbit$1d664d25, goose$1d664d25, gay$1d664d25, custom$1d664d25, car$1d664d25};

        public static int[] values$3e28aa2b() {
            return (int[]) f8985a.clone();
        }
    }

    public FaceAdapter(Context context, GoloHandler goloHandler, int i, int i2, int i3) {
        this.f8981c = goloHandler;
        this.f8980b = context;
        this.f8982d = i;
        if (i == EnumC1686a.yellow$1d664d25) {
            this.f8983e = FaceProvider.m297a(i2, i3);
        } else if (i == EnumC1686a.goose$1d664d25) {
            this.f8983e = FaceProvider.m295b(i2, i3);
        } else if (i == EnumC1686a.gay$1d664d25) {
            this.f8983e = FaceProvider.m294c(i2, i3);
            this.f8984f = FaceProvider.m293d(i2, i3);
        } else if (i == EnumC1686a.car$1d664d25) {
            this.f8983e = FaceProvider.m292e(i2, i3);
        } else {
            this.f8983e = FaceProvider.m291f(i2, i3);
        }
        this.f8979a = new C1551a(context);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f8983e.size();
    }

    @Override // android.widget.Adapter
    @SuppressLint({"NewApi"})
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            if (this.f8982d == EnumC1686a.yellow$1d664d25) {
                view = LayoutInflater.from(this.f8980b).inflate(R.layout.aamsg_grid_view_item_face, (ViewGroup) null);
            } else {
                view = LayoutInflater.from(this.f8980b).inflate(R.layout.aamsg_grid_view_item_rabbit, (ViewGroup) null);
            }
        }
        view.setTag(this.f8983e.get(i).get("name"));
        TextView textView = (TextView) view.findViewById(R.id.face_name);
        if (this.f8982d == EnumC1686a.gay$1d664d25) {
            textView.setVisibility(4);
            textView.setText(this.f8984f.get(i));
        } else if (this.f8982d != EnumC1686a.yellow$1d664d25) {
            textView.setVisibility(8);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.face_image);
        if (this.f8982d == EnumC1686a.gay$1d664d25) {
            imageView.setContentDescription(this.f8980b.getString(R.string.description_face_image_gay));
        }
        if (this.f8982d == EnumC1686a.custom$1d664d25) {
            if ("add".equals(view.getTag())) {
                imageView.setImageResource(R.drawable.custom_face_more);
            } else {
                this.f8979a.m9255a(imageView, (String) this.f8983e.get(i).get("value"), null);
            }
        } else if (Build.VERSION.SDK_INT >= 15) {
            imageView.setImageDrawable(this.f8980b.getResources().getDrawableForDensity(((Integer) this.f8983e.get(i).get("value")).intValue(), this.f8982d == EnumC1686a.yellow$1d664d25 ? Opcodes.ISHL : 160));
        } else {
            imageView.setImageResource(((Integer) this.f8983e.get(i).get("value")).intValue());
        }
        view.setOnClickListener(new View$OnClickListenerC1687m(this, i));
        return view;
    }

    @Override // android.widget.Adapter
    public final /* synthetic */ Object getItem(int i) {
        return this.f8983e.get(i);
    }
}
