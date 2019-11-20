package com.catalog.fetch;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class CurlReaderBuilder{
    public Reader buildReader(String curlCommand) throws IOException {
        return new InputStreamReader(Runtime.getRuntime().exec(curlCommand).getInputStream());
    }
}
