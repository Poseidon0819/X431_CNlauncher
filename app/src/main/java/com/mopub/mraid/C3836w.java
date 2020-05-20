package com.mopub.mraid;

import android.content.Context;
import android.widget.Toast;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mraid.MraidNativeCommandHandler;

/* compiled from: MraidNativeCommandHandler.java */
/* renamed from: com.mopub.mraid.w */
/* loaded from: classes.dex */
final class C3836w implements MraidNativeCommandHandler.AsyncTaskC3808a.InterfaceC3809a {

    /* renamed from: a */
    final /* synthetic */ Context f20729a;

    /* renamed from: b */
    final /* synthetic */ MraidNativeCommandHandler.InterfaceC3811c f20730b;

    /* renamed from: c */
    final /* synthetic */ MraidNativeCommandHandler f20731c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3836w(MraidNativeCommandHandler mraidNativeCommandHandler, Context context, MraidNativeCommandHandler.InterfaceC3811c interfaceC3811c) {
        this.f20731c = mraidNativeCommandHandler;
        this.f20729a = context;
        this.f20730b = interfaceC3811c;
    }

    @Override // com.mopub.mraid.MraidNativeCommandHandler.AsyncTaskC3808a.InterfaceC3809a
    public final void onSuccess() {
        MoPubLog.m2498d("Image successfully saved.");
    }

    @Override // com.mopub.mraid.MraidNativeCommandHandler.AsyncTaskC3808a.InterfaceC3809a
    public final void onFailure() {
        Toast.makeText(this.f20729a, "Image failed to download.", 0).show();
        MoPubLog.m2498d("Error downloading and saving image file.");
        this.f20730b.onFailure(new MraidCommandException("Error downloading and saving image file."));
    }
}
