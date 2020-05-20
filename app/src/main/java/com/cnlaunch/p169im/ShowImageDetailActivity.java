package com.cnlaunch.p169im;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.p012v4.view.PagerAdapter;
import android.support.p012v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.golo3.p154a.C1551a;
import com.cnlaunch.golo3.p154a.p155a.AbstractC1561d;
import com.cnlaunch.golo3.p154a.p156b.C1580e;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p165g.GoloActivityManager;
import com.cnlaunch.golo3.p165g.SignatureTool;
import com.cnlaunch.golo3.p165g.ThreadPoolManager;
import com.cnlaunch.p169im.p172c.ProMessageFragment;
import com.cnlaunch.p169im.p180j.SendMessageTask;
import com.cnlaunch.p169im.widget.ImageTouchView;
import com.cnlaunch.p169im.widget.RoundProgressView;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import message.model.ChatMessage;
import message.model.ChatRoom;
import message.model.MessageObj;
import message.p378a.MessageParameters;
import message.p383f.RunnableC4744l;
import message.p383f.SendTask;
import message.p384g.LogUtilMsg;
import message.p384g.MessageThreadPoolManager;

/* renamed from: com.cnlaunch.im.ShowImageDetailActivity */
/* loaded from: classes.dex */
public class ShowImageDetailActivity extends Activity {

    /* renamed from: d */
    public static final String f8867d = Environment.getExternalStorageDirectory() + "/cnlaunch/";

    /* renamed from: a */
    int f8868a;

    /* renamed from: c */
    String f8870c;

    /* renamed from: e */
    Context f8871e;

    /* renamed from: h */
    private ViewPager f8874h;

    /* renamed from: i */
    private C1675b f8875i;

    /* renamed from: j */
    private List<View> f8876j;

    /* renamed from: k */
    private RoundProgressView f8877k;

    /* renamed from: l */
    private int f8878l;

    /* renamed from: m */
    private ProgressBar f8879m;

    /* renamed from: n */
    private String f8880n;

    /* renamed from: o */
    private String f8881o;

    /* renamed from: p */
    private C1551a f8882p;

    /* renamed from: q */
    private C1580e f8883q;

    /* renamed from: r */
    private TextView f8884r;

    /* renamed from: b */
    List<MessageObj> f8869b = new ArrayList();

    /* renamed from: s */
    private SendTask.InterfaceC4739a f8885s = new C1745j(this);

    /* renamed from: f */
    SharedPreferences f8872f = null;

    /* renamed from: g */
    Handler f8873g = new HandlerC1754n(this);

