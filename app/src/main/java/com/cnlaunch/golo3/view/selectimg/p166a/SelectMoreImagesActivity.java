package com.cnlaunch.golo3.view.selectimg.p166a;

import android.content.Intent;
import android.os.Bundle;
import android.support.p012v4.app.AbstractC0094s;
import android.support.p012v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.TextView;
import com.cnlaunch.golo3.p161c.BaseActivity;
import com.cnlaunch.golo3.p165g.CompressImgManager;
import com.cnlaunch.golo3.p165g.GoloActivityManager;
import com.cnlaunch.golo3.view.GoloProgressDialog;
import com.cnlaunch.golo3.view.selectimg.p166a.PhotoFolderFragment;
import com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment;
import com.cnlaunch.p132e.p133a.C1464a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.golo3.view.selectimg.a.j */
/* loaded from: classes.dex */
public class SelectMoreImagesActivity extends BaseActivity implements PhotoFolderFragment.InterfaceC1628b, PhotoFragment.InterfaceC1630a, PhotoFragment.InterfaceC1631b {

    /* renamed from: A */
    private PhotoFragment f8610A;

    /* renamed from: C */
    private AbstractC0094s f8612C;

    /* renamed from: z */
    private PhotoFolderFragment f8616z;

    /* renamed from: B */
    private List<PhotoInfo> f8611B = new ArrayList();

    /* renamed from: D */
    private int f8613D = 0;

    /* renamed from: E */
    private int f8614E = 0;

    /* renamed from: F */
    private int f8615F = 6;

    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("maxNum")) {
            this.f8615F = getIntent().getIntExtra("maxNum", 6);
        }
        this.f8612C = m15082d_();
        this.f8611B = new ArrayList();
        m9171a(C1464a.C1470f.selector_img_str, C1464a.C1469e.activity_selectphoto, new int[0]);
        this.f8616z = new PhotoFolderFragment();
        FragmentTransaction mo15058a = this.f8612C.mo15058a();
        mo15058a.mo15114a(C1464a.C1468d.body, this.f8616z);
        mo15058a.mo15103b();
        mo15058a.mo15096c();
    }

    @Override // com.cnlaunch.golo3.p161c.BaseActivity
    /* renamed from: b */
    public final void mo9067b() {
        int i = this.f8613D;
        if (i == 0) {
            GoloActivityManager.m9138a();
            GoloActivityManager.m9135b(this);
        } else if (i == 1) {
            m9170a(new int[0]);
            this.f8613D--;
            this.f8611B.clear();
            this.f8411n.setText(getString(C1464a.C1470f.selector_img_str));
            this.f8416s.setVisibility(8);
            this.f8612C.mo15058a().mo15100b(this.f8616z).mo15096c();
            this.f8612C.mo15005d();
        }
    }

    @Override // com.cnlaunch.golo3.p161c.BaseActivity
    /* renamed from: c */
    public final void mo9064c(int i) {
        super.mo9064c(i);
        m9065c();
    }

    /* renamed from: c */
    private void m9065c() {
        List<PhotoInfo> list = this.f8611B;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (PhotoInfo photoInfo : this.f8611B) {
            arrayList.add(photoInfo.getPath_absolute());
        }
        this.f8610A.m9078a();
        m9069a(arrayList);
    }

    /* renamed from: a */
    private void m9069a(ArrayList<String> arrayList) {
        CompressImgManager compressImgManager = new CompressImgManager();
        GoloProgressDialog.m9105a(this, getString(C1464a.C1470f.string_loading));
        compressImgManager.m9147a(arrayList, new C1633k(this));
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.InterfaceC1631b
    /* renamed from: b */
    public final void mo9066b(List<PhotoInfo> list) {
        m9170a(C1464a.C1470f.confirm);
        this.f8611B = list;
        TextView textView = this.f8411n;
        textView.setText(getString(C1464a.C1470f.selector_img_already_select_str) + "(" + this.f8611B.size() + "/" + this.f8615F + ")");
    }

    @Override // com.cnlaunch.golo3.view.selectimg.p166a.PhotoFolderFragment.InterfaceC1628b
    /* renamed from: a */
    public final void mo9068a(List<PhotoInfo> list) {
        this.f8411n.setText(getString(C1464a.C1470f.selector_img_already_select_str) + "(0/" + this.f8615F + ")");
        this.f8416s.setVisibility(0);
        this.f8612C.mo15058a();
        this.f8610A = new PhotoFragment();
        this.f8610A.f8597a = this;
        Bundle bundle = new Bundle();
        PhotoSerializable photoSerializable = new PhotoSerializable();
        this.f8611B.clear();
        for (PhotoInfo photoInfo : list) {
            photoInfo.setChoose(false);
        }
        photoSerializable.setList(list);
        bundle.putInt("count", this.f8611B.size());
        bundle.putInt("maxNum", this.f8615F);
        bundle.putSerializable("list", photoSerializable);
        this.f8610A.setArguments(bundle);
        this.f8612C.mo15058a().mo15111a(this.f8616z).mo15096c();
        FragmentTransaction mo15058a = this.f8612C.mo15058a();
        mo15058a.mo15114a(C1464a.C1468d.body, this.f8610A);
        mo15058a.mo15116a();
        mo15058a.mo15103b();
        mo15058a.mo15096c();
        this.f8613D++;
    }

    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f8613D == 0) {
            GoloActivityManager.m9138a();
            GoloActivityManager.m9135b(this);
        } else if (i == 4 && this.f8613D == 1) {
            m9170a(new int[0]);
            this.f8613D--;
            this.f8411n.setText(C1464a.C1470f.selector_img_str);
            this.f8612C.mo15058a().mo15100b(this.f8616z).mo15096c();
            this.f8612C.mo15005d();
        }
        return false;
    }

    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        List<PhotoInfo> list = this.f8611B;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.cnlaunch.golo3.view.selectimg.p166a.PhotoFragment.InterfaceC1630a
    /* renamed from: a */
    public final void mo9070a() {
        m9065c();
    }
}
