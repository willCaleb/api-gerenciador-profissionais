package com.will.gerenciadormontagem.utils;

public class StringUtils {

    public static boolean isNullOrEmpty(String string){
        return (string == null) || string.trim().equals("");
    }

    public static boolean isNotNullOrEmpty(String string){
        return !isNullOrEmpty(string);
    }
}
