import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем динамический массив
        ArrayList<Double> memo = new ArrayList<>();
        // Заполняем массив
        System.out.print("Введите 10 элементов массива:\n");
        for(int i = 0; i < 10; i++) {
            memo.add(scan.nextDouble());
        }
        // Сортируем массив
        Collections.sort(memo);
        // Выводим отсортированный массив
        System.out.printf("Отсортированный массив: %s\n\n", memo);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массив
        ArrayList<Double> memo = new ArrayList<>();
        // Вводим в массив 10 элементов
        System.out.print("Введите 10 элементов массива:\n");
        for(int i = 0; i < 10; i++) {
            memo.add(scan.nextDouble());
        }
        // Используем конструкцию для удаления всх элементов кратных пяти
        memo.removeIf(x -> x % 5 == 0);
        // Выводим отредактированный массив и минимальный элемент
        System.out.printf("Массив после редактирования: %s\nМинимальный элемент массива: %.1f\n\n",memo, Collections.min(memo));
    }
    private static void hInput(ArrayList<Double> arr) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите 10 элементов массива:\n");
        for(int i = 0; i < 10; i++) {
            arr.add(scan.nextDouble());
        }
    }
    private static void hRed(ArrayList<Double> arr) {
        arr.removeIf(x -> x % 5 == 0);
    }
    private static void hOutput(ArrayList<Double> arr) {
        System.out.print("Массив после редактирования: \n");
        for (Double d : arr) {
            System.out.printf("%.1f ", d);
        }
    }
    private static void hMin(ArrayList<Double> arr) {
        System.out.printf("\nМинимальный элемент массива: %.1f", Collections.min(arr));
    }
    public static void Hard() {
        // Создаем функции для каждого действия в уровне Medium
        ArrayList<Double> memo = new ArrayList<>();
        hInput(memo);
        hRed(memo);
        hOutput(memo);
        hMin(memo);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}