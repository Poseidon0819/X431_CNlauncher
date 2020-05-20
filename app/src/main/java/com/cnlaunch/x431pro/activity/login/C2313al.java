package com.cnlaunch.x431pro.activity.login;

import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.x431pro.module.p272k.p274b.Country;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.al */
/* loaded from: classes.dex */
final class C2313al implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13420a;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2313al(RegistActivity registActivity) {
        this.f13420a = registActivity;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        arrayList = this.f13420a.f13192bj;
        if (arrayList != null) {
            arrayList2 = this.f13420a.f13192bj;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Country country = (Country) it.next();
                arrayList3 = this.f13420a.f13193bk;
                if (!arrayList3.isEmpty()) {
                    arrayList4 = this.f13420a.f13193bk;
                    if (((String) arrayList4.get(i)).equalsIgnoreCase(country.getDisplay())) {
                        this.f13420a.f13188bf = country.getNcode();
                        FileUtils.m5016a(country.getDisplay(), PathUtils.m4846j() + "nation.dat");
                        this.f13420a.m6709i();
                    }
                }
            }
        }
    }
}
