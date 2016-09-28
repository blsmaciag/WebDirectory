package com.gft.challange.websocket;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class FolderEntryController {

    @Autowired
    private DirectoryContentsLister lister;

    Logger log = Logger.getLogger(FolderEntryController.class);

    @MessageMapping("/messenger")
    public void informAboutNewEntry() throws IOException {
        lister.listContents();
    }
}
