package com.artifex.mupdflib;

/* loaded from: classes.dex */
public abstract class CallbackApplication {

    /* loaded from: classes.dex */
    public interface MuPDFCallbackInterface {
        void callbackMethod(String str);
    }

    /* loaded from: classes.dex */
    public static final class MuPDFCallbackClass {
        public static MuPDFCallbackInterface callback = null;
        private static String gaiStr = "";

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void sendGaiView(String str) {
            MuPDFCallbackInterface muPDFCallbackInterface = callback;
            if (muPDFCallbackInterface != null) {
                gaiStr = str;
                muPDFCallbackInterface.callbackMethod(gaiStr);
            }
        }
    }
}
