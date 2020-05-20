package com.artifex.mupdflib;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

/* loaded from: classes.dex */
public class OutlineActivity extends ListActivity {
    OutlineItem[] mItems;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mItems = OutlineActivityData.get().items;
        setListAdapter(new OutlineAdapter(getLayoutInflater(), this.mItems));
        getListView().setSelection(OutlineActivityData.get().position);
        getListView().setDividerHeight(0);
        setResult(-1);
    }

    @Override // android.app.ListActivity
    protected void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        OutlineActivityData.get().position = getListView().getFirstVisiblePosition();
        setResult(this.mItems[i].page);
        finish();
    }
}
