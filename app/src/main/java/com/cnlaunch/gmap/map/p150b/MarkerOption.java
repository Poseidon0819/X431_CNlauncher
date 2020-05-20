package com.cnlaunch.gmap.map.p150b;

import android.view.View;
import com.cnlaunch.gmap.map.logic.p153a.LcLatlng;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.cnlaunch.gmap.map.b.q */
/* loaded from: classes.dex */
public final class MarkerOption implements Cloneable {

    /* renamed from: a */
    public boolean f7580a;

    /* renamed from: b */
    public LcLatlng f7581b;

    /* renamed from: c */
    public int f7582c;

    /* renamed from: d */
    public View f7583d;

    /* renamed from: e */
    public float f7584e = ColumnText.GLOBAL_SPACE_CHAR_RATIO;

    /* renamed from: f */
    public float f7585f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;

    /* renamed from: g */
    public float f7586g = ColumnText.GLOBAL_SPACE_CHAR_RATIO;

    /* renamed from: h */
    public int f7587h;

    /* renamed from: i */
    public String f7588i;

    public final Object clone() {
        try {
            return (MarkerOption) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
