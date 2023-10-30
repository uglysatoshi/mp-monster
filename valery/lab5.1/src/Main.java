import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите значение a: "); int a = in.nextInt();
        System.out.print("Введите значение b: "); int b = in.nextInt();
        int z = Math.min(2*a, b+a) + Math.min(2*a - b, b); // нахождение минимальных значений и их суммирование
        System.out.println("Z = " + z);
    }

    public static int sum(int value) { // функция суммирования
        char[] arr = (Integer.toString(value)).toCharArray();
        int sum = 0;
        for (char anArr : arr) {
            sum += anArr - 48;
        }
        return sum;
    }
    public static void Medium() {
        System.out.println("Поиск счастливых чисел в диапозоне [400000;400999]");
        for (int i = 400000; i < 400999; i++) {
            if ((sum(i / 1000)) == (sum(i % 1000))) { // если части идентичны
                System.out.println("Число " + i + " является счастливым");
            }
        }
    }

    public static void Hard() {
        Scanner in = new Scanner (System.in);
        System.out.print("Введите число A: "); int A = in.nextInt();
        System.out.print("Введите число B: "); int B = in.nextInt();
        System.out.print("Введите число C: "); int C = in.nextInt();
        System.out.print("Введите число D: "); int D = in.nextInt();
        System.out.print("Для пары чисел A и В ");
        HardRecursion(A,B);
        System.out.print("Для пары чисел A и С ");
        HardRecursion(A,C);
        System.out.print("Для пары чисел A и D ");
        HardRecursion(A,D);
    }
    private static void HardRecursion(int A, int B) {
        while(A > B) A -= B; // отнимаем число пока
        // если выполняется условие выводим и выходим, иначе продолжение рекурсии
        if(A % B == 0) System.out.println("наибольший общий делитель: " + B);
        else HardRecursion(B, A);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}