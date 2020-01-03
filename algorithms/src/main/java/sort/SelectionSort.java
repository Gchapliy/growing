package sort;

import java.util.Arrays;
import java.util.Random;

/**
 *                                      ***Сортировка выбором***
 * это некий гибрид между пузырьковой и сортировкой вставками. Как и сортировка пузырьком,
 * этот алгоритм проходит по массиву раз за разом, перемещая одно значение на правильную позицию.
 * Однако, в отличие от пузырьковой сортировки, он выбирает наименьшее неотсортированное значение
 * вместо наибольшего. Как и при сортировке вставками, упорядоченная часть массива расположена в
 * начале, в то время как в пузырьковой сортировке она находится в конце.
 *
 * Сложность	Наилучший случай	В среднем	Наихудший случай
 *  Время	            O(n)	        O(n2)	        O(n2)
 Память	            O(1)	        O(1)	        O(1)
 */
public class SelectionSort {
    private static Random random;

    public static void main(String[] args) {
        random = new Random();
        int[] a = new int[20];

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(200) - 100;
        }
        System.out.println("before sorting: " + Arrays.toString(a));
        selectionSort(a);
        System.out.println("after sorting: " + Arrays.toString(a));
    }

    public static void selectionSort(int[] items){
        int sortedRangeEnd = 0;

        while (sortedRangeEnd < items.length)
        {
            int nextIndex = FindIndexOfSmallestFromIndex(items, sortedRangeEnd);
            int temp = items[sortedRangeEnd];
            items[sortedRangeEnd] = items[nextIndex];
            items[nextIndex] = temp;

            sortedRangeEnd++;
        }
    }

    private static int FindIndexOfSmallestFromIndex(int[] items, int sortedRangeEnd)
    {
        int currentSmallest = items[sortedRangeEnd];
        int currentSmallestIndex = sortedRangeEnd;

        for (int i = sortedRangeEnd + 1; i < items.length; i++)
        {
            if (currentSmallest < items[i])
            {
                currentSmallest = items[i];
                currentSmallestIndex = i;
            }
        }

        return currentSmallestIndex;
    }
}
