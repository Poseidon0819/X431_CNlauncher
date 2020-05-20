package com.cnlaunch.diagnosemodule.utils;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;

/* loaded from: classes.dex */
public class DialogContentPrintUtil {
    private static final boolean OPEN_LOG = false;
    private static OnClickPrintListener onClickPrintListener;

    /* loaded from: classes.dex */
    public interface OnClickPrintListener {
        void onClick(String str);
    }

    public static void log(String str) {
    }

    public static boolean enable(Context context) {
        boolean z = false;
        try {
            z = PreferencesManager.m9595a(context).m9583b(DiagnoseConstants.DIALOG_CONTENT_PRINT, false);
        } catch (Exception unused) {
        }
        log("enable=".concat(String.valueOf(z)));
        return z;
    }

    public static void setOnClickPrintListener(OnClickPrintListener onClickPrintListener2) {
        log("setOnClickPrintListener()");
        onClickPrintListener = onClickPrintListener2;
    }

    public static void removeOnClickPrintListener() {
        log("removeOnClickPrintListener()");
        onClickPrintListener = null;
    }

    public static void onClickPrintListener(String str) {
        log("onClickPrintListener()");
        OnClickPrintListener onClickPrintListener2 = onClickPrintListener;
        if (onClickPrintListener2 != null) {
            onClickPrintListener2.onClick(str);
        }
    }
}
