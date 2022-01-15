package com.example.tp4_player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void demarrer(View view){
        Intent intent =new Intent(this,ServiceMusique.class);
        intent.setAction("START");
        intent.putExtra("songName","song1");
        startService(intent);
    }

    public void lister(View view){
        Intent intent =new Intent(this,MyPlayList.class);
        startActivity(intent);
    }

    public void stop(View view){
        Intent intent =new Intent(this,ServiceMusique.class);
        intent.setAction("STOP");
        intent.putExtra("songName","song1");
        startService(intent);
    }

    public void quit(View view){
        finish();
    }


}
