package com.razorpay.demospringproject.utils;

import java.util.random.RandomGenerator;

/**
 * @author sarabjeet.singh on 11/09/24
 */


public class Util {

    public static String generateRandomId(){
        return String.valueOf(RandomGenerator.getDefault().nextLong());
    }

    public static int generateRandomAmount(){
        return RandomGenerator.getDefault().nextInt(1000);
    }



}
