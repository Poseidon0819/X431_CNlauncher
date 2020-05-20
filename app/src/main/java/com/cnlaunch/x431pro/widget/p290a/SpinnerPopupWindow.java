package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.PdfContentParser;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.widget.a.cu */
/* loaded from: classes.dex */
public final class SpinnerPopupWindow {

    /* renamed from: a */
    PopupWindow f16382a;

    /* renamed from: b */
    public AdapterView.OnItemClickListener f16383b;

    /* renamed from: d */
    private Context f16385d;

    /* renamed from: e */
    private ListView f16386e;

    /* renamed from: f */
    private int f16387f = PdfContentParser.COMMAND_TYPE;

    /* renamed from: c */
    public int f16384c = PdfContentParser.COMMAND_TYPE;

    public SpinnerPopupWindow(Context context) {
        this.f16385d = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_dialog_spinner, (ViewGroup) null);
        this.f16382a = new PopupWindow(inflate, -2, -2, true);
        this.f16386e = (ListView) inflate.findViewById(R.id.listview);
        this.f16386e.setOnItemClickListener(new C2861cv(this));
        this.f16382a.setFocusable(true);
        this.f16382a.setTouchable(true);
        this.f16382a.setOutsideTouchable(true);
        this.f16382a.setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));
    }

    /* renamed from: a */
    public final void m4582a(View view, List<String> list) {
        if (view == null || list == null) {
            return;
        }
        this.f16386e.setAdapter((ListAdapter) new ArrayAdapter(this.f16385d, (int) R.layout.simple_spinner_item, list));
        ListAdapter adapter = this.f16386e.getAdapter();
        if (adapter != null) {
            View view2 = adapter.getView(0, null, this.f16386e);
            view2.measure(0, 0);
            int measuredHeight = view2.getMeasuredHeight();
            if (measuredHeight > 0) {
                if (list.size() < 3 && list.size() > 0) {
                    this.f16387f = (list.size() * measuredHeight) + (list.size() - 1);
                } else if (list.size() >= 3) {
                    this.f16387f = (measuredHeight * 3) + 2;
                }
            }
        }
        this.f16386e.setLayoutParams(new LinearLayout.LayoutParams(this.f16384c, this.f16387f));
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = this.f16385d.getResources().getDisplayMetrics().heightPixels - iArr[1];
        int i2 = this.f16387f;
        if (i < i2 + 50) {
            this.f16382a.showAtLocation(view, 48, 0, iArr[1] - i2);
        } else {
            this.f16382a.showAsDropDown(view);
        }
    }

    /* renamed from: b */
    public final void m4581b(View view, List<String> list) {
        int i;
        int i2;
        int i3;
        if (view == null || list == null) {
            return;
        }
        this.f16386e.setAdapter((ListAdapter) new ArrayAdapter(this.f16385d, (int) R.layout.simple_spinner_item, list));
        ListAdapter adapter = this.f16386e.getAdapter();
        View view2 = null;
        if (adapter != null) {
            View view3 = null;
            i3 = 0;
            for (int i4 = 0; i4 < adapter.getCount(); i4++) {
                view3 = adapter.getView(i4, null, this.f16386e);
                view3.measure(0, 0);
                if (view3.getMeasuredWidth() > i3) {
                    i3 = view3.getMeasuredWidth();
                }
            }
            i2 = (int) this.f16385d.getResources().getDimension(R.dimen.spinner_item_height);
            int i5 = i2 * 2;
            this.f16387f = i5;
            if (i2 > 0) {
                if (list.size() < 3 && list.size() > 0) {
                    this.f16387f = (list.size() * i2) + (list.size() - 1);
                } else if (list.size() >= 3) {
                    this.f16387f = (i2 * 3) + 2;
                }
            }
            i = i5;
            view2 = view3;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        if (view2 == null || this.f16384c != 200) {
            i3 = this.f16384c;
        }
        this.f16386e.setLayoutParams(new LinearLayout.LayoutParams(i3, this.f16387f));
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        if ((this.f16385d.getResources().getDisplayMetrics().heightPixels - iArr[1]) - i2 < this.f16387f) {
            this.f16382a.showAtLocation(view, 0, iArr[0], iArr[1] - i);
        } else {
            this.f16382a.showAsDropDown(view);
        }
    }

    /* renamed from: a */
    public final void m4583a() {
        PopupWindow popupWindow = this.f16382a;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.f16382a.dismiss();
    }
}
