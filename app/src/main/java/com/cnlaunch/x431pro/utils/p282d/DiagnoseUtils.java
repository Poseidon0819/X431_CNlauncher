package com.cnlaunch.x431pro.utils.p282d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.diagnosemodule.utils.CopyFile;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.JsonUtils;
import com.cnlaunch.diagnosemodule.utils.MessagerInfo;
import com.cnlaunch.p118c.p119a.MyTools;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p169im.IMActivity;
import com.cnlaunch.p169im.p180j.SendMessageTask;
import com.cnlaunch.p181j.ExplainResult;
import com.cnlaunch.p188n.RemoteSocketControler;
import com.cnlaunch.p188n.p191c.DiagCarInfo;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.module.cloud.model.CloudData;
import com.cnlaunch.x431pro.module.cloud.model.CloudDataManager;
import com.cnlaunch.x431pro.module.cloud.p248b.WebRemoteHandler;
import com.cnlaunch.x431pro.module.p252d.p254b.CarVersionInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagnoseRunningInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.RemoteDiagRunningInfo;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import message.model.ChatMessage;
import message.model.ChatRoom;
import message.p378a.MessageParameters;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.utils.d.d */
/* loaded from: classes.dex */
public final class DiagnoseUtils {

    /* renamed from: h */
    private static DiagnoseUtils f15754h;

    /* renamed from: b */
    public PreferencesManager f15756b;

    /* renamed from: c */
    public DiagCarInfo f15757c;

    /* renamed from: f */
    public Context f15760f;

    /* renamed from: g */
    private String f15761g = "XEE";

    /* renamed from: a */
    public DiagnoseActivity f15755a = null;

    /* renamed from: d */
    public boolean f15758d = false;

    /* renamed from: e */
    public ArrayList<CloudData> f15759e = new ArrayList<>();

    /* renamed from: i */
    private ArrayList<CarVersionInfo> f15762i = new ArrayList<>();

    /* renamed from: j */
    private boolean f15763j = false;

    /* renamed from: k */
    private boolean f15764k = true;

    /* renamed from: l */
    private String f15765l = "";

    /* renamed from: a */
    public static DiagnoseUtils m5086a() {
        if (f15754h == null) {
            f15754h = new DiagnoseUtils();
        }
        return f15754h;
    }

    /* renamed from: b */
    public final boolean m5082b() {
        return m5075g() != null && m5075g().getDiagnoseStatue() == 1;
    }

