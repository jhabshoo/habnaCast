package dev.habna.habnacast;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import dev.habna.habnacast.Models.Album;
import dev.habna.habnacast.Utilities.Util;

public class AlbumActivity extends ListActivity {

    private List<Album> albums = new ArrayList< Album>();
    private InputStream is = null;
    private final String TAG = "AlbumActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        try {
        setContentView(R.layout.activity_album);

//        try {
            loadMusic();
        }catch(XmlPullParserException xppe) {
            xppe.printStackTrace();
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
        catch(Exception e)  {
            Util.log(TAG, e.getMessage());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.music, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return (id == R.id.action_settings ? true : super.onOptionsItemSelected(item));
    }

    private void loadMusic()  throws XmlPullParserException, IOException  {
        Album album = new Album();
        try {
            Util.log(TAG, "Loading Music");
            is = getResources().openRawResource(R.raw.let_it_bleed);
            album.parse(is);
            Util.log(TAG, "Finished parsing album file.");
            albums.add(album);
            List<String> albumNames = new ArrayList<String>();
            for (Album a :  albums)    {
                albumNames.add(a.getName());
            }
            ListView listView = getListView();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_row, albumNames);
            listView.setAdapter(adapter);
        }catch (XmlPullParserException xppe)    {
            throw xppe;
        }catch (IOException ioe)    {
            throw ioe;
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

    }
}
