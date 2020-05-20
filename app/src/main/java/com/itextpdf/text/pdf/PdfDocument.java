package com.itextpdf.text.pdf;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.MarkedObject;
import com.itextpdf.text.MarkedSection;
import com.itextpdf.text.Meta;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.Version;
import com.itextpdf.text.api.WriterOperation;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.draw.DrawInterface;
import com.itextpdf.text.pdf.internal.PdfAnnotationsImp;
import com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class PdfDocument extends Document {
    protected static final DecimalFormat SIXTEEN_DIGITS = new DecimalFormat("0000000000000000");
    static final String hangingPunctuation = ".,;:'";
    protected PdfDictionary additionalActions;
    PdfAnnotationsImp annotationsImp;
    protected PdfCollection collection;
    protected PdfOutline currentOutline;
    protected PdfContentByte graphics;
    int jsCounter;
    protected int markPoint;
    protected float nextMarginBottom;
    protected float nextMarginLeft;
    protected float nextMarginRight;
    protected float nextMarginTop;
    protected PdfAction openActionAction;
    protected String openActionName;
    protected PdfPageLabels pageLabels;
    protected PageResources pageResources;
    protected PdfOutline rootOutline;
    protected PdfContentByte text;
    protected int textEmptySize;
    protected PdfWriter writer;
    protected float leading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    protected int alignment = 0;
    protected float currentHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    protected boolean isSectionTitle = false;
    protected int leadingCount = 0;
    protected PdfAction anchorAction = null;
    protected boolean firstPageEvent = true;
    protected PdfLine line = null;
    protected ArrayList<PdfLine> lines = new ArrayList<>();
    protected int lastElementType = -1;
    protected Indentation indentation = new Indentation();
    protected PdfInfo info = new PdfInfo();
    protected PdfViewerPreferencesImp viewerPreferences = new PdfViewerPreferencesImp();
    protected TreeMap<String, Destination> localDestinations = new TreeMap<>();
    protected HashMap<String, PdfObject> documentLevelJS = new HashMap<>();
    protected HashMap<String, PdfObject> documentFileAttachment = new HashMap<>();
    protected Rectangle nextPageSize = null;
    protected HashMap<String, PdfRectangle> thisBoxSize = new HashMap<>();
    protected HashMap<String, PdfRectangle> boxSize = new HashMap<>();
    private boolean pageEmpty = true;
    protected PdfDictionary pageAA = null;
    protected boolean strictImageSequence = false;
    protected float imageEnd = -1.0f;
    protected Image imageWait = null;
    private ArrayList<Element> floatingElements = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class Indentation {
        float indentLeft = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float sectionIndentLeft = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float listIndentLeft = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float imageIndentLeft = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float indentRight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float sectionIndentRight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float imageIndentRight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float indentTop = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float indentBottom = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    /* loaded from: classes.dex */
    public static class PdfInfo extends PdfDictionary {
        PdfInfo() {
            addProducer();
            addCreationDate();
        }

        PdfInfo(String str, String str2, String str3) {
            this();
            addTitle(str2);
            addSubject(str3);
            addAuthor(str);
        }

        void addTitle(String str) {
            put(PdfName.TITLE, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        void addSubject(String str) {
            put(PdfName.SUBJECT, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        void addKeywords(String str) {
            put(PdfName.KEYWORDS, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        void addAuthor(String str) {
            put(PdfName.AUTHOR, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        void addCreator(String str) {
            put(PdfName.CREATOR, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        void addProducer() {
            put(PdfName.PRODUCER, new PdfString(Version.getInstance().getVersion()));
        }

        void addCreationDate() {
            PdfDate pdfDate = new PdfDate();
            put(PdfName.CREATIONDATE, pdfDate);
            put(PdfName.MODDATE, pdfDate);
        }

        void addkey(String str, String str2) {
            if (str.equals("Producer") || str.equals("CreationDate")) {
                return;
            }
            put(new PdfName(str), new PdfString(str2, PdfObject.TEXT_UNICODE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PdfCatalog extends PdfDictionary {
        PdfWriter writer;

        PdfCatalog(PdfIndirectReference pdfIndirectReference, PdfWriter pdfWriter) {
            super(CATALOG);
            this.writer = pdfWriter;
            put(PdfName.PAGES, pdfIndirectReference);
        }

        void addNames(TreeMap<String, Destination> treeMap, HashMap<String, PdfObject> hashMap, HashMap<String, PdfObject> hashMap2, PdfWriter pdfWriter) {
            if (treeMap.isEmpty() && hashMap.isEmpty() && hashMap2.isEmpty()) {
                return;
            }
            try {
                PdfDictionary pdfDictionary = new PdfDictionary();
                if (!treeMap.isEmpty()) {
                    PdfArray pdfArray = new PdfArray();
                    for (Map.Entry<String, Destination> entry : treeMap.entrySet()) {
                        String key = entry.getKey();
                        Destination value = entry.getValue();
                        if (value.destination != null) {
                            PdfIndirectReference pdfIndirectReference = value.reference;
                            pdfArray.add(new PdfString(key, null));
                            pdfArray.add(pdfIndirectReference);
                        }
                    }
                    if (pdfArray.size() > 0) {
                        PdfDictionary pdfDictionary2 = new PdfDictionary();
                        pdfDictionary2.put(PdfName.NAMES, pdfArray);
                        pdfDictionary.put(PdfName.DESTS, pdfWriter.addToBody(pdfDictionary2).getIndirectReference());
                    }
                }
                if (!hashMap.isEmpty()) {
                    pdfDictionary.put(PdfName.JAVASCRIPT, pdfWriter.addToBody(PdfNameTree.writeTree(hashMap, pdfWriter)).getIndirectReference());
                }
                if (!hashMap2.isEmpty()) {
                    pdfDictionary.put(PdfName.EMBEDDEDFILES, pdfWriter.addToBody(PdfNameTree.writeTree(hashMap2, pdfWriter)).getIndirectReference());
                }
                if (pdfDictionary.size() > 0) {
                    put(PdfName.NAMES, pdfWriter.addToBody(pdfDictionary).getIndirectReference());
                }
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }

        void setOpenAction(PdfAction pdfAction) {
            put(PdfName.OPENACTION, pdfAction);
        }

        void setAdditionalActions(PdfDictionary pdfDictionary) {
            try {
                put(PdfName.f19680AA, this.writer.addToBody(pdfDictionary).getIndirectReference());
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    public PdfDocument() {
        addProducer();
        addCreationDate();
    }

    public void addWriter(PdfWriter pdfWriter) throws DocumentException {
        if (this.writer == null) {
            this.writer = pdfWriter;
            this.annotationsImp = new PdfAnnotationsImp(pdfWriter);
            return;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("you.can.only.add.a.writer.to.a.pdfdocument.once", new Object[0]));
    }

    public float getLeading() {
        return this.leading;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLeading(float f) {
        this.leading = f;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.ElementListener
    public boolean add(Element element) throws DocumentException {
        MarkedObject title;
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            try {
                if (element.type() != 37) {
                    flushFloatingElements();
                }
                int type = element.type();
                if (type != 23) {
                    float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    if (type == 40) {
                        ensureNewLine();
                        flushLines();
                        float write = ((MultiColumnText) element).write(this.writer.getDirectContent(), this, indentTop() - this.currentHeight);
                        this.currentHeight += write;
                        this.text.moveText(ColumnText.GLOBAL_SPACE_CHAR_RATIO, write * (-1.0f));
                        this.pageEmpty = false;
                    } else if (type == 50) {
                        if ((element instanceof MarkedSection) && (title = ((MarkedSection) element).getTitle()) != null) {
                            title.process(this);
                        }
                        ((MarkedObject) element).process(this);
                    } else if (type == 55) {
                        DrawInterface drawInterface = (DrawInterface) element;
                        PdfContentByte pdfContentByte = this.graphics;
                        float indentLeft = indentLeft();
                        float indentBottom = indentBottom();
                        float indentRight = indentRight();
                        float indentTop = indentTop();
                        float indentTop2 = indentTop() - this.currentHeight;
                        if (this.leadingCount > 0) {
                            f = this.leading;
                        }
                        drawInterface.draw(pdfContentByte, indentLeft, indentBottom, indentRight, indentTop, indentTop2 - f);
                        this.pageEmpty = false;
                    } else if (type != 666) {
                        switch (type) {
                            case 0:
                                this.info.addkey(((Meta) element).getName(), ((Meta) element).getContent());
                                break;
                            case 1:
                                this.info.addTitle(((Meta) element).getContent());
                                break;
                            case 2:
                                this.info.addSubject(((Meta) element).getContent());
                                break;
                            case 3:
                                this.info.addKeywords(((Meta) element).getContent());
                                break;
                            case 4:
                                this.info.addAuthor(((Meta) element).getContent());
                                break;
                            case 5:
                                this.info.addProducer();
                                break;
                            case 6:
                                this.info.addCreationDate();
                                break;
                            case 7:
                                this.info.addCreator(((Meta) element).getContent());
                                break;
                            default:
                                switch (type) {
                                    case 10:
                                        if (this.line == null) {
                                            carriageReturn();
                                        }
                                        PdfChunk pdfChunk = new PdfChunk((Chunk) element, this.anchorAction);
                                        while (true) {
                                            PdfChunk add = this.line.add(pdfChunk);
                                            if (add != null) {
                                                carriageReturn();
                                                if (!pdfChunk.isNewlineSplit()) {
                                                    add.trimFirstSpace();
                                                }
                                                pdfChunk = add;
                                            } else {
                                                this.pageEmpty = false;
                                                if (pdfChunk.isAttribute(Chunk.NEWPAGE)) {
                                                    newPage();
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    case 11:
                                        this.leadingCount++;
                                        this.leading = ((Phrase) element).getTotalLeading();
                                        element.process(this);
                                        this.leadingCount--;
                                        break;
                                    case 12:
                                        this.leadingCount++;
                                        Paragraph paragraph = (Paragraph) element;
                                        addSpacing(paragraph.getSpacingBefore(), this.leading, paragraph.getFont());
                                        this.alignment = paragraph.getAlignment();
                                        this.leading = paragraph.getTotalLeading();
                                        carriageReturn();
                                        if (this.currentHeight + this.line.height() + this.leading > indentTop() - indentBottom()) {
                                            newPage();
                                        }
                                        this.indentation.indentLeft += paragraph.getIndentationLeft();
                                        this.indentation.indentRight += paragraph.getIndentationRight();
                                        carriageReturn();
                                        PdfPageEvent pageEvent = this.writer.getPageEvent();
                                        if (pageEvent != null && !this.isSectionTitle) {
                                            pageEvent.onParagraph(this.writer, this, indentTop() - this.currentHeight);
                                        }
                                        if (paragraph.getKeepTogether()) {
                                            carriageReturn();
                                            PdfPTable pdfPTable = new PdfPTable(1);
                                            pdfPTable.setWidthPercentage(100.0f);
                                            PdfPCell pdfPCell = new PdfPCell();
                                            pdfPCell.addElement(paragraph);
                                            pdfPCell.setBorder(0);
                                            pdfPCell.setPadding(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                                            pdfPTable.addCell(pdfPCell);
                                            this.indentation.indentLeft -= paragraph.getIndentationLeft();
                                            this.indentation.indentRight -= paragraph.getIndentationRight();
                                            add(pdfPTable);
                                            this.indentation.indentLeft += paragraph.getIndentationLeft();
                                            this.indentation.indentRight += paragraph.getIndentationRight();
                                        } else {
                                            this.line.setExtraIndent(paragraph.getFirstLineIndent());
                                            element.process(this);
                                            carriageReturn();
                                            addSpacing(paragraph.getSpacingAfter(), paragraph.getTotalLeading(), paragraph.getFont());
                                        }
                                        if (pageEvent != null && !this.isSectionTitle) {
                                            pageEvent.onParagraphEnd(this.writer, this, indentTop() - this.currentHeight);
                                        }
                                        this.alignment = 0;
                                        this.indentation.indentLeft -= paragraph.getIndentationLeft();
                                        this.indentation.indentRight -= paragraph.getIndentationRight();
                                        carriageReturn();
                                        this.leadingCount--;
                                        break;
                                    case 13:
                                    case 16:
                                        Section section = (Section) element;
                                        PdfPageEvent pageEvent2 = this.writer.getPageEvent();
                                        boolean z = section.isNotAddedYet() && section.getTitle() != null;
                                        if (section.isTriggerNewPage()) {
                                            newPage();
                                        }
                                        if (z) {
                                            float indentTop3 = indentTop() - this.currentHeight;
                                            int rotation = this.pageSize.getRotation();
                                            if (rotation == 90 || rotation == 180) {
                                                indentTop3 = this.pageSize.getHeight() - indentTop3;
                                            }
                                            PdfDestination pdfDestination = new PdfDestination(2, indentTop3);
                                            while (this.currentOutline.level() >= section.getDepth()) {
                                                this.currentOutline = this.currentOutline.parent();
                                            }
                                            this.currentOutline = new PdfOutline(this.currentOutline, pdfDestination, section.getBookmarkTitle(), section.isBookmarkOpen());
                                        }
                                        carriageReturn();
                                        this.indentation.sectionIndentLeft += section.getIndentationLeft();
                                        this.indentation.sectionIndentRight += section.getIndentationRight();
                                        if (section.isNotAddedYet() && pageEvent2 != null) {
                                            if (element.type() == 16) {
                                                pageEvent2.onChapter(this.writer, this, indentTop() - this.currentHeight, section.getTitle());
                                            } else {
                                                pageEvent2.onSection(this.writer, this, indentTop() - this.currentHeight, section.getDepth(), section.getTitle());
                                            }
                                        }
                                        if (z) {
                                            this.isSectionTitle = true;
                                            add(section.getTitle());
                                            this.isSectionTitle = false;
                                        }
                                        this.indentation.sectionIndentLeft += section.getIndentation();
                                        element.process(this);
                                        flushLines();
                                        this.indentation.sectionIndentLeft -= section.getIndentationLeft() + section.getIndentation();
                                        this.indentation.sectionIndentRight -= section.getIndentationRight();
                                        if (section.isComplete() && pageEvent2 != null) {
                                            if (element.type() == 16) {
                                                pageEvent2.onChapterEnd(this.writer, this, indentTop() - this.currentHeight);
                                                break;
                                            } else {
                                                pageEvent2.onSectionEnd(this.writer, this, indentTop() - this.currentHeight);
                                                break;
                                            }
                                        }
                                        break;
                                    case 14:
                                        List list = (List) element;
                                        if (list.isAlignindent()) {
                                            list.normalizeIndentation();
                                        }
                                        this.indentation.listIndentLeft += list.getIndentationLeft();
                                        this.indentation.indentRight += list.getIndentationRight();
                                        element.process(this);
                                        this.indentation.listIndentLeft -= list.getIndentationLeft();
                                        this.indentation.indentRight -= list.getIndentationRight();
                                        carriageReturn();
                                        break;
                                    case 15:
                                        this.leadingCount++;
                                        ListItem listItem = (ListItem) element;
                                        addSpacing(listItem.getSpacingBefore(), this.leading, listItem.getFont());
                                        this.alignment = listItem.getAlignment();
                                        this.indentation.listIndentLeft += listItem.getIndentationLeft();
                                        this.indentation.indentRight += listItem.getIndentationRight();
                                        this.leading = listItem.getTotalLeading();
                                        carriageReturn();
                                        this.line.setListItem(listItem);
                                        element.process(this);
                                        addSpacing(listItem.getSpacingAfter(), listItem.getTotalLeading(), listItem.getFont());
                                        if (this.line.hasToBeJustified()) {
                                            this.line.resetAlignment();
                                        }
                                        carriageReturn();
                                        this.indentation.listIndentLeft -= listItem.getIndentationLeft();
                                        this.indentation.indentRight -= listItem.getIndentationRight();
                                        this.leadingCount--;
                                        break;
                                    case 17:
                                        this.leadingCount++;
                                        Anchor anchor = (Anchor) element;
                                        String reference = anchor.getReference();
                                        this.leading = anchor.getLeading();
                                        if (reference != null) {
                                            this.anchorAction = new PdfAction(reference);
                                        }
                                        element.process(this);
                                        this.anchorAction = null;
                                        this.leadingCount--;
                                        break;
                                    default:
                                        switch (type) {
                                            case 29:
                                                if (this.line == null) {
                                                    carriageReturn();
                                                }
                                                Annotation annotation = (Annotation) element;
                                                Rectangle rectangle = new Rectangle(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                                                if (this.line != null) {
                                                    rectangle = new Rectangle(annotation.llx(indentRight() - this.line.widthLeft()), annotation.ury((indentTop() - this.currentHeight) - 20.0f), annotation.urx((indentRight() - this.line.widthLeft()) + 20.0f), annotation.lly(indentTop() - this.currentHeight));
                                                }
                                                this.annotationsImp.addPlainAnnotation(PdfAnnotationsImp.convertAnnotation(this.writer, annotation, rectangle));
                                                this.pageEmpty = false;
                                                break;
                                            case 30:
                                                this.graphics.rectangle((Rectangle) element);
                                                this.pageEmpty = false;
                                                break;
                                            default:
                                                switch (type) {
                                                    case 32:
                                                    case 33:
                                                    case 34:
                                                    case 35:
                                                    case 36:
                                                        add((Image) element);
                                                        break;
                                                    case 37:
                                                        ensureNewLine();
                                                        flushLines();
                                                        addDiv((PdfDiv) element);
                                                        this.pageEmpty = false;
                                                        break;
                                                    default:
                                                        return false;
                                                }
                                        }
                                }
                        }
                    } else if (this.writer != null) {
                        ((WriterOperation) element).write(this.writer, this);
                    }
                } else {
                    PdfPTable pdfPTable2 = (PdfPTable) element;
                    if (pdfPTable2.size() > pdfPTable2.getHeaderRows()) {
                        ensureNewLine();
                        flushLines();
                        addPTable(pdfPTable2);
                        this.pageEmpty = false;
                        newLine();
                    }
                }
                this.lastElementType = element.type();
                return true;
            } catch (Exception e) {
                throw new DocumentException(e);
            }
        }
        return false;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public void open() {
        if (!this.open) {
            super.open();
            this.writer.open();
            this.rootOutline = new PdfOutline(this.writer);
            this.currentOutline = this.rootOutline;
        }
        try {
            initPage();
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public void close() {
        if (this.close) {
            return;
        }
        try {
            boolean z = this.imageWait != null;
            newPage();
            if (this.imageWait != null || z) {
                newPage();
            }
            if (this.annotationsImp.hasUnusedAnnotations()) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("not.all.annotations.could.be.added.to.the.document.the.document.doesn.t.have.enough.pages", new Object[0]));
            }
            PdfPageEvent pageEvent = this.writer.getPageEvent();
            if (pageEvent != null) {
                pageEvent.onCloseDocument(this.writer, this);
            }
            super.close();
            this.writer.addLocalDestinations(this.localDestinations);
            calculateOutlineCount();
            writeOutlines();
            this.writer.close();
        } catch (Exception e) {
            throw ExceptionConverter.convertException(e);
        }
    }

    public void setXmpMetadata(byte[] bArr) throws IOException {
        PdfStream pdfStream = new PdfStream(bArr);
        pdfStream.put(PdfName.TYPE, PdfName.METADATA);
        pdfStream.put(PdfName.SUBTYPE, PdfName.XML);
        PdfEncryption encryption = this.writer.getEncryption();
        if (encryption != null && !encryption.isMetadataEncrypted()) {
            PdfArray pdfArray = new PdfArray();
            pdfArray.add(PdfName.CRYPT);
            pdfStream.put(PdfName.FILTER, pdfArray);
        }
        this.writer.addPageDictEntry(PdfName.METADATA, this.writer.addToBody(pdfStream).getIndirectReference());
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean newPage() {
        try {
            flushFloatingElements();
            this.lastElementType = -1;
            if (isPageEmpty()) {
                setNewPageSizeAndMargins();
                return false;
            } else if (!this.open || this.close) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("the.document.is.not.open", new Object[0]));
            } else {
                PdfPageEvent pageEvent = this.writer.getPageEvent();
                if (pageEvent != null) {
                    pageEvent.onEndPage(this.writer, this);
                }
                super.newPage();
                Indentation indentation = this.indentation;
                indentation.imageIndentLeft = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                indentation.imageIndentRight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                try {
                    flushLines();
                    int rotation = this.pageSize.getRotation();
                    if (this.writer.isPdfIso()) {
                        if (this.thisBoxSize.containsKey("art") && this.thisBoxSize.containsKey("trim")) {
                            throw new PdfXConformanceException(MessageLocalization.getComposedMessage("only.one.of.artbox.or.trimbox.can.exist.in.the.page", new Object[0]));
                        }
                        if (!this.thisBoxSize.containsKey("art") && !this.thisBoxSize.containsKey("trim")) {
                            if (this.thisBoxSize.containsKey("crop")) {
                                this.thisBoxSize.put("trim", this.thisBoxSize.get("crop"));
                            } else {
                                this.thisBoxSize.put("trim", new PdfRectangle(this.pageSize, this.pageSize.getRotation()));
                            }
                        }
                    }
                    this.pageResources.addDefaultColorDiff(this.writer.getDefaultColorspace());
                    if (this.writer.isRgbTransparencyBlending()) {
                        PdfDictionary pdfDictionary = new PdfDictionary();
                        pdfDictionary.put(PdfName.f19698CS, PdfName.DEVICERGB);
                        this.pageResources.addDefaultColorDiff(pdfDictionary);
                    }
                    PdfPage pdfPage = new PdfPage(new PdfRectangle(this.pageSize, rotation), this.thisBoxSize, this.pageResources.getResources(), rotation);
                    pdfPage.put(PdfName.TABS, this.writer.getTabs());
                    pdfPage.putAll(this.writer.getPageDictEntries());
                    this.writer.resetPageDictEntries();
                    if (this.pageAA != null) {
                        pdfPage.put(PdfName.f19680AA, this.writer.addToBody(this.pageAA).getIndirectReference());
                        this.pageAA = null;
                    }
                    if (this.annotationsImp.hasUnusedAnnotations()) {
                        PdfArray rotateAnnotations = this.annotationsImp.rotateAnnotations(this.writer, this.pageSize);
                        if (rotateAnnotations.size() != 0) {
                            pdfPage.put(PdfName.ANNOTS, rotateAnnotations);
                        }
                    }
                    if (this.writer.isTagged()) {
                        pdfPage.put(PdfName.STRUCTPARENTS, new PdfNumber(this.writer.getCurrentPageNumber() - 1));
                    }
                    if (this.text.size() > this.textEmptySize) {
                        this.text.endText();
                    } else {
                        this.text = null;
                    }
                    this.writer.add(pdfPage, new PdfContents(this.writer.getDirectContentUnder(), this.graphics, this.text, this.writer.getDirectContent(), this.pageSize));
                    initPage();
                    return true;
                } catch (DocumentException e) {
                    throw new ExceptionConverter(e);
                } catch (IOException e2) {
                    throw new ExceptionConverter(e2);
                }
            }
        } catch (DocumentException e3) {
            throw new ExceptionConverter(e3);
        }
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean setPageSize(Rectangle rectangle) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            this.nextPageSize = new Rectangle(rectangle);
            return true;
        }
        return false;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean setMargins(float f, float f2, float f3, float f4) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            this.nextMarginLeft = f;
            this.nextMarginRight = f2;
            this.nextMarginTop = f3;
            this.nextMarginBottom = f4;
            return true;
        }
        return false;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean setMarginMirroring(boolean z) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            return super.setMarginMirroring(z);
        }
        return false;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean setMarginMirroringTopBottom(boolean z) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            return super.setMarginMirroringTopBottom(z);
        }
        return false;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public void setPageCount(int i) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            super.setPageCount(i);
        }
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public void resetPageCount() {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            super.resetPageCount();
        }
    }

    protected void initPage() throws DocumentException {
        this.pageN++;
        this.annotationsImp.resetAnnotations();
        this.pageResources = new PageResources();
        this.writer.resetContent();
        this.graphics = new PdfContentByte(this.writer);
        this.markPoint = 0;
        setNewPageSizeAndMargins();
        this.imageEnd = -1.0f;
        Indentation indentation = this.indentation;
        indentation.imageIndentRight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        indentation.imageIndentLeft = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        indentation.indentBottom = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        indentation.indentTop = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.currentHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.thisBoxSize = new HashMap<>(this.boxSize);
        if (this.pageSize.getBackgroundColor() != null || this.pageSize.hasBorders() || this.pageSize.getBorderColor() != null) {
            add(this.pageSize);
        }
        float f = this.leading;
        int i = this.alignment;
        this.pageEmpty = true;
        try {
            if (this.imageWait != null) {
                add(this.imageWait);
                this.imageWait = null;
            }
            this.leading = f;
            this.alignment = i;
            carriageReturn();
            PdfPageEvent pageEvent = this.writer.getPageEvent();
            if (pageEvent != null) {
                if (this.firstPageEvent) {
                    pageEvent.onOpenDocument(this.writer, this);
                }
                pageEvent.onStartPage(this.writer, this);
            }
            this.firstPageEvent = false;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    protected void newLine() throws DocumentException {
        this.lastElementType = -1;
        carriageReturn();
        ArrayList<PdfLine> arrayList = this.lines;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.lines.add(this.line);
            this.currentHeight += this.line.height();
        }
        this.line = new PdfLine(indentLeft(), indentRight(), this.alignment, this.leading);
    }

    protected void carriageReturn() {
        if (this.lines == null) {
            this.lines = new ArrayList<>();
        }
        PdfLine pdfLine = this.line;
        if (pdfLine != null && pdfLine.size() > 0) {
            if (this.currentHeight + this.line.height() + this.leading > indentTop() - indentBottom()) {
                PdfLine pdfLine2 = this.line;
                this.line = null;
                newPage();
                this.line = pdfLine2;
            }
            this.currentHeight += this.line.height();
            this.lines.add(this.line);
            this.pageEmpty = false;
        }
        float f = this.imageEnd;
        if (f > -1.0f && this.currentHeight > f) {
            this.imageEnd = -1.0f;
            Indentation indentation = this.indentation;
            indentation.imageIndentRight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            indentation.imageIndentLeft = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        this.line = new PdfLine(indentLeft(), indentRight(), this.alignment, this.leading);
    }

    public float getVerticalPosition(boolean z) {
        if (z) {
            ensureNewLine();
        }
        return (top() - this.currentHeight) - this.indentation.indentTop;
    }

    protected void ensureNewLine() {
        try {
            if (this.lastElementType == 11 || this.lastElementType == 10) {
                newLine();
                flushLines();
            }
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    protected float flushLines() throws DocumentException {
        if (this.lines == null) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        PdfLine pdfLine = this.line;
        if (pdfLine != null && pdfLine.size() > 0) {
            this.lines.add(this.line);
            this.line = new PdfLine(indentLeft(), indentRight(), this.alignment, this.leading);
        }
        if (this.lines.isEmpty()) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        Object[] objArr = new Object[2];
        PdfFont pdfFont = null;
        objArr[1] = Float.valueOf((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        Iterator<PdfLine> it = this.lines.iterator();
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        while (it.hasNext()) {
            PdfLine next = it.next();
            float indentLeft = (next.indentLeft() - indentLeft()) + this.indentation.indentLeft + this.indentation.listIndentLeft + this.indentation.sectionIndentLeft;
            this.text.moveText(indentLeft, -next.height());
            if (next.listSymbol() != null) {
                ColumnText.showTextAligned(this.graphics, 0, new Phrase(next.listSymbol()), this.text.getXTLM() - next.listIndent(), this.text.getYTLM(), ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            }
            objArr[0] = pdfFont;
            writeLineToContent(next, this.text, this.graphics, objArr, this.writer.getSpaceCharRatio());
            pdfFont = (PdfFont) objArr[0];
            f += next.height();
            this.text.moveText(-indentLeft, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        }
        this.lines = new ArrayList<>();
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float writeLineToContent(PdfLine pdfLine, PdfContentByte pdfContentByte, PdfContentByte pdfContentByte2, Object[] objArr, float f) throws DocumentException {
        float f2;
        float widthLeft;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        char c;
        PdfChunk pdfChunk;
        float f8;
        int i;
        float f9;
        float f10;
        float f11;
        BaseColor baseColor;
        int i2;
        float f12;
        float f13;
        float f14;
        PdfFont pdfFont;
        BaseColor baseColor2;
        float f15;
        int i3;
        PdfFont pdfFont2;
        float f16;
        int i4;
        float f17;
        float f18;
        float f19;
        int i5;
        char c2;
        float width;
        int i6;
        PdfChunk pdfChunk2;
        float f20;
        float f21;
        float f22;
        PdfChunk pdfChunk3;
        float f23;
        float f24;
        BaseColor baseColor3;
        float f25;
        float f26;
        float f27;
        float f28;
        float f29;
        float f30;
        float f31;
        char c3;
        PdfDocument pdfDocument = this;
        PdfLine pdfLine2 = pdfLine;
        PdfContentByte pdfContentByte3 = pdfContentByte2;
        PdfFont pdfFont3 = (PdfFont) objArr[0];
        int i7 = 1;
        float floatValue = ((Float) objArr[1]).floatValue();
        float xtlm = pdfContentByte.getXTLM() + pdfLine.getOriginalWidth();
        int numberOfSpaces = pdfLine.numberOfSpaces();
        int lineLengthUtf32 = pdfLine.getLineLengthUtf32();
        boolean z = pdfLine.hasToBeJustified() && (numberOfSpaces != 0 || lineLengthUtf32 > 1);
        int separatorCount = pdfLine.getSeparatorCount();
        float f32 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (separatorCount > 0) {
            f2 = floatValue;
            widthLeft = xtlm;
            f3 = pdfLine.widthLeft() / separatorCount;
            f4 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f5 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (z && separatorCount == 0) {
            if (pdfLine.isNewlineSplit()) {
                float f33 = (((numberOfSpaces * f) + lineLengthUtf32) - 1.0f) * floatValue;
                if (pdfLine.widthLeft() >= f33) {
                    if (pdfLine.isRTL()) {
                        pdfContentByte.moveText(pdfLine.widthLeft() - f33, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                    }
                    f4 = floatValue;
                    f2 = f4;
                    widthLeft = xtlm;
                    f32 = f * floatValue;
                    f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    f5 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                }
            }
            float widthLeft2 = pdfLine.widthLeft();
            PdfChunk chunk = pdfLine2.getChunk(pdfLine.size() - 1);
            if (chunk != null) {
                String pdfChunk4 = chunk.toString();
                if (pdfChunk4.length() > 0) {
                    char charAt = pdfChunk4.charAt(pdfChunk4.length() - 1);
                    if (hangingPunctuation.indexOf(charAt) >= 0) {
                        float width2 = (chunk.font().width(charAt) * 0.4f) + widthLeft2;
                        f6 = width2 - widthLeft2;
                        widthLeft2 = width2;
                        float f34 = widthLeft2 / (((numberOfSpaces * f) + lineLengthUtf32) - 1.0f);
                        f4 = f34;
                        f2 = f4;
                        widthLeft = xtlm;
                        f5 = f6;
                        f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        f32 = f * f34;
                    }
                }
            }
            f6 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            float f342 = widthLeft2 / (((numberOfSpaces * f) + lineLengthUtf32) - 1.0f);
            f4 = f342;
            f2 = f4;
            widthLeft = xtlm;
            f5 = f6;
            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f32 = f * f342;
        } else if (pdfLine2.alignment == 0 || pdfLine2.alignment == -1) {
            f2 = floatValue;
            widthLeft = xtlm - pdfLine.widthLeft();
            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f4 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f32 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f5 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else {
            f2 = floatValue;
            widthLeft = xtlm;
            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f4 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f32 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f5 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        int lastStrokeChunk = pdfLine.getLastStrokeChunk();
        float xtlm2 = pdfContentByte.getXTLM();
        float ytlm = pdfContentByte.getYTLM();
        Iterator<PdfChunk> it = pdfLine.iterator();
        PdfFont pdfFont4 = pdfFont3;
        float f35 = xtlm2;
        int i8 = 0;
        boolean z2 = false;
        float f36 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float f37 = Float.NaN;
        while (it.hasNext()) {
            PdfChunk next = it.next();
            BaseColor color = next.color();
            float size = next.font().size();
            PdfFont pdfFont5 = pdfFont4;
            float fontDescriptor = next.font().getFont().getFontDescriptor(i7, size);
            float fontDescriptor2 = next.font().getFont().getFontDescriptor(3, size);
            if (i8 <= lastStrokeChunk) {
                if (z) {
                    width = next.getWidthCorrected(f4, f32);
                } else {
                    width = next.width();
                }
                if (next.isStroked()) {
                    PdfChunk chunk2 = pdfLine2.getChunk(i8 + 1);
                    if (next.isSeparator()) {
                        Object[] objArr2 = (Object[]) next.getAttribute(Chunk.SEPARATOR);
                        DrawInterface drawInterface = (DrawInterface) objArr2[0];
                        if (((Boolean) objArr2[1]).booleanValue()) {
                            pdfChunk2 = next;
                            f22 = f32;
                            pdfChunk3 = chunk2;
                            i6 = i8;
                            f20 = ytlm;
                            i = lastStrokeChunk;
                            f21 = f3;
                            f10 = f4;
                            drawInterface.draw(pdfContentByte2, xtlm2, ytlm + fontDescriptor2, xtlm2 + pdfLine.getOriginalWidth(), fontDescriptor - fontDescriptor2, f20);
                        } else {
                            pdfChunk2 = next;
                            i6 = i8;
                            i = lastStrokeChunk;
                            f21 = f3;
                            f10 = f4;
                            f22 = f32;
                            pdfChunk3 = chunk2;
                            float f38 = ytlm;
                            f20 = f38;
                            drawInterface.draw(pdfContentByte2, f35, f38 + fontDescriptor2, f35 + f21, fontDescriptor - fontDescriptor2, f38);
                        }
                        width = f21;
                    } else {
                        pdfChunk2 = next;
                        i6 = i8;
                        f20 = ytlm;
                        i = lastStrokeChunk;
                        f21 = f3;
                        f10 = f4;
                        f22 = f32;
                        pdfChunk3 = chunk2;
                    }
                    if (pdfChunk2.isTab()) {
                        PdfChunk pdfChunk5 = pdfChunk2;
                        Object[] objArr3 = (Object[]) pdfChunk5.getAttribute(Chunk.TAB);
                        DrawInterface drawInterface2 = (DrawInterface) objArr3[0];
                        float floatValue2 = ((Float) objArr3[1]).floatValue() + ((Float) objArr3[3]).floatValue();
                        if (floatValue2 > f35) {
                            pdfChunk = pdfChunk5;
                            drawInterface2.draw(pdfContentByte2, f35, f20 + fontDescriptor2, floatValue2, fontDescriptor - fontDescriptor2, f20);
                        } else {
                            pdfChunk = pdfChunk5;
                        }
                        f23 = floatValue2;
                        f36 = f35;
                    } else {
                        pdfChunk = pdfChunk2;
                        f23 = f35;
                    }
                    if (pdfChunk.isAttribute(Chunk.BACKGROUND)) {
                        float f39 = (pdfChunk3 == null || !pdfChunk3.isAttribute(Chunk.BACKGROUND)) ? f2 : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        if (pdfChunk3 == null) {
                            f39 += f5;
                        }
                        Object[] objArr4 = (Object[]) pdfChunk.getAttribute(Chunk.BACKGROUND);
                        pdfContentByte3.setColorFill((BaseColor) objArr4[0]);
                        float[] fArr = (float[]) objArr4[1];
                        f24 = f20;
                        pdfContentByte3.rectangle(f23 - fArr[0], ((f24 + fontDescriptor2) - fArr[1]) + pdfChunk.getTextRise(), (width - f39) + fArr[0] + fArr[2], (fontDescriptor - fontDescriptor2) + fArr[1] + fArr[3]);
                        pdfContentByte2.fill();
                        pdfContentByte3.setGrayFill(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                    } else {
                        f24 = f20;
                    }
                    if (pdfChunk.isAttribute(Chunk.UNDERLINE)) {
                        float f40 = (pdfChunk3 == null || !pdfChunk3.isAttribute(Chunk.UNDERLINE)) ? f2 : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        if (pdfChunk3 == null) {
                            f40 += f5;
                        }
                        Object[][] objArr5 = (Object[][]) pdfChunk.getAttribute(Chunk.UNDERLINE);
                        int i9 = 0;
                        while (i9 < objArr5.length) {
                            Object[] objArr6 = objArr5[i9];
                            BaseColor baseColor4 = (BaseColor) objArr6[0];
                            float[] fArr2 = (float[]) objArr6[1];
                            BaseColor baseColor5 = baseColor4 == null ? color : baseColor4;
                            if (baseColor5 != null) {
                                pdfContentByte3.setColorStroke(baseColor5);
                                c3 = 0;
                            } else {
                                c3 = 0;
                            }
                            Object[][] objArr7 = objArr5;
                            pdfContentByte3.setLineWidth(fArr2[c3] + (fArr2[1] * size));
                            float f41 = fArr2[2] + (fArr2[3] * size);
                            int i10 = (int) fArr2[4];
                            if (i10 != 0) {
                                pdfContentByte3.setLineCap(i10);
                            }
                            float f42 = f24 + f41;
                            pdfContentByte3.moveTo(f23, f42);
                            BaseColor baseColor6 = color;
                            pdfContentByte3.lineTo((f23 + width) - f40, f42);
                            pdfContentByte2.stroke();
                            if (baseColor5 != null) {
                                pdfContentByte2.resetGrayStroke();
                            }
                            if (i10 != 0) {
                                pdfContentByte3.setLineCap(0);
                            }
                            i9++;
                            color = baseColor6;
                            objArr5 = objArr7;
                        }
                        baseColor3 = color;
                        pdfContentByte3.setLineWidth(1.0f);
                    } else {
                        baseColor3 = color;
                    }
                    if (pdfChunk.isAttribute(Chunk.ACTION)) {
                        float f43 = (pdfChunk3 == null || !pdfChunk3.isAttribute(Chunk.ACTION)) ? f2 : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        if (pdfChunk3 == null) {
                            f43 += f5;
                        }
                        pdfContentByte.addAnnotation(new PdfAnnotation(pdfDocument.writer, f23, f24 + fontDescriptor2 + pdfChunk.getTextRise(), (f23 + width) - f43, f24 + fontDescriptor + pdfChunk.getTextRise(), (PdfAction) pdfChunk.getAttribute(Chunk.ACTION)));
                    }
                    if (pdfChunk.isAttribute(Chunk.REMOTEGOTO)) {
                        float f44 = (pdfChunk3 == null || !pdfChunk3.isAttribute(Chunk.REMOTEGOTO)) ? f2 : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        if (pdfChunk3 == null) {
                            f44 += f5;
                        }
                        Object[] objArr8 = (Object[]) pdfChunk.getAttribute(Chunk.REMOTEGOTO);
                        String str = (String) objArr8[0];
                        if (objArr8[1] instanceof String) {
                            f25 = f24;
                            f26 = f21;
                            f27 = f23;
                            remoteGoto(str, (String) objArr8[1], f23, pdfChunk.getTextRise() + f24 + fontDescriptor2, (f23 + width) - f44, f24 + fontDescriptor + pdfChunk.getTextRise());
                        } else {
                            f25 = f24;
                            f26 = f21;
                            f27 = f23;
                            remoteGoto(str, ((Integer) objArr8[1]).intValue(), f27, pdfChunk.getTextRise() + f25 + fontDescriptor2, (f27 + width) - f44, f25 + fontDescriptor + pdfChunk.getTextRise());
                        }
                    } else {
                        f25 = f24;
                        f26 = f21;
                        f27 = f23;
                    }
                    if (pdfChunk.isAttribute(Chunk.LOCALGOTO)) {
                        float f45 = (pdfChunk3 == null || !pdfChunk3.isAttribute(Chunk.LOCALGOTO)) ? f2 : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        if (pdfChunk3 == null) {
                            f45 += f5;
                        }
                        localGoto((String) pdfChunk.getAttribute(Chunk.LOCALGOTO), f27, f25, (f27 + width) - f45, f25 + size);
                    }
                    if (pdfChunk.isAttribute(Chunk.LOCALDESTINATION)) {
                        pdfDocument.localDestination((String) pdfChunk.getAttribute(Chunk.LOCALDESTINATION), new PdfDestination(0, f27, f25 + size, ColumnText.GLOBAL_SPACE_CHAR_RATIO));
                    }
                    if (pdfChunk.isAttribute(Chunk.GENERICTAG)) {
                        float f46 = (pdfChunk3 == null || !pdfChunk3.isAttribute(Chunk.GENERICTAG)) ? f2 : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        if (pdfChunk3 == null) {
                            f46 += f5;
                        }
                        Rectangle rectangle = new Rectangle(f27, f25, (f27 + width) - f46, f25 + size);
                        PdfPageEvent pageEvent = pdfDocument.writer.getPageEvent();
                        if (pageEvent != null) {
                            pageEvent.onGenericTag(pdfDocument.writer, pdfDocument, rectangle, (String) pdfChunk.getAttribute(Chunk.GENERICTAG));
                        }
                    }
                    if (pdfChunk.isAttribute(Chunk.PDFANNOTATION)) {
                        float f47 = (pdfChunk3 == null || !pdfChunk3.isAttribute(Chunk.PDFANNOTATION)) ? f2 : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        if (pdfChunk3 == null) {
                            f47 += f5;
                        }
                        PdfAnnotation shallowDuplicate = PdfFormField.shallowDuplicate((PdfAnnotation) pdfChunk.getAttribute(Chunk.PDFANNOTATION));
                        shallowDuplicate.put(PdfName.RECT, new PdfRectangle(f27, f25 + fontDescriptor2, (f27 + width) - f47, f25 + fontDescriptor));
                        pdfContentByte.addAnnotation(shallowDuplicate);
                    }
                    float[] fArr3 = (float[]) pdfChunk.getAttribute(Chunk.SKEW);
                    Float f48 = (Float) pdfChunk.getAttribute(Chunk.HSCALE);
                    if (fArr3 == null && f48 == null) {
                        f30 = 1.0f;
                    } else {
                        if (fArr3 != null) {
                            f28 = fArr3[0];
                            f29 = fArr3[1];
                        } else {
                            f28 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                            f29 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        }
                        float floatValue3 = f48 != null ? f48.floatValue() : 1.0f;
                        pdfContentByte.setTextMatrix(floatValue3, f28, f29, 1.0f, f27, f25);
                        f30 = floatValue3;
                    }
                    if (pdfChunk.isAttribute(Chunk.CHAR_SPACING)) {
                        pdfContentByte.setCharacterSpacing(((Float) pdfChunk.getAttribute(Chunk.CHAR_SPACING)).floatValue());
                    }
                    if (pdfChunk.isImage()) {
                        Image image = pdfChunk.getImage();
                        float[] matrix = image.matrix();
                        matrix[4] = (f27 + pdfChunk.getImageOffsetX()) - matrix[4];
                        matrix[5] = (pdfChunk.getImageOffsetY() + f25) - matrix[5];
                        float f49 = matrix[0];
                        float f50 = matrix[1];
                        float f51 = matrix[2];
                        float f52 = matrix[3];
                        float f53 = matrix[4];
                        float f54 = matrix[5];
                        f11 = f22;
                        baseColor = baseColor3;
                        i2 = numberOfSpaces;
                        f31 = f27;
                        f9 = f26;
                        f12 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        f8 = f25;
                        pdfContentByte2.addImage(image, f49, f50, f51, f52, f53, f54);
                        pdfContentByte.moveText(((f31 + f2) + image.getScaledWidth()) - pdfContentByte.getXTLM(), ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                    } else {
                        f31 = f27;
                        f8 = f25;
                        f9 = f26;
                        f11 = f22;
                        baseColor = baseColor3;
                        f12 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        i2 = numberOfSpaces;
                    }
                    f14 = f30;
                    f35 = f31;
                } else {
                    pdfChunk = next;
                    i6 = i8;
                    f8 = ytlm;
                    i = lastStrokeChunk;
                    f9 = f3;
                    f10 = f4;
                    f11 = f32;
                    baseColor = color;
                    i2 = numberOfSpaces;
                    f12 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    f14 = 1.0f;
                }
                i8 = i6 + 1;
                f13 = f35 + width;
            } else {
                pdfChunk = next;
                f8 = ytlm;
                i = lastStrokeChunk;
                f9 = f3;
                f10 = f4;
                f11 = f32;
                baseColor = color;
                i2 = numberOfSpaces;
                f12 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                f13 = f35;
                f14 = 1.0f;
            }
            if (pdfChunk.font().compareTo(pdfFont5) != 0) {
                pdfFont = pdfChunk.font();
                pdfContentByte.setFontAndSize(pdfFont.getFont(), pdfFont.size());
            } else {
                pdfFont = pdfFont5;
            }
            Object[] objArr9 = (Object[]) pdfChunk.getAttribute(Chunk.TEXTRENDERMODE);
            Float f55 = (Float) pdfChunk.getAttribute(Chunk.SUBSUPSCRIPT);
            if (objArr9 != null) {
                i3 = ((Integer) objArr9[0]).intValue() & 3;
                if (i3 != 0) {
                    pdfContentByte.setTextRenderingMode(i3);
                    i5 = 1;
                } else {
                    i5 = 1;
                }
                if (i3 == i5 || i3 == 2) {
                    f15 = ((Float) objArr9[i5]).floatValue();
                    if (f15 != 1.0f) {
                        pdfContentByte.setLineWidth(f15);
                        c2 = 2;
                    } else {
                        c2 = 2;
                    }
                    baseColor2 = (BaseColor) objArr9[c2];
                    if (baseColor2 == null) {
                        baseColor2 = baseColor;
                    }
                    if (baseColor2 != null) {
                        pdfContentByte.setColorStroke(baseColor2);
                    }
                } else {
                    baseColor2 = null;
                    f15 = 1.0f;
                }
            } else {
                baseColor2 = null;
                f15 = 1.0f;
                i3 = 0;
            }
            float floatValue4 = f55 != null ? f55.floatValue() : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            if (baseColor != null) {
                pdfContentByte.setColorFill(baseColor);
            }
            if (floatValue4 != f12) {
                pdfContentByte.setTextRise(floatValue4);
            }
            if (pdfChunk.isImage()) {
                pdfFont2 = pdfFont;
                i4 = i8;
                f17 = f10;
                f18 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                z2 = true;
            } else {
                if (pdfChunk.isHorizontalSeparator()) {
                    PdfTextArray pdfTextArray = new PdfTextArray();
                    f16 = f9;
                    pdfFont2 = pdfFont;
                    pdfTextArray.add((((-f16) * 1000.0f) / pdfChunk.font.size()) / f14);
                    pdfContentByte.showText(pdfTextArray);
                } else {
                    pdfFont2 = pdfFont;
                    f16 = f9;
                    if (pdfChunk.isTab()) {
                        PdfTextArray pdfTextArray2 = new PdfTextArray();
                        pdfTextArray2.add((((f36 - f13) * 1000.0f) / pdfChunk.font.size()) / f14);
                        pdfContentByte.showText(pdfTextArray2);
                    } else if (z && i2 > 0 && pdfChunk.isSpecialEncoding()) {
                        if (f14 != f37) {
                            pdfContentByte.setWordSpacing(f11 / f14);
                            f17 = f10;
                            pdfContentByte.setCharacterSpacing((f17 / f14) + pdfContentByte.getCharacterSpacing());
                            f37 = f14;
                        } else {
                            f17 = f10;
                        }
                        String pdfChunk6 = pdfChunk.toString();
                        i4 = i8;
                        int indexOf = pdfChunk6.indexOf(32);
                        if (indexOf < 0) {
                            pdfContentByte.showText(pdfChunk6);
                            f9 = f16;
                        } else {
                            f9 = f16;
                            float size2 = (((-f11) * 1000.0f) / pdfChunk.font.size()) / f14;
                            PdfTextArray pdfTextArray3 = new PdfTextArray(pdfChunk6.substring(0, indexOf));
                            while (true) {
                                int indexOf2 = pdfChunk6.indexOf(32, indexOf + 1);
                                if (indexOf2 < 0) {
                                    break;
                                }
                                pdfTextArray3.add(size2);
                                pdfTextArray3.add(pdfChunk6.substring(indexOf, indexOf2));
                                indexOf = indexOf2;
                            }
                            pdfTextArray3.add(size2);
                            pdfTextArray3.add(pdfChunk6.substring(indexOf));
                            pdfContentByte.showText(pdfTextArray3);
                        }
                        f18 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    } else {
                        i4 = i8;
                        f9 = f16;
                        f17 = f10;
                        if (z && f14 != f37) {
                            pdfContentByte.setWordSpacing(f11 / f14);
                            pdfContentByte.setCharacterSpacing((f17 / f14) + pdfContentByte.getCharacterSpacing());
                            f37 = f14;
                        }
                        pdfContentByte.showText(pdfChunk.toString());
                        f18 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    }
                }
                i4 = i8;
                f9 = f16;
                f17 = f10;
                f18 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
            if (floatValue4 != f18) {
                pdfContentByte.setTextRise(f18);
            }
            if (baseColor != null) {
                pdfContentByte.resetRGBColorFill();
            }
            if (i3 != 0) {
                pdfContentByte.setTextRenderingMode(0);
            }
            if (baseColor2 != null) {
                pdfContentByte.resetRGBColorStroke();
                f19 = 1.0f;
            } else {
                f19 = 1.0f;
            }
            if (f15 != f19) {
                pdfContentByte.setLineWidth(f19);
            }
            if (pdfChunk.isAttribute(Chunk.SKEW) || pdfChunk.isAttribute(Chunk.HSCALE)) {
                ytlm = f8;
                pdfContentByte.setTextMatrix(f13, ytlm);
                z2 = true;
            } else {
                ytlm = f8;
            }
            if (pdfChunk.isAttribute(Chunk.CHAR_SPACING)) {
                pdfContentByte.setCharacterSpacing(f17);
            }
            pdfContentByte3 = pdfContentByte2;
            f35 = f13;
            f4 = f17;
            f32 = f11;
            i8 = i4;
            numberOfSpaces = i2;
            lastStrokeChunk = i;
            f3 = f9;
            pdfDocument = this;
            pdfLine2 = pdfLine;
            i7 = 1;
            pdfFont4 = pdfFont2;
        }
        PdfFont pdfFont6 = pdfFont4;
        if (z) {
            f7 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            pdfContentByte.setWordSpacing(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            pdfContentByte.setCharacterSpacing(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            if (pdfLine.isNewlineSplit()) {
                f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
        } else {
            f7 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        if (z2) {
            pdfContentByte.moveText(xtlm2 - pdfContentByte.getXTLM(), f7);
            c = 0;
        } else {
            c = 0;
        }
        objArr[c] = pdfFont6;
        objArr[1] = Float.valueOf(f2);
        return widthLeft;
    }

    protected float indentLeft() {
        return left(this.indentation.indentLeft + this.indentation.listIndentLeft + this.indentation.imageIndentLeft + this.indentation.sectionIndentLeft);
    }

    protected float indentRight() {
        return right(this.indentation.indentRight + this.indentation.sectionIndentRight + this.indentation.imageIndentRight);
    }

    protected float indentTop() {
        return top(this.indentation.indentTop);
    }

    float indentBottom() {
        return bottom(this.indentation.indentBottom);
    }

    protected void addSpacing(float f, float f2, Font font) {
        Font font2;
        if (f == ColumnText.GLOBAL_SPACE_CHAR_RATIO || this.pageEmpty || this.currentHeight + this.line.height() + this.leading > indentTop() - indentBottom()) {
            return;
        }
        this.leading = f;
        carriageReturn();
        if (font.isUnderlined() || font.isStrikethru()) {
            font2 = new Font(font);
            font2.setStyle(font2.getStyle() & (-5) & (-9));
        } else {
            font2 = font;
        }
        new Chunk(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, font2).process(this);
        carriageReturn();
        this.leading = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfInfo getInfo() {
        return this.info;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfCatalog getCatalog(PdfIndirectReference pdfIndirectReference) {
        PdfCatalog pdfCatalog = new PdfCatalog(pdfIndirectReference, this.writer);
        if (this.rootOutline.getKids().size() > 0) {
            pdfCatalog.put(PdfName.PAGEMODE, PdfName.USEOUTLINES);
            pdfCatalog.put(PdfName.OUTLINES, this.rootOutline.indirectReference());
        }
        this.writer.getPdfVersion().addToCatalog(pdfCatalog);
        this.viewerPreferences.addToCatalog(pdfCatalog);
        if (this.pageLabels != null) {
            pdfCatalog.put(PdfName.PAGELABELS, this.pageLabels.getDictionary(this.writer));
        }
        pdfCatalog.addNames(this.localDestinations, getDocumentLevelJS(), this.documentFileAttachment, this.writer);
        String str = this.openActionName;
        if (str != null) {
            pdfCatalog.setOpenAction(getLocalGotoAction(str));
        } else {
            PdfAction pdfAction = this.openActionAction;
            if (pdfAction != null) {
                pdfCatalog.setOpenAction(pdfAction);
            }
        }
        PdfDictionary pdfDictionary = this.additionalActions;
        if (pdfDictionary != null) {
            pdfCatalog.setAdditionalActions(pdfDictionary);
        }
        if (this.collection != null) {
            pdfCatalog.put(PdfName.COLLECTION, this.collection);
        }
        if (this.annotationsImp.hasValidAcroForm()) {
            try {
                pdfCatalog.put(PdfName.ACROFORM, this.writer.addToBody(this.annotationsImp.getAcroForm()).getIndirectReference());
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        return pdfCatalog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOutline(PdfOutline pdfOutline, String str) {
        localDestination(str, pdfOutline.getPdfDestination());
    }

    public PdfOutline getRootOutline() {
        return this.rootOutline;
    }

    void calculateOutlineCount() {
        if (this.rootOutline.getKids().size() == 0) {
            return;
        }
        traverseOutlineCount(this.rootOutline);
    }

    void traverseOutlineCount(PdfOutline pdfOutline) {
        ArrayList<PdfOutline> kids = pdfOutline.getKids();
        PdfOutline parent = pdfOutline.parent();
        if (kids.isEmpty()) {
            if (parent != null) {
                parent.setCount(parent.getCount() + 1);
                return;
            }
            return;
        }
        for (int i = 0; i < kids.size(); i++) {
            traverseOutlineCount(kids.get(i));
        }
        if (parent != null) {
            if (pdfOutline.isOpen()) {
                parent.setCount(pdfOutline.getCount() + parent.getCount() + 1);
                return;
            }
            parent.setCount(parent.getCount() + 1);
            pdfOutline.setCount(-pdfOutline.getCount());
        }
    }

    void writeOutlines() throws IOException {
        if (this.rootOutline.getKids().size() == 0) {
            return;
        }
        outlineTree(this.rootOutline);
        PdfWriter pdfWriter = this.writer;
        PdfOutline pdfOutline = this.rootOutline;
        pdfWriter.addToBody(pdfOutline, pdfOutline.indirectReference());
    }

    void outlineTree(PdfOutline pdfOutline) throws IOException {
        pdfOutline.setIndirectReference(this.writer.getPdfIndirectReference());
        if (pdfOutline.parent() != null) {
            pdfOutline.put(PdfName.PARENT, pdfOutline.parent().indirectReference());
        }
        ArrayList<PdfOutline> kids = pdfOutline.getKids();
        int size = kids.size();
        for (int i = 0; i < size; i++) {
            outlineTree(kids.get(i));
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                kids.get(i2).put(PdfName.PREV, kids.get(i2 - 1).indirectReference());
            }
            if (i2 < size - 1) {
                kids.get(i2).put(PdfName.NEXT, kids.get(i2 + 1).indirectReference());
            }
        }
        if (size > 0) {
            pdfOutline.put(PdfName.FIRST, kids.get(0).indirectReference());
            pdfOutline.put(PdfName.LAST, kids.get(size - 1).indirectReference());
        }
        for (int i3 = 0; i3 < size; i3++) {
            PdfOutline pdfOutline2 = kids.get(i3);
            this.writer.addToBody(pdfOutline2, pdfOutline2.indirectReference());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setViewerPreferences(int i) {
        this.viewerPreferences.setViewerPreferences(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.viewerPreferences.addViewerPreference(pdfName, pdfObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPageLabels(PdfPageLabels pdfPageLabels) {
        this.pageLabels = pdfPageLabels;
    }

    public PdfPageLabels getPageLabels() {
        return this.pageLabels;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void localGoto(String str, float f, float f2, float f3, float f4) {
        this.annotationsImp.addPlainAnnotation(new PdfAnnotation(this.writer, f, f2, f3, f4, getLocalGotoAction(str)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remoteGoto(String str, String str2, float f, float f2, float f3, float f4) {
        this.annotationsImp.addPlainAnnotation(new PdfAnnotation(this.writer, f, f2, f3, f4, new PdfAction(str, str2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remoteGoto(String str, int i, float f, float f2, float f3, float f4) {
        addAnnotation(new PdfAnnotation(this.writer, f, f2, f3, f4, new PdfAction(str, i)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAction(PdfAction pdfAction, float f, float f2, float f3, float f4) {
        addAnnotation(new PdfAnnotation(this.writer, f, f2, f3, f4, pdfAction));
    }

    PdfAction getLocalGotoAction(String str) {
        Destination destination = this.localDestinations.get(str);
        if (destination == null) {
            destination = new Destination();
        }
        if (destination.action == null) {
            if (destination.reference == null) {
                destination.reference = this.writer.getPdfIndirectReference();
            }
            PdfAction pdfAction = new PdfAction(destination.reference);
            destination.action = pdfAction;
            this.localDestinations.put(str, destination);
            return pdfAction;
        }
        return destination.action;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean localDestination(String str, PdfDestination pdfDestination) {
        Destination destination = this.localDestinations.get(str);
        if (destination == null) {
            destination = new Destination();
        }
        if (destination.destination != null) {
            return false;
        }
        destination.destination = pdfDestination;
        this.localDestinations.put(str, destination);
        if (pdfDestination.hasPage()) {
            return true;
        }
        pdfDestination.addPage(this.writer.getCurrentPage());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addJavaScript(PdfAction pdfAction) {
        if (pdfAction.get(PdfName.f19733JS) == null) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("only.javascript.actions.are.allowed", new Object[0]));
        }
        try {
            HashMap<String, PdfObject> hashMap = this.documentLevelJS;
            DecimalFormat decimalFormat = SIXTEEN_DIGITS;
            int i = this.jsCounter;
            this.jsCounter = i + 1;
            hashMap.put(decimalFormat.format(i), this.writer.addToBody(pdfAction).getIndirectReference());
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addJavaScript(String str, PdfAction pdfAction) {
        if (pdfAction.get(PdfName.f19733JS) == null) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("only.javascript.actions.are.allowed", new Object[0]));
        }
        try {
            this.documentLevelJS.put(str, this.writer.addToBody(pdfAction).getIndirectReference());
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, PdfObject> getDocumentLevelJS() {
        return this.documentLevelJS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFileAttachment(String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        if (str == null) {
            PdfString pdfString = (PdfString) pdfFileSpecification.get(PdfName.DESC);
            str = pdfString == null ? "" : PdfEncodings.convertToString(pdfString.getBytes(), null);
        }
        pdfFileSpecification.addDescription(str, true);
        if (str.length() == 0) {
            str = "Unnamed";
        }
        String convertToString = PdfEncodings.convertToString(new PdfString(str, PdfObject.TEXT_UNICODE).getBytes(), null);
        int i = 0;
        while (this.documentFileAttachment.containsKey(convertToString)) {
            i++;
            convertToString = PdfEncodings.convertToString(new PdfString(str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + i, PdfObject.TEXT_UNICODE).getBytes(), null);
        }
        this.documentFileAttachment.put(convertToString, pdfFileSpecification.getReference());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, PdfObject> getDocumentFileAttachment() {
        return this.documentFileAttachment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOpenAction(String str) {
        this.openActionName = str;
        this.openActionAction = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOpenAction(PdfAction pdfAction) {
        this.openActionAction = pdfAction;
        this.openActionName = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAdditionalAction(PdfName pdfName, PdfAction pdfAction) {
        if (this.additionalActions == null) {
            this.additionalActions = new PdfDictionary();
        }
        if (pdfAction == null) {
            this.additionalActions.remove(pdfName);
        } else {
            this.additionalActions.put(pdfName, pdfAction);
        }
        if (this.additionalActions.size() == 0) {
            this.additionalActions = null;
        }
    }

    public void setCollection(PdfCollection pdfCollection) {
        this.collection = pdfCollection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfAcroForm getAcroForm() {
        return this.annotationsImp.getAcroForm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSigFlags(int i) {
        this.annotationsImp.setSigFlags(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCalculationOrder(PdfFormField pdfFormField) {
        this.annotationsImp.addCalculationOrder(pdfFormField);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        this.pageEmpty = false;
        this.annotationsImp.addAnnotation(pdfAnnotation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMarkPoint() {
        return this.markPoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void incMarkPoint() {
        this.markPoint++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCropBoxSize(Rectangle rectangle) {
        setBoxSize("crop", rectangle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBoxSize(String str, Rectangle rectangle) {
        if (rectangle == null) {
            this.boxSize.remove(str);
        } else {
            this.boxSize.put(str, new PdfRectangle(rectangle));
        }
    }

    protected void setNewPageSizeAndMargins() {
        this.pageSize = this.nextPageSize;
        if (this.marginMirroring && (getPageNumber() & 1) == 0) {
            this.marginRight = this.nextMarginLeft;
            this.marginLeft = this.nextMarginRight;
        } else {
            this.marginLeft = this.nextMarginLeft;
            this.marginRight = this.nextMarginRight;
        }
        if (this.marginMirroringTopBottom && (getPageNumber() & 1) == 0) {
            this.marginTop = this.nextMarginBottom;
            this.marginBottom = this.nextMarginTop;
        } else {
            this.marginTop = this.nextMarginTop;
            this.marginBottom = this.nextMarginBottom;
        }
        this.text = new PdfContentByte(this.writer);
        this.text.reset();
        this.text.beginText();
        this.textEmptySize = this.text.size();
        this.text.moveText(left(), top());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rectangle getBoxSize(String str) {
        PdfRectangle pdfRectangle = this.thisBoxSize.get(str);
        if (pdfRectangle != null) {
            return pdfRectangle.getRectangle();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPageEmpty(boolean z) {
        this.pageEmpty = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPageEmpty() {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter != null) {
            if (pdfWriter.getDirectContent().size() == 0 && this.writer.getDirectContentUnder().size() == 0) {
                return this.pageEmpty || this.writer.isPaused();
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDuration(int i) {
        if (i > 0) {
            this.writer.addPageDictEntry(PdfName.DUR, new PdfNumber(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTransition(PdfTransition pdfTransition) {
        this.writer.addPageDictEntry(PdfName.TRANS, pdfTransition.getTransitionDictionary());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPageAction(PdfName pdfName, PdfAction pdfAction) {
        if (this.pageAA == null) {
            this.pageAA = new PdfDictionary();
        }
        this.pageAA.put(pdfName, pdfAction);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setThumbnail(Image image) throws PdfException, DocumentException {
        PdfWriter pdfWriter = this.writer;
        PdfName pdfName = PdfName.THUMB;
        PdfWriter pdfWriter2 = this.writer;
        pdfWriter.addPageDictEntry(pdfName, pdfWriter2.getImageReference(pdfWriter2.addDirectImageSimple(image)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PageResources getPageResources() {
        return this.pageResources;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStrictImageSequence() {
        return this.strictImageSequence;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStrictImageSequence(boolean z) {
        this.strictImageSequence = z;
    }

    public void clearTextWrap() {
        float f = this.imageEnd - this.currentHeight;
        PdfLine pdfLine = this.line;
        if (pdfLine != null) {
            f += pdfLine.height();
        }
        if (this.imageEnd <= -1.0f || f <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            return;
        }
        carriageReturn();
        this.currentHeight += f;
    }

    protected void add(Image image) throws PdfException, DocumentException {
        if (image.hasAbsoluteY()) {
            this.graphics.addImage(image);
            this.pageEmpty = false;
            return;
        }
        if (this.currentHeight != ColumnText.GLOBAL_SPACE_CHAR_RATIO && (indentTop() - this.currentHeight) - image.getScaledHeight() < indentBottom()) {
            if (!this.strictImageSequence && this.imageWait == null) {
                this.imageWait = image;
                return;
            }
            newPage();
            if (this.currentHeight != ColumnText.GLOBAL_SPACE_CHAR_RATIO && (indentTop() - this.currentHeight) - image.getScaledHeight() < indentBottom()) {
                this.imageWait = image;
                return;
            }
        }
        this.pageEmpty = false;
        if (image == this.imageWait) {
            this.imageWait = null;
        }
        boolean z = (image.getAlignment() & 4) == 4 && (image.getAlignment() & 1) != 1;
        boolean z2 = (image.getAlignment() & 8) == 8;
        float f = this.leading;
        float f2 = f / 2.0f;
        float f3 = z ? f2 + f : f2;
        float indentTop = ((indentTop() - this.currentHeight) - image.getScaledHeight()) - f3;
        float[] matrix = image.matrix();
        float indentLeft = indentLeft() - matrix[4];
        if ((image.getAlignment() & 2) == 2) {
            indentLeft = (indentRight() - image.getScaledWidth()) - matrix[4];
        }
        if ((image.getAlignment() & 1) == 1) {
            indentLeft = (indentLeft() + (((indentRight() - indentLeft()) - image.getScaledWidth()) / 2.0f)) - matrix[4];
        }
        if (image.hasAbsoluteX()) {
            indentLeft = image.getAbsoluteX();
        }
        if (z) {
            float f4 = this.imageEnd;
            if (f4 < ColumnText.GLOBAL_SPACE_CHAR_RATIO || f4 < this.currentHeight + image.getScaledHeight() + f3) {
                this.imageEnd = this.currentHeight + image.getScaledHeight() + f3;
            }
            if ((image.getAlignment() & 2) == 2) {
                this.indentation.imageIndentRight += image.getScaledWidth() + image.getIndentationLeft();
            } else {
                this.indentation.imageIndentLeft += image.getScaledWidth() + image.getIndentationRight();
            }
        } else if ((image.getAlignment() & 2) == 2) {
            indentLeft -= image.getIndentationRight();
        } else {
            indentLeft = (image.getAlignment() & 1) == 1 ? indentLeft + (image.getIndentationLeft() - image.getIndentationRight()) : indentLeft + image.getIndentationLeft();
        }
        this.graphics.addImage(image, matrix[0], matrix[1], matrix[2], matrix[3], indentLeft, indentTop - matrix[5]);
        if (z || z2) {
            return;
        }
        this.currentHeight += image.getScaledHeight() + f3;
        flushLines();
        this.text.moveText(ColumnText.GLOBAL_SPACE_CHAR_RATIO, -(image.getScaledHeight() + f3));
        newLine();
    }

    void addPTable(PdfPTable pdfPTable) throws DocumentException {
        ColumnText columnText = new ColumnText(this.writer.getDirectContent());
        if (pdfPTable.getKeepTogether() && !fitsPage(pdfPTable, ColumnText.GLOBAL_SPACE_CHAR_RATIO) && this.currentHeight > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            newPage();
        }
        if (this.currentHeight == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            columnText.setAdjustFirstLine(false);
        }
        columnText.addElement(pdfPTable);
        boolean isHeadersInEvent = pdfPTable.isHeadersInEvent();
        pdfPTable.setHeadersInEvent(true);
        int i = 0;
        while (true) {
            columnText.setSimpleColumn(indentLeft(), indentBottom(), indentRight(), indentTop() - this.currentHeight);
            if ((columnText.m2716go() & 1) != 0) {
                this.text.moveText(ColumnText.GLOBAL_SPACE_CHAR_RATIO, (columnText.getYLine() - indentTop()) + this.currentHeight);
                this.currentHeight = indentTop() - columnText.getYLine();
                pdfPTable.setHeadersInEvent(isHeadersInEvent);
                return;
            }
            i = indentTop() - this.currentHeight == columnText.getYLine() ? i + 1 : 0;
            if (i == 3) {
                throw new DocumentException(MessageLocalization.getComposedMessage("infinite.table.loop", new Object[0]));
            }
            newPage();
        }
    }

    private void addDiv(PdfDiv pdfDiv) throws DocumentException {
        if (this.floatingElements == null) {
            this.floatingElements = new ArrayList<>();
        }
        this.floatingElements.add(pdfDiv);
    }

    private void flushFloatingElements() throws DocumentException {
        ArrayList<Element> arrayList = this.floatingElements;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<Element> arrayList2 = this.floatingElements;
        this.floatingElements = null;
        FloatLayout floatLayout = new FloatLayout(this.writer.getDirectContent(), arrayList2);
        int i = 0;
        while (true) {
            floatLayout.setSimpleColumn(indentLeft(), indentBottom(), indentRight(), indentTop() - this.currentHeight);
            if ((floatLayout.layout(false) & 1) != 0) {
                this.text.moveText(ColumnText.GLOBAL_SPACE_CHAR_RATIO, (floatLayout.getYLine() - indentTop()) + this.currentHeight);
                this.currentHeight = indentTop() - floatLayout.getYLine();
                return;
            }
            i = (indentTop() - this.currentHeight == floatLayout.getYLine() || isPageEmpty()) ? i + 1 : 0;
            if (i == 2) {
                return;
            }
            newPage();
        }
    }

    boolean fitsPage(PdfPTable pdfPTable, float f) {
        if (!pdfPTable.isLockedWidth()) {
            pdfPTable.setTotalWidth(((indentRight() - indentLeft()) * pdfPTable.getWidthPercentage()) / 100.0f);
        }
        ensureNewLine();
        float totalHeight = pdfPTable.isSkipFirstHeader() ? pdfPTable.getTotalHeight() - pdfPTable.getHeaderHeight() : pdfPTable.getTotalHeight();
        float f2 = this.currentHeight;
        float f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (f2 > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f3 = pdfPTable.spacingBefore();
        }
        return totalHeight + f3 <= ((indentTop() - this.currentHeight) - indentBottom()) - f;
    }

    /* loaded from: classes.dex */
    public class Destination {
        public PdfAction action;
        public PdfDestination destination;
        public PdfIndirectReference reference;

        public Destination() {
        }
    }
}
