import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class EmployeeVisit {
    LocalDate date;                  // Дата посещения
    String fullName;                 // ФИО сотрудника
    String position;                 // Должность
    private LocalTime arrivalTime;   // Время прихода
    LocalTime departureTime;         // Время ухода

    public EmployeeVisit(LocalDate date, String fullName, String position, LocalTime arrivalTime, LocalTime departureTime) {
        this.date = date;
        this.fullName = fullName;
        this.position = position;
        this.setArrivalTime(arrivalTime);
        this.departureTime = departureTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public int getHoursWorked() {
        Duration duration = Duration.between(arrivalTime, departureTime);
        return (int) duration.toHours();
    }
}

class EmployeeAttendanceSystem {
    private List<EmployeeVisit> employeeVisits = new ArrayList<>(); // Хранение данных о посещениях сотрудников
    public void addEmployeeVisit(EmployeeVisit visit) {
        // Метод для добавления записи о посещении
        employeeVisits.add(visit);
    }
    public void printAllVisitsWithHoursWorked() {
        System.out.println("Сведения по всем записям:");
        for (EmployeeVisit visit : employeeVisits) {
            int hoursWorked = visit.getHoursWorked();
            // Вывод информации о каждом посещении
            System.out.println("Дата: " + visit.getDate() + ", Сотрудник: " + visit.getFullName() +
                    ", Должность: " + visit.getPosition() + ", Часы работы: " + hoursWorked);
        }
    }
    public void printEmployeesArrivingAfterTimeOnDate(LocalDate date, LocalTime time) {
        System.out.println("Сотрудники, пришедшие после " + time + " в день " + date + ":");
        for (EmployeeVisit visit : employeeVisits) {
            if (visit.getDate().equals(date) && visit.getArrivalTime().isAfter(time)) {
                // Вывод информации о сотрудниках, пришедших после указанного времени
                System.out.println("Сотрудник: " + visit.getFullName() +
                        ", Должность: " + visit.getPosition());
            }
        }
    }
    public int countEmployeesWorkingInTimeRangeOnDate(LocalDate date, LocalTime startTime, LocalTime endTime) {
        int count = 0;
        for (EmployeeVisit visit : employeeVisits) {
            if (visit.getDate().equals(date) &&
                    visit.getArrivalTime().isBefore(endTime) &&
                    visit.getDepartureTime().isAfter(startTime)) {
                // Подсчет количества сотрудников, находящихся на работе в указанный интервал времени
                count++;
            }
        }
        return count;
    }
    public EmployeeVisit findLastDepartureOnDate(LocalDate date) {
        EmployeeVisit lastDeparture = null;
        for (EmployeeVisit visit : employeeVisits) {
            if (visit.getDate().equals(date) && (lastDeparture == null || visit.getDepartureTime().isAfter(lastDeparture.getDepartureTime()))) {
                // Поиск сотрудника, ушедшего последним с работы
                lastDeparture = visit;
            }
        }
        return lastDeparture;
    }
    public void generateControlReportForMonth(int month, String outputFileName) {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        if (currentMonth == month) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))) {
                for (EmployeeVisit visit : employeeVisits) {
                    if (visit.getDate().getMonthValue() == month &&
                            visit.getArrivalTime().isAfter(LocalTime.of(8, 0)) &&
                            visit.getHoursWorked() < 8) {
                        // Генерация отчета о сотрудниках, пришедших позже 8:00 и отработавших менее 8 часов
                        writer.println("Дата: " + visit.getDate() + ", Сотрудник: " + visit.getFullName() +
                                ", Должность: " + visit.getPosition() + ", Часы работы: " + visit.getHoursWorked());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
