import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем динамический массив
        ArrayList<Integer> arr = new ArrayList<>();
        // Заполняем массив
        System.out.print("Введите 10 целочисленных элементов: ");
        for(int i = 0; i < 10; i++) {
            arr.add(scan.nextInt());
        }
        // Проходим по массиву и перемножаем все четные элементы
        int result = 1;
        for(int a : arr) {
            if(a %2 == 0) result *= a;
        }
        // Выводим результат
        System.out.printf("Произведение четных элементов массива: %d\n\n", result);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем динамический массив
        ArrayList<Integer> arr = new ArrayList<>();
        // Вводим значения пока не введем отрицательное
        System.out.print("Введите элементы: ");
        do{
            arr.add(scan.nextInt());
        }while(arr.get(arr.size() - 1) > 0);
        // Проходим по массиву пока не найдем неубывающий элемент
        for(int i = 0; i < arr.size()-2; i++) {
            if(arr.get(i) < arr.get(i+1)) {
                System.out.print("Массив не упорядочен по убыванию\n\n");
                return;
            }
        }
        System.out.print("Массив упорядочен по убыванию\n\n");
    }
    public static void Hard() {
        ArrayList<Integer> arr = new ArrayList<>();
        Input(arr);
        Scan(arr);
    }
    private static void Input(ArrayList<Integer> arr) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите элементы: ");
        do{
            arr.add(scan.nextInt());
        }while(arr.get(arr.size() - 1) > 0);
    }
    private static void Scan(ArrayList<Integer> arr) {
        for(int i = 0; i < arr.size()-2; i++) {
            if(arr.get(i) < arr.get(i+1)) {
                System.out.print("Массив не упорядочен по убыванию\n\n");
                return;
            }
        }
        System.out.print("Массив упорядочен по убыванию\n\n");
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}