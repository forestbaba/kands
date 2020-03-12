package com.forestsoftware.kands;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.forestsoftware.kands.Adapter.RecyclerTouchListener;
import com.forestsoftware.kands.DB.DBFavouriteSQLiteHandler;
import com.forestsoftware.kands.DB.DictObjectModel;
import com.forestsoftware.kands.Adapter.FavouriteCustomAdapter;
import com.forestsoftware.kands.DB.FavouriteDataModel;
import com.forestsoftware.kands.Adapter.ClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP-PC on 1/20/2018.
 */

public class FavouriteListFragment extends AppCompatActivity implements ClickListener
{
    Activity activity;
    ListView favoriteListView;
    List<DictObjectModel> fav;
    private List<FavouriteDataModel> wordsList;
   // FavouriteSharedPreferenceAdapter favouriteSharedPreferenceAdapter;

    DBFavouriteSQLiteHandler dbHandler;
    public List<FavouriteDataModel> wordsListFavourite;
    RecyclerView mRecyclerView;
    FavouriteCustomAdapter mRecyclerAdapter;
    RelativeLayout rlayout;


   // FavouriteSharedPreference favouriteSharedPreference;
    public static final String ARG_ITEM_ID = "favourite_list";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favword_list);
//        activity = getActivity();
//        activity = FavouriteListFragment.this;
        dbHandler = new DBFavouriteSQLiteHandler(getApplicationContext());
        wordsListFavourite = dbHandler.getWords();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
      //  rlayout = (RelativeLayout)findViewById(R.id.favList_Layout);
      //  favoriteListView = (ListView) findViewById(R.id.list_favourite);
      //  findViewsById(view);
       // favouriteSharedPreference = new FavouriteSharedPreference();

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position)
            {
//                FavouriteDataModel favouriteDataModel = wordsList.get(position);
                Intent i = new Intent(getApplicationContext(), FavouriteDisplaySong.class);
                i.putExtra("SONG_DISPLAY", position);
                startActivity(i);

//                startActivity(new Intent(FavouriteListFragment.this,FavouriteDisplaySong.class));
             //   Toast.makeText(getApplicationContext(),""+wordsListFavourite.get(0),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        if (wordsListFavourite == null) {
            Snackbar.make(favoriteListView, "No favourite - Null", Snackbar.LENGTH_SHORT).show();
        }
        else {

            if (wordsListFavourite.size() == 0) {
                Snackbar.make(getWindow().getDecorView(), "No favourite - size 0", Snackbar.LENGTH_SHORT).show();
            }

            ;
            if (wordsListFavourite != null) {

                mRecyclerAdapter = new FavouriteCustomAdapter(getApplicationContext(), wordsListFavourite);

                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                mRecyclerView.setAdapter(mRecyclerAdapter);

                //mRecyclerAdapter.notifyDataSetChanged ();
//                mRecyclerAdapter.setListener(this);
            }
        }
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
//    {
//        View view = inflater.inflate(R.layout.activity_favword_list, container, false);
//        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
//        rlayout = (RelativeLayout)view.findViewById(R.id.favList_Layout);
//        findViewsById(view);
//
////        setProducts();
////
////        favouriteSharedPreferenceAdapter = new FavouriteSharedPreferenceAdapter(getContext(), fav);
////        favoriteListView.setAdapter(favouriteSharedPreferenceAdapter);
////        favoriteListView.setOnItemClickListener(this);
////        favoriteListView.setOnItemLongClickListener(this);
//
//
//        if (wordsListFavourite == null) {
//            Snackbar.make(getActivity().findViewById(android.R.id.content), "No favourite - Null", Snackbar.LENGTH_SHORT).show();
//        }
//        else {
//
//            if (wordsListFavourite.size() == 0) {
//                Snackbar.make(getActivity().findViewById(android.R.id.content), "No favourite - size 0", Snackbar.LENGTH_SHORT).show();
//            }
//
//           ;
//            if (wordsListFavourite != null) {
//
//                mRecyclerAdapter = new FavouriteCustomAdapter(getContext(), wordsListFavourite);
//
//                mRecyclerView.setHasFixedSize(true);
//                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//                mRecyclerView.setAdapter(mRecyclerAdapter);
//                //mRecyclerAdapter.notifyDataSetChanged ();
////                mRecyclerAdapter.setListener(this);
//            }
//        }
//
//
//        return view;
//    }

    private void setProducts() {

        DictObjectModel product1 = new DictObjectModel(1, "Dell XPS Laptop", "60000");
        DictObjectModel product2 = new DictObjectModel(2, "HP Pavilion G6-2014TX Laptop", "50000");
        DictObjectModel product3 = new DictObjectModel(3, "ProBook HP 4540 Laptop", "45000");
        DictObjectModel product4 = new DictObjectModel(4, "HP Envy 4-1025TX Laptop", "9696");
        DictObjectModel product5 = new DictObjectModel(5, "Dell Inspiron Laptop", "48000");
        DictObjectModel product6 = new DictObjectModel(6, "Dell Vostro Laptop", "50000");
        DictObjectModel product7 = new DictObjectModel(7, "Lenovo IdeaPad Z Series Laptop", "40000");
        DictObjectModel product8 = new DictObjectModel(8, "Lenovo ThinkPad X Series Laptop", "38000");
        DictObjectModel product9 = new DictObjectModel(9, "Sony VAIO S Series Laptop", "39000");
        DictObjectModel product10 = new DictObjectModel(10, "Samsung Series 5 Laptop", "50000");
        fav = new ArrayList<DictObjectModel>();
        fav.add(product1);
        fav.add(product2);
        fav.add(product3);
        fav.add(product4);
        fav.add(product5);
        fav.add(product6);
        fav.add(product7);
        fav.add(product8);
        fav.add(product9);
        fav.add(product10);
    }

    private void findViewsById(View view) {
       // favoriteListView = (ListView) findViewById(R.id.list_favourite);
    }


