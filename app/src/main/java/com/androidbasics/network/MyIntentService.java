package com.androidbasics.network;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.androidbasics.model.CityItem;
import com.androidbasics.utils.HttpHelper;
import com.google.gson.Gson;

import java.io.IOException;

//          Create Intent Service for Network Request
//          Download JSON on Android with GET Request from Internet
//          Create POJO/Java Model Class from JSON


public class MyIntentService extends IntentService {
    public static final String SERVICE_PAYLOAD = "service_payload";
    public static final String SERVICE_MESSAGE = "service_message";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Uri uri = intent.getData();
        String data;
        try {
            data = HttpHelper.downloadUrl(uri.toString());
        } catch (IOException e) {
            e.printStackTrace();
//            data = e.getMessage();
            return;
        }
//       Convert JSON into POJO/Java Objects using GSON Library
        Gson gson = new Gson();
        CityItem[] cityItems = gson.fromJson(data, CityItem[].class);
        sendMessageToUi(cityItems);
    }

    private void sendMessageToUi(CityItem[] data) {
        Intent intent = new Intent(SERVICE_MESSAGE);                            //  SERVICE_MESSAGE is intent filter used to filter the service intent for Local broadcast receiver
        intent.putExtra(SERVICE_PAYLOAD, data);                                   //  SERVICE_PAYLOAD is intent extra key used for getting data from the intent
        LocalBroadcastManager.getInstance(this)
                .sendBroadcast(intent);
    }
}