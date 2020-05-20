package com.cnlaunch.diagnosemodule.wiget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.C1444R;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DialogContentPrintUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class DiagnoseAlertDialog extends Dialog {

    /* loaded from: classes.dex */
    public interface DiagnoseAlertDialogCallback {
        void dealWithDialogDismiss(Object obj);

        void dealWithDialogShowing(Object obj);

        void dealWithTranslate(Builder builder, List<String> list);

        boolean showTranslateBtn();
    }

    public DiagnoseAlertDialog(Context context, int i) {
        super(context, 16974129);
    }

    public DiagnoseAlertDialog(Context context) {
        super(context);
        getContext().setTheme(16974129);
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private DialogInterface.OnClickListener NeutralButtonClickListener;
        private String NeutralButtonText;
        private boolean cancelable;
        private View contentView;
        private Context context;
        private DiagnoseAlertDialog instance;
        private boolean isTranslated;
        private ImageView ivTranslate;
        private DiagnoseAlertDialogCallback mDiagnoseAlertDialogCallback;
        private int mIconId;

        /* renamed from: message  reason: collision with root package name */
        private String f24481message;
        private TextView message_content;
        private DialogInterface.OnClickListener negativeButtonClickListener;
        private String negativeButtonText;
        private DialogInterface.OnClickListener positiveButtonClickListener;
        private String positiveButtonText;
        private int style;
        private String title;
        private TextView tvTitle;
        private boolean positiveBtnEnable = true;
        private boolean negativebtnEnable = true;
        private boolean isHTMLdata = false;

        public void setDiagnoseAlertDialogCallback(DiagnoseAlertDialogCallback diagnoseAlertDialogCallback) {
            this.mDiagnoseAlertDialogCallback = diagnoseAlertDialogCallback;
        }

        public Builder(Context context) {
            this.context = context;
        }

        public Builder(Context context, int i) {
            this.context = context;
            this.style = i;
        }

        public void setPositiveBtnEnable(boolean z) {
            this.positiveBtnEnable = z;
        }

        public void setnegativebtnEnable(boolean z) {
            this.negativebtnEnable = z;
        }

        public Builder setMessage(String str) {
            this.f24481message = str;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.cancelable = z;
            return this;
        }

        public Builder setMessage(int i) {
            this.f24481message = (String) this.context.getText(i);
            return this;
        }

        public Builder setTitle(int i) {
            this.title = (String) this.context.getText(i);
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setView(View view) {
            this.contentView = view;
            return this;
        }

        public Builder setIcon(int i) {
            this.mIconId = i;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.positiveButtonText = (String) this.context.getText(i);
            this.positiveButtonClickListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(String str, DialogInterface.OnClickListener onClickListener) {
            this.positiveButtonText = str;
            this.positiveButtonClickListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.negativeButtonText = (String) this.context.getText(i);
            this.negativeButtonClickListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(String str, DialogInterface.OnClickListener onClickListener) {
            this.negativeButtonText = str;
            this.negativeButtonClickListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(String str, DialogInterface.OnClickListener onClickListener) {
            this.NeutralButtonText = str;
            this.NeutralButtonClickListener = onClickListener;
            return this;
        }

        public DiagnoseAlertDialog create() {
            return create(false);
        }

        public boolean onSpeakDialogBtn(int i) {
            DialogInterface.OnClickListener onClickListener;
            if (i == -2) {
                DialogInterface.OnClickListener onClickListener2 = this.negativeButtonClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(this.instance, -2);
                    hide();
                    return true;
                }
                return false;
            } else if (i == -1) {
                DialogInterface.OnClickListener onClickListener3 = this.positiveButtonClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(this.instance, -1);
                    hide();
                    return true;
                }
                return false;
            } else if (i != -3 || (onClickListener = this.NeutralButtonClickListener) == null) {
                return false;
            } else {
                onClickListener.onClick(this.instance, -3);
                hide();
                return true;
            }
        }

        public void setHTMLdata(boolean z) {
            this.isHTMLdata = z;
        }

        public boolean getIsHTMLdata() {
            return this.isHTMLdata;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void SendBroadcastKeyVoice(Context context) {
            context.sendBroadcast(new Intent("DialogNeedPlayKeyVoice"));
        }

        public DiagnoseAlertDialog create(boolean z) {
            Button button;
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            if (this.style == 0) {
                this.style = C1444R.style.DiagnoseMessageDialogTheme;
            }
            final DiagnoseAlertDialog diagnoseAlertDialog = new DiagnoseAlertDialog(this.context, this.style);
            this.instance = diagnoseAlertDialog;
            if (z) {
                View inflate = layoutInflater.inflate(this.isHTMLdata ? C1444R.layout.alert_dialog_with_webview : C1444R.layout.diagnose_alert_dialog, (ViewGroup) null);
                this.tvTitle = (TextView) inflate.findViewById(C1444R.C1445id.title);
                this.tvTitle.setText(this.title);
                this.message_content = (TextView) inflate.findViewById(C1444R.C1445id.message);
                this.message_content.setPadding(10, 10, 10, 10);
                if (this.positiveButtonText != null) {
                    ((Button) inflate.findViewById(C1444R.C1445id.positiveButton)).setText(this.positiveButtonText);
                    if (this.positiveButtonClickListener != null) {
                        ((Button) inflate.findViewById(C1444R.C1445id.positiveButton)).setOnClickListener(new View.OnClickListener() { // from class: com.cnlaunch.diagnosemodule.wiget.DiagnoseAlertDialog.Builder.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (DiagnoseConstants.isDIYneedsound) {
                                    Builder builder = Builder.this;
                                    builder.SendBroadcastKeyVoice(builder.context);
                                }
                                Builder.this.positiveButtonClickListener.onClick(diagnoseAlertDialog, -1);
                                Builder.this.hide();
                            }
                        });
                    }
                    if (DiagnoseConstants.getDiagIdentity() == 0 || DiagnoseConstants.isWebRemote) {
                        Button button2 = (Button) inflate.findViewById(C1444R.C1445id.positiveButton);
                        button2.setBackgroundColor(this.context.getResources().getColor(C1444R.color.transparent));
                        button2.setTextColor(this.context.getResources().getColor(C1444R.color.grayb0));
                        button2.setClickable(false);
                    }
                    inflate.findViewById(C1444R.C1445id.positiveButton).setEnabled(this.positiveBtnEnable);
                } else {
                    inflate.findViewById(C1444R.C1445id.positiveButton).setVisibility(8);
                }
                if (this.negativeButtonText != null) {
                    ((Button) inflate.findViewById(C1444R.C1445id.negativeButton)).setText(this.negativeButtonText);
                    if (this.negativeButtonClickListener != null) {
                        ((Button) inflate.findViewById(C1444R.C1445id.negativeButton)).setOnClickListener(new View.OnClickListener() { // from class: com.cnlaunch.diagnosemodule.wiget.DiagnoseAlertDialog.Builder.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (DiagnoseConstants.isDIYneedsound) {
                                    Builder builder = Builder.this;
                                    builder.SendBroadcastKeyVoice(builder.context);
                                }
                                Builder.this.negativeButtonClickListener.onClick(diagnoseAlertDialog, -2);
                                Builder.this.hide();
                            }
                        });
                    }
                    if (DiagnoseConstants.getDiagIdentity() == 0 || DiagnoseConstants.isWebRemote) {
                        Button button3 = (Button) inflate.findViewById(C1444R.C1445id.negativeButton);
                        button3.setBackgroundColor(this.context.getResources().getColor(C1444R.color.transparent));
                        button3.setTextColor(this.context.getResources().getColor(C1444R.color.grayb0));
                        button3.setClickable(false);
                    }
                    inflate.findViewById(C1444R.C1445id.negativeButton).setEnabled(this.negativebtnEnable);
                } else {
                    inflate.findViewById(C1444R.C1445id.negativeButton).setVisibility(8);
                }
                if (this.NeutralButtonText != null && (button = (Button) inflate.findViewById(C1444R.C1445id.neutralButton)) != null) {
                    button.setText(this.NeutralButtonText);
                    if (this.NeutralButtonClickListener != null) {
                        button.setOnClickListener(new View.OnClickListener() { // from class: com.cnlaunch.diagnosemodule.wiget.DiagnoseAlertDialog.Builder.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (DiagnoseConstants.isDIYneedsound) {
                                    Builder builder = Builder.this;
                                    builder.SendBroadcastKeyVoice(builder.context);
                                }
                                Builder.this.NeutralButtonClickListener.onClick(diagnoseAlertDialog, -3);
                                Builder.this.hide();
                            }
                        });
                    }
                    if (DiagnoseConstants.getDiagIdentity() == 0 || DiagnoseConstants.isWebRemote) {
                        button.setBackgroundColor(this.context.getResources().getColor(C1444R.color.transparent));
                        button.setTextColor(this.context.getResources().getColor(C1444R.color.grayb0));
                        button.setClickable(false);
                    }
                }
                if (this.f24481message != null) {
                    boolean z2 = true;
                    if (!this.isHTMLdata) {
                        ((TextView) inflate.findViewById(C1444R.C1445id.message)).setText(this.f24481message);
                        this.ivTranslate = (ImageView) inflate.findViewById(C1444R.C1445id.iv_translate);
                        DiagnoseAlertDialogCallback diagnoseAlertDialogCallback = this.mDiagnoseAlertDialogCallback;
                        if (diagnoseAlertDialogCallback != null && diagnoseAlertDialogCallback.showTranslateBtn() && (!TextUtils.isEmpty(this.title) || !TextUtils.isEmpty(this.f24481message))) {
                            this.ivTranslate.setVisibility(0);
                            this.ivTranslate.setOnClickListener(new View.OnClickListener() { // from class: com.cnlaunch.diagnosemodule.wiget.DiagnoseAlertDialog.Builder.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (!Builder.this.isTranslated) {
                                        Builder.this.ivTranslate.setEnabled(false);
                                        ArrayList arrayList = new ArrayList();
                                        if (!TextUtils.isEmpty(Builder.this.title)) {
                                            arrayList.add(Builder.this.title);
                                        }
                                        if (!TextUtils.isEmpty(Builder.this.f24481message)) {
                                            arrayList.add(Builder.this.f24481message);
                                        }
                                        Builder.this.mDiagnoseAlertDialogCallback.dealWithTranslate(Builder.this, arrayList);
                                        return;
                                    }
                                    Builder.this.resertText();
                                }
                            });
                        }
                    } else {
                        inflate.findViewById(C1444R.C1445id.sv_content).setVisibility(8);
                        WebView webView = (WebView) inflate.findViewById(C1444R.C1445id.webView);
                        if (webView != null) {
                            webView.setVisibility(0);
                            webView.getSettings().setTextSize(WebSettings.TextSize.LARGER);
                            if (Build.VERSION.SDK_INT > 16) {
                                webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
                                webView.getSettings().setAllowFileAccessFromFileURLs(true);
                            }
                            webView.getSettings().setAllowFileAccess(true);
                            webView.clearFormData();
                            webView.loadDataWithBaseURL(null, this.f24481message, "text/html", "utf-8", null);
                        }
                    }
                    View findViewById = inflate.findViewById(C1444R.C1445id.btn_print);
                    if (DiagnoseConstants.getDiagIdentity() >= 2 && !DiagnoseConstants.isWebRemote) {
                        z2 = false;
                    }
                    if (findViewById != null && DialogContentPrintUtil.enable(this.context) && !z2) {
                        findViewById.setVisibility(0);
                        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.cnlaunch.diagnosemodule.wiget.DiagnoseAlertDialog.Builder.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                DialogContentPrintUtil.onClickPrintListener(Builder.this.f24481message);
                            }
                        });
                    }
                } else {
                    ((TextView) inflate.findViewById(C1444R.C1445id.message)).setVisibility(8);
                }
                if (this.contentView != null) {
                    ((FrameLayout) inflate.findViewById(C1444R.C1445id.fl_content)).removeAllViews();
                    ((FrameLayout) inflate.findViewById(C1444R.C1445id.fl_content)).addView(this.contentView, new ViewGroup.LayoutParams(-1, -2));
                    ((LinearLayout) inflate.findViewById(C1444R.C1445id.content)).setMinimumHeight(0);
                }
                diagnoseAlertDialog.setContentView(inflate);
                diagnoseAlertDialog.setCancelable(this.cancelable);
                Window window = diagnoseAlertDialog.getWindow();
                if (window != null && DiagnoseConstants.IS_Diglog_bottom) {
                    window.setGravity(80);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.width = -1;
                    attributes.height = -2;
                    window.setAttributes(attributes);
                }
                window.getDecorView().getBackground().setAlpha(0);
                return diagnoseAlertDialog;
            }
            return diagnoseAlertDialog;
        }

        public DiagnoseAlertDialog show() {
            DiagnoseAlertDialog create = create(true);
            DiagnoseAlertDialogCallback diagnoseAlertDialogCallback = this.mDiagnoseAlertDialogCallback;
            if (diagnoseAlertDialogCallback != null) {
                diagnoseAlertDialogCallback.dealWithDialogShowing(this);
            }
            create.show();
            return create;
        }

        public boolean isShowing() {
            DiagnoseAlertDialog diagnoseAlertDialog = this.instance;
            if (diagnoseAlertDialog == null) {
                return false;
            }
            return diagnoseAlertDialog.isShowing();
        }

        public void hide() {
            DiagnoseAlertDialog diagnoseAlertDialog = this.instance;
            if (diagnoseAlertDialog != null) {
                diagnoseAlertDialog.hide();
                this.instance.dismiss();
                DiagnoseAlertDialogCallback diagnoseAlertDialogCallback = this.mDiagnoseAlertDialogCallback;
                if (diagnoseAlertDialogCallback != null) {
                    diagnoseAlertDialogCallback.dealWithDialogDismiss(this);
                }
            }
        }

        public void updateTitle(String str) {
            if (TextUtils.isEmpty(str) || str.equals(this.title)) {
                return;
            }
            this.tvTitle.setText(str);
        }

        public void updateMessage(String str) {
            if (TextUtils.isEmpty(str) || str.equals(this.f24481message)) {
                return;
            }
            this.message_content.setText(str);
        }

        public void revertTitle() {
            if (TextUtils.isEmpty(this.title)) {
                return;
            }
            this.tvTitle.setText(this.title);
        }

        public void resertMessage() {
            if (TextUtils.isEmpty(this.f24481message)) {
                return;
            }
            this.message_content.setText(this.f24481message);
        }

        public void setTranslateText(Map<String, String> map) {
            if (!TextUtils.isEmpty(this.title)) {
                updateTitle(map.get(this.title));
            }
            if (!TextUtils.isEmpty(this.f24481message)) {
                updateMessage(map.get(this.f24481message));
            }
            this.isTranslated = true;
            this.ivTranslate.setEnabled(true);
        }

        public void resertText() {
            revertTitle();
            resertMessage();
            this.isTranslated = false;
            this.ivTranslate.setEnabled(true);
        }
    }
}
