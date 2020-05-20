package com.unionpay.mobile.android.hce.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.unionpay.mobile.android.hce.service.b */
/* loaded from: classes2.dex */
public interface InterfaceC4166b extends IInterface {

    /* renamed from: com.unionpay.mobile.android.hce.service.b$a */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC4167a extends Binder implements InterfaceC4166b {

        /* renamed from: com.unionpay.mobile.android.hce.service.b$a$a */
        /* loaded from: classes2.dex */
        static class C4168a implements InterfaceC4166b {

            /* renamed from: a */
            private IBinder f22226a;

            C4168a(IBinder iBinder) {
                this.f22226a = iBinder;
            }

            @Override // com.unionpay.mobile.android.hce.service.InterfaceC4166b
            /* renamed from: a */
            public final void mo1548a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCECallback");
                    obtain.writeString(str);
                    this.f22226a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.mobile.android.hce.service.InterfaceC4166b
            /* renamed from: a */
            public final void mo1547a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCECallback");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f22226a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f22226a;
            }
        }

        public AbstractBinderC4167a() {
            attachInterface(this, "com.unionpay.mobile.android.hce.service.IHCECallback");
        }

        /* renamed from: a */
        public static InterfaceC4166b m1549a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.mobile.android.hce.service.IHCECallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC4166b)) ? new C4168a(iBinder) : (InterfaceC4166b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.unionpay.mobile.android.hce.service.IHCECallback");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.unionpay.mobile.android.hce.service.IHCECallback");
                    mo1547a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.unionpay.mobile.android.hce.service.IHCECallback");
                    mo1548a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo1548a(String str) throws RemoteException;

    /* renamed from: a */
    void mo1547a(String str, String str2) throws RemoteException;
}
