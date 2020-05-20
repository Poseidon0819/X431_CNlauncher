package com.cnlaunch.golo3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.itextpdf.text.html.HtmlTags;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LayoutLinear extends LinearLayout {

    /* renamed from: a */
    private DisplayMetrics f8503a;

    public LayoutLinear(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private DisplayMetrics getDisplayMetrics() {
        if (this.f8503a == null) {
            this.f8503a = new DisplayMetrics();
            ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.f8503a);
        }
        return this.f8503a;
    }

    private int getDisplayWidth() {
        if (getDisplayMetrics().widthPixels > 0) {
            return getDisplayMetrics().widthPixels;
        }
        return 480;
    }

    private int getDisplayHeight() {
        if (getDisplayMetrics().heightPixels > 0) {
            return getDisplayMetrics().heightPixels;
        }
        return 800;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int displayWidth = getDisplayWidth();
        int displayHeight = getDisplayHeight();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            try {
                String str = (String) childAt.getContentDescription();
                if (str != null) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("base")) {
                        if (jSONObject.getString("base").equals("width")) {
                            m9108a(childAt, jSONObject, displayWidth);
                        } else if (jSONObject.getString("base").equals("height")) {
                            m9108a(childAt, jSONObject, displayHeight);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    private static void m9108a(View view, JSONObject jSONObject, int i) throws JSONException, NullPointerException {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (jSONObject.has("width")) {
            double d = i;
            double d2 = jSONObject.getDouble("width");
            Double.isNaN(d);
            layoutParams.width = (int) (d * d2);
        }
        if (jSONObject.has("height")) {
            double d3 = i;
            double d4 = jSONObject.getDouble("height");
            Double.isNaN(d3);
            layoutParams.height = (int) (d3 * d4);
        }
        if (jSONObject.has(HtmlTags.ALIGN_LEFT)) {
            double d5 = i;
            double d6 = jSONObject.getDouble(HtmlTags.ALIGN_LEFT);
            Double.isNaN(d5);
            layoutParams.leftMargin = (int) (d5 * d6);
        }
        if (jSONObject.has(HtmlTags.ALIGN_RIGHT)) {
            double d7 = i;
            double d8 = jSONObject.getDouble(HtmlTags.ALIGN_RIGHT);
            Double.isNaN(d7);
            layoutParams.rightMargin = (int) (d7 * d8);
        }
        if (jSONObject.has(HtmlTags.ALIGN_TOP)) {
            double d9 = i;
            double d10 = jSONObject.getDouble(HtmlTags.ALIGN_TOP);
            Double.isNaN(d9);
            layoutParams.topMargin = (int) (d9 * d10);
        }
        if (jSONObject.has(HtmlTags.ALIGN_BOTTOM)) {
            double d11 = i;
            double d12 = jSONObject.getDouble(HtmlTags.ALIGN_BOTTOM);
            Double.isNaN(d11);
            layoutParams.bottomMargin = (int) (d11 * d12);
        }
        if (jSONObject.has("minWidth")) {
            double d13 = i;
            double d14 = jSONObject.getDouble("minWidth");
            Double.isNaN(d13);
            view.setMinimumWidth((int) (d13 * d14));
        }
        if (jSONObject.has("minHeight")) {
            double d15 = i;
            double d16 = jSONObject.getDouble("minHeight");
            Double.isNaN(d15);
            view.setMinimumHeight((int) (d15 * d16));
        }
        if (jSONObject.has("textSize")) {
            double d17 = i;
            double d18 = jSONObject.getDouble("textSize");
            Double.isNaN(d17);
            ((TextView) view).setTextSize(0, (float) (d17 * d18));
        }
        if (jSONObject.has("maxW")) {
            double d19 = i;
            double d20 = jSONObject.getDouble("maxW");
            Double.isNaN(d19);
            ((TextView) view).setMaxWidth((int) (d19 * d20));
        }
        if (jSONObject.has("paddingRight")) {
            int paddingLeft = view.getPaddingLeft();
            int paddingTop = view.getPaddingTop();
            double d21 = i;
            double d22 = jSONObject.getDouble("paddingRight");
            Double.isNaN(d21);
            view.setPadding(paddingLeft, paddingTop, (int) (d21 * d22), view.getPaddingBottom());
        }
        if (jSONObject.has("paddingLeft")) {
            double d23 = i;
            double d24 = jSONObject.getDouble("paddingLeft");
            Double.isNaN(d23);
            view.setPadding((int) (d23 * d24), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
        if (jSONObject.has("paddingBottom")) {
            int paddingLeft2 = view.getPaddingLeft();
            int paddingTop2 = view.getPaddingTop();
            int paddingRight = view.getPaddingRight();
            double d25 = i;
            double d26 = jSONObject.getDouble("paddingBottom");
            Double.isNaN(d25);
            view.setPadding(paddingLeft2, paddingTop2, paddingRight, (int) (d25 * d26));
        }
        if (jSONObject.has("paddingTop")) {
            int paddingLeft3 = view.getPaddingLeft();
            double d27 = i;
            double d28 = jSONObject.getDouble("paddingTop");
            Double.isNaN(d27);
            view.setPadding(paddingLeft3, (int) (d27 * d28), view.getPaddingRight(), view.getPaddingBottom());
        }
        view.setLayoutParams(layoutParams);
    }
}
