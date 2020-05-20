package message.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.html.HtmlTags;
import com.mopub.mobileads.VastExtensionXmlManager;
import message.p378a.MessageParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ChatMessage implements Parcelable, Cloneable {
    public static final Parcelable.Creator<ChatMessage> CREATOR = new C4749a();

    /* renamed from: a */
    public Long f24056a;

    /* renamed from: b */
    public String f24057b;

    /* renamed from: c */
    public String f24058c;

    /* renamed from: d */
    public String f24059d;

    /* renamed from: e */
    public String f24060e;

    /* renamed from: f */
    public String f24061f;

    /* renamed from: g */
    public Long f24062g;

    /* renamed from: h */
    public String f24063h;

    /* renamed from: i */
    public String f24064i;

    /* renamed from: j */
    public String f24065j;

    /* renamed from: k */
    public Integer f24066k;

    /* renamed from: l */
    public String f24067l;

    /* renamed from: m */
    public boolean f24068m;

    /* renamed from: n */
    private String f24069n;

    /* renamed from: o */
    private int f24070o;

    /* renamed from: p */
    private boolean f24071p;

    /* renamed from: q */
    private long f24072q;

    /* renamed from: r */
    private String f24073r;

    /* renamed from: message.model.ChatMessage$a */
    /* loaded from: classes2.dex */
    public enum EnumC4747a {
        read,
        unread
    }

    /* renamed from: message.model.ChatMessage$b */
    /* loaded from: classes2.dex */
    public enum EnumC4748b {
        init,
        done,
        failed
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ChatMessage(Parcel parcel, byte b) {
        this(parcel);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String toString() {
        return "ChatMessage{id=" + this.f24056a + ", roomId='" + this.f24057b + "', roomType='" + this.f24058c + "', flag='" + this.f24059d + "', speakerId='" + this.f24060e + "', status='" + this.f24061f + "', time=" + this.f24062g + ", content='" + this.f24063h + "', expansion='" + this.f24064i + "', groupFlag='" + this.f24065j + "', subType=" + this.f24066k + ", messageId='" + this.f24067l + "', itemId='" + this.f24069n + "', playing=" + this.f24068m + ", showMenu=" + this.f24071p + ", publicGroupId=" + this.f24072q + ", publicGroupName='" + this.f24073r + "', isCustomer='" + this.f24070o + "'}";
    }

    public ChatMessage() {
        this.f24063h = "{}";
        this.f24064i = "{}";
        this.f24065j = "";
        this.f24068m = false;
        this.f24071p = false;
    }

    public ChatMessage(String str, String str2) {
        this.f24063h = "{}";
        this.f24064i = "{}";
        this.f24065j = "";
        this.f24068m = false;
        this.f24071p = false;
        this.f24058c = MessageParameters.EnumC4721a.single.name();
        this.f24060e = str2;
        this.f24057b = str2;
        this.f24061f = EnumC4748b.init.name();
        this.f24059d = EnumC4747a.read.name();
        this.f24062g = Long.valueOf(System.currentTimeMillis() + MessageParameters.f23943h);
        m214a(VastExtensionXmlManager.TYPE, (Object) 8);
        m214a("text", (Object) str);
    }

    /* renamed from: a */
    public final int m218a() {
        return m208b(this.f24063h, VastExtensionXmlManager.TYPE);
    }

    /* renamed from: a */
    public final void m217a(int i) {
        m214a(VastExtensionXmlManager.TYPE, Integer.valueOf(i));
    }

    /* renamed from: b */
    public final String m211b() {
        return m213a(this.f24063h, "text");
    }

    /* renamed from: c */
    public final String m207c() {
        return m213a(this.f24063h, Annotation.URL);
    }

    /* renamed from: d */
    public final String m204d() {
        return m213a(this.f24063h, "thumb");
    }

    /* renamed from: e */
    public final String m203e() {
        return m213a(this.f24063h, "name");
    }

    /* renamed from: f */
    public final String m202f() {
        return m213a(this.f24063h, "nickname");
    }

    /* renamed from: g */
    public final String m201g() {
        return m213a(this.f24063h, "latitude");
    }

    /* renamed from: h */
    public final String m200h() {
        return m213a(this.f24063h, "longitude");
    }

    /* renamed from: a */
    public final void m214a(String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject(this.f24063h);
            jSONObject.put(str, obj);
            this.f24063h = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void m209b(String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject(this.f24064i);
            jSONObject.put(str, obj);
            this.f24064i = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: i */
    public final int m199i() {
        String m213a = m213a(this.f24063h, "subtype");
        if (m213a == null || "".equals(m213a)) {
            return -1;
        }
        return m208b(this.f24063h, "subtype");
    }

    /* renamed from: b */
    public final void m210b(int i) {
        m214a("subtype", Integer.valueOf(i));
    }

    /* renamed from: a */
    public final void m216a(long j) {
        m214a(HtmlTags.SIZE, (Object) String.valueOf(j));
    }

    /* renamed from: j */
    public final String m198j() {
        return m213a(this.f24063h, HtmlTags.SIZE);
    }

    /* renamed from: c */
    public final void m206c(int i) {
        m214a("time", (Object) String.valueOf(i));
    }

    /* renamed from: k */
    public final String m197k() {
        return m213a(this.f24064i, "path");
    }

    /* renamed from: l */
    public final String m196l() {
        return m213a(this.f24064i, "thumbPath");
    }

    /* renamed from: m */
    public final String m195m() {
        return m213a(this.f24063h, "serial_no");
    }

    /* renamed from: n */
    public final boolean m194n() {
        return m205c(this.f24064i, "hasPlayed");
    }

    /* renamed from: o */
    public final void m193o() {
        m209b("hasPlayed", Boolean.TRUE);
    }

    /* renamed from: a */
    public static String m213a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str2)) {
                return jSONObject.getString(str2);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: p */
    public final JSONObject m192p() {
        try {
            return new JSONObject(this.f24063h);
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    /* renamed from: b */
    private static int m208b(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str2)) {
                return jSONObject.getInt(str2);
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: c */
    private static boolean m205c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str2)) {
                return jSONObject.getBoolean(str2);
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final void m212a(String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put(str2, obj);
            this.f24063h = jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ChatMessage(Parcel parcel) {
        this.f24063h = "{}";
        this.f24064i = "{}";
        this.f24065j = "";
        this.f24068m = false;
        this.f24071p = false;
        this.f24057b = parcel.readString();
        this.f24058c = parcel.readString();
        this.f24059d = parcel.readString();
        this.f24060e = parcel.readString();
        this.f24061f = parcel.readString();
        this.f24062g = Long.valueOf(parcel.readLong());
        this.f24063h = parcel.readString();
        this.f24064i = parcel.readString();
        this.f24070o = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f24057b);
        parcel.writeString(this.f24058c);
        parcel.writeString(this.f24059d);
        parcel.writeString(this.f24060e);
        parcel.writeString(this.f24061f);
        parcel.writeLong(this.f24062g.longValue());
        parcel.writeString(this.f24063h);
        parcel.writeString(this.f24064i);
        parcel.writeInt(this.f24070o);
    }

    /* renamed from: q */
    public final String m191q() {
        return m213a(this.f24063h, "content");
    }

    /* renamed from: a */
    public final void m215a(String str) {
        m212a(this.f24063h, "SNkey", str);
    }
}
