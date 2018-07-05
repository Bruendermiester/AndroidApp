package com.system1.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

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

    List<Quiz> quizList = new LinkedList<>();
    Quiz currentQuiz;
    List<Outcomes> currentOutcomeList = new LinkedList<>();

    private int correctAnswers = 0;
    public static Integer questionNumber = 0;

    public class Quiz {

        private String title;
        private String description;
        private String type;
        private String url;

        public ArrayList<Questions> questions;
        public ArrayList<Outcomes> outcomes;

        public ArrayList<Outcomes> getOutcomes() {
            return outcomes;
        }

        public void setOutcomes(ArrayList<Outcomes> outcomes) {
            this.outcomes = outcomes;
        }

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

        public Quiz() {

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

    public class Outcomes implements Serializable {

        private String description;
        private String imageId;
        private String title;
        private int count;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImageId() {
            return imageId;
        }

        public void setImageId(String imageId) {
            this.imageId = imageId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Outcomes() {

        }

        public Outcomes(Quiz quiz, int index) {
            count = 0;
            this.description = quiz.outcomes.get(index).getDescription();
            this.title = quiz.outcomes.get(index).getTitle();
            this.imageId = quiz.outcomes.get(index).getImageId();
        }

    }

    public class Options implements Serializable {

        private String answer;
        private Integer points;
        private String personalityMatch;

        public String getPersonalityMatch() {
            return personalityMatch;
        }

        public void setPersonalityMatch(String personalityMatch) {
            this.personalityMatch = personalityMatch;
        }

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
                quiz.setOutcomes(quizJson.getOutcomes());
                quizList.add(quiz);
            }

            reader.close();
        } catch (UnsupportedEncodingException ex) {

        } catch (IOException ex) {

        }
        return quizList;
    }

    public void quizSetup() {
        int countId = 0;
        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView textQuestion = new TextView(this);
        textQuestion.setText((questionNumber+1) + ": " + currentQuiz.questions
                .get(questionNumber).question);
        textQuestion.setWidth(250);
        textQuestion.setHeight(250);
        textQuestion.setGravity(Gravity.CENTER);
        linearLayout.addView(textQuestion);

        for(int i = 0; i < currentQuiz.questions.get(questionNumber).options.size(); i++ )
        {
            TextView textView = new TextView(this);
            textView.setText((i+1) + ": " + currentQuiz.questions
                    .get(questionNumber).options.get(i).answer);
            textView.setWidth(250);
            textView.setHeight(100);
            textView.setId(countId);
            countId ++;
            textView.setGravity(Gravity.START);
            textView.setPadding(30,0,0,0);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int i = 0; i < currentQuiz.questions.get(questionNumber).options.size(); i++) {

                        TextView currentView = findViewById(i);
                        if(currentQuiz.getType().toLowerCase().equals("knowledge") ||
                                currentQuiz.getType().toLowerCase().equals("screenshot")) {
                            if (view == currentView && currentQuiz.questions.get(questionNumber).options.get(i).points == 1) {
                                correctAnswers++;
                            }
                        }
                        else {
                            if (view == currentView) {
                                for(int x = 0; x < currentOutcomeList.size(); x++) {
                                    if(currentQuiz.outcomes.get(x).title.equals(currentQuiz.questions.get(questionNumber).options.get(i).personalityMatch)) {
                                        currentOutcomeList.get(x).count++;
                                    }
                                }
                               // currentQuiz.questions.get(questionNumber).options.get(i).personalityMatch;
                            }
                        }
                    }

                    questionNumber++;
                    reCreate(view);
                }
            });

            linearLayout.addView(textView);
        }
    }

    public void reCreate(View view) {

        int quizLength = currentQuiz.questions.size();

        // Remove current question views
        ViewGroup r = (ViewGroup) view.getParent().getParent();
        r.removeAllViews();

        if(questionNumber.equals(quizLength)) {
            displayResult(quizLength);
        }
        else {
            quizSetup();
        }
    }

    public void displayResult(int quizLength) {

        if(currentQuiz.getType().equals("personality")) {

            LinearLayout linearLayout = new LinearLayout(this);
            setContentView(linearLayout);
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            TextView textView = new TextView(this);
            textView.setText("Congradulations you wasted your time");
            textView.setWidth(250);
            textView.setHeight(350);
            textView.setGravity(Gravity.CENTER);
            linearLayout.addView(textView);

            TextView textView2 = new TextView(this);
            textView2.setText(getPersonalityOutcomeResult());
            textView2.setWidth(250);
            textView2.setHeight(100);
            textView2.setGravity(Gravity.CENTER);
            linearLayout.addView(textView2);

            Button button = new Button(this);
            button.setText("Start over??");
            button.setWidth(75);
            button.setHeight(40);
            button.setGravity(Gravity.CENTER);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    questionNumber = 0;
                    correctAnswers = 0;
                    reCreate(view);
                }
            });
            linearLayout.addView(button);

            Button button2 = new Button(this);
            button2.setText("Home");
            button2.setWidth(75);
            button2.setHeight(40);
            button2.setGravity(Gravity.CENTER);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    questionNumber = 0;
                    correctAnswers = 0;
                    ViewGroup r = (ViewGroup) view.getParent().getParent();
                    r.removeAllViews();
                    setupHomePage();
                }
            });
            linearLayout.addView(button2);

        }
        else {
            LinearLayout linearLayout = new LinearLayout(this);
            setContentView(linearLayout);
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            TextView textView = new TextView(this);
            textView.setText("Congradulations you wasted your time");
            textView.setWidth(250);
            textView.setHeight(350);
            textView.setGravity(Gravity.CENTER);
            linearLayout.addView(textView);

            TextView textView2 = new TextView(this);
            textView2.setText(correctAnswers + " / " + quizLength);
            textView2.setWidth(250);
            textView2.setHeight(100);
            textView2.setGravity(Gravity.CENTER);
            linearLayout.addView(textView2);

            Button button = new Button(this);
            button.setText("Start over??");
            button.setWidth(75);
            button.setHeight(40);
            button.setGravity(Gravity.CENTER);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    questionNumber = 0;
                    correctAnswers = 0;
                    reCreate(view);
                }
            });
            linearLayout.addView(button);

            Button button2 = new Button(this);
            button2.setText("Home");
            button2.setWidth(75);
            button2.setHeight(40);
            button2.setGravity(Gravity.CENTER);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    questionNumber = 0;
                    correctAnswers = 0;
                    ViewGroup r = (ViewGroup) view.getParent().getParent();
                    r.removeAllViews();
                    setupHomePage();
                }
            });
            linearLayout.addView(button2);
        }

    }

    public String getPersonalityOutcomeResult() {
        String result = "";
        int currentCount = 0;

        for(int i = 0; i < currentOutcomeList.size(); i++) {
            if(currentCount <= currentOutcomeList.get(i).count) {
                currentCount = currentOutcomeList.get(i).count;
                result = currentOutcomeList.get(i).title;
            }
        }

        return result;
    }

    public void setupHomePage() {

        int countId = 0;
        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        for(int i = 0; i < quizList.size(); i++) {
            TextView textView = new TextView(this);
            textView.setText(quizList.get(i).title);
            textView.setWidth(250);
            textView.setHeight(200);
            textView.setId(countId);
            countId ++;
            textView.setGravity(Gravity.START);
            textView.setPadding(30,0,0,0);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    for(int i = 0; i < quizList.size(); i++) {
                        TextView currentView = findViewById(i);
                        if (view == currentView) {

                            currentQuiz = quizList.get(i);

                            // Set up personality outcome object for displaying result
                            if(currentQuiz.getType().toLowerCase().equals("personality")) {
                                for(int x = 0; x < currentQuiz.outcomes.size(); x++ ) {
                                    Outcomes outcome = new Outcomes(currentQuiz, x);
                                    currentOutcomeList.add(outcome);
                                }
                            }

                            quizSetup();

                        }
                    }
                }
            });

            linearLayout.addView(textView);

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");

        quizList = loadJSonFromAsset();

        setupHomePage();

//        myAdView = findViewById(R.id.myAdView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        myAdView.loadAd(adRequest);
//
//        myAdView2 = findViewById(R.id.myAdView2);
//        AdRequest adRequest2 = new AdRequest.Builder().build();
//        myAdView2.loadAd(adRequest2);

    }

}
