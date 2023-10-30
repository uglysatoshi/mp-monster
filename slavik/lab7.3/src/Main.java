import java.util.*;

public class Main {
    public static void Base() {
        // Объявляем список
        LinkedList<Hockey> list = new LinkedList<>();
        // Добавляем в список 5 структур Hockey
        for(int i = 0; i < 5; i++) {
            list.add(new Hockey());
        }
        // Выводим средний возраст по списку
        System.out.printf("Средний возврат хоккеистов: %.2f\n\n", avgAge(list));
        // Выводим всех двадцати пяти летних хоккеистов
        show25(list);
    }
    public static void Medium() {
        // Объявляем список
        LinkedList<Car> list = new LinkedList<>();
        // Добавляем в список 5 элементов Car
        for(int i = 0; i < 5; i++) {
            list.add(new Car());
        }
        // Проходим по списку и выводим все машины с возрастом более 1 года и грузоподъемностью более 3х тонн
        System.out.print("Машины зарегистрированные более года назад и имеющие грузоподъемность более 3-х тонн: \n");
        for (Car car : list) {
            if (2023 - car.age > 1 && car.weightUp > 3) {
                car.show();
            }
        }
    }
    public static void Hard() {
        // Объявляем список
        ArrayList<Marshrut> marsh = new ArrayList<>();
        // Добавляем в список 5 элементов Marshrut
        for (int i = 0; i < 5; i++) {
            marsh.add(new Marshrut());
        }
        // Выводим максимальную длину маршрута
        System.out.printf("Максимальная длина маршрута: %d км\n", maxMarsh(marsh));
        // Выводим маршрут по названию
        printByName(marsh);
        // Сортируем список
        sortMarsh(marsh);
        // Выводим список после сортировки
        System.out.print("Отсортированный массив: \n");
        printMarsh(marsh);
    }
    // Функция нахождения среднего возраста хоккеистов
    private static double avgAge(LinkedList<Hockey> list) {
        double sum = 0;
        for (Hockey hockey : list) {
            sum += hockey.age;
        }
        return sum / list.size();
    }
    // Функция вывода хоккеистов старше 25
    private static void show25(LinkedList<Hockey> list) {
        System.out.print("Хоккеисты старше 25: \n");
        for(Hockey hockey : list) {
            if (hockey.age > 25) {
                hockey.show();
            }
        }
    }
    // Функция вывода максимальной длины маршрута
    private static int maxMarsh(ArrayList<Marshrut> marsh) {
        int max = Integer.MIN_VALUE;
        for (Marshrut marshrut : marsh) {
            if (marshrut.length > max) max = marshrut.length;
        }
        return max;
    }
    // Функция вывода списка маршрутов
    private static void printMarsh(ArrayList<Marshrut> marsh) {
        for (Marshrut marshrut : marsh) {
            marshrut.show();
        }
    }
    // Поиск по названию маршрута
    private static void printByName(ArrayList<Marshrut> marsh) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название маршрута: ");
        String name = scan.next();
        for (Marshrut marshrut : marsh) {
            if(marshrut.end.equals(name) || marshrut.start.equals(name)) marshrut.show();
        }
    }
    // Сортировка по номеру маршрута
    private static void sortMarsh(ArrayList<Marshrut> marsh) {
        marsh.sort(Comparator.comparingInt(marsh2 -> marsh2.number));
    }
    public static void main(String[] args) {
//        Base();
//        Medium();
        Hard();
    }
}