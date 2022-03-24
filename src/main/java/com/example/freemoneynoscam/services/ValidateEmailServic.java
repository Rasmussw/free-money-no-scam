package com.example.freemoneynoscam.services;

import java.util.regex.Pattern;

public class ValidateEmailServic {
/*
    public static boolean isEmailValid(String email) {
        //TODO implement logic such that we verify an e-mail is valid
        if (email.contains("@") && email.contains(".")) {
            return true;
        } else {
            return false;
        }
    }
*/
    public static boolean isEmailValid1(String email) {
        //TODO implement logic such that we verify an e-mail is valid

        // regular expresion, der siger noget om hvornår en email er valid (hva der må være før @ og efter osv.)
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";

        if (email.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }
}