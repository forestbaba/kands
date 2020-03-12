package com.forestsoftware.kands.Adapter;

/**
 * Created by HP-PC on 1/27/2018.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.forestsoftware.kands.R;
import com.forestsoftware.kands.DB.DBFavouriteSQLiteHandler;
import com.forestsoftware.kands.DB.FavouriteDataModel;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("NewApi")
public class FavouriteCustomAdapter extends RecyclerView.Adapter<FavouriteCustomAdapter.ItemsViewHolder>{

    private List<FavouriteDataModel> wordsList;
    public List<FavouriteDataModel> favouriteWords = new ArrayList<FavouriteDataModel>();
    int mPreviousPosition = -1;
    Context mContext;
    static ClickListener clickListener;
    DBFavouriteSQLiteHandler dbHandler;
    int songNumber;

    public  FavouriteCustomAdapter() {}
    public FavouriteCustomAdapter(Context con, List<FavouriteDataModel> wordsList){
        this.wordsList=wordsList;
        this.mContext=con;
        this.dbHandler = new DBFavouriteSQLiteHandler(mContext);
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {

        FavouriteDataModel wordMapper = wordsList.get(position);

        holder.txtViewIcon.setText(""+ wordMapper.getWord().charAt(0));
        holder.txtViewIcon.setGravity(Gravity.CENTER);
        holder.txtViewWord.setText(wordMapper.getWord());
        songNumber = wordMapper.getId();
//       holder.txtViewPOS.setText(wordMapper.getPartOfSpeech());

		/*If a product exists in SQLite then set filled star drawable and set a tag*/
//        if(checkFavouriteItem(wordMapper)){
//
//            Drawable starFilled = ResourcesCompat.getDrawable(mContext.getResources(), R.mipmap.ic_favourite_filled, null);
//            starFilled.setBounds(0,0,24,24);
//            holder.imgButtonFavourite.setBackground(starFilled);
//            holder.imgButtonFavourite.setTag("filled");
//
//        }else{
//
//            Drawable starEmpty = ResourcesCompat.getDrawable(mContext.getResources(), R.mipmap.ic_favourite,null);
//            starEmpty.setBounds(0,0,24,24);
//            holder.imgButtonFavourite.setBackground(starEmpty);
//            holder.imgButtonFavourite.setTag("empty");
//        }
    }

    @Override
    public int getItemCount() {
        return wordsList.size();
        //return (null != wordsList ? wordsList.size() : 0);
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CardView cardView;
        TextView txtViewIcon,txtViewWord,txtViewPOS;
        ImageButton imgButtonFavourite;
        boolean starred = false;

        public ItemsViewHolder(View itemView){
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardViewID);
            txtViewIcon = (TextView) itemView.findViewById(R.id.txtView_iconEntry);
            txtViewWord = (TextView) itemView.findViewById(R.id.txtView_Word);
          //  txtViewPOS = (TextView) itemView.findViewById(R.id.txtView_PartOfSpeech);
            imgButtonFavourite = (ImageButton) itemView.findViewById(R.id.imgButton_Favourite);

//
//            txtViewWord.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Intent i = new Intent(mContext, FavouriteDisplaySong.class);
//                    Toast.makeText(mContext, "You click me"+songNumber, Toast.LENGTH_SHORT).show();
//                }
//            });

            itemView.setOnClickListener(this);
//            imgButtonFavourite.setImageResource(R.drawable.delete);
            imgButtonFavourite.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
//
//                    String tag = imgButtonFavourite.getTag().toString();
//                    if (tag.equalsIgnoreCase("empty") && !starred) {
//
//                        //SharedPreference way
//                        //mSharedPreference.addFavorite(mContext,	wordsList.get(getAdapterPosition()));
//
//                        //SQLiteDB way
//                        dbHandler.addWord(wordsList.get(getAdapterPosition()));
//
//                        imgButtonFavourite.setTag("filled");
//                        Drawable starFilled = ResourcesCompat.getDrawable(view.getResources(), R.mipmap.ic_favourite_filled, null);
//                        starFilled.setBounds(0, 0, 24, 24);
//                        imgButtonFavourite.setBackground(starFilled);
//
//                        Snackbar.make(view, "Added to Favorites", Snackbar.LENGTH_LONG).setAction("Remove",new View.OnClickListener() {
//
//                            @Override
//                            public void onClick(View view) {
//                                //SQLiteDB way
//                                dbHandler.removeWord(wordsList.get(getAdapterPosition()));
//
//                                Drawable star = ResourcesCompat.getDrawable(view.getResources(), R.mipmap.ic_favourite, null);
//                                star.setBounds(0,0,24,24);
//                                imgButtonFavourite.setBackground(star);
//                            }
//                        }).show();
//                    } else {

                    Toast.makeText(mContext,"You clicked me",Toast.LENGTH_SHORT).show();
                        dbHandler.removeWord(wordsList.get(getAdapterPosition()));

                        //*****//
                        wordsList.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(), wordsList.size());
                        //*******//

//                        imgButtonFavourite.setTag("empty");
//                        Drawable starEmpty = ResourcesCompat.getDrawable(view.getResources(), R.mipmap.ic_favourite, null);
//                        starEmpty.setBounds(0, 0, 24, 24);
//                        imgButtonFavourite.setBackground(starEmpty);
//                    }
//                    starred =! starred;
                }
            });
        }

        @Override
        public void onClick(View view) {
            if(clickListener!=null){
                clickListener.itemClicked(view, getAdapterPosition());
            }
        }
    }

    //Checks whether a particular product exists in SQLiteDB
    public boolean checkFavouriteItem(FavouriteDataModel checkStarredItem){
        boolean check = false;

        ArrayList<FavouriteDataModel> itemsInDB = dbHandler.getWords();

        if(itemsInDB!=null){
            for(FavouriteDataModel word : itemsInDB){
                if((word.getWord()).equals(checkStarredItem.getWord())) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    public void setListener(ClickListener clicked){
        FavouriteCustomAdapter.clickListener = clicked;
    }

    public interface ClickListener{
        public void itemClicked(View view, int position);
    }
}