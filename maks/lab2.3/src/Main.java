import java.util.Scanner;

public class Main {
    public static void Base() {
        int var;
        Scanner scan = new Scanner(System.in);
        // Вводим номер темы поздравления
        System.out.print("Введите номер темы от 1 до 3: ");
        int theme = scan.nextInt();
        // Проверяем значения
        while (theme < 1 || theme > 3) {
            System.out.print("Введите число от 1 до 3: ");
            theme = scan.nextInt();
        }
        // Оператор выбора
        switch(theme) {
            case 1:
                System.out.print("Введите номер варианта от 1 до 3: ");
                var = scan.nextInt();
                while (var < 1 || var > 3) {
                    System.out.print("Введите число от 1 до 3: ");
                    var = scan.nextInt();
                }
                switch (var) {
                    case 1 -> System.out.print("Новогодние, вариант А\n");
                    case 2 -> System.out.print("Новогодние, вариант Б\n");
                    case 3 -> System.out.print("Новогодние, вариант В\n");
                }
                break;
            case 2:
                System.out.print("Введите номер варианта от 1 до 3: ");
                var = scan.nextInt();
                while (var < 1 || var > 3) {
                    System.out.print("Введите число от 1 до 3: ");
                    var = scan.nextInt();
                }
                switch (var) {
                    case 1 -> System.out.print("С днем рождения, вариант А\n");
                    case 2 -> System.out.print("С днем рождения, вариант Б\n");
                    case 3 -> System.out.print("С днем рождения, вариант В\n");
                }
                break;
            case 3:
                System.out.print("Введите номер варианта от 1 до 3: ");
                var = scan.nextInt();
                while (var < 1 || var > 3) {
                    System.out.print("Введите число от 1 до 3: ");
                    var = scan.nextInt();
                }
                switch (var) {
                    case 1 -> System.out.print("С днем защитника отечества, вариант А\n");
                    case 2 -> System.out.print("С днем защитника отечества, вариант Б\n");
                    case 3 -> System.out.print("С днем защитника отечества, вариант В\n");
                }
                break;
        }
    }
    public static void Medium(double a, double b, double c) {
        double[] solutions = solveSystem(a, b, c);
        System.out.printf("Решенная система линейных уравнений:\ny1 = %.4f\ny2 = %.4f\ny3 = %.4f\n\n", solutions[0], solutions[1], solutions[2]);
    }

    static double[] solveSystem(double a, double b, double c) {
        double[][] coefficients = {
                {Math.cbrt(b * b + Math.sqrt(Math.abs(0 + c))), 0, 0},
                {0, -Math.cos(0 - b - c), 0},
                {0, 0, Math.sin(0 + a - b)}
        };
        double[] constants = {
                Math.log(a),
                Math.log(a),
                Math.log(a)
        };
        int n = constants.length; // Размер системы
        // Прямой ход метода Гаусса
        for (int pivot = 0; pivot < n; pivot++) {
            double pivotValue = coefficients[pivot][pivot];

            for (int col = pivot; col < n; col++) {
                coefficients[pivot][col] /= pivotValue;
            }
            constants[pivot] /= pivotValue;

            for (int row = pivot + 1; row < n; row++) {
                double factor = coefficients[row][pivot];
                for (int col = pivot; col < n; col++) {
                    coefficients[row][col] -= factor * coefficients[pivot][col];
                }
                constants[row] -= factor * constants[pivot];
            }
        }

        // Обратный ход
        double[] solutions = new double[n];
        for (int row = n - 1; row >= 0; row--) {
            double sum = 0;
            for (int col = row + 1; col < n; col++) {
                sum += coefficients[row][col] * solutions[col];
            }
            solutions[row] = constants[row] - sum;
        }

        return solutions;
    }

