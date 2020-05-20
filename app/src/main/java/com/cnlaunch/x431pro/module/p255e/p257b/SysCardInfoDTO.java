package com.cnlaunch.x431pro.module.p255e.p257b;

import com.cnlaunch.x431pro.utils.CardUtil;
import java.io.Serializable;

/* renamed from: com.cnlaunch.x431pro.module.e.b.j */
/* loaded from: classes.dex */
public final class SysCardInfoDTO implements Serializable {
    private static final long serialVersionUID = -8332138977867754517L;
    private String cardConfName;
    private String cardConsumeDate;
    private String cardNo;
    private int cardRechargeYear;
    private int cardState;
    private String serialNo;
    private String softConfName;

    public final String getCardConfName() {
        return this.cardConfName;
    }

    public final void setCardConfName(String str) {
        this.cardConfName = str;
    }

    public final String getCardNo() {
        return this.cardNo;
    }

    public final void setCardNo(String str) {
        this.cardNo = str;
    }

    public final String getCardConsumeDate() {
        return CardUtil.m4921a(this.cardConsumeDate);
    }

    public final void setCardConsumeDate(String str) {
        this.cardConsumeDate = str;
    }

    public final int getCardRechargeYear() {
        return this.cardRechargeYear;
    }

    public final void setCardRechargeYear(int i) {
        this.cardRechargeYear = i;
    }

    public final int getCardState() {
        return this.cardState;
    }

    public final void setCardState(int i) {
        this.cardState = i;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        this.serialNo = str;
    }

    public final String getSoftConfName() {
        return this.softConfName;
    }

    public final void setSoftConfName(String str) {
        this.softConfName = str;
    }
}
