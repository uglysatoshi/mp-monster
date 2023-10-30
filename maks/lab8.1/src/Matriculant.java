public class Matriculant {
    // Поля класса
    String lastname;
    String firstname;
    String surname;
    String gender;
    String nationality;
    String birth;
    String address;
    double GPA;
    double passingScore;
    // Функция вывода
    void show() {
        System.out.printf("ФИО: %s %s %s\nПол: %s\nНациональность: %s\nДата рождения: %s\nАдрес проживания: %s\nСредний балл: %.2f\nПроходной балл: %.2f\n\n", lastname, firstname, surname, gender, nationality, birth, address, GPA, passingScore);
    }
}
