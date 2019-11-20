package com.catalog.fetch;

import com.catalog.ProductTypeConstants;
import com.catalog.models.ProductType1;
import com.catalog.models.ProductType2;
import com.catalog.models.ProductType3;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CurlJsonItemFetcherProductTypeIntegrationTests {
    @Test
    void givenRequestForProductType1_whenFetchItems_ThenProductType1CollectionIsReturned(){
        Type productType1FetchType = new TypeToken<Collection<ProductType1>>(){}.getType();

        CurlJsonItemFetcher curlJsonItemFetcher = new CurlJsonItemFetcher();

        Collection<ProductType1> productType1s = new LinkedList<>(
                curlJsonItemFetcher.FetchItems(ProductTypeConstants.productType1Source, productType1FetchType, new GsonWrapper(), new CurlReaderBuilder()));

        assertTrue(productType1s.size() > 0);
    }

    @Test
    void givenRequestForProductType2_whenFetchItems_ThenProductType2CollectionIsReturned(){
        Type productType2FetchType = new TypeToken<Collection<ProductType2>>(){}.getType();

        CurlJsonItemFetcher curlJsonItemFetcher = new CurlJsonItemFetcher();

        Collection<ProductType1> productType2s = new LinkedList<>(
                curlJsonItemFetcher.FetchItems(ProductTypeConstants.productType2Source, productType2FetchType, new GsonWrapper(), new CurlReaderBuilder()));

        assertTrue(productType2s.size() > 0);
    }

    @Test
    void givenRequestForProductType3_whenFetchItems_ThenProductType3CollectionIsReturned(){
        Type productType3FetchType = new TypeToken<Collection<ProductType3>>(){}.getType();

        CurlJsonItemFetcher curlJsonItemFetcher = new CurlJsonItemFetcher();

        Collection<ProductType1> productType3s = new LinkedList<>(
                curlJsonItemFetcher.FetchItems(ProductTypeConstants.productType3Source, productType3FetchType, new GsonWrapper(), new CurlReaderBuilder()));

        assertTrue(productType3s.size() > 0);
    }
}


