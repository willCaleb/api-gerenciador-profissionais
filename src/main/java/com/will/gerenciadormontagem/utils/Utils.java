package com.will.gerenciadormontagem.utils;

public class Utils {
    public static boolean isEmpty(Object object) {
        return object == null;
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    public static <T> T nvl(T first, T second) {
        if ((first instanceof String) || (second instanceof String)) {
            return StringUtils.isNotNullOrEmpty((String) first) ? first : second;
        }
        return Utils.nvl(first, second);
    }
}
