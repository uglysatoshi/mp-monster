import java.util.Scanner;

public class Main {
    static final double scale = Math.pow(10,3);
    static Scanner in = new Scanner(System.in);
    public static void Base() { // функция базового уровня
        // Так как ввод T в функцию происходит через константы, следовательно ограничение ввода не требуется и деления на ноль никогда не произойдет
        System.out.print("Введите амплитуду колебания: "); double a = in.nextDouble(); // ввод значения a
        final int T = 2; // объявляем T как константу и передаем в нее 2
        final double m = 0.2; // объявляем m как константу и передаем в нее 0.2
        double W = (2 * Math.pow(Math.PI, 2) * Math.pow(a, 2) * m) / Math.pow(T, 2); // функция W
        System.out.println("Энергия материальной точки: " + Math.ceil(W * scale) / scale); // вывод W
    }

    public static void Medium() {
        // так как под корнем находится модуль, корень не может быть отрицательным
        final int m = 2; // объявляем m как константу и передаем в нее 2
        final double x = 1.1; // объявляем x как константу и передаем в нее 1.1
        double y = Math.sin((Math.sqrt(Math.abs(x))) + Math.pow(Math.tan(Math.toDegrees(Math.pow(x, 4) + Math.pow(m, 2))), 3)); // Функция y
        System.out.println("Функция Y: " + Math.ceil(y * scale) / scale); // Выводим y
    }

    public static void Hard() {
        // Так как ввод значений в функцию происходит через константы, следовательно ограничение ввода не требуется и деления на ноль никогда не произойдет
        final double C = Math.pow(10, -6); // через функцию pow создаем значение 10^-6  и передаем в C
        final double L = 0.04; // Передаем в L 0.04
        final int U = 100; // Передаем в U 100
        double I = U * Math.sqrt(C / L); // Находим I
        double W = (L * Math.pow(I, 2) / 2); // Находим W
        System.out.println("Амплитуда силы тока: " + I + " A"); // Выводим I
        System.out.println("Полная энергия: " + Math.ceil(W * scale) / scale + " Дж"); // Выводим W
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}