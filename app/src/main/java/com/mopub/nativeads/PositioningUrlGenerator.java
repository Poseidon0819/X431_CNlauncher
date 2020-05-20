package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;

/* renamed from: com.mopub.nativeads.aw */
/* loaded from: classes2.dex */
final class PositioningUrlGenerator extends BaseUrlGenerator {

    /* renamed from: a */
    private final Context f21092a;

    /* renamed from: b */
    private String f21093b;

    public PositioningUrlGenerator(Context context) {
        this.f21092a = context;
    }

    public final PositioningUrlGenerator withAdUnitId(String str) {
        this.f21093b = str;
        return this;
    }

    @Override // com.mopub.common.BaseUrlGenerator
    public final String generateUrlString(String str) {
        m2609a(str, Constants.POSITIONING_HANDLER);
        m2604b("id", this.f21093b);
        m2610a("1");
        ClientMetadata clientMetadata = ClientMetadata.getInstance(this.f21092a);
        m2604b("nsv", clientMetadata.getSdkVersion());
        m2607a(clientMetadata.getDeviceManufacturer(), clientMetadata.getDeviceModel(), clientMetadata.getDeviceProduct());
        m2605b(clientMetadata.getAppVersion());
        m2606b();
        return this.f19982e.toString();
    }
}
