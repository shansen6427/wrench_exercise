package com.catalog;

import com.catalog.fetch.*;
import com.catalog.models.GenericCatalog;
import com.catalog.models.GenericCatalogItem;
import com.catalog.models.ProductToCatalogItemConverter;

import java.util.Collection;

public class GenericCatalogItemProvider {

    public Collection<GenericCatalogItem> GetCatalogItems() {
        CurlJsonItemFetcher curlJsonItemFetcher = new CurlJsonItemFetcher();
        GsonWrapper gsonWrapper = new GsonWrapper();
        ProductToCatalogItemConverter productToCatalogItemConverter = new ProductToCatalogItemConverter();

        GenericCatalog genericCatalog = new GenericCatalog();

        ProductFetchInfoFactory productFetchInfoFactory = new ProductFetchInfoFactory();
        for(ProductFetchInfo productFetchInfo : productFetchInfoFactory.buildProductFetchInfos()){
            Collection products =
                    curlJsonItemFetcher.FetchItems(productFetchInfo.getTarget(), productFetchInfo.getProductFetchType(), gsonWrapper, new CurlReaderBuilder());
            if (products != null){
                Collection genericCatalogItemsFromProductType =
                        productToCatalogItemConverter.ConvertProducts(productFetchInfo.getProductType(), products);
                genericCatalog.addAll(genericCatalogItemsFromProductType);
            }
        }

        return genericCatalog.getCatalogItems();
    }
}
