package com.gft.challange.directoryTree.newVersion;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

public class FileNode implements INewNode<Path> {

    private Path path;

    public FileNode(Path path) {
        this.path = path;
    }

    @Override
    public Path getContent() {
        return path;
    }

    @Override
    public Iterator<INewNode<Path>> iterator() {
        ArrayList<INewNode<Path>> result = new ArrayList<>();

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            directoryStream.forEach(p -> result.add(new FileNode(p)));
        } catch (IOException ex) {
        }
        return result.iterator();
    }
}
