import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Класс, представляющий информацию о профилактических работах на канале
    static class Maintenance {
        String channelName;
        LocalDate maintenanceDate;
        LocalTime startTime;
        LocalTime endTime;
        public Maintenance(String channelName, LocalDate maintenanceDate, LocalTime startTime, LocalTime endTime) {
            this.channelName = channelName;
            this.maintenanceDate = maintenanceDate;
            this.startTime = startTime;
            this.endTime = endTime;
        }
        public int getDurationMinutes() {
            return (int) (endTime.toSecondOfDay() - startTime.toSecondOfDay()) / 60;
        }
        public boolean isNightMaintenance() {
            LocalTime nightStart = LocalTime.of(22, 0);
            LocalTime nightEnd = LocalTime.of(6, 0);
            return startTime.isAfter(nightStart) || startTime.isBefore(nightEnd);
        }
    }
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // 1. Ввести дату и выполнить ее форматирование
        System.out.print("Введите дату(yyyy-mm-dd): ");
        String inputDate = scan.nextLine();

        LocalDate date = LocalDate.parse(inputDate);
        DateTimeFormatter numericDayFormatter = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter dayOfWeekFormatter = DateTimeFormatter.ofPattern("E");
        DateTimeFormatter zeroPaddedMonthFormatter = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter fullYearFormatter = DateTimeFormatter.ofPattern("yyyy");

        String numericDay = date.format(numericDayFormatter); // День в числовом виде
        String dayOfWeek = date.format(dayOfWeekFormatter); // День недели в виде аббревиатуры
        String zeroPaddedMonth = date.format(zeroPaddedMonthFormatter); // Месяц с начальными нулями
        String fullYear = date.format(fullYearFormatter); // Год в полном формате

        System.out.println("День в числовом виде: " + numericDay);
        System.out.println("День недели в виде аббревиатуры: " + dayOfWeek);
        System.out.println("Месяц с начальными нулями: " + zeroPaddedMonth);
        System.out.println("Год в полном формате: " + fullYear);

        // 2. Определить, на какой минуте от начала года произошло событие, и день недели
        int dayOfYear = date.get(ChronoField.DAY_OF_YEAR);
        int dayOfWeekNumber = date.get(ChronoField.DAY_OF_WEEK); // 1 - Понедельник, 7 - Воскресенье

        System.out.println("День года: " + dayOfYear);
        System.out.println("День недели (1-понедельник, 7-воскресенье): " + dayOfWeekNumber);
    }
    public static void MediumHard() {
        // Создаем список профилактических работ на каналах
        List<Maintenance> maintenanceList = new ArrayList<>();

        // Добавляем информацию о профилактических работах
        maintenanceList.add(new Maintenance("Канал 1", LocalDate.of(2023, 10, 29), LocalTime.of(1, 0), LocalTime.of(3, 0)));
        maintenanceList.add(new Maintenance("Канал 2", LocalDate.of(2023, 10, 30), LocalTime.of(2, 0), LocalTime.of(4, 0)));
        maintenanceList.add(new Maintenance("Канал 3", LocalDate.of(2023, 11, 5), LocalTime.of(23, 0), LocalTime.of(1, 0)));
        maintenanceList.add(new Maintenance("Канал 4", LocalDate.of(2023, 11, 15), LocalTime.of(5, 0), LocalTime.of(7, 0)));

        // 1. Вывести информацию по всем каналам с указанием длительности профилактических работ
        System.out.print("Выводим информацию по всем каналам с указанием длительности профилактических работ: \n");
        for (Maintenance maintenance : maintenanceList) {
            System.out.println("Канал: " + maintenance.channelName);
            System.out.println("Дата: " + maintenance.maintenanceDate);
            System.out.println("Время начала: " + maintenance.startTime);
            System.out.println("Время окончания: " + maintenance.endTime);
            System.out.println("Длительность (в минутах): " + maintenance.getDurationMinutes());
            System.out.println();
        }
        // 2. Вывести информацию о каналах с профилактикой в ночное время
        System.out.print("Выводим информацию о каналах с профилактикой в ночное время: \n");
        for (Maintenance maintenance : maintenanceList) {
            if (maintenance.isNightMaintenance()) {
                System.out.println("Канал: " + maintenance.channelName);
                System.out.println("Дата: " + maintenance.maintenanceDate);
                System.out.println("Время начала: " + maintenance.startTime);
                System.out.println("Время окончания: " + maintenance.endTime);
                System.out.println();
            }
        }
        // 3. Подсчитать количество профилактик, выполненных по понедельникам
        int mondayMaintenanceCount = 0;
        for (Maintenance maintenance : maintenanceList) {
            if (maintenance.maintenanceDate.getDayOfWeek() == DayOfWeek.MONDAY) {
                mondayMaintenanceCount++;
            }
        }
        System.out.println("Количество профилактик по понедельникам: " + mondayMaintenanceCount);
        // 4. Подготовить сведения о запланированных профилактиках на следующие три месяца
        prepareMaintenanceInfoForNextThreeMonths(maintenanceList);
    }
    private static void prepareMaintenanceInfoForNextThreeMonths(List<Maintenance> maintenanceList) {
        LocalDate currentDate = LocalDate.now();
        for (int i = 0; i < 3; i++) {
            LocalDate nextMonth = currentDate.plusMonths(i);
            List<Maintenance> maintenanceForNextMonth = getMaintenanceForMonth(maintenanceList, nextMonth);

            if (!maintenanceForNextMonth.isEmpty()) {
                String filename = "maintenance_info_" + nextMonth.getMonthValue() + ".txt";
                writeMaintenanceInfoToFile(filename, maintenanceForNextMonth);
                System.out.println("Сведения о профилактиках на " + nextMonth.getMonth() + " сохранены в файл " + filename);
            }
        }
    }
    private static List<Maintenance> getMaintenanceForMonth(List<Maintenance> maintenanceList, LocalDate month) {
        List<Maintenance> maintenanceForMonth = new ArrayList<>();
        for (Maintenance maintenance : maintenanceList) {
            if (maintenance.maintenanceDate.getMonth() == month.getMonth()) {
                maintenanceForMonth.add(maintenance);
            }
        }
        return maintenanceForMonth;
    }
    private static void writeMaintenanceInfoToFile(String filename, List<Maintenance> maintenanceList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Maintenance maintenance : maintenanceList) {
                writer.write("Канал: " + maintenance.channelName);
                writer.newLine();
                writer.write("Дата: " + maintenance.maintenanceDate);
                writer.newLine();
                writer.write("Время начала: " + maintenance.startTime);
                writer.newLine();
                writer.write("Время окончания: " + maintenance.endTime);
                writer.newLine();
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        Base();
        MediumHard();
    }
}