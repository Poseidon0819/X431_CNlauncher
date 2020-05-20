package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.SplitCharacter;
import com.itextpdf.text.Utilities;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.apache.http.conn.ssl.TokenParser;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class PdfChunk {
    private static final float ITALIC_ANGLE = 0.21256f;
    protected HashMap<String, Object> attributes;
    protected BaseFont baseFont;
    protected boolean changeLeading;
    protected String encoding;
    protected PdfFont font;
    protected Image image;
    protected float leading;
    protected boolean newlineSplit;
    protected HashMap<String, Object> noStroke;
    protected float offsetX;
    protected float offsetY;
    protected SplitCharacter splitCharacter;
    protected String value;
    private static final char[] singleSpace = {TokenParser.f24154SP};
    private static final PdfChunk[] thisChunk = new PdfChunk[1];
    private static final HashSet<String> keysAttributes = new HashSet<>();
    private static final HashSet<String> keysNoStroke = new HashSet<>();

    public static boolean noPrint(int i) {
        if (i < 8203 || i > 8207) {
            return i >= 8234 && i <= 8238;
        }
        return true;
    }

    static {
        keysAttributes.add(Chunk.ACTION);
        keysAttributes.add(Chunk.UNDERLINE);
        keysAttributes.add(Chunk.REMOTEGOTO);
        keysAttributes.add(Chunk.LOCALGOTO);
        keysAttributes.add(Chunk.LOCALDESTINATION);
        keysAttributes.add(Chunk.GENERICTAG);
        keysAttributes.add(Chunk.NEWPAGE);
        keysAttributes.add(Chunk.IMAGE);
        keysAttributes.add(Chunk.BACKGROUND);
        keysAttributes.add(Chunk.PDFANNOTATION);
        keysAttributes.add(Chunk.SKEW);
        keysAttributes.add(Chunk.HSCALE);
        keysAttributes.add(Chunk.SEPARATOR);
        keysAttributes.add(Chunk.TAB);
        keysAttributes.add(Chunk.CHAR_SPACING);
        keysAttributes.add(Chunk.LINEHEIGHT);
        keysNoStroke.add(Chunk.SUBSUPSCRIPT);
        keysNoStroke.add(Chunk.SPLITCHARACTER);
        keysNoStroke.add(Chunk.HYPHENATION);
        keysNoStroke.add(Chunk.TEXTRENDERMODE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfChunk(String str, PdfChunk pdfChunk) {
        this.value = "";
        this.encoding = "Cp1252";
        this.attributes = new HashMap<>();
        this.noStroke = new HashMap<>();
        this.changeLeading = false;
        this.leading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        thisChunk[0] = this;
        this.value = str;
        this.font = pdfChunk.font;
        this.attributes = pdfChunk.attributes;
        this.noStroke = pdfChunk.noStroke;
        this.baseFont = pdfChunk.baseFont;
        this.changeLeading = pdfChunk.changeLeading;
        this.leading = pdfChunk.leading;
        Object[] objArr = (Object[]) this.attributes.get(Chunk.IMAGE);
        if (objArr == null) {
            this.image = null;
        } else {
            this.image = (Image) objArr[0];
            this.offsetX = ((Float) objArr[1]).floatValue();
            this.offsetY = ((Float) objArr[2]).floatValue();
            this.changeLeading = ((Boolean) objArr[3]).booleanValue();
        }
        this.encoding = this.font.getFont().getEncoding();
        this.splitCharacter = (SplitCharacter) this.noStroke.get(Chunk.SPLITCHARACTER);
        if (this.splitCharacter == null) {
            this.splitCharacter = DefaultSplitCharacter.DEFAULT;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfChunk(Chunk chunk, PdfAction pdfAction) {
        this.value = "";
        this.encoding = "Cp1252";
        this.attributes = new HashMap<>();
        this.noStroke = new HashMap<>();
        this.changeLeading = false;
        this.leading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        thisChunk[0] = this;
        this.value = chunk.getContent();
        Font font = chunk.getFont();
        float size = font.getSize();
        size = size == -1.0f ? 12.0f : size;
        this.baseFont = font.getBaseFont();
        int style = font.getStyle();
        style = style == -1 ? 0 : style;
        if (this.baseFont == null) {
            this.baseFont = font.getCalculatedBaseFont(false);
        } else {
            if ((style & 1) != 0) {
                this.attributes.put(Chunk.TEXTRENDERMODE, new Object[]{2, new Float(size / 30.0f), null});
            }
            if ((style & 2) != 0) {
                this.attributes.put(Chunk.SKEW, new float[]{ColumnText.GLOBAL_SPACE_CHAR_RATIO, ITALIC_ANGLE});
            }
        }
        this.font = new PdfFont(this.baseFont, size);
        HashMap<String, Object> attributes = chunk.getAttributes();
        if (attributes != null) {
            for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                String key = entry.getKey();
                if (keysAttributes.contains(key)) {
                    this.attributes.put(key, entry.getValue());
                } else if (keysNoStroke.contains(key)) {
                    this.noStroke.put(key, entry.getValue());
                }
            }
            if ("".equals(attributes.get(Chunk.GENERICTAG))) {
                this.attributes.put(Chunk.GENERICTAG, chunk.getContent());
            }
        }
        if (font.isUnderlined()) {
            this.attributes.put(Chunk.UNDERLINE, Utilities.addToArray((Object[][]) this.attributes.get(Chunk.UNDERLINE), new Object[]{null, new float[]{ColumnText.GLOBAL_SPACE_CHAR_RATIO, 0.06666667f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, -0.33333334f, ColumnText.GLOBAL_SPACE_CHAR_RATIO}}));
        }
        if (font.isStrikethru()) {
            this.attributes.put(Chunk.UNDERLINE, Utilities.addToArray((Object[][]) this.attributes.get(Chunk.UNDERLINE), new Object[]{null, new float[]{ColumnText.GLOBAL_SPACE_CHAR_RATIO, 0.06666667f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 0.33333334f, ColumnText.GLOBAL_SPACE_CHAR_RATIO}}));
        }
        if (pdfAction != null) {
            this.attributes.put(Chunk.ACTION, pdfAction);
        }
        this.noStroke.put(Chunk.COLOR, font.getColor());
        this.noStroke.put(Chunk.ENCODING, this.font.getFont().getEncoding());
        Float f = (Float) this.attributes.get(Chunk.LINEHEIGHT);
        if (f != null) {
            this.changeLeading = true;
            this.leading = f.floatValue();
        }
        Object[] objArr = (Object[]) this.attributes.get(Chunk.IMAGE);
        if (objArr == null) {
            this.image = null;
        } else {
            this.attributes.remove(Chunk.HSCALE);
            this.image = (Image) objArr[0];
            this.offsetX = ((Float) objArr[1]).floatValue();
            this.offsetY = ((Float) objArr[2]).floatValue();
            this.changeLeading = ((Boolean) objArr[3]).booleanValue();
        }
        this.font.setImage(this.image);
        Float f2 = (Float) this.attributes.get(Chunk.HSCALE);
        if (f2 != null) {
            this.font.setHorizontalScaling(f2.floatValue());
        }
        this.encoding = this.font.getFont().getEncoding();
        this.splitCharacter = (SplitCharacter) this.noStroke.get(Chunk.SPLITCHARACTER);
        if (this.splitCharacter == null) {
            this.splitCharacter = DefaultSplitCharacter.DEFAULT;
        }
    }

    public int getUnicodeEquivalent(int i) {
        return this.baseFont.getUnicodeEquivalent(i);
    }

    protected int getWord(String str, int i) {
        int length = str.length();
        while (i < length && Character.isLetter(str.charAt(i))) {
            i++;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x013c, code lost:
        r24.newlineSplit = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013e, code lost:
        if (r9 != '\r') goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0140, code lost:
        r2 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0142, code lost:
        if (r2 >= r4) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0146, code lost:
        if (r11[r2] != '\n') goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0148, code lost:
        r18 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014b, code lost:
        r18 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014d, code lost:
        r2 = r24.value.substring(r5 + r18);
        r24.value = r24.value.substring(0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0163, code lost:
        if (r24.value.length() > 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0165, code lost:
        r24.value = org.codehaus.jackson.util.MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x016e, code lost:
        return new com.itextpdf.text.pdf.PdfChunk(r2, r24);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.itextpdf.text.pdf.PdfChunk split(float r25) {
        /*
            Method dump skipped, instructions count: 539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfChunk.split(float):com.itextpdf.text.pdf.PdfChunk");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfChunk truncate(float f) {
        Image image = this.image;
        if (image != null) {
            if (image.getScaledWidth() > f) {
                if (this.image.isScaleToFitLineWhenOverflow()) {
                    this.image.scalePercent((f / this.image.getWidth()) * 100.0f);
                    return null;
                }
                PdfChunk pdfChunk = new PdfChunk("", this);
                this.value = "";
                this.attributes.remove(Chunk.IMAGE);
                this.image = null;
                this.font = PdfFont.getDefaultFont();
                return pdfChunk;
            }
            return null;
        }
        int i = 1;
        if (f < this.font.width()) {
            String substring = this.value.substring(1);
            this.value = this.value.substring(0, 1);
            return new PdfChunk(substring, this);
        }
        int length = this.value.length();
        int i2 = 0;
        float f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        boolean z = false;
        while (i2 < length) {
            z = Utilities.isSurrogatePair(this.value, i2);
            if (z) {
                f2 += getCharWidth(Utilities.convertToUtf32(this.value, i2));
            } else {
                f2 += getCharWidth(this.value.charAt(i2));
            }
            if (f2 > f) {
                break;
            }
            if (z) {
                i2++;
            }
            i2++;
        }
        if (i2 == length) {
            return null;
        }
        if (i2 != 0) {
            i = i2;
        } else if (z) {
            i = 2;
        }
        String substring2 = this.value.substring(i);
        this.value = this.value.substring(0, i);
        return new PdfChunk(substring2, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfFont font() {
        return this.font;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseColor color() {
        return (BaseColor) this.noStroke.get(Chunk.COLOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float width() {
        if (isAttribute(Chunk.CHAR_SPACING)) {
            return this.font.width(this.value) + (this.value.length() * ((Float) getAttribute(Chunk.CHAR_SPACING)).floatValue());
        }
        return isAttribute(Chunk.SEPARATOR) ? ColumnText.GLOBAL_SPACE_CHAR_RATIO : this.font.width(this.value);
    }

    public boolean isNewlineSplit() {
        return this.newlineSplit;
    }

    public float getWidthCorrected(float f, float f2) {
        Image image = this.image;
        if (image != null) {
            return image.getScaledWidth() + f;
        }
        int i = 0;
        int i2 = -1;
        while (true) {
            i2 = this.value.indexOf(32, i2 + 1);
            if (i2 < 0) {
                return width() + (this.value.length() * f) + (i * f2);
            }
            i++;
        }
    }

    public float getTextRise() {
        Float f = (Float) getAttribute(Chunk.SUBSUPSCRIPT);
        return f != null ? f.floatValue() : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public float trimLastSpace() {
        BaseFont font = this.font.getFont();
        if (font.getFontType() == 2 && font.getUnicodeEquivalent(32) != 32) {
            if (this.value.length() <= 1 || !this.value.endsWith("\u0001")) {
                return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
            String str = this.value;
            this.value = str.substring(0, str.length() - 1);
            return this.font.width(1);
        } else if (this.value.length() <= 1 || !this.value.endsWith(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else {
            String str2 = this.value;
            this.value = str2.substring(0, str2.length() - 1);
            return this.font.width(32);
        }
    }

    public float trimFirstSpace() {
        BaseFont font = this.font.getFont();
        if (font.getFontType() == 2 && font.getUnicodeEquivalent(32) != 32) {
            if (this.value.length() <= 1 || !this.value.startsWith("\u0001")) {
                return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
            this.value = this.value.substring(1);
            return this.font.width(1);
        } else if (this.value.length() <= 1 || !this.value.startsWith(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else {
            this.value = this.value.substring(1);
            return this.font.width(32);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getAttribute(String str) {
        if (this.attributes.containsKey(str)) {
            return this.attributes.get(str);
        }
        return this.noStroke.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAttribute(String str) {
        if (this.attributes.containsKey(str)) {
            return true;
        }
        return this.noStroke.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStroked() {
        return !this.attributes.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSeparator() {
        return isAttribute(Chunk.SEPARATOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHorizontalSeparator() {
        return isAttribute(Chunk.SEPARATOR) && !((Boolean) ((Object[]) getAttribute(Chunk.SEPARATOR))[1]).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isTab() {
        return isAttribute(Chunk.TAB);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void adjustLeft(float f) {
        Object[] objArr = (Object[]) this.attributes.get(Chunk.TAB);
        if (objArr != null) {
            this.attributes.put(Chunk.TAB, new Object[]{objArr[0], objArr[1], objArr[2], Float.valueOf(f)});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isImage() {
        return this.image != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Image getImage() {
        return this.image;
    }

    void setImageOffsetX(float f) {
        this.offsetX = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getImageOffsetX() {
        return this.offsetX;
    }

    void setImageOffsetY(float f) {
        this.offsetY = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getImageOffsetY() {
        return this.offsetY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSpecialEncoding() {
        return this.encoding.equals("UnicodeBigUnmarked") || this.encoding.equals(BaseFont.IDENTITY_H);
    }

    String getEncoding() {
        return this.encoding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int length() {
        return this.value.length();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int lengthUtf32() {
        if (!BaseFont.IDENTITY_H.equals(this.encoding)) {
            return this.value.length();
        }
        int length = this.value.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (Utilities.isSurrogateHigh(this.value.charAt(i))) {
                i++;
            }
            i2++;
            i++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isExtSplitCharacter(int i, int i2, int i3, char[] cArr, PdfChunk[] pdfChunkArr) {
        return this.splitCharacter.isSplitCharacter(i, i2, i3, cArr, pdfChunkArr);
    }

    String trim(String str) {
        BaseFont font = this.font.getFont();
        if (font.getFontType() != 2 || font.getUnicodeEquivalent(32) == 32) {
            while (true) {
                if (!str.endsWith(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR) && !str.endsWith("\t")) {
                    break;
                }
                str = str.substring(0, str.length() - 1);
            }
        } else {
            while (str.endsWith("\u0001")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    public boolean changeLeading() {
        return this.changeLeading;
    }

    public float getLeading() {
        return this.leading;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCharWidth(int i) {
        if (noPrint(i)) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        if (isAttribute(Chunk.CHAR_SPACING)) {
            return this.font.width(i) + (((Float) getAttribute(Chunk.CHAR_SPACING)).floatValue() * this.font.getHorizontalScaling());
        }
        return this.font.width(i);
    }
}
