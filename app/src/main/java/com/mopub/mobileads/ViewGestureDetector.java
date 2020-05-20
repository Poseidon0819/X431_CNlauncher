package com.mopub.mobileads;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.common.AdReport;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdAlertGestureListener;

/* loaded from: classes.dex */
public class ViewGestureDetector extends GestureDetector {

    /* renamed from: a */
    private final View f20498a;

    /* renamed from: b */
    private AdAlertGestureListener f20499b;

    /* renamed from: c */
    private UserClickListener f20500c;

    /* loaded from: classes.dex */
    public interface UserClickListener {
        void onResetUserClick();

        void onUserClick();

        boolean wasClicked();
    }

    public ViewGestureDetector(Context context, View view, AdReport adReport) {
        this(context, view, new AdAlertGestureListener(view, adReport));
    }

    private ViewGestureDetector(Context context, View view, AdAlertGestureListener adAlertGestureListener) {
        super(context, adAlertGestureListener);
        this.f20499b = adAlertGestureListener;
        this.f20498a = view;
        setIsLongpressEnabled(false);
    }

    public void sendTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                onTouchEvent(motionEvent);
                return;
            case 1:
                UserClickListener userClickListener = this.f20500c;
                if (userClickListener != null) {
                    userClickListener.onUserClick();
                } else {
                    MoPubLog.m2498d("View's onUserClick() is not registered.");
                }
                AdAlertGestureListener adAlertGestureListener = this.f20499b;
                if (adAlertGestureListener.f20252c == AdAlertGestureListener.EnumC3717a.FINISHED$34b17a83) {
                    adAlertGestureListener.f20251b = new AdAlertReporter(adAlertGestureListener.f20253d.getContext(), adAlertGestureListener.f20253d, adAlertGestureListener.f20250a);
                    adAlertGestureListener.f20251b.send();
                }
                adAlertGestureListener.m2478a();
                return;
            case 2:
                View view = this.f20498a;
                boolean z = false;
                if (motionEvent != null && view != null) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (x >= ColumnText.GLOBAL_SPACE_CHAR_RATIO && x <= view.getWidth() && y >= ColumnText.GLOBAL_SPACE_CHAR_RATIO && y <= view.getHeight()) {
                        z = true;
                    }
                }
                if (z) {
                    onTouchEvent(motionEvent);
                    return;
                } else {
                    this.f20499b.m2478a();
                    return;
                }
            default:
                return;
        }
    }

    public void setUserClickListener(UserClickListener userClickListener) {
        this.f20500c = userClickListener;
    }
}