//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        DictObjectModel favourite = (DictObjectModel) parent.getItemAtPosition(position);
//        Toast.makeText(getContext(), favourite.toString(), Toast.LENGTH_LONG).show();
//
//    }
//
//    @Override
//    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//        ImageView button = (ImageView) view.findViewById(R.id.imgbtn_favorite);
//
//        DictObjectModel model = new DictObjectModel();
//        String mm = model.getSong() + model.gettitle() + model.getNumber();
//
//        boolean fid = fav.contains(String.valueOf(mm));
//        if (fav.contains(model.getSong())) {
//            Log.wtf("Does it contain ? -----********-'-'-'", "true");
//        } else {
//            Log.wtf("Does it contain ? -----********-'-'-'", "false");
//        }
//        String tag = button.getTag().toString();
//        if (tag.equalsIgnoreCase("grey")) {
//            favouriteSharedPreference.addFavorite(getContext(), fav.get(position));
//            Toast.makeText(getContext(), getContext().getResources().getString(R.string.add_favr), Toast.LENGTH_SHORT).show();
//            Log.wtf("Position is -----********-'-'-'", "" + fav.get((int) id));
//
//            button.setTag("red");
//            button.setImageResource(R.drawable.favourite_red);
//        } else {
//            favouriteSharedPreference.removeFavorite(getContext(), fav.get(position));
//            button.setTag("grey");
//            button.setImageResource(R.drawable.favourite_blue);
//            Toast.makeText(getContext(), FavouriteListFragment.this.getResources().getString(R.string.remove_favr), Toast.LENGTH_SHORT).show();
//        }
//        return true;
//    }

    @Override
    public void onResume() {
        getSupportActionBar().setTitle(R.string.app_name);

//        getActivity().getActionBar().setTitle(R.string.app_name);
        super.onResume();

    }

    @Override
    public void onClick(View view, int position)
    {
       // Toast.makeText(this,"---000---",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLongClick(View view, int position) {

    }
    public int getFavouriteListSize()
    {
        return wordsListFavourite.size();

    }
}
