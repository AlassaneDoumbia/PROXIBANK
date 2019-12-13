/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TOSHIBA
 */
public class Utils {
    
    public static String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
        return formatter.format(new Date());
    }
}
