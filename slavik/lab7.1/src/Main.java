import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        // Вводим строку и разбиваем ее на символьный массив
        char[] arr = scan.nextLine().toCharArray();
        // Объявляем счетчик
        int count = 0;
        // Считаем каждое упорядоченное появление abc
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == 'a' && arr[i + 1] == 'b' && arr[i + 2] == 'c') {
                count++;
            }
        }
        // Выводим результат
        System.out.printf("Группа символов abc повторяется: %d\n\n", count);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Вводим строку и разбиваем ее на символьный массив
        System.out.print("Введите строку: ");
        char[] arr = scan.nextLine().toCharArray();
        int countUpper = 0;
        int countLower = 0;
        // Считаем количество символов верхнего и нижнего регистров
        for (char c : arr) {
            if (Character.isUpperCase(c)) countUpper++;
            if (Character.isLowerCase(c)) countLower++;
        }
        // Выводим результаты
        System.out.printf("Соотношение символов верхнего регистра ко всем символам текста: %.2f процентов\nСоотношение символов нижнего регистра ко всем символам текста: %.2f процентов\n\n",  (double) countUpper / arr.length * 100, (double) countLower / arr.length * 100);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        // Вводим строку и разбиваем ее на символьный массив
        char[] arr = scan.nextLine().toCharArray();
        int maxCounter = Integer.MIN_VALUE;
        int minCounter = Integer.MAX_VALUE;
        int counter = 0;
        // Идем по массиву и ищем самое маленькое и самое большое слово
        for (char c : arr) {
            if (c == ' ') {
                if (minCounter > counter) minCounter = counter;
                if (maxCounter < counter) maxCounter = counter;
                counter = 0;
                continue;
            }
            counter++;
        }
        // Выводим результат
        System.out.printf("Длинна самого длинного слова: %d символов\nДлинна самого короткого слова: %d символов\n\n", maxCounter, minCounter);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}