package com.cnlaunch.golo3.p160b;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.cnlaunch.golo3.p162d.InterfaceTable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.golo3.b.e */
/* loaded from: classes.dex */
public class InterfaceDao {

    /* renamed from: a */
    public InterfaceTable f8398a = new InterfaceTable();

    /* renamed from: a */
    public final String m9172a(String str) {
        return this.f8398a.m9166a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m9173a(InterfaceDao interfaceDao, JSONObject jSONObject, Long l) throws Exception {
        if (jSONObject != null) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("urls");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getJSONObject(i));
            }
            arrayList.add(new JSONObject().put("key", InterfaceConfig.f7961c).put("value", jSONObject.getString("area")));
            arrayList.add(new JSONObject().put("key", InterfaceConfig.f7908b).put("value", jSONObject.getString("version")));
            try {
                InterfaceTable interfaceTable = interfaceDao.f8398a;
                interfaceTable.f8432b = interfaceTable.f8431a.getWritableDatabase();
                interfaceTable.f8432b.delete("interface_TB", null, null);
                interfaceDao.f8398a.m9165a(arrayList);
            } catch (Exception unused) {
            }
            ApplicationConfig.f7809h = interfaceDao.f8398a.m9166a(InterfaceConfig.f8014d);
            ApplicationConfig.f7810i = interfaceDao.f8398a.m9166a(InterfaceConfig.f8067e);
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(ApplicationConfig.f7802a).edit();
            edit.putLong("stamptime", l.longValue());
            edit.commit();
        }
    }
}
