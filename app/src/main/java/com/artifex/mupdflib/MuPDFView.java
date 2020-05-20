package com.artifex.mupdflib;

import android.graphics.PointF;
import android.graphics.RectF;
import com.artifex.mupdflib.Annotation;

/* loaded from: classes.dex */
public interface MuPDFView {
    void blank(int i);

    void cancelDraw();

    void continueDraw(float f, float f2);

    boolean copySelection();

    void deleteSelectedAnnotation();

    void deselectAnnotation();

    void deselectText();

    int getPage();

    LinkInfo hitLink(float f, float f2);

    boolean markupSelection(Annotation.Type type);

    Hit passClickEvent(float f, float f2);

    void releaseBitmaps();

    void releaseResources();

    void removeHq();

    boolean saveDraw();

    void selectText(float f, float f2, float f3, float f4);

    void setChangeReporter(Runnable runnable);

    void setLinkHighlighting(boolean z);

    void setPage(int i, PointF pointF);

    void setScale(float f);

    void setSearchBoxes(RectF[] rectFArr);

    void setSearchBoxesPrim(RectF[] rectFArr);

    void startDraw(float f, float f2);

    void update();

    void updateHq(boolean z);
}
