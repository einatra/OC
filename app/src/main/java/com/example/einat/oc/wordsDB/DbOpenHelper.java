package com.example.einat.oc.wordsDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Einat on 05/04/2016.
 */
public class DbOpenHelper extends SQLiteOpenHelper {

    public final String WORDS_TABLE = "words";
    public final String CHARACTER = "character";
    public final String PINYIN = "pinyin";
    public final String MEANING = "meaning";

    private static final String DB_NAME = "words.sql";
    private static final int DB_VERSION = 1;

    public DbOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + WORDS_TABLE + "( " + CHARACTER + " TEXT, " +
                PINYIN + " TEXT, " + MEANING + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
