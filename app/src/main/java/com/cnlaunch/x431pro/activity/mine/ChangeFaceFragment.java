package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.cnlaunch.golo3.p165g.UserFaceUtils;
import com.cnlaunch.golo3.view.selectimg.FileConstant;
import com.cnlaunch.golo3.view.selectimg.ImgThumbBean;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent;
import com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.FaceSettingRespone;
import com.cnlaunch.x431pro.module.p272k.p274b.UserSettingInfo;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.SelectPhotoUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;
import com.p297e.p298a.p306b.p310c.RoundedBitmapDisplayer;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

/* renamed from: com.cnlaunch.x431pro.activity.mine.k */
/* loaded from: classes.dex */
public class ChangeFaceFragment extends BaseFragment implements View.OnClickListener, OnActivityResultListenter {

    /* renamed from: h */
    private static final String f14231h = FileConstant.f8692d;

    /* renamed from: i */
    private static final String f14232i = f14231h + "user_face.jpg";

    /* renamed from: j */
    private static final String f14233j = f14231h + File.separator + "user_face_tmp.jpg";

    /* renamed from: a */
    DisplayImageOptions f14234a;

    /* renamed from: c */
    private ImageView f14236c;

    /* renamed from: d */
    private Button f14237d;

    /* renamed from: e */
    private Button f14238e;

    /* renamed from: f */
    private Button f14239f;

    /* renamed from: g */
    private Button f14240g;

    /* renamed from: k */
    private SelectPhotoUtils f14241k;

    /* renamed from: l */
    private String f14242l;

    /* renamed from: m */
    private Bitmap f14243m;

    /* renamed from: n */
    private UserAction f14244n;

    /* renamed from: o */
    private InfaceFragmentParent f14245o = null;

    /* renamed from: p */
    private int f14246p = 1;

