package com.gft.challange.filesystem.navigator;

import java.nio.file.Path;
import java.util.Iterator;

public interface FileSystemEntryHandler {

    boolean isDirectory(Path path);

    boolean hasChildEntries(Path direcotryPath);

    Iterator<Path> getChildEntries(Path directoryPath);

}
