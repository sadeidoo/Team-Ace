//package com.example.guessthatnumber;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
//import java.util.Random;
//
//public class PlayGame2 extends AppCompatActivity {
//    MediaPlayer music;
//    MediaPlayer victoryMusic;
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_play_game);
//        getSupportActionBar().setTitle("Randomizer");
//        music = MediaPlayer.create(PlayGame2.this, R.raw.thecradleofyoursoul);
//        victoryMusic = MediaPlayer.create(PlayGame2.this, R.raw.audiencecheeringandclapping);
//        music.setLooping(true);
//        music.start();
//        FloatingActionButton floatingActionButton = findViewById(R.id.playGameBack2);
//        final TextView heightLabel = (TextView) findViewById(R.id.heightLabel);
//        final TextView guessText = (TextView) findViewById(R.id.guessText);
//        TextView userGuess = (TextView) findViewById(R.id.userGuess);
//        Button pushMe = (Button) findViewById(R.id.button3);
//
////        floatingActionButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                goBack();
////            }
////        });
//
//        pushMe.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//
//                Random randGen = new Random();
//                int rando = randGen.nextInt(6) + 1;
//                int userNumber = Integer.parseInt(userGuess.getText().toString());
//                if (userNumber < 1 || userNumber > 30) {
//                    heightLabel.setText("Please guess a number between 1 & 6");
//                } else if (userNumber == rando) {
//                    victoryMusic.start();
//                    heightLabel.setText("You Got It Right!");
//                    try
//                        {
//                            Thread.sleep(5000);
//                        }
//                    catch(InterruptedException ex)
//                        {
//                            Thread.currentThread().interrupt();
//                        }
//                    Intent myInt = new Intent(getApplicationContext(), Gamemodes.class);
//                    startActivity(myInt);
//                }
//                else {
//                    heightLabel.setText("Try Again");
//                }
//                guessText.setText("");
//
//
//
//            }
//
//
//        });
//
//
//    }
//
//    public void goBack() {
//        Intent intent = new Intent(this, Gamemodes.class);
//        startActivity(intent);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        music.release();
//        finish();
//    }
//
//
//}