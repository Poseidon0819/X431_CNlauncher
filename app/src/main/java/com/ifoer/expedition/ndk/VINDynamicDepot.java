package com.ifoer.expedition.ndk;

/* loaded from: classes.dex */
public class VINDynamicDepot {
    public native String AutoSearchSetArgs(String str);

    public native String AutoSearchVehByVIN(String str, int i);

    public native int OBDReadVIN();

    public native String ReadVinCvn();

    public native int VINDiagnoseMain();
}
