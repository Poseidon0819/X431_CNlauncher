package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.ColumnText;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class LocationTextExtractionStrategy implements TextExtractionStrategy {
    static boolean DUMP_STATE = false;
    private final List<TextChunk> locationalResult = new ArrayList();

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
    }

    private boolean startsWithSpace(String str) {
        return str.length() != 0 && str.charAt(0) == ' ';
    }

    private boolean endsWithSpace(String str) {
        return str.length() != 0 && str.charAt(str.length() - 1) == ' ';
    }

    @Override // com.itextpdf.text.pdf.parser.TextExtractionStrategy
    public String getResultantText() {
        if (DUMP_STATE) {
            dumpState();
        }
        Collections.sort(this.locationalResult);
        StringBuffer stringBuffer = new StringBuffer();
        TextChunk textChunk = null;
        for (TextChunk textChunk2 : this.locationalResult) {
            if (textChunk == null) {
                stringBuffer.append(textChunk2.text);
            } else if (textChunk2.sameLine(textChunk)) {
                float distanceFromEndOf = textChunk2.distanceFromEndOf(textChunk);
                if (distanceFromEndOf < (-textChunk2.charSpaceWidth)) {
                    stringBuffer.append(TokenParser.f24154SP);
                } else if (distanceFromEndOf > textChunk2.charSpaceWidth / 2.0f && !startsWithSpace(textChunk2.text) && !endsWithSpace(textChunk.text)) {
                    stringBuffer.append(TokenParser.f24154SP);
                }
                stringBuffer.append(textChunk2.text);
            } else {
                stringBuffer.append('\n');
                stringBuffer.append(textChunk2.text);
            }
            textChunk = textChunk2;
        }
        return stringBuffer.toString();
    }

    private void dumpState() {
        for (TextChunk textChunk : this.locationalResult) {
            textChunk.printDiagnostics();
            System.out.println();
        }
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderText(TextRenderInfo textRenderInfo) {
        LineSegment baseline = textRenderInfo.getBaseline();
        this.locationalResult.add(new TextChunk(textRenderInfo.getText(), baseline.getStartPoint(), baseline.getEndPoint(), textRenderInfo.getSingleSpaceWidth()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextChunk implements Comparable<TextChunk> {
        final float charSpaceWidth;
        final float distParallelEnd;
        final float distParallelStart;
        final int distPerpendicular;
        final Vector endLocation;
        final int orientationMagnitude;
        final Vector orientationVector;
        final Vector startLocation;
        final String text;

        private static int compareInts(int i, int i2) {
            if (i == i2) {
                return 0;
            }
            return i < i2 ? -1 : 1;
        }

        public TextChunk(String str, Vector vector, Vector vector2, float f) {
            this.text = str;
            this.startLocation = vector;
            this.endLocation = vector2;
            this.charSpaceWidth = f;
            Vector subtract = vector2.subtract(vector);
            this.orientationVector = (subtract.length() == ColumnText.GLOBAL_SPACE_CHAR_RATIO ? new Vector(1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO) : subtract).normalize();
            this.orientationMagnitude = (int) (Math.atan2(this.orientationVector.get(1), this.orientationVector.get(0)) * 1000.0d);
            this.distPerpendicular = (int) vector.subtract(new Vector(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f)).cross(this.orientationVector).get(2);
            this.distParallelStart = this.orientationVector.dot(vector);
            this.distParallelEnd = this.orientationVector.dot(vector2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printDiagnostics() {
            PrintStream printStream = System.out;
            printStream.println("Text (@" + this.startLocation + " -> " + this.endLocation + "): " + this.text);
            PrintStream printStream2 = System.out;
            StringBuilder sb = new StringBuilder("orientationMagnitude: ");
            sb.append(this.orientationMagnitude);
            printStream2.println(sb.toString());
            PrintStream printStream3 = System.out;
            printStream3.println("distPerpendicular: " + this.distPerpendicular);
            PrintStream printStream4 = System.out;
            printStream4.println("distParallel: " + this.distParallelStart);
        }

        public boolean sameLine(TextChunk textChunk) {
            return this.orientationMagnitude == textChunk.orientationMagnitude && this.distPerpendicular == textChunk.distPerpendicular;
        }

        public float distanceFromEndOf(TextChunk textChunk) {
            return this.distParallelStart - textChunk.distParallelEnd;
        }

        @Override // java.lang.Comparable
        public int compareTo(TextChunk textChunk) {
            if (this == textChunk) {
                return 0;
            }
            int compareInts = compareInts(this.orientationMagnitude, textChunk.orientationMagnitude);
            if (compareInts != 0) {
                return compareInts;
            }
            int compareInts2 = compareInts(this.distPerpendicular, textChunk.distPerpendicular);
            return compareInts2 != 0 ? compareInts2 : Float.compare(this.distParallelStart, textChunk.distParallelStart);
        }
    }
}
