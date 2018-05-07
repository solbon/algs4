package sort;

import edu.princeton.cs.algs4.StdRandom;

import static sort.Selection.*;

public class Shell {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 0;
        while (h < N/3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j = j - h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        Shell.sort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }
    }

}
