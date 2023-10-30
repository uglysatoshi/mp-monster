package Hard;

// класс наследник - формальная личность
public class Formal extends Person {
    public void Hello(Person person) {
        System.out.println(name + ": Здравствуй, " + person.name);
    }
    public void About() {
        System.out.println("Меня зовут " + name + ", мой возраст " + age + " лет, я формалист");
    }
}
