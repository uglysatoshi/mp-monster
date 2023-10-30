import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void Base() {
        // Объявляем стэк
        Stack<House> stack = new Stack<>();
        // Заполняем стэк
        for(int i = 0; i < 3; i++) {
            stack.push(new House());
        }
        // Проходим по стэку и ищем нужные элементы
        int cnt = 0;
        for (House house : stack) {
            if (Objects.equals(house.street, "Дерибасовская")) cnt++;
        }
        // Выводим результат поиска
        System.out.printf("Домов на улице Дерибасовская: %d\n\n", cnt);
    }
    public static void Medium() {
        LinkedList<String> queue = new LinkedList<>();
        Queue.enqueueS(queue, "one");
        Queue.enqueueS(queue, "two");
        Queue.enqueueS(queue, "three");
        Queue.enqueueS(queue, "four");
        Queue.enqueueS(queue, "five");
        Queue.enqueueS(queue, "six");
        Queue.enqueueS(queue, "seven");
        Queue.showS(queue);
        Queue.dequeueS(queue);
        Queue.enqueueS(queue, "eight");
        Queue.showS(queue);
        Queue.countS(queue);
    }
    public static void Hard() {
        // задаем массив из 10 чисел
        double[] arr = new double[]{7, 12, 53, 74, 5, 16, 73, 82, 97, 10};
        // задаем две очереди
        LinkedList<Double> queueFirst = new LinkedList<>();
        LinkedList<Double> queueSecond = new LinkedList<>();
        // вносим в очереди значения по четным и нечетным индексам
        for (int i = 0; i < 10; i++) {
            if(i % 2 == 0) {
                Queue.enqueue(queueSecond, arr[i]);
            }
            else {
                Queue.enqueue(queueFirst, arr[i]);
            }
        }
        Queue.show(queueFirst);
        Queue.show(queueSecond);
        Queue.getFirstLast(queueFirst);
        Queue.getFirstLast(queueSecond);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}