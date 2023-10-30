import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        // Вводим строку
        String str = scan.nextLine();
        // Удаляем все элементы до первого пробела
        str = str.substring(str.indexOf(" ") +1);
        // Выводим результат
        System.out.printf("Строка после удаления первого слова: %s\n\n", str);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        // Вводим строку и конвертируем ее в символьный массив
        char[] charArray = scan.nextLine().toCharArray();
        // Меняем символы местами
        for (int i = 0; i < charArray.length - 1; i += 2) {
            char temp = charArray[i];
            charArray[i] = charArray[i + 1];
            charArray[i + 1] = temp;
        }
        // Выводим результат
        System.out.printf("Строка после изменения: %s\n\n", new String(charArray));
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        // Вводим строку и конвертируем ее в символьный массив
        char[] arr = scan.nextLine().toCharArray();
        // Каждому значению добавляем 1, тк char представляем собой код элемента,
        // следовательно, следующий по коду элемент будет на 1 больше
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'я') {
                arr[i] = ' ';
            }
            else {
                arr[i] += 1;
            }
        }
        System.out.printf("Строка после обработки: %s\n\n", Arrays.toString(arr));
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}