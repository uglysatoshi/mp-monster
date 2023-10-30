import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);

    public static void Base() {
        ArrayList<Double> Memo = new ArrayList<>(0);
        // Вводим n-ое количество элементов
        System.out.print("Введите количество элементов: "); int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            Memo.add(in.nextDouble());
        }
        // Суммируем все элементы
        double arithmetic = 0;
        for (Double aDouble : Memo) {
            arithmetic += aDouble;
        }
        // Делим на количество элементов
        arithmetic = arithmetic / Memo.size();
        System.out.println("Среднее арифметическое динамического массива: " + Math.abs(arithmetic));
    }

    public static void Medium() {
        ArrayList<Double> Memo = new ArrayList<>(0);
        // пока не введем 10, вводим
        while(!Memo.contains(10.0)) {
            Memo.add(in.nextDouble());
        }
        double neg_sum = 0;
        // суммируем отрицательные элементы пока не дойдем до конца массива
        for (Double aDouble : Memo) {
            if (aDouble < 0) {
                neg_sum += aDouble;
            }
        }
        System.out.println("Сумма отрицательных элементов: " + neg_sum);
    }
    // Функция добавления элементов
    private static void add(ArrayList<Double> Memo) {
        // Вводим элементы пока не введем 0
        System.out.println("Для остановки добавления элементов введите 0");
        while(!Memo.contains(0.0)) Memo.add(in.nextDouble());
    }
    // Функция нахождения суммы
    private static double sum(ArrayList<Double> Memo) {
        double sum = 0;
        // Суммируем пока не дойдем до конца
        for (Double aDouble : Memo) {
                sum += aDouble;
        }
        return sum;
    }
    public static void Hard() {
        ArrayList<Double> Memo = new ArrayList<>(0);
        add(Memo);
        System.out.println("Размер: " + Memo.size());
        System.out.println("Сумма: " + sum((Memo)));
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}