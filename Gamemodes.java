package com.example.guessthatnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gamemodes extends AppCompatActivity {
    private Button pickGameModeButton;
    private Button pickGameModeButton2;
    private Button pickGameModeButton3;
    private Button pickGameModeButton4;
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemodes);
        pickGameModeButton = (Button) findViewById(R.id.playGameMode1);
        pickGameModeButton2 = (Button) findViewById(R.id.playGameMode2);
        pickGameModeButton3 = (Button) findViewById(R.id.playGameMode3);
        pickGameModeButton4 = (Button) findViewById(R.id.playGameMode4);
        music = MediaPlayer.create(Gamemodes.this, R.raw.spiritblossom);
        music.setLooping(true);
        music.start();
        pickGameModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPickGameMode();
            }
        });
        pickGameModeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPickGameMode2();
            }
        });
        pickGameModeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPickGameMode3();
            }
        });
        pickGameModeButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPickGameMode4();
            }
        });
    }
    public void openPickGameMode() {
        Intent intent = new Intent(this, PlayGame.class);
        startActivity(intent);
    }
    public void openPickGameMode2() {
        Intent intent = new Intent(this, PlayGame2.class);
        startActivity(intent);
    }
    public void openPickGameMode3() {
        Intent intent = new Intent(this, PlayGame3.class);
        startActivity(intent);
    }

    public void openPickGameMode4() {
        Intent intent = new Intent(this, PlayGame4.class);
        startActivity(intent);
    }


    @Override
    protected void onPause() {
        super.onPause();
        music.release();
        finish();
    }
}