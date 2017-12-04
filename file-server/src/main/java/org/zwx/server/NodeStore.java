package org.zwx.server;

import org.zwx.common.Constants;
import org.zwx.service.SystemConfigService;

import java.nio.file.Paths;
import java.util.*;

public class NodeStore {

    private SystemConfigService systemConfigService;

    private static final NodeStore INSTANCE = new NodeStore();

    private Collection<Node> nodes = Collections.synchronizedCollection(new HashSet<Node>());

    private NodeStore() {
        init();
    }

    private void init() {
        registerFromLocalFile();
        registerFromDB();
    }

    private void registerFromDB() {

    }

    private void registerFromLocalFile() {
        NodeRegistry nodeRegistry = NodeRegistry.getInstance();
        String confPath = systemConfigService.getConfig(Constants.NODE_CONF_PATH);
        Node node = nodeRegistry.resolveNode(Paths.get(confPath));
        nodes.add(node);
    }


}
