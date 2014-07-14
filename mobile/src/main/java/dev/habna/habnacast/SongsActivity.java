package dev.habna.habnacast;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import dev.habna.habnacast.Models.Album;
import dev.habna.habnacast.Models.Song;

public class SongsActivity extends ListActivity {

    private Album album = null;
    private final String TAG = "SongsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        album = (Album)getIntent().getSerializableExtra("album");
        loadSongs();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.songs, menu);
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

    private void loadSongs()    {
        ListView listView = getListView();
        List<String> songNames = new ArrayList<String>();
        for (Song song : album.getSongs())  {
            songNames.add(song.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_row, songNames);
        listView.setAdapter(adapter);
    }
}
