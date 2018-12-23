package ru.otus;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class MainHW105 {

//    VM Options: -Xms1G -Xmx2G -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\Users\Катюша\IdeaProjects\otus_java_2018_08_peshekhonov\HW105\dumps1\ -XX:+UseSerialGC
//    VM Options: -Xms1G -Xmx2G -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\Users\Катюша\IdeaProjects\otus_java_2018_08_peshekhonov\HW105\dumps2\ -XX:+UseParallelGC
//    VM Options: -Xms1G -Xmx2G -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\Users\Катюша\IdeaProjects\otus_java_2018_08_peshekhonov\HW105\dumps3\ -XX:+UseConcMarkSweepGC
//    VM Options: -Xms1G -Xmx2G -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\Users\Катюша\IdeaProjects\otus_java_2018_08_peshekhonov\HW105\dumps4\ -XX:+UseG1GC

    public static void main(String args[]) throws MalformedObjectNameException, NotCompliantMBeanException,
            InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {

        int size = 5*1000*1000;
        System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());
        MBeanServer beenServer = ManagementFactory.getPlatformMBeanServer();
        Benchmark bean = new Benchmark();
        beenServer.registerMBean(bean, new ObjectName("ru.otus:type=Benchmark"));
        bean.setSize(size);
        bean.start();
    }
}
