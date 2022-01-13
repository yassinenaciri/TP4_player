package com.example.tp4_player;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class ServiceMusique extends Service {
    MediaPlayer mediaPlayer;
    public ServiceMusique() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        System.out.println("HEEEEEEEEEEE"+intent.getAction());

        if (intent.getAction() == "START"){
            if (mediaPlayer != null){
                mediaPlayer.stop();
            }
            String songName =(String) intent.getExtras().get("songName");
            mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(songName,"raw", getPackageName()));
            mediaPlayer.start();
        }
        else if (intent.getAction() == "STOP"){
            if (mediaPlayer != null){
                mediaPlayer.stop();
            }
        }

        return Service.START_STICKY_COMPATIBILITY;
    }
}
