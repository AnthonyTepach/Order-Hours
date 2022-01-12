package com.anthnytepach.app;

import com.anthnytepach.app.Files.FileBrowser;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    Map<String, String> ext;
    List<String> newData=new ArrayList<>();
    public Main() {
        ext = new HashMap<>();
        ext.put("Desc", "Delimitado por tab UTF-8");
        ext.put("Ext", ".txt");
        ext.put("Type", "TXT");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.reformatDocument();
        main.writeDocument();
    }

    private void writeDocument() {
        try {
            FileWriter fw = new FileWriter(new FileBrowser().saveAs().concat("/Reporte-Asistencia-Formateado.csv"), Charset.forName("utf-8"));

            for (int i = 0; i < newData.size(); i++) {
                fw.write(newData.get(i));
                fw.write("\n");
            }
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            JOptionPane.showMessageDialog(null,"Finalizado");
        }
    }

    public void reformatDocument() {
        try {
            List<String> listTxt = Files.readAllLines(Paths.get(new FileBrowser().openFile(ext)), StandardCharsets.UTF_8);
            for(int i=0;i<listTxt.size();i++) {
                String array_items[] = listTxt.get(i).split("\t");
                String array_times[] = array_items[11].split(",");

                List<String> times = Arrays.asList(array_times);
                Collections.sort(times);

                String format_hours = "";
                for (String a : times) {
                    format_hours = format_hours + "," + a.substring(0, a.length() - 3);
                }
                String format_line = "";
                for (int j = 0; j < array_items.length - 1; j++) {
                    format_line = format_line + "," + array_items[j];
                }
                newData.add(format_line.substring(1) + "," + format_hours.substring(1));

            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
