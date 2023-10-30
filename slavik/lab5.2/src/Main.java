import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем матрицу
        int[][] arr = new int[7][6];
        // Заполняем матрицу
        System.out.print("Заполните двумерный массив 7x6: \n");
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 100);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
        // Объявляем массив для средних арифметических
        double[] sr = new double[6];
        // Проходим по столбцам и заполняем массив
        for (int j = 0; j < 6; j++) {
            double sum = 0;
            for(int i = 0; i < 7; i++) {
                sum += arr[i][j];
            }
            sum /= 7;
            sr[j] = sum;
        }
        // Выводим массив
        System.out.print("Выводим средние арифметические столбцов: \n");
        for (int i = 0; i < sr.length; i++) {
            System.out.printf("%.2f ", sr[i]);
        }
        System.out.print("\n\n");
    }
    public static void Medium() {
        double[][] arr = new double[5][5];
        // Заполнение матрицы
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Math.pow(logD(5, i*i + j*j), 2) - Math.pow(Math.E, Math.E) / 1.5 * i*i - Math.pow(-2.3, i);
            }
        }
        // Объявляем новый массив и заносим в него элементы главной диагонали матрицы
        double[] nArr = new double[5];
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(i == j) nArr[i] = arr[i][j];
            }
        }
        // Проводим изменения в массиве функцией sub
        for (int i = 0; i < 5; i++) {
            nArr[i] = sub(nArr[i]);
        }
        // Выводим результат
        System.out.printf("Конечный вектор: %s\n\n", Arrays.toString(nArr));
    }
    // функция вычисления логарифма по произвольному основанию
    public static double logD(int base, double x) {
        return Math.log(x) / Math.log(base);
    }
    // Функция из индивидуального задания
    public static double sub(double x) {
        double pr = 1;
        double sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += x;
            pr *= Math.pow(x, 2);
        }
        return Math.pow(logD(3, Math.abs(pr - sum)), 5);
    }
    public static void main(String[] args) {
        Base();
        Medium();
    }
}