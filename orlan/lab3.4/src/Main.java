public class Main {
    public static void Base() {
        System.out.println("\nПостроение графика уравнения y = |ln(x)|-(x-2)^2\n");
        // Область исследования и шаг
        double start = 0;
        double end = 5;
        double step = 0.04;

        // Рисуем график
        for (double y = 1; y >= -3; y -= 0.1) { // Область исследования и шаг по y
            System.out.print(String.format("%5.2f", y) + "|");

            for (double x = start; x <= end; x += step) { // исследование по x
                double y1 = Math.abs(Math.log10(x)) - Math.pow(x-2, 2);
                if (Math.abs(y - y1) < 0.03) { // калибровка точности
                    System.out.print("@");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
        // вывод значений в консоль
        System.out.println("\nТабуляция уравнения y = |ln(x)|-(x-2)^2\n");
        double x = 2;
        while (x <= 4.1) {
            System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", Math.abs(Math.log10(x)) - Math.pow(x-2, 2)));
            x += 0.2;
        }
        System.out.println();
    }
    public static void Medium() {
        System.out.println("\nПостроение графика системы линейных уравнений \n    { 1 - 2x^3 \ny = { sqrt(cos(2x-1)) \n    { e^-cos(2x)\n");

        // Область исследования и шаг
        double start = -2;
        double end = 4;
        double step = 0.06;

        // Рисуем график
        for (double y = 2; y >= 0; y -= 0.05) { // Область исследования и шаг по y
            System.out.print(String.format("%5.2f", y) + "|");

            for (double x = start; x <= end; x += step) { // исследование по x
                double y1 = (x > 3.5) ? 1-2*Math.pow(x,3) : Double.NaN;
                double y2 = (x >= 0 && x <= 3.5) ? Math.sqrt(Math.cos(2*x-1)) : Double.NaN;
                double y3 = (x < 0) ? Math.pow(Math.E, -1*Math.cos(2*x)) : Double.NaN;
                if (Math.abs(y - y1) < 0.03) { // калибровка точности
                    System.out.print("*");
                } else if (Math.abs(y - y2) < 0.03) { // калибровка точности
                    System.out.print("+");
                } else if (Math.abs(y - y3) < 0.03) { // калибровка точности
                    System.out.print("@");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        // вывод значений СЛУ в консоль
        System.out.println("\nТабуляция системы линейных уравнений \n    { 1 - 2x^3 \ny = { sqrt(cos(2x-1)) \n    { e^-cos(2x)\n");
        double x = -0.5;
        while (x <= 4.5) {
            if (x >= 0 && x <= 3.5) {
                double y = Math.sqrt(Math.cos(2*x-1));
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            }
            else {
                double y;
                if (x > 3.5) {
                    y = 1-2*Math.pow(x,3);
                }
                else {
                    y = Math.pow(Math.E, -1*Math.cos(2*x));
                }
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            }
            x += 0.2;
        }
        System.out.println();
    }
    public static void Hard() {
        System.out.println("\nПостроение графика системы линейных уравнений \n    { x^2 - x+1/3-x \nu = { sin^3(x-2)^2\n");

        // Область исследования и шаг по x
        double start = 1;
        double end = 5;
        double step = 0.01;

        // Рисуем график
        for (double y = 1; y >= -1; y -= 0.05) { // Область исследования и шаг по y
            System.out.print(String.format("%5.2f", y) + "|");

            for (double x = start; x <= end; x += step) { // исследование по x
                double y1 = (x > 2) ? Math.pow(x, 2) - (x+1)/(3-x) : Double.NaN;
                double y2 = (x <= 2) ? Math.pow(Math.sin(Math.pow(x-1, 2)), 3) : Double.NaN;
                if (Math.abs(y - y1) < 0.03) { // калибровка точности
                    System.out.print("*");
                } else if (Math.abs(y - y2) < 0.03) { // калибровка точности
                    System.out.print("+");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
        // вывод значений СЛУ в консоль
        System.out.println("\nТабуляция системы линейных уравнений \n    { x^2 - x+1/3-x \nu = { sin^3(x-2)^2\n");
        double x = 1;
        while (x <= 3) {
            if (x > 2) {
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", Math.pow(x, 2) - (x+1)/(3-x)));
            }
            else {
                double y = Math.pow(Math.sin(Math.pow(x-1, 2)), 3);
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            }
            x += 0.2;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}