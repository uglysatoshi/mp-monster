import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Обязательные правила для ввода\nx5 < x4 < x1 < x3 < x2\ny5 > y4 && y5 > y3; y2 > y3; y1 > y5 && y1 > y2\n");
        // Вводим координаты
        System.out.print("Введите значения x1 и y1: ");
        double x1 = scan.nextDouble(); double y1 = scan.nextDouble();
        System.out.print("Введите значения x2 и y2: ");
        double x2 = scan.nextDouble(); double y2 = scan.nextDouble();
        System.out.print("Введите значения x3 и y3: ");
        double x3 = scan.nextDouble(); double y3 = scan.nextDouble();
        System.out.print("Введите значения x4 и y4: ");
        double x4 = scan.nextDouble(); double y4 = scan.nextDouble();
        System.out.print("Введите значения x5 и y5: ");
        double x5 = scan.nextDouble(); double y5 = scan.nextDouble();
        // Проводим проверку
        while(!((x5 < x4 && x4 < x1 && x1 < x3 && x3 < x2) && (y5 > y4 && y5 > y3 && y2 > y4 && y2 > y3 && y1 > y5 && y1 > y2))) {
            System.out.print("Одно из выше описанных условий не выполнено \n");
            System.out.print("Введите значения x1 и y1: ");
            x1 = scan.nextDouble(); y1 = scan.nextDouble();
            System.out.print("Введите значения x2 и y2: ");
            x2 = scan.nextDouble(); y2 = scan.nextDouble();
            System.out.print("Введите значения x3 и y3: ");
            x3 = scan.nextDouble(); y3 = scan.nextDouble();
            System.out.print("Введите значения x4 и y4: ");
            x4 = scan.nextDouble(); y4 = scan.nextDouble();
            System.out.print("Введите значения x5 и y5: ");
            x5 = scan.nextDouble(); y5 = scan.nextDouble();
        }
        // Находим площадь по сумме площадей трех треугольников
        double S = calculateTriangleArea(x1,y1,x5,y5,x4,y4) + calculateTriangleArea(x1,y1,x4,y4,x3,y3) + calculateTriangleArea(x1,y1,x2,y2,x3,y3);
        // Выводим результат
        System.out.printf("Площадь пятиугольника по трем треугольникам: %.2f\n\n", S);
    }
    public static double calculateTriangleArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Вычисляем стороны
        double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double c = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        // находим полусумму
        double s = (a + b + c) / 2.0;
        // Выводим результат по формуле
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    public static void Medium() {
        System.out.print("Таблица истинности: \n");
        // Проходимся по каждому логическому значению таблицы
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    logic(i, j, k);
                }
            }
        }
        System.out.print("\n\n");
    }
    private static void logic(int X, int Y, int Z) {
        // Конвертируем int в bool
        boolean X1 = X == 1;
        boolean Y1 = Y == 1;
        boolean Z1 = Z == 1;
        // Выводим строку таблицы по переданным значениям
        System.out.printf("X = %d Y = %d Z = %d  (!X and Z) or (Y and !Z) = %b\t!Y or (X and !Z) and Z = %b\n", X, Y, Z,(!X1 && Z1) || (Y1 && !Z1), !Y1 || (X1 && !Z1) && Z1);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        double a, b;
        System.out.print("Введите левую и правую границы отрезка (a < b): ");
        do {
            a = scan.nextDouble();
            b = scan.nextDouble();
        } while(a > b);
        double eps = 1e-6;
        System.out.printf("Корень уравнения на отрезке [%.1f;%.1f] = %f", a, b, Root(a, b, eps));
    }
    // Рекурсивная функция для нахождения корня уравнения f(x) = 0 методом деления отрезка пополам
    public static double Root(double a, double b, double epsilon) {
        double midpoint = (a + b) / 2.0; // Середина текущего отрезка
        // Проверяем условие окончания рекурсии
        if (Math.abs(b - a) < epsilon) {
            return midpoint; // Возвращаем середину отрезка как приближенный корень
        }
        double fa = f(a);
        double fmid = f(midpoint);
        // Определяем, на какой половине отрезка находится корень и продолжаем поиски в соответствующей половине
        if (fa * fmid < 0) {
            return Root(a, midpoint, epsilon); // Корень находится в левой половине
        } else {
            return Root(midpoint, b, epsilon); // Корень находится в правой половине
        }
    }

    // Функция f(x)
    public static double f(double x) {
        return x*x-2; // Пример функции x^2 - 2
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}