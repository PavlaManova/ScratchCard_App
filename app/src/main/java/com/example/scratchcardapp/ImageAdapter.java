package com.example.scratchcardapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.android.material.imageview.ShapeableImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;

    public Integer[] images={
            R.drawable.lion,
            R.drawable.the_godfather,
            R.drawable.the_kite_runner,
            R.drawable.titanic,
            R.drawable.troy
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
        ShapeableImageView imageView2=new ShapeableImageView(context);
        imageView2.setImageResource(images[i]);
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView2.setLayoutParams(new GridView.LayoutParams(250,250));
        
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(images[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(250,250));
        return imageView;
    }
}
