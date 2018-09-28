package ru.otus;

import com.carrotsearch.sizeof.RamUsageEstimator;

import java.util.ArrayList;
import java.util.List;

public class MainHW102 {
    public static void main(String[] args) {
        System.out.println("empty string size = " + RamUsageEstimator.sizeOf("") + " bytes");
        List<Long> list = new ArrayList<>();
        System.out.println("empty arrayList size = " + RamUsageEstimator.sizeOf(list) + " bytes");
        list.add(10L);
        long oneElementListSize = RamUsageEstimator.sizeOf(list);
        list.add(0L);
        list.add(9223372036854775807L);
        list.add(-9223372036854775808L);
        long fourElementListSize = RamUsageEstimator.sizeOf(list);
        long oneElementIncreasedSize = (fourElementListSize - oneElementListSize) / 3;

        System.out.println("one element arrayList size in bytes is: " + oneElementListSize);
        System.out.println("four element arrayList size in bytes is: " + fourElementListSize);
        System.out.println("each element increases size of array on " + oneElementIncreasedSize + " bytes");

    }

}

