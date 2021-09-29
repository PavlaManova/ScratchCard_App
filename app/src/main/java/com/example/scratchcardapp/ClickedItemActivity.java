package com.example.scratchcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ClickedItemActivity extends AppCompatActivity {

    private ImageView movieToScrImg;
    private TextView movieName;
    private String selectedName;
    private int selectedImage;
    private int position;
    private Intent intent;
    private Boolean isScratched;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_item);

        movieToScrImg=(ImageView)findViewById(R.id.movieToScratchView);
        movieName=(TextView)findViewById(R.id.movieNameView);

        btn=(Button)findViewById(R.id.tryBtn);

        intent=getIntent();
        getItemExtras();

        loadDataAccordingScratched();

        //temporary code
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isScratched=true;
                btn.setEnabled(false);
                PrefConfig.saveScratchedImgInPref(getApplicationContext(),isScratched,position);
            }
        });
    }

    private void loadDataAccordingScratched() {
        isScratched=PrefConfig.loadScratchedImgFromPref(getApplicationContext(),position);

        if(isScratched){
            movieToScrImg.setImageResource(selectedImage);
            btn.setEnabled(false);
        }
        else {
            //implement code for scratching
            movieToScrImg.setImageResource(R.drawable.default_min);
            btn.setEnabled(true);
        }
    }

    private void getItemExtras() {
        if(intent.getExtras()!=null){
            selectedName=intent.getStringExtra("name");
            selectedImage=intent.getIntExtra("image",0);
            position=intent.getIntExtra("position",0);
        }

        movieName.setText(selectedName);
    }
}