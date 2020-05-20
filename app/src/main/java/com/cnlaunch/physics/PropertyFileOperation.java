package com.cnlaunch.physics;

import android.util.Pair;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.cnlaunch.physics.n */
/* loaded from: classes.dex */
public final class PropertyFileOperation {

    /* renamed from: a */
    private ConcurrentHashMap<String, String> f10146a = new ConcurrentHashMap<>();

    /* renamed from: b */
    private String f10147b;

    public PropertyFileOperation(String str) {
        this.f10147b = str;
        Properties m8091a = m8091a();
        if (C1856n.f10135a) {
            StringBuilder sb = new StringBuilder();
            Enumeration<?> propertyNames = m8091a.propertyNames();
            sb.append("PropertyFileOperation file init (key) collenction:");
            while (propertyNames.hasMoreElements()) {
                sb.append(String.format("(%s),", propertyNames.nextElement().toString()));
            }
            C1856n.m8130a("PropertyFileOperation", sb.toString());
        }
        Enumeration<?> propertyNames2 = m8091a.propertyNames();
        while (propertyNames2.hasMoreElements()) {
            String obj = propertyNames2.nextElement().toString();
            this.f10146a.put(obj, m8091a.getProperty(obj));
        }
        if (C1856n.f10135a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("PropertyFileOperation file (key,value) collenction:");
            for (Map.Entry<String, String> entry : this.f10146a.entrySet()) {
                sb2.append(String.format("(%s,%s),", entry.getKey(), entry.getValue()));
            }
            C1856n.m8130a("PropertyFileOperation", sb2.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final boolean m8088a(List<Pair<String, String>> list) {
        synchronized (this) {
            if (C1856n.f10135a) {
                StringBuilder sb = new StringBuilder();
                sb.append("PropertyFileOperation pair List (key,value) collenction:");
                for (Pair<String, String> pair : list) {
                    sb.append(String.format("(%s,%s),", pair.first, pair.second));
                }
                C1856n.m8130a("PropertyFileOperation", sb.toString());
            }
            for (Pair<String, String> pair2 : list) {
                this.f10146a.put(pair2.first, pair2.second);
            }
        }
        return m8087b();
    }

    /* renamed from: a */
    public final boolean m8089a(String str, String str2) {
        this.f10146a.put(str, str2);
        return m8087b();
    }

    /* renamed from: a */
    public final String m8090a(String str) {
        if (C1856n.f10135a) {
            C1856n.m8130a("PropertyFileOperation", "PropertyFileOperation file get key=".concat(String.valueOf(str)));
            StringBuilder sb = new StringBuilder();
            sb.append("PropertyFileOperation file (key,value) collenction:");
            for (Map.Entry<String, String> entry : this.f10146a.entrySet()) {
                sb.append(String.format("(%s,%s),", entry.getKey(), entry.getValue()));
            }
            C1856n.m8130a("PropertyFileOperation", sb.toString());
        }
        return this.f10146a.get(str);
    }

    /* renamed from: a */
    private Properties m8091a() {
        File file = new File(this.f10147b);
        Properties properties = new Properties();
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
                properties.load(inputStreamReader);
                inputStreamReader.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return properties;
    }

    /* renamed from: b */
    private boolean m8087b() {
        try {
            File file = new File(this.f10147b);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, Charset.forName("UTF-8"));
            if (C1856n.f10135a) {
                StringBuilder sb = new StringBuilder();
                sb.append("PropertyFileOperation save file (key,value) collenction:");
                for (Map.Entry<String, String> entry : this.f10146a.entrySet()) {
                    sb.append(String.format("(%s,%s),", entry.getKey(), entry.getValue()));
                }
                C1856n.m8130a("PropertyFileOperation", sb.toString());
            }
            Properties properties = new Properties();
            for (Map.Entry<String, String> entry2 : this.f10146a.entrySet()) {
                properties.setProperty(entry2.getKey(), entry2.getValue());
            }
            properties.store(outputStreamWriter, (String) null);
            outputStreamWriter.close();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
