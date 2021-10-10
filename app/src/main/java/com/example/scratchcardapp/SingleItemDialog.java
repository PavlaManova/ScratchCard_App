package com.example.scratchcardapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.cardview.widget.CardView;

import com.anupkumarpanwar.scratchview.ScratchView;

public class SingleItemDialog extends AppCompatDialogFragment {

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

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.single_item_dialog, null);

        loadViewsById(view);

        getItemExtras();
        loadDataAccordingScratched();
        configureScratchFeature();

        builder.setView(view)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();
    }

    private void loadViewsById(View view) {
        movieToScrImg=(ImageView)view.findViewById(R.id.imgToScratch);
        movieName=(TextView)view.findViewById(R.id.movieNameView);
        scratchView=(ScratchView) view.findViewById(R.id.scratchView);
        cardView=(CardView)view.findViewById(R.id.cardView);
        scratchedImg=(ImageView)view.findViewById(R.id.scratchedImg);
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
        isScratched=PrefConfig.loadScratchedImgFromPref(getContext(),position);
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
                Toast.makeText(getContext(),"Hope you liked it!",Toast.LENGTH_SHORT).show();
                isScratched=true;
                PrefConfig.saveScratchedImgInPref(getContext(),isScratched,position);
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
            }
        });
    }

    public void setIntent(Intent initialIntent){
        intent=initialIntent;
    }
}
