package sort;

import edu.princeton.cs.algs4.StdRandom;

import static sort.Selection.*;

public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[50];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        Insertion.sort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }
    }
}
