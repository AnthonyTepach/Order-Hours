package com.anthnytepach.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String line = "542\tMaria Francisca\tTorres Velazquez\t\tFemenino\t21\tQUINCENA\t1\tCargo\t10/01/2022\t4\t16:59:02,07:37:35,16:01:39,18:54:42";
        String array_items[] = line.split("\t");
        String array_times[] = array_items[11].split(",");

        List<String> times = Arrays.asList(array_times);
        Collections.sort(times);

        String format_hours = "";
        for (String a : times) {
            format_hours = format_hours + "," + a.substring(0, a.length() - 3);
        }
        String format_line = "";
        for (int i = 0; i < array_items.length-1; i++) {
            format_line=format_line+"\t"+array_items[i];
        }
        System.out.println(format_line.substring(1)+"\t"+format_hours.substring(1));
    }
}
