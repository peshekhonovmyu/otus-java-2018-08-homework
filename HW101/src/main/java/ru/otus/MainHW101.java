package ru.otus;

import com.google.common.collect.*;

import java.util.Iterator;

public class MainHW101 {

    public static void main(String args[]) {

        BiMap<String, Integer> biMap = HashBiMap.create();
        int i = 0;
        for (String arg : args) {
            biMap.put(arg, i++);
        }

        BiMap<Integer, String> inversedBimap = biMap.inverse();

        Iterator<Integer> biMapIterator = inversedBimap.keySet().iterator();
        while (biMapIterator.hasNext()) {
            System.out.print(inversedBimap.get(biMapIterator));
        }
    }
}
