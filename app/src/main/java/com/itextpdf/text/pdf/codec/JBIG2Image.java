package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgJBIG2;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.codec.JBIG2SegmentReader;

/* loaded from: classes.dex */
public class JBIG2Image {
    public static byte[] getGlobalSegment(RandomAccessFileOrArray randomAccessFileOrArray) {
        try {
            JBIG2SegmentReader jBIG2SegmentReader = new JBIG2SegmentReader(randomAccessFileOrArray);
            jBIG2SegmentReader.read();
            return jBIG2SegmentReader.getGlobal(true);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Image getJbig2Image(RandomAccessFileOrArray randomAccessFileOrArray, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.page.number.must.be.gt.eq.1", new Object[0]));
        }
        try {
            JBIG2SegmentReader jBIG2SegmentReader = new JBIG2SegmentReader(randomAccessFileOrArray);
            jBIG2SegmentReader.read();
            JBIG2SegmentReader.JBIG2Page page = jBIG2SegmentReader.getPage(i);
            return new ImgJBIG2(page.pageBitmapWidth, page.pageBitmapHeight, page.getData(true), jBIG2SegmentReader.getGlobal(true));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static int getNumberOfPages(RandomAccessFileOrArray randomAccessFileOrArray) {
        try {
            JBIG2SegmentReader jBIG2SegmentReader = new JBIG2SegmentReader(randomAccessFileOrArray);
            jBIG2SegmentReader.read();
            return jBIG2SegmentReader.numberOfPages();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
