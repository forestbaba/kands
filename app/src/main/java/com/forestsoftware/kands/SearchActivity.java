package com.forestsoftware.kands;//


import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.forestsoftware.kands.Adapter.SearchCustomAdapter;
import com.forestsoftware.kands.DB.DatabaseHelper;
import com.forestsoftware.kands.DB.DictObjectModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    public static ArrayList<DictObjectModel> data;
    DatabaseHelper db;
    ArrayList<String> wordcombimelist;
    ArrayList<String> meancombimelist;
    LinkedHashMap<String, String> namelist;
    SearchView searchView;
    SharedPreferences sharedPreferences;
    RelativeLayout rl;
    EditText searchEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        rl = (RelativeLayout) findViewById(R.id.search_relativelayout);
        recyclerView.setHasFixedSize(true);

        searchView = (SearchView) findViewById(R.id.searchView);
        searchEditText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.color_white));
        searchEditText.setHintTextColor(getResources().getColor(R.color.color_white));
        searchView.setQueryHint("Search");
        searchView.setQueryRefinementEnabled(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DictObjectModel>();
        fetchData();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                newText = newText.toLowerCase();

                final ArrayList<DictObjectModel> filteredList = new ArrayList<DictObjectModel>();

                for (int i = 0; i < wordcombimelist.size(); i++) {

                    final String text = wordcombimelist.get(i).toLowerCase();
                    if (text.contains(newText)) {

                        filteredList.add(new DictObjectModel(wordcombimelist.get(i), meancombimelist.get(i)));
                    }
                }
                adapter = new SearchCustomAdapter(filteredList);
                recyclerView.setAdapter(adapter);


                return true;
            }
        });






    }

    public void fetchData() {
        db = new DatabaseHelper(getApplicationContext());

        namelist = new LinkedHashMap<>();
        int ii;
        SQLiteDatabase sd = db.getReadableDatabase();
        Cursor cursor = sd.query("dictionary", null, null, null, null, null, null);
        ii = cursor.getColumnIndex("contents");

        wordcombimelist = new ArrayList<String>();
        meancombimelist = new ArrayList<String>();
        while (cursor.moveToNext())
        {
            namelist.put(cursor.getString(ii), cursor.getString(cursor.getColumnIndex("title")));
        }
        Iterator entries = namelist.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            wordcombimelist.add(String.valueOf(thisEntry.getKey()));
            meancombimelist.add("- " + String.valueOf(thisEntry.getValue()));

        }

        for (int i = 0; i < wordcombimelist.size(); i++) {
            data.add(new DictObjectModel(wordcombimelist.get(i), meancombimelist.get(i)));
          //  Log.wtf("Values ",""+ wordcombimelist.get(i));

        }
        adapter = new SearchCustomAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}
