package com.example.einat.oc.wordsDB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Einat on 05/04/2016.
 */
public class DbAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DbAccess instance;

    private DbAccess(Context context) {
        this.openHelper = new DbOpenHelper(context);
    }

    public static DbAccess getInstance(Context context){
        if (instance == null){
            instance = new DbAccess(context);
        }
        return instance;
    }

    public void open(){
        this.database = openHelper.getWritableDatabase();
    }

    public void close(){
        if(database != null)
        this.database.close();
    }

    public ArrayList getWords(){
        ArrayList<Word> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM words", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Word word = new Word();
            word.setCharacter(cursor.getString(0));
            word.setPinyin(cursor.getString(1));
            word.setMeaning(cursor.getString(2));
            list.add(word);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
