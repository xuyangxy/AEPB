package com.tw.aepb.coin;

public class Util {
    public static int getNumberDecimalDigits(double number) {
        if (number == (long)number) {
            return 0;
        }
        int i = 0;
        while (true){
            i++;
            if (number * Math.pow(10, i) % 1 == 0) {
                return i;
            }
        }
    }
}
