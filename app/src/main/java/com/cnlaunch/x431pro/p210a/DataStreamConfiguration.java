package com.cnlaunch.x431pro.p210a;

import android.content.Context;
import android.util.Log;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.JsonUtils;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.ifoer.expedition.pro.R;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.a.i */
/* loaded from: classes.dex */
public final class DataStreamConfiguration {

    /* renamed from: a */
    public static int f10575a = 5;

    /* renamed from: b */
    public static int f10576b = 35;

    /* renamed from: c */
    public static int f10577c = 3;

    /* renamed from: d */
    public static int f10578d = 5;

    /* renamed from: e */
    public static int f10579e = 15;

    /* renamed from: f */
    public static boolean f10580f = false;

    /* renamed from: g */
    private static int f10581g = 15;

    /* renamed from: a */
    public static int m7960a() {
        return f10575a;
    }

    /* renamed from: b */
    public static int m7957b() {
        return f10576b;
    }

    /* renamed from: c */
    public static int m7956c() {
        return f10577c;
    }

    /* renamed from: d */
    public static int m7955d() {
        return f10581g;
    }

    /* renamed from: e */
    public static int m7954e() {
        return f10578d;
    }

    /* renamed from: a */
    public static void m7959a(Context context) {
        DiagnoseConstants.setDataStreamPageNum(context.getResources().getInteger(R.integer.datastream_page_num));
        f10575a = context.getResources().getInteger(R.integer.datastream_textlist_num);
        f10576b = context.getResources().getInteger(R.integer.datastream_page_maxnum);
        f10577c = context.getResources().getInteger(R.integer.datastream_page_count);
        f10581g = context.getResources().getInteger(R.integer.graph_page_num);
        f10578d = context.getResources().getInteger(R.integer.graphgridItemColumnNum);
        f10579e = context.getResources().getInteger(R.integer.graph_combined_big_pagenum);
    }

    /* renamed from: f */
    public static void m7953f() {
        DiagnoseConstants.setDataStreamPageNum(15);
        f10575a = 5;
        f10576b = 35;
        f10577c = 3;
        f10581g = 15;
        f10578d = 5;
        f10579e = 15;
    }

    /* renamed from: g */
    public static String m7952g() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("PageItemCount", f10575a);
            jSONObject.put("MaxPageCount", f10576b);
            jSONObject.put("BigPage", f10577c);
            jSONObject.put("graphPageNum", f10581g);
            jSONObject.put("graphColumnNum", f10578d);
            jSONObject.put("combinedBigPageNum", f10579e);
            jSONObject.put("DataStreamPageNum", DiagnoseConstants.DATASTREAM_PAGE);
            return JsonUtils.specialRemoteConfigJson(jSONObject, DiagnoseConstants.DATASTREAM_PAGE);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.i("Sanda", "getJsonConfig=" + e.toString());
            return null;
        }
    }

    /* renamed from: h */
    public static String m7951h() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isFunctionBack", PathUtils.m4866a(DiagnoseConstants.DIAGNOSE_LIB_PATH));
            return JsonUtils.specialRemoteConfigJsonUser(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.i("Sanda", "getJsonConfig=" + e.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static void m7958a(String str) {
        try {
            f10580f = new JSONObject(str).getBoolean("isFunctionBack");
        } catch (Exception unused) {
        }
    }
}
