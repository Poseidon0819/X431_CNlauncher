package com.cnlaunch.x431pro.module.p255e.p257b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.e.b.g */
/* loaded from: classes.dex */
public class ProductsRegDateResponse extends BaseResponse {
    private static final long serialVersionUID = -7427408992013994138L;
    private List<ProductsRegDateDTO> productsRegDateDTOs;

    public List<ProductsRegDateDTO> getProductsRegDateDTOs() {
        return this.productsRegDateDTOs;
    }

    public void setProductsRegDateDTOs(List<ProductsRegDateDTO> list) {
        this.productsRegDateDTOs = list;
    }
}
