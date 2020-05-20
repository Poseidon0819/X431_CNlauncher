package com.cnlaunch.x431pro.module.p255e.p257b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.e.b.h */
/* loaded from: classes.dex */
public class RegisteredProductsResponse extends BaseResponse {
    private static final long serialVersionUID = 1824386259294829009L;
    private List<ProductDTO> productDTOs;

    public List<ProductDTO> getProductDTOs() {
        return this.productDTOs;
    }

    public void setProductDTOs(List<ProductDTO> list) {
        this.productDTOs = list;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "RegisteredProductsResponse{productDTOs=" + this.productDTOs + '}';
    }
}
