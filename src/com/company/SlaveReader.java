package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SlaveReader implements Slave,Runnable {
    String filePath;
    Master master;
    List<String> lines;



    public SlaveReader(String filePath,Master master){
        this.filePath=filePath;
        this.master=master;
    }


    @Override
    public void run() {
        try {
           lines  = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
           File file = new File(filePath);
           master.setResult(lines,file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
