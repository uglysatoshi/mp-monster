import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void Base() {
        baseP1();
        baseP2();
    }
    private static void baseP1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое время (часы, минуты, секунды):");
        int hours1 = scanner.nextInt();
        int minutes1 = scanner.nextInt();
        int seconds1 = scanner.nextInt();
        System.out.println("Введите второе время (часы, минуты, секунды):");
        int hours2 = scanner.nextInt();
        int minutes2 = scanner.nextInt();
        int seconds2 = scanner.nextInt();
        // Переводим время в секунды
        int time1InSeconds = hours1 * 3600 + minutes1 * 60 + seconds1;
        int time2InSeconds = hours2 * 3600 + minutes2 * 60 + seconds2;
        // Вычисляем разницу в секундах
        int differenceInSeconds = Math.abs(time2InSeconds - time1InSeconds);
        System.out.printf("Разница во времени составляет %d секунд.\n\n", differenceInSeconds);
    }
    private static void baseP2() {
        Scanner scanner = new Scanner(System.in);
        // Ввод информации о поезде
        System.out.println("Введите направление поезда (например, Одесса-Киев):");
        String direction = scanner.nextLine();
        System.out.println("Введите номер платформы:");
        int platformNumber = scanner.nextInt();
        System.out.println("Введите номер пути:");
        int trackNumber = scanner.nextInt();
        System.out.println("Введите количество минут до отправления:");
        int minutesToDeparture = scanner.nextInt();
        // Форматирование информации в бегущей строке
        System.out.printf("Поезд следованием %s отправляется от %d платформы %d пути через %d мин\n\n", direction, platformNumber, trackNumber, minutesToDeparture);
    }
    public static void Medium() {
        // Объявляем и вводим список
        LinkedList<Email> list = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            list.add(new Email());
        }
        // Количество прошедших дней с момента отправки каждого письма
        daysLeft(list);
        // Письма за 2023 год
        interval(list);
        mB(list);
        netDomain(list);
    }
    private static void daysLeft(LinkedList<Email> list) {
        System.out.print("Вывод количества дней прошедших после отправки: \n");
        for(Email e : list) {
            Period period = Period.between(LocalDateTime.now().toLocalDate(), e.date.toLocalDate());
            // Получите количество дней из Period
            System.out.printf("Количество прошедших дней от отправки письма с %s на %s: %d\n",e.addressOfSender, e.addressOfRecipient, period.getDays());
        }
    }
    private static void interval(LinkedList<Email> list) {
        // Задаем начальную и конечную дату интервала
        LocalDate startDate = LocalDate.of(2023, 1, 1); // Начальная дата
        LocalDate endDate = LocalDate.of(2023, 12, 31); // Конечная дата
        System.out.print("Письма отправленные за 2023 год: \n");
        // Проходим по списку и проверяем каждое письмо
        for(Email e : list) {
            if(isWithinInterval(e.date, startDate.atStartOfDay(), endDate.atTime(23, 59))) {
                e.show();
            }
        }
    }
    // Проверка находится ли дата в интервале
    private static boolean isWithinInterval(LocalDateTime dateTime, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return !dateTime.isBefore(startDateTime) && !dateTime.isAfter(endDateTime);
    }
    private static void mB(LinkedList<Email> list) {
        int sum = 0;
        for(Email e : list) {
            if(Period.between(LocalDateTime.now().toLocalDate(), e.date.toLocalDate()).getDays() < 31) {
                sum += e.size;
            }
        }
        System.out.printf("Количество Мбайт отправлено за последний месяц: %.2f",(double) sum / 1024 );
    }
    private static void netDomain(LinkedList<Email> list) {
        System.out.print("Письма отправленные с домена .net\n");
        for(Email e : list) {
            if(e.addressOfSender.endsWith(".net")) {
                e.show();
            }
        }
    }

    public static void main(String[] args) {
//        Base();
        Medium();
    }
}