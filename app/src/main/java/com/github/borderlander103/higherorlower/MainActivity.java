package com.github.borderlander103.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumber();
    }

    public void randomNumber() {
        Random r = new Random();
        mRandom = r.nextInt(20) + 1;
    }

    public void guessButton(View view) {

        Log.i("Value", Integer.toString(mRandom));

        EditText mGuessView = findViewById(R.id.numberEditText);

        String mGuessString = mGuessView.getText().toString();

        int mGuessInt = Integer.parseInt(mGuessString);

        Log.i("Value", Integer.toString(mGuessInt));

        String message;

        if (mGuessInt > mRandom) {
            message = "Lower";
        } else if (mGuessInt < mRandom){
            message = "Higher";
        } else {
            message = "Just Right";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

}
