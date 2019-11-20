package com.catalog.models;

import java.util.Collection;
import java.util.HashMap;

public class GenericCatalog{
    private HashMap<String, GenericCatalogItem> catalogItems;

    public GenericCatalog() {
        catalogItems = new HashMap<>();
    }

    public void addAll(Collection<GenericCatalogItem> genericCatalogItems){
        for(GenericCatalogItem newCatalogItem : genericCatalogItems){
            if (newCatalogItem.getPrice() > 150){
                newCatalogItem.setPrice(150);
            }

            GenericCatalogItem itemWithSameName = catalogItems.putIfAbsent(newCatalogItem.getName(), newCatalogItem);
            if (itemWithSameName != null){
                if (itemWithSameName.getPrice() >= newCatalogItem.getPrice()){
                    catalogItems.replace(newCatalogItem.getName(), newCatalogItem);
                }
            }
        }
    }

    public Collection<GenericCatalogItem> getCatalogItems(){
        return catalogItems.values();
    }
}
