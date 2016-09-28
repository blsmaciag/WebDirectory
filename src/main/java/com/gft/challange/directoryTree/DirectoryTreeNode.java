package com.gft.challange.directoryTree;

import com.gft.challange.filesystem.navigator.FileSystemNavigator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirectoryTreeNode implements TreeNode {

    private TreeNode parentNode;
    private List<TreeNode> childNodes = null;
    private TreeNodePayload<Path> payload;
    private FileSystemNavigator fileSystemNavigator = new FileSystemNavigator(); //todo remove it

    public DirectoryTreeNode(Path path) {
        payload = new TreeNodePayload(path);
    }

    @Override
    public TreeNode getParentNode() {
        return parentNode;
    }

    @Override
    public void addChildNode(TreeNode node) {
        node.setParentNode(this);
        if (childNodes == null) {
            childNodes = new ArrayList<>();
        }
        childNodes.add(node);
    }

    @Override
    public boolean hasChildNodes() {
        if (fileSystemNavigator.isDirectory(payload.getContents()) &&
                fileSystemNavigator.hasChildEntries(payload.getContents())) {
            return true;
        }
        return false;
    }

    @Override
    public List<TreeNode> getChildren() {
        if (childNodes == null) {
            return getDirectoryEntries(payload.getContents());
        } else {
            return childNodes;
        }
    }

    @Override
    public TreeNodePayload<Path> getNodeContent() {
        return payload;
    }

    public void setPayload(TreeNodePayload payload) {
        this.payload = payload;
    }

    @Override
    public void setParentNode(TreeNode treeNode) {
        this.parentNode = treeNode;
    }

    /**
     * @return Iterator to iterate over list of siblings
     */
    @Override
    public Iterator<TreeNode> iterator() {
        return new TreeNodeIterator(this);
    }

    private List<TreeNode> getDirectoryEntries(Path path) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            Iterator<Path> iterator = directoryStream.iterator();
            while (iterator.hasNext()) {
                this.addChildNode(new DirectoryTreeNode(iterator.next()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return childNodes;
    }

    @Autowired
    public void setFileSystemNavigator(FileSystemNavigator fileSystemNavigator) {
        this.fileSystemNavigator = fileSystemNavigator;
    }
}
