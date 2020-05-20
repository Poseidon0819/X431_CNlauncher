package com.cnlaunch.x431pro.activity.mine;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import org.vudroid.core.DecodeService;
import org.vudroid.core.DocumentView;
import org.vudroid.core.PDFPreferences;
import org.vudroid.core.events.CurrentPageListener;
import org.vudroid.core.events.DecodingProgressListener;
import org.vudroid.core.models.CurrentPageModel;
import org.vudroid.core.models.DecodingProgressModel;
import org.vudroid.core.models.ZoomModel;

/* renamed from: com.cnlaunch.x431pro.activity.mine.a */
/* loaded from: classes.dex */
public abstract class BasePDFViewFragment extends Fragment implements CurrentPageListener, DecodingProgressListener {

    /* renamed from: a */
    private DecodeService f13547a;

    /* renamed from: b */
    private DocumentView f13548b;

    /* renamed from: c */
    private PDFPreferences f13549c;

    /* renamed from: d */
    private Toast f13550d;

    /* renamed from: e */
    private CurrentPageModel f13551e;

    /* renamed from: a */
    public abstract String mo6292a();

    /* renamed from: b */
    protected abstract DecodeService mo6291b();

    @Override // org.vudroid.core.events.DecodingProgressListener
    public void decodingProgressChanged(int i) {
    }

    @Override // org.vudroid.core.events.CurrentPageListener
    @SuppressLint({"ShowToast"})
    public void currentPageChanged(int i) {
        String str = (i + 1) + "/" + this.f13547a.getPageCount();
        Toast toast = this.f13550d;
        if (toast != null) {
            toast.setText(str);
        } else {
            this.f13550d = Toast.makeText(getActivity(), str, 300);
        }
        this.f13550d.setGravity(51, 0, 0);
        this.f13550d.show();
        SharedPreferences.Editor edit = getActivity().getSharedPreferences("DjvuDocumentViewState", 0).edit();
        edit.putInt(mo6292a(), this.f13548b.getCurrentPage());
        edit.commit();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        this.f13547a.recycle();
        this.f13547a = null;
        this.f13548b.onFinishTemporaryDetach();
        this.f13548b.destroyDrawingCache();
        this.f13548b = null;
        this.f13549c = null;
        this.f13551e.removeEventListener(this);
        this.f13551e = null;
        System.gc();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f13547a == null) {
            this.f13547a = mo6291b();
        }
        ZoomModel zoomModel = new ZoomModel();
        DecodingProgressModel decodingProgressModel = new DecodingProgressModel();
        decodingProgressModel.addEventListener(this);
        this.f13551e = new CurrentPageModel();
        this.f13551e.addEventListener(this);
        this.f13548b = new DocumentView(getActivity(), zoomModel, decodingProgressModel, this.f13551e);
        zoomModel.addEventListener(this.f13548b);
        this.f13548b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f13547a.setContentResolver(getActivity().getContentResolver());
        this.f13547a.setContainerView(this.f13548b);
        this.f13548b.setDecodeService(this.f13547a);
        this.f13547a.open(Uri.parse(mo6292a()));
        this.f13549c = new PDFPreferences(getActivity());
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.addView(this.f13548b);
        this.f13548b.goToPage(0);
        this.f13548b.showDocument();
        this.f13549c.addRecent(Uri.parse(mo6292a()));
        return frameLayout;
    }
}
