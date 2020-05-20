package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.logging.MoPubLog;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;
import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class UrlHandler {

    /* renamed from: c */
    private static final ResultActions f20097c = new C3713v();

    /* renamed from: d */
    private static final MoPubSchemeListener f20098d = new C3714w();

    /* renamed from: a */
    MoPubSchemeListener f20099a;

    /* renamed from: b */
    boolean f20100b;

    /* renamed from: e */
    private EnumSet<UrlAction> f20101e;

    /* renamed from: f */
    private ResultActions f20102f;

    /* renamed from: g */
    private String f20103g;

    /* renamed from: h */
    private boolean f20104h;

    /* renamed from: i */
    private boolean f20105i;

    /* loaded from: classes.dex */
    public interface MoPubSchemeListener {
        void onClose();

        void onFailLoad();

        void onFinishLoad();
    }

    /* loaded from: classes.dex */
    public interface ResultActions {
        void urlHandlingFailed(String str, UrlAction urlAction);

        void urlHandlingSucceeded(String str, UrlAction urlAction);
    }

    /* synthetic */ UrlHandler(EnumSet enumSet, ResultActions resultActions, MoPubSchemeListener moPubSchemeListener, boolean z, String str, byte b) {
        this(enumSet, resultActions, moPubSchemeListener, z, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m2544a(UrlHandler urlHandler) {
        urlHandler.f20105i = false;
        return false;
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        private EnumSet<UrlAction> f20106a = EnumSet.of(UrlAction.NOOP);

        /* renamed from: b */
        private ResultActions f20107b = UrlHandler.f20097c;

        /* renamed from: c */
        private MoPubSchemeListener f20108c = UrlHandler.f20098d;

        /* renamed from: d */
        private boolean f20109d = false;

        /* renamed from: e */
        private String f20110e;

        public Builder withSupportedUrlActions(UrlAction urlAction, UrlAction... urlActionArr) {
            this.f20106a = EnumSet.of(urlAction, urlActionArr);
            return this;
        }

        public Builder withSupportedUrlActions(EnumSet<UrlAction> enumSet) {
            this.f20106a = EnumSet.copyOf((EnumSet) enumSet);
            return this;
        }

        public Builder withResultActions(ResultActions resultActions) {
            this.f20107b = resultActions;
            return this;
        }

        public Builder withMoPubSchemeListener(MoPubSchemeListener moPubSchemeListener) {
            this.f20108c = moPubSchemeListener;
            return this;
        }

        public Builder withoutMoPubBrowser() {
            this.f20109d = true;
            return this;
        }

        public Builder withDspCreativeId(String str) {
            this.f20110e = str;
            return this;
        }

        public UrlHandler build() {
            return new UrlHandler(this.f20106a, this.f20107b, this.f20108c, this.f20109d, this.f20110e, (byte) 0);
        }
    }

    private UrlHandler(EnumSet<UrlAction> enumSet, ResultActions resultActions, MoPubSchemeListener moPubSchemeListener, boolean z, String str) {
        this.f20101e = EnumSet.copyOf((EnumSet) enumSet);
        this.f20102f = resultActions;
        this.f20099a = moPubSchemeListener;
        this.f20100b = z;
        this.f20103g = str;
        this.f20104h = false;
        this.f20105i = false;
    }

    public void handleUrl(Context context, String str) {
        Preconditions.checkNotNull(context);
        handleUrl(context, str, true);
    }

    public void handleUrl(Context context, String str, boolean z) {
        Preconditions.checkNotNull(context);
        handleUrl(context, str, z, null);
    }

    public void handleUrl(Context context, String str, boolean z, Iterable<String> iterable) {
        Preconditions.checkNotNull(context);
        if (TextUtils.isEmpty(str)) {
            m2542a(str, (UrlAction) null, "Attempted to handle empty url.", (Throwable) null);
            return;
        }
        UrlResolutionTask.getResolvedUrl(str, new C3715x(this, context, z, iterable, str));
        this.f20105i = true;
    }

    public boolean handleResolvedUrl(Context context, String str, boolean z, Iterable<String> iterable) {
        if (TextUtils.isEmpty(str)) {
            m2542a(str, (UrlAction) null, "Attempted to handle empty url.", (Throwable) null);
            return false;
        }
        UrlAction urlAction = UrlAction.NOOP;
        Uri parse = Uri.parse(str);
        Iterator it = this.f20101e.iterator();
        while (it.hasNext()) {
            UrlAction urlAction2 = (UrlAction) it.next();
            if (urlAction2.shouldTryHandlingUrl(parse)) {
                try {
                    urlAction2.handleUrl(this, context, parse, z, this.f20103g);
                    if (!this.f20104h && !this.f20105i && !UrlAction.IGNORE_ABOUT_SCHEME.equals(urlAction2) && !UrlAction.HANDLE_MOPUB_SCHEME.equals(urlAction2)) {
                        try {
                            TrackingRequest.makeTrackingHttpRequest(iterable, context, BaseEvent.Name.CLICK_REQUEST);
                            this.f20102f.urlHandlingSucceeded(parse.toString(), urlAction2);
                            this.f20104h = true;
                        } catch (IntentNotResolvableException e) {
                            e = e;
                            MoPubLog.m2497d(e.getMessage(), e);
                            urlAction = urlAction2;
                        }
                    }
                    return true;
                } catch (IntentNotResolvableException e2) {
                    e = e2;
                }
            }
        }
        m2542a(str, urlAction, "Link ignored. Unable to handle url: ".concat(String.valueOf(str)), (Throwable) null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2542a(String str, UrlAction urlAction, String str2, Throwable th) {
        Preconditions.checkNotNull(str2);
        if (urlAction == null) {
            urlAction = UrlAction.NOOP;
        }
        MoPubLog.m2497d(str2, th);
        this.f20102f.urlHandlingFailed(str, urlAction);
    }
}
