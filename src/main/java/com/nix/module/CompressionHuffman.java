package com.nix.module;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CompressionHuffman  {


    public static void incoder(Node root,String str, Map<Character, String> huffmanCode) {


        if (root == null)
            return ;

        // found a leaf node
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            huffmanCode.put(root.getCharacter(), str);
        }


        incoder(root.getLeftChild(), str + "0", huffmanCode);
        incoder(root.getRightChild(), str + "1", huffmanCode);
    }


    public static int decoder(Node root, int index, StringBuilder sb) {

      /*  if (root == nullptr) {
            return;
        }

        // found a leaf node
        if (!root->left && !root->right)
        {
            cout << root->ch;
            return;
        }

        index++;

        if (str[index] =='0')
            decode(root->left, index, str);
        else
            decode(root->right, index, str);
    }*/

        if (root == null)
            return index;

        // found a leaf node
        if (root.getLeftChild() == null && root.getRightChild() == null)
        {
            System.out.print(root.getCharacter());
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

