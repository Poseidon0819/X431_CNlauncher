package com.unionpay.tsmservice.p373mi.widget;

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
import com.unionpay.tsmservice.p373mi.ITsmCallback;
import com.unionpay.tsmservice.p373mi.OnSafetyKeyboardCallback;
import com.unionpay.tsmservice.p373mi.UPTsmAddon;
import com.unionpay.tsmservice.p373mi.data.Constant;
import com.unionpay.tsmservice.p373mi.data.NinePatchInfo;
import com.unionpay.tsmservice.p373mi.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.p373mi.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.p373mi.result.GetEncryptDataResult;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.unionpay.tsmservice.mi.widget.UPSaftyKeyboard */
/* loaded from: classes2.dex */
public class UPSaftyKeyboard {

    /* renamed from: A */
    private boolean f23646A;

    /* renamed from: B */
    private boolean f23647B;

    /* renamed from: C */
    private boolean f23648C;

    /* renamed from: D */
    private int f23649D;

    /* renamed from: E */
    private int f23650E;

    /* renamed from: F */
    private int f23651F;

    /* renamed from: G */
    private int f23652G;

    /* renamed from: H */
    private int f23653H;

    /* renamed from: I */
    private int f23654I;

    /* renamed from: J */
    private Typeface f23655J;

    /* renamed from: K */
    private boolean f23656K;

    /* renamed from: L */
    private boolean f23657L;

    /* renamed from: M */
    private boolean f23658M;

    /* renamed from: N */
    private OnShowListener f23659N;

    /* renamed from: O */
    private OnHideListener f23660O;

    /* renamed from: P */
    private OnEditorListener f23661P;

    /* renamed from: Q */
    private OnOutsideTouchListener f23662Q;

    /* renamed from: R */
    private OnConfirmClickListener f23663R;

    /* renamed from: S */
    private OnSafetyKeyboardCallback.Stub f23664S;

    /* renamed from: T */
    private UPTsmAddon.UPTsmConnectionListener f23665T;

    /* renamed from: U */
    private Handler.Callback f23666U;

    /* renamed from: V */
    private final Handler f23667V;

    /* renamed from: a */
    private Context f23668a;

    /* renamed from: b */
    private UPTsmAddon f23669b;

    /* renamed from: c */
    private int f23670c;

    /* renamed from: d */
    private int f23671d;

    /* renamed from: e */
    private String f23672e;

    /* renamed from: f */
    private int f23673f;

    /* renamed from: g */
    private int f23674g;

    /* renamed from: h */
    private int f23675h;

    /* renamed from: i */
    private int f23676i;

    /* renamed from: j */
    private int f23677j;

    /* renamed from: k */
    private int f23678k;

    /* renamed from: l */
    private int f23679l;

    /* renamed from: m */
    private int f23680m;

    /* renamed from: n */
    private int f23681n;

    /* renamed from: o */
    private int f23682o;

    /* renamed from: p */
    private int f23683p;

    /* renamed from: q */
    private int f23684q;

    /* renamed from: r */
    private int f23685r;

    /* renamed from: s */
    private int f23686s;

    /* renamed from: t */
    private int f23687t;

    /* renamed from: u */
    private int f23688u;

    /* renamed from: v */
    private int f23689v;

    /* renamed from: w */
    private int f23690w;

    /* renamed from: x */
    private int f23691x;

    /* renamed from: y */
    private int f23692y;

    /* renamed from: z */
    private boolean f23693z;

    /* renamed from: com.unionpay.tsmservice.mi.widget.UPSaftyKeyboard$OnConfirmClickListener */
    /* loaded from: classes2.dex */
    public interface OnConfirmClickListener {
        void onConfirmClick();
    }

    /* renamed from: com.unionpay.tsmservice.mi.widget.UPSaftyKeyboard$OnEditorListener */
    /* loaded from: classes2.dex */
    public interface OnEditorListener {
        void onEditorChanged(int i);
    }

    /* renamed from: com.unionpay.tsmservice.mi.widget.UPSaftyKeyboard$OnHideListener */
    /* loaded from: classes2.dex */
    public interface OnHideListener {
        void onHide();
    }

