import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void Base() {
        int sum = 0;
        // Суммируем все значения
        for (int i = -10; i <= 10; i++) {
            if (i % 9 == 0 && i > 0) {
                sum += i;
            }
        }
        System.out.printf("Сумма всех положительных чисел кратных 9 в диапазоне от -10 до 10: %d\n\n", sum);
    }
    public static void Medium() {
        // сумма для степеней двойки
        int sum1 = 0;

        // сумма для последовательности
        // использовал long тк число не влезло в int
        long sum2 = 1;
        // запускаем суммирование степеней двойки
        for (int i = 1; i <= 10; i++) {
            sum1 += (int) Math.pow(2, i);
        }
        // цикл нахождения произведения последовательности
        for (int i = 1; i < 10; i++) {
            int presum = 0;
            // вычисление суммы всех элементов
            for (int j = 1; j <= i+1; j++) {
                presum += j;
            }
            // нахождение произведения
            sum2 *= presum;
        }
        System.out.printf("Первая последовательность: %d\nВторая последовательность: %d\n\n", sum1, sum2);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        // цикл пока не введем отрицательное число
        System.out.print("Введите числа: ");
        do {
            list.add(scan.nextInt());
        } while(list.getLast() > 0);
        // тк мы вышли из цикла значит последнее число отрицательное
        // по условию его следует удалить
        list.removeLast();
        // запускаем проверку
        for(int i = 0; i < list.size()-1; i++) {
            if(list.get(i) >= 3 || list.get(i) <= 13) {
                System.out.printf("Элемент %d принадлежит [3;13]\n",list.get(i));
            }
            else {
                System.out.printf("Элемент %d не принадлежит [3;13]\n",list.get(i));
            }
        }

    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}