package org.zwx.audit.applicaion;

import org.zwx.audit.model.BakConfig;

import java.util.List;

public class Configuration {
    public List<BakConfig> bakConfigList;

    public List<BakConfig> getBakConfigList() {
        return bakConfigList;
    }

    public void buildBakConfigs(BakConfigParse parser) {
        bakConfigList = parser.parse();
    }

    public void refreashBakConfig() {

    }

    public void addBakConfig(BakConfig bakConfig) {
        bakConfigList.add(bakConfig);
    }

}
