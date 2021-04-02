package temp;

import java.util.HashMap;
import java.util.Map;

public class MeasurePerformance {
    private static Map<Integer, Integer> map;

    public static void main(String[] args) {
        prepare();
        long avg = 0;
        for (int i=0; i<50; i++) {
            long startTime = System.currentTimeMillis();
            run();
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.print(estimatedTime + " ");
            avg += estimatedTime;
        }
        avg /= 50;
        System.out.println("\n" + avg);
    }
    private static void prepare() {
        map = new HashMap<>();
        for (int i=0; i<10000000; i++) {
            map.put(i, i);
        }
    }
    private static void run() {
        for (int i=0; i<20000000; i++) {
            map.containsKey(i);
        }
    }
}
