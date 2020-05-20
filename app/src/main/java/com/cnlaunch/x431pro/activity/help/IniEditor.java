package com.cnlaunch.x431pro.activity.help;

import android.annotation.SuppressLint;
import com.itextpdf.text.html.HtmlTags;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.http.conn.ssl.TokenParser;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.help.l */
/* loaded from: classes.dex */
public final class IniEditor {

    /* renamed from: b */
    private static boolean f12813b = false;

    /* renamed from: h */
    private static final InterfaceC2261b f12814h = new C2266m();

    /* renamed from: a */
    String f12815a;

    /* renamed from: c */
    private Map<String, C2265f> f12816c;

    /* renamed from: d */
    private List<String> f12817d;

    /* renamed from: e */
    private char[] f12818e;

    /* renamed from: f */
    private boolean f12819f;

    /* renamed from: g */
    private C2264e f12820g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IniEditor.java */
    /* renamed from: com.cnlaunch.x431pro.activity.help.l$b */
    /* loaded from: classes.dex */
    public interface InterfaceC2261b {
        String toString();
    }

    public IniEditor() {
        this((byte) 0);
    }

    private IniEditor(byte b) {
        this(f12813b);
    }

    private IniEditor(boolean z) {
        this.f12816c = new HashMap();
        this.f12817d = new LinkedList();
        this.f12819f = z;
        this.f12818e = null;
        this.f12820g = new C2264e("%s %s %s");
    }

    /* renamed from: a */
    public final boolean m6900a(String str) {
        return this.f12816c.containsKey(m6897d(str));
    }

    /* renamed from: b */
    public final boolean m6899b(String str) {
        String m6897d = m6897d(str);
        if (m6900a(m6897d)) {
            return false;
        }
        C2265f c2265f = new C2265f(m6897d, this.f12818e, this.f12819f);
        c2265f.f12832a = this.f12820g;
        this.f12816c.put(m6897d, c2265f);
        this.f12817d.add(m6897d);
        return true;
    }

    /* renamed from: a */
    public final void m6901a(OutputStreamWriter outputStreamWriter) throws IOException {
        PrintWriter printWriter = new PrintWriter((Writer) outputStreamWriter, true);
        for (String str : this.f12817d) {
            C2265f m6898c = m6898c(str);
            printWriter.println(C2265f.m6894a(m6898c));
            m6898c.m6892a(printWriter);
        }
    }

    /* renamed from: a */
    public final void m6904a(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        m6903a(fileInputStream);
        fileInputStream.close();
    }

    /* renamed from: a */
    private void m6903a(InputStream inputStream) throws IOException {
        m6902a(new InputStreamReader(inputStream));
    }

