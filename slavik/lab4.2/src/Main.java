import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Вводим размерность матрицы
        System.out.print("Введите значения n и m: ");
        int n = scan.nextInt();
        int m = scan.nextInt();
        // Объявляем марицу размером n x m
        int[][] arr = new int[Math.abs(n)][Math.abs(m)];
        // Заполняем матрицу
        System.out.print("Заполните массив: \n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        // Создаем массив для хранения максимальных значений по столбцу
        int[] maximals = new int[n];
        // Проходимся по столбцам матрицы и записываем максимальные элементы
        for(int j = 0; j < m; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if(arr[i][j] > max) max = arr[i][j];
            }
            maximals[j] = max;
        }
        // Выводим максимальные элементы
        System.out.print("Наибольшие элементы каждого столбца: \n");
        for (int maximal : maximals) {
            System.out.printf("%d ", maximal);
        }
        System.out.print("\n\n");
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите значения n и m: ");
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] array = new int[Math.abs(n)][Math.abs(m)];
        System.out.print("Заполните массив: \n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = scan.nextInt();
            }
        }
        int minElement = Integer.MAX_VALUE; // Инициализируем минимальный элемент максимальным значением
        int minRowIndex = -1; // Инициализируем индекс строки с минимальным элементом

        // Находим первый встреченный минимальный элемент и его строку
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < minElement) {
                    minElement = array[i][j];
                    minRowIndex = i;
                }
            }
        }
        // Создаем новый массив с увеличенным количеством строк
        int[][] newArray = new int[array.length + 1][];

        // Копируем строки до строки с минимальным элементом в новый массив
        System.arraycopy(array, 0, newArray, 0, minRowIndex + 1);

        // Вставляем первую строку после строки с минимальным элементом в новый массив
        newArray[minRowIndex + 1] = array[0];

        // Копируем оставшиеся строки в новый массив
        if (newArray.length - (minRowIndex + 2) >= 0)
            System.arraycopy(array, minRowIndex + 2 - 1, newArray, minRowIndex + 2, newArray.length - (minRowIndex + 2));

        // Обновляем исходный массив
        array = newArray;
        System.out.print("Массив после перестановки: \n");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите значения n: ");
        int n = scan.nextInt();
        int[][] array = new int[n][n];
        System.out.print("Заполните массив: \n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scan.nextInt();
            }
        }
        // Зеркально отражаем элементы относительно побочной диагонали
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int temp = array[i][j];
                array[i][j] = array[n - j - 1][n - i - 1];
                array[n - j - 1][n - i - 1] = temp;
            }
        }
        System.out.print("Массив после перестановки: \n");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}