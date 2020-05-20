package com.cnlaunch.p120d.p125c.p128c;

import android.util.Log;
import com.cnlaunch.p120d.p125c.p128c.SimpleMultipartEntity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: RequestParams.java */
/* renamed from: com.cnlaunch.d.c.c.i */
/* loaded from: classes.dex */
public final class C1426i {

    /* renamed from: a */
    protected boolean f7137a;

    /* renamed from: b */
    protected LinkedHashMap<String, String> f7138b;

    /* renamed from: c */
    protected ConcurrentHashMap<String, C1428b> f7139c;

    /* renamed from: d */
    protected ConcurrentHashMap<String, C1427a> f7140d;

    /* renamed from: e */
    protected ConcurrentHashMap<String, Object> f7141e;

    /* compiled from: RequestParams.java */
    /* renamed from: com.cnlaunch.d.c.c.i$b */
    /* loaded from: classes.dex */
    static class C1428b {

        /* renamed from: a */
        public InputStream f7144a;

        /* renamed from: b */
        public String f7145b;

        /* renamed from: c */
        public String f7146c;
    }

    public C1426i() {
        this((byte) 0);
    }

    private C1426i(byte b) {
        this.f7137a = false;
        this.f7138b = new LinkedHashMap<>();
        this.f7139c = new ConcurrentHashMap<>();
        this.f7140d = new ConcurrentHashMap<>();
        this.f7141e = new ConcurrentHashMap<>();
    }

    /* renamed from: a */
    public final void m9506a(String str, String str2) {
        if (str == null || str2 == null || "".equals(str2)) {
            return;
        }
        this.f7138b.put(str, str2);
    }

    /* renamed from: a */
    public final void m9509a(String str, File file) throws FileNotFoundException {
        m9508a(str, file, null);
    }

    /* renamed from: a */
    public final void m9508a(String str, File file, String str2) throws FileNotFoundException {
        if (str == null || file == null) {
            return;
        }
        this.f7140d.put(str, new C1427a(file, str2));
    }

    /* renamed from: a */
    public final void m9507a(String str, Object obj) {
        if (obj != null) {
            this.f7141e.put(str, obj);
        }
    }

    /* renamed from: a */
    public final Object m9510a(String str) {
        return this.f7138b.get(str);
    }

