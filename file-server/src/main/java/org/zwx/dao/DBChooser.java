package org.zwx.dao;

import org.zwx.common.Constants;
import org.zwx.common.DBType;
import org.zwx.service.SystemConfigService;
import org.zwx.util.JSONUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class DBChooser {

    private static final DBChooser INSTANCE = new DBChooser();

    //TODO
    SystemConfigService systemConfigService;

    private Set<DBEntity> dbEntitySet;

    private DBChooser() {
        init();
    }

    public static DBChooser getInstance() {
        return INSTANCE;
    }

    private void init() {
        parseDBFromJSON();
    }

    private void parseDBFromJSON() {
        Path path = Paths.get(systemConfigService.getConfig(Constants.DB_CONF_PATH));
        dbEntitySet = JSONUtils.readJSONFile(path.toFile());
    }

    public DBEntity chooseDB(DBType type) {
        return dbEntitySet.stream()
                .filter(item -> item.getType().equals(type.value))
                .findFirst().orElseThrow(() ->  new RuntimeException("lack type:" + type.value));
    }

}
