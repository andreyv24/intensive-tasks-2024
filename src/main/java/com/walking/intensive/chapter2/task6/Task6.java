package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (isNumbersNegative(m, n)) {
            return -1;
        }
        int lcm = Math.max(m, n);
        while (lcm % Math.min(m, n) != 0) {
            lcm += Math.max(m, n);
        }
        return lcm;
//        return (m * n) / getGcd(m, n); альтернативный вариант.
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (isNumbersNegative(m, n)) {
            return -1;
        }
        int gcd = Math.min(m, n);
        while (n % gcd != 0 || m % gcd != 0) {
            gcd--;
        }
        return gcd;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью алгоритма Евклида
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {
        if (isNumbersNegative(m, n)) {
            return -1;
        }
        if (m == n) {
            return m;
        }
        return m > n ? getGcdByEuclideanAlgorithm(m - n, n) : getGcdByEuclideanAlgorithm(m, n - m);
    }

    static boolean isNumbersNegative(int m, int n) {
        return (n <= 0 || m <= 0);
    }
}
