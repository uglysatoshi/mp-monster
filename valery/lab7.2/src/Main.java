import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку содержащую символы: ");
        String str = in.nextLine();
        // Функция toIntExact используется для перевода Long в int
        // Функция codePoints().filter(isDigit) находит значения "[0-9]"
        // Функция count подчитывает количество срабатываний
        int counter = Math.toIntExact(str.codePoints().filter(Character::isDigit).count());
        System.out.println("Цифр в строке: " + counter);
    }
    public static void Medium() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = in.nextLine();
        // Заменяем "*" на "*-"
        str = str.replace("*", "*-");
        System.out.println("Строка после обработки: " + str);
    }
    public static void Hard() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = in.nextLine();
        // переводим строку в массив символов
        char[] arr = str.toCharArray();
        // каждому значению добавляем 1, тк char представляем собой код элемента,
        // следовательно следующий по коду элемент будет на 1 больше
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'я') {
                arr[i] = ' ';
            }
            else {
                arr[i] += 1;
            }
        }
        // переводим обратно в string
        str = Arrays.toString(arr);
        System.out.println("Строка после обработки: " + str);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}