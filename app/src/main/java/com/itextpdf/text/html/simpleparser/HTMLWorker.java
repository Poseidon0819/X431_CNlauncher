package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.TextElementArray;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes.dex */
public class HTMLWorker implements DocListener, SimpleXMLDocHandler {
    public static final String FONT_PROVIDER = "font_factory";
    public static final String IMG_BASEURL = "img_baseurl";
    public static final String IMG_PROCESSOR = "img_interface";
    public static final String IMG_PROVIDER = "img_provider";
    public static final String IMG_STORE = "img_static";
    public static final String LINK_PROVIDER = "alink_interface";
    private static Logger LOGGER = LoggerFactory.getLogger(HTMLWorker.class);
    private final ChainedProperties chain;
    protected Paragraph currentParagraph;
    protected DocListener document;
    private final ElementFactory factory;
    private boolean insidePRE;
    protected List<Element> objectList;
    private boolean pendingLI;
    private boolean pendingTD;
    private boolean pendingTR;
    private Map<String, Object> providers;
    protected boolean skipText;
    protected Stack<Element> stack;
    private StyleSheet style;
    private final Stack<boolean[]> tableState;
    protected Map<String, HTMLTagProcessor> tags;

    @Override // com.itextpdf.text.DocListener
    public void close() {
    }

    @Override // com.itextpdf.text.DocListener
    public boolean newPage() {
        return true;
    }

    @Override // com.itextpdf.text.DocListener
    public void open() {
    }

