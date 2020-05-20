package com.cnlaunch.gmap.map.logic.control;

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
import com.cnlaunch.gmap.map.p151c.HttpMsgCenter;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.gmap.map.logic.control.a */
/* loaded from: classes.dex */
public class BasicActivity extends FragmentActivity implements View.OnClickListener {

    /* renamed from: A */
    protected LayoutInflater f7622A;

    /* renamed from: B */
    protected Resources f7623B;

    /* renamed from: C */
    protected Activity f7624C;

    /* renamed from: D */
    public final int f7625D = 161061273;

    /* renamed from: n */
    private TextView f7626n;

    /* renamed from: o */
    private TextView f7627o;

    /* renamed from: q */
    protected TextView f7628q;

    /* renamed from: r */
    protected TextView f7629r;

    /* renamed from: s */
    protected View f7630s;

    /* renamed from: t */
    protected View f7631t;

    /* renamed from: u */
    protected View f7632u;

    /* renamed from: v */
    protected RelativeLayout f7633v;

    /* renamed from: w */
    protected LinearLayout f7634w;

    /* renamed from: x */
    protected LinearLayout f7635x;

    /* renamed from: y */
    protected LinearLayout f7636y;

    /* renamed from: z */
    protected FrameLayout f7637z;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9270c(int i) {
    }

    public void onClick(View view) {
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7622A = getLayoutInflater();
        this.f7623B = getResources();
        this.f7624C = this;
        getWindow().setBackgroundDrawable(null);
        requestWindowFeature(1);
        this.f7637z = (FrameLayout) findViewById(16908290);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m9272a(String str, int... iArr) {
        int i;
        View inflate = this.f7622A.inflate(R.layout.gmap_map_base_layout, (ViewGroup) null);
        this.f7622A.inflate(R.layout.gmap_activity_base, (ViewGroup) this.f7637z, true);
        this.f7633v = (RelativeLayout) findViewById(R.id.title_layout);
        this.f7632u = inflate;
        this.f7630s = findViewById(R.id.title_left_layout);
        this.f7631t = findViewById(R.id.title_back_image);
        this.f7636y = (LinearLayout) findViewById(R.id.layout_car);
        this.f7630s.setOnClickListener(new View$OnClickListenerC1542b(this));
        this.f7628q = (TextView) findViewById(R.id.title_text);
        this.f7629r = (TextView) findViewById(R.id.title_car);
        this.f7629r.setOnClickListener(this);
        this.f7628q.setText(TextUtils.isEmpty(str) ? "" : str);
        this.f7634w = (LinearLayout) findViewById(R.id.title_right_layout);
        this.f7635x = (LinearLayout) findViewById(R.id.title_middle_layout);
        this.f7626n = (TextView) findViewById(R.id.left_center_title_btn);
        this.f7627o = (TextView) findViewById(R.id.right_cnter_title_btn);
        this.f7635x.setVisibility(8);
        int length = iArr == null ? 0 : iArr.length;
        int i2 = 0;
        boolean z = true;
        boolean z2 = true;
        while (true) {
            i = 2130903039;
            if (i2 >= length) {
                break;
            }
            if (iArr[i2] < R.animator.animator_slide_in_from_bottom || iArr[i2] > 2130903039) {
                z2 = false;
            } else {
                z = false;
            }
            i2++;
        }
        int i3 = -2;
        if (z) {
            String[] strArr = new String[length];
            for (int i4 = 0; i4 < length; i4++) {
                strArr[i4] = getString(iArr[i4]);
            }
            int length2 = strArr.length;
            LinearLayout linearLayout = this.f7634w;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            if (length2 > 0) {
                this.f7634w.setVisibility(0);
                int dimension = (int) this.f7623B.getDimension(R.dimen.dp_10);
                for (int i5 = 0; i5 < length2; i5++) {
                    TextView textView = new TextView(this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.f7623B.getDimensionPixelSize(R.dimen.sp_14));
                    textView.setText(strArr[i5]);
                    textView.setTextColor(this.f7623B.getColor(R.color.green_text_color));
                    textView.setBackgroundResource(R.drawable.title_color_select);
                    textView.setPadding(dimension, 0, dimension, 0);
                    this.f7634w.addView(textView, layoutParams);
                    textView.setTag(Integer.valueOf(i5));
                    textView.setOnClickListener(new View$OnClickListenerC1546f(this));
                }
            }
        } else if (z2) {
            LinearLayout linearLayout2 = this.f7634w;
            if (linearLayout2 != null) {
                linearLayout2.removeAllViews();
            }
            this.f7634w.setVisibility(0);
            int dimension2 = (int) this.f7623B.getDimension(R.dimen.dp_10);
            for (int i6 = 0; i6 < length; i6++) {
                ImageView imageView = new ImageView(this);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
                imageView.setPadding(dimension2, 0, dimension2, 0);
                imageView.setImageResource(iArr[i6]);
                imageView.setBackgroundResource(R.drawable.title_color_select);
                this.f7634w.addView(imageView, layoutParams2);
                imageView.setTag(Integer.valueOf(i6));
                imageView.setOnClickListener(new View$OnClickListenerC1543c(this));
            }
        } else {
            LinearLayout linearLayout3 = this.f7634w;
            if (linearLayout3 != null) {
                linearLayout3.removeAllViews();
            }
            this.f7634w.setVisibility(0);
            int dimension3 = (int) this.f7623B.getDimension(R.dimen.dp_10);
            int i7 = 0;
            while (i7 < length) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
                if (iArr[i7] >= R.animator.animator_slide_in_from_bottom && iArr[i7] <= i) {
                    ImageView imageView2 = new ImageView(this);
                    imageView2.setPadding(dimension3, 0, dimension3, 0);
                    imageView2.setImageResource(iArr[i7]);
                    imageView2.setBackgroundResource(R.drawable.title_color_select);
                    imageView2.setTag(Integer.valueOf(i7));
                    imageView2.setOnClickListener(new View$OnClickListenerC1544d(this));
                    this.f7634w.addView(imageView2, layoutParams3);
                } else {
                    TextView textView2 = new TextView(this);
                    textView2.setGravity(17);
                    textView2.setPadding(dimension3, 0, dimension3, 0);
                    textView2.setTextSize(0, this.f7623B.getDimensionPixelSize(R.dimen.sp_14));
                    textView2.setText(iArr[i7]);
                    textView2.setTextColor(this.f7623B.getColor(R.color.green_text_color));
                    textView2.setBackgroundResource(R.drawable.title_color_select);
                    textView2.setTag(Integer.valueOf(i7));
                    textView2.setOnClickListener(new View$OnClickListenerC1545e(this));
                    this.f7634w.addView(textView2, layoutParams3);
                }
                i7++;
                i = 2130903039;
                i3 = -2;
            }
        }
        if (inflate != null) {
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams4.setMargins(0, (int) this.f7623B.getDimension(R.dimen.dp_48), 0, 0);
            this.f7637z.addView(inflate, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final void m9271c() {
        this.f7637z.addView(this.f7622A.inflate(R.layout.gmap_map_base_layout, (ViewGroup) null), new FrameLayout.LayoutParams(-1, -1));
        this.f7637z.setBackgroundColor(this.f7623B.getColor(17170443));
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
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
        HttpMsgCenter.m9286b(this.f7624C);
        clearDrawables(this.f7637z);
    }
}
