package com.forestsoftware.kands.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by HP-PC on 2/6/2018.
 */

public class SomeFavouriteDBOperation extends DatabaseHelperFavourite {
    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     *
     * @param context
     */
    public SomeFavouriteDBOperation(Context context) {
        super(context);
    }

    SQLiteDatabase sd = this.getReadableDatabase();


    public DictObjectModel getFavouriteById(int phrase){

        DictObjectModel dictObjectModel  = null;


        String query = "select * from songs where id = " + phrase;

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

}
