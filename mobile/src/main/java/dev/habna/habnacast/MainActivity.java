package dev.habna.habnacast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.parse.Parse;

import dev.habna.habnacast.Utilities.Util;

public class MainActivity extends Activity {

    private final String PARSE_APP = "jF6TxfZDxYcTdA3RVnjTP99V3m1DytWzC6w5he8R";
    private final String PARSE_CLIENT = "evcuP2dFQj02f1lQHlDWg6XoTo3BXcM0YqGYqGsT";

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(this, PARSE_APP, PARSE_CLIENT);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void launchMusicActivity(View view)  {
        Util.log(TAG, "Launching AlbumActivity");
        Intent intent = new Intent(this, AlbumActivity.class);
        startActivity(intent);

    }

}
