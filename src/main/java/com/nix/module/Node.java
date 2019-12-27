package com.nix.module;

import java.util.HashMap;
import java.util.Map;

public class Node {

    // Частота символа
    private Integer frequency;
    // Символ
    private Character character;
    // Левый потомок узла
    private Node leftChild;
    // Правый потомок узла
    private Node rightChild;

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public Node(Integer frequency, Character character) {
        this.frequency = frequency;
        this.character = character;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public Character getCharacter() {
        return character;
    }

    public Node(HuffmanTree left, HuffmanTree right) {

        frequency = left.getRoot().frequency + right.getRoot().frequency;
        leftChild = left.getRoot();
        rightChild = right.getRoot();
    }

    @Override
    public String toString() {
        return "[id=" + frequency + ", data =" + character + "]";
    }
}