    /* renamed from: com.unionpay.tsmservice.mi.widget.UPSaftyKeyboard$OnOutsideTouchListener */
    /* loaded from: classes2.dex */
    public interface OnOutsideTouchListener {
        void onTouch(float f, float f2);
    }

    /* renamed from: com.unionpay.tsmservice.mi.widget.UPSaftyKeyboard$OnShowListener */
    /* loaded from: classes2.dex */
    public interface OnShowListener {
        void onShow();
    }

    /* renamed from: com.unionpay.tsmservice.mi.widget.UPSaftyKeyboard$a */
    /* loaded from: classes2.dex */
    final class BinderC4561a extends OnSafetyKeyboardCallback.Stub {
        BinderC4561a() {
        }

        @Override // com.unionpay.tsmservice.p373mi.OnSafetyKeyboardCallback
        public final void onConfirmClicked() {
            UPSaftyKeyboard.this.f23667V.sendEmptyMessage(4);
        }

        @Override // com.unionpay.tsmservice.p373mi.OnSafetyKeyboardCallback
        public final void onEditorChanged(int i) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = i;
            UPSaftyKeyboard.this.f23667V.sendMessage(obtain);
        }

        @Override // com.unionpay.tsmservice.p373mi.OnSafetyKeyboardCallback
        public final void onHide() {
            UPSaftyKeyboard.this.f23667V.sendEmptyMessage(1);
        }

