package com.example.web4.service;

public class Validation {
    public static boolean isHit(double x, double y, double r){

        if (x <= 0 && y >= 0 && x >= -r/2 && y <= r){
            return true;
        }

        if (x <= 0 && y <= 0 && Math.abs(x) + Math.abs(y) < r/2){
            return true;
        }

        if (x >= 0 && y <= 0 && x * x + y * y <= r * r){
            return true;
        }

        return false;

    }

    public static boolean checkValidNumber(String str) {
        return str.matches("^[-+]?[0-9]*[.][0-9]+$") || str.matches("^[-+]?[0-9]+$");
    }
}
