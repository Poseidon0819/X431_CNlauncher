package com.unionpay.client3.tsm;

import android.os.Bundle;

/* loaded from: classes2.dex */
public interface ITsmTransCallback {
    void onFailed(int i, int i2, String str, String str2);

    void onSuccess(int i, int i2, Bundle bundle);
}
