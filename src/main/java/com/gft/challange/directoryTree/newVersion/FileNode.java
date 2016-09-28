package com.gft.challange.directoryTree.newVersion;

import java.nio.file.Path;
import java.util.Iterator;

/**
 * Created by bzmg on 2016-09-28.
 */
public class FileNode implements INewNode<Path> {

    public FileNode(Path path) {
    }

    @Override
    public Path getContent() {
        return null;
    }

    @Override
    public Iterator<INewNode<Path>> iterator() {
        return null;
    }
}
