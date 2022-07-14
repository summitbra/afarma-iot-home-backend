package com.summitbra.afarma.iot.home.backend.responses;

public class ResponseMedia {

    private String media;

    private String phrase;

    public ResponseMedia(String media) {
        this.media = media;
        this.phrase = "Ádesão Média";
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
