package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.by */
/* loaded from: classes.dex */
public abstract class SelectAutoDownloadDialog extends BaseDialog {

    /* renamed from: a */
    private View f16339a;

    /* renamed from: b */
    private RadioGroup f16340b;

    /* renamed from: c */
    private RadioButton f16341c;

    /* renamed from: g */
    private RadioButton f16342g;

    /* renamed from: h */
    private int f16343h;

    /* renamed from: i */
    private Context f16344i;

    /* renamed from: a */
    public abstract void mo4616a(int i);

    public SelectAutoDownloadDialog(Context context) {
        super(context);
        this.f16339a = null;
        this.f16343h = 0;
        this.f16344i = context;
        this.f16339a = LayoutInflater.from(context).inflate(R.layout.layout_select_auto_download, (ViewGroup) null);
        this.f16340b = (RadioGroup) this.f16339a.findViewById(R.id.radioGroup);
        this.f16340b.setOnCheckedChangeListener(new C2841a());
        this.f16341c = (RadioButton) this.f16339a.findViewById(R.id.btn_select_1);
        this.f16342g = (RadioButton) this.f16339a.findViewById(R.id.btn_select_2);
        this.f16343h = PreferencesManager.m9595a(this.f16344i).m9585b("auto_download_select", 0);
        if (this.f16343h == 0) {
            this.f16340b.check(R.id.btn_select_1);
        } else {
            this.f16340b.check(R.id.btn_select_2);
        }
        setTitle(R.string.common_title_tips);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16339a;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    /* compiled from: SelectAutoDownloadDialog.java */
    /* renamed from: com.cnlaunch.x431pro.widget.a.by$a */
    /* loaded from: classes.dex */
    class C2841a implements RadioGroup.OnCheckedChangeListener {
        C2841a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.btn_select_1 /* 2131296549 */:
                    SelectAutoDownloadDialog.this.f16343h = 0;
                    PreferencesManager.m9595a(SelectAutoDownloadDialog.this.f16344i).m9590a("auto_download_select", 0);
                    return;
                case R.id.btn_select_2 /* 2131296550 */:
                    SelectAutoDownloadDialog.this.f16343h = 1;
                    PreferencesManager.m9595a(SelectAutoDownloadDialog.this.f16344i).m9590a("auto_download_select", 1);
                    return;
                default:
                    return;
            }
        }
    }
}
