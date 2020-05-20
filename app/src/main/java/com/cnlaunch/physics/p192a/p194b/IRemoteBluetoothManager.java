package com.cnlaunch.physics.p192a.p194b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.cnlaunch.physics.a.b.e */
/* loaded from: classes.dex */
public interface IRemoteBluetoothManager extends IInterface {
    /* renamed from: a */
    int mo8431a() throws RemoteException;

    /* renamed from: a */
    int mo8426a(byte[] bArr, int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo8430a(int i) throws RemoteException;

    /* renamed from: a */
    void mo8429a(String str) throws RemoteException;

    /* renamed from: a */
    void mo8428a(String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo8427a(boolean z) throws RemoteException;

    /* renamed from: b */
    String mo8425b() throws RemoteException;

    /* renamed from: b */
    void mo8424b(String str) throws RemoteException;

    /* renamed from: b */
    void mo8423b(boolean z) throws RemoteException;

    /* renamed from: b */
    void mo8422b(byte[] bArr, int i, int i2) throws RemoteException;

    /* renamed from: c */
    void mo8420c(boolean z) throws RemoteException;

    /* renamed from: c */
    boolean mo8421c() throws RemoteException;

    /* renamed from: d */
    String mo8419d() throws RemoteException;

    /* renamed from: d */
    void mo8418d(boolean z) throws RemoteException;

    /* renamed from: e */
    void mo8417e() throws RemoteException;

    /* renamed from: e */
    void mo8416e(boolean z) throws RemoteException;

    /* renamed from: f */
    boolean mo8415f() throws RemoteException;

    /* renamed from: g */
    boolean mo8414g() throws RemoteException;

    /* renamed from: h */
    String mo8413h() throws RemoteException;

    /* renamed from: i */
    boolean mo8412i() throws RemoteException;

    /* renamed from: j */
    void mo8411j() throws RemoteException;

    /* renamed from: k */
    int mo8410k() throws RemoteException;

    /* renamed from: l */
    int mo8409l() throws RemoteException;

    /* renamed from: m */
    void mo8408m() throws RemoteException;

    /* renamed from: n */
    void mo8407n() throws RemoteException;

    /* renamed from: o */
    void mo8406o() throws RemoteException;

    /* renamed from: p */
    void mo8405p() throws RemoteException;

    /* renamed from: q */
    String mo8404q() throws RemoteException;

    /* renamed from: r */
    boolean mo8403r() throws RemoteException;

    /* renamed from: s */
    boolean mo8402s() throws RemoteException;

    /* compiled from: IRemoteBluetoothManager.java */
    /* renamed from: com.cnlaunch.physics.a.b.e$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1826a extends Binder implements IRemoteBluetoothManager {
        /* renamed from: a */
        public static IRemoteBluetoothManager m8432a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteBluetoothManager)) {
                return (IRemoteBluetoothManager) queryLocalInterface;
            }
            return new C1827a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    int a = mo8431a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    String b = mo8425b();
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    return true;
                case 3:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    boolean c = mo8421c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8427a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    String d = mo8419d();
                    parcel2.writeNoException();
                    parcel2.writeString(d);
                    return true;
                case 6:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8417e();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8428a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8429a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    boolean f = mo8415f();
                    parcel2.writeNoException();
                    parcel2.writeInt(f ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    boolean g = mo8414g();
                    parcel2.writeNoException();
                    parcel2.writeInt(g ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8424b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    String h = mo8413h();
                    parcel2.writeNoException();
                    parcel2.writeString(h);
                    return true;
                case 13:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8423b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    boolean i3 = mo8412i();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3 ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8411j();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8420c(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    int k = mo8410k();
                    parcel2.writeNoException();
                    parcel2.writeInt(k);
                    return true;
                case 18:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    int readInt = parcel.readInt();
                    byte[] bArr = readInt < 0 ? null : new byte[readInt];
                    int a2 = mo8426a(bArr, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                    parcel2.writeByteArray(bArr);
                    return true;
                case 19:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    int l = mo8409l();
                    parcel2.writeNoException();
                    parcel2.writeInt(l);
                    return true;
                case 20:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8408m();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8430a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8422b(parcel.createByteArray(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8407n();
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8406o();
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8405p();
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    String q = mo8404q();
                    parcel2.writeNoException();
                    parcel2.writeString(q);
                    return true;
                case 27:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8418d(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    boolean r = mo8403r();
                    parcel2.writeNoException();
                    parcel2.writeInt(r ? 1 : 0);
                    return true;
                case 29:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    mo8416e(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    boolean s = mo8402s();
                    parcel2.writeNoException();
                    parcel2.writeInt(s ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IRemoteBluetoothManager.java */
        /* renamed from: com.cnlaunch.physics.a.b.e$a$a */
        /* loaded from: classes.dex */
        static class C1827a implements IRemoteBluetoothManager {

            /* renamed from: a */
            private IBinder f9786a;

            C1827a(IBinder iBinder) {
                this.f9786a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9786a;
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: a */
            public final int mo8431a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: b */
            public final String mo8425b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: c */
            public final boolean mo8421c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: a */
            public final void mo8427a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    obtain.writeInt(z ? 1 : 0);
                    this.f9786a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: d */
            public final String mo8419d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: e */
            public final void mo8417e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: a */
            public final void mo8428a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f9786a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: a */
            public final void mo8429a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    obtain.writeString(str);
                    this.f9786a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: f */
            public final boolean mo8415f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: g */
            public final boolean mo8414g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: b */
            public final void mo8424b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    obtain.writeString(str);
                    this.f9786a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: h */
            public final String mo8413h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: b */
            public final void mo8423b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    obtain.writeInt(z ? 1 : 0);
                    this.f9786a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: i */
            public final boolean mo8412i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: j */
            public final void mo8411j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: c */
            public final void mo8420c(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    obtain.writeInt(z ? 1 : 0);
                    this.f9786a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: k */
            public final int mo8410k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: a */
            public final int mo8426a(byte[] bArr, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    if (bArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(bArr.length);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f9786a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readByteArray(bArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: l */
            public final int mo8409l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: m */
            public final void mo8408m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: a */
            public final void mo8430a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    obtain.writeInt(i);
                    this.f9786a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: b */
            public final void mo8422b(byte[] bArr, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f9786a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: n */
            public final void mo8407n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: o */
            public final void mo8406o() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: p */
            public final void mo8405p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: q */
            public final String mo8404q() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: d */
            public final void mo8418d(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    obtain.writeInt(z ? 1 : 0);
                    this.f9786a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: r */
            public final boolean mo8403r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: e */
            public final void mo8416e(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    obtain.writeInt(z ? 1 : 0);
                    this.f9786a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager
            /* renamed from: s */
            public final boolean mo8402s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager");
                    this.f9786a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
