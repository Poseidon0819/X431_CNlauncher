package com.cnlaunch.x431pro.activity.info;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.artifex.mupdflib.MuPDFCore;
import com.artifex.mupdflib.MuPDFPageAdapter;
import com.artifex.mupdflib.MuPDFReaderView;
import com.artifex.mupdflib.SearchTask;
import com.artifex.mupdflib.SearchTaskResult;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.info.r */
/* loaded from: classes.dex */
public class PdfViewFragment extends BaseFragment implements View.OnClickListener, MuPDFCore.Callback {

    /* renamed from: b */
    private MuPDFCore f12934b;

    /* renamed from: c */
    private MuPDFReaderView f12935c;

    /* renamed from: d */
    private Context f12936d;

    /* renamed from: e */
    private String f12937e;

    /* renamed from: f */
    private SearchTask f12938f;

    /* renamed from: g */
    private TextView f12939g;

    /* renamed from: h */
    private TextView f12940h;

    /* renamed from: i */
    private LinearLayout f12941i;

    /* renamed from: j */
    private int f12942j;

    /* renamed from: k */
    private int f12943k;

    /* renamed from: l */
    private EditText f12944l;

    /* renamed from: m */
    private MuPDFPageAdapter f12945m;

    /* renamed from: o */
    private Handler f12947o;

    /* renamed from: q */
    private String f12949q;

    /* renamed from: a */
    Bundle f12933a = new Bundle();

    /* renamed from: n */
    private String f12946n = "";

