package com.forestsoftware.kands.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.forestsoftware.kands.DB.DatabaseHelper;
import com.forestsoftware.kands.R;
import com.forestsoftware.kands.utility.Utils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ADEOY3 on 10/31/2016.
 */

public class CustomCategoryAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> expandableListTitle;
    private HashMap<String, List<String>> expandableListDetail;
    SharedPreferences sharedPreferences;


    public CustomCategoryAdapter(Context context, List<String> expandableListTitle,
                                       HashMap<String, List<String>> expandableListDetail)
    {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public int getChildrenCount(int listPosition)
    {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition)).size();
    }

    @Override
    public Object getGroup(int listPosition)
    {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {

        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getGroupId(int listPosition)
    {
        return listPosition;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,View convertView, ViewGroup parent)
    {
        String listTitle = (String) getGroup(listPosition);
        String listNumber = String.valueOf(getGroupId(listPosition) + 1);

        if (convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTextSize(16);

        TextView  listTitleId = (TextView) convertView.findViewById(R.id.listId);


        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);

        listTitleId.setTypeface(null, Typeface.BOLD);
        listTitleId.setText(""+listNumber);



        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        //    This line really suffered me, i was parsing null instead of a value like below, take note     String getTheTheme = sharedPreferences.getString("change_theme","");

        String getTheTheme = sharedPreferences.getString("change_theme","White");

        switch (getTheTheme)
        {
            case "White":
                listTitleTextView.setTextColor(context.getResources().getColor(R.color.color_black));
                listTitleTextView.setBackgroundColor(context.getResources().getColor(R.color.color_white));
                listTitleId.setTextColor(context.getResources().getColor(R.color.color_black));
                listTitleId.setBackgroundColor(context.getResources().getColor(R.color.color_white));



                //listTitleTextView.setTextColor(context.getResources().getColor(R.color.color_black));


                break;

            case "Black":
                listTitleTextView.setTextColor(context.getResources().getColor(R.color.color_white));
                listTitleTextView.setBackgroundColor(context.getResources().getColor(R.color.color_black));
                listTitleId.setTextColor(context.getResources().getColor(R.color.color_white));
                listTitleId.setBackgroundColor(context.getResources().getColor(R.color.color_black));


               break;
            case "Grey":
                Utils.SIZE="DEFAULT";
                listTitleTextView.setBackgroundColor(context.getResources().getColor(R.color.colour_grey));
                listTitleTextView.setTextColor(context.getResources().getColor(R.color.color_black));
                listTitleId.setBackgroundColor(context.getResources().getColor(R.color.colour_grey));
                listTitleId.setTextColor(context.getResources().getColor(R.color.color_black));
                break;



            case "Brown":
                Utils.SIZE="DEFAULT";
                listTitleTextView.setBackgroundColor(context.getResources().getColor(R.color.colour_brown));
                listTitleTextView.setTextColor(context.getResources().getColor(R.color.color_white));
                listTitleId.setBackgroundColor(context.getResources().getColor(R.color.colour_brown));
                listTitleId.setTextColor(context.getResources().getColor(R.color.color_white));
                break;
        }

        return convertView;
    }


    @Override
    public View getChildView(int listPosition, final int expandedListPosition,boolean isLastChild, View convertView, ViewGroup parent)
    {
        final String expandedListText = (String)getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_item, null);
        }
        TextView expandedListTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
        //TextView expandedListTextChild = (TextView) convertView.findViewById(R.id.theChildId);

        String space = "             ";

        DatabaseHelper dbBackend = new DatabaseHelper(context);
        int length = 969;

        expandedListTextView.setText(expandedListText);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        String getTheTheme = sharedPreferences.getString("change_theme","white");

        switch (getTheTheme)
        {
            case "White":
                expandedListTextView.setTextColor(context.getResources().getColor(R.color.color_black));
                expandedListTextView.setBackgroundColor(context.getResources().getColor(R.color.color_white));
                break;

            case "Black":
                expandedListTextView.setTextColor(context.getResources().getColor(R.color.color_white));
                expandedListTextView.setBackgroundColor(context.getResources().getColor(R.color.color_black));
                break;

            case "Grey":
                expandedListTextView.setBackgroundColor(context.getResources().getColor(R.color.colour_grey));
                expandedListTextView.setTextColor(context.getResources().getColor(R.color.color_black));
                break;

            case "Brown":
               expandedListTextView.setBackgroundColor(context.getResources().getColor(R.color.colour_brown));
                expandedListTextView.setTextColor(context.getResources().getColor(R.color.color_white));
                break;
        }

        return convertView;
    }




    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public String getGroupName( int groupid)
    {
        return null;
    }
}
