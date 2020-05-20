package message.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class MessageObj implements Parcelable {
    public static final Parcelable.Creator<MessageObj> CREATOR = new C4751d();

    /* renamed from: a */
    public String f24084a;

    /* renamed from: b */
    public String f24085b;

    /* renamed from: c */
    public String f24086c;

    /* renamed from: d */
    public String f24087d;

    /* renamed from: e */
    public String f24088e;

    /* renamed from: f */
    public int f24089f;

    /* renamed from: g */
    private String f24090g;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ MessageObj(Parcel parcel, byte b) {
        this(parcel);
    }

    public MessageObj() {
    }

    private MessageObj(Parcel parcel) {
        this.f24089f = parcel.readInt();
        this.f24088e = parcel.readString();
        this.f24084a = parcel.readString();
        this.f24090g = parcel.readString();
        this.f24085b = parcel.readString();
        this.f24086c = parcel.readString();
        this.f24087d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f24089f);
        parcel.writeString(this.f24088e);
        parcel.writeString(this.f24084a);
        parcel.writeString(this.f24090g);
        parcel.writeString(this.f24085b);
        parcel.writeString(this.f24086c);
        parcel.writeString(this.f24087d);
    }
}
