package com.cnlaunch.x431pro.activity.info;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.artifex.mupdflib.MuPDFCore;
import com.artifex.mupdflib.MuPDFPageAdapter;
import com.artifex.mupdflib.MuPDFReaderView;
import com.artifex.mupdflib.SearchTask;
import com.artifex.mupdflib.SearchTaskResult;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.share.ShareActivity;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.info.k */
/* loaded from: classes.dex */
public class PdfSearchFragment extends BaseFragment implements View.OnClickListener, MuPDFCore.Callback {

    /* renamed from: b */
    private MuPDFCore f12911b;

    /* renamed from: c */
    private MuPDFReaderView f12912c;

    /* renamed from: d */
    private Context f12913d;

    /* renamed from: e */
    private String f12914e;

    /* renamed from: f */
    private SearchTask f12915f;

    /* renamed from: g */
    private TextView f12916g;

    /* renamed from: h */
    private TextView f12917h;

    /* renamed from: i */
    private LinearLayout f12918i;

    /* renamed from: j */
    private int f12919j;

    /* renamed from: k */
    private int f12920k;

    /* renamed from: l */
    private EditText f12921l;

    /* renamed from: m */
    private ImageButton f12922m;

    /* renamed from: n */
    private MuPDFPageAdapter f12923n;

    /* renamed from: o */
    private Handler f12924o;

    /* renamed from: q */
    private String f12926q;

    /* renamed from: a */
    Bundle f12910a = new Bundle();

    /* renamed from: p */
    private final int f12925p = 40994;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12913d = getActivity();
        this.f12924o = new HandlerC2285l(this);
        Bundle bundle2 = getBundle();
        if (bundle2 != null) {
            this.f12914e = bundle2.getString("file_path");
        }
        View inflate = layoutInflater.inflate(R.layout.layout_main, viewGroup, false);
        this.f12916g = (TextView) inflate.findViewById(R.id.page_current);
        this.f12917h = (TextView) inflate.findViewById(R.id.page_count);
        this.f12911b = m6833a(Uri.decode(this.f12914e));
        this.f12918i = (LinearLayout) inflate.findViewById(R.id.pdf_container);
        MuPDFCore muPDFCore = this.f12911b;
        if (muPDFCore != null && muPDFCore.countPages() == 0) {
            this.f12911b = null;
        }
        MuPDFCore muPDFCore2 = this.f12911b;
        if (muPDFCore2 == null || muPDFCore2.countPages() == 0 || this.f12911b.countPages() == -1) {
            Log.e("PdfFragment", "Document Not Opening");
        }
        this.f12920k = this.f12911b.countPages();
        if (this.f12911b != null) {
            this.f12912c = new C2286m(this, getActivity(), this);
            this.f12923n = new MuPDFPageAdapter(this.f12913d, this.f12911b, this.f12912c, this);
            this.f12912c.setAdapter(this.f12923n);
            this.f12918i.addView(this.f12912c);
            TextView textView = this.f12916g;
            textView.setText((this.f12912c.getDisplayedViewIndex() + 1) + "/");
            this.f12917h.setText(String.valueOf(this.f12911b.countPages()));
            this.f12919j = this.f12912c.getDisplayedViewIndex() + 1;
            this.f12920k = this.f12911b.countPages();
        }
        this.f12915f = new C2287n(this, this.f12913d, this.f12911b, this.f12912c);
        ((ActivityC2004c) getActivity()).m7738d();
        this.f12921l = (EditText) ((ActivityC2004c) getActivity()).m7734f().findViewById(R.id.edit_search);
        this.f12921l.setVisibility(0);
        this.f12921l.addTextChangedListener(new C2288o(this));
        this.f12922m = (ImageButton) ((ActivityC2004c) getActivity()).m7734f().findViewById(R.id.edit_search_btn);
        this.f12922m.setOnClickListener(this);
        return inflate;
    }

    /* renamed from: a */
    public final void m6837a() {
        if (this.f12912c == null || !isAdded()) {
            return;
        }
        SearchTaskResult searchTaskResult = new SearchTaskResult("", this.f12912c.getDisplayedViewIndex(), new RectF[0], new RectF[0]);
        SearchTaskResult.set(searchTaskResult);
        this.f12912c.setDisplayedViewIndex(searchTaskResult.pageNumber);
        this.f12912c.resetupChildren();
    }

    /* renamed from: a */
    public final void m6836a(int i, String str, boolean z) {
        int displayedViewIndex = this.f12912c.getDisplayedViewIndex();
        SearchTaskResult searchTaskResult = SearchTaskResult.get();
        int i2 = searchTaskResult != null ? searchTaskResult.pageNumber : -1;
        if (z) {
            i2 = -1;
        }
        if (this.f12919j == this.f12920k) {
            i = 0;
        }
        this.f12915f.m12507go(str, i, displayedViewIndex, i2);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int i = getResources().getConfiguration().orientation;
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private MuPDFCore m6833a(String str) {
        try {
            this.f12911b = new MuPDFCore(this.f12913d, str);
            return this.f12911b;
        } catch (Exception e) {
            Log.e("PdfFragment", e.getMessage());
            return null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.edit_search_btn) {
            boolean z = false;
            if (!C1621v.m9121a(this.f12921l.getText().toString())) {
                String str = this.f12926q;
                if (str == null) {
                    this.f12926q = this.f12921l.getText().toString();
                } else if (!str.equals(this.f12921l.getText().toString())) {
                    this.f12926q = this.f12921l.getText().toString();
                    z = true;
                }
                m6836a(1, this.f12921l.getText().toString(), z);
                return;
            }
            Toast.makeText(getActivity(), (int) R.string.please_input_key, 0).show();
        } else if (id == R.id.iv_delete_report) {
            new C2289p(this).m4610a(getActivity(), R.string.dialog_title_default, R.string.mine_dialog_content_delreport, true);
        } else if (id == R.id.iv_print_report) {
            LoadDialog.m4685a(this.f12913d, (int) R.string.printing_progress);
            request(20013);
        } else if (id != R.id.iv_share_report) {
        } else {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("FilePath", this.f12914e);
            intent.putExtras(bundle);
            intent.setClass(getActivity(), ShareActivity.class);
            getActivity().startActivity(intent);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        SearchTaskResult.set(new SearchTaskResult("", -1, new RectF[0], new RectF[0]));
        MuPDFReaderView muPDFReaderView = this.f12912c;
        if (muPDFReaderView != null) {
            muPDFReaderView.applyToChildren(new C2290q(this));
        }
        MuPDFCore muPDFCore = this.f12911b;
        if (muPDFCore != null) {
            muPDFCore.onDestroy();
            this.f12911b = null;
        }
        this.f12923n.releaseBitmaps();
        SearchTask searchTask = this.f12915f;
        if (searchTask != null) {
            searchTask.stop();
        }
        ((ActivityC2004c) getActivity()).m7736e();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        getActivity().getParent().getWindow().setSoftInputMode(32);
        ((ActivityC2004c) getActivity()).m7738d();
        this.f12924o.sendEmptyMessageDelayed(40994, 500L);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        getActivity().getParent().getWindow().setSoftInputMode(16);
    }

    @Override // com.artifex.mupdflib.MuPDFCore.Callback
    public void changePage() {
        if (getActivity() == null || !(getActivity() instanceof PdfSearchActivity)) {
            return;
        }
        ((PdfSearchActivity) getActivity()).f12869n = true;
    }
}
