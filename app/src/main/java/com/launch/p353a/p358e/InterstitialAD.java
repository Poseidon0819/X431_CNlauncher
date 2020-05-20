package com.launch.p353a.p358e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.mapapi.UIMsg;
import com.launch.p353a.p361h.RunnableC3663d;
import com.launch.p353a.p364k.AdError;
import com.launch.p353a.p364k.LUAsdk;
import com.launch.p353a.p364k.StringUtil;
import com.launch.p353a.p364k.UrlUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.launch.a.e.c */
/* loaded from: classes.dex */
public final class InterstitialAD {

    /* renamed from: a */
    public AbstractInterstitialADListener f19887a;

    /* renamed from: b */
    Activity f19888b;

    /* renamed from: c */
    JSONArray f19889c;

    /* renamed from: d */
    int f19890d;

    /* renamed from: e */
    Handler f19891e;

    /* renamed from: f */
    private String f19892f;

    /* renamed from: g */
    private String f19893g;

    public InterstitialAD(Activity activity, String str) {
        this(activity, str, (byte) 0);
    }

    @SuppressLint({"MissingPermission"})
    private InterstitialAD(Activity activity, String str, byte b) {
        this.f19890d = 0;
        this.f19891e = new HandlerC3641d(this, Looper.getMainLooper());
        this.f19888b = activity;
        if (!StringUtil.m2629a(str) && activity != null && !StringUtil.m2629a(LUAsdk.f19966a)) {
            this.f19892f = str;
            this.f19893g = null;
            if (LUAsdk.f19967b == null) {
                new Thread(new RunnableC3646i(this)).start();
                return;
            } else if (LUAsdk.f19967b.equals("")) {
                new Thread(new RunnableC3647j(this)).start();
                return;
            } else {
                m2692b();
                return;
            }
        }
        m2695a(this.f19887a);
        Log.e("error::", String.format("SplashAD Constructor params error, appid=%s,posId=%s,context=%s", LUAsdk.f19966a, str, activity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m2695a(AbstractInterstitialADListener abstractInterstitialADListener) {
        if (abstractInterstitialADListener != null) {
            new AdError();
            abstractInterstitialADListener.mo2690b();
        }
    }

    /* renamed from: a */
    public final void m2693a(String str, String str2) {
        new Thread(new RunnableC3645h(this, str, str2)).start();
    }

    /* renamed from: a */
    public final String m2694a(String str) {
        return this.f19888b.getSharedPreferences("Lau", 0).getString(str, "");
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    private void m2692b() {
        RunnableC3663d runnableC3663d = new RunnableC3663d(this.f19888b);
        runnableC3663d.f19880c = UrlUtils.m2628a(this.f19888b, this.f19892f, this.f19893g);
        runnableC3663d.f19879b = "GET";
        runnableC3663d.f19882e = UIMsg.m_AppUI.MSG_APP_GPS;
        runnableC3663d.f19959f = new C3648k(this);
        runnableC3663d.m2655a();
    }

    /* renamed from: a */
    public final void m2696a() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://pv.sohu.com/cityjson?ie=utf-8").openConnection();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine + "\n");
                }
                inputStream.close();
                try {
                    String string = new JSONObject(sb.toString().replace("var returnCitySN = ", "")).getString("cip");
                    if (string != null) {
                        LUAsdk.f19967b = string;
                    } else {
                        LUAsdk.f19967b = "";
                    }
                    m2692b();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
