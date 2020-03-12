package com.forestsoftware.kands;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.forestsoftware.kands.Adapter.CustomCategoryAdapter;
import com.forestsoftware.kands.Adapter.SongData;
import com.forestsoftware.kands.DB.SomeDbOperation;
import com.forestsoftware.kands.utility.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Category extends AppCompatActivity {

    private Menu menu;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> parent;
    HashMap<String, List<String>> expandableListDetail;
    CardView par;
    SharedPreferences sharedPreferences;

    String getThe = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = SongData.getData();
        par = (CardView) findViewById(R.id.cardViewID);


        parent = new ArrayList<>();



        parent.add("Orin Akúnlẹkọ     i - xlv");
        parent.add("Orin Owurọ     1 - 8");
        parent.add("OrinAlẹ     9 - 19");
        parent.add("Orin Ọjọ Isinmi     20 - 44");
        parent.add("Orin Idariji Ẹsẹ     45 - 71");
        parent.add(" Orin Iyasi Mimọ     72 - 80");
        parent.add("Orin Ọpẹ     81 - 149");
        parent.add("OrinIyin     150 - 152 ");
        parent.add("Orin Agbara Ẹmi Mimọ     153 - 166 ");
        parent.add("Orin Ikore     167 - 177 ");
        parent.add("Orin Bibọ Jesu     178 - 197 ");
        parent.add("Orin Ibi Kristi     198 - 209");
        parent.add("Orin Opin Ọdun     210 - 213");
        parent.add("Orin Ifihan     214 - 217");
        parent.add("Orin Ọdun Tuntun     218 - 234");
        parent.add("Orin Irònúpiwàdà (Lenti)     235 - 285");
        parent.add("Orin Isinmi Ọpẹ     286 - 288");
        parent.add("Orin Ọsẹ Ijiya Jesu     289 - 308");
        parent.add("Orin Asalẹ Ajinde     309 - 316 ");
        parent.add("Orin Ajinde Jesu     317 - 340 ");
        parent.add("Orin Igoke Re Ọrun     341 - 349 ");
        parent.add("Orin Oke Ọrun     350 - 376 ");
        parent.add("Orin Pentikọsti     377 - 385 ");
        parent.add("Orin Ọjọ Isinmi Funfun     386 - 387 ");
        parent.add("Orin Ọjọ Mẹtalọkan     388 - 395 ");
        parent.add("Orin Ọrọ Ọlọrun     396 - 408");
        parent.add("Orin Adura     409 - 436");
        parent.add("Orin Igbàgbọ     437 - 473");
        parent.add("Orin Abo     474 - 478 ");
        parent.add("Orin Anu ati Ipese     479 - 490");
        parent.add("Orin Iwosàn     491 - 496");
        parent.add("Orin Isẹgun     497 - 512");
        parent.add("Orin Ifẹ si Ọlọrun     513 – 525");
        parent.add("Orin Ifẹ si Ọmọ Ẹnikeji     526 - 536 ");
        parent.add("Orin Iwa Mimọ 537     - 549 ");
        parent.add("Orin Irin Ajo ati Ijagun     550 - 582 ");
        parent.add("OrinIsẹ Isin     583 - 601");
        parent.add("Orin Ikilọ ati Ipe     602 - 612");
        parent.add("Orin Iribọmi     613 - 623");
        parent.add("Orin Imulọkanle     624 - 645 ");
        parent.add("Orin Ounjẹ Ale Oluwa(Idapo Mimọ)     646 - 652");
        parent.add("Orin Igbeyawo     653 - 660");
        parent.add("Orin Isọmọ L’orukọ     661 - 662 ");
        parent.add("Orin Ọjọ Obi ati Ọmọde     663 - 688 ");
        parent.add("Orin Ifi Ipile Lelẹ     689 - 693 ");
        parent.add("Orin Isile     694 - 697 ");
        parent.add("Orin Ijọ Ounjẹ ọrun loke Ọrun     698 - 700");
        parent.add("Orin Ajọdun     701 - 726 ");
        parent.add("Orin Ajọdun Maikeli Mimọ     727 - 730");
        parent.add("Orin Kérúbù ati Séráfù     731 - 748 ");
        parent.add("Orin Isinku     749 - 768 ");
        parent.add("Orin Saaju Adura     769 - 773");
        parent.add("Orin Saju Ore-Ọfẹ ati Ibukun     774 - 782 ");
        parent.add("Orin Oniruru Igba ati Ore Ọlọrun     783 - 865 ");
        parent.add("Orin Isọji ati Idaraya Emi     1 - 49");




        HashMap<String, List<String>> allChildItems = returnGroupedChildItems();
        expandableListAdapter = new CustomCategoryAdapter(this, parent, allChildItems);


        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(), parent.get(groupPosition) + " List Expanded.",
//                        Toast.LENGTH_SHORT).show();
                if (groupPosition != -1)
                {

                }
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener()
        {

            @Override
            public void onGroupCollapse(int groupPosition) {

            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                int length = expandableListAdapter.getGroupCount();
                for (int j = 0; j < length; j++) {
                    //  expandableListView.collapseGroup(j);
                }

            }
        });


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                //  Toast.makeText(getApplicationContext(), "Group Position" + groupPosition + "\n" + "Position " + childPosition, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), SongDetailsFragmentCategory.class);
                if (groupPosition == 0) {
                    intent.putExtra("DICTIONARY_ID", childPosition);
                   // Toast.makeText(getApplicationContext(),"position "+ childPosition,Toast.LENGTH_SHORT).show();
                }
                if (groupPosition == 1) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 45);
                   // Toast.makeText(getApplicationContext(),"position "+ childPosition,Toast.LENGTH_SHORT).show();
                }
                if (groupPosition == 2) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 53);
                }
                if (groupPosition == 3) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 65);
                }
                if (groupPosition == 4) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 90);
                }
                if (groupPosition == 5) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 117);
                }
                if (groupPosition == 6) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 127);
                }
                if (groupPosition == 7) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 196);
                }
                if (groupPosition == 8) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 199);
                }
                if (groupPosition == 9) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 213);

                }
                if (groupPosition == 10) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 224);
                }
                if (groupPosition == 11) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 244);
                }
                if (groupPosition == 12) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 256);
                }
                if (groupPosition == 13) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 260);
                }
                if (groupPosition == 14) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 264);
                }
                if (groupPosition == 15) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 281);
                }
                if (groupPosition == 16) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 332);
                }
                if (groupPosition == 17) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 335);
                }
                if (groupPosition == 18) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 355);
                }
                if (groupPosition == 19) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 368);
                }
                if (groupPosition == 20) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 392);
                }
                if (groupPosition == 21) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 401);
                }
                if (groupPosition == 22) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 428);

                }
                if (groupPosition == 23) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 437);
                }
                if (groupPosition == 24) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 439);
                }
                if (groupPosition == 25) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 447);
                }
                if (groupPosition == 26) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 460);
                }
                if (groupPosition == 27) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 488);
                }
                if (groupPosition == 28) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 525);
                }
                if (groupPosition == 29) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 530);
                }
                if (groupPosition == 30) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 542);
                }
                if (groupPosition == 31) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 548);
                }
                if (groupPosition == 32) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 564);
                }
                if (groupPosition == 33) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 577);
                }
                if (groupPosition == 34) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 588);
                }
                if (groupPosition == 35) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 601);
                }
                if (groupPosition == 36) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 634);
                }
                if (groupPosition == 37) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 653);
                }
                if (groupPosition == 38) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 664);
                }
                if (groupPosition == 39) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 675);
                }
                if (groupPosition == 40) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 697);
                }
                if (groupPosition == 41) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 704);
                }
                if (groupPosition == 42) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 712);
                }
                if (groupPosition == 43) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 714);
                }
                if (groupPosition == 44) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 741);
                }
                if (groupPosition == 45) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 746);
                }
                if (groupPosition == 46) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 750);
                }
                if (groupPosition == 47) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 753);
                }
                if (groupPosition == 48) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 779);
                }
                if (groupPosition == 49) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 783);
                }
                if (groupPosition == 50) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 801);
                }
                if (groupPosition == 51) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 821);
                }
                if (groupPosition == 52) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 826);
                }
                if (groupPosition == 53) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 835);
                }
                if (groupPosition == 54) {
                    intent.putExtra("DICTIONARY_ID", childPosition + 920);
                }


                startActivity(intent);

