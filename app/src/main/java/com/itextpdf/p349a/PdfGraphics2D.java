package com.itextpdf.p349a;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import org.apache.http.conn.ssl.TokenParser;

/* renamed from: com.itextpdf.a.c */
/* loaded from: classes.dex */
public class PdfGraphics2D extends Graphics2D {

    /* renamed from: v */
    private static final AffineTransform f19548v = new AffineTransform();

    /* renamed from: A */
    private Stroke f19549A;

    /* renamed from: B */
    private Paint f19550B;

    /* renamed from: C */
    private Paint f19551C;

    /* renamed from: D */
    private MediaTracker f19552D;

    /* renamed from: E */
    private boolean f19553E;

    /* renamed from: F */
    private float f19554F;

    /* renamed from: a */
    protected Font f19555a;

    /* renamed from: b */
    protected BaseFont f19556b;

    /* renamed from: c */
    protected float f19557c;

    /* renamed from: d */
    protected AffineTransform f19558d;

    /* renamed from: e */
    protected Paint f19559e;

    /* renamed from: f */
    protected Color f19560f;

    /* renamed from: g */
    protected float f19561g;

    /* renamed from: h */
    protected float f19562h;

    /* renamed from: i */
    protected Area f19563i;

    /* renamed from: j */
    protected RenderingHints f19564j;

    /* renamed from: k */
    protected Stroke f19565k;

    /* renamed from: l */
    protected Stroke f19566l;

    /* renamed from: m */
    protected PdfContentByte f19567m;

    /* renamed from: n */
    protected HashMap<String, BaseFont> f19568n;

    /* renamed from: o */
    protected boolean f19569o;

    /* renamed from: p */
    protected FontMapper f19570p;

    /* renamed from: q */
    protected PdfGState[] f19571q;

    /* renamed from: r */
    protected PdfGState[] f19572r;

    /* renamed from: s */
    protected int f19573s;

    /* renamed from: t */
    protected int f19574t;

    /* renamed from: u */
    private BasicStroke f19575u;

    /* renamed from: w */
    private ArrayList<C3613c> f19576w;

    /* renamed from: x */
    private boolean f19577x;

    /* renamed from: y */
    private Graphics2D f19578y;

    /* renamed from: z */
    private boolean f19579z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PdfGraphics2D.java */
    /* renamed from: com.itextpdf.a.c$c */
    /* loaded from: classes.dex */
    public static final class C3613c {

        /* renamed from: a */
        final int f19582a;

        /* renamed from: b */
        final PdfGraphics2D f19583b;
    }

    private PdfGraphics2D() {
        this.f19575u = new BasicStroke(1.0f);
        this.f19564j = new RenderingHints((Map) null);
        this.f19569o = false;
        this.f19577x = false;
        this.f19579z = false;
        this.f19573s = 255;
        this.f19574t = 255;
        this.f19553E = false;
        this.f19554F = 0.95f;
    }

