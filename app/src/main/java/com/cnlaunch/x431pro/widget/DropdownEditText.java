package com.cnlaunch.x431pro.widget;

import android.annotation.SuppressLint;
import android.content.Context;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DropdownEditText extends EditText {

    /* renamed from: a */
    Context f15997a;

    /* renamed from: b */
    ListView f15998b;

    /* renamed from: c */
    EditText f15999c;

    /* renamed from: d */
    ArrayList<String> f16000d;

    /* renamed from: e */
    C2788a f16001e;

    /* renamed from: f */
    PreferencesManager f16002f;

    /* renamed from: g */
    PopupWindow f16003g;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: h */
    Handler f16004h;

    /* renamed from: i */
    private Drawable f16005i;

    public DropdownEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
        this.f15997a = context;
    }

    private DropdownEditText(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, 16842862);
        this.f16000d = new ArrayList<>();
        this.f16004h = new HandlerC2911j(this);
        this.f15997a = context;
        this.f16005i = getCompoundDrawables()[2];
        if (this.f16005i == null) {
            this.f16005i = getResources().getDrawable(R.drawable.spinner_down);
        }
        Drawable drawable = this.f16005i;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f16005i.getIntrinsicHeight());
        setClearIconVisible(true);
        this.f16002f = PreferencesManager.m9595a(this.f15997a);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getCompoundDrawables()[2] != null && motionEvent.getAction() == 1) {
            if (motionEvent.getX() > ((float) ((getWidth() - getPaddingRight()) - this.f16005i.getIntrinsicWidth())) && motionEvent.getX() < ((float) (getWidth() - getPaddingRight()))) {
                Context context = this.f15997a;
                if (context != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                    if (inputMethodManager.isActive()) {
                        inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                    }
                }
                if (this.f16000d.size() > 0) {
                    View inflate = LayoutInflater.from(this.f15997a).inflate(R.layout.layout_lonin_dropdown_view, (ViewGroup) null, false);
                    this.f15998b = (ListView) inflate.findViewById(R.id.listView1);
                    this.f16001e = new C2788a(this.f16000d);
                    this.f15998b.setAdapter((ListAdapter) this.f16001e);
                    this.f15998b.setOnItemClickListener(new C2912k(this));
                    this.f16003g = new PopupWindow(inflate, getWidth(), -2, true);
                    this.f16003g.setBackgroundDrawable(new BitmapDrawable());
                    this.f16003g.showAsDropDown(this);
                }
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setList(ArrayList<String> arrayList) {
        this.f16000d = arrayList;
    }

    public void setPasswordText(EditText editText) {
        this.f15999c = editText;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.widget.DropdownEditText$a */
    /* loaded from: classes.dex */
    public class C2788a extends BaseAdapter {

        /* renamed from: a */
        ArrayList<String> f16006a;

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        public C2788a(ArrayList<String> arrayList) {
            this.f16006a = arrayList;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return this.f16006a.size();
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            return this.f16006a.get(i);
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C2789a c2789a;
            LayoutInflater from = LayoutInflater.from(DropdownEditText.this.f15997a);
            if (view == null) {
                c2789a = new C2789a();
                view2 = from.inflate(R.layout.item_list_login_dropdown, (ViewGroup) null);
                c2789a.f16008a = (TextView) view2.findViewById(R.id.username);
                c2789a.f16009b = (ImageView) view2.findViewById(R.id.delete);
                view2.setTag(c2789a);
            } else {
                view2 = view;
                c2789a = (C2789a) view.getTag();
            }
            c2789a.f16008a.setText(this.f16006a.get(i));
            c2789a.f16009b.setOnClickListener(new View$OnClickListenerC2913l(this, c2789a));
            return view2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.cnlaunch.x431pro.widget.DropdownEditText$a$a */
        /* loaded from: classes.dex */
        public class C2789a {

            /* renamed from: a */
            TextView f16008a;

            /* renamed from: b */
            ImageView f16009b;

            C2789a() {
            }
        }
    }

    protected void setClearIconVisible(boolean z) {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.f16005i : null, getCompoundDrawables()[3]);
    }
}
