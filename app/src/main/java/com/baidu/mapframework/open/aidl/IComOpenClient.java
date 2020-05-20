package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IComOpenClient extends IInterface {

    /* renamed from: com.baidu.mapframework.open.aidl.IComOpenClient$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1161a extends Binder implements IComOpenClient {

        /* renamed from: com.baidu.mapframework.open.aidl.IComOpenClient$a$a */
        /* loaded from: classes.dex */
        static class C1162a implements IComOpenClient {

            /* renamed from: a */
            private IBinder f5802a;

            C1162a(IBinder iBinder) {
                this.f5802a = iBinder;
            }

            @Override // com.baidu.mapframework.open.aidl.IComOpenClient
            /* renamed from: a */
            public String mo10885a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IComOpenClient");
                    obtain.writeString(str);
                    this.f5802a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.mapframework.open.aidl.IComOpenClient
            /* renamed from: a */
            public boolean mo10884a(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IComOpenClient");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f5802a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5802a;
            }
        }

        /* renamed from: a */
        public static IComOpenClient m10886a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IComOpenClient)) ? new C1162a(iBinder) : (IComOpenClient) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str;
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
                        str = mo10885a(parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 2:
                        parcel.enforceInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
                        boolean a = mo10884a(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(a ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                str = "com.baidu.mapframework.open.aidl.IComOpenClient";
            }
            parcel2.writeString(str);
            return true;
        }
    }

    /* renamed from: a */
    String mo10885a(String str) throws RemoteException;

    /* renamed from: a */
    boolean mo10884a(String str, String str2, Bundle bundle) throws RemoteException;
}
