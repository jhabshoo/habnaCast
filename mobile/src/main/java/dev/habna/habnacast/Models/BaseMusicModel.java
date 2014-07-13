package dev.habna.habnacast.Models;

import dev.habna.habnacast.Utilities.Util;

/**
 * Created by jhabshoosh on 7/8/14.
 */
public abstract class BaseMusicModel extends BaseModel implements BaseMusicInterface    {

    String artist;
    int year;

    BaseMusicModel()    {
        super();
        this.artist = "";
        this.year = Util.UNKNOWN_YEAR;
    }

    protected BaseMusicModel(String artist, int year) {
        super();
        this.artist = artist;
        this.year = year;
    }

    protected BaseMusicModel(String name, String artist, int year) {
        super(name);
        this.artist = artist;
        this.year = year;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
