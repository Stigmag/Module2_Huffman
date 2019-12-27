package com.nix.module;

import java.util.Map;

public class Print {
    public static void printCodeTable(String text) {
        System.out.println("Huffman Codes are :\n");
        for (Map.Entry<Character, String> entry : HuffmanTree.GetTableCode(text).entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("\nOriginal string was :\n" + text);
    }
    public static void printCodeHuffman(String text)
    { StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < text.length(); i++) {
            sb.append(HuffmanTree.GetTableCode(text).get(text.charAt(i)));

        }

        System.out.println("\nEncoded string is :\n" +  sb.toString());
        printDecoderedtext(text,sb);
    }
    public static void printDecoderedtext(String text, StringBuilder sb )
    {	int index = -1;
        System.out.println("\nDecoded string is: \n");
        while (index < sb.length() - 2) {
            index = HuffmanTree.GetDecoderText(text, index, sb);}

    }

}