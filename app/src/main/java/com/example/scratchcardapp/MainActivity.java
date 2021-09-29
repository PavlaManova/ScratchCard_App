package com.example.scratchcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements GenderDialog.GenderDialogListener {

    private ImageView ownerImage;
    private boolean femaleChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ownerImage=(ImageView)findViewById(R.id.ownerImage);

        femaleChosen=PrefConfig.loadGenderImgFromPref(this);
        if(femaleChosen)
            ownerImage.setImageResource(R.drawable.owner_image_female);
        else
            ownerImage.setImageResource(R.drawable.owner_image_male);

        ownerImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                openDialog();
                return true;
            }
        });

        GridView gridView=(GridView) findViewById(R.id.gridView);
        ImageAdapter imgAdapter=new ImageAdapter(this);
        gridView.setAdapter(imgAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName=imgAdapter.moviesNames[position];
                int selectedImage=imgAdapter.images[position];
                startActivity(new Intent(MainActivity.this, ClickedItemActivity.class).putExtra("name",selectedName).putExtra("image",selectedImage));
            }
        });
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
            femaleChosen=true;
        }
        else {
            ownerImage.setImageResource(R.drawable.owner_image_male);
            femaleChosen=false;
        }
        PrefConfig.saveGenderInPref(getApplicationContext(),femaleChosen);
    }
}

