import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    // функция нахождения зачения
    public static void find(NOTE2[] arr) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ФИ для поиска: "); String str = in.nextLine();
        // переменная для обозначения найдено ли значение
        boolean found = false;
        // поиск значения
        for (NOTE2 note2 : arr) {
            // если искомое равно нынешнему, выводим и обозначаем как найденное
            if (Objects.equals(note2.name, str)) {
                note2.show();
                found = true;
            }
        }
        // если ни одного значения не было найдено
        if (!found) {
            System.out.println("Не найдено ни одной записи с ФИ: " + str);
        }
    }
    // функция сортировки массива значений NOTE2
    public static void sort(NOTE2[] arr) {
        // переменная для обозначения массива как отсортированного
        boolean isSorted = false;
        // переменная для перестановки
        NOTE2 buffer;
        // пока не отсортирован продолжаем
        while(!isSorted) {

            isSorted = true;
            for(int i = 0; i < arr.length - 1; i++) {
                // если значение перовых 3 цифр номера больше
                if(arr[i].phoneNumber() > arr[i+1].phoneNumber()) {
                    isSorted = false;
                    buffer = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buffer;
                }
            }
        }
    }
    public static void Base() {
        LinkedList<Storage> list =  new LinkedList<>();
        // заносим значения в список
        for(int i = 0; i < 5; i++) {
            Storage storage = new Storage();
            list.add(storage);
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            // ищем максимальную суммарную цену
            if(list.get(i).multiply() > max) {
                max = list.get(i).multiply();
                index = i;
            }
        }
        System.out.println("Элемент с максимальным суммарной ценной:");
        // выводим максиальный элемент по индексу
        list.get(index).show();
    }
    public static void Medium() {
        // создаем и заполняем список
        LinkedList<Train> list =  new LinkedList<>();
        for(int i = 0; i < 1; i++) {
            Train train = new Train();
            list.add(train);
        }

        // выводим список
        for (Train train : list) {
            train.show();
        }
    }
    public static void Hard() {
        // выделяем память для 7 элементов NOTE2
        NOTE2[] arr = new NOTE2[7];
        // заполняем массив элементами NOTE2
        for (int i = 0; i < arr.length; i++) {
            NOTE2 tmp = new NOTE2();
            arr[i] = tmp;
        }
        // сортируем
        sort(arr);
        // выводим
        for (NOTE2 note2 : arr) {
            note2.show();
        }
        // ищем значения
        find(arr);
        find(arr);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();

    }
}