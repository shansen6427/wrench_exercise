package com.catalog.fakes;

import com.catalog.fetch.GsonWrapper;
import com.google.gson.Gson;

import java.io.Reader;
import java.lang.reflect.Type;

public class GsonWrapperFake extends GsonWrapper {
    private Object fromJsonReturnValue;

    public GsonWrapperFake() { super(new Gson()); }

    @Override
    public Object fromJson(Reader json, Type typeOfT){
        return fromJsonReturnValue;
    }

    public void setJson(Object object){
        fromJsonReturnValue = object;
    }
}
