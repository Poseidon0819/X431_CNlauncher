package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.mapframework.open.aidl.InterfaceC1166b;

/* renamed from: com.baidu.mapframework.open.aidl.a */
/* loaded from: classes.dex */
public interface InterfaceC1163a extends IInterface {

    /* renamed from: com.baidu.mapframework.open.aidl.a$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1164a extends Binder implements InterfaceC1163a {

        /* renamed from: com.baidu.mapframework.open.aidl.a$a$a */
        /* loaded from: classes.dex */
        static class C1165a implements InterfaceC1163a {

            /* renamed from: a */
            private IBinder f5803a;

            C1165a(IBinder iBinder) {
                this.f5803a = iBinder;
            }

            @Override // com.baidu.mapframework.open.aidl.InterfaceC1163a
            /* renamed from: a */
            public void mo10882a(InterfaceC1166b interfaceC1166b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IMapOpenService");
                    obtain.writeStrongBinder(interfaceC1166b != null ? interfaceC1166b.asBinder() : null);
                    this.f5803a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5803a;
            }
        }

        /* renamed from: a */
        public static InterfaceC1163a m10883a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.mapframework.open.aidl.IMapOpenService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1163a)) ? new C1165a(iBinder) : (InterfaceC1163a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.baidu.mapframework.open.aidl.IMapOpenService");
                return true;
            }
            parcel.enforceInterface("com.baidu.mapframework.open.aidl.IMapOpenService");
            mo10882a(InterfaceC1166b.AbstractBinderC1167a.m10881b(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo10882a(InterfaceC1166b interfaceC1166b) throws RemoteException;
}
