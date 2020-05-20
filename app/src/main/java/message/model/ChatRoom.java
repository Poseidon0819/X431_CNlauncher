package message.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import message.model.ChatMessage;
import message.p378a.MessageParameters;

/* loaded from: classes2.dex */
public class ChatRoom implements Parcelable {
    public static final Parcelable.Creator<ChatRoom> CREATOR = new C4750b();

    /* renamed from: a */
    public String f24076a;

    /* renamed from: b */
    public String f24077b;

    /* renamed from: c */
    public boolean f24078c;

    /* renamed from: d */
    public MessageParameters.EnumC4721a f24079d;

    /* renamed from: e */
    public long f24080e;

    /* renamed from: f */
    public String f24081f;

    /* renamed from: g */
    private String f24082g;

    /* renamed from: h */
    private String f24083h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ChatRoom(Parcel parcel, byte b) {
        this(parcel);
    }

    public ChatRoom(String str, String str2, MessageParameters.EnumC4721a enumC4721a) {
        this.f24076a = str;
        this.f24077b = str2;
        this.f24079d = enumC4721a;
        this.f24082g = ApplicationConfig.m9181a();
    }

    /* renamed from: a */
    public final ChatMessage m190a(int i) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.f24057b = this.f24076a;
        chatMessage.f24058c = this.f24079d.name();
        chatMessage.f24060e = ApplicationConfig.m9181a();
        chatMessage.f24061f = ChatMessage.EnumC4748b.init.name();
        chatMessage.f24059d = ChatMessage.EnumC4747a.read.name();
        chatMessage.f24062g = Long.valueOf(System.currentTimeMillis() + MessageParameters.f23943h);
        chatMessage.m217a(i);
        return chatMessage;
    }

    private ChatRoom(Parcel parcel) {
        this.f24076a = parcel.readString();
        this.f24077b = parcel.readString();
        this.f24079d = MessageParameters.EnumC4721a.valueOf(parcel.readString());
        this.f24082g = ApplicationConfig.m9181a();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f24076a);
        parcel.writeString(this.f24077b);
        parcel.writeString(this.f24079d.name());
    }

    public String toString() {
        return "ChatRoom{id='" + this.f24076a + "', name='" + this.f24077b + "', mUserId='" + this.f24082g + "', isFriend=" + this.f24078c + ", type=" + this.f24079d + ", publicGroupId=" + this.f24080e + ", publicGroupName='" + this.f24081f + "', request_id='" + this.f24083h + "'}";
    }
}
