package message.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: MessageObj.java */
/* renamed from: message.model.d */
/* loaded from: classes2.dex */
final class C4751d implements Parcelable.Creator<MessageObj> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MessageObj[] newArray(int i) {
        return new MessageObj[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MessageObj createFromParcel(Parcel parcel) {
        return new MessageObj(parcel, (byte) 0);
    }
}
