package com.cnlaunch.wifiprinter;

import android.app.DialogFragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.wifiprinter.C1900at;

/* loaded from: classes.dex */
public class HelpActivity extends DialogFragment {

    /* renamed from: a */
    TextView f10343a;

    /* renamed from: b */
    Button f10344b;

    /* renamed from: c */
    private int f10345c;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1900at.C1906f.fragment_help, viewGroup, false);
        this.f10343a = (TextView) inflate.findViewById(C1900at.C1905e.tview);
        this.f10344b = (Button) inflate.findViewById(C1900at.C1905e.back);
        return inflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f10343a.setMovementMethod(ScrollingMovementMethod.getInstance());
        if (getArguments() != null) {
            this.f10345c = getArguments().getInt("PAGE", 0);
        }
        switch (this.f10345c) {
            case 1:
                this.f10343a.setText(getResources().getString(C1900at.C1907g.helpPage1));
                break;
            case 2:
                this.f10343a.setText(getResources().getString(C1900at.C1907g.helpPage2));
                break;
            case 3:
                this.f10343a.setText(getResources().getString(C1900at.C1907g.helpPage3));
                break;
            case 4:
                this.f10343a.setText(getResources().getString(C1900at.C1907g.helpPage4));
                break;
        }
        this.f10344b.setOnClickListener(new View$OnClickListenerC1913b(this));
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m8034a();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m8034a();
    }

    /* renamed from: a */
    private void m8034a() {
        Window window = getDialog().getWindow();
        window.getAttributes();
        double width = window.getWindowManager().getDefaultDisplay().getWidth();
        Double.isNaN(width);
        double height = window.getWindowManager().getDefaultDisplay().getHeight();
        Double.isNaN(height);
        window.setLayout((int) ((width * 4.0d) / 5.0d), (int) ((height * 2.0d) / 3.0d));
        this.f10343a.scrollTo(0, 0);
    }
}
