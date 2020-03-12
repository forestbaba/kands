package com.forestsoftware.kands;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by HP-PC on 1/28/2018.
 */

public class AboutKAndS extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_k_and_s);

        getSupportActionBar().setTitle("About K and S");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}

