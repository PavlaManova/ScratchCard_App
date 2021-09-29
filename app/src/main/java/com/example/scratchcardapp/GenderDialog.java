package com.example.scratchcardapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class GenderDialog extends AppCompatDialogFragment {

    private ImageView ownerImageView;
    private RadioButton femaleRadioButton;
    private RadioButton maleRadioButton;
    private GenderDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.gender_dialog,null);

        femaleRadioButton=(RadioButton)view.findViewById(R.id.femaleRadioButton);
        maleRadioButton=(RadioButton)view.findViewById(R.id.maleRadioButton);

        builder.setView(view)
                .setTitle("Choose profile picture")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.setOwnerImage(femaleRadioButton);
                    }
                });


        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (GenderDialogListener) context;
        }catch(ClassCastException e){
                throw new ClassCastException(context.toString() +
                        "must implement GenderDialogListener");
        }
    }

    public interface GenderDialogListener{
            void setOwnerImage(RadioButton femaleRadioButton);
    }
}
