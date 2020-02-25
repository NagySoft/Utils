package com.essence.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class MyToast {

    public static void showToast(Context context, String msg) {
        Log.d(context + "MyToast", "showToast: " + msg);
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void showToast(Context context, int msgId) {
        Log.d(context + "MyToast", "showToast: " + context.getString(msgId));
        Toast.makeText(context, msgId, Toast.LENGTH_LONG).show();
    }
}
