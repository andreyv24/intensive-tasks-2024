package com.walking.intensive.chapter3.task11;

/**
 * Реализуйте метод getOddSubArraysElementsSum() с учетом условий ниже.
 *
 * <p>Входной параметр метода - массив положительных целых чисел.
 *
 * <p>Возвращаемое значение - сумма элементов всех возможных подмассивов нечетной длины.
 * Подмассивом считается непрерывная последовательность элементов массива.
 *
 * <p>Например:
 *
 * <p>Входные данные: array = [1,4,2,5,3]
 *
 * <p>Подмассивы и суммы их элементов:
 *
 * <ul>
 * <li>[1] = 1
 * <li>[4] = 4
 * <li>[2] = 2
 * <li>[5] = 5
 * <li>[3] = 3
 * <li>[1,4,2] = 7
 * <li>[4,2,5] = 11
 * <li>[2,5,3] = 10
 * <li>[1,4,2,5,3] = 15
 * </ul>
 *
 * <p>Итоговая сумма: 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * <p>Возвращаемое значение: 58
 *
 * <p>Для пустого массива должен возвращаться 0.
 *
 * <p>При наличии любых некорректных данных - например, неположительных элементов входящего массива, метод должен
 * возвращать -1.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task11 {
    public static void main(String[] args) {
//        int[] inputArray1 = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] inputArray2 = new int[] {1, 2, 4, 0, 1, 10, 20};
//        int[] inputArray3 = new int[] {10, 9, 8, 7, 6, 5};
//        int[] inputArray4 = new int[] {1, 4 ,2 , 5, 3};
//        int[] inputArray5 = new int[] {3, 0, 1, 2,};
//        int[] inputArray6 = new int[] {1, 4 ,2};
//        getOddSubArraysElementsSum(inputArray1);
//        System.out.println("Сумма элементов всех возможных подмассивов нечетной длины по массиву 1 = " + getOddSubArraysElementsSum(inputArray1));
//        getOddSubArraysElementsSum(inputArray2);
//        System.out.println("Сумма элементов всех возможных подмассивов нечетной длины  по массиву 2 = " + getOddSubArraysElementsSum(inputArray2));
//        getOddSubArraysElementsSum(inputArray3);
//        System.out.println("Сумма элементов всех возможных подмассивов нечетной длины  по массиву 3 = " + getOddSubArraysElementsSum(inputArray3));
//        getOddSubArraysElementsSum(inputArray4);
//        System.out.println("Сумма элементов всех возможных подмассивов нечетной длины  по массиву 4 = " + getOddSubArraysElementsSum(inputArray4));
//        getOddSubArraysElementsSum(inputArray5);
//        System.out.println("Сумма элементов всех возможных подмассивов нечетной длины  по массиву 5 = " + getOddSubArraysElementsSum(inputArray5));
//        getOddSubArraysElementsSum(inputArray6);
//        System.out.println("Сумма элементов всех возможных подмассивов нечетной длины  по массиву 6 = " + getOddSubArraysElementsSum(inputArray6));
    }

    static int getOddSubArraysElementsSum(int[] array) {
        int sumElementsSubarray = 0;
        int i = 0;
        while (i < array.length) {
            if (array[i] < 0) {
                return -1;
            }

            int elementCounterInOddSubarrays = 0;
            int elementCounterInSubarrays = ((array.length - i) * (i + 1));
            elementCounterInOddSubarrays = (elementCounterInSubarrays + 1) / 2;
            sumElementsSubarray = sumElementsSubarray + elementCounterInOddSubarrays * array[i];
            i++;
        }
        return sumElementsSubarray;
    }
}
