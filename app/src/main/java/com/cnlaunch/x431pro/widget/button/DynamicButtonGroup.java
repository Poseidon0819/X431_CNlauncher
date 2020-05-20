package com.cnlaunch.x431pro.widget.button;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.x431pro.activity.GDApplication;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.List;

/* loaded from: classes.dex */
public class DynamicButtonGroup extends LinearLayout {

    /* renamed from: a */
    final int f16494a;

    /* renamed from: b */
    final int f16495b;

    /* renamed from: c */
    int f16496c;

    /* renamed from: d */
    int f16497d;

    /* renamed from: e */
    int f16498e;

    /* renamed from: f */
    int f16499f;

    /* renamed from: g */
    int f16500g;

    /* renamed from: h */
    int f16501h;

    /* renamed from: i */
    int f16502i;

    /* renamed from: j */
    float f16503j;

    /* renamed from: k */
    Button f16504k;

    /* renamed from: l */
    final int f16505l;

    /* renamed from: m */
    public int f16506m;

    /* renamed from: n */
    private PopupWindow f16507n;

    /* renamed from: o */
    private GridView f16508o;

    /* renamed from: p */
    private C2887a f16509p;

    /* renamed from: q */
    private LayoutInflater f16510q;

    /* renamed from: r */
    private Context f16511r;

    /* renamed from: s */
    private boolean f16512s;

    /* renamed from: t */
    private View.OnClickListener f16513t;

    /* renamed from: u */
    private View.OnClickListener f16514u;

    /* renamed from: v */
    private InterfaceC2888b f16515v;

    /* renamed from: w */
    private InterfaceC2889c f16516w;

    /* renamed from: x */
    private View.OnTouchListener f16517x;

    /* renamed from: com.cnlaunch.x431pro.widget.button.DynamicButtonGroup$b */
    /* loaded from: classes.dex */
    public interface InterfaceC2888b {
        /* renamed from: a */
        void mo4501a(int i);
    }

    /* renamed from: com.cnlaunch.x431pro.widget.button.DynamicButtonGroup$c */
    /* loaded from: classes.dex */
    public interface InterfaceC2889c {
        /* renamed from: a */
        void mo4500a(int i, int i2);
    }

    public void setIsOnTounchListen(boolean z) {
        this.f16512s = z;
    }

    public DynamicButtonGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16494a = 640;
        this.f16495b = TIFFConstants.TIFFTAG_MINSAMPLEVALUE;
        this.f16512s = false;
        this.f16513t = new View$OnClickListenerC2893a(this);
        this.f16514u = new View$OnClickListenerC2894b(this);
        this.f16517x = new View$OnTouchListenerC2895c(this);
        this.f16496c = 0;
        this.f16497d = 0;
        this.f16498e = 0;
        this.f16499f = 0;
        this.f16500g = 0;
        this.f16501h = 0;
        this.f16502i = 0;
        this.f16503j = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f16505l = 1090;
        this.f16506m = 1090;
        this.f16511r = context;
        this.f16510q = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(InterfaceC2888b interfaceC2888b) {
        this.f16515v = interfaceC2888b;
    }

    public void setOnItemTouchListener(InterfaceC2889c interfaceC2889c) {
        this.f16516w = interfaceC2889c;
        setIsOnTounchListen(true);
    }

