package com.mopub.mraid;

import android.graphics.Rect;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import com.mopub.common.CloseableLayout;
import com.mopub.common.util.Dips;
import com.mopub.mraid.MraidBridge;
import com.mopub.mraid.MraidController;
import java.net.URI;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MraidController.java */
/* renamed from: com.mopub.mraid.j */
/* loaded from: classes.dex */
public final class C3823j implements MraidBridge.MraidBridgeListener {

    /* renamed from: a */
    final /* synthetic */ MraidController f20719a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3823j(MraidController mraidController) {
        this.f20719a = mraidController;
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onPageLoaded() {
        MraidController mraidController = this.f20719a;
        mraidController.m2249a(ViewState.DEFAULT, new RunnableC3825l(mraidController));
        if (mraidController.f20663g != null) {
            mraidController.f20663g.onLoaded(mraidController.f20659c);
        }
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onPageFailedToLoad() {
        MraidController.MraidListener mraidListener;
        MraidController.MraidListener mraidListener2;
        mraidListener = this.f20719a.f20663g;
        if (mraidListener != null) {
            mraidListener2 = this.f20719a.f20663g;
            mraidListener2.onFailedToLoad();
        }
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onVisibilityChanged(boolean z) {
        MraidBridge mraidBridge;
        MraidBridge mraidBridge2;
        mraidBridge = this.f20719a.f20666j;
        if (mraidBridge.m2262b()) {
            return;
        }
        mraidBridge2 = this.f20719a.f20673q;
        mraidBridge2.m2264a(z);
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final boolean onJsAlert(String str, JsResult jsResult) {
        return this.f20719a.m2245a(str, jsResult);
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.f20719a.m2251a(consoleMessage);
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onClose() {
        this.f20719a.m2254a();
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onResize(int i, int i2, int i3, int i4, CloseableLayout.ClosePosition closePosition, boolean z) throws MraidCommandException {
        MraidController mraidController = this.f20719a;
        if (mraidController.f20664h == null) {
            throw new MraidCommandException("Unable to resize after the WebView is destroyed");
        }
        if (mraidController.f20662f == ViewState.LOADING || mraidController.f20662f == ViewState.HIDDEN) {
            return;
        }
        if (mraidController.f20662f == ViewState.EXPANDED) {
            throw new MraidCommandException("Not allowed to resize from an already expanded ad");
        }
        if (mraidController.f20658b == PlacementType.INTERSTITIAL) {
            throw new MraidCommandException("Not allowed to resize from an interstitial ad");
        }
        int dipsToIntPixels = Dips.dipsToIntPixels(i, mraidController.f20657a);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(i2, mraidController.f20657a);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(i3, mraidController.f20657a);
        int dipsToIntPixels4 = Dips.dipsToIntPixels(i4, mraidController.f20657a);
        int i5 = mraidController.f20661e.f20743g.left + dipsToIntPixels3;
        int i6 = mraidController.f20661e.f20743g.top + dipsToIntPixels4;
        Rect rect = new Rect(i5, i6, dipsToIntPixels + i5, i6 + dipsToIntPixels2);
        if (!z) {
            Rect rect2 = mraidController.f20661e.f20739c;
            if (rect.width() > rect2.width() || rect.height() > rect2.height()) {
                throw new MraidCommandException("resizeProperties specified a size (" + i + ", " + i2 + ") and offset (" + i3 + ", " + i4 + ") that doesn't allow the ad to appear within the max allowed size (" + mraidController.f20661e.f20740d.width() + ", " + mraidController.f20661e.f20740d.height() + ")");
            }
            rect.offsetTo(MraidController.m2252a(rect2.left, rect.left, rect2.right - rect.width()), MraidController.m2252a(rect2.top, rect.top, rect2.bottom - rect.height()));
        }
        Rect rect3 = new Rect();
        mraidController.f20660d.applyCloseRegionBounds(closePosition, rect, rect3);
        if (!mraidController.f20661e.f20739c.contains(rect3)) {
            throw new MraidCommandException("resizeProperties specified a size (" + i + ", " + i2 + ") and offset (" + i3 + ", " + i4 + ") that doesn't allow the close region to appear within the max allowed size (" + mraidController.f20661e.f20740d.width() + ", " + mraidController.f20661e.f20740d.height() + ")");
        } else if (!rect.contains(rect3)) {
            throw new MraidCommandException("resizeProperties specified a size (" + i + ", " + dipsToIntPixels2 + ") and offset (" + i3 + ", " + i4 + ") that don't allow the close region to appear within the resized ad.");
        } else {
            mraidController.f20660d.setCloseVisible(false);
            mraidController.f20660d.setClosePosition(closePosition);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
            layoutParams.leftMargin = rect.left - mraidController.f20661e.f20739c.left;
            layoutParams.topMargin = rect.top - mraidController.f20661e.f20739c.top;
            if (mraidController.f20662f == ViewState.DEFAULT) {
                mraidController.f20659c.removeView(mraidController.f20664h);
                mraidController.f20659c.setVisibility(4);
                mraidController.f20660d.addView(mraidController.f20664h, new FrameLayout.LayoutParams(-1, -1));
                mraidController.m2242b().addView(mraidController.f20660d, layoutParams);
            } else if (mraidController.f20662f == ViewState.RESIZED) {
                mraidController.f20660d.setLayoutParams(layoutParams);
            }
            mraidController.f20660d.setClosePosition(closePosition);
            mraidController.m2249a(ViewState.RESIZED, (Runnable) null);
        }
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onExpand(URI uri, boolean z) throws MraidCommandException {
        MraidController mraidController = this.f20719a;
        if (mraidController.f20664h == null) {
            throw new MraidCommandException("Unable to expand after the WebView is destroyed");
        }
        if (mraidController.f20658b != PlacementType.INTERSTITIAL) {
            if (mraidController.f20662f == ViewState.DEFAULT || mraidController.f20662f == ViewState.RESIZED) {
                mraidController.m2239c();
                boolean z2 = uri != null;
                if (z2) {
                    mraidController.f20665i = new MraidBridge.MraidWebView(mraidController.f20657a);
                    mraidController.f20666j.m2273a(mraidController.f20665i);
                    mraidController.f20666j.setContentUrl(uri.toString());
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                if (mraidController.f20662f == ViewState.DEFAULT) {
                    if (z2) {
                        mraidController.f20660d.addView(mraidController.f20665i, layoutParams);
                    } else {
                        mraidController.f20659c.removeView(mraidController.f20664h);
                        mraidController.f20659c.setVisibility(4);
                        mraidController.f20660d.addView(mraidController.f20664h, layoutParams);
                    }
                    mraidController.m2242b().addView(mraidController.f20660d, new FrameLayout.LayoutParams(-1, -1));
                } else if (mraidController.f20662f == ViewState.RESIZED && z2) {
                    mraidController.f20660d.removeView(mraidController.f20664h);
                    mraidController.f20659c.addView(mraidController.f20664h, layoutParams);
                    mraidController.f20659c.setVisibility(4);
                    mraidController.f20660d.addView(mraidController.f20665i, layoutParams);
                }
                mraidController.f20660d.setLayoutParams(layoutParams);
                mraidController.m2244a(z);
                mraidController.m2249a(ViewState.EXPANDED, (Runnable) null);
            }
        }
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onUseCustomClose(boolean z) {
        this.f20719a.m2244a(z);
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onSetOrientationProperties(boolean z, MraidOrientation mraidOrientation) throws MraidCommandException {
        this.f20719a.m2243a(z, mraidOrientation);
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onOpen(URI uri) {
        this.f20719a.m2240b(uri.toString());
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onPlayVideo(URI uri) {
        this.f20719a.m2246a(uri.toString());
    }
}
