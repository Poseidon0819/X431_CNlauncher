package com.cnlaunch.x431pro.utils.p285e;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.utils.e.b */
/* loaded from: classes.dex */
public final class IniFile {

    /* renamed from: a */
    Map<String, C2764a> f15852a;

    /* renamed from: b */
    File f15853b;

    /* renamed from: c */
    private String f15854c;

    /* renamed from: d */
    private String f15855d;

    /* compiled from: IniFile.java */
    /* renamed from: com.cnlaunch.x431pro.utils.e.b$a */
    /* loaded from: classes.dex */
    public class C2764a {

        /* renamed from: a */
        String f15856a;

        /* renamed from: b */
        Map<String, Object> f15857b = new LinkedHashMap();

        public C2764a() {
        }

        /* renamed from: a */
        public final void m4985a(String str, Object obj) {
            this.f15857b.put(str, obj);
        }

        /* renamed from: a */
        public final Object m4986a(String str) {
            return this.f15857b.get(str);
        }

        public final String toString() {
            return "Section [name=" + this.f15856a + ", values=" + this.f15857b + "]";
        }
    }

    /* renamed from: a */
    public final Object m4987a(String str, String str2) {
        Object m4986a;
        C2764a c2764a = this.f15852a.get(str);
        if (c2764a == null || (m4986a = c2764a.m4986a(str2)) == null || m4986a.toString().trim().equals("")) {
            return null;
        }
        return m4986a;
    }

    public IniFile() {
        this.f15854c = null;
        this.f15855d = "UTF-8";
        this.f15852a = new LinkedHashMap();
        this.f15853b = null;
    }

    public IniFile(File file) {
        this.f15854c = null;
        this.f15855d = "UTF-8";
        this.f15852a = new LinkedHashMap();
        this.f15853b = null;
        this.f15853b = file;
        try {
            m4989a(new BufferedReader(new FileReader(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m4989a(BufferedReader bufferedReader) {
        C2764a c2764a = null;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String trim = readLine.trim();
                    if (trim.matches("\\[.*\\]")) {
                        c2764a = new C2764a();
                        c2764a.f15856a = trim.substring(1, trim.length() - 1);
                        this.f15852a.put(c2764a.f15856a, c2764a);
                    } else {
                        String[] split = trim.split("=");
                        if (split.length == 2) {
                            c2764a.m4985a(split[0], split[1]);
                        }
                    }
                } else {
                    bufferedReader.close();
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m4988a(BufferedWriter bufferedWriter) {
        boolean z = false;
        try {
            z = (this.f15854c == null || this.f15854c.trim().equals("")) ? true : true;
            for (C2764a c2764a : this.f15852a.values()) {
                bufferedWriter.write("[" + c2764a.f15856a + "]");
                if (!z) {
                    bufferedWriter.write(this.f15854c);
                } else {
                    bufferedWriter.newLine();
                }
                for (Map.Entry<String, Object> entry : c2764a.f15857b.entrySet()) {
                    bufferedWriter.write(entry.getKey());
                    bufferedWriter.write("=");
                    bufferedWriter.write(entry.getValue().toString());
                    if (!z) {
                        bufferedWriter.write(this.f15854c);
                    } else {
                        bufferedWriter.newLine();
                    }
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
