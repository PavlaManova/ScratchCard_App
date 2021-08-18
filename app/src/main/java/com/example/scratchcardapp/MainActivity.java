package com.example.scratchcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements GenderDialog.GenderDialogListener {

    private ImageView ownerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ownerImage=(ImageView)findViewById(R.id.ownerImage);
        ownerImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                openDialog();

                return true;
            }
        });

        GridView gridView=(GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));
    }

    public void openDialog()
    {
        GenderDialog genderDialog=new GenderDialog();
        genderDialog.show(getSupportFragmentManager(),"we'll see again");
    }

    @Override
    public void setOwnerImage(RadioButton femaleRadioButton) {
        if(femaleRadioButton.isChecked())
        {
            ownerImage.setImageResource(R.drawable.owner_image_female);
        }
        else
            ownerImage.setImageResource(R.drawable.owner_image_male);
    }
}

