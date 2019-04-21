package com.example.final_project;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final Button[] buttons = {
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
    };

    private final String[][] answers = {{"A"}, {"B"}, {"C"}, {"D"}, {"A"}};
    private final String[][] choices = {
            {"A", "B", "C", "D"},
            {"A", "B", "C", "D"},
            {"A", "B", "C", "D"},
            {"A", "B", "C", "D"},
            {"A", "B", "C", "D"}
    };
    private static final int[] imageIDs = {
            R.drawable.a,
            R.drawable.abc,
            R.drawable.pic1,
            R.drawable.abcd,
            R.drawable.cs125
    };
    boolean hasStarted = false;
    boolean hasEnded = false;
    private static int score = 0;
    private static int questionNo = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //when we move to the next question, showPicture is called again to show another new picture
    public void showPicture(int questionNo) {
        ImageView toShow = findViewById(R.id.imageView);
        toShow.setImageResource(imageIDs[questionNo]);
    }

    public void showChoices(int questionNo) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText(choices[questionNo][i]);
        }
    }
    //when button is clicked, call checkAnswer
    public void buttonOnClick(View v) {
        Button button = (Button) v;
        int num = 0;
        for (int i = 0; i < buttons.length; i++) {
            if (button.equals(buttons[i])) {
                num = i;
            }
        }
        if (choices[questionNo][num].equals(answers[questionNo])) {
            buttons[num].setBackgroundColor(Color.GREEN);
            score++;
            questionNo++;
            Toast.makeText(this,"RIGHT!",Toast.LENGTH_SHORT);
            nextQuestion(questionNo);
        } else {
            buttons[num].setBackgroundColor(Color.RED);
            score--;
            questionNo++;
            Toast.makeText(this,"WRONG!",Toast.LENGTH_SHORT);
            nextQuestion(questionNo);
        }
    }

    public void nextQuestion(int questionNo) {
        if (questionNo >= imageIDs.length) {
            endGame();
        }
        showPicture(questionNo);
        showChoices(questionNo);
    }

    public void endGame() {
        String finalScore = Integer.toString(getScore());
        Toast.makeText(this,"CONGRATS! You Got " + finalScore,Toast.LENGTH_LONG);
    }
    public int getScore() { return score; }
}
