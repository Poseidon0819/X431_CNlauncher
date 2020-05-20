package com.cnlaunch.x431pro.module.golo.model;

import android.text.TextUtils;
import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.a */
/* loaded from: classes.dex */
public final class AddFriendInfo extends AbstractC2709c {
    public static final int ECODE_HISFRIEND_OVERMAN = 100103;
    public static final int ECODE_NEED_ENSURE = 100101;
    public static final int ECODE_SUCCESS = 1;
    public static final int ECODE_YOURFRIEND_OVERMAN = 100102;
    private static final long serialVersionUID = -5406788209527303644L;
    private int ecode = 0;
    private String nick_name;
    private String user_id;
    private String user_name;

    public final int getEcode() {
        return this.ecode;
    }

    public final void setEcode(int i) {
        this.ecode = i;
    }

    public final String getNick_name() {
        return this.nick_name;
    }

    public final void setNick_name(String str) {
        this.nick_name = str;
    }

    public final String getUser_name() {
        return this.user_name;
    }

    public final void setUser_name(String str) {
        this.user_name = str;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final void setUser_id(String str) {
        this.user_id = str;
    }

    public final String getName() {
        return TextUtils.isEmpty(this.nick_name) ? this.user_name : this.nick_name;
    }
}
