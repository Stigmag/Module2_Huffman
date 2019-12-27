package com.nix.module;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class HuffmanTree implements Comparable<HuffmanTree>{
    private Node root;


    HuffmanTree(Node root) {
        this.root = root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }



    public static HuffmanTree build(String text) {
        Map<Character, Integer> freq = TextProcess.GetFrequency(text);
         PriorityQueue<HuffmanTree> tree = new PriorityQueue<>();


        freq.forEach((k, v) -> {

            if (v > 0)
                tree.offer(new HuffmanTree(new Node(v,k)));

        });

        while (tree.size() > 1) {

            HuffmanTree a = tree.poll();
            HuffmanTree b = tree.poll();
            tree.offer(new HuffmanTree(new Node(a, b)));

        }


        return tree.poll();


    }
    public static Map<Character,String> GetTableCode(String text)
    {


        Map<Character, String> huffmanCode = new HashMap<>();
        CompressionHuffman.incoder(HuffmanTree.build(text).getRoot(), "", huffmanCode);
return huffmanCode;
    }
    public static int GetDecoderText(String text,int index,StringBuilder sb)
    {


        int k= CompressionHuffman.decoder(HuffmanTree.build(text).getRoot(),index,sb);
       return k;
    }

    @Override
    public int compareTo(HuffmanTree tree) {
        return root.getFrequency() - tree.root.getFrequency();
    }


}
