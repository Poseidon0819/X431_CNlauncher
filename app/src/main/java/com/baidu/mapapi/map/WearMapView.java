package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.commonutils.C1190a;
import com.baidu.mapsdkplatform.comapi.map.C1215i;
import com.baidu.mapsdkplatform.comapi.map.C1236z;
import com.baidu.mapsdkplatform.comapi.map.GestureDetector$OnDoubleTapListenerC1216j;
import com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k;
import com.baidu.mapsdkplatform.comapi.map.View$OnTouchListenerC1204H;
import com.cnlaunch.translate.TranslateManager;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentParser;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.opengles.GL10;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

@TargetApi(20)
/* loaded from: classes.dex */
public class WearMapView extends ViewGroup implements View.OnApplyWindowInsetsListener {
    public static final int BT_INVIEW = 1;

    /* renamed from: c */
    private static String f5348c;

    /* renamed from: w */
    private static final SparseArray<Integer> f5353w;

    /* renamed from: A */
    private InterfaceC1219k f5354A;

    /* renamed from: B */
    private int f5355B;

    /* renamed from: C */
    private int f5356C;

    /* renamed from: D */
    private int f5357D;

    /* renamed from: E */
    private int f5358E;

    /* renamed from: F */
    private int f5359F;

    /* renamed from: G */
    private int f5360G;

    /* renamed from: a */
    ScreenShape f5361a;

    /* renamed from: e */
    private GestureDetector$OnDoubleTapListenerC1216j f5362e;

    /* renamed from: f */
    private BaiduMap f5363f;

    /* renamed from: g */
    private ImageView f5364g;

    /* renamed from: h */
    private Bitmap f5365h;

    /* renamed from: i */
    private View$OnTouchListenerC1204H f5366i;

    /* renamed from: j */
    private boolean f5367j;

    /* renamed from: k */
    private Point f5368k;

    /* renamed from: l */
    private Point f5369l;

    /* renamed from: m */
    private RelativeLayout f5370m;
    public AnimationTask mTask;
    public Timer mTimer;
    public HandlerC1089a mTimerHandler;

    /* renamed from: n */
    private SwipeDismissView f5371n;

    /* renamed from: o */
    private TextView f5372o;

    /* renamed from: p */
    private TextView f5373p;

    /* renamed from: q */
    private ImageView f5374q;

    /* renamed from: u */
    private boolean f5375u;

    /* renamed from: v */
    private Context f5376v;

    /* renamed from: x */
    private boolean f5377x;

    /* renamed from: y */
    private boolean f5378y;

    /* renamed from: z */
    private float f5379z;

    /* renamed from: b */
    private static final String f5347b = MapView.class.getSimpleName();

    /* renamed from: d */
    private static int f5349d = 0;

    /* renamed from: r */
    private static int f5350r = 0;

    /* renamed from: s */
    private static int f5351s = 0;

    /* renamed from: t */
    private static int f5352t = 10;

