package com.nix.module;

import java.util.HashMap;
import java.util.Map;

public class TextProcess {
    public static Map<Character, Integer> frequency = new HashMap<>();

    public static Map<Character, Integer> GetFrequency(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!frequency.containsKey(text.charAt(i))) {
                frequency.put(text.charAt(i), 0);
            }
            frequency.put(text.charAt(i), frequency.get(text.charAt(i)) + 1);
        }

        return frequency;

    }
}
