package com.cnlaunch.p169im.p179i;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import java.util.List;

/* renamed from: com.cnlaunch.im.i.b */
/* loaded from: classes.dex */
public class UserInfoCache {

    /* renamed from: b */
    private static UserInfoCache f9287b;

    /* renamed from: a */
    private SharedPreferences f9288a;

    /* renamed from: c */
    private Context f9289c;

    private UserInfoCache(Context context, boolean z) {
        this.f9288a = null;
        this.f9289c = context;
        this.f9288a = context.getSharedPreferences("USERINFO_NAME", 0);
        if (z) {
            m8712a(15);
        }
    }

    /* renamed from: a */
    public static UserInfoCache m8711a(Context context, boolean z) {
        if (f9287b == null) {
            synchronized (UserInfoCache.class) {
                if (f9287b == null) {
                    f9287b = new UserInfoCache(context, z);
                }
            }
        }
        return f9287b;
    }

    /* renamed from: a */
    public final void m8712a(int i) {
        List<FriendInfo> m8757a;
        SharedPreferences.Editor edit = this.f9288a.edit();
        if ((i & 8) == 8 && (m8757a = GoloDBManager.m8756a(this.f9289c).m8757a()) != null && m8757a.size() > 0) {
            for (FriendInfo friendInfo : m8757a) {
                edit.putString(friendInfo.getUser_id(), friendInfo.getName());
            }
        }
        edit.commit();
    }

    /* renamed from: a */
    public final String m8710a(String str) {
        return this.f9288a.getString(str, "");
    }

    /* renamed from: a */
    public final void m8709a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = this.f9288a.edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
