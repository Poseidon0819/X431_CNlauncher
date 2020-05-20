package message.p383f;

import com.cnlaunch.p167h.C1673a;
import com.itextpdf.text.Annotation;
import com.mopub.common.AdType;
import com.p099c.p100a.p103c.ResponseInfo;
import com.p099c.p100a.p103c.p104a.RequestCallBack;
import message.model.ChatMessage;
import message.p383f.SendTask;
import message.p384g.LogUtilMsg;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SendTask.java */
/* renamed from: message.f.j */
/* loaded from: classes2.dex */
final class C4742j extends RequestCallBack<String> {

    /* renamed from: a */
    final /* synthetic */ C4741i f24020a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4742j(C4741i c4741i) {
        this.f24020a = c4741i;
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo250a(ResponseInfo<String> responseInfo) {
        try {
            JSONObject jSONObject = new JSONObject(responseInfo.f6665a);
            LogUtilMsg.m227a(AdType.STATIC_NATIVE, jSONObject.toString());
            if (jSONObject.has("code")) {
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(DataPacketExtension.ELEMENT_NAME);
                    this.f24020a.f24017d.m214a(Annotation.URL, (Object) jSONObject2.getString(Annotation.URL));
                    if (jSONObject2.has("thumb")) {
                        this.f24020a.f24017d.m214a("thumb", (Object) jSONObject2.getString("thumb"));
                    }
                    if (this.f24020a.f24018e.length > 0) {
                        this.f24020a.f24019f.m259b(this.f24020a.f24017d, (SendTask.InterfaceC4739a) this.f24020a.f24018e[0]);
                        return;
                    } else {
                        this.f24020a.f24019f.m259b(this.f24020a.f24017d, new Object[0]);
                        return;
                    }
                }
                C1673a m8965a = C1673a.m8965a();
                m8965a.m8964a("XMPP Upload Failed:[code=" + i + "]");
                if (this.f24020a.f24018e.length > 0) {
                    ((SendTask.InterfaceC4739a) this.f24020a.f24018e[0]).mo253b();
                }
                this.f24020a.f24017d.f24061f = ChatMessage.EnumC4748b.failed.name();
                this.f24020a.f24019f.mo260b(this.f24020a.f24017d);
                this.f24020a.f24019f.mo257d(this.f24020a.f24017d);
                throw new Exception(jSONObject.getString("msg"));
            }
        } catch (JSONException e) {
            C1673a m8965a2 = C1673a.m8965a();
            m8965a2.m8964a("XMPP Upload JSONException:[" + e.getMessage() + "]");
            if (this.f24020a.f24018e.length > 0) {
                ((SendTask.InterfaceC4739a) this.f24020a.f24018e[0]).mo253b();
            }
            e.printStackTrace();
        } catch (Exception e2) {
            C1673a m8965a3 = C1673a.m8965a();
            m8965a3.m8964a("XMPP Upload Exception:[" + e2.getMessage() + "]");
            if (this.f24020a.f24018e.length > 0) {
                ((SendTask.InterfaceC4739a) this.f24020a.f24018e[0]).mo253b();
            }
            e2.printStackTrace();
        }
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo249a(String str) {
        LogUtilMsg.m227a("onFailure", str);
        C1673a m8965a = C1673a.m8965a();
        m8965a.m8964a("XMPP Upload Failed:[" + str + "]");
        if (this.f24020a.f24018e.length > 0) {
            ((SendTask.InterfaceC4739a) this.f24020a.f24018e[0]).mo253b();
        }
        this.f24020a.f24017d.f24061f = ChatMessage.EnumC4748b.failed.name();
        this.f24020a.f24019f.mo260b(this.f24020a.f24017d);
        this.f24020a.f24019f.mo257d(this.f24020a.f24017d);
    }
}
