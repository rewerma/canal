package com.alibaba.otter.canal.connector.core.config;

public class MQProperties {

    private boolean flatMessage            = true;
    private boolean databaseHash           = true;
    private boolean filterTransactionEntry = true;
    private Integer parallelThreadSize     = 8;
    private Integer fetchTimeout           = 100;
    private Integer batchSize              = 50;
    private String  accessChannel          = "local";

    public boolean isFlatMessage() {
        return flatMessage;
    }

    public void setFlatMessage(boolean flatMessage) {
        this.flatMessage = flatMessage;
    }

    public boolean isDatabaseHash() {
        return databaseHash;
    }

    public void setDatabaseHash(boolean databaseHash) {
        this.databaseHash = databaseHash;
    }

    public boolean isFilterTransactionEntry() {
        return filterTransactionEntry;
    }

    public void setFilterTransactionEntry(boolean filterTransactionEntry) {
        this.filterTransactionEntry = filterTransactionEntry;
    }

    public Integer getParallelThreadSize() {
        return parallelThreadSize;
    }

    public void setParallelThreadSize(Integer parallelThreadSize) {
        this.parallelThreadSize = parallelThreadSize;
    }

    public Integer getFetchTimeout() {
        return fetchTimeout;
    }

    public void setFetchTimeout(Integer fetchTimeout) {
        this.fetchTimeout = fetchTimeout;
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }

    public String getAccessChannel() {
        return accessChannel;
    }

    public void setAccessChannel(String accessChannel) {
        this.accessChannel = accessChannel;
    }
}
