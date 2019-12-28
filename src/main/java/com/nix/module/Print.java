package com.nix.module;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Print {
    public static void printCodeTable(String text) {
        System.out.println("Huffman Codes are :\n");
        for (Map.Entry<Character, String> entry : HuffmanTree.GetTableCode(text).entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

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

// separate them by space
        String[] splited = sb.toString().split("");
// here we will save the numbers
        int[] numbers = new int[splited.length];
        for(int i = 0; i < splited.length; i++) {
            list.add(Integer.parseInt(splited[i]));
        }
        for (int j = 0; j < list.size(); j++) {

            File.write("kol.hf", list.get(j));
        }






        //  File.write("kol.hf",sb.toString());
        try{

            printDecoderedtext(File.readByte("kol.hf"),sb);
        }
        catch (IOException e)
        {
            System.out.println(e.toString());
        }


    }
    public static void printDecoderedtext(String text, StringBuilder sb )
    {	 int index = -1;

        while (index < sb.length() - 2) {
            index = HuffmanTree.GetDecoderText(text, index, sb);

        }

    }

}
