package com.catalog.fetch;

import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

public class CurlJsonItemFetcher {
    public <T> T FetchItems(String curlCommand, Type conversionType, GsonWrapper gsonWrapper, CurlReaderBuilder curlReaderBuilder) {
        try (Reader reader = curlReaderBuilder.buildReader(curlCommand)){
            return gsonWrapper.fromJson(reader, conversionType);
        } catch (IOException e) {
            System.out.println(String.format("Exception when fetching from target: [%s]\nError message: [%s}",
                    curlCommand, e.getMessage()));
        } catch (JsonSyntaxException e){
            System.out.println(
                    String.format("Could not convert to desired type: [%s]\nError message: [%s]",
                            conversionType.toString(), e.getMessage()));
        }

        return null;
    }
}

