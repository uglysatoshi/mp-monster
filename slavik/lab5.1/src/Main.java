import java.util.*;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массив
        int[] arr = new int[8];
        System.out.print("Введите 8 элементов массива: ");
        // Заполняем массив
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        // Проводим сравнение всех элементов
        int max = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // Выводим max
        System.out.printf("Максимальное число массива: %d\n\n", max);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем динамический массив
        ArrayList<Integer> arr = new ArrayList<>();
        // Добавляем в него 10 элементов
        System.out.print("Введите 10 элементов массива: ");
        for(int i = 0; i < 10; i++) {
            arr.add(scan.nextInt());
        }
        // Избавляемся от неподходящих элементов
        arr.removeIf(x -> x < 0);
        // Сортируем массив после обработки
        Collections.sort(arr);
        // Выводим массив
        System.out.printf("Отсортированный массив с удаленными отрицательными элементами: %s\n\n", arr);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массив
        int[] arr = new int[10];
        // Заполняем массив
        System.out.print("Введите 10 элементов массива: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        // Объявляем и вводим k
        System.out.print("Введите значение k(k < 10): ");
        int k = scan.nextInt();
        // Выводим результат функции minl
        System.out.printf("Минимальное значение в массиве от элемента k до конца массива: %d", minl(k, arr));
    }
    // Функция находящая минимальный элемент массива после элемента с индексом k
    public static int minl(int start, int[] arr) {
        int min = Integer.MAX_VALUE;
        // проверка на верность значения
        if (start > arr.length) return -1;
        // Проходим по массиву и ищем минимальный элемент
        for (int i = start; i < arr.length; i++) {
            if(arr[i] < min) min = arr[i];
        }
        return min;
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}