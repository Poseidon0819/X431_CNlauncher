package com.artifex.mupdflib;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.WindowManager;
import com.artifex.mupdflib.MuPDFCore;
import com.artifex.mupdflib.ReaderView;

/* loaded from: classes.dex */
public class MuPDFReaderView extends ReaderView {
    private static final float TOUCH_TOLERANCE = 2.0f;
    private MuPDFCore.Callback callback;
    private final Context mContext;
    private boolean mLinksHighlighted;
    private Mode mMode;

    /* renamed from: mX */
    private float f3559mX;

    /* renamed from: mY */
    private float f3560mY;
    private boolean tapDisabled;
    private int tapPageMargin;

    /* loaded from: classes.dex */
    public enum Mode {
        Viewing,
        Selecting,
        Drawing
    }

    private void touch_up() {
    }

    protected void onDocMotion() {
    }

    protected void onHit(Hit hit) {
    }

    protected void onTapMainDocArea() {
    }

    public void setLinksHighlighted(boolean z) {
        this.mLinksHighlighted = z;
        resetupChildren();
    }

    public void setMode(Mode mode) {
        this.mMode = mode;
    }

    private void setup() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.tapPageMargin = (int) displayMetrics.xdpi;
        if (this.tapPageMargin < 80) {
            this.tapPageMargin = 80;
        }
        if (this.tapPageMargin > displayMetrics.widthPixels / 6) {
            this.tapPageMargin = displayMetrics.widthPixels / 6;
        }
    }

    public MuPDFReaderView(Context context, MuPDFCore.Callback callback) {
        super(context);
        this.mLinksHighlighted = false;
        this.mMode = Mode.Viewing;
        this.tapDisabled = false;
        this.callback = callback;
        this.mContext = context;
        setup();
    }

    @Override // com.artifex.mupdflib.ReaderView, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return super.onDown(motionEvent);
    }

    @Override // com.artifex.mupdflib.ReaderView, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        MuPDFView muPDFView = (MuPDFView) getDisplayedView();
        switch (this.mMode) {
            case Viewing:
                if (!this.tapDisabled) {
                    onDocMotion();
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            case Selecting:
                if (muPDFView != null) {
                    muPDFView.selectText(motionEvent.getX(), motionEvent.getY(), motionEvent2.getX(), motionEvent2.getY());
                }
                return true;
            default:
                return true;
        }
    }

    @Override // com.artifex.mupdflib.ReaderView
    public void movingLeft(int i) {
        super.movingLeft(i);
    }

    @Override // com.artifex.mupdflib.ReaderView
    public void movingRight() {
        super.movingRight();
    }

    @Override // com.artifex.mupdflib.ReaderView, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (C08242.$SwitchMap$com$artifex$mupdflib$MuPDFReaderView$Mode[this.mMode.ordinal()] != 1) {
            return true;
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // com.artifex.mupdflib.ReaderView, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.tapDisabled = true;
        return super.onScaleBegin(scaleGestureDetector);
    }

    @Override // com.artifex.mupdflib.ReaderView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mMode == Mode.Drawing) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    touch_start(x, y);
                    break;
                case 1:
                    touch_up();
                    break;
                case 2:
                    touch_move(x, y);
                    break;
            }
        }
        if ((motionEvent.getAction() & motionEvent.getActionMasked()) == 0) {
            this.tapDisabled = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void touch_start(float f, float f2) {
        MuPDFView muPDFView = (MuPDFView) getDisplayedView();
        if (muPDFView != null) {
            muPDFView.startDraw(f, f2);
        }
        this.f3559mX = f;
        this.f3560mY = f2;
    }

    private void touch_move(float f, float f2) {
        float abs = Math.abs(f - this.f3559mX);
        float abs2 = Math.abs(f2 - this.f3560mY);
        if (abs >= 2.0f || abs2 >= 2.0f) {
            MuPDFView muPDFView = (MuPDFView) getDisplayedView();
            if (muPDFView != null) {
                muPDFView.continueDraw(f, f2);
            }
            this.f3559mX = f;
            this.f3560mY = f2;
        }
    }

    @Override // com.artifex.mupdflib.ReaderView
    protected void onChildSetup(int i, View view) {
        if (SearchTaskResult.get() != null && SearchTaskResult.get().pageNumber == i) {
            MuPDFView muPDFView = (MuPDFView) view;
            muPDFView.setSearchBoxes(SearchTaskResult.get().searchBoxes);
            muPDFView.setSearchBoxesPrim(SearchTaskResult.get().searchBoxesPrim);
        } else {
            MuPDFView muPDFView2 = (MuPDFView) view;
            muPDFView2.setSearchBoxes(null);
            muPDFView2.setSearchBoxesPrim(null);
        }
        MuPDFView muPDFView3 = (MuPDFView) view;
        muPDFView3.setLinkHighlighting(this.mLinksHighlighted);
        muPDFView3.setChangeReporter(new Runnable() { // from class: com.artifex.mupdflib.MuPDFReaderView.1
            @Override // java.lang.Runnable
            public void run() {
                MuPDFReaderView.this.applyToChildren(new ReaderView.ViewMapper() { // from class: com.artifex.mupdflib.MuPDFReaderView.1.1
                    @Override // com.artifex.mupdflib.ReaderView.ViewMapper
                    public void applyToView(View view2) {
                        ((MuPDFView) view2).update();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.artifex.mupdflib.ReaderView
    public void onMoveToChild(int i) {
        if (SearchTaskResult.get() == null || SearchTaskResult.get().pageNumber == i) {
            return;
        }
        SearchTaskResult.set(null);
        resetupChildren();
    }

    @Override // com.artifex.mupdflib.ReaderView
    protected void onMoveOffChild(int i) {
        View view = getView(i);
        if (view != null) {
            ((MuPDFView) view).deselectAnnotation();
        }
    }

    @Override // com.artifex.mupdflib.ReaderView
    protected void onSettle(View view) {
        ((MuPDFView) view).updateHq(false);
    }

    @Override // com.artifex.mupdflib.ReaderView
    protected void onUnsettle(View view) {
        ((MuPDFView) view).removeHq();
    }

    @Override // com.artifex.mupdflib.ReaderView
    protected void onNotInUse(View view) {
        ((MuPDFView) view).releaseResources();
    }

    @Override // com.artifex.mupdflib.ReaderView
    protected void onScaleChild(View view, Float f) {
        ((MuPDFView) view).setScale(f.floatValue());
    }
}
