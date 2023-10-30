import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим переменные a, b, c
        System.out.print("Введите значения a, b, c: ");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        // находим количество чисел меньше 45
        int cnt = 0;
        if (a < 45) cnt++;
        if (b < 45) cnt++;
        if (c < 45) cnt++;
        // если только 1 число меньше 45
        if (cnt == 1) {
            System.out.print("Условие истинно\n\n");
        } else {
            System.out.print("Условие ложно\n\n");
        }
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Заполняем переменные
        System.out.print("Введите время разговора от 0 до 24 часов: ");
        int t = scan.nextInt();
        // Проводим проверку
        while (t > 24 || t < 0) {
            System.out.print("Введите время разговора от 0 до 24 часов: ");
            t = scan.nextInt();
        }
        System.out.print("Введите продолжительность разговора в минутах: ");
        double dt = scan.nextDouble();
        System.out.print("Введите стоимость минуты разговора: ");
        double s = scan.nextDouble();
        System.out.print("Введите день недели от 1 до 7: ");
        int d = scan.nextInt();
        // Проводим проверку
        while (d > 7 || d < 1) {
            System.out.print("Введите день недели от 1 до 7: ");
            d = scan.nextInt();
        }
        // Находим оригинальную стоимость
        double cost = Math.abs(dt) * Math.abs(s);
        // Исходя из условия начисляем скидки
        if(t >= 22 || t < 8) {cost *= 0.8;}
        if (d == 6 || d == 7) { cost *= 0.9;}
        // Выводим цену после преобразования
        System.out.printf("Общая стоимость звонка в рублях с учетом скидок: %.2f\n\n", cost);
    }
    public static void Hard() {
        double x,y;
        Scanner scan = new Scanner(System.in);
        // Объявляем переменные x, y и заполняем их
        System.out.print("Введите координаты x,y: ");
        x = scan.nextDouble();
        y = scan.nextDouble();
        // Проверяем попадает ли значение в заштрихованную область
        if (x <= 1 && x >= 0 && y <= Math.sqrt(x)) {
            System.out.print("Точка входит в заштрихованную область");
        }
        else {
            System.out.print("Точка не входит в заштрихованную область");
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}