    /* renamed from: b */
    ImgThumbBean f14235b = null;

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final long mo5997a() {
        return 0L;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final boolean mo5995a(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.change_face_fragment, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f14234a == null) {
            DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
            c3010a.f17117a = R.drawable.login_default;
            c3010a.f17118b = R.drawable.login_default;
            c3010a.f17119c = R.drawable.login_default;
            c3010a.f17129m = true;
            c3010a.f17133q = new RoundedBitmapDisplayer((int) getResources().getDimension(R.dimen.user_face));
            this.f14234a = c3010a.m4193a();
        }
        try {
            this.f14245o = (InfaceFragmentParent) getActivity();
            if (this.f14245o != null) {
                this.f14245o.mo6035a(this);
            }
        } catch (Exception e) {
            NLog.m9451c("EE", "infaceFragmentParent Error:" + e.toString());
        }
        File file = new File(f14231h);
        if (!file.exists()) {
            FileUtils.m5006b(file);
        }
        this.f14241k = new SelectPhotoUtils(getActivity(), this);
        this.f14244n = new UserAction(this.mContext);
        setTitle(R.string.user_face);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14236c = (ImageView) getActivity().findViewById(R.id.user_face_image);
        this.f14237d = (Button) getActivity().findViewById(R.id.btn_take_photo);
        this.f14238e = (Button) getActivity().findViewById(R.id.btn_select_photo);
        this.f14239f = (Button) getActivity().findViewById(R.id.btn_save_photo);
        this.f14240g = (Button) getActivity().findViewById(R.id.btn_cancel_photo);
        this.f14237d.setOnClickListener(this);
        this.f14238e.setOnClickListener(this);
        this.f14239f.setOnClickListener(this);
        this.f14240g.setOnClickListener(this);
        if (this.f14246p == 1) {
            this.f14239f.setEnabled(false);
        } else {
            this.f14239f.setEnabled(true);
        }
        ImageLoader.m4191a().m4185b(UserFaceUtils.m9115a(PreferencesManager.m9595a(this.mContext).m9591a("user_id"), PreferencesManager.m9595a(this.mContext).m9591a("current_country").equalsIgnoreCase("CN") ? "1" : "2"), this.f14236c, this.f14234a);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_cancel_photo) {
            getFragmentManager().popBackStack();
        } else if (id == R.id.btn_save_photo) {
            if (this.f14246p == 1) {
                return;
            }
            if (this.f14235b != null) {
                LoadDialog.m4686a(getActivity());
                request(30005);
            }
            this.f14246p = 1;
            this.f14239f.setEnabled(false);
        } else if (id == R.id.btn_select_photo) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            this.f14241k.m4835a(2);
        } else if (id != R.id.btn_take_photo) {
        } else {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                NToast.m9447b(getActivity(), (int) R.string.notSdCard);
            } else {
                this.f14241k.m4831a(f14233j);
            }
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle extras;
        getActivity();
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (C2744aa.m5193a()) {
                        this.f14241k.m4829b(f14233j, f14232i);
                        return;
                    }
                    return;
                case 2:
                    this.f14242l = SelectPhotoUtils.m4834a(getActivity(), intent.getData());
                    this.f14241k.m4829b(this.f14242l, f14232i);
                    return;
                case 3:
                    if (intent == null || (extras = intent.getExtras()) == null) {
                        return;
                    }
                    Bitmap bitmap = this.f14243m;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    this.f14243m = (Bitmap) extras.getParcelable(DataPacketExtension.ELEMENT_NAME);
                    this.f14236c.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.f14236c.setImageBitmap(this.f14243m);
                    Bitmap bitmap2 = this.f14243m;
                    if (bitmap2 != null) {
                        try {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(f14232i)));
                            bitmap2.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.f14235b = new ImgThumbBean();
                    this.f14235b.setImg(f14232i);
                    this.f14246p = 0;
                    return;
                case 4:
                    Bitmap bitmap3 = this.f14243m;
                    if (bitmap3 != null) {
                        bitmap3.recycle();
                    }
                    ImageLoader.m4191a().m4186b();
                    ImageLoader m4191a = ImageLoader.m4191a();
                    m4191a.m4188a("file://" + f14232i, this.f14236c, this.f14234a);
                    this.f14235b = new ImgThumbBean();
                    this.f14235b.setImg(f14232i);
                    this.f14246p = 0;
                    this.f14239f.setEnabled(true);
                    return;
                default:
                    return;
            }
        }
        FileUtils.m5000d(f14233j);
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final void mo5996a(int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.f14243m;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f14243m = null;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        InfaceFragmentParent infaceFragmentParent = this.f14245o;
        if (infaceFragmentParent != null) {
            infaceFragmentParent.mo6035a((OnActivityResultListenter) null);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 30005) {
            UserSettingInfo userSettingInfo = new UserSettingInfo();
            userSettingInfo.setPic(this.f14235b.getImg());
            PreferencesManager.m9595a((Context) getActivity()).m9584b("user_id", "");
            return this.f14244n.m5262b(userSettingInfo);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        if (i != 30005) {
            return;
        }
        LoadDialog.m4681b(getActivity());
        if (obj != null) {
            if (isSuccess(((FaceSettingRespone) obj).getCode())) {
                NToast.m9450a(this.mContext, (int) R.string.change_face_success);
                ImageLoader.m4191a().m4186b();
                ImageLoader.m4191a().m4184c();
                ImageLoader.m4191a().m4188a(UserFaceUtils.m9115a(PreferencesManager.m9595a(this.mContext).m9591a("user_id"), PreferencesManager.m9595a(this.mContext).m9591a("current_country").equalsIgnoreCase("CN") ? "1" : "2"), this.f14236c, this.f14234a);
                try {
                    this.mContext.sendBroadcast(new Intent("changeFace"));
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        this.f14246p = 0;
        this.f14239f.setEnabled(true);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        if (i != 30005) {
            return;
        }
        LoadDialog.m4681b(getActivity());
        this.f14246p = 0;
        this.f14239f.setEnabled(true);
        NToast.m9450a(this.mContext, (int) R.string.change_face_failure);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
