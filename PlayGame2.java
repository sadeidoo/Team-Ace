package com.example.guessthatnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PlayGame2 extends AppCompatActivity {
    MediaPlayer music;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game2);
        music = MediaPlayer.create(PlayGame2.this, R.raw.thecradleofyoursoul);
        music.setLooping(true);
        music.start();

        final TextView heightLabel = (TextView) findViewById(R.id.heightLabel);
        final TextView guessText = (TextView) findViewById(R.id.guessText);
        TextView userGuess = (TextView) findViewById(R.id.userGuess);
        Button pushMe = (Button) findViewById(R.id.button3);

        pushMe.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Random randGen = new Random();
                int rando = randGen.nextInt(6) + 1;
                int userNumber = Integer.parseInt(userGuess.getText().toString());

                if (userNumber < 1 || userNumber > 30) {
                    heightLabel.setText("Please guess a number between 1 & 6");
                } else if (userNumber == rando) {
                    heightLabel.setText("You Got It Right!");
                }
                    else {
                    heightLabel.setText("Try Again");
                }
                    guessText.setText("");



            }


        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        music.release();
        finish();
    }


}