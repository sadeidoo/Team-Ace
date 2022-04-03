package com.example.guessthatnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.content.res.Resources;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class PlayGame extends AppCompatActivity {
    MediaPlayer music;
    MediaPlayer victoryMusic;

    //new variables:
    Context context;
    Resources resources;
    int lang_selected;
    TextView enterYourNumber, chancesRemaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        getSupportActionBar().setTitle("Hot & Cold");
        music = MediaPlayer.create(PlayGame.this, R.raw.thecradleofyoursoul);
        victoryMusic = MediaPlayer.create(PlayGame.this, R.raw.audiencecheeringandclapping);
        music.setLooping(true);
        music.start();
        FloatingActionButton floatingActionButton = findViewById(R.id.playGameBack);
        final TextView heightLabel = (TextView) findViewById(R.id.heightLabel);
        final TextView guessText = (TextView) findViewById(R.id.guessText);
        TextView userGuess = (TextView) findViewById(R.id.userGuess);
        Button pushMe = (Button) findViewById(R.id.button3);
//        enterYourNumber = (TextView)findViewById(R.id.heightLabel);
//        chancesRemaining = (TextView)findViewById(R.id.chancesRemaining);
        TextView settings = (TextView)findViewById(R.id.Settings); //Setting text

//        if (settings.getText().equals("Settings")) { //if Settings text is in English, set all strings in PlayGame view to English
//            context = LocaleHelper.setLocale(PlayGame.this,"en"); //ensures English strings are used
//            resources = context.getResources();
//            lang_selected = 0;
//            //strings that change: enter your number, chances remaining
//            enterYourNumber.setText(resources.getString(R.string.enter_your_number));
//            chancesRemaining.setText(resources.getString(R.string.chances_remaining));
//
//
//        }else if(settings.getText().equals("Réglages")){ //if Settings text is in French, set all strings in PlayGame view to French
//            context = LocaleHelper.setLocale(PlayGame.this,"fr"); //ensures French strings are used
//            resources =context.getResources();
//            lang_selected = 1;
//            enterYourNumber.setText(resources.getString(R.string.enter_your_number));
//            chancesRemaining.setText(resources.getString(R.string.chances_remaining));
//        }
//        else if(settings.getText().equals("Ajustes")){ //if Settings text is in Spanish, set all strings in PlayGame view to Spanish
//            context = LocaleHelper.setLocale(PlayGame.this,"es"); //ensures Spanish strings are used
//            resources =context.getResources();
//            lang_selected = 2;
//            enterYourNumber.setText(resources.getString(R.string.enter_your_number));
//            chancesRemaining.setText(resources.getString(R.string.chances_remaining));
//        }

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });

        pushMe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Random randGen = new Random();
                int rando = randGen.nextInt(30) + 1;
                int userNumber = Integer.parseInt(userGuess.getText().toString());
                int x = rando;
                if (userNumber < 1 || userNumber > 30) {
                    heightLabel.setText("Please guess a number between 1 & 30");
                } else if (userNumber == x) {
                    victoryMusic.start();
                    heightLabel.setText("You Got It Right!");
                    try
                    {
                        Thread.sleep(5000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    Intent myInt = new Intent(getApplicationContext(), Gamemodes.class);
                    startActivity(myInt);
                } else if ((x - userNumber) < 5){
                    heightLabel.setText("You're Closer");
                } else {
                    heightLabel.setText("You're Far");
                }
                guessText.setText("");



            }


        });


    }

    public void goBack() {
        Intent intent = new Intent(this, Gamemodes.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        music.release();
        finish();
    }


}