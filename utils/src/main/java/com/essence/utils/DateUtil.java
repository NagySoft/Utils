package com.essence.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
    public static String TAG = DateUtil.class.getSimpleName();

    static final String DATE_FORMAT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    static final String DATE_FORMAT_MMMM_dd_yyyy_hh_mm_a = "MMMM dd, yyyy hh:mm a";
    static final String DATE_FORMAT_UTC_Z = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    static final String UTC = "UTC";
    private static final String DATE_FORMAT_dd_mm_yyyy = "dd/MM/yyyy";
    private static final String DATE_FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss";

    public static Date convertUTCStringToDate(String utcDateString) throws Exception {
        SimpleDateFormat dateFormatter;
        dateFormatter = new SimpleDateFormat(DATE_FORMAT_UTC);
        dateFormatter.setTimeZone(TimeZone.getTimeZone(UTC));
        Date utcDate = dateFormatter.parse(utcDateString);
        return utcDate;
    }

    public static String convertToDateUTCString(Date date) throws Exception {
        SimpleDateFormat dateFormatter;
        dateFormatter = new SimpleDateFormat(DATE_FORMAT_UTC);
        dateFormatter.setTimeZone(TimeZone.getTimeZone(UTC));
        String UTCString = dateFormatter.format(date);
        return UTCString;
    }

    public static String convertDateToString(Date date) {
        SimpleDateFormat dateFormatter;
        dateFormatter = new SimpleDateFormat(DATE_FORMAT_MMMM_dd_yyyy_hh_mm_a);
        dateFormatter.setTimeZone(TimeZone.getDefault());
        String formattedDate = dateFormatter.format(date);
        return formattedDate;
    }

    public static Date convertStringToDate(String dateString) throws Exception {
        SimpleDateFormat dateFormatter;
        dateFormatter = new SimpleDateFormat(DATE_FORMAT_MMMM_dd_yyyy_hh_mm_a);
        dateFormatter.setTimeZone(TimeZone.getDefault());
        Date date = dateFormatter.parse(dateString);
        return date;
    }

    private static String getUTCDatetime(Date date) {
        final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_UTC, Locale.US);
//        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }

    public static String getDatetimeDD_MM_YYYY(Date date) {
        final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_dd_mm_yyyy, Locale.US);
        return sdf.format(date);
    }

    private static Date parseDatetimeUTC(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_UTC, Locale.US);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Date parseDatetimeDD_MM_YYYY(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_dd_mm_yyyy, Locale.US);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String formatDateFromUTCString(String format, String date) {
        if (date == null) {
            return null;
        }
        final SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        return sdf.format(parseDatetimeUTC(date));
    }

    public static String formatDateToUTCString(String date) {
        return getUTCDatetime(parseDatetimeDD_MM_YYYY(date));
    }

    public static String formatDateDD_MM_YYYY(String date) {
        return formatDateFromUTCString(DATE_FORMAT_dd_mm_yyyy, date);
    }

    public static String getNowUTC() {
        return getUTCDatetime(Calendar.getInstance().getTime());
    }

    private static Date getNowDate() {
        return Calendar.getInstance().getTime();
    }

    public static String getNowDateDD_MM_YYYY() {
        return getDatetimeDD_MM_YYYY(getNowDate());
    }
}
