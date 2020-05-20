package com.cnlaunch.x431pro.activity.p217c;

import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.widget.EditText;
import com.ifoer.expedition.pro.R;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.cnlaunch.x431pro.activity.c.c */
/* loaded from: classes.dex */
public final class KeyboardUtil {

    /* renamed from: a */
    KeyboardView f11003a;

    /* renamed from: b */
    Keyboard f11004b;

    /* renamed from: e */
    EditText f11007e;

    /* renamed from: f */
    private Activity f11008f;

    /* renamed from: c */
    public boolean f11005c = false;

    /* renamed from: d */
    public boolean f11006d = true;

    /* renamed from: g */
    private KeyboardView.OnKeyboardActionListener f11009g = new C2007d(this);

    public KeyboardUtil(EditText editText) {
        this.f11007e = editText;
        this.f11008f = (Activity) editText.getContext();
        this.f11004b = new Keyboard(this.f11008f, R.layout.layout_keyboard);
        this.f11003a = (KeyboardView) this.f11008f.findViewById(R.id.keyboard_view);
        this.f11003a.setKeyboard(this.f11004b);
        this.f11003a.setEnabled(true);
        this.f11003a.setPreviewEnabled(false);
        Activity activity = this.f11008f;
        if (Build.VERSION.SDK_INT <= 10) {
            editText.setInputType(0);
        } else {
            activity.getWindow().setSoftInputMode(3);
            try {
                EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE).invoke(editText, Boolean.FALSE);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        this.f11003a.setOnKeyboardActionListener(this.f11009g);
    }

    /* renamed from: a */
    public final void m7727a() {
        if (this.f11003a.getVisibility() == 0) {
            this.f11003a.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m7726a(String str) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(str.toLowerCase()) >= 0;
    }

    /* renamed from: b */
    public static String m7725b(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i += 4) {
            int i2 = i + 2;
            byte[] bArr = {(byte) (Integer.parseInt(str.substring(i, i2)) + 160), (byte) (Integer.parseInt(str.substring(i2, str.length())) + 160)};
            String str3 = "";
            try {
                str3 = new String(bArr, "GB2312");
            } catch (Exception e) {
                e.printStackTrace();
            }
            str2 = str2 + str3;
        }
        return str2;
    }
}
