package com.essence.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import java.util.Locale;

public class LanguageUtil {

    public static final String LANGUAGE_ARABIC = "AR";
    public static final String LANGUAGE_ENGLISH = "EN";
    public static final String LANGUAGE_CODE = "LANGUAGE_CODE";
    public static final String LANGUAGE = "LANGUAGE";

    public static String changeLanguage(Context context, String languageCode) {
        Log.d("LanguageUtil", "changeLanguage: " + languageCode);
        if (languageCode.equals(LANGUAGE_ENGLISH))
            languageCode = LANGUAGE_ARABIC;
        else
            languageCode = LANGUAGE_ENGLISH;
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        return languageCode;
    }
}