    /* renamed from: a */
    private void m6902a(InputStreamReader inputStreamReader) throws IOException {
        int indexOf;
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        while (bufferedReader.ready()) {
            String trim = bufferedReader.readLine().trim();
            if (trim.length() > 0 && trim.charAt(0) == '[' && (indexOf = trim.indexOf(93)) >= 0) {
                str = trim.substring(1, indexOf);
                m6899b(str);
            }
            if (str != null) {
                m6898c(str).m6893a(bufferedReader);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final C2265f m6898c(String str) {
        return this.f12816c.get(m6897d(str));
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: d */
    private String m6897d(String str) {
        if (!this.f12819f) {
            str = str.toLowerCase();
        }
        return str.trim();
    }

    /* compiled from: IniEditor.java */
    /* renamed from: com.cnlaunch.x431pro.activity.help.l$f */
    /* loaded from: classes.dex */
    public static class C2265f {

        /* renamed from: j */
        private static final char[] f12828j = {SignatureVisitor.INSTANCEOF, ':'};

        /* renamed from: k */
        private static final char[] f12829k = {'#', ';'};

        /* renamed from: l */
        private static final char[] f12830l = {TokenParser.f24154SP, '\t'};

        /* renamed from: m */
        private static final char[] f12831m = {'[', ']'};

        /* renamed from: a */
        C2264e f12832a;

        /* renamed from: b */
        private String f12833b;

        /* renamed from: c */
        private Map<String, C2263d> f12834c;

        /* renamed from: d */
        private List<InterfaceC2261b> f12835d;

        /* renamed from: e */
        private char[] f12836e;

        /* renamed from: f */
        private char[] f12837f;

        /* renamed from: g */
        private char[] f12838g;

        /* renamed from: h */
        private char[] f12839h;

        /* renamed from: i */
        private boolean f12840i;

        public C2265f(String str, char[] cArr, boolean z) {
            if (!m6886d(str)) {
                throw new IllegalArgumentException("Illegal section name:".concat(String.valueOf(str)));
            }
            this.f12833b = str;
            this.f12840i = z;
            this.f12834c = new HashMap();
            this.f12835d = new LinkedList();
            this.f12836e = f12828j;
            this.f12838g = cArr == null ? f12829k : cArr;
            this.f12832a = new C2264e("%s %s %s");
            char[] cArr2 = this.f12836e;
            this.f12837f = new char[cArr2.length];
            System.arraycopy(cArr2, 0, this.f12837f, 0, cArr2.length);
            char[] cArr3 = this.f12838g;
            this.f12839h = new char[cArr3.length];
            System.arraycopy(cArr3, 0, this.f12839h, 0, cArr3.length);
            Arrays.sort(this.f12837f);
            Arrays.sort(this.f12839h);
        }

        /* renamed from: a */
        public final boolean m6891a(String str) {
            return this.f12834c.containsKey(m6885e(str));
        }

        /* renamed from: b */
        public final String m6888b(String str) {
            String m6885e = m6885e(str);
            if (m6891a(m6885e)) {
                return m6887c(m6885e).f12823a;
            }
            return null;
        }

        /* renamed from: a */
        public final void m6890a(String str, String str2) {
            m6889a(str, str2, this.f12836e[0]);
        }

        /* renamed from: a */
        private void m6889a(String str, String str2, char c) {
            String m6885e = m6885e(str);
            if (m6891a(m6885e)) {
                m6887c(m6885e).m6896a(str2);
                return;
            }
            C2263d c2263d = new C2263d(m6885e, str2, c, this.f12832a);
            this.f12834c.put(m6885e, c2263d);
            this.f12835d.add(c2263d);
        }

        /* renamed from: a */
        public final void m6893a(BufferedReader bufferedReader) throws IOException {
            while (bufferedReader.ready()) {
                bufferedReader.mark(1024);
                String trim = bufferedReader.readLine().trim();
                if (trim.length() > 0 && trim.charAt(0) == '[') {
                    bufferedReader.reset();
                    return;
                } else if (trim.equals("")) {
                    this.f12835d.add(IniEditor.f12814h);
                } else {
                    int binarySearch = Arrays.binarySearch(this.f12839h, trim.charAt(0));
                    if (binarySearch >= 0) {
                        String substring = trim.substring(1);
                        char c = this.f12839h[binarySearch];
                        StringTokenizer stringTokenizer = new StringTokenizer(substring.trim(), "\n\r");
                        while (stringTokenizer.hasMoreTokens()) {
                            this.f12835d.add(new C2260a(stringTokenizer.nextToken(), c));
                        }
                    } else {
                        int length = trim.length();
                        int i = -1;
                        int i2 = -1;
                        for (int i3 = 0; i3 < length && i < 0; i3++) {
                            if (Arrays.binarySearch(this.f12837f, trim.charAt(i3)) < 0) {
                                boolean z = Arrays.binarySearch(f12830l, trim.charAt(i3)) >= 0;
                                if (!z && i2 >= 0) {
                                    break;
                                } else if (z) {
                                    i2 = i3;
                                }
                            } else {
                                i = i3;
                            }
                        }
                        if (i != 0) {
                            if (i >= 0) {
                                m6889a(trim.substring(0, i), trim.substring(i + 1), trim.charAt(i));
                            } else if (i2 < 0) {
                                m6890a(trim, "");
                            } else {
                                m6890a(trim.substring(0, i2), trim.substring(i2 + 1));
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public final void m6892a(PrintWriter printWriter) throws IOException {
            for (InterfaceC2261b interfaceC2261b : this.f12835d) {
                printWriter.println(interfaceC2261b.toString());
            }
            if (printWriter.checkError()) {
                throw new IOException();
            }
        }

        /* renamed from: c */
        private C2263d m6887c(String str) {
            return this.f12834c.get(str);
        }

        /* renamed from: d */
        private static boolean m6886d(String str) {
            if (str.trim().equals("")) {
                return false;
            }
            int i = 0;
            while (true) {
                char[] cArr = f12831m;
                if (i >= cArr.length) {
                    return true;
                }
                if (str.indexOf(cArr[i]) >= 0) {
                    return false;
                }
                i++;
            }
        }

        /* renamed from: e */
        private String m6885e(String str) {
            if (!this.f12840i) {
                str = str.toLowerCase();
            }
            return str.trim();
        }

        /* renamed from: a */
        static /* synthetic */ String m6894a(C2265f c2265f) {
            return "[" + c2265f.f12833b + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IniEditor.java */
    /* renamed from: com.cnlaunch.x431pro.activity.help.l$d */
    /* loaded from: classes.dex */
    public static class C2263d implements InterfaceC2261b {

        /* renamed from: a */
        String f12823a;

        /* renamed from: b */
        private String f12824b;

        /* renamed from: c */
        private char f12825c;

        /* renamed from: d */
        private C2264e f12826d;

        public C2263d(String str, String str2, char c, C2264e c2264e) {
            boolean z = false;
            if (!str.trim().equals("") && str.indexOf(c) < 0) {
                z = true;
            }
            if (!z) {
                throw new IllegalArgumentException("Illegal option name:".concat(String.valueOf(str)));
            }
            this.f12824b = str;
            this.f12825c = c;
            this.f12826d = c2264e;
            m6896a(str2);
        }

        /* renamed from: a */
        public final void m6896a(String str) {
            if (str == null) {
                this.f12823a = str;
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str.trim(), "\n\r");
            StringBuffer stringBuffer = new StringBuffer();
            while (stringTokenizer.hasMoreTokens()) {
                stringBuffer.append(stringTokenizer.nextToken());
            }
            this.f12823a = stringBuffer.toString();
        }

        @Override // com.cnlaunch.x431pro.activity.help.IniEditor.InterfaceC2261b
        public final String toString() {
            C2264e c2264e = this.f12826d;
            String str = this.f12824b;
            String str2 = this.f12823a;
            char c = this.f12825c;
            String[] strArr = c2264e.f12827a;
            return strArr[0] + str + strArr[1] + c + strArr[2] + str2 + strArr[3];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IniEditor.java */
    /* renamed from: com.cnlaunch.x431pro.activity.help.l$a */
    /* loaded from: classes.dex */
    public static class C2260a implements InterfaceC2261b {

        /* renamed from: a */
        private String f12821a;

        /* renamed from: b */
        private char f12822b;

        public C2260a(String str, char c) {
            this.f12821a = str.trim();
            this.f12822b = c;
        }

        @Override // com.cnlaunch.x431pro.activity.help.IniEditor.InterfaceC2261b
        public final String toString() {
            return this.f12822b + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f12821a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IniEditor.java */
    /* renamed from: com.cnlaunch.x431pro.activity.help.l$e */
    /* loaded from: classes.dex */
    public static class C2264e {

        /* renamed from: a */
        String[] f12827a;

        public C2264e(String str) {
            this.f12827a = m6895a(str);
        }

        /* renamed from: a */
        private static String[] m6895a(String str) {
            String[] strArr = new String[4];
            strArr[0] = "";
            strArr[1] = "";
            strArr[2] = "";
            strArr[3] = "";
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt != '%') {
                    if (charAt != 's') {
                        if (z) {
                            throw new IllegalArgumentException("Illegal option format. Unknown format specifier.");
                        }
                        stringBuffer.append(str.charAt(i2));
                    } else if (!z) {
                        stringBuffer.append(HtmlTags.f19633S);
                    } else if (i >= 4) {
                        throw new IllegalArgumentException("Illegal option format. Too many %s placeholders.");
                    } else {
                        strArr[i] = stringBuffer.toString();
                        i++;
                        stringBuffer = new StringBuffer();
                        z = false;
                    }
                } else if (z) {
                    stringBuffer.append("%");
                    z = false;
                } else {
                    z = true;
                }
            }
            if (i != 3) {
                throw new IllegalArgumentException("Illegal option format. Not enough %s placeholders.");
            }
            strArr[i] = stringBuffer.toString();
            return strArr;
        }
    }

    /* compiled from: IniEditor.java */
    /* renamed from: com.cnlaunch.x431pro.activity.help.l$c */
    /* loaded from: classes.dex */
    public static class C2262c extends RuntimeException {
        private static final long serialVersionUID = 1;

        public C2262c() {
        }

        public C2262c(String str) {
            super(str);
        }
    }
}
