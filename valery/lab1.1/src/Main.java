import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static final double scale = Math.pow(10, 3);
    public static void Hard() {
        // Высокий уровень
        System.out.print("Введите x: "); double x = in.nextDouble();
        System.out.print("Введите y: "); double y = in.nextDouble();
        System.out.print("Введите a: "); double a = in.nextDouble();
        System.out.print("Введите b: "); double b = in.nextDouble();
        // подкоренное выражение не может быть отрицательным
        while((x + b - a) < 0) {
            System.out.println("Подкоренное значение меньше нуля, введите значеня x, b, a заново");
            System.out.print("Введите x: "); x = in.nextDouble();
            System.out.print("Введите a: "); a = in.nextDouble();
            System.out.print("Введите b: "); b = in.nextDouble();
        }
        // логарифм отрицательный
        while (y < 0) {
            System.out.println("Логарифм от отрицательного значения не существует, введите y заново");
            System.out.print("Введите y: "); y = in.nextDouble();
        }
        // Деление на ноль
        while(Math.atan(b + a) == 0) {
            System.out.println("Знаменатель не может быть равен нулю, введите значения b, a заново");
            System.out.print("Введите a: "); a = in.nextDouble();
            System.out.print("Введите b: "); b = in.nextDouble();
        }
        double K = (Math.sqrt((x + b - a)) + Math.log(y)) / Math.atan(b + a); // функция из базового задания
        System.out.println("Функция K = " + Math.ceil(K * scale) / scale); // вывод K
    }
    public static void Medium() {
        // средний уровень
        System.out.print("Введите x: "); double x = in.nextDouble();
        System.out.print("Введите y: "); double y = in.nextDouble();
        // логарифм отрицательный
        while (y < 0) {
            System.out.println("Логарифм от отрицательного значения не существует, введите y заново");
            System.out.print("Введите y: "); y = in.nextDouble();
        }
        while (Math.log(y) + 2 * Math.pow(x, 3) == 0) {
            System.out.println("Знаменатель не может быть равен нулю, введите значения y, x заново");
            System.out.print("Введите y: "); y = in.nextDouble();
            System.out.print("Введите x: "); x = in.nextDouble();
        }
        double L = (0.81 * Math.cos(Math.toDegrees(x))) / Math.log(y) + 2 * Math.pow(x, 3); // фунцкия из среднего уровня
        System.out.println("Функция L = " + Math.ceil(L * scale) / scale); // вывод L
    }

    public static void Base() {
        // Базовый уровень
        System.out.print("Введите x: "); double x = in.nextDouble();
        System.out.print("Введите y: "); double y = in.nextDouble();
        double M = Math.cos(Math.toDegrees(2*y)) + 3.6 * Math.pow(Math.exp(1), x); // функция из высокого уровня
        System.out.println("Функция M = " + Math.ceil(M * scale) / scale); // Вывод M
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}