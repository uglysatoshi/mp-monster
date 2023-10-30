import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Уточняем вклад оформлен на полгода или на год
        System.out.print("Вклад оформлен на год или полгода, уточните(year/halfyear): ");
        String a = scan.next();
        // проводим проверку
        while(!a.equals("year") && !a.equals("halfyear")) {
            System.out.print("Вклад оформлен на год или полгода, уточните(year/halfyear): ");
            a = scan.next();
        }
        // Вводим сумму депозита
        System.out.print("Введите сумму депозита: ");
        double sum = scan.nextDouble();
        // Исходя из задания находим ежемесячные выплаты
        if(a.equals("year")) {
            System.out.printf("Ежемесячные выплаты будут составлять: %.4f\n\n", (sum * 0.08) / 12);
        }
        else {
            System.out.printf("Ежемесячные выплаты будут составлять: %.4f\n\n", (sum * 0.06) / 12);
        }
    }
    public static void Medium() {
        System.out.print("Введите 3 числа: ");
        // Объявляем и заполняем массив
        double[] arr = new double[3];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            arr[i] = scan.nextDouble();
        }
        // Сортировка пузырьком
        boolean isSorted = false;
        double buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;

                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                }
            }
        }
        // Выводим число из середины массива
        System.out.printf("Среднее число равно %.2f\n\n", arr[1]);


    }
    public static void Hard() {
        Scanner scanner = new Scanner(System.in);
        // Объявляем переменные координат и заполняем
        System.out.print("Введите координаты точки A1: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        System.out.print("Введите координаты точки A2: ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        System.out.print("Введите координаты точки A3: ");
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        // Вычисляем координаты векторов AB (A1A2) и AC (A1A3)
        int AB_x = x2 - x1;
        int AB_y = y2 - y1;
        int AC_x = x3 - x1;
        int AC_y = y3 - y1;

        // Выводим результат
        if (AB_x * AC_x + AB_y * AC_y == 0) {
            System.out.println("Можно провести прямую, перпендикулярную прямой через точки A1 и A2, через точку A3.");
        } else {
            System.out.println("Нельзя провести прямую, перпендикулярную прямой через точки A1 и A2, через точку A3.");
        }

    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}