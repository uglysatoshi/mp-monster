import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static public int factorial(int number) {
        // функция факториала
        int result = 1;
        for (int  i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
    public static void Base() {
        System.out.print("Введите количество элементов последовательности: "); int N = in.nextInt();
        double result = 1; // приравниваем result первому слагаемому последовательности
        System.out.print("Введите x (x > 0): "); double x = in.nextDouble();
        for(int i = 1; i <= N-1; i++) { // N - 1 тк 1 член мы расчитываем сразу
            // условие для избежания деления на ноль
            if(factorial(i) == 0) {
                continue;
            }
            result = ((Math.cos(Math.toDegrees(i * (Math.PI / 4)))) / factorial(i)) * Math.pow(x, i);
        }
        System.out.print("Сумма последовательности до элемента " + N + " при x равном " + x + " равна: ");
        System.out.printf("%.5f", result);
    }
    public static void main(String[] args) {
        Base();
    }
}