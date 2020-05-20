package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
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
import com.baidu.mapsdkplatform.comapi.map.C1210e;
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
import javax.microedition.khronos.opengles.GL10;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public final class MapView extends ViewGroup {

    /* renamed from: a */
    private static final String f5107a = "MapView";

    /* renamed from: b */
    private static String f5108b;

    /* renamed from: c */
    private static int f5109c;

    /* renamed from: p */
    private static final SparseArray<Integer> f5110p;

    /* renamed from: A */
    private int f5111A;

    /* renamed from: d */
    private GestureDetector$OnDoubleTapListenerC1216j f5112d;

    /* renamed from: e */
    private BaiduMap f5113e;

    /* renamed from: f */
    private ImageView f5114f;

    /* renamed from: g */
    private Bitmap f5115g;

    /* renamed from: h */
    private View$OnTouchListenerC1204H f5116h;

    /* renamed from: i */
    private Point f5117i;

    /* renamed from: j */
    private Point f5118j;

    /* renamed from: k */
    private RelativeLayout f5119k;

    /* renamed from: l */
    private TextView f5120l;

    /* renamed from: m */
    private TextView f5121m;

    /* renamed from: n */
    private ImageView f5122n;

    /* renamed from: o */
    private Context f5123o;

    /* renamed from: q */
    private int f5124q;

    /* renamed from: r */
    private boolean f5125r;

    /* renamed from: s */
    private boolean f5126s;

    /* renamed from: t */
    private float f5127t;

    /* renamed from: u */
    private InterfaceC1219k f5128u;

    /* renamed from: v */
    private int f5129v;

    /* renamed from: w */
    private int f5130w;

    /* renamed from: x */
    private int f5131x;

    /* renamed from: y */
    private int f5132y;

    /* renamed from: z */
    private int f5133z;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        f5110p = sparseArray;
        sparseArray.append(3, 2000000);
        f5110p.append(4, 1000000);
        f5110p.append(5, 500000);
        f5110p.append(6, 200000);
        f5110p.append(7, 100000);
        f5110p.append(8, 50000);
        f5110p.append(9, 25000);
        f5110p.append(10, Integer.valueOf((int) TranslateManager.TIME_OUT));
        f5110p.append(11, 10000);
        f5110p.append(12, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_GPS));
        f5110p.append(13, 2000);
        f5110p.append(14, 1000);
        f5110p.append(15, Integer.valueOf((int) UIMsg.d_ResultType.SHORT_URL));
        f5110p.append(16, Integer.valueOf((int) PdfContentParser.COMMAND_TYPE));
        f5110p.append(17, 100);
        f5110p.append(18, 50);
        f5110p.append(19, 20);
        f5110p.append(20, 10);
        f5110p.append(21, 5);
        f5110p.append(22, 2);
        f5110p.append(23, 2);
        f5110p.append(24, 2);
        f5110p.append(25, 2);
        f5110p.append(26, 2);
    }

    public MapView(Context context) {
        super(context);
        this.f5124q = LogoPosition.logoPostionleftBottom.ordinal();
        this.f5125r = true;
        this.f5126s = true;
        m11169a(context, (BaiduMapOptions) null);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5124q = LogoPosition.logoPostionleftBottom.ordinal();
        this.f5125r = true;
        this.f5126s = true;
        m11169a(context, (BaiduMapOptions) null);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5124q = LogoPosition.logoPostionleftBottom.ordinal();
        this.f5125r = true;
        this.f5126s = true;
        m11169a(context, (BaiduMapOptions) null);
    }

    public MapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.f5124q = LogoPosition.logoPostionleftBottom.ordinal();
        this.f5125r = true;
        this.f5126s = true;
        m11169a(context, baiduMapOptions);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m11170a(android.content.Context r10) {
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
            r9.f5115g = r0
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
            r9.f5115g = r2
        L40:
            android.graphics.Bitmap r0 = r9.f5115g
            if (r0 == 0) goto L57
            android.widget.ImageView r0 = new android.widget.ImageView
            r0.<init>(r10)
            r9.f5114f = r0
            android.widget.ImageView r10 = r9.f5114f
            android.graphics.Bitmap r0 = r9.f5115g
            r10.setImageBitmap(r0)
            android.widget.ImageView r10 = r9.f5114f
            r9.addView(r10)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.MapView.m11170a(android.content.Context):void");
    }

    /* renamed from: a */
    private void m11169a(Context context, BaiduMapOptions baiduMapOptions) {
        this.f5123o = context;
        C1215i.m10646a();
        BMapManager.init();
        m11168a(context, baiduMapOptions, f5108b, f5109c);
        this.f5113e = new BaiduMap(this.f5112d);
        m11170a(context);
        m11163b(context);
        if (baiduMapOptions != null && !baiduMapOptions.f4977h) {
            this.f5116h.setVisibility(4);
        }
        m11161c(context);
        if (baiduMapOptions != null && !baiduMapOptions.f4978i) {
            this.f5119k.setVisibility(4);
        }
        if (baiduMapOptions != null && baiduMapOptions.f4979j != null) {
            this.f5124q = baiduMapOptions.f4979j.ordinal();
        }
        if (baiduMapOptions != null && baiduMapOptions.f4981l != null) {
            this.f5118j = baiduMapOptions.f4981l;
        }
        if (baiduMapOptions == null || baiduMapOptions.f4980k == null) {
            return;
        }
        this.f5117i = baiduMapOptions.f4980k;
    }

    /* renamed from: a */
    private void m11168a(Context context, BaiduMapOptions baiduMapOptions, String str, int i) {
        if (baiduMapOptions == null) {
            this.f5112d = new GestureDetector$OnDoubleTapListenerC1216j(context, null, str, i);
        } else {
            this.f5112d = new GestureDetector$OnDoubleTapListenerC1216j(context, baiduMapOptions.m11222a(), str, i);
        }
        addView(this.f5112d);
        this.f5128u = new InterfaceC1219k() { // from class: com.baidu.mapapi.map.MapView.1
            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10622a() {
                if (MapView.this.f5112d == null || MapView.this.f5112d.m10642a() == null) {
                    return;
                }
                float f = MapView.this.f5112d.m10642a().m10753E().f6114a;
                if (f < MapView.this.f5112d.m10642a().f6004b) {
                    f = MapView.this.f5112d.m10642a().f6004b;
                } else if (f > MapView.this.f5112d.m10642a().f5983a) {
                    f = MapView.this.f5112d.m10642a().f5983a;
                }
                if (Math.abs(MapView.this.f5127t - f) > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    int intValue = ((Integer) MapView.f5110p.get(Math.round(f))).intValue();
                    double d = intValue;
                    double d2 = MapView.this.f5112d.m10642a().m10753E().f6126m;
                    Double.isNaN(d);
                    int i2 = ((int) (d / d2)) / 2;
                    MapView.this.f5122n.setPadding(i2, 0, i2, 0);
                    String format = intValue >= 1000 ? String.format(" %d公里 ", Integer.valueOf(intValue / 1000)) : String.format(" %d米 ", Integer.valueOf(intValue));
                    MapView.this.f5120l.setText(format);
                    MapView.this.f5121m.setText(format);
                    MapView.this.f5127t = f;
                }
                MapView.this.m11164b();
                MapView.this.requestLayout();
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
        this.f5112d.m10642a().m10720a(this.f5128u);
    }

    /* renamed from: a */
    private void m11167a(View view) {
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
    public void m11164b() {
        if (this.f5116h.m10771a()) {
            float f = this.f5112d.m10642a().m10753E().f6114a;
            this.f5116h.m10763b(f > this.f5112d.m10642a().f6004b);
            this.f5116h.m10766a(f < this.f5112d.m10642a().f5983a);
        }
    }

    /* renamed from: b */
    private void m11163b(Context context) {
        this.f5116h = new View$OnTouchListenerC1204H(context, false);
        if (this.f5116h.m10771a()) {
            this.f5116h.m10764b(new View.OnClickListener() { // from class: com.baidu.mapapi.map.MapView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    float f = MapView.this.f5112d.m10642a().f6004b;
                    C1236z m10753E = MapView.this.f5112d.m10642a().m10753E();
                    m10753E.f6114a -= 1.0f;
                    if (m10753E.f6114a >= f) {
                        f = m10753E.f6114a;
                    }
                    m10753E.f6114a = f;
                    BaiduMap.mapStatusReason |= 16;
                    MapView.this.f5112d.m10642a().m10716a(m10753E, 300);
                }
            });
            this.f5116h.m10769a(new View.OnClickListener() { // from class: com.baidu.mapapi.map.MapView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    float f = MapView.this.f5112d.m10642a().f5983a;
                    C1236z m10753E = MapView.this.f5112d.m10642a().m10753E();
                    m10753E.f6114a += 1.0f;
                    if (m10753E.f6114a <= f) {
                        f = m10753E.f6114a;
                    }
                    m10753E.f6114a = f;
                    BaiduMap.mapStatusReason |= 16;
                    MapView.this.f5112d.m10642a().m10716a(m10753E, 300);
                }
            });
            addView(this.f5116h);
        }
    }

    /* renamed from: c */
    private void m11161c(Context context) {
        this.f5119k = new RelativeLayout(context);
        this.f5119k.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f5120l = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.f5120l.setTextColor(Color.parseColor("#FFFFFF"));
        this.f5120l.setTextSize(2, 11.0f);
        TextView textView = this.f5120l;
        textView.setTypeface(textView.getTypeface(), 1);
        this.f5120l.setLayoutParams(layoutParams);
        this.f5120l.setId(MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT);
        this.f5119k.addView(this.f5120l);
        this.f5121m = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(14);
        this.f5121m.setTextColor(Color.parseColor("#000000"));
        this.f5121m.setTextSize(2, 11.0f);
        this.f5121m.setLayoutParams(layoutParams2);
        this.f5119k.addView(this.f5121m);
        this.f5122n = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.f5120l.getId());
        this.f5122n.setLayoutParams(layoutParams3);
        Bitmap m10820a = C1190a.m10820a("icon_scale.9.png", context);
        byte[] ninePatchChunk = m10820a.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        this.f5122n.setBackgroundDrawable(new NinePatchDrawable(m10820a, ninePatchChunk, new Rect(), null));
        this.f5119k.addView(this.f5122n);
        addView(this.f5119k);
    }

    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("customMapStylePath String is illegal");
        }
        if (!new File(str).exists()) {
            throw new RuntimeException("please check whether the customMapStylePath file exits");
        }
        f5108b = str;
    }

    public static void setIconCustom(int i) {
        f5109c = i;
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

    public final void cancelRenderMap() {
        this.f5112d.m10642a().m10651v(false);
        this.f5112d.m10642a().m10743O().clear();
    }

    public final LogoPosition getLogoPosition() {
        switch (this.f5124q) {
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
        BaiduMap baiduMap = this.f5113e;
        baiduMap.f4939a = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return f5110p.get((int) this.f5112d.m10642a().m10753E().f6114a).intValue();
    }

    public final int getScaleControlViewHeight() {
        return this.f5133z;
    }

    public final int getScaleControlViewWidth() {
        return this.f5111A;
    }

    public final boolean handleMultiTouch(float f, float f2, float f3, float f4) {
        GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f5112d;
        return gestureDetector$OnDoubleTapListenerC1216j != null && gestureDetector$OnDoubleTapListenerC1216j.m10640a(f, f2, f3, f4);
    }

    public final void handleTouchDown(float f, float f2) {
        GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f5112d;
        if (gestureDetector$OnDoubleTapListenerC1216j == null) {
            return;
        }
        gestureDetector$OnDoubleTapListenerC1216j.m10641a(f, f2);
    }

    public final boolean handleTouchMove(float f, float f2) {
        GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f5112d;
        return gestureDetector$OnDoubleTapListenerC1216j != null && gestureDetector$OnDoubleTapListenerC1216j.m10630c(f, f2);
    }

    public final boolean handleTouchUp(float f, float f2) {
        GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f5112d;
        if (gestureDetector$OnDoubleTapListenerC1216j == null) {
            return false;
        }
        return gestureDetector$OnDoubleTapListenerC1216j.m10634b(f, f2);
    }

    public final boolean inRangeOfView(float f, float f2) {
        GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f5112d;
        return gestureDetector$OnDoubleTapListenerC1216j != null && gestureDetector$OnDoubleTapListenerC1216j.m10627d(f, f2);
    }

    public final void onCreate(Context context, Bundle bundle) {
        BaiduMapOptions mapStatus;
        if (bundle == null) {
            return;
        }
        f5108b = bundle.getString("customMapPath");
        if (bundle == null) {
            mapStatus = new BaiduMapOptions();
        } else {
            MapStatus mapStatus2 = (MapStatus) bundle.getParcelable("mapstatus");
            if (this.f5117i != null) {
                this.f5117i = (Point) bundle.getParcelable("scalePosition");
            }
            if (this.f5118j != null) {
                this.f5118j = (Point) bundle.getParcelable("zoomPosition");
            }
            this.f5125r = bundle.getBoolean("mZoomControlEnabled");
            this.f5126s = bundle.getBoolean("mScaleControlEnabled");
            this.f5124q = bundle.getInt("logoPosition");
            setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
            mapStatus = new BaiduMapOptions().mapStatus(mapStatus2);
        }
        m11169a(context, mapStatus);
    }

    public final void onDestroy() {
        Context context = this.f5123o;
        if (context != null) {
            this.f5112d.m10633b(context.hashCode());
        }
        Bitmap bitmap = this.f5115g;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5115g.recycle();
            this.f5115g = null;
        }
        if (f5108b != null) {
            f5108b = null;
        }
        this.f5116h.m10765b();
        BMapManager.destroy();
        C1215i.m10643b();
        this.f5123o = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int measuredHeight;
        int measuredWidth;
        int height;
        int height2;
        int childCount = getChildCount();
        m11167a(this.f5114f);
        float f2 = 1.0f;
        if (((getWidth() - this.f5129v) - this.f5130w) - this.f5114f.getMeasuredWidth() <= 0 || ((getHeight() - this.f5131x) - this.f5132y) - this.f5114f.getMeasuredHeight() <= 0) {
            this.f5129v = 0;
            this.f5130w = 0;
            this.f5132y = 0;
            this.f5131x = 0;
            f = 1.0f;
        } else {
            f2 = ((getWidth() - this.f5129v) - this.f5130w) / getWidth();
            f = ((getHeight() - this.f5131x) - this.f5132y) / getHeight();
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f5112d;
                if (childAt == gestureDetector$OnDoubleTapListenerC1216j) {
                    gestureDetector$OnDoubleTapListenerC1216j.layout(0, 0, getWidth(), getHeight());
                } else {
                    ImageView imageView = this.f5114f;
                    if (childAt == imageView) {
                        float f3 = f2 * 5.0f;
                        int i6 = (int) (this.f5129v + f3);
                        int i7 = (int) (this.f5130w + f3);
                        float f4 = 5.0f * f;
                        int i8 = (int) (this.f5131x + f4);
                        int i9 = (int) (this.f5132y + f4);
                        switch (this.f5124q) {
                            case 1:
                                measuredHeight = imageView.getMeasuredHeight() + i8;
                                measuredWidth = this.f5114f.getMeasuredWidth() + i6;
                                break;
                            case 2:
                                height = getHeight() - i9;
                                i8 = height - this.f5114f.getMeasuredHeight();
                                int width = (((getWidth() - this.f5114f.getMeasuredWidth()) + this.f5129v) - this.f5130w) / 2;
                                measuredWidth = (((getWidth() + this.f5114f.getMeasuredWidth()) + this.f5129v) - this.f5130w) / 2;
                                measuredHeight = height;
                                i6 = width;
                                break;
                            case 3:
                                height = imageView.getMeasuredHeight() + i8;
                                int width2 = (((getWidth() - this.f5114f.getMeasuredWidth()) + this.f5129v) - this.f5130w) / 2;
                                measuredWidth = (((getWidth() + this.f5114f.getMeasuredWidth()) + this.f5129v) - this.f5130w) / 2;
                                measuredHeight = height;
                                i6 = width2;
                                break;
                            case 4:
                                height2 = getHeight() - i9;
                                i8 = height2 - this.f5114f.getMeasuredHeight();
                                int width3 = getWidth() - i7;
                                int measuredWidth2 = width3 - this.f5114f.getMeasuredWidth();
                                measuredHeight = height2;
                                i6 = measuredWidth2;
                                measuredWidth = width3;
                                break;
                            case 5:
                                height2 = imageView.getMeasuredHeight() + i8;
                                int width32 = getWidth() - i7;
                                int measuredWidth22 = width32 - this.f5114f.getMeasuredWidth();
                                measuredHeight = height2;
                                i6 = measuredWidth22;
                                measuredWidth = width32;
                                break;
                            default:
                                measuredHeight = getHeight() - i9;
                                measuredWidth = this.f5114f.getMeasuredWidth() + i6;
                                i8 = measuredHeight - this.f5114f.getMeasuredHeight();
                                break;
                        }
                        this.f5114f.layout(i6, i8, measuredWidth, measuredHeight);
                    } else {
                        View$OnTouchListenerC1204H view$OnTouchListenerC1204H = this.f5116h;
                        if (childAt != view$OnTouchListenerC1204H) {
                            RelativeLayout relativeLayout = this.f5119k;
                            if (childAt == relativeLayout) {
                                m11167a(relativeLayout);
                                Point point = this.f5117i;
                                if (point == null) {
                                    this.f5111A = this.f5119k.getMeasuredWidth();
                                    this.f5133z = this.f5119k.getMeasuredHeight();
                                    int i10 = (int) (this.f5129v + (5.0f * f2));
                                    int height3 = (getHeight() - ((int) ((this.f5132y + (f * 5.0f)) + 56.0f))) - this.f5114f.getMeasuredHeight();
                                    this.f5119k.layout(i10, height3, this.f5111A + i10, this.f5133z + height3);
                                } else {
                                    this.f5119k.layout(point.x, this.f5117i.y, this.f5117i.x + this.f5119k.getMeasuredWidth(), this.f5117i.y + this.f5119k.getMeasuredHeight());
                                }
                            } else {
                                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                if (layoutParams == null) {
                                    Log.e("test", "lp == null");
                                }
                                if (layoutParams instanceof MapViewLayoutParams) {
                                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                    Point m10723a = mapViewLayoutParams.f5139c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f5138b : this.f5112d.m10642a().m10723a(CoordUtil.ll2mc(mapViewLayoutParams.f5137a));
                                    m11167a(childAt);
                                    int measuredWidth3 = childAt.getMeasuredWidth();
                                    int measuredHeight2 = childAt.getMeasuredHeight();
                                    float f5 = mapViewLayoutParams.f5140d;
                                    int i11 = (int) (m10723a.x - (f5 * measuredWidth3));
                                    int i12 = ((int) (m10723a.y - (mapViewLayoutParams.f5141e * measuredHeight2))) + mapViewLayoutParams.f5142f;
                                    childAt.layout(i11, i12, measuredWidth3 + i11, measuredHeight2 + i12);
                                }
                            }
                        } else if (view$OnTouchListenerC1204H.m10771a()) {
                            m11167a(this.f5116h);
                            Point point2 = this.f5118j;
                            if (point2 == null) {
                                int height4 = (int) (((getHeight() - 15) * f) + this.f5131x);
                                int width4 = (int) (((getWidth() - 15) * f2) + this.f5129v);
                                int measuredWidth4 = width4 - this.f5116h.getMeasuredWidth();
                                int measuredHeight3 = height4 - this.f5116h.getMeasuredHeight();
                                if (this.f5124q == 4) {
                                    height4 -= this.f5114f.getMeasuredHeight();
                                    measuredHeight3 -= this.f5114f.getMeasuredHeight();
                                }
                                this.f5116h.layout(measuredWidth4, measuredHeight3, width4, height4);
                            } else {
                                this.f5116h.layout(point2.x, this.f5118j.y, this.f5118j.x + this.f5116h.getMeasuredWidth(), this.f5118j.y + this.f5116h.getMeasuredHeight());
                            }
                        }
                    }
                }
            }
        }
    }

    public final void onPause() {
        this.f5112d.onPause();
    }

    public final void onResume() {
        this.f5112d.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.f5113e) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        Point point = this.f5117i;
        if (point != null) {
            bundle.putParcelable("scalePosition", point);
        }
        Point point2 = this.f5118j;
        if (point2 != null) {
            bundle.putParcelable("zoomPosition", point2);
        }
        bundle.putBoolean("mZoomControlEnabled", this.f5125r);
        bundle.putBoolean("mScaleControlEnabled", this.f5126s);
        bundle.putInt("logoPosition", this.f5124q);
        bundle.putInt("paddingLeft", this.f5129v);
        bundle.putInt("paddingTop", this.f5131x);
        bundle.putInt("paddingRight", this.f5130w);
        bundle.putInt("paddingBottom", this.f5132y);
        bundle.putString("customMapPath", f5108b);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (view == this.f5114f) {
            return;
        }
        super.removeView(view);
    }

    public final void renderMap() {
        C1210e m10642a = this.f5112d.m10642a();
        m10642a.m10651v(true);
        m10642a.m10742P();
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            this.f5124q = LogoPosition.logoPostionleftBottom.ordinal();
        }
        this.f5124q = logoPosition.ordinal();
        requestLayout();
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        this.f5129v = i;
        this.f5131x = i2;
        this.f5130w = i3;
        this.f5132y = i4;
    }

    public final void setScaleControlPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.f5117i = point;
            requestLayout();
        }
    }

    public final void setUpViewEventToMapView(MotionEvent motionEvent) {
        this.f5112d.onTouchEvent(motionEvent);
    }

    public final void setZOrderMediaOverlay(boolean z) {
        GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f5112d;
        if (gestureDetector$OnDoubleTapListenerC1216j == null) {
            return;
        }
        gestureDetector$OnDoubleTapListenerC1216j.setZOrderMediaOverlay(z);
    }

    public final void setZoomControlsPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.f5118j = point;
            requestLayout();
        }
    }

    public final void showScaleControl(boolean z) {
        this.f5119k.setVisibility(z ? 0 : 8);
        this.f5126s = z;
    }

    public final void showZoomControls(boolean z) {
        if (this.f5116h.m10771a()) {
            this.f5116h.setVisibility(z ? 0 : 8);
            this.f5125r = z;
        }
    }
}
