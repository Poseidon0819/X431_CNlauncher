package com.cnlaunch.mycar.jni;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class FileUtils {
    private String SDPATH = Environment.getExternalStorageDirectory() + File.separator;

    public static void main(String[] strArr) {
    }

    public File createFileOnSD(String str) throws IOException {
        File file = new File(this.SDPATH + str);
        file.createNewFile();
        return file;
    }

    public File createDirOnSD(String str) throws IOException {
        File file = new File(this.SDPATH + str);
        file.mkdir();
        return file;
    }

    public static boolean isFileExist(String str) {
        return new File(str).exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public File writeToSDFromInput(String str, String str2, InputStream inputStream) {
        File file;
        FileOutputStream fileOutputStream = null;
        r0 = null;
        r0 = null;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        fileOutputStream = null;
        try {
            try {
                try {
                    createDirOnSD(str);
                    new File(this.SDPATH + ((String) str));
                    file = createFileOnSD(((String) str) + str2);
                    try {
                        FileOutputStream fileOutputStream4 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream4.write(bArr, 0, read);
                            }
                            fileOutputStream4.flush();
                            fileOutputStream4.close();
                            fileOutputStream = bArr;
                            str = file;
                        } catch (FileNotFoundException e) {
                            e = e;
                            fileOutputStream2 = fileOutputStream4;
                            e.printStackTrace();
                            fileOutputStream2.close();
                            fileOutputStream = fileOutputStream2;
                            str = file;
                            return str;
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream3 = fileOutputStream4;
                            e.printStackTrace();
                            fileOutputStream3.close();
                            fileOutputStream = fileOutputStream3;
                            str = file;
                            return str;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream4;
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                    } catch (IOException e5) {
                        e = e5;
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    file = null;
                } catch (IOException e7) {
                    e = e7;
                    file = null;
                }
            } catch (IOException e8) {
                e8.printStackTrace();
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String read(String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuffer.append(readLine + "\n");
            } else {
                bufferedReader.close();
                return stringBuffer.toString();
            }
        }
    }

    public void memoryInput(String str) throws IOException {
        StringReader stringReader = new StringReader(read(str));
        while (true) {
            int read = stringReader.read();
            if (read == -1) {
                return;
            }
            System.out.println((char) read);
        }
    }

    public static void readFileByBytes(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            while (true) {
                int read = fileInputStream.read();
                if (read == -1) {
                    break;
                }
                System.out.write(read);
            }
            fileInputStream.close();
            try {
                try {
                    byte[] bArr = new byte[100];
                    FileInputStream fileInputStream2 = new FileInputStream(str);
                    while (true) {
                        try {
                            int read2 = fileInputStream2.read(bArr);
                            if (read2 != -1) {
                                System.out.write(bArr, 0, read2);
                            } else {
                                try {
                                    fileInputStream2.close();
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            try {
                                fileInputStream.close();
                                return;
                            } catch (IOException unused2) {
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            try {
                                fileInputStream.close();
                            } catch (IOException unused3) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void readFileByChars(java.lang.String r8) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            r1 = -1
            r2 = 114(0x72, float:1.6E-43)
            r3 = 0
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L28
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L28
            r5.<init>(r0)     // Catch: java.lang.Exception -> L28
            r4.<init>(r5)     // Catch: java.lang.Exception -> L28
        L13:
            int r0 = r4.read()     // Catch: java.lang.Exception -> L26
            if (r0 == r1) goto L22
            char r0 = (char) r0     // Catch: java.lang.Exception -> L26
            if (r0 == r2) goto L13
            java.io.PrintStream r3 = java.lang.System.out     // Catch: java.lang.Exception -> L26
            r3.print(r0)     // Catch: java.lang.Exception -> L26
            goto L13
        L22:
            r4.close()     // Catch: java.lang.Exception -> L26
            goto L2d
        L26:
            r0 = move-exception
            goto L2a
        L28:
            r0 = move-exception
            r4 = r3
        L2a:
            r0.printStackTrace()
        L2d:
            r0 = 30
            char[] r3 = new char[r0]     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
        L3b:
            int r8 = r5.read(r3)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            if (r8 == r1) goto L60
            if (r8 != r0) goto L4f
            r4 = 29
            char r4 = r3[r4]     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            if (r4 == r2) goto L4f
            java.io.PrintStream r8 = java.lang.System.out     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r8.print(r3)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            goto L3b
        L4f:
            r4 = 0
        L50:
            if (r4 >= r8) goto L3b
            char r6 = r3[r4]     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            if (r6 == r2) goto L5d
            java.io.PrintStream r6 = java.lang.System.out     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            char r7 = r3[r4]     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r6.print(r7)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
        L5d:
            int r4 = r4 + 1
            goto L50
        L60:
            r5.close()     // Catch: java.io.IOException -> L63
        L63:
            return
        L64:
            r8 = move-exception
            goto L77
        L66:
            r8 = move-exception
            r4 = r5
            goto L6d
        L69:
            r8 = move-exception
            r5 = r4
            goto L77
        L6c:
            r8 = move-exception
        L6d:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L69
            if (r4 == 0) goto L76
            r4.close()     // Catch: java.io.IOException -> L75
        L75:
            return
        L76:
            return
        L77:
            if (r5 == 0) goto L7c
            r5.close()     // Catch: java.io.IOException -> L7c
        L7c:
            throw r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.mycar.jni.FileUtils.readFileByChars(java.lang.String):void");
    }

    public static void readFileByLines(String str) {
        File file = new File(str);
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                do {
                    try {
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } while (bufferedReader2.readLine() != null);
                bufferedReader2.close();
                try {
                    bufferedReader2.close();
                } catch (IOException unused3) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static void readFileByRandomAccess(String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    randomAccessFile.seek(randomAccessFile.length() > 4 ? 4 : 0);
                    byte[] bArr = new byte[10];
                    while (true) {
                        int read = randomAccessFile.read(bArr);
                        if (read != -1) {
                            System.out.write(bArr, 0, read);
                        } else {
                            try {
                                randomAccessFile.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    randomAccessFile2 = randomAccessFile;
                    e.printStackTrace();
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static void appendMethodA(String str, String str2) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.writeBytes(str2);
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendMethodB(String str, String str2) {
        try {
            FileWriter fileWriter = new FileWriter(str, true);
            fileWriter.write(str2);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final int byteArrayToShort(byte[] bArr) {
        return (bArr[0] << 8) + (bArr[1] & 255);
    }

    public static byte[] intToByteArray(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) ((i >>> ((3 - i2) * 8)) & 255);
        }
        return bArr;
    }

    public static final int byteArrayToInt(byte[] bArr) {
        return (bArr[0] << 24) + ((bArr[1] & 255) << 16) + ((bArr[2] & 255) << 8) + (bArr[3] & 255);
    }

    public static boolean sdCardIsMount() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static File sdCardGetDirectoryFile() {
        if (sdCardIsMount()) {
            return Environment.getExternalStorageDirectory();
        }
        return null;
    }

    public static String sdCardGetDirectoryPath() {
        return sdCardIsMount() ? Environment.getExternalStorageDirectory().getPath() : "";
    }

    public static int sdCardGetBlockSize() {
        if (sdCardIsMount()) {
            return new StatFs(sdCardGetDirectoryPath()).getBlockSize();
        }
        return -1;
    }

    public static int sdCardGetBlockCount() {
        if (sdCardIsMount()) {
            return new StatFs(sdCardGetDirectoryPath()).getBlockCount();
        }
        return -1;
    }

    public static int sdCardGetAvailableBlocks() {
        if (sdCardIsMount()) {
            return new StatFs(sdCardGetDirectoryPath()).getAvailableBlocks();
        }
        return -1;
    }

    public static int sdCardGetFreeBlocks() {
        if (sdCardIsMount()) {
            return new StatFs(sdCardGetDirectoryPath()).getFreeBlocks();
        }
        return -1;
    }

    public static int sdCardGetSizeAsMB() {
        if (sdCardIsMount()) {
            StatFs statFs = new StatFs(sdCardGetDirectoryPath());
            return ((statFs.getBlockSize() * statFs.getBlockCount()) / 1024) / 1024;
        }
        return -1;
    }

    public static int sdCardAvailableSizePercent() {
        if (sdCardIsMount()) {
            StatFs statFs = new StatFs(sdCardGetDirectoryPath());
            return (statFs.getAvailableBlocks() * 100) / statFs.getBlockCount();
        }
        return -1;
    }

    public static boolean DeleFile(String str) {
        return new File(str).delete();
    }

    public static long GetFileSize(String str) {
        return new File(str).length();
    }

    public static boolean saveFile(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return saveFile(str.getBytes("UTF-8"), str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean saveFile(byte[] bArr, String str) {
        if (bArr == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        try {
                            fileOutputStream2.close();
                            return true;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return true;
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return false;
                        }
                        return false;
                    } catch (IOException e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return false;
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e7) {
            e7.printStackTrace();
            return false;
        }
    }
}
