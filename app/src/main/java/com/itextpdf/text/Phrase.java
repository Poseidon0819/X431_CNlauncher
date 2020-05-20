package com.itextpdf.text;

import com.itextpdf.text.Font;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.HyphenationEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Phrase extends ArrayList<Element> implements TextElementArray {
    private static final long serialVersionUID = 2643594602455068231L;
    protected Font font;
    protected HyphenationEvent hyphenation;
    protected float leading;

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return true;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return true;
    }

    public int type() {
        return 11;
    }

    public Phrase() {
        this(16.0f);
    }

    public Phrase(Phrase phrase) {
        this.leading = Float.NaN;
        this.hyphenation = null;
        addAll(phrase);
        this.leading = phrase.getLeading();
        this.font = phrase.getFont();
        setHyphenation(phrase.getHyphenation());
    }

    public Phrase(float f) {
        this.leading = Float.NaN;
        this.hyphenation = null;
        this.leading = f;
        this.font = new Font();
    }

    public Phrase(Chunk chunk) {
        this.leading = Float.NaN;
        this.hyphenation = null;
        super.add((Phrase) chunk);
        this.font = chunk.getFont();
        setHyphenation(chunk.getHyphenation());
    }

    public Phrase(float f, Chunk chunk) {
        this.leading = Float.NaN;
        this.hyphenation = null;
        this.leading = f;
        super.add((Phrase) chunk);
        this.font = chunk.getFont();
        setHyphenation(chunk.getHyphenation());
    }

    public Phrase(String str) {
        this(Float.NaN, str, new Font());
    }

    public Phrase(String str, Font font) {
        this(Float.NaN, str, font);
    }

    public Phrase(float f, String str) {
        this(f, str, new Font());
    }

    public Phrase(float f, String str, Font font) {
        this.leading = Float.NaN;
        this.hyphenation = null;
        this.leading = f;
        this.font = font;
        if (str == null || str.length() == 0) {
            return;
        }
        super.add((Phrase) new Chunk(str, font));
    }

    public boolean process(ElementListener elementListener) {
        try {
            Iterator<Element> it = iterator();
            while (it.hasNext()) {
                elementListener.add(it.next());
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public java.util.List<Chunk> getChunks() {
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getChunks());
        }
        return arrayList;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, Element element) {
        if (element == null) {
            return;
        }
        int type = element.type();
        if (type != 14 && type != 17 && type != 23 && type != 29 && type != 37 && type != 50 && type != 55 && type != 666) {
            switch (type) {
                case 10:
                    Chunk chunk = (Chunk) element;
                    if (!this.font.isStandardFont()) {
                        chunk.setFont(this.font.difference(chunk.getFont()));
                    }
                    if (this.hyphenation != null && chunk.getHyphenation() == null && !chunk.isEmpty()) {
                        chunk.setHyphenation(this.hyphenation);
                    }
                    super.add(i, (int) chunk);
                    return;
                case 11:
                case 12:
                    break;
                default:
                    throw new ClassCastException(MessageLocalization.getComposedMessage("insertion.of.illegal.element.1", element.getClass().getName()));
            }
        }
        super.add(i, (int) element);
    }

    public boolean add(String str) {
        if (str == null) {
            return false;
        }
        return super.add((Phrase) new Chunk(str, this.font));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Element element) {
        if (element == null) {
            return false;
        }
        try {
            int type = element.type();
            if (type != 14 && type != 17 && type != 23 && type != 29 && type != 37 && type != 50 && type != 55 && type != 666) {
                switch (type) {
                    case 10:
                        return addChunk((Chunk) element);
                    case 11:
                    case 12:
                        Iterator<Element> it = ((Phrase) element).iterator();
                        boolean z = true;
                        while (it.hasNext()) {
                            Element next = it.next();
                            if (next instanceof Chunk) {
                                z &= addChunk((Chunk) next);
                            } else {
                                z &= add(next);
                            }
                        }
                        return z;
                    default:
                        throw new ClassCastException(String.valueOf(element.type()));
                }
            }
            return super.add((Phrase) element);
        } catch (ClassCastException e) {
            throw new ClassCastException(MessageLocalization.getComposedMessage("insertion.of.illegal.element.1", e.getMessage()));
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Element> collection) {
        for (Element element : collection) {
            add(element);
        }
        return true;
    }

    protected boolean addChunk(Chunk chunk) {
        Font font = chunk.getFont();
        String content = chunk.getContent();
        Font font2 = this.font;
        if (font2 != null && !font2.isStandardFont()) {
            font = this.font.difference(chunk.getFont());
        }
        if (size() > 0 && !chunk.hasAttributes()) {
            try {
                Chunk chunk2 = (Chunk) get(size() - 1);
                if (!chunk2.hasAttributes() && ((font == null || font.compareTo(chunk2.getFont()) == 0) && !"".equals(chunk2.getContent().trim()) && !"".equals(content.trim()))) {
                    chunk2.append(content);
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        Chunk chunk3 = new Chunk(content, font);
        chunk3.setAttributes(chunk.getAttributes());
        if (this.hyphenation != null && chunk3.getHyphenation() == null && !chunk3.isEmpty()) {
            chunk3.setHyphenation(this.hyphenation);
        }
        return super.add((Phrase) chunk3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addSpecial(Element element) {
        super.add((Phrase) element);
    }

    public void setLeading(float f) {
        this.leading = f;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public float getLeading() {
        Font font;
        if (Float.isNaN(this.leading) && (font = this.font) != null) {
            return font.getCalculatedLeading(1.5f);
        }
        return this.leading;
    }

    public float getTotalLeading() {
        return getLeading();
    }

    public boolean hasLeading() {
        return !Float.isNaN(this.leading);
    }

    public Font getFont() {
        return this.font;
    }

    public String getContent() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Chunk chunk : getChunks()) {
            stringBuffer.append(chunk.toString());
        }
        return stringBuffer.toString();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        switch (size()) {
            case 0:
                return true;
            case 1:
                Element element = get(0);
                return element.type() == 10 && ((Chunk) element).isEmpty();
            default:
                return false;
        }
    }

    public HyphenationEvent getHyphenation() {
        return this.hyphenation;
    }

    public void setHyphenation(HyphenationEvent hyphenationEvent) {
        this.hyphenation = hyphenationEvent;
    }

    private Phrase(boolean z) {
        this.leading = Float.NaN;
        this.hyphenation = null;
    }

    public static final Phrase getInstance(String str) {
        return getInstance(16, str, new Font());
    }

    public static final Phrase getInstance(int i, String str) {
        return getInstance(i, str, new Font());
    }

    public static final Phrase getInstance(int i, String str, Font font) {
        Phrase phrase = new Phrase(true);
        phrase.setLeading(i);
        phrase.font = font;
        if (font.getFamily() != Font.FontFamily.SYMBOL && font.getFamily() != Font.FontFamily.ZAPFDINGBATS && font.getBaseFont() == null) {
            while (true) {
                int index = SpecialSymbol.index(str);
                if (index < 0) {
                    break;
                }
                if (index > 0) {
                    phrase.add((Element) new Chunk(str.substring(0, index), font));
                    str = str.substring(index);
                }
                Font font2 = new Font(Font.FontFamily.SYMBOL, font.getSize(), font.getStyle(), font.getColor());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(SpecialSymbol.getCorrespondingSymbol(str.charAt(0)));
                str = str.substring(1);
                while (SpecialSymbol.index(str) == 0) {
                    stringBuffer.append(SpecialSymbol.getCorrespondingSymbol(str.charAt(0)));
                    str = str.substring(1);
                }
                phrase.add((Element) new Chunk(stringBuffer.toString(), font2));
            }
        }
        if (str != null && str.length() != 0) {
            phrase.add((Element) new Chunk(str, font));
        }
        return phrase;
    }

    public boolean trim() {
        while (size() > 0) {
            Element element = get(0);
            if (!(element instanceof Chunk) || !((Chunk) element).isWhitespace()) {
                break;
            }
            remove(element);
        }
        while (size() > 0) {
            Element element2 = get(size() - 1);
            if (!(element2 instanceof Chunk) || !((Chunk) element2).isWhitespace()) {
                break;
            }
            remove(element2);
        }
        return size() > 0;
    }
}
