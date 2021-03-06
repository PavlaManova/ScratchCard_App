package com.example.scratchcardapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
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
    private TextView directorName;
    private ScratchView scratchView;
    private String selectedName;
    private Button undoBtn;
    private int selectedImage;
    private int position;
    private Intent intent;
    private Boolean isScratched;
    private CardView cardView;

    private String[] directorsNames=
    {
        //1
        "Garth Davis",
        "Francis Ford Coppola",
        "Marc Forster",
        "James Cameron",
        "Wolfgang Petersen",
        "Danny Boyle",
        "Gore Verbinski",
            "Theodore Melfi",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            //11
            "Garth Davis",
            "Francis Ford Coppola",
            "Marc Forster",
            "James Cameron",
            "Wolfgang Petersen",
            "Danny Boyle",
            "Gore Verbinski",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            //21
            "Garth Davis",
            "Francis Ford Coppola",
            "Marc Forster",
            "James Cameron",
            "Wolfgang Petersen",
            "Danny Boyle",
            "Gore Verbinski",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            //31
            "Garth Davis",
            "Francis Ford Coppola",
            "Marc Forster",
            "James Cameron",
            "Wolfgang Petersen",
            "Danny Boyle",
            "Gore Verbinski",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            //41
            "Garth Davis",
            "Francis Ford Coppola",
            "Marc Forster",
            "James Cameron",
            "Wolfgang Petersen",
            "Danny Boyle",
            "Gore Verbinski",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            //51
            "Garth Davis",
            "Francis Ford Coppola",
            "Marc Forster",
            "James Cameron",
            "Wolfgang Petersen",
            "Danny Boyle",
            "Gore Verbinski",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            //61
            "Garth Davis",
            "Francis Ford Coppola",
            "Marc Forster",
            "James Cameron",
            "Wolfgang Petersen",
            "Danny Boyle",
            "Gore Verbinski",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            //71
            "Garth Davis",
            "Francis Ford Coppola",
            "Marc Forster",
            "James Cameron",
            "Wolfgang Petersen",
            "Danny Boyle",
            "Gore Verbinski",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            //81
            "Garth Davis",
            "Francis Ford Coppola",
            "Marc Forster",
            "James Cameron",
            "Wolfgang Petersen",
            "Danny Boyle",
            "Gore Verbinski",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            //91
            "Garth Davis",
            "Francis Ford Coppola",
            "Marc Forster",
            "James Cameron",
            "Wolfgang Petersen",
            "Danny Boyle",
            "Gore Verbinski",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
            "Wolfgang Petersen",
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        //AlertDialog dialog=builder.show();

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.single_item_dialog, null);
        //undoBtn=dialog.getButton(AlertDialog.BUTTON_NEUTRAL);

        loadViewsById(view);
        getItemExtras();
        loadDataAccordingScratched();
        configureScratchFeature();
        buildDialog(builder, view);

        return builder.create();
    }

    private void buildDialog(AlertDialog.Builder builder, View view) {
        builder.setView(view)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNeutralButton("Undo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //undoBtn.setVisibility(View.INVISIBLE);
                        isScratched=false;
                        PrefConfig.saveScratchedImgInPref(getContext(),isScratched,position);
                        makeItemUnscratched();

                    }
                });
    }

    private void makeItemUnscratched() {
        cardView.setVisibility(View.VISIBLE);
        scratchedImg.setVisibility(View.INVISIBLE);
        movieName.setTextColor(getResources().getColor(R.color.greyTitle));
        directorName.setTextColor(getResources().getColor(R.color.greyTitle));
    }

    private void loadViewsById(View view) {
        movieToScrImg=(ImageView)view.findViewById(R.id.imgToScratch);
        movieName=(TextView)view.findViewById(R.id.movieNameView);
        scratchView=(ScratchView) view.findViewById(R.id.scratchView);
        cardView=(CardView)view.findViewById(R.id.cardView);
        scratchedImg=(ImageView)view.findViewById(R.id.scratchedImg);
        directorName=(TextView)view.findViewById(R.id.directorNameTextView);
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
        directorName.setText(directorsNames[position]);
        isScratched=PrefConfig.loadScratchedImgFromPref(getContext(),position);
        scratchedImg.setImageResource(selectedImage);

        if(isScratched){
            cardView.setVisibility(View.INVISIBLE);
            scratchedImg.setVisibility(View.VISIBLE);
            movieName.setTextColor(getResources().getColor(R.color.titleColor));
            directorName.setTextColor(getResources().getColor(R.color.titleColor));
        }
        else
            makeItemUnscratched();
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
