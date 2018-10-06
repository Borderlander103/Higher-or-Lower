package com.github.borderlander103.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int mRandom;
    private TextView lowerBoundTv;
    private TextView upperBoundTv;
    private TextView justRightTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lowerBoundTv = findViewById(R.id.number_from_tv);
        upperBoundTv = findViewById(R.id.number_to_tv);
        justRightTv = findViewById(R.id.just_right_tv);

        lowerBoundTv.setText(String.valueOf(1));
        upperBoundTv.setText(String.valueOf(20));


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

        if (mGuessInt > mRandom) {
            if (mGuessInt < Integer.parseInt(upperBoundTv.getText().toString()))
                upperBoundTv.setText(String.valueOf(mGuessInt));

        } else if (mGuessInt < mRandom){
            if (mGuessInt > Integer.parseInt(lowerBoundTv.getText().toString()))
                lowerBoundTv.setText(String.valueOf(mGuessInt));
        } else {
            justRightTv.setVisibility(View.VISIBLE);
        }



    }

}
