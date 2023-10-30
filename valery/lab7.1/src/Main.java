import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void Base() {
        Scanner in = new Scanner(System.in);
        char[][] arr = new char[2][6];
        // вводим значения масиива
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.next().charAt(0);
            }
        }
        // подсчитываем количество необходимых элементов
        int counter = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if(arr[i][j] == '+' || arr[i][j] == '-' || arr[i][j] == '*') {
                    counter++;
                }
            }
        }
        System.out.println("Знаки '*', '+', '-' встречаются в строке: " + counter + " раз");
    }
    public static void Medium() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        // Заменяем все пробелы строки на запятую и пробел
        str = str.replace(" ", ", ");
        System.out.println(str);
    }
    public static void Hard() {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = input.nextLine();
        // вызываем функцию для обработки строки
        String simplifiedStr = simplifyExpression(str);
        System.out.print("Упрощенная строка: ");
        System.out.println(simplifiedStr);
    }
    private static String simplifyExpression(String expr) {
        // шаблон для обработки
        String pattern = "(\\w+)\\s*=\\s*(\\w+)\\s*\\+\\s*1";
        // передаем шаблон
        Pattern regex = Pattern.compile(pattern);
        // узнаем соответствует ли шаблон передаенному выражению
        Matcher matcher = regex.matcher(expr);

        // Если переданное выражение соответсвует шаблону
        // то выполняем обработку, иначе возвращаем исходное выражение
        if (matcher.find()) {
            // передаем в varName значение найденной переменной
            String varName = matcher.group(1);
            // добавляем к переменной "++"
            String newValue = varName + "++";
            // меняем в строке нынешнее значение на отредактированную переменную
            return expr.replace(matcher.group(), newValue);
        } else {
            return expr;
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}