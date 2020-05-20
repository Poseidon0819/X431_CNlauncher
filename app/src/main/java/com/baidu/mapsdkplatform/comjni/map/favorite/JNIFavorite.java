package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;

/* loaded from: classes.dex */
public class JNIFavorite {
    public native boolean Add(long j, String str, String str2);

    public native boolean Clear(long j);

    public native long Create();

    public native int GetAll(long j, Bundle bundle);

    public native String GetValue(long j, String str);

    public native boolean IsExist(long j, String str);

    public native boolean Load(long j, String str, String str2, String str3, int i, int i2, int i3);

    public native int Release(long j);

    public native boolean Remove(long j, String str);

    public native boolean SaveCache(long j);

    public native boolean SetType(long j, int i);

    public native boolean Update(long j, String str, String str2);
}
