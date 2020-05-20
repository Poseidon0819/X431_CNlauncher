package message.p381d;

import android.os.Environment;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import java.io.File;

/* renamed from: message.d.b */
/* loaded from: classes2.dex */
public final class MediaProvider {
    /* renamed from: a */
    public static File m290a(String str, String str2) {
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/cnlaunch/golo3/" + ApplicationConfig.m9181a() + str);
        if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
            File file2 = new File(file, str2);
            int i = 0;
            while (file2.exists() && file2.isFile()) {
                file2 = new File(file, str2 + "(" + i + ")");
                i++;
            }
            return file2;
        }
        return null;
    }
}
