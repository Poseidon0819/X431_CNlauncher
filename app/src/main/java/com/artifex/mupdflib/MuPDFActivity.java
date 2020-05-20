package com.artifex.mupdflib;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;
import com.artifex.mupdflib.CallbackApplication;
import com.artifex.mupdflib.FilePicker;
import com.artifex.mupdflib.MuPDFAlert;
import com.artifex.mupdflib.ReaderView;
import com.artifex.mupdflib.TwoWayView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfObject;

/* loaded from: classes.dex */
public class MuPDFActivity extends Activity implements FilePicker.FilePickerSupport {
    private static AlertDialog.Builder gAlertBuilder;
    private MuPDFCore core;
    private AlertDialog.Builder mAlertBuilder;
    private AlertDialog mAlertDialog;
    private AsyncTask<Void, Void, MuPDFAlert> mAlertTask;
    private View mButtonsView;
    private boolean mButtonsVisible;
    private String mDocName;
    private MuPDFReaderView mDocView;
    private String mFileName;
    private FilePicker mFilePicker;
    private TextView mInfoView;
    private int mOrientation;
    private TextView mPageNumberView;
    private TwoWayView mPreview;
    private FrameLayout mPreviewBarHolder;
    private String mProofFile;
    private ImageButton mSearchBack;
    private ImageButton mSearchButton;
    private ImageButton mSearchFwd;
    private SearchTask mSearchTask;
    private EditText mSearchText;
    private boolean[][] mSepEnabled;
    private ViewAnimator mTopBarSwitcher;
    private ToolbarPreviewAdapter pdfPreviewPagerAdapter;
    private final int PRINT_REQUEST = 1;
    private final int FILEPICK_REQUEST = 2;
    private final int PAGE_CHOICE_REQUEST = 3;
    private final int PROOF_REQUEST = 4;
    private TopBarMode mTopBarMode = TopBarMode.Main;
    private final Handler mHandler = new Handler();
    private boolean mAlertsActive = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TopBarMode {
        Main,
        Search
    }

    private Context getContext() {
        return this;
    }

    public static AlertDialog.Builder getAlertBuilder() {
        return gAlertBuilder;
    }

