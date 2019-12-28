package com.nix.module;

import com.sun.xml.internal.ws.util.ReadAllStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class File {


    //////////////////////////////////////////////////////////////////////////////////
    public static void write(String fileName, String text) {
        java.io.File file = new java.io.File(fileName);
        try {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new RuntimeException("Where my fuckin' file?");
                }
            }
            try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
                out.print(text);
            }
        } catch (IOException ololo) {
            throw new RuntimeException(ololo);
        }
    }

    public static void writeBytes(String fileName, String text) {
        java.io.File file = new java.io.File(fileName);
        try {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new RuntimeException("Where my fuckin' file?");
                }
            }
            try (ByteBufferOutput out = new ByteBufferOutput(new FileOutputStream(file.getAbsoluteFile()))) {
                List<Integer> list = new ArrayList<>();

                String[] splited = text.split("");

                int[] numbers = new int[splited.length];
                for (int i = 0; i < splited.length; i++) {
                    list.add(Integer.parseInt(splited[i]));
                }
                for (int j = 0; j < list.size(); j++) {
                    out.write(list.get(j));

                }


            }
        } catch (IOException ololo) {
            throw new RuntimeException(ololo);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////
    public static String readImage(String fileName) throws FileNotFoundException {
        String data = "";


        ImageIcon icon = new ImageIcon(fileName);
        try (ByteArrayOutputStream os = new ByteArrayOutputStream();
             ImageOutputStream ios = ImageIO.createImageOutputStream(os)) {
            BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.BITMASK);

            ImageIO.write(img, "png", os);

            byte[] bytes = os.toByteArray();
            data = Base64.getEncoder().encodeToString(bytes);
            //System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }


    //////////////////////////////////////////////////////////////////////////////////
    public static String read(String fileName) throws FileNotFoundException {
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

    public static void writeTableCode(String fileName, Map<Character, String> map) {
        try {
            java.io.File file = new java.io.File(fileName);
            FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(map);
            oos.flush();
            oos.close();
            fos.close();
        } catch (Exception e) {
        }

    }

    public static StringBuilder readByte5(String fileName, StringBuilder k) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        exists(fileName);
        int b;

        try {
            java.io.File file = new java.io.File(fileName);
            try (ByteBufferInput input = new ByteBufferInput(new FileInputStream(file.getAbsoluteFile()))) {

                for (int i = 0; i < k.toString().length(); i++) {
                    b = input.readNoEof();
                    sb.append(b);
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb;
    }

    public static Map<Character, String> readTableCode(String fileName) {
        HashMap<Character, String> mapInFile = new HashMap<>();
        try {
            java.io.File file = new java.io.File(fileName);
            FileInputStream fis = new FileInputStream(file.getAbsoluteFile());
            ObjectInputStream ois = new ObjectInputStream(fis);

            mapInFile = (HashMap<Character, String>) ois.readObject();

            ois.close();
            fis.close();
            //print All data in MAP
            for (Map.Entry<Character, String> m : mapInFile.entrySet()) {
                System.out.println(m.getKey() + "  " + m.getValue());

            }
        } catch (Exception e) {
        }
        return mapInFile;
    }

    public static String getFileExtension(String fileName) {
        int index = fileName.indexOf('.');
        return index == -1 ? null : fileName.substring(index);
    }

    public static String readByte(String fileName) throws FileNotFoundException {
       /* StringBuilder sb = new StringBuilder();
        exists(fileName);
        int b;

        try {
            java.io.File file = new java.io.File(fileName);
            try (ByteBufferInput input= new ByteBufferInput(new FileInputStream(file.getAbsoluteFile())))
            {
             byte[] text= Files.readAllBytes(file.toPath());
sb.append(text);


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();*/
        StringBuilder sb = new StringBuilder();
        exists(fileName);
        try {
            java.io.File file = new java.io.File(fileName);

            try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                String s;
                while ((s = in.readLine()) != null) {

                    for (char bit : s.toCharArray()) {

                        sb.append((int) (bit));
                    }

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void update(String nameFile, int newText) throws FileNotFoundException {

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


