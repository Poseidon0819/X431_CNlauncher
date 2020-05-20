package com.baidu.platform.core.p095c;

import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;
import org.jivesoftware.smack.packet.PrivacyItem;
import org.jivesoftware.smackx.GroupChatInvitation;

/* renamed from: com.baidu.platform.core.c.c */
/* loaded from: classes.dex */
public class C1345c extends AbstractC1323c {
    public C1345c(PoiIndoorOption poiIndoorOption) {
        m9888a(poiIndoorOption);
    }

    /* renamed from: a */
    private void m9888a(PoiIndoorOption poiIndoorOption) {
        this.f6490a.m9767a("qt", "indoor_s");
        this.f6490a.m9767a(GroupChatInvitation.ELEMENT_NAME, "0");
        this.f6490a.m9767a("y", "0");
        this.f6490a.m9767a(PrivacyItem.PrivacyRule.SUBSCRIPTION_FROM, "android_map_sdk");
        String str = poiIndoorOption.bid;
        if (str != null && !str.equals("")) {
            this.f6490a.m9767a("bid", str);
        }
        String str2 = poiIndoorOption.f5530wd;
        if (str2 != null && !str2.equals("")) {
            this.f6490a.m9767a("wd", str2);
        }
        String str3 = poiIndoorOption.floor;
        if (str3 != null && !str3.equals("")) {
            this.f6490a.m9767a("floor", str3);
        }
        C1384a c1384a = this.f6490a;
        StringBuilder sb = new StringBuilder();
        sb.append(poiIndoorOption.currentPage);
        c1384a.m9767a("current", sb.toString());
        C1384a c1384a2 = this.f6490a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(poiIndoorOption.pageSize);
        c1384a2.m9767a("pageSize", sb2.toString());
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9785c();
    }
}
