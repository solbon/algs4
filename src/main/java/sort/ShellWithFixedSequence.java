/*
    Добавьте в сортировку Шелла вывод на каждом шаге количества сравнений,
    деленного на размер массива. Напишите клиент тестирования, который проверяет
    гипотезу, что это количество является небольшой константой, выполнив
    сортировку массивов случайных значений Double с размером массивов, которые
    равны возрастающим степеням 10, начиная со 100.
 */
package sort;

import edu.princeton.cs.algs4.StdRandom;

public class ShellWithFixedSequence {
    public static void sort(Comparable[] a) {
//        int[] ha = {1,4,13,40,121,364,1093,13880};
        int[] ha = {1,5,19,41,109,209,505,929,2161,3905,8929,16001,36289,64769,146305,260609};
        int h = ha[ha.length - 1];
        int N = a.length;
        int l = ha.length - 1;

        while (l >= 0 && h >= 1) {
            double count = 0;
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j = j - h) {
                    count++;
                    if (Selection.less(a[j], a[j-h]))
                        break;
                    Selection.exch(a, j, j - h);
                }
            }
            System.out.printf("h = %6d\t%f\n",h, count / a.length);
            if (l == 0) {
                break;
            }
            h = ha[--l];
        }
    }

    public static void main(String[] args) {
        Integer[] a = null;
        for (int i = 2; i < 12; i++) {

            int k = (int) Math.pow(10d, i);
            System.out.println("===== " + k + " ======");
            a = new Integer[k];
            for (int j = 0; j < a.length; j++) {
                a[j] = StdRandom.uniform(100);
            }
            ShellWithFixedSequence.sort(a);
        }
    }
}
