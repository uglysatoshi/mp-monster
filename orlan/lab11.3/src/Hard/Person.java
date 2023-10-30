package Hard;
// класс предок
public class Person {
    // поля класса
    String name;
    int age;
    // пул доступных имен
    final String[] namePool = {"Александр", "Андрей", "Анастасия", "Ирина", "Наталья", "Павел", "Роман", "Светлана", "Сергей", "Татьяна"};
    // конструктор
    public Person() {
        this.age = (int) (Math.random() * (40 - 20) + 20);
        int i = (int) (Math.random() * 10);
        name = namePool[i];
    }
    // функция приветствия
    public void Hello(Person person) {}
    // функция рассказа о себе
    public void About() {}
}
