package com.will.gerenciadormontagem.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static boolean isNullOrEmpty(List<?> list){
        return list.isEmpty() || list == null;
    }
    public static boolean isNotNullOrEmpty(List<?> list){
        return !isNullOrEmpty(list);
    }

    public static List<?> ofNullable(List<?> list){
        return list.isEmpty() ? new ArrayList<>() : list;
    }
}
