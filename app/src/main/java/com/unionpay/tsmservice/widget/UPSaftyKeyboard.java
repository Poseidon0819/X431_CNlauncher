package com.unionpay.tsmservice.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.OnSafetyKeyboardCallback;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.data.NinePatchInfo;
import com.unionpay.tsmservice.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.result.GetEncryptDataResult;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class UPSaftyKeyboard {

    /* renamed from: A */
    private boolean f23700A;

    /* renamed from: B */
    private boolean f23701B;

    /* renamed from: C */
    private boolean f23702C;

    /* renamed from: D */
    private int f23703D;

    /* renamed from: E */
    private int f23704E;

    /* renamed from: F */
    private int f23705F;

    /* renamed from: G */
    private int f23706G;

    /* renamed from: H */
    private int f23707H;

    /* renamed from: I */
    private int f23708I;

    /* renamed from: J */
    private Typeface f23709J;

    /* renamed from: K */
    private boolean f23710K;

    /* renamed from: L */
    private OnShowListener f23711L;

    /* renamed from: M */
    private OnHideListener f23712M;

    /* renamed from: N */
    private OnEditorListener f23713N;

    /* renamed from: O */
    private OnSafetyKeyboardCallback.Stub f23714O;

    /* renamed from: P */
    private UPTsmAddon.UPTsmConnectionListener f23715P;

    /* renamed from: Q */
    private Handler.Callback f23716Q;

    /* renamed from: R */
    private final Handler f23717R;

    /* renamed from: a */
    private Context f23718a;

    /* renamed from: b */
    private UPTsmAddon f23719b;

    /* renamed from: c */
    private int f23720c;

    /* renamed from: d */
    private int f23721d;

    /* renamed from: e */
    private String f23722e;

    /* renamed from: f */
    private int f23723f;

    /* renamed from: g */
    private int f23724g;

    /* renamed from: h */
    private int f23725h;

    /* renamed from: i */
    private int f23726i;

    /* renamed from: j */
    private int f23727j;

    /* renamed from: k */
    private int f23728k;

    /* renamed from: l */
    private int f23729l;

    /* renamed from: m */
    private int f23730m;

    /* renamed from: n */
    private int f23731n;

    /* renamed from: o */
    private int f23732o;

    /* renamed from: p */
    private int f23733p;

    /* renamed from: q */
    private int f23734q;

    /* renamed from: r */
    private int f23735r;

    /* renamed from: s */
    private int f23736s;

    /* renamed from: t */
    private int f23737t;

    /* renamed from: u */
    private int f23738u;

    /* renamed from: v */
    private int f23739v;

    /* renamed from: w */
    private int f23740w;

    /* renamed from: x */
    private int f23741x;

    /* renamed from: y */
    private int f23742y;

    /* renamed from: z */
    private boolean f23743z;

    /* loaded from: classes2.dex */
    public interface OnEditorListener {
        void onEditorChanged(int i);
    }

    /* loaded from: classes2.dex */
    public interface OnHideListener {
        void onHide();
    }

    /* loaded from: classes2.dex */
    public interface OnShowListener {
        void onShow();
    }

    /* renamed from: com.unionpay.tsmservice.widget.UPSaftyKeyboard$a */
    /* loaded from: classes2.dex */
    class BinderC4638a extends OnSafetyKeyboardCallback.Stub {
        BinderC4638a() {
        }

        @Override // com.unionpay.tsmservice.OnSafetyKeyboardCallback
        public final void onEditorChanged(int i) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = i;
            UPSaftyKeyboard.this.f23717R.sendMessage(obtain);
        }

        @Override // com.unionpay.tsmservice.OnSafetyKeyboardCallback
        public final void onHide() throws RemoteException {
            UPSaftyKeyboard.this.f23717R.sendEmptyMessage(1);
        }

        @Override // com.unionpay.tsmservice.OnSafetyKeyboardCallback
        public final void onShow() throws RemoteException {
            UPSaftyKeyboard.this.f23717R.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.unionpay.tsmservice.widget.UPSaftyKeyboard$b */
    /* loaded from: classes2.dex */
    public class C4639b extends FutureTask<String> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.unionpay.tsmservice.widget.UPSaftyKeyboard$b$a */
        /* loaded from: classes2.dex */
        public class BinderC4641a extends ITsmCallback.Stub {
            BinderC4641a() {
            }

            @Override // com.unionpay.tsmservice.ITsmCallback
            public final void onError(String str, String str2) throws RemoteException {
                C4639b.this.set("");
            }

            @Override // com.unionpay.tsmservice.ITsmCallback
            public final void onResult(Bundle bundle) throws RemoteException {
                bundle.setClassLoader(GetEncryptDataResult.class.getClassLoader());
                C4639b.this.set(((GetEncryptDataResult) bundle.get("result")).getData());
            }
        }

        public C4639b() {
            super(new Callable<String>() { // from class: com.unionpay.tsmservice.widget.UPSaftyKeyboard.b.1
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ String call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public String m480a(TimeUnit timeUnit) {
            try {
                try {
                    return get(2000L, timeUnit);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    cancel(true);
                    return "";
                } catch (ExecutionException e2) {
                    e2.printStackTrace();
                    cancel(true);
                    return "";
                } catch (TimeoutException e3) {
                    e3.printStackTrace();
                    cancel(true);
                    return "";
                }
            } finally {
                cancel(true);
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m482a(C4639b c4639b, String str) {
            GetEncryptDataRequestParams getEncryptDataRequestParams = new GetEncryptDataRequestParams();
            getEncryptDataRequestParams.setPan(str);
            getEncryptDataRequestParams.setType(UPSaftyKeyboard.this.f23720c);
            try {
                UPSaftyKeyboard.this.f23719b.getEncryptData(getEncryptDataRequestParams, new BinderC4641a());
            } catch (RemoteException e) {
                e.printStackTrace();
                c4639b.set("");
            }
        }
    }

    public UPSaftyKeyboard(Context context, int i) throws RemoteException {
        this(context, i, null);
    }

    public UPSaftyKeyboard(Context context, int i, Drawable drawable) throws RemoteException {
        this.f23718a = null;
        this.f23723f = -1;
        this.f23724g = -1;
        this.f23725h = -1;
        this.f23726i = -1;
        this.f23727j = -1;
        this.f23728k = -1;
        this.f23729l = -1;
        this.f23730m = -1;
        this.f23731n = -1;
        this.f23732o = -1;
        this.f23733p = -1;
        this.f23734q = -1;
        this.f23735r = -1;
        this.f23736s = -1;
        this.f23737t = -1;
        this.f23738u = -1;
        this.f23739v = -1;
        this.f23740w = 0;
        this.f23741x = 0;
        this.f23742y = 1;
        this.f23743z = false;
        this.f23700A = false;
        this.f23701B = true;
        this.f23702C = false;
        this.f23703D = -1;
        this.f23704E = -1;
        this.f23705F = -1;
        this.f23706G = -1;
        this.f23707H = -1;
        this.f23708I = -16777216;
        this.f23710K = false;
        this.f23716Q = new Handler.Callback() { // from class: com.unionpay.tsmservice.widget.UPSaftyKeyboard.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message2) {
                switch (message2.what) {
                    case 0:
                        if (UPSaftyKeyboard.this.f23711L != null) {
                            UPSaftyKeyboard.this.f23711L.onShow();
                        }
                        return true;
                    case 1:
                        if (UPSaftyKeyboard.this.f23712M != null) {
                            UPSaftyKeyboard.this.f23712M.onHide();
                        }
                        UPSaftyKeyboard.m491c(UPSaftyKeyboard.this);
                        return true;
                    case 2:
                        if (UPSaftyKeyboard.this.f23713N != null) {
                            UPSaftyKeyboard.this.f23721d = message2.arg1;
                            UPSaftyKeyboard.this.f23713N.onEditorChanged(UPSaftyKeyboard.this.f23721d);
                        }
                        return true;
                    default:
                        return false;
                }
            }
        };
        this.f23717R = new Handler(Looper.getMainLooper(), this.f23716Q);
        this.f23718a = context;
        this.f23720c = i;
        if (i < 2000 || i > 2001) {
            throw new IllegalArgumentException("Type is error");
        }
        this.f23719b = UPTsmAddon.getInstance(this.f23718a);
        if (this.f23719b.isConnected()) {
            m500a();
        } else {
            this.f23715P = new UPTsmAddon.UPTsmConnectionListener() { // from class: com.unionpay.tsmservice.widget.UPSaftyKeyboard.2
                @Override // com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener
                public final void onTsmConnected() {
                    UPSaftyKeyboard.this.m500a();
                }

                @Override // com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener
                public final void onTsmDisconnected() {
                }
            };
            this.f23719b.addConnectionListener(this.f23715P);
            this.f23719b.bind();
        }
        if (drawable != null) {
            try {
                setKeyboardBackground(drawable);
            } catch (KeyboardDrawableErrorException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private String m495a(String str) {
        C4639b c4639b = new C4639b();
        C4639b.m482a(c4639b, str);
        return c4639b.m480a(TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m500a() {
        UPTsmAddon uPTsmAddon = this.f23719b;
        if (uPTsmAddon != null) {
            try {
                uPTsmAddon.clearEncryptData(this.f23720c);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m499a(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int m492c = m492c(drawable);
        if (m492c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m492c == 0) {
            safetyKeyboardRequestParams.setDoneForeBitmap(((BitmapDrawable) drawable).getBitmap());
        } else if (m492c == 1) {
            throw new KeyboardDrawableErrorException();
        }
        m498a(safetyKeyboardRequestParams);
    }

    /* renamed from: a */
    private void m498a(SafetyKeyboardRequestParams safetyKeyboardRequestParams) throws RemoteException {
        this.f23719b.setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
    }

    /* renamed from: b */
    private void m494b(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int m492c = m492c(drawable);
        if (m492c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m492c == 0) {
            safetyKeyboardRequestParams.setDelForeBitmap(((BitmapDrawable) drawable).getBitmap());
        } else if (m492c == 1) {
            throw new KeyboardDrawableErrorException();
        }
        m498a(safetyKeyboardRequestParams);
    }

    /* renamed from: c */
    private static int m492c(Drawable drawable) {
        if (drawable == null) {
            return -1;
        }
        if (drawable instanceof BitmapDrawable) {
            return 0;
        }
        if (drawable instanceof ColorDrawable) {
            return 1;
        }
        return drawable instanceof NinePatchDrawable ? 2 : -1;
    }

    /* renamed from: c */
    static /* synthetic */ OnSafetyKeyboardCallback.Stub m491c(UPSaftyKeyboard uPSaftyKeyboard) {
        uPSaftyKeyboard.f23714O = null;
        return null;
    }

    /* renamed from: d */
    private static NinePatchInfo m490d(Drawable drawable) {
        NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) drawable;
        NinePatchInfo ninePatchInfo = new NinePatchInfo();
        Rect rect = new Rect();
        ninePatchDrawable.getPadding(rect);
        ninePatchInfo.setPadding(rect);
        Drawable.ConstantState constantState = ninePatchDrawable.getConstantState();
        try {
            Field declaredField = Class.forName("android.graphics.drawable.NinePatchDrawable$NinePatchState").getDeclaredField("mNinePatch");
            declaredField.setAccessible(true);
            Bitmap bitmap = (Bitmap) Class.forName("android.graphics.NinePatch").getDeclaredMethod("getBitmap", new Class[0]).invoke(declaredField.get(constantState), new Object[0]);
            ninePatchInfo.setBitmap(bitmap);
            ninePatchInfo.setChunk(bitmap.getNinePatchChunk());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ninePatchInfo;
    }

    public synchronized boolean clearPwd() {
        this.f23721d = 0;
        int i = -5;
        try {
            i = this.f23719b.clearEncryptData(this.f23720c);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return i == 0;
    }

    public void enableLightStatusBar(boolean z) {
        this.f23710K = z;
    }

    public int getCurrentPinLength() {
        return this.f23721d;
    }

    public String getInput() {
        return m495a("");
    }

    public String getInput(String str) {
        return this.f23720c != 2000 ? "" : m495a(str);
    }

    public boolean hide() {
        int i;
        try {
            i = this.f23719b.hideKeyboard();
        } catch (RemoteException e) {
            e.printStackTrace();
            i = -5;
        }
        return i == 0;
    }

    public void setConfirmBtnOutPaddingRight(int i) {
        this.f23739v = i;
    }

    public void setConfirmBtnSize(int i, int i2) {
        this.f23725h = i;
        this.f23726i = i2;
    }

    public void setDelKeyDrawable(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        if (drawable != null) {
            m494b(drawable);
        }
    }

    public void setDelKeyDrawable(Drawable drawable, Drawable drawable2) throws KeyboardDrawableErrorException, RemoteException {
        if (drawable != null) {
            m494b(drawable);
        }
        if (drawable2 != null) {
            int m492c = m492c(drawable2);
            if (m492c == -1) {
                throw new KeyboardDrawableErrorException();
            }
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (m492c == 0) {
                safetyKeyboardRequestParams.setDelBgBitmap(((BitmapDrawable) drawable2).getBitmap());
                safetyKeyboardRequestParams.setDelBgColor(-1);
            } else if (m492c == 1) {
                safetyKeyboardRequestParams.setDelBgColor(((ColorDrawable) drawable2).getColor());
            } else if (m492c == 2) {
                safetyKeyboardRequestParams.setDelKeyBgNinePatch(m490d(drawable2));
            }
            m498a(safetyKeyboardRequestParams);
        }
    }

    public void setDoneKeyDrawable(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        if (drawable != null) {
            m499a(drawable);
        }
    }

    public void setDoneKeyDrawable(Drawable drawable, Drawable drawable2) throws KeyboardDrawableErrorException, RemoteException {
        if (drawable != null) {
            m499a(drawable);
        }
        if (drawable2 != null) {
            int m492c = m492c(drawable2);
            if (m492c == -1) {
                throw new KeyboardDrawableErrorException();
            }
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (m492c == 0) {
                safetyKeyboardRequestParams.setDoneBgBitmap(((BitmapDrawable) drawable2).getBitmap());
                safetyKeyboardRequestParams.setDoneBgColor(-1);
            } else if (m492c == 1) {
                safetyKeyboardRequestParams.setDoneBgColor(((ColorDrawable) drawable2).getColor());
            } else if (m492c == 2) {
                safetyKeyboardRequestParams.setDoneKeyBgNinePatch(m490d(drawable2));
            }
            m498a(safetyKeyboardRequestParams);
        }
    }

    public void setDoneKeyEnable(boolean z) {
        this.f23701B = z;
    }

    public void setDoneKeyRightMode(boolean z) {
        this.f23700A = z;
    }

    public void setKeyAreaPadding(int i, int i2, int i3, int i4) {
        this.f23734q = i;
        this.f23735r = i2;
        this.f23736s = i3;
        this.f23737t = i4;
    }

    public void setKeyBoardSize(int i, int i2) {
        this.f23723f = i;
        this.f23724g = i2;
    }

    public void setKeyboardAudio(boolean z) {
        this.f23743z = z;
    }

    public void setKeyboardBackground(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int m492c = m492c(drawable);
        if (m492c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m492c == 0) {
            safetyKeyboardRequestParams.setKeyboardBgBitmap(((BitmapDrawable) drawable).getBitmap());
            safetyKeyboardRequestParams.setKeyboardBgColor(-1);
        } else if (m492c == 1) {
            safetyKeyboardRequestParams.setKeyboardBgColor(((ColorDrawable) drawable).getColor());
        } else if (m492c == 2) {
            safetyKeyboardRequestParams.setKeyboardBgNinePatch(m490d(drawable));
        }
        m498a(safetyKeyboardRequestParams);
    }

    public void setKeyboardPadding(int i, int i2, int i3, int i4) {
        this.f23730m = i;
        this.f23731n = i2;
        this.f23732o = i3;
        this.f23733p = i4;
    }

    public void setKeyboardStartPosition(int i, int i2) {
        this.f23740w = i;
        this.f23741x = i2;
        this.f23742y = 0;
    }

    public void setKeyboardVibrate(boolean z) {
        this.f23702C = z;
    }

    public void setNumKeyBackgroud(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int m492c = m492c(drawable);
        if (m492c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m492c == 0) {
            safetyKeyboardRequestParams.setNumBgBitmap(((BitmapDrawable) drawable).getBitmap());
            safetyKeyboardRequestParams.setNumBgColor(-1);
        } else if (m492c == 1) {
            safetyKeyboardRequestParams.setNumBgColor(((ColorDrawable) drawable).getColor());
        } else if (m492c == 2) {
            safetyKeyboardRequestParams.setNumKeyBgNinePatch(m490d(drawable));
        }
        m498a(safetyKeyboardRequestParams);
    }

    public void setNumKeyMargin(int i, int i2) {
        this.f23728k = i;
        this.f23729l = i2;
    }

    public void setNumberKeyColor(int i) {
        this.f23708I = i;
    }

    public void setNumberKeyDrawable(Drawable[] drawableArr) throws KeyboardDrawableErrorException, RemoteException {
        char c = 65535;
        if (drawableArr != null && drawableArr.length > 0) {
            int length = drawableArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    c = 0;
                    break;
                } else if (!(drawableArr[i] instanceof BitmapDrawable)) {
                    break;
                } else {
                    i++;
                }
            }
        }
        if (c != 0) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        ArrayList<Bitmap> arrayList = new ArrayList<>();
        for (Drawable drawable : drawableArr) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                arrayList.add(bitmapDrawable.getBitmap());
            }
        }
        safetyKeyboardRequestParams.setNumForeBitmaps(arrayList);
        m498a(safetyKeyboardRequestParams);
    }

    public void setNumberKeySize(int i) {
        this.f23738u = i;
    }

    public void setOnEditorListener(OnEditorListener onEditorListener) {
        this.f23713N = onEditorListener;
    }

    public void setOnHideListener(OnHideListener onHideListener) {
        this.f23712M = onHideListener;
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        this.f23711L = onShowListener;
    }

    public void setTitleBackground(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int m492c = m492c(drawable);
        if (m492c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m492c == 0) {
            safetyKeyboardRequestParams.setTitleBgBitmap(((BitmapDrawable) drawable).getBitmap());
            safetyKeyboardRequestParams.setTitleBgColor(-1);
        } else if (m492c == 1) {
            safetyKeyboardRequestParams.setTitleBgColor(((ColorDrawable) drawable).getColor());
        } else if (m492c == 2) {
            safetyKeyboardRequestParams.setTitleBgNinePatch(m490d(drawable));
        }
        m498a(safetyKeyboardRequestParams);
    }

    public void setTitleColor(int i) {
        this.f23706G = i;
    }

    public void setTitleConfirmDrawable(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int m492c = m492c(drawable);
        if (m492c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m492c == 0) {
            safetyKeyboardRequestParams.setTitleDropBitmap(((BitmapDrawable) drawable).getBitmap());
        } else if (m492c == 1) {
            throw new KeyboardDrawableErrorException();
        }
        m498a(safetyKeyboardRequestParams);
    }

    public void setTitleDrawable(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int m492c = m492c(drawable);
        if (m492c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m492c == 0) {
            safetyKeyboardRequestParams.setTitleIconBitmap(((BitmapDrawable) drawable).getBitmap());
        } else if (m492c == 1) {
            throw new KeyboardDrawableErrorException();
        }
        m498a(safetyKeyboardRequestParams);
    }

    public void setTitleDrawablePadding(int i) {
        this.f23705F = i;
    }

    public void setTitleDrawableSize(int i, int i2) {
        this.f23703D = i;
        this.f23704E = i2;
    }

    public void setTitleFont(Typeface typeface) {
        this.f23709J = typeface;
    }

    public void setTitleHeight(int i) {
        this.f23727j = i;
    }

    public void setTitleSize(int i) {
        this.f23707H = i;
    }

    public void setTitleText(String str) {
        this.f23722e = str;
    }

    public synchronized boolean show() {
        if (this.f23714O == null) {
            this.f23714O = new BinderC4638a();
            try {
                SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
                safetyKeyboardRequestParams.setTitle(this.f23722e);
                safetyKeyboardRequestParams.setKeyboardWidth(this.f23723f);
                safetyKeyboardRequestParams.setKeyboardHeight(this.f23724g);
                safetyKeyboardRequestParams.setConfirmBtnWidth(this.f23725h);
                safetyKeyboardRequestParams.setConfirmBtnHeight(this.f23726i);
                safetyKeyboardRequestParams.setTitleHeight(this.f23727j);
                safetyKeyboardRequestParams.setMarginRow(this.f23728k);
                safetyKeyboardRequestParams.setMarginCol(this.f23729l);
                safetyKeyboardRequestParams.setOutPaddingLeft(this.f23730m);
                safetyKeyboardRequestParams.setOutPaddingRight(this.f23732o);
                safetyKeyboardRequestParams.setOutPaddingTop(this.f23731n);
                safetyKeyboardRequestParams.setOutPaddingBottom(this.f23733p);
                safetyKeyboardRequestParams.setInnerPaddingLeft(this.f23734q);
                safetyKeyboardRequestParams.setInnerPaddingRight(this.f23736s);
                safetyKeyboardRequestParams.setInnerPaddingTop(this.f23735r);
                safetyKeyboardRequestParams.setInnerPaddingBottom(this.f23737t);
                safetyKeyboardRequestParams.setNumSize(this.f23738u);
                safetyKeyboardRequestParams.setConfirmBtnOutPaddingRight(this.f23739v);
                safetyKeyboardRequestParams.setStartX(this.f23740w);
                safetyKeyboardRequestParams.setStartY(this.f23741x);
                safetyKeyboardRequestParams.setDefaultPosition(this.f23742y);
                safetyKeyboardRequestParams.setIsAudio(this.f23743z ? 1 : 0);
                safetyKeyboardRequestParams.setDoneRight(this.f23700A ? 1 : 0);
                safetyKeyboardRequestParams.setEnableOKBtn(this.f23701B ? 1 : 0);
                safetyKeyboardRequestParams.setIsVibrate(this.f23702C ? 1 : 0);
                safetyKeyboardRequestParams.setSecureWidth(this.f23703D);
                safetyKeyboardRequestParams.setSecureHeight(this.f23704E);
                safetyKeyboardRequestParams.setTitleDrawablePadding(this.f23705F);
                safetyKeyboardRequestParams.setTitleColor(this.f23706G);
                safetyKeyboardRequestParams.setTitleSize(this.f23707H);
                safetyKeyboardRequestParams.setNumberKeyColor(this.f23708I);
                if (this.f23709J != null) {
                    safetyKeyboardRequestParams.setTitleFont(this.f23709J.getStyle());
                }
                safetyKeyboardRequestParams.setEnableLightStatusBar(this.f23710K);
                if (this.f23719b.showSafetyKeyboard(safetyKeyboardRequestParams, this.f23720c, this.f23714O, this.f23718a) != 0) {
                    this.f23714O = null;
                    return false;
                }
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
                this.f23714O = null;
                return false;
            }
        }
        return false;
    }
}
