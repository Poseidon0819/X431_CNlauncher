package com.cnlaunch.p181j;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.p210a.RemoteDiagObserve;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.f */
/* loaded from: classes.dex */
public final class C1769f extends ResultQueue {

    /* renamed from: a */
    final /* synthetic */ DealDiagMessageHandler f9442a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1769f(DealDiagMessageHandler dealDiagMessageHandler) {
        this.f9442a = dealDiagMessageHandler;
    }

    @Override // com.cnlaunch.p181j.ResultQueue
    /* renamed from: a */
    final boolean mo8652a(ExplainResult explainResult) {
        Log.d("Sanda", "dealResult=" + explainResult.toString());
        LoadDialog.m4681b(this.f9442a.f9429e);
        this.f9442a.f9434j.removeMessages(11);
        this.f9442a.f9434j.removeMessages(13);
        if (explainResult.cmd.equalsIgnoreCase(ExplainResult.ASKFOR)) {
            Log.i("Sanda", "dealResult ExplainResult.ASKFOR=" + explainResult.ver);
            if (!MainActivity.m7907a()) {
                this.f9442a.f9429e.sendBroadcast(new Intent("ACTION_CLOSE_SOFT"));
                if (!m8683b()) {
                    this.f9421e.f9478id = explainResult.f9478id;
                    this.f9421e.cmd = "invite";
                    if (this.f9418b.contains(this.f9421e)) {
                        this.f9420d = explainResult.ver;
                        this.f9442a.m8672a(1, explainResult);
                        this.f9442a.f9434j.obtainMessage(12, explainResult).sendToTarget();
                        return true;
                    }
                }
                m8684a(explainResult.f9478id);
                this.f9420d = explainResult.ver;
                this.f9442a.f9434j.obtainMessage(7, explainResult).sendToTarget();
                return true;
            }
            mo8653a(3, explainResult);
            return false;
        } else if (explainResult.cmd.equalsIgnoreCase("invite")) {
            if (!MainActivity.m7907a()) {
                this.f9442a.f9429e.sendBroadcast(new Intent("ACTION_CLOSE_SOFT"));
                m8684a(explainResult.f9478id);
                this.f9420d = explainResult.ver;
                this.f9442a.f9434j.obtainMessage(10, explainResult).sendToTarget();
                return true;
            }
            mo8653a(3, explainResult);
            return false;
        } else {
            if (!m8683b()) {
                if (explainResult.cmd.equalsIgnoreCase(ExplainResult.START)) {
                    this.f9442a.f9434j.obtainMessage(12).sendToTarget();
                    if (explainResult.ver < 2) {
                        mo8653a(1, explainResult);
                        m8681c();
                        return false;
                    }
                    this.f9442a.m8672a(0, explainResult);
                    return true;
                } else if (explainResult.cmd.equalsIgnoreCase(ExplainResult.ACCEPT)) {
                    this.f9442a.f9434j.obtainMessage(12).sendToTarget();
                    if (explainResult.ver >= 2) {
                        this.f9442a.f9434j.obtainMessage(14, explainResult).sendToTarget();
                        return true;
                    }
                    mo8653a(1, explainResult);
                    m8681c();
                    return false;
                } else if (explainResult.cmd.equalsIgnoreCase(ExplainResult.REFUSE)) {
                    m8681c();
                    this.f9442a.f9434j.obtainMessage(3, explainResult.f24482message.m211b()).sendToTarget();
                    return false;
                } else if (explainResult.cmd.equalsIgnoreCase("fail")) {
                    m8681c();
                    this.f9442a.f9434j.obtainMessage(1).sendToTarget();
                    return false;
                } else if (explainResult.cmd.equalsIgnoreCase(ExplainResult.STOP)) {
                    this.f9442a.f9434j.obtainMessage(12).sendToTarget();
                    if (!MainActivity.m7895b()) {
                        this.f9442a.f9429e.sendBroadcast(new Intent("ACTION_CLOSE_SOFT"));
                        m8681c();
                    } else if (this.f9442a.f9428d != null) {
                        this.f9442a.f9428d.mo7468a();
                    }
                    return false;
                }
            }
            mo8653a(4, explainResult);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.cnlaunch.p181j.ResultQueue
    /* renamed from: a */
    public final void mo8653a(int i, ExplainResult explainResult) {
        switch (i) {
            case 1:
                Log.d("Sanda", "本地正在运行 拒绝对方并且提示");
                this.f9442a.f9434j.obtainMessage(12).sendToTarget();
                RemoteDiagObserve.m7939a(4);
                this.f9442a.m8669a(explainResult.f9478id, R.string.you_need_update, explainResult.toJsonString(ExplainResult.STOP));
                return;
            case 2:
                if (explainResult.cmd.equalsIgnoreCase("invite") || explainResult.cmd.equalsIgnoreCase(ExplainResult.ASKFOR)) {
                    this.f9442a.m8667a(explainResult.f9478id, this.f9442a.f9429e.getString(R.string.remotediag_with_other, this.f9442a.m8659e()), explainResult.toJsonString(ExplainResult.REFUSE));
                    NToast.longToast(this.f9442a.f9429e, this.f9442a.f9429e.getString(R.string.recive_remotediag_invite, this.f9442a.m8670a(explainResult.f9478id)));
                }
                Log.d("Sanda", "远程正在运行 拒绝对方并且提示(仅响应邀请和请求，其他的都不响应)");
                return;
            case 3:
                Log.d("Sanda", "本地正在运行 拒绝对方并且提示");
                this.f9442a.m8667a(explainResult.f9478id, this.f9442a.f9429e.getString(R.string.diag_in_bussnise, this.f9442a.m8659e()), explainResult.toJsonString(ExplainResult.REFUSE));
                Context context = this.f9442a.f9429e;
                NToast.longToast(context, this.f9442a.f9429e.getString(R.string.recive_remotediag_invite, this.f9442a.m8670a(explainResult.f9478id)) + "(" + this.f9442a.f9429e.getString(R.string.tip_must_stop_diag_before) + ")");
                return;
            default:
                return;
        }
    }
}
