package com.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String USER_NAME_REGEX = "^[a-z0-9]{6,}$";
    public static final String PASSWORD_REGEX = "^[\\w]{8,}";
    public static final String ALBUM_NAME_REGEX = "^[\\d]{10}$";
    public static final String LICENSE_REGEX = "(([1-9]\\d[A-Z][-])|[1-9]\\d[A-Z] )((\\d{3}[.]\\d{2})|(\\d{4}))";

    public static boolean isValid(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
