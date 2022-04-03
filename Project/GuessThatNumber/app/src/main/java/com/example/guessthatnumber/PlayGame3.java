package com.example.guessthatnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;

public class PlayGame3 extends AppCompatActivity {
    MediaPlayer music;
    boolean bool = false;
    private int count= 0;
    private int r1, r2;
    private Object Gamemodes;
    MediaPlayer victoryMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game3);
        getSupportActionBar().setTitle("The Keen Observer");
        music = MediaPlayer.create(PlayGame3.this, R.raw.thecradleofyoursoul);
        victoryMusic = MediaPlayer.create(PlayGame3.this, R.raw.audiencecheeringandclapping);
        music.setLooping(true);
        music.start();
        FloatingActionButton floatingActionButton = findViewById(R.id.playGameBack3);
        try {
            giveNewRandom();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
    }

    private void giveNewRandom() throws InterruptedException {
        if(count == 5){
            count = 0;
            final TextView heightLabel = (TextView) findViewById(R.id.heightLabel);
            victoryMusic.start();
            heightLabel.setText("You Won");
            if (count == 5){
                try
                {
                    Thread.sleep(5000);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }
            Intent myInt = new Intent(getApplicationContext(), Gamemodes.class);
            startActivity(myInt);
        }

        else {
            Random rand = new Random();

            r1 = rand.nextInt(10);
            r2 = rand.nextInt(10);

            Button b = (Button) findViewById(R.id.button1);
            b.setText(Integer.toString(r1));
            Button b2 = (Button) findViewById(R.id.button2);
            b2.setText(Integer.toString(r2));

        }


    }


    public void Left(View v) throws InterruptedException {
        if (r1 > r2) {
            count ++;
        }
        else if (r1 == r2) {
            this.count = count;

        }else {
            count = 0;
        }
        TextView txt = (TextView) findViewById(R.id.textViewResult);
        txt.setText("Points: " + count);
        giveNewRandom();

    }
    public void Right(View v) throws InterruptedException {
        if (r1 < r2) {
            count++;
        }
        else if (r1 == r2) {
            this.count = count;
        }

        else {
            count = 0;
        }
        TextView txt = (TextView) findViewById(R.id.textViewResult);
        txt.setText("Points: " + count);
        giveNewRandom();
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