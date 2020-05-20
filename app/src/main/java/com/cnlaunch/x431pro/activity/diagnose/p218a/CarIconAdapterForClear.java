package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.ifoer.expedition.pro.R;
import com.p039a.p040a.Glide;
import com.p039a.p040a.p044d.p046b.DiskCacheStrategy;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.p310c.RoundedBitmapDisplayer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.c */
/* loaded from: classes.dex */
public class CarIconAdapterForClear extends BaseAdapter {

    /* renamed from: c */
    private static final String f11274c = "c";

    /* renamed from: a */
    public List<CarIcon> f11275a;

    /* renamed from: b */
    public List<Boolean> f11276b = new ArrayList();

    /* renamed from: d */
    private Context f11277d;

    /* renamed from: e */
    private LayoutInflater f11278e;

    /* renamed from: f */
    private C2014a f11279f;

    /* renamed from: g */
    private DisplayImageOptions f11280g;

    /* renamed from: h */
    private Fragment f11281h;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public CarIconAdapterForClear(Context context, Fragment fragment) {
        this.f11281h = null;
        this.f11277d = context;
        this.f11281h = fragment;
        this.f11278e = LayoutInflater.from(this.f11277d);
        DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
        c3010a.f17133q = new RoundedBitmapDisplayer(100);
        c3010a.f17124h = true;
        c3010a.f17125i = true;
        this.f11280g = c3010a.m4193a();
    }

    /* compiled from: CarIconAdapterForClear.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.c$a */
    /* loaded from: classes.dex */
    class C2014a {

        /* renamed from: a */
        ImageView f11282a;

        /* renamed from: b */
        TextView f11283b;

        /* renamed from: c */
        TextView f11284c;

        /* renamed from: d */
        TextView f11285d;

        /* renamed from: e */
        TextView f11286e;

