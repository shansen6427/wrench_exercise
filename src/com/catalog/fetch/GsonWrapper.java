package com.catalog.fetch;

import com.google.gson.Gson;

import java.io.Reader;
import java.lang.reflect.Type;

public class GsonWrapper {
    private Gson gson;

    public GsonWrapper(){
        gson = new Gson();
    }

    public GsonWrapper(Gson gson) {
        this.gson = gson;
    }

    public <T> T fromJson (Reader reader, Type type){
        return gson.fromJson(reader, type);
    }
}
