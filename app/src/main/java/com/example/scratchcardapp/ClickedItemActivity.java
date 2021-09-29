package com.example.scratchcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ClickedItemActivity extends AppCompatActivity {

    ImageView movieToScrImg;
    TextView movieName;
    Button btn;

    Boolean isScratced;

    String selectedName;
    int selectedImage;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_item);

        movieToScrImg=(ImageView)findViewById(R.id.movieToScratchView);
        movieName=(TextView)findViewById(R.id.movieNameView);

        btn=(Button)findViewById(R.id.tryBtn);

        Intent intent=getIntent();
        if(intent.getExtras()!=null){
            selectedName=intent.getStringExtra("name");
            selectedImage=intent.getIntExtra("image",0);
            position=intent.getIntExtra("position",0);
        }

        movieName.setText(selectedName);
        isScratced=PrefConfig.loadScratchedImgFromPref(getApplicationContext(),position);

        if(isScratced){
            movieToScrImg.setImageResource(selectedImage);
            btn.setEnabled(false);
        }
        else {
            //implement code for scratching
            movieToScrImg.setImageResource(R.drawable.default_min);
            btn.setEnabled(true);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isScratced=true;
                btn.setEnabled(false);
                PrefConfig.saveScratchedImgInPref(getApplicationContext(),isScratced,position);
            }
        });



    }
}