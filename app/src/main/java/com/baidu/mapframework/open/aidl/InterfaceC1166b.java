package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.baidu.mapframework.open.aidl.b */
/* loaded from: classes.dex */
public interface InterfaceC1166b extends IInterface {

    /* renamed from: com.baidu.mapframework.open.aidl.b$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1167a extends Binder implements InterfaceC1166b {

        /* renamed from: com.baidu.mapframework.open.aidl.b$a$a */
        /* loaded from: classes.dex */
        static class C1168a implements InterfaceC1166b {

            /* renamed from: a */
            private IBinder f5804a;

            C1168a(IBinder iBinder) {
                this.f5804a = iBinder;
            }

            @Override // com.baidu.mapframework.open.aidl.InterfaceC1166b
            /* renamed from: a */
            public void mo10880a(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IOpenClientCallback");
                    obtain.writeStrongBinder(iBinder);
                    this.f5804a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5804a;
            }
        }

        public AbstractBinderC1167a() {
            attachInterface(this, "com.baidu.mapframework.open.aidl.IOpenClientCallback");
        }

        /* renamed from: b */
        public static InterfaceC1166b m10881b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.mapframework.open.aidl.IOpenClientCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1166b)) ? new C1168a(iBinder) : (InterfaceC1166b) queryLocalInterface;
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
                parcel2.writeString("com.baidu.mapframework.open.aidl.IOpenClientCallback");
                return true;
            }
            parcel.enforceInterface("com.baidu.mapframework.open.aidl.IOpenClientCallback");
            mo10880a(parcel.readStrongBinder());
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo10880a(IBinder iBinder) throws RemoteException;
}
