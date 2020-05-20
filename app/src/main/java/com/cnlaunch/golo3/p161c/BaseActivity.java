package com.cnlaunch.golo3.p161c;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.p012v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.golo3.p163e.C1609a;
import com.cnlaunch.golo3.p164f.MessageEventCodeManager;
import com.cnlaunch.golo3.p165g.GoloActivityManager;
import com.cnlaunch.golo3.p165g.Singlton;
import com.cnlaunch.p132e.p133a.C1464a;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.golo3.c.a */
/* loaded from: classes.dex */
public class BaseActivity extends FragmentActivity implements View.OnClickListener {

    /* renamed from: A */
    private TextView f8410A;

    /* renamed from: n */
    protected TextView f8411n;

    /* renamed from: o */
    protected TextView f8412o;

    /* renamed from: p */
    protected View f8413p;

    /* renamed from: q */
    protected View f8414q;

    /* renamed from: r */
    protected RelativeLayout f8415r;

    /* renamed from: s */
    protected LinearLayout f8416s;

    /* renamed from: t */
    protected LinearLayout f8417t;

    /* renamed from: u */
    protected LinearLayout f8418u;

    /* renamed from: v */
    protected FrameLayout f8419v;

    /* renamed from: w */
    protected LayoutInflater f8420w;

    /* renamed from: x */
    protected Resources f8421x;

    /* renamed from: y */
    protected Activity f8422y;

