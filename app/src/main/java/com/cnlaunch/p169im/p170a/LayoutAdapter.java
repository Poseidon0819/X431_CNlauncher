package com.cnlaunch.p169im.p170a;

import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.PowerManager;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.p169im.p170a.FaceAdapter;
import com.cnlaunch.p169im.p173d.GoloHandler;
import com.cnlaunch.p169im.p176f.RecorderHelper;
import com.cnlaunch.p169im.p180j.SendMessageTask;
import com.cnlaunch.p169im.widget.ChatListView;
import com.cnlaunch.p169im.widget.ChatViewPager;
import com.cnlaunch.p169im.widget.InputText;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.regex.Pattern;
import message.model.ChatMessage;
import message.model.ChatRoom;
import message.model.MessageObj;
import message.p381d.MediaProvider;

/* renamed from: com.cnlaunch.im.a.n */
/* loaded from: classes.dex */
public final class LayoutAdapter {

    /* renamed from: g */
    public static boolean f8988g = false;

    /* renamed from: a */
    public Context f8989a;

    /* renamed from: b */
    public ChatRoom f8990b;

    /* renamed from: c */
    public Handler f8991c;

    /* renamed from: d */
    public Timer f8992d;

    /* renamed from: h */
    public ChatMessage f8995h;

    /* renamed from: i */
    public MediaPlayer f8996i;

    /* renamed from: p */
    private long f9003p;

    /* renamed from: q */
    private long f9004q;

    /* renamed from: u */
    private Dialog f9008u;

    /* renamed from: w */
    private ImageView f9010w;

    /* renamed from: x */
    private TextView f9011x;

    /* renamed from: y */
    private View f9012y;

    /* renamed from: z */
    private PowerManager.WakeLock f9013z;

    /* renamed from: m */
    private int f9000m = 0;

    /* renamed from: n */
    private int f9001n = 0;

    /* renamed from: o */
    private int f9002o = 0;

    /* renamed from: e */
    public boolean f8993e = false;

    /* renamed from: r */
    private int f9005r = 600;

    /* renamed from: s */
    private int f9006s = 300;

    /* renamed from: t */
    private Runnable f9007t = new RunnableC1688o(this);

    /* renamed from: f */
    public RecorderHelper f8994f = new RecorderHelper();

    /* renamed from: v */
    private View f9009v = null;

    /* renamed from: j */
    public boolean f8997j = false;

    /* renamed from: k */
    public MediaPlayer.OnCompletionListener f8998k = new C1691r(this);

    /* renamed from: l */
    MessageDialog f8999l = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ int m8892b(LayoutAdapter layoutAdapter) {
        int i = layoutAdapter.f9002o;
        layoutAdapter.f9002o = i + 1;
        return i;
    }

    public LayoutAdapter(Context context, ChatRoom chatRoom, Handler handler) {
        this.f8989a = context;
        this.f8990b = chatRoom;
        this.f8991c = handler;
    }

    /* renamed from: a */
    public static void m8900a(View view, GoloHandler goloHandler, ChatViewPager chatViewPager) {
        view.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        String[] stringArray = ApplicationConfig.f7802a.getResources().getStringArray(R.array.face_name);
        double m8907a = ChatPagerProvider.m8907a(R.string.face_page_num);
        int i = (int) m8907a;
        int m8906b = ChatPagerProvider.m8906b(R.integer.face_row_num);
        double length = stringArray.length;
        Double.isNaN(length);
        int ceil = (int) Math.ceil(length / m8907a);
        for (int i2 = 0; i2 < ceil; i2++) {
            GridView gridView = new GridView(ApplicationConfig.f7802a);
            gridView.setNumColumns(m8906b);
            gridView.setGravity(17);
            int i3 = i2 * i;
            gridView.setAdapter((ListAdapter) new FaceAdapter(ApplicationConfig.f7802a, goloHandler, FaceAdapter.EnumC1686a.yellow$1d664d25, i3, (i - 1) + i3));
            arrayList.add(gridView);
        }
        chatViewPager.setAdapter(new ChatPagerAdapter(arrayList));
    }

    /* renamed from: a */
    public static void m8899a(InputMethodManager inputMethodManager, InputText inputText) {
        inputMethodManager.hideSoftInputFromWindow(inputText.getWindowToken(), 2);
    }

    /* renamed from: a */
    public static void m8898a(InputMethodManager inputMethodManager, InputText inputText, ChatListView chatListView) {
        inputMethodManager.toggleSoftInputFromWindow(inputText.getWindowToken(), 1, 1);
        if (!inputText.hasFocus()) {
            inputText.requestFocus();
        }
        chatListView.setTranscriptMode(2);
    }

    /* renamed from: a */
    public static void m8896a(InputText inputText) {
        int selectionStart;
        Editable editableText = inputText.getEditableText();
        if (editableText == null || (selectionStart = inputText.getSelectionStart()) <= 0) {
            return;
        }
        if (selectionStart >= 6) {
            int i = selectionStart - 6;
            if (Pattern.compile("\\[@([0-9]{3})]").matcher(editableText.toString().substring(i, selectionStart)).find()) {
                editableText.delete(i, selectionStart);
                return;
            }
        }
        editableText.delete(selectionStart - 1, selectionStart);
    }

