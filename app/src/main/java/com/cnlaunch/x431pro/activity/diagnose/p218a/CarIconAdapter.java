package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p283db.FavoritesCarIconDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.FavoritesDBManager;
import com.ifoer.expedition.pro.R;
import com.p039a.p040a.Glide;
import com.p039a.p040a.p044d.p046b.DiskCacheStrategy;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.p310c.RoundedBitmapDisplayer;
import de.greenrobot.dao.query.QueryBuilder;
import java.io.File;
import java.util.List;
import java.util.Locale;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.b */
/* loaded from: classes.dex */
public class CarIconAdapter extends BaseAdapter implements DragGridBaseAdapter {

    /* renamed from: d */
    private static final String f11255d = "b";

    /* renamed from: a */
    public List<CarIcon> f11256a;

    /* renamed from: b */
    FavoritesCarIconDao f11257b;

    /* renamed from: c */
    public boolean f11258c;

    /* renamed from: e */
    private Context f11259e;

    /* renamed from: f */
    private LayoutInflater f11260f;

    /* renamed from: g */
    private C2013a f11261g;

    /* renamed from: h */
    private DisplayImageOptions f11262h;

    /* renamed from: i */
    private Fragment f11263i;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public CarIconAdapter(Context context) {
        this.f11263i = null;
        this.f11259e = context;
        this.f11260f = LayoutInflater.from(this.f11259e);
        DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
        c3010a.f17133q = new RoundedBitmapDisplayer(100);
        c3010a.f17124h = true;
        c3010a.f17125i = true;
        this.f11262h = c3010a.m4193a();
        this.f11257b = FavoritesDBManager.m5033a(this.f11259e).f15810a.f15814a;
    }

    public CarIconAdapter(Context context, Fragment fragment) {
        this.f11263i = null;
        this.f11259e = context;
        this.f11263i = fragment;
        this.f11260f = LayoutInflater.from(this.f11259e);
        DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
        c3010a.f17133q = new RoundedBitmapDisplayer(100);
        c3010a.f17124h = true;
        c3010a.f17125i = true;
        this.f11262h = c3010a.m4193a();
        this.f11257b = FavoritesDBManager.m5033a(this.f11259e).f15810a.f15814a;
    }

    /* compiled from: CarIconAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.b$a */
    /* loaded from: classes.dex */
    class C2013a {

        /* renamed from: a */
        ImageView f11264a;

        /* renamed from: b */
        TextView f11265b;

        /* renamed from: c */
        TextView f11266c;

        /* renamed from: d */
        TextView f11267d;

        /* renamed from: e */
        TextView f11268e;

        /* renamed from: f */
        LinearLayout f11269f;

        /* renamed from: g */
        TextView f11270g;

        /* renamed from: h */
        TextView f11271h;

        /* renamed from: i */
        ImageView f11272i;

