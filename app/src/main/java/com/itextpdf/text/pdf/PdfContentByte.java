package com.itextpdf.text.pdf;

import com.itextpdf.p349a.FontMapper;
import com.itextpdf.p349a.PdfGraphics2D;
import com.itextpdf.p349a.PdfPrinterGraphics2D;
import com.itextpdf.p349a.p350a.AffineTransform;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgJBIG2;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.IllegalPdfSyntaxException;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.internal.PdfAnnotationsImp;
import java.awt.Graphics2D;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class PdfContentByte {
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 2;
    public static final int LINE_CAP_BUTT = 0;
    public static final int LINE_CAP_PROJECTING_SQUARE = 2;
    public static final int LINE_CAP_ROUND = 1;
    public static final int LINE_JOIN_BEVEL = 2;
    public static final int LINE_JOIN_MITER = 0;
    public static final int LINE_JOIN_ROUND = 1;
    public static final int TEXT_RENDER_MODE_CLIP = 7;
    public static final int TEXT_RENDER_MODE_FILL = 0;
    public static final int TEXT_RENDER_MODE_FILL_CLIP = 4;
    public static final int TEXT_RENDER_MODE_FILL_STROKE = 2;
    public static final int TEXT_RENDER_MODE_FILL_STROKE_CLIP = 6;
    public static final int TEXT_RENDER_MODE_INVISIBLE = 3;
    public static final int TEXT_RENDER_MODE_STROKE = 1;
    public static final int TEXT_RENDER_MODE_STROKE_CLIP = 5;
    private static HashMap<PdfName, String> abrev;
    private static final float[] unitRect = {ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, 1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, 1.0f};
    protected ArrayList<Integer> layerDepth;
    protected PdfDocument pdf;
    protected PdfWriter writer;
    protected ByteBuffer content = new ByteBuffer();
    protected GraphicState state = new GraphicState();
    protected ArrayList<GraphicState> stateList = new ArrayList<>();
    protected int separator = 10;
    private int mcDepth = 0;
    private boolean inText = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GraphicState {
        protected float charSpace;
        ColorDetails colorDetails;
        FontDetails fontDetails;
        protected float leading;
        protected float scale;
        float size;
        protected float wordSpace;
        protected float xTLM;
        protected float yTLM;

        GraphicState() {
            this.xTLM = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.yTLM = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.leading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.scale = 100.0f;
            this.charSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.wordSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }

        GraphicState(GraphicState graphicState) {
            this.xTLM = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.yTLM = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.leading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.scale = 100.0f;
            this.charSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.wordSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.fontDetails = graphicState.fontDetails;
            this.colorDetails = graphicState.colorDetails;
            this.size = graphicState.size;
            this.xTLM = graphicState.xTLM;
            this.yTLM = graphicState.yTLM;
            this.leading = graphicState.leading;
            this.scale = graphicState.scale;
            this.charSpace = graphicState.charSpace;
            this.wordSpace = graphicState.wordSpace;
        }
    }

    static {
        HashMap<PdfName, String> hashMap = new HashMap<>();
        abrev = hashMap;
        hashMap.put(PdfName.BITSPERCOMPONENT, "/BPC ");
        abrev.put(PdfName.COLORSPACE, "/CS ");
        abrev.put(PdfName.DECODE, "/D ");
        abrev.put(PdfName.DECODEPARMS, "/DP ");
        abrev.put(PdfName.FILTER, "/F ");
        abrev.put(PdfName.HEIGHT, "/H ");
        abrev.put(PdfName.IMAGEMASK, "/IM ");
        abrev.put(PdfName.INTENT, "/Intent ");
        abrev.put(PdfName.INTERPOLATE, "/I ");
        abrev.put(PdfName.WIDTH, "/W ");
    }

    public PdfContentByte(PdfWriter pdfWriter) {
        if (pdfWriter != null) {
            this.writer = pdfWriter;
            this.pdf = this.writer.getPdfDocument();
        }
    }

    public String toString() {
        return this.content.toString();
    }

    public ByteBuffer getInternalBuffer() {
        return this.content;
    }

    public byte[] toPdf(PdfWriter pdfWriter) {
        sanityCheck();
        return this.content.toByteArray();
    }

    public void add(PdfContentByte pdfContentByte) {
        PdfWriter pdfWriter = pdfContentByte.writer;
        if (pdfWriter != null && this.writer != pdfWriter) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("inconsistent.writers.are.you.mixing.two.documents", new Object[0]));
        }
        this.content.append(pdfContentByte.content);
    }

    public float getXTLM() {
        return this.state.xTLM;
    }

    public float getYTLM() {
        return this.state.yTLM;
    }

    public float getLeading() {
        return this.state.leading;
    }

    public float getCharacterSpacing() {
        return this.state.charSpace;
    }

    public float getWordSpacing() {
        return this.state.wordSpace;
    }

    public float getHorizontalScaling() {
        return this.state.scale;
    }

    public void setFlatness(float f) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO || f > 100.0f) {
            return;
        }
        this.content.append(f).append(" i").append_i(this.separator);
    }

    public void setLineCap(int i) {
        if (i < 0 || i > 2) {
            return;
        }
        this.content.append(i).append(" J").append_i(this.separator);
    }

    public void setLineDash(float f) {
        this.content.append("[] ").append(f).append(" d").append_i(this.separator);
    }

    public void setLineDash(float f, float f2) {
        this.content.append("[").append(f).append("] ").append(f2).append(" d").append_i(this.separator);
    }

    public void setLineDash(float f, float f2, float f3) {
        this.content.append("[").append(f).append(TokenParser.f24154SP).append(f2).append("] ").append(f3).append(" d").append_i(this.separator);
    }

    public final void setLineDash(float[] fArr, float f) {
        this.content.append("[");
        for (int i = 0; i < fArr.length; i++) {
            this.content.append(fArr[i]);
            if (i < fArr.length - 1) {
                this.content.append(TokenParser.f24154SP);
            }
        }
        this.content.append("] ").append(f).append(" d").append_i(this.separator);
    }

    public void setLineJoin(int i) {
        if (i < 0 || i > 2) {
            return;
        }
        this.content.append(i).append(" j").append_i(this.separator);
    }

    public void setLineWidth(float f) {
        this.content.append(f).append(" w").append_i(this.separator);
    }

    public void setMiterLimit(float f) {
        if (f > 1.0f) {
            this.content.append(f).append(" M").append_i(this.separator);
        }
    }

    public void clip() {
        this.content.append("W").append_i(this.separator);
    }

    public void eoClip() {
        this.content.append("W*").append_i(this.separator);
    }

    public void setGrayFill(float f) {
        this.content.append(f).append(" g").append_i(this.separator);
    }

    public void resetGrayFill() {
        this.content.append("0 g").append_i(this.separator);
    }

    public void setGrayStroke(float f) {
        this.content.append(f).append(" G").append_i(this.separator);
    }

    public void resetGrayStroke() {
        this.content.append("0 G").append_i(this.separator);
    }

    private void HelperRGB(float f, float f2, float f3) {
        PdfWriter.checkPdfIsoConformance(this.writer, 3, null);
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        this.content.append(f).append(TokenParser.f24154SP).append(f2).append(TokenParser.f24154SP).append(f3);
    }

    public void setRGBColorFillF(float f, float f2, float f3) {
        HelperRGB(f, f2, f3);
        this.content.append(" rg").append_i(this.separator);
    }

    public void resetRGBColorFill() {
        this.content.append("0 g").append_i(this.separator);
    }

    public void setRGBColorStrokeF(float f, float f2, float f3) {
        HelperRGB(f, f2, f3);
        this.content.append(" RG").append_i(this.separator);
    }

    public void resetRGBColorStroke() {
        this.content.append("0 G").append_i(this.separator);
    }

    private void HelperCMYK(float f, float f2, float f3, float f4) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        if (f4 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f4 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        this.content.append(f).append(TokenParser.f24154SP).append(f2).append(TokenParser.f24154SP).append(f3).append(TokenParser.f24154SP).append(f4);
    }

    public void setCMYKColorFillF(float f, float f2, float f3, float f4) {
        HelperCMYK(f, f2, f3, f4);
        this.content.append(" k").append_i(this.separator);
    }

    public void resetCMYKColorFill() {
        this.content.append("0 0 0 1 k").append_i(this.separator);
    }

    public void setCMYKColorStrokeF(float f, float f2, float f3, float f4) {
        HelperCMYK(f, f2, f3, f4);
        this.content.append(" K").append_i(this.separator);
    }

    public void resetCMYKColorStroke() {
        this.content.append("0 0 0 1 K").append_i(this.separator);
    }

    public void moveTo(float f, float f2) {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append(f).append(TokenParser.f24154SP).append(f2).append(" m").append_i(this.separator);
    }

    public void lineTo(float f, float f2) {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append(f).append(TokenParser.f24154SP).append(f2).append(" l").append_i(this.separator);
    }

    public void curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append(f).append(TokenParser.f24154SP).append(f2).append(TokenParser.f24154SP).append(f3).append(TokenParser.f24154SP).append(f4).append(TokenParser.f24154SP).append(f5).append(TokenParser.f24154SP).append(f6).append(" c").append_i(this.separator);
    }

    public void curveTo(float f, float f2, float f3, float f4) {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append(f).append(TokenParser.f24154SP).append(f2).append(TokenParser.f24154SP).append(f3).append(TokenParser.f24154SP).append(f4).append(" v").append_i(this.separator);
    }

    public void curveFromTo(float f, float f2, float f3, float f4) {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append(f).append(TokenParser.f24154SP).append(f2).append(TokenParser.f24154SP).append(f3).append(TokenParser.f24154SP).append(f4).append(" y").append_i(this.separator);
    }

    public void circle(float f, float f2, float f3) {
        float f4 = f + f3;
        moveTo(f4, f2);
        float f5 = f3 * 0.5523f;
        float f6 = f2 + f5;
        float f7 = f + f5;
        float f8 = f2 + f3;
        curveTo(f4, f6, f7, f8, f, f8);
        float f9 = f - f5;
        float f10 = f - f3;
        curveTo(f9, f8, f10, f6, f10, f2);
        float f11 = f2 - f5;
        float f12 = f2 - f3;
        curveTo(f10, f11, f9, f12, f, f12);
        curveTo(f7, f12, f4, f11, f4, f2);
    }

    public void rectangle(float f, float f2, float f3, float f4) {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append(f).append(TokenParser.f24154SP).append(f2).append(TokenParser.f24154SP).append(f3).append(TokenParser.f24154SP).append(f4).append(" re").append_i(this.separator);
    }

    private boolean compareColors(BaseColor baseColor, BaseColor baseColor2) {
        if (baseColor == null && baseColor2 == null) {
            return true;
        }
        if (baseColor == null || baseColor2 == null) {
            return false;
        }
        if (baseColor instanceof ExtendedColor) {
            return baseColor.equals(baseColor2);
        }
        return baseColor2.equals(baseColor);
    }

    public void variableRectangle(Rectangle rectangle) {
        float f;
        BaseColor baseColor;
        boolean z;
        float f2;
        BaseColor baseColor2;
        float f3;
        float top = rectangle.getTop();
        float bottom = rectangle.getBottom();
        float right = rectangle.getRight();
        float left = rectangle.getLeft();
        float borderWidthTop = rectangle.getBorderWidthTop();
        float borderWidthBottom = rectangle.getBorderWidthBottom();
        float borderWidthRight = rectangle.getBorderWidthRight();
        float borderWidthLeft = rectangle.getBorderWidthLeft();
        BaseColor borderColorTop = rectangle.getBorderColorTop();
        BaseColor borderColorBottom = rectangle.getBorderColorBottom();
        BaseColor borderColorRight = rectangle.getBorderColorRight();
        BaseColor borderColorLeft = rectangle.getBorderColorLeft();
        saveState();
        setLineCap(0);
        setLineJoin(0);
        boolean z2 = true;
        if (borderWidthTop > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            setLineWidth(borderWidthTop);
            if (borderColorTop == null) {
                resetRGBColorStroke();
            } else {
                setColorStroke(borderColorTop);
            }
            float f4 = top - (borderWidthTop / 2.0f);
            moveTo(left, f4);
            lineTo(right, f4);
            stroke();
            f = borderWidthTop;
            baseColor = borderColorTop;
            z = true;
        } else {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            baseColor = null;
            z = false;
        }
        if (borderWidthBottom > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            if (borderWidthBottom != f) {
                setLineWidth(borderWidthBottom);
                f = borderWidthBottom;
            }
            if (!z || !compareColors(baseColor, borderColorBottom)) {
                if (borderColorBottom == null) {
                    resetRGBColorStroke();
                } else {
                    setColorStroke(borderColorBottom);
                }
                baseColor = borderColorBottom;
                z = true;
            }
            float f5 = bottom + (borderWidthBottom / 2.0f);
            moveTo(right, f5);
            lineTo(left, f5);
            stroke();
        }
        if (borderWidthRight > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            if (borderWidthRight != f) {
                setLineWidth(borderWidthRight);
                f = borderWidthRight;
            }
            if (!z || !compareColors(baseColor, borderColorRight)) {
                if (borderColorRight == null) {
                    resetRGBColorStroke();
                } else {
                    setColorStroke(borderColorRight);
                }
                baseColor = borderColorRight;
                z = true;
            }
            boolean compareColors = compareColors(borderColorTop, borderColorRight);
            boolean compareColors2 = compareColors(borderColorBottom, borderColorRight);
            f2 = f;
            float f6 = right - (borderWidthRight / 2.0f);
            if (compareColors) {
                baseColor2 = baseColor;
                f3 = top;
            } else {
                baseColor2 = baseColor;
                f3 = top - borderWidthTop;
            }
            moveTo(f6, f3);
            lineTo(f6, compareColors2 ? bottom : bottom + borderWidthBottom);
            stroke();
            if (compareColors && compareColors2) {
                baseColor = baseColor2;
                borderColorRight = null;
                z2 = false;
            } else {
                if (borderColorRight == null) {
                    resetRGBColorFill();
                } else {
                    setColorFill(borderColorRight);
                }
                if (!compareColors) {
                    moveTo(right, top);
                    float f7 = top - borderWidthTop;
                    lineTo(right, f7);
                    lineTo(right - borderWidthRight, f7);
                    fill();
                }
                if (!compareColors2) {
                    moveTo(right, bottom);
                    float f8 = bottom + borderWidthBottom;
                    lineTo(right, f8);
                    lineTo(right - borderWidthRight, f8);
                    fill();
                }
                baseColor = baseColor2;
            }
        } else {
            f2 = f;
            borderColorRight = null;
            z2 = false;
        }
        if (borderWidthLeft > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            if (borderWidthLeft != f2) {
                setLineWidth(borderWidthLeft);
            }
            if (!z || !compareColors(baseColor, borderColorLeft)) {
                if (borderColorLeft == null) {
                    resetRGBColorStroke();
                } else {
                    setColorStroke(borderColorLeft);
                }
            }
            boolean compareColors3 = compareColors(borderColorTop, borderColorLeft);
            boolean compareColors4 = compareColors(borderColorBottom, borderColorLeft);
            float f9 = (borderWidthLeft / 2.0f) + left;
            moveTo(f9, compareColors3 ? top : top - borderWidthTop);
            lineTo(f9, compareColors4 ? bottom : bottom + borderWidthBottom);
            stroke();
            if (!compareColors3 || !compareColors4) {
                if (!z2 || !compareColors(borderColorRight, borderColorLeft)) {
                    if (borderColorLeft == null) {
                        resetRGBColorFill();
                    } else {
                        setColorFill(borderColorLeft);
                    }
                }
                if (!compareColors3) {
                    moveTo(left, top);
                    float f10 = top - borderWidthTop;
                    lineTo(left, f10);
                    lineTo(left + borderWidthLeft, f10);
                    fill();
                }
                if (!compareColors4) {
                    moveTo(left, bottom);
                    float f11 = bottom + borderWidthBottom;
                    lineTo(left, f11);
                    lineTo(left + borderWidthLeft, f11);
                    fill();
                }
            }
        }
        restoreState();
    }

    public void rectangle(Rectangle rectangle) {
        float left = rectangle.getLeft();
        float bottom = rectangle.getBottom();
        float right = rectangle.getRight();
        float top = rectangle.getTop();
        BaseColor backgroundColor = rectangle.getBackgroundColor();
        if (backgroundColor != null) {
            saveState();
            setColorFill(backgroundColor);
            rectangle(left, bottom, right - left, top - bottom);
            fill();
            restoreState();
        }
        if (rectangle.hasBorders()) {
            if (rectangle.isUseVariableBorders()) {
                variableRectangle(rectangle);
                return;
            }
            if (rectangle.getBorderWidth() != -1.0f) {
                setLineWidth(rectangle.getBorderWidth());
            }
            BaseColor borderColor = rectangle.getBorderColor();
            if (borderColor != null) {
                setColorStroke(borderColor);
            }
            if (rectangle.hasBorder(15)) {
                rectangle(left, bottom, right - left, top - bottom);
            } else {
                if (rectangle.hasBorder(8)) {
                    moveTo(right, bottom);
                    lineTo(right, top);
                }
                if (rectangle.hasBorder(4)) {
                    moveTo(left, bottom);
                    lineTo(left, top);
                }
                if (rectangle.hasBorder(2)) {
                    moveTo(left, bottom);
                    lineTo(right, bottom);
                }
                if (rectangle.hasBorder(1)) {
                    moveTo(left, top);
                    lineTo(right, top);
                }
            }
            stroke();
            if (borderColor != null) {
                resetRGBColorStroke();
            }
        }
    }

    public void closePath() {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append("h").append_i(this.separator);
    }

    public void newPath() {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append("n").append_i(this.separator);
    }

    public void stroke() {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append("S").append_i(this.separator);
    }

    public void closePathStroke() {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append(HtmlTags.f19633S).append_i(this.separator);
    }

    public void fill() {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append("f").append_i(this.separator);
    }

    public void eoFill() {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append("f*").append_i(this.separator);
    }

    public void fillStroke() {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append("B").append_i(this.separator);
    }

    public void closePathFillStroke() {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append(HtmlTags.f19619B).append_i(this.separator);
    }

    public void eoFillStroke() {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append("B*").append_i(this.separator);
    }

    public void closePathEoFillStroke() {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
        }
        this.content.append("b*").append_i(this.separator);
    }

    public void addImage(Image image) throws DocumentException {
        addImage(image, false);
    }

    public void addImage(Image image, boolean z) throws DocumentException {
        if (!image.hasAbsoluteY()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.image.must.have.absolute.positioning", new Object[0]));
        }
        float[] matrix = image.matrix();
        matrix[4] = image.getAbsoluteX() - matrix[4];
        matrix[5] = image.getAbsoluteY() - matrix[5];
        addImage(image, matrix[0], matrix[1], matrix[2], matrix[3], matrix[4], matrix[5], z);
    }

    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6) throws DocumentException {
        addImage(image, f, f2, f3, f4, f5, f6, false);
    }

    public void addImage(Image image, AffineTransform affineTransform) throws DocumentException {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        addImage(image, (float) dArr[0], (float) dArr[1], (float) dArr[2], (float) dArr[3], (float) dArr[4], (float) dArr[5], false);
    }

    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6, boolean z) throws DocumentException {
        char c;
        boolean z2;
        PdfName pdfName;
        byte[] globalBytes;
        char c2;
        try {
            if (image.getLayer() != null) {
                beginLayer(image.getLayer());
            }
            if (image.isImgTemplate()) {
                this.writer.addDirectImageSimple(image);
                PdfTemplate templateData = image.getTemplateData();
                float width = templateData.getWidth();
                float height = templateData.getHeight();
                addTemplate(templateData, f / width, f2 / width, f3 / height, f4 / height, f5, f6);
                c = 0;
            } else {
                this.content.append("q ");
                this.content.append(f).append(TokenParser.f24154SP);
                this.content.append(f2).append(TokenParser.f24154SP);
                this.content.append(f3).append(TokenParser.f24154SP);
                this.content.append(f4).append(TokenParser.f24154SP);
                this.content.append(f5).append(TokenParser.f24154SP);
                this.content.append(f6).append(" cm");
                if (z) {
                    this.content.append("\nBI\n");
                    PdfImage pdfImage = new PdfImage(image, "", null);
                    if ((image instanceof ImgJBIG2) && (globalBytes = ((ImgJBIG2) image).getGlobalBytes()) != null) {
                        PdfDictionary pdfDictionary = new PdfDictionary();
                        pdfDictionary.put(PdfName.JBIG2GLOBALS, this.writer.getReferenceJBIG2Globals(globalBytes));
                        pdfImage.put(PdfName.DECODEPARMS, pdfDictionary);
                    }
                    for (PdfName pdfName2 : pdfImage.getKeys()) {
                        PdfObject pdfObject = pdfImage.get(pdfName2);
                        String str = abrev.get(pdfName2);
                        if (str != null) {
                            this.content.append(str);
                            if (pdfName2.equals(PdfName.COLORSPACE) && pdfObject.isArray()) {
                                PdfArray pdfArray = (PdfArray) pdfObject;
                                if (pdfArray.size() == 4 && PdfName.INDEXED.equals(pdfArray.getAsName(0)) && pdfArray.getPdfObject(1).isName() && pdfArray.getPdfObject(2).isNumber() && pdfArray.getPdfObject(3).isString()) {
                                    z2 = false;
                                    if (z2 || !pdfName2.equals(PdfName.COLORSPACE) || pdfObject.isName()) {
                                        pdfName = pdfObject;
                                    } else {
                                        pdfName = this.writer.getColorspaceName();
                                        getPageResources().addColor(pdfName, this.writer.addToBody(pdfObject).getIndirectReference());
                                    }
                                    pdfName.toPdf(null, this.content);
                                    this.content.append('\n');
                                }
                            }
                            z2 = true;
                            if (z2) {
                            }
                            pdfName = pdfObject;
                            pdfName.toPdf(null, this.content);
                            this.content.append('\n');
                        }
                    }
                    c = 0;
                    this.content.append("ID\n");
                    pdfImage.writeContent(this.content);
                    this.content.append("\nEI\nQ").append_i(this.separator);
                } else {
                    c = 0;
                    PageResources pageResources = getPageResources();
                    Image imageMask = image.getImageMask();
                    if (imageMask != null) {
                        PdfName addDirectImageSimple = this.writer.addDirectImageSimple(imageMask);
                        pageResources.addXObject(addDirectImageSimple, this.writer.getImageReference(addDirectImageSimple));
                    }
                    PdfName addDirectImageSimple2 = this.writer.addDirectImageSimple(image);
                    this.content.append(TokenParser.f24154SP).append(pageResources.addXObject(addDirectImageSimple2, this.writer.getImageReference(addDirectImageSimple2)).getBytes()).append(" Do Q").append_i(this.separator);
                }
            }
            if (image.hasBorders()) {
                saveState();
                float width2 = image.getWidth();
                float height2 = image.getHeight();
                c2 = 1;
                concatCTM(f / width2, f2 / width2, f3 / height2, f4 / height2, f5, f6);
                rectangle(image);
                restoreState();
            } else {
                c2 = 1;
            }
            if (image.getLayer() != null) {
                endLayer();
            }
            Annotation annotation = image.getAnnotation();
            if (annotation == null) {
                return;
            }
            float[] fArr = new float[unitRect.length];
            for (int i = 0; i < unitRect.length; i += 2) {
                int i2 = i + 1;
                fArr[i] = (unitRect[i] * f) + (unitRect[i2] * f3) + f5;
                fArr[i2] = (unitRect[i] * f2) + (unitRect[i2] * f4) + f6;
            }
            float f7 = fArr[c];
            float f8 = fArr[c2];
            float f9 = f8;
            float f10 = f7;
            for (int i3 = 2; i3 < fArr.length; i3 += 2) {
                f10 = Math.min(f10, fArr[i3]);
                int i4 = i3 + 1;
                f8 = Math.min(f8, fArr[i4]);
                f7 = Math.max(f7, fArr[i3]);
                f9 = Math.max(f9, fArr[i4]);
            }
            Annotation annotation2 = new Annotation(annotation);
            annotation2.setDimensions(f10, f8, f7, f9);
            PdfAnnotation convertAnnotation = PdfAnnotationsImp.convertAnnotation(this.writer, annotation2, new Rectangle(f10, f8, f7, f9));
            if (convertAnnotation == null) {
                return;
            }
            addAnnotation(convertAnnotation);
        } catch (Exception e) {
            throw new DocumentException(e);
        }
    }

    public void reset() {
        reset(true);
    }

    public void reset(boolean z) {
        this.content.reset();
        if (z) {
            sanityCheck();
        }
        this.state = new GraphicState();
    }

    public void beginText() {
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.begin.end.text.operators", new Object[0]));
        }
        this.inText = true;
        GraphicState graphicState = this.state;
        graphicState.xTLM = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        graphicState.yTLM = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.content.append("BT").append_i(this.separator);
    }

    public void endText() {
        if (!this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.begin.end.text.operators", new Object[0]));
        }
        this.inText = false;
        this.content.append("ET").append_i(this.separator);
    }

    public void saveState() {
        this.content.append("q").append_i(this.separator);
        this.stateList.add(new GraphicState(this.state));
    }

    public void restoreState() {
        this.content.append("Q").append_i(this.separator);
        int size = this.stateList.size() - 1;
        if (size < 0) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.save.restore.state.operators", new Object[0]));
        }
        this.state = this.stateList.get(size);
        this.stateList.remove(size);
    }

    public void setCharacterSpacing(float f) {
        this.state.charSpace = f;
        this.content.append(f).append(" Tc").append_i(this.separator);
    }

    public void setWordSpacing(float f) {
        this.state.wordSpace = f;
        this.content.append(f).append(" Tw").append_i(this.separator);
    }

    public void setHorizontalScaling(float f) {
        this.state.scale = f;
        this.content.append(f).append(" Tz").append_i(this.separator);
    }

    public void setLeading(float f) {
        this.state.leading = f;
        this.content.append(f).append(" TL").append_i(this.separator);
    }

    public void setFontAndSize(BaseFont baseFont, float f) {
        checkWriter();
        if (f < 1.0E-4f && f > -1.0E-4f) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("font.size.too.small.1", String.valueOf(f)));
        }
        GraphicState graphicState = this.state;
        graphicState.size = f;
        graphicState.fontDetails = this.writer.addSimple(baseFont);
        this.content.append(getPageResources().addFont(this.state.fontDetails.getFontName(), this.state.fontDetails.getIndirectReference()).getBytes()).append(TokenParser.f24154SP).append(f).append(" Tf").append_i(this.separator);
    }

    public void setTextRenderingMode(int i) {
        this.content.append(i).append(" Tr").append_i(this.separator);
    }

    public void setTextRise(float f) {
        this.content.append(f).append(" Ts").append_i(this.separator);
    }

    private void showText2(String str) {
        if (this.state.fontDetails == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
        }
        escapeString(this.state.fontDetails.convertToBytes(str), this.content);
    }

    public void showText(String str) {
        showText2(str);
        this.content.append("Tj").append_i(this.separator);
    }

    public static PdfTextArray getKernArray(String str, BaseFont baseFont) {
        PdfTextArray pdfTextArray = new PdfTextArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length() - 1;
        char[] charArray = str.toCharArray();
        if (length >= 0) {
            stringBuffer.append(charArray, 0, 1);
        }
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char c = charArray[i2];
            int kerning = baseFont.getKerning(charArray[i], c);
            if (kerning == 0) {
                stringBuffer.append(c);
            } else {
                pdfTextArray.add(stringBuffer.toString());
                stringBuffer.setLength(0);
                stringBuffer.append(charArray, i2, 1);
                pdfTextArray.add(-kerning);
            }
            i = i2;
        }
        pdfTextArray.add(stringBuffer.toString());
        return pdfTextArray;
    }

    public void showTextKerned(String str) {
        if (this.state.fontDetails == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
        }
        BaseFont baseFont = this.state.fontDetails.getBaseFont();
        if (baseFont.hasKernPairs()) {
            showText(getKernArray(str, baseFont));
        } else {
            showText(str);
        }
    }

    public void newlineShowText(String str) {
        this.state.yTLM -= this.state.leading;
        showText2(str);
        this.content.append("'").append_i(this.separator);
    }

    public void newlineShowText(float f, float f2, String str) {
        this.state.yTLM -= this.state.leading;
        this.content.append(f).append(TokenParser.f24154SP).append(f2);
        showText2(str);
        this.content.append("\"").append_i(this.separator);
        GraphicState graphicState = this.state;
        graphicState.charSpace = f2;
        graphicState.wordSpace = f;
    }

    public void setTextMatrix(float f, float f2, float f3, float f4, float f5, float f6) {
        GraphicState graphicState = this.state;
        graphicState.xTLM = f5;
        graphicState.yTLM = f6;
        this.content.append(f).append(TokenParser.f24154SP).append(f2).append_i(32).append(f3).append_i(32).append(f4).append_i(32).append(f5).append_i(32).append(f6).append(" Tm").append_i(this.separator);
    }

    public void setTextMatrix(AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        setTextMatrix((float) dArr[0], (float) dArr[1], (float) dArr[2], (float) dArr[3], (float) dArr[4], (float) dArr[5]);
    }

    public void setTextMatrix(float f, float f2) {
        setTextMatrix(1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, f, f2);
    }

    public void moveText(float f, float f2) {
        this.state.xTLM += f;
        this.state.yTLM += f2;
        this.content.append(f).append(TokenParser.f24154SP).append(f2).append(" Td").append_i(this.separator);
    }

    public void moveTextWithLeading(float f, float f2) {
        this.state.xTLM += f;
        this.state.yTLM += f2;
        this.state.leading = -f2;
        this.content.append(f).append(TokenParser.f24154SP).append(f2).append(" TD").append_i(this.separator);
    }

    public void newlineText() {
        this.state.yTLM -= this.state.leading;
        this.content.append("T*").append_i(this.separator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        return this.content.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] escapeString(byte[] bArr) {
        ByteBuffer byteBuffer = new ByteBuffer();
        escapeString(bArr, byteBuffer);
        return byteBuffer.toByteArray();
    }

    static void escapeString(byte[] bArr, ByteBuffer byteBuffer) {
        byteBuffer.append_i(40);
        for (int i : bArr) {
            switch (i) {
                case 8:
                    byteBuffer.append("\\b");
                    break;
                case 9:
                    byteBuffer.append("\\t");
                    break;
                case 10:
                    byteBuffer.append("\\n");
                    break;
                case 12:
                    byteBuffer.append("\\f");
                    break;
                case 13:
                    byteBuffer.append("\\r");
                    break;
                case 40:
                case 41:
                case 92:
                    byteBuffer.append_i(92).append_i(i);
                    break;
                default:
                    byteBuffer.append_i(i);
                    break;
            }
        }
        byteBuffer.append(")");
    }

    public void addOutline(PdfOutline pdfOutline, String str) {
        checkWriter();
        this.pdf.addOutline(pdfOutline, str);
    }

    public PdfOutline getRootOutline() {
        checkWriter();
        return this.pdf.getRootOutline();
    }

    public float getEffectiveStringWidth(String str, boolean z) {
        float widthPoint;
        BaseFont baseFont = this.state.fontDetails.getBaseFont();
        if (z) {
            widthPoint = baseFont.getWidthPointKerned(str, this.state.size);
        } else {
            widthPoint = baseFont.getWidthPoint(str, this.state.size);
        }
        if (this.state.charSpace != ColumnText.GLOBAL_SPACE_CHAR_RATIO && str.length() > 1) {
            widthPoint += this.state.charSpace * (str.length() - 1);
        }
        int fontType = baseFont.getFontType();
        if (this.state.wordSpace != ColumnText.GLOBAL_SPACE_CHAR_RATIO && (fontType == 0 || fontType == 1 || fontType == 5)) {
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == ' ') {
                    widthPoint += this.state.wordSpace;
                }
            }
        }
        return ((double) this.state.scale) != 100.0d ? (widthPoint * this.state.scale) / 100.0f : widthPoint;
    }

    public void showTextAligned(int i, String str, float f, float f2, float f3) {
        showTextAligned(i, str, f, f2, f3, false);
    }

    private void showTextAligned(int i, String str, float f, float f2, float f3, boolean z) {
        float f4;
        float f5;
        float effectiveStringWidth;
        if (this.state.fontDetails == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
        }
        if (f3 == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            switch (i) {
                case 1:
                    effectiveStringWidth = f - (getEffectiveStringWidth(str, z) / 2.0f);
                    break;
                case 2:
                    effectiveStringWidth = f - getEffectiveStringWidth(str, z);
                    break;
                default:
                    effectiveStringWidth = f;
                    break;
            }
            setTextMatrix(effectiveStringWidth, f2);
            if (z) {
                showTextKerned(str);
                return;
            } else {
                showText(str);
                return;
            }
        }
        double d = f3;
        Double.isNaN(d);
        double d2 = (d * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        switch (i) {
            case 1:
                float effectiveStringWidth2 = getEffectiveStringWidth(str, z) / 2.0f;
                f4 = f2 - (effectiveStringWidth2 * sin);
                f5 = f - (effectiveStringWidth2 * cos);
                break;
            case 2:
                float effectiveStringWidth3 = getEffectiveStringWidth(str, z);
                f4 = f2 - (effectiveStringWidth3 * sin);
                f5 = f - (effectiveStringWidth3 * cos);
                break;
            default:
                f5 = f;
                f4 = f2;
                break;
        }
        setTextMatrix(cos, sin, -sin, cos, f5, f4);
        if (z) {
            showTextKerned(str);
        } else {
            showText(str);
        }
        setTextMatrix(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    public void showTextAlignedKerned(int i, String str, float f, float f2, float f3) {
        showTextAligned(i, str, f, f2, f3, true);
    }

    public void concatCTM(float f, float f2, float f3, float f4, float f5, float f6) {
        this.content.append(f).append(TokenParser.f24154SP).append(f2).append(TokenParser.f24154SP).append(f3).append(TokenParser.f24154SP);
        this.content.append(f4).append(TokenParser.f24154SP).append(f5).append(TokenParser.f24154SP).append(f6).append(" cm").append_i(this.separator);
    }

    public void concatCTM(AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        concatCTM((float) dArr[0], (float) dArr[1], (float) dArr[2], (float) dArr[3], (float) dArr[4], (float) dArr[5]);
    }

    public static ArrayList<float[]> bezierArc(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        float f9;
        float f10;
        int ceil;
        float f11;
        if (f > f3) {
            f8 = f;
            f7 = f3;
        } else {
            f7 = f;
            f8 = f3;
        }
        if (f4 > f2) {
            f10 = f2;
            f9 = f4;
        } else {
            f9 = f2;
            f10 = f4;
        }
        if (Math.abs(f6) <= 90.0f) {
            f11 = f6;
            ceil = 1;
        } else {
            ceil = (int) Math.ceil(Math.abs(f6) / 90.0f);
            f11 = f6 / ceil;
        }
        float f12 = (f7 + f8) / 2.0f;
        float f13 = (f9 + f10) / 2.0f;
        float f14 = (f8 - f7) / 2.0f;
        float f15 = (f10 - f9) / 2.0f;
        double d = f11;
        double d2 = 3.141592653589793d;
        Double.isNaN(d);
        double d3 = (float) ((d * 3.141592653589793d) / 360.0d);
        float abs = Math.abs((float) (((1.0d - Math.cos(d3)) * 1.3333333333333333d) / Math.sin(d3)));
        ArrayList<float[]> arrayList = new ArrayList<>();
        int i = 0;
        while (i < ceil) {
            double d4 = f5 + (i * f11);
            Double.isNaN(d4);
            float f16 = (float) ((d4 * d2) / 180.0d);
            i++;
            double d5 = f5 + (i * f11);
            Double.isNaN(d5);
            double d6 = f16;
            float cos = (float) Math.cos(d6);
            double d7 = (float) ((d5 * d2) / 180.0d);
            float cos2 = (float) Math.cos(d7);
            float sin = (float) Math.sin(d6);
            float sin2 = (float) Math.sin(d7);
            if (f11 > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                arrayList.add(new float[]{f12 + (f14 * cos), f13 - (f15 * sin), f12 + ((cos - (abs * sin)) * f14), f13 - ((sin + (cos * abs)) * f15), f12 + (((abs * sin2) + cos2) * f14), f13 - ((sin2 - (abs * cos2)) * f15), f12 + (cos2 * f14), f13 - (sin2 * f15)});
            } else {
                arrayList.add(new float[]{f12 + (f14 * cos), f13 - (f15 * sin), f12 + (((abs * sin) + cos) * f14), f13 - ((sin - (cos * abs)) * f15), f12 + ((cos2 - (abs * sin2)) * f14), f13 - (((abs * cos2) + sin2) * f15), f12 + (cos2 * f14), f13 - (sin2 * f15)});
            }
            d2 = 3.141592653589793d;
        }
        return arrayList;
    }

    public void arc(float f, float f2, float f3, float f4, float f5, float f6) {
        ArrayList<float[]> bezierArc = bezierArc(f, f2, f3, f4, f5, f6);
        if (bezierArc.isEmpty()) {
            return;
        }
        float[] fArr = bezierArc.get(0);
        moveTo(fArr[0], fArr[1]);
        for (int i = 0; i < bezierArc.size(); i++) {
            float[] fArr2 = bezierArc.get(i);
            curveTo(fArr2[2], fArr2[3], fArr2[4], fArr2[5], fArr2[6], fArr2[7]);
        }
    }

    public void ellipse(float f, float f2, float f3, float f4) {
        arc(f, f2, f3, f4, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 360.0f);
    }

    public PdfPatternPainter createPattern(float f, float f2, float f3, float f4) {
        checkWriter();
        if (f3 == ColumnText.GLOBAL_SPACE_CHAR_RATIO || f4 == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("xstep.or.ystep.can.not.be.zero", new Object[0]));
        }
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter(this.writer);
        pdfPatternPainter.setWidth(f);
        pdfPatternPainter.setHeight(f2);
        pdfPatternPainter.setXStep(f3);
        pdfPatternPainter.setYStep(f4);
        this.writer.addSimplePattern(pdfPatternPainter);
        return pdfPatternPainter;
    }

    public PdfPatternPainter createPattern(float f, float f2) {
        return createPattern(f, f2, f, f2);
    }

    public PdfPatternPainter createPattern(float f, float f2, float f3, float f4, BaseColor baseColor) {
        checkWriter();
        if (f3 == ColumnText.GLOBAL_SPACE_CHAR_RATIO || f4 == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("xstep.or.ystep.can.not.be.zero", new Object[0]));
        }
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter(this.writer, baseColor);
        pdfPatternPainter.setWidth(f);
        pdfPatternPainter.setHeight(f2);
        pdfPatternPainter.setXStep(f3);
        pdfPatternPainter.setYStep(f4);
        this.writer.addSimplePattern(pdfPatternPainter);
        return pdfPatternPainter;
    }

    public PdfPatternPainter createPattern(float f, float f2, BaseColor baseColor) {
        return createPattern(f, f2, f, f2, baseColor);
    }

    public PdfTemplate createTemplate(float f, float f2) {
        return createTemplate(f, f2, null);
    }

    PdfTemplate createTemplate(float f, float f2, PdfName pdfName) {
        checkWriter();
        PdfTemplate pdfTemplate = new PdfTemplate(this.writer);
        pdfTemplate.setWidth(f);
        pdfTemplate.setHeight(f2);
        this.writer.addDirectTemplateSimple(pdfTemplate, pdfName);
        return pdfTemplate;
    }

    public PdfAppearance createAppearance(float f, float f2) {
        return createAppearance(f, f2, null);
    }

    PdfAppearance createAppearance(float f, float f2, PdfName pdfName) {
        checkWriter();
        PdfAppearance pdfAppearance = new PdfAppearance(this.writer);
        pdfAppearance.setWidth(f);
        pdfAppearance.setHeight(f2);
        this.writer.addDirectTemplateSimple(pdfAppearance, pdfName);
        return pdfAppearance;
    }

    public void addPSXObject(PdfPSXObject pdfPSXObject) {
        checkWriter();
        this.content.append(getPageResources().addXObject(this.writer.addDirectTemplateSimple(pdfPSXObject, null), pdfPSXObject.getIndirectReference()).getBytes()).append(" Do").append_i(this.separator);
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2, float f3, float f4, float f5, float f6) {
        checkWriter();
        checkNoPattern(pdfTemplate);
        PdfName addXObject = getPageResources().addXObject(this.writer.addDirectTemplateSimple(pdfTemplate, null), pdfTemplate.getIndirectReference());
        this.content.append("q ");
        this.content.append(f).append(TokenParser.f24154SP);
        this.content.append(f2).append(TokenParser.f24154SP);
        this.content.append(f3).append(TokenParser.f24154SP);
        this.content.append(f4).append(TokenParser.f24154SP);
        this.content.append(f5).append(TokenParser.f24154SP);
        this.content.append(f6).append(" cm ");
        this.content.append(addXObject.getBytes()).append(" Do Q").append_i(this.separator);
    }

    public void addTemplate(PdfTemplate pdfTemplate, AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        addTemplate(pdfTemplate, (float) dArr[0], (float) dArr[1], (float) dArr[2], (float) dArr[3], (float) dArr[4], (float) dArr[5]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTemplateReference(PdfIndirectReference pdfIndirectReference, PdfName pdfName, float f, float f2, float f3, float f4, float f5, float f6) {
        checkWriter();
        PdfName addXObject = getPageResources().addXObject(pdfName, pdfIndirectReference);
        this.content.append("q ");
        this.content.append(f).append(TokenParser.f24154SP);
        this.content.append(f2).append(TokenParser.f24154SP);
        this.content.append(f3).append(TokenParser.f24154SP);
        this.content.append(f4).append(TokenParser.f24154SP);
        this.content.append(f5).append(TokenParser.f24154SP);
        this.content.append(f6).append(" cm ");
        this.content.append(addXObject.getBytes()).append(" Do Q").append_i(this.separator);
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2) {
        addTemplate(pdfTemplate, 1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, f, f2);
    }

    public void setCMYKColorFill(int i, int i2, int i3, int i4) {
        this.content.append((i & 255) / 255.0f);
        this.content.append(TokenParser.f24154SP);
        this.content.append((i2 & 255) / 255.0f);
        this.content.append(TokenParser.f24154SP);
        this.content.append((i3 & 255) / 255.0f);
        this.content.append(TokenParser.f24154SP);
        this.content.append((i4 & 255) / 255.0f);
        this.content.append(" k").append_i(this.separator);
    }

    public void setCMYKColorStroke(int i, int i2, int i3, int i4) {
        this.content.append((i & 255) / 255.0f);
        this.content.append(TokenParser.f24154SP);
        this.content.append((i2 & 255) / 255.0f);
        this.content.append(TokenParser.f24154SP);
        this.content.append((i3 & 255) / 255.0f);
        this.content.append(TokenParser.f24154SP);
        this.content.append((i4 & 255) / 255.0f);
        this.content.append(" K").append_i(this.separator);
    }

    public void setRGBColorFill(int i, int i2, int i3) {
        HelperRGB((i & 255) / 255.0f, (i2 & 255) / 255.0f, (i3 & 255) / 255.0f);
        this.content.append(" rg").append_i(this.separator);
    }

    public void setRGBColorStroke(int i, int i2, int i3) {
        HelperRGB((i & 255) / 255.0f, (i2 & 255) / 255.0f, (i3 & 255) / 255.0f);
        this.content.append(" RG").append_i(this.separator);
    }

    public void setColorStroke(BaseColor baseColor) {
        PdfWriter.checkPdfIsoConformance(this.writer, 1, baseColor);
        switch (ExtendedColor.getType(baseColor)) {
            case 1:
                setGrayStroke(((GrayColor) baseColor).getGray());
                return;
            case 2:
                CMYKColor cMYKColor = (CMYKColor) baseColor;
                setCMYKColorStrokeF(cMYKColor.getCyan(), cMYKColor.getMagenta(), cMYKColor.getYellow(), cMYKColor.getBlack());
                return;
            case 3:
                SpotColor spotColor = (SpotColor) baseColor;
                setColorStroke(spotColor.getPdfSpotColor(), spotColor.getTint());
                return;
            case 4:
                setPatternStroke(((PatternColor) baseColor).getPainter());
                return;
            case 5:
                setShadingStroke(((ShadingColor) baseColor).getPdfShadingPattern());
                return;
            default:
                setRGBColorStroke(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue());
                return;
        }
    }

    public void setColorFill(BaseColor baseColor) {
        PdfWriter.checkPdfIsoConformance(this.writer, 1, baseColor);
        switch (ExtendedColor.getType(baseColor)) {
            case 1:
                setGrayFill(((GrayColor) baseColor).getGray());
                return;
            case 2:
                CMYKColor cMYKColor = (CMYKColor) baseColor;
                setCMYKColorFillF(cMYKColor.getCyan(), cMYKColor.getMagenta(), cMYKColor.getYellow(), cMYKColor.getBlack());
                return;
            case 3:
                SpotColor spotColor = (SpotColor) baseColor;
                setColorFill(spotColor.getPdfSpotColor(), spotColor.getTint());
                return;
            case 4:
                setPatternFill(((PatternColor) baseColor).getPainter());
                return;
            case 5:
                setShadingFill(((ShadingColor) baseColor).getPdfShadingPattern());
                return;
            default:
                setRGBColorFill(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue());
                return;
        }
    }

    public void setColorFill(PdfSpotColor pdfSpotColor, float f) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfSpotColor);
        this.content.append(getPageResources().addColor(this.state.colorDetails.getColorName(), this.state.colorDetails.getIndirectReference()).getBytes()).append(" cs ").append(f).append(" scn").append_i(this.separator);
    }

    public void setColorStroke(PdfSpotColor pdfSpotColor, float f) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfSpotColor);
        this.content.append(getPageResources().addColor(this.state.colorDetails.getColorName(), this.state.colorDetails.getIndirectReference()).getBytes()).append(" CS ").append(f).append(" SCN").append_i(this.separator);
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter) {
        if (pdfPatternPainter.isStencil()) {
            setPatternFill(pdfPatternPainter, pdfPatternPainter.getDefaultColor());
            return;
        }
        checkWriter();
        this.content.append(PdfName.PATTERN.getBytes()).append(" cs ").append(getPageResources().addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference()).getBytes()).append(" scn").append_i(this.separator);
    }

    void outputColorNumbers(BaseColor baseColor, float f) {
        PdfWriter.checkPdfIsoConformance(this.writer, 1, baseColor);
        switch (ExtendedColor.getType(baseColor)) {
            case 0:
                this.content.append(baseColor.getRed() / 255.0f);
                this.content.append(TokenParser.f24154SP);
                this.content.append(baseColor.getGreen() / 255.0f);
                this.content.append(TokenParser.f24154SP);
                this.content.append(baseColor.getBlue() / 255.0f);
                return;
            case 1:
                this.content.append(((GrayColor) baseColor).getGray());
                return;
            case 2:
                CMYKColor cMYKColor = (CMYKColor) baseColor;
                this.content.append(cMYKColor.getCyan()).append(TokenParser.f24154SP).append(cMYKColor.getMagenta());
                this.content.append(TokenParser.f24154SP).append(cMYKColor.getYellow()).append(TokenParser.f24154SP).append(cMYKColor.getBlack());
                return;
            case 3:
                this.content.append(f);
                return;
            default:
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.color.type", new Object[0]));
        }
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter, BaseColor baseColor) {
        if (ExtendedColor.getType(baseColor) == 3) {
            setPatternFill(pdfPatternPainter, baseColor, ((SpotColor) baseColor).getTint());
        } else {
            setPatternFill(pdfPatternPainter, baseColor, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        }
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f) {
        checkWriter();
        if (!pdfPatternPainter.isStencil()) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("an.uncolored.pattern.was.expected", new Object[0]));
        }
        PageResources pageResources = getPageResources();
        PdfName addPattern = pageResources.addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference());
        ColorDetails addSimplePatternColorspace = this.writer.addSimplePatternColorspace(baseColor);
        this.content.append(pageResources.addColor(addSimplePatternColorspace.getColorName(), addSimplePatternColorspace.getIndirectReference()).getBytes()).append(" cs").append_i(this.separator);
        outputColorNumbers(baseColor, f);
        this.content.append(TokenParser.f24154SP).append(addPattern.getBytes()).append(" scn").append_i(this.separator);
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter, BaseColor baseColor) {
        if (ExtendedColor.getType(baseColor) == 3) {
            setPatternStroke(pdfPatternPainter, baseColor, ((SpotColor) baseColor).getTint());
        } else {
            setPatternStroke(pdfPatternPainter, baseColor, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        }
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f) {
        checkWriter();
        if (!pdfPatternPainter.isStencil()) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("an.uncolored.pattern.was.expected", new Object[0]));
        }
        PageResources pageResources = getPageResources();
        PdfName addPattern = pageResources.addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference());
        ColorDetails addSimplePatternColorspace = this.writer.addSimplePatternColorspace(baseColor);
        this.content.append(pageResources.addColor(addSimplePatternColorspace.getColorName(), addSimplePatternColorspace.getIndirectReference()).getBytes()).append(" CS").append_i(this.separator);
        outputColorNumbers(baseColor, f);
        this.content.append(TokenParser.f24154SP).append(addPattern.getBytes()).append(" SCN").append_i(this.separator);
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter) {
        if (pdfPatternPainter.isStencil()) {
            setPatternStroke(pdfPatternPainter, pdfPatternPainter.getDefaultColor());
            return;
        }
        checkWriter();
        this.content.append(PdfName.PATTERN.getBytes()).append(" CS ").append(getPageResources().addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference()).getBytes()).append(" SCN").append_i(this.separator);
    }

    public void paintShading(PdfShading pdfShading) {
        this.writer.addSimpleShading(pdfShading);
        PageResources pageResources = getPageResources();
        this.content.append(pageResources.addShading(pdfShading.getShadingName(), pdfShading.getShadingReference()).getBytes()).append(" sh").append_i(this.separator);
        ColorDetails colorDetails = pdfShading.getColorDetails();
        if (colorDetails != null) {
            pageResources.addColor(colorDetails.getColorName(), colorDetails.getIndirectReference());
        }
    }

    public void paintShading(PdfShadingPattern pdfShadingPattern) {
        paintShading(pdfShadingPattern.getShading());
    }

    public void setShadingFill(PdfShadingPattern pdfShadingPattern) {
        this.writer.addSimpleShadingPattern(pdfShadingPattern);
        PageResources pageResources = getPageResources();
        this.content.append(PdfName.PATTERN.getBytes()).append(" cs ").append(pageResources.addPattern(pdfShadingPattern.getPatternName(), pdfShadingPattern.getPatternReference()).getBytes()).append(" scn").append_i(this.separator);
        ColorDetails colorDetails = pdfShadingPattern.getColorDetails();
        if (colorDetails != null) {
            pageResources.addColor(colorDetails.getColorName(), colorDetails.getIndirectReference());
        }
    }

    public void setShadingStroke(PdfShadingPattern pdfShadingPattern) {
        this.writer.addSimpleShadingPattern(pdfShadingPattern);
        PageResources pageResources = getPageResources();
        this.content.append(PdfName.PATTERN.getBytes()).append(" CS ").append(pageResources.addPattern(pdfShadingPattern.getPatternName(), pdfShadingPattern.getPatternReference()).getBytes()).append(" SCN").append_i(this.separator);
        ColorDetails colorDetails = pdfShadingPattern.getColorDetails();
        if (colorDetails != null) {
            pageResources.addColor(colorDetails.getColorName(), colorDetails.getIndirectReference());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkWriter() {
        if (this.writer == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("the.writer.in.pdfcontentbyte.is.null", new Object[0]));
        }
    }

    public void showText(PdfTextArray pdfTextArray) {
        if (this.state.fontDetails == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
        }
        this.content.append("[");
        Iterator<Object> it = pdfTextArray.getArrayList().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof String) {
                showText2((String) next);
                z = false;
            } else {
                if (z) {
                    this.content.append(TokenParser.f24154SP);
                } else {
                    z = true;
                }
                this.content.append(((Float) next).floatValue());
            }
        }
        this.content.append("]TJ").append_i(this.separator);
    }

    public PdfWriter getPdfWriter() {
        return this.writer;
    }

    public PdfDocument getPdfDocument() {
        return this.pdf;
    }

    public void localGoto(String str, float f, float f2, float f3, float f4) {
        this.pdf.localGoto(str, f, f2, f3, f4);
    }

    public boolean localDestination(String str, PdfDestination pdfDestination) {
        return this.pdf.localDestination(str, pdfDestination);
    }

    public PdfContentByte getDuplicate() {
        return new PdfContentByte(this.writer);
    }

    public void remoteGoto(String str, String str2, float f, float f2, float f3, float f4) {
        this.pdf.remoteGoto(str, str2, f, f2, f3, f4);
    }

    public void remoteGoto(String str, int i, float f, float f2, float f3, float f4) {
        this.pdf.remoteGoto(str, i, f, f2, f3, f4);
    }

    public void roundRectangle(float f, float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9 = f3;
        if (f9 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            float f10 = f + f9;
            f9 = -f9;
            f6 = f10;
        } else {
            f6 = f;
        }
        if (f4 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f8 = -f4;
            f7 = f2 + f4;
        } else {
            f7 = f2;
            f8 = f4;
        }
        float f11 = f5 < ColumnText.GLOBAL_SPACE_CHAR_RATIO ? -f5 : f5;
        float f12 = f6 + f11;
        moveTo(f12, f7);
        float f13 = f6 + f9;
        float f14 = f13 - f11;
        lineTo(f14, f7);
        float f15 = f11 * 0.4477f;
        float f16 = f13 - f15;
        float f17 = f7 + f15;
        float f18 = f7 + f11;
        curveTo(f16, f7, f13, f17, f13, f18);
        float f19 = f8 + f7;
        float f20 = f19 - f11;
        lineTo(f13, f20);
        float f21 = f19 - f15;
        curveTo(f13, f21, f16, f19, f14, f19);
        lineTo(f12, f19);
        float f22 = f6 + f15;
        curveTo(f22, f19, f6, f21, f6, f20);
        lineTo(f6, f18);
        curveTo(f6, f17, f22, f7, f12, f7);
    }

    public void setAction(PdfAction pdfAction, float f, float f2, float f3, float f4) {
        this.pdf.setAction(pdfAction, f, f2, f3, f4);
    }

    public void setLiteral(String str) {
        this.content.append(str);
    }

    public void setLiteral(char c) {
        this.content.append(c);
    }

    public void setLiteral(float f) {
        this.content.append(f);
    }

    void checkNoPattern(PdfTemplate pdfTemplate) {
        if (pdfTemplate.getType() == 3) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.use.of.a.pattern.a.template.was.expected", new Object[0]));
        }
    }

    public void drawRadioField(float f, float f2, float f3, float f4, boolean z) {
        float f5;
        float f6;
        float f7;
        float f8;
        if (f > f3) {
            f6 = f;
            f5 = f3;
        } else {
            f5 = f;
            f6 = f3;
        }
        if (f2 > f4) {
            f8 = f2;
            f7 = f4;
        } else {
            f7 = f2;
            f8 = f4;
        }
        saveState();
        setLineWidth(1.0f);
        setLineCap(1);
        setColorStroke(new BaseColor(192, 192, 192));
        arc(f5 + 1.0f, f7 + 1.0f, f6 - 1.0f, f8 - 1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 360.0f);
        stroke();
        setLineWidth(1.0f);
        setLineCap(1);
        setColorStroke(new BaseColor(160, 160, 160));
        arc(f5 + 0.5f, f7 + 0.5f, f6 - 0.5f, f8 - 0.5f, 45.0f, 180.0f);
        stroke();
        setLineWidth(1.0f);
        setLineCap(1);
        setColorStroke(new BaseColor(0, 0, 0));
        arc(f5 + 1.5f, f7 + 1.5f, f6 - 1.5f, f8 - 1.5f, 45.0f, 180.0f);
        stroke();
        if (z) {
            setLineWidth(1.0f);
            setLineCap(1);
            setColorFill(new BaseColor(0, 0, 0));
            arc(f5 + 4.0f, f7 + 4.0f, f6 - 4.0f, f8 - 4.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 360.0f);
            fill();
        }
        restoreState();
    }

    public void drawTextField(float f, float f2, float f3, float f4) {
        if (f > f3) {
            f3 = f;
            f = f3;
        }
        if (f2 > f4) {
            f4 = f2;
            f2 = f4;
        }
        saveState();
        setColorStroke(new BaseColor(192, 192, 192));
        setLineWidth(1.0f);
        setLineCap(0);
        float f5 = f3 - f;
        float f6 = f4 - f2;
        rectangle(f, f2, f5, f6);
        stroke();
        setLineWidth(1.0f);
        setLineCap(0);
        setColorFill(new BaseColor(255, 255, 255));
        rectangle(f + 0.5f, 0.5f + f2, f5 - 1.0f, f6 - 1.0f);
        fill();
        setColorStroke(new BaseColor(192, 192, 192));
        setLineWidth(1.0f);
        setLineCap(0);
        float f7 = f + 1.0f;
        float f8 = f2 + 1.5f;
        moveTo(f7, f8);
        float f9 = f3 - 1.5f;
        lineTo(f9, f8);
        float f10 = f4 - 1.0f;
        lineTo(f9, f10);
        stroke();
        setColorStroke(new BaseColor(160, 160, 160));
        setLineWidth(1.0f);
        setLineCap(0);
        moveTo(f7, f2 + 1.0f);
        lineTo(f7, f10);
        lineTo(f3 - 1.0f, f10);
        stroke();
        setColorStroke(new BaseColor(0, 0, 0));
        setLineWidth(1.0f);
        setLineCap(0);
        float f11 = f + 2.0f;
        moveTo(f11, f2 + 2.0f);
        float f12 = f4 - 2.0f;
        lineTo(f11, f12);
        lineTo(f3 - 2.0f, f12);
        stroke();
        restoreState();
    }

    public void drawButton(float f, float f2, float f3, float f4, String str, BaseFont baseFont, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        if (f > f3) {
            f7 = f;
            f6 = f3;
        } else {
            f6 = f;
            f7 = f3;
        }
        if (f2 > f4) {
            f9 = f2;
            f8 = f4;
        } else {
            f8 = f2;
            f9 = f4;
        }
        saveState();
        setColorStroke(new BaseColor(0, 0, 0));
        setLineWidth(1.0f);
        setLineCap(0);
        float f10 = f7 - f6;
        float f11 = f9 - f8;
        rectangle(f6, f8, f10, f11);
        stroke();
        setLineWidth(1.0f);
        setLineCap(0);
        setColorFill(new BaseColor(192, 192, 192));
        rectangle(f6 + 0.5f, 0.5f + f8, f10 - 1.0f, f11 - 1.0f);
        fill();
        setColorStroke(new BaseColor(255, 255, 255));
        setLineWidth(1.0f);
        setLineCap(0);
        float f12 = f6 + 1.0f;
        float f13 = f8 + 1.0f;
        moveTo(f12, f13);
        float f14 = f9 - 1.0f;
        lineTo(f12, f14);
        float f15 = f7 - 1.0f;
        lineTo(f15, f14);
        stroke();
        setColorStroke(new BaseColor(160, 160, 160));
        setLineWidth(1.0f);
        setLineCap(0);
        moveTo(f12, f13);
        lineTo(f15, f13);
        lineTo(f15, f14);
        stroke();
        resetRGBColorFill();
        beginText();
        setFontAndSize(baseFont, f5);
        showTextAligned(1, str, f6 + (f10 / 2.0f), f8 + ((f11 - f5) / 2.0f), ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        endText();
        restoreState();
    }

    PageResources getPageResources() {
        return this.pdf.getPageResources();
    }

    public void setGState(PdfGState pdfGState) {
        PdfObject[] addSimpleExtGState = this.writer.addSimpleExtGState(pdfGState);
        this.content.append(getPageResources().addExtGState((PdfName) addSimpleExtGState[0], (PdfIndirectReference) addSimpleExtGState[1]).getBytes()).append(" gs").append_i(this.separator);
    }

    public void beginLayer(PdfOCG pdfOCG) {
        int i = 0;
        if ((pdfOCG instanceof PdfLayer) && ((PdfLayer) pdfOCG).getTitle() != null) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("a.title.is.not.a.layer", new Object[0]));
        }
        if (this.layerDepth == null) {
            this.layerDepth = new ArrayList<>();
        }
        if (pdfOCG instanceof PdfLayerMembership) {
            this.layerDepth.add(1);
            beginLayer2(pdfOCG);
            return;
        }
        for (PdfLayer pdfLayer = (PdfLayer) pdfOCG; pdfLayer != null; pdfLayer = pdfLayer.getParent()) {
            if (pdfLayer.getTitle() == null) {
                beginLayer2(pdfLayer);
                i++;
            }
        }
        this.layerDepth.add(Integer.valueOf(i));
    }

    private void beginLayer2(PdfOCG pdfOCG) {
        this.content.append("/OC ").append(getPageResources().addProperty((PdfName) this.writer.addSimpleProperty(pdfOCG, pdfOCG.getRef())[0], pdfOCG.getRef()).getBytes()).append(" BDC").append_i(this.separator);
    }

    public void endLayer() {
        ArrayList<Integer> arrayList;
        ArrayList<Integer> arrayList2;
        ArrayList<Integer> arrayList3 = this.layerDepth;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            int intValue = this.layerDepth.get(arrayList.size() - 1).intValue();
            this.layerDepth.remove(arrayList2.size() - 1);
            while (true) {
                int i = intValue - 1;
                if (intValue <= 0) {
                    return;
                }
                this.content.append("EMC").append_i(this.separator);
                intValue = i;
            }
        } else {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.layer.operators", new Object[0]));
        }
    }

    public void transform(AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        this.content.append(dArr[0]).append(TokenParser.f24154SP).append(dArr[1]).append(TokenParser.f24154SP).append(dArr[2]).append(TokenParser.f24154SP);
        this.content.append(dArr[3]).append(TokenParser.f24154SP).append(dArr[4]).append(TokenParser.f24154SP).append(dArr[5]).append(" cm").append_i(this.separator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        this.writer.addAnnotation(pdfAnnotation);
    }

    public void setDefaultColorspace(PdfName pdfName, PdfObject pdfObject) {
        getPageResources().addDefaultColor(pdfName, pdfObject);
    }

    public void beginMarkedContentSequence(PdfStructureElement pdfStructureElement) {
        PdfArray pdfArray;
        PdfObject pdfObject = pdfStructureElement.get(PdfName.f19734K);
        int markPoint = this.pdf.getMarkPoint();
        if (pdfObject != null) {
            if (pdfObject.isNumber()) {
                pdfArray = new PdfArray();
                pdfArray.add(pdfObject);
                pdfStructureElement.put(PdfName.f19734K, pdfArray);
            } else if (pdfObject.isArray()) {
                pdfArray = (PdfArray) pdfObject;
                if (!pdfArray.getPdfObject(0).isNumber()) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.structure.has.kids", new Object[0]));
                }
            } else {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("unknown.object.at.k.1", pdfObject.getClass().toString()));
            }
            PdfDictionary pdfDictionary = new PdfDictionary(PdfName.MCR);
            pdfDictionary.put(PdfName.f19754PG, this.writer.getCurrentPage());
            pdfDictionary.put(PdfName.MCID, new PdfNumber(markPoint));
            pdfArray.add(pdfDictionary);
            pdfStructureElement.setPageMark(this.writer.getPageNumber() - 1, -1);
        } else {
            pdfStructureElement.setPageMark(this.writer.getPageNumber() - 1, markPoint);
            pdfStructureElement.put(PdfName.f19754PG, this.writer.getCurrentPage());
        }
        this.pdf.incMarkPoint();
        this.mcDepth++;
        this.content.append(pdfStructureElement.get(PdfName.f19767S).getBytes()).append(" <</MCID ").append(markPoint).append(">> BDC").append_i(this.separator);
    }

    public void endMarkedContentSequence() {
        int i = this.mcDepth;
        if (i == 0) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.begin.end.marked.content.operators", new Object[0]));
        }
        this.mcDepth = i - 1;
        this.content.append("EMC").append_i(this.separator);
    }

    public void beginMarkedContentSequence(PdfName pdfName, PdfDictionary pdfDictionary, boolean z) {
        PdfObject[] addSimpleProperty;
        if (pdfDictionary == null) {
            this.content.append(pdfName.getBytes()).append(" BMC").append_i(this.separator);
            this.mcDepth++;
            return;
        }
        this.content.append(pdfName.getBytes()).append(TokenParser.f24154SP);
        if (z) {
            try {
                pdfDictionary.toPdf(this.writer, this.content);
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            if (this.writer.propertyExists(pdfDictionary)) {
                addSimpleProperty = this.writer.addSimpleProperty(pdfDictionary, null);
            } else {
                PdfWriter pdfWriter = this.writer;
                addSimpleProperty = pdfWriter.addSimpleProperty(pdfDictionary, pdfWriter.getPdfIndirectReference());
            }
            this.content.append(getPageResources().addProperty((PdfName) addSimpleProperty[0], (PdfIndirectReference) addSimpleProperty[1]).getBytes());
        }
        this.content.append(" BDC").append_i(this.separator);
        this.mcDepth++;
    }

    public void beginMarkedContentSequence(PdfName pdfName) {
        beginMarkedContentSequence(pdfName, null, false);
    }

    public void sanityCheck() {
        if (this.mcDepth != 0) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.marked.content.operators", new Object[0]));
        }
        if (this.inText) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.begin.end.text.operators", new Object[0]));
        }
        ArrayList<Integer> arrayList = this.layerDepth;
        if (arrayList != null && !arrayList.isEmpty()) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.layer.operators", new Object[0]));
        }
        if (!this.stateList.isEmpty()) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.save.restore.state.operators", new Object[0]));
        }
    }

    public Graphics2D createGraphicsShapes(float f, float f2) {
        return new PdfGraphics2D(this, f, f2, (byte) 0);
    }

    public Graphics2D createPrinterGraphicsShapes(float f, float f2, PrinterJob printerJob) {
        return new PdfPrinterGraphics2D(this, f, f2, printerJob, (byte) 0);
    }

    public Graphics2D createGraphics(float f, float f2) {
        return new PdfGraphics2D(this, f, f2);
    }

    public Graphics2D createPrinterGraphics(float f, float f2, PrinterJob printerJob) {
        return new PdfPrinterGraphics2D(this, f, f2, printerJob);
    }

    public Graphics2D createGraphics(float f, float f2, boolean z, float f3) {
        return new PdfGraphics2D(this, f, f2, null, false, z, f3);
    }

    public Graphics2D createPrinterGraphics(float f, float f2, boolean z, float f3, PrinterJob printerJob) {
        return new PdfPrinterGraphics2D(this, f, f2, null, false, z, f3, printerJob);
    }

    public Graphics2D createGraphicsShapes(float f, float f2, boolean z, float f3) {
        return new PdfGraphics2D(this, f, f2, null, true, z, f3);
    }

    public Graphics2D createPrinterGraphicsShapes(float f, float f2, boolean z, float f3, PrinterJob printerJob) {
        return new PdfPrinterGraphics2D(this, f, f2, null, true, z, f3, printerJob);
    }

    public Graphics2D createGraphics(float f, float f2, FontMapper fontMapper) {
        return new PdfGraphics2D(this, f, f2, fontMapper);
    }

    public Graphics2D createPrinterGraphics(float f, float f2, FontMapper fontMapper, PrinterJob printerJob) {
        return new PdfPrinterGraphics2D(this, f, f2, fontMapper, printerJob);
    }

    public Graphics2D createGraphics(float f, float f2, FontMapper fontMapper, boolean z, float f3) {
        return new PdfGraphics2D(this, f, f2, fontMapper, false, z, f3);
    }

    public Graphics2D createPrinterGraphics(float f, float f2, FontMapper fontMapper, boolean z, float f3, PrinterJob printerJob) {
        return new PdfPrinterGraphics2D(this, f, f2, fontMapper, false, z, f3, printerJob);
    }

    public void addImage(Image image, java.awt.geom.AffineTransform affineTransform) throws DocumentException {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        addImage(image, new AffineTransform(dArr));
    }

    public void addTemplate(PdfTemplate pdfTemplate, java.awt.geom.AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        addTemplate(pdfTemplate, new AffineTransform(dArr));
    }

    public void concatCTM(java.awt.geom.AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        concatCTM(new AffineTransform(dArr));
    }

    public void setTextMatrix(java.awt.geom.AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        setTextMatrix(new AffineTransform(dArr));
    }

    public void transform(java.awt.geom.AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        transform(new AffineTransform(dArr));
    }
}