    /* renamed from: b */
    public static void m8893b(View view, GoloHandler goloHandler, ChatViewPager chatViewPager) {
        view.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        String[] stringArray = ApplicationConfig.f7802a.getResources().getStringArray(R.array.face_car_name);
        double m8907a = ChatPagerProvider.m8907a(R.string.face_page_num_car);
        int i = (int) m8907a;
        int m8906b = ChatPagerProvider.m8906b(R.integer.face_row_num_car);
        double length = stringArray.length;
        Double.isNaN(length);
        int ceil = (int) Math.ceil(length / m8907a);
        for (int i2 = 0; i2 < ceil; i2++) {
            GridView gridView = new GridView(ApplicationConfig.f7802a);
            gridView.setNumColumns(m8906b);
            gridView.setGravity(17);
            int i3 = i2 * i;
            gridView.setAdapter((ListAdapter) new FaceAdapter(ApplicationConfig.f7802a, goloHandler, FaceAdapter.EnumC1686a.car$1d664d25, i3, (i - 1) + i3));
            arrayList.add(gridView);
        }
        chatViewPager.setAdapter(new ChatPagerAdapter(arrayList));
    }

    /* renamed from: c */
    public static void m8891c(View view, GoloHandler goloHandler, ChatViewPager chatViewPager) {
        view.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        String[] stringArray = ApplicationConfig.f7802a.getResources().getStringArray(R.array.face_goose_name);
        double m8907a = ChatPagerProvider.m8907a(R.string.face_page_num_goose);
        int i = (int) m8907a;
        int m8906b = ChatPagerProvider.m8906b(R.integer.face_row_num_goose);
        double length = stringArray.length;
        Double.isNaN(length);
        int ceil = (int) Math.ceil(length / m8907a);
        for (int i2 = 0; i2 < ceil; i2++) {
            GridView gridView = new GridView(ApplicationConfig.f7802a);
            gridView.setNumColumns(m8906b);
            gridView.setGravity(17);
            int i3 = i2 * i;
            gridView.setAdapter((ListAdapter) new FaceAdapter(ApplicationConfig.f7802a, goloHandler, FaceAdapter.EnumC1686a.goose$1d664d25, i3, (i - 1) + i3));
            arrayList.add(gridView);
        }
        chatViewPager.setAdapter(new ChatPagerAdapter(arrayList));
    }

