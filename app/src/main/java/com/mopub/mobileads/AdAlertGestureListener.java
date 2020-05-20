package com.mopub.mobileads;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.AdReport;

/* loaded from: classes.dex */
public class AdAlertGestureListener extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final AdReport f20250a;

    /* renamed from: b */
    AdAlertReporter f20251b;

    /* renamed from: c */
    int f20252c = EnumC3717a.UNSET$34b17a83;

    /* renamed from: d */
    View f20253d;

    /* renamed from: e */
    private float f20254e;

    /* renamed from: f */
    private float f20255f;

    /* renamed from: g */
    private boolean f20256g;

    /* renamed from: h */
    private boolean f20257h;

    /* renamed from: i */
    private int f20258i;

    /* renamed from: j */
    private float f20259j;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.mopub.mobileads.AdAlertGestureListener$a */
    /* loaded from: classes.dex */
    static final class EnumC3717a {
        public static final int UNSET$34b17a83 = 1;
        public static final int GOING_RIGHT$34b17a83 = 2;
        public static final int GOING_LEFT$34b17a83 = 3;
        public static final int FINISHED$34b17a83 = 4;
        public static final int FAILED$34b17a83 = 5;

        /* renamed from: a */
        private static final /* synthetic */ int[] f20261a = {UNSET$34b17a83, GOING_RIGHT$34b17a83, GOING_LEFT$34b17a83, FINISHED$34b17a83, FAILED$34b17a83};

        public static int[] values$414ea003() {
            return (int[]) f20261a.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdAlertGestureListener(View view, AdReport adReport) {
        this.f20254e = 100.0f;
        if (view != null && view.getWidth() > 0) {
            this.f20254e = Math.min(100.0f, view.getWidth() / 3.0f);
        }
        this.f20253d = view;
        this.f20250a = adReport;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        boolean z;
        boolean z2;
        if (this.f20252c == EnumC3717a.FINISHED$34b17a83) {
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
        if (Math.abs(motionEvent2.getY() - motionEvent.getY()) > 100.0f) {
            this.f20252c = EnumC3717a.FAILED$34b17a83;
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
        switch (C37161.f20260a[this.f20252c - 1]) {
            case 1:
                this.f20259j = motionEvent.getX();
                if (motionEvent2.getX() > this.f20259j) {
                    this.f20252c = EnumC3717a.GOING_RIGHT$34b17a83;
                    break;
                }
                break;
            case 2:
                float x = motionEvent2.getX();
                if (this.f20257h) {
                    z = true;
                } else if (x >= this.f20259j + this.f20254e) {
                    this.f20256g = false;
                    this.f20257h = true;
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (x < this.f20255f) {
                        this.f20252c = EnumC3717a.GOING_LEFT$34b17a83;
                        this.f20259j = x;
                        break;
                    }
                }
                break;
            case 3:
                float x2 = motionEvent2.getX();
                if (this.f20256g) {
                    z2 = true;
                } else if (x2 <= this.f20259j - this.f20254e) {
                    this.f20257h = false;
                    this.f20256g = true;
                    this.f20258i++;
                    if (this.f20258i >= 4) {
                        this.f20252c = EnumC3717a.FINISHED$34b17a83;
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (x2 > this.f20255f) {
                        this.f20252c = EnumC3717a.GOING_RIGHT$34b17a83;
                        this.f20259j = x2;
                        break;
                    }
                }
                break;
        }
        this.f20255f = motionEvent2.getX();
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    /* renamed from: com.mopub.mobileads.AdAlertGestureListener$1 */
    /* loaded from: classes.dex */
    final /* synthetic */ class C37161 {

        /* renamed from: a */
        static final /* synthetic */ int[] f20260a = new int[EnumC3717a.values$414ea003().length];

        static {
            try {
                f20260a[EnumC3717a.UNSET$34b17a83 - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20260a[EnumC3717a.GOING_RIGHT$34b17a83 - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20260a[EnumC3717a.GOING_LEFT$34b17a83 - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20260a[EnumC3717a.FAILED$34b17a83 - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2478a() {
        this.f20258i = 0;
        this.f20252c = EnumC3717a.UNSET$34b17a83;
    }
}
