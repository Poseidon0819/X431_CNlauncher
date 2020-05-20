package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.codec.BmpImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MetaDo {
    public static final int META_ANIMATEPALETTE = 1078;
    public static final int META_ARC = 2071;
    public static final int META_BITBLT = 2338;
    public static final int META_CHORD = 2096;
    public static final int META_CREATEBRUSHINDIRECT = 764;
    public static final int META_CREATEFONTINDIRECT = 763;
    public static final int META_CREATEPALETTE = 247;
    public static final int META_CREATEPATTERNBRUSH = 505;
    public static final int META_CREATEPENINDIRECT = 762;
    public static final int META_CREATEREGION = 1791;
    public static final int META_DELETEOBJECT = 496;
    public static final int META_DIBBITBLT = 2368;
    public static final int META_DIBCREATEPATTERNBRUSH = 322;
    public static final int META_DIBSTRETCHBLT = 2881;
    public static final int META_ELLIPSE = 1048;
    public static final int META_ESCAPE = 1574;
    public static final int META_EXCLUDECLIPRECT = 1045;
    public static final int META_EXTFLOODFILL = 1352;
    public static final int META_EXTTEXTOUT = 2610;
    public static final int META_FILLREGION = 552;
    public static final int META_FLOODFILL = 1049;
    public static final int META_FRAMEREGION = 1065;
    public static final int META_INTERSECTCLIPRECT = 1046;
    public static final int META_INVERTREGION = 298;
    public static final int META_LINETO = 531;
    public static final int META_MOVETO = 532;
    public static final int META_OFFSETCLIPRGN = 544;
    public static final int META_OFFSETVIEWPORTORG = 529;
    public static final int META_OFFSETWINDOWORG = 527;
    public static final int META_PAINTREGION = 299;
    public static final int META_PATBLT = 1565;
    public static final int META_PIE = 2074;
    public static final int META_POLYGON = 804;
    public static final int META_POLYLINE = 805;
    public static final int META_POLYPOLYGON = 1336;
    public static final int META_REALIZEPALETTE = 53;
    public static final int META_RECTANGLE = 1051;
    public static final int META_RESIZEPALETTE = 313;
    public static final int META_RESTOREDC = 295;
    public static final int META_ROUNDRECT = 1564;
    public static final int META_SAVEDC = 30;
    public static final int META_SCALEVIEWPORTEXT = 1042;
    public static final int META_SCALEWINDOWEXT = 1040;
    public static final int META_SELECTCLIPREGION = 300;
    public static final int META_SELECTOBJECT = 301;
    public static final int META_SELECTPALETTE = 564;
    public static final int META_SETBKCOLOR = 513;
    public static final int META_SETBKMODE = 258;
    public static final int META_SETDIBTODEV = 3379;
    public static final int META_SETMAPMODE = 259;
    public static final int META_SETMAPPERFLAGS = 561;
    public static final int META_SETPALENTRIES = 55;
    public static final int META_SETPIXEL = 1055;
    public static final int META_SETPOLYFILLMODE = 262;
    public static final int META_SETRELABS = 261;
    public static final int META_SETROP2 = 260;
    public static final int META_SETSTRETCHBLTMODE = 263;
    public static final int META_SETTEXTALIGN = 302;
    public static final int META_SETTEXTCHAREXTRA = 264;
    public static final int META_SETTEXTCOLOR = 521;
    public static final int META_SETTEXTJUSTIFICATION = 522;
    public static final int META_SETVIEWPORTEXT = 526;
    public static final int META_SETVIEWPORTORG = 525;
    public static final int META_SETWINDOWEXT = 524;
    public static final int META_SETWINDOWORG = 523;
    public static final int META_STRETCHBLT = 2851;
    public static final int META_STRETCHDIB = 3907;
    public static final int META_TEXTOUT = 1313;
    int bottom;

    /* renamed from: cb */
    public PdfContentByte f19838cb;

    /* renamed from: in */
    public InputMeta f19839in;
    int inch;
    int left;
    int right;
    MetaState state = new MetaState();
    int top;

    public MetaDo(InputStream inputStream, PdfContentByte pdfContentByte) {
        this.f19838cb = pdfContentByte;
        this.f19839in = new InputMeta(inputStream);
    }

    public void readAll() throws IOException, DocumentException {
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        String str2;
        if (this.f19839in.readInt() != -1698247209) {
            throw new DocumentException(MessageLocalization.getComposedMessage("not.a.placeable.windows.metafile", new Object[0]));
        }
        this.f19839in.readWord();
        this.left = this.f19839in.readShort();
        this.top = this.f19839in.readShort();
        this.right = this.f19839in.readShort();
        this.bottom = this.f19839in.readShort();
        this.inch = this.f19839in.readWord();
        this.state.setScalingX(((this.right - this.left) / this.inch) * 72.0f);
        this.state.setScalingY(((this.bottom - this.top) / this.inch) * 72.0f);
        this.state.setOffsetWx(this.left);
        this.state.setOffsetWy(this.top);
        this.state.setExtentWx(this.right - this.left);
        this.state.setExtentWy(this.bottom - this.top);
        this.f19839in.readInt();
        this.f19839in.readWord();
        this.f19839in.skip(18);
        this.f19838cb.setLineCap(1);
        this.f19838cb.setLineJoin(1);
        while (true) {
            int length = this.f19839in.getLength();
            int readInt = this.f19839in.readInt();
            if (readInt >= 3) {
                int readWord = this.f19839in.readWord();
                switch (readWord) {
                    case 30:
                        this.state.saveState(this.f19838cb);
                        break;
                    case META_CREATEPALETTE /* 247 */:
                    case 322:
                    case META_CREATEREGION /* 1791 */:
                        this.state.addMetaObject(new MetaObject());
                        break;
                    case 258:
                        this.state.setBackgroundMode(this.f19839in.readWord());
                        break;
                    case 262:
                        this.state.setPolyFillMode(this.f19839in.readWord());
                        break;
                    case META_RESTOREDC /* 295 */:
                        this.state.restoreState(this.f19839in.readShort(), this.f19838cb);
                        break;
                    case 301:
                        this.state.selectMetaObject(this.f19839in.readWord(), this.f19838cb);
                        break;
                    case META_SETTEXTALIGN /* 302 */:
                        this.state.setTextAlign(this.f19839in.readWord());
                        break;
                    case META_DELETEOBJECT /* 496 */:
                        this.state.deleteMetaObject(this.f19839in.readWord());
                        break;
                    case 513:
                        this.state.setCurrentBackgroundColor(this.f19839in.readColor());
                        break;
                    case 521:
                        this.state.setCurrentTextColor(this.f19839in.readColor());
                        break;
                    case META_SETWINDOWORG /* 523 */:
                        this.state.setOffsetWy(this.f19839in.readShort());
                        this.state.setOffsetWx(this.f19839in.readShort());
                        break;
                    case META_SETWINDOWEXT /* 524 */:
                        this.state.setExtentWy(this.f19839in.readShort());
                        this.state.setExtentWx(this.f19839in.readShort());
                        break;
                    case 531:
                        int readShort = this.f19839in.readShort();
                        int readShort2 = this.f19839in.readShort();
                        Point currentPoint = this.state.getCurrentPoint();
                        this.f19838cb.moveTo(this.state.transformX(currentPoint.f19840x), this.state.transformY(currentPoint.f19841y));
                        this.f19838cb.lineTo(this.state.transformX(readShort2), this.state.transformY(readShort));
                        this.f19838cb.stroke();
                        this.state.setCurrentPoint(new Point(readShort2, readShort));
                        break;
                    case 532:
                        this.state.setCurrentPoint(new Point(this.f19839in.readShort(), this.f19839in.readShort()));
                        break;
                    case META_CREATEPENINDIRECT /* 762 */:
                        MetaPen metaPen = new MetaPen();
                        metaPen.init(this.f19839in);
                        this.state.addMetaObject(metaPen);
                        break;
                    case META_CREATEFONTINDIRECT /* 763 */:
                        MetaFont metaFont = new MetaFont();
                        metaFont.init(this.f19839in);
                        this.state.addMetaObject(metaFont);
                        break;
                    case META_CREATEBRUSHINDIRECT /* 764 */:
                        MetaBrush metaBrush = new MetaBrush();
                        metaBrush.init(this.f19839in);
                        this.state.addMetaObject(metaBrush);
                        break;
                    case META_POLYGON /* 804 */:
                        if (isNullStrokeFill(false)) {
                            break;
                        } else {
                            int readWord2 = this.f19839in.readWord();
                            int readShort3 = this.f19839in.readShort();
                            int readShort4 = this.f19839in.readShort();
                            this.f19838cb.moveTo(this.state.transformX(readShort3), this.state.transformY(readShort4));
                            for (int i5 = 1; i5 < readWord2; i5++) {
                                this.f19838cb.lineTo(this.state.transformX(this.f19839in.readShort()), this.state.transformY(this.f19839in.readShort()));
                            }
                            this.f19838cb.lineTo(this.state.transformX(readShort3), this.state.transformY(readShort4));
                            strokeAndFill();
                            break;
                        }
                    case META_POLYLINE /* 805 */:
                        this.state.setLineJoinPolygon(this.f19838cb);
                        int readWord3 = this.f19839in.readWord();
                        this.f19838cb.moveTo(this.state.transformX(this.f19839in.readShort()), this.state.transformY(this.f19839in.readShort()));
                        for (int i6 = 1; i6 < readWord3; i6++) {
                            this.f19838cb.lineTo(this.state.transformX(this.f19839in.readShort()), this.state.transformY(this.f19839in.readShort()));
                        }
                        this.f19838cb.stroke();
                        break;
                    case META_INTERSECTCLIPRECT /* 1046 */:
                        float transformY = this.state.transformY(this.f19839in.readShort());
                        float transformX = this.state.transformX(this.f19839in.readShort());
                        float transformY2 = this.state.transformY(this.f19839in.readShort());
                        float transformX2 = this.state.transformX(this.f19839in.readShort());
                        this.f19838cb.rectangle(transformX2, transformY, transformX - transformX2, transformY2 - transformY);
                        this.f19838cb.eoClip();
                        this.f19838cb.newPath();
                        break;
                    case META_ELLIPSE /* 1048 */:
                        if (isNullStrokeFill(this.state.getLineNeutral())) {
                            break;
                        } else {
                            this.f19838cb.arc(this.state.transformX(this.f19839in.readShort()), this.state.transformY(this.f19839in.readShort()), this.state.transformX(this.f19839in.readShort()), this.state.transformY(this.f19839in.readShort()), ColumnText.GLOBAL_SPACE_CHAR_RATIO, 360.0f);
                            strokeAndFill();
                            break;
                        }
                    case META_RECTANGLE /* 1051 */:
                        if (isNullStrokeFill(true)) {
                            break;
                        } else {
                            float transformY3 = this.state.transformY(this.f19839in.readShort());
                            float transformX3 = this.state.transformX(this.f19839in.readShort());
                            float transformY4 = this.state.transformY(this.f19839in.readShort());
                            float transformX4 = this.state.transformX(this.f19839in.readShort());
                            this.f19838cb.rectangle(transformX4, transformY3, transformX3 - transformX4, transformY4 - transformY3);
                            strokeAndFill();
                            break;
                        }
                    case META_SETPIXEL /* 1055 */:
                        BaseColor readColor = this.f19839in.readColor();
                        int readShort5 = this.f19839in.readShort();
                        int readShort6 = this.f19839in.readShort();
                        this.f19838cb.saveState();
                        this.f19838cb.setColorFill(readColor);
                        this.f19838cb.rectangle(this.state.transformX(readShort6), this.state.transformY(readShort5), 0.2f, 0.2f);
                        this.f19838cb.fill();
                        this.f19838cb.restoreState();
                        break;
                    case META_TEXTOUT /* 1313 */:
                        int readWord4 = this.f19839in.readWord();
                        byte[] bArr = new byte[readWord4];
                        int i7 = 0;
                        while (i7 < readWord4) {
                            byte readByte = (byte) this.f19839in.readByte();
                            if (readByte != 0) {
                                bArr[i7] = readByte;
                                i7++;
                            }
                        }
                        try {
                            str = new String(bArr, 0, i7, "Cp1252");
                        } catch (UnsupportedEncodingException unused) {
                            str = new String(bArr, 0, i7);
                        }
                        this.f19839in.skip(((readWord4 + 1) & 65534) - i7);
                        outputText(this.f19839in.readShort(), this.f19839in.readShort(), 0, 0, 0, 0, 0, str);
                        break;
                    case META_POLYPOLYGON /* 1336 */:
                        if (isNullStrokeFill(false)) {
                            break;
                        } else {
                            int readWord5 = this.f19839in.readWord();
                            int[] iArr = new int[readWord5];
                            for (int i8 = 0; i8 < readWord5; i8++) {
                                iArr[i8] = this.f19839in.readWord();
                            }
                            for (int i9 = 0; i9 < readWord5; i9++) {
                                int i10 = iArr[i9];
                                int readShort7 = this.f19839in.readShort();
                                int readShort8 = this.f19839in.readShort();
                                this.f19838cb.moveTo(this.state.transformX(readShort7), this.state.transformY(readShort8));
                                for (int i11 = 1; i11 < i10; i11++) {
                                    this.f19838cb.lineTo(this.state.transformX(this.f19839in.readShort()), this.state.transformY(this.f19839in.readShort()));
                                }
                                this.f19838cb.lineTo(this.state.transformX(readShort7), this.state.transformY(readShort8));
                            }
                            strokeAndFill();
                            break;
                        }
                    case META_ROUNDRECT /* 1564 */:
                        if (isNullStrokeFill(true)) {
                            break;
                        } else {
                            float transformY5 = this.state.transformY(0) - this.state.transformY(this.f19839in.readShort());
                            float transformX5 = this.state.transformX(this.f19839in.readShort()) - this.state.transformX(0);
                            float transformY6 = this.state.transformY(this.f19839in.readShort());
                            float transformX6 = this.state.transformX(this.f19839in.readShort());
                            float transformY7 = this.state.transformY(this.f19839in.readShort());
                            float transformX7 = this.state.transformX(this.f19839in.readShort());
                            this.f19838cb.roundRectangle(transformX7, transformY6, transformX6 - transformX7, transformY7 - transformY6, (transformY5 + transformX5) / 4.0f);
                            strokeAndFill();
                            break;
                        }
                    case META_ARC /* 2071 */:
                        if (isNullStrokeFill(this.state.getLineNeutral())) {
                            break;
                        } else {
                            float transformY8 = this.state.transformY(this.f19839in.readShort());
                            float transformX8 = this.state.transformX(this.f19839in.readShort());
                            float transformY9 = this.state.transformY(this.f19839in.readShort());
                            float transformX9 = this.state.transformX(this.f19839in.readShort());
                            float transformY10 = this.state.transformY(this.f19839in.readShort());
                            float transformX10 = this.state.transformX(this.f19839in.readShort());
                            float transformY11 = this.state.transformY(this.f19839in.readShort());
                            float transformX11 = this.state.transformX(this.f19839in.readShort());
                            float f = (transformX10 + transformX11) / 2.0f;
                            float f2 = (transformY11 + transformY10) / 2.0f;
                            float arc = getArc(f, f2, transformX9, transformY9);
                            float arc2 = getArc(f, f2, transformX8, transformY8) - arc;
                            this.f19838cb.arc(transformX11, transformY10, transformX10, transformY11, arc, arc2 <= ColumnText.GLOBAL_SPACE_CHAR_RATIO ? arc2 + 360.0f : arc2);
                            this.f19838cb.stroke();
                            break;
                        }
                    case META_PIE /* 2074 */:
                        if (isNullStrokeFill(this.state.getLineNeutral())) {
                            break;
                        } else {
                            float transformY12 = this.state.transformY(this.f19839in.readShort());
                            float transformX12 = this.state.transformX(this.f19839in.readShort());
                            float transformY13 = this.state.transformY(this.f19839in.readShort());
                            float transformX13 = this.state.transformX(this.f19839in.readShort());
                            float transformY14 = this.state.transformY(this.f19839in.readShort());
                            float transformX14 = this.state.transformX(this.f19839in.readShort());
                            float transformY15 = this.state.transformY(this.f19839in.readShort());
                            float transformX15 = this.state.transformX(this.f19839in.readShort());
                            float f3 = (transformX14 + transformX15) / 2.0f;
                            float f4 = (transformY15 + transformY14) / 2.0f;
                            float arc3 = getArc(f3, f4, transformX13, transformY13);
                            float arc4 = getArc(f3, f4, transformX12, transformY12) - arc3;
                            ArrayList<float[]> bezierArc = PdfContentByte.bezierArc(transformX15, transformY14, transformX14, transformY15, arc3, arc4 <= ColumnText.GLOBAL_SPACE_CHAR_RATIO ? arc4 + 360.0f : arc4);
                            if (bezierArc.isEmpty()) {
                                break;
                            } else {
                                float[] fArr = bezierArc.get(0);
                                this.f19838cb.moveTo(f3, f4);
                                this.f19838cb.lineTo(fArr[0], fArr[1]);
                                for (int i12 = 0; i12 < bezierArc.size(); i12++) {
                                    float[] fArr2 = bezierArc.get(i12);
                                    this.f19838cb.curveTo(fArr2[2], fArr2[3], fArr2[4], fArr2[5], fArr2[6], fArr2[7]);
                                }
                                this.f19838cb.lineTo(f3, f4);
                                strokeAndFill();
                                break;
                            }
                        }
                    case META_CHORD /* 2096 */:
                        if (isNullStrokeFill(this.state.getLineNeutral())) {
                            break;
                        } else {
                            float transformY16 = this.state.transformY(this.f19839in.readShort());
                            float transformX16 = this.state.transformX(this.f19839in.readShort());
                            float transformY17 = this.state.transformY(this.f19839in.readShort());
                            float transformX17 = this.state.transformX(this.f19839in.readShort());
                            float transformY18 = this.state.transformY(this.f19839in.readShort());
                            float transformX18 = this.state.transformX(this.f19839in.readShort());
                            float transformY19 = this.state.transformY(this.f19839in.readShort());
                            float transformX19 = this.state.transformX(this.f19839in.readShort());
                            float f5 = (transformX18 + transformX19) / 2.0f;
                            float f6 = (transformY19 + transformY18) / 2.0f;
                            float arc5 = getArc(f5, f6, transformX17, transformY17);
                            float arc6 = getArc(f5, f6, transformX16, transformY16) - arc5;
                            ArrayList<float[]> bezierArc2 = PdfContentByte.bezierArc(transformX19, transformY18, transformX18, transformY19, arc5, arc6 <= ColumnText.GLOBAL_SPACE_CHAR_RATIO ? arc6 + 360.0f : arc6);
                            if (bezierArc2.isEmpty()) {
                                break;
                            } else {
                                float[] fArr3 = bezierArc2.get(0);
                                float f7 = fArr3[0];
                                float f8 = fArr3[1];
                                this.f19838cb.moveTo(f7, f8);
                                for (int i13 = 0; i13 < bezierArc2.size(); i13++) {
                                    float[] fArr4 = bezierArc2.get(i13);
                                    this.f19838cb.curveTo(fArr4[2], fArr4[3], fArr4[4], fArr4[5], fArr4[6], fArr4[7]);
                                }
                                this.f19838cb.lineTo(f7, f8);
                                strokeAndFill();
                                break;
                            }
                        }
                    case META_EXTTEXTOUT /* 2610 */:
                        int readShort9 = this.f19839in.readShort();
                        int readShort10 = this.f19839in.readShort();
                        int readWord6 = this.f19839in.readWord();
                        int readWord7 = this.f19839in.readWord();
                        if ((readWord7 & 6) != 0) {
                            i = this.f19839in.readShort();
                            i2 = this.f19839in.readShort();
                            i3 = this.f19839in.readShort();
                            i4 = this.f19839in.readShort();
                        } else {
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                            i4 = 0;
                        }
                        byte[] bArr2 = new byte[readWord6];
                        int i14 = 0;
                        while (i14 < readWord6) {
                            byte readByte2 = (byte) this.f19839in.readByte();
                            if (readByte2 != 0) {
                                bArr2[i14] = readByte2;
                                i14++;
                            }
                        }
                        try {
                            str2 = new String(bArr2, 0, i14, "Cp1252");
                        } catch (UnsupportedEncodingException unused2) {
                            str2 = new String(bArr2, 0, i14);
                        }
                        outputText(readShort10, readShort9, readWord7, i, i2, i3, i4, str2);
                        break;
                    case META_DIBSTRETCHBLT /* 2881 */:
                    case META_STRETCHDIB /* 3907 */:
                        this.f19839in.readInt();
                        if (readWord == 3907) {
                            this.f19839in.readWord();
                        }
                        int readShort11 = this.f19839in.readShort();
                        int readShort12 = this.f19839in.readShort();
                        int readShort13 = this.f19839in.readShort();
                        int readShort14 = this.f19839in.readShort();
                        float transformY20 = this.state.transformY(this.f19839in.readShort()) - this.state.transformY(0);
                        float transformX20 = this.state.transformX(this.f19839in.readShort()) - this.state.transformX(0);
                        float transformY21 = this.state.transformY(this.f19839in.readShort());
                        float transformX21 = this.state.transformX(this.f19839in.readShort());
                        byte[] bArr3 = new byte[(readInt * 2) - (this.f19839in.getLength() - length)];
                        for (int i15 = 0; i15 < bArr3.length; i15++) {
                            bArr3[i15] = (byte) this.f19839in.readByte();
                        }
                        try {
                            Image image = BmpImage.getImage(new ByteArrayInputStream(bArr3), true, bArr3.length);
                            this.f19838cb.saveState();
                            this.f19838cb.rectangle(transformX21, transformY21, transformX20, transformY20);
                            this.f19838cb.clip();
                            this.f19838cb.newPath();
                            float f9 = readShort12;
                            float f10 = readShort11;
                            image.scaleAbsolute((image.getWidth() * transformX20) / f9, ((-transformY20) * image.getHeight()) / f10);
                            image.setAbsolutePosition(transformX21 - ((transformX20 * readShort14) / f9), (transformY21 + ((transformY20 * readShort13) / f10)) - image.getScaledHeight());
                            this.f19838cb.addImage(image);
                            this.f19838cb.restoreState();
                            break;
                        } catch (Exception unused3) {
                            break;
                        }
                }
                InputMeta inputMeta = this.f19839in;
                inputMeta.skip((readInt * 2) - (inputMeta.getLength() - length));
            } else {
                this.state.cleanup(this.f19838cb);
                return;
            }
        }
    }

    public void outputText(int i, int i2, int i3, int i4, int i5, int i6, int i7, String str) {
        MetaFont currentFont = this.state.getCurrentFont();
        float transformX = this.state.transformX(i);
        float transformY = this.state.transformY(i2);
        double transformAngle = this.state.transformAngle(currentFont.getAngle());
        float sin = (float) Math.sin(transformAngle);
        float cos = (float) Math.cos(transformAngle);
        float fontSize = currentFont.getFontSize(this.state);
        BaseFont font = currentFont.getFont();
        int textAlign = this.state.getTextAlign();
        float widthPoint = font.getWidthPoint(str, fontSize);
        float fontDescriptor = font.getFontDescriptor(3, fontSize);
        float fontDescriptor2 = font.getFontDescriptor(8, fontSize);
        this.f19838cb.saveState();
        this.f19838cb.concatCTM(cos, sin, -sin, cos, transformX, transformY);
        int i8 = textAlign & 6;
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float f2 = i8 == 6 ? (-widthPoint) / 2.0f : (textAlign & 2) == 2 ? -widthPoint : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if ((textAlign & 24) != 24) {
            f = (textAlign & 8) == 8 ? -fontDescriptor : -fontDescriptor2;
        }
        if (this.state.getBackgroundMode() == 2) {
            this.f19838cb.setColorFill(this.state.getCurrentBackgroundColor());
            this.f19838cb.rectangle(f2, f + fontDescriptor, widthPoint, fontDescriptor2 - fontDescriptor);
            this.f19838cb.fill();
        }
        this.f19838cb.setColorFill(this.state.getCurrentTextColor());
        this.f19838cb.beginText();
        this.f19838cb.setFontAndSize(font, fontSize);
        this.f19838cb.setTextMatrix(f2, f);
        this.f19838cb.showText(str);
        this.f19838cb.endText();
        if (currentFont.isUnderline()) {
            this.f19838cb.rectangle(f2, f - (fontSize / 4.0f), widthPoint, fontSize / 15.0f);
            this.f19838cb.fill();
        }
        if (currentFont.isStrikeout()) {
            this.f19838cb.rectangle(f2, f + (fontSize / 3.0f), widthPoint, fontSize / 15.0f);
            this.f19838cb.fill();
        }
        this.f19838cb.restoreState();
    }

    public boolean isNullStrokeFill(boolean z) {
        MetaPen currentPen = this.state.getCurrentPen();
        MetaBrush currentBrush = this.state.getCurrentBrush();
        boolean z2 = true;
        boolean z3 = currentPen.getStyle() == 5;
        int style = currentBrush.getStyle();
        z2 = (!z3 || (style == 0 || (style == 2 && this.state.getBackgroundMode() == 2))) ? false : false;
        if (!z3) {
            if (z) {
                this.state.setLineJoinRectangle(this.f19838cb);
            } else {
                this.state.setLineJoinPolygon(this.f19838cb);
            }
        }
        return z2;
    }

    public void strokeAndFill() {
        MetaPen currentPen = this.state.getCurrentPen();
        MetaBrush currentBrush = this.state.getCurrentBrush();
        int style = currentPen.getStyle();
        int style2 = currentBrush.getStyle();
        if (style == 5) {
            this.f19838cb.closePath();
            if (this.state.getPolyFillMode() == 1) {
                this.f19838cb.eoFill();
                return;
            } else {
                this.f19838cb.fill();
                return;
            }
        }
        if (style2 == 0 || (style2 == 2 && this.state.getBackgroundMode() == 2)) {
            if (this.state.getPolyFillMode() == 1) {
                this.f19838cb.closePathEoFillStroke();
                return;
            } else {
                this.f19838cb.closePathFillStroke();
                return;
            }
        }
        this.f19838cb.closePathStroke();
    }

    static float getArc(float f, float f2, float f3, float f4) {
        double atan2 = Math.atan2(f4 - f2, f3 - f);
        if (atan2 < 0.0d) {
            atan2 += 6.283185307179586d;
        }
        return (float) ((atan2 / 3.141592653589793d) * 180.0d);
    }

    public static byte[] wrapBMP(Image image) throws IOException {
        byte[] originalData;
        if (image.getOriginalType() != 4) {
            throw new IOException(MessageLocalization.getComposedMessage("only.bmp.can.be.wrapped.in.wmf", new Object[0]));
        }
        if (image.getOriginalData() == null) {
            InputStream openStream = image.getUrl().openStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = openStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            }
            openStream.close();
            originalData = byteArrayOutputStream.toByteArray();
        } else {
            originalData = image.getOriginalData();
        }
        int length = ((originalData.length - 14) + 1) >>> 1;
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        writeWord(byteArrayOutputStream2, 1);
        writeWord(byteArrayOutputStream2, 9);
        writeWord(byteArrayOutputStream2, 768);
        writeDWord(byteArrayOutputStream2, length + 36 + 3);
        writeWord(byteArrayOutputStream2, 1);
        writeDWord(byteArrayOutputStream2, length + 14);
        writeWord(byteArrayOutputStream2, 0);
        writeDWord(byteArrayOutputStream2, 4);
        writeWord(byteArrayOutputStream2, 259);
        writeWord(byteArrayOutputStream2, 8);
        writeDWord(byteArrayOutputStream2, 5);
        writeWord(byteArrayOutputStream2, META_SETWINDOWORG);
        writeWord(byteArrayOutputStream2, 0);
        writeWord(byteArrayOutputStream2, 0);
        writeDWord(byteArrayOutputStream2, 5);
        writeWord(byteArrayOutputStream2, META_SETWINDOWEXT);
        writeWord(byteArrayOutputStream2, (int) image.getHeight());
        writeWord(byteArrayOutputStream2, (int) image.getWidth());
        writeDWord(byteArrayOutputStream2, length + 13);
        writeWord(byteArrayOutputStream2, META_DIBSTRETCHBLT);
        writeDWord(byteArrayOutputStream2, 13369376);
        writeWord(byteArrayOutputStream2, (int) image.getHeight());
        writeWord(byteArrayOutputStream2, (int) image.getWidth());
        writeWord(byteArrayOutputStream2, 0);
        writeWord(byteArrayOutputStream2, 0);
        writeWord(byteArrayOutputStream2, (int) image.getHeight());
        writeWord(byteArrayOutputStream2, (int) image.getWidth());
        writeWord(byteArrayOutputStream2, 0);
        writeWord(byteArrayOutputStream2, 0);
        byteArrayOutputStream2.write(originalData, 14, originalData.length - 14);
        if ((originalData.length & 1) == 1) {
            byteArrayOutputStream2.write(0);
        }
        writeDWord(byteArrayOutputStream2, 3);
        writeWord(byteArrayOutputStream2, 0);
        byteArrayOutputStream2.close();
        return byteArrayOutputStream2.toByteArray();
    }

    public static void writeWord(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >>> 8) & 255);
    }

    public static void writeDWord(OutputStream outputStream, int i) throws IOException {
        writeWord(outputStream, i & 65535);
        writeWord(outputStream, (i >>> 16) & 65535);
    }
}
