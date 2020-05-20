package com.unionpay.tsmservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface OnSafetyKeyboardCallback extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements OnSafetyKeyboardCallback {

        /* renamed from: com.unionpay.tsmservice.OnSafetyKeyboardCallback$Stub$a */
        /* loaded from: classes2.dex */
        static class C4499a implements OnSafetyKeyboardCallback {

            /* renamed from: a */
            private IBinder f23527a;

            C4499a(IBinder iBinder) {
                this.f23527a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f23527a;
            }

            @Override // com.unionpay.tsmservice.OnSafetyKeyboardCallback
            public final void onEditorChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                    obtain.writeInt(i);
                    this.f23527a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.OnSafetyKeyboardCallback
            public final void onHide() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                    this.f23527a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.OnSafetyKeyboardCallback
            public final void onShow() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                    this.f23527a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.OnSafetyKeyboardCallback");
        }

        public static OnSafetyKeyboardCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof OnSafetyKeyboardCallback)) ? new C4499a(iBinder) : (OnSafetyKeyboardCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                    onShow();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                    onHide();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                    onEditorChanged(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onEditorChanged(int i) throws RemoteException;

    void onHide() throws RemoteException;

    void onShow() throws RemoteException;
}
