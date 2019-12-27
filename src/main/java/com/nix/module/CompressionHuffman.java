package com.nix.module;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CompressionHuffman {


    public static void incoder(Node root, String str, Map<Character, String> huffmanCode) {

        if (root == null)
            return;

        // found a leaf node
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            huffmanCode.put(root.getCharacter(), str);
            //  File.write("TableCode",);

        }


        incoder(root.getLeftChild(), str + "0", huffmanCode);
        incoder(root.getRightChild(), str + "1", huffmanCode);


    }


    public static int decoder(Node root, int index, StringBuilder sb) {
        List<Integer> list = new ArrayList<>();
        List<Integer> test = new ArrayList<>();
        int numBits = 0;
        char[] mas = sb.toString().toCharArray();
        for (char number : mas) {
            list.add(Integer.valueOf(number));

        }

        for (int j = 0; j < list.size(); j++) {
            numBits--;
            test.add((list.get(j) >>> numBits) & 1);


        }
        StringBuilder strbul = new StringBuilder();
        Iterator<Integer> iter = test.iterator();
        while (iter.hasNext()) {
            strbul.append(iter.next());

        }


        if (root == null)
            return index;
        // found a leaf node
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            System.out.print(root.getCharacter());
            return index;
        }

        index++;

        if (index == 0)
            index = decoder(root.getLeftChild(), index, strbul);
        else
            index = decoder(root.getRightChild(), index, strbul);

        return index;

    }
}
