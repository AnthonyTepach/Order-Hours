package com.anthnytepach.app.Files;

import javax.swing.*;

public class FileBrowser extends JFileChooser {

    public String saveAs(){
        super.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = super.showSaveDialog(null);
        if (result==JFileChooser.CANCEL_OPTION);
        return super.getSelectedFile().toString();
    }
}
