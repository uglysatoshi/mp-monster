import java.util.Scanner;

public class Main {
    public static void Base () {
        Scanner scan = new Scanner(System.in);
        // Объявляем переменную a и вводим ее
        System.out.print("Введите сторону равностороннего треугольника: ");
        double a = scan.nextDouble();
        // Проводим проверку на отрицательность
        while (a <= 0) {
            System.out.print("Сторона треугольника не может быть отрицательной или равна нулю\nВведите значение заново: ");
            a = scan.nextDouble();
        }
        // Находим высоту треугольника по формуле1
        double h = a * Math.sqrt(3) / 2;
        // Выводим значение высоты
        System.out.printf("Высота треугольника со сторонами равными %.3f будет равна %.4f\n\n", a,h);
    }

    public static void Medium () {
        // Создаем переменные и передаем в них значения по заданию
        double x = 1.9;
        double a = -0.9;
        // Объявляем переменные и находим их значения по формуле из задания
        double w = Math.pow(x, 2) * Math.sqrt(Math.abs(a + x));
        double z = Math.pow(Math.cos(a), 2) + Math.pow(w, 2);
        double y = a * Math.pow(z, 7) + Math.pow(Math.sin(w), 2);
        // Выводим значения w, z, y
        System.out.printf("w = %.4f\nz = %.4f\ny = %.4f\n\n", w, z, y);
    }

    public static void Hard () {
        Scanner scan = new Scanner(System.in);
        // Объявляем переменные радиусов и вводим их
        System.out.print("Введите радиусы r1, r2, r3: ");
        double r1 = scan.nextDouble();
        double r2 = scan.nextDouble();
        double r3 = scan.nextDouble();
        // Проводим проверка на отрицательность
        while (r1 <= 0 || r2 <= 0 || r3 <= 0) {
            System.out.print("Радиус не может быть отрицательным или равен нулю\nВведите значения r1, r2, r3 заново: ");
            r1 = scan.nextDouble();
            r2 = scan.nextDouble();
            r3 = scan.nextDouble();
        }
        // Находим объемы шаров
        double v1 = (double) 4 / 3 * Math.PI * Math.pow(r1, 3);
        double v2 = (double) 4 / 3 * Math.PI * Math.pow(r2, 3);
        double v3 = (double) 4 / 3 * Math.PI * Math.pow(r3, 3);
        // Находим значение Z по формуле из задания
        double Z = (v1 + v2 + v3) / 3;
        // Выводим Z
        System.out.printf("Z = %.4f\n", Z);

    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}