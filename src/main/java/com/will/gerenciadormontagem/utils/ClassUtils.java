package com.will.gerenciadormontagem.utils;

import java.lang.reflect.Method;
import java.util.Locale;

public class ClassUtils {
    public static Method getGetterMethod(Method method, String name){
        if(isType(method, "get".toLowerCase(Locale.ROOT), name)){
            return method;
        }
        return null;
    }

    public static Method getSetterMethod(Method method, String name){
        if(isType(method, "set", name)){
            return method;
        }
        return null;
    }

    public static boolean isType(Method method, String type, String fieldName){
        return method.getName().startsWith(type) && (method.getName().equalsIgnoreCase(type.concat(fieldName)));
    }
}