        C2014a() {
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<CarIcon> list = this.f11275a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f11275a.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f11279f = new C2014a();
            view = this.f11278e.inflate(R.layout.diagnose_caricon_item, viewGroup, false);
            this.f11279f.f11282a = (ImageView) view.findViewById(R.id.car_logo);
            this.f11279f.f11286e = (TextView) view.findViewById(R.id.car_name_zh);
            this.f11279f.f11283b = (TextView) view.findViewById(R.id.car_name);
            this.f11279f.f11284c = (TextView) view.findViewById(R.id.diagnostic_for);
            this.f11279f.f11285d = (TextView) view.findViewById(R.id.by_launch);
            view.setTag(this.f11279f);
        } else {
            this.f11279f = (C2014a) view.getTag();
        }
        CarIcon carIcon = this.f11275a.get(i);
        if (C2744aa.m5148g()) {
            this.f11279f.f11284c.setVisibility(8);
            this.f11279f.f11285d.setVisibility(8);
            if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                this.f11279f.f11283b.setVisibility(8);
                this.f11279f.f11282a.setVisibility(0);
                this.f11279f.f11286e.setVisibility(0);
                this.f11279f.f11286e.setText(carIcon.m5038a(this.f11277d));
                String m9591a = PreferencesManager.m9595a(this.f11277d).m9591a("serialNo");
                if (TextUtils.isEmpty(carIcon.f15781e)) {
                    String str = "file://" + PathUtils.m4861b(this.f11277d, m9591a) + File.separator + carIcon.f15782f + File.separator + carIcon.f15778b + File.separator + "ICONCN.PNG";
                    Fragment fragment = this.f11281h;
                    (fragment == null ? Glide.m12699b(this.f11277d) : Glide.m12706a(fragment)).m12667a(str).m12975a().m12974a(DiskCacheStrategy.SOURCE).m12971b().mo12915a(this.f11279f.f11282a);
                } else if (carIcon.f15781e.contains(carIcon.f15778b) || carIcon.f15781e.contains("ICONCN.PNG")) {
                    String str2 = "file://" + PathUtils.m4858c() + carIcon.f15781e;
                    Fragment fragment2 = this.f11281h;
                    (fragment2 == null ? Glide.m12699b(this.f11277d) : Glide.m12706a(fragment2)).m12667a(str2).m12975a().m12974a(DiskCacheStrategy.SOURCE).m12971b().mo12915a(this.f11279f.f11282a);
                } else {
                    int identifier = this.f11277d.getResources().getIdentifier(carIcon.f15781e, "drawable", this.f11277d.getPackageName());
                    Fragment fragment3 = this.f11281h;
                    (fragment3 == null ? Glide.m12699b(this.f11277d) : Glide.m12706a(fragment3)).m12668a(Integer.valueOf(identifier)).m12975a().m12974a(DiskCacheStrategy.SOURCE).m12971b().mo12915a(this.f11279f.f11282a);
                }
            } else {
                this.f11279f.f11283b.setText(carIcon.f15779c.toUpperCase(Locale.getDefault()));
                this.f11279f.f11283b.setVisibility(0);
                this.f11279f.f11282a.setVisibility(8);
                this.f11279f.f11286e.setVisibility(8);
            }
        } else {
            if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                this.f11279f.f11283b.setText(carIcon.m5038a(this.f11277d));
            } else {
                this.f11279f.f11283b.setText(carIcon.f15779c.toUpperCase(Locale.getDefault()));
            }
            this.f11279f.f11283b.setVisibility(0);
            this.f11279f.f11284c.setVisibility(0);
            this.f11279f.f11285d.setVisibility(0);
            this.f11279f.f11282a.setVisibility(8);
            this.f11279f.f11286e.setVisibility(8);
            String upperCase = LangManager.m9469a().contains("zh") ? carIcon.f15792p : carIcon.f15779c.toUpperCase(Locale.getDefault());
            if (upperCase.contains("(")) {
                String substring = upperCase.substring(0, upperCase.indexOf("("));
                String substring2 = upperCase.substring(upperCase.indexOf("("), upperCase.length());
                this.f11279f.f11283b.setText(substring + HttpProxyConstants.CRLF + substring2);
                if (substring.length() > 11 || substring2.length() > 11) {
                    this.f11279f.f11283b.setTextSize(this.f11277d.getResources().getDimension(R.dimen.carname_normal_textsize));
                } else if (substring.length() > 9 || substring2.length() > 9) {
                    this.f11279f.f11283b.setTextSize(this.f11277d.getResources().getDimension(R.dimen.carname_middle_textsize));
                } else {
                    this.f11279f.f11283b.setTextSize(this.f11277d.getResources().getDimension(R.dimen.carname_large_textsize));
                }
            } else if (upperCase.contains("-") || upperCase.contains("_")) {
                if (upperCase.length() > 11) {
                    this.f11279f.f11283b.setTextSize(this.f11277d.getResources().getDimension(R.dimen.carname_normal_textsize));
                } else if (upperCase.length() > 9) {
                    this.f11279f.f11283b.setTextSize(this.f11277d.getResources().getDimension(R.dimen.carname_middle_textsize));
                } else {
                    this.f11279f.f11283b.setTextSize(this.f11277d.getResources().getDimension(R.dimen.carname_large_textsize));
                }
            } else if (upperCase.length() > 14) {
                this.f11279f.f11283b.setTextSize(this.f11277d.getResources().getDimension(R.dimen.carname_small_textsize));
            } else if (upperCase.length() > 11) {
                this.f11279f.f11283b.setTextSize(this.f11277d.getResources().getDimension(R.dimen.carname_normal_textsize));
            } else if (upperCase.length() > 9) {
                this.f11279f.f11283b.setTextSize(this.f11277d.getResources().getDimension(R.dimen.carname_middle_textsize));
            } else {
                this.f11279f.f11283b.setTextSize(this.f11277d.getResources().getDimension(R.dimen.carname_large_textsize));
            }
        }
        if (this.f11276b.get(i).booleanValue()) {
            view.setBackgroundDrawable(this.f11277d.getResources().getDrawable(R.drawable.car_bg_press));
        } else {
            view.setBackgroundDrawable(this.f11277d.getResources().getDrawable(R.drawable.car_bg_normal));
        }
        return view;
    }
}
