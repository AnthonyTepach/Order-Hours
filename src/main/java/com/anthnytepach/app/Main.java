package com.anthnytepach.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String line="542\tMaria Francisca\tTorres Velazquez\t\tFemenino\t21\tQUINCENA\t1\tCargo\t11/01/2022\t3\t15:30:55,16:25:29,07:50:43\n";
        String array_time[]=line.split("\t");

        List<String> times=Arrays.asList(array_time);
        Collections.sort(times);


        for (String a:times){
            System.out.println(a.substring(0,a.length()-3));
        }

    }
}
