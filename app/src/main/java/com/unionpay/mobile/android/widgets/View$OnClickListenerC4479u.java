package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.utils.C4386g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.unionpay.mobile.android.widgets.u */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4479u extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private Context f23498a;

    /* renamed from: b */
    private EditText f23499b;

    /* renamed from: c */
    private ImageView f23500c;

    /* renamed from: d */
    private boolean f23501d;

    /* renamed from: e */
    private InterfaceC4481b f23502e;

    /* renamed from: f */
    private InterfaceC4480a f23503f;

    /* renamed from: g */
    private int f23504g;

    /* renamed from: h */
    private Drawable f23505h;

    /* renamed from: i */
    private TextView f23506i;

    /* renamed from: j */
    private LinearLayout f23507j;

    /* renamed from: k */
    private View.OnClickListener f23508k;

    /* renamed from: l */
    private TextWatcher f23509l;

    /* renamed from: m */
    private View.OnFocusChangeListener f23510m;

    /* renamed from: com.unionpay.mobile.android.widgets.u$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4480a {
        /* renamed from: a */
        void mo588a(boolean z);
    }

    /* renamed from: com.unionpay.mobile.android.widgets.u$b */
    /* loaded from: classes2.dex */
    public interface InterfaceC4481b extends InterfaceC4480a {
        /* renamed from: a_ */
        void mo587a_();

        /* renamed from: e */
        void mo586e();
    }

    public View$OnClickListenerC4479u(Context context) {
        super(context);
        this.f23498a = null;
        this.f23499b = null;
        this.f23500c = null;
        this.f23501d = true;
        this.f23502e = null;
        this.f23503f = null;
        this.f23506i = null;
        this.f23508k = new View$OnClickListenerC4482v(this);
        this.f23509l = new C4483w(this);
        this.f23510m = new View$OnFocusChangeListenerC4484x(this);
        this.f23498a = context;
        setOrientation(0);
        this.f23504g = C4149a.f22125n;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setFocusable(true);
        TextView textView = new TextView(this.f23498a);
        textView.setPadding(C4386g.m858a(this.f23498a, 10.0f), 0, 0, 0);
        textView.setEms(4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 19;
        addView(textView, layoutParams);
        textView.setGravity(19);
        textView.setTextSize(C4150b.f22148k);
        textView.setTextColor(-13421773);
        this.f23506i = textView;
        this.f23506i.setVisibility(8);
        RelativeLayout relativeLayout = new RelativeLayout(this.f23498a);
        relativeLayout.setGravity(21);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 19;
        addView(relativeLayout, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.f23498a);
        linearLayout.setGravity(21);
        linearLayout.setId(linearLayout.hashCode());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        layoutParams3.rightMargin = C4386g.m858a(this.f23498a, 10.0f);
        linearLayout.setVisibility(8);
        relativeLayout.addView(linearLayout, layoutParams3);
        this.f23507j = linearLayout;
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f23498a);
        relativeLayout2.setGravity(16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(9, -1);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(0, linearLayout.getId());
        layoutParams4.rightMargin = C4386g.m858a(this.f23498a, 10.0f);
        relativeLayout.addView(relativeLayout2, layoutParams4);
        this.f23500c = new ImageView(this.f23498a);
        ImageView imageView = this.f23500c;
        imageView.setId(imageView.hashCode());
        this.f23500c.setBackgroundDrawable(this.f23505h);
        this.f23500c.setOnClickListener(this.f23508k);
        this.f23500c.setVisibility(8);
        ImageView imageView2 = this.f23500c;
        imageView2.setId(imageView2.hashCode());
        this.f23500c.setAdjustViewBounds(true);
        int m858a = C4386g.m858a(this.f23498a, 30.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(m858a, m858a);
        layoutParams5.addRule(11, -1);
        layoutParams5.addRule(15, -1);
        relativeLayout2.addView(this.f23500c, layoutParams5);
        this.f23499b = new EditText(this.f23498a);
        this.f23499b.setSingleLine();
        this.f23499b.setTextSize(C4150b.f22148k);
        this.f23499b.setTextColor(-10066330);
        this.f23499b.setHintTextColor(-6710887);
        this.f23499b.setBackgroundDrawable(null);
        this.f23499b.setGravity(16);
        this.f23499b.setPadding(C4386g.m858a(this.f23498a, 10.0f), 0, 0, 0);
        this.f23499b.addTextChangedListener(this.f23509l);
        if (this.f23501d) {
            this.f23499b.setOnFocusChangeListener(this.f23510m);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(0, this.f23500c.getId());
        layoutParams6.addRule(15, -1);
        layoutParams6.addRule(9, -1);
        relativeLayout2.addView(this.f23499b, layoutParams6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ boolean m598b(View$OnClickListenerC4479u view$OnClickListenerC4479u) {
        return (view$OnClickListenerC4479u.f23499b == null || view$OnClickListenerC4479u.m600b().length() == 0 || !view$OnClickListenerC4479u.f23501d) ? false : true;
    }

    /* renamed from: a */
    public final TextView m601a(String str) {
        if (this.f23506i != null && !TextUtils.isEmpty(str)) {
            this.f23506i.setVisibility(0);
            this.f23506i.setText(str);
        }
        return this.f23506i;
    }

    /* renamed from: a */
    public final View$OnClickListenerC4479u m609a(Drawable drawable) {
        if (drawable != null) {
            this.f23500c.setBackgroundDrawable(drawable);
        }
        return this;
    }

    /* renamed from: a */
    public final void m611a() {
        this.f23501d = false;
        EditText editText = this.f23499b;
        if (editText != null) {
            editText.setKeyListener(null);
            this.f23499b.setFocusable(false);
            ImageView imageView = this.f23500c;
            if (imageView == null || imageView.getVisibility() != 0) {
                return;
            }
            this.f23500c.setVisibility(8);
        }
    }

    /* renamed from: a */
    public final void m610a(int i) {
        EditText editText = this.f23499b;
        if (editText != null) {
            editText.setInputType(i);
        }
    }

    /* renamed from: a */
    public final void m608a(InputFilter inputFilter) {
        InputFilter[] inputFilterArr = {inputFilter};
        EditText editText = this.f23499b;
        if (editText == null) {
            return;
        }
        InputFilter[] filters = editText.getFilters();
        if (filters == null) {
            this.f23499b.setFilters(inputFilterArr);
            return;
        }
        InputFilter[] inputFilterArr2 = new InputFilter[filters.length + 1];
        System.arraycopy(filters, 0, inputFilterArr2, 0, filters.length);
        System.arraycopy(inputFilterArr, 0, inputFilterArr2, filters.length, 1);
        this.f23499b.setFilters(inputFilterArr2);
    }

    /* renamed from: a */
    public final void m607a(TextWatcher textWatcher) {
        EditText editText = this.f23499b;
        if (editText == null || textWatcher == null) {
            return;
        }
        editText.addTextChangedListener(textWatcher);
    }

    /* renamed from: a */
    public final void m606a(View view, LinearLayout.LayoutParams layoutParams) {
        LinearLayout linearLayout;
        if (view == null || (linearLayout = this.f23507j) == null) {
            return;
        }
        linearLayout.addView(view, layoutParams);
        this.f23507j.setVisibility(0);
    }

    /* renamed from: a */
    public final void m605a(TextView.OnEditorActionListener onEditorActionListener) {
        EditText editText = this.f23499b;
        if (editText == null || !this.f23501d) {
            return;
        }
        editText.setOnEditorActionListener(onEditorActionListener);
    }

    /* renamed from: a */
    public final void m604a(InterfaceC4480a interfaceC4480a) {
        this.f23503f = interfaceC4480a;
    }

    /* renamed from: a */
    public final void m603a(InterfaceC4481b interfaceC4481b) {
        this.f23502e = interfaceC4481b;
        EditText editText = this.f23499b;
        if (editText != null) {
            editText.setOnClickListener(this);
        }
    }

    /* renamed from: b */
    public final String m600b() {
        EditText editText = this.f23499b;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    /* renamed from: b */
    public final void m599b(int i) {
        EditText editText = this.f23499b;
        if (editText != null) {
            editText.setSelection(i);
        }
    }

    /* renamed from: b */
    public final void m597b(String str) {
        EditText editText = this.f23499b;
        if (editText == null || str == null) {
            return;
        }
        editText.setHint(str);
    }

    /* renamed from: c */
    public final Editable m596c() {
        EditText editText = this.f23499b;
        if (editText != null) {
            return editText.getText();
        }
        return null;
    }

    /* renamed from: c */
    public final void m594c(String str) {
        EditText editText = this.f23499b;
        if (editText == null || str == null) {
            return;
        }
        editText.setText(str);
    }

    /* renamed from: d */
    public final void m593d() {
        EditText editText = this.f23499b;
        if (editText != null) {
            editText.setLongClickable(false);
        }
    }

    /* renamed from: e */
    public final void m591e() {
        EditText editText = this.f23499b;
        if (editText == null) {
            return;
        }
        editText.setText("");
        InterfaceC4481b interfaceC4481b = this.f23502e;
        if (interfaceC4481b != null) {
            interfaceC4481b.mo586e();
        }
    }

    /* renamed from: f */
    public final void m589f() {
        ((Activity) this.f23498a).getWindow().setSoftInputMode(3);
        int i = Build.VERSION.SDK_INT;
        String str = i >= 16 ? "setShowSoftInputOnFocus" : i >= 14 ? "setSoftInputShownOnFocus" : null;
        if (str == null) {
            this.f23499b.setInputType(0);
            return;
        }
        try {
            Method method = EditText.class.getMethod(str, Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(this.f23499b, Boolean.FALSE);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            this.f23499b.setInputType(0);
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC4481b interfaceC4481b = this.f23502e;
        if (interfaceC4481b != null) {
            interfaceC4481b.mo587a_();
        }
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        EditText editText = this.f23499b;
        if (editText != null) {
            editText.setOnTouchListener(onTouchListener);
        }
    }
}
