package org.zwx.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class JSONUtils {

    private static final Logger LOG = LoggerFactory.getLogger(JSONUtils.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> T readJSONFile(File file) {
        try {
            return OBJECT_MAPPER.readValue(file, new TypeReference<T>(){} );
        } catch (IOException e) {
            throw new RuntimeException("can't resolve file:" + file.getAbsolutePath());
        }
    }
}
