package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;
import java.net.URL;

import org.apache.tika.Tika;

import net.sourceforge.tess4j.*;

public class Main {
    public static void main(String[] args) {
        String location = ("04-Request-Headers.pdf");
        try {
            String fileType = fileType(location);
            if (fileType.equals("application/pdf")) {
                ConvertPDFPageToImage.convert();
            } else if (!fileType.substring(0,5).equals("image")) {
                System.out.println("File type " + fileType + " is not supported.");
            }
            File imageFile = new File(location);
            Tesseract instance = Tesseract.getInstance();
            String result = instance.doOCR(imageFile);
            System.out.println(result);
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
}
