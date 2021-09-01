package com.example.scratchcardapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    private Integer[] images={
            //1
            R.drawable.lion,
            R.drawable.the_godfather,
            R.drawable.the_kite_runner,
            R.drawable.titanic,
            R.drawable.troy,
            R.drawable.slumdog_millionaire,
            R.drawable.pirates_of_the_caribbean,
            R.drawable.troy,
            R.drawable.troy,
            R.drawable.troy,
            //11
            R.drawable.lion,
            R.drawable.the_godfather,
            R.drawable.the_kite_runner,
            R.drawable.titanic,
            R.drawable.troy,
            R.drawable.slumdog_millionaire,
            R.drawable.pirates_of_the_caribbean,
            R.drawable.troy,
            R.drawable.troy,
            R.drawable.troy,
            //21
            R.drawable.lion,
            R.drawable.the_godfather,
            R.drawable.the_kite_runner,
            R.drawable.titanic,
            R.drawable.troy,
            R.drawable.slumdog_millionaire,
            R.drawable.pirates_of_the_caribbean,
            R.drawable.troy,
            R.drawable.troy,
            R.drawable.troy,
            //31
            R.drawable.lion,
            R.drawable.the_godfather,
            R.drawable.the_kite_runner,
            R.drawable.titanic,
            R.drawable.troy,
            R.drawable.slumdog_millionaire,
            R.drawable.pirates_of_the_caribbean,
            R.drawable.troy,
            R.drawable.troy,
            R.drawable.troy,
            //41
            R.drawable.lion,
            R.drawable.the_godfather,
            R.drawable.the_kite_runner,
            R.drawable.titanic,
            R.drawable.troy,
            R.drawable.slumdog_millionaire,
            R.drawable.pirates_of_the_caribbean,
            R.drawable.troy,
            R.drawable.troy,
            R.drawable.troy,
            //51
            R.drawable.lion,
            R.drawable.the_godfather,
            R.drawable.the_kite_runner,
            R.drawable.titanic,
            R.drawable.troy,
            R.drawable.slumdog_millionaire,
            R.drawable.pirates_of_the_caribbean,
            R.drawable.troy,
            R.drawable.troy,
            R.drawable.troy,
            //61
            R.drawable.lion,
            R.drawable.the_godfather,
            R.drawable.the_kite_runner,
            R.drawable.titanic,
            R.drawable.troy,
            R.drawable.slumdog_millionaire,
            R.drawable.pirates_of_the_caribbean,
            R.drawable.troy,
            R.drawable.troy,
            R.drawable.troy,
            //71
            R.drawable.lion,
            R.drawable.the_godfather,
            R.drawable.the_kite_runner,
            R.drawable.titanic,
            R.drawable.troy,
            R.drawable.slumdog_millionaire,
            R.drawable.pirates_of_the_caribbean,
            R.drawable.troy,
            R.drawable.troy,
            R.drawable.troy,
            //81
            R.drawable.lion,
            R.drawable.the_godfather,
            R.drawable.the_kite_runner,
            R.drawable.titanic,
            R.drawable.troy,
            R.drawable.slumdog_millionaire,
            R.drawable.pirates_of_the_caribbean,
            R.drawable.troy,
            R.drawable.troy,
            R.drawable.troy,
            //91
            R.drawable.lion,
            R.drawable.the_godfather,
            R.drawable.the_kite_runner,
            R.drawable.titanic,
            R.drawable.troy,
            R.drawable.slumdog_millionaire,
            R.drawable.pirates_of_the_caribbean,
            R.drawable.troy,
            R.drawable.troy,
            R.drawable.troy
    };

    private String[] moviesNames= {
            //1
            "Lion",
            "The Godfather",
            "The Kite Runner",
            "Titanic",
            "Troy",
            "Slumdog Millionaire",
            "Pirates Of The Carribean",
            "Troy",
            "Troy",
            "Troy",
            //11
            "Lion",
            "The Godfather",
            "The Kite Runner",
            "Titanic",
            "Troy",
            "Slumdog Millionaire",
            "Pirates Of The Carribean",
            "Troy",
            "Troy",
            "Troy",
            //21
            "Lion",
            "The Godfather",
            "The Kite Runner",
            "Titanic",
            "Troy",
            "Slumdog Millionaire",
            "Pirates Of The Carribean",
            "Troy",
            "Troy",
            "Troy",
            //31
            "Lion",
            "The Godfather",
            "The Kite Runner",
            "Titanic",
            "Troy",
            "Slumdog Millionaire",
            "Pirates Of The Carribean",
            "Troy",
            "Troy",
            "Troy",
            //41
            "Lion",
            "The Godfather",
            "The Kite Runner",
            "Titanic",
            "Troy",
            "Slumdog Millionaire",
            "Pirates Of The Carribean",
            "Troy",
            "Troy",
            "Troy",
            //51
            "Lion",
            "The Godfather",
            "The Kite Runner",
            "Titanic",
            "Troy",
            "Slumdog Millionaire",
            "Pirates Of The Carribean",
            "Troy",
            "Troy",
            "Troy",
            //61
            "Lion",
            "The Godfather",
            "The Kite Runner",
            "Titanic",
            "Troy",
            "Slumdog Millionaire",
            "Pirates Of The Carribean",
            "Troy",
            "Troy",
            "Troy",
            //71
            "Lion",
            "The Godfather",
            "The Kite Runner",
            "Titanic",
            "Troy",
            "Slumdog Millionaire",
            "Pirates Of The Carribean",
            "Troy",
            "Troy",
            "Troy",
            //81
            "Lion",
            "The Godfather",
            "The Kite Runner",
            "Titanic",
            "Troy",
            "Slumdog Millionaire",
            "Pirates Of The Carribean",
            "Troy",
            "Troy",
            "Troy",
            //91
            "Lion",
            "The Godfather",
            "The Kite Runner",
            "Titanic",
            "Troy",
            "Slumdog Millionaire",
            "Pirates Of The Carribean",
            "Troy",
            "Troy",
            "Troy"
    };

    public ImageAdapter(Context c){
        context=c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater==null)
        {
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view==null)
        {
            view=inflater.inflate(R.layout.row_item,null);
        }

        ImageView imageView=view.findViewById(R.id.image_view);
        TextView textView=view.findViewById(R.id.text_view);
        imageView.setImageResource(images[i]);
        textView.setText(moviesNames[i]);

        return view;
    }
}
