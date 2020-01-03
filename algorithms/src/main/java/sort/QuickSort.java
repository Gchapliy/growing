package sort;

import java.util.Arrays;
import java.util.Random;

/**
 *                                      ***Быстрая сортировка***
 * Он работает, рекурсивно повторяя следующие шаги:
 * Выбрать ключевой индекс и разделить по нему массив на две части.
 * Это можно делать разными способами, но мы используем случайное число.
 * Переместить все элементы больше ключевого в правую часть массива, а все элементы меньше ключевого — в левую.
 * Теперь ключевой элемент находится в правильной позиции — он больше любого элемента слева и меньше любого элемента справа.
 * Повторяем первые два шага, пока массив не будет полностью отсортирован.
 *
 * Сложность	Наилучший случай	В среднем	Наихудший случай
 * Время	      O(n·log n)	        O(n·log n)	      O(n2)
 * Память	      O(1)	            O(1)	          O(1)
 */

public class QuickSort {
    private static Random random;

    public static void main(String[] args) {
        random = new Random();
        int[] a = new int[20];

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(200) - 100;
        }
        System.out.println("before sorting: " + Arrays.toString(a));
        quickSort(a,0, a.length - 1);
        System.out.println("after sorting: " + Arrays.toString(a));
    }

    public static void quickSort(int[] a, int low, int high){
        if(low >= high) return;
        int pivot = a[low + random.nextInt(high - low + 1)];
        int i = low;
        int j = high;
        while (i <= j){
            while (a[i] < pivot)
                ++i;
            while (a[j] > pivot)
                --j;
            if(i <= j){
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                ++i;
                --j;
            }
        }
        quickSort(a, low, j);
        quickSort(a, i, high);
    }
}
