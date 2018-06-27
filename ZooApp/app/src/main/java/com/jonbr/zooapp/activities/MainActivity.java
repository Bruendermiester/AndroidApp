package com.jonbr.zooapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jonbr.zooapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    private AdView mAdView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//
//        mAdView2 = findViewById(R.id.adView2);
//        AdRequest adRequest2 = new AdRequest.Builder().build();
//        mAdView2.loadAd(adRequest2);
    }


    public class Quiz {


    }

    class Converter {


        String reader = "{ \"quiz\":{ \"content\":{ \"outcomes\":{ }, \"questions\":{ \"answer\":\"The Lion King was originally titled, The King of the Jungle, but Disney renamed it when they realized that Lion's don't live in the Jungle. Disney originally wanted Sean Connery to be the voice of Mufasa and wanted the voices of the hyenas to be Cheech and Chong.\", \"hint\":\"The circle of life\", \"image\":{ \"url\":\"https://cdn.now.howstuffworks.com/media-content/a76bc78b-4458-4487-9583-2f0332b3a417-640-360.jpg\" }, \"index\":0, \"options\":[ { \"answer\":\"Oliver and Company\" },{ \"answer\":\"The Lion King\", \"points\":1 }, { \"answer\":\"The Three Caballeros\" }, { \"answer\":\"Make Mine Music\" } ], \"question\":\"Which movie title correlates to this scene?\" } } } }\"";

        {
            try {
                JSONObject  REPONSE_JSON_OBJECT = new JSONObject (reader);
                JSONObject test = new JSONObject();
                test = REPONSE_JSON_OBJECT.getJSONObject("quiz")
                        .getJSONObject("content")
                        .getJSONObject("questions");
                Log.i("test", "testing");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    Converter testingConverter = new Converter();

}


