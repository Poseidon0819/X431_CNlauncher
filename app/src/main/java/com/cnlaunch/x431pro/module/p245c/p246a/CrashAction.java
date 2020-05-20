package com.cnlaunch.x431pro.module.p245c.p246a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.itextpdf.text.Annotation;
import java.io.File;
import java.io.FileNotFoundException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.module.c.a.a */
/* loaded from: classes.dex */
public final class CrashAction extends BaseAction {
    public CrashAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final boolean m5425a(File file) throws C1425f, FileNotFoundException {
        String b = m5451b(KeyConstant.f6779F);
        this.f15440b = m5452b();
        this.f15440b.m9508a(Annotation.FILE, file, "");
        String m9475b = this.f15446f.m9475b(m5450b(b, this.f15440b), this.f15440b);
        boolean z = false;
        if (!TextUtils.isEmpty(m9475b)) {
            try {
                if (new JSONObject(m9475b).getInt("code") == 0) {
                    z = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.i("CrashAction", "result:" + z + ",json:" + m9475b);
        return z;
    }
}
