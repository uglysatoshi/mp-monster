public class Main {
    private static int factorial(int x) { // функция нахождения факториала
        if (x <= 0) {
            return -1;
        }
        for (int i = 1; i <= x; i++) {
            x *= i;
        }
        return x;
    }
    private static double sum (double x) { // функция нахождения суммы
        double sum = 0;
        for(int k = 1; k <= 7; k++) {
            sum += Math.pow(x,k) / factorial(k);
        }
        return sum;
    }
    public static void Base() {
        System.out.println("\nПостроение графика уравнения y = sqrt(x) - 2cos(0.5πx)\n");
        // Область исследования и шаг
        double start = -5;
        double end = 5;
        double step = 0.06;

        // Рисуем график
        for (double y = 4; y >= -3; y -= 0.2) { // Область исследования и шаг по y
            System.out.print(String.format("%5.2f", y) + "|");

            for (double x = start; x <= end; x += step) { // исследование по x
                double y1 = Math.sqrt(x) - 2 * Math.cos(0.5 * Math.PI * x);
                if (Math.abs(y - y1) < 0.03) { // калибровка точности
                    System.out.print("@");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
        // вывод значений в консоль
        System.out.println("\nТабуляция уравнения y = sqrt(x) - 2cos(0.5πx)\n");
        double x = 0.1;
        while (x <= 2.5) {
            System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", Math.sqrt(x) - 2 * Math.cos(0.5 * Math.PI * x)));
            x += 0.2;
        }
        System.out.println();
    }
    public static void Medium() {
        System.out.println("\nПостроение графика системы линейных уравнений \n    { x + 1 \ny = { 1 - x^5 \n    { x + ln|sin(x)|\n");

        // Область исследования и шаг
        double start = -5;
        double end = 8;
        double step = 0.06;

        // Рисуем график
        for (double y = 5; y >= -5; y -= 0.25) { // Область исследования и шаг по y
            System.out.print(String.format("%5.2f", y) + "|");

            for (double x = start; x <= end; x += step) { // исследование по x
                double y1 = (x > 2.5) ? x+1 : Double.NaN;
                double y2 = (x >= 0 && x <= 2.5) ? 1 - Math.pow(x, 5) : Double.NaN;
                double y3 = (x < 0) ? x + Math.log10(Math.abs(Math.sin(x))) : Double.NaN;
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
        System.out.println("\nТабуляция системы линейных уравнений \n    { x + 1 \ny = { 1 - x^5 \n    { x + ln|sin(x)|\n");
        double x = -Math.PI;
        while (x <= 2*Math.PI) {
            if (x >= 0 && x <= 2.5) {
                double y = 1 - Math.pow(x, 5);
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            }
            else {
                double y;
                if (x > 2.5) {
                    y = x+1;
                }
                else {
                    y = x + Math.log10(Math.abs(Math.sin(x)));
                }
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            }
            x += 0.5;
        }
        System.out.println();
    }
    public static void Hard() {
        System.out.println("\nПостроение графика системы линейных уравнений \n    { Σ x^k / k! \ny = { arctg(π^x)\n");

        // Область исследования и шаг по x
        double start = -5;
        double end = 5;
        double step = 0.07;

        // Рисуем график
        for (double y = 2; y >= -1; y -= 0.1) { // Область исследования и шаг по y
            System.out.print(String.format("%5.2f", y) + "|");

            for (double x = start; x <= end; x += step) { // исследование по x
                double y1 = (x > 0) ? sum(x) : Double.NaN;
                double y2 = (x < 0) ? Math.atan(Math.pow(Math.PI, x)) : Double.NaN;
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
        System.out.println("\nТабуляция системы линейных уравнений \n    { Σ x^k / k! \ny = { arctg(π^x)\n");
        double x = -1;
        while (x <= 2) {
            if (x > 0) {
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", sum(x)));
            }
            else {
                double y = Math.atan((Math.pow(Math.PI, x)));
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