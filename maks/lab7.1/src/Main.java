import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Вводим строку и конвертируем ее в массив сиволов
        System.out.print("Введите строку: ");
        char[] arr = scan.nextLine().toCharArray();
        int cnt = 0;
        // Считаем каждое появление символов
        for(char a : arr) {
            if(a == 'k' || a == 'r' || a == 't') cnt++;
        }
        // Выводим результат
        System.out.printf("Символы k, r, t в встречаются в строке %d раз\n\n", cnt);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        char[] arr = scan.nextLine().toCharArray();
        // Используем HashSet для хранения уникальных символов
        Set<Character> uniqueChars = new HashSet<>();
        // Проходим по каждому символу в строке
        for (char c : arr) {
            // Добавляем символ в HashSet
            uniqueChars.add(c);
        }
        // Выводим результат
        System.out.printf("Количество уникальных символов в строке: %d\n\n", uniqueChars.size());
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите римское число: ");
        System.out.printf("Римское число в десятичной системе исчисления: %d", romanToDecimal(scan.nextLine()));
    }
    // Функция для преобразования римского числа в десятичное
    public static int romanToDecimal(String romanNum) {
        // Проверка на пустую строку римского числа
        if (romanNum.isEmpty()) {
            throw new IllegalArgumentException("Пустая строка римского числа");
        }
        // Инициализация результата и предыдущего значения символа
        int result = 0;
        int prevValue = 0;
        // Начинаем обход строки римского числа справа налево
        for (int i = romanNum.length() - 1; i >= 0; i--) {
            char currentChar = romanNum.charAt(i);
            int currentValue = romanCharToDecimal(currentChar);
            // Если текущее значение меньше предыдущего, вычитаем его
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                // Иначе, прибавляем его к результату
                result += currentValue;
            }
            // Обновляем значение предыдущего символа
            prevValue = currentValue;
        }
        return result;
    }
    private static int romanCharToDecimal(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            // Если символ не соответствует ни одному римскому числу, выбрасываем исключение
            default -> throw new IllegalArgumentException("Недопустимый символ в римском числе: " + c);
        };
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}