package message.p384g;

import android.content.SharedPreferences;
import android.os.Environment;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: message.g.b */
/* loaded from: classes2.dex */
public final class LogTracker {

    /* renamed from: a */
    private static ExecutorService f24039a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private static SimpleDateFormat f24040b = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");

    /* renamed from: c */
    private static File f24041c = new File(String.format("%s/%s/%s", Environment.getExternalStorageDirectory(), ApplicationConfig.f7802a.getPackageName(), "track"));

    /* renamed from: d */
    private static File f24042d = new File(f24041c, "total.txt");

    /* renamed from: e */
    private static File f24043e = new File(f24041c, "temp.txt");

    /* renamed from: f */
    private static SharedPreferences f24044f = ApplicationConfig.f7802a.getSharedPreferences("LogTracker", 0);

    /* renamed from: a */
    public static void m231a(String str, String str2) {
        f24039a.execute(new RunnableC4745c(String.format("%s: %s-> %s\n", f24040b.format(Long.valueOf(System.currentTimeMillis())), str, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m232a(String str, File file, boolean z) {
        try {
            FileWriter fileWriter = new FileWriter(file, z);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m235a(File file) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return !simpleDateFormat.format(new Date(file.lastModified())).equals(simpleDateFormat.format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m234a(File file, File file2) {
        m232a("\n===============================================\n", file2, true);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[10240];
            while (true) {
                int read = fileInputStream.read(bArr, 0, 10240);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return;
                }
            }
        } catch (IOException unused) {
        }
    }
}
