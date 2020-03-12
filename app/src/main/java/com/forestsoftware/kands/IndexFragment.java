package com.forestsoftware.kands;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.forestsoftware.kands.Adapter.ClickListener;
import com.forestsoftware.kands.Adapter.CustomAdapter;
import com.forestsoftware.kands.Adapter.RecyclerTouchListener;
import com.forestsoftware.kands.DB.DatabaseHelper;
import com.forestsoftware.kands.DB.DictObjectModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HP-PC on 1/2/2018.
 */

public class IndexFragment extends AppCompatActivity
{
    private List<DictObjectModel> songList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CustomAdapter cAdapter;



    DatabaseHelper db;
    LinkedHashMap<String, String> x = new LinkedHashMap<>();
//    LinkedHashMap<String,String> titleList;LinkedHashMap<String,x> titleList;

    LinkedHashMap<String, String> titleList;
    ArrayList<String> numberCombimelist;
    ArrayList<String> titlecombimelist;
    ArrayList<String> songcombimelist;

    public static ArrayList<DictObjectModel> data = new ArrayList<DictObjectModel>();

    private static RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_parent);

        prepareSongData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        cAdapter = new CustomAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cAdapter);



        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                DictObjectModel dom = data.get(position);
             //   Toast.makeText(getApplicationContext(), position + " is selected!", Toast.LENGTH_SHORT).show();

                SongDetailsFragment songDetailsFragment = new SongDetailsFragment();
                Intent i = new Intent(getApplicationContext(), SongDetailsFragment.class);
                i.putExtra("DICTIONARY_TITLE", position);
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }



    private void prepareSongData()
    {

        db = new DatabaseHelper(getApplicationContext());
      //  Log.wtf("We are here","Inside");
        try
        {

            db.createDataBase();
            db.openDataBase();

        } catch (Exception e)
        {
            e.printStackTrace();
        }


        titleList = new LinkedHashMap<>();
        int ii, ij;
        SQLiteDatabase sd = db.getReadableDatabase();

        Cursor cursor = sd.query("dictionary", null, null, null, null, null, null);
        ii = cursor.getColumnIndex("number");

        numberCombimelist = new ArrayList<String>();
        titlecombimelist = new ArrayList<String>();
        songcombimelist = new ArrayList<String>();

        while (cursor.moveToNext()) {
            x.put(cursor.getString(cursor.getColumnIndex("title")), cursor.getString(cursor.getColumnIndex("contents")));
            titleList.put(cursor.getString(ii), cursor.getString(cursor.getColumnIndex("title")));
        }


        Iterator entries = titleList.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            numberCombimelist.add(String.valueOf(thisEntry.getKey()));
            titlecombimelist.add(" " + String.valueOf(thisEntry.getValue()));
        }

        for (int i = 0; i < numberCombimelist.size(); i++) {
            data.add(new DictObjectModel(numberCombimelist.get(i), titlecombimelist.get(i)));
        }

        adapter = new CustomAdapter(data);
    }

}

