package com.forbitbd.quizapp.util;



import android.content.Context;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.Display;
import android.view.WindowManager;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sohel on 1/27/2018.
 */

public class MyUtil {
    private static final String DATE_FORMAT="dd-MMM-yyyy";
    private static final String MONTH_YEAR="MMM-yyyy";
    private static final String DATE_FORMAT2="dd-MM-yy";
    private static final String TIME_FORMAT="yyyy-MM-dd HH:mm:ss";
    private static final String D_FORMAT="yyyy-MM-dd";


    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPhone(String phone){
        Pattern pattern = Pattern.compile("(^(\\+88|0088)?(01){1}[56789]{1}(\\d){8})$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static String getStringDate(Date date){
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(date);
    }

    public static String getMonthYear(Date date){
        DateFormat df = new SimpleDateFormat(MONTH_YEAR);
        return df.format(date);
    }

    public static String getReqDate(Date date){
        DateFormat df = new SimpleDateFormat(D_FORMAT);
        return df.format(date);
    }

    public static String getStringDate2(Date date){
        DateFormat df = new SimpleDateFormat(DATE_FORMAT2);
        return df.format(date);
    }

    public static String getStringDate3(Date date){
        DateFormat df = new SimpleDateFormat(TIME_FORMAT);
        return df.format(date);
    }

    public static String getStringDate2(long time){
        DateFormat df = new SimpleDateFormat(TIME_FORMAT);
        return df.format(new Date(time));
    }

    public static String getStringDate2(String time){

        DateFormat df = new SimpleDateFormat(TIME_FORMAT);
        Date date = new Date(Long.parseLong(time));
        return df.format(date);
    }



    public static long getTimeInMilis(String dateStr){

        DateFormat df = new SimpleDateFormat(TIME_FORMAT);
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static int getDuration(long fDate,long sDate){
        long diff = fDate-sDate;
        return (int) (TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS)+1);
    }

    public static long getBeginingTime(long time){

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);


        int year = calendar.get(Calendar.YEAR);
        int dayofmonth = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);

        calendar.set(year,month,dayofmonth,0,0,0);


        return calendar.getTimeInMillis();
    }

    public static long getServerTime(String dateStr){
        DateFormat df = new SimpleDateFormat(TIME_FORMAT);
        try {
            return df.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getServerTimeStr(long time){
        DateFormat df = new SimpleDateFormat(TIME_FORMAT);
        return df.format(new Date(time));
    }

    public static int getCurrentSpanNumber(){
        DateFormat df = new SimpleDateFormat(TIME_FORMAT);
        String dateStr= df.format(new Date());

        return Integer.parseInt(dateStr.split(" ")[1].split(":")[0]);
    }

    public static long getBeginingTime(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());


        int year = calendar.get(Calendar.YEAR);
        int dayofmonth = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);

        calendar.set(year,month,dayofmonth,0,0,0);


        return calendar.getTimeInMillis();
    }

    public static long getEndingTime(Date date){

        long beginingTime = getBeginingTime(date.getTime());

        return beginingTime+(23*60*60+59*60+59)*1000;

    }

    public static long getEndingTime(long time){

        long beginingTime = getBeginingTime(time);

        return beginingTime+(23*60*60+59*60+59)*1000;

    }

    public static String encodeString(String string) {
        return string.replace(".", ",");
    }

    public static String decodeString(String string) {
        return string.replace(",", ".");
    }

    public static String getTwoDecimalFormat(double value){

        return String.format("%.2f", value);

    }


    public static List<Integer> getScreenDimension(Context context){

        List<Integer> retList = new ArrayList<>();

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        retList.add(width);
        retList.add(height);

        return retList;
    }




    public static Bitmap getScaledBitmap(Bitmap bitmap, int width, int height){
        return Bitmap.createScaledBitmap(bitmap,width,height,false);

    }






}
