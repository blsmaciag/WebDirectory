package com.gft.challange.websocket;

import com.gft.challange.model.FolderEntry;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class DirectoryContentsLister {

    Logger LOG = Logger.getLogger(DirectoryContentsLister.class);

    @Value("${directory}")
    private String directory;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void list() throws IOException {
        Path path = FileSystems.getDefault().getPath(directory);
        Files.walk(path).map(p -> new FolderEntry(p.toString(), null)).forEach(o -> {
            System.out.println(o.getPath());
            messagingTemplate.convertAndSend(ResourceUri.BROKER_TOPIC_FOLDER_ENTRIES.getUri(), o);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void listCmd() throws IOException {
        StringBuffer output = new StringBuffer();
        Process p = Runtime.getRuntime().exec("dir /s "+ directory);
        BufferedReader reader =  new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        while ((line = reader.readLine())!= null) {
            messagingTemplate.convertAndSend(ResourceUri.BROKER_TOPIC_FOLDER_ENTRIES.getUri(), new FolderEntry(line, null));
        }
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setMessagingTemplate(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
}
