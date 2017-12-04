package org.zwx.audit.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class JSONUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static<T> T resolve(File file) throws IOException {
        return OBJECT_MAPPER.readValue(file, new TypeReference<T>(){});
    }
}
