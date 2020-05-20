package com.cnlaunch.golo3.view.selectimg.p166a;

import android.widget.AdapterView;

/* compiled from: PhotoFragment.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.a.g */
/* loaded from: classes.dex */
final class C1632g implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PhotoFragment f8609a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1632g(PhotoFragment photoFragment) {
        this.f8609a = photoFragment;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0076  */
    @Override // android.widget.AdapterView.OnItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onItemClick(android.widget.AdapterView<?> r2, android.view.View r3, int r4, long r5) {
        /*
            r1 = this;
            java.lang.Object r2 = r3.getTag()
            com.cnlaunch.golo3.view.selectimg.a.b$a r2 = (com.cnlaunch.golo3.view.selectimg.p166a.PhotoAdapter.C1625a) r2
            com.cnlaunch.golo3.view.selectimg.a.f r3 = r1.f8609a
            java.util.List r3 = com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9077a(r3)
            java.lang.Object r3 = r3.get(r4)
            com.cnlaunch.golo3.view.selectimg.a.h r3 = (com.cnlaunch.golo3.view.selectimg.p166a.PhotoInfo) r3
            boolean r4 = r3.isChoose()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L34
            com.cnlaunch.golo3.view.selectimg.a.f r4 = r1.f8609a
            int r4 = com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9076b(r4)
            if (r4 <= 0) goto L34
            r3.setChoose(r6)
            com.cnlaunch.golo3.view.selectimg.a.f r4 = r1.f8609a
            java.util.List r4 = com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9075c(r4)
            r4.remove(r3)
            com.cnlaunch.golo3.view.selectimg.a.f r4 = r1.f8609a
            com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9074d(r4)
            goto L53
        L34:
            com.cnlaunch.golo3.view.selectimg.a.f r4 = r1.f8609a
            int r4 = com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9076b(r4)
            com.cnlaunch.golo3.view.selectimg.a.f r0 = r1.f8609a
            int r0 = com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9073e(r0)
            if (r4 >= r0) goto L53
            r3.setChoose(r5)
            com.cnlaunch.golo3.view.selectimg.a.f r4 = r1.f8609a
            java.util.List r4 = com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9075c(r4)
            r4.add(r3)
            com.cnlaunch.golo3.view.selectimg.a.f r4 = r1.f8609a
            com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9072f(r4)
        L53:
            boolean r3 = r3.isChoose()
            if (r3 == 0) goto L61
            android.widget.ImageView r2 = r2.f8577b
            int r3 = com.cnlaunch.p132e.p133a.C1464a.C1467c.gou_selected
            r2.setImageResource(r3)
            goto L68
        L61:
            android.widget.ImageView r2 = r2.f8577b
            int r3 = com.cnlaunch.p132e.p133a.C1464a.C1467c.gou_normal
            r2.setImageResource(r3)
        L68:
            com.cnlaunch.golo3.view.selectimg.a.f r2 = r1.f8609a
            int r2 = com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9076b(r2)
            com.cnlaunch.golo3.view.selectimg.a.f r3 = r1.f8609a
            int r3 = com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9073e(r3)
            if (r2 < r3) goto La3
            r2 = 0
            com.cnlaunch.golo3.view.selectimg.a.f r3 = r1.f8609a     // Catch: java.lang.Exception -> L92
            int r4 = com.cnlaunch.p132e.p133a.C1464a.C1470f.selector_img_Max_select_6_str     // Catch: java.lang.Exception -> L92
            java.lang.String r3 = r3.getString(r4)     // Catch: java.lang.Exception -> L92
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L92
            com.cnlaunch.golo3.view.selectimg.a.f r5 = r1.f8609a     // Catch: java.lang.Exception -> L92
            int r5 = com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9073e(r5)     // Catch: java.lang.Exception -> L92
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> L92
            r4[r6] = r5     // Catch: java.lang.Exception -> L92
            java.lang.String r2 = java.lang.String.format(r3, r4)     // Catch: java.lang.Exception -> L92
            goto L96
        L92:
            r3 = move-exception
            r3.printStackTrace()
        L96:
            com.cnlaunch.golo3.view.selectimg.a.f r3 = r1.f8609a
            android.support.v4.app.n r3 = r3.getActivity()
            android.widget.Toast r2 = android.widget.Toast.makeText(r3, r2, r6)
            r2.show()
        La3:
            com.cnlaunch.golo3.view.selectimg.a.f r2 = r1.f8609a
            com.cnlaunch.golo3.view.selectimg.a.f$b r2 = com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9071g(r2)
            com.cnlaunch.golo3.view.selectimg.a.f r3 = r1.f8609a
            java.util.List r3 = com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.m9075c(r3)
            r2.mo9066b(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.golo3.view.selectimg.p166a.C1632g.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
    }
}
