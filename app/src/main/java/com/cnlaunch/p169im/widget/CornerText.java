package com.cnlaunch.p169im.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentParser;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* renamed from: com.cnlaunch.im.widget.CornerText */
/* loaded from: classes.dex */
public class CornerText extends TextView {

    /* renamed from: a */
    protected Paint f9347a;

    public CornerText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9347a = new Paint(1);
        this.f9347a.setAntiAlias(true);
        this.f9347a.setFilterBitmap(true);
        this.f9347a.setStyle(Paint.Style.FILL);
        this.f9347a.setColor(Color.argb(255, 142, (int) Opcodes.INVOKEDYNAMIC, (int) PdfContentParser.COMMAND_TYPE));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        int textSize = ((int) getTextSize()) / 2;
        setPadding(textSize, 0, textSize, 0);
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        Path path = new Path();
        path.moveTo(height, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        float f = width - height;
        path.lineTo(f, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        path.arcTo(new RectF(f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, width, height), 270.0f, 180.0f);
        path.lineTo(height, height);
        path.arcTo(new RectF(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, height, height), 90.0f, 180.0f);
        canvas.drawPath(path, this.f9347a);
        super.onDraw(canvas);
    }
}
