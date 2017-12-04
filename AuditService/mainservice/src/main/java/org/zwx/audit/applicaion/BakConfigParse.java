package org.zwx.audit.applicaion;

import com.fasterxml.jackson.core.type.TypeReference;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.zwx.audit.model.BakConfig;
import org.zwx.audit.utils.JSONUtil;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class BakConfigParse {

    private static final Logger LOG = LoggerFactory.getLogger(BakConfigParse.class);

    private SystemConifg systemConifg;

    private String BAK_CONF_PATH = "BAK_CONF_PATH";

    public List<BakConfig> parse() {
        String bakConfigPath = systemConifg.getValue(BAK_CONF_PATH);

        List<BakConfig> configList = Collections.EMPTY_LIST;
        try {
            ClassPathResource resource = new ClassPathResource( bakConfigPath);
            configList = JSONUtil.resolve(resource.getFile());
        } catch (IOException e) {
            LOG.error("parse conf file filed, path:{}", BAK_CONF_PATH);
        }
        return configList;
    }
}
