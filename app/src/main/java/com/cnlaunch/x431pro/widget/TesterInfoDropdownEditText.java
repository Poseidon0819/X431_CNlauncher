package com.cnlaunch.x431pro.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LcEditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TesterInfoDropdownEditText extends LcEditText {

    /* renamed from: a */
    Context f16087a;

    /* renamed from: b */
    ListView f16088b;

    /* renamed from: c */
    View f16089c;

    /* renamed from: d */
    ArrayList<String> f16090d;

    /* renamed from: e */
    C2801a f16091e;

    /* renamed from: f */
    PreferencesManager f16092f;

    /* renamed from: g */
    PopupWindow f16093g;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: h */
    Handler f16094h;

    /* renamed from: i */
    private Drawable f16095i;

    /* renamed from: j */
    private int f16096j;

    public TesterInfoDropdownEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
        this.f16087a = context;
    }

    private TesterInfoDropdownEditText(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, (byte) 0);
        this.f16090d = new ArrayList<>();
        this.f16096j = 400;
        this.f16094h = new HandlerC2947r(this);
        this.f16087a = context;
        this.f16095i = getCompoundDrawables()[2];
        if (this.f16095i == null) {
            this.f16095i = getResources().getDrawable(R.drawable.spinner_down);
        }
        Drawable drawable = this.f16095i;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f16095i.getIntrinsicHeight());
        setClearIconVisible(true);
        this.f16092f = PreferencesManager.m9595a(this.f16087a);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getCompoundDrawables()[2] != null && motionEvent.getAction() == 1) {
            if (motionEvent.getX() > ((float) ((getWidth() - getPaddingRight()) - this.f16095i.getIntrinsicWidth())) && motionEvent.getX() < ((float) (getWidth() - getPaddingRight()))) {
                Context context = this.f16087a;
                if (context != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                    if (inputMethodManager.isActive()) {
                        inputMethodManager.hideSoftInputFromWindow(this.f16089c.getWindowToken(), 0);
                    }
                }
                if (this.f16090d.size() > 0) {
                    View view = this.f16089c;
                    if (view != null) {
                        View inflate = LayoutInflater.from(this.f16087a).inflate(R.layout.layout_lonin_dropdown_view, (ViewGroup) null, false);
                        this.f16088b = (ListView) inflate.findViewById(R.id.listView1);
                        this.f16091e = new C2801a(this.f16090d);
                        this.f16088b.setAdapter((ListAdapter) this.f16091e);
                        this.f16088b.setOnItemClickListener(new C2948s(this));
                        this.f16093g = new PopupWindow(inflate, getWidth(), (int) MetaDo.META_SETROP2, true);
                        this.f16093g.setBackgroundDrawable(new BitmapDrawable());
                        view.getLocationOnScreen(new int[2]);
                        this.f16093g.showAsDropDown(view);
                    }
                    return false;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setList(ArrayList<String> arrayList) {
        this.f16090d = arrayList;
    }

    public void setView(View view) {
        this.f16089c = view;
    }

    /* renamed from: com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a */
    /* loaded from: classes.dex */
    class C2801a extends BaseAdapter {

        /* renamed from: a */
        ArrayList<String> f16097a;

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        public C2801a(ArrayList<String> arrayList) {
            this.f16097a = arrayList;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return this.f16097a.size();
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            return this.f16097a.get(i);
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C2802a c2802a;
            LayoutInflater from = LayoutInflater.from(TesterInfoDropdownEditText.this.f16087a);
            if (view == null) {
                c2802a = new C2802a();
                view2 = from.inflate(R.layout.item_list_login_dropdown, (ViewGroup) null);
                c2802a.f16099a = (TextView) view2.findViewById(R.id.username);
                c2802a.f16100b = (ImageView) view2.findViewById(R.id.delete);
                view2.setTag(c2802a);
            } else {
                view2 = view;
                c2802a = (C2802a) view.getTag();
            }
            c2802a.f16099a.setText(this.f16097a.get(i));
            c2802a.f16100b.setOnClickListener(new View$OnClickListenerC2981t(this, c2802a));
            return view2;
        }

        /* renamed from: com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a$a */
        /* loaded from: classes.dex */
        class C2802a {

            /* renamed from: a */
            TextView f16099a;

            /* renamed from: b */
            ImageView f16100b;

            C2802a() {
            }
        }
    }

    protected void setClearIconVisible(boolean z) {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.f16095i : null, getCompoundDrawables()[3]);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        PopupWindow popupWindow = this.f16093g;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }
}
