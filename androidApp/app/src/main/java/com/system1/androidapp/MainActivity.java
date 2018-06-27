package com.system1.androidapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private AdView myAdView;
    private AdView myAdView2;
    private DatabaseReference mDatabase;
    private DatabaseReference dbRef;

    public class Quiz {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mDatabase = FirebaseDatabase.getInstance().getReference();
        dbRef = mDatabase.child("quizes/");


        dbRef.child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            Quiz quiz = new Quiz();
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                quiz = dataSnapshot.getValue(Quiz.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");


        myAdView = findViewById(R.id.myAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        myAdView.loadAd(adRequest);

        myAdView2 = findViewById(R.id.myAdView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        myAdView2.loadAd(adRequest2);

    }



}
