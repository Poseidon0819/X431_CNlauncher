package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;

/* loaded from: classes.dex */
public class WebViewAdUrlGenerator extends AdUrlGenerator {

    /* renamed from: f */
    private final boolean f20501f;

    public WebViewAdUrlGenerator(Context context, boolean z) {
        super(context);
        this.f20501f = z;
    }

    @Override // com.mopub.common.BaseUrlGenerator
    public String generateUrlString(String str) {
        m2609a(str, Constants.AD_HANDLER);
        m2610a("6");
        m2613a(ClientMetadata.getInstance(this.f19977a));
        m2614a();
        m2608a(this.f20501f);
        return this.f19982e.toString();
    }
}
