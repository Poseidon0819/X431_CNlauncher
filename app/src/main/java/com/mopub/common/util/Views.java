package com.mopub.common.util;

import android.app.Activity;
import android.content.Context;
import android.support.p012v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.logging.MoPubLog;

/* loaded from: classes.dex */
public class Views {
    public static void removeFromParent(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public static View getTopmostView(Context context, View view) {
        View view2 = null;
        View findViewById = !(context instanceof Activity) ? null : ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        if (view != null) {
            if (!ViewCompat.m14657F(view)) {
                MoPubLog.m2498d("Attempting to call View#getRootView() on an unattached View.");
            }
            View rootView = view.getRootView();
            if (rootView != null && (view2 = rootView.findViewById(16908290)) == null) {
                view2 = rootView;
            }
        }
        return findViewById != null ? findViewById : view2;
    }
}
