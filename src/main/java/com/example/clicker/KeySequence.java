package com.example.clicker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.awt.event.KeyEvent.*;

public class KeySequence {
    private final Map<Integer, Integer> keySequence;
    private final Random random;

    public KeySequence() {
        random = new Random();
        keySequence = new HashMap<>();
        keySequence.put(VK_F1, 130);
        keySequence.put(VK_F2, 130);
        keySequence.put(VK_F3, 130);
        keySequence.put(VK_F4, 130);
        keySequence.put(VK_F5, 130);
        keySequence.put(VK_F6, 130);
        keySequence.put(VK_F7, 130);
        keySequence.put(VK_F8, 130);
        keySequence.put(VK_F9, 130);
        keySequence.put(VK_F10, 130);
    }

    public Map<Integer, Integer> getKeySequence() {
        return keySequence;
    }

    public int timeShift() {
        return random.nextInt(31) - 15;
    }
}
