package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Drawables;
import java.util.Map;

/* loaded from: classes2.dex */
public class NativeRendererHelper {
    public static void addTextView(TextView textView, String str) {
        if (textView == null) {
            MoPubLog.m2498d("Attempted to add text (" + str + ") to null TextView.");
            return;
        }
        textView.setText((CharSequence) null);
        if (str == null) {
            MoPubLog.m2498d("Attempted to set TextView contents to null.");
        } else {
            textView.setText(str);
        }
    }

    public static void addPrivacyInformationIcon(ImageView imageView, String str, String str2) {
        if (imageView == null) {
            return;
        }
        if (str2 == null) {
            imageView.setImageDrawable(null);
            imageView.setOnClickListener(null);
            imageView.setVisibility(4);
            return;
        }
        Context context = imageView.getContext();
        if (context == null) {
            return;
        }
        if (str == null) {
            imageView.setImageDrawable(Drawables.NATIVE_PRIVACY_INFORMATION_ICON.createDrawable(context));
        } else {
            NativeImageHelper.loadImageView(str, imageView);
        }
        imageView.setOnClickListener(new View$OnClickListenerC3870an(context, str2));
        imageView.setVisibility(0);
    }

    public static void addCtaButton(TextView textView, View view, String str) {
        addTextView(textView, str);
        if (textView == null || view == null) {
            return;
        }
        textView.setOnClickListener(new View$OnClickListenerC3871ao(view));
    }

    public static void updateExtras(View view, Map<String, Integer> map, Map<String, Object> map2) {
        if (view == null) {
            MoPubLog.m2490w("Attempted to bind extras on a null main view.");
            return;
        }
        for (String str : map.keySet()) {
            View findViewById = view.findViewById(map.get(str).intValue());
            Object obj = map2.get(str);
            if (findViewById instanceof ImageView) {
                ImageView imageView = (ImageView) findViewById;
                imageView.setImageDrawable(null);
                Object obj2 = map2.get(str);
                if (obj2 != null && (obj2 instanceof String)) {
                    NativeImageHelper.loadImageView((String) obj2, imageView);
                }
            } else if (findViewById instanceof TextView) {
                TextView textView = (TextView) findViewById;
                textView.setText((CharSequence) null);
                if (obj instanceof String) {
                    addTextView(textView, (String) obj);
                }
            } else {
                MoPubLog.m2498d("View bound to " + str + " should be an instance of TextView or ImageView.");
            }
        }
    }
}
