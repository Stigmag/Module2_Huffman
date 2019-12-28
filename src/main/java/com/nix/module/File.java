package com.nix.module;

import com.sun.xml.internal.ws.util.ReadAllStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class File {



    //////////////////////////////////////////////////////////////////////////////////
    public static void write(String fileName, int text) {
        java.io.File file = new java.io.File(fileName);
        try {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new RuntimeException("Where my fuckin' file?");
                }
            }
            try (ByteBufferOutput out = new ByteBufferOutput(new FileOutputStream(file.getAbsoluteFile())) ){

                out.write(text);


            }
        } catch (IOException ololo) {
            throw new RuntimeException(ololo);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////
    public static  String readImage(String fileName) throws FileNotFoundException {
        String data="";



        ImageIcon icon = new ImageIcon(fileName);
        try (ByteArrayOutputStream os = new ByteArrayOutputStream();
             ImageOutputStream ios = ImageIO.createImageOutputStream(os))
        {
            BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.BITMASK);
            // g = img.createGraphics();
            // icon.paintIcon(null, g, 0, 0);
            // g.dispose();
            ImageIO.write(img, "png", os);
            // img=ImageIO.read(ios);
            byte[] bytes = os.toByteArray();
            data = Base64.getEncoder().encodeToString(bytes);
            //System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
           /* StringBuilder sb = new StringBuilder();
            exists(fileName);
            try {
                java.io.File file = new java.io.File(fileName);

                try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return sb.toString();*/
        return   data;
    }
    /* public static void update(String nameFile, int newText) throws FileNotFoundException {
         exists(nameFile);
         StringBuilder sb = new StringBuilder();
         String oldFile = read(nameFile);
         sb.append(oldFile);
         sb.append(newText);
         write(nameFile, sb.toString());
     }*/
    //////////////////////////////////////////////////////////////////////////////////
    public static String  read(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        exists(fileName);
        try {
            java.io.File file = new java.io.File(fileName);

            try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    public static String getFileExtension(String fileName) {
        int index = fileName.indexOf('.');
        return index == -1? null : fileName.substring(index);
    }
    public static String readByte(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        exists(fileName);
        int b;

        try {
            java.io.File file = new java.io.File(fileName);
            try (ByteBufferInput input= new ByteBufferInput(new FileInputStream(file.getAbsoluteFile())))
            {
                b=input.read();
                sb.append(b);


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    public static void update(String nameFile,int newText) throws FileNotFoundException {

        exists(nameFile);
        StringBuilder sb = new StringBuilder();
        String oldFile = read(nameFile);
        sb.append(oldFile);
        sb.append(newText);
        // write(nameFile, Integer.parseInt(sb.toString()));
    }



    private static void exists(String fileName) throws FileNotFoundException {
        java.io.File file = new java.io.File(fileName);
        if (!file.exists()) throw new FileNotFoundException(file.getName());
    }
}


