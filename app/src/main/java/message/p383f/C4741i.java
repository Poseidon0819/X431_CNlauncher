package message.p383f;

import android.util.Log;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p160b.SearchCallBack;
import com.cnlaunch.golo3.p163e.C1610b;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.p099c.p100a.HttpUtils;
import com.p099c.p100a.p103c.RequestParams;
import com.p099c.p100a.p103c.p105b.HttpRequest;
import java.util.HashMap;
import message.model.ChatMessage;
import message.p383f.SendTask;
import message.p384g.LogUtilMsg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendTask.java */
/* renamed from: message.f.i */
/* loaded from: classes2.dex */
public final class C4741i implements SearchCallBack {

    /* renamed from: a */
    final /* synthetic */ String f24014a;

    /* renamed from: b */
    final /* synthetic */ HttpUtils f24015b;

    /* renamed from: c */
    final /* synthetic */ RequestParams f24016c;

    /* renamed from: d */
    final /* synthetic */ ChatMessage f24017d;

    /* renamed from: e */
    final /* synthetic */ Object[] f24018e;

    /* renamed from: f */
    final /* synthetic */ SendTask f24019f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4741i(SendTask sendTask, String str, HttpUtils httpUtils, RequestParams requestParams, ChatMessage chatMessage, Object[] objArr) {
        this.f24019f = sendTask;
        this.f24014a = str;
        this.f24015b = httpUtils;
        this.f24016c = requestParams;
        this.f24017d = chatMessage;
        this.f24018e = objArr;
    }

    @Override // com.cnlaunch.golo3.p160b.SearchCallBack
    /* renamed from: a */
    public final void mo252a() {
        LogUtilMsg.m227a("searchActionSuccess", "searchActionSuccess");
        HashMap hashMap = new HashMap();
        hashMap.put(VastExtensionXmlManager.TYPE, this.f24014a);
        String str = ApplicationConfig.f7815n ? "http://file.us.api.dbscar.com/?action=file_service.upload" : "http://file.api.dbscar.com/?action=file_service.upload";
        String m9162a = C1610b.m9162a(1, str, hashMap);
        LogUtilMsg.m227a("reqUrl", m9162a);
        Log.i("XEE", "url:" + str + "  上传url:" + m9162a);
        this.f24015b.m9764a(ApplicationConfig.f7802a, HttpRequest.EnumC1391a.POST, m9162a, this.f24016c, new C4742j(this));
    }

    @Override // com.cnlaunch.golo3.p160b.SearchCallBack
    /* renamed from: b */
    public final void mo251b() {
        Object[] objArr = this.f24018e;
        if (objArr.length > 0) {
            ((SendTask.InterfaceC4739a) objArr[0]).mo253b();
        }
        this.f24017d.f24061f = ChatMessage.EnumC4748b.failed.name();
        this.f24019f.mo260b(this.f24017d);
        this.f24019f.mo257d(this.f24017d);
    }
}
