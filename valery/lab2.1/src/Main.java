import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void Base() {
        boolean X = false;
        boolean Y = false;
        boolean Z = true;
        boolean answer = X & Y | !Z ;
        System.out.println("Логическое выражение А: " + answer);
        answer = !X | !Z;
        System.out.println("Логическое выражение B: " + answer);
        answer = !(X & Z) & Y;
        System.out.println("Логическое выражение C: " + answer);
    }

    public static void Medium() {
        System.out.print("Введите значение: ");double A = in.nextDouble();
        if ((0 < A) & (A < 5000)) {
            System.out.println("Процент начисления: 20% годовых");
        }
        if ((A > 5000) & (A < 10000)) {
            System.out.println("Процент начисления: 22% годовых");
        }
        if ((A < 0) | (A > 10000)) {
            System.out.println("Процентаж по данному значению отсутсвует");
        }
    }

    public static void Hard() {
        System.out.print("Введите значение x: ");double x = in.nextDouble();
        System.out.print("Введите значение y: ");double y = in.nextDouble();
        if((Math.pow(x, 2) + Math.pow(y, 2) <= 2) & (Math.pow(x + 1, 2) + Math.pow(y, 2) >= 1)) {
            System.out.println("Точка попадает в границы");
        }
        else {
            System.out.println("Точка не попадает в границы");
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}