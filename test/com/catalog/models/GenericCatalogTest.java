package com.catalog.models;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GenericCatalogTest {

    @Test
    void whenAddAll_ThenAllGenericCatalogItemsAreAddedToCatalog() {
        List<GenericCatalogItem> catalogItemsToAdd = new LinkedList<>();
        catalogItemsToAdd.add(new GenericCatalogItem("name1", "description1", Category.Mechanical.getIndex(), 1.0));
        catalogItemsToAdd.add(new GenericCatalogItem("name2", "description2", Category.Diagnostic.getIndex(), 2.0));

        GenericCatalog cut = new GenericCatalog();

        cut.addAll(catalogItemsToAdd);

        List<GenericCatalogItem> itemsInCatalog = new LinkedList<>(cut.getCatalogItems());

        for(GenericCatalogItem catalogItem : catalogItemsToAdd){
            assertTrue(itemsInCatalog.contains(catalogItem));
        }
    }

    @Test
    void givenItemWithPriceAbove150_whenAddAll_ThenItemHasPriceReducedTo150() {
        List<GenericCatalogItem> catalogItemsToAdd = new LinkedList<>();
        catalogItemsToAdd.add(new GenericCatalogItem("name1", "description1", Category.Diagnostic.getIndex(), 200.0));

        GenericCatalog cut = new GenericCatalog();

        cut.addAll(catalogItemsToAdd);

        List<GenericCatalogItem> itemsInCatalog = new LinkedList<>(cut.getCatalogItems());

        assertEquals(itemsInCatalog.get(0).getPrice(), 150);
    }

    @Test
    void givenItemsWithSameName_whenAddAll_ThenItemWithLowerPriceIsAdded() {
        List<GenericCatalogItem> catalogItemsToAdd = new LinkedList<>();
        catalogItemsToAdd.add(new GenericCatalogItem("same name", "description1", Category.Mechanical.getIndex(), 3.0));
        catalogItemsToAdd.add(new GenericCatalogItem("same name", "description2", Category.Diagnostic.getIndex(), 2.0));

        GenericCatalog cut = new GenericCatalog();

        cut.addAll(catalogItemsToAdd);

        List<GenericCatalogItem> itemsInCatalog = new LinkedList<>(cut.getCatalogItems());
        assertEquals(itemsInCatalog.size(), 1);
        assertEquals(itemsInCatalog.get(0).getCategory(), Category.Diagnostic.getIndex());

        List<GenericCatalogItem> anotherCatalogItemToAdd = new LinkedList<>();
        anotherCatalogItemToAdd.add(new GenericCatalogItem("same name", "description1", Category.Detail.getIndex(), 1.0));

        cut.addAll(anotherCatalogItemToAdd);

        itemsInCatalog = new LinkedList<>(cut.getCatalogItems());
        assertEquals(itemsInCatalog.size(), 1);
        assertEquals(itemsInCatalog.get(0).getCategory(), Category.Detail.getIndex());
    }
}