package message.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ChatMessage.java */
/* renamed from: message.model.a */
/* loaded from: classes2.dex */
final class C4749a implements Parcelable.Creator<ChatMessage> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ChatMessage[] newArray(int i) {
        return new ChatMessage[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ChatMessage createFromParcel(Parcel parcel) {
        return new ChatMessage(parcel, (byte) 0);
    }
}
