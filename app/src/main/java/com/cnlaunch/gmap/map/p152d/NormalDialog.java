package com.cnlaunch.gmap.map.p152d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.gmap.map.d.c */
/* loaded from: classes.dex */
public final class NormalDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    public InterfaceC1540a f7615a;

    /* renamed from: b */
    private Button f7616b;

    /* renamed from: c */
    private Button f7617c;

    /* renamed from: d */
    private TextView f7618d;

    /* renamed from: e */
    private TextView f7619e;

    /* renamed from: f */
    private ImageView f7620f;

    /* compiled from: NormalDialog.java */
    /* renamed from: com.cnlaunch.gmap.map.d.c$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1540a {
        /* renamed from: a */
        void mo9275a();

        /* renamed from: b */
        void mo9274b();
    }

    public NormalDialog(Context context, String str, String str2, String str3, String str4) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.normal_dialog, (ViewGroup) null);
        this.f7616b = (Button) inflate.findViewById(R.id.cancle);
        this.f7617c = (Button) inflate.findViewById(R.id.ok);
        this.f7618d = (TextView) inflate.findViewById(R.id.title);
        this.f7619e = (TextView) inflate.findViewById(R.id.content);
        this.f7620f = (ImageView) inflate.findViewById(R.id.suggested_dialog_img_close);
        if (str != null && str.length() > 0) {
            this.f7618d.setText(str);
        } else {
            this.f7618d.setVisibility(8);
        }
        if (str2 != null && str2.length() > 0) {
            this.f7619e.setText(str2);
        }
        if (str3 != null && str3.length() > 0) {
            this.f7616b.setText(str3);
        } else {
            this.f7616b.setVisibility(8);
        }
        if (str4 != null && str4.length() > 0) {
            this.f7617c.setText(str4);
        }
        this.f7617c.setOnClickListener(this);
        this.f7616b.setOnClickListener(this);
        this.f7620f.setOnClickListener(this);
        setCanceledOnTouchOutside(false);
        requestWindowFeature(1);
        setContentView(inflate);
        getWindow().setBackgroundDrawableResource(17170445);
        Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
        int[] iArr = {defaultDisplay.getWidth(), defaultDisplay.getHeight()};
        int i = iArr[0] > iArr[1] ? iArr[1] : iArr[0];
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (i * 9) / 10;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        show();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cancle) {
            this.f7615a.mo9274b();
        } else if (id == R.id.ok) {
            this.f7615a.mo9275a();
        } else {
            cancel();
        }
    }
}
