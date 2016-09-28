package com.gft.challange.websocket;

import com.gft.challange.directoryTree.newVersion.FileNode;
import com.gft.challange.directoryTree.newVersion.INewNode;
import com.gft.challange.directoryTree.newVersion.NewTree;
import com.gft.challange.model.FolderEntry;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class DirectoryContentsLister {

    Logger LOG = Logger.getLogger(DirectoryContentsLister.class);

    @Value("${directory}")
    private String directory;


    private SimpMessagingTemplate messagingTemplate;

    public void listContents() throws IOException {
        NewTree<Path> directoryTree = new NewTree(new FileNode(Paths.get(directory)));
        Iterator<INewNode<Path>> directoryIterator = directoryTree.iterator();
        Stream.generate(() -> directoryIterator.hasNext() ? directoryIterator.next() : null).filter(Objects::nonNull)
                .limit(100).forEach(treeNode -> messagingTemplate.convertAndSend(ResourceUri.BROKER_TOPIC_FOLDER_ENTRIES.getUri(),
                new FolderEntry()));
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    @Autowired
    public void setMessagingTemplate(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
}