    public void createAlertWaiter() {
        this.mAlertsActive = true;
        AsyncTask<Void, Void, MuPDFAlert> asyncTask = this.mAlertTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.mAlertTask = null;
        }
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.cancel();
            this.mAlertDialog = null;
        }
        this.mAlertTask = new AsyncTask<Void, Void, MuPDFAlert>() { // from class: com.artifex.mupdflib.MuPDFActivity.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public MuPDFAlert doInBackground(Void... voidArr) {
                if (MuPDFActivity.this.mAlertsActive) {
                    return MuPDFActivity.this.core.waitForAlert();
                }
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.AsyncTask
            public void onPostExecute(final MuPDFAlert muPDFAlert) {
                if (muPDFAlert == null) {
                    return;
                }
                final MuPDFAlert.ButtonPressed[] buttonPressedArr = new MuPDFAlert.ButtonPressed[3];
                for (int i = 0; i < 3; i++) {
                    buttonPressedArr[i] = MuPDFAlert.ButtonPressed.None;
                }
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFActivity.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        MuPDFActivity.this.mAlertDialog = null;
                        if (MuPDFActivity.this.mAlertsActive) {
                            char c = 0;
                            switch (i2) {
                                case -3:
                                    c = 2;
                                    break;
                                case -2:
                                    c = 1;
                                    break;
                            }
                            muPDFAlert.buttonPressed = buttonPressedArr[c];
                            MuPDFActivity.this.core.replyToAlert(muPDFAlert);
                            MuPDFActivity.this.createAlertWaiter();
                        }
                    }
                };
                MuPDFActivity muPDFActivity = MuPDFActivity.this;
                muPDFActivity.mAlertDialog = muPDFActivity.mAlertBuilder.create();
                MuPDFActivity.this.mAlertDialog.setTitle(muPDFAlert.title);
                MuPDFActivity.this.mAlertDialog.setMessage(muPDFAlert.f24477message);
                int[] iArr = C078725.$SwitchMap$com$artifex$mupdflib$MuPDFAlert$IconType;
                muPDFAlert.iconType.ordinal();
                switch (C078725.$SwitchMap$com$artifex$mupdflib$MuPDFAlert$ButtonGroupType[muPDFAlert.buttonGroupType.ordinal()]) {
                    case 1:
                        MuPDFActivity.this.mAlertDialog.setButton(-2, MuPDFActivity.this.getString(C0835R.string.cancel), onClickListener);
                        buttonPressedArr[1] = MuPDFAlert.ButtonPressed.Cancel;
                    case 2:
                        MuPDFActivity.this.mAlertDialog.setButton(-1, MuPDFActivity.this.getString(C0835R.string.okay), onClickListener);
                        buttonPressedArr[0] = MuPDFAlert.ButtonPressed.Ok;
                        break;
                    case 3:
                        MuPDFActivity.this.mAlertDialog.setButton(-3, MuPDFActivity.this.getString(C0835R.string.cancel), onClickListener);
                        buttonPressedArr[2] = MuPDFAlert.ButtonPressed.Cancel;
                    case 4:
                        MuPDFActivity.this.mAlertDialog.setButton(-1, MuPDFActivity.this.getString(C0835R.string.yes), onClickListener);
                        buttonPressedArr[0] = MuPDFAlert.ButtonPressed.Yes;
                        MuPDFActivity.this.mAlertDialog.setButton(-2, MuPDFActivity.this.getString(C0835R.string.f3562no), onClickListener);
                        buttonPressedArr[1] = MuPDFAlert.ButtonPressed.No;
                        break;
                }
                MuPDFActivity.this.mAlertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.artifex.mupdflib.MuPDFActivity.1.2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        MuPDFActivity.this.mAlertDialog = null;
                        if (MuPDFActivity.this.mAlertsActive) {
                            muPDFAlert.buttonPressed = MuPDFAlert.ButtonPressed.None;
                            MuPDFActivity.this.core.replyToAlert(muPDFAlert);
                            MuPDFActivity.this.createAlertWaiter();
                        }
                    }
                });
                MuPDFActivity.this.mAlertDialog.show();
            }
        };
        this.mAlertTask.executeOnExecutor(new ThreadPerTaskExecutor(), new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.artifex.mupdflib.MuPDFActivity$25 */
    /* loaded from: classes.dex */
    public /* synthetic */ class C078725 {
        static final /* synthetic */ int[] $SwitchMap$com$artifex$mupdflib$MuPDFAlert$ButtonGroupType = new int[MuPDFAlert.ButtonGroupType.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$artifex$mupdflib$MuPDFAlert$IconType;

        static {
            try {
                $SwitchMap$com$artifex$mupdflib$MuPDFAlert$ButtonGroupType[MuPDFAlert.ButtonGroupType.OkCancel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$artifex$mupdflib$MuPDFAlert$ButtonGroupType[MuPDFAlert.ButtonGroupType.Ok.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$artifex$mupdflib$MuPDFAlert$ButtonGroupType[MuPDFAlert.ButtonGroupType.YesNoCancel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$artifex$mupdflib$MuPDFAlert$ButtonGroupType[MuPDFAlert.ButtonGroupType.YesNo.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $SwitchMap$com$artifex$mupdflib$MuPDFAlert$IconType = new int[MuPDFAlert.IconType.values().length];
            try {
                $SwitchMap$com$artifex$mupdflib$MuPDFAlert$IconType[MuPDFAlert.IconType.Error.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$artifex$mupdflib$MuPDFAlert$IconType[MuPDFAlert.IconType.Warning.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$artifex$mupdflib$MuPDFAlert$IconType[MuPDFAlert.IconType.Question.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$artifex$mupdflib$MuPDFAlert$IconType[MuPDFAlert.IconType.Status.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public void destroyAlertWaiter() {
        this.mAlertsActive = false;
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.cancel();
            this.mAlertDialog = null;
        }
        AsyncTask<Void, Void, MuPDFAlert> asyncTask = this.mAlertTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.mAlertTask = null;
        }
    }

    private MuPDFCore openFile(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        this.mFileName = new String(lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1));
        System.out.println("Trying to open ".concat(String.valueOf(str)));
        try {
            this.core = new MuPDFCore(this, str);
            PDFPreviewGridActivityData.set(null);
            return this.core;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } catch (OutOfMemoryError e2) {
            System.out.println(e2);
            return null;
        }
    }

    private MuPDFCore openBuffer(byte[] bArr, String str) {
        System.out.println("Trying to open byte buffer");
        try {
            this.core = new MuPDFCore(this, bArr, str);
            PDFPreviewGridActivityData.set(null);
            return this.core;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } catch (OutOfMemoryError e2) {
            System.out.println(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentlyViewedPreview() {
        int displayedViewIndex = this.mDocView.getDisplayedViewIndex();
        if (this.core.getDisplayPages() == 2) {
            displayedViewIndex = (displayedViewIndex * 2) - 1;
        }
        this.pdfPreviewPagerAdapter.setCurrentlyViewing(displayedViewIndex);
        Toast.makeText(getContext(), "Result :: ".concat(String.valueOf(displayedViewIndex + 1)), 1).show();
    }

    public void centerPreviewAtPosition(int i) {
        if (this.mPreview.getChildCount() > 0) {
            int measuredWidth = this.mPreview.getChildAt(0).getMeasuredWidth();
            if (measuredWidth > 0) {
                if (this.core.getDisplayPages() == 2) {
                    TwoWayView twoWayView = this.mPreview;
                    twoWayView.setSelectionFromOffset(i, (twoWayView.getWidth() / 2) - measuredWidth);
                    return;
                }
                TwoWayView twoWayView2 = this.mPreview;
                twoWayView2.setSelectionFromOffset(i, (twoWayView2.getWidth() / 2) - (measuredWidth / 2));
                return;
            }
            Log.e("centerOnPosition", "childmeasuredwidth = 0");
            return;
        }
        Log.e("centerOnPosition", "childcount = 0");
    }

    public boolean isProofing() {
        return this.core.fileFormat().equals("GPROOF");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b1  */
    @Override // android.app.Activity
    @android.annotation.SuppressLint({"StringFormatMatches", "NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r14) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.artifex.mupdflib.MuPDFActivity.onCreate(android.os.Bundle):void");
    }

    public void createUI(Bundle bundle) {
        MuPDFReaderView muPDFReaderView;
        if (this.core == null) {
            return;
        }
        this.mDocView = new MuPDFReaderView(getContext(), null) { // from class: com.artifex.mupdflib.MuPDFActivity.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.artifex.mupdflib.MuPDFReaderView, com.artifex.mupdflib.ReaderView
            public void onMoveToChild(int i) {
                MuPDFActivity.this.updatePageNumView(i);
                super.onMoveToChild(i);
                MuPDFActivity.this.setCurrentlyViewedPreview();
            }

            @Override // com.artifex.mupdflib.MuPDFReaderView
            protected void onTapMainDocArea() {
                if (!MuPDFActivity.this.mButtonsVisible) {
                    MuPDFActivity.this.showButtons();
                } else if (MuPDFActivity.this.mTopBarMode == TopBarMode.Main) {
                    MuPDFActivity.this.hideButtons();
                }
            }

            @Override // com.artifex.mupdflib.MuPDFReaderView
            protected void onDocMotion() {
                MuPDFActivity.this.hideButtons();
            }

            @Override // com.artifex.mupdflib.MuPDFReaderView
            protected void onHit(Hit hit) {
                MuPDFView muPDFView = (MuPDFView) MuPDFActivity.this.mDocView.getDisplayedView();
                if (muPDFView != null) {
                    muPDFView.deselectAnnotation();
                }
            }
        };
        this.mDocView.setAdapter(new MuPDFPageAdapter(this, this, this.core));
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("idleenabled", false);
        boolean booleanExtra2 = intent.getBooleanExtra("linkhighlight", false);
        boolean booleanExtra3 = intent.getBooleanExtra("horizontalscrolling", true);
        this.mDocView.setKeepScreenOn(!booleanExtra);
        this.mDocView.setLinksHighlighted(booleanExtra2);
        this.mDocView.setScrollingDirectionHorizontal(booleanExtra3);
        this.mDocName = intent.getStringExtra("docname");
        this.mSearchTask = new SearchTask(this, this.core, null) { // from class: com.artifex.mupdflib.MuPDFActivity.5
            @Override // com.artifex.mupdflib.SearchTask
            protected void onTextFound(SearchTaskResult searchTaskResult) {
                SearchTaskResult.set(searchTaskResult);
                MuPDFActivity.this.mDocView.setDisplayedViewIndex(searchTaskResult.pageNumber);
                MuPDFActivity.this.mDocView.resetupChildren();
            }
        };
        makeButtonsView();
        this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MuPDFActivity.this.searchModeOn();
            }
        });
        this.mSearchBack.setEnabled(false);
        this.mSearchFwd.setEnabled(false);
        this.mSearchBack.setColorFilter(Color.argb(255, 128, 128, 128));
        this.mSearchFwd.setColorFilter(Color.argb(255, 128, 128, 128));
        this.mSearchText.addTextChangedListener(new TextWatcher() { // from class: com.artifex.mupdflib.MuPDFActivity.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = editable.toString().length() > 0;
                MuPDFActivity muPDFActivity = MuPDFActivity.this;
                muPDFActivity.setButtonEnabled(muPDFActivity.mSearchBack, z);
                MuPDFActivity muPDFActivity2 = MuPDFActivity.this;
                muPDFActivity2.setButtonEnabled(muPDFActivity2.mSearchFwd, z);
                if (SearchTaskResult.get() == null || MuPDFActivity.this.mSearchText.getText().toString().equals(SearchTaskResult.get().txt)) {
                    return;
                }
                SearchTaskResult.set(null);
                MuPDFActivity.this.mDocView.resetupChildren();
            }
        });
        this.mSearchText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.artifex.mupdflib.MuPDFActivity.8
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    MuPDFActivity.this.search(1);
                    return false;
                }
                return false;
            }
        });
        this.mSearchText.setOnKeyListener(new View.OnKeyListener() { // from class: com.artifex.mupdflib.MuPDFActivity.9
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 66) {
                    MuPDFActivity.this.search(1);
                    return false;
                }
                return false;
            }
        });
        this.mSearchBack.setOnClickListener(new View.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MuPDFActivity.this.search(-1);
            }
        });
        this.mSearchFwd.setOnClickListener(new View.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MuPDFActivity.this.search(1);
            }
        });
        SharedPreferences preferences = getPreferences(0);
        int i = preferences.getInt("orientation", this.mOrientation);
        int i2 = preferences.getInt(com.itextpdf.text.Annotation.PAGE + this.mFileName, 0);
        if (i == this.mOrientation) {
            muPDFReaderView = this.mDocView;
        } else if (i == 1) {
            muPDFReaderView = this.mDocView;
            i2 = (i2 + 1) / 2;
        } else {
            muPDFReaderView = this.mDocView;
            i2 = i2 == 0 ? 0 : (i2 * 2) - 1;
        }
        muPDFReaderView.setDisplayedViewIndex(i2);
        if (bundle != null && bundle.getBoolean("SearchMode", false)) {
            searchModeOn();
        }
        if (bundle == null || !bundle.getBoolean("ButtonsHidden", false)) {
            this.mPreview.postDelayed(new Runnable() { // from class: com.artifex.mupdflib.MuPDFActivity.12
                @Override // java.lang.Runnable
                public void run() {
                    MuPDFActivity.this.runOnUiThread(new Runnable() { // from class: com.artifex.mupdflib.MuPDFActivity.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MuPDFActivity.this.showButtons();
                        }
                    });
                }
            }, 250L);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.addView(this.mDocView);
        relativeLayout.addView(this.mButtonsView);
        setContentView(relativeLayout);
        if (isProofing()) {
            this.mDocView.setDisplayedViewIndex(getIntent().getIntExtra("startingPage", 0));
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == 0) {
                    showInfo(getString(C0835R.string.print_failed));
                    break;
                }
                break;
            case 2:
                FilePicker filePicker = this.mFilePicker;
                if (filePicker != null && i2 == -1) {
                    filePicker.onPick(intent.getData());
                    break;
                }
                break;
            case 3:
                if (i2 >= 0) {
                    this.mDocView.setDisplayedViewIndex(this.core.getDisplayPages() == 2 ? (i2 + 1) / 2 : i2);
                    setCurrentlyViewedPreview();
                    break;
                }
                break;
            case 4:
                String str = this.mProofFile;
                if (str != null) {
                    this.core.endProof(str);
                    this.mProofFile = null;
                }
                this.mTopBarMode = TopBarMode.Main;
                this.mTopBarSwitcher.setDisplayedChild(this.mTopBarMode.ordinal());
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        MuPDFCore muPDFCore = this.core;
        this.core = null;
        return muPDFCore;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String str = this.mFileName;
        if (str != null && this.mDocView != null) {
            bundle.putString("FileName", str);
            SharedPreferences.Editor edit = getPreferences(0).edit();
            edit.putInt(com.itextpdf.text.Annotation.PAGE + this.mFileName, this.mDocView.getDisplayedViewIndex());
            edit.putInt("orientation", this.mOrientation);
            edit.commit();
        }
        if (!this.mButtonsVisible) {
            bundle.putBoolean("ButtonsHidden", true);
        }
        if (this.mTopBarMode == TopBarMode.Search) {
            bundle.putBoolean("SearchMode", true);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        SearchTask searchTask = this.mSearchTask;
        if (searchTask != null) {
            searchTask.stop();
        }
        if (this.mFileName == null || this.mDocView == null) {
            return;
        }
        SharedPreferences.Editor edit = getPreferences(0).edit();
        edit.putInt(com.itextpdf.text.Annotation.PAGE + this.mFileName, this.mDocView.getDisplayedViewIndex());
        edit.putInt("orientation", this.mOrientation);
        edit.commit();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        MuPDFReaderView muPDFReaderView = this.mDocView;
        if (muPDFReaderView != null) {
            muPDFReaderView.applyToChildren(new ReaderView.ViewMapper() { // from class: com.artifex.mupdflib.MuPDFActivity.13
                @Override // com.artifex.mupdflib.ReaderView.ViewMapper
                public void applyToView(View view) {
                    ((MuPDFView) view).releaseBitmaps();
                }
            });
        }
        MuPDFCore muPDFCore = this.core;
        if (muPDFCore != null) {
            muPDFCore.onDestroy();
        }
        AsyncTask<Void, Void, MuPDFAlert> asyncTask = this.mAlertTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.mAlertTask = null;
        }
        this.core = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setButtonEnabled(ImageButton imageButton, boolean z) {
        int argb;
        imageButton.setEnabled(z);
        if (z) {
            argb = Color.argb(0, 255, 255, 255);
        } else {
            argb = Color.argb(255, 128, 128, 128);
        }
        imageButton.setColorFilter(argb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showButtons() {
        if (this.core == null || this.mButtonsVisible) {
            return;
        }
        this.mButtonsVisible = true;
        updatePageNumView(this.mDocView.getDisplayedViewIndex());
        if (this.mTopBarMode == TopBarMode.Search) {
            this.mSearchText.requestFocus();
            showKeyboard();
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, -this.mTopBarSwitcher.getHeight(), ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.artifex.mupdflib.MuPDFActivity.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                MuPDFActivity.this.mTopBarSwitcher.setVisibility(0);
            }
        });
        this.mTopBarSwitcher.startAnimation(translateAnimation);
        setCurrentlyViewedPreview();
        TranslateAnimation translateAnimation2 = new TranslateAnimation(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.mPreviewBarHolder.getHeight(), ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        translateAnimation2.setDuration(200L);
        translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.artifex.mupdflib.MuPDFActivity.15
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                MuPDFActivity.this.mPreviewBarHolder.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MuPDFActivity.this.mPageNumberView.setVisibility(0);
            }
        });
        this.mPreviewBarHolder.startAnimation(translateAnimation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideButtons() {
        if (this.mButtonsVisible) {
            this.mButtonsVisible = false;
            hideKeyboard();
            TranslateAnimation translateAnimation = new TranslateAnimation(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, -this.mTopBarSwitcher.getHeight());
            translateAnimation.setDuration(200L);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.artifex.mupdflib.MuPDFActivity.16
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MuPDFActivity.this.mTopBarSwitcher.setVisibility(4);
                }
            });
            this.mTopBarSwitcher.startAnimation(translateAnimation);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.mPreviewBarHolder.getHeight());
            translateAnimation2.setDuration(200L);
            translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.artifex.mupdflib.MuPDFActivity.17
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MuPDFActivity.this.mPageNumberView.setVisibility(4);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MuPDFActivity.this.mPreviewBarHolder.setVisibility(4);
                }
            });
            this.mPreviewBarHolder.startAnimation(translateAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchModeOn() {
        if (this.mTopBarMode != TopBarMode.Search) {
            this.mTopBarMode = TopBarMode.Search;
            this.mSearchText.requestFocus();
            showKeyboard();
            this.mTopBarSwitcher.setDisplayedChild(this.mTopBarMode.ordinal());
        }
    }

    private void searchModeOff() {
        if (this.mTopBarMode == TopBarMode.Search) {
            this.mTopBarMode = TopBarMode.Main;
            hideKeyboard();
            this.mTopBarSwitcher.setDisplayedChild(this.mTopBarMode.ordinal());
            SearchTaskResult.set(null);
            this.mDocView.resetupChildren();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public void updatePageNumView(int i) {
        String format;
        MuPDFCore muPDFCore = this.core;
        if (muPDFCore == null) {
            return;
        }
        if (muPDFCore.getDisplayPages() == 2 && i != 0 && i != this.core.countPages() - 1) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            format = String.format("%1$d-%2$d", Integer.valueOf(i2), Integer.valueOf(i3));
            this.mPageNumberView.setText(String.format(getString(C0835R.string.two_pages_of_count), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.core.countSinglePages())));
        } else if (this.core.getDisplayPages() == 2 && i == 0) {
            int i4 = i + 1;
            format = String.format("%1$d", Integer.valueOf(i4));
            this.mPageNumberView.setText(String.format(getString(C0835R.string.one_page_of_count), Integer.valueOf(i4), Integer.valueOf(this.core.countSinglePages())));
        } else if (this.core.getDisplayPages() == 2 && i == this.core.countPages() - 1) {
            int i5 = i * 2;
            format = String.format("%1$d", Integer.valueOf(i5));
            this.mPageNumberView.setText(String.format(getString(C0835R.string.one_page_of_count), Integer.valueOf(i5), Integer.valueOf(this.core.countSinglePages())));
        } else {
            int i6 = i + 1;
            format = String.format("%1$d", Integer.valueOf(i6));
            this.mPageNumberView.setText(String.format(getString(C0835R.string.one_page_of_count), Integer.valueOf(i6), Integer.valueOf(this.core.countPages())));
        }
        CallbackApplication.MuPDFCallbackClass.sendGaiView(String.format("documentView (%1$s), page (%2$s)", this.mDocName, format));
    }

    private void printDoc() {
        if (!this.core.fileFormat().startsWith(PdfObject.TEXT_PDFDOCENCODING)) {
            showInfo(getString(C0835R.string.format_currently_not_supported));
            return;
        }
        Intent intent = getIntent();
        Uri data = intent != null ? intent.getData() : null;
        if (data == null) {
            showInfo(getString(C0835R.string.print_failed));
        }
        if (data.getScheme() == null) {
            data = Uri.parse("file://" + data.toString());
        }
        Intent intent2 = new Intent(this, PrintDialogActivity.class);
        intent2.setDataAndType(data, "aplication/pdf");
        intent2.putExtra("title", this.mFileName);
        startActivityForResult(intent2, 1);
    }

    private void showInfo(String str) {
        this.mInfoView.setText(str);
        if (Build.VERSION.SDK_INT >= 11) {
            new SafeAnimatorInflater(this, C0835R.anim.info, this.mInfoView);
            return;
        }
        this.mInfoView.setVisibility(0);
        this.mHandler.postDelayed(new Runnable() { // from class: com.artifex.mupdflib.MuPDFActivity.18
            @Override // java.lang.Runnable
            public void run() {
                MuPDFActivity.this.mInfoView.setVisibility(4);
            }
        }, 500L);
    }

    private void makeButtonsView() {
        this.mButtonsView = getLayoutInflater().inflate(C0835R.layout.buttons, (ViewGroup) null);
        this.mPreviewBarHolder = (FrameLayout) this.mButtonsView.findViewById(C0835R.C0836id.PreviewBarHolder);
        this.mPreview = new TwoWayView(this);
        this.mPreview.setOrientation(TwoWayView.Orientation.HORIZONTAL);
        this.mPreview.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.pdfPreviewPagerAdapter = new ToolbarPreviewAdapter(this, this.core);
        this.mPreview.setAdapter((ListAdapter) this.pdfPreviewPagerAdapter);
        this.mPreview.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.artifex.mupdflib.MuPDFActivity.19
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                MuPDFActivity.this.hideButtons();
                MuPDFActivity.this.mDocView.setDisplayedViewIndex((int) j);
            }
        });
        this.mPreviewBarHolder.addView(this.mPreview);
        this.mPageNumberView = (TextView) this.mButtonsView.findViewById(C0835R.C0836id.pageNumber);
        this.mInfoView = (TextView) this.mButtonsView.findViewById(C0835R.C0836id.info);
        this.mSearchButton = (ImageButton) this.mButtonsView.findViewById(C0835R.C0836id.searchButton);
        this.mTopBarSwitcher = (ViewAnimator) this.mButtonsView.findViewById(C0835R.C0836id.switcher);
        this.mSearchBack = (ImageButton) this.mButtonsView.findViewById(C0835R.C0836id.searchBack);
        this.mSearchFwd = (ImageButton) this.mButtonsView.findViewById(C0835R.C0836id.searchForward);
        this.mSearchText = (EditText) this.mButtonsView.findViewById(C0835R.C0836id.searchText);
        this.mTopBarSwitcher.setVisibility(4);
        this.mPageNumberView.setVisibility(4);
        this.mInfoView.setVisibility(4);
        this.mPreviewBarHolder.setVisibility(4);
    }

    public void OnMoreButtonClick(View view) {
        if (this.core != null) {
            int displayedViewIndex = this.mDocView.getDisplayedViewIndex();
            if (this.core.getDisplayPages() == 2) {
                displayedViewIndex = (displayedViewIndex * 2) - 1;
            }
            PDFPreviewGridActivityData.get().core = this.core;
            PDFPreviewGridActivityData.get().position = displayedViewIndex;
            startActivityForResult(new Intent(this, PDFPreviewGridActivity.class), 3);
            CallbackApplication.MuPDFCallbackClass.sendGaiView(String.format("documentThumbView (%1$s)", this.mDocName));
        }
    }

    public void OnCancelMoreButtonClick(View view) {
        this.mTopBarMode = TopBarMode.Main;
        this.mTopBarSwitcher.setDisplayedChild(this.mTopBarMode.ordinal());
    }

    public void OnPrintButtonClick(View view) {
        printDoc();
    }

    public void proofWithResolution(int i) {
        this.mProofFile = this.core.startProof(i);
        Uri parse = Uri.parse("file://" + this.mProofFile);
        Intent intent = new Intent(this, MuPDFActivity.class);
        intent.setAction("android.intent.action.VIEW");
        intent.setData(parse);
        intent.putExtra("startingPage", this.mDocView.getDisplayedViewIndex());
        startActivityForResult(intent, 4);
    }

    @TargetApi(14)
    public void OnProofButtonClick(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenu().add(0, 1, 0, "Select a resolution:");
        popupMenu.getMenu().add(0, 72, 0, DiagnoseConstants.FEEDBACK_DIAG_CALL_SERVICE_ALGORITHM_BASE);
        popupMenu.getMenu().add(0, 96, 0, "96");
        popupMenu.getMenu().add(0, 150, 0, DiagnoseConstants.UI_TYPE_DIALOG_EXIT);
        popupMenu.getMenu().add(0, 300, 0, "300");
        popupMenu.getMenu().add(0, 600, 0, DiagnoseConstants.UI_TYPE_ACTIVE_TEST);
        popupMenu.getMenu().add(0, 1200, 0, DiagnoseConstants.UI_TYPE_COMBINE_MENU);
        popupMenu.getMenu().add(0, 2400, 0, DiagnoseConstants.UI_TYPE_DIAG_CALL_SERVICE);
        MenuItem item = popupMenu.getMenu().getItem(0);
        item.setShowAsAction(8);
        item.setActionView(new View(view.getContext()));
        item.setOnActionExpandListener(new MenuItem.OnActionExpandListener() { // from class: com.artifex.mupdflib.MuPDFActivity.20
            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return false;
            }

            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return false;
            }
        });
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.artifex.mupdflib.MuPDFActivity.21
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId != 1) {
                    MuPDFActivity.this.proofWithResolution(itemId);
                    return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
        r7.setAccessible(true);
        r4 = r7.get(r1);
        java.lang.Class.forName(r4.getClass().getName()).getMethod("setForceShowIcon", java.lang.Boolean.TYPE).invoke(r4, java.lang.Boolean.TRUE);
     */
    @android.annotation.TargetApi(14)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void OnSepsButtonClick(final android.view.View r12) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.artifex.mupdflib.MuPDFActivity.OnSepsButtonClick(android.view.View):void");
    }

    public void OnCloseReaderButtonClick(View view) {
        finish();
    }

    public void OnCancelSearchButtonClick(View view) {
        searchModeOff();
    }

    private void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.mSearchText, 0);
        }
    }

    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mSearchText.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void search(int i) {
        hideKeyboard();
        int displayedViewIndex = this.mDocView.getDisplayedViewIndex();
        SearchTaskResult searchTaskResult = SearchTaskResult.get();
        this.mSearchTask.m12507go(this.mSearchText.getText().toString(), i, displayedViewIndex, searchTaskResult != null ? searchTaskResult.pageNumber : -1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        if (this.mButtonsVisible && this.mTopBarMode == TopBarMode.Search) {
            hideButtons();
        } else {
            showButtons();
            searchModeOn();
        }
        return super.onSearchRequested();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.mButtonsVisible && this.mTopBarMode != TopBarMode.Search) {
            hideButtons();
        } else {
            showButtons();
            searchModeOff();
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    protected void onStart() {
        MuPDFCore muPDFCore = this.core;
        if (muPDFCore != null) {
            muPDFCore.startAlerts();
            createAlertWaiter();
        }
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        if (this.core != null) {
            destroyAlertWaiter();
            this.core.stopAlerts();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        MuPDFCore muPDFCore = this.core;
        if (muPDFCore != null && muPDFCore.hasChanges()) {
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.artifex.mupdflib.MuPDFActivity.24
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i == -1) {
                        MuPDFActivity.this.core.save();
                    }
                    MuPDFActivity.this.finish();
                }
            };
            AlertDialog create = this.mAlertBuilder.create();
            create.setTitle("MuPDF");
            create.setMessage(getString(C0835R.string.document_has_changes_save_them_));
            create.setButton(-1, getString(C0835R.string.yes), onClickListener);
            create.setButton(-2, getString(C0835R.string.f3562no), onClickListener);
            create.show();
            return;
        }
        super.onBackPressed();
    }

    @Override // com.artifex.mupdflib.FilePicker.FilePickerSupport
    public void performPickFor(FilePicker filePicker) {
        this.mFilePicker = filePicker;
    }
}
