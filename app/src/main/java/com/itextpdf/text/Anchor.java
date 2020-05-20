package com.itextpdf.text;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Anchor extends Phrase {
    private static final long serialVersionUID = -852278536049236911L;
    protected String name;
    protected String reference;

    @Override // com.itextpdf.text.Phrase, com.itextpdf.text.Element
    public int type() {
        return 17;
    }

    public Anchor() {
        super(16.0f);
        this.name = null;
        this.reference = null;
    }

    public Anchor(float f) {
        super(f);
        this.name = null;
        this.reference = null;
    }

    public Anchor(Chunk chunk) {
        super(chunk);
        this.name = null;
        this.reference = null;
    }

    public Anchor(String str) {
        super(str);
        this.name = null;
        this.reference = null;
    }

    public Anchor(String str, Font font) {
        super(str, font);
        this.name = null;
        this.reference = null;
    }

    public Anchor(float f, Chunk chunk) {
        super(f, chunk);
        this.name = null;
        this.reference = null;
    }

    public Anchor(float f, String str) {
        super(f, str);
        this.name = null;
        this.reference = null;
    }

    public Anchor(float f, String str, Font font) {
        super(f, str, font);
        this.name = null;
        this.reference = null;
    }

    public Anchor(Phrase phrase) {
        super(phrase);
        this.name = null;
        this.reference = null;
        if (phrase instanceof Anchor) {
            Anchor anchor = (Anchor) phrase;
            setName(anchor.name);
            setReference(anchor.reference);
        }
    }

    @Override // com.itextpdf.text.Phrase, com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            boolean z = this.reference != null && this.reference.startsWith("#");
            boolean z2 = true;
            for (Chunk chunk : getChunks()) {
                if (this.name != null && z2 && !chunk.isEmpty()) {
                    chunk.setLocalDestination(this.name);
                    z2 = false;
                }
                if (z) {
                    chunk.setLocalGoto(this.reference.substring(1));
                }
                elementListener.add(chunk);
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    @Override // com.itextpdf.text.Phrase, com.itextpdf.text.Element
    public java.util.List<Chunk> getChunks() {
        String str = this.reference;
        boolean z = true;
        boolean z2 = str != null && str.startsWith("#");
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element instanceof Chunk) {
                Chunk chunk = (Chunk) element;
                z = applyAnchor(chunk, z, z2);
                arrayList.add(chunk);
            } else {
                for (Chunk chunk2 : element.getChunks()) {
                    z = applyAnchor(chunk2, z, z2);
                    arrayList.add(chunk2);
                }
            }
        }
        return arrayList;
    }

    protected boolean applyAnchor(Chunk chunk, boolean z, boolean z2) {
        if (this.name != null && z && !chunk.isEmpty()) {
            chunk.setLocalDestination(this.name);
            z = false;
        }
        if (z2) {
            chunk.setLocalGoto(this.reference.substring(1));
        } else {
            String str = this.reference;
            if (str != null) {
                chunk.setAnchor(str);
            }
        }
        return z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    public String getName() {
        return this.name;
    }

    public String getReference() {
        return this.reference;
    }

    public URL getUrl() {
        try {
            return new URL(this.reference);
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}
