package com.cnlaunch.x431pro.module.p255e.p257b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.e.b.e */
/* loaded from: classes.dex */
public class ProductUpgradeResult extends BaseResponse {
    private static final long serialVersionUID = -7299737040670890753L;
    private ProductUpgradeDTO productUpgradeInfo;

    public ProductUpgradeDTO getProductUpgradeInfo() {
        return this.productUpgradeInfo;
    }

    public void setProductUpgradeInfo(ProductUpgradeDTO productUpgradeDTO) {
        this.productUpgradeInfo = productUpgradeDTO;
    }
}
