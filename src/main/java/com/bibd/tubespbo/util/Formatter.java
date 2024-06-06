/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author asthiseta
 */
public class Formatter {
      // date format, currency, etc
    public static String formatRupiah(double nominal) {
        String hasil = String.format("%,.0f", nominal).replaceAll(",", ".");
        return "Rp" + hasil;
    }

    public static String formatDate(Date date) {
        if(date == null){
            return "N/A";
        }
        Locale locale = new Locale("id", "ID");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String dateResult = dateFormat.format(date);
        return dateResult;
    }
    
}
