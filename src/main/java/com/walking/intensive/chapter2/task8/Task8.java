package com.walking.intensive.chapter2.task8;

/**
 * Добираясь в школу на трамвае Вова проверяет, является ли купленный билет счастливым.
 * Если является, то нужно загадать желание и съесть билетик.
 *
 * <p>Билет содержит 6 цифр, комбинации подбираются случайным образом от 000000 до 999999.
 *
 * <p>Билет считается счастливым, если сумма первых трех цифр равна сумме последних трех цифр.
 *
 * <p>Пример: 123411 – счастливый (1 + 2 + 3 == 4 + 1 + 1).
 *
 * <p>Реализуйте метод getHappyTicketChance(), который будет возвращать вероятность
 * выпадения счастливого билета.
 *
 * <p>P.S. Вероятность – это отношение благоприятных исходов к числу всех исходов.
 * Вероятность не может принимать значение больше 1.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task8 {
    public static void main(String[] args) {

        System.out.println("\n");
        long startTimeV1 = System.currentTimeMillis();
        getHappyTicketChanceVer1();
        long endtTimeV1 = System.currentTimeMillis();
        System.out.println("1. Время выполнения версии с 2-мя циклами от 0 до 999 = " + (endtTimeV1 - startTimeV1) + "мс");
        System.out.println("\n");

        long startTimeV2 = System.currentTimeMillis();
        getHappyTicketChanceVer2();
        long endtTimeV2 = System.currentTimeMillis();
        System.out.println("2. Время выполнения версии с 5-ью циклами от 0 до 9 = " + (endtTimeV2 - startTimeV2) + "мс");
        System.out.println("\n");

        long startTimeV3 = System.currentTimeMillis();
        getHappyTicketChanceVer3();
        long endtTimeV3 = System.currentTimeMillis();
        System.out.println("3. Время выполнения версии с 4-мя циклами = " + (endtTimeV3 - startTimeV3) + "мс");
        System.out.println("\n");

        long startTimeV4 = System.currentTimeMillis();
        getHappyTicketChanceVer4();
        long endtTimeV4 = System.currentTimeMillis();
        System.out.println("4. Время выполнения с 2-мя циклами  = " + (endtTimeV4 - startTimeV4) + "мс");
        System.out.println("\n");
    }

    //   Перебор через 2 цикла от 0 до 999
    static double getHappyTicketChanceVer1() {
        int leftDigits = 0;
        int rightDigits = 0;
        double Equality = 0;
        double Probability;

        for (int i = 0; i < 1000; i++) {
            if (i < 10) {
                leftDigits = (i % 10);
            } else if (i < 99) {
                leftDigits = i / 10 + (i % 10);
            } else {
                leftDigits = i / 100 + (i % 100) / 10 + (i % 10);
            }

            for (int j = 1; j < 1000; j++) {
                if (leftDigits == rightDigits) {
                    Equality++;
                }
                if (j < 10) {
                    rightDigits = (j % 10);
                } else if (j < 99) {
                    rightDigits = j / 10 + (j % 10);
                } else {
                    rightDigits = j / 100 + (j % 100) / 10 + (j % 10);
                }
            }
        }

        System.out.println("Вероятность счастливого билета = " + Equality / (1000000));
        return Probability = Equality / (1000000);
    }

    //   Перебор через 5 циклов от 0 до 9
    static double getHappyTicketChanceVer2() {
        double Equality = 0;
        double Probability;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 10; m++) {
                            int n = i + j + k - (l + m);
                            if (n >= 0 && n < 10)
                                Equality++;
                        }
                    }
                }
            }
        }

        System.out.println("Вероятность счастливого билета = " + Equality / (1000000));
        return Probability = Equality / (1000000);
    }

    //   Подсчёт через 4 цикла
    static double getHappyTicketChanceVer3() {
        double luckyTiketsNumber = 0;
        double Probability;

        for (int i = 0; i < 14; i++) {
            int luckyTiketsNumberInOneAmount = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        if (i == j + k + l) {
                            luckyTiketsNumberInOneAmount += 1;
                        }
                    }
                }
            }
            luckyTiketsNumber += luckyTiketsNumberInOneAmount * luckyTiketsNumberInOneAmount;
        }
        luckyTiketsNumber *= 2;

        System.out.println("Вероятность счастливого билета = " + luckyTiketsNumber / (1000000));
        return Probability = luckyTiketsNumber / (1000000);
    }

    //   Оптимизированная версия
    static double getHappyTicketChanceVer4() {
        double luckyTiketsNumber = 0;
        double Probability;

        for (int i = 0; i < 14; i++) {
            int luckyTiketsNumberInOneAmount = 0;
            for (int j = 0 ; j < Math.min(10, i + 1); j++) {
                luckyTiketsNumberInOneAmount += Math.min(9, i - j) - Math.max(0, i - j - 9) + 1;
            }
            luckyTiketsNumber += luckyTiketsNumberInOneAmount * luckyTiketsNumberInOneAmount;
        }
        luckyTiketsNumber *= 2;

        System.out.println("Вероятность счастливого билета = " + luckyTiketsNumber / (1000000));
        return Probability = luckyTiketsNumber / (1000000);
    }
}
