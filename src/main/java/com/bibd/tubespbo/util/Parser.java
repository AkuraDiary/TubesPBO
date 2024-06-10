/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author asthiseta
 */
public class Parser {
    
     public static Date parseStringToDate(String date, String format) {
        if (date == null || format == null) {
            throw new IllegalArgumentException("Date and format cannot be null");
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            System.err.println("Failed to parse date: " + e.getMessage());
            return null;
        }
    }
     
     public static String parseDateToStringSQL(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    
}
