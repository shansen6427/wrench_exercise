package com.catalog.fetch;

import com.catalog.ProductTypeConstants;
import com.catalog.models.ProductType1;
import com.catalog.models.ProductType2;
import com.catalog.models.ProductType3;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class ProductFetchInfoFactory {
    public Collection<ProductFetchInfo> buildProductFetchInfos(){
        return List.of(
                buildFetchInfoForProductType1(),
                buildFetchInfoForProductType2(),
                buildFetchInfoForProductType3()
                );
    }

    private ProductFetchInfo buildFetchInfoForProductType1() {
        Type productType1FetchType = new TypeToken<Collection<ProductType1>>(){}.getType();
        return new ProductFetchInfo(ProductType1.class, ProductTypeConstants.productType1Source, productType1FetchType);
    }

    private ProductFetchInfo buildFetchInfoForProductType2() {
        Type productType2FetchType = new TypeToken<Collection<ProductType2>>(){}.getType();
        return new ProductFetchInfo(ProductType2.class, ProductTypeConstants.productType2Source, productType2FetchType);
    }

    private ProductFetchInfo buildFetchInfoForProductType3() {
        Type productType3FetchType = new TypeToken<Collection<ProductType3>>(){}.getType();
        return new ProductFetchInfo(ProductType3.class, ProductTypeConstants.productType3Source, productType3FetchType);
    }
}
