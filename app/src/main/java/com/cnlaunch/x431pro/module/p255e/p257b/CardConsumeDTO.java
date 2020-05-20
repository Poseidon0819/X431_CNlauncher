package com.cnlaunch.x431pro.module.p255e.p257b;

import android.text.TextUtils;
import com.cnlaunch.x431pro.utils.CardUtil;
import java.io.Serializable;

/* renamed from: com.cnlaunch.x431pro.module.e.b.a */
/* loaded from: classes.dex */
public final class CardConsumeDTO implements Serializable {
    private static final long serialVersionUID = -4983028326846351697L;
    private String cardNo;
    private String cardRechargeYear;
    private String freeEndTime;
    private String oldFreeEndTime;
    private String serialNo;
    private String updateDate;

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        this.serialNo = str;
    }

    public final String getUpdateDate() {
        return CardUtil.m4921a(this.updateDate);
    }

    public final void setUpdateDate(String str) {
        this.updateDate = str;
    }

    public final String getCardNo() {
        return this.cardNo;
    }

    public final void setCardNo(String str) {
        this.cardNo = str;
    }

    public final String getOldFreeEndTime() {
        return this.oldFreeEndTime;
    }

    public final void setOldFreeEndTime(String str) {
        this.oldFreeEndTime = str;
    }

    public final String getFreeEndTime() {
        return CardUtil.m4921a(this.freeEndTime);
    }

    public final void setFreeEndTime(String str) {
        this.freeEndTime = str;
    }

    public final String getCardRechargeYear() {
        return this.cardRechargeYear;
    }

    public final void setCardRechargeYear(String str) {
        this.cardRechargeYear = str;
    }

    public final String toString() {
        return "CardConsumeDTO{serialNo='" + this.serialNo + "', updateDate='" + this.updateDate + "', cardNo='" + this.cardNo + "', oldFreeEndTime='" + this.oldFreeEndTime + "', freeEndTime='" + this.freeEndTime + "', cardRechargeYear='" + this.cardRechargeYear + "'}";
    }

    public final boolean isEmpty() {
        return TextUtils.isEmpty(this.serialNo) && TextUtils.isEmpty(this.updateDate) && TextUtils.isEmpty(this.cardNo) && TextUtils.isEmpty(this.oldFreeEndTime) && TextUtils.isEmpty(this.freeEndTime) && TextUtils.isEmpty(this.cardRechargeYear);
    }
}
