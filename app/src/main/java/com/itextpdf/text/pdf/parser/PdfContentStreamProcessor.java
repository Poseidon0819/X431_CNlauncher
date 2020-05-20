package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.CMapAwareDocumentFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfLiteral;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfStream;
import com.itextpdf.text.pdf.PdfString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes.dex */
public class PdfContentStreamProcessor {
    public static final String DEFAULTOPERATOR = "DefaultOperator";
    private final RenderListener renderListener;
    private ResourceDictionary resources;
    private Matrix textLineMatrix;
    private Matrix textMatrix;
    private final Map<PdfName, XObjectDoHandler> xobjectDoHandlers;
    private final Stack<GraphicsState> gsStack = new Stack<>();
    private final Map<Integer, CMapAwareDocumentFont> cachedFonts = new HashMap();
    private final Stack<MarkedContentInfo> markedContentStack = new Stack<>();
    private final Map<String, ContentOperator> operators = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.itextpdf.text.pdf.parser.PdfContentStreamProcessor$1 */
    /* loaded from: classes.dex */
    public class C36371 {
    }

    public PdfContentStreamProcessor(RenderListener renderListener) {
        this.renderListener = renderListener;
        populateOperators();
        this.xobjectDoHandlers = new HashMap();
        populateXObjectDoHandlers();
        reset();
    }

    private void populateXObjectDoHandlers() {
        registerXObjectDoHandler(PdfName.DEFAULT, new IgnoreXObjectDoHandler(null));
        registerXObjectDoHandler(PdfName.FORM, new FormXObjectDoHandler(null));
        registerXObjectDoHandler(PdfName.IMAGE, new ImageXObjectDoHandler(null));
    }

