package com.gft.challange.directoryTree.newVersion;

/**
 * Created by bzmg on 2016-09-26.
 */
public interface INewNode<T> extends Iterable<INewNode<T>> {

    T getContent();
}
