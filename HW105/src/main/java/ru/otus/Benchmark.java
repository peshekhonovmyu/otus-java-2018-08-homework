package ru.otus;

import java.util.ArrayList;

public class Benchmark implements BenchmarkMBean {

    int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    void start() throws InterruptedException {
        try {
            while (true) {
                for (int i = 0; i < size; i++) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(String.valueOf(i));
                }
                //Thread.sleep(500);
                GC.printGCMetricks();

            }
        } catch (RuntimeException e) {
            return;
        }

    }
}