    /* renamed from: b */
    public final void m9504b(String str) {
        this.f7138b.remove(str);
        this.f7139c.remove(str);
        this.f7140d.remove(str);
        this.f7141e.remove(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f7138b.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, C1428b> entry2 : this.f7139c.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append("STREAM");
        }
        for (Map.Entry<String, C1427a> entry3 : this.f7140d.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry3.getKey());
            sb.append("=");
            sb.append("FILE");
        }
        for (BasicNameValuePair basicNameValuePair : m9503b(null, this.f7141e)) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(basicNameValuePair.getName());
            sb.append("=");
            sb.append(basicNameValuePair.getValue());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public final HttpEntity m9511a() throws IOException {
        if (this.f7139c.isEmpty() && this.f7140d.isEmpty()) {
            return m9501d();
        }
        SimpleMultipartEntity simpleMultipartEntity = new SimpleMultipartEntity();
        simpleMultipartEntity.f7153d = this.f7137a;
        for (Map.Entry<String, String> entry : this.f7138b.entrySet()) {
            simpleMultipartEntity.m9488a(entry.getKey(), entry.getValue());
        }
        for (BasicNameValuePair basicNameValuePair : m9503b(null, this.f7141e)) {
            simpleMultipartEntity.m9488a(basicNameValuePair.getName(), basicNameValuePair.getValue());
        }
        for (Map.Entry<String, C1428b> entry2 : this.f7139c.entrySet()) {
            C1428b value = entry2.getValue();
            if (value.f7144a != null) {
                String key = entry2.getKey();
                String str = value.f7145b;
                InputStream inputStream = value.f7144a;
                String str2 = value.f7146c;
                if (str2 == null) {
                    str2 = "application/octet-stream";
                }
                simpleMultipartEntity.f7155f.write(simpleMultipartEntity.f7152c);
                simpleMultipartEntity.f7155f.write(SimpleMultipartEntity.m9484b(key, str));
                simpleMultipartEntity.f7155f.write(SimpleMultipartEntity.m9489a(str2));
                simpleMultipartEntity.f7155f.write(SimpleMultipartEntity.f7150b);
                simpleMultipartEntity.f7155f.write(SimpleMultipartEntity.f7149a);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    simpleMultipartEntity.f7155f.write(bArr, 0, read);
                }
                simpleMultipartEntity.f7155f.write(SimpleMultipartEntity.f7149a);
                simpleMultipartEntity.f7155f.flush();
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.w("SimpleMultipartEntity", "Cannot close input stream", e);
                }
            }
        }
        for (Map.Entry<String, C1427a> entry3 : this.f7140d.entrySet()) {
            C1427a value2 = entry3.getValue();
            String key2 = entry3.getKey();
            File file = value2.f7142a;
            String str3 = value2.f7143b;
            if (str3 == null) {
                str3 = "application/octet-stream";
            }
            simpleMultipartEntity.f7154e.add(new SimpleMultipartEntity.C1429a(key2, file, str3));
        }
        return simpleMultipartEntity;
    }

    /* renamed from: d */
    private HttpEntity m9501d() {
        try {
            return new UrlEncodedFormEntity(m9500e(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* renamed from: e */
    private List<BasicNameValuePair> m9500e() {
        LinkedList linkedList = new LinkedList();
        ArrayList<String> arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.f7138b.entrySet()) {
            arrayList.add(entry.getKey());
        }
        Collections.sort(arrayList);
        for (String str : arrayList) {
            for (Map.Entry<String, String> entry2 : this.f7138b.entrySet()) {
                if (str.equals(entry2.getKey())) {
                    linkedList.add(new BasicNameValuePair(entry2.getKey(), entry2.getValue()));
                }
            }
        }
        linkedList.addAll(m9503b(null, this.f7141e));
        return linkedList;
    }

    /* renamed from: b */
    private List<BasicNameValuePair> m9503b(String str, Object obj) {
        LinkedList linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            ArrayList<String> arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            for (String str2 : arrayList) {
                Object obj2 = map.get(str2);
                if (obj2 != null) {
                    if (str != null) {
                        str2 = String.format("%s[%s]", str, str2);
                    }
                    linkedList.addAll(m9503b(str2, obj2));
                }
            }
        } else if (obj instanceof List) {
            for (Object obj3 : (List) obj) {
                linkedList.addAll(m9503b(String.format("%s[]", str), obj3));
            }
        } else if (obj instanceof Object[]) {
            for (Object obj4 : (Object[]) obj) {
                linkedList.addAll(m9503b(String.format("%s[]", str), obj4));
            }
        } else if (obj instanceof Set) {
            for (Object obj5 : (Set) obj) {
                linkedList.addAll(m9503b(str, obj5));
            }
        } else if (obj instanceof String) {
            linkedList.add(new BasicNameValuePair(str, (String) obj));
        }
        return linkedList;
    }

    /* renamed from: b */
    public final String m9505b() {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair nameValuePair : m9500e()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(nameValuePair.getName());
            sb.append("=");
            sb.append(nameValuePair.getValue());
        }
        return sb.toString();
    }

    /* renamed from: c */
    public final String m9502c() {
        StringBuilder sb = new StringBuilder();
        for (BasicNameValuePair basicNameValuePair : m9500e()) {
            sb.append(basicNameValuePair.getValue());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestParams.java */
    /* renamed from: com.cnlaunch.d.c.c.i$a */
    /* loaded from: classes.dex */
    public static class C1427a {

        /* renamed from: a */
        public File f7142a;

        /* renamed from: b */
        public String f7143b;

        public C1427a(File file, String str) {
            this.f7142a = file;
            this.f7143b = str;
        }
    }
}
