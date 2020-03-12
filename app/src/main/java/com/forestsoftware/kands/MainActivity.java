package com.forestsoftware.kands;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.forestsoftware.kands.Adapter.FavouriteCustomAdapter;
import com.winsontan520.wversionmanager.library.WVersionManager;

import java.util.Random;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    TextView tv,tvfc;
    ImageButton zoomin, zoomout, play;
    Handler handler;
    FavouriteListFragment favouriteListFragment = new FavouriteListFragment();

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        FavouriteCustomAdapter favouriteCustomAdapter = new FavouriteCustomAdapter();
//        int count = favouriteListFragment.getFavouriteListSize();



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       // navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);

//         tvfc = (TextView)findViewById(R.id.favourite_count);
//        tvfc.setText("poo");
//        TextView view = (TextView) navigationView.getMenu().findItem(R.id.favourite_count).getActionView();
//        view.setText("pop");
        navigationView.setNavigationItemSelectedListener(this);

        WVersionManager versionManager = new WVersionManager(this);
        versionManager.setVersionContentUrl("http://bit.ly/11c7Pnb"); // your update content url, see the response format below
        versionManager.checkVersion();
        //I need to come back here


        tv = (TextView) findViewById(R.id.scripture_show);
//This code is to be uncommented for next update
//        TextView view = (TextView) navigationView.getMenu().findItem(R.id.nav_favourite).getActionView().findViewById(R.id.favourite_count);
      //  view.setText("40");  This code is working, am using it for second update


        Runnable runnable = new Runnable() {
            int i = 0;
            final int[] array = {R.string.quote1, R.string.quote2, R.string.quote3, R.string.quote4,
                    R.string.quote5,R.string.quote6,R.string.quote7,R.string.quote8,R.string.quote9
                    ,R.string.quote10,R.string.quote11,R.string.quote12,R.string.quote13,R.string.quote14
                    ,R.string.quote15,R.string.quote16,R.string.quote17,R.string.quote18,R.string.quote19
                    ,R.string.quote20,R.string.quote21,R.string.quote22,R.string.quote23,R.string.quote24
            };
          //  final String [] some_array = getResources().getStringArray(R.array.quotes);

            @Override
            public void run() {
                tv.setText(getRandom(array));
                i++;
                if (i == array.length)
                    i = 0;
                tv.postDelayed(this, 60000);
              //  String[] some_array = getResources().getStringArray(R.array.quotes);
              //  Log.w("The strings",some_array[4]);

            }
        };
        runnable.run();



    }
    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_home) {
            Intent i = new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);
            // Handle the camera action
        } else if (id == R.id.nav_index) {
            Intent i = new Intent(MainActivity.this, IndexFragment.class);
         //   Toast.makeText(this, "Wao", Toast.LENGTH_SHORT).show();

            startActivity(i);
        } else if (id == R.id.nav_favourite) {
            Intent i = new Intent(MainActivity.this, FavouriteListFragment.class);
            startActivity(i);
        }

        if (id == R.id.nav_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "");//am suppose to put app url here

            try {
                startActivity(Intent.createChooser(intent, "SELECT AN ACTION"));
            } catch (android.content.ActivityNotFoundException ex) {

            }


        }
        if (id == R.id.nav_rate) {
            Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
            Intent market = new Intent(Intent.ACTION_VIEW, uri);
            market.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);

            try {

                startActivity(market);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.goo.com/store/apps/details?id=" +
                        getApplicationContext().getPackageName())));
            }

        }
//        if (id == R.id.nav_about_ks) {
//            Intent intent = new Intent(MainActivity.this, AboutKAndS.class);
//            startActivity(intent);
//
//        }
        if(id == R.id.nav_about_app)
        {
//            if (id == R.id.action_about) {
                new AlertDialog.Builder(this).setIcon(R.mipmap.kands)
                        .setTitle("K & S 2.0")
                        .setMessage("Base on CHERUBIM & SERAPHIM CHURCH HYMM BOOK " +"\n" +
                                "Fourth Edition." + "\n\n" +
//                                " Please forward any feedback to " + "\n" +
                                "adeoy3@gmail.com"+"\n\n"+
                                "This is an update for K & S version 1.2  " +
                               "\n\n"                            +
                                "Developer: ForestBaba"
                        )
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                // continue with delete
                            }
                        })

//                    .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                return true;


        }
        if (id == R.id.nav_category) {
            Intent intent = new Intent(MainActivity.this, Category.class);
            startActivity(intent);

        }

        if (id == R.id.nav_feedback) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"adeoy3@email.address"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
            intent.putExtra(Intent.EXTRA_TEXT, "mail body");
            startActivity(Intent.createChooser(intent, ""));

        }
//        else if (id == R.id.nav_settings) {
//            Intent i = new Intent(MainActivity.this, SettingsFragment.class);
//            startActivity(i);
//        }
        else if (id == R.id.search) {
        Intent i = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(i);
    }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    private void setMenuCounter(@IdRes int itemId, int count) {
//        TextView view = (TextView) navigationView.getMenu().findItem(itemId).getActionView();
//        view.setText(count > 0 ? String.valueOf(count) : null);
//    }
}
