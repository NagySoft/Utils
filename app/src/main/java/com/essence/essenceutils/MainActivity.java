package com.essence.essenceutils;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            String utcString = DateUtils.convertToDateUTCString(date);
            Log.d(TAG, "utcString: " + utcString);
            Date dateFromUTC = DateUtils.convertUTCStringToDate(utcString);
            Log.d(TAG, "dateFromUTC: " + dateFromUTC);
            String dateFormatted = DateUtils.convertDateToString(dateFromUTC);
            Log.d(TAG, "dateFormatted: " + dateFormatted);
            Date dateFromFormatted = DateUtils.convertStringToDate(dateFormatted);
            Log.d(TAG, "dateFromFormatted: " + dateFromFormatted);
            String utcStringFromFormatted = DateUtils.convertToDateUTCString(dateFromFormatted);
            Log.d(TAG, "utcStringFromFormatted: " + utcStringFromFormatted);
        } catch (Exception e) {

        }
    }
}
