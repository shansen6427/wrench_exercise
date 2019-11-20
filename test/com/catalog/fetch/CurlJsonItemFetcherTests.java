package com.catalog.fetch;

import com.catalog.ProductTypeConstants;
import com.catalog.fakes.CurlReaderBuilderFake;
import com.catalog.fakes.GsonWrapperFake;
import com.catalog.models.ProductType1;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CurlJsonItemFetcherTests {
    @Test
    void whenFetchItems_ThenFromJsonIsCalled(){
        Object fromJsonObject = "hello";

        CurlReaderBuilderFake curlReaderBuilderFake = new CurlReaderBuilderFake(null);

        GsonWrapperFake gsonWrapperFake = new GsonWrapperFake();
        gsonWrapperFake.setJson(fromJsonObject);

        CurlJsonItemFetcher cut = new CurlJsonItemFetcher();

        Object fetchedItem =
                cut.FetchItems("curl", Object.class, gsonWrapperFake, curlReaderBuilderFake);

        assertEquals(fetchedItem, fromJsonObject);
    }
}
