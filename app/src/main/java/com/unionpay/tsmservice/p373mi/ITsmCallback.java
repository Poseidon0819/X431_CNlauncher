package com.unionpay.tsmservice.p373mi;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.unionpay.tsmservice.mi.ITsmCallback */
/* loaded from: classes2.dex */
public interface ITsmCallback extends IInterface {

    /* renamed from: com.unionpay.tsmservice.mi.ITsmCallback$Stub */
    /* loaded from: classes2.dex */
    public abstract class Stub extends Binder implements ITsmCallback {

        /* renamed from: com.unionpay.tsmservice.mi.ITsmCallback$Stub$a */
        /* loaded from: classes2.dex */
        final class C4517a implements ITsmCallback {

            /* renamed from: a */
            private IBinder f23602a;

            C4517a(IBinder iBinder) {
                this.f23602a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f23602a;
            }

            @Override // com.unionpay.tsmservice.p373mi.ITsmCallback
            public final void onError(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmCallback");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f23602a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.p373mi.ITsmCallback
            public final void onResult(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f23602a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.mi.ITsmCallback");
        }

        public static ITsmCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.mi.ITsmCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITsmCallback)) ? new C4517a(iBinder) : (ITsmCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.unionpay.tsmservice.mi.ITsmCallback");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmCallback");
                    onResult(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmCallback");
                    onError(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onError(String str, String str2);

    void onResult(Bundle bundle);
}