    /* renamed from: p */
    private final int f12948p = 40994;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12936d = getActivity();
        this.f12947o = new HandlerC2291s(this);
        Bundle bundle2 = getBundle();
        if (bundle2 != null) {
            this.f12937e = bundle2.getString("file_path");
            this.f12946n = bundle2.getString("title");
        }
        View inflate = layoutInflater.inflate(R.layout.layout_main, viewGroup, false);
        this.f12939g = (TextView) inflate.findViewById(R.id.page_current);
        this.f12940h = (TextView) inflate.findViewById(R.id.page_count);
        this.f12934b = m6827a(Uri.decode(this.f12937e));
        this.f12941i = (LinearLayout) inflate.findViewById(R.id.pdf_container);
        MuPDFCore muPDFCore = this.f12934b;
        if (muPDFCore != null && muPDFCore.countPages() == 0) {
            this.f12934b = null;
        }
        MuPDFCore muPDFCore2 = this.f12934b;
        if (muPDFCore2 == null || muPDFCore2.countPages() == 0 || this.f12934b.countPages() == -1) {
            Log.e("PdfFragment", "Document Not Opening");
        }
        this.f12943k = this.f12934b.countPages();
        if (this.f12934b != null) {
            this.f12935c = new C2292t(this, getActivity(), this);
            this.f12945m = new MuPDFPageAdapter(this.f12936d, this.f12934b, this.f12935c, this);
            this.f12935c.setAdapter(this.f12945m);
            this.f12941i.addView(this.f12935c);
            TextView textView = this.f12939g;
            textView.setText((this.f12935c.getDisplayedViewIndex() + 1) + "/");
            this.f12940h.setText(String.valueOf(this.f12934b.countPages()));
            this.f12942j = this.f12935c.getDisplayedViewIndex() + 1;
            this.f12943k = this.f12934b.countPages();
        }
        return inflate;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (TextUtils.isEmpty(this.f12946n)) {
            return;
        }
        setTitle(this.f12946n);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int i = getResources().getConfiguration().orientation;
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private MuPDFCore m6827a(String str) {
        try {
            this.f12934b = new MuPDFCore(this.f12936d, str);
            return this.f12934b;
        } catch (Exception e) {
            Log.e("PdfFragment", e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r7) {
        /*
            r6 = this;
            int r7 = r7.getId()
            r0 = 2131296964(0x7f0902c4, float:1.821186E38)
            r1 = 1
            if (r7 == r0) goto L60
            r0 = 2131297198(0x7f0903ae, float:1.8212334E38)
            if (r7 == r0) goto L4d
            r0 = 2131297210(0x7f0903ba, float:1.8212358E38)
            if (r7 == r0) goto L3f
            r0 = 2131297215(0x7f0903bf, float:1.8212369E38)
            if (r7 == r0) goto L1a
            goto L5f
        L1a:
            android.content.Intent r7 = new android.content.Intent
            r7.<init>()
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "FilePath"
            java.lang.String r2 = r6.f12937e
            r0.putString(r1, r2)
            r7.putExtras(r0)
            android.app.Activity r0 = r6.getActivity()
            java.lang.Class<com.cnlaunch.x431pro.activity.share.ShareActivity> r1 = com.cnlaunch.x431pro.activity.share.ShareActivity.class
            r7.setClass(r0, r1)
            android.app.Activity r0 = r6.getActivity()
            r0.startActivity(r7)
            return
        L3f:
            android.content.Context r7 = r6.f12936d
            r0 = 2131691790(0x7f0f090e, float:1.9012662E38)
            com.cnlaunch.x431pro.widget.p290a.LoadDialog.m4685a(r7, r0)
            r7 = 20013(0x4e2d, float:2.8044E-41)
            r6.request(r7)
            return
        L4d:
            com.cnlaunch.x431pro.activity.info.u r7 = new com.cnlaunch.x431pro.activity.info.u
            r7.<init>(r6)
            android.app.Activity r0 = r6.getActivity()
            r2 = 2131690868(0x7f0f0574, float:1.9010792E38)
            r3 = 2131691342(0x7f0f074e, float:1.9011753E38)
            r7.m4610a(r0, r2, r3, r1)
        L5f:
            return
        L60:
            android.widget.EditText r7 = r6.f12944l
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            boolean r7 = com.cnlaunch.golo3.p165g.C1621v.m9121a(r7)
            r0 = 0
            if (r7 != 0) goto Lcd
            java.lang.String r7 = r6.f12949q
            if (r7 != 0) goto L82
            android.widget.EditText r7 = r6.f12944l
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            r6.f12949q = r7
            goto La0
        L82:
            android.widget.EditText r2 = r6.f12944l
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto La0
            android.widget.EditText r7 = r6.f12944l
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            r6.f12949q = r7
            r7 = 1
            goto La1
        La0:
            r7 = 0
        La1:
            android.widget.EditText r2 = r6.f12944l
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            com.artifex.mupdflib.MuPDFReaderView r3 = r6.f12935c
            int r3 = r3.getDisplayedViewIndex()
            com.artifex.mupdflib.SearchTaskResult r4 = com.artifex.mupdflib.SearchTaskResult.get()
            r5 = -1
            if (r4 == 0) goto Lbb
            int r4 = r4.pageNumber
            goto Lbc
        Lbb:
            r4 = -1
        Lbc:
            if (r7 == 0) goto Lbf
            r4 = -1
        Lbf:
            int r7 = r6.f12942j
            int r5 = r6.f12943k
            if (r7 != r5) goto Lc6
            goto Lc7
        Lc6:
            r0 = 1
        Lc7:
            com.artifex.mupdflib.SearchTask r7 = r6.f12938f
            r7.m12507go(r2, r0, r3, r4)
            return
        Lcd:
            android.app.Activity r7 = r6.getActivity()
            r1 = 2131691734(0x7f0f08d6, float:1.9012548E38)
            android.widget.Toast r7 = android.widget.Toast.makeText(r7, r1, r0)
            r7.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.info.PdfViewFragment.onClick(android.view.View):void");
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        SearchTaskResult.set(new SearchTaskResult("", -1, new RectF[0], new RectF[0]));
        MuPDFReaderView muPDFReaderView = this.f12935c;
        if (muPDFReaderView != null) {
            muPDFReaderView.applyToChildren(new C2294v(this));
        }
        MuPDFCore muPDFCore = this.f12934b;
        if (muPDFCore != null) {
            muPDFCore.onDestroy();
            this.f12934b = null;
        }
        this.f12945m.releaseBitmaps();
        SearchTask searchTask = this.f12938f;
        if (searchTask != null) {
            searchTask.stop();
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        getActivity().getParent().getWindow().setSoftInputMode(32);
        this.f12947o.sendEmptyMessageDelayed(40994, 500L);
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
