package com.gft.challange.directoryTree;

public class TreeNodePayload<T> {
    private T contents;

    public TreeNodePayload(T content) {
        this.contents = content;
    }

    T getContents() {
        return contents;
    }

    void setContents(T contents) {
        this.contents = contents;
    }
}
