import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массив
        int[] arr = new int[15];
        // Заполняем массив
        System.out.print("Введите 15 целочисленных значений: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        // Присваиваем переменным противоположные значения
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // Находим минимальное и максимальное числа
        for (int j : arr) {
            if (j < min) min = j;
            if (j > max) max = j;
        }
        // Выводим итоги
        System.out.printf("Разность максимального и минимального: %d\nСумма максимального и минимального: %d\n\n", max - min, max + min);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массив
        int[] arr = new int[11];
        // Заполняем массив
        System.out.print("Введите 11 целочисленных значений: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        // Объявляем переменную для суммирования
        int sum = 0;
        for(int j : arr) {
            // Если число четное и меньше нуля
            if(j < 0 && j % 2 == 0) {
                sum += j;
            }
        }
        System.out.printf("Сумма нечетных отрицательных чисел массива: %d\n", sum);

        // Производим замену элементов в массиве
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 3 == 0) arr[i] = sum;
        }
        // Выводим массив
        System.out.print("Массив после обработки:\n");
        for(int j : arr) {
            System.out.printf("%d ", j);
        }
        System.out.print("\n\n");

    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите двоичное число: ");
        // Объявляем и вводим строку двоичных символов
        String str = scan.next();
        // Получаем сдвинутую часть
        String firstTwoChars = str.substring(0, 2);
        // Получаем остаток строки после первых двух символов
        String restOfString = str.substring(2);
        // Получаем строку после сдвига
        String shiftedString = restOfString + firstTwoChars;
        // Выводим оба числа переведенные в десятичную систему исчисления
        System.out.printf("Двоичное число до сдвига переведенное в десятичную систему: %d\nДвоичное число после сдвига переведенное в десятичную систему: %d\nРазность двоичных чисел: %d\n", Integer.parseInt(str, 2), Integer.parseInt(shiftedString, 2),Integer.parseInt(str, 2) - Integer.parseInt(shiftedString, 2));
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}