package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class HTMLTagProcessors extends HashMap<String, HTMLTagProcessor> {
    private static final long serialVersionUID = -959260811961222824L;
    public static final HTMLTagProcessor EM_STRONG_STRIKE_SUP_SUP = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.1
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            String mapTag = mapTag(str);
            map.put(mapTag, null);
            hTMLWorker.updateChain(mapTag, map);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.updateChain(mapTag(str));
        }

        private String mapTag(String str) {
            return HtmlTags.f19621EM.equalsIgnoreCase(str) ? HtmlTags.f19629I : HtmlTags.STRONG.equalsIgnoreCase(str) ? HtmlTags.f19619B : HtmlTags.STRIKE.equalsIgnoreCase(str) ? HtmlTags.f19633S : str;
        }
    };

    /* renamed from: A */
    public static final HTMLTagProcessor f19639A = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.2
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.updateChain(str, map);
            hTMLWorker.flushContent();
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.processLink();
            hTMLWorker.updateChain(str);
        }
    };

    /* renamed from: BR */
    public static final HTMLTagProcessor f19640BR = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.3
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.newLine();
        }
    };
    public static final HTMLTagProcessor UL_OL = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.4
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingLI()) {
                hTMLWorker.endElement(HtmlTags.f19630LI);
            }
            hTMLWorker.setSkipText(true);
            hTMLWorker.updateChain(str, map);
            hTMLWorker.pushToStack(hTMLWorker.createList(str));
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingLI()) {
                hTMLWorker.endElement(HtmlTags.f19630LI);
            }
            hTMLWorker.setSkipText(false);
            hTMLWorker.updateChain(str);
            hTMLWorker.processList();
        }
    };

    /* renamed from: HR */
    public static final HTMLTagProcessor f19642HR = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.5
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.pushToStack(hTMLWorker.createLineSeparator(map));
        }
    };
    public static final HTMLTagProcessor SPAN = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.6
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.updateChain(str, map);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.updateChain(str);
        }
    };

    /* renamed from: H */
    public static final HTMLTagProcessor f19641H = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.7
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (!map.containsKey(HtmlTags.SIZE)) {
                map.put(HtmlTags.SIZE, Integer.toString(7 - Integer.parseInt(str.substring(1))));
            }
            hTMLWorker.updateChain(str, map);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str);
        }
    };

    /* renamed from: LI */
    public static final HTMLTagProcessor f19643LI = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.8
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingLI()) {
                hTMLWorker.endElement(str);
            }
            hTMLWorker.setSkipText(false);
            hTMLWorker.setPendingLI(true);
            hTMLWorker.updateChain(str, map);
            hTMLWorker.pushToStack(hTMLWorker.createListItem());
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.setPendingLI(false);
            hTMLWorker.setSkipText(true);
            hTMLWorker.updateChain(str);
            hTMLWorker.processListItem();
        }
    };
    public static final HTMLTagProcessor PRE = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.9
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (!map.containsKey(HtmlTags.FACE)) {
                map.put(HtmlTags.FACE, "Courier");
            }
            hTMLWorker.updateChain(str, map);
            hTMLWorker.setInsidePRE(true);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str);
            hTMLWorker.setInsidePRE(false);
        }
    };
    public static final HTMLTagProcessor DIV = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.10
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str, map);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str);
        }
    };
    public static final HTMLTagProcessor TABLE = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.11
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.pushToStack(new TableWrapper(map));
            hTMLWorker.pushTableState();
            hTMLWorker.setPendingTD(false);
            hTMLWorker.setPendingTR(false);
            hTMLWorker.setSkipText(true);
            map.remove(HtmlTags.ALIGN);
            map.put(HtmlTags.COLSPAN, "1");
            map.put(HtmlTags.ROWSPAN, "1");
            hTMLWorker.updateChain(str, map);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTR()) {
                hTMLWorker.endElement(HtmlTags.f19636TR);
            }
            hTMLWorker.updateChain(str);
            hTMLWorker.processTable();
            hTMLWorker.popTableState();
            hTMLWorker.setSkipText(false);
        }
    };

    /* renamed from: TR */
    public static final HTMLTagProcessor f19645TR = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.12
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTR()) {
                hTMLWorker.endElement(str);
            }
            hTMLWorker.setSkipText(true);
            hTMLWorker.setPendingTR(true);
            hTMLWorker.updateChain(str, map);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTD()) {
                hTMLWorker.endElement(HtmlTags.f19634TD);
            }
            hTMLWorker.setPendingTR(false);
            hTMLWorker.updateChain(str);
            hTMLWorker.processRow();
            hTMLWorker.setSkipText(true);
        }
    };

    /* renamed from: TD */
    public static final HTMLTagProcessor f19644TD = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.13
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTD()) {
                hTMLWorker.endElement(str);
            }
            hTMLWorker.setSkipText(false);
            hTMLWorker.setPendingTD(true);
            hTMLWorker.updateChain(HtmlTags.f19634TD, map);
            hTMLWorker.pushToStack(hTMLWorker.createCell(str));
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.setPendingTD(false);
            hTMLWorker.updateChain(HtmlTags.f19634TD);
            hTMLWorker.setSkipText(true);
        }
    };
    public static final HTMLTagProcessor IMG = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.14
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException, IOException {
            hTMLWorker.updateChain(str, map);
            hTMLWorker.processImage(hTMLWorker.createImage(map), map);
            hTMLWorker.updateChain(str);
        }
    };

    public HTMLTagProcessors() {
        put(HtmlTags.f19618A, f19639A);
        put(HtmlTags.f19619B, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.BODY, DIV);
        put(HtmlTags.f19620BR, f19640BR);
        put(HtmlTags.DIV, DIV);
        put(HtmlTags.f19621EM, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.FONT, SPAN);
        put(HtmlTags.f19622H1, f19641H);
        put(HtmlTags.f19623H2, f19641H);
        put(HtmlTags.f19624H3, f19641H);
        put(HtmlTags.f19625H4, f19641H);
        put(HtmlTags.f19626H5, f19641H);
        put(HtmlTags.f19627H6, f19641H);
        put(HtmlTags.f19628HR, f19642HR);
        put(HtmlTags.f19629I, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.IMG, IMG);
        put(HtmlTags.f19630LI, f19643LI);
        put(HtmlTags.f19631OL, UL_OL);
        put(HtmlTags.f19632P, DIV);
        put(HtmlTags.PRE, PRE);
        put(HtmlTags.f19633S, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.SPAN, SPAN);
        put(HtmlTags.STRIKE, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.STRONG, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.SUB, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.SUP, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.TABLE, TABLE);
        put(HtmlTags.f19634TD, f19644TD);
        put(HtmlTags.f19635TH, f19644TD);
        put(HtmlTags.f19636TR, f19645TR);
        put(HtmlTags.f19637U, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.f19638UL, UL_OL);
    }
}
