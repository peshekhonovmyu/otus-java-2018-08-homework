package ru.otus;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GC {

    private static final Set<String> YOUNG_GC = Stream.of("PS Scavenge", "ParNew", "G1 Young Generation").collect(Collectors.toCollection(HashSet::new));
    private static final Set<String> OLD_GC = Stream.of("PS MarkSweep", "ConcurrentMarkSweep", "G1 Old Generation").collect(Collectors.toCollection(HashSet::new));

    public static void printGCMetricks() {
        long minorCount = 0;
        long minorTime = 0;
        long majorCount = 0;
        long majorTime = 0;

        List<GarbageCollectorMXBean> mxBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : mxBeans) {
            long count = bean.getCollectionCount();
            if(count >= 0){
                if (YOUNG_GC.contains(bean.getName())){
                    minorCount += count;
                    minorTime += bean.getCollectionTime();
                } else if (OLD_GC.contains(bean.getName())){
                    majorCount += count;
                    majorTime += bean.getCollectionTime();
                }
            }
        }

        StringBuilder gcMetricMsg = new StringBuilder();
        gcMetricMsg
                .append("MinorGC: Count = ")
                .append(minorCount)
                .append(", time(ms) = ")
                .append(minorTime)
                .append(" MajorGC: Count = ")
                .append(majorCount)
                .append(", time(ms) = ")
                .append(majorTime);

        System.out.println(gcMetricMsg);
    }
}