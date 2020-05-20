package com.cnlaunch.p120d.p121a;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.Stack;

/* renamed from: com.cnlaunch.d.a.a */
/* loaded from: classes.dex */
public final class ActivityPageManager {

    /* renamed from: a */
    public static Stack<Activity> f6742a;

    /* renamed from: b */
    private static ActivityPageManager f6743b;

    /* renamed from: a */
    public static ActivityPageManager m9634a() {
        if (f6743b == null) {
            f6743b = new ActivityPageManager();
        }
        return f6743b;
    }

    /* renamed from: a */
    public static void m9633a(Activity activity) {
        if (f6742a == null) {
            f6742a = new Stack<>();
        }
        f6742a.add(activity);
    }

    /* renamed from: b */
    public static void m9628b(Activity activity) {
        if (f6742a == null) {
            f6742a = new Stack<>();
        }
        f6742a.remove(activity);
    }

    /* renamed from: b */
    public static void m9629b() {
        Stack<Activity> stack = f6742a;
        if (stack == null) {
            return;
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if (f6742a.get(i) != null) {
                f6742a.get(i).finish();
            }
        }
        f6742a.clear();
    }

    /* renamed from: a */
    public static void m9631a(View view) {
        if (view != null) {
            try {
                view.destroyDrawingCache();
                m9627b(view);
                if (view instanceof ViewGroup) {
                    m9630a((ViewGroup) view);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    private static void m9630a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            m9627b(childAt);
            if (childAt instanceof ViewGroup) {
                m9630a((ViewGroup) childAt);
            }
        }
        try {
            viewGroup.removeAllViews();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private static void m9627b(View view) {
        try {
            view.setOnClickListener(null);
            view.setOnCreateContextMenuListener(null);
            view.setOnFocusChangeListener(null);
            view.setOnKeyListener(null);
            view.setOnLongClickListener(null);
            view.setOnClickListener(null);
        } catch (Throwable unused) {
        }
        Drawable background = view.getBackground();
        if (background != null) {
            background.setCallback(null);
        }
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setCallback(null);
            }
            imageView.setImageDrawable(null);
            imageView.setBackgroundDrawable(null);
        }
        if (view instanceof WebView) {
            WebView webView = (WebView) view;
            webView.stopLoading();
            webView.clearFormData();
            webView.clearDisappearingChildren();
            webView.setWebChromeClient(null);
            webView.setWebViewClient(null);
            webView.destroyDrawingCache();
            webView.destroy();
        }
        if (view instanceof ListView) {
            ListView listView = (ListView) view;
            try {
                listView.removeAllViewsInLayout();
            } catch (Throwable unused2) {
            }
            listView.destroyDrawingCache();
        }
    }

    /* renamed from: a */
    public static void m9632a(Context context) {
        try {
            m9629b();
            ((ActivityManager) context.getSystemService("activity")).restartPackage(context.getPackageName());
            LruCacheManager.m9599a().f6972a.evictAll();
            CacheManager.m9606a();
            System.exit(0);
            Process.killProcess(Process.myPid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
