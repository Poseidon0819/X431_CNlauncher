package com.unionpay;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.unionpay.utils.C4644b;
import com.unionpay.utils.C4652j;
import com.unionpay.utils.UPUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* renamed from: com.unionpay.a */
/* loaded from: classes2.dex */
final class C4117a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String str;
        Context context2;
        boolean m1672c;
        String str2;
        String str3;
        String str4;
        BroadcastReceiver broadcastReceiver;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        long longExtra = intent.getLongExtra("extra_download_id", -1L);
        long m467c = UPUtils.m467c(context, "id");
        if (m467c == longExtra) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            Uri uriForDownloadedFile = downloadManager.getUriForDownloadedFile(m467c);
            String str5 = "";
            if (uriForDownloadedFile != null) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(new File(uriForDownloadedFile.getPath()));
                    String absolutePath = context.getFilesDir().getAbsolutePath();
                    if (absolutePath != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(absolutePath);
                        sb.append(File.separator);
                        str3 = UPPayAssistEx.f21993N;
                        sb.append(str3);
                        str5 = sb.toString();
                        str4 = UPPayAssistEx.f21993N;
                        FileOutputStream openFileOutput = context.openFileOutput(str4, 1);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            openFileOutput.write(bArr, 0, read);
                        }
                        openFileOutput.close();
                        fileInputStream.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    str5 = uriForDownloadedFile.getPath();
                }
                try {
                    String m458b = C4644b.m458b(str5);
                    str = UPPayAssistEx.f21991L;
                    if (str.equalsIgnoreCase(m458b)) {
                        context2 = UPPayAssistEx.f21986G;
                        m1672c = UPPayAssistEx.m1672c(context2);
                        if (!m1672c) {
                            Uri parse = Uri.parse("file:".concat(String.valueOf(str5)));
                            str2 = UPPayAssistEx.f21998S;
                            intent2.setDataAndType(parse, str2);
                            intent2.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
                            context.startActivity(intent2);
                        }
                    } else {
                        C4644b.m456c(uriForDownloadedFile.getPath());
                    }
                } catch (FileNotFoundException unused) {
                }
                C4652j.m432b("uppay", "downloadFileUri".concat(String.valueOf(uriForDownloadedFile)));
            }
            broadcastReceiver = UPPayAssistEx.f22004Y;
            context.unregisterReceiver(broadcastReceiver);
            UPPayAssistEx.m1666f();
        }
    }
}
