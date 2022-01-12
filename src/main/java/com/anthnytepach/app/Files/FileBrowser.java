package com.anthnytepach.app.Files;


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.Map;

public class FileBrowser extends JFileChooser {

    public String saveAs(){
        super.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = super.showSaveDialog(null);
        if (result==JFileChooser.CANCEL_OPTION);
        return super.getSelectedFile().toString();
    }

    public String openFile(Map<String,String> typeFile){
        FileNameExtensionFilter filter = new FileNameExtensionFilter(typeFile.get("Desc"), typeFile.get("Ext"),typeFile.get("Type"));
        super.setFileFilter(filter);
        int result = super.showOpenDialog(null);
        File file = super.getSelectedFile();
        if (result==JFileChooser.CANCEL_OPTION);
        return file.getAbsolutePath();
    }
}
