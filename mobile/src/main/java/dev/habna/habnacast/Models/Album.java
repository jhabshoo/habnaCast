package dev.habna.habnacast.Models;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jhabshoosh on 7/8/14.
 */
public class Album  extends BaseMusicModel implements Comparator {

    private List<Song> songs = new ArrayList<Song>();
    private final String TAG = "Album";

    public Album()  {
        super();
    }

    public Album(List<Song> songs) {
        this.songs = songs;
    }

    public Album(String artist, int year, List<Song> songs) {
        super(artist, year);
        this.songs = songs;
    }

    public Album(String name, String artist, int year, List<Song> songs) {
        super(name, artist, year);
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song)  {
        songs.add(song);
    }

    public void addSongs(Collection<Song> songs)    {
        songs.addAll(songs);
    }

    @Override
    public String toString() {
        return "Album{" +
                "songs=" + songs +
                ", TAG='" + TAG + '\'' +
                '}';
    }

    public void parse(InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(inputStream, null);
            parser.nextTag();
            readAlbum(parser);
        }finally {
            inputStream.close();
        }
    }

    public void readAlbum(XmlPullParser parser) throws XmlPullParserException, IOException  {
        parser.require(XmlPullParser.START_TAG, null, "album");
        while (parser.next() != XmlPullParser.END_TAG)   {
            if (parser.getEventType() != XmlPullParser.START_TAG)   {
                continue;
            }
            String tagName = parser.getName();
            if (tagName.equals("name"))    {
                setName(read(parser, "name"));
            }else if (tagName.equals("artist")) {
                setArtist(read(parser, "artist"));
            }else if (tagName.equals("year"))   {
                setYear(Integer.parseInt(read(parser, "year")));
            }else if (tagName.equals("song"))   {
                Song song = readSong(parser);
                song.setYear(getYear());
                song.setAlbum(getName());
                addSong(song);
            }
        }
    }

    private Song readSong(XmlPullParser parser) throws IOException, XmlPullParserException {
        Song song = new Song();
        parser.require(XmlPullParser.START_TAG, null, "song");
        while (parser.next() != XmlPullParser.END_TAG)  {
            if (parser.getEventType() != XmlPullParser.START_TAG)   {
                continue;
            }
            String tagName = parser.getName();
            if (tagName.equals("name")) {
                song.setName(read(parser, "name"));
            }
        }
        return song;
    }

    private String read(XmlPullParser parser, String tag) throws XmlPullParserException, IOException    {
        parser.require(XmlPullParser.START_TAG, null, tag);
        String text = readText(parser);
        parser.require(XmlPullParser.END_TAG, null, tag);
        return text;
    }

    private String readText(XmlPullParser parser) throws XmlPullParserException, IOException    {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT)    {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    @Override
    public int compare(Object lhs, Object rhs) {
        Album a = (Album) lhs;
        Album b = (Album) rhs;
        return a.getName().compareTo(b.getName());
    }
}