    public static void Hard() {
        double cost;
        Scanner scan = new Scanner(System.in);
        // Вводим количество дней до отправления
        System.out.print("Введите количество дней до отправления: ");
        int days = Math.abs(scan.nextInt());
        // Вводим в две или в одну сторону билет
        System.out.print("Билеты в одну или в две стороны(1/2): ");
        int storoni = scan.nextInt();
        // Проверка
        while (storoni != 1 && storoni != 2) {
            System.out.print("Введено не корректное значение\nВведите значения заново: ");
            storoni = scan.nextInt();
        }
        // Оператор выбора
        switch (storoni) {
            case 1 -> {
                System.out.print("Введите цифру города, в который вы отправляетесь (1 - Киев, 2 - Харьков, 3 - Донецк, 4 - Львов: ");
                int destination = scan.nextInt();
                while (destination >= 5 || destination <= 0) {
                    System.out.print("Введено не корректное значение\nВведите значения заново: ");
                    destination = scan.nextInt();
                }
                switch (destination) {
                    case 1 -> {
                        cost = 500;
                        if(days > 45) {
                            cost *= 0.8;
                        }
                        else {
                            if( days >= 20 && days < 45 ) {
                                cost *= 0.9;
                            }
                        }
                        System.out.printf("Стоимость билета: %.0f", cost);
                    }
                    case 2 -> {
                        cost = 400;
                        if(days > 45) {
                            cost *= 0.8;
                        }
                        else {
                            if( days >= 20 && days < 45 ) {
                                cost *= 0.9;
                            }
                        }
                        System.out.printf("Стоимость билета: %.0f", cost);
                    }
                    case 3 -> {
                        cost = 350;
                        if(days > 45) {
                            cost *= 0.8;
                        }
                        else {
                            if( days >= 20 && days < 45 ) {
                                cost *= 0.9;
                            }
                        }
                        System.out.printf("Стоимость билета: %.0f", cost);
                    }
                    case 4 -> {
                        cost = 600;
                        if(days > 45) {
                            cost *= 0.8;
                        }
                        else {
                            if( days >= 20 && days < 45 ) {
                                cost *= 0.9;
                            }
                        }
                        System.out.printf("Стоимость билета: %.0f", cost);
                    }
                }
            }
            case 2 -> {
                System.out.print("Введите цифру города, в который вы отправляетесь (1 - Киев, 2 - Харьков, 3 - Донецк, 4 - Львов: ");
                int destination = scan.nextInt();
                while (destination >= 5 || destination <= 0) {
                    System.out.print("Введено не корректное значение\nВведите значения заново: ");
                    destination = scan.nextInt();
                }
                switch (destination) {
                    case 1 -> {
                        cost = 750;
                        if(days > 45) {
                            cost *= 0.8;
                        }
                        else {
                            if( days >= 20 && days < 45 ) {
                                cost *= 0.9;
                            }
                        }
                        System.out.printf("Стоимость билета: %.0f", cost);
                    }
                    case 2 -> {
                        cost = 600;
                        if(days > 45) {
                            cost *= 0.8;
                        }
                        else {
                            if( days >= 20 && days < 45 ) {
                                cost *= 0.9;
                            }
                        }
                        System.out.printf("Стоимость билета: %.0f", cost);
                    }
                    case 3 -> {
                        cost = 550;
                        if(days > 45) {
                            cost *= 0.8;
                        }
                        else {
                            if( days >= 20 && days < 45 ) {
                                cost *= 0.9;
                            }
                        }
                        System.out.printf("Стоимость билета: %.0f", cost);
                    }
                    case 4 -> {
                        cost = 900;
                        if(days > 45) {
                            cost *= 0.8;
                        }
                        else {
                            if( days >= 20 && days < 45 ) {
                                cost *= 0.9;
                            }
                        }
                        System.out.printf("Стоимость билета: %.0f", cost);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.print("Базовый уровень\n");
        Base();
        System.out.print("Средний уровень\n");
        Medium(0.1, 9.8, 11.12);
        Medium(10, 10.05, 6.2);
        Medium(100, 3.03, 7.12);
        System.out.print("Высокий уровень\n");
        Hard();
    }
}