    /* renamed from: d */
    public static void m8889d(View view, GoloHandler goloHandler, ChatViewPager chatViewPager) {
        view.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        String[] stringArray = ApplicationConfig.f7802a.getResources().getStringArray(R.array.face_gay_name);
        double m8907a = ChatPagerProvider.m8907a(R.string.face_page_num_gay);
        int i = (int) m8907a;
        int m8906b = ChatPagerProvider.m8906b(R.integer.face_row_num_gay);
        double length = stringArray.length;
        Double.isNaN(length);
        int ceil = (int) Math.ceil(length / m8907a);
        for (int i2 = 0; i2 < ceil; i2++) {
            GridView gridView = new GridView(ApplicationConfig.f7802a);
            gridView.setNumColumns(m8906b);
            gridView.setGravity(17);
            int i3 = i2 * i;
            gridView.setAdapter((ListAdapter) new FaceAdapter(ApplicationConfig.f7802a, goloHandler, FaceAdapter.EnumC1686a.gay$1d664d25, i3, (i - 1) + i3));
            arrayList.add(gridView);
        }
        chatViewPager.setAdapter(new ChatPagerAdapter(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8902a() {
        if (!f8988g || this.f9010w == null) {
            return;
        }
        RecorderHelper recorderHelper = this.f8994f;
        int maxAmplitude = (recorderHelper.f9256a != 1 ? 0 : recorderHelper.f9261f.getMaxAmplitude()) / this.f9005r;
        switch ((maxAmplitude > 1 ? (int) (Math.log10(maxAmplitude) * 20.0d) : 0) / 4) {
            case 0:
                this.f9010w.setImageResource(R.drawable.audio_recorder_volume_0);
                break;
            case 1:
                this.f9010w.setImageResource(R.drawable.audio_recorder_volume_2);
                break;
            case 2:
                this.f9010w.setImageResource(R.drawable.audio_recorder_volume_3);
                break;
            case 3:
                this.f9010w.setImageResource(R.drawable.audio_recorder_volume_4);
                break;
            case 4:
                this.f9010w.setImageResource(R.drawable.audio_recorder_volume_5);
                break;
            case 5:
                this.f9010w.setImageResource(R.drawable.audio_recorder_volume_6);
                break;
            case 6:
                this.f9010w.setImageResource(R.drawable.audio_recorder_volume_7);
                break;
            case 7:
                this.f9010w.setImageResource(R.drawable.audio_recorder_volume_8);
                break;
            case 8:
                this.f9010w.setImageResource(R.drawable.audio_recorder_volume_9);
                break;
            case 9:
                this.f9010w.setImageResource(R.drawable.audio_recorder_volume_9);
                break;
            default:
                this.f9010w.setImageResource(R.drawable.audio_recorder_volume_5);
                break;
        }
        this.f8991c.postDelayed(this.f9007t, this.f9006s);
    }

    /* renamed from: a */
    public final void m8901a(MotionEvent motionEvent, ChatListView chatListView, View view) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f9001n = (int) motionEvent.getY();
                try {
                    m8894a(true, chatListView, view);
                    RecorderHelper recorderHelper = this.f8994f;
                    Context context = this.f8989a;
                    recorderHelper.f9260e = MediaProvider.m290a("/voice", String.valueOf(System.currentTimeMillis()));
                    if (recorderHelper.f9260e == null) {
                        Toast.makeText(context, context.getResources().getString(R.string.afternoon), 1000).show();
                    } else {
                        recorderHelper.f9261f = new MediaRecorder();
                        recorderHelper.f9261f.setAudioSource(1);
                        recorderHelper.f9261f.setOutputFormat(3);
                        recorderHelper.f9261f.setAudioEncoder(1);
                        recorderHelper.f9261f.setOutputFile(recorderHelper.f9260e.getPath());
                        try {
                            recorderHelper.f9261f.prepare();
                            try {
                                recorderHelper.f9261f.start();
                                recorderHelper.f9258c = System.currentTimeMillis();
                                recorderHelper.m8726a(1);
                            } catch (RuntimeException unused) {
                                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                                if (audioManager.getMode() != 2) {
                                    audioManager.getMode();
                                }
                                recorderHelper.f9261f.reset();
                                recorderHelper.f9261f.release();
                                recorderHelper.f9261f = null;
                            }
                        } catch (IOException unused2) {
                            recorderHelper.f9261f.reset();
                            recorderHelper.f9261f.release();
                            recorderHelper.f9261f = null;
                        }
                    }
                    this.f9003p = System.currentTimeMillis();
                    m8902a();
                    this.f9002o = 0;
                    C1689p c1689p = new C1689p(this);
                    this.f8992d = new Timer();
                    this.f8992d.schedule(c1689p, 1000L, 1000L);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 1:
            case 3:
                if (!this.f8993e) {
                    try {
                        m8894a(false, chatListView, view);
                        f8988g = false;
                        File m8727a = this.f8994f.m8727a();
                        this.f9004q = System.currentTimeMillis();
                        this.f8992d.cancel();
                        if (this.f9004q - this.f9003p < 1500) {
                            NToast.longToast(this.f8989a, (int) R.string.recordvoice_time_lower1);
                            if (m8727a.exists()) {
                                m8727a.delete();
                            }
                        } else {
                            ChatMessage m190a = this.f8990b.m190a(2);
                            m190a.m209b("path", (Object) m8727a.getPath());
                            m190a.m193o();
                            chatListView.setTranscriptMode(2);
                            new SendMessageTask().m256e(m190a);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                this.f8993e = false;
                return;
            case 2:
                this.f9000m = (int) motionEvent.getY();
                if (!f8988g || (-this.f9000m) - this.f9001n <= 30) {
                    return;
                }
                m8894a(false, chatListView, view);
                f8988g = false;
                this.f8992d.cancel();
                File m8727a2 = this.f8994f.m8727a();
                if (m8727a2.exists()) {
                    m8727a2.delete();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public final void m8894a(boolean z, ChatListView chatListView, View view) {
        if (view != null) {
            view.setActivated(z);
        }
        if (z) {
            if (this.f9008u == null) {
                this.f9008u = new Dialog(this.f8989a, R.style.dialog_normal);
                this.f9008u.getWindow().setType(SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED);
                this.f9008u.setCanceledOnTouchOutside(false);
                this.f9009v = LayoutInflater.from(this.f8989a).inflate(R.layout.aamsg_new_dialog_record, (ViewGroup) null);
                this.f9010w = (ImageView) this.f9009v.findViewById(R.id.dialog_record_mike);
                this.f9011x = (TextView) this.f9009v.findViewById(R.id.dialog_record_text);
                this.f9012y = this.f9009v.findViewById(R.id.dialog_record_cancle);
                this.f9013z = ((PowerManager) this.f8989a.getSystemService("power")).newWakeLock(6, "SoundRecorder");
                this.f8994f.f9257b = new C1690q(this);
                this.f9008u.setContentView(this.f9009v);
            }
            this.f9008u.show();
            f8988g = true;
            chatListView.setRecording(true);
            return;
        }
        Dialog dialog = this.f9008u;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f9008u.dismiss();
        chatListView.setRecording(false);
        f8988g = false;
        this.f9008u = null;
    }

    /* renamed from: a */
    public final boolean m8895a(MessageObj messageObj) {
        try {
            if (messageObj.f24085b == null || messageObj.f24085b.equals("")) {
                String string = this.f8989a.getSharedPreferences("mediaPath", 0).getString(messageObj.f24084a, null);
                if ((string == null || "".equals(string)) && FileUtils.m4994h("B") <= messageObj.f24089f) {
                    NToast.longToast(this.f8989a, (int) R.string.play_video_failed);
                    return false;
                }
                return true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
