package com.unionpay.tsmservice.p373mi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.unionpay.tsmservice.mi.ITsmProgressCallback */
/* loaded from: classes2.dex */
public interface ITsmProgressCallback extends IInterface {

    /* renamed from: com.unionpay.tsmservice.mi.ITsmProgressCallback$Stub */
    /* loaded from: classes2.dex */
    public abstract class Stub extends Binder implements ITsmProgressCallback {

        /* renamed from: com.unionpay.tsmservice.mi.ITsmProgressCallback$Stub$a */
        /* loaded from: classes2.dex */
        final class C4518a implements ITsmProgressCallback {

            /* renamed from: a */
            private IBinder f23603a;

            C4518a(IBinder iBinder) {
                this.f23603a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f23603a;
            }

            @Override // com.unionpay.tsmservice.p373mi.ITsmProgressCallback
            public final void onProgress(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmProgressCallback");
                    obtain.writeInt(i);
                    this.f23603a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.mi.ITsmProgressCallback");
        }

        public static ITsmProgressCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.mi.ITsmProgressCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITsmProgressCallback)) ? new C4518a(iBinder) : (ITsmProgressCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.unionpay.tsmservice.mi.ITsmProgressCallback");
                return true;
            }
            parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmProgressCallback");
            onProgress(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onProgress(int i);
}
