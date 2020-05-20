package com.baidu.platform.core.p093a;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.itextpdf.text.pdf.PdfBoolean;
import com.mopub.common.AdType;

/* renamed from: com.baidu.platform.core.a.a */
/* loaded from: classes.dex */
public class C1329a extends AbstractC1323c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1329a(DistrictSearchOption districtSearchOption) {
        m9919a(districtSearchOption);
    }

    /* renamed from: a */
    private void m9919a(DistrictSearchOption districtSearchOption) {
        C1384a c1384a;
        String str;
        String str2;
        if (districtSearchOption == null) {
            return;
        }
        this.f6490a.m9767a("qt", "con");
        this.f6490a.m9767a("rp_format", AdType.STATIC_NATIVE);
        this.f6490a.m9767a("rp_filter", "mobile");
        this.f6490a.m9767a("area_res", PdfBoolean.TRUE);
        this.f6490a.m9767a("addr_identify", "1");
        this.f6490a.m9767a("ie", "utf-8");
        this.f6490a.m9767a("pn", "0");
        this.f6490a.m9767a("rn", DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_MENUPATH);
        this.f6490a.m9767a("c", districtSearchOption.mCityName);
        if (districtSearchOption.mDistrictName == null || districtSearchOption.mDistrictName.equals("")) {
            c1384a = this.f6490a;
            str = "wd";
            str2 = districtSearchOption.mCityName;
        } else {
            c1384a = this.f6490a;
            str = "wd";
            str2 = districtSearchOption.mDistrictName;
        }
        c1384a.m9767a(str, str2);
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9774n();
    }
}
