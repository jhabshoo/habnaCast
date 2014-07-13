package dev.habna.habnacast.Models;

/**
 * Created by jhabshoosh on 7/8/14.
 */
public class Song extends BaseMusicModel {

    private String album;

    public Song() {
        super();
    }

    public Song(String artist, int year) {
        super(artist, year);
    }

    public Song(String name, String artist, int year) {
        super(name, artist, year);
    }

    public Song(String name, String artist, int year, String album) {
        super(name, artist, year);
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}