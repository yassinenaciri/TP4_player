package com.example.tp4_player;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MyPlayList extends AppCompatActivity {
    ListView mylist ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_play_list);

        /*
        Old code

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(activity, layout, array);
        ListView mylist = (ListView) findViewById(R.id.maListe);
        mylist.setAdapter(myAdapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                String p = parent.getItemAtPosition(pos).toString();
                demarrer(p);
            }});
        registerForContextMenu(mylist);
        */



        ArrayList<Song> songs =new ArrayList<>();
        songs.add(new Song("song1","ios"));
        songs.add(new Song("song2","android"));
        ArrayAdapter<Song> adapter = new MonAdapteur(this, R.layout.ligne, songs);
        mylist= findViewById(R.id.maListe);
        mylist.setAdapter(adapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                Song song=(Song) parent.getItemAtPosition(pos);
                String p =song.getTitre();
                demarrer(p);
            }
            });
        registerForContextMenu(mylist);
    }

    public void demarrer(String songName){
        Intent intent =new Intent(this,ServiceMusique.class);
        intent.setAction("START");
        intent.putExtra("songName",songName);
        startService(intent);
    }
    public void stop(){
        Intent intent =new Intent(this,ServiceMusique.class);
        intent.setAction("STOP");
        startService(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("choisir une action");
        MenuInflater inflater = getMenuInflater(); inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        // Old code
        //String title =(String)mylist.getItemAtPosition(info.position);
        Song song =(Song)mylist.getItemAtPosition(info.position);
        String title = song.getTitre();
        switch (item.getItemId()) {
            case R.id.play:
                demarrer(title);
                return true;
            case R.id.stop:
                stop();
                return true;
            default:
                return super.onContextItemSelected(item);
        } }

}