        @Override // com.unionpay.tsmservice.p373mi.OnSafetyKeyboardCallback
        public final void onOutsideTouch(float f, float f2) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            Bundle bundle = new Bundle();
            bundle.putFloat("coordinateX", f);
            bundle.putFloat("coordinateY", f2);
            obtain.setData(bundle);
            UPSaftyKeyboard.this.f23667V.sendMessage(obtain);
        }

        @Override // com.unionpay.tsmservice.p373mi.OnSafetyKeyboardCallback
        public final void onShow() {
            UPSaftyKeyboard.this.f23667V.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.unionpay.tsmservice.mi.widget.UPSaftyKeyboard$b */
    /* loaded from: classes2.dex */
    public final class C4562b extends FutureTask {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.unionpay.tsmservice.mi.widget.UPSaftyKeyboard$b$a */
        /* loaded from: classes2.dex */
        public final class BinderC4564a extends ITsmCallback.Stub {
            BinderC4564a() {
            }

            @Override // com.unionpay.tsmservice.p373mi.ITsmCallback
            public final void onError(String str, String str2) {
                C4562b.this.set("");
            }

            @Override // com.unionpay.tsmservice.p373mi.ITsmCallback
            public final void onResult(Bundle bundle) {
                bundle.setClassLoader(GetEncryptDataResult.class.getClassLoader());
                C4562b.this.set(((GetEncryptDataResult) bundle.get("result")).getData());
            }
        }

        public C4562b() {
            super(new Callable() { // from class: com.unionpay.tsmservice.mi.widget.UPSaftyKeyboard.b.1
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    throw new IllegalStateException("this should never be called");
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public String m502a(TimeUnit timeUnit) {
            try {
                try {
                    return (String) get(2000L, timeUnit);
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
        static /* synthetic */ void m504a(C4562b c4562b, String str) {
            GetEncryptDataRequestParams getEncryptDataRequestParams = new GetEncryptDataRequestParams();
            getEncryptDataRequestParams.setPan(str);
            getEncryptDataRequestParams.setType(UPSaftyKeyboard.this.f23670c);
            try {
                UPSaftyKeyboard.this.f23669b.getEncryptData(getEncryptDataRequestParams, new BinderC4564a());
            } catch (RemoteException e) {
                e.printStackTrace();
                c4562b.set("");
            }
        }
    }

    public UPSaftyKeyboard(Context context, int i) {
        this(context, i, null);
    }

    public UPSaftyKeyboard(Context context, int i, Drawable drawable) {
        this.f23668a = null;
        this.f23673f = -1;
        this.f23674g = -1;
        this.f23675h = -1;
        this.f23676i = -1;
        this.f23677j = -1;
        this.f23678k = -1;
        this.f23679l = -1;
        this.f23680m = -1;
        this.f23681n = -1;
        this.f23682o = -1;
        this.f23683p = -1;
        this.f23684q = -1;
        this.f23685r = -1;
        this.f23686s = -1;
        this.f23687t = -1;
        this.f23688u = -1;
        this.f23689v = -1;
        this.f23690w = 0;
        this.f23691x = 0;
        this.f23692y = 1;
        this.f23693z = false;
        this.f23646A = false;
        this.f23647B = true;
        this.f23648C = false;
        this.f23649D = -1;
        this.f23650E = -1;
        this.f23651F = -1;
        this.f23652G = -1;
        this.f23653H = -1;
        this.f23654I = -16777216;
        this.f23656K = false;
        this.f23657L = true;
        this.f23658M = true;
        this.f23666U = new Handler.Callback() { // from class: com.unionpay.tsmservice.mi.widget.UPSaftyKeyboard.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message2) {
                switch (message2.what) {
                    case 0:
                        if (UPSaftyKeyboard.this.f23659N != null) {
                            UPSaftyKeyboard.this.f23659N.onShow();
                        }
                        return true;
                    case 1:
                        if (UPSaftyKeyboard.this.f23660O != null) {
                            UPSaftyKeyboard.this.f23660O.onHide();
                        }
                        UPSaftyKeyboard.m515c(UPSaftyKeyboard.this);
                        return true;
                    case 2:
                        if (UPSaftyKeyboard.this.f23661P != null) {
                            UPSaftyKeyboard.this.f23671d = message2.arg1;
                            UPSaftyKeyboard.this.f23661P.onEditorChanged(UPSaftyKeyboard.this.f23671d);
                        }
                        return true;
                    case 3:
                        if (UPSaftyKeyboard.this.f23662Q != null) {
                            Bundle data = message2.getData();
                            UPSaftyKeyboard.this.f23662Q.onTouch(data.getFloat("coordinateX"), data.getFloat("coordinateY"));
                        }
                        return true;
                    case 4:
                        if (UPSaftyKeyboard.this.f23663R != null) {
                            UPSaftyKeyboard.this.f23663R.onConfirmClick();
                        }
                        return true;
                    default:
                        return false;
                }
            }
        };
        this.f23667V = new Handler(Looper.getMainLooper(), this.f23666U);
        this.f23668a = context;
        this.f23670c = i;
        if (i < 2000 || i > 2002) {
            throw new IllegalArgumentException("Type is error");
        }
        this.f23669b = UPTsmAddon.getInstance(this.f23668a);
        if (this.f23669b.isConnected()) {
            m525a();
        } else {
            this.f23665T = new UPTsmAddon.UPTsmConnectionListener() { // from class: com.unionpay.tsmservice.mi.widget.UPSaftyKeyboard.2
                @Override // com.unionpay.tsmservice.p373mi.UPTsmAddon.UPTsmConnectionListener
                public final void onTsmConnected() {
                    UPSaftyKeyboard.this.m525a();
                }

                @Override // com.unionpay.tsmservice.p373mi.UPTsmAddon.UPTsmConnectionListener
                public final void onTsmDisconnected() {
                }
            };
            this.f23669b.addConnectionListener(this.f23665T);
            this.f23669b.bind();
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
    private String m520a(String str) {
        C4562b c4562b = new C4562b();
        C4562b.m504a(c4562b, str);
        return c4562b.m502a(TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    private static ArrayList m519a(Drawable[] drawableArr) {
        ArrayList arrayList = new ArrayList();
        for (Drawable drawable : drawableArr) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                arrayList.add(bitmapDrawable.getBitmap());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m525a() {
        UPTsmAddon uPTsmAddon = this.f23669b;
        if (uPTsmAddon != null) {
            try {
                uPTsmAddon.clearEncryptData(this.f23670c);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m524a(Drawable drawable) {
        int m516c = m516c(drawable);
        if (m516c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m516c == 0) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.KEY_DONE_FORE_BITMAP, ((BitmapDrawable) drawable).getBitmap());
            safetyKeyboardRequestParams.setParams(bundle);
        } else if (m516c == 1) {
            throw new KeyboardDrawableErrorException();
        }
        m523a(safetyKeyboardRequestParams);
    }

    /* renamed from: a */
    private void m523a(SafetyKeyboardRequestParams safetyKeyboardRequestParams) {
        this.f23669b.setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
    }

    /* renamed from: b */
    private void m518b(Drawable drawable) {
        int m516c = m516c(drawable);
        if (m516c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m516c == 0) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.KEY_DEL_FORE_BITMAP, ((BitmapDrawable) drawable).getBitmap());
            safetyKeyboardRequestParams.setParams(bundle);
        } else if (m516c == 1) {
            throw new KeyboardDrawableErrorException();
        }
        m523a(safetyKeyboardRequestParams);
    }

    /* renamed from: c */
    private static int m516c(Drawable drawable) {
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
    static /* synthetic */ OnSafetyKeyboardCallback.Stub m515c(UPSaftyKeyboard uPSaftyKeyboard) {
        uPSaftyKeyboard.f23664S = null;
        return null;
    }

    /* renamed from: d */
    private static NinePatchInfo m514d(Drawable drawable) {
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

    public boolean cancelPay() {
        int i;
        try {
            i = this.f23669b.cancelPay();
        } catch (RemoteException e) {
            e.printStackTrace();
            i = -5;
        }
        return i == 0;
    }

    public synchronized boolean clearPwd() {
        this.f23671d = 0;
        int i = -5;
        try {
            i = this.f23669b.clearEncryptData(this.f23670c);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return i == 0;
    }

    public void enableDismissOnConfirmClick(boolean z) {
        this.f23658M = z;
    }

    public void enableDismissOnOutsideTouch(boolean z) {
        this.f23657L = z;
    }

    public void enableLightStatusBar(boolean z) {
        this.f23656K = z;
    }

    public int getCurrentPinLength() {
        return this.f23671d;
    }

    public String getInput() {
        return m520a("");
    }

    public String getInput(String str) {
        return this.f23670c != 2000 ? "" : m520a(str);
    }

    public boolean hide() {
        int i;
        try {
            i = this.f23669b.hideKeyboard();
        } catch (RemoteException e) {
            e.printStackTrace();
            i = -5;
        }
        return i == 0;
    }

    public void setConfirmBtnOutPaddingRight(int i) {
        this.f23689v = i;
    }

    public void setConfirmBtnSize(int i, int i2) {
        this.f23675h = i;
        this.f23676i = i2;
    }

    public void setDelKeyDrawable(Drawable drawable) {
        if (drawable != null) {
            m518b(drawable);
        }
    }

    public void setDelKeyDrawable(Drawable drawable, Drawable drawable2) {
        Bundle bundle;
        if (drawable != null) {
            m518b(drawable);
        }
        if (drawable2 != null) {
            int m516c = m516c(drawable2);
            if (m516c == -1) {
                throw new KeyboardDrawableErrorException();
            }
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (m516c == 0) {
                bundle = new Bundle();
                bundle.putParcelable(Constant.KEY_DEL_BG_BITMAP, ((BitmapDrawable) drawable2).getBitmap());
                bundle.putInt(Constant.KEY_DEL_BG_COLOR, -1);
            } else if (m516c != 1) {
                if (m516c == 2) {
                    NinePatchInfo m514d = m514d(drawable2);
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable(Constant.KEY_DEL_BG_NINE_PATCH, m514d);
                    safetyKeyboardRequestParams.setParams(bundle2);
                }
                m523a(safetyKeyboardRequestParams);
            } else {
                bundle = new Bundle();
                bundle.putInt(Constant.KEY_DEL_BG_COLOR, ((ColorDrawable) drawable2).getColor());
            }
            safetyKeyboardRequestParams.setParams(bundle);
            m523a(safetyKeyboardRequestParams);
        }
    }

    public void setDoneKeyDrawable(Drawable drawable) {
        if (drawable != null) {
            m524a(drawable);
        }
    }

    public void setDoneKeyDrawable(Drawable drawable, Drawable drawable2) {
        Bundle bundle;
        if (drawable != null) {
            m524a(drawable);
        }
        if (drawable2 != null) {
            int m516c = m516c(drawable2);
            if (m516c == -1) {
                throw new KeyboardDrawableErrorException();
            }
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (m516c == 0) {
                bundle = new Bundle();
                bundle.putParcelable(Constant.KEY_DONE_BG_BITMAP, ((BitmapDrawable) drawable2).getBitmap());
                bundle.putInt(Constant.KEY_DONE_BG_COLOR, -1);
            } else if (m516c != 1) {
                if (m516c == 2) {
                    NinePatchInfo m514d = m514d(drawable2);
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable(Constant.KEY_DONE_BG_NINE_PATCH, m514d);
                    safetyKeyboardRequestParams.setParams(bundle2);
                }
                m523a(safetyKeyboardRequestParams);
            } else {
                bundle = new Bundle();
                bundle.putInt(Constant.KEY_DONE_BG_COLOR, ((ColorDrawable) drawable2).getColor());
            }
            safetyKeyboardRequestParams.setParams(bundle);
            m523a(safetyKeyboardRequestParams);
        }
    }

    public void setDoneKeyEnable(boolean z) {
        this.f23647B = z;
    }

    public void setDoneKeyRightMode(boolean z) {
        this.f23646A = z;
    }

    public void setKeyAreaPadding(int i, int i2, int i3, int i4) {
        this.f23684q = i;
        this.f23685r = i2;
        this.f23686s = i3;
        this.f23687t = i4;
    }

    public void setKeyBoardSize(int i, int i2) {
        this.f23673f = i;
        this.f23674g = i2;
    }

    public void setKeyboardAudio(boolean z) {
        this.f23693z = z;
    }

    public void setKeyboardBackground(Drawable drawable) {
        Bundle bundle;
        int m516c = m516c(drawable);
        if (m516c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m516c == 0) {
            bundle = new Bundle();
            bundle.putParcelable(Constant.KEY_KEYBOARD_BG_BITMAP, ((BitmapDrawable) drawable).getBitmap());
            bundle.putInt(Constant.KEY_KEYBOARD_BG_COLOR, -1);
        } else if (m516c != 1) {
            if (m516c == 2) {
                NinePatchInfo m514d = m514d(drawable);
                bundle = new Bundle();
                bundle.putParcelable(Constant.KEY_KEYBOARD_BG_NINE_PATCH, m514d);
            }
            m523a(safetyKeyboardRequestParams);
        } else {
            bundle = new Bundle();
            bundle.putInt(Constant.KEY_KEYBOARD_BG_COLOR, ((ColorDrawable) drawable).getColor());
        }
        safetyKeyboardRequestParams.setParams(bundle);
        m523a(safetyKeyboardRequestParams);
    }

    public void setKeyboardPadding(int i, int i2, int i3, int i4) {
        this.f23680m = i;
        this.f23681n = i2;
        this.f23682o = i3;
        this.f23683p = i4;
    }

    public void setKeyboardStartPosition(int i, int i2) {
        this.f23690w = i;
        this.f23691x = i2;
        this.f23692y = 0;
    }

    public void setKeyboardVibrate(boolean z) {
        this.f23648C = z;
    }

    public void setNumKeyBackgroud(Drawable drawable) {
        Bundle bundle;
        int m516c = m516c(drawable);
        if (m516c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m516c == 0) {
            bundle = new Bundle();
            bundle.putParcelable(Constant.KEY_NUM_BG_BITMAP, ((BitmapDrawable) drawable).getBitmap());
            bundle.putInt(Constant.KEY_NUM_BG_COLOR, -1);
        } else if (m516c != 1) {
            if (m516c == 2) {
                NinePatchInfo m514d = m514d(drawable);
                bundle = new Bundle();
                bundle.putParcelable(Constant.KEY_NUM_BG_NINE_PATCH, m514d);
            }
            m523a(safetyKeyboardRequestParams);
        } else {
            bundle = new Bundle();
            bundle.putInt(Constant.KEY_NUM_BG_COLOR, ((ColorDrawable) drawable).getColor());
        }
        safetyKeyboardRequestParams.setParams(bundle);
        m523a(safetyKeyboardRequestParams);
    }

    public void setNumKeyMargin(int i, int i2) {
        this.f23678k = i;
        this.f23679l = i2;
    }

    public void setNumberKeyColor(int i) {
        this.f23654I = i;
    }

    public void setNumberKeyDrawable(Drawable[] drawableArr) {
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
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Constant.KEY_NUM_FORE_BITMAPS, m519a(drawableArr));
        safetyKeyboardRequestParams.setParams(bundle);
        m523a(safetyKeyboardRequestParams);
    }

    public void setNumberKeySize(int i) {
        this.f23688u = i;
    }

    public void setOnConfirmClickListener(OnConfirmClickListener onConfirmClickListener) {
        this.f23663R = onConfirmClickListener;
    }

    public void setOnEditorListener(OnEditorListener onEditorListener) {
        this.f23661P = onEditorListener;
    }

    public void setOnHideListener(OnHideListener onHideListener) {
        this.f23660O = onHideListener;
    }

    public void setOnOutsideTouchListener(OnOutsideTouchListener onOutsideTouchListener) {
        this.f23662Q = onOutsideTouchListener;
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        this.f23659N = onShowListener;
    }

    public void setTitleBackground(Drawable drawable) {
        Bundle bundle;
        int m516c = m516c(drawable);
        if (m516c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m516c == 0) {
            bundle = new Bundle();
            bundle.putParcelable(Constant.KEY_TITLE_BG_BITMAP, ((BitmapDrawable) drawable).getBitmap());
            bundle.putInt(Constant.KEY_TITLE_BG_COLOR, -1);
        } else if (m516c != 1) {
            if (m516c == 2) {
                NinePatchInfo m514d = m514d(drawable);
                bundle = new Bundle();
                bundle.putParcelable(Constant.KEY_TITLE_BG_NINE_PATCH, m514d);
            }
            m523a(safetyKeyboardRequestParams);
        } else {
            bundle = new Bundle();
            bundle.putInt(Constant.KEY_TITLE_BG_COLOR, ((ColorDrawable) drawable).getColor());
        }
        safetyKeyboardRequestParams.setParams(bundle);
        m523a(safetyKeyboardRequestParams);
    }

    public void setTitleColor(int i) {
        this.f23652G = i;
    }

    public void setTitleConfirmDrawable(Drawable drawable) {
        int m516c = m516c(drawable);
        if (m516c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m516c == 0) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.KEY_TITLE_DROP_BITMAP, ((BitmapDrawable) drawable).getBitmap());
            safetyKeyboardRequestParams.setParams(bundle);
        } else if (m516c == 1) {
            throw new KeyboardDrawableErrorException();
        }
        m523a(safetyKeyboardRequestParams);
    }

    public void setTitleDrawable(Drawable drawable) {
        int m516c = m516c(drawable);
        if (m516c == -1) {
            throw new KeyboardDrawableErrorException();
        }
        SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
        if (m516c == 0) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.KEY_TITLE_ICON_BITMAP, ((BitmapDrawable) drawable).getBitmap());
            safetyKeyboardRequestParams.setParams(bundle);
        } else if (m516c == 1) {
            throw new KeyboardDrawableErrorException();
        }
        m523a(safetyKeyboardRequestParams);
    }

    public void setTitleDrawablePadding(int i) {
        this.f23651F = i;
    }

    public void setTitleDrawableSize(int i, int i2) {
        this.f23649D = i;
        this.f23650E = i2;
    }

    public void setTitleFont(Typeface typeface) {
        this.f23655J = typeface;
    }

    public void setTitleHeight(int i) {
        this.f23677j = i;
    }

    public void setTitleSize(int i) {
        this.f23653H = i;
    }

    public void setTitleText(String str) {
        this.f23672e = str;
    }

    public synchronized boolean show() {
        if (this.f23664S == null) {
            this.f23664S = new BinderC4561a();
            try {
                SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
                Bundle bundle = new Bundle();
                bundle.putString("title", this.f23672e);
                bundle.putInt("width", this.f23673f);
                bundle.putInt("height", this.f23674g);
                bundle.putInt(Constant.KEY_CONFIRMBTN_WIDTH, this.f23675h);
                bundle.putInt(Constant.KEY_CONFIRMBTN_HEIGHT, this.f23676i);
                bundle.putInt(Constant.KEY_TITLE_HEIGHT, this.f23677j);
                bundle.putInt(Constant.KEY_ROW, this.f23678k);
                bundle.putInt(Constant.KEY_COL, this.f23679l);
                bundle.putInt(Constant.KEY_OUT_LEFT, this.f23680m);
                bundle.putInt(Constant.KEY_OUT_RIGHT, this.f23682o);
                bundle.putInt(Constant.KEY_OUT_TOP, this.f23681n);
                bundle.putInt(Constant.KEY_OUT_BOTTOM, this.f23683p);
                bundle.putInt(Constant.KEY_INNER_LEFT, this.f23684q);
                bundle.putInt(Constant.KEY_INNER_RIGHT, this.f23686s);
                bundle.putInt(Constant.KEY_INNER_TOP, this.f23685r);
                bundle.putInt(Constant.KEY_INNER_BOTTOM, this.f23687t);
                bundle.putInt(Constant.KEY_CONFIRMBTN_RIGHT, this.f23689v);
                bundle.putInt(Constant.KEY_STARTPOSITION_X, this.f23690w);
                bundle.putInt(Constant.KEY_STARTPOSITION_Y, this.f23691x);
                bundle.putInt(Constant.KEY_IS_DEFAULTPOSITION, this.f23692y);
                bundle.putInt(Constant.KEY_NUM_SIZE, this.f23688u);
                bundle.putInt(Constant.KEY_IS_AUDIO, this.f23693z ? 1 : 0);
                bundle.putInt(Constant.KEY_IS_VIBRATE, this.f23648C ? 1 : 0);
                bundle.putInt(Constant.KEY_DONE_RIGHT, this.f23646A ? 1 : 0);
                bundle.putInt(Constant.KEY_ENABLE_OKBTN, this.f23647B ? 1 : 0);
                bundle.putInt(Constant.KEY_SECURE_WIDTH, this.f23649D);
                bundle.putInt(Constant.KEY_SECURE_HEIGHT, this.f23650E);
                bundle.putInt(Constant.KEY_TITLE_DRAWABLE_PADDING, this.f23651F);
                bundle.putInt(Constant.KEY_TITLE_COLOR, this.f23652G);
                bundle.putInt(Constant.KEY_TITLE_SIZE, this.f23653H);
                bundle.putInt(Constant.KEY_NUMBER_KEYCOLOR, this.f23654I);
                if (this.f23655J != null) {
                    bundle.putInt(Constant.KEY_TITLE_FONT, this.f23655J.getStyle());
                }
                bundle.putBoolean(Constant.KEY_ENABLE_LIGHT_STATUS_BAR, this.f23656K);
                bundle.putBoolean(Constant.KEY_ENABLE_DISMISS_ON_OUTSIDE_TOUCH, this.f23657L);
                bundle.putBoolean(Constant.KEY_ENABLE_DISMISS_ON_CONFIRM_CLICK, this.f23658M);
                safetyKeyboardRequestParams.setParams(bundle);
                if (this.f23669b.showSafetyKeyboard(safetyKeyboardRequestParams, this.f23670c, this.f23664S, this.f23668a) != 0) {
                    this.f23664S = null;
                    return false;
                }
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
                this.f23664S = null;
                return false;
            }
        }
        return false;
    }
}
