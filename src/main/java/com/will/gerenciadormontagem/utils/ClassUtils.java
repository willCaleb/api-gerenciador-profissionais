package com.will.gerenciadormontagem.utils;

import java.lang.reflect.Method;

public class ClassUtils {
    public static Method getGetterMethod(Method method, String name){
        if(isType(method, "get", name)){
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
