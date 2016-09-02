package com.gft.challange.model;

import java.util.List;

public class FolderEntry {

    public FolderEntry() {
    }

    public FolderEntry(String path, List<String> subEntries) {
        this.path = path;
        this.subEntries = subEntries;
        this.filesCount = filesCount;
        this.bytesCount = bytesCount;
    }

    private String path;
    private List<String> subEntries;
    private int filesCount;
    private long bytesCount;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getSubEntries() {
        return subEntries;
    }

    public void setSubEntries(List<String> subEntries) {
        this.subEntries = subEntries;
    }

    public int getFilesCount() {
        return filesCount;
    }

    public void setFilesCount(int filesCount) {
        this.filesCount = filesCount;
    }

    public long getBytesCount() {
        return bytesCount;
    }

    public void setBytesCount(long bytesCount) {
        this.bytesCount = bytesCount;
    }
}
