package com.forestsoftware.kands.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.forestsoftware.kands.DB.DictObjectModel;
import com.forestsoftware.kands.R;

import java.util.ArrayList;

public class SearchCustomAdapter extends RecyclerView.Adapter<SearchCustomAdapter.MyViewHolder> {

    private ArrayList<DictObjectModel> dataSet;
    Boolean check = false;
   static Context context;
    CardView cview;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView word, meaning;
        RelativeLayout expandable;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.expandable = (RelativeLayout) itemView.findViewById(R.id.expandableLayout);
            this.word = (TextView) itemView.findViewById(R.id.wordtext);
            this.meaning = (TextView) itemView.findViewById(R.id.meaningtext);

        }
    }

    public SearchCustomAdapter(ArrayList<DictObjectModel> data) {
       // this.context = c;
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.xx, parent, false);

        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!check) {
                    myViewHolder.expandable.animate().alpha(0.0f).setDuration(1000);


                    myViewHolder.expandable.setVisibility(View.GONE);
                    check = true;
                    //  myViewHolder.schedule.setVisibility(View.VISIBLE);

                } else {
                    myViewHolder.expandable.setVisibility(View.VISIBLE);
                    myViewHolder.expandable.animate()
                            .alpha(1.0f)
                            .setDuration(1000);

                    check = false;

                }
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView word1 = holder.word;
        TextView meaning1 = holder.meaning;
        word1.setText(dataSet.get(listPosition).gettitle());
        meaning1.setText(dataSet.get(listPosition).getSong());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}