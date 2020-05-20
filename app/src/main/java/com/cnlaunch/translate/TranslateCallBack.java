package com.cnlaunch.translate;

/* loaded from: classes.dex */
public interface TranslateCallBack {
    void fail(int i, String str);

    void success(TranslateResult translateResult);
}
