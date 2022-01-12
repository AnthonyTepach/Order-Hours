package com.anthnytepach.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String line="16:27:34,15:34:09,06:49:14";
        String array_time[]=line.split(",");

        List<String> times=Arrays.asList(array_time);

        Collections.sort(times);

        for (String a:times){
            System.out.println(a.substring(0,a.length()-3));
        }

    }
}
