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
public class VinDropdownEditText extends EditText {

    /* renamed from: a */
    Context f16102a;

    /* renamed from: b */
    ListView f16103b;

    /* renamed from: c */
    View f16104c;

    /* renamed from: d */
    ArrayList<String> f16105d;

    /* renamed from: e */
    C2803a f16106e;

    /* renamed from: f */
    PreferencesManager f16107f;

    /* renamed from: g */
    String f16108g;

    /* renamed from: h */
    PopupWindow f16109h;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: i */
    Handler f16110i;

    /* renamed from: j */
    private Drawable f16111j;

    /* renamed from: k */
    private int f16112k;

    public VinDropdownEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
        this.f16102a = context;
    }

    private VinDropdownEditText(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, 16842862);
        this.f16105d = new ArrayList<>();
        this.f16108g = "vin_list";
        this.f16112k = 400;
        this.f16110i = new HandlerC2982u(this);
        this.f16102a = context;
        this.f16111j = getCompoundDrawables()[2];
        if (this.f16111j == null) {
            this.f16111j = getResources().getDrawable(R.drawable.spinner_down);
        }
        Drawable drawable = this.f16111j;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f16111j.getIntrinsicHeight());
        setClearIconVisible(true);
        this.f16107f = PreferencesManager.m9595a(this.f16102a);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getCompoundDrawables()[2] != null && motionEvent.getAction() == 1) {
            if ((motionEvent.getX() > ((float) ((getWidth() - getPaddingRight()) - this.f16111j.getIntrinsicWidth())) && motionEvent.getX() < ((float) (getWidth() - getPaddingRight()))) && this.f16105d.size() > 0) {
                View view = this.f16104c;
                if (view != null) {
                    View inflate = LayoutInflater.from(this.f16102a).inflate(R.layout.layout_lonin_dropdown_view, (ViewGroup) null, false);
                    this.f16103b = (ListView) inflate.findViewById(R.id.listView1);
                    this.f16106e = new C2803a(this.f16105d);
                    this.f16103b.setAdapter((ListAdapter) this.f16106e);
                    this.f16103b.setOnItemClickListener(new C2983v(this));
                    this.f16109h = new PopupWindow(inflate, getWidth(), 300, true);
                    this.f16109h.setBackgroundDrawable(new BitmapDrawable());
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    this.f16109h.showAtLocation(view, 0, iArr[0], iArr[1] + view.getHeight() + 5);
                }
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setList(ArrayList<String> arrayList) {
        this.f16105d = arrayList;
    }

    public void setView(View view) {
        this.f16104c = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.widget.VinDropdownEditText$a */
    /* loaded from: classes.dex */
    public class C2803a extends BaseAdapter {

        /* renamed from: a */
        ArrayList<String> f16113a;

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        public C2803a(ArrayList<String> arrayList) {
            this.f16113a = arrayList;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return this.f16113a.size();
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            return this.f16113a.get(i);
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C2804a c2804a;
            LayoutInflater from = LayoutInflater.from(VinDropdownEditText.this.f16102a);
            if (view == null) {
                c2804a = new C2804a();
                view2 = from.inflate(R.layout.item_list_vin_dropdown, (ViewGroup) null);
                c2804a.f16115a = (TextView) view2.findViewById(R.id.username);
                c2804a.f16116b = (ImageView) view2.findViewById(R.id.delete);
                view2.setTag(c2804a);
            } else {
                view2 = view;
                c2804a = (C2804a) view.getTag();
            }
            c2804a.f16115a.setText(this.f16113a.get(i));
            c2804a.f16116b.setOnClickListener(new View$OnClickListenerC2984w(this, c2804a));
            return view2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.cnlaunch.x431pro.widget.VinDropdownEditText$a$a */
        /* loaded from: classes.dex */
        public class C2804a {

            /* renamed from: a */
            TextView f16115a;

            /* renamed from: b */
            ImageView f16116b;

            C2804a() {
            }
        }
    }

    protected void setClearIconVisible(boolean z) {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.f16111j : null, getCompoundDrawables()[3]);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        PopupWindow popupWindow = this.f16109h;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }
}