//                Intent intent = new Intent(getContext(),SongOverviewActivity.class);
//                startActivity(intent);
                return false;
            }
        });


        String getTheTheme = sharedPreferences.getString("change_theme", "White");

        switch (getTheTheme) {
            case "White":
                par.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.color_white));



                break;

            case "Black":
                //listTitleTextView.setTextColor(context.getResources().getColor(R.color.color_white));
                par.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.color_black));
                //parent_lay.setBackgroundColor(context.getResources().getColor(R.color.color_black));
                par.invalidate();

                //Toast.makeText(context.getApplicationContext(),"Theme Selected is "+  getTheTheme,Toast.LENGTH_SHORT).show();
                break;
            case "Grey":
                Utils.SIZE = "DEFAULT";
                par.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colour_grey));
                // listTitleTextView.setTextColor(context.getResources().getColor(R.color.color_white));
                // Toast.makeText(context.getApplicationContext(),"Theme Selected is "+  getTheTheme,Toast.LENGTH_SHORT).show();
                break;


            case "Brown":
                Utils.SIZE = "DEFAULT";
                par.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colour_brown));
                //  listTitleTextView.setTextColor(context.getResources().getColor(R.color.color_white));

                break;
        }
    }

    //DbBackend dbBackend = new DbBackend(getApplicationContext());
    int point[] = {
            45, 53, 65, 90, 117,
            127, 196, 199, 213, 224,
            244, 256, 260, 264, 281,
            332, 335, 355, 368, 392,
            401, 428, 437, 439, 447,
            460, 488, 525, 530, 542,
            548, 564, 577, 588, 601,
            634, 653, 664, 675, 697,
            704, 712, 714, 741, 746,
            750, 753, 779, 783, 801,
            821, 826, 835, 920, 969
    };

    private HashMap<String, List<String>> returnGroupedChildItems() {
        SomeDbOperation dbBackend = new SomeDbOperation(getApplicationContext());
        HashMap<String, List<String>> childContent = new HashMap<String, List<String>>();
        List<String> parent1 = new ArrayList<String>();


        int count = 0;
        int length = dbBackend.dictionaryWords().length;
       // Log.e("QQQQQQQQQQ SIZE :", "" + length);
        String[] aa = dbBackend.dictionaryWords();
        ArrayList<String> x = new ArrayList<String>(Arrays.asList(aa));


        for (int i = 0; i < 45; i++)
            parent1.add(aa[i]);

        List<String> parent2 = new ArrayList<String>();
        for (int i = 45; i < 53; i++)
            parent2.add(aa[i]);

        List<String> parent3 = new ArrayList<String>();
        for (int i = 53; i < 65; i++)
            parent3.add(aa[i]);

        List<String> parent4 = new ArrayList<String>();
        for (int i = 65; i < 90; i++)
            parent4.add(aa[i]);

        List<String> parent5 = new ArrayList<String>();
        for (int i = 90; i < 117; i++)
            parent5.add(aa[i]);

        List<String> parent6 = new ArrayList<String>();
        for (int i = 117; i < 127; i++)
            parent6.add(aa[i]);

        List<String> parent7 = new ArrayList<String>();

        for (int i = 127; i < 196; i++)
            parent7.add(aa[i]);

        List<String> parent8 = new ArrayList<String>();
        for (int i = 196; i < 199; i++)
            parent8.add(aa[i]);

        List<String> parent9 = new ArrayList<String>();
        for (int i = 199; i < 213; i++)
            parent9.add(aa[i]);

        List<String> parent10 = new ArrayList<String>();
        for (int i = 213; i < 224; i++)
            parent10.add(aa[i]);

        List<String> parent11 = new ArrayList<String>();
        for (int i = 224; i < 244; i++)
            parent11.add(aa[i]);

        List<String> parent12 = new ArrayList<String>();
        for (int i = 244; i < 256; i++)
            parent12.add(aa[i]);


        List<String> parent13 = new ArrayList<String>();
        for (int i = 256; i < 260; i++)
            parent13.add(aa[i]);

        List<String> parent14 = new ArrayList<String>();
        for (int i = 260; i < 264; i++)
            parent14.add(aa[i]);

        List<String> parent15 = new ArrayList<String>();
        for (int i = 264; i < 281; i++)
            parent15.add(aa[i]);

        List<String> parent16 = new ArrayList<String>();
        for (int i = 281; i < 332; i++)
            parent16.add(aa[i]);

        List<String> parent17 = new ArrayList<String>();
        for (int i = 332; i < 335; i++)
            parent17.add(aa[i]);
//here
        List<String> parent18 = new ArrayList<String>();
        for (int i = 335; i < 355; i++)
            parent18.add(aa[i]);

        List<String> parent19 = new ArrayList<String>();

        for (int i = 355; i < 368; i++)
            parent19.add(aa[i]);

        List<String> parent20 = new ArrayList<String>();
        for (int i = 368; i < 392; i++)
            parent20.add(aa[i]);

        List<String> parent21 = new ArrayList<String>();
        for (int i = 392; i < 401; i++)
            parent21.add(aa[i]);

        List<String> parent22 = new ArrayList<String>();
        for (int i = 401; i < 428; i++)
            parent22.add(aa[i]);

        List<String> parent23 = new ArrayList<String>();
        for (int i = 428; i < 437; i++)
            parent23.add(aa[i]);

        List<String> parent24 = new ArrayList<String>();
        for (int i = 437; i < 439; i++)
            parent24.add(aa[i]);

        List<String> parent25 = new ArrayList<String>();
        for (int i = 439; i < 447; i++)
            parent25.add(aa[i]);

        List<String> parent26 = new ArrayList<String>();
        for (int i = 447; i < 460; i++)
            parent26.add(aa[i]);
        List<String> parent27 = new ArrayList<String>();
        for (int i = 460; i < 488; i++)
            parent27.add(aa[i]);
        List<String> parent28 = new ArrayList<String>();
        for (int i = 488; i < 525; i++)
            parent28.add(aa[i]);
        List<String> parent29 = new ArrayList<String>();
        for (int i = 525; i < 530; i++)
            parent29.add(aa[i]);
        List<String> parent30 = new ArrayList<String>();
        for (int i = 530; i < 542; i++)
            parent30.add(aa[i]);
        List<String> parent31 = new ArrayList<String>();
        for (int i = 542; i < 548; i++)
            parent31.add(aa[i]);
        List<String> parent32 = new ArrayList<String>();
        for (int i = 548; i < 564; i++)
            parent32.add(aa[i]);
        List<String> parent33 = new ArrayList<String>();
        for (int i = 564; i < 577; i++)
            parent33.add(aa[i]);
        List<String> parent34 = new ArrayList<String>();
        for (int i = 577; i < 588; i++)
            parent34.add(aa[i]);
        List<String> parent35 = new ArrayList<String>();
        for (int i = 588; i < 601; i++)
            parent35.add(aa[i]);
        List<String> parent36 = new ArrayList<String>();
        for (int i = 601; i < 634; i++)
            parent36.add(aa[i]);
        List<String> parent37 = new ArrayList<String>();
        for (int i = 634; i < 653; i++)
            parent37.add(aa[i]);
        List<String> parent38 = new ArrayList<String>();
        for (int i = 653; i < 664; i++)
            parent38.add(aa[i]);
        List<String> parent39 = new ArrayList<String>();
        for (int i = 664; i < 675; i++)
            parent39.add(aa[i]);

        List<String> parent40 = new ArrayList<String>();
        for (int i = 675; i < 697; i++)
            parent40.add(aa[i]);
        List<String> parent41 = new ArrayList<String>();
        for (int i = 697; i < 704; i++)
            parent41.add(aa[i]);
        List<String> parent42 = new ArrayList<String>();
        for (int i = 704; i < 712; i++)
            parent42.add(aa[i]);
        List<String> parent43 = new ArrayList<String>();
        for (int i = 712; i < 714; i++)
            parent43.add(aa[i]);
        List<String> parent44 = new ArrayList<String>();
        for (int i = 714; i < 741; i++)
            parent44.add(aa[i]);
        List<String> parent45 = new ArrayList<String>();
        for (int i = 741; i < 746; i++)
            parent45.add(aa[i]);
        List<String> parent46 = new ArrayList<String>();
        for (int i = 746; i < 750; i++)
            parent46.add(aa[i]);
        List<String> parent47 = new ArrayList<String>();
        for (int i = 750; i < 753; i++)
            parent47.add(aa[i]);
        List<String> parent48 = new ArrayList<String>();
        for (int i = 753; i < 779; i++)
            parent48.add(aa[i]);
        List<String> parent49 = new ArrayList<String>();
        for (int i = 779; i < 783; i++)
            parent49.add(aa[i]);
        List<String> parent50 = new ArrayList<String>();
        for (int i = 783; i < 801; i++)
            parent50.add(aa[i]);
        List<String> parent51 = new ArrayList<String>();
        for (int i = 801; i < 821; i++)
            parent51.add(aa[i]);
        List<String> parent52 = new ArrayList<String>();
        for (int i = 821; i < 826; i++)
            parent52.add(aa[i]);
        List<String> parent53 = new ArrayList<String>();
        for (int i = 826; i < 835; i++)
            parent53.add(aa[i]);
        List<String> parent54 = new ArrayList<String>();
        for (int i = 835; i < 920; i++)
            parent54.add(aa[i]);
//        List<String> parent55 = new ArrayList<String>();
//        for (int i = 920; i < 920; i++)
//            parent55.add(aa[i]);
////
////
//---------------------------
        childContent.put(parent.get(0), parent1);
        childContent.put(parent.get(1), parent2);
        childContent.put(parent.get(2), parent3);
        childContent.put(parent.get(3), parent4);
        childContent.put(parent.get(4), parent5);
        childContent.put(parent.get(5), parent6);
        childContent.put(parent.get(6), parent7);
        childContent.put(parent.get(7), parent8);
        childContent.put(parent.get(8), parent9);
        childContent.put(parent.get(9), parent10);
        childContent.put(parent.get(10), parent11);
        childContent.put(parent.get(11), parent12);
        childContent.put(parent.get(12), parent13);
        childContent.put(parent.get(13), parent14);
        childContent.put(parent.get(14), parent15);
        childContent.put(parent.get(15), parent16);
        childContent.put(parent.get(16), parent17);
        childContent.put(parent.get(17), parent18);

        childContent.put(parent.get(18), parent19);
        childContent.put(parent.get(19), parent20);
        childContent.put(parent.get(20), parent21);
        childContent.put(parent.get(21), parent22);
        childContent.put(parent.get(22), parent23);
        childContent.put(parent.get(23), parent24);
        childContent.put(parent.get(24), parent25);
        childContent.put(parent.get(25), parent26);
        childContent.put(parent.get(26), parent27);
        childContent.put(parent.get(27), parent28);
        childContent.put(parent.get(28), parent29);
        childContent.put(parent.get(29), parent30);
        childContent.put(parent.get(30), parent31);
        childContent.put(parent.get(31), parent32);
        childContent.put(parent.get(32), parent33);
        childContent.put(parent.get(33), parent34);
        childContent.put(parent.get(34), parent35);
        childContent.put(parent.get(35), parent36);

        childContent.put(parent.get(36), parent37);
        childContent.put(parent.get(37), parent38);
        childContent.put(parent.get(38), parent39);
        childContent.put(parent.get(39), parent40);
        childContent.put(parent.get(40), parent41);
        childContent.put(parent.get(41), parent42);
        childContent.put(parent.get(42), parent43);
        childContent.put(parent.get(43), parent44);
        childContent.put(parent.get(44), parent45);
        childContent.put(parent.get(45), parent46);
        childContent.put(parent.get(46), parent47);
        childContent.put(parent.get(47), parent48);
        childContent.put(parent.get(48), parent49);
        childContent.put(parent.get(49), parent50);
        childContent.put(parent.get(50), parent51);
        childContent.put(parent.get(51), parent52);
        childContent.put(parent.get(52), parent53);
        childContent.put(parent.get(53), parent54);
        childContent.put(parent.get(53), parent54);
       // childContent.put(parent.get(54), parent55);
        ///----------------------

        //childContent.put(parent.get(54), parent55);

        return childContent;


        // return convertView;


//        return null;
//    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu_main, menu);
//       // getMenuInflater().inflate(R.menu.menu_main, menu);
//        this.menu = menu;
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings) {
//            Intent intent = new Intent(Category.this, SettingsActivity2.class);
//            startActivity(intent);
//            return true;
//        }
//        if (id == R.id.action_search) {
//
//
//
//
//            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
//            startActivity(intent);
//            return true;
//
//
//        }
//        if (id == R.id.action_about) {
//            new AlertDialog.Builder(this).setIcon(R.mipmap.sut)
//                    .setTitle("K & S 1.2")
//                    .setMessage("Base on CHERUBIM & SERAPHIM CHURCH HYMM BOOK " +"\n" +
//                            "Fourth Edition." + "\n\n" +
//                            " Please forward any feedback to " + "\n" +
//                            "adeoy3@gmail.com"+"\n\n"+
//                            "Your suggestion as regards what should be added to make the " +
//                            "app great will be appreciated"+"\n\n"                            +
//                            "Developer: ForestBaba"
//                    )
//                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                            // continue with delete
//                        }
//                    })
//                    .show();
//            return true;
//
//
//        }
//
//        if (id == android.R.id.home) {
//
//            return true;
//        }
//
//
//        return super.onOptionsItemSelected(item);
//    }
    }
}