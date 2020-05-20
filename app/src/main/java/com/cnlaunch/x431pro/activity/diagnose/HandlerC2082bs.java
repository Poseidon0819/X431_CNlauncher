package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p169im.p180j.SendMessageTask;
import com.cnlaunch.x431pro.module.golo.model.MineCarInfoData;
import com.cnlaunch.x431pro.module.p252d.p254b.RemoteDiagRunningInfo;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.module.report.p277b.ReportBackInfo;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;
import message.model.ChatMessage;
import message.model.ChatRoom;
import message.p378a.MessageParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteReportFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bs */
/* loaded from: classes.dex */
public final class HandlerC2082bs extends Handler {

    /* renamed from: a */
    final /* synthetic */ RemoteReportFragment f11586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2082bs(RemoteReportFragment remoteReportFragment) {
        this.f11586a = remoteReportFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        Context context;
        Context context2;
        Button button;
        ReportBackInfo reportBackInfo;
        ReportBackInfo reportBackInfo2;
        if (this.f11586a.isAdded()) {
            switch (message2.what) {
                case 0:
                    MineCarInfoData mineCarInfoData = (MineCarInfoData) message2.obj;
                    ReportProduceTool.m5233a().f15643f = mineCarInfoData.getMine_car_plate_num();
                    textView = this.f11586a.f11574a;
                    textView.setText(mineCarInfoData.getMine_car_plate_num() + this.f11586a.getString(R.string.report_theme_tail));
                    String car_series_name = mineCarInfoData.getCar_series_name();
                    if (!TextUtils.isEmpty(car_series_name)) {
                        textView6 = this.f11586a.f11576j;
                        textView6.setVisibility(0);
                        textView7 = this.f11586a.f11576j;
                        textView7.setText(this.f11586a.getString(R.string.report_car_name) + car_series_name);
                    } else {
                        textView2 = this.f11586a.f11576j;
                        textView2.setVisibility(8);
                    }
                    String car_brand_vin = mineCarInfoData.getCar_brand_vin();
                    if (!TextUtils.isEmpty(car_brand_vin)) {
                        textView4 = this.f11586a.f11577k;
                        textView4.setVisibility(0);
                        textView5 = this.f11586a.f11577k;
                        textView5.setText(this.f11586a.getString(R.string.report_car_vin) + car_brand_vin);
                        return;
                    }
                    textView3 = this.f11586a.f11577k;
                    textView3.setVisibility(8);
                    return;
                case 1:
                    return;
                case 2:
                    context = this.f11586a.mContext;
                    NToast.m9444c(context, (int) R.string.report_send_report_fail);
                    return;
                case 3:
                    context2 = this.f11586a.mContext;
                    NToast.m9444c(context2, (int) R.string.report_send_report_success);
                    button = this.f11586a.f11580n;
                    button.setEnabled(false);
                    try {
                        reportBackInfo = this.f11586a.f11584r;
                        if (reportBackInfo != null) {
                            reportBackInfo2 = this.f11586a.f11584r;
                            String url = reportBackInfo2.getUrl();
                            RemoteDiagRunningInfo mo7081k = this.f11586a.f12357d.mo7081k();
                            ChatMessage m190a = new ChatRoom(mo7081k.getOtherUseID(), mo7081k.getOtherUseName(), MessageParameters.EnumC4721a.single).m190a(1);
                            m190a.m214a("text", (Object) this.f11586a.getString(R.string.report_tip));
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(Annotation.URL, url);
                            jSONObject.put("title_name", this.f11586a.getString(R.string.fragment_title_reprot_remote));
                            m190a.m212a(m190a.f24063h, "check_report", jSONObject);
                            new SendMessageTask().m256e(m190a);
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        Log.e("Sanda", "RemoteReport SendMessage is NullPointerException!");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.f11586a.f12357d.mo7085f(1);
                    return;
                default:
                    super.handleMessage(message2);
                    return;
            }
        }
    }
}
