package com.cnlaunch.x431pro.widget.p290a;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.activity.upgrade.View$OnClickListenerC2682e;
import com.cnlaunch.x431pro.activity.upgrade.p238a.DownloadAdapter;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.ifoer.expedition.pro.R;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DivisionSoftDownloadDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.l */
/* loaded from: classes.dex */
public final class HandlerC2870l extends Handler {

    /* renamed from: a */
    final /* synthetic */ DivisionSoftDownloadDialog f16456a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2870l(DivisionSoftDownloadDialog divisionSoftDownloadDialog) {
        this.f16456a = divisionSoftDownloadDialog;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        IconButton iconButton;
        IconButton iconButton2;
        Integer num;
        IconButton iconButton3;
        TextView textView;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        IconButton iconButton4;
        IconButton iconButton5;
        IconButton iconButton6;
        IconButton iconButton7;
        IconButton iconButton8;
        ThreadPoolExecutor threadPoolExecutor;
        IconButton iconButton9;
        IconButton iconButton10;
        DownloadAdapter downloadAdapter;
        IconButton iconButton11;
        IconButton iconButton12;
        IconButton iconButton13;
        IconButton iconButton14;
        ThreadPoolExecutor threadPoolExecutor2;
        IconButton iconButton15;
        IconButton iconButton16;
        IconButton iconButton17;
        IconButton iconButton18;
        IconButton iconButton19;
        IconButton iconButton20;
        int i;
        TextView textView2;
        TextView textView3;
        int i2;
        int i3;
        TextView textView4;
        ThreadPoolExecutor threadPoolExecutor3;
        IconButton iconButton21;
        Dialog dialog;
        switch (message2.what) {
            case 1:
                iconButton = this.f16456a.f16442u;
                iconButton.setText(R.string.down_retry_txt);
                Drawable drawable = this.f16456a.f16441t.getResources().getDrawable(R.drawable.select_btn_update_retry);
                drawable.setBounds(0, 0, 50, 50);
                iconButton2 = this.f16456a.f16442u;
                iconButton2.setImage(drawable);
                num = this.f16456a.f16416F;
                if (num.intValue() >= this.f16456a.f16414D.size()) {
                    iconButton3 = this.f16456a.f16442u;
                    iconButton3.setEnabled(false);
                    return;
                }
                return;
            case 2:
                textView = this.f16456a.f16444w;
                DivisionSoftDownloadDialog divisionSoftDownloadDialog = this.f16456a;
                num2 = divisionSoftDownloadDialog.f16416F;
                textView.setText(divisionSoftDownloadDialog.m4561a(String.valueOf(num2), String.valueOf(this.f16456a.f16414D.size())));
                return;
            case 3:
                this.f16456a.f16412B.f7053a = null;
                this.f16456a.f16412B.m9549c();
                num3 = this.f16456a.f16417G;
                if (num3.intValue() > 0) {
                    num6 = this.f16456a.f16417G;
                    int intValue = num6.intValue();
                    num7 = this.f16456a.f16415E;
                    if (intValue < num7.intValue()) {
                        new DialogC2871m(this, this.f16456a.f16441t).m4670a(R.string.tab_menu_upgrade, R.string.txt_update_failed_partly);
                        return;
                    }
                }
                num4 = this.f16456a.f16417G;
                if (num4.intValue() <= 0) {
                    num5 = this.f16456a.f16416F;
                    if (num5.intValue() >= this.f16456a.f16414D.size()) {
                        DialogC2873o dialogC2873o = new DialogC2873o(this, this.f16456a.f16441t);
                        dialogC2873o.setTitle(R.string.tab_menu_upgrade);
                        dialogC2873o.m4714e(R.string.txt_update_ok);
                        dialogC2873o.setCancelable(true);
                        dialogC2873o.m4719a(R.string.common_confirm, true, new View$OnClickListenerC2682e(dialogC2873o));
                        dialogC2873o.show();
                        return;
                    }
                    return;
                }
                new DialogC2872n(this, this.f16456a.f16441t).m4670a(R.string.tab_menu_upgrade, R.string.txt_update_failed);
                return;
            case 4:
                iconButton4 = this.f16456a.f16442u;
                iconButton4.setText(R.string.down_retry_txt);
                Drawable drawable2 = this.f16456a.f16441t.getResources().getDrawable(R.drawable.select_btn_update_retry);
                drawable2.setBounds(0, 0, 50, 50);
                iconButton5 = this.f16456a.f16442u;
                iconButton5.setImage(drawable2);
                iconButton6 = this.f16456a.f16442u;
                iconButton6.setEnabled(true);
                MessageDialog messageDialog = new MessageDialog(this.f16456a.f16441t, (int) R.string.login_conflict_dialog_title, (int) R.string.login_conflict_dialog_content);
                messageDialog.m4720a(R.string.btn_confirm, new View$OnClickListenerC2874p(this));
                messageDialog.m4717b(R.string.btn_canlce, true, null);
                messageDialog.m4713f(2);
                messageDialog.show();
                return;
            case 5:
                new C2875q(this, this.f16456a.f16441t).m6572d();
                return;
            case 6:
                this.f16456a.m4555d();
                this.f16456a.f16417G = 0;
                iconButton7 = this.f16456a.f16442u;
                iconButton7.setText(R.string.down_stop_txt);
                Drawable drawable3 = this.f16456a.f16441t.getResources().getDrawable(R.drawable.select_btn_update_stop);
                drawable3.setBounds(0, 0, 50, 50);
                iconButton8 = this.f16456a.f16442u;
                iconButton8.setImage(drawable3);
                this.f16456a.m4539n();
                return;
            case 7:
                this.f16456a.f16412B.f7053a = null;
                this.f16456a.f16412B.m9549c();
                threadPoolExecutor = this.f16456a.f16413C;
                threadPoolExecutor.shutdownNow();
                iconButton9 = this.f16456a.f16442u;
                iconButton9.setText(R.string.down_continue_txt);
                Drawable drawable4 = this.f16456a.f16441t.getResources().getDrawable(R.drawable.select_btn_update_download);
                drawable4.setBounds(0, 0, 50, 50);
                iconButton10 = this.f16456a.f16442u;
                iconButton10.setImage(drawable4);
                return;
            case 8:
                new DialogC2876r(this, this.f16456a.f16441t).m4670a(R.string.tab_menu_upgrade, R.string.txt_error_conflict_signature);
                return;
            case 9:
                downloadAdapter = this.f16456a.f16447z;
                downloadAdapter.notifyDataSetChanged();
                return;
            case 10:
                iconButton11 = this.f16456a.f16442u;
                iconButton11.setEnabled(message2.arg1 != 0);
                return;
            case 11:
                DialogC2877s dialogC2877s = new DialogC2877s(this, this.f16456a.f16441t);
                dialogC2877s.setTitle(R.string.tab_menu_upgrade);
                dialogC2877s.m4714e(R.string.txt_less_storage_space);
                dialogC2877s.setCancelable(true);
                dialogC2877s.m4719a(R.string.common_confirm, true, null);
                dialogC2877s.m4713f(2);
                dialogC2877s.show();
                iconButton12 = this.f16456a.f16442u;
                iconButton12.setText(R.string.down_retry_txt);
                Drawable drawable5 = this.f16456a.f16441t.getResources().getDrawable(R.drawable.select_btn_update_retry);
                drawable5.setBounds(0, 0, 50, 50);
                iconButton13 = this.f16456a.f16442u;
                iconButton13.setImage(drawable5);
                iconButton14 = this.f16456a.f16442u;
                iconButton14.setEnabled(true);
                return;
            case 12:
                this.f16456a.f16412B.f7053a = null;
                this.f16456a.f16412B.m9549c();
                threadPoolExecutor2 = this.f16456a.f16413C;
                threadPoolExecutor2.shutdownNow();
                DivisionSoftDownloadDialog.m4533q(this.f16456a);
                new MessageDialog(this.f16456a.f16441t).m4670a(R.string.tab_menu_upgrade, R.string.common_network_error);
                iconButton15 = this.f16456a.f16442u;
                iconButton15.setText(R.string.down_retry_txt);
                Drawable drawable6 = this.f16456a.f16441t.getResources().getDrawable(R.drawable.select_btn_update_retry);
                drawable6.setBounds(0, 0, 50, 50);
                iconButton16 = this.f16456a.f16442u;
                iconButton16.setImage(drawable6);
                iconButton17 = this.f16456a.f16442u;
                iconButton17.setEnabled(true);
                return;
            case 13:
                DivisionSoftDownloadDialog.m4533q(this.f16456a);
                iconButton18 = this.f16456a.f16442u;
                iconButton18.setText(R.string.down_retry_txt);
                Drawable drawable7 = this.f16456a.f16441t.getResources().getDrawable(R.drawable.select_btn_update_retry);
                drawable7.setBounds(0, 0, 50, 50);
                iconButton19 = this.f16456a.f16442u;
                iconButton19.setImage(drawable7);
                iconButton20 = this.f16456a.f16442u;
                iconButton20.setEnabled(true);
                return;
            case 14:
                this.f16456a.f16422L = message2.arg1;
                i = this.f16456a.f16422L;
                if (i < 20) {
                    i3 = this.f16456a.f16422L;
                    if (i3 > 0) {
                        textView4 = this.f16456a.f16446y;
                        textView4.setTextColor(-65536);
                        textView3 = this.f16456a.f16446y;
                        StringBuilder sb = new StringBuilder();
                        i2 = this.f16456a.f16422L;
                        sb.append(i2);
                        sb.append("KB/S");
                        textView3.setText(sb.toString());
                        return;
                    }
                }
                textView2 = this.f16456a.f16446y;
                textView2.setTextColor(-16777216);
                textView3 = this.f16456a.f16446y;
                StringBuilder sb2 = new StringBuilder();
                i2 = this.f16456a.f16422L;
                sb2.append(i2);
                sb2.append("KB/S");
                textView3.setText(sb2.toString());
                return;
            case 15:
                this.f16456a.f16412B.f7053a = null;
                this.f16456a.f16412B.m9549c();
                threadPoolExecutor3 = this.f16456a.f16413C;
                threadPoolExecutor3.shutdownNow();
                iconButton21 = this.f16456a.f16442u;
                iconButton21.setText(R.string.down_continue_txt);
                ((DiagnoseActivity) this.f16456a.f16441t).mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 1});
                dialog = this.f16456a.f16423M;
                dialog.dismiss();
                MessageDialog messageDialog2 = new MessageDialog(this.f16456a.f16441t);
                ((DiagnoseActivity) this.f16456a.f16441t).f11025O = messageDialog2;
                messageDialog2.m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2878t(this));
                messageDialog2.m4668a(this.f16456a.f16441t.getString(R.string.dialog_title_default), this.f16456a.f16441t.getString(message2.arg1), this.f16456a.f16441t.getString(R.string.onlineprograming_tip_go_buy), new View$OnClickListenerC2879u(this));
                return;
            default:
                return;
        }
    }
}
