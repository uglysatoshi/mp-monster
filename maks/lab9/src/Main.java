import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // 1 пункт
        System.out.print("Введите дату в формате(ЧЧ:ММ:СС): ");
        // Вводим строку и проверяем является ли она датой
        if(isLocalTime(scan.next())) { System.out.print("Является датой\n");
        } else {System.out.print("Не является датой\n");}
        // 2 пункт
        System.out.print("Введите длительность работы посудомоечной машины (в минутах): ");
        int washingDurationMinutes = scan.nextInt();
        System.out.print("Введите время отсрочки начала запуска программы (в часах): ");
        int delayHours = scan.nextInt();
        // Получаем текущее время и дату
        LocalDateTime now = LocalDateTime.now();
        // Добавляем отсрочку в часах
        var startTime = now.plusHours(delayHours);
        // Определяем дату и время окончания
        LocalDateTime endTime = startTime.plusMinutes(washingDurationMinutes);
        System.out.println("Дата и время начала мойки: " + startTime);
        System.out.println("Дата и время окончания мойки: " + endTime);
        // Рассчитываем оставшееся время до начала и до окончания
        Duration timeUntilStart = Duration.between(now, startTime);
        Duration timeUntilEnd = Duration.between(now, endTime);
        System.out.println("Время до начала мойки: " + timeUntilStart.toHours() + " часов и " +
                (timeUntilStart.toMinutesPart()) + " минут");
        System.out.println("Время до окончания мойки: " + timeUntilEnd.toHours() + " часов и " +
                (timeUntilEnd.toMinutesPart()) + " минут");
    }
    // Функция для проверки является ли введенная строка типа время(LocalTime)
    private static boolean isLocalTime(String input) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime.parse(input, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    public static void MediumHard() {
        EmployeeAttendanceSystem attendanceSystem = new EmployeeAttendanceSystem();
        attendanceSystem.addEmployeeVisit(new EmployeeVisit(LocalDate.of(2023, 10, 1), "Иванов Иван Иванович", "Менеджер", LocalTime.of(8, 0), LocalTime.of(16, 30)));
        attendanceSystem.addEmployeeVisit(new EmployeeVisit(LocalDate.of(2023, 10, 1), "Петров Петр Петрович", "Программист", LocalTime.of(9, 30), LocalTime.of(17, 0)));
        attendanceSystem.addEmployeeVisit(new EmployeeVisit(LocalDate.of(2023, 10, 1), "Сидоров Сидор Сидорович", "Дизайнер", LocalTime.of(13, 0), LocalTime.of(18, 0)));
        attendanceSystem.addEmployeeVisit(new EmployeeVisit(LocalDate.of(2023, 10, 3), "Смирнова Елена Петровна", "Бухгалтер", LocalTime.of(7, 45), LocalTime.of(16, 15)));
        attendanceSystem.printAllVisitsWithHoursWorked();
        attendanceSystem.printEmployeesArrivingAfterTimeOnDate(LocalDate.of(2023, 10, 1), LocalTime.of(12, 0));
        int count = attendanceSystem.countEmployeesWorkingInTimeRangeOnDate(LocalDate.of(2023, 10, 1), LocalTime.of(9, 0), LocalTime.of(17, 0));
        System.out.println("Количество сотрудников, находящихся на работе 2023-10-01: " + count);
        EmployeeVisit lastDeparture = attendanceSystem.findLastDepartureOnDate(LocalDate.of(2023, 10, 1));
        System.out.println("Сотрудник, ушедший последним: " + lastDeparture.getFullName());
        attendanceSystem.generateControlReportForMonth(10, "control_report.txt");
    }

    public static void main(String[] args) {
        Base();
        MediumHard();
    }
}