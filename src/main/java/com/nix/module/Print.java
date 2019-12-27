package com.nix.module;

import java.io.IOException;
import java.util.ArrayList;
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
        char[] mas = sb.toString().toCharArray();
        for (char number : mas) {
            list.add(Integer.valueOf(number));

        }
        for (int j = 0; j < list.size(); j++) {
            currentByte = (currentByte << 1) | (list.get(j));
            numBits++;
            if (numBits == 8) {
                File.write("kol.hf", currentByte);
            }
        }


        //  File.write("kol.hf",sb.toString());
        try {
            File.read("kol.hf");
            printDecoderedtext(File.read("kol.hf"), sb);
        } catch (IOException e) {
            System.out.println(e.toString());
        }


    }

    public static void printDecoderedtext(String text, StringBuilder sb) {
        int index = -1;

        while (index < sb.length() - 2) {
            index = HuffmanTree.GetDecoderText(text, index, sb);

        }
    }

}
