package com.mopub.nativeads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class MoPubAdAdapter extends BaseAdapter {

    /* renamed from: a */
    MoPubNativeAdLoadedListener f20818a;

    /* renamed from: b */
    private final WeakHashMap<View, Integer> f20819b;

    /* renamed from: c */
    private final Adapter f20820c;

    /* renamed from: d */
    private final MoPubStreamAdPlacer f20821d;

    /* renamed from: e */
    private final VisibilityTracker f20822e;

    public MoPubAdAdapter(Activity activity, Adapter adapter) {
        this(activity, adapter, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubAdAdapter(Activity activity, Adapter adapter, MoPubNativeAdPositioning.MoPubServerPositioning moPubServerPositioning) {
        this(new MoPubStreamAdPlacer(activity, moPubServerPositioning), adapter, new VisibilityTracker(activity));
    }

    public MoPubAdAdapter(Activity activity, Adapter adapter, MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        this(new MoPubStreamAdPlacer(activity, moPubClientPositioning), adapter, new VisibilityTracker(activity));
    }

    @VisibleForTesting
    private MoPubAdAdapter(MoPubStreamAdPlacer moPubStreamAdPlacer, Adapter adapter, VisibilityTracker visibilityTracker) {
        this.f20820c = adapter;
        this.f20821d = moPubStreamAdPlacer;
        this.f20819b = new WeakHashMap<>();
        this.f20822e = visibilityTracker;
        this.f20822e.f21125e = new C3888g(this);
        this.f20820c.registerDataSetObserver(new C3889h(this));
        this.f20821d.setAdLoadedListener(new C3890i(this));
        this.f20821d.setItemCount(this.f20820c.getCount());
    }

    public final void registerAdRenderer(MoPubAdRenderer moPubAdRenderer) {
        if (Preconditions.NoThrow.checkNotNull(moPubAdRenderer, "Tried to set a null ad renderer on the placer.")) {
            this.f20821d.registerAdRenderer(moPubAdRenderer);
        }
    }

    public final void setAdLoadedListener(MoPubNativeAdLoadedListener moPubNativeAdLoadedListener) {
        this.f20818a = moPubNativeAdLoadedListener;
    }

    public void loadAds(String str) {
        this.f20821d.loadAds(str);
    }

    public void loadAds(String str, RequestParameters requestParameters) {
        this.f20821d.loadAds(str, requestParameters);
    }

    public boolean isAd(int i) {
        return this.f20821d.isAd(i);
    }

    public void clearAds() {
        this.f20821d.clearAds();
    }

    public void destroy() {
        this.f20821d.destroy();
        this.f20822e.m2058b();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        Adapter adapter = this.f20820c;
        return (adapter instanceof ListAdapter) && ((ListAdapter) adapter).areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (isAd(i)) {
            return true;
        }
        Adapter adapter = this.f20820c;
        return (adapter instanceof ListAdapter) && ((ListAdapter) adapter).isEnabled(this.f20821d.getOriginalPosition(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f20821d.getAdjustedCount(this.f20820c.getCount());
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object adData = this.f20821d.getAdData(i);
        return adData != null ? adData : this.f20820c.getItem(this.f20821d.getOriginalPosition(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Object adData = this.f20821d.getAdData(i);
        if (adData != null) {
            return -System.identityHashCode(adData);
        }
        return this.f20820c.getItemId(this.f20821d.getOriginalPosition(i));
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.f20820c.hasStableIds();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View adView = this.f20821d.getAdView(i, view, viewGroup);
        if (adView == null) {
            adView = this.f20820c.getView(this.f20821d.getOriginalPosition(i), view, viewGroup);
        }
        this.f20819b.put(adView, Integer.valueOf(i));
        this.f20822e.m2060a(adView, adView, 0);
        return adView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int adViewType = this.f20821d.getAdViewType(i);
        if (adViewType != 0) {
            return (adViewType + this.f20820c.getViewTypeCount()) - 1;
        }
        return this.f20820c.getItemViewType(this.f20821d.getOriginalPosition(i));
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f20820c.getViewTypeCount() + this.f20821d.getAdViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.f20820c.isEmpty() && this.f20821d.getAdjustedCount(0) == 0;
    }

    public int getOriginalPosition(int i) {
        return this.f20821d.getOriginalPosition(i);
    }

    public int getAdjustedPosition(int i) {
        return this.f20821d.getAdjustedPosition(i);
    }

    public void insertItem(int i) {
        this.f20821d.insertItem(i);
    }

    public void removeItem(int i) {
        this.f20821d.removeItem(i);
    }

    public void setOnClickListener(ListView listView, AdapterView.OnItemClickListener onItemClickListener) {
        if (Preconditions.NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setOnClickListener with a null ListView")) {
            if (onItemClickListener == null) {
                listView.setOnItemClickListener(null);
            } else {
                listView.setOnItemClickListener(new C3891j(this, onItemClickListener));
            }
        }
    }

    public void setOnItemLongClickListener(ListView listView, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (Preconditions.NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setOnItemLongClickListener with a null ListView")) {
            if (onItemLongClickListener == null) {
                listView.setOnItemLongClickListener(null);
            } else {
                listView.setOnItemLongClickListener(new C3892k(this, onItemLongClickListener));
            }
        }
    }

    public void setOnItemSelectedListener(ListView listView, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (Preconditions.NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setOnItemSelectedListener with a null ListView")) {
            if (onItemSelectedListener == null) {
                listView.setOnItemSelectedListener(null);
            } else {
                listView.setOnItemSelectedListener(new C3893l(this, onItemSelectedListener));
            }
        }
    }

    public void setSelection(ListView listView, int i) {
        if (Preconditions.NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setSelection with a null ListView")) {
            listView.setSelection(this.f20821d.getAdjustedPosition(i));
        }
    }

    public void smoothScrollToPosition(ListView listView, int i) {
        if (Preconditions.NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.smoothScrollToPosition with a null ListView")) {
            listView.smoothScrollToPosition(this.f20821d.getAdjustedPosition(i));
        }
    }

    public void refreshAds(ListView listView, String str) {
        refreshAds(listView, str, null);
    }

    public void refreshAds(ListView listView, String str, RequestParameters requestParameters) {
        if (Preconditions.NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.refreshAds with a null ListView")) {
            View childAt = listView.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int max = Math.max(firstVisiblePosition - 1, 0);
            while (this.f20821d.isAd(max) && max > 0) {
                max--;
            }
            int lastVisiblePosition = listView.getLastVisiblePosition();
            while (this.f20821d.isAd(lastVisiblePosition) && lastVisiblePosition < getCount() - 1) {
                lastVisiblePosition++;
            }
            int originalPosition = this.f20821d.getOriginalPosition(max);
            this.f20821d.removeAdsInRange(this.f20821d.getOriginalCount(lastVisiblePosition + 1), this.f20821d.getOriginalCount(getCount()));
            int removeAdsInRange = this.f20821d.removeAdsInRange(0, originalPosition);
            if (removeAdsInRange > 0) {
                listView.setSelectionFromTop(firstVisiblePosition - removeAdsInRange, top);
            }
            loadAds(str, requestParameters);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m2180a(MoPubAdAdapter moPubAdAdapter, List list) {
        Iterator it = list.iterator();
        int i = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        int i2 = 0;
        while (it.hasNext()) {
            Integer num = moPubAdAdapter.f20819b.get((View) it.next());
            if (num != null) {
                i = Math.min(num.intValue(), i);
                i2 = Math.max(num.intValue(), i2);
            }
        }
        moPubAdAdapter.f20821d.placeAdsInRange(i, i2 + 1);
    }
}
