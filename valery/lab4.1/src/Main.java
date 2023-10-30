import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void Base() {
        System.out.println("Базовый уровень");
        int[] arr = new int[20]; // объявляем массив
        for (int i = 0; i < 20; i++) { // заполняем массив псевдослучайнми значениями
            arr[i] = (int) (Math.random() * (500 - 1)+ 1);
        }
        System.out.println("Массив заполнен псевдослучайными значениями");
        for (int i = 0; i < 20; i++) { // выводим массив
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int neg_counter = 0;
        int pos_counter = 0;
        for (int i = 0; i < 20; i++) {
            if (arr[i] % 2 == 0) { // если делится 2, то четное, иначе нечетное
                pos_counter++;
            }
            else {
                neg_counter++;
            }
        }
        if(pos_counter > neg_counter) {
            // если pos_counter больше neg_counter, то четных больше
            // иначе нечетных больше
            System.out.println("Четных значений больше");
        }
        else {
            System.out.println("Нечетных значений больше");
        }
    }

    public static void Medium() {
        System.out.println("Средний уровень");
        double[] arr = new double[12]; // объявляем массив
        for (int i = 0; i < 12; i++) { // заполняем массив значениями функции от i
            arr[i] = Math.pow(i, 2) - 2*i + 19.3 * Math.cos(i);
        }

        System.out.println("Массив до обработки");
        for (int i = 0; i < 12; i++) { // выводим массив
            System.out.print(String.format("%3.2f",arr[i]) + " ");
        }
        System.out.println(" ");

        double arithmetic = 0;
        for (int i = 0; i < 12; i++) { // находим сумму элементов
            arithmetic += arr[i];
        }

        arithmetic = arithmetic / 12; // находим среднее арифметическое
        int checker = 0;
        // находим количество элементов больше среднего арифметического
        for (int i = 0; i < 12; i++) {
            if (arr[i] > arithmetic) {
                checker ++;
            }
        }
        // задаем два массива для нахождения элементов больше и меньше среднего арифметического
        double[] newArrMore = new double[checker];
        int counterMore = -1;
        double[] newArrLess = new double[12 - checker];
        int counterLess = -1;
        // заполняем массивы
        for (int i = 0; i < 12; i++) {
            if (arr[i] > arithmetic) {
                counterMore++;
                newArrMore[counterMore] = arr[i];
            }
            else {
                counterLess++;
                newArrLess[counterLess] = arr[i];
            }
        }

        int count = 0;
        double[] newArrFinal = new double[12];

        // соединяем массивы без перестановки элементов
        for(int i = 0; i < newArrMore.length; i++) {
            newArrFinal[i] = newArrMore[i];
            count++;
        }
        for (double arrLess : newArrLess) {
            newArrFinal[count++] = arrLess;
        }
        System.out.println("Массив после обработки");
        for (int i = 0; i < 12; i++) {
            System.out.print(String.format("%3.2f",newArrFinal[i]) + " ");
        }
        System.out.println(" ");
    }

    public static void Hard() {
        System.out.print("Введите двоичное число: "); StringBuilder binary = new StringBuilder(in.nextLine());
        // для корректного перевода двоичное число должно быть
        // кратно 4-м
        while(binary.length() % 4 != 0) {
            binary.insert(0, "0");
        }
        // переводим в десятичную систему исчиления
        int decimal = Integer.parseInt(binary.toString(), 2);
        // переводим в шестнадцатиричную систему исчиления
        String hex = Integer.toHexString(decimal);
        System.out.println("Число в двоичной системе исчисления: " + binary);
        System.out.println("Число в десятичной системе исчисления: " + decimal);
        System.out.println("Число в шестнадцатиричной системе исчисления: " + hex);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}