    public XObjectDoHandler registerXObjectDoHandler(PdfName pdfName, XObjectDoHandler xObjectDoHandler) {
        return this.xobjectDoHandlers.put(pdfName, xObjectDoHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CMapAwareDocumentFont getFont(PRIndirectReference pRIndirectReference) {
        Integer valueOf = Integer.valueOf(pRIndirectReference.getNumber());
        CMapAwareDocumentFont cMapAwareDocumentFont = this.cachedFonts.get(valueOf);
        if (cMapAwareDocumentFont == null) {
            CMapAwareDocumentFont cMapAwareDocumentFont2 = new CMapAwareDocumentFont(pRIndirectReference);
            this.cachedFonts.put(valueOf, cMapAwareDocumentFont2);
            return cMapAwareDocumentFont2;
        }
        return cMapAwareDocumentFont;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CMapAwareDocumentFont getFont(PdfDictionary pdfDictionary) {
        return new CMapAwareDocumentFont(pdfDictionary);
    }

    private void populateOperators() {
        registerContentOperator(DEFAULTOPERATOR, new IgnoreOperatorContentOperator(null));
        registerContentOperator("q", new PushGraphicsState(null));
        registerContentOperator("Q", new PopGraphicsState(null));
        registerContentOperator("cm", new ModifyCurrentTransformationMatrix(null));
        registerContentOperator("gs", new ProcessGraphicsStateResource(null));
        SetTextCharacterSpacing setTextCharacterSpacing = new SetTextCharacterSpacing(null);
        registerContentOperator("Tc", setTextCharacterSpacing);
        SetTextWordSpacing setTextWordSpacing = new SetTextWordSpacing(null);
        registerContentOperator("Tw", setTextWordSpacing);
        registerContentOperator("Tz", new SetTextHorizontalScaling(null));
        SetTextLeading setTextLeading = new SetTextLeading(null);
        registerContentOperator("TL", setTextLeading);
        registerContentOperator("Tf", new SetTextFont(null));
        registerContentOperator("Tr", new SetTextRenderMode(null));
        registerContentOperator("Ts", new SetTextRise(null));
        registerContentOperator("BT", new BeginText(null));
        registerContentOperator("ET", new EndText(null));
        registerContentOperator("BMC", new BeginMarkedContent(null));
        registerContentOperator("BDC", new BeginMarkedContentDictionary(null));
        registerContentOperator("EMC", new EndMarkedContent(null));
        TextMoveStartNextLine textMoveStartNextLine = new TextMoveStartNextLine(null);
        registerContentOperator("Td", textMoveStartNextLine);
        registerContentOperator("TD", new TextMoveStartNextLineWithLeading(textMoveStartNextLine, setTextLeading));
        registerContentOperator("Tm", new TextSetTextMatrix(null));
        TextMoveNextLine textMoveNextLine = new TextMoveNextLine(textMoveStartNextLine);
        registerContentOperator("T*", textMoveNextLine);
        ShowText showText = new ShowText(null);
        registerContentOperator("Tj", new ShowText(null));
        MoveNextLineAndShowText moveNextLineAndShowText = new MoveNextLineAndShowText(textMoveNextLine, showText);
        registerContentOperator("'", moveNextLineAndShowText);
        registerContentOperator("\"", new MoveNextLineAndShowTextWithSpacing(setTextWordSpacing, setTextCharacterSpacing, moveNextLineAndShowText));
        registerContentOperator("TJ", new ShowTextArray(null));
        registerContentOperator("Do", new C3638Do(null));
    }

    public ContentOperator registerContentOperator(String str, ContentOperator contentOperator) {
        return this.operators.put(str, contentOperator);
    }

    public void reset() {
        this.gsStack.removeAllElements();
        this.gsStack.add(new GraphicsState());
        this.textMatrix = null;
        this.textLineMatrix = null;
        this.resources = new ResourceDictionary();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gs */
    public GraphicsState m2711gs() {
        return this.gsStack.peek();
    }

    private void invokeOperator(PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
        ContentOperator contentOperator = this.operators.get(pdfLiteral.toString());
        if (contentOperator == null) {
            contentOperator = this.operators.get(DEFAULTOPERATOR);
        }
        contentOperator.invoke(this, pdfLiteral, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginMarkedContent(PdfName pdfName, PdfDictionary pdfDictionary) {
        this.markedContentStack.push(new MarkedContentInfo(pdfName, pdfDictionary));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endMarkedContent() {
        this.markedContentStack.pop();
    }

    private String decode(PdfString pdfString) {
        byte[] bytes = pdfString.getBytes();
        return m2711gs().font.decode(bytes, 0, bytes.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginText() {
        this.renderListener.beginTextBlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endText() {
        this.renderListener.endTextBlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayPdfString(PdfString pdfString) {
        TextRenderInfo textRenderInfo = new TextRenderInfo(decode(pdfString), m2711gs(), this.textMatrix, this.markedContentStack);
        this.renderListener.renderText(textRenderInfo);
        this.textMatrix = new Matrix(textRenderInfo.getUnscaledWidth(), ColumnText.GLOBAL_SPACE_CHAR_RATIO).multiply(this.textMatrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayXObject(PdfName pdfName) throws IOException {
        PdfDictionary asDict = this.resources.getAsDict(PdfName.XOBJECT);
        PdfObject directObject = asDict.getDirectObject(pdfName);
        PdfStream pdfStream = (PdfStream) directObject;
        PdfName asName = pdfStream.getAsName(PdfName.SUBTYPE);
        if (directObject.isStream()) {
            XObjectDoHandler xObjectDoHandler = this.xobjectDoHandlers.get(asName);
            if (xObjectDoHandler == null) {
                xObjectDoHandler = this.xobjectDoHandlers.get(PdfName.DEFAULT);
            }
            xObjectDoHandler.handleXObject(this, pdfStream, asDict.getAsIndirectObject(pdfName));
            return;
        }
        throw new IllegalStateException(MessageLocalization.getComposedMessage("XObject.1.is.not.a.stream", pdfName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyTextAdjust(float f) {
        this.textMatrix = new Matrix(((-f) / 1000.0f) * m2711gs().fontSize * m2711gs().horizontalScaling, ColumnText.GLOBAL_SPACE_CHAR_RATIO).multiply(this.textMatrix);
    }

    public void processContent(byte[] bArr, PdfDictionary pdfDictionary) {
        this.resources.push(pdfDictionary);
        try {
            PdfContentParser pdfContentParser = new PdfContentParser(new PRTokeniser(bArr));
            ArrayList<PdfObject> arrayList = new ArrayList<>();
            while (pdfContentParser.parse(arrayList).size() > 0) {
                PdfLiteral pdfLiteral = (PdfLiteral) arrayList.get(arrayList.size() - 1);
                if ("BI".equals(pdfLiteral.toString())) {
                    PdfDictionary asDict = pdfDictionary != null ? pdfDictionary.getAsDict(PdfName.COLORSPACE) : null;
                    this.renderListener.renderImage(ImageRenderInfo.createForEmbeddedImage(m2711gs().ctm, InlineImageUtils.parseInlineImage(pdfContentParser, asDict), asDict));
                } else {
                    invokeOperator(pdfLiteral, arrayList);
                }
            }
            this.resources.pop();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ResourceDictionary extends PdfDictionary {
        private final List<PdfDictionary> resourcesStack = new ArrayList();

        public void push(PdfDictionary pdfDictionary) {
            this.resourcesStack.add(pdfDictionary);
        }

        public void pop() {
            List<PdfDictionary> list = this.resourcesStack;
            list.remove(list.size() - 1);
        }

        @Override // com.itextpdf.text.pdf.PdfDictionary
        public PdfObject getDirectObject(PdfName pdfName) {
            PdfObject directObject;
            for (int size = this.resourcesStack.size() - 1; size >= 0; size--) {
                PdfDictionary pdfDictionary = this.resourcesStack.get(size);
                if (pdfDictionary != null && (directObject = pdfDictionary.getDirectObject(pdfName)) != null) {
                    return directObject;
                }
            }
            return super.getDirectObject(pdfName);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class IgnoreOperatorContentOperator implements ContentOperator {
        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
        }

        private IgnoreOperatorContentOperator() {
        }

        /* synthetic */ IgnoreOperatorContentOperator(C36371 c36371) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ShowTextArray implements ContentOperator {
        private ShowTextArray() {
        }

        /* synthetic */ ShowTextArray(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            ListIterator<PdfObject> listIterator = ((PdfArray) arrayList.get(0)).listIterator();
            while (listIterator.hasNext()) {
                PdfObject next = listIterator.next();
                if (next instanceof PdfString) {
                    pdfContentStreamProcessor.displayPdfString((PdfString) next);
                } else {
                    pdfContentStreamProcessor.applyTextAdjust(((PdfNumber) next).floatValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MoveNextLineAndShowTextWithSpacing implements ContentOperator {
        private final MoveNextLineAndShowText moveNextLineAndShowText;
        private final SetTextCharacterSpacing setTextCharacterSpacing;
        private final SetTextWordSpacing setTextWordSpacing;

        public MoveNextLineAndShowTextWithSpacing(SetTextWordSpacing setTextWordSpacing, SetTextCharacterSpacing setTextCharacterSpacing, MoveNextLineAndShowText moveNextLineAndShowText) {
            this.setTextWordSpacing = setTextWordSpacing;
            this.setTextCharacterSpacing = setTextCharacterSpacing;
            this.moveNextLineAndShowText = moveNextLineAndShowText;
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            ArrayList<PdfObject> arrayList2 = new ArrayList<>(1);
            arrayList2.add(0, (PdfNumber) arrayList.get(0));
            this.setTextWordSpacing.invoke(pdfContentStreamProcessor, null, arrayList2);
            ArrayList<PdfObject> arrayList3 = new ArrayList<>(1);
            arrayList3.add(0, (PdfNumber) arrayList.get(1));
            this.setTextCharacterSpacing.invoke(pdfContentStreamProcessor, null, arrayList3);
            ArrayList<PdfObject> arrayList4 = new ArrayList<>(1);
            arrayList4.add(0, (PdfString) arrayList.get(2));
            this.moveNextLineAndShowText.invoke(pdfContentStreamProcessor, null, arrayList4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MoveNextLineAndShowText implements ContentOperator {
        private final ShowText showText;
        private final TextMoveNextLine textMoveNextLine;

        public MoveNextLineAndShowText(TextMoveNextLine textMoveNextLine, ShowText showText) {
            this.textMoveNextLine = textMoveNextLine;
            this.showText = showText;
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            this.textMoveNextLine.invoke(pdfContentStreamProcessor, null, new ArrayList<>(0));
            this.showText.invoke(pdfContentStreamProcessor, null, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ShowText implements ContentOperator {
        private ShowText() {
        }

        /* synthetic */ ShowText(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.displayPdfString((PdfString) arrayList.get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextMoveNextLine implements ContentOperator {
        private final TextMoveStartNextLine moveStartNextLine;

        public TextMoveNextLine(TextMoveStartNextLine textMoveStartNextLine) {
            this.moveStartNextLine = textMoveStartNextLine;
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            ArrayList<PdfObject> arrayList2 = new ArrayList<>(2);
            arrayList2.add(0, new PdfNumber(0));
            arrayList2.add(1, new PdfNumber(-pdfContentStreamProcessor.m2711gs().leading));
            this.moveStartNextLine.invoke(pdfContentStreamProcessor, null, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextSetTextMatrix implements ContentOperator {
        private TextSetTextMatrix() {
        }

        /* synthetic */ TextSetTextMatrix(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.textLineMatrix = new Matrix(((PdfNumber) arrayList.get(0)).floatValue(), ((PdfNumber) arrayList.get(1)).floatValue(), ((PdfNumber) arrayList.get(2)).floatValue(), ((PdfNumber) arrayList.get(3)).floatValue(), ((PdfNumber) arrayList.get(4)).floatValue(), ((PdfNumber) arrayList.get(5)).floatValue());
            pdfContentStreamProcessor.textMatrix = pdfContentStreamProcessor.textLineMatrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextMoveStartNextLineWithLeading implements ContentOperator {
        private final TextMoveStartNextLine moveStartNextLine;
        private final SetTextLeading setTextLeading;

        public TextMoveStartNextLineWithLeading(TextMoveStartNextLine textMoveStartNextLine, SetTextLeading setTextLeading) {
            this.moveStartNextLine = textMoveStartNextLine;
            this.setTextLeading = setTextLeading;
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            float floatValue = ((PdfNumber) arrayList.get(1)).floatValue();
            ArrayList<PdfObject> arrayList2 = new ArrayList<>(1);
            arrayList2.add(0, new PdfNumber(-floatValue));
            this.setTextLeading.invoke(pdfContentStreamProcessor, null, arrayList2);
            this.moveStartNextLine.invoke(pdfContentStreamProcessor, null, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextMoveStartNextLine implements ContentOperator {
        private TextMoveStartNextLine() {
        }

        /* synthetic */ TextMoveStartNextLine(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.textMatrix = new Matrix(((PdfNumber) arrayList.get(0)).floatValue(), ((PdfNumber) arrayList.get(1)).floatValue()).multiply(pdfContentStreamProcessor.textLineMatrix);
            pdfContentStreamProcessor.textLineMatrix = pdfContentStreamProcessor.textMatrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SetTextFont implements ContentOperator {
        private SetTextFont() {
        }

        /* synthetic */ SetTextFont(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            float floatValue = ((PdfNumber) arrayList.get(1)).floatValue();
            PdfObject pdfObject = pdfContentStreamProcessor.resources.getAsDict(PdfName.FONT).get((PdfName) arrayList.get(0));
            pdfContentStreamProcessor.m2711gs().font = pdfObject instanceof PdfDictionary ? pdfContentStreamProcessor.getFont((PdfDictionary) pdfObject) : pdfContentStreamProcessor.getFont((PRIndirectReference) pdfObject);
            pdfContentStreamProcessor.m2711gs().fontSize = floatValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SetTextRenderMode implements ContentOperator {
        private SetTextRenderMode() {
        }

        /* synthetic */ SetTextRenderMode(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.m2711gs().renderMode = ((PdfNumber) arrayList.get(0)).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SetTextRise implements ContentOperator {
        private SetTextRise() {
        }

        /* synthetic */ SetTextRise(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.m2711gs().rise = ((PdfNumber) arrayList.get(0)).floatValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SetTextLeading implements ContentOperator {
        private SetTextLeading() {
        }

        /* synthetic */ SetTextLeading(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.m2711gs().leading = ((PdfNumber) arrayList.get(0)).floatValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SetTextHorizontalScaling implements ContentOperator {
        private SetTextHorizontalScaling() {
        }

        /* synthetic */ SetTextHorizontalScaling(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.m2711gs().horizontalScaling = ((PdfNumber) arrayList.get(0)).floatValue() / 100.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SetTextCharacterSpacing implements ContentOperator {
        private SetTextCharacterSpacing() {
        }

        /* synthetic */ SetTextCharacterSpacing(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.m2711gs().characterSpacing = ((PdfNumber) arrayList.get(0)).floatValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SetTextWordSpacing implements ContentOperator {
        private SetTextWordSpacing() {
        }

        /* synthetic */ SetTextWordSpacing(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.m2711gs().wordSpacing = ((PdfNumber) arrayList.get(0)).floatValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ProcessGraphicsStateResource implements ContentOperator {
        private ProcessGraphicsStateResource() {
        }

        /* synthetic */ ProcessGraphicsStateResource(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            PdfName pdfName = (PdfName) arrayList.get(0);
            PdfDictionary asDict = pdfContentStreamProcessor.resources.getAsDict(PdfName.EXTGSTATE);
            if (asDict == null) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("resources.do.not.contain.extgstate.entry.unable.to.process.operator.1", pdfLiteral));
            }
            PdfDictionary asDict2 = asDict.getAsDict(pdfName);
            if (asDict2 == null) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.is.an.unknown.graphics.state.dictionary", pdfName));
            }
            PdfArray asArray = asDict2.getAsArray(PdfName.FONT);
            if (asArray != null) {
                CMapAwareDocumentFont font = pdfContentStreamProcessor.getFont((PRIndirectReference) asArray.getPdfObject(0));
                float floatValue = asArray.getAsNumber(1).floatValue();
                pdfContentStreamProcessor.m2711gs().font = font;
                pdfContentStreamProcessor.m2711gs().fontSize = floatValue;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PushGraphicsState implements ContentOperator {
        private PushGraphicsState() {
        }

        /* synthetic */ PushGraphicsState(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gsStack.push(new GraphicsState((GraphicsState) pdfContentStreamProcessor.gsStack.peek()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ModifyCurrentTransformationMatrix implements ContentOperator {
        private ModifyCurrentTransformationMatrix() {
        }

        /* synthetic */ ModifyCurrentTransformationMatrix(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            Matrix matrix = new Matrix(((PdfNumber) arrayList.get(0)).floatValue(), ((PdfNumber) arrayList.get(1)).floatValue(), ((PdfNumber) arrayList.get(2)).floatValue(), ((PdfNumber) arrayList.get(3)).floatValue(), ((PdfNumber) arrayList.get(4)).floatValue(), ((PdfNumber) arrayList.get(5)).floatValue());
            GraphicsState graphicsState = (GraphicsState) pdfContentStreamProcessor.gsStack.peek();
            graphicsState.ctm = matrix.multiply(graphicsState.ctm);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PopGraphicsState implements ContentOperator {
        private PopGraphicsState() {
        }

        /* synthetic */ PopGraphicsState(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gsStack.pop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BeginText implements ContentOperator {
        private BeginText() {
        }

        /* synthetic */ BeginText(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.textMatrix = new Matrix();
            pdfContentStreamProcessor.textLineMatrix = pdfContentStreamProcessor.textMatrix;
            pdfContentStreamProcessor.beginText();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class EndText implements ContentOperator {
        private EndText() {
        }

        /* synthetic */ EndText(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.textMatrix = null;
            pdfContentStreamProcessor.textLineMatrix = null;
            pdfContentStreamProcessor.endText();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BeginMarkedContent implements ContentOperator {
        private BeginMarkedContent() {
        }

        /* synthetic */ BeginMarkedContent(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            pdfContentStreamProcessor.beginMarkedContent((PdfName) arrayList.get(0), new PdfDictionary());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BeginMarkedContentDictionary implements ContentOperator {
        private BeginMarkedContentDictionary() {
        }

        /* synthetic */ BeginMarkedContentDictionary(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            pdfContentStreamProcessor.beginMarkedContent((PdfName) arrayList.get(0), getPropertiesDictionary(arrayList.get(1), pdfContentStreamProcessor.resources));
        }

        private PdfDictionary getPropertiesDictionary(PdfObject pdfObject, ResourceDictionary resourceDictionary) {
            if (pdfObject.isDictionary()) {
                return (PdfDictionary) pdfObject;
            }
            return resourceDictionary.getAsDict((PdfName) pdfObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class EndMarkedContent implements ContentOperator {
        private EndMarkedContent() {
        }

        /* synthetic */ EndMarkedContent(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            pdfContentStreamProcessor.endMarkedContent();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.itextpdf.text.pdf.parser.PdfContentStreamProcessor$Do */
    /* loaded from: classes.dex */
    public static class C3638Do implements ContentOperator {
        private C3638Do() {
        }

        /* synthetic */ C3638Do(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws IOException {
            pdfContentStreamProcessor.displayXObject((PdfName) arrayList.get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class FormXObjectDoHandler implements XObjectDoHandler {
        private FormXObjectDoHandler() {
        }

        /* synthetic */ FormXObjectDoHandler(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.XObjectDoHandler
        public void handleXObject(PdfContentStreamProcessor pdfContentStreamProcessor, PdfStream pdfStream, PdfIndirectReference pdfIndirectReference) {
            PdfDictionary asDict = pdfStream.getAsDict(PdfName.RESOURCES);
            try {
                byte[] contentBytesFromContentObject = ContentByteUtils.getContentBytesFromContentObject(pdfStream);
                PdfArray asArray = pdfStream.getAsArray(PdfName.MATRIX);
                new PushGraphicsState(null).invoke(pdfContentStreamProcessor, null, null);
                if (asArray != null) {
                    Matrix matrix = new Matrix(asArray.getAsNumber(0).floatValue(), asArray.getAsNumber(1).floatValue(), asArray.getAsNumber(2).floatValue(), asArray.getAsNumber(3).floatValue(), asArray.getAsNumber(4).floatValue(), asArray.getAsNumber(5).floatValue());
                    pdfContentStreamProcessor.m2711gs().ctm = matrix.multiply(pdfContentStreamProcessor.m2711gs().ctm);
                }
                pdfContentStreamProcessor.processContent(contentBytesFromContentObject, asDict);
                new PopGraphicsState(null).invoke(pdfContentStreamProcessor, null, null);
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ImageXObjectDoHandler implements XObjectDoHandler {
        private ImageXObjectDoHandler() {
        }

        /* synthetic */ ImageXObjectDoHandler(C36371 c36371) {
            this();
        }

        @Override // com.itextpdf.text.pdf.parser.XObjectDoHandler
        public void handleXObject(PdfContentStreamProcessor pdfContentStreamProcessor, PdfStream pdfStream, PdfIndirectReference pdfIndirectReference) {
            pdfContentStreamProcessor.renderListener.renderImage(ImageRenderInfo.createForXObject(pdfContentStreamProcessor.m2711gs().ctm, pdfIndirectReference, pdfContentStreamProcessor.resources.getAsDict(PdfName.COLORSPACE)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class IgnoreXObjectDoHandler implements XObjectDoHandler {
        @Override // com.itextpdf.text.pdf.parser.XObjectDoHandler
        public void handleXObject(PdfContentStreamProcessor pdfContentStreamProcessor, PdfStream pdfStream, PdfIndirectReference pdfIndirectReference) {
        }

        private IgnoreXObjectDoHandler() {
        }

        /* synthetic */ IgnoreXObjectDoHandler(C36371 c36371) {
            this();
        }
    }
}
