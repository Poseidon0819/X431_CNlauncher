package com.cnlaunch.golo3.view.selectimg;

import android.os.Environment;
import java.io.File;

/* renamed from: com.cnlaunch.golo3.view.selectimg.j */
/* loaded from: classes.dex */
public interface FileConstant {

    /* renamed from: a */
    public static final String f8689a = Environment.getExternalStorageDirectory() + "/cnlaunch/";

    /* renamed from: b */
    public static final String f8690b = f8689a + "/golo3/logos/";

    /* renamed from: c */
    public static final String f8691c = f8689a + "event reporting image/";

    /* renamed from: d */
    public static final String f8692d = f8689a + "selectImgFile/";

    /* renamed from: e */
    public static final String f8693e = f8689a + "ecologyImgFile/";

    /* renamed from: f */
    public static final String f8694f = f8689a + "printHistoryPDFTempFile/";

    /* renamed from: g */
    public static final String f8695g = File.separator + "cnlaunch" + File.separator + "golo_master_cn" + File.separator + "%s" + File.separator;

    /* renamed from: h */
    public static final String f8696h;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f8689a);
        sb.append(File.separator);
        sb.append("golo_master_cn");
        sb.append(File.separator);
        f8696h = sb.toString();
    }
}
