package com.catalog;

import com.catalog.models.ProductType1;
import com.catalog.models.ProductType2;
import com.catalog.models.ProductType3;

import java.lang.reflect.Type;
import java.util.Set;

public class ProductTypeConstants {
    public static final String productType1Source = "curl -X GET -H \"x-api-key: aGID7hE0qO3Uom0Cwb8Ul6Xxp4EuqebX9YuP4nBF\" -H \"Content-Type: application/json\" https://plzp0m26nf.execute-api.us-west-2.amazonaws.com/default/GetProducts1";
    public static final String productType2Source = "curl -X GET -H \"x-api-key: aGID7hE0qO3Uom0Cwb8Ul6Xxp4EuqebX9YuP4nBF\" -H \"Content-Type: application/json\" https://plzp0m26nf.execute-api.us-west-2.amazonaws.com/default/GetProducts2";
    public static final String productType3Source = "curl -X GET -H \"x-api-key: aGID7hE0qO3Uom0Cwb8Ul6Xxp4EuqebX9YuP4nBF\" -H \"Content-Type: application/json\" https://plzp0m26nf.execute-api.us-west-2.amazonaws.com/default/GetProducts3";

    public static final Set<Type> productTypes =
            Set.of(
                    ProductType1.class,
                    ProductType2.class,
                    ProductType3.class
                    );
}
