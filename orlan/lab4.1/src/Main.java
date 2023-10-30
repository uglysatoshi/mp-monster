import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массив и заполняем его
        Double[] arr =  new Double[12];
        System.out.print("Введите 12 вещественных чисел: ");
        for(int i = 0; i < 12; i++) {
            arr[i] = scan.nextDouble();
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        // Выводим отсортированный массив и сумму минимального и максимального элементов
        System.out.printf("Отсортированный массив: %s\nСумма минимального и максимального элементов: %.1f\n\n", Arrays.toString(arr), arr[0] + arr[arr.length - 1]);

    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        double[] arr =  new double[12];
        System.out.print("Введите 12 вещественных чисел: ");
        for(int i = 0; i < 12; i++) {
            arr[i] = scan.nextDouble();
        }
        // Сортировка пузырьком
        int counter = 0;
        boolean isSorted = false;
        double buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] < arr[i+1]){
                    isSorted = false;
                    counter++;
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                }
            }
        }
        // Выводим массив и количество перестановок
        System.out.printf("Отсортированный массив: %s\nКоличество перестановок элементов: %d\n\n", Arrays.toString(arr), counter);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Выделяем память под элементы массива
        int[] a = new int[6];
        // Заполняем массив
        System.out.print("Введите 6 целочисленных элементов: ");
        for(int i = 0; i < 6; i++) {
            a[i] = scan.nextInt();
        }
        // Находим одинаковые элементы и выводим их адреса
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(i == j) continue;
                if(a[i] == a[j]) {
                    System.out.printf("Уникальный адрес первого элемента: %d\n", System.identityHashCode(a[i]));
                    System.out.printf("Уникальный адрес второго элемента: %d\n", System.identityHashCode(a[j]));
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}