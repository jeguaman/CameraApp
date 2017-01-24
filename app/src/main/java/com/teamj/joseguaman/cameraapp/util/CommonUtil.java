package com.teamj.joseguaman.cameraapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Dennys Quiroz on 15/08/2015.
 */
public class CommonUtil {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void showSimpleMessageDialog(Context context, String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setPositiveButton("Aceptar", null)
                .setCancelable(false);
        final AlertDialog alert = builder.create();
        alert.show();
    }

    public static void showYesNoMessageDialog(Context context, String message, String yesTitle, DialogInterface.OnClickListener yesOnClickListener, String noTitle, DialogInterface.OnClickListener noOnClickListener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setPositiveButton(yesTitle, yesOnClickListener)
                .setNegativeButton(noTitle, noOnClickListener)
                .setCancelable(false);
        final AlertDialog alert = builder.create();
        alert.show();
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
}
