package dev.habna.habnacast.Models;

/**
 * Created by jhabshoosh on 7/8/14.
 */

/**
 * Base interface for all objects to be inserted into the database.
 *
 */
public interface BaseMusicInterface extends BaseInterface {

    public void setArtist(String artist);
    public String getArtist();

    public void setYear(int year);
    public int getYear();
}
