package com.itextpdf.text;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Annotation implements Element {
    public static final String APPLICATION = "application";
    public static final String CONTENT = "content";
    public static final String DEFAULTDIR = "defaultdir";
    public static final String DESTINATION = "destination";
    public static final String FILE = "file";
    public static final int FILE_DEST = 3;
    public static final int FILE_PAGE = 4;
    public static final int LAUNCH = 6;
    public static final String LLX = "llx";
    public static final String LLY = "lly";
    public static final String MIMETYPE = "mime";
    public static final String NAMED = "named";
    public static final int NAMED_DEST = 5;
    public static final String OPERATION = "operation";
    public static final String PAGE = "page";
    public static final String PARAMETERS = "parameters";
    public static final int SCREEN = 7;
    public static final int TEXT = 0;
    public static final String TITLE = "title";
    public static final String URL = "url";
    public static final int URL_AS_STRING = 2;
    public static final int URL_NET = 1;
    public static final String URX = "urx";
    public static final String URY = "ury";
    protected HashMap<String, Object> annotationAttributes;
    protected int annotationtype;
    protected float llx;
    protected float lly;
    protected float urx;
    protected float ury;

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return true;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return true;
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return 29;
    }

    private Annotation(float f, float f2, float f3, float f4) {
        this.annotationAttributes = new HashMap<>();
        this.llx = Float.NaN;
        this.lly = Float.NaN;
        this.urx = Float.NaN;
        this.ury = Float.NaN;
        this.llx = f;
        this.lly = f2;
        this.urx = f3;
        this.ury = f4;
    }

    public Annotation(Annotation annotation) {
        this.annotationAttributes = new HashMap<>();
        this.llx = Float.NaN;
        this.lly = Float.NaN;
        this.urx = Float.NaN;
        this.ury = Float.NaN;
        this.annotationtype = annotation.annotationtype;
        this.annotationAttributes = annotation.annotationAttributes;
        this.llx = annotation.llx;
        this.lly = annotation.lly;
        this.urx = annotation.urx;
        this.ury = annotation.ury;
    }

    public Annotation(String str, String str2) {
        this.annotationAttributes = new HashMap<>();
        this.llx = Float.NaN;
        this.lly = Float.NaN;
        this.urx = Float.NaN;
        this.ury = Float.NaN;
        this.annotationtype = 0;
        this.annotationAttributes.put("title", str);
        this.annotationAttributes.put("content", str2);
    }

    public Annotation(String str, String str2, float f, float f2, float f3, float f4) {
        this(f, f2, f3, f4);
        this.annotationtype = 0;
        this.annotationAttributes.put("title", str);
        this.annotationAttributes.put("content", str2);
    }

    public Annotation(float f, float f2, float f3, float f4, URL url) {
        this(f, f2, f3, f4);
        this.annotationtype = 1;
        this.annotationAttributes.put(URL, url);
    }

    public Annotation(float f, float f2, float f3, float f4, String str) {
        this(f, f2, f3, f4);
        this.annotationtype = 2;
        this.annotationAttributes.put(FILE, str);
    }

    public Annotation(float f, float f2, float f3, float f4, String str, String str2) {
        this(f, f2, f3, f4);
        this.annotationtype = 3;
        this.annotationAttributes.put(FILE, str);
        this.annotationAttributes.put(DESTINATION, str2);
    }

    public Annotation(float f, float f2, float f3, float f4, String str, String str2, boolean z) {
        this(f, f2, f3, f4);
        this.annotationtype = 7;
        this.annotationAttributes.put(FILE, str);
        this.annotationAttributes.put(MIMETYPE, str2);
        this.annotationAttributes.put(PARAMETERS, new boolean[]{false, z});
    }

    public Annotation(float f, float f2, float f3, float f4, String str, int i) {
        this(f, f2, f3, f4);
        this.annotationtype = 4;
        this.annotationAttributes.put(FILE, str);
        this.annotationAttributes.put(PAGE, Integer.valueOf(i));
    }

    public Annotation(float f, float f2, float f3, float f4, int i) {
        this(f, f2, f3, f4);
        this.annotationtype = 5;
        this.annotationAttributes.put(NAMED, Integer.valueOf(i));
    }

    public Annotation(float f, float f2, float f3, float f4, String str, String str2, String str3, String str4) {
        this(f, f2, f3, f4);
        this.annotationtype = 6;
        this.annotationAttributes.put(APPLICATION, str);
        this.annotationAttributes.put(PARAMETERS, str2);
        this.annotationAttributes.put(OPERATION, str3);
        this.annotationAttributes.put(DEFAULTDIR, str4);
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    @Override // com.itextpdf.text.Element
    public java.util.List<Chunk> getChunks() {
        return new ArrayList();
    }

    public void setDimensions(float f, float f2, float f3, float f4) {
        this.llx = f;
        this.lly = f2;
        this.urx = f3;
        this.ury = f4;
    }

    public float llx() {
        return this.llx;
    }

    public float lly() {
        return this.lly;
    }

    public float urx() {
        return this.urx;
    }

    public float ury() {
        return this.ury;
    }

    public float llx(float f) {
        return Float.isNaN(this.llx) ? f : this.llx;
    }

    public float lly(float f) {
        return Float.isNaN(this.lly) ? f : this.lly;
    }

    public float urx(float f) {
        return Float.isNaN(this.urx) ? f : this.urx;
    }

    public float ury(float f) {
        return Float.isNaN(this.ury) ? f : this.ury;
    }

    public int annotationType() {
        return this.annotationtype;
    }

    public String title() {
        String str = (String) this.annotationAttributes.get("title");
        return str == null ? "" : str;
    }

    public String content() {
        String str = (String) this.annotationAttributes.get("content");
        return str == null ? "" : str;
    }

    public HashMap<String, Object> attributes() {
        return this.annotationAttributes;
    }
}
