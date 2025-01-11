package com.walking.intensive.chapter1.task2;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        if (flatNumber <= 0 || floorAmount <= 0 || entranceAmount <= 0) {
            return "Некорректные входные данные";
        }

        int flatsAmount = entranceAmount * floorAmount * 4;
        if (flatNumber > flatsAmount) {
            return "Такой квартиры не существует";
        }

        int entranceNumber = (flatNumber / (floorAmount * 4));
        if ((flatNumber % (floorAmount * 4)) != 0) {
            entranceNumber += 1;
        }

        int floorNumber = (flatNumber - ((floorAmount * 4) * (entranceNumber - 1))) / 4;
        if (((flatNumber - ((floorAmount * 4) * (entranceNumber - 1))) % 4) != 0) {
            floorNumber += 1;
        }

        int maxNumberFlatPerFloor = ((entranceNumber - 1) * floorAmount * 4) + floorNumber * 4;
        if (flatNumber == maxNumberFlatPerFloor) {
            return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber +
                    " этаж," + " справа от лифта, вправо";
        }
        if (flatNumber == maxNumberFlatPerFloor - 1) {
            return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber +
                    " этаж," + " справа от лифта, влево";
        }
        if (flatNumber == maxNumberFlatPerFloor - 2) {
            return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber +
                    " этаж," + " слева от лифта, вправо";
        }

        return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber +
                " этаж," + " слева от лифта, влево";
    }
}
