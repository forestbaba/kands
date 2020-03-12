package com.forestsoftware.kands;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by HP-PC on 12/29/2017.
 */

public class HomeFragment extends AppCompatActivity {
    TextView tv;
    ImageButton zoomin, zoomout, play;
    Handler handler;
    //TextChanger tc = new TextChanger();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        tv = (TextView) findViewById(R.id.scripture_show);
        zoomin = (ImageButton) findViewById(R.id.zoom_in);
        zoomout = (ImageButton)findViewById(R.id.zoom_out);
        play = (ImageButton) findViewById(R.id.play_pause);
        //   RunnableDemo runnableDemo = new RunnableDemo("Show Things",getActivity());
        //   runnableDemo.start();
//        handler = new Handler();
//        tc.setEnabled(true);
        //   doWork();
//        String [] CurrentWebpage = getResources().getStringArray(R.array.quotes)[0];
        //String[] some_array = getResources().getStringArray(R.array.quotes);


       // Log.w("-------qwo------",""+some_array[8]);
       // final TextChanger tc = new TextChanger();
      //  getSupportActionBar().setTitle("Woooo");
//        tc.run();

        zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float size = tv.getTextSize();
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, size + 1);
               // tc.setEnabled(true);
            }
        });
        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float size = tv.getTextSize();
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, size - 1);
            }
        });


    }

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

//    public void doWork() {
//        handler.postDelayed(runnable, 10000);
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                int draw = R.drawable.play;
//                play.setImageResource(draw);
//                handler.removeCallbacks(runnable);
//
//
//            }
//        });
//    }



    public HomeFragment() {

    }

//    public Runnable runnable = new Runnable() {
//        int i = 0;
//        final int[] array = {R.string.text1, R.string.text2, R.string.text3, R.string.text4, R.string.text5};
//        String CurrentWebpage = getResources().getStringArray(R.array.quotes)[0];
//        @Override
//        public void run() {
//            tv.setText(array[i]);
//            i++;
//            if (i == 5)
//                i = 0;
//            tv.postDelayed(this, 100000);
//        }
//    };

//    class TextChanger extends Thread
//    {
//        private volatile boolean enabled = true;
//        private volatile boolean paused = true;
//        int i = 0;
//        final int[] array = {R.string.text1, R.string.text2, R.string.text3, R.string.text4, R.string.text5};
//
//        @Override
//        public void run()
//        {
//            super.run();
//            try {
//                while (enabled)
//                {  //tv.setText(array[i]);
//                    if (!paused)
//                    {
//                     //   tv.setText(array[i]);
//                        Log.wtf("Excuse me people","I am here Now");
//                        i++;
//                    }
//                    Log.wtf("Edakun me people","I am here edakun");
//                    Thread.sleep(5000);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        public void setEnabled(boolean arg)
//        {
//            enabled = arg;
//        }
//        public void setPaused (boolean arg)
//        {
//            paused = arg;
//        }
//
//
//    }


//    class RunnableDemo implements Runnable {
//        public Thread t;
//        private String threadName;
//        boolean suspended = false;
//        Activity activity;
//        final int[] array = {R.string.text1, R.string.text2, R.string.text3, R.string.text4, R.string.text5};
//        int i = 0;
//
//
//
//        RunnableDemo(String name, Activity act) {
//            threadName = name;
//            activity = act;
//            System.out.println("Creating " +  threadName );
//        }

//        @Override
//        public void run() {
//            activity.runOnUiThread(new Runnable() {
//
//                @Override
//                public void run() {
//                    System.out.println("Running " +  threadName );
//
//                    try {
//                        for(int i=0; i < array.length; i++) {
//
//
//
//                            System.out.println("Thread: " + threadName + ", " + i);
//                            tv.setText(array[i]);
//                            i++;
//                            if(i==array.length)
//                            {
//                                i=0;
//                            }
//
//
//
//                            Thread.sleep(5000);
//                            synchronized(this) {
//                                while(suspended)
//                                {
//                                    wait();
//                                }
//                            }
//                        }
//                    } catch (InterruptedException e) {
//                        System.out.println("Thread " +  threadName + " interrupted.");
//                    }
//                    System.out.println("Thread " +  threadName + " exiting.");
//
//                }
//
//            });
//        }

        //   public void run() {
//            System.out.println("Running " +  threadName );
//
//            try {
//                for(int i=0; i < array.length; i++) {
//
//                    System.out.println("Thread: " + threadName + ", " + i);
//                    // Let the thread sleep for a while.
//                    tv.setText(array[i]);
//
//                    Thread.sleep(300);
//                    synchronized(this) {
//                        while(suspended)
//                        {
//                            wait();
//                        }
//                    }
//                }
//            } catch (InterruptedException e) {
//                System.out.println("Thread " +  threadName + " interrupted.");
//            }
//            System.out.println("Thread " +  threadName + " exiting.");
//        }

//        public void start () {
//            System.out.println("Starting " +  threadName );
//            if (t == null) {
//                t = new Thread(this, threadName);
//                t.start ();
//            }
//        }
//
//        void suspend() {
//            suspended = true;
//        }
//
//        synchronized void resume() {
//            suspended = false;
//            notify();
//      //  }
    //}

}

