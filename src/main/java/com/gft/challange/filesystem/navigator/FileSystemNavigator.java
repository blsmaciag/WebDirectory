package com.gft.challange.filesystem.navigator;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.Stream;

@Component
public class FileSystemNavigator implements FileSystemEntryHandler {


    @Override
    public boolean isDirectory(Path path) {
        return Files.isDirectory(path);
    }

    @Override
    public boolean hasChildEntries(Path direcotryPath) {
        Iterator<Path> childEntries = getChildEntries(direcotryPath);
        return childEntries != null && childEntries.hasNext();
    }

    @Override
    public Iterator<Path> getChildEntries(Path directoryPath) {
        Iterator<Path> iterator = null;
        Stream<Path> directoryEntryStream = null;
        try {
            directoryEntryStream = Files.list(directoryPath);
            iterator = directoryEntryStream.iterator();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iterator;
    }
}