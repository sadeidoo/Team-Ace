package com.example.guessthatnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.lang.Thread;

public class PlayGame3 extends AppCompatActivity {
    MediaPlayer music;
    private int count= 0;
    private int r1, r2;
    private Object Gamemodes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game3);
        music = MediaPlayer.create(PlayGame3.this, R.raw.thecradleofyoursoul);
        music.setLooping(true);
        music.start();
        giveNewRandom();

    }

    private void giveNewRandom() {
        if(count == 5){
            count = 0;
            final TextView heightLabel = (TextView) findViewById(R.id.heightLabel);
            heightLabel.setText("You Won");


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


        public void Left(View v) {
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
    public void Right(View v) {
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

    @Override
    protected void onPause() {
        super.onPause();
        music.release();
        finish();
    }
}