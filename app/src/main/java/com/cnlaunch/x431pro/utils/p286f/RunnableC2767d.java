package com.cnlaunch.x431pro.utils.p286f;

import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p283db.CarIconDao;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarIconUtils.java */
/* renamed from: com.cnlaunch.x431pro.utils.f.d */
/* loaded from: classes.dex */
public final class RunnableC2767d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CarIconUtils f15887a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2767d(CarIconUtils carIconUtils) {
        this.f15887a = carIconUtils;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        List list2;
        List<List> list3;
        CarIcon carIcon;
        CarIcon carIcon2;
        CarIcon carIcon3;
        CarIcon carIcon4;
        CarIcon carIcon5;
        CarIcon carIcon6;
        CarIcon carIcon7;
        CarIcon carIcon8;
        CarIcon carIcon9;
        CarIcon carIcon10;
        CarIcon carIcon11;
        CarIcon carIcon12;
        CarIcon carIcon13;
        CarIcon carIcon14;
        CarIconDao carIconDao;
        CarIcon carIcon15;
        list = this.f15887a.f15885x;
        if (list != null) {
            list2 = this.f15887a.f15885x;
            if (list2.size() > 0) {
                list3 = this.f15887a.f15885x;
                for (List<HashMap> list4 : list3) {
                    if (list4 != null && list4.size() > 0) {
                        for (HashMap hashMap : list4) {
                            this.f15887a.f15882u = new CarIcon();
                            carIcon = this.f15887a.f15882u;
                            carIcon.f15790n = "";
                            carIcon2 = this.f15887a.f15882u;
                            carIcon2.f15778b = (String) hashMap.get("softPackageId");
                            carIcon3 = this.f15887a.f15882u;
                            carIcon3.f15779c = (String) hashMap.get("name");
                            carIcon4 = this.f15887a.f15882u;
                            carIcon4.f15780d = (String) hashMap.get("name_zh");
                            carIcon5 = this.f15887a.f15882u;
                            carIcon5.f15781e = (String) hashMap.get("icon");
                            carIcon6 = this.f15887a.f15882u;
                            carIcon6.f15782f = (String) hashMap.get("areaId");
                            carIcon7 = this.f15887a.f15882u;
                            carIcon7.f15783g = (String) hashMap.get("sname");
                            carIcon8 = this.f15887a.f15882u;
                            carIcon8.f15784h = (String) hashMap.get("sname_zh");
                            carIcon9 = this.f15887a.f15882u;
                            carIcon9.f15785i = "";
                            carIcon10 = this.f15887a.f15882u;
                            carIcon10.f15786j = "";
                            carIcon11 = this.f15887a.f15882u;
                            carIcon11.f15787k = Boolean.FALSE;
                            carIcon12 = this.f15887a.f15882u;
                            carIcon12.f15788l = "EN";
                            carIcon13 = this.f15887a.f15882u;
                            carIcon13.m5037a("");
                            carIcon14 = this.f15887a.f15882u;
                            carIcon14.f15791o = Boolean.FALSE;
                            carIconDao = this.f15887a.f15881t;
                            carIcon15 = this.f15887a.f15882u;
                            carIconDao.insert(carIcon15);
                        }
                    }
                }
            }
        }
    }
}