    @TargetApi(16)
    /* renamed from: a */
    public final void m4510a(int i, List<BasicButtonBean> list) {
        int i2;
        removeAllViews();
        this.f16499f = list.size();
        this.f16496c = 0;
        this.f16497d = 0;
        this.f16498e = 0;
        this.f16500g = 0;
        this.f16502i = getResources().getDimensionPixelSize(R.dimen.dialog_padding);
        this.f16501h = this.f16502i * 4;
        LayoutInflater layoutInflater = this.f16510q;
        int i3 = R.layout.llitem_text_activitetest;
        View inflate = layoutInflater.inflate(R.layout.llitem_text_activitetest, (ViewGroup) null);
        int i4 = R.id.tv_title;
        TextPaint paint = ((TextView) inflate.findViewById(R.id.tv_title)).getPaint();
        int i5 = i;
        while (true) {
            i2 = this.f16499f;
            if (i5 >= i2) {
                break;
            }
            this.f16503j = paint.measureText(list.get(i5).getTitle());
            this.f16496c = (int) (((float) this.f16496c) + this.f16503j + ((float) this.f16501h));
            i5++;
        }
        int i6 = this.f16496c;
        int i7 = this.f16506m;
        int i8 = R.drawable.select_activebutton_right_bg;
        int i9 = R.drawable.select_activebutton_bg;
        int i10 = R.drawable.select_activebutton_left_bg;
        if (i6 <= i7) {
            this.f16498e = i7 - i6;
            int i11 = this.f16498e;
            if (i11 != 0) {
                this.f16500g = i11 / (i2 - i);
            } else {
                this.f16500g = 0;
            }
            this.f16501h += this.f16500g;
            int i12 = i;
            while (i12 < this.f16499f) {
                View inflate2 = this.f16510q.inflate(R.layout.llitem_text_activitetest, (ViewGroup) null);
                TextView textView = (TextView) inflate2.findViewById(i4);
                String title = list.get(i12).getTitle();
                textView.setEnabled(list.get(i12).isEnable());
                textView.setText(title);
                textView.setId(i12);
                int i13 = this.f16499f;
                if (i == i13 - 1) {
                    GDApplication.m7908c();
                    textView.setBackgroundResource(R.drawable.select_activebutton);
                } else if (i12 == i) {
                    GDApplication.m7908c();
                    textView.setBackgroundResource(R.drawable.select_activebutton_left_bg);
                } else if (i12 == i13 - 1) {
                    GDApplication.m7908c();
                    textView.setBackgroundResource(R.drawable.select_activebutton_right_bg);
                } else {
                    GDApplication.m7908c();
                    textView.setBackgroundResource(R.drawable.select_activebutton_bg);
                }
                this.f16503j = paint.measureText(list.get(i12).getTitle());
                textView.setWidth(((int) this.f16503j) + this.f16501h);
                if (this.f16512s) {
                    textView.setOnTouchListener(this.f16517x);
                } else {
                    textView.setOnClickListener(this.f16514u);
                }
                addView(inflate2);
                if (i12 < this.f16499f - 1) {
                    View view = new View(this.f16511r);
                    view.setBackgroundColor(-1);
                    view.setLayoutParams(new LinearLayout.LayoutParams(3, -1));
                    addView(view);
                }
                i12++;
                i4 = R.id.tv_title;
            }
            return;
        }
        this.f16496c = 128;
        int i14 = i;
        while (i14 < this.f16499f) {
            View inflate3 = this.f16510q.inflate(i3, (ViewGroup) null);
            TextView textView2 = (TextView) inflate3.findViewById(R.id.tv_title);
            textView2.setText(list.get(i14).getTitle());
            textView2.setId(i14);
            if (i14 == i) {
                GDApplication.m7908c();
                textView2.setBackgroundResource(i10);
            } else if (i14 == this.f16499f - 1) {
                GDApplication.m7908c();
                textView2.setBackgroundResource(i8);
            } else {
                GDApplication.m7908c();
                textView2.setBackgroundResource(i9);
            }
            this.f16503j = paint.measureText(list.get(i14).getTitle());
            float f = this.f16503j;
            int i15 = this.f16501h;
            this.f16496c = (int) (this.f16496c + i15 + f);
            int i16 = this.f16496c;
            int i17 = this.f16506m;
            if (i16 <= i17) {
                textView2.setWidth(((int) f) + i15);
                if (this.f16512s) {
                    textView2.setOnTouchListener(this.f16517x);
                } else {
                    textView2.setOnClickListener(this.f16514u);
                }
                addView(inflate3);
                if (i14 < this.f16499f - 1) {
                    View view2 = new View(this.f16511r);
                    view2.setBackgroundColor(-1);
                    view2.setLayoutParams(new LinearLayout.LayoutParams(3, -1));
                    addView(view2);
                }
                textView2.setEnabled(list.get(i14).isEnable());
                i14++;
                i3 = R.layout.llitem_text_activitetest;
                i8 = R.drawable.select_activebutton_right_bg;
                i9 = R.drawable.select_activebutton_bg;
                i10 = R.drawable.select_activebutton_left_bg;
            } else {
                this.f16498e = (int) (((i17 + f) + i15) - i16);
                this.f16504k = (Button) this.f16510q.inflate(R.layout.btn_more, (ViewGroup) null);
                GDApplication.m7908c();
                this.f16504k.setWidth(this.f16498e + 128);
                addView(this.f16504k);
                this.f16504k.setOnClickListener(this.f16513t);
                this.f16497d = i14;
                int i18 = this.f16497d;
                m4511a();
                List<BasicButtonBean> subList = list.subList(i18, list.size());
                View inflate4 = this.f16510q.inflate(R.layout.popwindow_grid, (ViewGroup) null, false);
                this.f16508o = (GridView) inflate4.findViewById(R.id.gv_button);
                this.f16509p = new C2887a(i18, subList);
                this.f16508o.setAdapter((ListAdapter) this.f16509p);
                if (!this.f16512s) {
                    this.f16508o.setOnItemClickListener(new C2896d(this));
                }
                this.f16507n = new PopupWindow(inflate4, 640, (int) TIFFConstants.TIFFTAG_MINSAMPLEVALUE, true);
                inflate4.setOnTouchListener(new View$OnTouchListenerC2897e(this));
                return;
            }
        }
    }

