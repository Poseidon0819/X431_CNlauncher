package com.cnlaunch.physics.p202h;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager;
import com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManagerCallBack;
import java.util.List;

/* renamed from: com.cnlaunch.physics.h.a */
/* loaded from: classes.dex */
public interface IRemoteDeviceFactoryManager extends IInterface {
    /* renamed from: a */
    int mo8268a() throws RemoteException;

    /* renamed from: a */
    IRemoteBluetoothManager mo8267a(String str, boolean z, IRemoteDeviceFactoryManagerCallBack iRemoteDeviceFactoryManagerCallBack) throws RemoteException;

    /* renamed from: a */
    void mo8266a(String str, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    List<BluetoothDevice> mo8265b() throws RemoteException;

    /* compiled from: IRemoteDeviceFactoryManager.java */
    /* renamed from: com.cnlaunch.physics.h.a$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1842a extends Binder implements IRemoteDeviceFactoryManager {
        /* renamed from: a */
        public static IRemoteDeviceFactoryManager m8269a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteDeviceFactoryManager)) {
                return (IRemoteDeviceFactoryManager) queryLocalInterface;
            }
            return new C1843a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IRemoteDeviceFactoryManagerCallBack c1845a;
            if (i == 1598968902) {
                parcel2.writeString("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManager");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManager");
                    String readString = parcel.readString();
                    boolean z = parcel.readInt() != 0;
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        c1845a = null;
                    } else {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManagerCallBack");
                        if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteDeviceFactoryManagerCallBack)) {
                            c1845a = (IRemoteDeviceFactoryManagerCallBack) queryLocalInterface;
                        } else {
                            c1845a = new IRemoteDeviceFactoryManagerCallBack.AbstractBinderC1844a.C1845a(readStrongBinder);
                        }
                    }
                    IRemoteBluetoothManager a = mo8267a(readString, z, c1845a);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManager");
                    mo8266a(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManager");
                    int a2 = mo8268a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                    return true;
                case 4:
                    parcel.enforceInterface("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManager");
                    List<BluetoothDevice> b = mo8265b();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(b);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IRemoteDeviceFactoryManager.java */
        /* renamed from: com.cnlaunch.physics.h.a$a$a */
        /* loaded from: classes.dex */
        static class C1843a implements IRemoteDeviceFactoryManager {

            /* renamed from: a */
            private IBinder f9933a;

            C1843a(IBinder iBinder) {
                this.f9933a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9933a;
            }

            @Override // com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManager
            /* renamed from: a */
            public final IRemoteBluetoothManager mo8267a(String str, boolean z, IRemoteDeviceFactoryManagerCallBack iRemoteDeviceFactoryManagerCallBack) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManager");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(iRemoteDeviceFactoryManagerCallBack != null ? iRemoteDeviceFactoryManagerCallBack.asBinder() : null);
                    this.f9933a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return IRemoteBluetoothManager.AbstractBinderC1826a.m8432a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManager
            /* renamed from: a */
            public final void mo8266a(String str, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManager");
                    obtain.writeString(str);
                    int i = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f9933a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManager
            /* renamed from: a */
            public final int mo8268a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManager");
                    this.f9933a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManager
            /* renamed from: b */
            public final List<BluetoothDevice> mo8265b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManager");
                    this.f9933a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(BluetoothDevice.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
