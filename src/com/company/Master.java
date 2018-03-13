package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Master {

String filePath;
String result;
ArrayList<SlaveReader> slaves;
HashMap<String,List<String>> hashlist;
int count=0;
int flag =0;


public Master(){
    hashlist=new HashMap<>();
    }

public String read(String filePath)  {

    File folder = new File(filePath);
    File[] files = folder.listFiles();
    for (File file:files) {
        if ("txt".equals(getFileExtension(file))){
            count++;
        }
    }

    for (File file:files) {
        if ("txt".equals(getFileExtension(file))){
            new Thread(new SlaveReader(file.getPath(),this)).start();

        }
    }



    return result;
}

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    public void setResult(List<String> list,String name){
        hashlist.put(name,list);
        if ((hashlist.size()==count)){
            System.out.println("files were read");
            System.out.println(hashlist.keySet()+"");
            hwllo();
        }

    }
    public void hwllo(){
    int a=0;
    }
}
