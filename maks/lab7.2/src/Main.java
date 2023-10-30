import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        // Удаляем пробелы из строки при помощи replaceAll
        System.out.printf("Строка с удаленными пробелами: %s\n\n", scan.nextLine().replaceAll(" ", ""));
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        // Используем встроенную функцию reverse и выводим строку
        System.out.printf("Перевернутая строка: %s\n\n", new StringBuilder(scan.nextLine()).reverse());
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        // Конвертируем строку в массив строк и выводим получившийся массив преобразуя его в строку
        System.out.printf("Строка как массив слов: %s", Arrays.toString(scan.nextLine().split(" ")));
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}