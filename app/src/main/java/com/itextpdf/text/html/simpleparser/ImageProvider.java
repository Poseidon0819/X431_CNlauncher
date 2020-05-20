package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.DocListener;
import com.itextpdf.text.Image;
import java.util.Map;

/* loaded from: classes.dex */
public interface ImageProvider {
    Image getImage(String str, Map<String, String> map, ChainedProperties chainedProperties, DocListener docListener);
}
