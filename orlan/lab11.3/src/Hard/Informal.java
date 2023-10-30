package Hard;

// класс наследник - неформальная личность
public class Informal extends Person{
    public void Hello(Person person) {
        System.out.println(name + ": Привет, " + person.name);
    }
    public void About() {
        System.out.println("Меня зовут " + name + ", мой возраст " + age + " лет, я неформал");
    }
}
