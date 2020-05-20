package com.cnlaunch.p169im;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p165g.C1622y;
import com.cnlaunch.golo3.p165g.GoloActivityManager;
import com.cnlaunch.golo3.p165g.SignatureTool;
import com.cnlaunch.p120d.p130d.NToast;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import message.model.MessageObj;

/* renamed from: com.cnlaunch.im.ShowVideoActivity */
/* loaded from: classes.dex */
public class ShowVideoActivity extends Activity implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, SurfaceHolder.Callback, View.OnClickListener {

    /* renamed from: a */
    public static String f8890a = "mediaPath";

    /* renamed from: h */
    private ProgressDialog f8897h;

    /* renamed from: i */
    private ProgressDialog f8898i;

    /* renamed from: j */
    private MessageObj f8899j;

    /* renamed from: k */
    private Context f8900k;

    /* renamed from: l */
    private ImageView f8901l;

    /* renamed from: m */
    private SharedPreferences f8902m;

    /* renamed from: o */
    private String f8904o;

    /* renamed from: q */
    private boolean f8906q;

    /* renamed from: b */
    private int f8891b = 0;

    /* renamed from: c */
    private int f8892c = 0;

    /* renamed from: d */
    private MediaPlayer f8893d = null;

    /* renamed from: e */
    private SurfaceView f8894e = null;

    /* renamed from: f */
    private SurfaceHolder f8895f = null;

    /* renamed from: g */
    private String f8896g = "";

    /* renamed from: n */
    private boolean f8903n = false;

    /* renamed from: p */
    private boolean f8905p = false;

    /* renamed from: r */
    private Handler f8907r = new HandlerC1757q(this);

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m8942a(ShowVideoActivity showVideoActivity) {
        showVideoActivity.f8903n = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static /* synthetic */ boolean m8926l(ShowVideoActivity showVideoActivity) {
        showVideoActivity.f8905p = true;
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aamsg_im_message_video);
        this.f8900k = this;
        this.f8899j = (MessageObj) getIntent().getBundleExtra("BUNDLE").getParcelable("MEDIA");
        this.f8906q = getIntent().getBundleExtra("BUNDLE").getBoolean("ispublic");
        this.f8897h = new ProgressDialog(this);
        this.f8898i = new ProgressDialog(this);
        this.f8898i.setOnCancelListener(new DialogInterface$OnCancelListenerC1755o(this));
        this.f8901l = (ImageView) findViewById(R.id.recordPlayIv);
        if (this.f8899j.f24085b != null && !this.f8899j.f24085b.equals("")) {
            this.f8896g = this.f8899j.f24085b;
            m8936c();
            Log.d("Sanda", "initSurface");
            return;
        }
        this.f8902m = getSharedPreferences(f8890a, 0);
        String string = this.f8902m.getString(this.f8899j.f24084a, null);
        if (string == null || "".equals(string)) {
            this.f8901l.setVisibility(0);
            m8943a();
            Log.d("Sanda", "download");
            return;
        }
        this.f8896g = string;
        Log.d("Sanda", "initSurface");
        m8936c();
    }

    /* renamed from: a */
    private void m8943a() {
        this.f8903n = true;
        if (C1622y.m9112a(this)) {
            new C1756p(this).start();
        } else {
            NToast.m9447b(this.f8900k, (int) R.string.common_network_error);
        }
    }

