package com.gft.challange.directoryTree;

public class TreeNodeContent<T> {
    private T content;

    public TreeNodeContent(T content) {
        this.content = content;
    }

    T getContent() {
        return content;
    }
    void setContent(T content) {
        this.content = content;
    }
}
