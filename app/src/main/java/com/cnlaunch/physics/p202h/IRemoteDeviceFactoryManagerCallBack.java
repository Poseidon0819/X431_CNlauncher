package com.cnlaunch.physics.p202h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.cnlaunch.physics.h.b */
/* loaded from: classes.dex */
public interface IRemoteDeviceFactoryManagerCallBack extends IInterface {
    /* renamed from: a */
    void mo8264a(String str) throws RemoteException;

    /* compiled from: IRemoteDeviceFactoryManagerCallBack.java */
    /* renamed from: com.cnlaunch.physics.h.b$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1844a extends Binder implements IRemoteDeviceFactoryManagerCallBack {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC1844a() {
            attachInterface(this, "com.cnlaunch.physics.remote.IRemoteDeviceFactoryManagerCallBack");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManagerCallBack");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManagerCallBack");
            mo8264a(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* compiled from: IRemoteDeviceFactoryManagerCallBack.java */
        /* renamed from: com.cnlaunch.physics.h.b$a$a */
        /* loaded from: classes.dex */
        static class C1845a implements IRemoteDeviceFactoryManagerCallBack {

            /* renamed from: a */
            private IBinder f9934a;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C1845a(IBinder iBinder) {
                this.f9934a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9934a;
            }

            @Override // com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManagerCallBack
            /* renamed from: a */
            public final void mo8264a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.physics.remote.IRemoteDeviceFactoryManagerCallBack");
                    obtain.writeString(str);
                    this.f9934a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
