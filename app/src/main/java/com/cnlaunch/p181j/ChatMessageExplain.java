package com.cnlaunch.p181j;

import android.util.Log;
import message.model.ChatMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.j.b */
/* loaded from: classes.dex */
public final class ChatMessageExplain {
    /* renamed from: a */
    public static ExplainResult m8675a(ChatMessage chatMessage) {
        int m8674b = m8674b(chatMessage);
        ExplainResult explainResult = new ExplainResult(m8674b, 1);
        explainResult.f24482message = chatMessage;
        explainResult.f9478id = chatMessage.f24057b;
        if (m8674b == 1) {
            String m191q = chatMessage.m191q();
            if (m191q.contains(ExplainResult.ASKFOR)) {
                String[] split = m191q.split("-");
                explainResult.cmd = ExplainResult.ASKFOR;
                explainResult.serialNum = split[1];
                explainResult.location.f9480a = chatMessage.m201g();
                explainResult.location.f9481b = chatMessage.m200h();
            } else if (m191q.contains(ExplainResult.START)) {
                try {
                    explainResult.cmd = ExplainResult.START;
                    String[] split2 = m191q.split("-");
                    explainResult.f9479ip = split2[1];
                    explainResult.port = split2[2];
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("Sanda", "ChatMessageExplain [01]=" + e.toString());
                }
            } else {
                explainResult.cmd = m191q;
            }
        } else {
            try {
                JSONObject jSONObject = new JSONObject(chatMessage.m191q());
                explainResult.cmd = jSONObject.getString("cmd");
                if (explainResult.cmd.equalsIgnoreCase(ExplainResult.START)) {
                    explainResult.f9479ip = jSONObject.has("ip") ? jSONObject.getString("ip") : "";
                    explainResult.port = jSONObject.has("port") ? jSONObject.getString("port") : "";
                    explainResult.domain = jSONObject.has("domain") ? jSONObject.getString("domain") : "";
                } else if (explainResult.cmd.equalsIgnoreCase(ExplainResult.ASKFOR)) {
                    explainResult.serialNum = jSONObject.has("snkey") ? jSONObject.getString("snkey") : "";
                    explainResult.carName = jSONObject.has("carname") ? jSONObject.getString("carname") : "";
                    explainResult.location.f9480a = chatMessage.m201g();
                    explainResult.location.f9481b = chatMessage.m200h();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                Log.e("Sanda", "ChatMessageExplain [02]=" + e2.toString());
            }
        }
        return explainResult;
    }

    /* renamed from: b */
    private static int m8674b(ChatMessage chatMessage) {
        try {
            JSONObject jSONObject = new JSONObject(chatMessage.m191q());
            try {
                if (jSONObject.has("ver")) {
                    return jSONObject.getInt("ver");
                }
                return 1;
            } catch (JSONException e) {
                e.printStackTrace();
                return 0;
            }
        } catch (JSONException e2) {
            Log.e("Sanda", "ChatMessageExplain [00]=" + e2.toString());
            return 1;
        }
    }
}
