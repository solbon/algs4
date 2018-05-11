package sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import static sort.Selection.less;

/*
    Сортировка слиянием
 */
public class Merge {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
//        System.out.println("lo = [" + lo + "], mid = [" + mid + "], hi = [" + hi + "]");
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
//        System.out.println("merge(a, " + lo + ", " + mid + ", " + hi + ")");
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];

        }
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(100);
        }
        Stopwatch timer = new Stopwatch();
        sort(a);
        System.out.println(timer.elapsedTime());
//        for (int i = 0; i < a.length; i++) {
//            if (i % 50 == 0) System.out.println();
//            System.out.printf("%2d ", a[i]);
//        }
    }
}
