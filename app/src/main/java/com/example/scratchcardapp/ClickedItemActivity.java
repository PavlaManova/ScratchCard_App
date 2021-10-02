package com.example.scratchcardapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anupkumarpanwar.scratchview.ScratchView;
import com.google.android.material.imageview.ShapeableImageView;

public class ClickedItemActivity extends AppCompatActivity {

    private ImageView movieToScrImg;
    private ImageView scratchedImg;
    private TextView movieName;
    private ScratchView scratchView;
    private String selectedName;
    private int selectedImage;
    private int position;
    private Intent intent;
    private Boolean isScratched;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_item);

        loadViewsById();
        intent=getIntent();
        getItemExtras();
        loadDataAccordingScratched();
        configureScratchFeature();
    }

    private void loadViewsById() {
        movieToScrImg=(ImageView)findViewById(R.id.imgToScratch);
        movieName=(TextView)findViewById(R.id.movieNameView);
        scratchView=(ScratchView) findViewById(R.id.scratchView);
        cardView=(CardView)findViewById(R.id.cardView);
        scratchedImg=(ImageView)findViewById(R.id.scratchedImg);
    }

    private void getItemExtras() {
        if(intent.getExtras()!=null){
            selectedName=intent.getStringExtra("name");
            selectedImage=intent.getIntExtra("image",0);
            position=intent.getIntExtra("position",0);
        }

        movieName.setText(selectedName);
    }

    private void loadDataAccordingScratched() {
        movieToScrImg.setImageResource(selectedImage);
        isScratched=PrefConfig.loadScratchedImgFromPref(getApplicationContext(),position);
        scratchedImg.setImageResource(selectedImage);

        if(isScratched){
            cardView.setVisibility(View.INVISIBLE);
            scratchedImg.setVisibility(View.VISIBLE);
        }
        else{
            cardView.setVisibility(View.VISIBLE);
            scratchedImg.setVisibility(View.INVISIBLE);
        }
    }

    private void configureScratchFeature() {
        scratchView.setStrokeWidth(15);

        scratchView.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                Toast.makeText(getApplicationContext(),"Hope you liked it!",Toast.LENGTH_SHORT).show();
                isScratched=true;
                PrefConfig.saveScratchedImgInPref(getApplicationContext(),isScratched,position);
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {

            }
        });
    }
}