    public void playVideo(View view) {
        Log.d("Sanda", "playVideo");
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/cnlaunch/golo3/" + ApplicationConfig.m9181a() + "/file/" + SignatureTool.m9124a(this.f8899j.f24084a));
            if (file.exists() || file.isFile()) {
                if (this.f8903n) {
                    return;
                }
                if (this.f8894e != null) {
                    this.f8894e.setBackgroundDrawable(null);
                }
                this.f8901l.setVisibility(8);
                m8938b();
                return;
            }
            if (this.f8899j.f24085b != null && !this.f8899j.f24085b.equals("")) {
                this.f8896g = this.f8899j.f24085b;
                if (this.f8894e != null) {
                    this.f8894e.setBackgroundDrawable(null);
                }
                this.f8901l.setVisibility(8);
                m8938b();
            }
            if (this.f8903n || !this.f8905p) {
                return;
            }
            this.f8903n = true;
            this.f8905p = false;
            m8943a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m8938b() {
        Log.d("Sanda", "play()");
        try {
            this.f8893d = new MediaPlayer();
            this.f8893d.setDataSource(this.f8896g);
            this.f8893d.setAudioStreamType(3);
            this.f8893d.setDisplay(this.f8895f);
            this.f8893d.prepare();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8893d.getDuration());
            Log.i("Sanda", sb.toString());
            this.f8893d.setOnBufferingUpdateListener(this);
            this.f8893d.setOnCompletionListener(this);
            this.f8893d.setOnPreparedListener(this);
        } catch (Exception unused) {
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        Log.i("TAG-onBufferingUpdate", i + "|" + this.f8893d.getCurrentPosition());
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f8901l.setVisibility(0);
        Log.i("Sanda", "Completion");
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(m8939a(this.f8896g));
        SurfaceView surfaceView = this.f8894e;
        if (surfaceView != null) {
            surfaceView.setBackgroundDrawable(bitmapDrawable);
        }
        this.f8901l.setVisibility(0);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        int i;
        Log.i("Sanda", "onPrepared");
        this.f8891b = this.f8893d.getVideoWidth();
        this.f8892c = this.f8893d.getVideoHeight();
        int i2 = this.f8891b;
        if (i2 == 0 || (i = this.f8892c) == 0) {
            return;
        }
        this.f8895f.setFixedSize(i2, i);
        this.f8893d.start();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8893d.getDuration());
        Log.i("Sanda", sb.toString());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Log.d("Sanda", "surfaceChanged");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.d("Sanda", "surfaceCreated");
        this.f8895f = surfaceHolder;
        if (this.f8901l.getVisibility() != 0) {
            m8938b();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.i("TAG-surfaceDestroyed", "surfaceDestroyed");
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f8894e = null;
        this.f8903n = false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.f8903n = false;
            GoloActivityManager.m9138a();
            GoloActivityManager.m9135b(this);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8936c() {
        this.f8894e = (SurfaceView) ((Activity) this.f8900k).findViewById(R.id.surfaceview);
        this.f8895f = this.f8894e.getHolder();
        this.f8895f.addCallback((ShowVideoActivity) this.f8900k);
        this.f8895f.setType(3);
    }

    /* renamed from: a */
    public static Bitmap m8939a(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(((Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) * 1000) * 31) / 160);
                try {
                    mediaMetadataRetriever.release();
                    return frameAtTime;
                } catch (RuntimeException unused) {
                    return frameAtTime;
                }
            } catch (IllegalArgumentException | RuntimeException unused2) {
                mediaMetadataRetriever.release();
                return null;
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException unused3) {
                }
                throw th;
            }
        } catch (RuntimeException unused4) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m8940a(ShowVideoActivity showVideoActivity, String str, String str2, Handler handler) throws IOException {
        try {
            String m9124a = SignatureTool.m9124a(str);
            showVideoActivity.f8904o = str2 + "/" + m9124a;
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.connect();
            InputStream inputStream = openConnection.getInputStream();
            int i = showVideoActivity.f8899j.f24089f;
            if (i <= 0) {
                throw new RuntimeException("size not know");
            }
            if (inputStream == null) {
                throw new RuntimeException("stream is null");
            }
            File file = new File(str2 + "/" + m9124a);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str2 + "/" + m9124a);
            byte[] bArr = new byte[1024];
            Message message2 = new Message();
            if (showVideoActivity.f8903n) {
                message2.what = 0;
                message2.arg1 = i;
                handler.sendMessage(message2);
            }
            int i2 = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                } else if (!showVideoActivity.f8903n) {
                    handler.sendEmptyMessage(16);
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, read);
                    i2 += read;
                    Message message3 = new Message();
                    message3.what = 1;
                    message3.arg1 = i;
                    message3.arg2 = i2;
                    handler.sendMessage(message3);
                }
            }
            Log.d("Sanda", "downing=" + showVideoActivity.f8903n);
            if (showVideoActivity.f8903n) {
                Message message4 = new Message();
                message4.what = 2;
                message4.obj = str2 + "/" + m9124a;
                handler.sendMessage(message4);
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (Exception e) {
            Log.e("Sanda", "error: " + e.toString());
            NToast.m9447b(showVideoActivity.f8900k, (int) R.string.common_network_error);
        }
    }
}
