package com.example.scratchcardapp;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefConfig {
    private static final String MY_PREFERENCE_NAME = "com.example.scratchcardapp";
    private static final String PREF_GENDER_KEY = "pref_gender_key";

    public static void saveGenderInPref(Context context, boolean femaleChoosen)
    {
        SharedPreferences pref=context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean(PREF_GENDER_KEY, femaleChoosen);
        editor.apply();
    }

    public static boolean loadGenderImgFromPref(Context context){
        SharedPreferences pref=context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        return pref.getBoolean(PREF_GENDER_KEY, true);
    }
}

