package com.cnlaunch.golo3.view.selectimg;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.cnlaunch.golo3.p161c.BaseActivity;
import com.cnlaunch.golo3.p165g.GoloActivityManager;
import com.cnlaunch.golo3.p165g.GoloLog;
import com.cnlaunch.golo3.p165g.SharePreferenceUtils;
import com.cnlaunch.p132e.p133a.C1464a;
import com.mopub.mobileads.VastExtensionXmlManager;

/* loaded from: classes.dex */
public class CropImageActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: B */
    private CropImageView f8520B;

    /* renamed from: C */
    private Bitmap f8521C;

    /* renamed from: D */
    private CropImage f8522D;

    /* renamed from: E */
    private Button f8523E;

    /* renamed from: F */
    private Button f8524F;

    /* renamed from: G */
    private Button f8525G;

    /* renamed from: H */
    private Button f8526H;

    /* renamed from: K */
    private ProgressBar f8529K;

    /* renamed from: P */
    private SharePreferenceUtils f8534P;

    /* renamed from: Q */
    private LinearLayout f8535Q;

    /* renamed from: I */
    private String f8527I = "CropImageActivity";

    /* renamed from: J */
    private String f8528J = "";

    /* renamed from: z */
    public int f8537z = 0;

    /* renamed from: A */
    public int f8519A = 0;

    /* renamed from: L */
    private String f8530L = null;

    /* renamed from: M */
    private String f8531M = null;

    /* renamed from: N */
    private String f8532N = null;

    /* renamed from: O */
    private String f8533O = null;

    /* renamed from: R */
    private Handler f8536R = new HandlerC1650i(this);

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        return null;
    }

    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1464a.C1469e.activity_crop_image);
        this.f8534P = new SharePreferenceUtils(this);
        if (getIntent().hasExtra("mine_car_id")) {
            this.f8530L = getIntent().getStringExtra("mine_car_id");
        }
        if (getIntent().hasExtra(VastExtensionXmlManager.TYPE)) {
            this.f8531M = getIntent().getStringExtra(VastExtensionXmlManager.TYPE);
        }
        if (getIntent().hasExtra("apply")) {
            this.f8532N = getIntent().getStringExtra("apply");
        }
        if (getIntent().hasExtra("vmt")) {
            this.f8533O = getIntent().getStringExtra("vmt");
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f8537z = displayMetrics.widthPixels;
        this.f8519A = displayMetrics.heightPixels;
        this.f8527I = getIntent().getStringExtra("path");
        this.f8528J = getIntent().getStringExtra("pathBack");
        this.f8520B = (CropImageView) findViewById(C1464a.C1468d.gl_modify_avatar_image);
        this.f8523E = (Button) findViewById(C1464a.C1468d.gl_modify_avatar_save);
        if (this.f8532N != null) {
            this.f8523E.setText(getResources().getString(C1464a.C1470f.confirm));
        }
        this.f8535Q = (LinearLayout) findViewById(C1464a.C1468d.gl_modify_avatar_bottom);
        this.f8524F = (Button) findViewById(C1464a.C1468d.gl_modify_avatar_cancel);
        this.f8525G = (Button) findViewById(C1464a.C1468d.gl_modify_avatar_rotate_left);
        this.f8526H = (Button) findViewById(C1464a.C1468d.gl_modify_avatar_rotate_right);
        this.f8523E.setOnClickListener(this);
        this.f8524F.setOnClickListener(this);
        this.f8525G.setOnClickListener(this);
        this.f8526H.setOnClickListener(this);
        try {
            float m9089a = CropImage.m9089a(this.f8527I);
            this.f8521C = m9103a(this.f8527I, this.f8537z, this.f8519A);
            if (this.f8521C == null) {
                GoloActivityManager.m9138a();
                GoloActivityManager.m9135b(this);
            } else {
                Bitmap m9093a = CropImage.m9093a(this.f8521C, m9089a);
                this.f8520B.setImageBitmapResetBase$1fdc9e65(null);
                this.f8520B.setImageBitmap(m9093a);
                this.f8520B.setImageBitmapResetBase$1fdc9e65(m9093a);
                this.f8522D = new CropImage(this, this.f8520B, this.f8536R);
                CropImage cropImage = this.f8522D;
                cropImage.f8563i = m9093a;
                if (!((Activity) cropImage.f8560f).isFinishing()) {
                    cropImage.m9088a(cropImage.f8560f.getResources().getString(C1464a.C1470f.imWait), new RunnableC1645d(cropImage), cropImage.f8561g);
                }
            }
        } catch (Exception unused) {
            GoloActivityManager.m9138a();
            GoloActivityManager.m9135b(this);
        }
        this.f8529K = new ProgressBar(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addContentView(this.f8529K, layoutParams);
        this.f8529K.setVisibility(4);
        getPackageName();
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.f8521C != null) {
            this.f8521C = null;
        }
    }

    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C1464a.C1468d.gl_modify_avatar_cancel) {
            GoloActivityManager.m9138a();
            GoloActivityManager.m9135b(this);
        }
        if (view.getId() == C1464a.C1468d.gl_modify_avatar_save) {
            CropImage cropImage = this.f8522D;
            Bitmap bitmap = cropImage.f8563i;
            if (!cropImage.f8558d && cropImage.f8559e != null) {
                cropImage.f8558d = true;
                HighlightView highlightView = cropImage.f8559e;
                Rect rect = new Rect((int) highlightView.f8703g.left, (int) highlightView.f8703g.top, (int) highlightView.f8703g.right, (int) highlightView.f8703g.bottom);
                Rect rect2 = cropImage.f8559e.f8701e;
                int width = rect2.width();
                int height = rect2.height();
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                new Canvas(createBitmap).drawBitmap(bitmap, rect, new Rect(0, 0, width, height), (Paint) null);
                bitmap = createBitmap;
            }
            cropImage.f8562h.f8538a.clear();
            String m9092a = CropImage.m9092a(bitmap, this.f8528J);
            GoloLog.m9133a();
            if (m9092a == null) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("crop_path", m9092a);
            setResult(-1, intent);
            GoloActivityManager.m9138a();
            GoloActivityManager.m9135b(this);
        }
        if (view.getId() == C1464a.C1468d.gl_modify_avatar_rotate_left) {
            this.f8522D.m9094a(270.0f);
        }
        if (view.getId() == C1464a.C1468d.gl_modify_avatar_rotate_right) {
            this.f8522D.m9094a(90.0f);
        }
    }

    /* renamed from: a */
    private static Bitmap m9103a(String str, int i, int i2) {
        double d;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            if (i3 < i || i4 < i2) {
                d = 0.0d;
            } else if (i3 > i4) {
                double d2 = i3;
                double d3 = i;
                Double.isNaN(d2);
                Double.isNaN(d3);
                double d4 = d2 / d3;
                double d5 = i4;
                Double.isNaN(d5);
                i4 = (int) (d5 / d4);
                i3 = i;
                d = d4;
            } else {
                double d6 = i4;
                double d7 = i2;
                Double.isNaN(d6);
                Double.isNaN(d7);
                double d8 = d6 / d7;
                double d9 = i3;
                Double.isNaN(d9);
                i3 = (int) (d9 / d8);
                i4 = i2;
                d = d8;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = ((int) d) + 1;
            options2.inJustDecodeBounds = false;
            options2.outHeight = i4;
            options2.outWidth = i3;
            return BitmapFactory.decodeFile(str, options2);
        } catch (Exception unused) {
            return null;
        }
    }
}
