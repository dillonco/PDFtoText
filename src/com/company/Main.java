package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;
import java.net.URL;

import org.apache.tika.Tika;

import net.sourceforge.tess4j.*;
import java.io.File;


public class Main {
    private static String[] pageArray;

    public static void main(String[] args) {
        String location = ("InvoiceDetail.pdf");
        String destination = location.replace(location.substring(location.length() - 4), ".txt");
        try {
            String fileType = fileType(location);
            if (fileType.equals("application/pdf")) {
               pageArray = ConvertPDFPageToImage.convert(location);
            } else if (!fileType.substring(0,5).equals("image")) {
                System.out.println("File type " + fileType + " is not supported.");
            }

            for(int i =0; i < pageArray.length; i++) {
                File imageFile = new File(pageArray[i]);
                Tesseract instance = Tesseract.getInstance();
                String result = instance.doOCR(imageFile);
                System.out.println(result);
                appendToFile(result, destination);
            }
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String fileType3(String location) throws IOException {
        Path source = Paths.get(location);
        String fileType = Files.probeContentType(source);
        return fileType;
    }
    public static String fileType(String location){
        Tika tika = new Tika();
        //String fileType = tika.detect(new URL("http://tika.apache.org/tika.png"));
        String fileType =  tika.detect(location);
        //System.out.println("File type " + fileType + ".");
        return fileType;
    }
    public static void appendToFile(String data, String filename )
    {
        try{

            File file =new File(filename);

            //if file doesnt exists, then create it
            if(!file.exists()){
                file.createNewFile();
            }

            //true = append file
            FileWriter fileWritter = new FileWriter(file.getName(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(data);
            bufferWritter.close();

            System.out.println("Done");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
