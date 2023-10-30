import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массив
        ArrayList<Integer> arr = new ArrayList<>();
        // Заполняем массив
        System.out.print("Введите 10 целочисленных значений: ");
        for(int i = 0; i < 10; i++) {
            arr.add(scan.nextInt());
        }
        // Выводим индекс минимального элемента
        System.out.printf("Индекс минимального элемента: %d\n\n", arr.indexOf(Collections.min(arr)));
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массив
        ArrayList<Double> arr = new ArrayList<>();
        // Заполняем массив
        System.out.print("Введите 15 вещественных значений: ");
        for(int i = 0; i < 15; i++) {
            arr.add(scan.nextDouble());
        }
        // Удаляем элементы попадающие в диапазон (-3; 7)
        arr.removeIf(x -> x > -3 && x < 7);
        double result = 1;
        for(double d : arr) {
            if(d < 0) result *= d;
        }
        System.out.printf("Отредактированный массив: %s\nПроизведение отрицательных чисел: %.1f\n\n", arr, result);
    }
    public static void Hard() {
        ArrayList<Double> arr = new ArrayList<>();
        Input(arr);
        Delete(arr);
        System.out.printf("Отредактированный массив: %s\nПроизведение отрицательных чисел: %.1f\n\n", arr, Result(arr));
    }
    private static void Input(ArrayList<Double> arr) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите 15 вещественных значений: ");
        for(int i = 0; i < 15; i++) {
            arr.add(scan.nextDouble());
        }
    }
    private static void Delete(ArrayList<Double> arr) {
        arr.removeIf(x -> x > -3 && x < 7);
    }
    private static double Result(ArrayList<Double> arr) {
        double result = 1;
        for(double d : arr) {
            if(d < 0) result *= d;
        }
        return result;
    }

    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}