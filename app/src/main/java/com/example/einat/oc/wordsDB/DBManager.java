package com.example.einat.oc.wordsDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

/**
 * Created by Einat on 20/03/2016.
 */
public class DBManager extends SQLiteOpenHelper {

    private final Context context;
    private static String DB_DIR = "/data/data/com.example.einat.oc.wordsDB/assets/databases";
    private static String DB_NAME = "words.sql";
    private static String DB_PATH = DB_DIR + DB_NAME;
    private static int DB_VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;


    public final String WORDS_TABLE = "words";
    public final String CHARACTER = "character";
    public final String PINYIN = "pinyin";
    public final String MEANING = "meaning";


    public DBManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    //create an empty db on the sys
    public void createDB() throws IOException{

        boolean dbExists = checkDB();

        if (dbExists){
            Log.i("DB exists", "db exits");
        }

        dbExists = checkDB();

        if (!dbExists){
            this.getReadableDatabase();
            this.close();
            copyDB();
        }
    }
//copy db from local assets folder
    private void copyDB()throws IOException{
        OutputStream outputStream = new FileOutputStream(DB_PATH);
        InputStream inputStream = context.getAssets().open(DB_NAME);
        byte[] buffer = new byte [1024];
        int length;
        while((length = inputStream.read(buffer)) > 0){
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
//check if db already exists
    private boolean checkDB() {
        boolean isDB = false;
        try{
            File dbFile = new File (DB_PATH);
            isDB = dbFile.exists();
        }catch (SQLiteException e){

        }
        return isDB;
    }

    //open DB
    public void openDB() throws SQLException{
        sqLiteDatabase = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

//        db.execSQL("CREATE TABLE " + WORDS_TABLE + "( " + CHARACTER + " TEXT, " +
//        PINYIN + " TEXT, " + MEANING + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
