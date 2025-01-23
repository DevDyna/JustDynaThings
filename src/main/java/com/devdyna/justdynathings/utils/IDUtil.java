package com.devdyna.justdynathings.utils;

public class IDUtil {
    public static String getModName(String traslationName) {
        String[] parts = traslationName.split("\\.");
        if (parts.length >= 2) {
            return parts[1];
        } else {
            return null;
        }
    }
}
