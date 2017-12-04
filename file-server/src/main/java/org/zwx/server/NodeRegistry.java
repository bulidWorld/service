package org.zwx.server;

import org.zwx.util.JSONUtils;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class NodeRegistry {

    private static final NodeRegistry INSTANCE = new NodeRegistry();


    public static NodeRegistry getInstance() {
        return INSTANCE;
    }

    private NodeRegistry() {

    }

    public Node resolveNode(Path path) {
        return JSONUtils.readJSONFile(path.toFile());
    }

}
