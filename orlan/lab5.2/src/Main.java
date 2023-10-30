import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем матрицу
        double[][] matrix = new double[5][5];
        // Заполняем матрицу
        System.out.print("Заполните матрицу: \n");
        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 5; j++) {
                matrix[i][j] = scan.nextDouble();
            }
        }
        // Объявляем переменные для хранения максимального элемента и его столбца
        double max = Double.MIN_VALUE;
        int maxIndex = 0;
        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 5; j++) {
                if(i == j) {
                    if(max < matrix[i][j]) {
                        max = matrix[i][j];
                        maxIndex = j;
                    }
                }
            }
        }
        // Массив для элементов столбца
        double[] result = new double[5];
        // Переносим значения столбца с максимальным элементом по главной диагонали
        for(int i = 0; i < 5; i++) {
            result[i] = matrix[i][maxIndex];
        }
        // Выводим результат
        System.out.printf("Конечный массив: %s\n\n", Arrays.toString(result));
    }
    public static void Medium() {
        // Объявляем матрицу
        double[][] matrix = new double[5][5];
        // Заполняем матрицу

        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 5; j++) {
                matrix[i][j] = Math.pow(-(Math.PI /Math.E), i+j) + Math.log(Math.pow(Math.E, i+ (double) 5 /j) + (Math.pow(-2, i+j-1) * Math.pow(Math.E, 2*i-j)));
            }
        }
        // Объявляем массив result и вносим в него минимальные элементы столбца
        // измененные функцией sub
        double[] result = new double[5];
        for(int j = 0; j < 5; j ++) {
            double min = Double.MAX_VALUE;
            for(int i = 0; i < 5; i++) {
                if(matrix[i][j] < min) min = matrix[i][j];
            }
            result[j] = sub(min);
        }
        System.out.printf("Конечный массив: %s\n\n", Arrays.toString(result));

    }
    // Функция для вычисления значения по индивидуальному заданию
    private static double sub(double x) {
        double e = 0;
        for(int i = 1; i <= 6; i++) {
            double p = 1;
            for(int j = 1; j <= i; j++) {
                p *= x / Math.E;
            }
            e += Math.pow(x, 2) - p;
        }
        return Math.sqrt(Math.abs(e));
    }
    public static void main(String[] args) {
        Base();
        Medium();
    }
}