    public PdfGraphics2D(PdfContentByte pdfContentByte, float f, float f2) {
        this(pdfContentByte, f, f2, null, false, false, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    public PdfGraphics2D(PdfContentByte pdfContentByte, float f, float f2, FontMapper fontMapper) {
        this(pdfContentByte, f, f2, fontMapper, false, false, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    public PdfGraphics2D(PdfContentByte pdfContentByte, float f, float f2, byte b) {
        this(pdfContentByte, f, f2, null, true, false, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    public PdfGraphics2D(PdfContentByte pdfContentByte, float f, float f2, FontMapper fontMapper, boolean z, boolean z2, float f3) {
        this.f19575u = new BasicStroke(1.0f);
        this.f19564j = new RenderingHints((Map) null);
        this.f19569o = false;
        this.f19577x = false;
        this.f19579z = false;
        this.f19573s = 255;
        this.f19574t = 255;
        this.f19553E = false;
        this.f19554F = 0.95f;
        this.f19571q = new PdfGState[256];
        this.f19572r = new PdfGState[256];
        this.f19553E = z2;
        this.f19554F = f3;
        this.f19579z = z;
        this.f19558d = new AffineTransform();
        this.f19568n = new HashMap<>();
        if (!z) {
            this.f19570p = fontMapper;
            if (this.f19570p == null) {
                this.f19570p = new DefaultFontMapper();
            }
        }
        this.f19559e = Color.black;
        this.f19560f = Color.white;
        Font font = new Font("sanserif", 0, 12);
        if (this.f19579z) {
            this.f19555a = font;
        } else if (font != this.f19555a) {
            this.f19555a = font;
            this.f19557c = font.getSize2D();
            this.f19556b = m2721a(font);
        }
        this.f19567m = pdfContentByte;
        pdfContentByte.saveState();
        this.f19561g = f;
        this.f19562h = f2;
        this.f19563i = new Area(new Rectangle2D.Float((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO, (float) ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, f2));
        Area area = this.f19563i;
        if (area != null) {
            Shape createTransformedShape = this.f19558d.createTransformedShape(area);
            Area area2 = this.f19563i;
            if (area2 == null) {
                this.f19563i = new Area(createTransformedShape);
            } else {
                area2.intersect(new Area(createTransformedShape));
            }
            m2718a(createTransformedShape);
        } else {
            this.f19567m.restoreState();
            this.f19567m.saveState();
            this.f19563i = null;
            this.f19551C = null;
            this.f19550B = null;
            this.f19574t = 255;
            this.f19573s = 255;
            this.f19549A = this.f19575u;
        }
        BasicStroke basicStroke = this.f19575u;
        this.f19549A = basicStroke;
        this.f19565k = basicStroke;
        this.f19566l = basicStroke;
        m2717a(this.f19565k);
        pdfContentByte.saveState();
    }

    /* renamed from: a */
    private void m2717a(Stroke stroke) {
        if (stroke != null && (stroke instanceof BasicStroke)) {
            BasicStroke basicStroke = (BasicStroke) stroke;
            this.f19567m.setLineWidth(basicStroke.getLineWidth());
            int endCap = basicStroke.getEndCap();
            if (endCap == 0) {
                this.f19567m.setLineCap(0);
            } else if (endCap == 2) {
                this.f19567m.setLineCap(2);
            } else {
                this.f19567m.setLineCap(1);
            }
            int lineJoin = basicStroke.getLineJoin();
            if (lineJoin == 0) {
                this.f19567m.setLineJoin(0);
            } else if (lineJoin == 2) {
                this.f19567m.setLineJoin(2);
            } else {
                this.f19567m.setLineJoin(1);
            }
            this.f19567m.setMiterLimit(basicStroke.getMiterLimit());
            float[] dashArray = basicStroke.getDashArray();
            if (dashArray == null) {
                this.f19567m.setLiteral("[]0 d\n");
                return;
            }
            this.f19567m.setLiteral('[');
            for (float f : dashArray) {
                this.f19567m.setLiteral(f);
                this.f19567m.setLiteral(TokenParser.f24154SP);
            }
            this.f19567m.setLiteral(']');
            this.f19567m.setLiteral(basicStroke.getDashPhase());
            this.f19567m.setLiteral(" d\n");
        }
    }

    /* renamed from: a */
    private BaseFont m2721a(Font font) {
        BaseFont baseFont;
        synchronized (this.f19568n) {
            baseFont = this.f19568n.get(font.getFontName());
            if (baseFont == null) {
                baseFont = this.f19570p.mo2724a(font);
                this.f19568n.put(font.getFontName(), baseFont);
            }
        }
        return baseFont;
    }

    /* renamed from: a */
    public final void m2723a() {
        if (this.f19577x || this.f19569o) {
            return;
        }
        this.f19569o = true;
        this.f19567m.restoreState();
        this.f19567m.restoreState();
        Graphics2D graphics2D = this.f19578y;
        if (graphics2D != null) {
            graphics2D.dispose();
            this.f19578y = null;
        }
        if (this.f19576w != null) {
            ByteBuffer byteBuffer = new ByteBuffer();
            m2722a(byteBuffer);
            ByteBuffer internalBuffer = this.f19567m.getInternalBuffer();
            internalBuffer.reset();
            internalBuffer.append(byteBuffer);
        }
    }

    /* renamed from: a */
    private void m2722a(ByteBuffer byteBuffer) {
        ByteBuffer internalBuffer = this.f19567m.getInternalBuffer();
        ArrayList<C3613c> arrayList = this.f19576w;
        int i = 0;
        if (arrayList != null) {
            Iterator<C3613c> it = arrayList.iterator();
            while (it.hasNext()) {
                C3613c next = it.next();
                int i2 = next.f19582a;
                PdfGraphics2D pdfGraphics2D = next.f19583b;
                pdfGraphics2D.f19567m.restoreState();
                pdfGraphics2D.f19567m.restoreState();
                byteBuffer.append(internalBuffer.getBuffer(), i, i2 - i);
                Graphics2D graphics2D = pdfGraphics2D.f19578y;
                if (graphics2D != null) {
                    graphics2D.dispose();
                    pdfGraphics2D.f19578y = null;
                }
                pdfGraphics2D.m2722a(byteBuffer);
                i = i2;
            }
        }
        byteBuffer.append(internalBuffer.getBuffer(), i, internalBuffer.size() - i);
    }

    /* renamed from: a */
    private void m2718a(Shape shape) {
        if (shape == null) {
            return;
        }
        PathIterator pathIterator = shape.getPathIterator(f19548v);
        float[] fArr = new float[6];
        double[] dArr = new double[6];
        int i = 0;
        while (!pathIterator.isDone()) {
            i++;
            int currentSegment = pathIterator.currentSegment(dArr);
            int i2 = currentSegment == 4 ? 0 : currentSegment == 2 ? 2 : currentSegment == 3 ? 3 : 1;
            for (int i3 = 0; i3 < i2 * 2; i3++) {
                fArr[i3] = (float) dArr[i3];
            }
            float f = fArr[1];
            float f2 = this.f19562h;
            fArr[1] = f2 - f;
            fArr[3] = f2 - fArr[3];
            fArr[5] = f2 - fArr[5];
            switch (currentSegment) {
                case 0:
                    this.f19567m.moveTo(fArr[0], fArr[1]);
                    break;
                case 1:
                    this.f19567m.lineTo(fArr[0], fArr[1]);
                    break;
                case 2:
                    this.f19567m.curveTo(fArr[0], fArr[1], fArr[2], fArr[3]);
                    break;
                case 3:
                    this.f19567m.curveTo(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
                    break;
                case 4:
                    this.f19567m.closePath();
                    break;
            }
            pathIterator.next();
        }
        if (i == 0) {
            this.f19567m.rectangle(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        }
        if (pathIterator.getWindingRule() == 0) {
            this.f19567m.eoClip();
        } else {
            this.f19567m.clip();
        }
        this.f19567m.newPath();
    }

    /* renamed from: a */
    public final boolean m2719a(Image image, AffineTransform affineTransform) {
        AffineTransform affineTransform2;
        com.itextpdf.text.Image image2;
        if (affineTransform == null) {
            affineTransform2 = new AffineTransform();
        } else {
            affineTransform2 = new AffineTransform(affineTransform);
        }
        affineTransform2.translate(0.0d, image.getHeight((ImageObserver) null));
        affineTransform2.scale(image.getWidth((ImageObserver) null), image.getHeight((ImageObserver) null));
        double[] dArr = new double[6];
        AffineTransform.getTranslateInstance(0.0d, 0.0d).getMatrix(dArr);
        dArr[3] = -1.0d;
        dArr[5] = this.f19562h;
        AffineTransform affineTransform3 = new AffineTransform(dArr);
        affineTransform3.concatenate(this.f19558d);
        AffineTransform scaleInstance = AffineTransform.getScaleInstance(1.0d, -1.0d);
        affineTransform3.concatenate(affineTransform2);
        affineTransform3.concatenate(scaleInstance);
        double[] dArr2 = new double[6];
        affineTransform3.getMatrix(dArr2);
        if (this.f19573s != 255) {
            PdfGState pdfGState = this.f19571q[255];
            if (pdfGState == null) {
                pdfGState = new PdfGState();
                pdfGState.setFillOpacity(1.0f);
                this.f19571q[255] = pdfGState;
            }
            this.f19567m.setGState(pdfGState);
        }
        try {
            if (!this.f19553E) {
                image2 = com.itextpdf.text.Image.getInstance(image, null);
            } else {
                BufferedImage bufferedImage = new BufferedImage(image.getWidth((ImageObserver) null), image.getHeight((ImageObserver) null), 1);
                Graphics2D createGraphics = bufferedImage.createGraphics();
                createGraphics.drawImage(image, 0, 0, image.getWidth((ImageObserver) null), image.getHeight((ImageObserver) null), (ImageObserver) null);
                createGraphics.dispose();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                JPEGImageWriteParam jPEGImageWriteParam = new JPEGImageWriteParam(Locale.getDefault());
                jPEGImageWriteParam.setCompressionMode(2);
                jPEGImageWriteParam.setCompressionQuality(this.f19554F);
                ImageWriter imageWriter = (ImageWriter) ImageIO.getImageWritersByFormatName("jpg").next();
                ImageOutputStream createImageOutputStream = ImageIO.createImageOutputStream(byteArrayOutputStream);
                imageWriter.setOutput(createImageOutputStream);
                imageWriter.write((IIOMetadata) null, new IIOImage(bufferedImage, (List) null, (IIOMetadata) null), jPEGImageWriteParam);
                imageWriter.dispose();
                createImageOutputStream.close();
                bufferedImage.flush();
                image2 = com.itextpdf.text.Image.getInstance(byteArrayOutputStream.toByteArray());
            }
            this.f19567m.addImage(image2, (float) dArr2[0], (float) dArr2[1], (float) dArr2[2], (float) dArr2[3], (float) dArr2[4], (float) dArr2[5]);
            Object obj = this.f19564j.get(C3612b.f19580a);
            if (obj != null && !obj.equals(C3612b.f19581b)) {
                this.f19567m.setAction(new PdfAction(obj.toString()), (float) dArr2[4], (float) dArr2[5], (float) (dArr2[0] + dArr2[4]), (float) (dArr2[3] + dArr2[5]));
            }
            int i = this.f19573s;
            if (i != 255) {
                this.f19567m.setGState(this.f19571q[i]);
            }
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    public final synchronized void m2720a(Image image) {
        if (this.f19552D == null) {
            this.f19552D = new MediaTracker(new C3611a((byte) 0));
        }
        this.f19552D.addImage(image, 0);
        try {
            this.f19552D.waitForID(0);
        } catch (InterruptedException unused) {
        }
        this.f19552D.removeImage(image);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PdfGraphics2D.java */
    /* renamed from: com.itextpdf.a.c$a */
    /* loaded from: classes.dex */
    public static class C3611a extends Component {
        private C3611a() {
        }

        /* synthetic */ C3611a(byte b) {
            this();
        }
    }

    /* compiled from: PdfGraphics2D.java */
    /* renamed from: com.itextpdf.a.c$b */
    /* loaded from: classes.dex */
    public static class C3612b extends RenderingHints.Key {

        /* renamed from: a */
        public static final C3612b f19580a = new C3612b();

        /* renamed from: b */
        public static final Object f19581b = "0";

        private C3612b() {
            super(9999);
        }
    }
}
