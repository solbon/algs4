package sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import static sort.Selection.exch;
import static sort.Selection.less;

public class Quick {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partiton(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partiton(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[lo];
        int i = lo, j = hi;
        while (true) {
            while (less(a[++i], pivot)) {
                if (i == hi) break;
            }
            while (less(pivot, a[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        for (int n = 10; n < Integer.MAX_VALUE; n *= 10) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = StdRandom.uniform(100);
            }
            Stopwatch timer = new Stopwatch();
            sort(a);
            System.out.println("n = " + n + ", time in sec = " + timer.elapsedTime());
        }
//        for (int i = 0; i < a.length; i++) {
//            if (i % 50 == 0) System.out.println();
//            System.out.printf("%2d ", a[i]);
//        }
    }
}
