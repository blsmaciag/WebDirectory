package com.gft.challange.filesystem.navigator;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

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
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) { //sprawdzamy czy jest katalogiem
            iterator = stream.iterator();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iterator;
    }
}