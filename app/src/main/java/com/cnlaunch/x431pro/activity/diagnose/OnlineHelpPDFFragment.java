package com.cnlaunch.x431pro.activity.diagnose;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import org.vudroid.core.DecodeService;
import org.vudroid.core.DecodeServiceBase;
import org.vudroid.core.DocumentView;
import org.vudroid.core.PDFPreferences;
import org.vudroid.core.events.CurrentPageListener;
import org.vudroid.core.events.DecodingProgressListener;
import org.vudroid.core.models.CurrentPageModel;
import org.vudroid.core.models.DecodingProgressModel;
import org.vudroid.core.models.ZoomModel;
import org.vudroid.pdfdroid.codec.PdfContext;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bp */
/* loaded from: classes.dex */
public final class OnlineHelpPDFFragment extends BaseFragment implements OnKeyDownListenter, CurrentPageListener, DecodingProgressListener {

    /* renamed from: a */
    DecodeService f11563a;

    /* renamed from: b */
    DocumentView f11564b;

    /* renamed from: c */
    PDFPreferences f11565c;

    /* renamed from: d */
    CurrentPageModel f11566d;

    /* renamed from: f */
    private Toast f11568f;

    /* renamed from: g */
    private IFragmentCallback f11569g;

    /* renamed from: h */
    private FrameLayout f11570h;

    /* renamed from: e */
    private String f11567e = "";

    /* renamed from: i */
    private boolean f11571i = true;

    /* renamed from: j */
    private AtomicInteger f11572j = new AtomicInteger(0);

    @Override // org.vudroid.core.events.DecodingProgressListener
    public final void decodingProgressChanged(int i) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter
    /* renamed from: i_ */
    public final void mo6838i_() {
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f11569g.mo7096a(this);
        this.btn_left.setVisibility(4);
        setMenuUpdateVisibility(8);
        this.f11571i = true;
    }

    @Override // org.vudroid.core.events.CurrentPageListener
    @SuppressLint({"ShowToast"})
    public final void currentPageChanged(int i) {
        String str = (i + 1) + "/" + this.f11563a.getPageCount();
        Toast toast = this.f11568f;
        if (toast != null) {
            toast.setText(str);
        } else {
            this.f11568f = Toast.makeText(getActivity(), str, 0);
        }
        this.f11568f.setGravity(51, 0, 0);
        this.f11568f.show();
        SharedPreferences.Editor edit = getActivity().getSharedPreferences("DjvuDocumentViewState", 0).edit();
        edit.putInt(this.f11567e, this.f11564b.getCurrentPage());
        edit.commit();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f11571i) {
            setTitle(getString(R.string.onlinehelp_title));
            this.f11570h = (FrameLayout) getActivity().findViewById(R.id.fl_online_help_container);
            if (this.f11563a == null) {
                this.f11563a = new DecodeServiceBase(new PdfContext());
            }
            ZoomModel zoomModel = new ZoomModel();
            zoomModel.setMaxZoom(2);
            DecodingProgressModel decodingProgressModel = new DecodingProgressModel();
            decodingProgressModel.addEventListener(this);
            this.f11566d = new CurrentPageModel();
            this.f11566d.addEventListener(this);
            this.f11564b = new DocumentView(getActivity(), zoomModel, decodingProgressModel, this.f11566d);
            zoomModel.addEventListener(this.f11564b);
            this.f11564b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f11563a.setContentResolver(getActivity().getContentResolver());
            this.f11563a.setContainerView(this.f11564b);
            this.f11564b.setDecodeService(this.f11563a);
            if (Uri.parse(this.f11567e) != null) {
                try {
                    this.f11563a.open(Uri.parse(this.f11567e));
                } catch (Exception e) {
                    e.printStackTrace();
                    NToast.m9446b(this.mContext, getResources().getString(R.string.onlineprograming_tip_network_downfail));
                }
            }
            this.f11565c = new PDFPreferences(getActivity());
            this.f11570h.addView(this.f11564b);
            this.f11564b.goToPage(0);
            this.f11564b.showDocument();
            this.f11565c.addRecent(Uri.parse(this.f11567e));
            this.f11571i = false;
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onDestroy() {
        setMenuUpdateVisibility(PreferencesManager.m9595a(this.mContext).m9585b("unupdateSoftwareNum", 0) + PreferencesManager.m9595a(this.mContext).m9585b("unupdateSoftwareNumForHeavyduty", 0) <= 0 ? 8 : 0);
        this.f11569g.mo7093a(DiagnoseConstants.FEEDBACK_SPT_FUNCTION_HELP, "00", 3);
        if (this.f11564b != null) {
            new Handler().postDelayed(new RunnableC2081bq(this), 2000L);
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f11567e = arguments.getString("uri_name");
        }
        try {
            this.f11569g = (IFragmentCallback) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement FragmentCallback.OnMenuOnClickListener");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.layout_online_help, viewGroup, false);
    }

    @Override // android.app.Fragment
    public final void onDestroyView() {
        File file = new File(Uri.parse(this.f11567e).getPath());
        if (file.exists()) {
            file.delete();
        }
        super.onDestroyView();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            this.btn_left.setVisibility(0);
        }
        return false;
    }
}
