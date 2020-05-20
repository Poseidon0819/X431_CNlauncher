package message.p383f;

import android.content.SharedPreferences;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import message.model.MessageLoginEntity;
import message.p384g.LogUtilMsg;

/* renamed from: message.f.m */
/* loaded from: classes2.dex */
public class SharePreferenceMsgUtils {

    /* renamed from: b */
    private static SharePreferenceMsgUtils f24031b;

    /* renamed from: a */
    public SharedPreferences f24032a;

    private SharePreferenceMsgUtils(String str) {
        this.f24032a = null;
        LogUtilMsg.m227a("SharePreferenceMsgUtils_by_userId", str + "-");
        this.f24032a = ApplicationConfig.f7802a.getSharedPreferences(str, 0);
    }

    private SharePreferenceMsgUtils() {
        this.f24032a = null;
        LogUtilMsg.m227a("SharePreferenceMsgUtils_get_userId", ApplicationConfig.m9181a() + "-");
        this.f24032a = ApplicationConfig.f7802a.getSharedPreferences(ApplicationConfig.m9181a(), 0);
    }

    /* renamed from: a */
    public static SharePreferenceMsgUtils m248a() {
        if (f24031b == null) {
            synchronized (SharePreferenceMsgUtils.class) {
                if (f24031b == null && ApplicationConfig.m9181a() != null && !"".equals(ApplicationConfig.m9181a())) {
                    f24031b = new SharePreferenceMsgUtils();
                }
            }
        }
        return f24031b;
    }

    /* renamed from: a */
    public static SharePreferenceMsgUtils m246a(String str) {
        if (f24031b == null) {
            synchronized (SharePreferenceMsgUtils.class) {
                if (f24031b == null && str != null && !"".equals(str)) {
                    f24031b = new SharePreferenceMsgUtils(str);
                }
            }
        }
        return f24031b;
    }

    /* renamed from: a */
    public final void m247a(Long l) {
        this.f24032a.edit().putLong("last_message", l.longValue()).commit();
    }

    /* renamed from: b */
    public final Long m243b() {
        return Long.valueOf(this.f24032a.getLong("last_message", -1L));
    }

    /* renamed from: a */
    public final void m244a(MessageLoginEntity messageLoginEntity) {
        try {
            SharedPreferences.Editor edit = this.f24032a.edit();
            edit.putString("msg_login_content", messageLoginEntity.f24096f);
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public final MessageLoginEntity m242c() {
        try {
            return new MessageLoginEntity(this.f24032a.getString("msg_login_content", ""));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final void m245a(String str, String str2) {
        this.f24032a.edit().putString(str, str2).commit();
    }
}
