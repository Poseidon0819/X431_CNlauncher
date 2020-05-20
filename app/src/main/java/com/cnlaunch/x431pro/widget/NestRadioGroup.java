package com.cnlaunch.x431pro.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class NestRadioGroup extends LinearLayout {

    /* renamed from: a */
    private int f16014a;

    /* renamed from: b */
    private CompoundButton.OnCheckedChangeListener f16015b;

    /* renamed from: c */
    private boolean f16016c;

    /* renamed from: d */
    private InterfaceC2793c f16017d;

    /* renamed from: e */
    private ViewGroup$OnHierarchyChangeListenerC2794d f16018e;

    /* renamed from: com.cnlaunch.x431pro.widget.NestRadioGroup$c */
    /* loaded from: classes.dex */
    public interface InterfaceC2793c {
        /* renamed from: a */
        void mo4770a(int i);
    }

    public NestRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16014a = -1;
        this.f16016c = false;
        this.f16014a = -1;
        setOrientation(1);
        this.f16015b = new C2791a(this, (byte) 0);
        this.f16018e = new ViewGroup$OnHierarchyChangeListenerC2794d(this, (byte) 0);
        super.setOnHierarchyChangeListener(this.f16018e);
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f16018e.f16021b = onHierarchyChangeListener;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f16014a;
        if (i != -1) {
            this.f16016c = true;
            m4780a(i, true);
            this.f16016c = false;
            setCheckedId(this.f16014a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static CompoundButton m4774b(View view) {
        if (view instanceof CompoundButton) {
            return (CompoundButton) view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                CompoundButton m4774b = m4774b(viewGroup.getChildAt(i));
                if (m4774b != null) {
                    return m4774b;
                }
            }
            return null;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        CompoundButton m4774b = m4774b(view);
        if (m4774b != null && m4774b.isChecked()) {
            this.f16016c = true;
            int i2 = this.f16014a;
            if (i2 != -1) {
                m4780a(i2, false);
            }
            this.f16016c = false;
            setCheckedId(m4774b.getId());
        }
        super.addView(view, i, layoutParams);
    }

    /* renamed from: a */
    public final void m4781a(int i) {
        if (i == -1 || i != this.f16014a) {
            int i2 = this.f16014a;
            if (i2 != -1) {
                m4780a(i2, false);
            }
            if (i != -1) {
                m4780a(i, true);
            }
            setCheckedId(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i) {
        this.f16014a = i;
        InterfaceC2793c interfaceC2793c = this.f16017d;
        if (interfaceC2793c != null) {
            interfaceC2793c.mo4770a(this.f16014a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4780a(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById == null || !(findViewById instanceof CompoundButton)) {
            return;
        }
        ((CompoundButton) findViewById).setChecked(z);
    }

    public int getCheckedRadioButtonId() {
        return this.f16014a;
    }

    public void setOnCheckedChangeListener(InterfaceC2793c interfaceC2793c) {
        this.f16017d = interfaceC2793c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public C2792b generateLayoutParams(AttributeSet attributeSet) {
        return new C2792b(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C2792b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new C2792b();
    }

    /* renamed from: com.cnlaunch.x431pro.widget.NestRadioGroup$b */
    /* loaded from: classes.dex */
    public static class C2792b extends LinearLayout.LayoutParams {
        public C2792b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C2792b() {
            super(-2, -2);
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected final void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            if (typedArray.hasValue(i)) {
                this.width = typedArray.getLayoutDimension(i, "layout_width");
            } else {
                this.width = -2;
            }
            if (typedArray.hasValue(i2)) {
                this.height = typedArray.getLayoutDimension(i2, "layout_height");
            } else {
                this.height = -2;
            }
        }
    }

    /* renamed from: com.cnlaunch.x431pro.widget.NestRadioGroup$a */
    /* loaded from: classes.dex */
    class C2791a implements CompoundButton.OnCheckedChangeListener {
        private C2791a() {
        }

        /* synthetic */ C2791a(NestRadioGroup nestRadioGroup, byte b) {
            this();
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (NestRadioGroup.this.f16016c) {
                return;
            }
            NestRadioGroup.this.f16016c = true;
            if (NestRadioGroup.this.f16014a != -1) {
                NestRadioGroup nestRadioGroup = NestRadioGroup.this;
                nestRadioGroup.m4780a(nestRadioGroup.f16014a, false);
            }
            NestRadioGroup.this.f16016c = false;
            NestRadioGroup.this.setCheckedId(compoundButton.getId());
        }
    }

    /* renamed from: com.cnlaunch.x431pro.widget.NestRadioGroup$d */
    /* loaded from: classes.dex */
    class ViewGroup$OnHierarchyChangeListenerC2794d implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: b */
        private ViewGroup.OnHierarchyChangeListener f16021b;

        private ViewGroup$OnHierarchyChangeListenerC2794d() {
        }

        /* synthetic */ ViewGroup$OnHierarchyChangeListenerC2794d(NestRadioGroup nestRadioGroup, byte b) {
            this();
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        @TargetApi(17)
        public final void onChildViewAdded(View view, View view2) {
            CompoundButton m4774b;
            if (view == NestRadioGroup.this && (m4774b = NestRadioGroup.m4774b(view2)) != null) {
                if (m4774b.getId() == -1 && Build.VERSION.SDK_INT >= 17) {
                    m4774b.setId(View.generateViewId());
                }
                m4774b.setOnCheckedChangeListener(NestRadioGroup.this.f16015b);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f16021b;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            CompoundButton m4774b;
            if (view == NestRadioGroup.this && (m4774b = NestRadioGroup.m4774b(view2)) != null) {
                m4774b.setOnCheckedChangeListener(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f16021b;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }
}
