package com.itextpdf.text;

import java.util.EventListener;

/* loaded from: classes.dex */
public interface ElementListener extends EventListener {
    boolean add(Element element) throws DocumentException;
}
