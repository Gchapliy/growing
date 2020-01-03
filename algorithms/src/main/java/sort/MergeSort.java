package sort;

import java.util.Arrays;
import java.util.Random;

/**
 *                          ***Сортировка слиянием***
 * При сортировке слиянием мы разделяем массив пополам до тех пор, пока
 * каждый участок не станет длиной в один элемент. Затем эти участки
 * возвращаются на место (сливаются) в правильном порядке.
 *
 * Сложность	Наилучший случай	В среднем	Наихудший случай
 * Время	        O(n·log n)	    O(n·log n)	    O(n·log n)
 * Память	          O(n)	            O(n)	        O(n)
 */
public class MergeSort {
    private static Random random;

    public static void main(String[] args) {
        random = new Random();
        int[] a = new int[20];

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(200) - 100;
        }
        System.out.println("before sorting: " + Arrays.toString(a));
        mergeSort(a,0, a.length);
        System.out.println("after sorting: " + Arrays.toString(a));
    }

    private static void mergeSort(int[] a, int low, int high) {
        if(high - low < 2) return;
        int mid = (low + high) >>> 1;
        mergeSort(a, low, mid);
        mergeSort(a, mid, high);
        int[] b = Arrays.copyOfRange(a, low, mid);
        for (int i = low, j = mid, k = 0; k < b.length; i++) {
            if(j == high || b[k] <= a[j]){
                a[i] = b[k++];
            }else {
                a[i] = a[j++];
            }
        }
    }
}
