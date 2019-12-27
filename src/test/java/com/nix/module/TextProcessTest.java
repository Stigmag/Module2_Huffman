package com.nix.module;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TextProcessTest {

    @Test
    public void getFrequency() {
        String text="je erjo jre";
        TextProcess textProcess= new TextProcess();
        textProcess.GetFrequency(text);
        Map<Character, Integer> test= new HashMap<>();
        test.put('j',3);
        test.put('e',3);
        test.put('r',2);
        test.put('o',1);
        test.put(' ',2);
        assertEquals(test,textProcess.frequency);
    }
}