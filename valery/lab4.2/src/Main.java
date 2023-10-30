import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner in = new Scanner(System.in);
        int maxValueFirst = 0; // максимальное значение первого столбца
        int maxValueThird = 0; // максимальное значение третьего столбца
        int indexFirst = 0; // индекс максимального элемента первого столбца
        int indexThird = 0; // индекс максимального элемента третьего столбца
        int[][] arr = new int[4][3]; // объявляем матрицу

        // заполняем матрицу
        System.out.println("Введите значения массива 3х4: ");
         for (int i = 0; i < 4; i++) {
             for (int j = 0; j < 3; j++) {
                 arr[i][j] = in.nextInt();
             }
         }
         System.out.println();

         // идем по строкам
         for (int i = 0; i < 4; i++) {
             // если данное значение в столбце больше максимального
             if(arr[i][0] > maxValueFirst) {
                 maxValueFirst = arr[i][0];
                 indexFirst = i;
             }
             // если данное значение в столбце больше максимального
             if(arr[i][2] > maxValueThird) {
                 maxValueThird = arr[i][2];
                 indexThird = i;
             }
         }

         // меняем местами элементы
         arr[indexFirst][0] = maxValueThird;
         arr[indexThird][2] = maxValueFirst;

         System.out.println("Максимальное число в 1-ом столбце: " + maxValueFirst);
         System.out.println("Максимальное число в 3-ем столбце: " + maxValueThird);
         System.out.println("Матрица после перестановки элементов: ");
         for (int i = 0; i < 4; i++) {
             for (int j = 0; j < 3; j++) {
                 System.out.print(arr[i][j] + " ");
             }
             System.out.println();
         }
    }
    public static void Medium() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размерность матрицы A: ");
        int n = in.nextInt();
        int[][] A = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                A[i][j] = (int) (Math.random() * (500 - 1) + 1);
            }
        }

        System.out.println("Матрица А: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int min = Integer.MAX_VALUE; // передаем максимальное значение в целочисленном диапозоне
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) { // условие попадания в главную диагональ
                    if (A[i][j] < min) { // если данное значение меньше нынешнего минимального
                        min = A[i][j]; // приравниваем min к данному элементу матрицы
                        index = i; // записываем индекс строки
                    }
                }
            }
        }

        // обнуляем строку с индексом равным index
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(index == i) {
                    A[i][j] = 0;
                }
            }
        }

        int[][] B = new int[n-1][n];
        int countI = 0;
        int countJ = 0;

        // переносим значения из матрицы A в матрицу B игнорируя обнуленную строку
        for(int i = 0; i < n; i++) {
            if(A[i][i] == 0) continue;
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    B[countI][countJ] = A[i][j];
                    countJ++;
                }
            }
            countI++;
            countJ = 0;
        }

        // Выводим матрицу B
        System.out.println("Матрица B: ");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void Hard() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите N: "); int N = in.nextInt();
        System.out.print("Введите M: "); int M = in.nextInt();

        int[][] arr = new int[N][M]; // объявляем матрицу N x M

        // заполняем матрицу c клавиатуры
        System.out.println("Введите значения матрицы: ");
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int count = 1; // счетчик, изначально равен 1, так как первая строка всегда похожа сама на себя

        // проходим по всем строкам, начиная со второй
        for (int i = 1; i < N; i++) {
            boolean isSimilar = true; // флаг, показывающий, похожа ли текущая строка на первую
            boolean[] firstRowValues = new boolean[100]; // массив флагов для чисел в первой строке

            // ставим флаги для всех чисел из первой строки
            for (int j = 0; j < M; j++) {
                firstRowValues[arr[0][j] - 1] = true;
            }

            // проверяем, есть ли все числа из первой строки в текущей строке,
            // и есть ли в текущей строке все числа из первой строки
            for (int j = 0; j < M; j++) {
                int curValue = arr[i][j];
                if (!firstRowValues[curValue - 1]) {
                    isSimilar = false;
                    break;
                }
                firstRowValues[curValue - 1] = false;
            }

            if (isSimilar) {
                count++;
            }
        }

        System.out.println("Количетсво похожих строк: " + count);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}