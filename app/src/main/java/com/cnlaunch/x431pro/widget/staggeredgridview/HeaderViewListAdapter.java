package com.cnlaunch.x431pro.widget.staggeredgridview;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.d */
/* loaded from: classes.dex */
public final class HeaderViewListAdapter implements Filterable, WrapperListAdapter {

    /* renamed from: c */
    static final ArrayList<ExtendableListView.C2965d> f16911c = new ArrayList<>();

    /* renamed from: a */
    ArrayList<ExtendableListView.C2965d> f16912a;

    /* renamed from: b */
    ArrayList<ExtendableListView.C2965d> f16913b;

    /* renamed from: d */
    boolean f16914d;

    /* renamed from: e */
    private final ListAdapter f16915e;

    /* renamed from: f */
    private final boolean f16916f;

    public HeaderViewListAdapter(ArrayList<ExtendableListView.C2965d> arrayList, ArrayList<ExtendableListView.C2965d> arrayList2, ListAdapter listAdapter) {
        this.f16915e = listAdapter;
        this.f16916f = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f16912a = f16911c;
        } else {
            this.f16912a = arrayList;
        }
        if (arrayList2 == null) {
            this.f16913b = f16911c;
        } else {
            this.f16913b = arrayList2;
        }
        this.f16914d = m4290a(this.f16912a) && m4290a(this.f16913b);
    }

    @Override // android.widget.Adapter
    public final boolean isEmpty() {
        ListAdapter listAdapter = this.f16915e;
        return listAdapter == null || listAdapter.isEmpty();
    }

    /* renamed from: a */
    private static boolean m4290a(ArrayList<ExtendableListView.C2965d> arrayList) {
        if (arrayList != null) {
            Iterator<ExtendableListView.C2965d> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f16866c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.f16915e != null) {
            return this.f16913b.size() + this.f16912a.size() + this.f16915e.getCount();
        }
        return this.f16913b.size() + this.f16912a.size();
    }

    @Override // android.widget.ListAdapter
    public final boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f16915e;
        if (listAdapter != null) {
            return this.f16914d && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    @Override // android.widget.Adapter
    public final boolean hasStableIds() {
        ListAdapter listAdapter = this.f16915e;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public final int getViewTypeCount() {
        ListAdapter listAdapter = this.f16915e;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f16915e;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f16915e;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f16916f) {
            return ((Filterable) this.f16915e).getFilter();
        }
        return null;
    }

    @Override // android.widget.WrapperListAdapter
    public final ListAdapter getWrappedAdapter() {
        return this.f16915e;
    }

    @Override // android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        int size = this.f16912a.size();
        if (i < size) {
            return this.f16912a.get(i).f16866c;
        }
        int i2 = i - size;
        int i3 = 0;
        ListAdapter listAdapter = this.f16915e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f16915e.isEnabled(i2);
        }
        return this.f16913b.get(i2 - i3).f16866c;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int size = this.f16912a.size();
        if (i < size) {
            return this.f16912a.get(i).f16865b;
        }
        int i2 = i - size;
        int i3 = 0;
        ListAdapter listAdapter = this.f16915e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f16915e.getItem(i2);
        }
        return this.f16913b.get(i2 - i3).f16865b;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        int i2;
        int size = this.f16912a.size();
        ListAdapter listAdapter = this.f16915e;
        if (listAdapter == null || i < size || (i2 = i - size) >= listAdapter.getCount()) {
            return -1L;
        }
        return this.f16915e.getItemId(i2);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        int size = this.f16912a.size();
        if (i < size) {
            return this.f16912a.get(i).f16864a;
        }
        int i2 = i - size;
        int i3 = 0;
        ListAdapter listAdapter = this.f16915e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f16915e.getView(i2, view, viewGroup);
        }
        return this.f16913b.get(i2 - i3).f16864a;
    }

    @Override // android.widget.Adapter
    public final int getItemViewType(int i) {
        int i2;
        int size = this.f16912a.size();
        ListAdapter listAdapter = this.f16915e;
        if (listAdapter == null || i < size || (i2 = i - size) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f16915e.getItemViewType(i2);
    }
}
