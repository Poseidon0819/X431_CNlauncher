package com.cnlaunch.x431pro.activity.golo.function;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p165g.SignatureTool;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener;
import com.cnlaunch.x431pro.widget.CustomVideoView;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import message.model.MessageObj;

/* renamed from: com.cnlaunch.x431pro.activity.golo.function.g */
/* loaded from: classes.dex */
public final class VideoPlayFragment extends BaseFragment implements OnGoloKeyDownListener {

    /* renamed from: a */
    public static String f12661a = "mediaPath";

    /* renamed from: c */
    private SharedPreferences f12663c;

    /* renamed from: d */
    private CustomVideoView f12664d;

    /* renamed from: e */
    private ProgressBar f12665e;

    /* renamed from: f */
    private TextView f12666f;

    /* renamed from: g */
    private View f12667g;

    /* renamed from: h */
    private MessageObj f12668h;

    /* renamed from: b */
    private MediaController f12662b = null;

    /* renamed from: i */
    private final int f12669i = 1;

    /* renamed from: j */
    private final int f12670j = 2;

    /* renamed from: k */
    private final int f12671k = 3;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: l */
    private Handler f12672l = new HandlerC2242i(this);

    /* renamed from: m */
    private String f12673m = "";

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getBundle() != null) {
            this.f12668h = (MessageObj) getBundle().getParcelable("MEDIA");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12664d = (CustomVideoView) getActivity().findViewById(R.id.videoview);
        this.f12662b = new MediaController(getActivity());
        this.f12664d.setMediaController(this.f12662b);
        this.f12664d.setOnPreparedListener(new C2241h(this));
        this.f12667g = getActivity().findViewById(R.id.view_pb);
        this.f12665e = (ProgressBar) getActivity().findViewById(R.id.download_progress);
        this.f12666f = (TextView) getActivity().findViewById(R.id.download_progress_text);
        MessageObj messageObj = this.f12668h;
        if (messageObj == null) {
            Log.e("Sanda", "MesObj could not be Null!");
        } else if (messageObj.f24085b != null && !this.f12668h.f24085b.equals("")) {
            this.f12673m = this.f12668h.f24085b;
            m6978a();
        } else {
            this.f12663c = getActivity().getSharedPreferences(f12661a, 0);
            String string = this.f12663c.getString(this.f12668h.f24084a, null);
            if (string == null || "".equals(string)) {
                request(40019);
                return;
            }
            this.f12673m = string;
            m6978a();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i != 40019) {
            return super.doInBackground(i);
        }
        String str = this.f12668h.f24084a;
        return Boolean.valueOf(m6975a(str, Environment.getExternalStorageDirectory().getPath() + "/cnlaunch/golo3/" + ApplicationConfig.m9181a() + "/file"));
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_play, (ViewGroup) null);
    }

    /* renamed from: a */
    private boolean m6975a(String str, String str2) {
        this.f12672l.obtainMessage(1).sendToTarget();
        try {
            String str3 = str2 + "/" + SignatureTool.m9124a(str);
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.connect();
            InputStream inputStream = openConnection.getInputStream();
            int i = this.f12668h.f24089f;
            if (i <= 0) {
                throw new RuntimeException("size not know");
            }
            if (inputStream == null) {
                throw new RuntimeException("stream is null");
            }
            File file = new File(str3);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str3);
            byte[] bArr = new byte[1024];
            int i2 = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                    i2 += read;
                    this.f12672l.obtainMessage(2, i, i2).sendToTarget();
                } else {
                    this.f12672l.obtainMessage(3, str3).sendToTarget();
                    fileOutputStream.close();
                    inputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            Log.e("Sanda", "error: " + e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6978a() {
        try {
            this.f12664d.setVideoURI(Uri.parse(this.f12673m));
            this.f12664d.start();
        } catch (Exception e) {
            Log.i("Sanda", "play:" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (this.f12667g.getVisibility() == 0) {
                    cancelRequest(40019);
                    File file = new File(this.f12673m);
                    if (file.exists()) {
                        file.delete();
                        return false;
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                Log.e("Sanda", "onKeyDown:" + e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f12664d.setVideoScale(point);
        this.f12664d.getHolder().setFixedSize(point.x, point.y);
        super.onConfigurationChanged(configuration);
    }
}
