package com.launch.p353a.p359f;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.launch.p353a.p355b.AbstractBannerADListener;
import com.launch.p353a.p358e.AbstractInterstitialADListener;
import com.launch.p353a.p360g.NativeExpressADListener;
import com.launch.p353a.p361h.RunnableC3663d;
import com.launch.p353a.p363j.SplashADListener;
import com.launch.p353a.p364k.StringUtil;
import com.launch.p353a.p364k.UrlUtils;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* renamed from: com.launch.a.f.a */
/* loaded from: classes.dex */
public final class ClickManager implements View.OnClickListener {

    /* renamed from: a */
    public AbstractInterstitialADListener f19932a;

    /* renamed from: b */
    public NativeExpressADListener f19933b;

    /* renamed from: e */
    private Context f19936e;

    /* renamed from: f */
    private SplashADListener f19937f;

    /* renamed from: g */
    private View f19938g;

    /* renamed from: h */
    private String f19939h;

    /* renamed from: i */
    private String f19940i;

    /* renamed from: j */
    private TextView f19941j;

    /* renamed from: k */
    private int f19942k;

    /* renamed from: l */
    private AbstractBannerADListener f19943l;

    /* renamed from: c */
    public String f19934c = "01";

    /* renamed from: d */
    Runnable f19935d = new RunnableC3658c(this);

    /* renamed from: m */
    private Handler f19944m = new HandlerC3659d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* synthetic */ int m2661k(ClickManager clickManager) {
        int i = clickManager.f19942k;
        clickManager.f19942k = i - 1;
        return i;
    }

    public ClickManager(Context context, View view, String str, String str2) {
        this.f19936e = null;
        this.f19936e = context;
        this.f19938g = view;
        this.f19939h = str;
        this.f19940i = str2;
        this.f19938g.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (StringUtil.m2629a(this.f19940i)) {
            return;
        }
        RunnableC3663d runnableC3663d = new RunnableC3663d(this.f19936e);
        runnableC3663d.f19880c = UrlUtils.m2624b(this.f19939h);
        runnableC3663d.f19879b = "GET";
        runnableC3663d.f19959f = new C3657b(this);
        runnableC3663d.m2655a();
        if (this.f19934c.equals("01")) {
            String str = this.f19940i;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !"".equals(str) && str != null) {
                z = false;
            }
            if (z) {
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
                this.f19936e.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                throw new ActivityNotFoundException(e.getMessage());
            }
        }
    }
}
