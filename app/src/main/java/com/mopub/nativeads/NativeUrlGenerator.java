package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.nativeads.ap */
/* loaded from: classes2.dex */
public final class NativeUrlGenerator extends AdUrlGenerator {

    /* renamed from: f */
    String f21078f;

    /* renamed from: g */
    private String f21079g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeUrlGenerator(Context context) {
        super(context);
    }

    @Override // com.mopub.common.AdUrlGenerator
    public final NativeUrlGenerator withAdUnitId(String str) {
        this.f19978b = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final NativeUrlGenerator m2082a(RequestParameters requestParameters) {
        if (requestParameters != null) {
            this.f19979c = requestParameters.getKeywords();
            this.f19980d = requestParameters.getLocation();
            this.f21079g = requestParameters.getDesiredAssets();
        }
        return this;
    }

    @Override // com.mopub.common.BaseUrlGenerator
    public final String generateUrlString(String str) {
        m2609a(str, Constants.AD_HANDLER);
        m2613a(ClientMetadata.getInstance(this.f19977a));
        if (!TextUtils.isEmpty(this.f21079g)) {
            m2604b("assets", this.f21079g);
        }
        if (!TextUtils.isEmpty(this.f21078f)) {
            m2604b("MAGIC_NO", this.f21078f);
        }
        return this.f19982e.toString();
    }

    @Override // com.mopub.common.AdUrlGenerator
    public final void setSdkVersion(String str) {
        m2604b("nsv", str);
    }
}
