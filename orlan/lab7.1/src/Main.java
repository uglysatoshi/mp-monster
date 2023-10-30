import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Вводим строку и переводим ее в массив символов
        System.out.print("Введите строку: ");
        char[] arr = scan.nextLine().toCharArray();
        int cnt = 0;
        for(int i = 0; i < arr.length-1; i++) {
            // Находим символ #
            if(arr[i] == '#') {
                // Идем до конца массива после нахождения #
                for(int j = i+1; j < arr.length; j++) {
                    cnt++;
                }
                // Выводим результат и выходим
                System.out.printf("Символов после #: %d\n\n", cnt);
                return;
            }
        }
        // Если не было найдено #, либо символ последний в массиве
        System.out.print("Символ # находится последним, либо отсутствует в массиве\n\n");
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Вводим строку и переводим ее в массив символов
        System.out.print("Введите строку: ");
        char[] arr = scan.nextLine().toCharArray();
        int cnt = 0;
        for(int i = 0; i < arr.length-1; i++) {
            // Находим символ '['
            if(arr[i] == '[') {
                // Идем по массиву и считаем пока не найдем ']'
                for(int j = i+1; j < arr.length; j++) {
                    // Выводим результат и выходим и функции
                    if(arr[j] == ']') {
                        System.out.printf("Количество элементов в скобках: %d\n\n", cnt);
                        return;
                    }
                    // Иначе увеличиваем счетчик
                    cnt++;
                }
            }
        }
        // Если открывающейся скобки не было найдено
        System.out.print("В сроке нет открывающейся, или закрывающейся скобки, либо они находится конце строки\n\n");
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        // Вводим строку
        char[] input = scan.nextLine().toCharArray();
        char key = ')'; // Ключ для шифрования и дешифрования
        // Шифрование
        char[] encrypted = encrypt(input, key);
        System.out.printf("Зашифрованный массив: %s\n", new String(encrypted));
        // Дешифрование
        char[] decrypted = decrypt(encrypted, key);
        System.out.printf("Расшифрованный массив: %s\n\n", new String(decrypted));
    }
    // Метод для шифрования символьного массива
    public static char[] encrypt(char[] input, char key) {
        char[] encrypted = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            encrypted[i] = (char) (input[i] ^ key);
        }
        return encrypted;
    }
    // Метод для дешифровки символьного массива
    public static char[] decrypt(char[] encrypted, char key) {
        // Дешифрование с использованием XOR такое же, как и шифрование
        return encrypt(encrypted, key);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}