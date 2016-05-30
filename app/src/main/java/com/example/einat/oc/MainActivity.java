package com.example.einat.oc;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.einat.oc.wordsDB.DbAccess;
import com.example.einat.oc.wordsDB.Word;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    /**
     * calls splash screen when opened by user
     * first time ever opened switches to settings
     * after word was revealed covers and asks:
     * "you have --countdown timer-- till next pop quiz" btn: "quiz now" btn: "review word"
     * automatically calls word of the day and then tests in intervals -- questions opened from notifications
     *
     */

    private ListView listView;
    DbAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView) findViewById(R.id.listView);
        databaseAccess = DbAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        List<Word> chars = databaseAccess.getWords();
        Log.d("words", chars.toString());
        databaseAccess.close();

        ArrayList<String> list = new ArrayList<>();
        list.add("word");
        list.add("added");
        list.add("^&%#^&");


        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chars);
        this.listView.setAdapter(adapter);

//        DailyWordFragment dailyWordFragment = new DailyWordFragment();
//        fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.fragment_cointainer, dailyWordFragment, "dailyWordFrag").commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
