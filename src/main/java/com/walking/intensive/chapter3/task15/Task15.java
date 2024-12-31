package com.walking.intensive.chapter3.task15;

/**
 * Существует город, состоящий из N x N блоков, где каждый блок содержит одно здание в форме вертикальной
 * квадратной призмы. Линия горизонта города — это внешний контур, образованный всеми зданиями,
 * если смотреть на город издалека. Линия горизонта с каждого из сторон света — севера,
 * востока, юга и запада — может отличаться.
 *
 * <p>Каждое здание имеет определенную высоту, измеряемую в этажах.
 *
 * <p>Разрешено увеличивать высоту любого количества зданий на любую величину этажей
 * (величина может быть разной для каждого здания). Высота здания с нулевой высотой также может быть увеличена.
 * Увеличение высоты здания не должно повлиять на горизонт города ни с какой стороны света.
 *
 * <p>Реализуйте метод getMaxFloors() с учетом условий ниже.
 *
 * <p>Входящий параметр: массив city[][], где city[r][c] представляет высоту здания,
 * расположенного в блоке в строке r и столбце c. Высота здания не может быть отрицательной.
 *
 * <p>Возвращаемое значение: максимально возможное количество достроенных этажей,
 * на которое можно увеличить высоту зданий без изменения горизонта города
 * с любого направления по сторонам света.
 *
 * <p>Пример:
 *
 * <p>Входящий массив: city[ ][ ] = [[2,1],[1,3]].
 *
 * <p>Возвращаемое значение: 2.
 *
 * <p>Пояснение: всего 4 здания, 2 из которых имеют по 1 этажу, 1 здание - 2 этажа и 1 здание - 3 этажа.
 * Можно добавить максимум по 1 этажу к каждому одноэтажному дому чтобы ни одна из 4 линий горизонта не поменялась.
 * Итого 2 этажа.
 *
 * <p>При наличии некорректных входных данных верните из метода -1.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task15 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    static int getMaxFloors(int[][] city) {
        if (!checkInputData(city)) {
            return -1;
        }

        int northsMaxElement = getRowsMaxHeightBuilding(city,0,city.length);
        int eastsMaxElement = getColumnsMaxHeightBuilding(city, city.length,city.length - 1);
        int southsMaxElement = getRowsMaxHeightBuilding(city,city.length - 1, city.length);
        int westsMaxElement = getColumnsMaxHeightBuilding(city, city.length - 1 ,0);
        int numberCompletedFloors = 0;

        numberCompletedFloors = getRowsNumberCompletedFloors(city, 0, city.length, westsMaxElement, northsMaxElement, eastsMaxElement);
        numberCompletedFloors += getColumnNumberCompletedFloors(city, city.length - 1, city.length - 1, eastsMaxElement);
        numberCompletedFloors += getRowsNumberCompletedFloors(city, city.length - 1, 0, westsMaxElement, southsMaxElement, eastsMaxElement);
        numberCompletedFloors += getColumnNumberCompletedFloors(city, 0, city.length - 1, westsMaxElement);

        return numberCompletedFloors;
    }

    static boolean checkInputData(int[][] city) {
        if (city.length == 0) {
            return false;
        }

        for (int[] row : city) {
            if (row.length == 0) {
                return false;
            }

            for (int element : row) {
                if (city.length != row.length || element < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static int getRowsMaxHeightBuilding(int[][] city, int row, int column) {
        int maxHeightBuilding = 0;

        for (int j = 0; j < column; j++) {
            if (city[row][j] > maxHeightBuilding) {
                maxHeightBuilding = city[row][j];
            }
        }
        return maxHeightBuilding;
    }

    static int getColumnsMaxHeightBuilding(int[][] city, int row, int column) {
        int maxHeightBuilding = 0;

        for (int i = 0; i < row; i++) {
            if (city[i][column] > maxHeightBuilding) {
                maxHeightBuilding = city[i][column];
            }
        }
        return maxHeightBuilding;
    }

    static int getRowsNumberCompletedFloors(int[][] city, int row, int column, int maxLeftColumnElement, int maxRowElement, int maxRightColumnElement) {
        int rowsNumberCompletedFloors = 0;

        for (int j = 0; j < city[row].length; j++) {
            if (j == 0) {
                rowsNumberCompletedFloors = rowsNumberCompletedFloors + (Math.min(maxLeftColumnElement, maxRowElement) - city[row][0]);
                continue;
            }
            if (j == column - 1) {
                rowsNumberCompletedFloors = rowsNumberCompletedFloors + (Math.min(maxRowElement, maxRightColumnElement) - city[row][column - 1]);
                continue;
            }
            rowsNumberCompletedFloors = rowsNumberCompletedFloors + (maxRowElement - city[row][j]);
        }
        return rowsNumberCompletedFloors;
    }

    static int getColumnNumberCompletedFloors(int[][] city, int row, int column, int maxColumnElement) {
        int columnNumberCompletedFloors = 0;

        for (int i = 1; i < column; i++) {
            columnNumberCompletedFloors = columnNumberCompletedFloors + (maxColumnElement - city[i][row]);
        }
        return columnNumberCompletedFloors;
    }
}
