package com.cnlaunch.p183l.p185b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.cnlaunch.l.b.a */
/* loaded from: classes.dex */
public interface ILaunchAidlService extends IInterface {
    /* renamed from: a */
    boolean mo8631a(String str, String[] strArr) throws RemoteException;

    /* compiled from: ILaunchAidlService.java */
    /* renamed from: com.cnlaunch.l.b.a$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1797a extends Binder implements ILaunchAidlService {
        /* renamed from: a */
        public static ILaunchAidlService m8632a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.cnlaunch.rpcutils.aidlService.ILaunchAidlService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ILaunchAidlService)) {
                return (ILaunchAidlService) queryLocalInterface;
            }
            return new C1798a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.cnlaunch.rpcutils.aidlService.ILaunchAidlService");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.cnlaunch.rpcutils.aidlService.ILaunchAidlService");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            String[] strArr = readInt < 0 ? null : new String[readInt];
            boolean a = mo8631a(readString, strArr);
            parcel2.writeNoException();
            parcel2.writeInt(a ? 1 : 0);
            parcel2.writeStringArray(strArr);
            return true;
        }

        /* compiled from: ILaunchAidlService.java */
        /* renamed from: com.cnlaunch.l.b.a$a$a */
        /* loaded from: classes.dex */
        static class C1798a implements ILaunchAidlService {

            /* renamed from: a */
            private IBinder f9525a;

            C1798a(IBinder iBinder) {
                this.f9525a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9525a;
            }

            @Override // com.cnlaunch.p183l.p185b.ILaunchAidlService
            /* renamed from: a */
            public final boolean mo8631a(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cnlaunch.rpcutils.aidlService.ILaunchAidlService");
                    obtain.writeString(str);
                    if (strArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(strArr.length);
                    }
                    this.f9525a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    boolean z = obtain2.readInt() != 0;
                    obtain2.readStringArray(strArr);
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
