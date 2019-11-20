package com.catalog.models;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductToCatalogItemConverterTest {
    private final String defaultName = "name";
    private final String defaultDescription = "nice item!";
    private final double defaultPrice = 5.0;

    @Test
    void givenValidProductType1s_WhenConvertProducts_ThenReturnCorrectGenericCatalogItems() {
        Collection<ProductType1> productType1s = new LinkedList<>();
        for(Category category : Category.values()){
            productType1s.add(new ProductType1(defaultName, defaultDescription, category.toString(), defaultPrice));
        }
        List<GenericCatalogItem> expectedCatalogItems = new LinkedList<>();
        for(Category category : Category.values()){
            expectedCatalogItems.add(new GenericCatalogItem(defaultName, defaultDescription, category.getIndex(), defaultPrice));
        }

        ProductToCatalogItemConverter cut = new ProductToCatalogItemConverter();

        GenericCatalogItem[] convertedCatalogItems =
                cut.ConvertProducts(ProductType1.class, productType1s).toArray(new GenericCatalogItem[productType1s.size()]);

        for(int index = 0; index < convertedCatalogItems.length; index++){
            assertEquals(convertedCatalogItems[index], expectedCatalogItems.get(index));
        }
    }

    @Test
    void givenAProductType1WithInvalidCategory_WhenConvertProducts_ThenReturnedGenericCatalogItemsDoesContainThatItem() {
        Collection<ProductType1> productType1s = new LinkedList<>();
        productType1s.add(new ProductType1(defaultName, defaultDescription, Category.Diagnostic.toString(), defaultPrice));
        productType1s.add(new ProductType1(defaultName, defaultDescription, "Unknown", defaultPrice));

        ProductToCatalogItemConverter cut = new ProductToCatalogItemConverter();

        List<GenericCatalogItem> convertedCatalogItems =
                new LinkedList<>(cut.ConvertProducts(ProductType1.class, productType1s));

        assertEquals(convertedCatalogItems.size(), 1);
        assertEquals(convertedCatalogItems.get(0).getCategory(), Category.Diagnostic.getIndex());
    }

    @Test
    void givenValidProductType2s_WhenConvertProducts_ThenReturnCorrectGenericCatalogItems() {
        Collection<ProductType2> productType2s = new LinkedList<>();
        for(Category category : Category.values()){
            productType2s.add(new ProductType2(defaultName, defaultDescription, category.toString(), defaultPrice));
        }
        List<GenericCatalogItem> expectedCatalogItems = new LinkedList<>();
        for(Category category : Category.values()){
            expectedCatalogItems.add(new GenericCatalogItem(defaultName, defaultDescription, category.getIndex(), defaultPrice));
        }

        ProductToCatalogItemConverter cut = new ProductToCatalogItemConverter();

        GenericCatalogItem[] convertedCatalogItems =
                cut.ConvertProducts(ProductType2.class, productType2s).toArray(new GenericCatalogItem[productType2s.size()]);

        for(int index = 0; index < convertedCatalogItems.length; index++){
            assertEquals(convertedCatalogItems[index], expectedCatalogItems.get(index));
        }
    }

    @Test
    void givenAProductType2WithInvalidCategory_WhenConvertProductType2s_ThenReturnedGenericCatalogItemsDoesContainThatItem() {
        Collection<ProductType2> productType2s = new LinkedList<>();
        productType2s.add(new ProductType2(defaultName, defaultDescription, Category.Diagnostic.toString(), defaultPrice));
        productType2s.add(new ProductType2(defaultName, defaultDescription, "Unknown", defaultPrice));

        ProductToCatalogItemConverter cut = new ProductToCatalogItemConverter();

        List<GenericCatalogItem> convertedCatalogItems =
                new LinkedList<>(cut.ConvertProducts(ProductType2.class, productType2s));

        assertEquals(convertedCatalogItems.size(), 1);
        assertEquals(convertedCatalogItems.get(0).getCategory(), Category.Diagnostic.getIndex());
    }

    @Test
    void givenValidProductType3s_WhenConvertProductType3s_ThenReturnCorrectGenericCatalogItems() {
        Collection<ProductType3> productType3s = new LinkedList<>();
        productType3s.add(new ProductType3(defaultName, defaultDescription, defaultPrice));

        GenericCatalogItem expectedCatalogItem =
                new GenericCatalogItem(defaultName, defaultDescription, Category.Detail.getIndex(), defaultPrice);

        ProductToCatalogItemConverter cut = new ProductToCatalogItemConverter();

        GenericCatalogItem[] convertedCatalogItems =
                cut.ConvertProducts(ProductType3.class, productType3s).toArray(new GenericCatalogItem[productType3s.size()]);

        assertEquals(convertedCatalogItems[0], expectedCatalogItem);
    }
}