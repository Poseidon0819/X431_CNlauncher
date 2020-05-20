package com.cnlaunch.x431pro.activity.golo.function;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.cnlaunch.golo3.p161c.BaseActivity;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.IOException;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* loaded from: classes.dex */
public class PicturePreviewActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: A */
    private String f12579A;

    /* renamed from: B */
    private Bitmap f12580B;

    /* renamed from: C */
    private ProgressDialog f12581C;

    /* renamed from: D */
    private boolean f12582D = false;

    /* renamed from: E */
    private int f12583E;

    /* renamed from: F */
    private int f12584F;

    /* renamed from: z */
    Button f12585z;

    /* JADX WARN: Removed duplicated region for block: B:70:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0240  */
    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r15) {
        /*
            Method dump skipped, instructions count: 605
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.golo.function.PicturePreviewActivity.onCreate(android.os.Bundle):void");
    }

    /* renamed from: a */
    private void m7016a(String str) {
        Toast.makeText(this, str, 1).show();
    }

    /* renamed from: c */
    private void m7014c() {
        ProgressDialog progressDialog = this.f12581C;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.f12581C.dismiss();
    }

    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.im_picture_preview_button) {
            return;
        }
        Log.i("Sanda", "click");
        if (this.f12579A != null) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.f12579A));
            setResult(-1, intent);
        } else {
            setResult(0);
        }
        finish();
    }

    @Override // com.cnlaunch.golo3.p161c.BaseActivity, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Bitmap bitmap = this.f12580B;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f12580B.recycle();
        }
        m7014c();
        super.onDestroy();
    }

    /* renamed from: b */
    private static int m7015b(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    return TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
                }
                return 90;
            }
            return Opcodes.GETFIELD;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
