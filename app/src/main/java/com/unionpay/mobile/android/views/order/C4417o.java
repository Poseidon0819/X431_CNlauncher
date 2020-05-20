package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.views.order.AbstractMethod;
import com.unionpay.mobile.android.views.order.C4402b;
import com.unionpay.mobile.android.views.order.CViewMethods;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.views.order.o */
/* loaded from: classes2.dex */
public final class C4417o extends LinearLayout {

    /* renamed from: a */
    private Context f23286a;

    /* renamed from: b */
    private int f23287b;

    /* renamed from: c */
    private int f23288c;

    /* renamed from: d */
    private JSONObject f23289d;

    /* renamed from: e */
    private JSONObject f23290e;

    /* renamed from: f */
    private JSONObject f23291f;

    /* renamed from: g */
    private Drawable f23292g;

    /* renamed from: h */
    private JSONArray f23293h;

    /* renamed from: i */
    private List<Map<String, Object>> f23294i;

    /* renamed from: j */
    private String f23295j;

    /* renamed from: k */
    private AbstractMethod f23296k;

    /* renamed from: l */
    private CViewMethods f23297l;

    /* renamed from: m */
    private Drawable f23298m;

    /* renamed from: n */
    private boolean f23299n;

    /* renamed from: com.unionpay.mobile.android.views.order.o$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4418a extends AbstractMethod.InterfaceC4398a, AbstractMethod.InterfaceC4399b, CViewMethods.InterfaceC4400a, C4402b.InterfaceC4404b {
    }

    private C4417o(Context context) {
        super(context);
        this.f23287b = InterfaceC4414l.f23273a.intValue();
        this.f23288c = InterfaceC4414l.f23273a.intValue();
        this.f23286a = context;
        setOrientation(1);
    }

    /* renamed from: a */
    public static C4417o m761a(Context context, Drawable drawable) {
        C4417o c4417o = new C4417o(context);
        c4417o.f23292g = drawable;
        return c4417o;
    }

    /* renamed from: a */
    public static C4417o m760a(Context context, Drawable drawable, Drawable drawable2) {
        C4417o c4417o = new C4417o(context);
        c4417o.f23298m = drawable2;
        c4417o.f23287b = InterfaceC4414l.f23275c.intValue();
        c4417o.f23288c = InterfaceC4414l.f23275c.intValue();
        c4417o.f23292g = drawable;
        c4417o.m745c();
        return c4417o;
    }

    /* renamed from: a */
    public static C4417o m759a(Context context, JSONArray jSONArray, List<Map<String, Object>> list, Drawable drawable, Drawable drawable2, String str) {
        C4417o c4417o = new C4417o(context);
        c4417o.f23298m = drawable2;
        c4417o.f23287b = InterfaceC4414l.f23274b.intValue();
        c4417o.f23288c = InterfaceC4414l.f23274b.intValue();
        c4417o.f23292g = drawable;
        c4417o.f23293h = jSONArray;
        c4417o.f23294i = list;
        c4417o.f23295j = str;
        c4417o.m745c();
        return c4417o;
    }

    /* renamed from: b */
    public static C4417o m749b(Context context, JSONArray jSONArray, List<Map<String, Object>> list, Drawable drawable, Drawable drawable2, String str) {
        C4417o c4417o = new C4417o(context);
        c4417o.f23298m = drawable2;
        c4417o.f23287b = InterfaceC4414l.f23277e.intValue();
        c4417o.f23288c = InterfaceC4414l.f23277e.intValue();
        c4417o.f23292g = drawable;
        c4417o.f23293h = jSONArray;
        c4417o.f23294i = list;
        c4417o.f23295j = str;
        c4417o.m745c();
        return c4417o;
    }

    /* renamed from: a */
    public final int m763a() {
        return this.f23287b;
    }

    /* renamed from: a */
    public final C4417o m762a(int i) {
        this.f23288c = i;
        return this;
    }

    /* renamed from: a */
    public final C4417o m758a(Drawable drawable) {
        this.f23298m = drawable;
        return this;
    }

    /* renamed from: a */
    public final C4417o m757a(InterfaceC4418a interfaceC4418a) {
        AbstractMethod abstractMethod = this.f23296k;
        if (abstractMethod != null) {
            abstractMethod.m825a((AbstractMethod.InterfaceC4399b) interfaceC4418a);
            this.f23296k.m826a((AbstractMethod.InterfaceC4398a) interfaceC4418a);
            AbstractMethod abstractMethod2 = this.f23296k;
            if (abstractMethod2 instanceof C4402b) {
                ((C4402b) abstractMethod2).m804a((C4402b.InterfaceC4404b) interfaceC4418a);
            }
        }
        CViewMethods cViewMethods = this.f23297l;
        if (cViewMethods != null) {
            cViewMethods.m812a(interfaceC4418a);
        }
        return this;
    }

    /* renamed from: a */
    public final C4417o m756a(String str) {
        this.f23295j = str;
        return this;
    }

    /* renamed from: a */
    public final C4417o m755a(List<Map<String, Object>> list) {
        this.f23294i = list;
        return this;
    }

    /* renamed from: a */
    public final C4417o m754a(JSONArray jSONArray) {
        this.f23293h = jSONArray;
        return this;
    }

    /* renamed from: a */
    public final C4417o m753a(JSONObject jSONObject) {
        this.f23289d = jSONObject;
        AbstractMethod abstractMethod = this.f23296k;
        if (abstractMethod != null && (abstractMethod instanceof C4402b)) {
            ((C4402b) abstractMethod).m799a(this.f23289d);
        }
        return this;
    }

    /* renamed from: a */
    public final C4417o m752a(boolean z) {
        this.f23299n = z;
        return this;
    }

    /* renamed from: b */
    public final C4417o m750b(int i) {
        this.f23287b = i;
        return this;
    }

    /* renamed from: b */
    public final C4417o m748b(Drawable drawable) {
        AbstractMethod abstractMethod = this.f23296k;
        if (abstractMethod != null) {
            abstractMethod.m829a(drawable);
        }
        return this;
    }

    /* renamed from: b */
    public final C4417o m746b(JSONObject jSONObject) {
        this.f23290e = jSONObject;
        AbstractMethod abstractMethod = this.f23296k;
        if (abstractMethod != null && (abstractMethod instanceof C4411i)) {
            ((C4411i) abstractMethod).m780a(this.f23290e);
        }
        return this;
    }

    /* renamed from: b */
    public final String m751b() {
        AbstractMethod abstractMethod = this.f23296k;
        if (abstractMethod == null || !(abstractMethod instanceof C4411i)) {
            return null;
        }
        return ((C4411i) abstractMethod).m768h();
    }

    /* renamed from: b */
    public final void m747b(String str) {
        ((C4402b) this.f23296k).m795b(str);
    }

    /* renamed from: c */
    public final C4417o m743c(JSONObject jSONObject) {
        this.f23291f = jSONObject;
        AbstractMethod abstractMethod = this.f23296k;
        if (abstractMethod != null && (abstractMethod instanceof C4411i)) {
            ((C4411i) abstractMethod).m775b(this.f23291f);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x012d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x012e  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m745c() {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.views.order.C4417o.m745c():void");
    }

    /* renamed from: c */
    public final void m744c(int i) {
        AbstractMethod abstractMethod = this.f23296k;
        if (abstractMethod == null || !(abstractMethod instanceof C4402b)) {
            return;
        }
        ((C4402b) abstractMethod).m806a(i);
    }
}
