package com.forestsoftware.kands.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by HP-PC on 1/10/2018.
 */

public class SomeDbOperation extends DatabaseHelper
{
    public SomeDbOperation(Context context)
    {

        super(context);

    }
    SQLiteDatabase sd = this.getReadableDatabase();
    public DictObjectModel getQuizById(int phrase){

        DictObjectModel dictObjectModel  = null;


        String query = "select * from dictionary where _id = " + phrase;

      //  String query = "select * from dictionary where title = " +  phrase + "";

        Cursor cursor = sd.rawQuery(query, null);

//    //    Cursor cursorx = sd.rawQuery("select * from dictionary  where 'title=?'", new String[]{phrase});

        if(cursor.moveToFirst()){

            do{
                String number = cursor.getString(cursor.getColumnIndexOrThrow("number"));
                String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String song = cursor.getString(cursor.getColumnIndexOrThrow("contents"));

                dictObjectModel = new DictObjectModel( number, title, song);

            }while(cursor.moveToNext());

        }

        cursor.close();
        return dictObjectModel;

    }

    public DictObjectModel getFavouriteById(int phrase){

        DictObjectModel dictObjectModel  = null;


        String query = "select * from songs where _id = " + phrase;

        //  String query = "select * from dictionary where title = " +  phrase + "";

        Cursor cursor = sd.rawQuery(query, null);

//    //    Cursor cursorx = sd.rawQuery("select * from dictionary  where 'title=?'", new String[]{phrase});

        if(cursor.moveToFirst()){

            do{
                String number = cursor.getString(cursor.getColumnIndexOrThrow("songid"));
                String title = cursor.getString(cursor.getColumnIndexOrThrow("song"));
                String song = cursor.getString(cursor.getColumnIndexOrThrow("meaning"));

                dictObjectModel = new DictObjectModel( number, title, song);

            }while(cursor.moveToNext());

        }

        cursor.close();
        return dictObjectModel;

    }

    public String[] dictionaryWords()
    {

        String query = "Select * from dictionary";
        Cursor cursor = sd.rawQuery(query, null);
        ArrayList<String> wordTerms = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                wordTerms.add(word);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] dictionaryWords = new String[wordTerms.size()];
        dictionaryWords = wordTerms.toArray(dictionaryWords);
        return dictionaryWords;
    }

}
