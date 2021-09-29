package com.example.scratchcardapp;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefConfig {
    private static final String MY_PREFERENCE_NAME = "com.example.scratchcardapp";
    private static final String PREF_GENDER_KEY = "pref_gender_key";
    private static final String[] PREF_IMG_SCR_KEY= {
    "1","2","3","4"
    };

    public static void saveGenderInPref(Context context, boolean femaleChosen)
    {
        SharedPreferences pref=context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean(PREF_GENDER_KEY, femaleChosen);
        editor.apply();
    }

    public static boolean loadGenderImgFromPref(Context context){
        SharedPreferences pref=context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        return pref.getBoolean(PREF_GENDER_KEY, true);
    }

    public static void saveScratchedImgInPref(Context context, boolean[] imgScratched){
        SharedPreferences pref=context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        for(int i=0;i<PREF_IMG_SCR_KEY.length;i++)
        {
            editor.putBoolean(PREF_IMG_SCR_KEY[i],imgScratched[i]);
        }
        editor.apply();
    }

    public static boolean loadScratchedImgFromPref(Context context,int i){
        SharedPreferences pref=context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        return pref.getBoolean(PREF_IMG_SCR_KEY[i], false);
    }
}

