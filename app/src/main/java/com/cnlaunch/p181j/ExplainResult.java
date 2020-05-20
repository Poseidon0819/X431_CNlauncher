package com.cnlaunch.p181j;

import java.io.Serializable;
import message.model.ChatMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.j.w */
/* loaded from: classes.dex */
public final class ExplainResult implements Serializable {
    public static final String ACCEPT = "accept";
    public static final String APPINFO = "A-pro";
    public static final String ASKFOR = "askfor";
    public static final String FAIL = "fail";
    public static final String INVITE = "invite";
    public static final int MODEL_ACCEPT = 1;
    public static final int MODEL_CREATE = 0;
    public static final String REFUSE = "refuse";
    public static final String START = "start";
    public static final String STOP = "stop";
    private static final long serialVersionUID = -7029804216618699510L;
    private int model;
    public int ver;
    public String cmd = null;

    /* renamed from: ip */
    public String f9479ip = null;
    public String port = null;
    public String domain = null;
    public String serialNum = null;

    /* renamed from: message  reason: collision with root package name */
    public ChatMessage f24482message = null;
    public String carName = null;
    C1785a location = new C1785a();

    /* renamed from: id */
    public String f9478id = null;

    /* compiled from: ExplainResult.java */
    /* renamed from: com.cnlaunch.j.w$a */
    /* loaded from: classes.dex */
    public static class C1785a {

        /* renamed from: a */
        public String f9480a = null;

        /* renamed from: b */
        public String f9481b = null;
    }

    public ExplainResult(int i, int i2) {
        this.model = 0;
        this.ver = 0;
        this.ver = i;
        this.model = i2;
    }

    public final Object toJsonString(String str) {
        if (this.ver >= 2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ver", this.ver);
                jSONObject.put("app", APPINFO);
                jSONObject.put("cmd", str);
                if (str.equalsIgnoreCase(START)) {
                    jSONObject.put("ip", this.f9479ip);
                    jSONObject.put("port", this.port);
                    jSONObject.put("domain", this.domain);
                } else if (str.equalsIgnoreCase(ASKFOR)) {
                    jSONObject.put("carname", this.carName);
                    jSONObject.put("snkey", this.serialNum);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        } else if (str.equalsIgnoreCase(START)) {
            return START + "-" + this.f9479ip + "-" + this.port;
        } else if (str.equalsIgnoreCase(ASKFOR)) {
            return ASKFOR + "-" + this.serialNum;
        } else {
            return str;
        }
    }

    public final int getModel() {
        return this.model;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj instanceof ExplainResult) {
            ExplainResult explainResult = (ExplainResult) obj;
            return explainResult.cmd != null && (str = explainResult.f9478id) != null && str.equals(this.f9478id) && explainResult.cmd.equals(this.cmd);
        }
        return false;
    }
}
