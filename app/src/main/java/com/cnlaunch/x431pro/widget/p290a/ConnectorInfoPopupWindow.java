package com.cnlaunch.x431pro.widget.p290a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.b */
/* loaded from: classes.dex */
public final class ConnectorInfoPopupWindow {

    /* renamed from: a */
    public TextView f16266a;

    /* renamed from: b */
    public TextView f16267b;

    /* renamed from: c */
    public TextView f16268c;

    /* renamed from: d */
    public PopupWindow f16269d;

    /* renamed from: e */
    public Context f16270e;

    /* renamed from: f */
    private TextView f16271f;

    public ConnectorInfoPopupWindow(Context context) {
        this.f16270e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.mine_serial_info_pop, (ViewGroup) null);
        this.f16269d = new PopupWindow(inflate, -2, -2, true);
        this.f16271f = (TextView) inflate.findViewById(R.id.tv_poptext);
        this.f16266a = (TextView) inflate.findViewById(R.id.tv_deviceInfo);
        this.f16267b = (TextView) inflate.findViewById(R.id.tv_softInfo);
        this.f16268c = (TextView) inflate.findViewById(R.id.tv_serialno_state);
        this.f16269d.setFocusable(true);
        this.f16269d.setTouchable(true);
        this.f16269d.setOutsideTouchable(true);
        this.f16269d.setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));
    }

    /* renamed from: a */
    public final void m4672a(View view, String str) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.f16269d.getContentView().measure(0, 0);
            int measuredHeight = (iArr[1] + view.getHeight()) + this.f16269d.getContentView().getMeasuredHeight() > m4673a(this.f16270e) ? (-view.getHeight()) - this.f16269d.getContentView().getMeasuredHeight() : 0;
            TextView textView = this.f16271f;
            textView.setText(this.f16270e.getResources().getString(R.string.mine_activate_time) + str);
            this.f16269d.showAsDropDown(view, 0, measuredHeight);
        }
    }

    /* renamed from: a */
    public static int m4673a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return displayMetrics.heightPixels;
    }
}
