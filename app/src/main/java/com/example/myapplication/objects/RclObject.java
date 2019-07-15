package com.example.myapplication.objects;

public class RclObject {
    private String singerName;
    private String songName;
    private String songDate;
    private int songLike;
    private int songView;
    private int songComment;
    private int songImage;

    public RclObject() {
    }

    public RclObject(String singerName, String songName, String songDate, int songLike, int songView, int songComment, int songImage) {
        this.singerName = singerName;
        this.songName = songName;
        this.songDate = songDate;
        this.songLike = songLike;
        this.songView = songView;
        this.songComment = songComment;
        this.songImage = songImage;
    }


    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDate() {
        return songDate;
    }

    public void setSongDate(String songDate) {
        this.songDate = songDate;
    }

    public int getSongLike() {
        return songLike;
    }

    public void setSongLike(int songLike) {
        this.songLike = songLike;
    }

    public int getSongView() {
        return songView;
    }

    public void setSongView(int songView) {
        this.songView = songView;
    }

    public int getSongComment() {
        return songComment;
    }

    public void setSongComment(int songComment) {
        this.songComment = songComment;
    }

    public int getSongImage() {
        return songImage;
    }

    public void setSongImage(int songImage) {
        this.songImage = songImage;
    }
}
