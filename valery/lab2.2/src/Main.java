import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите значение x: "); double x = in.nextDouble();
        System.out.print("Введите значение y: "); double y = in.nextDouble();
        if (x > 0 & y > 0) { // условие попадения в 1ю четверть
            System.out.println("Данные значения x и y попадают в первую четверть");
        }
        if (x < 0 & y > 0) { // условие попадения во 2ю четверть
            System.out.println("Данные значения x и y попадают во вторую четверть");
        }
        if (x < 0 & y < 0) { // условие попадения в 3ю четверть
            System.out.println("Данные значения x и y попадают в третью четверть");
        }
        if (x > 0 & y < 0) { // условие попадения в 4ю четверть
            System.out.println("Данные значения x и y попадают во вторую четверть");
        }
    }

    public static void Medium() {
        Scanner in = new Scanner(System.in);
        // меню с вопросом и ответами
        System.out.println("Сколько байт занимает тип double в ЯП Java?");
        System.out.println("A) 6 байт");
        System.out.println("B) 8 байт");
        System.out.println("С) 4 байта");
        System.out.print("Введите ответ: "); String answer = in.nextLine();
        if(Objects.equals(answer, "b")) { // условие проверки ответа на верность
            System.out.println("Ответ верный! :)");
        }
        else {
            System.out.println("Ответ не верный! :(");
        }

    }

    public static void Hard() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку из 6ти цифр: "); String str = in.nextLine();
        char[] number = str.toCharArray(); // перевод строки в массив символов
        int[] numbers = new int[number.length]; // создание массива размером в количество символов строки
        for (int i = 0; i < number.length; i++) {
            // переводим из сивольного типа в целочисленный и добавляем в массив
            numbers[i] = Integer.parseInt(String.valueOf(number[i]));
        }
        // если первые 3 числа равны последним 3м то число является счистливым
        if (numbers[0] + numbers[1] + numbers[2] == numbers[3] + numbers[4] + numbers[5]) {
            System.out.println("Ваше число является счастливым");
        }
        else {
            System.out.println("Ваше число не является счастливым");
        }
    }

    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}