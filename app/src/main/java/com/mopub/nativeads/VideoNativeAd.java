package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.view.View;
import com.mopub.common.Preconditions;
import com.mopub.nativeads.NativeVideoController;
import java.util.HashMap;
import java.util.Map;

@TargetApi(16)
/* loaded from: classes2.dex */
public abstract class VideoNativeAd extends BaseNativeAd implements NativeVideoController.Listener {

    /* renamed from: c */
    private String f21016c;

    /* renamed from: d */
    private String f21017d;

    /* renamed from: e */
    private String f21018e;

    /* renamed from: f */
    private String f21019f;

    /* renamed from: g */
    private String f21020g;

    /* renamed from: h */
    private String f21021h;

    /* renamed from: i */
    private String f21022i;

    /* renamed from: j */
    private String f21023j;

    /* renamed from: k */
    private String f21024k;

    /* renamed from: l */
    private final Map<String, Object> f21025l = new HashMap();

    @Override // com.mopub.nativeads.BaseNativeAd
    public void clear(View view) {
    }

    @Override // com.mopub.nativeads.BaseNativeAd
    public void destroy() {
    }

    @Override // com.mopub.nativeads.BaseNativeAd
    public void prepare(View view) {
    }

    public void render(MediaLayout mediaLayout) {
    }

    public String getTitle() {
        return this.f21020g;
    }

    public String getText() {
        return this.f21021h;
    }

    public String getMainImageUrl() {
        return this.f21016c;
    }

    public String getIconImageUrl() {
        return this.f21017d;
    }

    public String getClickDestinationUrl() {
        return this.f21018e;
    }

    public String getVastVideo() {
        return this.f21024k;
    }

    public String getCallToAction() {
        return this.f21019f;
    }

    public String getPrivacyInformationIconClickThroughUrl() {
        return this.f21022i;
    }

    public String getPrivacyInformationIconImageUrl() {
        return this.f21023j;
    }

    public final Object getExtra(String str) {
        if (Preconditions.NoThrow.checkNotNull(str, "getExtra key is not allowed to be null")) {
            return this.f21025l.get(str);
        }
        return null;
    }

    public final Map<String, Object> getExtras() {
        return this.f21025l;
    }

    public void setTitle(String str) {
        this.f21020g = str;
    }

    public void setText(String str) {
        this.f21021h = str;
    }

    public void setMainImageUrl(String str) {
        this.f21016c = str;
    }

    public void setIconImageUrl(String str) {
        this.f21017d = str;
    }

    public void setClickDestinationUrl(String str) {
        this.f21018e = str;
    }

    public void setVastVideo(String str) {
        this.f21024k = str;
    }

    public void setCallToAction(String str) {
        this.f21019f = str;
    }

    public void setPrivacyInformationIconClickThroughUrl(String str) {
        this.f21022i = str;
    }

    public void setPrivacyInformationIconImageUrl(String str) {
        this.f21023j = str;
    }

    public final void addExtra(String str, Object obj) {
        if (Preconditions.NoThrow.checkNotNull(str, "addExtra key is not allowed to be null")) {
            this.f21025l.put(str, obj);
        }
    }
}
