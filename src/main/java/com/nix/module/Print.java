package com.nix.module;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.*;

public class Print {
    public static void printCodeTable(String text) {

        System.out.println("Huffman Codes are :\n");
        for (Map.Entry<Character, String> entry : HuffmanTree.GetTableCode(text).entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        HashMap<Character,String> mapInFile= new HashMap<>();
        File.writeTableCode("test2.txt",HuffmanTree.GetTableCode(text));

        System.out.println("\nOriginal string was :\n" + text);
    }

    public static void printCodeHuffman(String text) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int currentByte = 0;
        int numBits = 0;

        for (int i = 0; i < text.length(); i++) {

            sb.append(HuffmanTree.GetTableCode(text).get(text.charAt(i)));


        }
        System.out.println(sb.toString());


// separate them by space
       /* String[] splited = sb.toString().split("");
// here we will save the numbers
        int[] numbers = new int[splited.length];
        for(int i = 0; i < splited.length; i++) {
            list.add(Integer.parseInt(splited[i]));
        }
        for (int j = 0; j < list.size(); j++) {


        }*/

        File.writeBytes("kol.hf", sb.toString());




        //  File.write("kol.hf",sb.toString());
        try{
            String str=File.readByte("kol.hf");
            System.out.println(str);
            printDecoderedtext(text,File.readByte5("kol.hf",sb));
        }
        catch (IOException e)
        {
            System.out.println(e.toString());
        }


    }
    public static void printDecoderedtext(String text, StringBuilder sb )

    {
        int index = -1;

        while (index < sb.length() - 2) {
            index = HuffmanTree.GetDecoderText(text, index, sb);

        }

    }

}
