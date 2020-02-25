package com.essence.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import java.util.Locale;

public class LanguageUtil {

    public static void changeLanguage(Context context) {
        String current = Locale.getDefault().getLanguage().toUpperCase();
        Log.d("LanguageUtil", "changeLanguage: " + current);
        String languageCode = "";
        if (current.equals("EN"))
            languageCode = "AR";
        else
            languageCode = "EN";
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        context.getResources().updateConfiguration(configuration
                , context.getResources().getDisplayMetrics());
    }
}
