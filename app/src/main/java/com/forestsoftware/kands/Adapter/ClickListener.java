package com.forestsoftware.kands.Adapter;

import android.view.View;

/**
 * Created by HP-PC on 1/10/2018.
 */

public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}