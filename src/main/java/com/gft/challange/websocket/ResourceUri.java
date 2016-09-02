package com.gft.challange.websocket;

public enum ResourceUri {

    APPLICATION_RESOURCE_PREFIX("/app"),

    ENDPOINT_MESSENGER("/messenger"),

    BROKER_TOPIC("/topic"),
    BROKER_TOPIC_FOLDER_ENTRIES(BROKER_TOPIC.getUri()+"/folder/entries");

    private String uri;

    ResourceUri(String s) {
        uri = s;
    }

    public String getUri() {
        return uri;
    }
}
