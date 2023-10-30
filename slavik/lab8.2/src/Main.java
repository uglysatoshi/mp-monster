import java.io.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public  class Main {
// Класс, представляющий информацию о турпоездке
    static class TourPackage {
        String name;
        double cost;
        int departureGroups;
        int groupSize;
        double totalCost;

        public TourPackage(String name, double cost, int departureGroups, int groupSize) {
            this.name = name;
            this.cost = cost;
            this.departureGroups = departureGroups;
            this.groupSize = groupSize;
            this.totalCost = cost * departureGroups * groupSize;
        }
    }

    // Класс Employee используется для хранения информации о сотруднике
    static class Employee {
        String lastName;
        String position;
        float salary;
        Date birthDate;

        public Employee(String lastName, String position, float salary, Date birthDate) {
            this.lastName = lastName;
            this.position = position;
            this.salary = salary;
            this.birthDate = birthDate;
        }
    }

    public static void Base() {
        // Создаем сотрудников
        Employee[] employees = new Employee[]{
                new Employee("Иванов", "Менеджер", 50000.0f, parseDate("1990-01-15")),
                new Employee("Петров", "Инженер", 60000.0f, parseDate("1985-08-22")),
                new Employee("Сидоров", "Программист", 75000.0f, parseDate("1995-03-10")),
                new Employee("Смирнова", "Дизайнер", 45000.0f, parseDate("1980-06-05"))
        };

        // Записываем сотрудников в бинарный файл
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("employees.bin"))) {
            for (Employee employee : employees) {
                writeEmployeeData(output, employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Читаем и фильтруем данные из бинарного файла
        try (DataInputStream input = new DataInputStream(new FileInputStream("employees.bin"))) {
            float totalSalary = 0;
            int totalEmployees = 0;
            Date today = new Date();

            System.out.println("Сотрудники с зарплатой выше средней и возрастом менее 30 лет:");
            while (input.available() > 0) {
                Employee employee = readEmployeeData(input);

                if (employee == null) {
                    break;
                }

                totalSalary += employee.salary;
                totalEmployees++;

                long ageInMillis = today.getTime() - employee.birthDate.getTime();
                int age = (int) (ageInMillis / (1000 * 60 * 60 * 24 * 365.25));

                if (employee.salary > (totalSalary / totalEmployees) && age < 30) {
                    System.out.println("Фамилия: " + employee.lastName + ", Должность: " + employee.position + ", Зарплата: " + employee.salary + ", Возраст: " + age + " лет");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("\n\n");
    }

    // Функция для записи информации о сотруднике в бинарный файл
    private static void writeEmployeeData(DataOutputStream output, Employee employee) throws IOException {
        output.writeUTF(employee.lastName);
        output.writeUTF(employee.position);
        output.writeFloat(employee.salary);
        output.writeUTF(new SimpleDateFormat("yyyy-MM-dd").format(employee.birthDate));
    }

    // Функция для чтения информации о сотруднике из бинарного файла
    private static Employee readEmployeeData(DataInputStream input) throws IOException {
        try {
            String lastName = input.readUTF();
            String position = input.readUTF();
            float salary = input.readFloat();
            Date birthDate = parseDate(input.readUTF());
            return new Employee(lastName, position, salary, birthDate);
        } catch (EOFException e) {
            return null;
        }
    }

    // Функция для разбора строки и преобразования ее в объект Date
    private static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void Medium() {
        int[][] originalArray = new int[][]
                {
                        {45, 78, 199, 98, 0},
                        {774, 771, 48, 82, 11},
                        {456, 2889, 9382, 19, 8},
                        {43, 92, 923, 4, 2},
                        {1829, 389, 38, 199, 33}
                };
        ArrayList<Integer> arrayList = new ArrayList<>();
        // Заполнение исходного массива и ArrayList
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arrayList.add(originalArray[i][j]);
            }
        }
        // Запись элементов ArrayList в бинарный файл по столбцам
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("array.bin"))) {
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 5; i++) {
                    output.writeInt(arrayList.get(i * 5 + j));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Печать исходного массива
        System.out.println("Исходный массив:");
        printArray(originalArray);
        // Увеличение значений столбцов в два раза
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                originalArray[i][j] *= 2;
            }
        }
        // Печать массива после изменения
        System.out.println("\nМассив после изменения:");
        printArray(originalArray);
        System.out.print("\n\n");
    }

    // Метод для печати двумерного массива
    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void Hard() {
        // Создаем список турпоездок и заполняем его данными
        List<TourPackage> tourPackages = new ArrayList<>();
        tourPackages.add(new TourPackage("Париж", 1000.0, 3, 5));
        tourPackages.add(new TourPackage("Лондон", 800.0, 2, 6));
        tourPackages.add(new TourPackage("Рим", 1200.0, 4, 8));
        tourPackages.add(new TourPackage("Барселона", 900.0, 3, 10));

        // Записываем данные о турпоездках в бинарный файл
        writeTourPackagesToFile("tour_packages.bin", tourPackages);
        System.out.print("Выводим список без обработки:\n");
        printTourPackages(tourPackages);
        // Модифицируем данные в бинарном файле и записываем их в другой файл
        modifyTourPackages("tour_packages.bin", "updated_tour_packages.bin");

        System.out.print("Выводим список после обработки:\n");
        // Считываем и выводим обновленные данные из файла
        List<TourPackage> updatedPackages = readTourPackagesFromFile("updated_tour_packages.bin");
        printTourPackages(updatedPackages);
    }
    // Метод для записи информации о турпоездках в бинарный файл
    private static void writeTourPackagesToFile(String filename, List<TourPackage> packages) {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(filename))) {
            for (TourPackage pack : packages) {
                output.writeUTF(pack.name);
                output.writeDouble(pack.cost);
                output.writeInt(pack.departureGroups);
                output.writeInt(pack.groupSize);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Метод для чтения и изменения информации о турпоездках из бинарного файла
    private static void modifyTourPackages(String inputFilename, String outputFilename) {
        try (DataInputStream input = new DataInputStream(new FileInputStream(inputFilename));
             DataOutputStream output = new DataOutputStream(new FileOutputStream(outputFilename))) {
            while (input.available() > 0) {
                String name = input.readUTF();
                double cost = input.readDouble();
                int departureGroups = input.readInt();
                int groupSize = input.readInt();
                // Если группа состоит из 10 человек, снижаем стоимость на 5%
                if (groupSize == 10) {
                    cost *= 0.95;
                }
                // Пересчитываем общую стоимость
                double totalCost = cost * departureGroups * groupSize;
                // Записываем обновленные данные в выходной файл
                output.writeUTF(name);
                output.writeDouble(cost);
                output.writeInt(departureGroups);
                output.writeInt(groupSize);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Метод для чтения информации о турпоездках из бинарного файла
    private static List<TourPackage> readTourPackagesFromFile(String filename) {
        List<TourPackage> packages = new ArrayList<>();
        try (DataInputStream input = new DataInputStream(new FileInputStream(filename))) {
            while (input.available() > 0) {
                // Считываем данные о турпоездке из файла
                String name = input.readUTF();
                double cost = input.readDouble();
                int departureGroups = input.readInt();
                int groupSize = input.readInt();
                // Создаем объект TourPackage и добавляем его в список
                packages.add(new TourPackage(name, cost, departureGroups, groupSize));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return packages;
    }
    // Метод для вывода информации о турпоездках в консоль
    private static void printTourPackages(List<TourPackage> packages) {
        for (TourPackage pack : packages) {
            System.out.println("Название: " + pack.name);
            System.out.println("Стоимость: " + pack.cost);
            System.out.println("Количество групп: " + pack.departureGroups);
            System.out.println("Количество в группе: " + pack.groupSize);
            System.out.println("Общая стоимость: " + pack.totalCost);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}