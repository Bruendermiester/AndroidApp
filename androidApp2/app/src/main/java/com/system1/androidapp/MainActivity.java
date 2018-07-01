package com.system1.androidapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AdView myAdView;
    private AdView myAdView2;

    public class Quiz {

        private String title;
        private String description;
        private String type;
        private String url;

        public ArrayList<Questions> questions;

        public ArrayList<Questions> getQuestions() {
            return questions;
        }

        public void setQuestions(ArrayList<Questions> questions) {
            this.questions = questions;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Quiz () {

        }

    }

    public class Questions implements Serializable {

        private Integer index;
        private String hint;
        private String question;
        private String answer;
        public ArrayList<Options> options;

        public ArrayList<Options> getOptions() {
            return options;
        }

        public void setOptions(ArrayList<Options> options) {
            this.options = options;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public Questions() {

        }

    }

    public class Options implements Serializable {

        private String answer;
        private Integer points;

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public Integer getPoints() {
            return points;
        }

        public void setPoints(Integer points) {
            this.points = points;
        }



        public Options() {

        }

    }


    public List<Quiz> loadJSonFromAsset() {
        List<Quiz> quizList = new LinkedList<>();

        try {
            InputStream is = getAssets().open("quizzes.json");
            JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));

            reader.beginArray();

            Gson gson = new GsonBuilder().create();

            while (reader.hasNext()) {
                Quiz quizJson = gson.fromJson(reader, Quiz.class);
                Quiz quiz = new Quiz();
                quiz.setTitle(quizJson.getTitle());
                quiz.setDescription(quizJson.getDescription());
                quiz.setType(quizJson.getType());
                quiz.setUrl(quizJson.getUrl());
                quiz.setQuestions(quizJson.getQuestions());
                quizList.add(quiz);
            }

            reader.close();
        }catch(UnsupportedEncodingException ex){

        }catch (IOException ex) {

        }
        return quizList;
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");

        List<Quiz> quizList = new LinkedList<>();

        quizList = loadJSonFromAsset();

        myAdView = findViewById(R.id.myAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        myAdView.loadAd(adRequest);

        myAdView2 = findViewById(R.id.myAdView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        myAdView2.loadAd(adRequest2);

    }




}
