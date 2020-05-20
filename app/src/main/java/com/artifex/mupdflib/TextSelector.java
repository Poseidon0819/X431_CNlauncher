package com.artifex.mupdflib;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PageView.java */
/* loaded from: classes.dex */
class TextSelector {
    private final RectF mSelectBox;
    private final TextWord[][] mText;

    public TextSelector(TextWord[][] textWordArr, RectF rectF) {
        this.mText = textWordArr;
        this.mSelectBox = rectF;
    }

    public void select(TextProcessor textProcessor) {
        TextWord[][] textWordArr;
        if (this.mText == null || this.mSelectBox == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (TextWord[] textWordArr2 : this.mText) {
            if (textWordArr2[0].bottom > this.mSelectBox.top && textWordArr2[0].top < this.mSelectBox.bottom) {
                arrayList.add(textWordArr2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TextWord[] textWordArr3 = (TextWord[]) it.next();
            boolean z = textWordArr3[0].top < this.mSelectBox.top;
            boolean z2 = textWordArr3[0].bottom > this.mSelectBox.bottom;
            float f = Float.NEGATIVE_INFINITY;
            float f2 = Float.POSITIVE_INFINITY;
            if (z && z2) {
                f = Math.min(this.mSelectBox.left, this.mSelectBox.right);
                f2 = Math.max(this.mSelectBox.left, this.mSelectBox.right);
            } else if (z) {
                f = this.mSelectBox.left;
            } else if (z2) {
                f2 = this.mSelectBox.right;
            }
            textProcessor.onStartLine();
            for (TextWord textWord : textWordArr3) {
                if (textWord.right > f && textWord.left < f2) {
                    textProcessor.onWord(textWord);
                }
            }
            textProcessor.onEndLine();
        }
    }
}
