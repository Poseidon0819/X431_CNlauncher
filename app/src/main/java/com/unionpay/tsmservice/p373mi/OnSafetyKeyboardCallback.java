package com.unionpay.tsmservice.p373mi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback */
/* loaded from: classes2.dex */
public interface OnSafetyKeyboardCallback extends IInterface {

    /* renamed from: com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback$Stub */
    /* loaded from: classes2.dex */
    public abstract class Stub extends Binder implements OnSafetyKeyboardCallback {

        /* renamed from: com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback$Stub$a */
        /* loaded from: classes2.dex */
        final class C4520a implements OnSafetyKeyboardCallback {

            /* renamed from: a */
            private IBinder f23605a;

            C4520a(IBinder iBinder) {
                this.f23605a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f23605a;
            }

            @Override // com.unionpay.tsmservice.p373mi.OnSafetyKeyboardCallback
            public final void onConfirmClicked() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    this.f23605a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.p373mi.OnSafetyKeyboardCallback
            public final void onEditorChanged(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    obtain.writeInt(i);
                    this.f23605a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.p373mi.OnSafetyKeyboardCallback
            public final void onHide() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    this.f23605a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.p373mi.OnSafetyKeyboardCallback
            public final void onOutsideTouch(float f, float f2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    this.f23605a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.p373mi.OnSafetyKeyboardCallback
            public final void onShow() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    this.f23605a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
        }

        public static OnSafetyKeyboardCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof OnSafetyKeyboardCallback)) ? new C4520a(iBinder) : (OnSafetyKeyboardCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    onShow();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    onHide();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    onEditorChanged(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    onOutsideTouch(parcel.readFloat(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    onConfirmClicked();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onConfirmClicked();

    void onEditorChanged(int i);

    void onHide();

    void onOutsideTouch(float f, float f2);

    void onShow();
}
