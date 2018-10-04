package com.github.borderlander103.higherorlower;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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

        if(mGuessString != null && !mGuessString.isEmpty()) {

            int mGuessInt = Integer.parseInt(mGuessString);

            Log.i("Value", Integer.toString(mGuessInt));

            String message ="";

            if (mGuessInt > mRandom) {
                message = "Lower";
            } else if (mGuessInt < mRandom) {
                message = "Higher";
            } else {
//                message = "Just Right";
                showDialog();
                mGuessView.setText("");
                randomNumber();
            }

            if (!message.isEmpty()) {Toast.makeText(this, message, Toast.LENGTH_SHORT).show(); }
        }

    }

    public void showDialog() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("You guessed right! \n\nHave another go.");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        alert.create().show();
    }

}
