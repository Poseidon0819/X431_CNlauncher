package com.cnlaunch.x431pro.utils.p285e;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* renamed from: com.cnlaunch.x431pro.utils.e.d */
/* loaded from: classes.dex */
public final class ZipFileUtils {

    /* renamed from: a */
    private static FileInputStream f15859a;

    /* renamed from: a */
    public static void m4983a(String str, String str2) throws Exception {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
        File file = new File(str);
        m4982a(file.getParent() + File.separator, file.getName(), zipOutputStream);
        zipOutputStream.finish();
        zipOutputStream.close();
    }

    /* renamed from: a */
    private static void m4982a(String str, String str2, ZipOutputStream zipOutputStream) throws Exception {
        if (zipOutputStream == null) {
            return;
        }
        File file = new File(str + str2);
        if (file.isFile()) {
            ZipEntry zipEntry = new ZipEntry(str2);
            f15859a = new FileInputStream(file);
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = f15859a.read(bArr);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    zipOutputStream.closeEntry();
                    return;
                }
            }
        } else {
            String[] list = file.list();
            if (list.length <= 0) {
                zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                zipOutputStream.closeEntry();
            }
            for (int i = 0; i < list.length; i++) {
                m4982a(str, str2 + File.separator + list[i], zipOutputStream);
            }
        }
    }

    /* renamed from: a */
    public static void m4981a(Collection<File> collection, File file) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        for (File file2 : collection) {
            m4984a(file2, zipOutputStream, "");
        }
        zipOutputStream.close();
    }

    /* renamed from: a */
    private static void m4984a(File file, ZipOutputStream zipOutputStream, String str) throws FileNotFoundException, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.trim().length() == 0 ? "" : File.separator);
        sb.append(file.getName());
        String str2 = new String(sb.toString().getBytes(), "utf-8");
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                m4984a(file2, zipOutputStream, str2);
            }
            return;
        }
        byte[] bArr = new byte[1048576];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1048576);
        zipOutputStream.putNextEntry(new ZipEntry(str2));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
        }
    }
}
