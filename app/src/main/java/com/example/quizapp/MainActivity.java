package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questiontv,attemptedtv;
    private Button opt1,opt2,opt3,opt4;
    private ArrayList<Quiz> questionsandanswerlist;
    Random random;
    int currentscore=0,questionattempted=1,currnentpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questiontv = findViewById(R.id.idquetions);
        attemptedtv = findViewById(R.id.idAttempted);
        opt1 = findViewById(R.id.idoption1);
        opt2 = findViewById(R.id.idoption2);
        opt3 = findViewById(R.id.idoption3);
        opt4 = findViewById(R.id.idoption4);
        questionsandanswerlist = new ArrayList<Quiz>();
        random = new Random();

        setQuestionsforquiz(questionsandanswerlist);
        currnentpos =random.nextInt(questionsandanswerlist.size());
        datatoview(currnentpos);

        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionsandanswerlist.get(currnentpos).getAnswer().trim().toLowerCase().equals(opt1.getText().toString().trim().toLowerCase())){
                    currentscore++;
                }
                questionattempted++;
                currnentpos = random.nextInt(questionsandanswerlist.size());
                datatoview(currnentpos);

            }
        });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionsandanswerlist.get(currnentpos).getAnswer().trim().toLowerCase().equals(opt2.getText().toString().trim().toLowerCase())){
                    currentscore++;
                }
                questionattempted++;
                currnentpos = random.nextInt(questionsandanswerlist.size());
                datatoview(currnentpos);
            }
        });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionsandanswerlist.get(currnentpos).getAnswer().trim().toLowerCase().equals(opt3.getText().toString().trim().toLowerCase())){
                    currentscore++;
                }
                questionattempted++;
                currnentpos = random.nextInt(questionsandanswerlist.size());
                datatoview(currnentpos);
            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionsandanswerlist.get(currnentpos).getAnswer().trim().toLowerCase().equals(opt4.getText().toString().trim().toLowerCase())){
                    currentscore++;
                }
                questionattempted++;
                currnentpos = random.nextInt(questionsandanswerlist.size());
                datatoview(currnentpos);
            }
        });


    }
    private void finalresult(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.final_result,(LinearLayout)findViewById(R.id.idLinearLayout));
        TextView scoretv = bottomSheetView.findViewById(R.id.idscore);
        Button restart = bottomSheetView.findViewById(R.id.idrestart);
        scoretv.setText("Your score is :\n"+currentscore+"/10");
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currnentpos = random.nextInt(questionsandanswerlist.size());
                datatoview(currnentpos);
                questionattempted = 1;
                currentscore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }




    private void datatoview(int currnentpos){

        attemptedtv.setText("Questions attempted"+questionattempted+"/10");
        if(questionattempted==10){
            finalresult();
        }
        else {
            questiontv.setText(questionsandanswerlist.get(currnentpos).getQuestions());
            opt1.setText(questionsandanswerlist.get(currnentpos).getOption1());
            opt2.setText(questionsandanswerlist.get(currnentpos).getOption2());
            opt3.setText(questionsandanswerlist.get(currnentpos).getOption3());
            opt4.setText(questionsandanswerlist.get(currnentpos).getOption4());
        }





    }
    private void setQuestionsforquiz(ArrayList<Quiz> questionsandanswerlist) {

        questionsandanswerlist.add(new Quiz("Which language is used to create android application?","Kotlin", "java", "Both java and kotlin", "None of the above", "Both java and kotlin"));
        questionsandanswerlist.add(new Quiz("What is android?","Android is a stack of software's for mobility", "Google mobile device name", "Virtual machine", "None of the above", "Android is a stack of software's for mobility"));
        questionsandanswerlist.add(new Quiz("What is an activity in Android?","Activity performs the actions on the screen", "Manage the Application content", "Screen UI", "None of the above", "Activity performs the actions on the screen"));
        questionsandanswerlist.add(new Quiz("Is it possible to have an activity without UI to perform action/actions?","Not possible", "Wrong question", "Yes, it is possible", "None of the above", "Yes, it is possible"));
        questionsandanswerlist.add(new Quiz("How to get a response from an activity in Android?","startActivityToResult", "startActiivtyForResult", "Bundle", "None of the above", "startActiivtyForResult"));
        questionsandanswerlist.add(new Quiz("How to pass the data between activities in Android?","Intent", "Content Provider", "Broadcast receiver", "None of the above", "Intent"));
        questionsandanswerlist.add(new Quiz("What is Manifest.xml in android?","It has information about layout in an application", "It has the information about activities in an application", "It has all the information about an application", "None of the above", "It has all the information about an application"));
        questionsandanswerlist.add(new Quiz("What are the layouts available in android?","Linear Layout", "Table Layout", "Relative Layout", "All of the above", "All of the above"));
        questionsandanswerlist.add(new Quiz("How many sizes are supported by Android?","Android supported all sizes", "Android does not support all sizes", "Android supports small,normal, large and extra-large sizes", "Size is undefined in android", "Android supports small,normal, large and extra-large sizes"));
        questionsandanswerlist.add(new Quiz("Can a user save all database updates in onStop?","Yes, a user can save all database updates in onStop", "No, a user can save in onSavedInstance", "No, a user can save in a Bundle", "No, In some situations, a user can't reach onStop", "No, In some situations, a user can't reach onStop"));

    }
}