    /* renamed from: t */
    private BitmapFactory.Options f8886t = new BitmapFactory.Options();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.show_image_detail);
        this.f8871e = this;
        this.f8874h = (ViewPager) findViewById(R.id.share_image_detail_info);
        this.f8879m = (ProgressBar) findViewById(R.id.download_progressbar);
        this.f8877k = (RoundProgressView) findViewById(R.id.round_progress_view);
        this.f8884r = (TextView) findViewById(R.id.btn_download);
        this.f8884r.setOnClickListener(new View$OnClickListenerC1743h(this));
        this.f8882p = new C1551a(this.f8871e);
        this.f8883q = GoloApplication.m8922c();
        this.f8883q.f7745f = null;
        this.f8868a = getIntent().getIntExtra("IMAGEPOSITION", -1);
        ArrayList arrayList = (ArrayList) getIntent().getSerializableExtra("BUNDLE");
        for (int i = 0; i < arrayList.size(); i++) {
            this.f8869b.add(arrayList.get(i));
        }
        this.f8876j = new ArrayList();
        for (int i2 = 0; i2 < this.f8869b.size(); i2++) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.aamsg_msg_filper_item_show, (ViewGroup) null);
            ImageTouchView imageTouchView = (ImageTouchView) inflate.findViewById(R.id.large_image);
            ((ImageTouchView) inflate.findViewById(R.id.origin_image)).setOnImageTouchListener(new C1744i(this));
            this.f8876j.add(inflate);
            if (this.f8868a == i2 && this.f8869b.get(i2).f24086c == null) {
                if (this.f8872f == null) {
                    this.f8872f = getSharedPreferences("messageImage", 0);
                }
                if (this.f8872f.getString(this.f8869b.get(i2).f24084a, null) == null) {
                    String str = this.f8869b.get(i2).f24085b;
                    if (str != null && !"".equals(str)) {
                        imageTouchView.setVisibility(8);
                    } else {
                        this.f8882p.m9255a(imageTouchView, this.f8869b.get(i2).f24087d, this.f8883q);
                    }
                }
            }
        }
        if (this.f8869b != null) {
            m8957a(this.f8868a);
        }
        this.f8875i = new C1675b(this.f8876j);
        this.f8874h.setAdapter(this.f8875i);
        this.f8874h.setCurrentItem(this.f8868a);
        this.f8874h.setOnPageChangeListener(new C1674a());
    }

    /* renamed from: com.cnlaunch.im.ShowImageDetailActivity$b */
    /* loaded from: classes.dex */
    public class C1675b extends PagerAdapter {

        /* renamed from: a */
        public List<View> f8888a;

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final boolean mo1770a(View view, Object obj) {
            return view == obj;
        }

        public C1675b(List<View> list) {
            this.f8888a = list;
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final void mo7523a(View view, int i, Object obj) {
            ((ViewPager) view).removeView(this.f8888a.get(i));
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final int mo1771a() {
            return this.f8888a.size();
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final Object mo7524a(View view, int i) {
            ((ViewPager) view).addView(this.f8888a.get(i), 0);
            return this.f8888a.get(i);
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final void mo1768a(ViewGroup viewGroup, int i, Object obj) {
            super.mo1768a(viewGroup, i, obj);
            ((ViewPager) viewGroup).removeView((View) obj);
        }
    }

    /* renamed from: com.cnlaunch.im.ShowImageDetailActivity$a */
    /* loaded from: classes.dex */
    public class C1674a implements ViewPager.InterfaceC0176e {
        @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
        /* renamed from: a */
        public final void mo1773a(int i, float f, int i2) {
        }

        @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
        /* renamed from: a_ */
        public final void mo1772a_(int i) {
        }

        public C1674a() {
        }

        @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
        /* renamed from: a */
        public final void mo1774a(int i) {
            ShowImageDetailActivity.this.f8868a = i;
            ShowImageDetailActivity showImageDetailActivity = ShowImageDetailActivity.this;
            if (showImageDetailActivity.f8872f == null) {
                showImageDetailActivity.f8872f = showImageDetailActivity.getSharedPreferences("messageImage", 0);
            }
            showImageDetailActivity.m8957a(i);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 15 || intent == null || "".equals(intent)) {
            return;
        }
        String stringExtra = intent.getStringExtra("ids");
        String stringExtra2 = intent.getStringExtra("names");
        String[] split = stringExtra.split(",");
        String str = stringExtra2.split(",")[0];
        if (split.length == 1) {
            ChatRoom chatRoom = new ChatRoom(split[0], str, MessageParameters.EnumC4721a.single);
            ChatMessage m190a = chatRoom.m190a(3);
            m190a.m209b("path", (Object) this.f8870c);
            m190a.m209b("thumbPath", (Object) this.f8870c);
            m190a.m214a(Annotation.URL, (Object) this.f8880n);
            m190a.m214a("thumb", (Object) this.f8881o);
            Intent intent2 = new Intent();
            intent2.putExtra("ChatRoom", chatRoom);
            intent2.putExtra("forward", m190a);
            intent2.setClass(this, ProMessageFragment.class);
            startActivity(intent2);
            GoloActivityManager.m9138a();
            if (GoloActivityManager.f8472a.isEmpty()) {
                return;
            }
            GoloActivityManager.m9135b(GoloActivityManager.f8472a.lastElement());
        } else if (split.length > 1) {
            ChatMessage m190a2 = new ChatRoom(split[0], str, MessageParameters.EnumC4721a.single).m190a(3);
            m190a2.m209b("path", (Object) this.f8870c);
            m190a2.m209b("thumbPath", (Object) this.f8870c);
            m190a2.m214a(Annotation.URL, (Object) this.f8880n);
            m190a2.m214a("thumb", (Object) this.f8881o);
            MessageThreadPoolManager.m225a(SendTask.class.getName()).m226a(new RunnableC4744l(new SendMessageTask(), stringExtra, m190a2, this.f8885s));
        }
    }

    /* renamed from: a */
    public final void m8957a(int i) {
        String str = this.f8869b.get(i).f24086c;
        if (str == null || "".equals(str)) {
            if (this.f8872f == null) {
                this.f8872f = getSharedPreferences("messageImage", 0);
            }
            String string = this.f8872f.getString(this.f8869b.get(i).f24084a, null);
            if (string == null) {
                ImageTouchView imageTouchView = (ImageTouchView) this.f8876j.get(i).findViewById(R.id.large_image);
                if (imageTouchView != null) {
                    imageTouchView.setVisibility(0);
                    this.f8881o = this.f8869b.get(i).f24087d;
                    this.f8882p.m9255a(imageTouchView, this.f8881o, this.f8883q);
                }
                this.f8877k.setVisibility(0);
                this.f8879m.setVisibility(8);
                LogUtilMsg.m227a("showImage", this.f8869b.get(i).f24084a);
                ThreadPoolManager.m9119a(ShowImageDetailActivity.class.getName()).m9120a(new RunnableC1753m(this, i));
                return;
            }
            View view = this.f8876j.get(i);
            ImageTouchView imageTouchView2 = (ImageTouchView) view.findViewById(R.id.origin_image);
            ((ImageTouchView) view.findViewById(R.id.large_image)).setVisibility(8);
            imageTouchView2.setVisibility(0);
            this.f8870c = string;
            this.f8880n = this.f8869b.get(i).f24084a;
            this.f8881o = this.f8869b.get(i).f24087d;
            this.f8882p.m9255a(imageTouchView2, string, this.f8883q);
            return;
        }
        View view2 = this.f8876j.get(i);
        ImageTouchView imageTouchView3 = (ImageTouchView) view2.findViewById(R.id.origin_image);
        ((ImageTouchView) view2.findViewById(R.id.large_image)).setVisibility(8);
        imageTouchView3.setVisibility(0);
        this.f8870c = str;
        this.f8880n = this.f8869b.get(i).f24084a;
        this.f8881o = this.f8869b.get(i).f24087d;
        this.f8882p.m9255a(imageTouchView3, str, this.f8883q);
    }

    /* renamed from: a */
    public final String m8953a(String str) {
        int read;
        if (str == null || str.equals("")) {
            return null;
        }
        String[] split = str.split("/");
        try {
            String str2 = f8867d + ApplicationConfig.m9181a() + "/share/image/";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str3 = str2 + SignatureTool.m9124a(split[split.length - 1]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(UIMsg.m_AppUI.MSG_APP_GPS);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            int contentLength = httpURLConnection.getContentLength();
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            do {
                read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                i += read;
                this.f8878l = (int) ((i / contentLength) * 100.0f);
                this.f8873g.sendEmptyMessage(11);
            } while (read > 0);
            Bitmap m8952a = m8952a(byteArrayOutputStream.toByteArray());
            File file2 = new File(str3);
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (m8952a != null) {
                m8952a.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                m8952a.recycle();
                System.gc();
            }
            httpURLConnection.disconnect();
            inputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            this.f8878l = 100;
            if (str != null && str3 != null) {
                this.f8871e.getSharedPreferences("sharedImage", 0).edit().putString(str, str3).commit();
            }
            this.f8873g.sendEmptyMessage(12);
            inputStream.close();
            return str3;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        new C1551a.C1554c(this.f8882p, (byte) 0).m9239a(AbstractC1561d.f7707e, 1);
        super.onDestroy();
    }

    /* renamed from: a */
    private Bitmap m8952a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (this.f8886t.inSampleSize == 0) {
                this.f8886t.inSampleSize = 1;
            } else {
                this.f8886t.inSampleSize *= 2;
            }
            this.f8886t.inJustDecodeBounds = false;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, this.f8886t);
            this.f8886t.inSampleSize = 0;
            return decodeByteArray;
        } catch (OutOfMemoryError unused) {
            m8952a(bArr);
            return null;
        }
    }
}
