import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static class Shop {
        // поля класса
        String prodName;
        String prodPurveyor;
        LocalDate prodManufactured;
        int prodExpiration;
        String prodPrice;
        // конструктр класса
        public Shop() {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите наименование продукта: "); this.prodName = in.next();
            System.out.print("Введите изготовителя продукта: "); this.prodPurveyor = in.next();
            this.prodManufactured = getData();
            System.out.print("Введите срок годности: "); this.prodExpiration = in.nextInt();
            System.out.print("Введите цену: ");this.prodPrice = in.next();
            System.out.println();
        }
        // функция вывода в консоль
        void show() {
            System.out.println("Наименование продукта: " + prodName);
            System.out.println("Поставщик продукта: " + prodPurveyor);
            System.out.println("Дата произведения: " + prodManufactured);
            System.out.println("Срок годности: " + prodExpiration);
            System.out.println("Цена: " + prodPrice);
            System.out.println();
        }
    }
    // функция проверяющая является ли строка конвертируемой в время
    private static void DataChecker() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите дату(dd/mm/yyyy): "); String str = in.nextLine();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            // переводим в формат времени
            dateFormat.parse(str);
            // если прошло успешно вывоим
            System.out.println("Является датой");
        } catch (ParseException e) {
            // если прошло не успешно выводим
            System.out.println("Не является датой");
        }
    }
    // функция нахождения количества записей во временном промежутке
    private static void medProcedures() {
        Scanner in = new Scanner(System.in);
        // выделяем шаблон для ввода времени
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        // заполняем строки по шаблону
        System.out.print("Введите время начала приема(чч:мм): ");
        String startTimeStr = in.nextLine();
        System.out.print("Введите время конца приема(чч:мм):");
        String lastTimeStr = in.nextLine();
        System.out.print("Введите количество процедур в это время:");
        int numProcedures = in.nextInt();
        try {
            // переводим строку во временной формат
            Date startTime = dateFormat.parse(startTimeStr);
            Date nextTime = dateFormat.parse(lastTimeStr);
            // выводим интервал
            long interval = (nextTime.getTime() - startTime.getTime()) / numProcedures;
            // выводим время умноженное на интервал
            System.out.println("Список времени процедур:");
            for (int i = 0; i < numProcedures; i++) {
                Date procedureTime = new Date(startTime.getTime() + i * interval);
                System.out.println(dateFormat.format(procedureTime));
            }

        } catch (Exception e) {
            System.out.println("Ошибка ввода времени");
        }
    }
    private static void createShopList(LinkedList<Shop> list) {
        Scanner in = new Scanner(System.in);
        // заполняем список элементами Shop
        System.out.print("Введите количество элементов: "); int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            // вызываем конструктор
            Shop shop = new Shop();
            // заносим элемент в список
            list.add(shop);
        }
    }
    // функция получения даты
    public static @NotNull LocalDate getData() {
        Scanner in = new Scanner(System.in);
        // ставим шаблон формата даты
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Введите дату(dd/MM/yyyy): ");
        String str = in.next();
        // возвращаем отформатированный вариант
        return LocalDate.parse(str, formatter);
    }
    // поиск просроченных продуктов
    private static void shopExpired(LinkedList<Shop> list) {
        LocalDate date = getData();
        boolean found = false;
        System.out.println("Испортившиеся продукты: ");
        // идем по списку
        for (Shop shop : list) {
            // находим время между введенной датой и старой
            int daysGone = (int) ChronoUnit.DAYS.between(shop.prodManufactured, date);
            // если количество дней между датами больше, чем срок годности
            if(daysGone > shop.prodExpiration) {
                // выводим
                shop.show();
                // ставим как найденное
                found = true;
            }
        }
        // если не одной записи не найдено
        if(!found) {
            System.out.println("Не найдено ни одной записи");
        }
    }
    // поиск продуктор просрочащихся ровно чере 2 дня
    private static void shopExpired2Days(LinkedList<Shop> list) {
        LocalDate date = getData();
        int counter = 0;
        // идем по списку
        for (Shop shop : list) {
            // находим время между введенной датой и старой
            int daysGone = (int) ChronoUnit.DAYS.between(shop.prodManufactured, date);
            // если продукт не просрочен на данный момент
            if (!(daysGone >= shop.prodExpiration)) {
                // если продукт просрочится через 2
                if(daysGone + 2 == shop.prodExpiration) {
                    // добавляем к счетсику единицу
                    counter ++;
                }
            }
        }
        System.out.println("Продуктов подлежащих списанию через 2 дня: " + counter);
    }
    // поиск по месяцу
    private static void findByMonth(LinkedList<Shop> list) {
        Scanner in = new Scanner(System.in);
        // вводим месяц
        System.out.print("Введите месяц для поиска: " ); int month = in.nextInt();
        for (Shop shop : list) {
            // если значение месяца равно введеному месяцу
            if (shop.prodManufactured.getMonthValue() == month) {
                // выводим
                shop.show();
            }
        }
    }
    // поиск самого свежего продукта
    private static void findLatest(LinkedList<Shop> list) {
        Scanner in = new Scanner(System.in);
        LocalDate date = getData();
        System.out.print("Введите наименование продукта: "); String name = in.next();
        int min = Integer.MAX_VALUE;
        int minInd = 0;
        // идем по списку
        for (int i = 0; i < list.size(); i++) {
            // находим время между введенной датой и старой
            int daysGone = (int) ChronoUnit.DAYS.between(list.get(i).prodManufactured, date);
            // если количество дней меньше нынешнего, и наименование равно вееденому
            if(daysGone < min && Objects.equals(list.get(i).prodName, name)) {
                // записываем индекс
                minInd = i;
                // записываем количество дней
                min = daysGone;
            }
        }
        System.out.println("Самый смежий продукт с данного наименования: ");
        // выводим по индексу
        list.get(minInd).show();
    }
    // запись в файл просроченных продуктов
    private static void shopExpiredAddToFile(LinkedList<Shop> list) {
        try(FileWriter fi = new FileWriter("prodExpired.txt")) {
            LocalDate date = getData();
            // идем по списку
            for (Shop shop : list) {
                // находим время между введенной датой и старой
                int daysGone = (int) ChronoUnit.DAYS.between(shop.prodManufactured, date);
                // если просрочился
                if(daysGone > shop.prodExpiration) {
                    // записываем каждое поле в файл
                    fi.write(shop.prodName + "\n");
                    fi.write(shop.prodPurveyor + "\n");
                    fi.write(shop.prodManufactured.toString() + "\n");
                    fi.write(shop.prodExpiration + "\n");
                    fi.write(shop.prodPrice + "\n");
                    fi.write( "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void Base() {
        DataChecker();
        medProcedures();
    }
    public static void MediumHard() {
        LinkedList<Shop> list = new LinkedList<>();
        createShopList(list);
        shopExpired(list);
        findByMonth(list);
        shopExpired2Days(list);
        findLatest(list);
        shopExpiredAddToFile(list);
    }

    public static void main(String[] args) {
        Base();
        MediumHard();
    }
}