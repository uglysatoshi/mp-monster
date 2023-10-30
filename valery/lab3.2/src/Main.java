import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void Base() {
        System.out.print("Введите значение N: "); int N = in.nextInt();
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 5 == 0) { // если делится без остатка
                result++; // условие выполнено, добавляем 1
            }
        }
        System.out.println("Количество чисел кратных 5 в области от 1 до N: " + result);
    }

    public static void Medium() {
        System.out.print("Введите значение N: "); int N = in.nextInt();
        int check = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                check ++;
            }
        }
        int[] dividers = new int[check];
        int counter = -1;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                counter++;
                dividers[counter] = i;
            }
        }
        boolean swapped;
        counter = check;
        do {
            swapped = false;
            // Перебираем массив и меняем местами элементы, если предыдущий
            // больше, чем следующий
            for (var i = 0; i < counter-1; i++) {
                if (dividers[i] < dividers[i + 1]) {
                    // temp – временная константа для хранения текущего элемента
                    var temp = dividers[i];
                    dividers[i] = dividers[i + 1];
                    dividers[i + 1] = temp;
                    // Если сработал if и была совершена перестановка,
                    // присваиваем swapped значение true
                    swapped = true;
                }
            }
            // Уменьшаем счетчик на 1, т.к. самый большой элемент уже находится
            // в конце массива
            counter--;
        } while (swapped);

        System.out.println("Делители числа " + N + " располложеные в порядке убывания");
        for (int i = 0; i < check; i++) {
            System.out.print(dividers[i] + " ");
        }
        System.out.println(" ");
    }

    public static void Hard() {
        System.out.print("Введите число элементов последовательности: "); int N = in.nextInt();
        int[] arr = new int[N];
        System.out.println("Введите " + N + " элементов последовательности: ");
        for (int i = 0; i<N; i++) {
            arr[i] = in.nextInt();
        }
        int result = 0;
        for (int i = 0; i < N; i++ ) {
            if (arr[i] != 0) {
                if (arr[i] > 0) {
                    result = arr[i] + result;
                }
            }
            else {
                break;
            }
        }
        System.out.println("Сумма положительных элементов последовательности, предшествующих нулю: " + result);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}