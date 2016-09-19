package com.gft.challange.iterator;

import java.nio.file.Path;

public class FileSystemEntry {
    private Path entryPath;
    private Path parentEntryPath;

    public FileSystemEntry(Path entryPath, Path parentEntryPath) {

        this.entryPath = entryPath;
        this.parentEntryPath = parentEntryPath;
    }

    public Path getEntryPath() {
        return entryPath;
    }

    public Path getParentEntryPath() {
        return parentEntryPath;
    }
}
