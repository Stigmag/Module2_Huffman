package com.nix.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.*;

public class Print {
    private static final Logger logger
            = LoggerFactory.getLogger(Application.class);
    public static void printCodeTable(String text) {
logger.debug("Huffman Codes are :\n");

        for (Map.Entry<Character, String> entry : HuffmanTree.GetTableCode(text).entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        HashMap<Character,String> mapInFile= new HashMap<>();
        File.writeTableCode("test2.txt",HuffmanTree.GetTableCode(text));

        logger.debug("Original string was :" + text);
    }

    public static void printCodeHuffman(String text) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int currentByte = 0;
        int numBits = 0;

        for (int i = 0; i < text.length(); i++) {

            sb.append(HuffmanTree.GetTableCode(text).get(text.charAt(i)));


        }
        logger.debug("Code Huffman compression: "+sb.toString());




        File.writeBytes("kol.hf", sb.toString());




        //  File.write("kol.hf",sb.toString());
        try{
            String str=File.readByte("kol.hf");

            printDecoderedtext(text,File.readByte5("kol.hf",sb));
        }
        catch (IOException e)
        {
           logger.error(e.getMessage());
        }


    }
    public static void printDecoderedtext(String text, StringBuilder sb )

    {
        int index = -1;
        logger.debug("Decoded string is: ");
        while (index < sb.length() - 2) {
           index = HuffmanTree.GetDecoderText(text, index, sb);

        }

    }

}
