package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class AdRequestStatusMapping {

    /* renamed from: a */
    final Map<String, C3718a> f20268a = new TreeMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.AdRequestStatusMapping$b */
    /* loaded from: classes.dex */
    public enum EnumC3719b {
        LOADING,
        LOADED,
        PLAYED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2475a(String str) {
        this.f20268a.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m2474b(String str) {
        this.f20268a.put(str, new C3718a(EnumC3719b.LOADING));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean m2473c(String str) {
        C3718a c3718a = this.f20268a.get(str);
        return c3718a != null && EnumC3719b.LOADED.equals(c3718a.f20269a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean m2472d(String str) {
        return this.f20268a.containsKey(str) && this.f20268a.get(str).f20269a == EnumC3719b.LOADING;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final String m2471e(String str) {
        if (this.f20268a.containsKey(str)) {
            return this.f20268a.get(str).f20270b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.AdRequestStatusMapping$a */
    /* loaded from: classes.dex */
    public static class C3718a {

        /* renamed from: a */
        EnumC3719b f20269a;

        /* renamed from: b */
        String f20270b;

        /* renamed from: c */
        String f20271c;

        /* renamed from: d */
        String f20272d;

        public C3718a(EnumC3719b enumC3719b) {
            this(enumC3719b, null, null, null);
        }

        public C3718a(EnumC3719b enumC3719b, String str, String str2, String str3) {
            Preconditions.checkNotNull(enumC3719b);
            this.f20269a = enumC3719b;
            this.f20270b = str;
            this.f20271c = str2;
            this.f20272d = str3;
        }

        public final boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof C3718a) {
                C3718a c3718a = (C3718a) obj;
                return this.f20269a.equals(c3718a.f20269a) && TextUtils.equals(this.f20270b, c3718a.f20270b) && TextUtils.equals(this.f20271c, c3718a.f20271c) && TextUtils.equals(this.f20272d, c3718a.f20272d);
            }
            return false;
        }

        public final int hashCode() {
            int ordinal = (this.f20269a.ordinal() + 899) * 31;
            String str = this.f20270b;
            int hashCode = (ordinal + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f20271c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f20272d;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }
    }
}
