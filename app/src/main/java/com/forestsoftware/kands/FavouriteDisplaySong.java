package com.forestsoftware.kands;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.forestsoftware.kands.DB.DictObjectModel;
import com.forestsoftware.kands.DB.SomeFavouriteDBOperation;

/**
 * Created by HP-PC on 2/5/2018.
 */

public class FavouriteDisplaySong extends AppCompatActivity
{
    TextView tv,tvt;
    ImageButton zoomIn,zoomOut;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_display_song);
     //   tv = (TextView)findViewById(R.id.ds);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int sPhrase = bundle.getInt("SONG_DISPLAY");
        int id = sPhrase + 1;


        SomeFavouriteDBOperation dbOperation = new SomeFavouriteDBOperation(this);
//        dbOperation.getQuizById(id);

        final DictObjectModel dom = dbOperation.getFavouriteById(id);
//        Log.w("Stuffs to output: ", "*****[[]]]***" + dom.gettitle());
        System.out.println("The output is: " + id);

//        tvt.setText(dom.gettitle());
        tv = (TextView) findViewById(R.id.tv_song);
        tvt = (TextView) findViewById(R.id.tv_title);

        zoomIn = (ImageButton) findViewById(R.id.zoom_in);
        zoomOut = (ImageButton) findViewById(R.id.zoom_out);

        tvt.setText(dom.gettitle());
        tv.setText(dom.getSong());

//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        String sPhrase = bundle.getString("SONG_DISPLAY");
//        tv.setText(sPhrase);
        setButton();
    }

    public void setButton() {
        float lowestSize = 18;
        float highestSize = 50;
        float size = tv.getTextSize();

        if (size <= lowestSize) {
            zoomOut.setEnabled(false);
        } else if (tv.getTextSize() >= highestSize) {
            zoomIn.setEnabled(false);
        }

        zoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float size = tv.getTextSize();
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, size + 1);
//                tc.setEnabled(true);
            }
        });
        zoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float size = tv.getTextSize();
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, size - 1);
                if (size <= 18) {
                    zoomOut.setEnabled(false);
                }
            }
        });

//        menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showPopUpmenu(v);
//            }
//        });


    }
}
