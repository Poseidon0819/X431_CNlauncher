package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.utils.p280b.LanChaset;
import com.cnlaunch.x431pro.widget.p290a.MulitInputDialog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bh */
/* loaded from: classes.dex */
final class DialogC2074bh extends MulitInputDialog {

    /* renamed from: a */
    final /* synthetic */ C2071be f11542a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2074bh(C2071be c2071be, Context context, String str, ArrayList arrayList) {
        super(context, str, arrayList);
        this.f11542a = c2071be;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.MulitInputDialog
    /* renamed from: a */
    public final void mo4665a(ArrayList<String> arrayList) {
        int i;
        int size = arrayList.size();
        String m5100a = LanChaset.m5100a(Locale.getDefault().getCountry());
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                i2 += arrayList.get(i3).getBytes(m5100a).length + 1;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                i2++;
            }
        }
        byte[] bArr = new byte[i2 + 4];
        bArr[0] = 1;
        bArr[1] = (byte) (size & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        int i4 = 4;
        for (int i5 = 0; i5 < size; i5++) {
            if (arrayList.get(i5) != null) {
                try {
                    byte[] bytes = arrayList.get(i5).getBytes(m5100a);
                    i = bytes.length;
                    System.arraycopy(bytes, 0, bArr, i4, i);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    i = 0;
                }
            } else {
                i = 0;
            }
            bArr[i4 + i] = 0;
            i4 += i + 1;
        }
        this.f11542a.f11538d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_MULTI_INPUT_WINDOW, bArr);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.MulitInputDialog
    /* renamed from: h_ */
    public final void mo4660h_() {
        this.f11542a.f11538d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_MULTI_INPUT_WINDOW, new byte[]{0});
    }
}
