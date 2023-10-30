import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Вводим строку и конвертируем ее в массив символов
        System.out.print("Введите строку: ");
        char[] arr = scan.nextLine().toCharArray();
        int sum = 0;
        // Суммируем коды всех символов
        for (char c : arr) {
            sum += c;
        }
        // Выводим результат
        System.out.printf("Сумма кодов символов строки: %d\n\n", sum);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Вводим строку
        System.out.print("Введите строку: ");
        String str = scan.nextLine();
        // Делаем шаблон для фильтрации
        Pattern pattern = Pattern.compile("[А-Я]");
        Matcher matcher = pattern.matcher(str);
        // Создаем новую строку и вносим в нее символы проходящие через шаблон
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group());
        }
        // Выводим результат
        System.out.printf("Строка после форматирования: %s\n\n", result);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scan.nextLine();
        // Разделяем строку на слова по пробелам
        String[] words = input.split(" ");
        // Меняем местами первое и последнее слово
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        words[0] = lastWord;
        words[words.length - 1] = firstWord;
        // Собираем слова обратно в строку с пробелами
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" ");
        }
        System.out.printf("Строка после редактирования: %s", result.toString().trim());
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}