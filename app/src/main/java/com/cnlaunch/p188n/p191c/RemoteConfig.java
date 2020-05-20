package com.cnlaunch.p188n.p191c;

/* renamed from: com.cnlaunch.n.c.f */
/* loaded from: classes.dex */
public final class RemoteConfig extends BaseModel {

    /* renamed from: ip */
    private String f9647ip;
    private boolean isUsb_p2p_mode;
    private String key;
    private int port;

    /* renamed from: sn */
    private String f9648sn;
    private String tech_id;
    private String tech_name;
    private String tech_tel;

    public RemoteConfig(String str, int i, String str2, String str3) {
        this.f9647ip = "";
        this.f9648sn = "";
        this.key = "";
        this.tech_id = "";
        this.tech_name = "";
        this.tech_tel = "";
        this.isUsb_p2p_mode = false;
        this.f9647ip = str;
        this.port = i;
        this.f9648sn = str2;
        this.key = str3;
    }

    public RemoteConfig(String str, int i, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this(str, i, str2, str3);
        this.tech_id = str4;
        this.tech_name = str5;
        this.tech_tel = str6;
        this.isUsb_p2p_mode = z;
    }

    public final String getIp() {
        return this.f9647ip;
    }

    public final int getPort() {
        return this.port;
    }

    public final String getSn() {
        return this.f9648sn;
    }

    public final void setSn(String str) {
        this.f9648sn = str;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getTech_id() {
        return this.tech_id;
    }

    public final String getTech_name() {
        return this.tech_name;
    }

    public final String getTech_tel() {
        return this.tech_tel;
    }

    public final boolean isUsb_p2p_mode() {
        return this.isUsb_p2p_mode;
    }
}
