package com.cnlaunch.x431pro.widget.slidingmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.ifoer.expedition.p348a.C3592a;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class SlidingMenu extends RelativeLayout {

    /* renamed from: a */
    private CustomViewAbove f16738a;

    /* renamed from: b */
    private CustomViewBehind f16739b;

    /* renamed from: c */
    private InterfaceC2952d f16740c;

    /* renamed from: d */
    private InterfaceC2950b f16741d;

    /* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.SlidingMenu$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2949a {
    }

    /* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.SlidingMenu$b */
    /* loaded from: classes.dex */
    public interface InterfaceC2950b {
    }

    /* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.SlidingMenu$c */
    /* loaded from: classes.dex */
    public interface InterfaceC2951c {
    }

    /* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.SlidingMenu$d */
    /* loaded from: classes.dex */
    public interface InterfaceC2952d {
    }

    /* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.SlidingMenu$e */
    /* loaded from: classes.dex */
    public interface InterfaceC2953e {
    }

    public SlidingMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private SlidingMenu(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, 0);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f16739b = new CustomViewBehind(context);
        addView(this.f16739b, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(11);
        this.f16738a = new CustomViewAbove(context);
        addView(this.f16738a, layoutParams2);
        this.f16738a.setCustomViewBehind(this.f16739b);
        this.f16739b.setCustomViewAbove(this.f16738a);
        this.f16738a.setOnPageChangeListener(new C2958e(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3592a.C3593a.SlidingMenu);
        setMode(obtainStyledAttributes.getInt(5, 0));
        int resourceId = obtainStyledAttributes.getResourceId(11, -1);
        if (resourceId != -1) {
            setContent(resourceId);
        } else {
            setContent(new FrameLayout(context));
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(12, -1);
        if (resourceId2 != -1) {
            setMenu(resourceId2);
        } else {
            setMenu(new FrameLayout(context));
        }
        setTouchModeAbove(obtainStyledAttributes.getInt(10, 0));
        int dimension = (int) obtainStyledAttributes.getDimension(2, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(4, -1.0f);
        if (dimension != -1 && dimension2 != -1) {
            throw new IllegalStateException("Cannot set both behindOffset and behindWidth for a SlidingMenu");
        }
        if (dimension != -1) {
            setBehindOffset(dimension);
        } else if (dimension2 != -1) {
            setBehindWidth(dimension2);
        } else {
            setBehindOffset(0);
        }
        setBehindScrollScale(obtainStyledAttributes.getFloat(3, 0.33f));
        int resourceId3 = obtainStyledAttributes.getResourceId(8, -1);
        if (resourceId3 != -1) {
            setShadowDrawable(resourceId3);
        }
        setShadowWidth((int) obtainStyledAttributes.getDimension(9, ColumnText.GLOBAL_SPACE_CHAR_RATIO));
        setFadeEnabled(obtainStyledAttributes.getBoolean(1, true));
        setFadeDegree(obtainStyledAttributes.getFloat(0, 0.66f));
        setSelectorEnabled(obtainStyledAttributes.getBoolean(7, false));
        int resourceId4 = obtainStyledAttributes.getResourceId(6, -1);
        if (resourceId4 != -1) {
            setSelectorDrawable(resourceId4);
        }
        obtainStyledAttributes.recycle();
        setBackgroundColor(-16777216);
    }

    public void setContent(int i) {
        setContent(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setContent(View view) {
        this.f16738a.setContent(view);
        m4420a();
    }

    public View getContent() {
        return this.f16738a.getContent();
    }

    public void setMenu(int i) {
        setMenu(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setMenu(View view) {
        this.f16739b.setContent(view);
    }

    public View getMenu() {
        return this.f16739b.getContent();
    }

    public void setSecondaryMenu(int i) {
        setSecondaryMenu(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setSecondaryMenu(View view) {
        this.f16739b.setSecondaryContent(view);
    }

    public View getSecondaryMenu() {
        return this.f16739b.getSecondaryContent();
    }

    public void setSlidingEnabled(boolean z) {
        this.f16738a.setSlidingEnabled(z);
    }

    public void setMode(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalStateException("SlidingMenu mode must be LEFT, RIGHT, or LEFT_RIGHT");
        }
        this.f16739b.setMode(i);
    }

    public int getMode() {
        return this.f16739b.getMode();
    }

    public void setStatic(boolean z) {
        if (z) {
            setSlidingEnabled(false);
            this.f16738a.setCustomViewBehind(null);
            this.f16738a.setCurrentItem(1);
            return;
        }
        this.f16738a.setCurrentItem(1);
        this.f16738a.setCustomViewBehind(this.f16739b);
        setSlidingEnabled(true);
    }

    /* renamed from: d */
    private void m4415d() {
        this.f16738a.m4409a(0, false, 0);
    }

    /* renamed from: a */
    public final void m4420a() {
        this.f16738a.m4409a(1, false, 0);
    }

    /* renamed from: b */
    public final void m4418b() {
        if (m4416c()) {
            m4420a();
        } else {
            m4415d();
        }
    }

    /* renamed from: c */
    public final boolean m4416c() {
        return this.f16738a.getCurrentItem() == 0 || this.f16738a.getCurrentItem() == 2;
    }

    public int getBehindOffset() {
        return ((RelativeLayout.LayoutParams) this.f16739b.getLayoutParams()).rightMargin;
    }

    public void setBehindOffset(int i) {
        this.f16739b.setWidthOffset(i);
    }

    public void setBehindOffsetRes(int i) {
        setBehindOffset((int) getContext().getResources().getDimension(i));
    }

    public void setAboveOffset(int i) {
        this.f16738a.setAboveOffset(i);
    }

    public void setAboveOffsetRes(int i) {
        setAboveOffset((int) getContext().getResources().getDimension(i));
    }

    public void setBehindWidth(int i) {
        int width;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        try {
            Point point = new Point();
            Display.class.getMethod("getSize", Point.class).invoke(defaultDisplay, point);
            width = point.x;
        } catch (Exception unused) {
            width = defaultDisplay.getWidth();
        }
        setBehindOffset(width - i);
    }

    public void setBehindWidthRes(int i) {
        setBehindWidth((int) getContext().getResources().getDimension(i));
    }

    public float getBehindScrollScale() {
        return this.f16739b.getScrollScale();
    }

    public void setBehindScrollScale(float f) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO && f > 1.0f) {
            throw new IllegalStateException("ScrollScale must be between 0 and 1");
        }
        this.f16739b.setScrollScale(f);
    }

    public void setBehindCanvasTransformer(InterfaceC2949a interfaceC2949a) {
        this.f16739b.setCanvasTransformer(interfaceC2949a);
    }

    public int getTouchModeAbove() {
        return this.f16738a.getTouchMode();
    }

    public void setTouchModeAbove(int i) {
        if (i != 1 && i != 0 && i != 2) {
            throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
        }
        this.f16738a.setTouchMode(i);
    }

    public void setShadowDrawable(int i) {
        setShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f16739b.setShadowDrawable(drawable);
    }

    public void setSecondaryShadowDrawable(int i) {
        setSecondaryShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setSecondaryShadowDrawable(Drawable drawable) {
        this.f16739b.setSecondaryShadowDrawable(drawable);
    }

    public void setShadowWidthRes(int i) {
        setShadowWidth((int) getResources().getDimension(i));
    }

    public void setShadowWidth(int i) {
        this.f16739b.setShadowWidth(i);
    }

    public void setFadeEnabled(boolean z) {
        this.f16739b.setFadeEnabled(z);
    }

    public void setFadeDegree(float f) {
        this.f16739b.setFadeDegree(f);
    }

    public void setSelectorEnabled(boolean z) {
        this.f16738a.setSelectorEnabled(true);
    }

    public void setSelectedView(View view) {
        this.f16738a.setSelectedView(view);
    }

    public void setSelectorDrawable(int i) {
        this.f16738a.setSelectorBitmap(BitmapFactory.decodeResource(getResources(), i));
    }

    public void setSelectorBitmap(Bitmap bitmap) {
        this.f16738a.setSelectorBitmap(bitmap);
    }

    public void setOnOpenListener(InterfaceC2952d interfaceC2952d) {
        this.f16740c = interfaceC2952d;
    }

    public void setOnCloseListener(InterfaceC2950b interfaceC2950b) {
        this.f16741d = interfaceC2950b;
    }

    public void setOnOpenedListener(InterfaceC2953e interfaceC2953e) {
        this.f16738a.setOnOpenedListener(interfaceC2953e);
    }

    public void setOnClosedListener(InterfaceC2951c interfaceC2951c) {
        this.f16738a.setOnClosedListener(interfaceC2951c);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C2959f();

        /* renamed from: a */
        private final boolean f16742a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable, boolean z) {
            super(parcelable);
            this.f16742a = z;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f16742a ? (byte) 1 : (byte) 0);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f16742a = parcel.readByte() != 0;
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), m4416c());
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f16742a) {
            m4415d();
        } else {
            m4420a();
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        setPadding(rect.left, rect.top, rect.right, rect.bottom);
        return true;
    }
}
