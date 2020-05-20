package com.cnlaunch.p186m.p187a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.cnlaunch.m.a.a */
/* loaded from: classes.dex */
public interface ISecondWifiService extends IInterface {
    /* renamed from: a */
    boolean mo8629a() throws RemoteException;

    /* renamed from: a */
    boolean mo8628a(String str) throws RemoteException;

    /* renamed from: a */
    boolean mo8627a(String str, String str2) throws RemoteException;

    /* renamed from: a */
    boolean mo8626a(boolean z) throws RemoteException;

    /* renamed from: b */
    String mo8624b(String str) throws RemoteException;

    /* renamed from: b */
    void mo8622b(boolean z) throws RemoteException;

    /* renamed from: b */
    boolean mo8625b() throws RemoteException;

    /* renamed from: b */
    boolean mo8623b(String str, String str2) throws RemoteException;

    /* renamed from: c */
    String mo8621c() throws RemoteException;

    /* renamed from: c */
    String mo8620c(String str) throws RemoteException;

    /* renamed from: d */
    boolean mo8619d() throws RemoteException;

    /* renamed from: e */
    int mo8618e() throws RemoteException;

    /* compiled from: ISecondWifiService.java */
    /* renamed from: com.cnlaunch.m.a.a$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1799a extends Binder implements ISecondWifiService {
        /* renamed from: a */
        public static ISecondWifiService m8630a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.cnlaunch.second.wifi.ISecondWifiService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ISecondWifiService)) {
                return (ISecondWifiService) queryLocalInterface;
            }
            return new C1800a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.cnlaunch.second.wifi.ISecondWifiService");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.cnlaunch.second.wifi.ISecondWifiService");
                    boolean a = mo8629a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.cnlaunch.second.wifi.ISecondWifiService");
                    boolean b = mo8625b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.cnlaunch.second.wifi.ISecondWifiService");
                    boolean a2 = mo8627a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.cnlaunch.second.wifi.ISecondWifiService");
                    boolean b2 = mo8623b(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(b2 ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.cnlaunch.second.wifi.ISecondWifiService");
                    boolean a3 = mo8628a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a3 ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.cnlaunch.second.wifi.ISecondWifiService");
                    String b3 = mo8624b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b3);
                    return true;
                case 7:
                    parcel.enforceInterface("com.cnlaunch.second.wifi.ISecondWifiService");
                    String c = mo8621c();
                    parcel2.writeNoException();
                    parcel2.writeString(c);
                    return true;
                case 8:
                    parcel.enforceInterface("com.cnlaunch.second.wifi.ISecondWifiService");
                    boolean a4 = mo8626a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(a4 ? 1 : 0);
                    return true;
                case 9:
                    parcel.enforceInterface("com.cnlaunch.second.wifi.ISecondWifiService");
                    boolean d = mo8619d();
                    parcel2.writeNoException();
                    parcel2.writeInt(d ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface("com.cnlaunch.second.wifi.ISecondWifiService");
                    String c2 = mo8620c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(c2);
                    return true;
                case 11:
                    parcel.enforceInterface("com.cnlaunch.second.wifi.ISecondWifiService");
                    int e = mo8618e();
                    parcel2.writeNoException();
                    parcel2.writeInt(e);
                    return true;
                case 12:
                    parcel.enforceInterface("com.cnlaunch.second.wifi.ISecondWifiService");
                    mo8622b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: ISecondWifiService.java */
        /* renamed from: com.cnlaunch.m.a.a$a$a */
        /* loaded from: classes.dex */
        static class C1800a implements ISecondWifiService {

            /* renamed from: a */
            private IBinder f9526a;

            C1800a(IBinder iBinder) {
                this.f9526a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9526a;
            }

            @Override // com.cnlaunch.p186m.p187a.ISecondWifiService
            /* renamed from: a */
            public final boolean mo8629a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.second.wifi.ISecondWifiService");
                    this.f9526a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.p186m.p187a.ISecondWifiService
            /* renamed from: b */
            public final boolean mo8625b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.second.wifi.ISecondWifiService");
                    this.f9526a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.p186m.p187a.ISecondWifiService
            /* renamed from: a */
            public final boolean mo8627a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.second.wifi.ISecondWifiService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f9526a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.p186m.p187a.ISecondWifiService
            /* renamed from: b */
            public final boolean mo8623b(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.second.wifi.ISecondWifiService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f9526a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.p186m.p187a.ISecondWifiService
            /* renamed from: a */
            public final boolean mo8628a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.second.wifi.ISecondWifiService");
                    obtain.writeString(str);
                    this.f9526a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.p186m.p187a.ISecondWifiService
            /* renamed from: b */
            public final String mo8624b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.second.wifi.ISecondWifiService");
                    obtain.writeString(str);
                    this.f9526a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.p186m.p187a.ISecondWifiService
            /* renamed from: c */
            public final String mo8621c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.second.wifi.ISecondWifiService");
                    this.f9526a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.p186m.p187a.ISecondWifiService
            /* renamed from: a */
            public final boolean mo8626a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.second.wifi.ISecondWifiService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f9526a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.p186m.p187a.ISecondWifiService
            /* renamed from: d */
            public final boolean mo8619d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.second.wifi.ISecondWifiService");
                    this.f9526a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.p186m.p187a.ISecondWifiService
            /* renamed from: c */
            public final String mo8620c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.second.wifi.ISecondWifiService");
                    obtain.writeString(str);
                    this.f9526a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.p186m.p187a.ISecondWifiService
            /* renamed from: e */
            public final int mo8618e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.second.wifi.ISecondWifiService");
                    this.f9526a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.p186m.p187a.ISecondWifiService
            /* renamed from: b */
            public final void mo8622b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.second.wifi.ISecondWifiService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f9526a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
