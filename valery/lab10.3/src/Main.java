import java.util.Scanner;

public class Main {
    public static boolean whileLooper = false;
    public static int choice = -1;
    public static void menu() {
        System.out.println("1 - Вывести состояние автомата");
        System.out.println("2 - Изменить состояние автомата");
        System.out.println("0 - Выход");
    }
    public static void Medium() {
        whileLooper = false;choice = -1;
        AsyncAutoM async = new AsyncAutoM();
        Scanner in = new Scanner(System.in);
        menu();
        do {
            System.out.print("Выберите пункт: ");
            choice = in.nextInt();
            switch (choice) {
                case 1 -> async.showStatement();
                case 2 -> async.changeStatement();
                case 0 -> whileLooper = true;
            }
        }while(!whileLooper);
    }
    public static void Hard() {
        whileLooper = false;
        choice = -1;
        AsyncAutoH async = new AsyncAutoH();
        Scanner in = new Scanner(System.in);
        menu();
        do {
            System.out.print("Выберите пункт: ");
            choice = in.nextInt();
            switch (choice) {
                case 1 -> async.showStatement();
                case 2 -> async.changeStatement();
                case 0 -> whileLooper = true;
            }
        } while(!whileLooper);
    }
    public static void main(String[] args) {
        Medium();
        Hard();
    }
}