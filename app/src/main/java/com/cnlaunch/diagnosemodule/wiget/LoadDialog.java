package com.cnlaunch.diagnosemodule.wiget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.cnlaunch.diagnosemodule.C1444R;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;

/* loaded from: classes.dex */
public class LoadDialog extends Dialog {
    private static LoadDialog loadDialog;
    private static TextView messageView;
    private boolean canNotCancel;
    private String tipMsg;

    public LoadDialog(Context context, boolean z, String str) {
        super(context);
        this.canNotCancel = z;
        this.tipMsg = str;
        getContext().setTheme(16974129);
        setContentView(C1444R.layout.layout_dialog_loading);
        TextView textView = (TextView) findViewById(16908299);
        messageView = textView;
        textView.setText(str);
        setCancelable(false);
        Window window = getWindow();
        if (window != null && DiagnoseConstants.IS_Diglog_bottom) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        window.getDecorView().getBackground().setAlpha(0);
    }

    public LoadDialog(Context context, boolean z, String str, int i) {
        super(context);
        this.canNotCancel = z;
        this.tipMsg = str;
        getContext().setTheme(16974129);
        setContentView(i);
        TextView textView = (TextView) findViewById(16908299);
        messageView = textView;
        textView.setText(str);
        setCancelable(false);
        Window window = getWindow();
        if (window != null && DiagnoseConstants.IS_Diglog_bottom) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        window.getDecorView().getBackground().setAlpha(0);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.canNotCancel) {
            Toast.makeText(getContext(), this.tipMsg, 0).show();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public static void show(Context context) {
        show(context, (String) null, false);
    }

    public static void show(Context context, String str) {
        show(context, str, false);
    }

    public static void show(Context context, String str, View.OnClickListener onClickListener) {
        show(context, str, false, onClickListener);
    }

    private static void show(Context context, String str, boolean z) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        LoadDialog loadDialog2 = loadDialog;
        if (loadDialog2 != null && loadDialog2.isShowing()) {
            messageView.setText(str);
            return;
        }
        LoadDialog loadDialog3 = new LoadDialog(context, z, str);
        loadDialog = loadDialog3;
        loadDialog3.show();
    }

    private static void show(Context context, String str, boolean z, View.OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        LoadDialog loadDialog2 = loadDialog;
        if (loadDialog2 != null && loadDialog2.isShowing()) {
            messageView.setText(str);
            return;
        }
        LoadDialog loadDialog3 = new LoadDialog(context, z, str, C1444R.layout.layout_dialog_loading_home);
        loadDialog = loadDialog3;
        Button button = (Button) loadDialog3.findViewById(C1444R.C1445id.home_btn);
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
        loadDialog.show();
    }

    public static void dismiss(Context context) {
        try {
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                loadDialog = null;
            } else if (loadDialog == null || !loadDialog.isShowing()) {
            } else {
                Context context2 = loadDialog.getContext();
                if (context2 != null && (context2 instanceof Activity) && ((Activity) context2).isFinishing()) {
                    loadDialog = null;
                    return;
                }
                loadDialog.dismiss();
                loadDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            loadDialog = null;
        }
    }

    public static boolean isShow() {
        LoadDialog loadDialog2 = loadDialog;
        if (loadDialog2 != null) {
            return loadDialog2.isShowing();
        }
        return false;
    }
}
