package com.itextpdf.text.pdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public class CompareTool {
    private static String cannotOpenTargetDirectory = "Cannot open target directory for <filename>.";
    private static String differentPages = "File <filename> differs on page <pagenumber>.";
    private static String gsFailed = "GhostScript failed for <filename>.";
    private static String undefinedGsPath = "Path to GhostScript is not specified. Please use -DgsExec=<path_to_ghostscript> (e.g. -DgsExec=\"C:/Program Files/gs/gs8.64/bin/gswin32c.exe\")";
    private static String unexpectedNumberOfPages = "Unexpected number of pages for <filename>.";
    private String cmpImage;
    private String cmpPdf;
    private String cmpPdfName;
    private String compareExec;
    private String gsExec;
    private String outImage;
    private String outPdf;
    private String outPdfName;
    private String gsParams = " -dNOPAUSE -dBATCH -sDEVICE=png16m -r150 -sOutputFile=<outputfile> <inputfile>";
    private String compareParams = " <image1> <image2> <difference>";

    public CompareTool(String str, String str2) {
        init(str, str2);
        this.gsExec = System.getProperty("gsExec");
        this.compareExec = System.getProperty("compareExec");
    }

    public String compare(String str, String str2) throws IOException, InterruptedException {
        String str3 = this.gsExec;
        if (str3 == null || str3.length() == 0) {
            return undefinedGsPath;
        }
        File file = new File(str);
        int i = 0;
        if (!file.exists()) {
            file.mkdir();
        } else {
            for (File file2 : file.listFiles(new PngFileFilter())) {
                file2.delete();
            }
            for (File file3 : file.listFiles(new CmpPngFileFilter())) {
                file3.delete();
            }
        }
        File file4 = new File(str2);
        if (file4.exists()) {
            file4.delete();
        }
        if (file.exists()) {
            Process exec = Runtime.getRuntime().exec(this.gsExec + this.gsParams.replace("<outputfile>", str + this.cmpImage).replace("<inputfile>", this.cmpPdf));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                System.out.println(readLine);
            }
            bufferedReader.close();
            while (true) {
                String readLine2 = bufferedReader2.readLine();
                if (readLine2 == null) {
                    break;
                }
                System.out.println(readLine2);
            }
            bufferedReader2.close();
            if (exec.waitFor() == 0) {
                Process exec2 = Runtime.getRuntime().exec(this.gsExec + this.gsParams.replace("<outputfile>", str + this.outImage).replace("<inputfile>", this.outPdf));
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(exec2.getInputStream()));
                BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(exec2.getErrorStream()));
                while (true) {
                    String readLine3 = bufferedReader3.readLine();
                    if (readLine3 == null) {
                        break;
                    }
                    System.out.println(readLine3);
                }
                bufferedReader3.close();
                while (true) {
                    String readLine4 = bufferedReader4.readLine();
                    if (readLine4 == null) {
                        break;
                    }
                    System.out.println(readLine4);
                }
                bufferedReader4.close();
                if (exec2.waitFor() == 0) {
                    File[] listFiles = file.listFiles(new PngFileFilter());
                    File[] listFiles2 = file.listFiles(new CmpPngFileFilter());
                    boolean z = listFiles.length != listFiles2.length;
                    int min = Math.min(listFiles.length, listFiles2.length);
                    if (min <= 0) {
                        return "No files for comparing!!!\nThe result or sample pdf file is not processed by GhostScript.";
                    }
                    Arrays.sort(listFiles, new ImageNameComparator());
                    Arrays.sort(listFiles2, new ImageNameComparator());
                    while (i < min) {
                        PrintStream printStream = System.out;
                        StringBuilder sb = new StringBuilder("Comparing page ");
                        int i2 = i + 1;
                        sb.append(Integer.toString(i2));
                        sb.append(" (");
                        sb.append(listFiles[i].getAbsolutePath());
                        sb.append(")...");
                        printStream.print(sb.toString());
                        FileInputStream fileInputStream = new FileInputStream(listFiles[i]);
                        FileInputStream fileInputStream2 = new FileInputStream(listFiles2[i]);
                        boolean compareStreams = compareStreams(fileInputStream, fileInputStream2);
                        fileInputStream.close();
                        fileInputStream2.close();
                        if (!compareStreams) {
                            String replace = differentPages.replace("<filename>", this.outPdf).replace("<pagenumber>", Integer.toString(i2));
                            String str4 = this.compareExec;
                            if (str4 != null && str4.length() > 0) {
                                Process exec3 = Runtime.getRuntime().exec(this.compareExec + this.compareParams.replace("<image1>", listFiles[i].getAbsolutePath()).replace("<image2>", listFiles2[i].getAbsolutePath()).replace("<difference>", str2));
                                BufferedReader bufferedReader5 = new BufferedReader(new InputStreamReader(exec3.getErrorStream()));
                                while (true) {
                                    String readLine5 = bufferedReader5.readLine();
                                    if (readLine5 == null) {
                                        break;
                                    }
                                    System.out.println(readLine5);
                                }
                                bufferedReader5.close();
                                if (exec3.waitFor() == 0) {
                                    replace = replace + "\nPlease, examine " + str2 + " for more details.";
                                }
                            } else {
                                replace = replace + "\nYou can optionally specify path to ImageMagick compare tool (e.g. -DcompareExec=\"C:/Program Files/ImageMagick-6.5.4-2/compare.exe\") to visualize differences.";
                            }
                            if (z) {
                                return unexpectedNumberOfPages.replace("<filename>", this.outPdf) + "\n" + replace;
                            }
                            return replace;
                        }
                        System.out.println("done.");
                        i = i2;
                    }
                    return null;
                }
                return gsFailed.replace("<filename>", this.outPdf);
            }
            return gsFailed.replace("<filename>", this.cmpPdf);
        }
        return cannotOpenTargetDirectory.replace("<filename>", this.outPdf);
    }

    public String compare(String str, String str2, String str3, String str4) throws IOException, InterruptedException {
        init(str, str2);
        return compare(str3, str4);
    }

    private void init(String str, String str2) {
        this.outPdf = str;
        this.cmpPdf = str2;
        this.outPdfName = new File(str).getName();
        String str3 = this.outPdfName;
        str3.substring(0, str3.indexOf(46));
        this.cmpPdfName = new File(str2).getName();
        String str4 = this.cmpPdfName;
        str4.substring(0, str4.indexOf(46));
        this.outImage = this.outPdfName + "-%03d.png";
        this.cmpImage = "cmp_" + this.outPdfName + "-%03d.png";
    }

    private boolean compareStreams(InputStream inputStream, InputStream inputStream2) throws IOException {
        int read;
        byte[] bArr = new byte[65536];
        byte[] bArr2 = new byte[65536];
        do {
            int read2 = inputStream.read(bArr);
            read = inputStream2.read(bArr2);
            if (read2 != read || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
            if (read2 == -1) {
                return true;
            }
        } while (read != -1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PngFileFilter implements FileFilter {
        PngFileFilter() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String absolutePath = file.getAbsolutePath();
            return absolutePath.endsWith(".png") && !absolutePath.contains("cmp_") && absolutePath.contains(CompareTool.this.outPdfName);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CmpPngFileFilter implements FileFilter {
        CmpPngFileFilter() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String absolutePath = file.getAbsolutePath();
            return absolutePath.endsWith(".png") && absolutePath.contains("cmp_") && absolutePath.contains(CompareTool.this.cmpPdfName);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ImageNameComparator implements Comparator<File> {
        ImageNameComparator() {
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getAbsolutePath().compareTo(file2.getAbsolutePath());
        }
    }
}
