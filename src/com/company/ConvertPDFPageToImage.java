package com.company;

/**
 * Created by admin on 7/6/2014.
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

@SuppressWarnings("unchecked")
public class ConvertPDFPageToImage {
    public static void convert() {
        try {
            //setting up the file we want to convert, and what directory to put it in
            String sourceDir = "04-Request-Headers.pdf";
            String destinationDir = "images/";
            File oldFile = new File(sourceDir);
            //remove the .pdf extension, later we'll add .png
            String fileName = oldFile.getName().replace(".pdf", "");
            if (oldFile.exists()) {

                PDDocument document = PDDocument.load(sourceDir);
                List<PDPage> list = document.getDocumentCatalog().getAllPages();

                int pageNumber = 1;
                for (PDPage page : list) {
                    BufferedImage image = page.convertToImage();
                    File outputfile = new File(destinationDir + fileName + "_" + pageNumber + ".png");
                    ImageIO.write(image, "png", outputfile);
                    pageNumber++;
                }
                document.close();

            } else {
                System.err.println(fileName + "File does not exist");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}