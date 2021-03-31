package com.androidbasics.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.androidbasics.MainActivity;

//  Create & Run Intent Service It Helps To Simplify Started Service Intent Functionality(it create handler, thread , handleMessage StopSelf,etc Implicitly),Only One Thread Is Allocate To Process
//  Implement Lifecycle of  a IntentService
public class MyIntentService extends IntentService {

    private static final String TAG = "MyTag";

    public MyIntentService() {
        super("MyIntentService");
        setIntentRedelivery(true);  //START_REDELIVER_INTENT if True Otherwise START_STICKY

        Log.d(TAG,"MyIntentService Constructor : MyIntentService" );
        Log.d(TAG,"MyIntentService  Constructor : Thread Name : "+ Thread.currentThread().getName() );
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate : MyIntentService" );
        Log.d(TAG,"onCreate : Thread Name : "+ Thread.currentThread().getName() );
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String songName=intent.getStringExtra(MainActivity.MESSAGE_KEY);
        downloadSong(songName);

        Log.d(TAG,"onHandleIntent : MyIntentService" );
        Log.d(TAG,"onHandleIntent : Thread Name : "+ Thread.currentThread().getName() );
    }

    private void downloadSong(String song) {
        Log.d(TAG, "downloadSong : " + song + " Download Started...");
        Log.d(TAG,"downloadSong : Thread Name : "+ Thread.currentThread().getName() );


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "downloadSong : " + song + " Download Finished ");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy : MyIntentService" );
        Log.d(TAG,"onDestroy : Thread Name : "+ Thread.currentThread().getName() );
    }
}