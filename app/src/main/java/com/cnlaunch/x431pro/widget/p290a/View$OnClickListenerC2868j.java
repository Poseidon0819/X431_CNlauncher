package com.cnlaunch.x431pro.widget.p290a;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.cnlaunch.x431pro.activity.upgrade.p238a.DownloadAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.ifoer.expedition.pro.R;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DivisionSoftDownloadDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.j */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2868j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DivisionSoftDownloadDialog f16454a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2868j(DivisionSoftDownloadDialog divisionSoftDownloadDialog) {
        this.f16454a = divisionSoftDownloadDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        IconButton iconButton;
        IconButton iconButton2;
        IconButton iconButton3;
        IconButton iconButton4;
        IconButton iconButton5;
        ThreadPoolExecutor threadPoolExecutor;
        DownloadAdapter downloadAdapter;
        IconButton iconButton6;
        IconButton iconButton7;
        IconButton iconButton8;
        ThreadPoolExecutor threadPoolExecutor2;
        IconButton iconButton9;
        iconButton = this.f16454a.f16442u;
        String charSequence = iconButton.getText().toString();
        if (!charSequence.equals(this.f16454a.f16441t.getString(R.string.down_stop_txt))) {
            if (charSequence.equals(this.f16454a.f16441t.getString(R.string.down_retry_txt))) {
                this.f16454a.m4537o();
                this.f16454a.m4555d();
                iconButton4 = this.f16454a.f16442u;
                iconButton4.setText(R.string.down_stop_txt);
                Drawable drawable = this.f16454a.f16441t.getResources().getDrawable(R.drawable.select_btn_update_stop);
                drawable.setBounds(0, 0, 50, 50);
                iconButton5 = this.f16454a.f16442u;
                iconButton5.setImage(drawable);
                this.f16454a.m4539n();
                return;
            }
            this.f16454a.m4555d();
            this.f16454a.f16417G = 0;
            iconButton2 = this.f16454a.f16442u;
            iconButton2.setText(R.string.down_stop_txt);
            Drawable drawable2 = this.f16454a.f16441t.getResources().getDrawable(R.drawable.select_btn_update_stop);
            drawable2.setBounds(0, 0, 50, 50);
            iconButton3 = this.f16454a.f16442u;
            iconButton3.setImage(drawable2);
            this.f16454a.m4539n();
            return;
        }
        this.f16454a.f16412B.f7053a = null;
        this.f16454a.f16412B.m9549c();
        threadPoolExecutor = this.f16454a.f16413C;
        threadPoolExecutor.shutdownNow();
        for (DownloadSoftDto downloadSoftDto : this.f16454a.f16414D) {
            if (1 == downloadSoftDto.f15579e.intValue()) {
                downloadSoftDto.f15579e = 0;
            }
        }
        downloadAdapter = this.f16454a.f16447z;
        downloadAdapter.notifyDataSetChanged();
        iconButton6 = this.f16454a.f16442u;
        iconButton6.setText(R.string.down_continue_txt);
        Drawable drawable3 = this.f16454a.f16441t.getResources().getDrawable(R.drawable.select_btn_update_download);
        drawable3.setBounds(0, 0, 50, 50);
        iconButton7 = this.f16454a.f16442u;
        iconButton7.setImage(drawable3);
        iconButton8 = this.f16454a.f16442u;
        iconButton8.setEnabled(false);
        threadPoolExecutor2 = this.f16454a.f16413C;
        if (threadPoolExecutor2.isTerminating()) {
            LoadDialog.m4684a(this.f16454a.f16441t, this.f16454a.f16441t.getString(R.string.txt_stopping));
            new C2869k(this).start();
            return;
        }
        iconButton9 = this.f16454a.f16442u;
        iconButton9.setEnabled(true);
    }
}
