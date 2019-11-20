package com.catalog.fakes;

import com.catalog.fetch.CurlReaderBuilder;

import java.io.IOException;
import java.io.Reader;

public class CurlReaderBuilderFake extends CurlReaderBuilder{
    private Reader reader;

    public CurlReaderBuilderFake(Reader reader) {
        this.reader = reader;
    }

    @Override
    public Reader buildReader(String curlCommand) throws IOException {
        return reader;
    }
}
