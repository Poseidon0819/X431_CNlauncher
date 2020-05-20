package com.cnlaunch.golo3.view.selectimg.p166a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p012v4.app.Fragment;
import android.support.p012v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.cnlaunch.golo3.p154a.C1551a;
import com.cnlaunch.p132e.p133a.C1464a;
import com.p297e.p298a.p299a.p304b.p305a.WeakMemoryCache;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;
import com.p297e.p298a.p306b.ImageLoaderConfiguration;
import com.p297e.p298a.p306b.p310c.RoundedBitmapDisplayer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.golo3.view.selectimg.a.f */
/* loaded from: classes.dex */
public final class PhotoFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    InterfaceC1630a f8597a;

    /* renamed from: b */
    private InterfaceC1631b f8598b;

    /* renamed from: c */
    private GridView f8599c;

    /* renamed from: d */
    private PhotoAdapter f8600d;

    /* renamed from: e */
    private C1551a f8601e;

    /* renamed from: f */
    private List<PhotoInfo> f8602f;

    /* renamed from: g */
    private List<PhotoInfo> f8603g = new ArrayList();

    /* renamed from: h */
    private int f8604h = 0;

    /* renamed from: i */
    private int f8605i;

    /* renamed from: j */
    private CheckBox f8606j;

    /* renamed from: k */
    private TextView f8607k;

    /* renamed from: l */
    private ImageLoader f8608l;

    /* compiled from: PhotoFragment.java */
    /* renamed from: com.cnlaunch.golo3.view.selectimg.a.f$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1630a {
        /* renamed from: a */
        void mo9070a();
    }

    /* compiled from: PhotoFragment.java */
    /* renamed from: com.cnlaunch.golo3.view.selectimg.a.f$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1631b {
        /* renamed from: b */
        void mo9066b(List<PhotoInfo> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static /* synthetic */ int m9074d(PhotoFragment photoFragment) {
        int i = photoFragment.f8604h;
        photoFragment.f8604h = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ int m9072f(PhotoFragment photoFragment) {
        int i = photoFragment.f8604h;
        photoFragment.f8604h = i + 1;
        return i;
    }

    @Override // android.support.p012v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.f8598b == null) {
            this.f8598b = (InterfaceC1631b) activity;
        }
    }

    @Override // android.support.p012v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.p012v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C1464a.C1469e.fragment_photoselect, viewGroup, false);
    }

    @Override // android.support.p012v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
        c3010a.f17117a = C1464a.C1467c.select_default_img;
        c3010a.f17118b = C1464a.C1467c.select_default_img;
        c3010a.f17119c = C1464a.C1467c.select_default_img;
        c3010a.f17129m = true;
        c3010a.f17133q = new RoundedBitmapDisplayer(90);
        Bitmap.Config config = Bitmap.Config.RGB_565;
        if (config == null) {
            throw new IllegalArgumentException("bitmapConfig can't be null");
        }
        c3010a.f17127k.inPreferredConfig = config;
        DisplayImageOptions m4193a = c3010a.m4193a();
        ImageLoaderConfiguration.C3015a c3015a = new ImageLoaderConfiguration.C3015a(activity);
        c3015a.f17183i = m4193a;
        ImageLoaderConfiguration m4178a = c3015a.m4176a(new WeakMemoryCache()).m4178a();
        this.f8608l = ImageLoader.m4191a();
        this.f8608l.m4189a(m4178a);
        this.f8599c = (GridView) getView().findViewById(C1464a.C1468d.gridview);
        this.f8606j = (CheckBox) getView().findViewById(C1464a.C1468d.checkbox_yuan);
        this.f8607k = (TextView) getView().findViewById(C1464a.C1468d.confirm_ok);
        this.f8607k.setOnClickListener(this);
        Bundle arguments = getArguments();
        this.f8604h = 0;
        this.f8605i = arguments.getInt("maxNum");
        this.f8602f = new ArrayList();
        this.f8602f.addAll(((PhotoSerializable) arguments.getSerializable("list")).getList());
        this.f8601e = new C1551a(getActivity());
        this.f8600d = new PhotoAdapter(getActivity(), this.f8602f, this.f8599c, this.f8608l);
        this.f8599c.setAdapter((ListAdapter) this.f8600d);
        this.f8599c.setOnItemClickListener(new C1632g(this));
    }

    @Override // android.support.p012v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        C1551a c1551a = this.f8601e;
        if (c1551a != null) {
            c1551a.m9257a();
            this.f8601e.m9253b();
            this.f8601e = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == C1464a.C1468d.checkbox_yuan || id != C1464a.C1468d.confirm_ok) {
            return;
        }
        this.f8597a.mo9070a();
    }

    /* renamed from: a */
    public final boolean m9078a() {
        CheckBox checkBox = this.f8606j;
        if (checkBox != null) {
            return checkBox.isChecked();
        }
        return false;
    }
}
