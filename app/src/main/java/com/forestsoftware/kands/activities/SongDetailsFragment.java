package com.forestsoftware.kands.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.forestsoftware.kands.DB.DBFavouriteSQLiteHandler;
import com.forestsoftware.kands.DB.DictObjectModel;
import com.forestsoftware.kands.DB.FavouriteDataModel;
import com.forestsoftware.kands.DB.SomeDbOperation;
import com.forestsoftware.kands.MainActivity;
import com.forestsoftware.kands.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP-PC on 1/10/2018.
 */

//public class SongDetailsFragment extends Activity implements AppCompatCallback
public class SongDetailsFragment extends AppCompatActivity

{
    Toolbar toolbar;
    private AppCompatDelegate delegate;
    TextView tvs, tvt;
    ImageButton zoomIn, zoomOut, menu, favouriteButton;
    private boolean day = false;
    private boolean night = false;
    private boolean _default = false;
    boolean starred = false;
    DBFavouriteSQLiteHandler dbHandler;
    List<FavouriteDataModel> wordList;

    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_fragment);
        sp = this.getSharedPreferences("theme", Context.MODE_PRIVATE);
        String tbt = "";
//        toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitle("Song Overview ");
        dbHandler = new DBFavouriteSQLiteHandler(this);
        wordList = new ArrayList<FavouriteDataModel>();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvs = (TextView) findViewById(R.id.tv_song);
      //  tvt = (TextView) findViewById(R.id.tv_title);

        zoomIn = (ImageButton) findViewById(R.id.zoom_in);
        zoomOut = (ImageButton) findViewById(R.id.zoom_out);
     //   menu = (ImageButton) findViewById(R.id.pop_menu);
        //   favouriteButton = (ImageButton) findViewById(R.id.fbt);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int sPhrase = bundle.getInt("DICTIONARY_TITLE");
        int id = sPhrase + 1;


        SomeDbOperation dbOperation = new SomeDbOperation(this);
//        dbOperation.getQuizById(id);

        final DictObjectModel dom = dbOperation.getQuizById(id);
      //  Log.w("Stuffs to output: ", "=---===" + dom.gettitle());
        System.out.println("The output is: " + dom.getSong());

        tvt.setText(dom.gettitle());
        tvs.setText(dom.getSong());
        setButton();
    }

//        favouriteButton.setOnClickListener(new View.OnClickListener()
//        {
//
//            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//            @Override
//            public void onClick(View view) {
//
////                String tag = favouriteButton.getRootView().getTag().toString();
////                String tag = "empty";
//                if ( !starred) {
//
//                    //SharedPreference way
//                    //mSharedPreference.addFavorite(mContext,	wordsList.get(getAdapterPosition()));
//
//                    //SQLiteDB way
//
//
//                   final String m1 = dom.gettitle();
//                    String m2 = dom.getSong();
//
//
//                    dbHandler.addW(m1, m2);
//
//                    favouriteButton.setTag("filled");
//                    Drawable starFilled = ResourcesCompat.getDrawable(view.getResources(), R.mipmap.ic_favourite_filled, null);
//                    starFilled.setBounds(0, 0, 24, 24);
//                    favouriteButton.setBackground(starFilled);
//
//                    Snackbar.make(view, "Added to Favorites", Snackbar.LENGTH_LONG).setAction("Remove",new View.OnClickListener() {
//
//                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//                        @Override
//                        public void onClick(View view) {
//                            //SharedPreference way
//                            //mSharedPreference.removeFavorite(mContext, wordsList.get(getAdapterPosition()));
//
//                            //SQLiteDB way
//                            dbHandler.removeW(m1);
//
//                            Drawable star = ResourcesCompat.getDrawable(view.getResources(), R.mipmap.ic_favourite, null);
//                            star.setBounds(0,0,24,24);
//                            favouriteButton.setBackground(star);
//                        }
//                    }).show();
//                } else {
//
//                    //SharedPreference way
//                    //mSharedPreference.removeFavorite(mContext,	wordsList.get(getAdapterPosition()));
//
//                    //SQLiteDB way
//                    dbHandler.removeW(dom.gettitle());
//
//                    //*****//
////                    wordsList.remove(getAdapterPosition());
////                    notifyItemRemoved(getAdapterPosition());
////                    notifyItemRangeChanged(getAdapterPosition(), wordsList.size());
//                    //*******//
//
//                    favouriteButton.setTag("empty");
//                    Drawable starEmpty = ResourcesCompat.getDrawable(view.getResources(), R.mipmap.ic_favourite, null);
//                    starEmpty.setBounds(0, 0, 24, 24);
//                    favouriteButton.setBackground(starEmpty);
//                }
//                starred =! starred;
//            }
//        });
//
//    }

    void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //     setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void setButton() {
        float lowestSize = 18;
        float highestSize = 50;
        float size = tvs.getTextSize();

        if (size <= lowestSize) {
            zoomOut.setEnabled(false);
        } else if (tvs.getTextSize() >= highestSize) {
            zoomIn.setEnabled(false);
        }

        zoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float size = tvs.getTextSize();
                tvs.setTextSize(TypedValue.COMPLEX_UNIT_PX, size + 1);
