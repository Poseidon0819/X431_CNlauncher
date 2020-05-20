package com.unionpay.mobile.android.hce.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.unionpay.mobile.android.hce.service.InterfaceC4166b;

/* renamed from: com.unionpay.mobile.android.hce.service.a */
/* loaded from: classes2.dex */
public interface InterfaceC4163a extends IInterface {

    /* renamed from: com.unionpay.mobile.android.hce.service.a$a */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC4164a extends Binder implements InterfaceC4163a {

        /* renamed from: com.unionpay.mobile.android.hce.service.a$a$a */
        /* loaded from: classes2.dex */
        static class C4165a implements InterfaceC4163a {

            /* renamed from: a */
            private IBinder f22225a;

            C4165a(IBinder iBinder) {
                this.f22225a = iBinder;
            }

            @Override // com.unionpay.mobile.android.hce.service.InterfaceC4163a
            /* renamed from: a */
            public final String mo1551a(String str, String str2, InterfaceC4166b interfaceC4166b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCEBankService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(interfaceC4166b != null ? interfaceC4166b.asBinder() : null);
                    this.f22225a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.mobile.android.hce.service.InterfaceC4163a
            /* renamed from: a */
            public final void mo1550a(String str, String str2, String str3, InterfaceC4166b interfaceC4166b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCEBankService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(interfaceC4166b != null ? interfaceC4166b.asBinder() : null);
                    this.f22225a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f22225a;
            }
        }

        /* renamed from: a */
        public static InterfaceC4163a m1552a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.mobile.android.hce.service.IHCEBankService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC4163a)) ? new C4165a(iBinder) : (InterfaceC4163a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.unionpay.mobile.android.hce.service.IHCEBankService");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.unionpay.mobile.android.hce.service.IHCEBankService");
                    String a = mo1551a(parcel.readString(), parcel.readString(), InterfaceC4166b.AbstractBinderC4167a.m1549a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.unionpay.mobile.android.hce.service.IHCEBankService");
                    mo1550a(parcel.readString(), parcel.readString(), parcel.readString(), InterfaceC4166b.AbstractBinderC4167a.m1549a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    String mo1551a(String str, String str2, InterfaceC4166b interfaceC4166b) throws RemoteException;

    /* renamed from: a */
    void mo1550a(String str, String str2, String str3, InterfaceC4166b interfaceC4166b) throws RemoteException;
}
