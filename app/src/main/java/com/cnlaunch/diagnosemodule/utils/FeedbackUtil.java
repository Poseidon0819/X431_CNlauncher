package com.cnlaunch.diagnosemodule.utils;

/* loaded from: classes.dex */
public class FeedbackUtil {
    public static String getFaultCodeFeedbackType() {
        return DiagnoseConstants.FEEDBACK_FREEZEFRAME;
    }

    public static String getMenuListType() {
        return "1";
    }

    public static String getActiveTestFeedbackCmd(int i) {
        return String.valueOf(i);
    }

    public static String getCombineMenuFeedbackCmd(int i, int i2) {
        StringBuilder sb = new StringBuilder("008");
        sb.append(String.valueOf(i));
        sb.append(i2 < 10 ? "0".concat(String.valueOf(i2)) : Integer.valueOf(i2));
        return sb.toString();
    }

    public static String getFaultCodeFeedbackCmd(int i) {
        return String.valueOf(i);
    }

    public static String getMenuFeedbackCmd(int i) {
        return String.valueOf(i);
    }

    public static String getSelectFeedbackCmd(int i) {
        return String.valueOf(i);
    }

    public static String getSpeciaFunctionFeedbackCmd(int i, int i2) {
        return String.valueOf((i / i2) + 80);
    }
}
