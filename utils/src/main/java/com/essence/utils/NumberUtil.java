package com.essence.utils;

public class NumberUtil {
    public static float round(float number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        float tmp = number * pow;
        return ((float) ((int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp))) / pow;
    }

    public static float getSizeKB(float size) {
        return round(((float) size / 1024), 1);
    }

}
