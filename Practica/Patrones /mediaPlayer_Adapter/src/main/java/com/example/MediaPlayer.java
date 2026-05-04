package com.example;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayer {
    private List<Media> mediaList;

    public MediaPlayer() {
        mediaList = new ArrayList<>();
    }

    public void addMedia(Media media) {
        this.mediaList.add(media);
    }

    public void play() {
        this.mediaList.stream()
            .forEach(media -> media.play());
        
    }
}
