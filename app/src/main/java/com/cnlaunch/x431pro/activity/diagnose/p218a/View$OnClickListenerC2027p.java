package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.view.View;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;

/* compiled from: MenuListAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.p */
/* loaded from: classes.dex */
final class View$OnClickListenerC2027p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11405a;

    /* renamed from: b */
    final /* synthetic */ MenuListAdapter f11406b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2027p(MenuListAdapter menuListAdapter, int i) {
        this.f11406b = menuListAdapter;
        this.f11405a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        String str;
        String str2;
        String str3;
        int i2;
        int i3;
        IFragmentCallback iFragmentCallback;
        IFragmentCallback iFragmentCallback2;
        IFragmentCallback iFragmentCallback3;
        StringBuilder sb = new StringBuilder("1");
        sb.append(ByteHexHelper.intToTwoHexString(this.f11405a));
        i = this.f11406b.f11391c;
        sb.append(ByteHexHelper.intToTwoHexString(i));
        String sb2 = sb.toString();
        str = this.f11406b.f11392d;
        if (str.equals(DiagnoseConstants.UI_TYPE_MENU_AND_HELP_BTN_ID)) {
            iFragmentCallback3 = this.f11406b.f11389a;
            iFragmentCallback3.mo7093a(DiagnoseConstants.FEEDBACK_SPT_MENU_AND_HELP_BTN_ID, sb2, 3);
            return;
        }
        str2 = this.f11406b.f11392d;
        if (str2.equals(DiagnoseConstants.UI_TYPE_FILE_MENU_AND_HELP_BTN)) {
            iFragmentCallback2 = this.f11406b.f11389a;
            iFragmentCallback2.mo7093a(DiagnoseConstants.FEEDBACK_SPT_FILE_MENU_AND_HELP_BTN, sb2, 3);
            return;
        }
        str3 = this.f11406b.f11392d;
        if (str3.equals(DiagnoseConstants.UI_TYPE_MENU2HD_ID)) {
            StringBuilder sb3 = new StringBuilder("01");
            sb3.append(ByteHexHelper.intToTwoHexString(this.f11405a));
            i2 = this.f11406b.f11391c;
            sb3.append(ByteHexHelper.intToTwoHexString(i2));
            i3 = this.f11406b.f11398j;
            sb3.append(ByteHexHelper.intToTwoHexString(i3));
            String sb4 = sb3.toString();
            iFragmentCallback = this.f11406b.f11389a;
            iFragmentCallback.mo7093a(DiagnoseConstants.FEEDBACK_SPT_MENU2HD_ID, sb4, 3);
        }
    }
}