    /* renamed from: z */
    private TextView f8423z;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9064c(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GoloActivityManager.m9138a();
        GoloActivityManager.m9137a(this);
        this.f8420w = getLayoutInflater();
        this.f8421x = getResources();
        this.f8422y = this;
        getWindow().setBackgroundDrawable(null);
        requestWindowFeature(1);
        this.f8419v = (FrameLayout) findViewById(16908290);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m9171a(int i, int i2, int... iArr) {
        String string = getString(i);
        View inflate = this.f8420w.inflate(i2, (ViewGroup) null);
        this.f8420w.inflate(C1464a.C1469e.activity_base, (ViewGroup) this.f8419v, true);
        this.f8415r = (RelativeLayout) findViewById(C1464a.C1468d.title_layout);
        this.f8414q = inflate;
        this.f8413p = findViewById(C1464a.C1468d.title_left_layout);
        this.f8418u = (LinearLayout) findViewById(C1464a.C1468d.layout_car);
        this.f8413p.setOnClickListener(new View$OnClickListenerC1603b(this));
        this.f8411n = (TextView) findViewById(C1464a.C1468d.title_text);
        this.f8412o = (TextView) findViewById(C1464a.C1468d.title_car);
        this.f8412o.setOnClickListener(this);
        TextView textView = this.f8411n;
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        textView.setText(string);
        this.f8416s = (LinearLayout) findViewById(C1464a.C1468d.title_right_layout);
        this.f8417t = (LinearLayout) findViewById(C1464a.C1468d.title_middle_layout);
        this.f8423z = (TextView) findViewById(C1464a.C1468d.left_center_title_btn);
        this.f8410A = (TextView) findViewById(C1464a.C1468d.right_cnter_title_btn);
        this.f8417t.setVisibility(8);
        m9170a(iArr);
        if (inflate != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            inflate.setBackgroundColor(this.f8421x.getColor(C1464a.C1465a.gray_bg_helper));
            layoutParams.setMargins(0, (int) this.f8421x.getDimension(C1464a.C1466b.dp_48), 0, 0);
            this.f8419v.addView(inflate, layoutParams);
        }
    }

    /* renamed from: a */
    public final void m9170a(int... iArr) {
        int length = iArr == null ? 0 : iArr.length;
        boolean z = true;
        boolean z2 = true;
        for (int i = 0; i < length; i++) {
            if (iArr[i] < R.animator.animator_slide_in_from_bottom || iArr[i] > 2130903039) {
                z2 = false;
            } else {
                z = false;
            }
        }
        if (z) {
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = getString(iArr[i2]);
            }
            m9169a(strArr);
        } else if (z2) {
            LinearLayout linearLayout = this.f8416s;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            this.f8416s.setVisibility(0);
            int dimension = (int) this.f8421x.getDimension(C1464a.C1466b.dp_10);
            for (int i3 = 0; i3 < length; i3++) {
                ImageView imageView = new ImageView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                imageView.setPadding(dimension, 0, dimension, 0);
                imageView.setImageResource(iArr[i3]);
                imageView.setBackgroundResource(C1464a.C1467c.title_color_select);
                this.f8416s.addView(imageView, layoutParams);
                imageView.setTag(Integer.valueOf(i3));
                imageView.setOnClickListener(new View$OnClickListenerC1604c(this));
            }
        } else {
            LinearLayout linearLayout2 = this.f8416s;
            if (linearLayout2 != null) {
                linearLayout2.removeAllViews();
            }
            this.f8416s.setVisibility(0);
            int dimension2 = (int) this.f8421x.getDimension(C1464a.C1466b.dp_10);
            for (int i4 = 0; i4 < length; i4++) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
                if (iArr[i4] >= R.animator.animator_slide_in_from_bottom && iArr[i4] <= 2130903039) {
                    ImageView imageView2 = new ImageView(this);
                    imageView2.setPadding(dimension2, 0, dimension2, 0);
                    imageView2.setImageResource(iArr[i4]);
                    imageView2.setBackgroundResource(C1464a.C1467c.title_color_select);
                    imageView2.setTag(Integer.valueOf(i4));
                    imageView2.setOnClickListener(new View$OnClickListenerC1605d(this));
                    this.f8416s.addView(imageView2, layoutParams2);
                } else {
                    TextView textView = new TextView(this);
                    textView.setGravity(17);
                    textView.setPadding(dimension2, 0, dimension2, 0);
                    textView.setTextSize(0, this.f8421x.getDimensionPixelSize(C1464a.C1466b.sp_14));
                    textView.setText(iArr[i4]);
                    textView.setTextColor(this.f8421x.getColor(C1464a.C1465a.green_text_color));
                    textView.setBackgroundResource(C1464a.C1467c.title_color_select);
                    textView.setTag(Integer.valueOf(i4));
                    textView.setOnClickListener(new View$OnClickListenerC1606e(this));
                    this.f8416s.addView(textView, layoutParams2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m9169a(String[] strArr) {
        int length = strArr.length;
        LinearLayout linearLayout = this.f8416s;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        if (length > 0) {
            this.f8416s.setVisibility(0);
            int dimension = (int) this.f8421x.getDimension(C1464a.C1466b.dp_10);
            for (int i = 0; i < length; i++) {
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                textView.setGravity(17);
                textView.setTextSize(0, this.f8421x.getDimensionPixelSize(C1464a.C1466b.sp_14));
                textView.setText(strArr[i]);
                textView.setTextColor(this.f8421x.getColor(C1464a.C1465a.green_text_color));
                textView.setBackgroundResource(C1464a.C1467c.title_color_select);
                textView.setPadding(dimension, 0, dimension, 0);
                this.f8416s.addView(textView, layoutParams);
                textView.setTag(Integer.valueOf(i));
                textView.setOnClickListener(new View$OnClickListenerC1607f(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9067b() {
        GoloActivityManager.m9138a();
        GoloActivityManager.m9135b(this);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            GoloActivityManager.m9138a();
            GoloActivityManager.m9135b(this);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void clearDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                clearDrawables(viewGroup.getChildAt(i));
            }
            if (view instanceof AdapterView) {
                return;
            }
            viewGroup.removeAllViews();
        }
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C1609a.m9163b(this.f8422y);
        clearDrawables(this.f8419v);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        ((MessageEventCodeManager) Singlton.m9123a(MessageEventCodeManager.class)).m9126a(2451, new Object[0]);
    }
}
