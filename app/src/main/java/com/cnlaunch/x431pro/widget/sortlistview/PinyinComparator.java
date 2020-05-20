package com.cnlaunch.x431pro.widget.sortlistview;

import java.util.Comparator;

/* renamed from: com.cnlaunch.x431pro.widget.sortlistview.b */
/* loaded from: classes.dex */
public final class PinyinComparator implements Comparator<SortModel> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(SortModel sortModel, SortModel sortModel2) {
        SortModel sortModel3 = sortModel;
        SortModel sortModel4 = sortModel2;
        if (sortModel3.f16812b.equals("@") || sortModel4.f16812b.equals("#")) {
            return -1;
        }
        if (sortModel3.f16812b.equals("#") || sortModel4.f16812b.equals("@")) {
            return 1;
        }
        return sortModel3.f16812b.compareTo(sortModel4.f16812b);
    }
}
