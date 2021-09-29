package com.example.scratchcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ClickedItemActivity extends AppCompatActivity {

    ImageView movieToScrImg;
    TextView movieName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_item);

        movieToScrImg=(ImageView)findViewById(R.id.movieToScratchView);
        movieName=(TextView)findViewById(R.id.movieNameView);

        Intent intent=getIntent();

        if(intent.getExtras()!=null){
            String selectedName=intent.getStringExtra("name");
            int selectedImage=intent.getIntExtra("image",0);

            movieName.setText(selectedName);
            movieToScrImg.setImageResource(selectedImage);

        }
    }
}