package com.catalog;

import com.catalog.models.GenericCatalogItem;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        DisplayGenericCatalogItems();
    }

    private static void DisplayGenericCatalogItems() {
        GenericCatalogItemProvider genericCatalogItemFetcher = new GenericCatalogItemProvider();
        Collection<GenericCatalogItem> genericCatalogItems = genericCatalogItemFetcher.GetCatalogItems();
        System.out.println(genericCatalogItems.toString());
    }
}
