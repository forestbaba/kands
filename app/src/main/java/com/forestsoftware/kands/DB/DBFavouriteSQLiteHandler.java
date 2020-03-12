package com.forestsoftware.kands.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBFavouriteSQLiteHandler extends SQLiteOpenHelper {

	public static final int DATABASE_VERSION = 3;
	public static final String DATABASE_NAME = "songfavourite";
	private static final String TABLE_WORD = "songs";
	private static final String KEY_ID = "id";
	private static final String KEY_WORD = "song";
	private static final String KEY_POS = "meaning";
	private static final String KEY_SONG_ID = "songid";
	Context context;

	public DBFavouriteSQLiteHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	//create table
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE = "CREATE TABLE " + TABLE_WORD + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_WORD + " TEXT,"
                + KEY_POS + " TEXT,"   + KEY_SONG_ID + " INTEGER" + ")";
		db.execSQL(CREATE_TABLE);
	}

	//update table
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_WORD);
		onCreate(db);
	}
	
	//add favouriteDataModel
	public void addWord(FavouriteDataModel favouriteDataModel){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(KEY_WORD, favouriteDataModel.getWord());
		contentValues.put(KEY_POS, favouriteDataModel.getPartOfSpeech());
		
		db.insert(TABLE_WORD,null,contentValues);
		db.close();		
	}
	public void addW(String x1, String x2, int x3)
	{
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues contentValues = new ContentValues();
		contentValues.put(KEY_WORD, x1);
		contentValues.put(KEY_POS, x2);
		contentValues.put(KEY_SONG_ID, x3);

		db.insert(TABLE_WORD,null,contentValues);
		db.close();
	}
	
	//remove favouriteDataModel
	public void removeWord(FavouriteDataModel favouriteDataModel){
		SQLiteDatabase db = this.getWritableDatabase();
		
		db.delete(TABLE_WORD, KEY_WORD + " = ?", new String[]{String.valueOf(favouriteDataModel.getWord())});
		db.close();
	}

	public void removeW(String x){
		SQLiteDatabase db = this.getWritableDatabase();

		db.delete(TABLE_WORD, KEY_WORD + " = ?", new String[]{x});
		db.close();
	}
	
	//getWord
	public FavouriteDataModel getWord(FavouriteDataModel favouriteDataModel){
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.query(TABLE_WORD, new String[]
						{KEY_ID,KEY_WORD,KEY_POS},KEY_ID + " = ?",
				new String[]{String.valueOf(favouriteDataModel.getId())},
				null,null,null,null);
		if(cursor!=null) 
			cursor.moveToFirst();
		
		FavouriteDataModel favouriteDataModelFound = new FavouriteDataModel(cursor.getString(1), cursor.getString(2),cursor.getInt(3));
		
		return favouriteDataModelFound;
	}
	public boolean Exist(String searchTerm)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		String [] selectionArgs = {searchTerm};
		String limit = "1";

		Cursor cursor = db.query(TABLE_WORD, new String[]
						{ KEY_ID, KEY_WORD, KEY_POS},KEY_WORD + " = ?",selectionArgs,
				null,null,null,limit);

		boolean exist = (cursor.getCount()>0);
		cursor.close();
	//	Log.wtf("going- down ->->->::  ",""+exist);
		return exist;

	}
	
	//getAllWords
	public ArrayList<FavouriteDataModel> getWords(){
		List<FavouriteDataModel> wordsList = new ArrayList<FavouriteDataModel>();
		String query = "SELECT * FROM " + TABLE_WORD;
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		
		if(cursor.moveToFirst()){
			do{
				FavouriteDataModel favouriteDataModel = new FavouriteDataModel(cursor.getString(1), cursor.getString(2),cursor.getInt(3));

				wordsList.add(favouriteDataModel);
			}while(cursor.moveToNext());
		}
		
		return (ArrayList<FavouriteDataModel>) wordsList;
	}
	public String getW(){
//		List<FavouriteDataModel> wordsList = new ArrayList<FavouriteDataModel>();
		String query = "SELECT * FROM " + TABLE_WORD;
		String mm = "lol";

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(query, null);

		if(cursor.moveToFirst()){
			do{
				FavouriteDataModel favouriteDataModel = new FavouriteDataModel(cursor.getString(1));

				String m = favouriteDataModel.getWord();
				mm = m;
//				wordsList.add(favouriteDataModel);
			}while(cursor.moveToNext());
		}

		return mm;
	}

}
