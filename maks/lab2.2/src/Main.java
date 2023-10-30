import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массив
        double[] arr = new double[3];
        // Заполняем массив
        System.out.print("Введите 3 числа: ");
        for (int i = 0; i < arr.length; i++ ) {
            arr[i] = scan.nextDouble();
        }
        // Производим изменение элементов массива исходя из условия
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr[i] *= arr[i];
            } else {
                arr[i] = 0;
            }
            // Выводим каждый элемент после изменения
            System.out.printf("%d - %.1f\n", i+1, arr[i]);
        }
        System.out.print("\n");

    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем переменную суммы и вводим значение
        System.out.print("Введите сумму покупки: ");
        double sum = scan.nextDouble();
        // Производим проверку на отрицательность
        while(sum < 0) {
            System.out.print("Сумма не может быть отрицательной\nВведите значение заново: ");
            sum = scan.nextDouble();
        }
        // Производим изменения исходя из условий задачи
        if (sum > 500) {
            if (sum > 1000) {
                System.out.printf("Сумма после скидок: %.2f\n\n", sum * 0.95);
                return;
            }
            System.out.printf("Сумма после скидки: %.2f\n\n", sum * 0.9);
            return;
        }
        System.out.print("К данной сумме покупки скидки нет.\n\n");

    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Объявляем переменную a и вводим значение
        System.out.print("Введите трех значное число: ");
        int a = scan.nextInt();
        // Проверка является ли число трехзначным и положительным
        while(a > 999 || a < 100) {
            System.out.print("Число не является трехзначным\nВведите значение заново");
            a = scan.nextInt();
        }
        // Объявляем переменную b и вводим значение
        System.out.print("Введите число b: ");
        int b = scan.nextInt();
        // Находим сумму и произведение всех цифр
        int multiA = a/100 * (a%100)/10 * (a %100) % 10;
        int sumA = a/100 + (a%100)/10 + (a %100) % 10;
        // Проверяем больше ли число b произведения цифр числа а
        if(multiA > b) {
            System.out.printf("Произведение всех цифр %d больше числа %d\n", a, b);
        } else {
            System.out.printf("Произведение всех цифр %d меньше числа %d\n", a, b);
        }
        // Проверяем кратна ли суммы цифр числа a трем.
        if(sumA % 3 == 0) {
            System.out.printf("Сумма всех цифр %d кратна трём\n", a);
        } else {
            System.out.printf("Сумма всех цифр %d не кратна трём\n", a);
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}