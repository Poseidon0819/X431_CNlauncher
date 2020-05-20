package com.cnlaunch.golo3.view.selectimg.p166a;

import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.golo3.view.selectimg.p166a.PhotoFolderFragment;

/* compiled from: PhotoFolderFragment.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.a.e */
/* loaded from: classes.dex */
final class C1629e implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PhotoFolderFragment f8596a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1629e(PhotoFolderFragment photoFolderFragment) {
        this.f8596a = photoFolderFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PhotoFolderFragment.InterfaceC1628b interfaceC1628b;
        interfaceC1628b = this.f8596a.f8588b;
        interfaceC1628b.mo9068a(((AlbumInfo) this.f8596a.f8591e.get(i)).getList());
    }
}
