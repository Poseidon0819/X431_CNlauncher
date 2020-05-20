package com.mopub.nativeads;

import android.app.Activity;
import android.support.p023v7.widget.LinearLayoutManager;
import android.support.p023v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class MoPubRecyclerAdapter extends RecyclerView.AbstractC0457a<RecyclerView.AbstractC0480t> {

    /* renamed from: a */
    MoPubNativeAdLoadedListener f20878a;

    /* renamed from: b */
    private final RecyclerView.AbstractC0459c f20879b;

    /* renamed from: c */
    private RecyclerView f20880c;

    /* renamed from: d */
    private final MoPubStreamAdPlacer f20881d;

    /* renamed from: e */
    private final RecyclerView.AbstractC0457a f20882e;

    /* renamed from: f */
    private final VisibilityTracker f20883f;

    /* renamed from: g */
    private final WeakHashMap<View, Integer> f20884g;

    /* renamed from: h */
    private ContentChangeStrategy f20885h;

    /* loaded from: classes2.dex */
    public enum ContentChangeStrategy {
        INSERT_AT_END,
        MOVE_ALL_ADS_WITH_CONTENT,
        KEEP_ADS_FIXED
    }

    public MoPubRecyclerAdapter(Activity activity, RecyclerView.AbstractC0457a abstractC0457a) {
        this(activity, abstractC0457a, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubRecyclerAdapter(Activity activity, RecyclerView.AbstractC0457a abstractC0457a, MoPubNativeAdPositioning.MoPubServerPositioning moPubServerPositioning) {
        this(new MoPubStreamAdPlacer(activity, moPubServerPositioning), abstractC0457a, new VisibilityTracker(activity));
    }

    public MoPubRecyclerAdapter(Activity activity, RecyclerView.AbstractC0457a abstractC0457a, MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        this(new MoPubStreamAdPlacer(activity, moPubClientPositioning), abstractC0457a, new VisibilityTracker(activity));
    }

    @VisibleForTesting
    private MoPubRecyclerAdapter(MoPubStreamAdPlacer moPubStreamAdPlacer, RecyclerView.AbstractC0457a abstractC0457a, VisibilityTracker visibilityTracker) {
        this.f20885h = ContentChangeStrategy.INSERT_AT_END;
        this.f20884g = new WeakHashMap<>();
        this.f20882e = abstractC0457a;
        this.f20883f = visibilityTracker;
        this.f20883f.f21125e = new C3905x(this);
        super.setHasStableIds(this.f20882e.hasStableIds());
        this.f20881d = moPubStreamAdPlacer;
        this.f20881d.setAdLoadedListener(new C3906y(this));
        this.f20881d.setItemCount(this.f20882e.getItemCount());
        this.f20879b = new C3907z(this);
        this.f20882e.registerAdapterDataObserver(this.f20879b);
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0457a
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f20880c = recyclerView;
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0457a
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f20880c = null;
    }

    public final void setAdLoadedListener(MoPubNativeAdLoadedListener moPubNativeAdLoadedListener) {
        this.f20878a = moPubNativeAdLoadedListener;
    }

    public final void registerAdRenderer(MoPubAdRenderer moPubAdRenderer) {
        if (Preconditions.NoThrow.checkNotNull(moPubAdRenderer, "Cannot register a null adRenderer")) {
            this.f20881d.registerAdRenderer(moPubAdRenderer);
        }
    }

    public final void loadAds(String str) {
        this.f20881d.loadAds(str);
    }

    public final void loadAds(String str, RequestParameters requestParameters) {
        this.f20881d.loadAds(str, requestParameters);
    }

    public static int computeScrollOffset(LinearLayoutManager linearLayoutManager, RecyclerView.AbstractC0480t abstractC0480t) {
        if (abstractC0480t == null) {
            return 0;
        }
        View view = abstractC0480t.itemView;
        if (!linearLayoutManager.mo13512f()) {
            if (linearLayoutManager.mo13515e()) {
                if (linearLayoutManager.f1845l) {
                    return view.getRight();
                }
                return view.getLeft();
            }
            return 0;
        } else if (linearLayoutManager.f1845l) {
            return view.getBottom();
        } else {
            return view.getTop();
        }
    }

    public final void refreshAds(String str) {
        refreshAds(str, null);
    }

    public final void refreshAds(String str, RequestParameters requestParameters) {
        RecyclerView recyclerView = this.f20880c;
        if (recyclerView == null) {
            MoPubLog.m2490w("This adapter is not attached to a RecyclerView and cannot be refreshed.");
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            MoPubLog.m2490w("Can't refresh ads when there is no layout manager on a RecyclerView.");
        } else if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int m13833j = linearLayoutManager.m13833j();
            int computeScrollOffset = computeScrollOffset(linearLayoutManager, this.f20880c.m13795a(m13833j, false));
            int max = Math.max(0, m13833j - 1);
            while (this.f20881d.isAd(max) && max > 0) {
                max--;
            }
            int itemCount = getItemCount();
            int m13830k = linearLayoutManager.m13830k();
            while (this.f20881d.isAd(m13830k) && m13830k < itemCount - 1) {
                m13830k++;
            }
            int originalPosition = this.f20881d.getOriginalPosition(max);
            this.f20881d.removeAdsInRange(this.f20881d.getOriginalPosition(m13830k), this.f20882e.getItemCount());
            int removeAdsInRange = this.f20881d.removeAdsInRange(0, originalPosition);
            if (removeAdsInRange > 0) {
                linearLayoutManager.f1846m = m13833j - removeAdsInRange;
                linearLayoutManager.f1847n = computeScrollOffset;
                if (linearLayoutManager.f1848o != null) {
                    linearLayoutManager.f1848o.f1850a = -1;
                }
                linearLayoutManager.m13687l();
            }
            loadAds(str, requestParameters);
        } else {
            MoPubLog.m2490w("This LayoutManager can't be refreshed.");
        }
    }

    public final void clearAds() {
        this.f20881d.clearAds();
    }

    public final boolean isAd(int i) {
        return this.f20881d.isAd(i);
    }

    public final int getAdjustedPosition(int i) {
        return this.f20881d.getAdjustedPosition(i);
    }

    public final int getOriginalPosition(int i) {
        return this.f20881d.getOriginalPosition(i);
    }

    public final void setContentChangeStrategy(ContentChangeStrategy contentChangeStrategy) {
        if (Preconditions.NoThrow.checkNotNull(contentChangeStrategy)) {
            this.f20885h = contentChangeStrategy;
        }
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0457a
    public final int getItemCount() {
        return this.f20881d.getAdjustedCount(this.f20882e.getItemCount());
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0457a
    public final RecyclerView.AbstractC0480t onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i >= -56 && i <= this.f20881d.getAdViewTypeCount() - 56) {
            MoPubAdRenderer adRendererForViewType = this.f20881d.getAdRendererForViewType(i - (-56));
            if (adRendererForViewType == null) {
                MoPubLog.m2490w("No view binder was registered for ads in MoPubRecyclerAdapter.");
                return null;
            }
            return new MoPubRecyclerViewHolder(adRendererForViewType.createAdView((Activity) viewGroup.getContext(), viewGroup));
        }
        return this.f20882e.onCreateViewHolder(viewGroup, i);
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0457a
    public final void onBindViewHolder(RecyclerView.AbstractC0480t abstractC0480t, int i) {
        Object adData = this.f20881d.getAdData(i);
        if (adData != null) {
            this.f20881d.bindAdView((NativeAd) adData, abstractC0480t.itemView);
            return;
        }
        this.f20884g.put(abstractC0480t.itemView, Integer.valueOf(i));
        VisibilityTracker visibilityTracker = this.f20883f;
        View view = abstractC0480t.itemView;
        visibilityTracker.m2060a(view, view, 0);
        this.f20882e.onBindViewHolder(abstractC0480t, this.f20881d.getOriginalPosition(i));
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0457a
    public final int getItemViewType(int i) {
        int adViewType = this.f20881d.getAdViewType(i);
        return adViewType != 0 ? adViewType - 56 : this.f20882e.getItemViewType(this.f20881d.getOriginalPosition(i));
    }

    public final void destroy() {
        this.f20882e.unregisterAdapterDataObserver(this.f20879b);
        this.f20881d.destroy();
        this.f20883f.m2058b();
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0457a
    public final long getItemId(int i) {
        if (this.f20882e.hasStableIds()) {
            Object adData = this.f20881d.getAdData(i);
            if (adData != null) {
                return -System.identityHashCode(adData);
            }
            return this.f20882e.getItemId(this.f20881d.getOriginalPosition(i));
        }
        return -1L;
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0457a
    public final boolean onFailedToRecycleView(RecyclerView.AbstractC0480t abstractC0480t) {
        if (abstractC0480t instanceof MoPubRecyclerViewHolder) {
            return super.onFailedToRecycleView(abstractC0480t);
        }
        return this.f20882e.onFailedToRecycleView(abstractC0480t);
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0457a
    public final void onViewAttachedToWindow(RecyclerView.AbstractC0480t abstractC0480t) {
        if (abstractC0480t instanceof MoPubRecyclerViewHolder) {
            super.onViewAttachedToWindow(abstractC0480t);
        } else {
            this.f20882e.onViewAttachedToWindow(abstractC0480t);
        }
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0457a
    public final void onViewDetachedFromWindow(RecyclerView.AbstractC0480t abstractC0480t) {
        if (abstractC0480t instanceof MoPubRecyclerViewHolder) {
            super.onViewDetachedFromWindow(abstractC0480t);
        } else {
            this.f20882e.onViewDetachedFromWindow(abstractC0480t);
        }
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0457a
    public final void onViewRecycled(RecyclerView.AbstractC0480t abstractC0480t) {
        if (abstractC0480t instanceof MoPubRecyclerViewHolder) {
            super.onViewRecycled(abstractC0480t);
        } else {
            this.f20882e.onViewRecycled(abstractC0480t);
        }
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0457a
    public final void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
        this.f20882e.unregisterAdapterDataObserver(this.f20879b);
        this.f20882e.setHasStableIds(z);
        this.f20882e.registerAdapterDataObserver(this.f20879b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m2138a(MoPubRecyclerAdapter moPubRecyclerAdapter, List list) {
        Iterator it = list.iterator();
        int i = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        int i2 = 0;
        while (it.hasNext()) {
            Integer num = moPubRecyclerAdapter.f20884g.get((View) it.next());
            if (num != null) {
                i = Math.min(num.intValue(), i);
                i2 = Math.max(num.intValue(), i2);
            }
        }
        moPubRecyclerAdapter.f20881d.placeAdsInRange(i, i2 + 1);
    }
}