        C2013a() {
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<CarIcon> list = this.f11256a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f11256a.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f11261g = new C2013a();
            view = this.f11260f.inflate(R.layout.diagnose_caricon_item, viewGroup, false);
            this.f11261g.f11264a = (ImageView) view.findViewById(R.id.car_logo);
            this.f11261g.f11268e = (TextView) view.findViewById(R.id.car_name_zh);
            this.f11261g.f11265b = (TextView) view.findViewById(R.id.car_name);
            this.f11261g.f11266c = (TextView) view.findViewById(R.id.diagnostic_for);
            this.f11261g.f11267d = (TextView) view.findViewById(R.id.by_launch);
            this.f11261g.f11269f = (LinearLayout) view.findViewById(R.id.ll_car_name);
            this.f11261g.f11270g = (TextView) view.findViewById(R.id.car_name_en);
            this.f11261g.f11271h = (TextView) view.findViewById(R.id.car_name_hk);
            this.f11261g.f11272i = (ImageView) view.findViewById(R.id.iv_download);
            view.setTag(this.f11261g);
        } else {
            this.f11261g = (C2013a) view.getTag();
        }
        CarIcon carIcon = this.f11256a.get(i);
        this.f11261g.f11272i.setVisibility(8);
        if (C2744aa.m5148g()) {
            this.f11261g.f11266c.setVisibility(8);
            this.f11261g.f11267d.setVisibility(8);
            if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                this.f11261g.f11265b.setVisibility(8);
                this.f11261g.f11264a.setVisibility(0);
                this.f11261g.f11268e.setVisibility(0);
                this.f11261g.f11268e.setText(carIcon.m5038a(this.f11259e));
                this.f11261g.f11268e.setTextSize(22.0f);
                String m9591a = PreferencesManager.m9595a(this.f11259e).m9591a("serialNo");
                if (TextUtils.isEmpty(carIcon.f15781e)) {
                    String str = "file://" + PathUtils.m4861b(this.f11259e, m9591a) + File.separator + carIcon.f15782f + File.separator + carIcon.f15778b + File.separator + "ICONCN.PNG";
                    Fragment fragment = this.f11263i;
                    (fragment == null ? Glide.m12699b(this.f11259e) : Glide.m12706a(fragment)).m12667a(str).m12975a().m12974a(DiskCacheStrategy.SOURCE).m12971b().mo12915a(this.f11261g.f11264a);
                } else if (carIcon.f15781e.contains(carIcon.f15778b) || carIcon.f15781e.contains("ICONCN.PNG")) {
                    String str2 = "file://" + PathUtils.m4858c() + carIcon.f15781e;
                    Fragment fragment2 = this.f11263i;
                    (fragment2 == null ? Glide.m12699b(this.f11259e) : Glide.m12706a(fragment2)).m12667a(str2).m12975a().m12974a(DiskCacheStrategy.SOURCE).m12971b().mo12915a(this.f11261g.f11264a);
                } else {
                    int identifier = this.f11259e.getResources().getIdentifier(carIcon.f15781e, "drawable", this.f11259e.getPackageName());
                    Fragment fragment3 = this.f11263i;
                    (fragment3 == null ? Glide.m12699b(this.f11259e) : Glide.m12706a(fragment3)).m12668a(Integer.valueOf(identifier)).m12975a().m12974a(DiskCacheStrategy.SOURCE).m12971b().mo12915a(this.f11261g.f11264a);
                }
            } else {
                this.f11261g.f11265b.setText(carIcon.f15779c.toUpperCase(Locale.getDefault()));
                this.f11261g.f11265b.setVisibility(0);
                this.f11261g.f11264a.setVisibility(8);
                this.f11261g.f11268e.setVisibility(8);
            }
        } else {
            if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                this.f11261g.f11265b.setText(carIcon.m5038a(this.f11259e));
            } else {
                this.f11261g.f11265b.setText(carIcon.f15779c.toUpperCase(Locale.getDefault()));
            }
            this.f11261g.f11265b.setVisibility(0);
            this.f11261g.f11266c.setVisibility(0);
            this.f11261g.f11267d.setVisibility(0);
            this.f11261g.f11264a.setVisibility(8);
            this.f11261g.f11268e.setVisibility(8);
            String upperCase = LangManager.m9469a().contains("zh") ? carIcon.f15792p : carIcon.f15779c.toUpperCase(Locale.getDefault());
            if (LangManager.m9466b().contains("HK") || LangManager.m9466b().contains("TW")) {
                upperCase = carIcon.f15779c.toUpperCase(Locale.getDefault());
                this.f11261g.f11269f.setVisibility(0);
                this.f11261g.f11265b.setVisibility(8);
                this.f11261g.f11270g.setText(upperCase);
                this.f11261g.f11271h.setText(carIcon.m5038a(this.f11259e));
            } else {
                this.f11261g.f11269f.setVisibility(8);
                this.f11261g.f11265b.setVisibility(0);
            }
            if (upperCase.contains("(")) {
                String substring = upperCase.substring(0, upperCase.indexOf("("));
                String substring2 = upperCase.substring(upperCase.indexOf("("), upperCase.length());
                this.f11261g.f11265b.setText(substring + HttpProxyConstants.CRLF + substring2);
                if (substring.length() > 11 || substring2.length() > 11) {
                    this.f11261g.f11265b.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_normal_textsize));
                    this.f11261g.f11270g.setTextSize(17.0f);
                } else if (substring.length() > 9 || substring2.length() > 9) {
                    this.f11261g.f11265b.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_middle_textsize));
                    this.f11261g.f11270g.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_middle_textsize));
                } else {
                    this.f11261g.f11265b.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_large_textsize));
                    this.f11261g.f11270g.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_large_textsize));
                }
            } else if (upperCase.contains("-") || upperCase.contains("_")) {
                if (upperCase.length() > 11) {
                    this.f11261g.f11265b.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_normal_textsize));
                    this.f11261g.f11270g.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_normal_textsize));
                } else if (upperCase.length() > 9) {
                    this.f11261g.f11265b.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_middle_textsize));
                    this.f11261g.f11270g.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_middle_textsize));
                } else {
                    this.f11261g.f11265b.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_large_textsize));
                    this.f11261g.f11270g.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_large_textsize));
                }
            } else if (upperCase.length() > 14) {
                this.f11261g.f11265b.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_small_textsize));
                this.f11261g.f11270g.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_small_textsize));
            } else if (upperCase.length() > 11) {
                this.f11261g.f11265b.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_normal_textsize));
                this.f11261g.f11270g.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_normal_textsize));
            } else if (upperCase.length() > 9) {
                this.f11261g.f11265b.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_middle_textsize));
                this.f11261g.f11270g.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_middle_textsize));
            } else {
                this.f11261g.f11265b.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_large_textsize));
                this.f11261g.f11270g.setTextSize(this.f11259e.getResources().getDimension(R.dimen.carname_large_textsize));
            }
        }
        if (!carIcon.f15787k.booleanValue() && this.f11258c) {
            this.f11261g.f11272i.setVisibility(0);
            if (C2744aa.m5148g()) {
                this.f11261g.f11264a.setVisibility(8);
                this.f11261g.f11268e.setVisibility(8);
                this.f11261g.f11265b.setVisibility(0);
                if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                    this.f11261g.f11265b.setText(carIcon.m5038a(this.f11259e));
                } else {
                    this.f11261g.f11265b.setText(carIcon.f15779c.toUpperCase(Locale.getDefault()));
                }
                this.f11261g.f11265b.setTextSize(22.0f);
            }
        }
        return view;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p218a.DragGridBaseAdapter
    /* renamed from: a */
    public final void mo7500a(int i) {
        CarIcon carIcon = this.f11256a.get(i);
        NLog.m9456a(f11255d, "carIcon=".concat(String.valueOf(carIcon)));
        QueryBuilder<CarIcon> queryBuilder = this.f11257b.queryBuilder();
        queryBuilder.where(FavoritesCarIconDao.Properties.SoftPackageId.m321eq(carIcon.f15778b), FavoritesCarIconDao.Properties.SerialNo.m321eq(carIcon.f15790n));
        if (queryBuilder.unique() != null) {
            NToast.m9447b(this.f11259e, (int) R.string.already_added_favorites);
            return;
        }
        CarIcon carIcon2 = new CarIcon();
        carIcon2.f15781e = carIcon.f15781e;
        carIcon2.f15787k = carIcon.f15787k;
        carIcon2.f15782f = carIcon.f15782f;
        carIcon2.f15788l = carIcon.f15788l;
        carIcon2.f15785i = carIcon.f15785i;
        carIcon2.f15779c = carIcon.f15779c;
        carIcon2.f15780d = carIcon.f15780d;
        carIcon2.f15790n = carIcon.f15790n;
        carIcon2.m5037a(carIcon.f15789m);
        carIcon2.f15786j = carIcon.f15786j;
        carIcon2.f15783g = carIcon.f15783g;
        carIcon2.f15784h = carIcon.f15784h;
        carIcon2.f15778b = carIcon.f15778b;
        carIcon2.f15791o = Boolean.TRUE;
        this.f11257b.insert(carIcon2);
        this.f11259e.sendBroadcast(new Intent("addedFavorites"));
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p218a.DragGridBaseAdapter
    /* renamed from: b */
    public final void mo7499b(int i) {
        CarIcon carIcon = this.f11256a.get(i);
        NLog.m9456a(f11255d, "deleteFavoritesItem.carIcon=".concat(String.valueOf(carIcon)));
        try {
            FavoritesDBManager.m5033a(this.f11259e).f15810a.f15814a.delete(carIcon);
            this.f11259e.sendBroadcast(new Intent("deletedFavorites"));
        } catch (SQLiteCantOpenDatabaseException e) {
            NLog.m9451c(f11255d, e);
        }
    }

    /* renamed from: a */
    public final void m7522a(List<CarIcon> list) {
        this.f11256a = list;
        notifyDataSetChanged();
    }
}
