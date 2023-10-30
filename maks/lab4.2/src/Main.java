import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем матрицу
        int[][] arr = new int[7][8];
        // Заполняем матрицу
        System.out.print("Заполните матрицу: \n");
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 8; j++) {
                arr[i][j] = (int) (Math.random() * 100 -1);
            }
        }
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        // Объявляем массив для занесения результатов счетчика
        int[] minimals = new int[8];
        // Проходим по массиву и считаем нечетные элементы в столбцах
        for(int j = 0; j < 8; j++) {
            int counter = 0;
            for(int i = 0; i < 7; i++) {
                if(arr[i][j] % 2 != 0) counter++;
            }
            minimals[j] = counter;
        }
        // Выводим результат
        System.out.printf("Количество нечетных элементов в каждом столбце: %s\n\n", Arrays.toString(minimals));
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Вводим размерность матрицы
        System.out.print("Введите значения N, M: ");
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[][] A = new int[N][M];
        // Заполняем матрицу
        System.out.print("Заполните матрицу: \n");
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                A[i][j] = (int) (Math.random() * 100 -1);
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        // Вводим абсолютное значение B
        System.out.print("Введите число B: ");
        final int B = scan.nextInt();
        int absCount = 0;
        ArrayList <Integer> C = new ArrayList<>();
        // Считаем и вносим элементы в массив
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(A[i][j] > B) {
                    absCount++;
                    C.add(A[i][j]);
                }
            }
        }
        // Выводим результат
        System.out.printf("Массив чисел больше B: %s\nКоличество чисел больше B: %d\n\n", C, absCount);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Объявляем матрицу
        int[][] arr = new int[5][10];
        // Заполняем матрицу
        System.out.print("Заполните матрицу: \n");
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 10; j++) {
                arr[i][j] = (int) (Math.random() * 100 -1);
            }
        }
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 10; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int counter = 0;
        for(int j = 0; j < 10; j++) {
            boolean isDecreasing = true;
            // i - 1, чтобы не выходить за границы
            for(int i = 0; i < 5-1; i++) {
                // Проверка на убывание, если хоть один элемент не убывает ->
                // -> выходим из цикла
                if (arr[i][j] < arr[i + 1][j]) {
                    isDecreasing = false;
                    break;
                }
            }
            if(isDecreasing) counter++;
        }
        // Выводим итоги
        System.out.printf("Количество монотонно убывающих столбцов: %d", counter);
    }
    public static void main(String[] args) {
//        Base();
//        Medium();
        Hard();
    }
}