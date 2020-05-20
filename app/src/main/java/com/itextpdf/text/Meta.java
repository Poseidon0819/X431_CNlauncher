package com.itextpdf.text;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class Meta implements Element {
    public static final String AUTHOR = "author";
    public static final String CREATIONDATE = "creationdate";
    public static final String KEYWORDS = "keywords";
    public static final String PRODUCER = "producer";
    public static final String SUBJECT = "subject";
    public static final String TITLE = "title";
    public static final String UNKNOWN = "unknown";
    private final StringBuffer content;
    private final int type;

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Meta(int i, String str) {
        this.type = i;
        this.content = new StringBuffer(str);
    }

    public Meta(String str, String str2) {
        this.type = getType(str);
        this.content = new StringBuffer(str2);
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
    public int type() {
        return this.type;
    }

    @Override // com.itextpdf.text.Element
    public java.util.List<Chunk> getChunks() {
        return new ArrayList();
    }

    public StringBuffer append(String str) {
        StringBuffer stringBuffer = this.content;
        stringBuffer.append(str);
        return stringBuffer;
    }

    public String getContent() {
        return this.content.toString();
    }

    public String getName() {
        switch (this.type) {
            case 1:
                return "title";
            case 2:
                return SUBJECT;
            case 3:
                return KEYWORDS;
            case 4:
                return AUTHOR;
            case 5:
                return PRODUCER;
            case 6:
                return CREATIONDATE;
            default:
                return UNKNOWN;
        }
    }

    public static int getType(String str) {
        if (SUBJECT.equals(str)) {
            return 2;
        }
        if (KEYWORDS.equals(str)) {
            return 3;
        }
        if (AUTHOR.equals(str)) {
            return 4;
        }
        if ("title".equals(str)) {
            return 1;
        }
        if (PRODUCER.equals(str)) {
            return 5;
        }
        return CREATIONDATE.equals(str) ? 6 : 0;
    }
}
