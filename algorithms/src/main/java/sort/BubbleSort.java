package sort;

import java.util.Arrays;
import java.util.Random;

/**
 *                                      ***Пузырьковая сортировка***
 * Он проходит по массиву несколько раз, на каждом этапе перемещая самое большое значение из неотсортированных в конец массива.
 *
 * Сложность	Наилучший случай	В среднем	Наихудший случай
 *   Время	        O(n)	            O(n2)	        O(n2)
 *   Память	        O(1)	            O(1)	        O(1)
 */

public class BubbleSort {

    public static Random random;

    public static void main(String[] args) {
        random = new Random();
        int[] a = new int[20];

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(200) - 100;
        }
        System.out.println("before sorting: " + Arrays.toString(a));
        bubbleSort(a);
        System.out.println("after sorting: " + Arrays.toString(a));
    }

    private static void bubbleSort(int[] a){
        boolean swapped;

        do
        {
            swapped = false;
            for (int i = 1; i < a.length; i++) {
                if (a[i - 1] > a[i])
                {
                    int temp = a[i];
                    a[i] = a[i -1];
                    a[i - 1] = temp;

                    swapped = true;
                }
            }
        } while (swapped != false);
    }

}
