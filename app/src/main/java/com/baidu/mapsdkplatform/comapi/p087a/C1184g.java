package com.baidu.mapsdkplatform.comapi.p087a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;

/* renamed from: com.baidu.mapsdkplatform.comapi.a.g */
/* loaded from: classes.dex */
public class C1184g extends AbstractC1175b {

    /* renamed from: a */
    private Animator f5869a = null;

    /* renamed from: b */
    private long f5870b = 0;

    /* renamed from: c */
    private Interpolator f5871c = null;

    /* renamed from: d */
    private Animation.AnimationListener f5872d = null;

    /* renamed from: e */
    private int f5873e = 1;

    /* renamed from: f */
    private int f5874f = 0;

    /* renamed from: g */
    private Object[] f5875g;

    @TargetApi(11)
    /* renamed from: com.baidu.mapsdkplatform.comapi.a.g$a */
    /* loaded from: classes.dex */
    public class C1186a implements TypeEvaluator {
        public C1186a() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = latLng.longitude;
            double d2 = f;
            Double.isNaN(d2);
            double d3 = d + ((latLng2.longitude - latLng.longitude) * d2);
            double d4 = latLng.latitude;
            Double.isNaN(d2);
            return new LatLng(d4 + (d2 * (latLng2.latitude - latLng.latitude)), d3);
        }
    }

    @TargetApi(11)
    /* renamed from: com.baidu.mapsdkplatform.comapi.a.g$b */
    /* loaded from: classes.dex */
    public class C1187b implements TypeEvaluator {
        public C1187b() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            Point point = (Point) obj;
            Point point2 = (Point) obj2;
            return new Point((int) (point.x + ((point2.x - point.x) * f)), (int) (point.y + (f * (point2.y - point.y))));
        }
    }

    public C1184g(Point... pointArr) {
        this.f5875g = pointArr;
    }

    public C1184g(LatLng... latLngArr) {
        this.f5875g = latLngArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(11)
    /* renamed from: a */
    public ObjectAnimator m10831a(Marker marker) {
        String str;
        TypeEvaluator c1186a;
        if (marker.isFixed()) {
            if (!(this.f5875g[0] instanceof Point)) {
                throw new ClassCastException("if the marker is fixed on screen, the parameters of Transformation must be android.graphics.Point");
            }
            str = "fixedScreenPosition";
            c1186a = new C1187b();
        } else if (!(this.f5875g[0] instanceof LatLng)) {
            throw new ClassCastException("if the marker isn't fixed on screen, the parameters of Transformation must be Latlng");
        } else {
            str = "position";
            c1186a = new C1186a();
        }
        ObjectAnimator ofObject = ObjectAnimator.ofObject(marker, str, c1186a, this.f5875g);
        if (ofObject != null) {
            ofObject.setRepeatCount(this.f5874f);
            ofObject.setRepeatMode(m10826c());
            ofObject.setDuration(this.f5870b);
            Interpolator interpolator = this.f5871c;
            if (interpolator != null) {
                ofObject.setInterpolator(interpolator);
            }
        }
        return ofObject;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    public void mo10837a() {
        Animator animator = this.f5869a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10836a(int i) {
        this.f5873e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10835a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f5870b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    protected void mo10834a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.mapsdkplatform.comapi.a.g.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                if (C1184g.this.f5872d != null) {
                    C1184g.this.f5872d.onAnimationCancel();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                if (C1184g.this.f5872d != null) {
                    C1184g.this.f5872d.onAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                if (C1184g.this.f5872d != null) {
                    C1184g.this.f5872d.onAnimationRepeat();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                if (C1184g.this.f5872d != null) {
                    C1184g.this.f5872d.onAnimationStart();
                }
            }
        });
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10833a(Interpolator interpolator) {
        this.f5871c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10832a(Animation.AnimationListener animationListener) {
        this.f5872d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    public void mo10830a(Marker marker, Animation animation) {
        this.f5869a = m10831a(marker);
        mo10834a(this.f5869a);
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: b */
    public void mo10828b() {
        Animator animator = this.f5869a;
        if (animator != null) {
            animator.cancel();
            this.f5869a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: b */
    public void mo10827b(int i) {
        if (i > 0) {
            this.f5874f = i;
        }
    }

    /* renamed from: c */
    public int m10826c() {
        return this.f5873e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: c */
    public void mo10825c(int i) {
    }
}
