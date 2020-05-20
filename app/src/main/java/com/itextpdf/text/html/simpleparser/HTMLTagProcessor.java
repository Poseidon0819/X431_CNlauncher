package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public interface HTMLTagProcessor {
    void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException;

    void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException, IOException;
}
