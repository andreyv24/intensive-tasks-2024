package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    static boolean ifTriangleExist(double a, double b, double c) {
        if ((a + b) > c && (a + c) > b && (b + c) > a) {
            return true;
        }
        return false;
    }

    static double getTrianglePerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    static double getTriangleSquare(double a, double b, double c) {
        double perimeter = getTrianglePerimeter(a, b, c);
        return Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        if (ifTriangleExist(a, b, c)) {
            return getTriangleSquare(a, b, c);
        } else
            return -1;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        double[] Heights = new double[3];
        if (ifTriangleExist(a, b, c)) {
            double square = getTriangleSquare(a, b, c);
            double Ha = (2 * square) / a;
            double Hb = (2 * square) / b;
            double Hc = (2 * square) / c;
            Heights[0] = Ha;
            Heights[1] = Hb;
            Heights[2] = Hc;
            Arrays.sort(Heights);
            return Heights;
        } else
            return new double[]{};
    }
    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        double[] Medians = new double[3];
        if (ifTriangleExist(a, b, c)) {
            double Ma = 0.5 * (Math.sqrt((2 * b * b) + (2 * c * c) - (a * a)));
            double Mb = 0.5 * (Math.sqrt((2 * a * a) + (2 * c * c) - (b * b)));
            double Mc = 0.5 * (Math.sqrt((2 * a * a) + (2 * b * b) - (c * c)));
            Medians[0] = Ma;
            Medians[1] = Mb;
            Medians[2] = Mc;
            Arrays.sort(Medians);
            return Medians;
        } else
            return new double[]{};
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        double[] Bisectors = new double[3];
        if (ifTriangleExist(a, b, c)) {
            double Ba = (Math.sqrt((b * c) * (b + c + a) * (b + c - a))) / (b + c);
            double Bb = (Math.sqrt((a * c) * (a + c + b) * (a + c - b))) / (a + c);
            double Bc = (Math.sqrt((a * b) * (a + b + c) * (a + b - c))) / (a + b);
            Bisectors[0] = Ba;
            Bisectors[1] = Bb;
            Bisectors[2] = Bc;
            Arrays.sort(Bisectors);
            return Bisectors;
        } else
            return new double[]{};
    }
    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        double[] Angles = new double[3];
        if (ifTriangleExist(a, b, c)) {
            double COSa = ((b * b) + (c * c) - (a * a)) / (2 * b * c);
            double COSb = ((a * a) + (c * c) - (b * b)) / (2 * a * c);
            double COSg = ((a * a) + (b * b) - (c * c)) / (2 * a * b);
            Angles[0] = Math.toDegrees(Math.acos(COSa));
            Angles[1] = Math.toDegrees(Math.acos(COSb));
            Angles[2] = Math.toDegrees(Math.acos(COSg));
            Arrays.sort(Angles);
            return Angles;
        } else
            return new double[]{};
    }
    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (ifTriangleExist(a, b, c)) {
            double perimeter = getTrianglePerimeter(a, b, c);
            double square = getTriangleSquare(a, b, c);
            double rInt = square / perimeter;
            return rInt;
        }
        return -1;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (ifTriangleExist(a, b, c)) {
            double square = getTriangleSquare(a, b, c);
            double rOut = (a * b * c) / (4 * square);
            return rOut;
        } else
            return -1;
    }
    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        //        Место для вашего кода

        return 0; // Заглушка. При реализации - удалить
    }
}