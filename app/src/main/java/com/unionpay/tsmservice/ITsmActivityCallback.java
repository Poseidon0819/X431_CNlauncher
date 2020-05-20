package com.unionpay.tsmservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface ITsmActivityCallback extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements ITsmActivityCallback {

        /* renamed from: com.unionpay.tsmservice.ITsmActivityCallback$Stub$a */
        /* loaded from: classes2.dex */
        static class C4495a implements ITsmActivityCallback {

            /* renamed from: a */
            private IBinder f23523a;

            C4495a(IBinder iBinder) {
                this.f23523a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f23523a;
            }

            @Override // com.unionpay.tsmservice.ITsmActivityCallback
            public final void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmActivityCallback");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f23523a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.ITsmActivityCallback");
        }

        public static ITsmActivityCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.ITsmActivityCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITsmActivityCallback)) ? new C4495a(iBinder) : (ITsmActivityCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.unionpay.tsmservice.ITsmActivityCallback");
                return true;
            }
            parcel.enforceInterface("com.unionpay.tsmservice.ITsmActivityCallback");
            startActivity(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException;
}
