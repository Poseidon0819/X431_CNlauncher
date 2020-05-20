package com.cnlaunch.p120d.p121a.p122a;

import android.util.Log;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/* renamed from: com.cnlaunch.d.a.a.a */
/* loaded from: classes.dex */
public class JsonMananger {

    /* renamed from: b */
    private static ObjectMapper f6744b;

    /* renamed from: c */
    private static JsonMananger f6745c;

    /* renamed from: a */
    private final String f6746a = JsonMananger.class.getSimpleName();

    private JsonMananger() {
        if (f6744b == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            f6744b = objectMapper;
            objectMapper.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.ALWAYS);
            f6744b.getDeserializationConfig().set(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
    }

    /* renamed from: a */
    public static JsonMananger m9626a() {
        if (f6745c == null) {
            synchronized (JsonMananger.class) {
                if (f6745c == null) {
                    f6745c = new JsonMananger();
                }
            }
        }
        return f6745c;
    }

    /* renamed from: a */
    public static <T> T m9624a(String str, Class<T> cls) throws C1425f {
        try {
            f6744b.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            return (T) f6744b.readValue(str, cls);
        } catch (JsonParseException e) {
            e.printStackTrace();
            throw new C1425f(e.getMessage());
        } catch (JsonMappingException e2) {
            if (str.contains("10003") || str.contains("1022")) {
                throw new C1425f("-300");
            }
            if (str.contains("\"msg\":\"no data\"")) {
                Log.e("jsonToBean", "[No Data]");
                return null;
            }
            e2.printStackTrace();
            throw new C1425f(e2.getMessage());
        } catch (IOException e3) {
            e3.printStackTrace();
            throw new C1425f(e3.getMessage());
        }
    }

    /* renamed from: a */
    public static String m9625a(Object obj) throws C1425f {
        try {
            return f6744b.writeValueAsString(obj);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            throw new C1425f(e.getMessage());
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
            throw new C1425f(e2.getMessage());
        } catch (IOException e3) {
            e3.printStackTrace();
            throw new C1425f(e3.getMessage());
        }
    }

    /* renamed from: b */
    public static ObjectMapper m9623b() {
        return f6744b;
    }

    /* renamed from: b */
    public static <T> T m9622b(String str, Class<T> cls) throws C1425f {
        try {
            return (T) f6744b.readValue(str, cls);
        } catch (JsonParseException e) {
            e.printStackTrace();
            throw new C1425f(e.getMessage());
        } catch (JsonMappingException e2) {
            if (str.contains("10003") || str.contains("1022")) {
                throw new C1425f("-300");
            }
            if (str.contains("\"msg\":\"no data\"")) {
                Log.e("jsonToBean", "[No Data]");
                return null;
            }
            e2.printStackTrace();
            throw new C1425f(e2.getMessage());
        } catch (IOException e3) {
            e3.printStackTrace();
            throw new C1425f(e3.getMessage());
        }
    }
}
