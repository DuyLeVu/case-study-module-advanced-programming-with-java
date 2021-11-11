package com.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String USER_NAME_REGEX = "^[a-z0-9]{6,}$";
    public static final String PASSWORD_REGEX = "^[\\w]{8,}";
    public static final String NAME_REGEX = "^\\S?(.+)+\\S?$";

    public static boolean isValid(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