    /* loaded from: classes.dex */
    public class AnimationTask extends TimerTask {
        public AnimationTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message2 = new Message();
            message2.what = 1;
            WearMapView.this.mTimerHandler.sendMessage(message2);
        }
    }

    /* loaded from: classes.dex */
    public interface OnDismissCallback {
        void onDismiss();

        void onNotify();
    }

    /* loaded from: classes.dex */
    public enum ScreenShape {
        ROUND,
        RECTANGLE,
        UNDETECTED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapapi.map.WearMapView$a */
    /* loaded from: classes.dex */
    public class HandlerC1089a extends Handler {

        /* renamed from: b */
        private final WeakReference<Context> f5388b;

        public HandlerC1089a(Context context) {
            this.f5388b = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            if (this.f5388b.get() == null) {
                return;
            }
            super.handleMessage(message2);
            if (message2.what == 1 && WearMapView.this.f5366i != null) {
                WearMapView.this.m11096a(true);
            }
        }
    }

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        f5353w = sparseArray;
        sparseArray.append(3, 2000000);
        f5353w.append(4, 1000000);
        f5353w.append(5, 500000);
        f5353w.append(6, 200000);
        f5353w.append(7, 100000);
        f5353w.append(8, 50000);
        f5353w.append(9, 25000);
        f5353w.append(10, Integer.valueOf((int) TranslateManager.TIME_OUT));
        f5353w.append(11, 10000);
        f5353w.append(12, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_GPS));
        f5353w.append(13, 2000);
        f5353w.append(14, 1000);
        f5353w.append(15, Integer.valueOf((int) UIMsg.d_ResultType.SHORT_URL));
        f5353w.append(16, Integer.valueOf((int) PdfContentParser.COMMAND_TYPE));
        f5353w.append(17, 100);
        f5353w.append(18, 50);
        f5353w.append(19, 20);
        f5353w.append(20, 10);
        f5353w.append(21, 5);
        f5353w.append(22, 2);
    }

    public WearMapView(Context context) {
        super(context);
        this.f5367j = true;
        this.f5375u = true;
        this.f5361a = ScreenShape.ROUND;
        this.f5377x = true;
        this.f5378y = true;
        m11103a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5367j = true;
        this.f5375u = true;
        this.f5361a = ScreenShape.ROUND;
        this.f5377x = true;
        this.f5378y = true;
        m11103a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5367j = true;
        this.f5375u = true;
        this.f5361a = ScreenShape.ROUND;
        this.f5377x = true;
        this.f5378y = true;
        m11103a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.f5367j = true;
        this.f5375u = true;
        this.f5361a = ScreenShape.ROUND;
        this.f5377x = true;
        this.f5378y = true;
        m11103a(context, baiduMapOptions);
    }

    /* renamed from: a */
    private int m11105a(int i, int i2) {
        return i - ((int) Math.sqrt(Math.pow(i, 2.0d) - Math.pow(i2, 2.0d)));
    }

    /* renamed from: a */
    private void m11106a(int i) {
        GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f5362e;
        if (gestureDetector$OnDoubleTapListenerC1216j == null) {
            return;
        }
        switch (i) {
            case 0:
                gestureDetector$OnDoubleTapListenerC1216j.onPause();
                m11095b();
                return;
            case 1:
                gestureDetector$OnDoubleTapListenerC1216j.onResume();
                m11092c();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private static void m11104a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        f5350r = point.x;
        f5351s = point.y;
    }

    /* renamed from: a */
    private void m11103a(Context context, BaiduMapOptions baiduMapOptions) {
        AnimationTask animationTask;
        m11104a(context);
        setOnApplyWindowInsetsListener(this);
        this.f5376v = context;
        this.mTimerHandler = new HandlerC1089a(context);
        this.mTimer = new Timer();
        if (this.mTimer != null && (animationTask = this.mTask) != null) {
            animationTask.cancel();
        }
        this.mTask = new AnimationTask();
        this.mTimer.schedule(this.mTask, 5000L);
        C1215i.m10646a();
        BMapManager.init();
        m11102a(context, baiduMapOptions, f5348c);
        this.f5363f = new BaiduMap(this.f5362e);
        this.f5362e.m10642a().m10657s(false);
        this.f5362e.m10642a().m10659r(false);
        m11091c(context);
        m11088d(context);
        m11094b(context);
        if (baiduMapOptions != null && !baiduMapOptions.f4977h) {
            this.f5366i.setVisibility(4);
        }
        m11085e(context);
        if (baiduMapOptions != null && !baiduMapOptions.f4978i) {
            this.f5370m.setVisibility(4);
        }
        if (baiduMapOptions != null && baiduMapOptions.f4981l != null) {
            this.f5369l = baiduMapOptions.f4981l;
        }
        if (baiduMapOptions == null || baiduMapOptions.f4980k == null) {
            return;
        }
        this.f5368k = baiduMapOptions.f4980k;
    }

    /* renamed from: a */
    private void m11102a(Context context, BaiduMapOptions baiduMapOptions, String str) {
        if (baiduMapOptions == null) {
            this.f5362e = new GestureDetector$OnDoubleTapListenerC1216j(context, null, str, f5349d);
        } else {
            this.f5362e = new GestureDetector$OnDoubleTapListenerC1216j(context, baiduMapOptions.m11222a(), str, f5349d);
        }
        addView(this.f5362e);
        this.f5354A = new InterfaceC1219k() { // from class: com.baidu.mapapi.map.WearMapView.1
            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10622a() {
                if (WearMapView.this.f5362e == null || WearMapView.this.f5362e.m10642a() == null) {
                    return;
                }
                float f = WearMapView.this.f5362e.m10642a().m10753E().f6114a;
                if (WearMapView.this.f5379z != f) {
                    int intValue = ((Integer) WearMapView.f5353w.get((int) f)).intValue();
                    double d = intValue;
                    double d2 = WearMapView.this.f5362e.m10642a().m10753E().f6126m;
                    Double.isNaN(d);
                    int i = ((int) (d / d2)) / 2;
                    WearMapView.this.f5374q.setPadding(i, 0, i, 0);
                    String format = intValue >= 1000 ? String.format(" %d公里 ", Integer.valueOf(intValue / 1000)) : String.format(" %d米 ", Integer.valueOf(intValue));
                    WearMapView.this.f5372o.setText(format);
                    WearMapView.this.f5373p.setText(format);
                    WearMapView.this.f5379z = f;
                }
                WearMapView.this.requestLayout();
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10621a(Bitmap bitmap) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10620a(MotionEvent motionEvent) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10619a(GeoPoint geoPoint) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10618a(C1236z c1236z) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10617a(String str2) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10616a(GL10 gl10, C1236z c1236z) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10615a(boolean z) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: b */
            public void mo10614b() {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: b */
            public void mo10613b(GeoPoint geoPoint) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: b */
            public void mo10612b(C1236z c1236z) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: b */
            public boolean mo10611b(String str2) {
                return false;
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: c */
            public void mo10610c() {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: c */
            public void mo10609c(GeoPoint geoPoint) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: c */
            public void mo10608c(C1236z c1236z) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: d */
            public void mo10607d() {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: d */
            public void mo10606d(GeoPoint geoPoint) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: e */
            public void mo10605e() {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: e */
            public void mo10604e(GeoPoint geoPoint) {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: f */
            public void mo10603f() {
            }
        };
        this.f5362e.m10642a().m10720a(this.f5354A);
    }

    /* renamed from: a */
    private void m11101a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i = layoutParams.width;
        int makeMeasureSpec = i > 0 ? View.MeasureSpec.makeMeasureSpec(i, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE) : View.MeasureSpec.makeMeasureSpec(0, 0);
        int i2 = layoutParams.height;
        view.measure(makeMeasureSpec, i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* renamed from: a */
    private void m11100a(final View view, boolean z) {
        AnimatorSet animatorSet;
        if (z) {
            animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "TranslationY", ColumnText.GLOBAL_SPACE_CHAR_RATIO, -50.0f), ObjectAnimator.ofFloat(view, "alpha", 1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO));
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.mapapi.map.WearMapView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(4);
                    super.onAnimationEnd(animator);
                }
            });
        } else {
            view.setVisibility(0);
            animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "TranslationY", -50.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO), ObjectAnimator.ofFloat(view, "alpha", ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f));
        }
        animatorSet.setDuration(1200L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11096a(boolean z) {
        if (this.f5367j) {
            m11100a(this.f5366i, z);
        }
    }

    /* renamed from: b */
    private void m11095b() {
        if (this.f5362e == null || this.f5375u) {
            return;
        }
        m11089d();
        this.f5375u = true;
    }

    /* renamed from: b */
    private void m11094b(Context context) {
        this.f5371n = new SwipeDismissView(context, this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), f5351s);
        this.f5371n.setBackgroundColor(Color.argb(0, 0, 0, 0));
        this.f5371n.setLayoutParams(layoutParams);
        addView(this.f5371n);
    }

    /* renamed from: c */
    private void m11092c() {
        if (this.f5362e != null && this.f5375u) {
            m11086e();
            this.f5375u = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m11091c(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.String r0 = "logo_h.png"
            int r1 = com.baidu.mapapi.common.SysOSUtil.getDensityDpi()
            r2 = 180(0xb4, float:2.52E-43)
            if (r1 >= r2) goto Lc
            java.lang.String r0 = "logo_l.png"
        Lc:
            android.graphics.Bitmap r2 = com.baidu.mapsdkplatform.comapi.commonutils.C1190a.m10820a(r0, r10)
            r0 = 480(0x1e0, float:6.73E-43)
            if (r1 <= r0) goto L30
            android.graphics.Matrix r7 = new android.graphics.Matrix
            r7.<init>()
            r0 = 1073741824(0x40000000, float:2.0)
        L1b:
            r7.postScale(r0, r0)
            r3 = 0
            r4 = 0
            int r5 = r2.getWidth()
            int r6 = r2.getHeight()
            r8 = 1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8)
            r9.f5365h = r0
            goto L40
        L30:
            r3 = 320(0x140, float:4.48E-43)
            if (r1 <= r3) goto L3e
            if (r1 > r0) goto L3e
            android.graphics.Matrix r7 = new android.graphics.Matrix
            r7.<init>()
            r0 = 1069547520(0x3fc00000, float:1.5)
            goto L1b
        L3e:
            r9.f5365h = r2
        L40:
            android.graphics.Bitmap r0 = r9.f5365h
            if (r0 == 0) goto L57
            android.widget.ImageView r0 = new android.widget.ImageView
            r0.<init>(r10)
            r9.f5364g = r0
            android.widget.ImageView r10 = r9.f5364g
            android.graphics.Bitmap r0 = r9.f5365h
            r10.setImageBitmap(r0)
            android.widget.ImageView r10 = r9.f5364g
            r9.addView(r10)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.WearMapView.m11091c(android.content.Context):void");
    }

    /* renamed from: d */
    private void m11089d() {
        GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f5362e;
        if (gestureDetector$OnDoubleTapListenerC1216j == null) {
            return;
        }
        gestureDetector$OnDoubleTapListenerC1216j.m10635b();
    }

    /* renamed from: d */
    private void m11088d(Context context) {
        this.f5366i = new View$OnTouchListenerC1204H(context, true);
        if (this.f5366i.m10771a()) {
            this.f5366i.m10764b(new View.OnClickListener() { // from class: com.baidu.mapapi.map.WearMapView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C1236z m10753E = WearMapView.this.f5362e.m10642a().m10753E();
                    m10753E.f6114a -= 1.0f;
                    WearMapView.this.f5362e.m10642a().m10716a(m10753E, 300);
                }
            });
            this.f5366i.m10769a(new View.OnClickListener() { // from class: com.baidu.mapapi.map.WearMapView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C1236z m10753E = WearMapView.this.f5362e.m10642a().m10753E();
                    m10753E.f6114a += 1.0f;
                    WearMapView.this.f5362e.m10642a().m10716a(m10753E, 300);
                }
            });
            addView(this.f5366i);
        }
    }

    /* renamed from: e */
    private void m11086e() {
        GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f5362e;
        if (gestureDetector$OnDoubleTapListenerC1216j == null) {
            return;
        }
        gestureDetector$OnDoubleTapListenerC1216j.m10631c();
    }

    /* renamed from: e */
    private void m11085e(Context context) {
        this.f5370m = new RelativeLayout(context);
        this.f5370m.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f5372o = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.f5372o.setTextColor(Color.parseColor("#FFFFFF"));
        this.f5372o.setTextSize(2, 11.0f);
        TextView textView = this.f5372o;
        textView.setTypeface(textView.getTypeface(), 1);
        this.f5372o.setLayoutParams(layoutParams);
        this.f5372o.setId(MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT);
        this.f5370m.addView(this.f5372o);
        this.f5373p = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(14);
        this.f5373p.setTextColor(Color.parseColor("#000000"));
        this.f5373p.setTextSize(2, 11.0f);
        this.f5373p.setLayoutParams(layoutParams2);
        this.f5370m.addView(this.f5373p);
        this.f5374q = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.f5372o.getId());
        this.f5374q.setLayoutParams(layoutParams3);
        Bitmap m10820a = C1190a.m10820a("icon_scale.9.png", context);
        byte[] ninePatchChunk = m10820a.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        this.f5374q.setBackgroundDrawable(new NinePatchDrawable(m10820a, ninePatchChunk, new Rect(), null));
        this.f5370m.addView(this.f5374q);
        addView(this.f5370m);
    }

    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("customMapStylePath String is illegal");
        }
        if (!new File(str).exists()) {
            throw new RuntimeException("please check whether the customMapStylePath file exits");
        }
        f5348c = str;
    }

    public static void setIconCustom(int i) {
        f5349d = i;
    }

    public static void setMapCustomEnable(boolean z) {
        C1215i.m10644a(z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MapViewLayoutParams) {
            super.addView(view, layoutParams);
        }
    }

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.f5363f;
        baiduMap.f4941c = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return f5353w.get((int) this.f5362e.m10642a().m10753E().f6114a).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.f5359F;
    }

    public int getScaleControlViewWidth() {
        return this.f5360G;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.f5361a = windowInsets.isRound() ? ScreenShape.ROUND : ScreenShape.RECTANGLE;
        return windowInsets;
    }

    public void onCreate(Context context, Bundle bundle) {
        BaiduMapOptions mapStatus;
        if (bundle == null) {
            return;
        }
        f5348c = bundle.getString("customMapPath");
        if (bundle == null) {
            mapStatus = new BaiduMapOptions();
        } else {
            MapStatus mapStatus2 = (MapStatus) bundle.getParcelable("mapstatus");
            if (this.f5368k != null) {
                this.f5368k = (Point) bundle.getParcelable("scalePosition");
            }
            if (this.f5369l != null) {
                this.f5369l = (Point) bundle.getParcelable("zoomPosition");
            }
            this.f5377x = bundle.getBoolean("mZoomControlEnabled");
            this.f5378y = bundle.getBoolean("mScaleControlEnabled");
            setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
            mapStatus = new BaiduMapOptions().mapStatus(mapStatus2);
        }
        m11103a(context, mapStatus);
    }

    public final void onDestroy() {
        Context context = this.f5376v;
        if (context != null) {
            this.f5362e.m10633b(context.hashCode());
        }
        Bitmap bitmap = this.f5365h;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5365h.recycle();
            this.f5365h = null;
        }
        this.f5366i.m10765b();
        BMapManager.destroy();
        C1215i.m10643b();
        AnimationTask animationTask = this.mTask;
        if (animationTask != null) {
            animationTask.cancel();
        }
        this.f5376v = null;
    }

    public final void onDismiss() {
        removeAllViews();
    }

    public final void onEnterAmbient(Bundle bundle) {
        m11106a(0);
    }

    public void onExitAmbient() {
        m11106a(1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AnimationTask animationTask;
        switch (motionEvent.getAction()) {
            case 0:
                if (this.f5366i.getVisibility() != 0) {
                    if (this.f5366i.getVisibility() == 4) {
                        if (this.mTimer != null) {
                            AnimationTask animationTask2 = this.mTask;
                            if (animationTask2 != null) {
                                animationTask2.cancel();
                            }
                            this.mTimer.cancel();
                            this.mTask = null;
                            this.mTimer = null;
                        }
                        m11096a(false);
                        break;
                    }
                } else {
                    Timer timer = this.mTimer;
                    if (timer != null) {
                        if (this.mTask != null) {
                            timer.cancel();
                            this.mTask.cancel();
                        }
                        this.mTimer = null;
                        this.mTask = null;
                        break;
                    }
                }
                break;
            case 1:
                this.mTimer = new Timer();
                if (this.mTimer != null && (animationTask = this.mTask) != null) {
                    animationTask.cancel();
                }
                this.mTask = new AnimationTask();
                this.mTimer.schedule(this.mTask, 5000L);
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(20)
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        int i6;
        int i7;
        int i8;
        int childCount = getChildCount();
        m11101a(this.f5364g);
        float f2 = 1.0f;
        if (((getWidth() - this.f5355B) - this.f5356C) - this.f5364g.getMeasuredWidth() <= 0 || ((getHeight() - this.f5357D) - this.f5358E) - this.f5364g.getMeasuredHeight() <= 0) {
            this.f5355B = 0;
            this.f5356C = 0;
            this.f5358E = 0;
            this.f5357D = 0;
            f = 1.0f;
        } else {
            f2 = ((getWidth() - this.f5355B) - this.f5356C) / getWidth();
            f = ((getHeight() - this.f5357D) - this.f5358E) / getHeight();
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f5362e;
            if (childAt == gestureDetector$OnDoubleTapListenerC1216j) {
                gestureDetector$OnDoubleTapListenerC1216j.layout(0, 0, getWidth(), getHeight());
            } else if (childAt == this.f5364g) {
                int i10 = (int) (this.f5358E + (12.0f * f));
                if (this.f5361a == ScreenShape.ROUND) {
                    m11101a(this.f5366i);
                    int i11 = f5350r / 2;
                    i8 = m11105a(i11, this.f5366i.getMeasuredWidth() / 2);
                    i7 = f5352t + ((f5350r / 2) - m11105a(i11, i11 - i8));
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                int i12 = (f5351s - i8) - i10;
                int i13 = f5350r - i7;
                this.f5364g.layout(i13 - this.f5364g.getMeasuredWidth(), i12 - this.f5364g.getMeasuredHeight(), i13, i12);
            } else {
                View$OnTouchListenerC1204H view$OnTouchListenerC1204H = this.f5366i;
                if (childAt == view$OnTouchListenerC1204H) {
                    if (view$OnTouchListenerC1204H.m10771a()) {
                        m11101a(this.f5366i);
                        Point point = this.f5369l;
                        if (point == null) {
                            int m11105a = (int) ((12.0f * f) + this.f5357D + (this.f5361a == ScreenShape.ROUND ? m11105a(f5351s / 2, this.f5366i.getMeasuredWidth() / 2) : 0));
                            int measuredWidth = (f5350r - this.f5366i.getMeasuredWidth()) / 2;
                            this.f5366i.layout(measuredWidth, m11105a, this.f5366i.getMeasuredWidth() + measuredWidth, this.f5366i.getMeasuredHeight() + m11105a);
                        } else {
                            this.f5366i.layout(point.x, this.f5369l.y, this.f5369l.x + this.f5366i.getMeasuredWidth(), this.f5369l.y + this.f5366i.getMeasuredHeight());
                        }
                    }
                } else if (childAt == this.f5370m) {
                    if (this.f5361a == ScreenShape.ROUND) {
                        m11101a(this.f5366i);
                        int i14 = f5350r / 2;
                        i6 = m11105a(i14, this.f5366i.getMeasuredWidth() / 2);
                        i5 = f5352t + ((f5350r / 2) - m11105a(i14, i14 - i6));
                    } else {
                        i5 = 0;
                        i6 = 0;
                    }
                    m11101a(this.f5370m);
                    Point point2 = this.f5368k;
                    if (point2 == null) {
                        int i15 = (int) (this.f5358E + (12.0f * f));
                        this.f5360G = this.f5370m.getMeasuredWidth();
                        this.f5359F = this.f5370m.getMeasuredHeight();
                        int i16 = (int) (this.f5355B + (5.0f * f2) + i5);
                        int i17 = (f5351s - i15) - i6;
                        this.f5370m.layout(i16, i17 - this.f5370m.getMeasuredHeight(), this.f5360G + i16, i17);
                    } else {
                        this.f5370m.layout(point2.x, this.f5368k.y, this.f5368k.x + this.f5370m.getMeasuredWidth(), this.f5368k.y + this.f5370m.getMeasuredHeight());
                    }
                } else {
                    SwipeDismissView swipeDismissView = this.f5371n;
                    if (childAt == swipeDismissView) {
                        m11101a(swipeDismissView);
                        this.f5371n.layout(0, 0, this.f5371n.getMeasuredWidth(), f5351s);
                    } else {
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        if (layoutParams instanceof MapViewLayoutParams) {
                            MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                            Point m10723a = mapViewLayoutParams.f5139c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f5138b : this.f5362e.m10642a().m10723a(CoordUtil.ll2mc(mapViewLayoutParams.f5137a));
                            m11101a(childAt);
                            int measuredWidth2 = childAt.getMeasuredWidth();
                            int measuredHeight = childAt.getMeasuredHeight();
                            float f3 = mapViewLayoutParams.f5140d;
                            float f4 = mapViewLayoutParams.f5141e;
                            int i18 = (int) (m10723a.x - (f3 * measuredWidth2));
                            int i19 = ((int) (m10723a.y - (f4 * measuredHeight))) + mapViewLayoutParams.f5142f;
                            childAt.layout(i18, i19, measuredWidth2 + i18, measuredHeight + i19);
                        }
                    }
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.f5363f) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        Point point = this.f5368k;
        if (point != null) {
            bundle.putParcelable("scalePosition", point);
        }
        Point point2 = this.f5369l;
        if (point2 != null) {
            bundle.putParcelable("zoomPosition", point2);
        }
        bundle.putBoolean("mZoomControlEnabled", this.f5377x);
        bundle.putBoolean("mScaleControlEnabled", this.f5378y);
        bundle.putInt("paddingLeft", this.f5355B);
        bundle.putInt("paddingTop", this.f5357D);
        bundle.putInt("paddingRight", this.f5356C);
        bundle.putInt("paddingBottom", this.f5358E);
        bundle.putString("customMapPath", f5348c);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.f5364g) {
            return;
        }
        super.removeView(view);
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        SwipeDismissView swipeDismissView = this.f5371n;
        if (swipeDismissView == null) {
            return;
        }
        swipeDismissView.setCallback(onDismissCallback);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f5355B = i;
        this.f5357D = i2;
        this.f5356C = i3;
        this.f5358E = i4;
    }

    public void setScaleControlPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.f5368k = point;
            requestLayout();
        }
    }

    public void setShape(ScreenShape screenShape) {
        this.f5361a = screenShape;
    }

    public void setViewAnimitionEnable(boolean z) {
        this.f5367j = z;
    }

    public void setZoomControlsPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.f5369l = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.f5370m.setVisibility(z ? 0 : 8);
        this.f5378y = z;
    }

    public void showZoomControls(boolean z) {
        if (this.f5366i.m10771a()) {
            this.f5366i.setVisibility(z ? 0 : 8);
            this.f5377x = z;
        }
    }
}
