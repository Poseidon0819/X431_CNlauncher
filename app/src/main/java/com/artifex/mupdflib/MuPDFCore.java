package com.artifex.mupdflib;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.Log;
import com.artifex.mupdflib.Annotation;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfObject;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MuPDFCore {
    private static boolean gs_so_available = false;
    private static boolean is_load_so_fail = false;
    private int displayPages;
    private byte[] fileBuffer;
    private String file_format;
    private long globals;
    private boolean isSetScaled;
    private boolean isUnencryptedPDF;
    private String mFileName;
    private int numPages;
    private float pageHeight;
    private float pageWidth;

    /* loaded from: classes.dex */
    public interface Callback {
        void changePage();
    }

    /* loaded from: classes.dex */
    public enum WidgetType {
        NONE,
        TEXT,
        LISTBOX,
        COMBOBOX,
        SIGNATURE
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void abortCookie(long j);

    private native void addInkAnnotationInternal(PointF[][] pointFArr);

    private native void addMarkupAnnotationInternal(PointF[] pointFArr, int i);

    private native boolean authenticatePasswordInternal(String str);

    private native String checkFocusedSignatureInternal();

    private native int controlSepOnPageInternal(int i, int i2, boolean z);

    private native int countPagesInternal();

    /* JADX INFO: Access modifiers changed from: private */
    public native long createCookie();

    private native void deleteAnnotationInternal(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void destroyCookie(long j);

    private native void destroying();

    private native void drawPage(Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6, long j);

    private native void endProofInternal(String str);

    private native String fileFormatInternal();

    private native Annotation[] getAnnotationsInternal(int i);

    private native String[] getFocusedWidgetChoiceOptions();

    private native String[] getFocusedWidgetChoiceSelected();

    private native int getFocusedWidgetSignatureState();

    private native String getFocusedWidgetTextInternal();

    private native int getFocusedWidgetTypeInternal();

    private native int getNumSepsOnPageInternal(int i);

    private native OutlineItem[] getOutlineInternal();

    private native float getPageHeight();

    private native LinkInfo[] getPageLinksInternal(int i);

    private native float getPageWidth();

    private native Separation getSepInternal(int i, int i2);

    private native RectF[] getWidgetAreasInternal(int i);

    private native void gotoPageInternal(int i);

    private static native boolean gprfSupportedInternal();

    private native boolean hasChangesInternal();

    private native boolean hasOutlineInternal();

    private native boolean isUnencryptedPDFInternal();

    private native boolean needsPasswordInternal();

    private native long openBuffer();

    private native long openBuffer(String str);

    private native long openFile(String str);

    private native int passClickEventInternal(int i, float f, float f2);

    private native void replyToAlertInternal(MuPDFAlertInternal muPDFAlertInternal);

    private native void saveInternal();

    private native RectF[] searchPage(String str);

    private native void setFocusedWidgetChoiceSelectedInternal(String[] strArr);

    private native int setFocusedWidgetTextInternal(String str);

    private native boolean signFocusedSignatureInternal(String str, String str2);

    private native void startAlertsInternal();

    private native String startProofInternal(int i);

    private native void stopAlertsInternal();

    private native TextChar[][][][] text();

    private native byte[] textAsHtml();

    private native void updatePageInternal(Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j);

    private native MuPDFAlertInternal waitForAlertInternal();

    public native boolean javascriptSupported();

    static {
        try {
            System.loadLibrary("mupdf");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            is_load_so_fail = true;
        }
    }

    public static boolean is_load_so_fail() {
        return is_load_so_fail;
    }

    public boolean isSetScaled() {
        return this.isSetScaled;
    }

    public void setSetScaled(boolean z) {
        this.isSetScaled = z;
    }

    /* loaded from: classes.dex */
    public class Cookie {
        private final long cookiePtr;

        public Cookie() {
            this.cookiePtr = MuPDFCore.this.createCookie();
        }

        public void abort() {
            MuPDFCore.this.abortCookie(this.cookiePtr);
        }

        public void destroy() {
            MuPDFCore.this.destroyCookie(this.cookiePtr);
        }
    }

    public MuPDFCore(Context context, String str) throws Exception {
        this.numPages = -1;
        this.displayPages = 1;
        this.mFileName = str;
        if (is_load_so_fail) {
            return;
        }
        this.globals = openFile(str);
        if (this.globals == 0) {
            throw new Exception(String.format(context.getString(C0835R.string.cannot_open_file_Path), str));
        }
        this.file_format = fileFormatInternal();
        this.isUnencryptedPDF = isUnencryptedPDFInternal();
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getFileDirectory() {
        return new File(getFileName()).getParent();
    }

    public MuPDFCore(Context context, byte[] bArr, String str) throws Exception {
        this.numPages = -1;
        this.displayPages = 1;
        this.fileBuffer = bArr;
        this.globals = openBuffer(str == null ? "" : str);
        if (this.globals == 0) {
            throw new Exception(context.getString(C0835R.string.cannot_open_buffer));
        }
        this.file_format = fileFormatInternal();
        this.isUnencryptedPDF = isUnencryptedPDFInternal();
    }

    public MuPDFCore(Context context, byte[] bArr) throws Exception {
        this.numPages = -1;
        this.displayPages = 1;
        this.fileBuffer = bArr;
        this.globals = openBuffer();
        if (this.globals == 0) {
            throw new Exception(context.getString(C0835R.string.cannot_open_buffer));
        }
        this.file_format = fileFormatInternal();
    }

    public int countPages() {
        if (this.numPages < 0) {
            this.numPages = countPagesSynchronized();
        }
        if (this.displayPages == 1) {
            return this.numPages;
        }
        int i = this.numPages;
        if (i % 2 == 0) {
            return (i / 2) + 1;
        }
        return (i / 2) + 1;
    }

    public String fileFormat() {
        return this.file_format;
    }

    public boolean isUnencryptedPDF() {
        return this.isUnencryptedPDF;
    }

    private synchronized int countPagesSynchronized() {
        return countPagesInternal();
    }

    private void gotoPage(int i) {
        int i2 = this.numPages;
        if (i > i2 - 1) {
            i = i2 - 1;
        } else if (i < 0) {
            i = 0;
        }
        gotoPageInternal(i);
        this.pageWidth = getPageWidth();
        this.pageHeight = getPageHeight();
    }

    public synchronized PointF getPageSize(int i) {
        if (this.displayPages == 1) {
            gotoPage(i);
            return new PointF(this.pageWidth, this.pageHeight);
        }
        gotoPage(i);
        if (i != this.numPages - 1 && i != 0) {
            float f = this.pageWidth;
            float f2 = this.pageHeight;
            gotoPage(i + 1);
            return new PointF(f + this.pageWidth, Math.max(f2, this.pageHeight));
        }
        return new PointF(this.pageWidth * 2.0f, this.pageHeight);
    }

    public float getPageWidthByStart() {
        return getPageWidth();
    }

    public float getPageHeightByStart() {
        return getPageHeight();
    }

    public MuPDFAlert waitForAlert() {
        MuPDFAlertInternal waitForAlertInternal = waitForAlertInternal();
        if (waitForAlertInternal != null) {
            return waitForAlertInternal.toAlert();
        }
        return null;
    }

    public void replyToAlert(MuPDFAlert muPDFAlert) {
        replyToAlertInternal(new MuPDFAlertInternal(muPDFAlert));
    }

    public void stopAlerts() {
        stopAlertsInternal();
    }

    public void startAlerts() {
        startAlertsInternal();
    }

    public synchronized void onDestroy() {
        if (!is_load_so_fail) {
            destroying();
        }
        this.globals = 0L;
    }

    public synchronized PointF getSinglePageSize(int i) {
        gotoPage(i);
        return new PointF(this.pageWidth, this.pageHeight);
    }

    public synchronized void drawPageSynchrinized(int i, Bitmap bitmap, int i2, int i3, int i4, int i5, int i6, int i7) {
        gotoPage(i);
        drawPage(bitmap, i2, i3, i4, i5, i6, i7, 0L);
    }

    public synchronized void drawSinglePage(int i, Bitmap bitmap, int i2, int i3) {
        drawPageSynchrinized(i, bitmap, i2, i3, 0, 0, i2, i3);
    }

    public synchronized void drawPage(Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6, int i7, Cookie cookie) {
        Canvas canvas;
        int i8;
        int i9;
        int i10;
        float f;
        int i11;
        try {
            canvas = new Canvas(bitmap);
        } catch (Exception unused) {
            canvas = null;
        }
        try {
            canvas.drawColor(0);
            if (this.displayPages == 1) {
                gotoPage(i);
                drawPage(bitmap, i2, i3, i4, i5, i6, i7, cookie.cookiePtr);
                return;
            }
            int i12 = i == 0 ? 0 : (i * 2) - 1;
            int i13 = i2 / 2;
            int i14 = i2 - i13;
            int min = Math.min(i13, i13 - i4);
            int i15 = min < 0 ? 0 : min;
            int i16 = i6 - i15;
            Paint paint = new Paint(2);
            if (i12 == this.numPages - 1) {
                canvas.drawColor(-16777216);
                if (i15 > 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(i15, i7, Bitmap.Config.ARGB_8888);
                    gotoPage(i12);
                    drawPage(createBitmap, i13, i3, i15 == 0 ? i4 - i13 : 0, i5, i15, i7, cookie.cookiePtr);
                    canvas.drawBitmap(createBitmap, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, paint);
                    createBitmap.recycle();
                }
            } else if (i12 == 0) {
                canvas.drawColor(-16777216);
                if (i16 > 0) {
                    Bitmap createBitmap2 = Bitmap.createBitmap(i16, i7, Bitmap.Config.ARGB_8888);
                    gotoPage(i12);
                    drawPage(createBitmap2, i14, i3, i15 == 0 ? i4 - i13 : 0, i5, i16, i7, cookie.cookiePtr);
                    canvas.drawBitmap(createBitmap2, i15, ColumnText.GLOBAL_SPACE_CHAR_RATIO, paint);
                    createBitmap2.recycle();
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(bitmap.getWidth());
                Log.d("draw bitmap width", sb.toString());
                if (i15 > 0) {
                    Bitmap createBitmap3 = Bitmap.createBitmap(i15, i7, Bitmap.Config.ARGB_8888);
                    gotoPage(i12);
                    long j = cookie.cookiePtr;
                    i8 = i12;
                    f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    i9 = i13;
                    i10 = i15;
                    drawPage(createBitmap3, i13, i3, i4, i5, i15, i7, j);
                    canvas.drawBitmap(createBitmap3, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, paint);
                    createBitmap3.recycle();
                    i11 = i16;
                } else {
                    i8 = i12;
                    i9 = i13;
                    i10 = i15;
                    f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    i11 = i16;
                }
                if (i11 > 0) {
                    Bitmap createBitmap4 = Bitmap.createBitmap(i11, i7, Bitmap.Config.ARGB_8888);
                    gotoPage(i8 + 1);
                    int i17 = i10;
                    drawPage(createBitmap4, i14, i3, i17 == 0 ? i4 - i9 : 0, i5, i11, i7, cookie.cookiePtr);
                    canvas.drawBitmap(createBitmap4, i17, f, paint);
                    createBitmap4.recycle();
                }
            }
        } catch (Exception unused2) {
            if (canvas != null) {
                canvas.drawColor(0);
            }
        }
    }

    public synchronized void updatePage(Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6, int i7, Cookie cookie) {
        Canvas canvas;
        int i8;
        int i9;
        int i10;
        int i11;
        try {
            canvas = new Canvas(bitmap);
            try {
                canvas.drawColor(0);
                if (this.displayPages == 1) {
                    updatePageInternal(bitmap, i, i2, i3, i4, i5, i6, i7, cookie.cookiePtr);
                    return;
                }
                int i12 = i == 0 ? 0 : (i * 2) - 1;
                int i13 = i2 / 2;
                int i14 = i2 - i13;
                int min = Math.min(i13, i13 - i4);
                int i15 = min < 0 ? 0 : min;
                int i16 = i6 - i15;
                Paint paint = new Paint(2);
                if (i12 == this.numPages - 1) {
                    if (i15 > 0) {
                        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, i15, i7);
                        updatePageInternal(createBitmap, i12, i13, i3, i15 == 0 ? i4 - i13 : 0, i5, i15, i7, cookie.cookiePtr);
                        canvas.drawBitmap(createBitmap, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, paint);
                        createBitmap.recycle();
                    }
                } else if (i12 != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(bitmap.getWidth());
                    Log.d("update bitmap width", sb.toString());
                    if (i15 > 0) {
                        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, i15 < bitmap.getWidth() ? i15 : bitmap.getWidth(), i7);
                        i8 = i16;
                        i9 = i15;
                        i10 = i13;
                        i11 = i12;
                        updatePageInternal(createBitmap2, i12, i13, i3, i4, i5, i15, i7, cookie.cookiePtr);
                        canvas.drawBitmap(createBitmap2, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, paint);
                        createBitmap2.recycle();
                    } else {
                        i8 = i16;
                        i9 = i15;
                        i10 = i13;
                        i11 = i12;
                    }
                    if (i8 > 0) {
                        int i17 = i8;
                        int i18 = i9;
                        Bitmap createBitmap3 = Bitmap.createBitmap(bitmap, i18, 0, i17, i7);
                        updatePageInternal(createBitmap3, i11 + 1, i14, i3, i18 == 0 ? i4 - i10 : 0, i5, i17, i7, cookie.cookiePtr);
                        canvas.drawBitmap(createBitmap3, i18, ColumnText.GLOBAL_SPACE_CHAR_RATIO, paint);
                        createBitmap3.recycle();
                    }
                } else if (i16 > 0) {
                    Bitmap createBitmap4 = Bitmap.createBitmap(bitmap, i15, 0, i16, i7);
                    updatePageInternal(createBitmap4, i12, i14, i3, i15 == 0 ? i4 - i13 : 0, i5, i16, i7, cookie.cookiePtr);
                    canvas.drawBitmap(createBitmap4, i15, ColumnText.GLOBAL_SPACE_CHAR_RATIO, paint);
                    createBitmap4.recycle();
                }
            } catch (OutOfMemoryError unused) {
                if (canvas != null) {
                    canvas.drawColor(0);
                }
            }
        } catch (OutOfMemoryError unused2) {
            canvas = null;
        }
    }

    public synchronized PassClickResult passClickEvent(int i, float f, float f2) {
        boolean z = passClickEventInternal(i, f, f2) != 0;
        switch (WidgetType.values()[getFocusedWidgetTypeInternal()]) {
            case TEXT:
                return new PassClickResultText(z, getFocusedWidgetTextInternal());
            case LISTBOX:
            case COMBOBOX:
                return new PassClickResultChoice(z, getFocusedWidgetChoiceOptions(), getFocusedWidgetChoiceSelected());
            case SIGNATURE:
                return new PassClickResultSignature(z, getFocusedWidgetSignatureState());
            default:
                return new PassClickResult(z);
        }
    }

    public synchronized boolean setFocusedWidgetText(int i, String str) {
        gotoPage(i);
        return setFocusedWidgetTextInternal(str) != 0;
    }

    public synchronized void setFocusedWidgetChoiceSelected(String[] strArr) {
        setFocusedWidgetChoiceSelectedInternal(strArr);
    }

    public synchronized String checkFocusedSignature() {
        return checkFocusedSignatureInternal();
    }

    public synchronized boolean signFocusedSignature(String str, String str2) {
        return signFocusedSignatureInternal(str, str2);
    }

    public synchronized LinkInfo[] getPageLinks(int i) {
        LinkInfo[] linkInfoArr;
        int i2;
        LinkInfo[] linkInfoArr2;
        if (this.displayPages == 1) {
            return getPageLinksInternal(i);
        }
        int i3 = 0;
        LinkInfo[] linkInfoArr3 = new LinkInfo[0];
        LinkInfo[] linkInfoArr4 = new LinkInfo[0];
        int i4 = i * 2;
        int i5 = i4 - 1;
        int countPages = countPages() * 2;
        if (i5 <= 0 || (linkInfoArr = getPageLinksInternal(i5)) == null) {
            linkInfoArr = linkInfoArr3;
            i2 = 0;
        } else {
            i2 = linkInfoArr.length + 0;
        }
        if (i4 >= countPages || (linkInfoArr2 = getPageLinksInternal(i4)) == null) {
            linkInfoArr2 = linkInfoArr4;
        } else {
            i2 += linkInfoArr2.length;
        }
        LinkInfo[] linkInfoArr5 = new LinkInfo[i2];
        for (int i6 = 0; i6 < linkInfoArr.length; i6++) {
            linkInfoArr5[i6] = linkInfoArr[i6];
        }
        int length = linkInfoArr.length;
        while (i3 < linkInfoArr2.length) {
            LinkInfo linkInfo = linkInfoArr2[i3];
            linkInfo.rect.left += this.pageWidth;
            linkInfo.rect.right += this.pageWidth;
            linkInfoArr5[length] = linkInfo;
            i3++;
            length++;
        }
        return linkInfoArr5;
    }

    public synchronized RectF[] getWidgetAreas(int i) {
        return getWidgetAreasInternal(i);
    }

    public synchronized Annotation[] getAnnoations(int i) {
        return getAnnotationsInternal(i);
    }

    public synchronized RectF[] searchPage(int i, String str) {
        gotoPage(i);
        return searchPage(str);
    }

    public synchronized byte[] html(int i) {
        gotoPage(i);
        return textAsHtml();
    }

    public synchronized TextWord[][] textLines(int i) {
        ArrayList arrayList;
        TextChar[][][][] textCharArr;
        int i2;
        gotoPage(i);
        TextChar[][][][] text = text();
        arrayList = new ArrayList();
        int length = text.length;
        int i3 = 0;
        while (i3 < length) {
            TextChar[][][] textCharArr2 = text[i3];
            if (textCharArr2 != null) {
                int length2 = textCharArr2.length;
                int i4 = 0;
                while (i4 < length2) {
                    TextChar[][] textCharArr3 = textCharArr2[i4];
                    ArrayList arrayList2 = new ArrayList();
                    TextWord textWord = new TextWord();
                    int length3 = textCharArr3.length;
                    TextWord textWord2 = textWord;
                    int i5 = 0;
                    while (i5 < length3) {
                        TextChar[] textCharArr4 = textCharArr3[i5];
                        int length4 = textCharArr4.length;
                        TextWord textWord3 = textWord2;
                        int i6 = 0;
                        while (i6 < length4) {
                            TextChar textChar = textCharArr4[i6];
                            TextChar[][][][] textCharArr5 = text;
                            int i7 = length;
                            if (textChar.f3563c != ' ') {
                                textWord3.Add(textChar);
                            } else if (textWord3.f3564w.length() > 0) {
                                arrayList2.add(textWord3);
                                textWord3 = new TextWord();
                            }
                            i6++;
                            text = textCharArr5;
                            length = i7;
                        }
                        i5++;
                        textWord2 = textWord3;
                    }
                    TextChar[][][][] textCharArr6 = text;
                    int i8 = length;
                    if (textWord2.f3564w.length() > 0) {
                        arrayList2.add(textWord2);
                    }
                    if (arrayList2.size() > 0) {
                        arrayList.add(arrayList2.toArray(new TextWord[arrayList2.size()]));
                    }
                    i4++;
                    text = textCharArr6;
                    length = i8;
                }
                textCharArr = text;
                i2 = length;
            } else {
                textCharArr = text;
                i2 = length;
            }
            i3++;
            text = textCharArr;
            length = i2;
        }
        return (TextWord[][]) arrayList.toArray(new TextWord[arrayList.size()]);
    }

    public synchronized void addMarkupAnnotation(int i, PointF[] pointFArr, Annotation.Type type) {
        gotoPage(i);
        addMarkupAnnotationInternal(pointFArr, type.ordinal());
    }

    public synchronized void addInkAnnotation(int i, PointF[][] pointFArr) {
        gotoPage(i);
        addInkAnnotationInternal(pointFArr);
    }

    public synchronized void deleteAnnotation(int i, int i2) {
        gotoPage(i);
        deleteAnnotationInternal(i2);
    }

    public synchronized boolean hasOutline() {
        return hasOutlineInternal();
    }

    public synchronized OutlineItem[] getOutline() {
        return getOutlineInternal();
    }

    public synchronized boolean needsPassword() {
        return needsPasswordInternal();
    }

    public synchronized boolean authenticatePassword(String str) {
        return authenticatePasswordInternal(str);
    }

    public synchronized boolean hasChanges() {
        return hasChangesInternal();
    }

    public synchronized void save() {
        saveInternal();
    }

    public synchronized String startProof(int i) {
        return startProofInternal(i);
    }

    public synchronized void endProof(String str) {
        endProofInternal(str);
    }

    public static boolean gprfSupported() {
        if (gs_so_available) {
            return gprfSupportedInternal();
        }
        return false;
    }

    public boolean canProof() {
        return fileFormat().contains(PdfObject.TEXT_PDFDOCENCODING);
    }

    public synchronized int getNumSepsOnPage(int i) {
        return getNumSepsOnPageInternal(i);
    }

    public synchronized int controlSepOnPage(int i, int i2, boolean z) {
        return controlSepOnPageInternal(i, i2, z);
    }

    public synchronized Separation getSep(int i, int i2) {
        return getSepInternal(i, i2);
    }

    public int getDisplayPages() {
        return this.displayPages;
    }

    public int countDisplays() {
        int countPages = countPages();
        if (countPages % 2 == 0) {
            return (countPages / 2) + 1;
        }
        return countPages / 2;
    }

    public void setDisplayPages(int i) throws IllegalStateException {
        if (i <= 0 || i > 2) {
            throw new IllegalStateException("MuPDFCore can only handle 1 or 2 pages per screen!");
        }
        this.displayPages = i;
    }

    public int countSinglePages() {
        return this.numPages;
    }

    public int[] getDisplayScreenWidthAndHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }
}
