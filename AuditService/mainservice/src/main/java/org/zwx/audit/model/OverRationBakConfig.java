package org.zwx.audit.model;

public class OverRationBakConfig {

    private String bakFilePath;

    /**
     * M 为单位
     */
    private Double maxFileSize;

    private Double ration;

    private String tblName;

    public String getBakFilePath() {
        return bakFilePath;
    }

    public void setBakFilePath(String bakFilePath) {
        this.bakFilePath = bakFilePath;
    }

    public Double getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(Double maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public Double getRation() {
        return ration;
    }

    public void setRation(Double ration) {
        this.ration = ration;
    }

    public String getTblName() {
        return tblName;
    }

    public void setTblName(String tblName) {
        this.tblName = tblName;
    }
}
