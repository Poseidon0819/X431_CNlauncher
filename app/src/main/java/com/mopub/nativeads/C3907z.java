package com.mopub.nativeads;

import android.support.p023v7.widget.RecyclerView;
import com.mopub.nativeads.MoPubRecyclerAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubRecyclerAdapter.java */
/* renamed from: com.mopub.nativeads.z */
/* loaded from: classes2.dex */
public final class C3907z extends RecyclerView.AbstractC0459c {

    /* renamed from: a */
    final /* synthetic */ MoPubRecyclerAdapter f21173a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3907z(MoPubRecyclerAdapter moPubRecyclerAdapter) {
        this.f21173a = moPubRecyclerAdapter;
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0459c
    public final void onChanged() {
        MoPubStreamAdPlacer moPubStreamAdPlacer;
        RecyclerView.AbstractC0457a abstractC0457a;
        moPubStreamAdPlacer = this.f21173a.f20881d;
        abstractC0457a = this.f21173a.f20882e;
        moPubStreamAdPlacer.setItemCount(abstractC0457a.getItemCount());
        this.f21173a.notifyDataSetChanged();
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0459c
    public final void onItemRangeChanged(int i, int i2) {
        MoPubStreamAdPlacer moPubStreamAdPlacer;
        MoPubStreamAdPlacer moPubStreamAdPlacer2;
        moPubStreamAdPlacer = this.f21173a.f20881d;
        int adjustedPosition = moPubStreamAdPlacer.getAdjustedPosition((i2 + i) - 1);
        moPubStreamAdPlacer2 = this.f21173a.f20881d;
        int adjustedPosition2 = moPubStreamAdPlacer2.getAdjustedPosition(i);
        this.f21173a.notifyItemRangeChanged(adjustedPosition2, (adjustedPosition - adjustedPosition2) + 1);
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0459c
    public final void onItemRangeInserted(int i, int i2) {
        MoPubStreamAdPlacer moPubStreamAdPlacer;
        RecyclerView.AbstractC0457a abstractC0457a;
        MoPubStreamAdPlacer moPubStreamAdPlacer2;
        MoPubRecyclerAdapter.ContentChangeStrategy contentChangeStrategy;
        MoPubRecyclerAdapter.ContentChangeStrategy contentChangeStrategy2;
        MoPubStreamAdPlacer moPubStreamAdPlacer3;
        moPubStreamAdPlacer = this.f21173a.f20881d;
        int adjustedPosition = moPubStreamAdPlacer.getAdjustedPosition(i);
        abstractC0457a = this.f21173a.f20882e;
        int itemCount = abstractC0457a.getItemCount();
        moPubStreamAdPlacer2 = this.f21173a.f20881d;
        moPubStreamAdPlacer2.setItemCount(itemCount);
        boolean z = i + i2 >= itemCount;
        MoPubRecyclerAdapter.ContentChangeStrategy contentChangeStrategy3 = MoPubRecyclerAdapter.ContentChangeStrategy.KEEP_ADS_FIXED;
        contentChangeStrategy = this.f21173a.f20885h;
        if (contentChangeStrategy3 != contentChangeStrategy) {
            MoPubRecyclerAdapter.ContentChangeStrategy contentChangeStrategy4 = MoPubRecyclerAdapter.ContentChangeStrategy.INSERT_AT_END;
            contentChangeStrategy2 = this.f21173a.f20885h;
            if (contentChangeStrategy4 != contentChangeStrategy2 || !z) {
                for (int i3 = 0; i3 < i2; i3++) {
                    moPubStreamAdPlacer3 = this.f21173a.f20881d;
                    moPubStreamAdPlacer3.insertItem(i);
                }
                this.f21173a.notifyItemRangeInserted(adjustedPosition, i2);
                return;
            }
        }
        this.f21173a.notifyDataSetChanged();
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0459c
    public final void onItemRangeRemoved(int i, int i2) {
        MoPubStreamAdPlacer moPubStreamAdPlacer;
        RecyclerView.AbstractC0457a abstractC0457a;
        MoPubStreamAdPlacer moPubStreamAdPlacer2;
        MoPubRecyclerAdapter.ContentChangeStrategy contentChangeStrategy;
        MoPubRecyclerAdapter.ContentChangeStrategy contentChangeStrategy2;
        MoPubStreamAdPlacer moPubStreamAdPlacer3;
        MoPubStreamAdPlacer moPubStreamAdPlacer4;
        MoPubStreamAdPlacer moPubStreamAdPlacer5;
        moPubStreamAdPlacer = this.f21173a.f20881d;
        int adjustedPosition = moPubStreamAdPlacer.getAdjustedPosition(i);
        abstractC0457a = this.f21173a.f20882e;
        int itemCount = abstractC0457a.getItemCount();
        moPubStreamAdPlacer2 = this.f21173a.f20881d;
        moPubStreamAdPlacer2.setItemCount(itemCount);
        boolean z = i + i2 >= itemCount;
        MoPubRecyclerAdapter.ContentChangeStrategy contentChangeStrategy3 = MoPubRecyclerAdapter.ContentChangeStrategy.KEEP_ADS_FIXED;
        contentChangeStrategy = this.f21173a.f20885h;
        if (contentChangeStrategy3 != contentChangeStrategy) {
            MoPubRecyclerAdapter.ContentChangeStrategy contentChangeStrategy4 = MoPubRecyclerAdapter.ContentChangeStrategy.INSERT_AT_END;
            contentChangeStrategy2 = this.f21173a.f20885h;
            if (contentChangeStrategy4 != contentChangeStrategy2 || !z) {
                moPubStreamAdPlacer3 = this.f21173a.f20881d;
                int adjustedCount = moPubStreamAdPlacer3.getAdjustedCount(itemCount + i2);
                for (int i3 = 0; i3 < i2; i3++) {
                    moPubStreamAdPlacer5 = this.f21173a.f20881d;
                    moPubStreamAdPlacer5.removeItem(i);
                }
                moPubStreamAdPlacer4 = this.f21173a.f20881d;
                int adjustedCount2 = adjustedCount - moPubStreamAdPlacer4.getAdjustedCount(itemCount);
                this.f21173a.notifyItemRangeRemoved(adjustedPosition - (adjustedCount2 - i2), adjustedCount2);
                return;
            }
        }
        this.f21173a.notifyDataSetChanged();
    }

    @Override // android.support.p023v7.widget.RecyclerView.AbstractC0459c
    public final void onItemRangeMoved(int i, int i2, int i3) {
        this.f21173a.notifyDataSetChanged();
    }
}