    @Override // com.itextpdf.text.DocListener
    public void resetPageCount() {
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMarginMirroring(boolean z) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMarginMirroringTopBottom(boolean z) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMargins(float f, float f2, float f3, float f4) {
        return true;
    }

    @Override // com.itextpdf.text.DocListener
    public void setPageCount(int i) {
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setPageSize(Rectangle rectangle) {
        return true;
    }

    public HTMLWorker(DocListener docListener) {
        this(docListener, null, null);
    }

    public HTMLWorker(DocListener docListener, Map<String, HTMLTagProcessor> map, StyleSheet styleSheet) {
        this.style = new StyleSheet();
        this.stack = new Stack<>();
        this.chain = new ChainedProperties();
        this.providers = new HashMap();
        this.factory = new ElementFactory();
        this.tableState = new Stack<>();
        this.pendingTR = false;
        this.pendingTD = false;
        this.pendingLI = false;
        this.insidePRE = false;
        this.skipText = false;
        this.document = docListener;
        setSupportedTags(map);
        setStyleSheet(styleSheet);
    }

    public void setSupportedTags(Map<String, HTMLTagProcessor> map) {
        if (map == null) {
            map = new HTMLTagProcessors();
        }
        this.tags = map;
    }

    public void setStyleSheet(StyleSheet styleSheet) {
        if (styleSheet == null) {
            styleSheet = new StyleSheet();
        }
        this.style = styleSheet;
    }

    public void parse(Reader reader) throws IOException {
        LOGGER.info("Please note, there is a more extended version of the HTMLWorker available in the iText XMLWorker");
        SimpleXMLParser.parse(this, null, reader, true);
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startDocument() {
        HashMap hashMap = new HashMap();
        this.style.applyStyle(HtmlTags.BODY, hashMap);
        this.chain.addToChain(HtmlTags.BODY, hashMap);
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startElement(String str, Map<String, String> map) {
        HTMLTagProcessor hTMLTagProcessor = this.tags.get(str);
        if (hTMLTagProcessor == null) {
            return;
        }
        this.style.applyStyle(str, map);
        StyleSheet.resolveStyleAttribute(map, this.chain);
        try {
            hTMLTagProcessor.startElement(this, str, map);
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void text(String str) {
        if (this.skipText) {
            return;
        }
        if (this.currentParagraph == null) {
            this.currentParagraph = createParagraph();
        }
        if (!this.insidePRE) {
            if (str.trim().length() == 0 && str.indexOf(32) < 0) {
                return;
            }
            str = HtmlUtilities.eliminateWhiteSpace(str);
        }
        this.currentParagraph.add((Element) createChunk(str));
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endElement(String str) {
        HTMLTagProcessor hTMLTagProcessor = this.tags.get(str);
        if (hTMLTagProcessor == null) {
            return;
        }
        try {
            hTMLTagProcessor.endElement(this, str);
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endDocument() {
        for (int i = 0; i < this.stack.size(); i++) {
            try {
                this.document.add(this.stack.elementAt(i));
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
        if (this.currentParagraph != null) {
            this.document.add(this.currentParagraph);
        }
        this.currentParagraph = null;
    }

    public void newLine() {
        if (this.currentParagraph == null) {
            this.currentParagraph = new Paragraph();
        }
        this.currentParagraph.add((Element) createChunk("\n"));
    }

    public void carriageReturn() throws DocumentException {
        if (this.currentParagraph == null) {
            return;
        }
        if (this.stack.empty()) {
            this.document.add(this.currentParagraph);
        } else {
            Element pop = this.stack.pop();
            if (pop instanceof TextElementArray) {
                ((TextElementArray) pop).add(this.currentParagraph);
            }
            this.stack.push(pop);
        }
        this.currentParagraph = null;
    }

    public void flushContent() {
        pushToStack(this.currentParagraph);
        this.currentParagraph = new Paragraph();
    }

    public void pushToStack(Element element) {
        if (element != null) {
            this.stack.push(element);
        }
    }

    public void updateChain(String str, Map<String, String> map) {
        this.chain.addToChain(str, map);
    }

    public void updateChain(String str) {
        this.chain.removeChain(str);
    }

    public void setProviders(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.providers = map;
        FontProvider fontProvider = map != null ? (FontProvider) map.get(FONT_PROVIDER) : null;
        if (fontProvider != null) {
            this.factory.setFontProvider(fontProvider);
        }
    }

    public Chunk createChunk(String str) {
        return this.factory.createChunk(str, this.chain);
    }

    public Paragraph createParagraph() {
        return this.factory.createParagraph(this.chain);
    }

    public com.itextpdf.text.List createList(String str) {
        return this.factory.createList(str, this.chain);
    }

    public ListItem createListItem() {
        return this.factory.createListItem(this.chain);
    }

    public LineSeparator createLineSeparator(Map<String, String> map) {
        return this.factory.createLineSeparator(map, this.currentParagraph.getLeading() / 2.0f);
    }

    public Image createImage(Map<String, String> map) throws DocumentException, IOException {
        String str = map.get(HtmlTags.SRC);
        if (str == null) {
            return null;
        }
        return this.factory.createImage(str, map, this.chain, this.document, (ImageProvider) this.providers.get(IMG_PROVIDER), (ImageStore) this.providers.get(IMG_STORE), (String) this.providers.get(IMG_BASEURL));
    }

    public CellWrapper createCell(String str) {
        return new CellWrapper(str, this.chain);
    }

    public void processLink() {
        String property;
        if (this.currentParagraph == null) {
            this.currentParagraph = new Paragraph();
        }
        LinkProcessor linkProcessor = (LinkProcessor) this.providers.get(LINK_PROVIDER);
        if ((linkProcessor == null || !linkProcessor.process(this.currentParagraph, this.chain)) && (property = this.chain.getProperty(HtmlTags.HREF)) != null) {
            for (Chunk chunk : this.currentParagraph.getChunks()) {
                chunk.setAnchor(property);
            }
        }
        if (this.stack.isEmpty()) {
            this.currentParagraph = new Paragraph(new Phrase(this.currentParagraph));
            return;
        }
        Paragraph paragraph = (Paragraph) this.stack.pop();
        paragraph.add((Element) new Phrase(this.currentParagraph));
        this.currentParagraph = paragraph;
    }

    public void processList() throws DocumentException {
        if (this.stack.empty()) {
            return;
        }
        Element pop = this.stack.pop();
        if (!(pop instanceof com.itextpdf.text.List)) {
            this.stack.push(pop);
        } else if (this.stack.empty()) {
            this.document.add(pop);
        } else {
            ((TextElementArray) this.stack.peek()).add(pop);
        }
    }

    public void processListItem() throws DocumentException {
        if (this.stack.empty()) {
            return;
        }
        Element pop = this.stack.pop();
        if (!(pop instanceof ListItem)) {
            this.stack.push(pop);
        } else if (this.stack.empty()) {
            this.document.add(pop);
        } else {
            ListItem listItem = (ListItem) pop;
            Element pop2 = this.stack.pop();
            if (!(pop2 instanceof com.itextpdf.text.List)) {
                this.stack.push(pop2);
                return;
            }
            ((com.itextpdf.text.List) pop2).add(listItem);
            listItem.adjustListSymbolFont();
            this.stack.push(pop2);
        }
    }

    public void processImage(Image image, Map<String, String> map) throws DocumentException {
        ImageProcessor imageProcessor = (ImageProcessor) this.providers.get(IMG_PROCESSOR);
        if (imageProcessor == null || !imageProcessor.process(image, map, this.chain, this.document)) {
            String str = map.get(HtmlTags.ALIGN);
            if (str != null) {
                carriageReturn();
            }
            if (this.currentParagraph == null) {
                this.currentParagraph = createParagraph();
            }
            this.currentParagraph.add((Element) new Chunk(image, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, true));
            this.currentParagraph.setAlignment(HtmlUtilities.alignmentValue(str));
            if (str != null) {
                carriageReturn();
            }
        }
    }

    public void processTable() throws DocumentException {
        PdfPTable createTable = ((TableWrapper) this.stack.pop()).createTable();
        createTable.setSplitRows(true);
        if (this.stack.empty()) {
            this.document.add(createTable);
        } else {
            ((TextElementArray) this.stack.peek()).add(createTable);
        }
    }

    public void processRow() {
        Element pop;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        boolean z2 = false;
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        int i = 0;
        do {
            pop = this.stack.pop();
            if (pop instanceof CellWrapper) {
                CellWrapper cellWrapper = (CellWrapper) pop;
                float width = cellWrapper.getWidth();
                arrayList2.add(Float.valueOf(width));
                z2 |= cellWrapper.isPercentage();
                if (width == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    i++;
                } else {
                    f += width;
                }
                arrayList.add(cellWrapper.getCell());
            }
        } while (!(pop instanceof TableWrapper));
        TableWrapper tableWrapper = (TableWrapper) pop;
        tableWrapper.addRow(arrayList);
        if (arrayList2.size() > 0) {
            float f2 = 100.0f - f;
            Collections.reverse(arrayList2);
            float[] fArr = new float[arrayList2.size()];
            int i2 = 0;
            while (true) {
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = ((Float) arrayList2.get(i2)).floatValue();
                if (fArr[i2] == ColumnText.GLOBAL_SPACE_CHAR_RATIO && z2 && i > 0) {
                    fArr[i2] = f2 / i;
                }
                if (fArr[i2] == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                tableWrapper.setColWidths(fArr);
            }
        }
        this.stack.push(tableWrapper);
    }

    public void pushTableState() {
        this.tableState.push(new boolean[]{this.pendingTR, this.pendingTD});
    }

    public void popTableState() {
        boolean[] pop = this.tableState.pop();
        this.pendingTR = pop[0];
        this.pendingTD = pop[1];
    }

    public boolean isPendingTR() {
        return this.pendingTR;
    }

    public void setPendingTR(boolean z) {
        this.pendingTR = z;
    }

    public boolean isPendingTD() {
        return this.pendingTD;
    }

    public void setPendingTD(boolean z) {
        this.pendingTD = z;
    }

    public boolean isPendingLI() {
        return this.pendingLI;
    }

    public void setPendingLI(boolean z) {
        this.pendingLI = z;
    }

    public boolean isInsidePRE() {
        return this.insidePRE;
    }

    public void setInsidePRE(boolean z) {
        this.insidePRE = z;
    }

    public boolean isSkipText() {
        return this.skipText;
    }

    public void setSkipText(boolean z) {
        this.skipText = z;
    }

    public static List<Element> parseToList(Reader reader, StyleSheet styleSheet) throws IOException {
        return parseToList(reader, styleSheet, null);
    }

    public static List<Element> parseToList(Reader reader, StyleSheet styleSheet, HashMap<String, Object> hashMap) throws IOException {
        return parseToList(reader, styleSheet, null, hashMap);
    }

    public static List<Element> parseToList(Reader reader, StyleSheet styleSheet, Map<String, HTMLTagProcessor> map, HashMap<String, Object> hashMap) throws IOException {
        HTMLWorker hTMLWorker = new HTMLWorker(null, map, styleSheet);
        hTMLWorker.document = hTMLWorker;
        hTMLWorker.setProviders(hashMap);
        hTMLWorker.objectList = new ArrayList();
        hTMLWorker.parse(reader);
        return hTMLWorker.objectList;
    }

    @Override // com.itextpdf.text.ElementListener
    public boolean add(Element element) throws DocumentException {
        this.objectList.add(element);
        return true;
    }

    @Deprecated
    public void setInterfaceProps(HashMap<String, Object> hashMap) {
        setProviders(hashMap);
    }

    @Deprecated
    public Map<String, Object> getInterfaceProps() {
        return this.providers;
    }
}
