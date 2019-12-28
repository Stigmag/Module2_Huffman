package com.nix.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CompressionHuffman {
    private static String output = "";

    private static final Logger logger
            = LoggerFactory.getLogger(Application.class);

    public static void incoder(Node root, String str, Map<Character, String> huffmanCode) {


        if (root == null)
            return;

        // found a leaf node
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            huffmanCode.put(root.getCharacter(), str);
        }


        incoder(root.getLeftChild(), str + "0", huffmanCode);
        incoder(root.getRightChild(), str + "1", huffmanCode);
    }


    public static int decoder(Node root, int index, StringBuilder sb) {


        if (root == null)
            return index;


        if (root.getLeftChild() == null && root.getRightChild() == null) {
            logger.debug(root.getCharacter().toString());
            output += root.getCharacter().toString();
            File.write("decoderFile.txt", output);
            return index;
        }

        index++;

        if (sb.charAt(index) == '0')
            index = decoder(root.getLeftChild(), index, sb);
        else
            index = decoder(root.getRightChild(), index, sb);

        return index;
    }

}

