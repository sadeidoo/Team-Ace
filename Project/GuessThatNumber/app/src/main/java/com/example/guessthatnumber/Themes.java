package com.example.guessthatnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class Themes extends AppCompatActivity {
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);
        music = MediaPlayer.create(Themes.this, R.raw.ambientcinematichiphop);
        music.setLooping(true);
        music.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        music.release();
        finish();
    }
}