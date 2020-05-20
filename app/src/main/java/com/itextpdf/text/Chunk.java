package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.HyphenationEvent;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.draw.DrawInterface;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class Chunk implements Element {
    public static final String ACTION = "ACTION";
    public static final String BACKGROUND = "BACKGROUND";
    public static final String CHAR_SPACING = "CHAR_SPACING";
    public static final String COLOR = "COLOR";
    public static final String ENCODING = "ENCODING";
    public static final String GENERICTAG = "GENERICTAG";
    public static final String HSCALE = "HSCALE";
    public static final String HYPHENATION = "HYPHENATION";
    public static final String IMAGE = "IMAGE";
    public static final String LINEHEIGHT = "LINEHEIGHT";
    public static final String LOCALDESTINATION = "LOCALDESTINATION";
    public static final String LOCALGOTO = "LOCALGOTO";
    public static final Chunk NEWLINE = new Chunk("\n");
    public static final String NEWPAGE = "NEWPAGE";
    public static final Chunk NEXTPAGE;
    public static final String OBJECT_REPLACEMENT_CHARACTER = "￼";
    public static final String PDFANNOTATION = "PDFANNOTATION";
    public static final String REMOTEGOTO = "REMOTEGOTO";
    public static final String SEPARATOR = "SEPARATOR";
    public static final String SKEW = "SKEW";
    public static final String SPLITCHARACTER = "SPLITCHARACTER";
    public static final String SUBSUPSCRIPT = "SUBSUPSCRIPT";
    public static final String TAB = "TAB";
    public static final String TEXTRENDERMODE = "TEXTRENDERMODE";
    public static final String UNDERLINE = "UNDERLINE";
    public static final String WHITESPACE = "WHITESPACE";
    protected HashMap<String, Object> attributes;
    protected StringBuffer content;
    protected Font font;

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
        return 10;
    }

    static {
        Chunk chunk = new Chunk("");
        NEXTPAGE = chunk;
        chunk.setNewPage();
    }

    public Chunk() {
        this.content = null;
        this.font = null;
        this.attributes = null;
        this.content = new StringBuffer();
        this.font = new Font();
    }

    public Chunk(Chunk chunk) {
        this.content = null;
        this.font = null;
        this.attributes = null;
        StringBuffer stringBuffer = chunk.content;
        if (stringBuffer != null) {
            this.content = new StringBuffer(stringBuffer.toString());
        }
        Font font = chunk.font;
        if (font != null) {
            this.font = new Font(font);
        }
        HashMap<String, Object> hashMap = chunk.attributes;
        if (hashMap != null) {
            this.attributes = new HashMap<>(hashMap);
        }
    }

    public Chunk(String str, Font font) {
        this.content = null;
        this.font = null;
        this.attributes = null;
        this.content = new StringBuffer(str);
        this.font = font;
    }

    public Chunk(String str) {
        this(str, new Font());
    }

    public Chunk(char c, Font font) {
        this.content = null;
        this.font = null;
        this.attributes = null;
        this.content = new StringBuffer();
        this.content.append(c);
        this.font = font;
    }

    public Chunk(char c) {
        this(c, new Font());
    }

    public Chunk(Image image, float f, float f2) {
        this(OBJECT_REPLACEMENT_CHARACTER, new Font());
        Image image2 = Image.getInstance(image);
        image2.setAbsolutePosition(Float.NaN, Float.NaN);
        setAttribute(IMAGE, new Object[]{image2, Float.valueOf(f), Float.valueOf(f2), Boolean.FALSE});
    }

    public Chunk(DrawInterface drawInterface) {
        this(drawInterface, false);
    }

    public Chunk(DrawInterface drawInterface, boolean z) {
        this(OBJECT_REPLACEMENT_CHARACTER, new Font());
        setAttribute(SEPARATOR, new Object[]{drawInterface, Boolean.valueOf(z)});
    }

    public Chunk(DrawInterface drawInterface, float f) {
        this(drawInterface, f, false);
    }

    public Chunk(DrawInterface drawInterface, float f, boolean z) {
        this(OBJECT_REPLACEMENT_CHARACTER, new Font());
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("a.tab.position.may.not.be.lower.than.0.yours.is.1", String.valueOf(f)));
        }
        setAttribute(TAB, new Object[]{drawInterface, Float.valueOf(f), Boolean.valueOf(z), Float.valueOf((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO)});
    }

    public Chunk(Image image, float f, float f2, boolean z) {
        this(OBJECT_REPLACEMENT_CHARACTER, new Font());
        setAttribute(IMAGE, new Object[]{image, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)});
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
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        return arrayList;
    }

    public StringBuffer append(String str) {
        StringBuffer stringBuffer = this.content;
        stringBuffer.append(str);
        return stringBuffer;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Font getFont() {
        return this.font;
    }

    public String getContent() {
        return this.content.toString().replaceAll("\t", "");
    }

    @Override // com.itextpdf.text.Element
    public String toString() {
        return getContent();
    }

    public boolean isEmpty() {
        return this.content.toString().trim().length() == 0 && this.content.toString().indexOf("\n") == -1 && this.attributes == null;
    }

    public float getWidthPoint() {
        if (getImage() != null) {
            return getImage().getScaledWidth();
        }
        return this.font.getCalculatedBaseFont(true).getWidthPoint(getContent(), this.font.getCalculatedSize()) * getHorizontalScaling();
    }

    public boolean hasAttributes() {
        return this.attributes != null;
    }

    public HashMap<String, Object> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(HashMap<String, Object> hashMap) {
        this.attributes = hashMap;
    }

    private Chunk setAttribute(String str, Object obj) {
        if (this.attributes == null) {
            this.attributes = new HashMap<>();
        }
        this.attributes.put(str, obj);
        return this;
    }

    public Chunk setHorizontalScaling(float f) {
        return setAttribute(HSCALE, Float.valueOf(f));
    }

    public float getHorizontalScaling() {
        Float f;
        HashMap<String, Object> hashMap = this.attributes;
        if (hashMap == null || (f = (Float) hashMap.get(HSCALE)) == null) {
            return 1.0f;
        }
        return f.floatValue();
    }

    public Chunk setUnderline(float f, float f2) {
        return setUnderline(null, f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f2, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 0);
    }

    public Chunk setUnderline(BaseColor baseColor, float f, float f2, float f3, float f4, int i) {
        if (this.attributes == null) {
            this.attributes = new HashMap<>();
        }
        return setAttribute(UNDERLINE, Utilities.addToArray((Object[][]) this.attributes.get(UNDERLINE), new Object[]{baseColor, new float[]{f, f2, f3, f4, i}}));
    }

    public Chunk setTextRise(float f) {
        return setAttribute(SUBSUPSCRIPT, Float.valueOf(f));
    }

    public float getTextRise() {
        HashMap<String, Object> hashMap = this.attributes;
        return (hashMap == null || !hashMap.containsKey(SUBSUPSCRIPT)) ? ColumnText.GLOBAL_SPACE_CHAR_RATIO : ((Float) this.attributes.get(SUBSUPSCRIPT)).floatValue();
    }

    public Chunk setSkew(float f, float f2) {
        double d = f;
        Double.isNaN(d);
        float tan = (float) Math.tan((d * 3.141592653589793d) / 180.0d);
        double d2 = f2;
        Double.isNaN(d2);
        return setAttribute(SKEW, new float[]{tan, (float) Math.tan((d2 * 3.141592653589793d) / 180.0d)});
    }

    public Chunk setBackground(BaseColor baseColor) {
        return setBackground(baseColor, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    public Chunk setBackground(BaseColor baseColor, float f, float f2, float f3, float f4) {
        return setAttribute(BACKGROUND, new Object[]{baseColor, new float[]{f, f2, f3, f4}});
    }

    public Chunk setTextRenderMode(int i, float f, BaseColor baseColor) {
        return setAttribute(TEXTRENDERMODE, new Object[]{Integer.valueOf(i), Float.valueOf(f), baseColor});
    }

    public Chunk setSplitCharacter(SplitCharacter splitCharacter) {
        return setAttribute(SPLITCHARACTER, splitCharacter);
    }

    public Chunk setHyphenation(HyphenationEvent hyphenationEvent) {
        return setAttribute(HYPHENATION, hyphenationEvent);
    }

    public Chunk setRemoteGoto(String str, String str2) {
        return setAttribute(REMOTEGOTO, new Object[]{str, str2});
    }

    public Chunk setRemoteGoto(String str, int i) {
        return setAttribute(REMOTEGOTO, new Object[]{str, Integer.valueOf(i)});
    }

    public Chunk setLocalGoto(String str) {
        return setAttribute(LOCALGOTO, str);
    }

    public Chunk setLocalDestination(String str) {
        return setAttribute(LOCALDESTINATION, str);
    }

    public Chunk setGenericTag(String str) {
        return setAttribute(GENERICTAG, str);
    }

    public Chunk setLineHeight(float f) {
        return setAttribute(LINEHEIGHT, Float.valueOf(f));
    }

    public Image getImage() {
        Object[] objArr;
        HashMap<String, Object> hashMap = this.attributes;
        if (hashMap == null || (objArr = (Object[]) hashMap.get(IMAGE)) == null) {
            return null;
        }
        return (Image) objArr[0];
    }

    public Chunk setAction(PdfAction pdfAction) {
        return setAttribute(ACTION, pdfAction);
    }

    public Chunk setAnchor(URL url) {
        return setAttribute(ACTION, new PdfAction(url.toExternalForm()));
    }

    public Chunk setAnchor(String str) {
        return setAttribute(ACTION, new PdfAction(str));
    }

    public Chunk setNewPage() {
        return setAttribute(NEWPAGE, null);
    }

    public Chunk setAnnotation(PdfAnnotation pdfAnnotation) {
        return setAttribute(PDFANNOTATION, pdfAnnotation);
    }

    public HyphenationEvent getHyphenation() {
        HashMap<String, Object> hashMap = this.attributes;
        if (hashMap == null) {
            return null;
        }
        return (HyphenationEvent) hashMap.get(HYPHENATION);
    }

    public Chunk setCharacterSpacing(float f) {
        return setAttribute(CHAR_SPACING, Float.valueOf(f));
    }

    public float getCharacterSpacing() {
        HashMap<String, Object> hashMap = this.attributes;
        return (hashMap == null || !hashMap.containsKey(CHAR_SPACING)) ? ColumnText.GLOBAL_SPACE_CHAR_RATIO : ((Float) this.attributes.get(CHAR_SPACING)).floatValue();
    }

    public static Chunk createWhitespace(String str) {
        return createWhitespace(str, false);
    }

    public static Chunk createWhitespace(String str, boolean z) {
        if (!z) {
            Chunk chunk = new Chunk((char) TokenParser.f24154SP);
            chunk.setAttribute(WHITESPACE, str);
            return chunk;
        }
        return new Chunk(str);
    }

    public boolean isWhitespace() {
        HashMap<String, Object> hashMap = this.attributes;
        return hashMap != null && hashMap.containsKey(WHITESPACE);
    }
}
