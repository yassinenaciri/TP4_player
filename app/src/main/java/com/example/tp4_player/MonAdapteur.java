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
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView titre;
        ImageView image;

    }

    public MonAdapteur(@NonNull Context context, int resource, @NonNull List<Song> objects) {
        super(context, resource,  objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Song song = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne, parent, false);
        }
        // Lookup view for data population
        TextView songName = (TextView) convertView.findViewById(R.id.titre);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        songName.setText(song.getTitre());
        //image.setImageResource(R.drawable.imageandroid);
        // Return the completed view to render on screen
        return convertView;
    }
}
