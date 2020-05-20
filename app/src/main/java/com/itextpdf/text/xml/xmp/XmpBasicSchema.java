package com.itextpdf.text.xml.xmp;

/* loaded from: classes.dex */
public class XmpBasicSchema extends XmpSchema {
    public static final String ADVISORY = "xmp:Advisory";
    public static final String BASEURL = "xmp:BaseURL";
    public static final String CREATEDATE = "xmp:CreateDate";
    public static final String CREATORTOOL = "xmp:CreatorTool";
    public static final String DEFAULT_XPATH_ID = "xmp";
    public static final String DEFAULT_XPATH_URI = "http://ns.adobe.com/xap/1.0/";
    public static final String IDENTIFIER = "xmp:Identifier";
    public static final String METADATADATE = "xmp:MetadataDate";
    public static final String MODIFYDATE = "xmp:ModifyDate";
    public static final String NICKNAME = "xmp:Nickname";
    public static final String THUMBNAILS = "xmp:Thumbnails";
    private static final long serialVersionUID = -2416613941622479298L;

    public XmpBasicSchema() {
        super("xmlns:xmp=\"http://ns.adobe.com/xap/1.0/\"");
    }

    public void addCreatorTool(String str) {
        setProperty(CREATORTOOL, str);
    }

    public void addCreateDate(String str) {
        setProperty(CREATEDATE, str);
    }

    public void addModDate(String str) {
        setProperty(MODIFYDATE, str);
    }

    public void addMetaDataDate(String str) {
        setProperty(METADATADATE, str);
    }

    public void addIdentifiers(String[] strArr) {
        XmpArray xmpArray = new XmpArray(XmpArray.UNORDERED);
        for (String str : strArr) {
            xmpArray.add(str);
        }
        setProperty(IDENTIFIER, xmpArray);
    }

    public void addNickname(String str) {
        setProperty(NICKNAME, str);
    }
}
