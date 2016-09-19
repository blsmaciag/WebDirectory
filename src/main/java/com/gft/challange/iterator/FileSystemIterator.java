package com.gft.challange.iterator;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public final class FileSystemIterator implements Iterator<Path> {

    private Path rootDirectory;
    private Path currentNodePath;
    private Path lastProcessedNode;
    private Stack<Iterator<Path>> nodesStack = new Stack();

    public FileSystemIterator(Path rootDirectory) {
        if(!Files.isDirectory(rootDirectory)) {
            throw new RuntimeException("Iterator constructor accepts only directory as a parameter");
        }
        this.rootDirectory = rootDirectory;
        this.currentNodePath = rootDirectory;
    }

    @Override
    public boolean hasNext() {
        if (currentNodePath.equals(null)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Path next() {
        if(rootDirectory.equals(lastProcessedNode)) {
            throw new NoSuchElementException(); //no elements to process
        }
        currentNodePath = getNextAvailableTreeEntry();
        if (Files.isDirectory(currentNodePath)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentNodePath)) { //sprawdzamy czy jest katalogiem
                Path entry = tryToGetChild(currentNodePath);
                if (entry == null) {
                    nodesStack.pop();
                    markAsProcessed(currentNodePath);
                    return currentNodePath;
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            markAsProcessed(currentNodePath);
            return currentNodePath;
        }

        return null;
    }

    private Path getNextAvailableTreeEntry() {
        while(!nodesStack.empty()) {
            Iterator<Path> iterator = nodesStack.peek();
            if(iterator.hasNext())
                return iterator.next();
        }
        return null;
    }

    private void markAsProcessed(Path processedPath) {
        lastProcessedNode = processedPath;
    }

    private Path tryToGetChild(Path directoryPath) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) { //sprawdzamy czy jest katalogiem
            Iterator<Path> directoryIterator = stream.iterator();
            if(directoryIterator.hasNext()) {
                nodesStack.push(directoryIterator);
                return directoryIterator.next();
            } else {
                return null;
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null; //TODO: rethink this ;) cause exception will be ignored in such case
    }
}
