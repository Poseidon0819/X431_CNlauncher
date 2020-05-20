package com.cnlaunch.x431pro.module.p255e.p257b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.e.b.b */
/* loaded from: classes.dex */
public class CardConsumeListResult extends BaseResponse {
    private static final long serialVersionUID = -2407217813289095599L;
    private List<CardConsumeDTO> cardConsumeRecordList;

    public List<CardConsumeDTO> getCardConsumeRecordList() {
        return this.cardConsumeRecordList;
    }

    public void setCardConsumeRecordList(List<CardConsumeDTO> list) {
        this.cardConsumeRecordList = list;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "CardConsumeListResult{cardConsumeRecordList=" + this.cardConsumeRecordList + '}';
    }
}
