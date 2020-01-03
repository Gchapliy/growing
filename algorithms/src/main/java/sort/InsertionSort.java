package sort;

import java.util.Arrays;
import java.util.Random;

/**
 *                                      ***Сортировка вставками***
 * Сортировка вставками работает, проходя по массиву и перемещая нужное значение
 * в начало массива. После того, как обработана очередная позиция, мы знаем,
 * что все позиции до нее отсортированы, а после нее — нет.
 *
 * Сложность	Наилучший случай	В среднем	Наихудший случай
 * Время	            O(n)	        O(n2)	        O(n2)
 * Память	            O(1)	        O(1)	        O(1)
 */
public class InsertionSort {
    private static Random random;

    public static void main(String[] args) {
        random = new Random();
        int[] a = new int[20];

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(200) - 100;
        }
        System.out.println("before sorting: " + Arrays.toString(a));
        insertionSort(a);
        System.out.println("after sorting: " + Arrays.toString(a));
    }

    public static void insertionSort(int[] items) {
        int sortedRangeEndIndex = 1;

        while (sortedRangeEndIndex < items.length)
        {
            if (items[sortedRangeEndIndex] < items[sortedRangeEndIndex - 1])
            {
                int insertIndex = FindInsertionIndex(items, items[sortedRangeEndIndex]);
                Insert(items, insertIndex, sortedRangeEndIndex);
            }

            sortedRangeEndIndex++;
        }
    }

    private static int FindInsertionIndex(int[] items, int valueToInsert)
    {
        for (int index = 0; index < items.length; index++) {
            if (items[index] > valueToInsert)
            {
                return index;
            }
        }

        throw new IllegalArgumentException("The insertion index was not found");
    }

    private static void Insert(int[] itemArray, int indexInsertingAt, int indexInsertingFrom)
    {
        // itemArray =       0 1 2 4 5 6 3 7
        // insertingAt =     3
        // insertingFrom =   6
        //
        // Действия:
        //  1: Сохранить текущий индекс в temp
        //  2: Заменить indexInsertingAt на indexInsertingFrom
        //  3: Заменить indexInsertingAt на indexInsertingFrom в позиции +1
        //     Сдвинуть элементы влево на один.
        //  4: Записать temp на позицию в массиве + 1.

        // Шаг 1.
        int temp = itemArray[indexInsertingAt];

        // Шаг 2.

        itemArray[indexInsertingAt] = itemArray[indexInsertingFrom];

        // Шаг 3.
        for (int current = indexInsertingFrom; current > indexInsertingAt; current--)
        {
            itemArray[current] = itemArray[current - 1];
        }

        // Шаг 4.
        itemArray[indexInsertingAt + 1] = temp;
    }
}