    /* renamed from: a */
    public final void m5083a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("remote_message", str);
        Message obtain = Message.obtain((Handler) null, (int) MessagerInfo.REMOTE_CMD_MESSAGE);
        obtain.replyTo = this.f15755a.f11026P;
        obtain.setData(bundle);
        this.f15755a.m7692a(obtain);
    }

    /* renamed from: a */
    public final synchronized void m5085a(Context context) {
        if (this.f15757c != null && !this.f15757c.isUpdata() && !"DEMO".equalsIgnoreCase(this.f15757c.getPackageId())) {
            this.f15757c.setDiag_end_time(System.currentTimeMillis() / 1000);
            String report_type = this.f15757c.getReport_type();
            this.f15757c.setReport_type("CCC");
            if (!MyTools.m9636a(this.f15757c.getVin())) {
                this.f15757c.setUpdata(true);
                if (MainActivity.m7907a()) {
                    if (!MyTools.m9636a(this.f15757c.getMileage())) {
                        this.f15757c.setUpdata(true);
                    } else {
                        this.f15757c.setUpdata(false);
                    }
                } else {
                    this.f15758d = true;
                }
                this.f15759e = CloudDataManager.m5413a(context).m5411a(this.f15757c, (ArrayList<BasicSystemStatusBean>) null);
                C2744aa.m5182a(context, this.f15759e);
            }
            this.f15757c.setReport_type(report_type);
        }
    }

    /* renamed from: c */
    public final void m5079c() {
        NLog.m9452b("XEE", "清空诊断信息 clearDiagInfo");
        DiagnoseConstants.RECORD_MODEL = "";
        DiagnoseConstants.RECORD_YEAR = "";
        DiagnoseConstants.MARKET_CAR_MODEL = "";
        DiagnoseConstants.LICENSEPLATE_PIC_PATH = "";
        DiagnoseConstants.LICENSEPLATE = "";
        DiagnoseConstants.RECORD_DISPLACEMENT = "";
        DiagnoseConstants.RECORD_TRANS = "";
        DiagnoseConstants.VIN_CODE = "";
        DiagnoseConstants.CAR_VENDER = "";
        this.f15758d = false;
        DiagCarInfo diagCarInfo = this.f15757c;
        if (diagCarInfo != null) {
            diagCarInfo.clean();
            this.f15757c = null;
        }
    }

    /* renamed from: d */
    public final void m5078d() {
        DiagnoseConstants.setDiagIdentity(3);
        RemoteSocketControler.m8607a().m8593k();
        WebRemoteHandler.m5419a().m5417b();
        MainActivity.m7882c(false);
        ((MainActivity) this.f15755a.getParent()).m7898a(IMActivity.class, (Intent) null);
    }

    /* renamed from: a */
    public final void m5084a(RemoteDiagRunningInfo remoteDiagRunningInfo) {
        ChatMessage m190a = new ChatRoom(remoteDiagRunningInfo.getOtherUseID(), "", MessageParameters.EnumC4721a.single).m190a(10);
        m190a.m214a("text", (Object) this.f15755a.getString(R.string.canlce_remotediag));
        m190a.m214a("content", (Object) ExplainResult.STOP);
        new SendMessageTask().m256e(m190a);
        this.f15755a.mo7085f(1);
    }

    /* renamed from: e */
    public final DiagCarInfo m5077e() {
        DiagCarInfo diagCarInfo = this.f15757c;
        if (diagCarInfo != null) {
            DiagnoseConstants.MARKET_CAR_MODEL = diagCarInfo.getModel();
            DiagnoseConstants.RECORD_YEAR = this.f15757c.getYear();
            DiagnoseConstants.RECORD_DISPLACEMENT = this.f15757c.getDisplacement();
            DiagnoseConstants.RECORD_TRANS = this.f15757c.getTransmission();
            DiagnoseConstants.VIN_CODE = this.f15757c.getVin();
            DiagnoseConstants.LICENSEPLATE = this.f15757c.getPlate();
        }
        return this.f15757c;
    }

    /* renamed from: f */
    public final void m5076f() {
        this.f15756b.m9588a("car_owner_name", "");
        this.f15756b.m9588a("car_tester", "");
        this.f15756b.m9588a("car_remark", "");
        this.f15756b.m9588a("licensePlateNumberDiagnew", "");
        this.f15756b.m9588a("car_vin", "");
        DiagnoseConstants.FAULTCODE_REFRESH = true;
        DiagnoseConstants.SPECIAFUNCTIONCODE_REFRESH = true;
        DiagnoseConstants.RECORD_DISPLACEMENT = "";
        this.f15756b.m9588a("report_sensing_html", "");
        this.f15756b.m9588a("report_select_image_path", "");
        this.f15756b.m9588a("report_sensing_normal", "");
    }

    /* renamed from: b */
    public final void m5080b(String str) {
        DiagnoseActivity diagnoseActivity = this.f15755a;
        Message obtain = Message.obtain((Handler) null, 104);
        obtain.replyTo = diagnoseActivity.f11026P;
        JSONObject jSONObject = new JSONObject();
        Bundle bundle = new Bundle();
        String specialRemoteOtherJsonUser = JsonUtils.specialRemoteOtherJsonUser(jSONObject, str);
        if (MainActivity.m7895b()) {
            bundle.putString("remote_other_message", specialRemoteOtherJsonUser);
            obtain.setData(bundle);
            diagnoseActivity.m7692a(obtain);
        } else if (MainActivity.m7881d()) {
            RemoteSocketControler.m8607a().m8601a(specialRemoteOtherJsonUser);
        }
    }

    /* renamed from: b */
    public static void m5081b(Context context) {
        String str = null;
        try {
            try {
                str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).dataDir;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            CopyFile.delectFile(str + "/libs/cnlaunch/");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: g */
    public final DiagnoseRunningInfo m5075g() {
        DiagnoseActivity diagnoseActivity = this.f15755a;
        if (diagnoseActivity != null) {
            return diagnoseActivity.mo7083i();
        }
        return null;
    }
}
