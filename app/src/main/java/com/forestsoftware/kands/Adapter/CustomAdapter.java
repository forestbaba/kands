package com.forestsoftware.kands.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.forestsoftware.kands.R;
import com.forestsoftware.kands.DB.DictObjectModel;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<DictObjectModel> dataSet;
    Boolean check = false;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, number;

        RelativeLayout expandable;

        public MyViewHolder(View itemView) {
            super(itemView);
//            this.expandable= (RelativeLayout)itemView.findViewById(R.id.expandableLayout);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.number = (TextView) itemView.findViewById(R.id.number);

        }
    }

    public CustomAdapter(List<DictObjectModel> data)
    {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(view);


//        final MyViewHolder myViewHolder = new MyViewHolder(view);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!check)
//                {
//                    myViewHolder.expandable.animate().alpha(0.0f).setDuration(1000);
//
//
//                    myViewHolder.expandable.setVisibility(View.GONE);
//                        check=true;
//                  //  myViewHolder.schedule.setVisibility(View.VISIBLE);
//
//                }
//                else {
//                    myViewHolder.expandable.setVisibility(View.VISIBLE);
//                    myViewHolder.expandable.animate()
//                            .alpha(1.0f)
//                            .setDuration(1000);
//
//                    check=false;
//
//                }
//            }
//        });

        // return null;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        DictObjectModel dom = dataSet.get(listPosition);

        //TextView title = holder.title;
        //TextView number = holder.number;

        holder.title.setText(dataSet.get(listPosition).gettitle());
        holder.number.setText(dataSet.get(listPosition).getSong());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}