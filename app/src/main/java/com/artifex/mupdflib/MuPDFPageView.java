package com.artifex.mupdflib;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import com.artifex.mupdflib.Annotation;
import com.artifex.mupdflib.FilePicker;
import com.artifex.mupdflib.MuPDFCore;
import com.itextpdf.text.pdf.ColumnText;
import java.util.ArrayList;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class MuPDFPageView extends PageView implements MuPDFView {
    private Runnable changeReporter;
    private AsyncTask<PointF[][], Void, Void> mAddInk;
    private AsyncTask<PointF[], Void, Void> mAddStrikeOut;
    private Annotation[] mAnnotations;
    private AsyncTask<Void, Void, String> mCheckSignature;
    private AlertDialog.Builder mChoiceEntryBuilder;
    private final MuPDFCore mCore;
    private AsyncTask<Integer, Void, Void> mDeleteAnnotation;
    private MuPDFReaderView mDocView;
    private EditText mEditText;
    private final FilePicker.FilePickerSupport mFilePickerSupport;
    private AsyncTask<Void, Void, Annotation[]> mLoadAnnotations;
    private AsyncTask<Void, Void, RectF[]> mLoadWidgetAreas;
    private AsyncTask<Void, Void, PassClickResult> mPassClick;
    private AlertDialog mPasswordEntry;
    private AlertDialog.Builder mPasswordEntryBuilder;
    private EditText mPasswordText;
    private int mSelectedAnnotationIndex;
    private AsyncTask<String, Void, Void> mSetWidgetChoice;
    private AsyncTask<String, Void, Boolean> mSetWidgetText;
    private AsyncTask<Void, Void, Boolean> mSign;
    private AlertDialog.Builder mSignatureReportBuilder;
    private AlertDialog.Builder mSigningDialogBuilder;
    private AlertDialog mTextEntry;
    private AlertDialog.Builder mTextEntryBuilder;
    private RectF[] mWidgetAreas;

    @Override // com.artifex.mupdflib.MuPDFView
    public void setScale(float f) {
    }

    public MuPDFPageView(Context context, FilePicker.FilePickerSupport filePickerSupport, MuPDFCore muPDFCore, Point point, Bitmap bitmap, MuPDFReaderView muPDFReaderView, MuPDFCore.Callback callback) {
        super(context, point, bitmap, callback);
        this.mSelectedAnnotationIndex = -1;
        this.mFilePickerSupport = filePickerSupport;
        this.mDocView = muPDFReaderView;
        this.mCore = muPDFCore;
        this.mTextEntryBuilder = new AlertDialog.Builder(context);
        AlertDialog.Builder builder = this.mTextEntryBuilder;
        builder.setTitle("MuPDF: " + getContext().getString(C0835R.string.fill_out_text_field));
        this.mEditText = (EditText) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0835R.layout.textentry, (ViewGroup) null);
        this.mTextEntryBuilder.setView(this.mEditText);
        this.mTextEntryBuilder.setNegativeButton(C0835R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFPageView.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        this.mTextEntryBuilder.setPositiveButton(C0835R.string.okay, new DialogInterface.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFPageView.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MuPDFPageView.this.mSetWidgetText = new AsyncTask<String, Void, Boolean>() { // from class: com.artifex.mupdflib.MuPDFPageView.2.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.artifex.mupdflib.AsyncTask
                    public Boolean doInBackground(String... strArr) {
                        return Boolean.valueOf(MuPDFPageView.this.mCore.setFocusedWidgetText(MuPDFPageView.this.mPageNumber, strArr[0]));
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.artifex.mupdflib.AsyncTask
                    public void onPostExecute(Boolean bool) {
                        MuPDFPageView.this.changeReporter.run();
                        if (bool.booleanValue()) {
                            return;
                        }
                        MuPDFPageView.this.invokeTextDialog(MuPDFPageView.this.mEditText.getText().toString());
                    }
                };
                MuPDFPageView.this.mSetWidgetText.execute(MuPDFPageView.this.mEditText.getText().toString());
            }
        });
        this.mTextEntry = this.mTextEntryBuilder.create();
        this.mChoiceEntryBuilder = new AlertDialog.Builder(context);
        AlertDialog.Builder builder2 = this.mChoiceEntryBuilder;
        builder2.setTitle("MuPDF: " + getContext().getString(C0835R.string.choose_value));
        this.mSigningDialogBuilder = new AlertDialog.Builder(context);
        this.mSigningDialogBuilder.setTitle("Select certificate and sign?");
        this.mSigningDialogBuilder.setNegativeButton(C0835R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFPageView.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        this.mSigningDialogBuilder.setPositiveButton(C0835R.string.okay, new DialogInterface.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFPageView.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                new FilePicker(MuPDFPageView.this.mFilePickerSupport) { // from class: com.artifex.mupdflib.MuPDFPageView.4.1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Override // com.artifex.mupdflib.FilePicker
                    public void onPick(Uri uri) {
                        MuPDFPageView.this.signWithKeyFile(uri);
                    }
                }.pick();
            }
        });
        this.mSignatureReportBuilder = new AlertDialog.Builder(context);
        this.mSignatureReportBuilder.setTitle("Signature checked");
        this.mSignatureReportBuilder.setPositiveButton(C0835R.string.okay, new DialogInterface.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFPageView.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        this.mPasswordText = new EditText(context);
        this.mPasswordText.setInputType(128);
        this.mPasswordText.setTransformationMethod(new PasswordTransformationMethod());
        this.mPasswordEntryBuilder = new AlertDialog.Builder(context);
        this.mPasswordEntryBuilder.setTitle(C0835R.string.enter_password);
        this.mPasswordEntryBuilder.setView(this.mPasswordText);
        this.mPasswordEntryBuilder.setNegativeButton(C0835R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFPageView.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        this.mPasswordEntry = this.mPasswordEntryBuilder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signWithKeyFile(final Uri uri) {
        this.mPasswordEntry.getWindow().setSoftInputMode(5);
        this.mPasswordEntry.setButton(-1, "Sign", new DialogInterface.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFPageView.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                MuPDFPageView muPDFPageView = MuPDFPageView.this;
                muPDFPageView.signWithKeyFileAndPassword(uri, muPDFPageView.mPasswordText.getText().toString());
            }
        });
        this.mPasswordEntry.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signWithKeyFileAndPassword(final Uri uri, final String str) {
        this.mSign = new AsyncTask<Void, Void, Boolean>() { // from class: com.artifex.mupdflib.MuPDFPageView.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                return Boolean.valueOf(MuPDFPageView.this.mCore.signFocusedSignature(Uri.decode(uri.getEncodedPath()), str));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onPostExecute(Boolean bool) {
                if (bool.booleanValue()) {
                    MuPDFPageView.this.changeReporter.run();
                    return;
                }
                MuPDFPageView.this.mPasswordText.setText("");
                MuPDFPageView.this.signWithKeyFile(uri);
            }
        };
        this.mSign.execute(new Void[0]);
    }

    @Override // com.artifex.mupdflib.MuPDFView
    public LinkInfo hitLink(float f, float f2) {
        LinkInfo[] linkInfoArr;
        float width = (this.mSourceScale * getWidth()) / this.mSize.x;
        float left = (f - getLeft()) / width;
        float top = (f2 - getTop()) / width;
        if (this.mLinks != null) {
            for (LinkInfo linkInfo : this.mLinks) {
                if (linkInfo.rect.contains(left, top)) {
                    return linkInfo;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeTextDialog(String str) {
        this.mEditText.setText(str);
        this.mTextEntry.getWindow().setSoftInputMode(5);
        this.mTextEntry.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChoiceDialog(final String[] strArr) {
        this.mChoiceEntryBuilder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFPageView.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MuPDFPageView.this.mSetWidgetChoice = new AsyncTask<String, Void, Void>() { // from class: com.artifex.mupdflib.MuPDFPageView.9.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.artifex.mupdflib.AsyncTask
                    public Void doInBackground(String... strArr2) {
                        MuPDFPageView.this.mCore.setFocusedWidgetChoiceSelected(new String[]{strArr2[0]});
                        return null;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.artifex.mupdflib.AsyncTask
                    public void onPostExecute(Void r1) {
                        MuPDFPageView.this.changeReporter.run();
                    }
                };
                MuPDFPageView.this.mSetWidgetChoice.execute(strArr[i]);
            }
        });
        this.mChoiceEntryBuilder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeSignatureCheckingDialog() {
        this.mCheckSignature = new AsyncTask<Void, Void, String>() { // from class: com.artifex.mupdflib.MuPDFPageView.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public String doInBackground(Void... voidArr) {
                return MuPDFPageView.this.mCore.checkFocusedSignature();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onPostExecute(String str) {
                AlertDialog create = MuPDFPageView.this.mSignatureReportBuilder.create();
                create.setMessage(str);
                create.show();
            }
        };
        this.mCheckSignature.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeSigningDialog() {
        this.mSigningDialogBuilder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void warnNoSignatureSupport() {
        AlertDialog create = this.mSignatureReportBuilder.create();
        create.setTitle("App built with no signature support");
        create.show();
    }

    @Override // com.artifex.mupdflib.MuPDFView
    public void setChangeReporter(Runnable runnable) {
        this.changeReporter = runnable;
    }

    @Override // com.artifex.mupdflib.MuPDFView
    public Hit passClickEvent(float f, float f2) {
        boolean z;
        float width = (this.mSourceScale * getWidth()) / this.mSize.x;
        final float left = (f - getLeft()) / width;
        final float top = (f2 - getTop()) / width;
        if (this.mAnnotations != null) {
            int i = 0;
            while (true) {
                Annotation[] annotationArr = this.mAnnotations;
                if (i >= annotationArr.length) {
                    z = false;
                    break;
                } else if (annotationArr[i].contains(left, top)) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                switch (this.mAnnotations[i].type) {
                    case HIGHLIGHT:
                    case UNDERLINE:
                    case SQUIGGLY:
                    case STRIKEOUT:
                    case INK:
                        this.mSelectedAnnotationIndex = i;
                        setItemSelectBox(this.mAnnotations[i]);
                        return Hit.Annotation;
                }
            }
        } else {
            z = false;
        }
        this.mSelectedAnnotationIndex = -1;
        setItemSelectBox(null);
        if (!this.mCore.javascriptSupported()) {
            return Hit.Nothing;
        }
        if (this.mWidgetAreas != null) {
            int i2 = 0;
            while (true) {
                RectF[] rectFArr = this.mWidgetAreas;
                if (i2 < rectFArr.length && !z) {
                    if (rectFArr[i2].contains(left, top)) {
                        z = true;
                    }
                    i2++;
                }
            }
        }
        if (z) {
            this.mPassClick = new AsyncTask<Void, Void, PassClickResult>() { // from class: com.artifex.mupdflib.MuPDFPageView.11
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.artifex.mupdflib.AsyncTask
                public PassClickResult doInBackground(Void... voidArr) {
                    return MuPDFPageView.this.mCore.passClickEvent(MuPDFPageView.this.mPageNumber, left, top);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.artifex.mupdflib.AsyncTask
                public void onPostExecute(PassClickResult passClickResult) {
                    if (passClickResult.changed) {
                        MuPDFPageView.this.changeReporter.run();
                    }
                    passClickResult.acceptVisitor(new PassClickResultVisitor() { // from class: com.artifex.mupdflib.MuPDFPageView.11.1
                        @Override // com.artifex.mupdflib.PassClickResultVisitor
                        public void visitText(PassClickResultText passClickResultText) {
                            MuPDFPageView.this.invokeTextDialog(passClickResultText.text);
                        }

                        @Override // com.artifex.mupdflib.PassClickResultVisitor
                        public void visitChoice(PassClickResultChoice passClickResultChoice) {
                            MuPDFPageView.this.invokeChoiceDialog(passClickResultChoice.options);
                        }

                        @Override // com.artifex.mupdflib.PassClickResultVisitor
                        public void visitSignature(PassClickResultSignature passClickResultSignature) {
                            switch (C081221.$SwitchMap$com$artifex$mupdflib$SignatureState[passClickResultSignature.state.ordinal()]) {
                                case 1:
                                    MuPDFPageView.this.warnNoSignatureSupport();
                                    return;
                                case 2:
                                    MuPDFPageView.this.invokeSigningDialog();
                                    return;
                                case 3:
                                    MuPDFPageView.this.invokeSignatureCheckingDialog();
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                }
            };
            this.mPassClick.execute(new Void[0]);
            return Hit.Widget;
        }
        return Hit.Nothing;
    }

    /* renamed from: com.artifex.mupdflib.MuPDFPageView$21 */
    /* loaded from: classes.dex */
    /* synthetic */ class C081221 {
        static final /* synthetic */ int[] $SwitchMap$com$artifex$mupdflib$SignatureState = new int[SignatureState.values().length];

        static {
            try {
                $SwitchMap$com$artifex$mupdflib$SignatureState[SignatureState.NoSupport.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$artifex$mupdflib$SignatureState[SignatureState.Unsigned.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$artifex$mupdflib$SignatureState[SignatureState.Signed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $SwitchMap$com$artifex$mupdflib$Annotation$Type = new int[Annotation.Type.values().length];
            try {
                $SwitchMap$com$artifex$mupdflib$Annotation$Type[Annotation.Type.HIGHLIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$artifex$mupdflib$Annotation$Type[Annotation.Type.UNDERLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$artifex$mupdflib$Annotation$Type[Annotation.Type.SQUIGGLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$artifex$mupdflib$Annotation$Type[Annotation.Type.STRIKEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$artifex$mupdflib$Annotation$Type[Annotation.Type.INK.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // com.artifex.mupdflib.MuPDFView
    @TargetApi(11)
    public boolean copySelection() {
        final StringBuilder sb = new StringBuilder();
        processSelectedText(new TextProcessor() { // from class: com.artifex.mupdflib.MuPDFPageView.12
            StringBuilder line;

            @Override // com.artifex.mupdflib.TextProcessor
            public void onStartLine() {
                this.line = new StringBuilder();
            }

            @Override // com.artifex.mupdflib.TextProcessor
            public void onWord(TextWord textWord) {
                if (this.line.length() > 0) {
                    this.line.append(TokenParser.f24154SP);
                }
                this.line.append(textWord.f3564w);
            }

            @Override // com.artifex.mupdflib.TextProcessor
            public void onEndLine() {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                sb.append((CharSequence) this.line);
            }
        });
        if (sb.length() == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            ((ClipboardManager) this.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("MuPDF", sb));
        } else {
            ((android.text.ClipboardManager) this.mContext.getSystemService("clipboard")).setText(sb);
        }
        deselectText();
        return true;
    }

    @Override // com.artifex.mupdflib.MuPDFView
    public boolean markupSelection(final Annotation.Type type) {
        final ArrayList arrayList = new ArrayList();
        processSelectedText(new TextProcessor() { // from class: com.artifex.mupdflib.MuPDFPageView.13
            RectF rect;

            @Override // com.artifex.mupdflib.TextProcessor
            public void onStartLine() {
                this.rect = new RectF();
            }

            @Override // com.artifex.mupdflib.TextProcessor
            public void onWord(TextWord textWord) {
                this.rect.union(textWord);
            }

            @Override // com.artifex.mupdflib.TextProcessor
            public void onEndLine() {
                if (this.rect.isEmpty()) {
                    return;
                }
                arrayList.add(new PointF(this.rect.left, this.rect.bottom));
                arrayList.add(new PointF(this.rect.right, this.rect.bottom));
                arrayList.add(new PointF(this.rect.right, this.rect.top));
                arrayList.add(new PointF(this.rect.left, this.rect.top));
            }
        });
        if (arrayList.size() == 0) {
            return false;
        }
        this.mAddStrikeOut = new AsyncTask<PointF[], Void, Void>() { // from class: com.artifex.mupdflib.MuPDFPageView.14
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public Void doInBackground(PointF[]... pointFArr) {
                MuPDFPageView.this.addMarkup(pointFArr[0], type);
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onPostExecute(Void r1) {
                MuPDFPageView.this.loadAnnotations();
                MuPDFPageView.this.update();
            }
        };
        this.mAddStrikeOut.execute((PointF[]) arrayList.toArray(new PointF[arrayList.size()]));
        deselectText();
        return true;
    }

    @Override // com.artifex.mupdflib.MuPDFView
    public void deleteSelectedAnnotation() {
        if (this.mSelectedAnnotationIndex != -1) {
            AsyncTask<Integer, Void, Void> asyncTask = this.mDeleteAnnotation;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            this.mDeleteAnnotation = new AsyncTask<Integer, Void, Void>() { // from class: com.artifex.mupdflib.MuPDFPageView.15
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.artifex.mupdflib.AsyncTask
                public Void doInBackground(Integer... numArr) {
                    MuPDFPageView.this.mCore.deleteAnnotation(MuPDFPageView.this.mPageNumber, numArr[0].intValue());
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.artifex.mupdflib.AsyncTask
                public void onPostExecute(Void r1) {
                    MuPDFPageView.this.loadAnnotations();
                    MuPDFPageView.this.update();
                }
            };
            this.mDeleteAnnotation.execute(Integer.valueOf(this.mSelectedAnnotationIndex));
            this.mSelectedAnnotationIndex = -1;
            setItemSelectBox(null);
        }
    }

    @Override // com.artifex.mupdflib.MuPDFView
    public void deselectAnnotation() {
        this.mSelectedAnnotationIndex = -1;
        setItemSelectBox(null);
    }

    @Override // com.artifex.mupdflib.MuPDFView
    public boolean saveDraw() {
        if (getDraw() == null) {
            return false;
        }
        AsyncTask<PointF[][], Void, Void> asyncTask = this.mAddInk;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.mAddInk = null;
        }
        this.mAddInk = new AsyncTask<PointF[][], Void, Void>() { // from class: com.artifex.mupdflib.MuPDFPageView.16
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public Void doInBackground(PointF[][]... pointFArr) {
                MuPDFPageView.this.mCore.addInkAnnotation(MuPDFPageView.this.mPageNumber, pointFArr[0]);
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onPostExecute(Void r1) {
                MuPDFPageView.this.loadAnnotations();
                MuPDFPageView.this.update();
            }
        };
        this.mAddInk.execute(getDraw());
        cancelDraw();
        return true;
    }

    @Override // com.artifex.mupdflib.PageView
    protected CancellableTaskDefinition<Void, Void> getDrawPageTask(final Bitmap bitmap, final int i, final int i2, final int i3, final int i4, final int i5, final int i6) {
        return new MuPDFCancellableTaskDefinition<Void, Void>(this.mCore) { // from class: com.artifex.mupdflib.MuPDFPageView.17
            @Override // com.artifex.mupdflib.MuPDFCancellableTaskDefinition
            public Void doInBackground(MuPDFCore.Cookie cookie, Void... voidArr) {
                if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 14) {
                    bitmap.eraseColor(0);
                }
                MuPDFPageView.this.mCore.drawPage(bitmap, MuPDFPageView.this.mPageNumber, i, i2, i3, i4, i5, i6, cookie);
                return null;
            }
        };
    }

    @Override // com.artifex.mupdflib.PageView
    protected CancellableTaskDefinition<Void, Void> getUpdatePageTask(final Bitmap bitmap, final int i, final int i2, final int i3, final int i4, final int i5, final int i6) {
        return new MuPDFCancellableTaskDefinition<Void, Void>(this.mCore) { // from class: com.artifex.mupdflib.MuPDFPageView.18
            @Override // com.artifex.mupdflib.MuPDFCancellableTaskDefinition
            public Void doInBackground(MuPDFCore.Cookie cookie, Void... voidArr) {
                if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 14) {
                    bitmap.eraseColor(0);
                }
                MuPDFPageView.this.mCore.updatePage(bitmap, MuPDFPageView.this.mPageNumber, i, i2, i3, i4, i5, i6, cookie);
                return null;
            }
        };
    }

    @Override // com.artifex.mupdflib.PageView
    protected LinkInfo[] getLinkInfo() {
        return this.mCore.getPageLinks(this.mPageNumber);
    }

    @Override // com.artifex.mupdflib.PageView
    protected TextWord[][] getText() {
        return this.mCore.textLines(this.mPageNumber);
    }

    @Override // com.artifex.mupdflib.PageView
    protected void addMarkup(PointF[] pointFArr, Annotation.Type type) {
        this.mCore.addMarkupAnnotation(this.mPageNumber, pointFArr, type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAnnotations() {
        this.mAnnotations = null;
        AsyncTask<Void, Void, Annotation[]> asyncTask = this.mLoadAnnotations;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        this.mLoadAnnotations = new AsyncTask<Void, Void, Annotation[]>() { // from class: com.artifex.mupdflib.MuPDFPageView.19
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public Annotation[] doInBackground(Void... voidArr) {
                return MuPDFPageView.this.mCore.getAnnoations(MuPDFPageView.this.mPageNumber);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onPostExecute(Annotation[] annotationArr) {
                MuPDFPageView.this.mAnnotations = annotationArr;
            }
        };
        this.mLoadAnnotations.execute(new Void[0]);
    }

    @Override // com.artifex.mupdflib.PageView, com.artifex.mupdflib.MuPDFView
    public void setPage(final int i, PointF pointF) {
        loadAnnotations();
        this.mLoadWidgetAreas = new AsyncTask<Void, Void, RectF[]>() { // from class: com.artifex.mupdflib.MuPDFPageView.20
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public RectF[] doInBackground(Void... voidArr) {
                return MuPDFPageView.this.mCore.getWidgetAreas(i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onPostExecute(RectF[] rectFArr) {
                MuPDFPageView.this.mWidgetAreas = rectFArr;
            }
        };
        this.mLoadWidgetAreas.execute(new Void[0]);
        super.setPage(i, pointF);
    }

    @Override // com.artifex.mupdflib.PageView
    public void scaleView() {
        if (this.mCore.isSetScaled()) {
            return;
        }
        float parseFloat = this.mCore.getDisplayScreenWidthAndHeight((Activity) this.mContext)[0] / Float.parseFloat(String.valueOf(this.mSize.x));
        if (this.mContext.getResources().getConfiguration().orientation == 1) {
            this.mDocView.setScaleByStart(1.0f);
        } else if (parseFloat != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            this.mDocView.setScaleByStart(parseFloat);
        }
        this.mDocView.requestLayout();
        this.mCore.setSetScaled(true);
    }

    @Override // com.artifex.mupdflib.PageView, com.artifex.mupdflib.MuPDFView
    public void releaseResources() {
        AsyncTask<Void, Void, PassClickResult> asyncTask = this.mPassClick;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.mPassClick = null;
        }
        AsyncTask<Void, Void, RectF[]> asyncTask2 = this.mLoadWidgetAreas;
        if (asyncTask2 != null) {
            asyncTask2.cancel(true);
            this.mLoadWidgetAreas = null;
        }
        AsyncTask<Void, Void, Annotation[]> asyncTask3 = this.mLoadAnnotations;
        if (asyncTask3 != null) {
            asyncTask3.cancel(true);
            this.mLoadAnnotations = null;
        }
        AsyncTask<String, Void, Boolean> asyncTask4 = this.mSetWidgetText;
        if (asyncTask4 != null) {
            asyncTask4.cancel(true);
            this.mSetWidgetText = null;
        }
        AsyncTask<String, Void, Void> asyncTask5 = this.mSetWidgetChoice;
        if (asyncTask5 != null) {
            asyncTask5.cancel(true);
            this.mSetWidgetChoice = null;
        }
        AsyncTask<PointF[], Void, Void> asyncTask6 = this.mAddStrikeOut;
        if (asyncTask6 != null) {
            asyncTask6.cancel(true);
            this.mAddStrikeOut = null;
        }
        AsyncTask<Integer, Void, Void> asyncTask7 = this.mDeleteAnnotation;
        if (asyncTask7 != null) {
            asyncTask7.cancel(true);
            this.mDeleteAnnotation = null;
        }
        super.releaseResources();
    }
}