    /* renamed from: a */
    public final void m4511a() {
        PopupWindow popupWindow = this.f16507n;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.f16507n.dismiss();
    }

    /* renamed from: com.cnlaunch.x431pro.widget.button.DynamicButtonGroup$a */
    /* loaded from: classes.dex */
    class C2887a extends BaseAdapter {

        /* renamed from: a */
        C2890d f16518a;

        /* renamed from: c */
        private List<BasicButtonBean> f16520c;

        /* renamed from: d */
        private int f16521d;

        public C2887a(int i, List<BasicButtonBean> list) {
            this.f16521d = i;
            this.f16520c = list;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            List<BasicButtonBean> list = this.f16520c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public BasicButtonBean getItem(int i) {
            return this.f16520c.get(i);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return i + this.f16521d;
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = DynamicButtonGroup.this.f16510q.inflate(R.layout.griditem_text_activitetest, (ViewGroup) null);
                this.f16518a = new C2890d();
                this.f16518a.f16522a = (TextView) view.findViewById(R.id.tv_title);
                GDApplication.m7908c();
                view.setTag(this.f16518a);
            } else {
                this.f16518a = (C2890d) view.getTag();
            }
            this.f16518a.f16522a.setText(getItem(i).getTitle());
            this.f16518a.f16522a.setEnabled(getItem(i).isEnable());
            if (DynamicButtonGroup.this.f16512s) {
                this.f16518a.f16522a.setId(i + this.f16521d);
                this.f16518a.f16522a.setOnTouchListener(DynamicButtonGroup.this.f16517x);
            }
            return view;
        }
    }

    /* renamed from: com.cnlaunch.x431pro.widget.button.DynamicButtonGroup$d */
    /* loaded from: classes.dex */
    class C2890d {

        /* renamed from: a */
        TextView f16522a;

        C2890d() {
        }
    }

    public void setWidthLimit(int i) {
        this.f16506m = i;
    }

    /* renamed from: b */
    public final void m4508b() {
        PopupWindow popupWindow = this.f16507n;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }
}
