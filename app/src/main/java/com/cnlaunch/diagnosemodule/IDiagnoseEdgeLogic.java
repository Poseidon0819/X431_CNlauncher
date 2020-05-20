package com.cnlaunch.diagnosemodule;

import android.content.Context;

/* loaded from: classes.dex */
public interface IDiagnoseEdgeLogic {
    public static final int SORT_WEIGHT_CAR_GENIUS_LOGIN_VALUE = 60;
    public static final int SORT_WEIGHT_DEFAULT_VALUE = 0;
    public static final int SORT_WEIGHT_EASY_DIAGNOSE_ENCRYPTION_AUTHENTICATED_VALUE = 50;
    public static final int SORT_WEIGHT_SMARTBOX30_SYSTEM_UPDATE_VALUE = 100;

    void diagnoseInit(Context context, DiagnoseEdgeParameters diagnoseEdgeParameters, IDiagnoseEdgeLogicCallback iDiagnoseEdgeLogicCallback);

    void diagnoseStart();

    int getSortNo();

    boolean isForbidden();

    boolean isNeedBreak();

    IDiagnoseEdgeLogic next();

    void setNext(IDiagnoseEdgeLogic iDiagnoseEdgeLogic);

    void startFailedAction();
}
