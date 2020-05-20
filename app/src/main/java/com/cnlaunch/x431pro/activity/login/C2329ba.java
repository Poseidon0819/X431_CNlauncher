package com.cnlaunch.x431pro.activity.login;

import android.widget.RadioGroup;
import com.ifoer.expedition.pro.R;

/* compiled from: RegistActivity_ja.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ba */
/* loaded from: classes.dex */
final class C2329ba implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ RegistActivity_ja f13436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2329ba(RegistActivity_ja registActivity_ja) {
        this.f13436a = registActivity_ja;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.radioMale) {
            this.f13436a.f13262am = 0;
        } else {
            this.f13436a.f13262am = 1;
        }
    }
}
