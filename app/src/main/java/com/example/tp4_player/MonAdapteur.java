package com.example.tp4_player;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MonAdapteur extends ArrayAdapter<Song> {
    private Context context;

    public MonAdapteur(@NonNull Context context, int resource, @NonNull List<Song> objects) {
        super(context, resource,  objects);
        this.context=context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Song song = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne, parent, false);
        }
        TextView songName = (TextView) convertView.findViewById(R.id.titre);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        songName.setText(song.getTitre());
        image.setImageResource(context.getResources().getIdentifier(song.getImage(),"drawable",context.getPackageName()));

        return convertView;
    }
}
