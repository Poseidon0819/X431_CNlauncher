package com.thoughtworks.xstream.p366io.json;

import java.io.Writer;
import org.apache.http.conn.ssl.TokenParser;

/* renamed from: com.thoughtworks.xstream.io.json.JsonHierarchicalStreamWriter */
/* loaded from: classes2.dex */
public class JsonHierarchicalStreamWriter extends JsonWriter {
    public JsonHierarchicalStreamWriter(Writer writer, char[] cArr, String str) {
        super(writer, cArr, str);
    }

    public JsonHierarchicalStreamWriter(Writer writer, char[] cArr) {
        this(writer, cArr, "\n");
    }

    public JsonHierarchicalStreamWriter(Writer writer, String str, String str2) {
        this(writer, str.toCharArray(), str2);
    }

    public JsonHierarchicalStreamWriter(Writer writer, String str) {
        this(writer, str.toCharArray());
    }

    public JsonHierarchicalStreamWriter(Writer writer) {
        this(writer, new char[]{TokenParser.f24154SP, TokenParser.f24154SP});
    }
}
