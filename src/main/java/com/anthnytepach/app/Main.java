package com.anthnytepach.app;

import com.anthnytepach.app.Files.FileBrowser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    Map<String, String> ext;

    public Main() {

        ext = new HashMap<>();
        ext.put("Desc", "Archivo de Texto");
        ext.put("Ext", ".txt");
        ext.put("Type", "TXT");
    }

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
        for (int i = 0; i < array_items.length - 1; i++) {
            format_line = format_line + "\t" + array_items[i];
        }
        System.out.println(format_line.substring(1) + "\t" + format_hours.substring(1));
    }

    public void reformatDocument() {
        try {
            List<String> listTxt = Files.readAllLines(Paths.get(new FileBrowser().openFile(ext)), StandardCharsets.UTF_8);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