//                tc.setEnabled(true);
            }
        });
        zoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float size = tvs.getTextSize();
                tvs.setTextSize(TypedValue.COMPLEX_UNIT_PX, size - 1);
                if (size <= 18) {
                    zoomOut.setEnabled(false);
                }
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUpmenu(v);
            }
        });


    }



    private void showPopUpmenu(View view) {
        PopupMenu popupMenu = new PopupMenu(getApplicationContext(), view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.pop_up, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new MymenuItemClickListener());
        popupMenu.show();
    }

    class MymenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
//            switch (item.getItemId())
//            {
//                case  R.id.default_theme:
//                    item.setChecked(true);
//            }
            if (item.getItemId() == R.id.home) // Press Back Icon
            {
                Intent i = new Intent(SongDetailsFragment.this, MainActivity.class);
                startActivity(i);
                finish();
            }
            if (item.getItemId() == R.id.share_now) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = tvs.getText().toString();
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }


            if (item.getItemId() == R.id.default_theme) {
                MenuItem menuItem = item.getSubMenu().getItem();
                menuItem.setChecked(true);
                item.setChecked(true);

                item.setChecked(!item.isChecked());
                SharedPreferences settings = getSharedPreferences("Settings", 0);

                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("checkbox", item.isChecked());
                editor.apply();
                return true;
            }
            if (item.getItemId() == R.id.night) {
                Toast.makeText(getApplicationContext(), "Checking if: " + item.getItemId(), Toast.LENGTH_SHORT).show();
                if (item.isChecked())
                {
                    item.setChecked(false);
                    night = false;
                    Toast.makeText(getApplicationContext(), "Checking if: " + item.getItemId(), Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    item.setChecked(true);
                    tvs.setBackgroundColor(getResources().getColor(R.color.black));
                    tvt.setBackgroundColor(getResources().getColor(R.color.black));

                    tvs.setTextColor(getResources().getColor(R.color.White));
                    tvt.setTextColor(getResources().getColor(R.color.White));
                    sp.edit().putBoolean("black", true).apply();
                    SharedPreferences settings = getSharedPreferences("Settings",0);
                    SharedPreferences.Editor sp = settings.edit();
                    sp.putBoolean("Theme", true);
                    sp.commit();
                    night = true;

                }
                return true;

            }


            if (item.getItemId() == R.id.day) {
                if (item.isChecked()) {
                    item.setChecked(false);
                    day = false;
                } else {
                    item.setChecked(true);
                    tvs.setBackgroundColor(getResources().getColor(R.color.White));
                    tvt.setBackgroundColor(getResources().getColor(R.color.White));

                    tvs.setTextColor(getResources().getColor(R.color.black));
                    tvt.setTextColor(getResources().getColor(R.color.black));
                    day = true;
                    sp.edit().putBoolean("white", true).apply();

                }
                return true;
            }
            if (item.getItemId() == R.id.favourite)
            {
//                Intent intent = new Intent(SongDetailsFragment.this, FavouriteFragment.class);
//                startActivity(intent);
            }
            return false;
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
//
//        int id = item.getItemId();
//        switch (id)
//        {
//            case android.R.id.:
//
//                return true;
//        }
////        return true;
//


        return super.onOptionsItemSelected(item);
    }
}