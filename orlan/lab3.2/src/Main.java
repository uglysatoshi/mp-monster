import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void Base() {
        int multy = 1;
        // Перемножаем все подходящие под условия значения находящиеся в диапазоне от -80 до 80
        for(int i = -80; i <= 80; i++) {
            if(i % 2 != 0 && i % 7 == 0) {
                multy *= i;
            }
        }
        System.out.printf("Произведение целых нечетных чисел кратных 7 в диапазоне от -80 до 80: %d\n\n", multy);
    }
    public static void Medium()  {
        Scanner scan = new Scanner(System.in);
        // Инициализируем n псевдослучайным числом
        int n = (int) (Math.random() * 1000 - 1) + 1;
        // Вводим второй член разности квадрата
        System.out.print("Введите число n: ");
        int m = scan.nextInt();
        System.out.printf("Квадрат разности: %.1f\n\n", Math.pow(n - m, 2));
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        // цикл пока не введем отрицательное число
        System.out.print("Введите значения: ");
        do {
            list.add(scan.nextInt());
        } while(list.getLast() != 0);
        // тк мы вышли из цикла значит последнее число равно нулю
        // по условию его следует удалить
        list.removeLast();
        // запускаем проверку
        for(int i = 0; i < list.size()-1; i++) {
            if(list.get(i) >= -5 || list.get(i) <= 5) {
                System.out.printf("Элемент %d принадлежит [-5;5]\n",list.get(i));
            }
            else {
                System.out.printf("Элемент %d не принадлежит [-5;5]\n",list.get(i));
            }
        }

    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}