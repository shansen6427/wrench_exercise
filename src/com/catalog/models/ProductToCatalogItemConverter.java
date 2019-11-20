package com.catalog.models;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ProductToCatalogItemConverter {

    public Collection<GenericCatalogItem> ConvertProducts(Type productType, Collection products){
        if (productType == ProductType1.class){
            return ConvertProductType1(products);
        }
        else if (productType == ProductType2.class){
            return ConvertProductType2(products);
        }
        else if (productType == ProductType3.class){
            return ConvertProductType3(products);
        }
        else{
            return new LinkedList<>();
        }
    }

    private Collection<GenericCatalogItem> ConvertProductType1(Collection<ProductType1> productType1s) {
        List<GenericCatalogItem> genericCatalogItems = new LinkedList<>();

        for(ProductType1 productType1 : productType1s){
            GenericCatalogItem genericCatalogItem = new GenericCatalogItem();
            genericCatalogItem.setName(productType1.getName());
            genericCatalogItem.setDescription(productType1.getDescription());
            genericCatalogItem.setCategory(ConvertProductType1ProductType(productType1.getProductType()));
            genericCatalogItem.setPrice(productType1.getPrice());

            if (genericCatalogItem.getCategory() != 0){
                genericCatalogItems.add(genericCatalogItem);
            }
        }

        return genericCatalogItems;
    }

    private Collection<GenericCatalogItem> ConvertProductType2(Collection<ProductType2> productType2s) {
        List<GenericCatalogItem> genericCatalogItems = new LinkedList<>();

        for(ProductType2 productType2 : productType2s){
            GenericCatalogItem genericCatalogItem = new GenericCatalogItem();
            genericCatalogItem.setName(productType2.getName());
            genericCatalogItem.setDescription(productType2.getDescription());
            genericCatalogItem.setCategory(ConvertProductType2Category(productType2.getCategory()));
            genericCatalogItem.setPrice(productType2.getPrice());

            if (genericCatalogItem.getCategory() != 0){
                genericCatalogItems.add(genericCatalogItem);
            }
        }

        return genericCatalogItems;
    }

    private Collection<GenericCatalogItem> ConvertProductType3(Collection<ProductType3> productType3s) {
        List<GenericCatalogItem> genericCatalogItems = new LinkedList<>();

        for(ProductType3 productType3 : productType3s){
            GenericCatalogItem genericCatalogItem = new GenericCatalogItem();
            genericCatalogItem.setName(productType3.getName());
            genericCatalogItem.setDescription(productType3.getIncludes());
            genericCatalogItem.setCategory(Category.Detail.getIndex());
            genericCatalogItem.setPrice(productType3.getPrice());

            genericCatalogItems.add(genericCatalogItem);
        }

        return genericCatalogItems;
    }

    private int ConvertProductType2Category(String productCategory) {
        for(Category category : Category.values()){
            if (category.toString().equalsIgnoreCase(productCategory)){
                return category.getIndex();
            }
        }

        return 0;
    }

    private int ConvertProductType1ProductType(String productType) {
        for(Category category : Category.values()){
            if (category.toString().equalsIgnoreCase(productType)){
                return category.getIndex();
            }
        }

        return 0;
    }
}
