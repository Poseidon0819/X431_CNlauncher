package com.cnlaunch.x431pro.module.golo.model;

import android.text.TextUtils;
import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.e */
/* loaded from: classes.dex */
public abstract class CustomerInfo extends AbstractC2709c {
    private static final long serialVersionUID = 7381027988545018565L;
    private String lastText;
    private Long lastTime;
    private String nick_name;
    private String signature;
    private String status;
    private String user_id;
    private String user_name;
    private int newMsgCount = 0;
    private boolean isExtend = true;
    private Boolean isRead = Boolean.FALSE;
    private Boolean isNewCustomer = Boolean.FALSE;
    private String sortKey = "";

    public boolean isOnLine() {
        return false;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public boolean isExtend() {
        return this.isExtend;
    }

    public void setExtend(boolean z) {
        this.isExtend = z;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    public String getNick_name() {
        return this.nick_name;
    }

    public void setNick_name(String str) {
        this.nick_name = str;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String str) {
        this.user_name = str;
    }

    public String getSortKey() {
        return this.sortKey;
    }

    public void setSortKey(String str) {
        this.sortKey = str;
    }

    public Long getLastTime() {
        return this.lastTime;
    }

    public void setLastTime(Long l) {
        this.lastTime = l;
    }

    public int getNewMsgCount() {
        return this.newMsgCount;
    }

    public void setNewMsgCount(int i) {
        this.newMsgCount = i;
    }

    public Boolean getIsRead() {
        return this.isRead;
    }

    public void setIsRead(Boolean bool) {
        this.isRead = bool;
    }

    public static boolean isNotNull(String str) {
        return (TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str)) ? false : true;
    }

    public Boolean getIsNewCustomer() {
        Boolean bool = this.isNewCustomer;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public void setIsNewCustomer(Boolean bool) {
        this.isNewCustomer = bool;
    }

    public String getLastText() {
        return TextUtils.isEmpty(this.lastText) ? "" : this.lastText;
    }

    public void setLastText(String str) {
        this.lastText = str;
    }
}
