import java.util.Scanner;

public class Main {
    public static void Base(double a, double b, double c) {
        // Объявляем массив и заполняем его значениями a, b, c
        double[] arr = new double[3];
        arr[0] = a; arr[1] = b; arr[2] = c;
        // Находим среднее арифметическое
        double sr = (arr[0] + arr[1] + arr[2]) / 3;
        // Выводим все элементы больше sr
        for (int i = 0; i < 3; i++) {
            if(arr[i] > sr) {
                System.out.printf("%.1f больше среднего\n", arr[i]);
            }
        }
        System.out.print("\n");
    }
    public static void Medium(double k, double r, double s) {

        double[] solutions = solveSystem(k, r, s);

        System.out.printf("Решенная система линейных уравнений:\ny1 = %.4f\ny2 = %.4f\ny3 = %.4f\n\n", solutions[0], solutions[1], solutions[2]);
    }

    static double[] solveSystem(double k, double r, double s) {
            double[][] coefficients = {
                    {Math.exp(2 * k), Math.log(Math.abs(r)), 0},
                    {Math.cbrt(1), 0, Math.sqrt(Math.abs(k + r * s))},
                    {0, 1, 0}
            };

            double[] constants = {0, 0, Math.atan(k + r * s)};

            int n = constants.length; // Размер системы

            // Прямой ход метода Гаусса
            for (int pivot = 0; pivot < n; pivot++) {
                double pivotValue = coefficients[pivot][pivot];

                // Деление строки на ведущий элемент
                for (int col = pivot; col < n; col++) {
                    coefficients[pivot][col] /= pivotValue;
                }
                constants[pivot] /= pivotValue;

                // Вычитание текущей строки из остальных строк
                for (int row = 0; row < n; row++) {
                    if (row != pivot) {
                        double factor = coefficients[row][pivot];
                        for (int col = pivot; col < n; col++) {
                            coefficients[row][col] -= factor * coefficients[pivot][col];
                        }
                        constants[row] -= factor * constants[pivot];
                    }
                }
            }

            return constants;
        }

    public static void Hard() {
        Scanner in = new Scanner(System.in);

        // варианты значений для игры
        int[] var1 = {6, 7, 8};
        int[] var2 = {7,8,9};
        int[] var3 = {6, 9, 10};
        int[] var4 = {6, 9, 8};
        int[] var5 = {7, 6, 10};
        // объявление массива игрока
        int[] playerValues = new int[3];

        // меню для пользователя
        System.out.println("Варианты значений");
        System.out.println("1. '6', '7', '8'");
        System.out.println("2. '7', '8', '9'");
        System.out.println("3. '6', '9', '10'");
        System.out.println("4. '6', '9', '8'");
        System.out.println("5. '7', '6', '10'");
        System.out.print("Введите цифру варианта, который ходите выбрать: "); int variable = in.nextInt();

        // Проверка значения
        while (variable > 5 || variable < 1) {
            System.out.print("Введите цифру варианта, который ходите выбрать: ");
            variable = in.nextInt();
        }

        // исходя из выбранного пользователем варианты присваиваем значения
        if (variable == 1) playerValues = var1;
        if (variable == 2) playerValues = var2;
        if (variable == 3) playerValues = var3;
        if (variable == 4) playerValues = var4;
        if (variable == 5) playerValues = var5;

        // псевдослучаный ввод значений для компьютера
        int[] computerValues = new int[3];
        for(int i = 0; i < 3; i++) {
            computerValues[i] = (int) (Math.random() * (10 - 6 + 1) + 6);

        }

        // суммирование очков игрока и компьютера
        int playerResult = 0;
        int computerResult = 0;
        for (int i = 0; i < 3; i++) {
            playerResult = playerValues[i] + playerResult;
            computerResult = computerValues[i] + computerResult;
        }

        // условия для обозначения победителя и проигравшего
        if (playerResult > computerResult) {
            System.out.println("Вы выиграли");
        }
        else {
            if (playerResult == computerResult) {
                System.out.println("Ничья");
            }
            else {
                System.out.println("Вы проиграли");
            }
        }
    }
    public static void main(String[] args) {
        System.out.print("Базовый уровень\nПервый вариант значений\n");
        Base(3.2, -7, 0.5);
        System.out.print("Второй вариант значений\n");
        Base(2.3, 3, 2.5);
        System.out.print("Третий вариант значений\n");
        Base(23, -34, 89.5);
        System.out.print("Средний уровень\nПервый вариант значений\n");
        Medium(1.33, 0.85, 3.5);
        System.out.print("Второй вариант значений\n");
        Medium(0.9, 3.3, 1.2);
        System.out.print("Третий вариант значений\n");
        Medium(1.57, -0.75, 2.15);
        System.out.print("Высокий уровень\n");
        Hard();
    }
}