package com.example.scratchcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GenderDialog.GenderDialogListener {

    private ImageView ownerImage;
    private boolean femaleChosen;

    private String selectedName;
    private int selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ownerImage=(ImageView)findViewById(R.id.ownerImage);
        loadOwnerImage();

        //change gender option
        ownerImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                openGenderDialog();
                return true;
            }
        });

        //fill grid with 100 items
        GridView gridView=(GridView) findViewById(R.id.gridView);
        ImageAdapter imgAdapter=new ImageAdapter(this);
        gridView.setAdapter(imgAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedName=imgAdapter.getItemName(position);
                selectedImage=imgAdapter.getItemImage(position);
               /* startActivity(new Intent(MainActivity.this, ClickedItemActivity.class)
                        .putExtra("name",selectedName).putExtra("image",selectedImage)
                        .putExtra("position",position));*/
               openSingleItemDialog(new Intent(new Intent(MainActivity.this, SingleItemDialog.class)
                       .putExtra("name",selectedName).putExtra("image",selectedImage)
                       .putExtra("position",position)));
            }
        });
    }

    private void loadOwnerImage() {
        femaleChosen=PrefConfig.loadGenderImgFromPref(this);
        if(femaleChosen)
            ownerImage.setImageResource(R.drawable.owner_image_female);
        else
            ownerImage.setImageResource(R.drawable.owner_image_male);
    }

    public void openGenderDialog()
    {
        GenderDialog genderDialog=new GenderDialog();
        genderDialog.show(getSupportFragmentManager(),"show gender dialog");
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

    public void openSingleItemDialog(Intent intent){
        SingleItemDialog singleItemDialog = new SingleItemDialog();
        singleItemDialog.setIntent(intent);
        singleItemDialog.show(getSupportFragmentManager(), "show single item clicked dialog");
    }
}

