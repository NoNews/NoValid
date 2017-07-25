package ru.alexbykov.novalid.utils;

import android.text.TextUtils;

/**
 * Date: 23.07.2017
 * Time: 10:10
 * Project: Validator
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class StringUtils {


    private StringUtils() {
    }

    public static boolean isEmpty(String text) {
        return (TextUtils.isEmpty(text) || isOnlySpaces(text));
    }

    public static boolean isOnlySpaces(String text) {
          return !(text.trim().length() > 0);
    }
}
