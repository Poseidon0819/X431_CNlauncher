package com.cnlaunch.p169im.p173d;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.newgolo.manager.LightDownTimer;
import com.cnlaunch.p169im.p176f.GoloNotication;
import com.cnlaunch.p169im.p179i.UserInfoCache;
import com.cnlaunch.p169im.p180j.RunLastTask;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.html.HtmlTags;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import message.model.ChatMessage;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"DefaultLocale", "HandlerLeak"})
/* renamed from: com.cnlaunch.im.d.e */
/* loaded from: classes.dex */
public final class NoticeMessageHandler {

    /* renamed from: b */
    public static boolean f9196b = false;

    /* renamed from: e */
    private static Context f9197e;

    /* renamed from: f */
    private static NoticeMessageHandler f9198f;

    /* renamed from: a */
    public RunLastTask f9199a;

    /* renamed from: c */
    public GoloNotication f9200c;

    /* renamed from: g */
    private LightDownTimer f9202g;

    /* renamed from: d */
    public Set<String> f9201d = new HashSet();

    /* renamed from: h */
    private Handler f9203h = new HandlerC1733g(this);

    /* renamed from: a */
    public static NoticeMessageHandler m8784a(Context context) {
        if (f9198f == null) {
            f9198f = new NoticeMessageHandler(context);
        }
        return f9198f;
    }

    /* renamed from: a */
    public final void m8779a(String str) {
        this.f9200c.m8734a(str);
    }

    /* renamed from: b */
    public final boolean m8773b(String str) {
        try {
            return this.f9201d.contains(str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private NoticeMessageHandler(Context context) {
        f9197e = context;
        this.f9200c = new GoloNotication(f9197e);
        this.f9199a = new RunLastTask();
    }

    /* renamed from: a */
    public static void m8785a() {
        try {
            GoloLightManager.m8495c();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (f9197e != null) {
            Intent intent = new Intent("com.cnlaunch.golo.Notification");
            intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
            f9197e.startActivity(intent);
        }
    }

    /* renamed from: a */
    public final int m8778a(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return 0;
        }
        Log.i("Sanda", "noticMessage=" + chatMessage.f24057b);
        if (chatMessage.m218a() == 0) {
            return 7;
        }
        if (chatMessage.m218a() == 9) {
            JSONObject m192p = chatMessage.m192p();
            if (m192p.has("subtype")) {
                try {
                    boolean z = m192p.getInt("subtype") == 1;
                    Intent intent = new Intent();
                    intent.setAction("add_friend");
                    intent.putExtra("result", z);
                    intent.putExtra("target_id", chatMessage.f24057b);
                    f9197e.sendBroadcast(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
            return 7;
        } else if (chatMessage.m218a() == 14) {
            return 0;
        } else {
            if (f9196b) {
                return 7;
            }
            if (chatMessage.m192p().has("diag_uid")) {
                String m8777a = m8777a(chatMessage.m192p());
                if ("remote_req".equalsIgnoreCase(m8777a) || "bunding_new".equalsIgnoreCase(m8777a)) {
                    return 7;
                }
            }
            if (MainActivity.m7895b()) {
                if (!AutoVoiceHandler.f9188c) {
                    return 0;
                }
                if (chatMessage.m218a() != 2) {
                    return 2;
                }
            }
            return this.f9201d.contains(chatMessage.f24057b) ? 0 : 7;
        }
    }

    /* renamed from: b */
    private static PendingIntent m8775b(Context context) {
        Intent intent = new Intent("Golo_Notification");
        intent.putExtra("subtype", 1);
        return PendingIntent.getBroadcast(context, 0, intent, NTLMConstants.FLAG_UNIDENTIFIED_10);
    }

    /* renamed from: a */
    private static String m8777a(JSONObject jSONObject) {
        if (jSONObject.has("diag_uid")) {
            try {
                if (jSONObject.has("acttype") && 1 == jSONObject.getInt("acttype")) {
                    return "bunding_new";
                }
                if (jSONObject.has("acttype") && jSONObject.getInt("acttype") == 0) {
                    return "bunding_remove";
                }
                if (jSONObject.has("diag_id") && jSONObject.has("status")) {
                    return "remote_status_change";
                }
                if (jSONObject.has("diag_id")) {
                    return "remote_req";
                }
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: c */
    private static boolean m8771c(String str) {
        return TextUtils.isEmpty(str) || str.equalsIgnoreCase("NULL");
    }

    /* renamed from: a */
    public static String m8783a(Context context, ChatMessage chatMessage) {
        int m218a = chatMessage.m218a();
        if (m218a == 10) {
            String m211b = chatMessage.m211b();
            m211b = (TextUtils.isEmpty(m211b) || m211b.equalsIgnoreCase("NULL")) ? "" : "";
            return "[" + context.getString(R.string.dialog_remotediag_handler_title) + "]" + m211b;
        } else if (m218a != 12) {
            switch (m218a) {
                case 1:
                    if (Pattern.compile("(\\[@){1}[0-9]+[\\]]{1}").matcher(chatMessage.m211b()).find()) {
                        return "[" + context.getString(R.string.chat_select_grid_face) + "]";
                    } else if (chatMessage.m192p().has(HtmlTags.FACE)) {
                        return "[" + context.getString(R.string.chat_select_grid_face) + "]";
                    } else {
                        return chatMessage.m211b();
                    }
                case 2:
                    return "[" + context.getString(R.string.share_void_read) + "]";
                case 3:
                    return "[" + context.getString(R.string.favor_picture) + "]";
                case 4:
                    return "[" + context.getString(R.string.position) + "]" + chatMessage.m211b();
                case 5:
                    return "[" + context.getString(R.string.card) + "]";
                case 6:
                    return "[" + context.getString(R.string.check_server_file_txt) + "]";
                case 7:
                    return "[" + context.getString(R.string.chat_select_vedio) + "]";
                default:
                    return chatMessage.m211b();
            }
        } else {
            String str = "";
            try {
                JSONArray jSONArray = new JSONArray(chatMessage.m192p().getString("news"));
                if (jSONArray.length() > 0) {
                    str = jSONArray.getJSONObject(0).getString("title");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "[" + context.getString(R.string.news) + "]" + str;
        }
    }

    /* renamed from: b */
    private static String m8772b(ChatMessage chatMessage) {
        if (chatMessage.f24060e.equalsIgnoreCase("666666")) {
            return f9197e.getString(R.string.cheyunteam_name);
        }
        if (chatMessage.m218a() != 5) {
            chatMessage.m202f();
        }
        String m8710a = m8771c("") ? UserInfoCache.m8711a(f9197e, true).m8710a(chatMessage.f24060e) : "";
        return m8771c(m8710a) ? chatMessage.f24060e : m8710a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(8:47|48|(1:50)(1:54)|51|52|6|7|8)|5|6|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        r0.printStackTrace();
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void m8780a(com.cnlaunch.p169im.p173d.NoticeMessageHandler r17, message.model.ChatMessage r18) {
        /*
            Method dump skipped, instructions count: 629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p169im.p173d.NoticeMessageHandler.m8780a(com.cnlaunch.im.d.e, message.model.ChatMessage):void");
    }
}
