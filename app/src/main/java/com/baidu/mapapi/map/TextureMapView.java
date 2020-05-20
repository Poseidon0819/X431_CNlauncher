package com.baidu.mapapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.mapsdkplatform.comapi.map.GestureDetector$OnDoubleTapListenerC1196A;
import com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k;
import com.baidu.mapsdkplatform.comapi.map.View$OnTouchListenerC1204H;
import com.cnlaunch.translate.TranslateManager;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentParser;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.io.File;
import javax.microedition.khronos.opengles.GL10;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public final class TextureMapView extends ViewGroup {

    /* renamed from: a */
    private static final String f5291a = "TextureMapView";

    /* renamed from: i */
    private static String f5292i;

    /* renamed from: j */
    private static int f5293j;

    /* renamed from: p */
    private static final SparseArray<Integer> f5294p;

    /* renamed from: A */
    private int f5295A;

    /* renamed from: b */
    private GestureDetector$OnDoubleTapListenerC1196A f5296b;

    /* renamed from: c */
    private BaiduMap f5297c;

    /* renamed from: d */
    private ImageView f5298d;

    /* renamed from: e */
    private Bitmap f5299e;

    /* renamed from: f */
    private View$OnTouchListenerC1204H f5300f;

    /* renamed from: g */
    private Point f5301g;

    /* renamed from: h */
    private Point f5302h;

    /* renamed from: k */
    private RelativeLayout f5303k;

    /* renamed from: l */
    private TextView f5304l;

    /* renamed from: m */
    private TextView f5305m;

    /* renamed from: n */
    private ImageView f5306n;

    /* renamed from: o */
    private Context f5307o;

    /* renamed from: q */
    private float f5308q;

    /* renamed from: r */
    private InterfaceC1219k f5309r;

    /* renamed from: s */
    private int f5310s;

    /* renamed from: t */
    private boolean f5311t;

    /* renamed from: u */
    private boolean f5312u;

    /* renamed from: v */
    private int f5313v;

    /* renamed from: w */
    private int f5314w;

    /* renamed from: x */
    private int f5315x;

    /* renamed from: y */
    private int f5316y;

    /* renamed from: z */
    private int f5317z;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        f5294p = sparseArray;
        sparseArray.append(3, 2000000);
        f5294p.append(4, 1000000);
        f5294p.append(5, 500000);
        f5294p.append(6, 200000);
        f5294p.append(7, 100000);
        f5294p.append(8, 50000);
        f5294p.append(9, 25000);
        f5294p.append(10, Integer.valueOf((int) TranslateManager.TIME_OUT));
        f5294p.append(11, 10000);
        f5294p.append(12, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_GPS));
        f5294p.append(13, 2000);
        f5294p.append(14, 1000);
        f5294p.append(15, Integer.valueOf((int) UIMsg.d_ResultType.SHORT_URL));
        f5294p.append(16, Integer.valueOf((int) PdfContentParser.COMMAND_TYPE));
        f5294p.append(17, 100);
        f5294p.append(18, 50);
        f5294p.append(19, 20);
        f5294p.append(20, 10);
        f5294p.append(21, 5);
        f5294p.append(22, 2);
    }

    public TextureMapView(Context context) {
        super(context);
        this.f5310s = LogoPosition.logoPostionleftBottom.ordinal();
        this.f5311t = true;
        this.f5312u = true;
        m11134a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5310s = LogoPosition.logoPostionleftBottom.ordinal();
        this.f5311t = true;
        this.f5312u = true;
        m11134a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5310s = LogoPosition.logoPostionleftBottom.ordinal();
        this.f5311t = true;
        this.f5312u = true;
        m11134a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.f5310s = LogoPosition.logoPostionleftBottom.ordinal();
        this.f5311t = true;
        this.f5312u = true;
        m11134a(context, baiduMapOptions);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m11135a(android.content.Context r10) {
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
            r9.f5299e = r0
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
            r9.f5299e = r2
        L40:
            android.graphics.Bitmap r0 = r9.f5299e
            if (r0 == 0) goto L57
            android.widget.ImageView r0 = new android.widget.ImageView
            r0.<init>(r10)
            r9.f5298d = r0
            android.widget.ImageView r10 = r9.f5298d
            android.graphics.Bitmap r0 = r9.f5299e
            r10.setImageBitmap(r0)
            android.widget.ImageView r10 = r9.f5298d
            r9.addView(r10)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.TextureMapView.m11135a(android.content.Context):void");
    }

    /* renamed from: a */
    private void m11134a(Context context, BaiduMapOptions baiduMapOptions) {
        setBackgroundColor(-1);
        this.f5307o = context;
        C1215i.m10646a();
        BMapManager.init();
        m11133a(context, baiduMapOptions, f5292i, f5293j);
        this.f5297c = new BaiduMap(this.f5296b);
        m11135a(context);
        m11128b(context);
        if (baiduMapOptions != null && !baiduMapOptions.f4977h) {
            this.f5300f.setVisibility(4);
        }
        m11126c(context);
        if (baiduMapOptions != null && !baiduMapOptions.f4978i) {
            this.f5303k.setVisibility(4);
        }
        if (baiduMapOptions != null && baiduMapOptions.f4979j != null) {
            this.f5310s = baiduMapOptions.f4979j.ordinal();
        }
        if (baiduMapOptions != null && baiduMapOptions.f4981l != null) {
            this.f5302h = baiduMapOptions.f4981l;
        }
        if (baiduMapOptions == null || baiduMapOptions.f4980k == null) {
            return;
        }
        this.f5301g = baiduMapOptions.f4980k;
    }

    /* renamed from: a */
    private void m11133a(Context context, BaiduMapOptions baiduMapOptions, String str, int i) {
        f5292i = str;
        if (baiduMapOptions == null) {
            this.f5296b = new GestureDetector$OnDoubleTapListenerC1196A(context, null, str, i);
        } else {
            this.f5296b = new GestureDetector$OnDoubleTapListenerC1196A(context, baiduMapOptions.m11222a(), str, i);
        }
        addView(this.f5296b);
        this.f5309r = new InterfaceC1219k() { // from class: com.baidu.mapapi.map.TextureMapView.1
            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10622a() {
                if (TextureMapView.this.f5296b == null || TextureMapView.this.f5296b.m10783b() == null) {
                    return;
                }
                float f = TextureMapView.this.f5296b.m10783b().m10753E().f6114a;
                if (f < TextureMapView.this.f5296b.m10783b().f6004b) {
                    f = TextureMapView.this.f5296b.m10783b().f6004b;
                } else if (f > TextureMapView.this.f5296b.m10783b().f5983a) {
                    f = TextureMapView.this.f5296b.m10783b().f5983a;
                }
                if (Math.abs(TextureMapView.this.f5308q - f) > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    int intValue = ((Integer) TextureMapView.f5294p.get(Math.round(f))).intValue();
                    double d = intValue;
                    double d2 = TextureMapView.this.f5296b.m10783b().m10753E().f6126m;
                    Double.isNaN(d);
                    int i2 = ((int) (d / d2)) / 2;
                    TextureMapView.this.f5306n.setPadding(i2, 0, i2, 0);
                    String format = intValue >= 1000 ? String.format(" %d公里 ", Integer.valueOf(intValue / 1000)) : String.format(" %d米 ", Integer.valueOf(intValue));
                    TextureMapView.this.f5304l.setText(format);
                    TextureMapView.this.f5305m.setText(format);
                    TextureMapView.this.f5308q = f;
                }
                TextureMapView.this.m11129b();
                TextureMapView.this.requestLayout();
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
        this.f5296b.m10783b().m10720a(this.f5309r);
    }

    /* renamed from: a */
    private void m11132a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i = layoutParams.width;
        int makeMeasureSpec = i > 0 ? View.MeasureSpec.makeMeasureSpec(i, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE) : View.MeasureSpec.makeMeasureSpec(0, 0);
        int i2 = layoutParams.height;
        view.measure(makeMeasureSpec, i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11129b() {
        if (this.f5300f.m10771a()) {
            float f = this.f5296b.m10783b().m10753E().f6114a;
            this.f5300f.m10763b(f > this.f5296b.m10783b().f6004b);
            this.f5300f.m10766a(f < this.f5296b.m10783b().f5983a);
        }
    }

    /* renamed from: b */
    private void m11128b(Context context) {
        this.f5300f = new View$OnTouchListenerC1204H(context);
        if (this.f5300f.m10771a()) {
            this.f5300f.m10764b(new View.OnClickListener() { // from class: com.baidu.mapapi.map.TextureMapView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    float f = TextureMapView.this.f5296b.m10783b().f6004b;
                    C1236z m10753E = TextureMapView.this.f5296b.m10783b().m10753E();
                    m10753E.f6114a -= 1.0f;
                    if (m10753E.f6114a >= f) {
                        f = m10753E.f6114a;
                    }
                    m10753E.f6114a = f;
                    BaiduMap.mapStatusReason |= 16;
                    TextureMapView.this.f5296b.m10783b().m10716a(m10753E, 300);
                }
            });
            this.f5300f.m10769a(new View.OnClickListener() { // from class: com.baidu.mapapi.map.TextureMapView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    float f = TextureMapView.this.f5296b.m10783b().f5983a;
                    C1236z m10753E = TextureMapView.this.f5296b.m10783b().m10753E();
                    m10753E.f6114a += 1.0f;
                    if (m10753E.f6114a <= f) {
                        f = m10753E.f6114a;
                    }
                    m10753E.f6114a = f;
                    BaiduMap.mapStatusReason |= 16;
                    TextureMapView.this.f5296b.m10783b().m10716a(m10753E, 300);
                }
            });
            addView(this.f5300f);
        }
    }

    /* renamed from: c */
    private void m11126c(Context context) {
        this.f5303k = new RelativeLayout(context);
        this.f5303k.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f5304l = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.f5304l.setTextColor(Color.parseColor("#FFFFFF"));
        this.f5304l.setTextSize(2, 11.0f);
        TextView textView = this.f5304l;
        textView.setTypeface(textView.getTypeface(), 1);
        this.f5304l.setLayoutParams(layoutParams);
        this.f5304l.setId(MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT);
        this.f5303k.addView(this.f5304l);
        this.f5305m = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(14);
        this.f5305m.setTextColor(Color.parseColor("#000000"));
        this.f5305m.setTextSize(2, 11.0f);
        this.f5305m.setLayoutParams(layoutParams2);
        this.f5303k.addView(this.f5305m);
        this.f5306n = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.f5304l.getId());
        this.f5306n.setLayoutParams(layoutParams3);
        Bitmap m10820a = C1190a.m10820a("icon_scale.9.png", context);
        byte[] ninePatchChunk = m10820a.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        this.f5306n.setBackgroundDrawable(new NinePatchDrawable(m10820a, ninePatchChunk, new Rect(), null));
        this.f5303k.addView(this.f5306n);
        addView(this.f5303k);
    }

    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("customMapStylePath String is illegal");
        }
        if (!new File(str).exists()) {
            throw new RuntimeException("please check whether the customMapStylePath file exits");
        }
        f5292i = str;
    }

    public static void setIconCustom(int i) {
        f5293j = i;
    }

    public static void setMapCustomEnable(boolean z) {
        C1215i.m10644a(z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MapViewLayoutParams) {
            super.addView(view, layoutParams);
        }
    }

    public final LogoPosition getLogoPosition() {
        switch (this.f5310s) {
            case 1:
                return LogoPosition.logoPostionleftTop;
            case 2:
                return LogoPosition.logoPostionCenterBottom;
            case 3:
                return LogoPosition.logoPostionCenterTop;
            case 4:
                return LogoPosition.logoPostionRightBottom;
            case 5:
                return LogoPosition.logoPostionRightTop;
            default:
                return LogoPosition.logoPostionleftBottom;
        }
    }

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.f5297c;
        baiduMap.f4940b = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return f5294p.get((int) this.f5296b.m10783b().m10753E().f6114a).intValue();
    }

    public final int getScaleControlViewHeight() {
        return this.f5295A;
    }

    public final int getScaleControlViewWidth() {
        return this.f5295A;
    }

    public final void onCreate(Context context, Bundle bundle) {
        BaiduMapOptions mapStatus;
        if (bundle == null) {
            return;
        }
        f5292i = bundle.getString("customMapPath");
        if (bundle == null) {
            mapStatus = new BaiduMapOptions();
        } else {
            MapStatus mapStatus2 = (MapStatus) bundle.getParcelable("mapstatus");
            if (this.f5301g != null) {
                this.f5301g = (Point) bundle.getParcelable("scalePosition");
            }
            if (this.f5302h != null) {
                this.f5302h = (Point) bundle.getParcelable("zoomPosition");
            }
            this.f5311t = bundle.getBoolean("mZoomControlEnabled");
            this.f5312u = bundle.getBoolean("mScaleControlEnabled");
            this.f5310s = bundle.getInt("logoPosition");
            setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
            mapStatus = new BaiduMapOptions().mapStatus(mapStatus2);
        }
        m11134a(context, mapStatus);
    }

    public final void onDestroy() {
        Context context = this.f5307o;
        if (context != null) {
            this.f5296b.m10787a(context.hashCode());
        }
        Bitmap bitmap = this.f5299e;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5299e.recycle();
        }
        this.f5300f.m10765b();
        BMapManager.destroy();
        C1215i.m10643b();
        this.f5307o = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int measuredHeight;
        int measuredWidth;
        int height;
        int height2;
        int childCount = getChildCount();
        m11132a(this.f5298d);
        float f2 = 1.0f;
        if (((getWidth() - this.f5313v) - this.f5314w) - this.f5298d.getMeasuredWidth() <= 0 || ((getHeight() - this.f5315x) - this.f5316y) - this.f5298d.getMeasuredHeight() <= 0) {
            this.f5313v = 0;
            this.f5314w = 0;
            this.f5316y = 0;
            this.f5315x = 0;
            f = 1.0f;
        } else {
            f2 = ((getWidth() - this.f5313v) - this.f5314w) / getWidth();
            f = ((getHeight() - this.f5315x) - this.f5316y) / getHeight();
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            GestureDetector$OnDoubleTapListenerC1196A gestureDetector$OnDoubleTapListenerC1196A = this.f5296b;
            if (childAt == gestureDetector$OnDoubleTapListenerC1196A) {
                gestureDetector$OnDoubleTapListenerC1196A.layout(0, 0, getWidth(), getHeight());
            } else {
                ImageView imageView = this.f5298d;
                if (childAt == imageView) {
                    float f3 = f2 * 5.0f;
                    int i6 = (int) (this.f5313v + f3);
                    int i7 = (int) (this.f5314w + f3);
                    float f4 = 5.0f * f;
                    int i8 = (int) (this.f5315x + f4);
                    int i9 = (int) (this.f5316y + f4);
                    switch (this.f5310s) {
                        case 1:
                            measuredHeight = imageView.getMeasuredHeight() + i8;
                            measuredWidth = this.f5298d.getMeasuredWidth() + i6;
                            break;
                        case 2:
                            height = getHeight() - i9;
                            i8 = height - this.f5298d.getMeasuredHeight();
                            int width = (((getWidth() - this.f5298d.getMeasuredWidth()) + this.f5313v) - this.f5314w) / 2;
                            measuredWidth = (((getWidth() + this.f5298d.getMeasuredWidth()) + this.f5313v) - this.f5314w) / 2;
                            measuredHeight = height;
                            i6 = width;
                            break;
                        case 3:
                            height = imageView.getMeasuredHeight() + i8;
                            int width2 = (((getWidth() - this.f5298d.getMeasuredWidth()) + this.f5313v) - this.f5314w) / 2;
                            measuredWidth = (((getWidth() + this.f5298d.getMeasuredWidth()) + this.f5313v) - this.f5314w) / 2;
                            measuredHeight = height;
                            i6 = width2;
                            break;
                        case 4:
                            height2 = getHeight() - i9;
                            i8 = height2 - this.f5298d.getMeasuredHeight();
                            int width3 = getWidth() - i7;
                            int measuredWidth2 = width3 - this.f5298d.getMeasuredWidth();
                            measuredHeight = height2;
                            i6 = measuredWidth2;
                            measuredWidth = width3;
                            break;
                        case 5:
                            height2 = imageView.getMeasuredHeight() + i8;
                            int width32 = getWidth() - i7;
                            int measuredWidth22 = width32 - this.f5298d.getMeasuredWidth();
                            measuredHeight = height2;
                            i6 = measuredWidth22;
                            measuredWidth = width32;
                            break;
                        default:
                            measuredHeight = getHeight() - i9;
                            measuredWidth = this.f5298d.getMeasuredWidth() + i6;
                            i8 = measuredHeight - this.f5298d.getMeasuredHeight();
                            break;
                    }
                    this.f5298d.layout(i6, i8, measuredWidth, measuredHeight);
                } else {
                    View$OnTouchListenerC1204H view$OnTouchListenerC1204H = this.f5300f;
                    if (childAt != view$OnTouchListenerC1204H) {
                        RelativeLayout relativeLayout = this.f5303k;
                        if (childAt == relativeLayout) {
                            m11132a(relativeLayout);
                            Point point = this.f5301g;
                            if (point == null) {
                                this.f5295A = this.f5303k.getMeasuredWidth();
                                this.f5317z = this.f5303k.getMeasuredHeight();
                                int i10 = (int) (this.f5313v + (5.0f * f2));
                                int height3 = (getHeight() - ((int) ((this.f5316y + (f * 5.0f)) + 56.0f))) - this.f5298d.getMeasuredHeight();
                                this.f5303k.layout(i10, height3, this.f5295A + i10, this.f5317z + height3);
                            } else {
                                this.f5303k.layout(point.x, this.f5301g.y, this.f5301g.x + this.f5303k.getMeasuredWidth(), this.f5301g.y + this.f5303k.getMeasuredHeight());
                            }
                        } else {
                            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                            if (layoutParams instanceof MapViewLayoutParams) {
                                MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                Point m10723a = mapViewLayoutParams.f5139c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f5138b : this.f5296b.m10783b().m10723a(CoordUtil.ll2mc(mapViewLayoutParams.f5137a));
                                m11132a(childAt);
                                int measuredWidth3 = childAt.getMeasuredWidth();
                                int measuredHeight2 = childAt.getMeasuredHeight();
                                float f5 = mapViewLayoutParams.f5140d;
                                int i11 = (int) (m10723a.x - (f5 * measuredWidth3));
                                int i12 = ((int) (m10723a.y - (mapViewLayoutParams.f5141e * measuredHeight2))) + mapViewLayoutParams.f5142f;
                                childAt.layout(i11, i12, measuredWidth3 + i11, measuredHeight2 + i12);
                            }
                        }
                    } else if (view$OnTouchListenerC1204H.m10771a()) {
                        m11132a(this.f5300f);
                        Point point2 = this.f5302h;
                        if (point2 == null) {
                            int height4 = (int) (((getHeight() - 15) * f) + this.f5315x);
                            int width4 = (int) (((getWidth() - 15) * f2) + this.f5313v);
                            int measuredWidth4 = width4 - this.f5300f.getMeasuredWidth();
                            int measuredHeight3 = height4 - this.f5300f.getMeasuredHeight();
                            if (this.f5310s == 4) {
                                height4 -= this.f5298d.getMeasuredHeight();
                                measuredHeight3 -= this.f5298d.getMeasuredHeight();
                            }
                            this.f5300f.layout(measuredWidth4, measuredHeight3, width4, height4);
                        } else {
                            this.f5300f.layout(point2.x, this.f5302h.y, this.f5302h.x + this.f5300f.getMeasuredWidth(), this.f5302h.y + this.f5300f.getMeasuredHeight());
                        }
                    }
                }
            }
        }
    }

    public final void onPause() {
        this.f5296b.m10780d();
    }

    public final void onResume() {
        this.f5296b.m10781c();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.f5297c) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        Point point = this.f5301g;
        if (point != null) {
            bundle.putParcelable("scalePosition", point);
        }
        Point point2 = this.f5302h;
        if (point2 != null) {
            bundle.putParcelable("zoomPosition", point2);
        }
        bundle.putBoolean("mZoomControlEnabled", this.f5311t);
        bundle.putBoolean("mScaleControlEnabled", this.f5312u);
        bundle.putInt("logoPosition", this.f5310s);
        bundle.putInt("paddingLeft", this.f5313v);
        bundle.putInt("paddingTop", this.f5315x);
        bundle.putInt("paddingRight", this.f5314w);
        bundle.putInt("paddingBottom", this.f5316y);
        bundle.putString("customMapPath", f5292i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (view == this.f5298d) {
            return;
        }
        super.removeView(view);
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            this.f5310s = LogoPosition.logoPostionleftBottom.ordinal();
        }
        this.f5310s = logoPosition.ordinal();
        requestLayout();
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        this.f5313v = i;
        this.f5315x = i2;
        this.f5314w = i3;
        this.f5316y = i4;
    }

    public final void setScaleControlPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.f5301g = point;
            requestLayout();
        }
    }

    public final void setZoomControlsPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.f5302h = point;
            requestLayout();
        }
    }

    public final void showScaleControl(boolean z) {
        this.f5303k.setVisibility(z ? 0 : 8);
        this.f5312u = z;
    }

    public final void showZoomControls(boolean z) {
        if (this.f5300f.m10771a()) {
            this.f5300f.setVisibility(z ? 0 : 8);
            this.f5311t = z;
        }
    }
}
