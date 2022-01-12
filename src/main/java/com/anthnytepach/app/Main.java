package com.anthnytepach.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String line="542\tMaria Francisca\tTorres Velazquez\t\tFemenino\t21\tQUINCENA\t1\tCargo\t10/01/2022\t4\t16:59:02,07:37:35,16:01:39,18:54:42";
        String array_items[]=line.split("\t");
        String array_times[]=array_items[11].split(",");

        List<String> times=Arrays.asList(array_times);
        Collections.sort(times);


        for (String a:times){
            System.out.println(a.substring(0,a.length()-3));
        }

    }
}
