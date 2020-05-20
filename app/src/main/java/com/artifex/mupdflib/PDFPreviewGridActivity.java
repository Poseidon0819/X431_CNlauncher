package com.artifex.mupdflib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class PDFPreviewGridActivity extends Activity {
    private PDFPreviewGridAdapter mAdapter;
    private MuPDFCore mCore;
    private GridView mGrid;
    private int mPosition;

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION);
            getWindow().setStatusBarColor(getResources().getColor(C0835R.color.actionbar_background_dark));
            getWindow().setNavigationBarColor(getResources().getColor(C0835R.color.actionbar_background_dark));
        }
        LibraryUtils.reloadLocale(getApplicationContext());
        this.mCore = PDFPreviewGridActivityData.get().core;
        this.mPosition = PDFPreviewGridActivityData.get().position;
        setContentView(C0835R.layout.preview_grid_fragment);
        this.mGrid = (GridView) findViewById(C0835R.C0836id.preview_grid);
        this.mAdapter = new PDFPreviewGridAdapter(this, this.mCore, this.mPosition);
        this.mGrid.setAdapter((ListAdapter) this.mAdapter);
        this.mGrid.smoothScrollToPosition(this.mPosition);
    }

    public void OnCancelPreviewButtonClick(View view) {
        setResult(this.mPosition);
        finish();
    }
}
