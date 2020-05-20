package message.p384g;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.widget.Toast;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p165g.SignatureTool;
import java.io.File;
import java.util.List;

/* renamed from: message.g.f */
/* loaded from: classes2.dex */
public final class MsgUtils {

    /* renamed from: a */
    private static Toast f24052a;

    /* renamed from: b */
    private static Runnable f24053b = new RunnableC4746g();

    /* renamed from: c */
    private static Handler f24054c = new Handler(ApplicationConfig.f7802a.getMainLooper());

    /* renamed from: a */
    public static void m221a(String str, Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(new File(str)));
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public static boolean m222a(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(1000);
        if (runningServices.size() <= 0) {
            return false;
        }
        for (int size = runningServices.size() - 1; size >= 0; size--) {
            if (runningServices.get(size).service.getClassName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m220a(String str, String str2) {
        try {
            return SignatureTool.m9124a("app_id=app1&user_id=" + str + str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
