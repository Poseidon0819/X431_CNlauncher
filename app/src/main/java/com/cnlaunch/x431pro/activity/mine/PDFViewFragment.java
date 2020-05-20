package com.cnlaunch.x431pro.activity.mine;

import android.app.Activity;
import android.os.Bundle;
import org.vudroid.core.DecodeService;
import org.vudroid.core.DecodeServiceBase;
import org.vudroid.pdfdroid.codec.PdfContext;

/* renamed from: com.cnlaunch.x431pro.activity.mine.bl */
/* loaded from: classes.dex */
public final class PDFViewFragment extends BasePDFViewFragment {

    /* renamed from: a */
    private String f13935a = "";

    @Override // com.cnlaunch.x431pro.activity.mine.BasePDFViewFragment
    /* renamed from: a */
    public final String mo6292a() {
        return this.f13935a;
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13935a = arguments.getString("uri_name");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.mine.BasePDFViewFragment
    /* renamed from: b */
    protected final DecodeService mo6291b() {
        return new DecodeServiceBase(new PdfContext());
    }

    @Override // com.cnlaunch.x431pro.activity.mine.BasePDFViewFragment, android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
    }
}
