package com.baidu.mapapi.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
import com.baidu.mapapi.map.WearMapView;

/* loaded from: classes.dex */
public class SwipeDismissView extends RelativeLayout {

    /* renamed from: a */
    WearMapView.OnDismissCallback f5263a;

    public SwipeDismissView(Context context, AttributeSet attributeSet, int i, View view) {
        super(context, attributeSet, i);
        this.f5263a = null;
        m11140a(context, view);
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, View view) {
        super(context, attributeSet);
        this.f5263a = null;
        m11140a(context, view);
    }

    public SwipeDismissView(Context context, View view) {
        super(context);
        this.f5263a = null;
        m11140a(context, view);
    }

    /* renamed from: a */
    void m11140a(Context context, View view) {
        setOnTouchListener(new SwipeDismissTouchListener(view, new Object(), new SwipeDismissTouchListener.DismissCallbacks() { // from class: com.baidu.mapapi.map.SwipeDismissView.1
            @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
            public boolean canDismiss(Object obj) {
                return true;
            }

            @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
            public void onDismiss(View view2, Object obj) {
                if (SwipeDismissView.this.f5263a == null) {
                    return;
                }
                SwipeDismissView.this.f5263a.onDismiss();
            }

            @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
            public void onNotify() {
                if (SwipeDismissView.this.f5263a == null) {
                    return;
                }
                SwipeDismissView.this.f5263a.onNotify();
            }
        }));
    }

    public void setCallback(WearMapView.OnDismissCallback onDismissCallback) {
        this.f5263a = onDismissCallback;
    }
}
