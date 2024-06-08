/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.util;

import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author asthiseta
 */
public class Validator {

    public static boolean isValidEmail(String email) {
        boolean allowLocal = true;
        boolean valid = EmailValidator.getInstance(allowLocal).isValid(email);
        return valid;
    }

}
