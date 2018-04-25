package algorythmanalysis;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {

    public static double timeTrial(int n) {
        int max = 1_000_000;
        int[] a = new int[n];
        for (int i = 0; i < n - 1; i++) {
            a[i] = StdRandom.uniform(-max, max);
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
//        int n = Integer.parseInt(args[0]);
        for (int n = 250; true; n = n * 2) {
            double time = timeTrial(n);
            System.out.printf("%7d %5.2f", n, time);
            System.out.println();
        }

    }
}
