package message.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ChatRoom.java */
/* renamed from: message.model.b */
/* loaded from: classes2.dex */
final class C4750b implements Parcelable.Creator<ChatRoom> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ChatRoom[] newArray(int i) {
        return new ChatRoom[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ChatRoom createFromParcel(Parcel parcel) {
        return new ChatRoom(parcel, (byte) 0);
    }
}
