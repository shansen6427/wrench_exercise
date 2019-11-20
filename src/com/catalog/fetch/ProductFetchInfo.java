package com.catalog.fetch;

import java.lang.reflect.Type;

public class ProductFetchInfo{
    private Type productType;
    private String target;
    private Type productFetchType;

    public ProductFetchInfo(Type productType, String target, Type productFetchType) {
        this.productType = productType;
        this.target = target;
        this.productFetchType = productFetchType;
    }

    public Type getProductType() {
        return productType;
    }

    public void setProductType(Type productType) {
        this.productType = productType;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Type getProductFetchType() {
        return productFetchType;
    }

    public void setProductFetchType(Type productFetchType) {
        this.productFetchType = productFetchType;
    }
}
